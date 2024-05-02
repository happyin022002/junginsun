/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActivationVvdVO.java
*@FileTitle : ActivationVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.12 유혁 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ActivationVvdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ActivationVvdVO> models = new ArrayList<ActivationVvdVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String vslSvcTpCd = null;

    /* Column Info */
    private String curCrrCd = null;

    /* Column Info */
    private String n1stPortBrthDt = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String pfSkdTpCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String turnSkdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String skdStsMnlFlg = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String skdStsCd = null;

    /* Column Info */
    private String turnSkdDirCd = null;

    /* Column Info */
    private String virSkdStsCd = null;

    /* Column Info */
    private String actCrrCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String hisflag = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String vslNmXterHideFlg = null;

    /* Column Info */
    private String pfSvcTpCd = null;

    /* Column Info */
    private String modiVopTpCd = null;

    /* Column Info */
    private String modiVslOprTpCd = null;
    
    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ActivationVvdVO() {
    }

    public ActivationVvdVO(String ibflag, String pagerows, String vslSlanCd, String pfSkdTpCd, String vslSvcTpCd, String vslCd, String vslEngNm, String skdVoyNo, String skdDirCd, String skdStsCd, String virSkdStsCd, String turnSkdVoyNo, String turnSkdDirCd, String creDt, String n1stPortBrthDt, String skdStsMnlFlg, String hisflag, String creUsrId, String updUsrId, String curCrrCd, String actCrrCd, String pfSvcTpCd, String modiVopTpCd, String modiVslOprTpCd) {
        this.vslCd = vslCd;
        this.vslSvcTpCd = vslSvcTpCd;
        this.curCrrCd = curCrrCd;
        this.n1stPortBrthDt = n1stPortBrthDt;
        this.creDt = creDt;
        this.pfSkdTpCd = pfSkdTpCd;
        this.skdVoyNo = skdVoyNo;
        this.vslSlanCd = vslSlanCd;
        this.turnSkdVoyNo = turnSkdVoyNo;
        this.skdDirCd = skdDirCd;
        this.skdStsMnlFlg = skdStsMnlFlg;
        this.pagerows = pagerows;
        this.skdStsCd = skdStsCd;
        this.turnSkdDirCd = turnSkdDirCd;
        this.virSkdStsCd = virSkdStsCd;
        this.actCrrCd = actCrrCd;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.vslEngNm = vslEngNm;
        this.hisflag = hisflag;
        this.updUsrId = updUsrId;
        this.pfSvcTpCd = pfSvcTpCd;
        this.modiVopTpCd = modiVopTpCd;
        this.modiVslOprTpCd = modiVslOprTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
        this.hashColumns.put("cur_crr_cd", getCurCrrCd());
        this.hashColumns.put("n1st_port_brth_dt", getN1stPortBrthDt());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("skd_sts_mnl_flg", getSkdStsMnlFlg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("skd_sts_cd", getSkdStsCd());
        this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
        this.hashColumns.put("vir_skd_sts_cd", getVirSkdStsCd());
        this.hashColumns.put("act_crr_cd", getActCrrCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("hisflag", getHisflag());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("vsl_nm_xter_hide_flg", getVslNmXterHideFlg());
        this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
        this.hashColumns.put("modi_vop_tp_cd", getModiVopTpCd());
        this.hashColumns.put("modi_vsl_opr_tp_cd", getModiVslOprTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
        this.hashFields.put("cur_crr_cd", "curCrrCd");
        this.hashFields.put("n1st_port_brth_dt", "n1stPortBrthDt");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("skd_sts_mnl_flg", "skdStsMnlFlg");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("skd_sts_cd", "skdStsCd");
        this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
        this.hashFields.put("vir_skd_sts_cd", "virSkdStsCd");
        this.hashFields.put("act_crr_cd", "actCrrCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("hisflag", "hisflag");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("vsl_nm_xter_hide_flg", "vslNmXterHideFlg");
        this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
        this.hashFields.put("modi_vop_tp_cd", "modiVopTpCd");
        this.hashFields.put("modi_vsl_opr_tp_cd", "modiVslOprTpCd");
        return this.hashFields;
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
	 * @return vslSvcTpCd
	 */
    public String getVslSvcTpCd() {
        return this.vslSvcTpCd;
    }

    /**
	 * Column Info
	 * @return curCrrCd
	 */
    public String getCurCrrCd() {
        return this.curCrrCd;
    }

    /**
	 * Column Info
	 * @return n1stPortBrthDt
	 */
    public String getN1stPortBrthDt() {
        return this.n1stPortBrthDt;
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
	 * @return pfSkdTpCd
	 */
    public String getPfSkdTpCd() {
        return this.pfSkdTpCd;
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
	 * @return vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    /**
	 * Column Info
	 * @return turnSkdVoyNo
	 */
    public String getTurnSkdVoyNo() {
        return this.turnSkdVoyNo;
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
	 * @return skdStsMnlFlg
	 */
    public String getSkdStsMnlFlg() {
        return this.skdStsMnlFlg;
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
	 * @return skdStsCd
	 */
    public String getSkdStsCd() {
        return this.skdStsCd;
    }

    /**
	 * Column Info
	 * @return turnSkdDirCd
	 */
    public String getTurnSkdDirCd() {
        return this.turnSkdDirCd;
    }

    /**
	 * Column Info
	 * @return virSkdStsCd
	 */
    public String getVirSkdStsCd() {
        return this.virSkdStsCd;
    }

    /**
	 * Column Info
	 * @return actCrrCd
	 */
    public String getActCrrCd() {
        return this.actCrrCd;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
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
	 * @return vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 * Column Info
	 * @return hisflag
	 */
    public String getHisflag() {
        return this.hisflag;
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
	 * @return vslNmXterHideFlg
	 */
    public String getVslNmXterHideFlg() {
        return this.vslNmXterHideFlg;
    }

    /**
	 * Column Info
	 * @return modiVopTpCd
	 */
    public String getModiVopTpCd() {
        return this.modiVopTpCd;
    }    

    /**
	 * Column Info
	 * @return modiVslOprTpCd
	 */
    public String getModiVslOprTpCd() {
        return this.modiVslOprTpCd;
    }   
    
    /**
	 * Column Info
	 * @param vslNmXterHideFlg
	 */
    public void setVslNmXterHideFlg(String vslNmXterHideFlg) {
        this.vslNmXterHideFlg = vslNmXterHideFlg;
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
	 * @param vslSvcTpCd
	 */
    public void setVslSvcTpCd(String vslSvcTpCd) {
        this.vslSvcTpCd = vslSvcTpCd;
    }

    /**
	 * Column Info
	 * @param curCrrCd
	 */
    public void setCurCrrCd(String curCrrCd) {
        this.curCrrCd = curCrrCd;
    }

    /**
	 * Column Info
	 * @param n1stPortBrthDt
	 */
    public void setN1stPortBrthDt(String n1stPortBrthDt) {
        this.n1stPortBrthDt = n1stPortBrthDt;
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
	 * @param pfSkdTpCd
	 */
    public void setPfSkdTpCd(String pfSkdTpCd) {
        this.pfSkdTpCd = pfSkdTpCd;
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
	 * @param vslSlanCd
	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * Column Info
	 * @param turnSkdVoyNo
	 */
    public void setTurnSkdVoyNo(String turnSkdVoyNo) {
        this.turnSkdVoyNo = turnSkdVoyNo;
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
	 * @param skdStsMnlFlg
	 */
    public void setSkdStsMnlFlg(String skdStsMnlFlg) {
        this.skdStsMnlFlg = skdStsMnlFlg;
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
	 * @param skdStsCd
	 */
    public void setSkdStsCd(String skdStsCd) {
        this.skdStsCd = skdStsCd;
    }

    /**
	 * Column Info
	 * @param turnSkdDirCd
	 */
    public void setTurnSkdDirCd(String turnSkdDirCd) {
        this.turnSkdDirCd = turnSkdDirCd;
    }

    /**
	 * Column Info
	 * @param virSkdStsCd
	 */
    public void setVirSkdStsCd(String virSkdStsCd) {
        this.virSkdStsCd = virSkdStsCd;
    }

    /**
	 * Column Info
	 * @param actCrrCd
	 */
    public void setActCrrCd(String actCrrCd) {
        this.actCrrCd = actCrrCd;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
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
	 * @param vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @param hisflag
	 */
    public void setHisflag(String hisflag) {
        this.hisflag = hisflag;
    }

    /**
	 * Column Info
	 * @param updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public void setPfSvcTpCd(String pfSvcTpCd) {
        this.pfSvcTpCd = pfSvcTpCd;
    }

    public String getPfSvcTpCd() {
        return this.pfSvcTpCd;
    }

    /**
	 * Column Info
	 * @param modiVopTpCd
	 */
    public void setModiVopTpCd(String modiVopTpCd) {
        this.modiVopTpCd = modiVopTpCd;
    }

    /**
	 * Column Info
	 * @param modiVslOprTpCd
	 */
    public void setModiVslOprTpCd(String modiVslOprTpCd) {
        this.modiVslOprTpCd = modiVslOprTpCd;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setVslSvcTpCd(JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd", ""));
        setCurCrrCd(JSPUtil.getParameter(request, prefix + "cur_crr_cd", ""));
        setN1stPortBrthDt(JSPUtil.getParameter(request, prefix + "n1st_port_brth_dt", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setSkdStsMnlFlg(JSPUtil.getParameter(request, prefix + "skd_sts_mnl_flg", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSkdStsCd(JSPUtil.getParameter(request, prefix + "skd_sts_cd", ""));
        setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));
        setVirSkdStsCd(JSPUtil.getParameter(request, prefix + "vir_skd_sts_cd", ""));
        setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setHisflag(JSPUtil.getParameter(request, prefix + "hisflag", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setVslNmXterHideFlg(JSPUtil.getParameter(request, prefix + "vsl_nm_xter_hide_flg", ""));
        setPfSvcTpCd(JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", ""));
        setModiVopTpCd(JSPUtil.getParameter(request, prefix + "modi_vop_tp_cd", ""));
        setModiVslOprTpCd(JSPUtil.getParameter(request, prefix + "modi_vsl_opr_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActivationVvdVO[]
	 */
    public ActivationVvdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActivationVvdVO[]
	 */
    public ActivationVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ActivationVvdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd", length));
            String[] curCrrCd = (JSPUtil.getParameter(request, prefix + "cur_crr_cd", length));
            String[] n1stPortBrthDt = (JSPUtil.getParameter(request, prefix + "n1st_port_brth_dt", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] skdStsMnlFlg = (JSPUtil.getParameter(request, prefix + "skd_sts_mnl_flg", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] skdStsCd = (JSPUtil.getParameter(request, prefix + "skd_sts_cd", length));
            String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", length));
            String[] virSkdStsCd = (JSPUtil.getParameter(request, prefix + "vir_skd_sts_cd", length));
            String[] actCrrCd = (JSPUtil.getParameter(request, prefix + "act_crr_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] hisflag = (JSPUtil.getParameter(request, prefix + "hisflag", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] vslNmXterHideFlg = (JSPUtil.getParameter(request, prefix + "vsl_nm_xter_hide_flg", length));
            String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", length));
            String[] modiVopTpCd = (JSPUtil.getParameter(request, prefix + "modi_vop_tp_cd", length));
            String[] modiVslOprTpCd = (JSPUtil.getParameter(request, prefix + "modi_vsl_opr_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ActivationVvdVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (vslSvcTpCd[i] != null)
                    model.setVslSvcTpCd(vslSvcTpCd[i]);
                if (curCrrCd[i] != null)
                    model.setCurCrrCd(curCrrCd[i]);
                if (n1stPortBrthDt[i] != null)
                    model.setN1stPortBrthDt(n1stPortBrthDt[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (pfSkdTpCd[i] != null)
                    model.setPfSkdTpCd(pfSkdTpCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (turnSkdVoyNo[i] != null)
                    model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (skdStsMnlFlg[i] != null)
                    model.setSkdStsMnlFlg(skdStsMnlFlg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (skdStsCd[i] != null)
                    model.setSkdStsCd(skdStsCd[i]);
                if (turnSkdDirCd[i] != null)
                    model.setTurnSkdDirCd(turnSkdDirCd[i]);
                if (virSkdStsCd[i] != null)
                    model.setVirSkdStsCd(virSkdStsCd[i]);
                if (actCrrCd[i] != null)
                    model.setActCrrCd(actCrrCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (hisflag[i] != null)
                    model.setHisflag(hisflag[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (vslNmXterHideFlg[i] != null)
                    model.setVslNmXterHideFlg(vslNmXterHideFlg[i]);
                if (pfSvcTpCd[i] != null) 
		    		model.setPfSvcTpCd(pfSvcTpCd[i]);
                if (modiVopTpCd[i] != null) 
		    		model.setModiVopTpCd(modiVopTpCd[i]);
                if (modiVslOprTpCd[i] != null) 
		    		model.setModiVslOprTpCd(modiVslOprTpCd[i]);
                
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getActivationVvdVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ActivationVvdVO[]
	 */
    public ActivationVvdVO[] getActivationVvdVOs() {
        ActivationVvdVO[] vos = (ActivationVvdVO[]) models.toArray(new ActivationVvdVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSvcTpCd = this.vslSvcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.curCrrCd = this.curCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stPortBrthDt = this.n1stPortBrthDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfSkdTpCd = this.pfSkdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdVoyNo = this.turnSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdStsMnlFlg = this.skdStsMnlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdStsCd = this.skdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdDirCd = this.turnSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.virSkdStsCd = this.virSkdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCrrCd = this.actCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hisflag = this.hisflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfSvcTpCd = this.pfSvcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiVopTpCd = this.modiVopTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiVslOprTpCd = this.modiVslOprTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
