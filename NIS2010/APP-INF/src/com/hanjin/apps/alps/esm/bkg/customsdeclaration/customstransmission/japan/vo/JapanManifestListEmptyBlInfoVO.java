/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanManifestListEmptyBlInfoVO.java
*@FileTitle : JapanManifestListEmptyBlInfoVO
*Open Issues :
*Change history :
*	2017.09.07 하대성 corCd, corReason, delCd, delReason, opVvdCd Culumn Add
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2009.06.01  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class JapanManifestListEmptyBlInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<JapanManifestListEmptyBlInfoVO> models = new ArrayList<JapanManifestListEmptyBlInfoVO>();

    /* Column Info */
    private String data19 = null;

    /* Column Info */
    private String data17 = null;

    /* Column Info */
    private String data18 = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String data12 = null;

    /* Column Info */
    private String data11 = null;

    /* Column Info */
    private String data10 = null;

    /* Column Info */
    private String data51 = null;

    /* Column Info */
    private String data16 = null;

    /* Column Info */
    private String data52 = null;

    /* Column Info */
    private String data15 = null;

    /* Column Info */
    private String data14 = null;

    /* Column Info */
    private String data50 = null;

    /* Column Info */
    private String data13 = null;

    /* Column Info */
    private String data55 = null;

    /* Column Info */
    private String data56 = null;

    /* Column Info */
    private String data53 = null;

    /* Column Info */
    private String data54 = null;

    /* Column Info */
    private String data59 = null;

    /* Column Info */
    private String data57 = null;

    /* Column Info */
    private String data58 = null;

    /* Column Info */
    private String data70 = null;

    /* Column Info */
    private String data72 = null;

    /* Column Info */
    private String data71 = null;

    /* Column Info */
    private String data1 = null;

    /* Column Info */
    private String data74 = null;

    /* Column Info */
    private String data73 = null;

    /* Column Info */
    private String data76 = null;

    /* Column Info */
    private String data4 = null;

    /* Column Info */
    private String data28 = null;

    /* Column Info */
    private String data75 = null;

    /* Column Info */
    private String data5 = null;

    /* Column Info */
    private String data29 = null;

    /* Column Info */
    private String data78 = null;

    /* Column Info */
    private String data2 = null;

    /* Column Info */
    private String data77 = null;

    /* Column Info */
    private String data3 = null;

    /* Column Info */
    private String data8 = null;

    /* Column Info */
    private String data79 = null;

    /* Column Info */
    private String data9 = null;

    /* Column Info */
    private String data6 = null;

    /* Column Info */
    private String data7 = null;

    /* Column Info */
    private String data21 = null;

    /* Column Info */
    private String data20 = null;

    /* Column Info */
    private String data23 = null;

    /* Column Info */
    private String data22 = null;

    /* Column Info */
    private String data60 = null;

    /* Column Info */
    private String data25 = null;

    /* Column Info */
    private String data61 = null;

    /* Column Info */
    private String data24 = null;

    /* Column Info */
    private String data62 = null;

    /* Column Info */
    private String data27 = null;

    /* Column Info */
    private String data63 = null;

    /* Column Info */
    private String data26 = null;

    /* Column Info */
    private String data64 = null;

    /* Column Info */
    private String inVvdCd = null;

    /* Column Info */
    private String data65 = null;

    /* Column Info */
    private String data66 = null;

    /* Column Info */
    private String data67 = null;

    /* Column Info */
    private String data68 = null;

    /* Column Info */
    private String data69 = null;

    /* Column Info */
    private String cyOprCd = null;

    /* Column Info */
    private String inCallSgnNo = null;

    /* Column Info */
    private String data39 = null;

    /* Column Info */
    private String data30 = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String data37 = null;

    /* Column Info */
    private String data38 = null;

    /* Column Info */
    private String data35 = null;

    /* Column Info */
    private String data36 = null;

    /* Column Info */
    private String data33 = null;

    /* Column Info */
    private String data34 = null;

    /* Column Info */
    private String data31 = null;

    /* Column Info */
    private String data32 = null;

    /* Column Info */
    private String data40 = null;

    /* Column Info */
    private String data41 = null;

    /* Column Info */
    private String data46 = null;

    /* Column Info */
    private String data47 = null;

    /* Column Info */
    private String data48 = null;

    /* Column Info */
    private String data49 = null;

    /* Column Info */
    private String data42 = null;

    /* Column Info */
    private String data43 = null;

    /* Column Info */
    private String data44 = null;

    /* Column Info */
    private String data45 = null;

    /* Column Info */
    private String corCd = null;

    /* Column Info */
    private String corReason = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String delReason = null;

    /* Column Info */
    private String opVvdCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public JapanManifestListEmptyBlInfoVO() {
    }

    public JapanManifestListEmptyBlInfoVO(String ibflag, String pagerows, String inCallSgnNo, String inVvdCd, String data1, String cyOprCd, String data2, String data3, String data4, String data5, String data6, String data7, String data8, String data9, String data10, String data11, String data12, String data13, String data14, String data15, String data16, String data17, String data18, String data19, String data20, String data21, String data22, String data23, String data24, String data25, String data26, String data27, String data28, String data29, String data30, String data31, String data32, String data33, String data34, String data35, String data36, String data37, String data38, String data39, String data40, String data41, String data42, String data43, String data44, String data45, String data46, String data47, String data48, String data49, String data50, String data51, String data52, String data53, String data54, String data55, String data56, String data57, String data58, String data59, String data60, String data61, String data62, String data63, String data64, String data65, String data66, String data67, String data68, String data69, String data70, String data71, String data72, String data73, String data74, String data75, String data76, String data77, String data78, String data79, String corCd, String corReason, String delCd, String delReason, String opVvdCd) {
        this.data19 = data19;
        this.data17 = data17;
        this.data18 = data18;
        this.pagerows = pagerows;
        this.data12 = data12;
        this.data11 = data11;
        this.data10 = data10;
        this.data51 = data51;
        this.data16 = data16;
        this.data52 = data52;
        this.data15 = data15;
        this.data14 = data14;
        this.data50 = data50;
        this.data13 = data13;
        this.data55 = data55;
        this.data56 = data56;
        this.data53 = data53;
        this.data54 = data54;
        this.data59 = data59;
        this.data57 = data57;
        this.data58 = data58;
        this.data70 = data70;
        this.data72 = data72;
        this.data71 = data71;
        this.data1 = data1;
        this.data74 = data74;
        this.data73 = data73;
        this.data76 = data76;
        this.data4 = data4;
        this.data28 = data28;
        this.data75 = data75;
        this.data5 = data5;
        this.data29 = data29;
        this.data78 = data78;
        this.data2 = data2;
        this.data77 = data77;
        this.data3 = data3;
        this.data8 = data8;
        this.data79 = data79;
        this.data9 = data9;
        this.data6 = data6;
        this.data7 = data7;
        this.data21 = data21;
        this.data20 = data20;
        this.data23 = data23;
        this.data22 = data22;
        this.data60 = data60;
        this.data25 = data25;
        this.data61 = data61;
        this.data24 = data24;
        this.data62 = data62;
        this.data27 = data27;
        this.data63 = data63;
        this.data26 = data26;
        this.data64 = data64;
        this.inVvdCd = inVvdCd;
        this.data65 = data65;
        this.data66 = data66;
        this.data67 = data67;
        this.data68 = data68;
        this.data69 = data69;
        this.cyOprCd = cyOprCd;
        this.inCallSgnNo = inCallSgnNo;
        this.data39 = data39;
        this.data30 = data30;
        this.ibflag = ibflag;
        this.data37 = data37;
        this.data38 = data38;
        this.data35 = data35;
        this.data36 = data36;
        this.data33 = data33;
        this.data34 = data34;
        this.data31 = data31;
        this.data32 = data32;
        this.data40 = data40;
        this.data41 = data41;
        this.data46 = data46;
        this.data47 = data47;
        this.data48 = data48;
        this.data49 = data49;
        this.data42 = data42;
        this.data43 = data43;
        this.data44 = data44;
        this.data45 = data45;
        this.corCd = corCd;
        this.corReason = corReason;
        this.delCd = delCd;
        this.delReason = delReason;
        this.opVvdCd = opVvdCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("data19", getData19());
        this.hashColumns.put("data17", getData17());
        this.hashColumns.put("data18", getData18());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("data12", getData12());
        this.hashColumns.put("data11", getData11());
        this.hashColumns.put("data10", getData10());
        this.hashColumns.put("data51", getData51());
        this.hashColumns.put("data16", getData16());
        this.hashColumns.put("data52", getData52());
        this.hashColumns.put("data15", getData15());
        this.hashColumns.put("data14", getData14());
        this.hashColumns.put("data50", getData50());
        this.hashColumns.put("data13", getData13());
        this.hashColumns.put("data55", getData55());
        this.hashColumns.put("data56", getData56());
        this.hashColumns.put("data53", getData53());
        this.hashColumns.put("data54", getData54());
        this.hashColumns.put("data59", getData59());
        this.hashColumns.put("data57", getData57());
        this.hashColumns.put("data58", getData58());
        this.hashColumns.put("data70", getData70());
        this.hashColumns.put("data72", getData72());
        this.hashColumns.put("data71", getData71());
        this.hashColumns.put("data1", getData1());
        this.hashColumns.put("data74", getData74());
        this.hashColumns.put("data73", getData73());
        this.hashColumns.put("data76", getData76());
        this.hashColumns.put("data4", getData4());
        this.hashColumns.put("data28", getData28());
        this.hashColumns.put("data75", getData75());
        this.hashColumns.put("data5", getData5());
        this.hashColumns.put("data29", getData29());
        this.hashColumns.put("data78", getData78());
        this.hashColumns.put("data2", getData2());
        this.hashColumns.put("data77", getData77());
        this.hashColumns.put("data3", getData3());
        this.hashColumns.put("data8", getData8());
        this.hashColumns.put("data79", getData79());
        this.hashColumns.put("data9", getData9());
        this.hashColumns.put("data6", getData6());
        this.hashColumns.put("data7", getData7());
        this.hashColumns.put("data21", getData21());
        this.hashColumns.put("data20", getData20());
        this.hashColumns.put("data23", getData23());
        this.hashColumns.put("data22", getData22());
        this.hashColumns.put("data60", getData60());
        this.hashColumns.put("data25", getData25());
        this.hashColumns.put("data61", getData61());
        this.hashColumns.put("data24", getData24());
        this.hashColumns.put("data62", getData62());
        this.hashColumns.put("data27", getData27());
        this.hashColumns.put("data63", getData63());
        this.hashColumns.put("data26", getData26());
        this.hashColumns.put("data64", getData64());
        this.hashColumns.put("in_vvd_cd", getInVvdCd());
        this.hashColumns.put("data65", getData65());
        this.hashColumns.put("data66", getData66());
        this.hashColumns.put("data67", getData67());
        this.hashColumns.put("data68", getData68());
        this.hashColumns.put("data69", getData69());
        this.hashColumns.put("cy_opr_cd", getCyOprCd());
        this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
        this.hashColumns.put("data39", getData39());
        this.hashColumns.put("data30", getData30());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("data37", getData37());
        this.hashColumns.put("data38", getData38());
        this.hashColumns.put("data35", getData35());
        this.hashColumns.put("data36", getData36());
        this.hashColumns.put("data33", getData33());
        this.hashColumns.put("data34", getData34());
        this.hashColumns.put("data31", getData31());
        this.hashColumns.put("data32", getData32());
        this.hashColumns.put("data40", getData40());
        this.hashColumns.put("data41", getData41());
        this.hashColumns.put("data46", getData46());
        this.hashColumns.put("data47", getData47());
        this.hashColumns.put("data48", getData48());
        this.hashColumns.put("data49", getData49());
        this.hashColumns.put("data42", getData42());
        this.hashColumns.put("data43", getData43());
        this.hashColumns.put("data44", getData44());
        this.hashColumns.put("data45", getData45());
        this.hashColumns.put("cor_cd", getCorCd());
        this.hashColumns.put("cor_reason", getCorReason());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("del_reason", getDelReason());
        this.hashColumns.put("op_vvd_cd", getOpVvdCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("data19", "data19");
        this.hashFields.put("data17", "data17");
        this.hashFields.put("data18", "data18");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("data12", "data12");
        this.hashFields.put("data11", "data11");
        this.hashFields.put("data10", "data10");
        this.hashFields.put("data51", "data51");
        this.hashFields.put("data16", "data16");
        this.hashFields.put("data52", "data52");
        this.hashFields.put("data15", "data15");
        this.hashFields.put("data14", "data14");
        this.hashFields.put("data50", "data50");
        this.hashFields.put("data13", "data13");
        this.hashFields.put("data55", "data55");
        this.hashFields.put("data56", "data56");
        this.hashFields.put("data53", "data53");
        this.hashFields.put("data54", "data54");
        this.hashFields.put("data59", "data59");
        this.hashFields.put("data57", "data57");
        this.hashFields.put("data58", "data58");
        this.hashFields.put("data70", "data70");
        this.hashFields.put("data72", "data72");
        this.hashFields.put("data71", "data71");
        this.hashFields.put("data1", "data1");
        this.hashFields.put("data74", "data74");
        this.hashFields.put("data73", "data73");
        this.hashFields.put("data76", "data76");
        this.hashFields.put("data4", "data4");
        this.hashFields.put("data28", "data28");
        this.hashFields.put("data75", "data75");
        this.hashFields.put("data5", "data5");
        this.hashFields.put("data29", "data29");
        this.hashFields.put("data78", "data78");
        this.hashFields.put("data2", "data2");
        this.hashFields.put("data77", "data77");
        this.hashFields.put("data3", "data3");
        this.hashFields.put("data8", "data8");
        this.hashFields.put("data79", "data79");
        this.hashFields.put("data9", "data9");
        this.hashFields.put("data6", "data6");
        this.hashFields.put("data7", "data7");
        this.hashFields.put("data21", "data21");
        this.hashFields.put("data20", "data20");
        this.hashFields.put("data23", "data23");
        this.hashFields.put("data22", "data22");
        this.hashFields.put("data60", "data60");
        this.hashFields.put("data25", "data25");
        this.hashFields.put("data61", "data61");
        this.hashFields.put("data24", "data24");
        this.hashFields.put("data62", "data62");
        this.hashFields.put("data27", "data27");
        this.hashFields.put("data63", "data63");
        this.hashFields.put("data26", "data26");
        this.hashFields.put("data64", "data64");
        this.hashFields.put("in_vvd_cd", "inVvdCd");
        this.hashFields.put("data65", "data65");
        this.hashFields.put("data66", "data66");
        this.hashFields.put("data67", "data67");
        this.hashFields.put("data68", "data68");
        this.hashFields.put("data69", "data69");
        this.hashFields.put("cy_opr_cd", "cyOprCd");
        this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
        this.hashFields.put("data39", "data39");
        this.hashFields.put("data30", "data30");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("data37", "data37");
        this.hashFields.put("data38", "data38");
        this.hashFields.put("data35", "data35");
        this.hashFields.put("data36", "data36");
        this.hashFields.put("data33", "data33");
        this.hashFields.put("data34", "data34");
        this.hashFields.put("data31", "data31");
        this.hashFields.put("data32", "data32");
        this.hashFields.put("data40", "data40");
        this.hashFields.put("data41", "data41");
        this.hashFields.put("data46", "data46");
        this.hashFields.put("data47", "data47");
        this.hashFields.put("data48", "data48");
        this.hashFields.put("data49", "data49");
        this.hashFields.put("data42", "data42");
        this.hashFields.put("data43", "data43");
        this.hashFields.put("data44", "data44");
        this.hashFields.put("data45", "data45");
        this.hashFields.put("cor_cd", "corCd");
        this.hashFields.put("cor_reason", "corReason");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("del_reason", "delReason");
        this.hashFields.put("op_vvd_cd", "opVvdCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return data19
	 */
    public String getData19() {
        return this.data19;
    }

    /**
	 * Column Info
	 * @return data17
	 */
    public String getData17() {
        return this.data17;
    }

    /**
	 * Column Info
	 * @return data18
	 */
    public String getData18() {
        return this.data18;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Column Info
	 * @return data12
	 */
    public String getData12() {
        return this.data12;
    }

    /**
	 * Column Info
	 * @return data11
	 */
    public String getData11() {
        return this.data11;
    }

    /**
	 * Column Info
	 * @return data10
	 */
    public String getData10() {
        return this.data10;
    }

    /**
	 * Column Info
	 * @return data51
	 */
    public String getData51() {
        return this.data51;
    }

    /**
	 * Column Info
	 * @return data16
	 */
    public String getData16() {
        return this.data16;
    }

    /**
	 * Column Info
	 * @return data52
	 */
    public String getData52() {
        return this.data52;
    }

    /**
	 * Column Info
	 * @return data15
	 */
    public String getData15() {
        return this.data15;
    }

    /**
	 * Column Info
	 * @return data14
	 */
    public String getData14() {
        return this.data14;
    }

    /**
	 * Column Info
	 * @return data50
	 */
    public String getData50() {
        return this.data50;
    }

    /**
	 * Column Info
	 * @return data13
	 */
    public String getData13() {
        return this.data13;
    }

    /**
	 * Column Info
	 * @return data55
	 */
    public String getData55() {
        return this.data55;
    }

    /**
	 * Column Info
	 * @return data56
	 */
    public String getData56() {
        return this.data56;
    }

    /**
	 * Column Info
	 * @return data53
	 */
    public String getData53() {
        return this.data53;
    }

    /**
	 * Column Info
	 * @return data54
	 */
    public String getData54() {
        return this.data54;
    }

    /**
	 * Column Info
	 * @return data59
	 */
    public String getData59() {
        return this.data59;
    }

    /**
	 * Column Info
	 * @return data57
	 */
    public String getData57() {
        return this.data57;
    }

    /**
	 * Column Info
	 * @return data58
	 */
    public String getData58() {
        return this.data58;
    }

    /**
	 * Column Info
	 * @return data70
	 */
    public String getData70() {
        return this.data70;
    }

    /**
	 * Column Info
	 * @return data72
	 */
    public String getData72() {
        return this.data72;
    }

    /**
	 * Column Info
	 * @return data71
	 */
    public String getData71() {
        return this.data71;
    }

    /**
	 * Column Info
	 * @return data1
	 */
    public String getData1() {
        return this.data1;
    }

    /**
	 * Column Info
	 * @return data74
	 */
    public String getData74() {
        return this.data74;
    }

    /**
	 * Column Info
	 * @return data73
	 */
    public String getData73() {
        return this.data73;
    }

    /**
	 * Column Info
	 * @return data76
	 */
    public String getData76() {
        return this.data76;
    }

    /**
	 * Column Info
	 * @return data4
	 */
    public String getData4() {
        return this.data4;
    }

    /**
	 * Column Info
	 * @return data28
	 */
    public String getData28() {
        return this.data28;
    }

    /**
	 * Column Info
	 * @return data75
	 */
    public String getData75() {
        return this.data75;
    }

    /**
	 * Column Info
	 * @return data5
	 */
    public String getData5() {
        return this.data5;
    }

    /**
	 * Column Info
	 * @return data29
	 */
    public String getData29() {
        return this.data29;
    }

    /**
	 * Column Info
	 * @return data78
	 */
    public String getData78() {
        return this.data78;
    }

    /**
	 * Column Info
	 * @return data2
	 */
    public String getData2() {
        return this.data2;
    }

    /**
	 * Column Info
	 * @return data77
	 */
    public String getData77() {
        return this.data77;
    }

    /**
	 * Column Info
	 * @return data3
	 */
    public String getData3() {
        return this.data3;
    }

    /**
	 * Column Info
	 * @return data8
	 */
    public String getData8() {
        return this.data8;
    }

    /**
	 * Column Info
	 * @return data79
	 */
    public String getData79() {
        return this.data79;
    }

    /**
	 * Column Info
	 * @return data9
	 */
    public String getData9() {
        return this.data9;
    }

    /**
	 * Column Info
	 * @return data6
	 */
    public String getData6() {
        return this.data6;
    }

    /**
	 * Column Info
	 * @return data7
	 */
    public String getData7() {
        return this.data7;
    }

    /**
	 * Column Info
	 * @return data21
	 */
    public String getData21() {
        return this.data21;
    }

    /**
	 * Column Info
	 * @return data20
	 */
    public String getData20() {
        return this.data20;
    }

    /**
	 * Column Info
	 * @return data23
	 */
    public String getData23() {
        return this.data23;
    }

    /**
	 * Column Info
	 * @return data22
	 */
    public String getData22() {
        return this.data22;
    }

    /**
	 * Column Info
	 * @return data60
	 */
    public String getData60() {
        return this.data60;
    }

    /**
	 * Column Info
	 * @return data25
	 */
    public String getData25() {
        return this.data25;
    }

    /**
	 * Column Info
	 * @return data61
	 */
    public String getData61() {
        return this.data61;
    }

    /**
	 * Column Info
	 * @return data24
	 */
    public String getData24() {
        return this.data24;
    }

    /**
	 * Column Info
	 * @return data62
	 */
    public String getData62() {
        return this.data62;
    }

    /**
	 * Column Info
	 * @return data27
	 */
    public String getData27() {
        return this.data27;
    }

    /**
	 * Column Info
	 * @return data63
	 */
    public String getData63() {
        return this.data63;
    }

    /**
	 * Column Info
	 * @return data26
	 */
    public String getData26() {
        return this.data26;
    }

    /**
	 * Column Info
	 * @return data64
	 */
    public String getData64() {
        return this.data64;
    }

    /**
	 * Column Info
	 * @return inVvdCd
	 */
    public String getInVvdCd() {
        return this.inVvdCd;
    }

    /**
	 * Column Info
	 * @return data65
	 */
    public String getData65() {
        return this.data65;
    }

    /**
	 * Column Info
	 * @return data66
	 */
    public String getData66() {
        return this.data66;
    }

    /**
	 * Column Info
	 * @return data67
	 */
    public String getData67() {
        return this.data67;
    }

    /**
	 * Column Info
	 * @return data68
	 */
    public String getData68() {
        return this.data68;
    }

    /**
	 * Column Info
	 * @return data69
	 */
    public String getData69() {
        return this.data69;
    }

    /**
	 * Column Info
	 * @return cyOprCd
	 */
    public String getCyOprCd() {
        return this.cyOprCd;
    }

    /**
	 * Column Info
	 * @return inCallSgnNo
	 */
    public String getInCallSgnNo() {
        return this.inCallSgnNo;
    }

    /**
	 * Column Info
	 * @return data39
	 */
    public String getData39() {
        return this.data39;
    }

    /**
	 * Column Info
	 * @return data30
	 */
    public String getData30() {
        return this.data30;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return data37
	 */
    public String getData37() {
        return this.data37;
    }

    /**
	 * Column Info
	 * @return data38
	 */
    public String getData38() {
        return this.data38;
    }

    /**
	 * Column Info
	 * @return data35
	 */
    public String getData35() {
        return this.data35;
    }

    /**
	 * Column Info
	 * @return data36
	 */
    public String getData36() {
        return this.data36;
    }

    /**
	 * Column Info
	 * @return data33
	 */
    public String getData33() {
        return this.data33;
    }

    /**
	 * Column Info
	 * @return data34
	 */
    public String getData34() {
        return this.data34;
    }

    /**
	 * Column Info
	 * @return data31
	 */
    public String getData31() {
        return this.data31;
    }

    /**
	 * Column Info
	 * @return data32
	 */
    public String getData32() {
        return this.data32;
    }

    /**
	 * Column Info
	 * @return data40
	 */
    public String getData40() {
        return this.data40;
    }

    /**
	 * Column Info
	 * @return data41
	 */
    public String getData41() {
        return this.data41;
    }

    /**
	 * Column Info
	 * @return data46
	 */
    public String getData46() {
        return this.data46;
    }

    /**
	 * Column Info
	 * @return data47
	 */
    public String getData47() {
        return this.data47;
    }

    /**
	 * Column Info
	 * @return data48
	 */
    public String getData48() {
        return this.data48;
    }

    /**
	 * Column Info
	 * @return data49
	 */
    public String getData49() {
        return this.data49;
    }

    /**
	 * Column Info
	 * @return data42
	 */
    public String getData42() {
        return this.data42;
    }

    /**
	 * Column Info
	 * @return data43
	 */
    public String getData43() {
        return this.data43;
    }

    /**
	 * Column Info
	 * @return data44
	 */
    public String getData44() {
        return this.data44;
    }

    /**
	 * Column Info
	 * @return data45
	 */
    public String getData45() {
        return this.data45;
    }

    /**
	 * Column Info
	 * @param data19
	 */
    public void setData19(String data19) {
        this.data19 = data19;
    }

    /**
	 * Column Info
	 * @param data17
	 */
    public void setData17(String data17) {
        this.data17 = data17;
    }

    /**
	 * Column Info
	 * @param data18
	 */
    public void setData18(String data18) {
        this.data18 = data18;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param data12
	 */
    public void setData12(String data12) {
        this.data12 = data12;
    }

    /**
	 * Column Info
	 * @param data11
	 */
    public void setData11(String data11) {
        this.data11 = data11;
    }

    /**
	 * Column Info
	 * @param data10
	 */
    public void setData10(String data10) {
        this.data10 = data10;
    }

    /**
	 * Column Info
	 * @param data51
	 */
    public void setData51(String data51) {
        this.data51 = data51;
    }

    /**
	 * Column Info
	 * @param data16
	 */
    public void setData16(String data16) {
        this.data16 = data16;
    }

    /**
	 * Column Info
	 * @param data52
	 */
    public void setData52(String data52) {
        this.data52 = data52;
    }

    /**
	 * Column Info
	 * @param data15
	 */
    public void setData15(String data15) {
        this.data15 = data15;
    }

    /**
	 * Column Info
	 * @param data14
	 */
    public void setData14(String data14) {
        this.data14 = data14;
    }

    /**
	 * Column Info
	 * @param data50
	 */
    public void setData50(String data50) {
        this.data50 = data50;
    }

    /**
	 * Column Info
	 * @param data13
	 */
    public void setData13(String data13) {
        this.data13 = data13;
    }

    /**
	 * Column Info
	 * @param data55
	 */
    public void setData55(String data55) {
        this.data55 = data55;
    }

    /**
	 * Column Info
	 * @param data56
	 */
    public void setData56(String data56) {
        this.data56 = data56;
    }

    /**
	 * Column Info
	 * @param data53
	 */
    public void setData53(String data53) {
        this.data53 = data53;
    }

    /**
	 * Column Info
	 * @param data54
	 */
    public void setData54(String data54) {
        this.data54 = data54;
    }

    /**
	 * Column Info
	 * @param data59
	 */
    public void setData59(String data59) {
        this.data59 = data59;
    }

    /**
	 * Column Info
	 * @param data57
	 */
    public void setData57(String data57) {
        this.data57 = data57;
    }

    /**
	 * Column Info
	 * @param data58
	 */
    public void setData58(String data58) {
        this.data58 = data58;
    }

    /**
	 * Column Info
	 * @param data70
	 */
    public void setData70(String data70) {
        this.data70 = data70;
    }

    /**
	 * Column Info
	 * @param data72
	 */
    public void setData72(String data72) {
        this.data72 = data72;
    }

    /**
	 * Column Info
	 * @param data71
	 */
    public void setData71(String data71) {
        this.data71 = data71;
    }

    /**
	 * Column Info
	 * @param data1
	 */
    public void setData1(String data1) {
        this.data1 = data1;
    }

    /**
	 * Column Info
	 * @param data74
	 */
    public void setData74(String data74) {
        this.data74 = data74;
    }

    /**
	 * Column Info
	 * @param data73
	 */
    public void setData73(String data73) {
        this.data73 = data73;
    }

    /**
	 * Column Info
	 * @param data76
	 */
    public void setData76(String data76) {
        this.data76 = data76;
    }

    /**
	 * Column Info
	 * @param data4
	 */
    public void setData4(String data4) {
        this.data4 = data4;
    }

    /**
	 * Column Info
	 * @param data28
	 */
    public void setData28(String data28) {
        this.data28 = data28;
    }

    /**
	 * Column Info
	 * @param data75
	 */
    public void setData75(String data75) {
        this.data75 = data75;
    }

    /**
	 * Column Info
	 * @param data5
	 */
    public void setData5(String data5) {
        this.data5 = data5;
    }

    /**
	 * Column Info
	 * @param data29
	 */
    public void setData29(String data29) {
        this.data29 = data29;
    }

    /**
	 * Column Info
	 * @param data78
	 */
    public void setData78(String data78) {
        this.data78 = data78;
    }

    /**
	 * Column Info
	 * @param data2
	 */
    public void setData2(String data2) {
        this.data2 = data2;
    }

    /**
	 * Column Info
	 * @param data77
	 */
    public void setData77(String data77) {
        this.data77 = data77;
    }

    /**
	 * Column Info
	 * @param data3
	 */
    public void setData3(String data3) {
        this.data3 = data3;
    }

    /**
	 * Column Info
	 * @param data8
	 */
    public void setData8(String data8) {
        this.data8 = data8;
    }

    /**
	 * Column Info
	 * @param data79
	 */
    public void setData79(String data79) {
        this.data79 = data79;
    }

    /**
	 * Column Info
	 * @param data9
	 */
    public void setData9(String data9) {
        this.data9 = data9;
    }

    /**
	 * Column Info
	 * @param data6
	 */
    public void setData6(String data6) {
        this.data6 = data6;
    }

    /**
	 * Column Info
	 * @param data7
	 */
    public void setData7(String data7) {
        this.data7 = data7;
    }

    /**
	 * Column Info
	 * @param data21
	 */
    public void setData21(String data21) {
        this.data21 = data21;
    }

    /**
	 * Column Info
	 * @param data20
	 */
    public void setData20(String data20) {
        this.data20 = data20;
    }

    /**
	 * Column Info
	 * @param data23
	 */
    public void setData23(String data23) {
        this.data23 = data23;
    }

    /**
	 * Column Info
	 * @param data22
	 */
    public void setData22(String data22) {
        this.data22 = data22;
    }

    /**
	 * Column Info
	 * @param data60
	 */
    public void setData60(String data60) {
        this.data60 = data60;
    }

    /**
	 * Column Info
	 * @param data25
	 */
    public void setData25(String data25) {
        this.data25 = data25;
    }

    /**
	 * Column Info
	 * @param data61
	 */
    public void setData61(String data61) {
        this.data61 = data61;
    }

    /**
	 * Column Info
	 * @param data24
	 */
    public void setData24(String data24) {
        this.data24 = data24;
    }

    /**
	 * Column Info
	 * @param data62
	 */
    public void setData62(String data62) {
        this.data62 = data62;
    }

    /**
	 * Column Info
	 * @param data27
	 */
    public void setData27(String data27) {
        this.data27 = data27;
    }

    /**
	 * Column Info
	 * @param data63
	 */
    public void setData63(String data63) {
        this.data63 = data63;
    }

    /**
	 * Column Info
	 * @param data26
	 */
    public void setData26(String data26) {
        this.data26 = data26;
    }

    /**
	 * Column Info
	 * @param data64
	 */
    public void setData64(String data64) {
        this.data64 = data64;
    }

    /**
	 * Column Info
	 * @param inVvdCd
	 */
    public void setInVvdCd(String inVvdCd) {
        this.inVvdCd = inVvdCd;
    }

    /**
	 * Column Info
	 * @param data65
	 */
    public void setData65(String data65) {
        this.data65 = data65;
    }

    /**
	 * Column Info
	 * @param data66
	 */
    public void setData66(String data66) {
        this.data66 = data66;
    }

    /**
	 * Column Info
	 * @param data67
	 */
    public void setData67(String data67) {
        this.data67 = data67;
    }

    /**
	 * Column Info
	 * @param data68
	 */
    public void setData68(String data68) {
        this.data68 = data68;
    }

    /**
	 * Column Info
	 * @param data69
	 */
    public void setData69(String data69) {
        this.data69 = data69;
    }

    /**
	 * Column Info
	 * @param cyOprCd
	 */
    public void setCyOprCd(String cyOprCd) {
        this.cyOprCd = cyOprCd;
    }

    /**
	 * Column Info
	 * @param inCallSgnNo
	 */
    public void setInCallSgnNo(String inCallSgnNo) {
        this.inCallSgnNo = inCallSgnNo;
    }

    /**
	 * Column Info
	 * @param data39
	 */
    public void setData39(String data39) {
        this.data39 = data39;
    }

    /**
	 * Column Info
	 * @param data30
	 */
    public void setData30(String data30) {
        this.data30 = data30;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param data37
	 */
    public void setData37(String data37) {
        this.data37 = data37;
    }

    /**
	 * Column Info
	 * @param data38
	 */
    public void setData38(String data38) {
        this.data38 = data38;
    }

    /**
	 * Column Info
	 * @param data35
	 */
    public void setData35(String data35) {
        this.data35 = data35;
    }

    /**
	 * Column Info
	 * @param data36
	 */
    public void setData36(String data36) {
        this.data36 = data36;
    }

    /**
	 * Column Info
	 * @param data33
	 */
    public void setData33(String data33) {
        this.data33 = data33;
    }

    /**
	 * Column Info
	 * @param data34
	 */
    public void setData34(String data34) {
        this.data34 = data34;
    }

    /**
	 * Column Info
	 * @param data31
	 */
    public void setData31(String data31) {
        this.data31 = data31;
    }

    /**
	 * Column Info
	 * @param data32
	 */
    public void setData32(String data32) {
        this.data32 = data32;
    }

    /**
	 * Column Info
	 * @param data40
	 */
    public void setData40(String data40) {
        this.data40 = data40;
    }

    /**
	 * Column Info
	 * @param data41
	 */
    public void setData41(String data41) {
        this.data41 = data41;
    }

    /**
	 * Column Info
	 * @param data46
	 */
    public void setData46(String data46) {
        this.data46 = data46;
    }

    /**
	 * Column Info
	 * @param data47
	 */
    public void setData47(String data47) {
        this.data47 = data47;
    }

    /**
	 * Column Info
	 * @param data48
	 */
    public void setData48(String data48) {
        this.data48 = data48;
    }

    /**
	 * Column Info
	 * @param data49
	 */
    public void setData49(String data49) {
        this.data49 = data49;
    }

    /**
	 * Column Info
	 * @param data42
	 */
    public void setData42(String data42) {
        this.data42 = data42;
    }

    /**
	 * Column Info
	 * @param data43
	 */
    public void setData43(String data43) {
        this.data43 = data43;
    }

    /**
	 * Column Info
	 * @param data44
	 */
    public void setData44(String data44) {
        this.data44 = data44;
    }

    /**
	 * Column Info
	 * @param data45
	 */
    public void setData45(String data45) {
        this.data45 = data45;
    }

    public void setCorCd(String corCd) {
        this.corCd = corCd;
    }

    public String getCorCd() {
        return this.corCd;
    }

    public void setCorReason(String corReason) {
        this.corReason = corReason;
    }

    public String getCorReason() {
        return this.corReason;
    }

    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    public String getDelCd() {
        return this.delCd;
    }

    public void setDelReason(String delReason) {
        this.delReason = delReason;
    }

    public String getDelReason() {
        return this.delReason;
    }

    public void setOpVvdCd(String opVvdCd) {
        this.opVvdCd = opVvdCd;
    }

    public String getOpVvdCd() {
        return this.opVvdCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setData19(JSPUtil.getParameter(request, prefix + "data19", ""));
        setData17(JSPUtil.getParameter(request, prefix + "data17", ""));
        setData18(JSPUtil.getParameter(request, prefix + "data18", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setData12(JSPUtil.getParameter(request, prefix + "data12", ""));
        setData11(JSPUtil.getParameter(request, prefix + "data11", ""));
        setData10(JSPUtil.getParameter(request, prefix + "data10", ""));
        setData51(JSPUtil.getParameter(request, prefix + "data51", ""));
        setData16(JSPUtil.getParameter(request, prefix + "data16", ""));
        setData52(JSPUtil.getParameter(request, prefix + "data52", ""));
        setData15(JSPUtil.getParameter(request, prefix + "data15", ""));
        setData14(JSPUtil.getParameter(request, prefix + "data14", ""));
        setData50(JSPUtil.getParameter(request, prefix + "data50", ""));
        setData13(JSPUtil.getParameter(request, prefix + "data13", ""));
        setData55(JSPUtil.getParameter(request, prefix + "data55", ""));
        setData56(JSPUtil.getParameter(request, prefix + "data56", ""));
        setData53(JSPUtil.getParameter(request, prefix + "data53", ""));
        setData54(JSPUtil.getParameter(request, prefix + "data54", ""));
        setData59(JSPUtil.getParameter(request, prefix + "data59", ""));
        setData57(JSPUtil.getParameter(request, prefix + "data57", ""));
        setData58(JSPUtil.getParameter(request, prefix + "data58", ""));
        setData70(JSPUtil.getParameter(request, prefix + "data70", ""));
        setData72(JSPUtil.getParameter(request, prefix + "data72", ""));
        setData71(JSPUtil.getParameter(request, prefix + "data71", ""));
        setData1(JSPUtil.getParameter(request, prefix + "data1", ""));
        setData74(JSPUtil.getParameter(request, prefix + "data74", ""));
        setData73(JSPUtil.getParameter(request, prefix + "data73", ""));
        setData76(JSPUtil.getParameter(request, prefix + "data76", ""));
        setData4(JSPUtil.getParameter(request, prefix + "data4", ""));
        setData28(JSPUtil.getParameter(request, prefix + "data28", ""));
        setData75(JSPUtil.getParameter(request, prefix + "data75", ""));
        setData5(JSPUtil.getParameter(request, prefix + "data5", ""));
        setData29(JSPUtil.getParameter(request, prefix + "data29", ""));
        setData78(JSPUtil.getParameter(request, prefix + "data78", ""));
        setData2(JSPUtil.getParameter(request, prefix + "data2", ""));
        setData77(JSPUtil.getParameter(request, prefix + "data77", ""));
        setData3(JSPUtil.getParameter(request, prefix + "data3", ""));
        setData8(JSPUtil.getParameter(request, prefix + "data8", ""));
        setData79(JSPUtil.getParameter(request, prefix + "data79", ""));
        setData9(JSPUtil.getParameter(request, prefix + "data9", ""));
        setData6(JSPUtil.getParameter(request, prefix + "data6", ""));
        setData7(JSPUtil.getParameter(request, prefix + "data7", ""));
        setData21(JSPUtil.getParameter(request, prefix + "data21", ""));
        setData20(JSPUtil.getParameter(request, prefix + "data20", ""));
        setData23(JSPUtil.getParameter(request, prefix + "data23", ""));
        setData22(JSPUtil.getParameter(request, prefix + "data22", ""));
        setData60(JSPUtil.getParameter(request, prefix + "data60", ""));
        setData25(JSPUtil.getParameter(request, prefix + "data25", ""));
        setData61(JSPUtil.getParameter(request, prefix + "data61", ""));
        setData24(JSPUtil.getParameter(request, prefix + "data24", ""));
        setData62(JSPUtil.getParameter(request, prefix + "data62", ""));
        setData27(JSPUtil.getParameter(request, prefix + "data27", ""));
        setData63(JSPUtil.getParameter(request, prefix + "data63", ""));
        setData26(JSPUtil.getParameter(request, prefix + "data26", ""));
        setData64(JSPUtil.getParameter(request, prefix + "data64", ""));
        setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
        setData65(JSPUtil.getParameter(request, prefix + "data65", ""));
        setData66(JSPUtil.getParameter(request, prefix + "data66", ""));
        setData67(JSPUtil.getParameter(request, prefix + "data67", ""));
        setData68(JSPUtil.getParameter(request, prefix + "data68", ""));
        setData69(JSPUtil.getParameter(request, prefix + "data69", ""));
        setCyOprCd(JSPUtil.getParameter(request, prefix + "cy_opr_cd", ""));
        setInCallSgnNo(JSPUtil.getParameter(request, prefix + "in_call_sgn_no", ""));
        setData39(JSPUtil.getParameter(request, prefix + "data39", ""));
        setData30(JSPUtil.getParameter(request, prefix + "data30", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setData37(JSPUtil.getParameter(request, prefix + "data37", ""));
        setData38(JSPUtil.getParameter(request, prefix + "data38", ""));
        setData35(JSPUtil.getParameter(request, prefix + "data35", ""));
        setData36(JSPUtil.getParameter(request, prefix + "data36", ""));
        setData33(JSPUtil.getParameter(request, prefix + "data33", ""));
        setData34(JSPUtil.getParameter(request, prefix + "data34", ""));
        setData31(JSPUtil.getParameter(request, prefix + "data31", ""));
        setData32(JSPUtil.getParameter(request, prefix + "data32", ""));
        setData40(JSPUtil.getParameter(request, prefix + "data40", ""));
        setData41(JSPUtil.getParameter(request, prefix + "data41", ""));
        setData46(JSPUtil.getParameter(request, prefix + "data46", ""));
        setData47(JSPUtil.getParameter(request, prefix + "data47", ""));
        setData48(JSPUtil.getParameter(request, prefix + "data48", ""));
        setData49(JSPUtil.getParameter(request, prefix + "data49", ""));
        setData42(JSPUtil.getParameter(request, prefix + "data42", ""));
        setData43(JSPUtil.getParameter(request, prefix + "data43", ""));
        setData44(JSPUtil.getParameter(request, prefix + "data44", ""));
        setData45(JSPUtil.getParameter(request, prefix + "data45", ""));
        setCorCd(JSPUtil.getParameter(request, prefix + "cor_cd", ""));
        setCorReason(JSPUtil.getParameter(request, prefix + "cor_reason", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setDelReason(JSPUtil.getParameter(request, prefix + "del_reason", ""));
        setOpVvdCd(JSPUtil.getParameter(request, prefix + "op_vvd_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListEmptyBlInfoVO[]
	 */
    public JapanManifestListEmptyBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListEmptyBlInfoVO[]
	 */
    public JapanManifestListEmptyBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        JapanManifestListEmptyBlInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] data19 = (JSPUtil.getParameter(request, prefix + "data19".trim(), length));
            String[] data17 = (JSPUtil.getParameter(request, prefix + "data17".trim(), length));
            String[] data18 = (JSPUtil.getParameter(request, prefix + "data18".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] data12 = (JSPUtil.getParameter(request, prefix + "data12".trim(), length));
            String[] data11 = (JSPUtil.getParameter(request, prefix + "data11".trim(), length));
            String[] data10 = (JSPUtil.getParameter(request, prefix + "data10".trim(), length));
            String[] data51 = (JSPUtil.getParameter(request, prefix + "data51".trim(), length));
            String[] data16 = (JSPUtil.getParameter(request, prefix + "data16".trim(), length));
            String[] data52 = (JSPUtil.getParameter(request, prefix + "data52".trim(), length));
            String[] data15 = (JSPUtil.getParameter(request, prefix + "data15".trim(), length));
            String[] data14 = (JSPUtil.getParameter(request, prefix + "data14".trim(), length));
            String[] data50 = (JSPUtil.getParameter(request, prefix + "data50".trim(), length));
            String[] data13 = (JSPUtil.getParameter(request, prefix + "data13".trim(), length));
            String[] data55 = (JSPUtil.getParameter(request, prefix + "data55".trim(), length));
            String[] data56 = (JSPUtil.getParameter(request, prefix + "data56".trim(), length));
            String[] data53 = (JSPUtil.getParameter(request, prefix + "data53".trim(), length));
            String[] data54 = (JSPUtil.getParameter(request, prefix + "data54".trim(), length));
            String[] data59 = (JSPUtil.getParameter(request, prefix + "data59".trim(), length));
            String[] data57 = (JSPUtil.getParameter(request, prefix + "data57".trim(), length));
            String[] data58 = (JSPUtil.getParameter(request, prefix + "data58".trim(), length));
            String[] data70 = (JSPUtil.getParameter(request, prefix + "data70".trim(), length));
            String[] data72 = (JSPUtil.getParameter(request, prefix + "data72".trim(), length));
            String[] data71 = (JSPUtil.getParameter(request, prefix + "data71".trim(), length));
            String[] data1 = (JSPUtil.getParameter(request, prefix + "data1".trim(), length));
            String[] data74 = (JSPUtil.getParameter(request, prefix + "data74".trim(), length));
            String[] data73 = (JSPUtil.getParameter(request, prefix + "data73".trim(), length));
            String[] data76 = (JSPUtil.getParameter(request, prefix + "data76".trim(), length));
            String[] data4 = (JSPUtil.getParameter(request, prefix + "data4".trim(), length));
            String[] data28 = (JSPUtil.getParameter(request, prefix + "data28".trim(), length));
            String[] data75 = (JSPUtil.getParameter(request, prefix + "data75".trim(), length));
            String[] data5 = (JSPUtil.getParameter(request, prefix + "data5".trim(), length));
            String[] data29 = (JSPUtil.getParameter(request, prefix + "data29".trim(), length));
            String[] data78 = (JSPUtil.getParameter(request, prefix + "data78".trim(), length));
            String[] data2 = (JSPUtil.getParameter(request, prefix + "data2".trim(), length));
            String[] data77 = (JSPUtil.getParameter(request, prefix + "data77".trim(), length));
            String[] data3 = (JSPUtil.getParameter(request, prefix + "data3".trim(), length));
            String[] data8 = (JSPUtil.getParameter(request, prefix + "data8".trim(), length));
            String[] data79 = (JSPUtil.getParameter(request, prefix + "data79".trim(), length));
            String[] data9 = (JSPUtil.getParameter(request, prefix + "data9".trim(), length));
            String[] data6 = (JSPUtil.getParameter(request, prefix + "data6".trim(), length));
            String[] data7 = (JSPUtil.getParameter(request, prefix + "data7".trim(), length));
            String[] data21 = (JSPUtil.getParameter(request, prefix + "data21".trim(), length));
            String[] data20 = (JSPUtil.getParameter(request, prefix + "data20".trim(), length));
            String[] data23 = (JSPUtil.getParameter(request, prefix + "data23".trim(), length));
            String[] data22 = (JSPUtil.getParameter(request, prefix + "data22".trim(), length));
            String[] data60 = (JSPUtil.getParameter(request, prefix + "data60".trim(), length));
            String[] data25 = (JSPUtil.getParameter(request, prefix + "data25".trim(), length));
            String[] data61 = (JSPUtil.getParameter(request, prefix + "data61".trim(), length));
            String[] data24 = (JSPUtil.getParameter(request, prefix + "data24".trim(), length));
            String[] data62 = (JSPUtil.getParameter(request, prefix + "data62".trim(), length));
            String[] data27 = (JSPUtil.getParameter(request, prefix + "data27".trim(), length));
            String[] data63 = (JSPUtil.getParameter(request, prefix + "data63".trim(), length));
            String[] data26 = (JSPUtil.getParameter(request, prefix + "data26".trim(), length));
            String[] data64 = (JSPUtil.getParameter(request, prefix + "data64".trim(), length));
            String[] inVvdCd = (JSPUtil.getParameter(request, prefix + "in_vvd_cd".trim(), length));
            String[] data65 = (JSPUtil.getParameter(request, prefix + "data65".trim(), length));
            String[] data66 = (JSPUtil.getParameter(request, prefix + "data66".trim(), length));
            String[] data67 = (JSPUtil.getParameter(request, prefix + "data67".trim(), length));
            String[] data68 = (JSPUtil.getParameter(request, prefix + "data68".trim(), length));
            String[] data69 = (JSPUtil.getParameter(request, prefix + "data69".trim(), length));
            String[] cyOprCd = (JSPUtil.getParameter(request, prefix + "cy_opr_cd".trim(), length));
            String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix + "in_call_sgn_no".trim(), length));
            String[] data39 = (JSPUtil.getParameter(request, prefix + "data39".trim(), length));
            String[] data30 = (JSPUtil.getParameter(request, prefix + "data30".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] data37 = (JSPUtil.getParameter(request, prefix + "data37".trim(), length));
            String[] data38 = (JSPUtil.getParameter(request, prefix + "data38".trim(), length));
            String[] data35 = (JSPUtil.getParameter(request, prefix + "data35".trim(), length));
            String[] data36 = (JSPUtil.getParameter(request, prefix + "data36".trim(), length));
            String[] data33 = (JSPUtil.getParameter(request, prefix + "data33".trim(), length));
            String[] data34 = (JSPUtil.getParameter(request, prefix + "data34".trim(), length));
            String[] data31 = (JSPUtil.getParameter(request, prefix + "data31".trim(), length));
            String[] data32 = (JSPUtil.getParameter(request, prefix + "data32".trim(), length));
            String[] data40 = (JSPUtil.getParameter(request, prefix + "data40".trim(), length));
            String[] data41 = (JSPUtil.getParameter(request, prefix + "data41".trim(), length));
            String[] data46 = (JSPUtil.getParameter(request, prefix + "data46".trim(), length));
            String[] data47 = (JSPUtil.getParameter(request, prefix + "data47".trim(), length));
            String[] data48 = (JSPUtil.getParameter(request, prefix + "data48".trim(), length));
            String[] data49 = (JSPUtil.getParameter(request, prefix + "data49".trim(), length));
            String[] data42 = (JSPUtil.getParameter(request, prefix + "data42".trim(), length));
            String[] data43 = (JSPUtil.getParameter(request, prefix + "data43".trim(), length));
            String[] data44 = (JSPUtil.getParameter(request, prefix + "data44".trim(), length));
            String[] data45 = (JSPUtil.getParameter(request, prefix + "data45".trim(), length));
            String[] corCd = (JSPUtil.getParameter(request, prefix + "cor_cd", length));
	    	String[] corReason = (JSPUtil.getParameter(request, prefix + "cor_reason", length));
	    	String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
	    	String[] delReason = (JSPUtil.getParameter(request, prefix + "del_reason", length));
	    	String[] opVvdCd = (JSPUtil.getParameter(request, prefix + "op_vvd_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new JapanManifestListEmptyBlInfoVO();
                if (data19[i] != null)
                    model.setData19(data19[i]);
                if (data17[i] != null)
                    model.setData17(data17[i]);
                if (data18[i] != null)
                    model.setData18(data18[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (data12[i] != null)
                    model.setData12(data12[i]);
                if (data11[i] != null)
                    model.setData11(data11[i]);
                if (data10[i] != null)
                    model.setData10(data10[i]);
                if (data51[i] != null)
                    model.setData51(data51[i]);
                if (data16[i] != null)
                    model.setData16(data16[i]);
                if (data52[i] != null)
                    model.setData52(data52[i]);
                if (data15[i] != null)
                    model.setData15(data15[i]);
                if (data14[i] != null)
                    model.setData14(data14[i]);
                if (data50[i] != null)
                    model.setData50(data50[i]);
                if (data13[i] != null)
                    model.setData13(data13[i]);
                if (data55[i] != null)
                    model.setData55(data55[i]);
                if (data56[i] != null)
                    model.setData56(data56[i]);
                if (data53[i] != null)
                    model.setData53(data53[i]);
                if (data54[i] != null)
                    model.setData54(data54[i]);
                if (data59[i] != null)
                    model.setData59(data59[i]);
                if (data57[i] != null)
                    model.setData57(data57[i]);
                if (data58[i] != null)
                    model.setData58(data58[i]);
                if (data70[i] != null)
                    model.setData70(data70[i]);
                if (data72[i] != null)
                    model.setData72(data72[i]);
                if (data71[i] != null)
                    model.setData71(data71[i]);
                if (data1[i] != null)
                    model.setData1(data1[i]);
                if (data74[i] != null)
                    model.setData74(data74[i]);
                if (data73[i] != null)
                    model.setData73(data73[i]);
                if (data76[i] != null)
                    model.setData76(data76[i]);
                if (data4[i] != null)
                    model.setData4(data4[i]);
                if (data28[i] != null)
                    model.setData28(data28[i]);
                if (data75[i] != null)
                    model.setData75(data75[i]);
                if (data5[i] != null)
                    model.setData5(data5[i]);
                if (data29[i] != null)
                    model.setData29(data29[i]);
                if (data78[i] != null)
                    model.setData78(data78[i]);
                if (data2[i] != null)
                    model.setData2(data2[i]);
                if (data77[i] != null)
                    model.setData77(data77[i]);
                if (data3[i] != null)
                    model.setData3(data3[i]);
                if (data8[i] != null)
                    model.setData8(data8[i]);
                if (data79[i] != null)
                    model.setData79(data79[i]);
                if (data9[i] != null)
                    model.setData9(data9[i]);
                if (data6[i] != null)
                    model.setData6(data6[i]);
                if (data7[i] != null)
                    model.setData7(data7[i]);
                if (data21[i] != null)
                    model.setData21(data21[i]);
                if (data20[i] != null)
                    model.setData20(data20[i]);
                if (data23[i] != null)
                    model.setData23(data23[i]);
                if (data22[i] != null)
                    model.setData22(data22[i]);
                if (data60[i] != null)
                    model.setData60(data60[i]);
                if (data25[i] != null)
                    model.setData25(data25[i]);
                if (data61[i] != null)
                    model.setData61(data61[i]);
                if (data24[i] != null)
                    model.setData24(data24[i]);
                if (data62[i] != null)
                    model.setData62(data62[i]);
                if (data27[i] != null)
                    model.setData27(data27[i]);
                if (data63[i] != null)
                    model.setData63(data63[i]);
                if (data26[i] != null)
                    model.setData26(data26[i]);
                if (data64[i] != null)
                    model.setData64(data64[i]);
                if (inVvdCd[i] != null)
                    model.setInVvdCd(inVvdCd[i]);
                if (data65[i] != null)
                    model.setData65(data65[i]);
                if (data66[i] != null)
                    model.setData66(data66[i]);
                if (data67[i] != null)
                    model.setData67(data67[i]);
                if (data68[i] != null)
                    model.setData68(data68[i]);
                if (data69[i] != null)
                    model.setData69(data69[i]);
                if (cyOprCd[i] != null)
                    model.setCyOprCd(cyOprCd[i]);
                if (inCallSgnNo[i] != null)
                    model.setInCallSgnNo(inCallSgnNo[i]);
                if (data39[i] != null)
                    model.setData39(data39[i]);
                if (data30[i] != null)
                    model.setData30(data30[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (data37[i] != null)
                    model.setData37(data37[i]);
                if (data38[i] != null)
                    model.setData38(data38[i]);
                if (data35[i] != null)
                    model.setData35(data35[i]);
                if (data36[i] != null)
                    model.setData36(data36[i]);
                if (data33[i] != null)
                    model.setData33(data33[i]);
                if (data34[i] != null)
                    model.setData34(data34[i]);
                if (data31[i] != null)
                    model.setData31(data31[i]);
                if (data32[i] != null)
                    model.setData32(data32[i]);
                if (data40[i] != null)
                    model.setData40(data40[i]);
                if (data41[i] != null)
                    model.setData41(data41[i]);
                if (data46[i] != null)
                    model.setData46(data46[i]);
                if (data47[i] != null)
                    model.setData47(data47[i]);
                if (data48[i] != null)
                    model.setData48(data48[i]);
                if (data49[i] != null)
                    model.setData49(data49[i]);
                if (data42[i] != null)
                    model.setData42(data42[i]);
                if (data43[i] != null)
                    model.setData43(data43[i]);
                if (data44[i] != null)
                    model.setData44(data44[i]);
                if (data45[i] != null)
                    model.setData45(data45[i]);
                if (corCd[i] != null) 
		    		model.setCorCd(corCd[i]);
				if (corReason[i] != null) 
		    		model.setCorReason(corReason[i]);
				if (delCd[i] != null) 
		    		model.setDelCd(delCd[i]);
				if (delReason[i] != null) 
		    		model.setDelReason(delReason[i]);
				if (opVvdCd[i] != null) 
		    		model.setOpVvdCd(opVvdCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getJapanManifestListEmptyBlInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return JapanManifestListEmptyBlInfoVO[]
	 */
    public JapanManifestListEmptyBlInfoVO[] getJapanManifestListEmptyBlInfoVOs() {
        JapanManifestListEmptyBlInfoVO[] vos = (JapanManifestListEmptyBlInfoVO[]) models.toArray(new JapanManifestListEmptyBlInfoVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.data19 = this.data19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data17 = this.data17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data18 = this.data18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data12 = this.data12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data11 = this.data11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data10 = this.data10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data51 = this.data51.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data16 = this.data16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data52 = this.data52.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data15 = this.data15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data14 = this.data14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data50 = this.data50.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data13 = this.data13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data55 = this.data55.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data56 = this.data56.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data53 = this.data53.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data54 = this.data54.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data59 = this.data59.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data57 = this.data57.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data58 = this.data58.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data70 = this.data70.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data72 = this.data72.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data71 = this.data71.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data1 = this.data1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data74 = this.data74.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data73 = this.data73.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data76 = this.data76.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data4 = this.data4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data28 = this.data28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data75 = this.data75.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data5 = this.data5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data29 = this.data29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data78 = this.data78.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data2 = this.data2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data77 = this.data77.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data3 = this.data3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data8 = this.data8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data79 = this.data79.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data9 = this.data9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data6 = this.data6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data7 = this.data7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data21 = this.data21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data20 = this.data20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data23 = this.data23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data22 = this.data22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data60 = this.data60.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data25 = this.data25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data61 = this.data61.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data24 = this.data24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data62 = this.data62.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data27 = this.data27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data63 = this.data63.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data26 = this.data26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data64 = this.data64.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inVvdCd = this.inVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data65 = this.data65.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data66 = this.data66.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data67 = this.data67.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data68 = this.data68.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data69 = this.data69.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cyOprCd = this.cyOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inCallSgnNo = this.inCallSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data39 = this.data39.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data30 = this.data30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data37 = this.data37.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data38 = this.data38.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data35 = this.data35.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data36 = this.data36.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data33 = this.data33.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data34 = this.data34.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data31 = this.data31.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data32 = this.data32.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data40 = this.data40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data41 = this.data41.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data46 = this.data46.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data47 = this.data47.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data48 = this.data48.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data49 = this.data49.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data42 = this.data42.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data43 = this.data43.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data44 = this.data44.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data45 = this.data45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corCd = this.corCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corReason = this.corReason.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delReason = this.delReason.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opVvdCd = this.opVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
