package project.common;

public class CardNo extends Action {
    @Override
    public Response execute(Request request) {
        String cardNo = (String) request.get("cardNo");
        for (Member m : members) {
            if(m.getMemberNo().equals(cardNo)){
                return new Response(true,"会员卡号正确！");
            }
        }
        return new Response(false,"会员卡号错误！\n请重新输入：");
    }
}
