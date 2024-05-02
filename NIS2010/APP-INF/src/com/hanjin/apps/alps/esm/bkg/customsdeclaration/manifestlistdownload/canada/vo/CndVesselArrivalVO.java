/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndVesselArrivalVO.java
*@FileTitle : CndVesselArrivalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.03 김민정 
* 1.0 Creation 
* -------------------------------------------------------
* History
* 2013.06.10 김보배 [CHM-201324023] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CndVesselArrivalVO extends VesselArrivalVO {

    private static final long serialVersionUID = 1L;

    private Collection<CndVesselArrivalVO> models = new ArrayList<CndVesselArrivalVO>();

    /* Column Info */
    private String cndVslCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String teuFul = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String cvyRefNo = null;

    /* Column Info */
    private String teuMty = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String crrCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String attrCtnt2 = null;

    /* Column Info */
    private String othMty = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String othFul = null;

    /* Column Info */
    private String feuMty = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String capNm = null;

    /* Column Info */
    private String vslArrRptSndDt = null;

    /* Column Info */
    private String cgoWgt = null;

    /* Column Info */
    private String feuFul = null;

    /* Column Info */
    private String actArrDt = null;

    /* Column Info */
    private String actDepDt = null;

    /* Column Info */
    private String vpsEtdDt = null;

    /* Column Info */
    private String etdDt = null;

    /* Column Info */
    private String vslDepRptSndDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CndVesselArrivalVO() {
    }

    /**
	 * CndVesselArrivalVO
	 * @param ibflag
	 * @param pagerows
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param vpsPortCd
	 * @param crrCd
	 * @param vpsEtaDt
	 * @param cvyRefNo
	 * @param capNm
	 * @param cgoWgt
	 * @param teuFul
	 * @param feuFul
	 * @param othFul
	 * @param teuMty
	 * @param feuMty
	 * @param othMty
	 * @param attrCtnt2
	 * @param updUsrId
	 * @param cndVslCd
	 * @param vslArrRptSndDt
	 * @param actArrDt
	 */
    public CndVesselArrivalVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String crrCd, String vpsEtaDt, String cvyRefNo, String capNm, String cgoWgt, String teuFul, String feuFul, String othFul, String teuMty, String feuMty, String othMty, String attrCtnt2, String updUsrId, String cndVslCd, String vslArrRptSndDt, String actArrDt, String actDepDt, String vpsEtdDt, String etdDt, String vslDepRptSndDt) {
        this.cndVslCd = cndVslCd;
        this.vslCd = vslCd;
        this.teuFul = teuFul;
        this.skdVoyNo = skdVoyNo;
        this.cvyRefNo = cvyRefNo;
        this.teuMty = teuMty;
        this.vpsEtaDt = vpsEtaDt;
        this.skdDirCd = skdDirCd;
        this.crrCd = crrCd;
        this.pagerows = pagerows;
        this.vpsPortCd = vpsPortCd;
        this.attrCtnt2 = attrCtnt2;
        this.othMty = othMty;
        this.ibflag = ibflag;
        this.othFul = othFul;
        this.feuMty = feuMty;
        this.updUsrId = updUsrId;
        this.capNm = capNm;
        this.vslArrRptSndDt = vslArrRptSndDt;
        this.cgoWgt = cgoWgt;
        this.feuFul = feuFul;
        this.actArrDt = actArrDt;
        this.actDepDt = actDepDt;
        this.vpsEtdDt = vpsEtdDt;
        this.etdDt = etdDt;
        this.vslDepRptSndDt = vslDepRptSndDt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cnd_vsl_cd", getCndVslCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("teu_ful", getTeuFul());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("cvy_ref_no", getCvyRefNo());
        this.hashColumns.put("teu_mty", getTeuMty());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
        this.hashColumns.put("oth_mty", getOthMty());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("oth_ful", getOthFul());
        this.hashColumns.put("feu_mty", getFeuMty());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cap_nm", getCapNm());
        this.hashColumns.put("vsl_arr_rpt_snd_dt", getVslArrRptSndDt());
        this.hashColumns.put("cgo_wgt", getCgoWgt());
        this.hashColumns.put("feu_ful", getFeuFul());
        this.hashColumns.put("act_arr_dt", getActArrDt());
        this.hashColumns.put("act_dep_dt", getActDepDt());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("etd_dt", getEtdDt());
        this.hashColumns.put("vsl_dep_rpt_snd_dt", getVslDepRptSndDt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cnd_vsl_cd", "cndVslCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("teu_ful", "teuFul");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("cvy_ref_no", "cvyRefNo");
        this.hashFields.put("teu_mty", "teuMty");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("attr_ctnt2", "attrCtnt2");
        this.hashFields.put("oth_mty", "othMty");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("oth_ful", "othFul");
        this.hashFields.put("feu_mty", "feuMty");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cap_nm", "capNm");
        this.hashFields.put("vsl_arr_rpt_snd_dt", "vslArrRptSndDt");
        this.hashFields.put("cgo_wgt", "cgoWgt");
        this.hashFields.put("feu_ful", "feuFul");
        this.hashFields.put("act_arr_dt", "actArrDt");
        this.hashFields.put("act_dep_dt", "actDepDt");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("etd_dt", "etdDt");
        this.hashFields.put("vsl_dep_rpt_snd_dt", "vslDepRptSndDt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return cndVslCd
	 */
    public String getCndVslCd() {
        return this.cndVslCd;
    }

    /**
	 * Column Info
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return teuFul
	 */
    public String getTeuFul() {
        return this.teuFul;
    }

    /**
	 * Column Info
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return cvyRefNo
	 */
    public String getCvyRefNo() {
        return this.cvyRefNo;
    }

    /**
	 * Column Info
	 * @return teuMty
	 */
    public String getTeuMty() {
        return this.teuMty;
    }

    /**
	 * Column Info
	 * @return vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 * Column Info
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 * Column Info
	 * @return crrCd
	 */
    public String getCrrCd() {
        return this.crrCd;
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
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
    }

    /**
	 * Column Info
	 * @return attrCtnt2
	 */
    public String getAttrCtnt2() {
        return this.attrCtnt2;
    }

    /**
	 * Column Info
	 * @return othMty
	 */
    public String getOthMty() {
        return this.othMty;
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
	 * @return othFul
	 */
    public String getOthFul() {
        return this.othFul;
    }

    /**
	 * Column Info
	 * @return feuMty
	 */
    public String getFeuMty() {
        return this.feuMty;
    }

    /**
	 * Column Info
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 * Column Info
	 * @return capNm
	 */
    public String getCapNm() {
        return this.capNm;
    }

    /**
	 * Column Info
	 * @return vslArrRptSndDt
	 */
    public String getVslArrRptSndDt() {
        return this.vslArrRptSndDt;
    }

    /**
	 * Column Info
	 * @return cgoWgt
	 */
    public String getCgoWgt() {
        return this.cgoWgt;
    }

    /**
	 * Column Info
	 * @return feuFul
	 */
    public String getFeuFul() {
        return this.feuFul;
    }

    /**
	 * Column Info
	 * @return actArrDt
	 */
    public String getActArrDt() {
        return this.actArrDt;
    }

    /**
	 * Column Info
	 * @param cndVslCd
	 */
    public void setCndVslCd(String cndVslCd) {
        this.cndVslCd = cndVslCd;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param teuFul
	 */
    public void setTeuFul(String teuFul) {
        this.teuFul = teuFul;
    }

    /**
	 * Column Info
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param cvyRefNo
	 */
    public void setCvyRefNo(String cvyRefNo) {
        this.cvyRefNo = cvyRefNo;
    }

    /**
	 * Column Info
	 * @param teuMty
	 */
    public void setTeuMty(String teuMty) {
        this.teuMty = teuMty;
    }

    /**
	 * Column Info
	 * @param vpsEtaDt
	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param crrCd
	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
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
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    /**
	 * Column Info
	 * @param attrCtnt2
	 */
    public void setAttrCtnt2(String attrCtnt2) {
        this.attrCtnt2 = attrCtnt2;
    }

    /**
	 * Column Info
	 * @param othMty
	 */
    public void setOthMty(String othMty) {
        this.othMty = othMty;
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
	 * @param othFul
	 */
    public void setOthFul(String othFul) {
        this.othFul = othFul;
    }

    /**
	 * Column Info
	 * @param feuMty
	 */
    public void setFeuMty(String feuMty) {
        this.feuMty = feuMty;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param capNm
	 */
    public void setCapNm(String capNm) {
        this.capNm = capNm;
    }

    /**
	 * Column Info
	 * @param vslArrRptSndDt
	 */
    public void setVslArrRptSndDt(String vslArrRptSndDt) {
        this.vslArrRptSndDt = vslArrRptSndDt;
    }

    /**
	 * Column Info
	 * @param cgoWgt
	 */
    public void setCgoWgt(String cgoWgt) {
        this.cgoWgt = cgoWgt;
    }

    /**
	 * Column Info
	 * @param feuFul
	 */
    public void setFeuFul(String feuFul) {
        this.feuFul = feuFul;
    }

    /**
	 * Column Info
	 * @param actArrDt
	 */
    public void setActArrDt(String actArrDt) {
        this.actArrDt = actArrDt;
    }

    public void setActDepDt(String actDepDt) {
        this.actDepDt = actDepDt;
    }

    public String getActDepDt() {
        return this.actDepDt;
    }

    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    public String getVpsEtdDt() {
        return this.vpsEtdDt;
    }

    public void setEtdDt(String etdDt) {
        this.etdDt = etdDt;
    }

    public String getEtdDt() {
        return this.etdDt;
    }

    public void setVslDepRptSndDt(String vslDepRptSndDt) {
        this.vslDepRptSndDt = vslDepRptSndDt;
    }

    public String getVslDepRptSndDt() {
        return this.vslDepRptSndDt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCndVslCd(JSPUtil.getParameter(request, "cnd_vsl_cd", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setTeuFul(JSPUtil.getParameter(request, "teu_ful", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setCvyRefNo(JSPUtil.getParameter(request, "cvy_ref_no", ""));
        setTeuMty(JSPUtil.getParameter(request, "teu_mty", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
        setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
        setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
        setAttrCtnt2(JSPUtil.getParameter(request, "attr_ctnt2", ""));
        setOthMty(JSPUtil.getParameter(request, "oth_mty", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setOthFul(JSPUtil.getParameter(request, "oth_ful", ""));
        setFeuMty(JSPUtil.getParameter(request, "feu_mty", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setCapNm(JSPUtil.getParameter(request, "cap_nm", ""));
        setVslArrRptSndDt(JSPUtil.getParameter(request, "vsl_arr_rpt_snd_dt", ""));
        setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
        setFeuFul(JSPUtil.getParameter(request, "feu_ful", ""));
        setActArrDt(JSPUtil.getParameter(request, "act_arr_dt", ""));
        setActDepDt(JSPUtil.getParameter(request, "act_dep_dt", ""));
        setActArrDt(JSPUtil.getParameter(request, "etd_dt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndVesselArrivalVO[]
	 */
    public CndVesselArrivalVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndVesselArrivalVO[]
	 */
    public CndVesselArrivalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CndVesselArrivalVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] cndVslCd = (JSPUtil.getParameter(request, prefix + "cnd_vsl_cd".trim(), length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd".trim(), length));
            String[] teuFul = (JSPUtil.getParameter(request, prefix + "teu_ful".trim(), length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no".trim(), length));
            String[] cvyRefNo = (JSPUtil.getParameter(request, prefix + "cvy_ref_no".trim(), length));
            String[] teuMty = (JSPUtil.getParameter(request, prefix + "teu_mty".trim(), length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt".trim(), length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd".trim(), length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd".trim(), length));
            String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix + "attr_ctnt2".trim(), length));
            String[] othMty = (JSPUtil.getParameter(request, prefix + "oth_mty".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] othFul = (JSPUtil.getParameter(request, prefix + "oth_ful".trim(), length));
            String[] feuMty = (JSPUtil.getParameter(request, prefix + "feu_mty".trim(), length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
            String[] capNm = (JSPUtil.getParameter(request, prefix + "cap_nm".trim(), length));
            String[] vslArrRptSndDt = (JSPUtil.getParameter(request, prefix + "vsl_arr_rpt_snd_dt".trim(), length));
            String[] cgoWgt = (JSPUtil.getParameter(request, prefix + "cgo_wgt".trim(), length));
            String[] feuFul = (JSPUtil.getParameter(request, prefix + "feu_ful".trim(), length));
            String[] actArrDt = (JSPUtil.getParameter(request, prefix + "act_arr_dt".trim(), length));
            String[] actDepDt = (JSPUtil.getParameter(request, prefix + "act_dep_dt", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] etdDt = (JSPUtil.getParameter(request, prefix + "etd_dt", length));
            String[] vslDepRptSndDt = (JSPUtil.getParameter(request, prefix + "vsl_dep_rpt_snd_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CndVesselArrivalVO();
                if (cndVslCd[i] != null)
                    model.setCndVslCd(cndVslCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (teuFul[i] != null)
                    model.setTeuFul(teuFul[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (cvyRefNo[i] != null)
                    model.setCvyRefNo(cvyRefNo[i]);
                if (teuMty[i] != null)
                    model.setTeuMty(teuMty[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (attrCtnt2[i] != null)
                    model.setAttrCtnt2(attrCtnt2[i]);
                if (othMty[i] != null)
                    model.setOthMty(othMty[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (othFul[i] != null)
                    model.setOthFul(othFul[i]);
                if (feuMty[i] != null)
                    model.setFeuMty(feuMty[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (capNm[i] != null)
                    model.setCapNm(capNm[i]);
                if (vslArrRptSndDt[i] != null)
                    model.setVslArrRptSndDt(vslArrRptSndDt[i]);
                if (cgoWgt[i] != null)
                    model.setCgoWgt(cgoWgt[i]);
                if (feuFul[i] != null)
                    model.setFeuFul(feuFul[i]);
                if (actArrDt[i] != null)
                    model.setActArrDt(actArrDt[i]);
                if (actDepDt[i] != null)
                    model.setActDepDt(actDepDt[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (etdDt[i] != null)
                    model.setEtdDt(etdDt[i]);
                if (vslDepRptSndDt[i] != null) 
		    		model.setVslDepRptSndDt(vslDepRptSndDt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCndVesselArrivalVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CndVesselArrivalVO[]
	 */
    public CndVesselArrivalVO[] getCndVesselArrivalVOs() {
        CndVesselArrivalVO[] vos = (CndVesselArrivalVO[]) models.toArray(new CndVesselArrivalVO[models.size()]);
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
        this.cndVslCd = this.cndVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teuFul = this.teuFul.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cvyRefNo = this.cvyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.teuMty = this.teuMty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.attrCtnt2 = this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.othMty = this.othMty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.othFul = this.othFul.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.feuMty = this.feuMty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.capNm = this.capNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslArrRptSndDt = this.vslArrRptSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoWgt = this.cgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.feuFul = this.feuFul.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actArrDt = this.actArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actDepDt = this.actDepDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etdDt = this.etdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDepRptSndDt = this.vslDepRptSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
