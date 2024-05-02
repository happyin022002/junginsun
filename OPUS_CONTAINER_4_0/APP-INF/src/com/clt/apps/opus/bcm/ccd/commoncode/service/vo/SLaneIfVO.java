/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SLaneIfVO.java
*@FileTitle : SLaneIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SLaneIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SLaneIfVO> models = new ArrayList<SLaneIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vslSlanCd = null;

    /* Column Info */
    private String vslSlanNm = null;

    /* Column Info */
    private String vslSvcTpCd = null;

    /* Column Info */
    private String vslTpCd = null;

    /* Column Info */
    private String stEffDt = null;

    /* Column Info */
    private String endEffDt = null;

    /* Column Info */
    private String coCd = null;

    /* Column Info */
    private String fdrDivCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String modiVslSlanCd = null;
    
    /* Column Info */
    private String modiVslSlanCd2 = null;

    /* Column Info */
    private String ecomInsfId = null;

    /* Column Info */
    private String ecomInsfPrsId = null;

    /* Column Info */
    private String ecomInsfDttm = null;

    /* Column Info */
    private String ecomInsfCnqeVal = null;

    /* Column Info */
    private String ecomInsfDvCd = null;

    /* Column Info */
    private String ecomInsfCnqeCont = null;

    /* Column Info */
    private String ocediInsfId = null;

    /* Column Info */
    private String ocediInsfPrsId = null;

    /* Column Info */
    private String ocediInsfDttm = null;

    /* Column Info */
    private String ocediInsfCnqeVal = null;

    /* Column Info */
    private String ocediInsfDvCd = null;

    /* Column Info */
    private String ocediInsfCnqeCont = null;

    /* Column Info */
    private String vslSlanIfSeq = null;
	
	/* Column Info */
	private String opediInsfId = null;

    /* Column Info */
    private String opediInsfDvCd = null;
    
    /* Column Info */
    private String modiVipTeamCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SLaneIfVO() {
    }

    public SLaneIfVO(String ibflag, String pagerows, String vslSlanSeq, String vslSlanCd, String vslSlanNm, String vslSvcTpCd, String vslTpCd, String stEffDt, String endEffDt, String coCd, String fdrDivCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String modiVslSlanCd, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont, String ocediInsfId, String ocediInsfPrsId, String ocediInsfDttm, String ocediInsfCnqeVal, String ocediInsfDvCd, String ocediInsfCnqeCont, String vslSlanIfSeq, String opediInsfId, String opediInsfDvCd, String modiVslSlanCd2, String modiVipTeamCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vslSlanCd = vslSlanCd;
        this.vslSlanNm = vslSlanNm;
        this.vslSvcTpCd = vslSvcTpCd;
        this.vslTpCd = vslTpCd;
        this.stEffDt = stEffDt;
        this.endEffDt = endEffDt;
        this.coCd = coCd;
        this.fdrDivCd = fdrDivCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.deltFlg = deltFlg;
        this.modiVslSlanCd = modiVslSlanCd;
        this.ecomInsfId = ecomInsfId;
        this.ecomInsfPrsId = ecomInsfPrsId;
        this.ecomInsfDttm = ecomInsfDttm;
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
        this.ecomInsfDvCd = ecomInsfDvCd;
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
        this.ocediInsfId = ocediInsfId;
        this.ocediInsfPrsId = ocediInsfPrsId;
        this.ocediInsfDttm = ocediInsfDttm;
        this.ocediInsfCnqeVal = ocediInsfCnqeVal;
        this.ocediInsfDvCd = ocediInsfDvCd;
        this.ocediInsfCnqeCont = ocediInsfCnqeCont;
        this.vslSlanIfSeq = vslSlanIfSeq;
        this.opediInsfId = opediInsfId;
        this.opediInsfDvCd = opediInsfDvCd;
        this.modiVslSlanCd2 = modiVslSlanCd2;
        this.modiVipTeamCd = modiVipTeamCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
        this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
        this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
        this.hashColumns.put("vsl_tp_cd", getVslTpCd());
        this.hashColumns.put("st_eff_dt", getStEffDt());
        this.hashColumns.put("end_eff_dt", getEndEffDt());
        this.hashColumns.put("co_cd", getCoCd());
        this.hashColumns.put("fdr_div_cd", getFdrDivCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("modi_vsl_slan_cd", getModiVslSlanCd());
        this.hashColumns.put("ecom_insf_id", getEcomInsfId());
        this.hashColumns.put("ecom_insf_prs_id", getEcomInsfPrsId());
        this.hashColumns.put("ecom_insf_dttm", getEcomInsfDttm());
        this.hashColumns.put("ecom_insf_cnqe_val", getEcomInsfCnqeVal());
        this.hashColumns.put("ecom_insf_dv_cd", getEcomInsfDvCd());
        this.hashColumns.put("ecom_insf_cnqe_cont", getEcomInsfCnqeCont());
        this.hashColumns.put("ocedi_insf_id", getOcediInsfId());
        this.hashColumns.put("ocedi_insf_prs_id", getOcediInsfPrsId());
        this.hashColumns.put("ocedi_insf_dttm", getOcediInsfDttm());
        this.hashColumns.put("ocedi_insf_cnqe_val", getOcediInsfCnqeVal());
        this.hashColumns.put("ocedi_insf_dv_cd", getOcediInsfDvCd());
        this.hashColumns.put("ocedi_insf_cnqe_cont", getOcediInsfCnqeCont());
        this.hashColumns.put("vsl_slan_if_seq", getVslSlanIfSeq());
		this.hashColumns.put("opedi_insf_id", getOpediInsfId());
        this.hashColumns.put("opedi_insf_dv_cd", getOpediInsfDvCd());
        this.hashColumns.put("modi_vsl_slan_cd2", getModiVslSlanCd2());
        this.hashColumns.put("modi_vip_team_cd", getModiVipTeamCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vsl_slan_seq", "vslSlanSeq");
        this.hashFields.put("vsl_slan_cd", "vslSlanCd");
        this.hashFields.put("vsl_slan_nm", "vslSlanNm");
        this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
        this.hashFields.put("vsl_tp_cd", "vslTpCd");
        this.hashFields.put("st_eff_dt", "stEffDt");
        this.hashFields.put("end_eff_dt", "endEffDt");
        this.hashFields.put("co_cd", "coCd");
        this.hashFields.put("fdr_div_cd", "fdrDivCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("modi_vsl_slan_cd", "modiVslSlanCd");
        this.hashFields.put("insf_id", "insfId");
        this.hashFields.put("insf_prs_id", "insfPrsId");
        this.hashFields.put("insf_dttm", "insfDttm");
        this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
        this.hashFields.put("insf_dv_cd", "insfDvCd");
        this.hashFields.put("insf_cnqe_cont", "insfCnqeCont");
        this.hashFields.put("ecom_insf_id", "ecomInsfId");
        this.hashFields.put("ecom_insf_prs_id", "ecomInsfPrsId");
        this.hashFields.put("ecom_insf_dttm", "ecomInsfDttm");
        this.hashFields.put("ecom_insf_cnqe_val", "ecomInsfCnqeVal");
        this.hashFields.put("ecom_insf_dv_cd", "ecomInsfDvCd");
        this.hashFields.put("ecom_insf_cnqe_cont", "ecomInsfCnqeCont");
        this.hashFields.put("ocedi_insf_id", "ocediInsfId");
        this.hashFields.put("ocedi_insf_prs_id", "ocediInsfPrsId");
        this.hashFields.put("ocedi_insf_dttm", "ocediInsfDttm");
        this.hashFields.put("ocedi_insf_cnqe_val", "ocediInsfCnqeVal");
        this.hashFields.put("ocedi_insf_dv_cd", "ocediInsfDvCd");
        this.hashFields.put("ocedi_insf_cnqe_cont", "ocediInsfCnqeCont");
        this.hashFields.put("vsl_slan_if_seq", "vslSlanIfSeq");
		this.hashFields.put("opedi_insf_id", "opediInsfId");
        this.hashFields.put("opedi_insf_dv_cd", "opediInsfDvCd");
        this.hashFields.put("modi_vsl_slan_cd2", "modiVslSlanCd2");
        this.hashFields.put("modi_vip_team_cd", "modiVipTeamCd");
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
	 * @param String vslSlanCd
	 */
    public void setVslSlanCd(String vslSlanCd) {
        this.vslSlanCd = vslSlanCd;
    }

    /**
	 * 
	 * @return String vslSlanCd
	 */
    public String getVslSlanCd() {
        return this.vslSlanCd;
    }

    /**
	 *
	 * @param String vslSlanNm
	 */
    public void setVslSlanNm(String vslSlanNm) {
        this.vslSlanNm = vslSlanNm;
    }

    /**
	 * 
	 * @return String vslSlanNm
	 */
    public String getVslSlanNm() {
        return this.vslSlanNm;
    }

    /**
	 *
	 * @param String vslSvcTpCd
	 */
    public void setVslSvcTpCd(String vslSvcTpCd) {
        this.vslSvcTpCd = vslSvcTpCd;
    }

    /**
	 * 
	 * @return String vslSvcTpCd
	 */
    public String getVslSvcTpCd() {
        return this.vslSvcTpCd;
    }

    /**
	 *
	 * @param String vslTpCd
	 */
    public void setVslTpCd(String vslTpCd) {
        this.vslTpCd = vslTpCd;
    }

    /**
	 * 
	 * @return String vslTpCd
	 */
    public String getVslTpCd() {
        return this.vslTpCd;
    }

    /**
	 *
	 * @param String stEffDt
	 */
    public void setStEffDt(String stEffDt) {
        this.stEffDt = stEffDt;
    }

    /**
	 * 
	 * @return String stEffDt
	 */
    public String getStEffDt() {
        return this.stEffDt;
    }

    /**
	 *
	 * @param String endEffDt
	 */
    public void setEndEffDt(String endEffDt) {
        this.endEffDt = endEffDt;
    }

    /**
	 * 
	 * @return String endEffDt
	 */
    public String getEndEffDt() {
        return this.endEffDt;
    }

    /**
	 *
	 * @param String coCd
	 */
    public void setCoCd(String coCd) {
        this.coCd = coCd;
    }

    /**
	 * 
	 * @return String coCd
	 */
    public String getCoCd() {
        return this.coCd;
    }

    /**
	 *
	 * @param String fdrDivCd
	 */
    public void setFdrDivCd(String fdrDivCd) {
        this.fdrDivCd = fdrDivCd;
    }

    /**
	 * 
	 * @return String fdrDivCd
	 */
    public String getFdrDivCd() {
        return this.fdrDivCd;
    }

    /**
	 *
	 * @param String creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * 
	 * @return String creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 *
	 * @param String creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * 
	 * @return String creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 *
	 * @param String updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * 
	 * @return String updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    /**
	 *
	 * @param String updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * 
	 * @return String updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 *
	 * @param String deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * 
	 * @return String deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 *
	 * @param String modiVslSlanCd
	 */
    public void setModiVslSlanCd(String modiVslSlanCd) {
        this.modiVslSlanCd = modiVslSlanCd;
    }

    /**
	 * 
	 * @return String modiVslSlanCd
	 */
    public String getModiVslSlanCd() {
        return this.modiVslSlanCd;
    }
    
    /**
	 *
	 * @param String modiVslSlanCd2
	 */
   public void setModiVslSlanCd2(String modiVslSlanCd2) {
       this.modiVslSlanCd2 = modiVslSlanCd2;
   }

   /**
	 * 
	 * @return String modiVslSlanCd2
	 */
   public String getModiVslSlanCd2() {
       return this.modiVslSlanCd2;
   }

    public void setEcomInsfId(String ecomInsfId) {
        this.ecomInsfId = ecomInsfId;
    }

    public String getEcomInsfId() {
        return this.ecomInsfId;
    }

    public void setEcomInsfPrsId(String ecomInsfPrsId) {
        this.ecomInsfPrsId = ecomInsfPrsId;
    }

    public String getEcomInsfPrsId() {
        return this.ecomInsfPrsId;
    }

    public void setEcomInsfDttm(String ecomInsfDttm) {
        this.ecomInsfDttm = ecomInsfDttm;
    }

    public String getEcomInsfDttm() {
        return this.ecomInsfDttm;
    }

    public void setEcomInsfCnqeVal(String ecomInsfCnqeVal) {
        this.ecomInsfCnqeVal = ecomInsfCnqeVal;
    }

    public String getEcomInsfCnqeVal() {
        return this.ecomInsfCnqeVal;
    }

    public void setEcomInsfDvCd(String ecomInsfDvCd) {
        this.ecomInsfDvCd = ecomInsfDvCd;
    }

    public String getEcomInsfDvCd() {
        return this.ecomInsfDvCd;
    }

    public void setEcomInsfCnqeCont(String ecomInsfCnqeCont) {
        this.ecomInsfCnqeCont = ecomInsfCnqeCont;
    }

    public String getEcomInsfCnqeCont() {
        return this.ecomInsfCnqeCont;
    }

    public void setOcediInsfId(String ocediInsfId) {
        this.ocediInsfId = ocediInsfId;
    }

    public String getOcediInsfId() {
        return this.ocediInsfId;
    }

    public void setOcediInsfPrsId(String ocediInsfPrsId) {
        this.ocediInsfPrsId = ocediInsfPrsId;
    }

    public String getOcediInsfPrsId() {
        return this.ocediInsfPrsId;
    }

    public void setOcediInsfDttm(String ocediInsfDttm) {
        this.ocediInsfDttm = ocediInsfDttm;
    }

    public String getOcediInsfDttm() {
        return this.ocediInsfDttm;
    }

    public void setOcediInsfCnqeVal(String ocediInsfCnqeVal) {
        this.ocediInsfCnqeVal = ocediInsfCnqeVal;
    }

    public String getOcediInsfCnqeVal() {
        return this.ocediInsfCnqeVal;
    }

    public void setOcediInsfDvCd(String ocediInsfDvCd) {
        this.ocediInsfDvCd = ocediInsfDvCd;
    }

    public String getOcediInsfDvCd() {
        return this.ocediInsfDvCd;
    }

    public void setOcediInsfCnqeCont(String ocediInsfCnqeCont) {
        this.ocediInsfCnqeCont = ocediInsfCnqeCont;
    }

    public String getOcediInsfCnqeCont() {
        return this.ocediInsfCnqeCont;
    }

    public void setVslSlanIfSeq(String vslSlanIfSeq) {
        this.vslSlanIfSeq = vslSlanIfSeq;
    }

    public String getVslSlanIfSeq() {
        return this.vslSlanIfSeq;
    }

	public String getOpediInsfId() {
		return opediInsfId;
	}

	public void setOpediInsfId(String opediInsfId) {
		this.opediInsfId = opediInsfId;
	}

    public void setOpediInsfDvCd(String opediInsfDvCd) {
        this.opediInsfDvCd = opediInsfDvCd;
    }

    public String getOpediInsfDvCd() {
        return this.opediInsfDvCd;
    }

    public String getModiVipTeamCd() {
		return modiVipTeamCd;
	}

	public void setModiVipTeamCd(String modiVipTeamCd) {
		this.modiVipTeamCd = modiVipTeamCd;
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
        setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
        setVslSlanNm(JSPUtil.getParameter(request, prefix + "vsl_slan_nm", ""));
        setVslSvcTpCd(JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd", ""));
        setVslTpCd(JSPUtil.getParameter(request, prefix + "vsl_tp_cd", ""));
        setStEffDt(JSPUtil.getParameter(request, prefix + "st_eff_dt", ""));
        setEndEffDt(JSPUtil.getParameter(request, prefix + "end_eff_dt", ""));
        setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
        setFdrDivCd(JSPUtil.getParameter(request, prefix + "fdr_div_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setModiVslSlanCd(JSPUtil.getParameter(request, prefix + "modi_vsl_slan_cd", ""));
        setEcomInsfId(JSPUtil.getParameter(request, prefix + "ecom_insf_id", ""));
        setEcomInsfPrsId(JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", ""));
        setEcomInsfDttm(JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", ""));
        setEcomInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", ""));
        setEcomInsfDvCd(JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", ""));
        setEcomInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", ""));
        setOcediInsfId(JSPUtil.getParameter(request, prefix + "ocedi_insf_id", ""));
        setOcediInsfPrsId(JSPUtil.getParameter(request, prefix + "ocedi_insf_prs_id", ""));
        setOcediInsfDttm(JSPUtil.getParameter(request, prefix + "ocedi_insf_dttm", ""));
        setOcediInsfCnqeVal(JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_val", ""));
        setOcediInsfDvCd(JSPUtil.getParameter(request, prefix + "ocedi_insf_dv_cd", ""));
        setOcediInsfCnqeCont(JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_cont", ""));
        setVslSlanIfSeq(JSPUtil.getParameter(request, prefix + "vsl_slan_if_seq", ""));
		setOpediInsfId(JSPUtil.getParameter(request, prefix + "opedi_insf_id", ""));
        setOpediInsfDvCd(JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", ""));
        setModiVslSlanCd2(JSPUtil.getParameter(request, prefix + "modi_vsl_slan_cd2", ""));
        setModiVipTeamCd(JSPUtil.getParameter(request, prefix + "modi_vip_team_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SLaneIfVO[]
	 */
    public SLaneIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SLaneIfVO[]
	 */
    public SLaneIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SLaneIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslSlanCd = (JSPUtil.getParameter(request, prefix + "vsl_slan_cd", length));
            String[] vslSlanNm = (JSPUtil.getParameter(request, prefix + "vsl_slan_nm", length));
            String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd", length));
            String[] vslTpCd = (JSPUtil.getParameter(request, prefix + "vsl_tp_cd", length));
            String[] stEffDt = (JSPUtil.getParameter(request, prefix + "st_eff_dt", length));
            String[] endEffDt = (JSPUtil.getParameter(request, prefix + "end_eff_dt", length));
            String[] coCd = (JSPUtil.getParameter(request, prefix + "co_cd", length));
            String[] fdrDivCd = (JSPUtil.getParameter(request, prefix + "fdr_div_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] modiVslSlanCd = (JSPUtil.getParameter(request, prefix + "modi_vsl_slan_cd", length));
            String[] ecomInsfId = (JSPUtil.getParameter(request, prefix + "ecom_insf_id", length));
            String[] ecomInsfPrsId = (JSPUtil.getParameter(request, prefix + "ecom_insf_prs_id", length));
            String[] ecomInsfDttm = (JSPUtil.getParameter(request, prefix + "ecom_insf_dttm", length));
            String[] ecomInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_val", length));
            String[] ecomInsfDvCd = (JSPUtil.getParameter(request, prefix + "ecom_insf_dv_cd", length));
            String[] ecomInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ecom_insf_cnqe_cont", length));
            String[] ocediInsfId = (JSPUtil.getParameter(request, prefix + "ocedi_insf_id", length));
            String[] ocediInsfPrsId = (JSPUtil.getParameter(request, prefix + "ocedi_insf_prs_id", length));
            String[] ocediInsfDttm = (JSPUtil.getParameter(request, prefix + "ocedi_insf_dttm", length));
            String[] ocediInsfCnqeVal = (JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_val", length));
            String[] ocediInsfDvCd = (JSPUtil.getParameter(request, prefix + "ocedi_insf_dv_cd", length));
            String[] ocediInsfCnqeCont = (JSPUtil.getParameter(request, prefix + "ocedi_insf_cnqe_cont", length));
            String[] vslSlanIfSeq = (JSPUtil.getParameter(request, prefix + "vsl_slan_if_seq", length));
			String[] opediInsfId = (JSPUtil.getParameter(request, prefix	+ "opedi_insf_id", length));
	    	String[] opediInsfDvCd = (JSPUtil.getParameter(request, prefix + "opedi_insf_dv_cd", length));
	    	String[] modiVslSlanCd2 = (JSPUtil.getParameter(request, prefix + "modi_vsl_slan_cd2", length));
	    	String[] modiVipTeamCd = (JSPUtil.getParameter(request, prefix + "modi_vip_team_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SLaneIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslSlanCd[i] != null)
                    model.setVslSlanCd(vslSlanCd[i]);
                if (vslSlanNm[i] != null)
                    model.setVslSlanNm(vslSlanNm[i]);
                if (vslSvcTpCd[i] != null)
                    model.setVslSvcTpCd(vslSvcTpCd[i]);
                if (vslTpCd[i] != null)
                    model.setVslTpCd(vslTpCd[i]);
                if (stEffDt[i] != null)
                    model.setStEffDt(stEffDt[i]);
                if (endEffDt[i] != null)
                    model.setEndEffDt(endEffDt[i]);
                if (coCd[i] != null)
                    model.setCoCd(coCd[i]);
                if (fdrDivCd[i] != null)
                    model.setFdrDivCd(fdrDivCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (modiVslSlanCd[i] != null)
                    model.setModiVslSlanCd(modiVslSlanCd[i]);
                if (ecomInsfId[i] != null)
                    model.setEcomInsfId(ecomInsfId[i]);
                if (ecomInsfPrsId[i] != null)
                    model.setEcomInsfPrsId(ecomInsfPrsId[i]);
                if (ecomInsfDttm[i] != null)
                    model.setEcomInsfDttm(ecomInsfDttm[i]);
                if (ecomInsfCnqeVal[i] != null)
                    model.setEcomInsfCnqeVal(ecomInsfCnqeVal[i]);
                if (ecomInsfDvCd[i] != null)
                    model.setEcomInsfDvCd(ecomInsfDvCd[i]);
                if (ecomInsfCnqeCont[i] != null)
                    model.setEcomInsfCnqeCont(ecomInsfCnqeCont[i]);
                if (ocediInsfId[i] != null)
                    model.setOcediInsfId(ocediInsfId[i]);
                if (ocediInsfPrsId[i] != null)
                    model.setOcediInsfPrsId(ocediInsfPrsId[i]);
                if (ocediInsfDttm[i] != null)
                    model.setOcediInsfDttm(ocediInsfDttm[i]);
                if (ocediInsfCnqeVal[i] != null)
                    model.setOcediInsfCnqeVal(ocediInsfCnqeVal[i]);
                if (ocediInsfDvCd[i] != null)
                    model.setOcediInsfDvCd(ocediInsfDvCd[i]);
                if (ocediInsfCnqeCont[i] != null)
                    model.setOcediInsfCnqeCont(ocediInsfCnqeCont[i]);
                if (vslSlanIfSeq[i] != null) 
		    		model.setVslSlanIfSeq(vslSlanIfSeq[i]);
				if (opediInsfId[i] != null)
					model.setOpediInsfId(opediInsfId[i]);
				if (opediInsfDvCd[i] != null) 
		    		model.setOpediInsfDvCd(opediInsfDvCd[i]);
				if (modiVslSlanCd2[i] != null)
                    model.setModiVslSlanCd2(modiVslSlanCd2[i]);
				if (modiVipTeamCd[i] != null)
                    model.setModiVipTeamCd(modiVipTeamCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSLaneIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SLaneIfVO[]
	 */
    public SLaneIfVO[] getSLaneIfVOs() {
        SLaneIfVO[] vos = (SLaneIfVO[]) models.toArray(new SLaneIfVO[models.size()]);
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
        this.vslSlanCd = this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanNm = this.vslSlanNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSvcTpCd = this.vslSvcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslTpCd = this.vslTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stEffDt = this.stEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.endEffDt = this.endEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coCd = this.coCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fdrDivCd = this.fdrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiVslSlanCd = this.modiVslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfId = this.ecomInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfPrsId = this.ecomInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDttm = this.ecomInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeVal = this.ecomInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfDvCd = this.ecomInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ecomInsfCnqeCont = this.ecomInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfId = this.ocediInsfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfPrsId = this.ocediInsfPrsId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfDttm = this.ocediInsfDttm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfCnqeVal = this.ocediInsfCnqeVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfDvCd = this.ocediInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocediInsfCnqeCont = this.ocediInsfCnqeCont.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSlanIfSeq = this.vslSlanIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opediInsfId = this.opediInsfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opediInsfDvCd = this.opediInsfDvCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiVslSlanCd2 = this.modiVslSlanCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiVipTeamCd = this.modiVipTeamCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
