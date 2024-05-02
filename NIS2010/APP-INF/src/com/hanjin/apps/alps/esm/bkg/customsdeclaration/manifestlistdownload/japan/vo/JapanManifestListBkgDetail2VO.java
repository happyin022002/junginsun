/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanManifestListBkgDetail2VO.java
*@FileTitle : JapanManifestListBkgDetail2VO
*Open Issues :
*Change history :
*	2017.09.07 하대성 custPhnNo1, custPhnNo2, custPhnNo3 Culumn Add
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2009.09.04 김승민 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class JapanManifestListBkgDetail2VO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<JapanManifestListBkgDetail2VO> models = new ArrayList<JapanManifestListBkgDetail2VO>();

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String mkDesc = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String measUtCd = null;

    /* Column Info */
    private String custNm1 = null;

    /* Column Info */
    private String custAddr1 = null;

    /* Column Info */
    private String custAddr3 = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String custAddr2 = null;

    /* Column Info */
    private String bdrCngFlg = null;

    /* Column Info */
    private String lT = null;

    /* Column Info */
    private String corrNo = null;

    /* Column Info */
    private String iF = null;

    /* Column Info */
    private String actWgt = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String polCd2 = null;

    /* Column Info */
    private String cmdtDesc = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String seq = null;

    /* Column Info */
    private String cntrSealNo = null;

    /* Column Info */
    private String custNm3 = null;

    /* Column Info */
    private String custNm2 = null;

    /* Column Info */
    private String custPhnNo1 = null;

    /* Column Info */
    private String custPhnNo2 = null;

    /* Column Info */
    private String custPhnNo3 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public JapanManifestListBkgDetail2VO() {
    }

    public JapanManifestListBkgDetail2VO(String ibflag, String pagerows, String seq, String blNo, String bkgNo, String iF, String lT, String polCd, String podCd, String polCd2, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String custNm1, String custAddr1, String custNm2, String custAddr2, String custNm3, String custAddr3, String mkDesc, String cmdtDesc, String bdrCngFlg, String corrNo, String vpsEtdDt, String cntrNo, String cntrSealNo, String custPhnNo1, String custPhnNo2, String custPhnNo3) {
        this.blNo = blNo;
        this.mkDesc = mkDesc;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.wgtUtCd = wgtUtCd;
        this.measQty = measQty;
        this.pckQty = pckQty;
        this.pckTpCd = pckTpCd;
        this.measUtCd = measUtCd;
        this.custNm1 = custNm1;
        this.custAddr1 = custAddr1;
        this.custAddr3 = custAddr3;
        this.vpsEtdDt = vpsEtdDt;
        this.custAddr2 = custAddr2;
        this.bdrCngFlg = bdrCngFlg;
        this.lT = lT;
        this.corrNo = corrNo;
        this.iF = iF;
        this.actWgt = actWgt;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.polCd2 = polCd2;
        this.cmdtDesc = cmdtDesc;
        this.cntrNo = cntrNo;
        this.seq = seq;
        this.cntrSealNo = cntrSealNo;
        this.custNm3 = custNm3;
        this.custNm2 = custNm2;
        this.custPhnNo1 = custPhnNo1;
        this.custPhnNo2 = custPhnNo2;
        this.custPhnNo3 = custPhnNo3;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("mk_desc", getMkDesc());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("cust_nm1", getCustNm1());
        this.hashColumns.put("cust_addr1", getCustAddr1());
        this.hashColumns.put("cust_addr3", getCustAddr3());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("cust_addr2", getCustAddr2());
        this.hashColumns.put("bdr_cng_flg", getBdrCngFlg());
        this.hashColumns.put("l_t", getLT());
        this.hashColumns.put("corr_no", getCorrNo());
        this.hashColumns.put("i_f", getIF());
        this.hashColumns.put("act_wgt", getActWgt());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("pol_cd2", getPolCd2());
        this.hashColumns.put("cmdt_desc", getCmdtDesc());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("seq", getSeq());
        this.hashColumns.put("cntr_seal_no", getCntrSealNo());
        this.hashColumns.put("cust_nm3", getCustNm3());
        this.hashColumns.put("cust_nm2", getCustNm2());
        this.hashColumns.put("cust_phn_no1", getCustPhnNo1());
        this.hashColumns.put("cust_phn_no2", getCustPhnNo2());
        this.hashColumns.put("cust_phn_no3", getCustPhnNo3());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("mk_desc", "mkDesc");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("cust_nm1", "custNm1");
        this.hashFields.put("cust_addr1", "custAddr1");
        this.hashFields.put("cust_addr3", "custAddr3");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("cust_addr2", "custAddr2");
        this.hashFields.put("bdr_cng_flg", "bdrCngFlg");
        this.hashFields.put("l_t", "lT");
        this.hashFields.put("corr_no", "corrNo");
        this.hashFields.put("i_f", "iF");
        this.hashFields.put("act_wgt", "actWgt");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("pol_cd2", "polCd2");
        this.hashFields.put("cmdt_desc", "cmdtDesc");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("seq", "seq");
        this.hashFields.put("cntr_seal_no", "cntrSealNo");
        this.hashFields.put("cust_nm3", "custNm3");
        this.hashFields.put("cust_nm2", "custNm2");
        this.hashFields.put("cust_phn_no1", "custPhnNo1");
        this.hashFields.put("cust_phn_no2", "custPhnNo2");
        this.hashFields.put("cust_phn_no3", "custPhnNo3");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 * Column Info
	 * @return mkDesc
	 */
    public String getMkDesc() {
        return this.mkDesc;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return pckQty
	 */
    public String getPckQty() {
        return this.pckQty;
    }

    /**
	 * Column Info
	 * @return pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
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
	 * @return custNm1
	 */
    public String getCustNm1() {
        return this.custNm1;
    }

    /**
	 * Column Info
	 * @return custAddr1
	 */
    public String getCustAddr1() {
        return this.custAddr1;
    }

    /**
	 * Column Info
	 * @return custAddr3
	 */
    public String getCustAddr3() {
        return this.custAddr3;
    }

    /**
	 * Column Info
	 * @return vpsEtdDt
	 */
    public String getVpsEtdDt() {
        return this.vpsEtdDt;
    }

    /**
	 * Column Info
	 * @return custAddr2
	 */
    public String getCustAddr2() {
        return this.custAddr2;
    }

    /**
	 * Column Info
	 * @return bdrCngFlg
	 */
    public String getBdrCngFlg() {
        return this.bdrCngFlg;
    }

    /**
	 * Column Info
	 * @return lT
	 */
    public String getLT() {
        return this.lT;
    }

    /**
	 * Column Info
	 * @return corrNo
	 */
    public String getCorrNo() {
        return this.corrNo;
    }

    /**
	 * Column Info
	 * @return iF
	 */
    public String getIF() {
        return this.iF;
    }

    /**
	 * Column Info
	 * @return actWgt
	 */
    public String getActWgt() {
        return this.actWgt;
    }

    /**
	 * Column Info
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return polCd2
	 */
    public String getPolCd2() {
        return this.polCd2;
    }

    /**
	 * Column Info
	 * @return cmdtDesc
	 */
    public String getCmdtDesc() {
        return this.cmdtDesc;
    }

    /**
	 * Column Info
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return seq
	 */
    public String getSeq() {
        return this.seq;
    }

    /**
	 * Column Info
	 * @return cntrSealNo
	 */
    public String getCntrSealNo() {
        return this.cntrSealNo;
    }

    /**
	 * Column Info
	 * @return custNm3
	 */
    public String getCustNm3() {
        return this.custNm3;
    }

    /**
	 * Column Info
	 * @return custNm2
	 */
    public String getCustNm2() {
        return this.custNm2;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * @param mkDesc
	 */
    public void setMkDesc(String mkDesc) {
        this.mkDesc = mkDesc;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param pckQty
	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * Column Info
	 * @param pckTpCd
	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
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
	 * @param custNm1
	 */
    public void setCustNm1(String custNm1) {
        this.custNm1 = custNm1;
    }

    /**
	 * Column Info
	 * @param custAddr1
	 */
    public void setCustAddr1(String custAddr1) {
        this.custAddr1 = custAddr1;
    }

    /**
	 * Column Info
	 * @param custAddr3
	 */
    public void setCustAddr3(String custAddr3) {
        this.custAddr3 = custAddr3;
    }

    /**
	 * Column Info
	 * @param vpsEtdDt
	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    /**
	 * Column Info
	 * @param custAddr2
	 */
    public void setCustAddr2(String custAddr2) {
        this.custAddr2 = custAddr2;
    }

    /**
	 * Column Info
	 * @param bdrCngFlg
	 */
    public void setBdrCngFlg(String bdrCngFlg) {
        this.bdrCngFlg = bdrCngFlg;
    }

    /**
	 * Column Info
	 * @param lT
	 */
    public void setLT(String lT) {
        this.lT = lT;
    }

    /**
	 * Column Info
	 * @param corrNo
	 */
    public void setCorrNo(String corrNo) {
        this.corrNo = corrNo;
    }

    /**
	 * Column Info
	 * @param iF
	 */
    public void setIF(String iF) {
        this.iF = iF;
    }

    /**
	 * Column Info
	 * @param actWgt
	 */
    public void setActWgt(String actWgt) {
        this.actWgt = actWgt;
    }

    /**
	 * Column Info
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param polCd2
	 */
    public void setPolCd2(String polCd2) {
        this.polCd2 = polCd2;
    }

    /**
	 * Column Info
	 * @param cmdtDesc
	 */
    public void setCmdtDesc(String cmdtDesc) {
        this.cmdtDesc = cmdtDesc;
    }

    /**
	 * Column Info
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param seq
	 */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
	 * Column Info
	 * @param cntrSealNo
	 */
    public void setCntrSealNo(String cntrSealNo) {
        this.cntrSealNo = cntrSealNo;
    }

    /**
	 * Column Info
	 * @param custNm3
	 */
    public void setCustNm3(String custNm3) {
        this.custNm3 = custNm3;
    }

    /**
	 * Column Info
	 * @param custNm2
	 */
    public void setCustNm2(String custNm2) {
        this.custNm2 = custNm2;
    }

    public void setCustPhnNo1(String custPhnNo1) {
        this.custPhnNo1 = custPhnNo1;
    }

    public String getCustPhnNo1() {
        return this.custPhnNo1;
    }

    public void setCustPhnNo2(String custPhnNo2) {
        this.custPhnNo2 = custPhnNo2;
    }

    public String getCustPhnNo2() {
        return this.custPhnNo2;
    }

    public void setCustPhnNo3(String custPhnNo3) {
        this.custPhnNo3 = custPhnNo3;
    }

    public String getCustPhnNo3() {
        return this.custPhnNo3;
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
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setCustNm1(JSPUtil.getParameter(request, prefix + "cust_nm1", ""));
        setCustAddr1(JSPUtil.getParameter(request, prefix + "cust_addr1", ""));
        setCustAddr3(JSPUtil.getParameter(request, prefix + "cust_addr3", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setCustAddr2(JSPUtil.getParameter(request, prefix + "cust_addr2", ""));
        setBdrCngFlg(JSPUtil.getParameter(request, prefix + "bdr_cng_flg", ""));
        setLT(JSPUtil.getParameter(request, prefix + "l_t", ""));
        setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
        setIF(JSPUtil.getParameter(request, prefix + "i_f", ""));
        setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setPolCd2(JSPUtil.getParameter(request, prefix + "pol_cd2", ""));
        setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
        setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
        setCustNm3(JSPUtil.getParameter(request, prefix + "cust_nm3", ""));
        setCustNm2(JSPUtil.getParameter(request, prefix + "cust_nm2", ""));
        setCustPhnNo1(JSPUtil.getParameter(request, prefix + "cust_phn_no1", ""));
        setCustPhnNo2(JSPUtil.getParameter(request, prefix + "cust_phn_no2", ""));
        setCustPhnNo3(JSPUtil.getParameter(request, prefix + "cust_phn_no3", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListBkgDetail2VO[]
	 */
    public JapanManifestListBkgDetail2VO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListBkgDetail2VO[]
	 */
    public JapanManifestListBkgDetail2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        JapanManifestListBkgDetail2VO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] mkDesc = (JSPUtil.getParameter(request, prefix + "mk_desc", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] measUtCd = (JSPUtil.getParameter(request, prefix + "meas_ut_cd", length));
            String[] custNm1 = (JSPUtil.getParameter(request, prefix + "cust_nm1", length));
            String[] custAddr1 = (JSPUtil.getParameter(request, prefix + "cust_addr1", length));
            String[] custAddr3 = (JSPUtil.getParameter(request, prefix + "cust_addr3", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] custAddr2 = (JSPUtil.getParameter(request, prefix + "cust_addr2", length));
            String[] bdrCngFlg = (JSPUtil.getParameter(request, prefix + "bdr_cng_flg", length));
            String[] lT = (JSPUtil.getParameter(request, prefix + "l_t", length));
            String[] corrNo = (JSPUtil.getParameter(request, prefix + "corr_no", length));
            String[] iF = (JSPUtil.getParameter(request, prefix + "i_f", length));
            String[] actWgt = (JSPUtil.getParameter(request, prefix + "act_wgt", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] polCd2 = (JSPUtil.getParameter(request, prefix + "pol_cd2", length));
            String[] cmdtDesc = (JSPUtil.getParameter(request, prefix + "cmdt_desc", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] seq = (JSPUtil.getParameter(request, prefix + "seq", length));
            String[] cntrSealNo = (JSPUtil.getParameter(request, prefix + "cntr_seal_no", length));
            String[] custNm3 = (JSPUtil.getParameter(request, prefix + "cust_nm3", length));
            String[] custNm2 = (JSPUtil.getParameter(request, prefix + "cust_nm2", length));
            String[] custPhnNo1 = (JSPUtil.getParameter(request, prefix + "cust_phn_no1", length));
            String[] custPhnNo2 = (JSPUtil.getParameter(request, prefix + "cust_phn_no2", length));
            String[] custPhnNo3 = (JSPUtil.getParameter(request, prefix + "cust_phn_no3", length));
            for (int i = 0; i < length; i++) {
                model = new JapanManifestListBkgDetail2VO();
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (mkDesc[i] != null)
                    model.setMkDesc(mkDesc[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (measUtCd[i] != null)
                    model.setMeasUtCd(measUtCd[i]);
                if (custNm1[i] != null)
                    model.setCustNm1(custNm1[i]);
                if (custAddr1[i] != null)
                    model.setCustAddr1(custAddr1[i]);
                if (custAddr3[i] != null)
                    model.setCustAddr3(custAddr3[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (custAddr2[i] != null)
                    model.setCustAddr2(custAddr2[i]);
                if (bdrCngFlg[i] != null)
                    model.setBdrCngFlg(bdrCngFlg[i]);
                if (lT[i] != null)
                    model.setLT(lT[i]);
                if (corrNo[i] != null)
                    model.setCorrNo(corrNo[i]);
                if (iF[i] != null)
                    model.setIF(iF[i]);
                if (actWgt[i] != null)
                    model.setActWgt(actWgt[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (polCd2[i] != null)
                    model.setPolCd2(polCd2[i]);
                if (cmdtDesc[i] != null)
                    model.setCmdtDesc(cmdtDesc[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (seq[i] != null)
                    model.setSeq(seq[i]);
                if (cntrSealNo[i] != null)
                    model.setCntrSealNo(cntrSealNo[i]);
                if (custNm3[i] != null)
                    model.setCustNm3(custNm3[i]);
                if (custNm2[i] != null)
                    model.setCustNm2(custNm2[i]);
                if (custPhnNo1[i] != null)
                    model.setCustPhnNo1(custPhnNo1[i]);
                if (custPhnNo2[i] != null)
                    model.setCustPhnNo2(custPhnNo2[i]);
                if (custPhnNo3[i] != null)
                    model.setCustPhnNo3(custPhnNo3[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getJapanManifestListBkgDetail2VOs();
    }

    /**
	 * VO 배열을 반환
	 * @return JapanManifestListBkgDetail2VO[]
	 */
    public JapanManifestListBkgDetail2VO[] getJapanManifestListBkgDetail2VOs() {
        JapanManifestListBkgDetail2VO[] vos = (JapanManifestListBkgDetail2VO[]) models.toArray(new JapanManifestListBkgDetail2VO[models.size()]);
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
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mkDesc = this.mkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm1 = this.custNm1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr1 = this.custAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr3 = this.custAddr3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr2 = this.custAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrCngFlg = this.bdrCngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lT = this.lT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.corrNo = this.corrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.iF = this.iF.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actWgt = this.actWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd2 = this.polCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtDesc = this.cmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo = this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm3 = this.custNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm2 = this.custNm2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custPhnNo1 = this.custPhnNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custPhnNo2 = this.custPhnNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custPhnNo3 = this.custPhnNo3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
