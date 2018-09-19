package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TokenController {

    @GetMapping("/greeting")
    public ModelAndView greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("name", name);
        return new ModelAndView("greeting-view");
    }

    @GetMapping("/paypage")
    public ModelAndView paypage(){
        return new ModelAndView("hosted-paypage");
    }

    @GetMapping("/tokenisation")
    public ModelAndView tokenisation(){
        return new ModelAndView("hosted-tokenisation");
    }

    @GetMapping("/tokenise")
    @ResponseBody
    public String tokenise(@RequestParam(name = "datakey", required = true) String dataKey){
        String issuerId = CardVerificationClass.cardVerify(dataKey);
        NewTokenisationService.tokenise(dataKey, issuerId);
        return "OK tokenised"+dataKey+"|||"+issuerId;
    }

    @GetMapping("preauth")
    @ResponseBody
    public String preAuth(@RequestParam(name = "datakey") String datakey,
                          @RequestParam(name = "issue") String issuerId){
        PreAuthService.preAuth(datakey,issuerId);
        return "OK"+datakey;
    }

    @GetMapping("/complete")
    @ResponseBody
    public String complete(@RequestParam(name = "txn") String txn,
                           @RequestParam(name="amount", required=false, defaultValue="1.00") String amount,
                           @RequestParam(name="order_id", required=false, defaultValue="Test1436981327037") String order_id
    ){
        CompletionService.complete(txn,
                amount,
                order_id
        );

        return "OK"+txn;
    }

//    @GetMapping("/refund")
//    @ResponseBody
//    public String get

    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    @GetMapping("/refund")
    @ResponseBody
    public String completionRefund(String datakey,
                                   @RequestParam(name = "txn") String txn,
                           @RequestParam(name="amount") String amount,
                           @RequestParam(name="order_id", required=false, defaultValue="Test1436981327037") String order_id
    ){
        RefundService.newCompletionRefund(datakey,
                txn,
                order_id,
                amount
        );

        return "OK"+txn;
    }

    @GetMapping("/indrefund")
    @ResponseBody
    public String indRefund(String datakey){
        RefundService.indRefund(datakey);
        return "OK";
    }



}