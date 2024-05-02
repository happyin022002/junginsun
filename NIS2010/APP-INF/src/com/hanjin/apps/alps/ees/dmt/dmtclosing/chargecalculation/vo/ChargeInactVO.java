/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeInactVO.java
*@FileTitle : ChargeInactVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.19 
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class ChargeInactVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ChargeInactVO> models = new ArrayList<ChargeInactVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String sysAreaGrpId = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String cntrCycNo = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String dmdtChgLocDivCd = null;

    /* Column Info */
    private String chgSeq = null;

    /* Column Info */
    private String inactRqstNo = null;

    /* Column Info */
    private String inactAproNo = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String dmdtDeltRqstStsCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String dmdtChgDeltRsnCd = null;

    /* Column Info */
    private String deltRmk = null;

    /* Column Info */
    private String dmdtChgDeltSpecRsnCd = null;

    /* Column Info */
    private String deltSpecRsnRmkSeq = null;

    /* Column Info */
    private String deltSeq = null;

    /* Column Info */
    private String aproUsrId = null;

    /* Column Info */
    private String aproOfcCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ChargeInactVO() {
    }

    public ChargeInactVO(String ibflag, String pagerows, String sysAreaGrpId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String inactRqstNo, String inactAproNo, String ofcCd, String dmdtDeltRqstStsCd, String creUsrId, String creOfcCd, String dmdtChgDeltRsnCd, String deltRmk, String dmdtChgDeltSpecRsnCd, String deltSpecRsnRmkSeq, String deltSeq, String aproUsrId, String aproOfcCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.sysAreaGrpId = sysAreaGrpId;
        this.cntrNo = cntrNo;
        this.cntrCycNo = cntrCycNo;
        this.dmdtTrfCd = dmdtTrfCd;
        this.dmdtChgLocDivCd = dmdtChgLocDivCd;
        this.chgSeq = chgSeq;
        this.inactRqstNo = inactRqstNo;
        this.inactAproNo = inactAproNo;
        this.ofcCd = ofcCd;
        this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
        this.creUsrId = creUsrId;
        this.creOfcCd = creOfcCd;
        this.dmdtChgDeltRsnCd = dmdtChgDeltRsnCd;
        this.deltRmk = deltRmk;
        this.dmdtChgDeltSpecRsnCd = dmdtChgDeltSpecRsnCd;
        this.deltSpecRsnRmkSeq = deltSpecRsnRmkSeq;
        this.deltSeq = deltSeq;
        this.aproUsrId = aproUsrId;
        this.aproOfcCd = aproOfcCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
        this.hashColumns.put("chg_seq", getChgSeq());
        this.hashColumns.put("inact_rqst_no", getInactRqstNo());
        this.hashColumns.put("inact_apro_no", getInactAproNo());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("dmdt_delt_rqst_sts_cd", getDmdtDeltRqstStsCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("dmdt_chg_delt_rsn_cd", getDmdtChgDeltRsnCd());
        this.hashColumns.put("delt_rmk", getDeltRmk());
        this.hashColumns.put("dmdt_chg_delt_spec_rsn_cd", getDmdtChgDeltSpecRsnCd());
        this.hashColumns.put("delt_spec_rsn_rmk_seq", getDeltSpecRsnRmkSeq());
        this.hashColumns.put("delt_seq", getDeltSeq());
        this.hashColumns.put("apro_usr_id", getAproUsrId());
        this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("cntr_cyc_no", "cntrCycNo");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
        this.hashFields.put("chg_seq", "chgSeq");
        this.hashFields.put("inact_rqst_no", "inactRqstNo");
        this.hashFields.put("inact_apro_no", "inactAproNo");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("dmdt_delt_rqst_sts_cd", "dmdtDeltRqstStsCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("dmdt_chg_delt_rsn_cd", "dmdtChgDeltRsnCd");
        this.hashFields.put("delt_rmk", "deltRmk");
        this.hashFields.put("dmdt_chg_delt_spec_rsn_cd", "dmdtChgDeltSpecRsnCd");
        this.hashFields.put("delt_spec_rsn_rmk_seq", "deltSpecRsnRmkSeq");
        this.hashFields.put("delt_seq", "deltSeq");
        this.hashFields.put("apro_usr_id", "aproUsrId");
        this.hashFields.put("apro_ofc_cd", "aproOfcCd");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String sysAreaGrpId
	 */
    public void setSysAreaGrpId(String sysAreaGrpId) {
        this.sysAreaGrpId = sysAreaGrpId;
    }

    /**
	 * 
	 * @return String sysAreaGrpId
	 */
    public String getSysAreaGrpId() {
        return this.sysAreaGrpId;
    }

    /**
	 *
	 * @param String cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * 
	 * @return String cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 *
	 * @param String cntrCycNo
	 */
    public void setCntrCycNo(String cntrCycNo) {
        this.cntrCycNo = cntrCycNo;
    }

    /**
	 * 
	 * @return String cntrCycNo
	 */
    public String getCntrCycNo() {
        return this.cntrCycNo;
    }

    /**
	 *
	 * @param String dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    /**
	 * 
	 * @return String dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
    }

    /**
	 *
	 * @param String dmdtChgLocDivCd
	 */
    public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
        this.dmdtChgLocDivCd = dmdtChgLocDivCd;
    }

    /**
	 * 
	 * @return String dmdtChgLocDivCd
	 */
    public String getDmdtChgLocDivCd() {
        return this.dmdtChgLocDivCd;
    }

    /**
	 *
	 * @param String chgSeq
	 */
    public void setChgSeq(String chgSeq) {
        this.chgSeq = chgSeq;
    }

    /**
	 * 
	 * @return String chgSeq
	 */
    public String getChgSeq() {
        return this.chgSeq;
    }

    public void setInactRqstNo(String inactRqstNo) {
        this.inactRqstNo = inactRqstNo;
    }

    public String getInactRqstNo() {
        return this.inactRqstNo;
    }

    public void setInactAproNo(String inactAproNo) {
        this.inactAproNo = inactAproNo;
    }

    public String getInactAproNo() {
        return this.inactAproNo;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public String getOfcCd() {
        return this.ofcCd;
    }

    public void setDmdtDeltRqstStsCd(String dmdtDeltRqstStsCd) {
        this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
    }

    public String getDmdtDeltRqstStsCd() {
        return this.dmdtDeltRqstStsCd;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    public String getCreOfcCd() {
        return this.creOfcCd;
    }

    public void setDmdtChgDeltRsnCd(String dmdtChgDeltRsnCd) {
        this.dmdtChgDeltRsnCd = dmdtChgDeltRsnCd;
    }

    public String getDmdtChgDeltRsnCd() {
        return this.dmdtChgDeltRsnCd;
    }

    public void setDeltRmk(String deltRmk) {
        this.deltRmk = deltRmk;
    }

    public String getDeltRmk() {
        return this.deltRmk;
    }

    public void setDmdtChgDeltSpecRsnCd(String dmdtChgDeltSpecRsnCd) {
        this.dmdtChgDeltSpecRsnCd = dmdtChgDeltSpecRsnCd;
    }

    public String getDmdtChgDeltSpecRsnCd() {
        return this.dmdtChgDeltSpecRsnCd;
    }

    public void setDeltSpecRsnRmkSeq(String deltSpecRsnRmkSeq) {
        this.deltSpecRsnRmkSeq = deltSpecRsnRmkSeq;
    }

    public String getDeltSpecRsnRmkSeq() {
        return this.deltSpecRsnRmkSeq;
    }

    public void setDeltSeq(String deltSeq) {
        this.deltSeq = deltSeq;
    }

    public String getDeltSeq() {
        return this.deltSeq;
    }

    public void setAproUsrId(String aproUsrId) {
        this.aproUsrId = aproUsrId;
    }

    public String getAproUsrId() {
        return this.aproUsrId;
    }

    public void setAproOfcCd(String aproOfcCd) {
        this.aproOfcCd = aproOfcCd;
    }

    public String getAproOfcCd() {
        return this.aproOfcCd;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSysAreaGrpId(JSPUtil.getParameter(request, prefix + "sys_area_grp_id", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
        setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
        setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
        setInactRqstNo(JSPUtil.getParameter(request, prefix + "inact_rqst_no", ""));
        setInactAproNo(JSPUtil.getParameter(request, prefix + "inact_apro_no", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setDmdtDeltRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_delt_rqst_sts_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setDmdtChgDeltRsnCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_delt_rsn_cd", ""));
        setDeltRmk(JSPUtil.getParameter(request, prefix + "delt_rmk", ""));
        setDmdtChgDeltSpecRsnCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_delt_spec_rsn_cd", ""));
        setDeltSpecRsnRmkSeq(JSPUtil.getParameter(request, prefix + "delt_spec_rsn_rmk_seq", ""));
        setDeltSeq(JSPUtil.getParameter(request, prefix + "delt_seq", ""));
        setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
        setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeInactVO[]
	 */
    public ChargeInactVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeInactVO[]
	 */
    public ChargeInactVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChargeInactVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix + "sys_area_grp_id", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] cntrCycNo = (JSPUtil.getParameter(request, prefix + "cntr_cyc_no", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", length));
            String[] chgSeq = (JSPUtil.getParameter(request, prefix + "chg_seq", length));
            String[] inactRqstNo = (JSPUtil.getParameter(request, prefix + "inact_rqst_no", length));
            String[] inactAproNo = (JSPUtil.getParameter(request, prefix + "inact_apro_no", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] dmdtDeltRqstStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_delt_rqst_sts_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] dmdtChgDeltRsnCd = (JSPUtil.getParameter(request, prefix + "dmdt_chg_delt_rsn_cd", length));
            String[] deltRmk = (JSPUtil.getParameter(request, prefix + "delt_rmk", length));
            String[] dmdtChgDeltSpecRsnCd = (JSPUtil.getParameter(request, prefix + "dmdt_chg_delt_spec_rsn_cd", length));
            String[] deltSpecRsnRmkSeq = (JSPUtil.getParameter(request, prefix + "delt_spec_rsn_rmk_seq", length));
            String[] deltSeq = (JSPUtil.getParameter(request, prefix + "delt_seq", length));
            String[] aproUsrId = (JSPUtil.getParameter(request, prefix + "apro_usr_id", length));
	    	String[] aproOfcCd = (JSPUtil.getParameter(request, prefix + "apro_ofc_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ChargeInactVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (sysAreaGrpId[i] != null)
                    model.setSysAreaGrpId(sysAreaGrpId[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (cntrCycNo[i] != null)
                    model.setCntrCycNo(cntrCycNo[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (dmdtChgLocDivCd[i] != null)
                    model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
                if (chgSeq[i] != null)
                    model.setChgSeq(chgSeq[i]);
                if (inactRqstNo[i] != null)
                    model.setInactRqstNo(inactRqstNo[i]);
                if (inactAproNo[i] != null)
                    model.setInactAproNo(inactAproNo[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (dmdtDeltRqstStsCd[i] != null)
                    model.setDmdtDeltRqstStsCd(dmdtDeltRqstStsCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (dmdtChgDeltRsnCd[i] != null)
                    model.setDmdtChgDeltRsnCd(dmdtChgDeltRsnCd[i]);
                if (deltRmk[i] != null)
                    model.setDeltRmk(deltRmk[i]);
                if (dmdtChgDeltSpecRsnCd[i] != null)
                    model.setDmdtChgDeltSpecRsnCd(dmdtChgDeltSpecRsnCd[i]);
                if (deltSpecRsnRmkSeq[i] != null)
                    model.setDeltSpecRsnRmkSeq(deltSpecRsnRmkSeq[i]);
                if (deltSeq[i] != null)
                    model.setDeltSeq(deltSeq[i]);
                if (aproUsrId[i] != null) 
		    		model.setAproUsrId(aproUsrId[i]);
				if (aproOfcCd[i] != null) 
		    		model.setAproOfcCd(aproOfcCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChargeInactVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChargeInactVO[]
	 */
    public ChargeInactVO[] getChargeInactVOs() {
        ChargeInactVO[] vos = (ChargeInactVO[]) models.toArray(new ChargeInactVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sysAreaGrpId = this.sysAreaGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCycNo = this.cntrCycNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtChgLocDivCd = this.dmdtChgLocDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgSeq = this.chgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inactRqstNo = this.inactRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inactAproNo = this.inactAproNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtDeltRqstStsCd = this.dmdtDeltRqstStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtChgDeltRsnCd = this.dmdtChgDeltRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltRmk = this.deltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtChgDeltSpecRsnCd = this.dmdtChgDeltSpecRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltSpecRsnRmkSeq = this.deltSpecRsnRmkSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltSeq = this.deltSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproUsrId = this.aproUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproOfcCd = this.aproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
