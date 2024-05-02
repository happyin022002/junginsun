/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanManifestListBlGeneralInfoVO.java
*@FileTitle : JapanManifestListBlGeneralInfoVO
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
public class JapanManifestListBlGeneralInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<JapanManifestListBlGeneralInfoVO> models = new ArrayList<JapanManifestListBlGeneralInfoVO>();

    /* Column Info */
    private String cyOprCd = null;

    /* Column Info */
    private String inCallSgnNo = null;

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

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String data10 = null;

    /* Column Info */
    private String data16 = null;

    /* Column Info */
    private String pckCstmsCd = null;

    /* Column Info */
    private String data15 = null;

    /* Column Info */
    private String data14 = null;

    /* Column Info */
    private String data13 = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String loclTsFlg2 = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String loclTsFlg3 = null;

    /* Column Info */
    private String measUtCd = null;

    /* Column Info */
    private String loclTsFlg1 = null;

    /* Column Info */
    private String unLocId1 = null;

    /* Column Info */
    private String data1 = null;

    /* Column Info */
    private String data4 = null;

    /* Column Info */
    private String data5 = null;

    /* Column Info */
    private String data2 = null;

    /* Column Info */
    private String data3 = null;

    /* Column Info */
    private String locNm = null;

    /* Column Info */
    private String data8 = null;

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
    private String data25 = null;

    /* Column Info */
    private String data24 = null;

    /* Column Info */
    private String inVvdCd = null;

    /* Column Info */
    private String unLocId2 = null;

    /* Column Info */
    private String grsWgt = null;

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

    public JapanManifestListBlGeneralInfoVO() {
    }

    public JapanManifestListBlGeneralInfoVO(String ibflag, String pagerows, String inCallSgnNo, String inVvdCd, String data1, String cyOprCd, String data2, String unLocId1, String data3, String data4, String unLocId2, String locNm, String data5, String pckQty, String pckCstmsCd, String grsWgt, String wgtUtCd, String data6, String data7, String measQty, String measUtCd, String data8, String data9, String data10, String data11, String data12, String data13, String data14, String loclTsFlg1, String loclTsFlg2, String loclTsFlg3, String data15, String data16, String data17, String data18, String data19, String data20, String data21, String data22, String data23, String data24, String data25, String corCd, String corReason, String delCd, String delReason, String opVvdCd) {
        this.cyOprCd = cyOprCd;
        this.inCallSgnNo = inCallSgnNo;
        this.data19 = data19;
        this.data17 = data17;
        this.data18 = data18;
        this.pagerows = pagerows;
        this.data12 = data12;
        this.data11 = data11;
        this.ibflag = ibflag;
        this.data10 = data10;
        this.data16 = data16;
        this.pckCstmsCd = pckCstmsCd;
        this.data15 = data15;
        this.data14 = data14;
        this.data13 = data13;
        this.wgtUtCd = wgtUtCd;
        this.measQty = measQty;
        this.loclTsFlg2 = loclTsFlg2;
        this.pckQty = pckQty;
        this.loclTsFlg3 = loclTsFlg3;
        this.measUtCd = measUtCd;
        this.loclTsFlg1 = loclTsFlg1;
        this.unLocId1 = unLocId1;
        this.data1 = data1;
        this.data4 = data4;
        this.data5 = data5;
        this.data2 = data2;
        this.data3 = data3;
        this.locNm = locNm;
        this.data8 = data8;
        this.data9 = data9;
        this.data6 = data6;
        this.data7 = data7;
        this.data21 = data21;
        this.data20 = data20;
        this.data23 = data23;
        this.data22 = data22;
        this.data25 = data25;
        this.data24 = data24;
        this.inVvdCd = inVvdCd;
        this.unLocId2 = unLocId2;
        this.grsWgt = grsWgt;
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
        this.hashColumns.put("cy_opr_cd", getCyOprCd());
        this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
        this.hashColumns.put("data19", getData19());
        this.hashColumns.put("data17", getData17());
        this.hashColumns.put("data18", getData18());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("data12", getData12());
        this.hashColumns.put("data11", getData11());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("data10", getData10());
        this.hashColumns.put("data16", getData16());
        this.hashColumns.put("pck_cstms_cd", getPckCstmsCd());
        this.hashColumns.put("data15", getData15());
        this.hashColumns.put("data14", getData14());
        this.hashColumns.put("data13", getData13());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("locl_ts_flg2", getLoclTsFlg2());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("locl_ts_flg3", getLoclTsFlg3());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("locl_ts_flg1", getLoclTsFlg1());
        this.hashColumns.put("un_loc_id1", getUnLocId1());
        this.hashColumns.put("data1", getData1());
        this.hashColumns.put("data4", getData4());
        this.hashColumns.put("data5", getData5());
        this.hashColumns.put("data2", getData2());
        this.hashColumns.put("data3", getData3());
        this.hashColumns.put("loc_nm", getLocNm());
        this.hashColumns.put("data8", getData8());
        this.hashColumns.put("data9", getData9());
        this.hashColumns.put("data6", getData6());
        this.hashColumns.put("data7", getData7());
        this.hashColumns.put("data21", getData21());
        this.hashColumns.put("data20", getData20());
        this.hashColumns.put("data23", getData23());
        this.hashColumns.put("data22", getData22());
        this.hashColumns.put("data25", getData25());
        this.hashColumns.put("data24", getData24());
        this.hashColumns.put("in_vvd_cd", getInVvdCd());
        this.hashColumns.put("un_loc_id2", getUnLocId2());
        this.hashColumns.put("grs_wgt", getGrsWgt());
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
        this.hashFields.put("cy_opr_cd", "cyOprCd");
        this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
        this.hashFields.put("data19", "data19");
        this.hashFields.put("data17", "data17");
        this.hashFields.put("data18", "data18");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("data12", "data12");
        this.hashFields.put("data11", "data11");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("data10", "data10");
        this.hashFields.put("data16", "data16");
        this.hashFields.put("pck_cstms_cd", "pckCstmsCd");
        this.hashFields.put("data15", "data15");
        this.hashFields.put("data14", "data14");
        this.hashFields.put("data13", "data13");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("locl_ts_flg2", "loclTsFlg2");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("locl_ts_flg3", "loclTsFlg3");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("locl_ts_flg1", "loclTsFlg1");
        this.hashFields.put("un_loc_id1", "unLocId1");
        this.hashFields.put("data1", "data1");
        this.hashFields.put("data4", "data4");
        this.hashFields.put("data5", "data5");
        this.hashFields.put("data2", "data2");
        this.hashFields.put("data3", "data3");
        this.hashFields.put("loc_nm", "locNm");
        this.hashFields.put("data8", "data8");
        this.hashFields.put("data9", "data9");
        this.hashFields.put("data6", "data6");
        this.hashFields.put("data7", "data7");
        this.hashFields.put("data21", "data21");
        this.hashFields.put("data20", "data20");
        this.hashFields.put("data23", "data23");
        this.hashFields.put("data22", "data22");
        this.hashFields.put("data25", "data25");
        this.hashFields.put("data24", "data24");
        this.hashFields.put("in_vvd_cd", "inVvdCd");
        this.hashFields.put("un_loc_id2", "unLocId2");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("cor_cd", "corCd");
        this.hashFields.put("cor_reason", "corReason");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("del_reason", "delReason");
        this.hashFields.put("op_vvd_cd", "opVvdCd");
        return this.hashFields;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @return data16
	 */
    public String getData16() {
        return this.data16;
    }

    /**
	 * Column Info
	 * @return pckCstmsCd
	 */
    public String getPckCstmsCd() {
        return this.pckCstmsCd;
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
	 * @return data13
	 */
    public String getData13() {
        return this.data13;
    }

    /**
	 * Column Info
	 * @return wgtUtCd
	 */
    public String getWgtUtCd() {
        return this.wgtUtCd;
    }

    /**
	 * Column Info
	 * @return measQty
	 */
    public String getMeasQty() {
        return this.measQty;
    }

    /**
	 * Column Info
	 * @return loclTsFlg2
	 */
    public String getLoclTsFlg2() {
        return this.loclTsFlg2;
    }

    /**
	 * Column Info
	 * @return pckQty
	 */
    public String getPckQty() {
        return this.pckQty;
    }

    /**
	 * Column Info
	 * @return loclTsFlg3
	 */
    public String getLoclTsFlg3() {
        return this.loclTsFlg3;
    }

    /**
	 * Column Info
	 * @return measUtCd
	 */
    public String getMeasUtCd() {
        return this.measUtCd;
    }

    /**
	 * Column Info
	 * @return loclTsFlg1
	 */
    public String getLoclTsFlg1() {
        return this.loclTsFlg1;
    }

    /**
	 * Column Info
	 * @return unLocId1
	 */
    public String getUnLocId1() {
        return this.unLocId1;
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
	 * @return data4
	 */
    public String getData4() {
        return this.data4;
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
	 * @return data2
	 */
    public String getData2() {
        return this.data2;
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
	 * @return locNm
	 */
    public String getLocNm() {
        return this.locNm;
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
	 * @return data25
	 */
    public String getData25() {
        return this.data25;
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
	 * @return inVvdCd
	 */
    public String getInVvdCd() {
        return this.inVvdCd;
    }

    /**
	 * Column Info
	 * @return unLocId2
	 */
    public String getUnLocId2() {
        return this.unLocId2;
    }

    /**
	 * Column Info
	 * @return grsWgt
	 */
    public String getGrsWgt() {
        return this.grsWgt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
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
	 * @param data16
	 */
    public void setData16(String data16) {
        this.data16 = data16;
    }

    /**
	 * Column Info
	 * @param pckCstmsCd
	 */
    public void setPckCstmsCd(String pckCstmsCd) {
        this.pckCstmsCd = pckCstmsCd;
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
	 * @param data13
	 */
    public void setData13(String data13) {
        this.data13 = data13;
    }

    /**
	 * Column Info
	 * @param wgtUtCd
	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * Column Info
	 * @param measQty
	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
    }

    /**
	 * Column Info
	 * @param loclTsFlg2
	 */
    public void setLoclTsFlg2(String loclTsFlg2) {
        this.loclTsFlg2 = loclTsFlg2;
    }

    /**
	 * Column Info
	 * @param pckQty
	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * Column Info
	 * @param loclTsFlg3
	 */
    public void setLoclTsFlg3(String loclTsFlg3) {
        this.loclTsFlg3 = loclTsFlg3;
    }

    /**
	 * Column Info
	 * @param measUtCd
	 */
    public void setMeasUtCd(String measUtCd) {
        this.measUtCd = measUtCd;
    }

    /**
	 * Column Info
	 * @param loclTsFlg1
	 */
    public void setLoclTsFlg1(String loclTsFlg1) {
        this.loclTsFlg1 = loclTsFlg1;
    }

    /**
	 * Column Info
	 * @param unLocId1
	 */
    public void setUnLocId1(String unLocId1) {
        this.unLocId1 = unLocId1;
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
	 * @param data4
	 */
    public void setData4(String data4) {
        this.data4 = data4;
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
	 * @param data2
	 */
    public void setData2(String data2) {
        this.data2 = data2;
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
	 * @param locNm
	 */
    public void setLocNm(String locNm) {
        this.locNm = locNm;
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
	 * @param data25
	 */
    public void setData25(String data25) {
        this.data25 = data25;
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
	 * @param inVvdCd
	 */
    public void setInVvdCd(String inVvdCd) {
        this.inVvdCd = inVvdCd;
    }

    /**
	 * Column Info
	 * @param unLocId2
	 */
    public void setUnLocId2(String unLocId2) {
        this.unLocId2 = unLocId2;
    }

    /**
	 * Column Info
	 * @param grsWgt
	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
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
        setCyOprCd(JSPUtil.getParameter(request, prefix + "cy_opr_cd", ""));
        setInCallSgnNo(JSPUtil.getParameter(request, prefix + "in_call_sgn_no", ""));
        setData19(JSPUtil.getParameter(request, prefix + "data19", ""));
        setData17(JSPUtil.getParameter(request, prefix + "data17", ""));
        setData18(JSPUtil.getParameter(request, prefix + "data18", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setData12(JSPUtil.getParameter(request, prefix + "data12", ""));
        setData11(JSPUtil.getParameter(request, prefix + "data11", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setData10(JSPUtil.getParameter(request, prefix + "data10", ""));
        setData16(JSPUtil.getParameter(request, prefix + "data16", ""));
        setPckCstmsCd(JSPUtil.getParameter(request, prefix + "pck_cstms_cd", ""));
        setData15(JSPUtil.getParameter(request, prefix + "data15", ""));
        setData14(JSPUtil.getParameter(request, prefix + "data14", ""));
        setData13(JSPUtil.getParameter(request, prefix + "data13", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setLoclTsFlg2(JSPUtil.getParameter(request, prefix + "locl_ts_flg2", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setLoclTsFlg3(JSPUtil.getParameter(request, prefix + "locl_ts_flg3", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setLoclTsFlg1(JSPUtil.getParameter(request, prefix + "locl_ts_flg1", ""));
        setUnLocId1(JSPUtil.getParameter(request, prefix + "un_loc_id1", ""));
        setData1(JSPUtil.getParameter(request, prefix + "data1", ""));
        setData4(JSPUtil.getParameter(request, prefix + "data4", ""));
        setData5(JSPUtil.getParameter(request, prefix + "data5", ""));
        setData2(JSPUtil.getParameter(request, prefix + "data2", ""));
        setData3(JSPUtil.getParameter(request, prefix + "data3", ""));
        setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
        setData8(JSPUtil.getParameter(request, prefix + "data8", ""));
        setData9(JSPUtil.getParameter(request, prefix + "data9", ""));
        setData6(JSPUtil.getParameter(request, prefix + "data6", ""));
        setData7(JSPUtil.getParameter(request, prefix + "data7", ""));
        setData21(JSPUtil.getParameter(request, prefix + "data21", ""));
        setData20(JSPUtil.getParameter(request, prefix + "data20", ""));
        setData23(JSPUtil.getParameter(request, prefix + "data23", ""));
        setData22(JSPUtil.getParameter(request, prefix + "data22", ""));
        setData25(JSPUtil.getParameter(request, prefix + "data25", ""));
        setData24(JSPUtil.getParameter(request, prefix + "data24", ""));
        setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
        setUnLocId2(JSPUtil.getParameter(request, prefix + "un_loc_id2", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setCorCd(JSPUtil.getParameter(request, prefix + "cor_cd", ""));
        setCorReason(JSPUtil.getParameter(request, prefix + "cor_reason", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setDelReason(JSPUtil.getParameter(request, prefix + "del_reason", ""));
        setOpVvdCd(JSPUtil.getParameter(request, prefix + "op_vvd_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListBlGeneralInfoVO[]
	 */
    public JapanManifestListBlGeneralInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListBlGeneralInfoVO[]
	 */
    public JapanManifestListBlGeneralInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        JapanManifestListBlGeneralInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] cyOprCd = (JSPUtil.getParameter(request, prefix + "cy_opr_cd".trim(), length));
            String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix + "in_call_sgn_no".trim(), length));
            String[] data19 = (JSPUtil.getParameter(request, prefix + "data19".trim(), length));
            String[] data17 = (JSPUtil.getParameter(request, prefix + "data17".trim(), length));
            String[] data18 = (JSPUtil.getParameter(request, prefix + "data18".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] data12 = (JSPUtil.getParameter(request, prefix + "data12".trim(), length));
            String[] data11 = (JSPUtil.getParameter(request, prefix + "data11".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] data10 = (JSPUtil.getParameter(request, prefix + "data10".trim(), length));
            String[] data16 = (JSPUtil.getParameter(request, prefix + "data16".trim(), length));
            String[] pckCstmsCd = (JSPUtil.getParameter(request, prefix + "pck_cstms_cd".trim(), length));
            String[] data15 = (JSPUtil.getParameter(request, prefix + "data15".trim(), length));
            String[] data14 = (JSPUtil.getParameter(request, prefix + "data14".trim(), length));
            String[] data13 = (JSPUtil.getParameter(request, prefix + "data13".trim(), length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd".trim(), length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty".trim(), length));
            String[] loclTsFlg2 = (JSPUtil.getParameter(request, prefix + "locl_ts_flg2".trim(), length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty".trim(), length));
            String[] loclTsFlg3 = (JSPUtil.getParameter(request, prefix + "locl_ts_flg3".trim(), length));
            String[] measUtCd = (JSPUtil.getParameter(request, prefix + "meas_ut_cd".trim(), length));
            String[] loclTsFlg1 = (JSPUtil.getParameter(request, prefix + "locl_ts_flg1".trim(), length));
            String[] unLocId1 = (JSPUtil.getParameter(request, prefix + "un_loc_id1".trim(), length));
            String[] data1 = (JSPUtil.getParameter(request, prefix + "data1".trim(), length));
            String[] data4 = (JSPUtil.getParameter(request, prefix + "data4".trim(), length));
            String[] data5 = (JSPUtil.getParameter(request, prefix + "data5".trim(), length));
            String[] data2 = (JSPUtil.getParameter(request, prefix + "data2".trim(), length));
            String[] data3 = (JSPUtil.getParameter(request, prefix + "data3".trim(), length));
            String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm".trim(), length));
            String[] data8 = (JSPUtil.getParameter(request, prefix + "data8".trim(), length));
            String[] data9 = (JSPUtil.getParameter(request, prefix + "data9".trim(), length));
            String[] data6 = (JSPUtil.getParameter(request, prefix + "data6".trim(), length));
            String[] data7 = (JSPUtil.getParameter(request, prefix + "data7".trim(), length));
            String[] data21 = (JSPUtil.getParameter(request, prefix + "data21".trim(), length));
            String[] data20 = (JSPUtil.getParameter(request, prefix + "data20".trim(), length));
            String[] data23 = (JSPUtil.getParameter(request, prefix + "data23".trim(), length));
            String[] data22 = (JSPUtil.getParameter(request, prefix + "data22".trim(), length));
            String[] data25 = (JSPUtil.getParameter(request, prefix + "data25".trim(), length));
            String[] data24 = (JSPUtil.getParameter(request, prefix + "data24".trim(), length));
            String[] inVvdCd = (JSPUtil.getParameter(request, prefix + "in_vvd_cd".trim(), length));
            String[] unLocId2 = (JSPUtil.getParameter(request, prefix + "un_loc_id2".trim(), length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt".trim(), length));
            String[] corCd = (JSPUtil.getParameter(request, prefix + "cor_cd", length));
            String[] corReason = (JSPUtil.getParameter(request, prefix + "cor_reason", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] delReason = (JSPUtil.getParameter(request, prefix + "del_reason", length));
            String[] opVvdCd = (JSPUtil.getParameter(request, prefix + "op_vvd_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new JapanManifestListBlGeneralInfoVO();
                if (cyOprCd[i] != null)
                    model.setCyOprCd(cyOprCd[i]);
                if (inCallSgnNo[i] != null)
                    model.setInCallSgnNo(inCallSgnNo[i]);
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
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (data10[i] != null)
                    model.setData10(data10[i]);
                if (data16[i] != null)
                    model.setData16(data16[i]);
                if (pckCstmsCd[i] != null)
                    model.setPckCstmsCd(pckCstmsCd[i]);
                if (data15[i] != null)
                    model.setData15(data15[i]);
                if (data14[i] != null)
                    model.setData14(data14[i]);
                if (data13[i] != null)
                    model.setData13(data13[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (loclTsFlg2[i] != null)
                    model.setLoclTsFlg2(loclTsFlg2[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (loclTsFlg3[i] != null)
                    model.setLoclTsFlg3(loclTsFlg3[i]);
                if (measUtCd[i] != null)
                    model.setMeasUtCd(measUtCd[i]);
                if (loclTsFlg1[i] != null)
                    model.setLoclTsFlg1(loclTsFlg1[i]);
                if (unLocId1[i] != null)
                    model.setUnLocId1(unLocId1[i]);
                if (data1[i] != null)
                    model.setData1(data1[i]);
                if (data4[i] != null)
                    model.setData4(data4[i]);
                if (data5[i] != null)
                    model.setData5(data5[i]);
                if (data2[i] != null)
                    model.setData2(data2[i]);
                if (data3[i] != null)
                    model.setData3(data3[i]);
                if (locNm[i] != null)
                    model.setLocNm(locNm[i]);
                if (data8[i] != null)
                    model.setData8(data8[i]);
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
                if (data25[i] != null)
                    model.setData25(data25[i]);
                if (data24[i] != null)
                    model.setData24(data24[i]);
                if (inVvdCd[i] != null)
                    model.setInVvdCd(inVvdCd[i]);
                if (unLocId2[i] != null)
                    model.setUnLocId2(unLocId2[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
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
        return getJapanManifestListBlGeneralInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return JapanManifestListBlGeneralInfoVO[]
	 */
    public JapanManifestListBlGeneralInfoVO[] getJapanManifestListBlGeneralInfoVOs() {
        JapanManifestListBlGeneralInfoVO[] vos = (JapanManifestListBlGeneralInfoVO[]) models.toArray(new JapanManifestListBlGeneralInfoVO[models.size()]);
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
        this.cyOprCd = this.cyOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inCallSgnNo = this.inCallSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data19 = this.data19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data17 = this.data17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data18 = this.data18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data12 = this.data12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data11 = this.data11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data10 = this.data10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data16 = this.data16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckCstmsCd = this.pckCstmsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data15 = this.data15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data14 = this.data14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data13 = this.data13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclTsFlg2 = this.loclTsFlg2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclTsFlg3 = this.loclTsFlg3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclTsFlg1 = this.loclTsFlg1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocId1 = this.unLocId1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data1 = this.data1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data4 = this.data4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data5 = this.data5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data2 = this.data2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data3 = this.data3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data8 = this.data8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data9 = this.data9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data6 = this.data6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data7 = this.data7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data21 = this.data21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data20 = this.data20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data23 = this.data23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data22 = this.data22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data25 = this.data25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.data24 = this.data24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inVvdCd = this.inVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unLocId2 = this.unLocId2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corCd = this.corCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corReason = this.corReason.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delReason = this.delReason.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opVvdCd = this.opVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
