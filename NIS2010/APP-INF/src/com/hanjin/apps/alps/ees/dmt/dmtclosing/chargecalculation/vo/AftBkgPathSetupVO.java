/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AftBkgPathSetupVO.java
*@FileTitle : AftBkgPathSetupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.19
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.10.19 김기태 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AftBkgPathSetupVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AftBkgPathSetupVO> models = new ArrayList<AftBkgPathSetupVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String rhqCd = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String toDcAmt = null;

    /* Column Info */
    private String brncOfcPicChkFlg = null;

    /* Column Info */
    private String rhqMgrAproFlg = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String brncOfcMgrAproFlg = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String hoMgrAproFlg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String hoPicChkFlg = null;

    /* Column Info */
    private String aftBkgPathStupSeq = null;

    /* Column Info */
    private String fmDcAmt = null;

    /* Column Info */
    private String expDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String rhqPicChkFlg = null;

    /* Column Info */
    private String aftBkgOfcCd = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String crntFlg = null;

    /* Column Info */
    private String tobeFlg = null;

    /* Column Info */
    private String expFlg = null;

    /* Column Info 
	 * DB에서 사용하는 컬럼명은 RHQ_CD이고 기구현된 INPUT name이 rhq_ofc_cd이므로 조회시 값을 사용하기 위해서는 이 기존 이름으로 받아와 사용해야한다.
	 * */
    private String rhqOfcCd = null;

    /* Column Info */
    private String brncOfcOpMgrAproFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public AftBkgPathSetupVO() {
    }

    public AftBkgPathSetupVO(String ibflag, String pagerows, String rhqCd, String effDt, String fmDcAmt, String aftBkgPathStupSeq, String expDt, String toDcAmt, String ofcCd, String brncOfcPicChkFlg, String brncOfcMgrAproFlg, String rhqPicChkFlg, String rhqMgrAproFlg, String hoPicChkFlg, String hoMgrAproFlg, String creUsrId, String creDt, String updUsrId, String updDt, String aftBkgOfcCd, String deltFlg, String crntFlg, String tobeFlg, String expFlg, String rhqOfcCd, String brncOfcOpMgrAproFlg) {
        this.updDt = updDt;
        this.rhqCd = rhqCd;
        this.creDt = creDt;
        this.toDcAmt = toDcAmt;
        this.brncOfcPicChkFlg = brncOfcPicChkFlg;
        this.rhqMgrAproFlg = rhqMgrAproFlg;
        this.pagerows = pagerows;
        this.brncOfcMgrAproFlg = brncOfcMgrAproFlg;
        this.ofcCd = ofcCd;
        this.creUsrId = creUsrId;
        this.hoMgrAproFlg = hoMgrAproFlg;
        this.ibflag = ibflag;
        this.effDt = effDt;
        this.hoPicChkFlg = hoPicChkFlg;
        this.aftBkgPathStupSeq = aftBkgPathStupSeq;
        this.fmDcAmt = fmDcAmt;
        this.expDt = expDt;
        this.updUsrId = updUsrId;
        this.rhqPicChkFlg = rhqPicChkFlg;
        this.aftBkgOfcCd = aftBkgOfcCd;
        this.deltFlg = deltFlg;
        this.crntFlg = crntFlg;
        this.tobeFlg = tobeFlg;
        this.expFlg = expFlg;
        this.rhqOfcCd = rhqOfcCd;
        this.brncOfcOpMgrAproFlg = brncOfcOpMgrAproFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("rhq_cd", getRhqCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("to_dc_amt", getToDcAmt());
        this.hashColumns.put("brnc_ofc_pic_chk_flg", getBrncOfcPicChkFlg());
        this.hashColumns.put("rhq_mgr_apro_flg", getRhqMgrAproFlg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("brnc_ofc_mgr_apro_flg", getBrncOfcMgrAproFlg());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ho_mgr_apro_flg", getHoMgrAproFlg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("ho_pic_chk_flg", getHoPicChkFlg());
        this.hashColumns.put("aft_bkg_path_stup_seq", getAftBkgPathStupSeq());
        this.hashColumns.put("fm_dc_amt", getFmDcAmt());
        this.hashColumns.put("exp_dt", getExpDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("rhq_pic_chk_flg", getRhqPicChkFlg());
        this.hashColumns.put("aft_bkg_ofc_cd", getAftBkgOfcCd());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("crnt_flg", getCrntFlg());
        this.hashColumns.put("tobe_flg", getTobeFlg());
        this.hashColumns.put("exp_flg", getExpFlg());
        this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
        this.hashColumns.put("brnc_ofc_op_mgr_apro_flg", getBrncOfcOpMgrAproFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("rhq_cd", "rhqCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("to_dc_amt", "toDcAmt");
        this.hashFields.put("brnc_ofc_pic_chk_flg", "brncOfcPicChkFlg");
        this.hashFields.put("rhq_mgr_apro_flg", "rhqMgrAproFlg");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("brnc_ofc_mgr_apro_flg", "brncOfcMgrAproFlg");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ho_mgr_apro_flg", "hoMgrAproFlg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("ho_pic_chk_flg", "hoPicChkFlg");
        this.hashFields.put("aft_bkg_path_stup_seq", "aftBkgPathStupSeq");
        this.hashFields.put("fm_dc_amt", "fmDcAmt");
        this.hashFields.put("exp_dt", "expDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("rhq_pic_chk_flg", "rhqPicChkFlg");
        this.hashFields.put("aft_bkg_ofc_cd", "aftBkgOfcCd");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("crnt_flg", "crntFlg");
        this.hashFields.put("tobe_flg", "tobeFlg");
        this.hashFields.put("exp_flg", "expFlg");
        this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
        this.hashFields.put("brnc_ofc_op_mgr_apro_flg", "brncOfcOpMgrAproFlg");
        return this.hashFields;
    }

    public String getCrntFlg() {
        return crntFlg;
    }

    public void setCrntFlg(String crntFlg) {
        this.crntFlg = crntFlg;
    }

    public String getTobeFlg() {
        return tobeFlg;
    }

    public void setTobeFlg(String tobeFlg) {
        this.tobeFlg = tobeFlg;
    }

    public String getExpFlg() {
        return expFlg;
    }

    public void setExpFlg(String expFlg) {
        this.expFlg = expFlg;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return rhqCd
	 */
    public String getRhqCd() {
        return this.rhqCd;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return toDcAmt
	 */
    public String getToDcAmt() {
        return this.toDcAmt;
    }

    /**
	 * Column Info
	 * @return brncOfcPicChkFlg
	 */
    public String getBrncOfcPicChkFlg() {
        return this.brncOfcPicChkFlg;
    }

    /**
	 * Column Info
	 * @return rhqMgrAproFlg
	 */
    public String getRhqMgrAproFlg() {
        return this.rhqMgrAproFlg;
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
	 * @return brncOfcMgrAproFlg
	 */
    public String getBrncOfcMgrAproFlg() {
        return this.brncOfcMgrAproFlg;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return hoMgrAproFlg
	 */
    public String getHoMgrAproFlg() {
        return this.hoMgrAproFlg;
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
	 * @return effDt
	 */
    public String getEffDt() {
        return this.effDt;
    }

    /**
	 * Column Info
	 * @return hoPicChkFlg
	 */
    public String getHoPicChkFlg() {
        return this.hoPicChkFlg;
    }

    /**
	 * Column Info
	 * @return aftBkgPathStupSeq
	 */
    public String getAftBkgPathStupSeq() {
        return this.aftBkgPathStupSeq;
    }

    /**
	 * Column Info
	 * @return fmDcAmt
	 */
    public String getFmDcAmt() {
        return this.fmDcAmt;
    }

    /**
	 * Column Info
	 * @return expDt
	 */
    public String getExpDt() {
        return this.expDt;
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
	 * @return rhqPicChkFlg
	 */
    public String getRhqPicChkFlg() {
        return this.rhqPicChkFlg;
    }

    /**
	 * Column Info
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 * Column Info
	 * @return aftBkgOfcCd
	 */
    public String getAftBkgOfcCd() {
        return aftBkgOfcCd;
    }

    /**
	 * Column Info
	 * @return rhqOfcCd
	 */
    public String getRhqOfcCd() {
        return rhqOfcCd;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param rhqCd
	 */
    public void setRhqCd(String rhqCd) {
        this.rhqCd = rhqCd;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param toDcAmt
	 */
    public void setToDcAmt(String toDcAmt) {
        this.toDcAmt = toDcAmt;
    }

    /**
	 * Column Info
	 * @param brncOfcPicChkFlg
	 */
    public void setBrncOfcPicChkFlg(String brncOfcPicChkFlg) {
        this.brncOfcPicChkFlg = brncOfcPicChkFlg;
    }

    /**
	 * Column Info
	 * @param rhqMgrAproFlg
	 */
    public void setRhqMgrAproFlg(String rhqMgrAproFlg) {
        this.rhqMgrAproFlg = rhqMgrAproFlg;
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
	 * @param brncOfcMgrAproFlg
	 */
    public void setBrncOfcMgrAproFlg(String brncOfcMgrAproFlg) {
        this.brncOfcMgrAproFlg = brncOfcMgrAproFlg;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param hoMgrAproFlg
	 */
    public void setHoMgrAproFlg(String hoMgrAproFlg) {
        this.hoMgrAproFlg = hoMgrAproFlg;
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
	 * @param effDt
	 */
    public void setEffDt(String effDt) {
        this.effDt = effDt;
    }

    /**
	 * Column Info
	 * @param hoPicChkFlg
	 */
    public void setHoPicChkFlg(String hoPicChkFlg) {
        this.hoPicChkFlg = hoPicChkFlg;
    }

    /**
	 * Column Info
	 * @param aftBkgPathStupSeq
	 */
    public void setAftBkgPathStupSeq(String aftBkgPathStupSeq) {
        this.aftBkgPathStupSeq = aftBkgPathStupSeq;
    }

    /**
	 * Column Info
	 * @param fmDcAmt
	 */
    public void setFmDcAmt(String fmDcAmt) {
        this.fmDcAmt = fmDcAmt;
    }

    /**
	 * Column Info
	 * @param expDt
	 */
    public void setExpDt(String expDt) {
        this.expDt = expDt;
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
	 * @param rhqPicChkFlg
	 */
    public void setRhqPicChkFlg(String rhqPicChkFlg) {
        this.rhqPicChkFlg = rhqPicChkFlg;
    }

    /**
	 * Column Info
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Column Info
	 * @param aftBkgOfcCd
	 */
    public void setAftBkgOfcCd(String aftBkgOfcCd) {
        this.aftBkgOfcCd = aftBkgOfcCd;
    }

    /**
	 * Column Info
	 * @param rhqOfcCd
	 */
    public void setRhqOfcCd(String rhqOfcCd) {
        this.rhqOfcCd = rhqOfcCd;
    }

    public void setBrncOfcOpMgrAproFlg(String brncOfcOpMgrAproFlg) {
        this.brncOfcOpMgrAproFlg = brncOfcOpMgrAproFlg;
    }

    public String getBrncOfcOpMgrAproFlg() {
        return this.brncOfcOpMgrAproFlg;
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
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setToDcAmt(JSPUtil.getParameter(request, prefix + "to_dc_amt", ""));
        setBrncOfcPicChkFlg(JSPUtil.getParameter(request, prefix + "brnc_ofc_pic_chk_flg", ""));
        setRhqMgrAproFlg(JSPUtil.getParameter(request, prefix + "rhq_mgr_apro_flg", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setBrncOfcMgrAproFlg(JSPUtil.getParameter(request, prefix + "brnc_ofc_mgr_apro_flg", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setHoMgrAproFlg(JSPUtil.getParameter(request, prefix + "ho_mgr_apro_flg", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
        setHoPicChkFlg(JSPUtil.getParameter(request, prefix + "ho_pic_chk_flg", ""));
        setAftBkgPathStupSeq(JSPUtil.getParameter(request, prefix + "aft_bkg_path_stup_seq", ""));
        setFmDcAmt(JSPUtil.getParameter(request, prefix + "fm_dc_amt", ""));
        setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setRhqPicChkFlg(JSPUtil.getParameter(request, prefix + "rhq_pic_chk_flg", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCrntFlg(JSPUtil.getParameter(request, prefix + "crnt_flg", ""));
        setTobeFlg(JSPUtil.getParameter(request, prefix + "tobe_flg", ""));
        setExpFlg(JSPUtil.getParameter(request, prefix + "exp_flg", ""));
        setAftBkgOfcCd(JSPUtil.getParameter(request, prefix + "aft_bkg_ofc_cd", ""));
        setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
        setBrncOfcOpMgrAproFlg(JSPUtil.getParameter(request, prefix + "brnc_ofc_op_mgr_apro_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AftBkgPathSetupVO[]
	 */
    public AftBkgPathSetupVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AftBkgPathSetupVO[]
	 */
    public AftBkgPathSetupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AftBkgPathSetupVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] rhqCd = (JSPUtil.getParameter(request, prefix + "rhq_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] toDcAmt = (JSPUtil.getParameter(request, prefix + "to_dc_amt", length));
            String[] brncOfcPicChkFlg = (JSPUtil.getParameter(request, prefix + "brnc_ofc_pic_chk_flg", length));
            String[] rhqMgrAproFlg = (JSPUtil.getParameter(request, prefix + "rhq_mgr_apro_flg", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] brncOfcMgrAproFlg = (JSPUtil.getParameter(request, prefix + "brnc_ofc_mgr_apro_flg", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] hoMgrAproFlg = (JSPUtil.getParameter(request, prefix + "ho_mgr_apro_flg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] hoPicChkFlg = (JSPUtil.getParameter(request, prefix + "ho_pic_chk_flg", length));
            String[] aftBkgPathStupSeq = (JSPUtil.getParameter(request, prefix + "aft_bkg_path_stup_seq", length));
            String[] fmDcAmt = (JSPUtil.getParameter(request, prefix + "fm_dc_amt", length));
            String[] expDt = (JSPUtil.getParameter(request, prefix + "exp_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] rhqPicChkFlg = (JSPUtil.getParameter(request, prefix + "rhq_pic_chk_flg", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] crntFlg = (JSPUtil.getParameter(request, prefix + "crnt_flg", length));
            String[] tobeFlg = (JSPUtil.getParameter(request, prefix + "tobe_flg", length));
            String[] expFlg = (JSPUtil.getParameter(request, prefix + "exp_flg", length));
            String[] aftBkgOfcCd = (JSPUtil.getParameter(request, prefix + "aft_bkg_ofc_cd", length));
            String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", length));
            String[] brncOfcOpMgrAproFlg = (JSPUtil.getParameter(request, prefix + "brnc_ofc_op_mgr_apro_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AftBkgPathSetupVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (rhqCd[i] != null)
                    model.setRhqCd(rhqCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (toDcAmt[i] != null)
                    model.setToDcAmt(toDcAmt[i]);
                if (brncOfcPicChkFlg[i] != null)
                    model.setBrncOfcPicChkFlg(brncOfcPicChkFlg[i]);
                if (rhqMgrAproFlg[i] != null)
                    model.setRhqMgrAproFlg(rhqMgrAproFlg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (brncOfcMgrAproFlg[i] != null)
                    model.setBrncOfcMgrAproFlg(brncOfcMgrAproFlg[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (hoMgrAproFlg[i] != null)
                    model.setHoMgrAproFlg(hoMgrAproFlg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (hoPicChkFlg[i] != null)
                    model.setHoPicChkFlg(hoPicChkFlg[i]);
                if (aftBkgPathStupSeq[i] != null)
                    model.setAftBkgPathStupSeq(aftBkgPathStupSeq[i]);
                if (fmDcAmt[i] != null)
                    model.setFmDcAmt(fmDcAmt[i]);
                if (expDt[i] != null)
                    model.setExpDt(expDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (rhqPicChkFlg[i] != null)
                    model.setRhqPicChkFlg(rhqPicChkFlg[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (crntFlg[i] != null)
                    model.setCrntFlg(crntFlg[i]);
                if (tobeFlg[i] != null)
                    model.setTobeFlg(tobeFlg[i]);
                if (expFlg[i] != null)
                    model.setExpFlg(expFlg[i]);
                if (aftBkgOfcCd[i] != null)
                    model.setAftBkgOfcCd(aftBkgOfcCd[i]);
                if (rhqOfcCd[i] != null)
                    model.setRhqOfcCd(rhqOfcCd[i]);
                if (brncOfcOpMgrAproFlg[i] != null) 
		    		model.setBrncOfcOpMgrAproFlg(brncOfcOpMgrAproFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAftBkgPathSetupVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AftBkgPathSetupVO[]
	 */
    public AftBkgPathSetupVO[] getAftBkgPathSetupVOs() {
        AftBkgPathSetupVO[] vos = (AftBkgPathSetupVO[]) models.toArray(new AftBkgPathSetupVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqCd = this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDcAmt = this.toDcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.brncOfcPicChkFlg = this.brncOfcPicChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqMgrAproFlg = this.rhqMgrAproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.brncOfcMgrAproFlg = this.brncOfcMgrAproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hoMgrAproFlg = this.hoMgrAproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hoPicChkFlg = this.hoPicChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftBkgPathStupSeq = this.aftBkgPathStupSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmDcAmt = this.fmDcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqPicChkFlg = this.rhqPicChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crntFlg = this.crntFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tobeFlg = this.tobeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expFlg = this.expFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftBkgOfcCd = this.aftBkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqOfcCd = this.rhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.brncOfcOpMgrAproFlg = this.brncOfcOpMgrAproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
