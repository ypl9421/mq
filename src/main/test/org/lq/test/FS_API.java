package org.lq.test;

import com.lark.oapi.okhttp.MediaType;
import com.lark.oapi.okhttp.OkHttpClient;
import com.lark.oapi.okhttp.Request;
import com.lark.oapi.okhttp.Response;

import java.io.IOException;

/**
 * @author 无语
 * @create 2022-11-18 14:02
 */
public class FS_API {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("");
        Request request = new Request.Builder()
                .url("https://open.feishu.cn/open-apis/bitable/v1/apps/bascn7LR8OmgipwDqWyu3Mu3jtf/tables/tblDojNsFWBjCYC7/records?filter=CurrentValue.%5B%E5%AD%A6%E7%94%9F%E5%A7%93%E5%90%8D%5D+%3D+%22郎旭%22&page_size=20&view_id=vewXrZFoyG")
                .method("GET", null)
                .addHeader("Authorization", "Bearer t-g104bidN4XT7SD5NT2GZGBMVLLHY3DPVT7UUQLOZ")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response.body().string() = " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json = "response.body().string() = {\"code\":0,\"data\":{\"has_more\":false,\"items\":[{\"fields\":{\"入营年级\":\"2023届\",\"合同名称\":[\"optUjghXdP\",\"optKhezDLN\"],\"备注\":\"物联网工程的，Java自学了三个月，面试过两家没有offer，可以马上出来实习。\",\"学员状态\":[{\"record_ids\":[\"recfV2LAJ1\"],\"table_id\":\"tbl5BQG7oHGT689F\",\"text\":\"CEP\",\"type\":\"text\"}],\"学校\":[{\"record_ids\":[\"rec89pjCIA\"],\"table_id\":\"tbl69hW9woL8WQtL\",\"text\":\"天津科技大学\",\"type\":\"text\"}],\"学生姓名\":\"郎旭\",\"实收金额\":null,\"就业方向\":\"Java开发\",\"性别\":\"男\",\"技术指导老师\":[{\"record_ids\":[\"recqnKKtQa\"],\"table_id\":\"tblnleTsn5tf7HPs\",\"text\":\"谢勇\",\"type\":\"text\"}],\"是否结算\":0,\"求职意向单\":[{\"text\":\"√\",\"type\":\"text\"}],\"渠道经理\":[{\"record_ids\":[\"recDVgNHZz\"],\"table_id\":\"tblnleTsn5tf7HPs\",\"text\":\"孟祥凯\",\"type\":\"text\"}],\"班主任\":\"张梦含\",\"签署协议日期\":1668528000000,\"联系标记\":true},\"id\":\"recDsPWLiJ\",\"record_id\":\"recDsPWLiJ\"}],\"page_token\":\"recDsPWLiJ\",\"total\":1},\"msg\":\"success\"}";

    }
}
