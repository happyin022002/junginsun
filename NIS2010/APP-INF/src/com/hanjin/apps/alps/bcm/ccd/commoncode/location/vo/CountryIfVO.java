/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CountryIfVO.java
*@FileTitle : CountryIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo;
  
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
public class CountryIfVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CountryIfVO> models = new ArrayList<CountryIfVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cntIfSeq = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String cntNm = null;

    /* Column Info */
    private String scontiCd = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String cntIsoCd = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

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
    private String euCntFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public CountryIfVO() {
    }

    public CountryIfVO(String ibflag, String pagerows, String cntIfSeq, String cntCd, String cntNm, String scontiCd, String currCd, String cntIsoCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String insfCnqeCont, String ecomInsfId, String ecomInsfPrsId, String ecomInsfDttm, String ecomInsfCnqeVal, String ecomInsfDvCd, String ecomInsfCnqeCont, String ocediInsfId, String ocediInsfPrsId, String ocediInsfDttm, String ocediInsfCnqeVal, String ocediInsfDvCd, String ocediInsfCnqeCont, String euCntFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.cntIfSeq = cntIfSeq;
        this.cntCd = cntCd;
        this.cntNm = cntNm;
        this.scontiCd = scontiCd;
        this.currCd = currCd;
        this.cntIsoCd = cntIsoCd;
        this.deltFlg = deltFlg;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
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
        this.euCntFlg = euCntFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cnt_if_seq", getCntIfSeq());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("cnt_nm", getCntNm());
        this.hashColumns.put("sconti_cd", getScontiCd());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("cnt_iso_cd", getCntIsoCd());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
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
        this.hashColumns.put("eu_cnt_flg", getEuCntFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cnt_if_seq", "cntIfSeq");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("cnt_nm", "cntNm");
        this.hashFields.put("sconti_cd", "scontiCd");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("cnt_iso_cd", "cntIsoCd");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
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
        this.hashFields.put("eu_cnt_flg", "euCntFlg");
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
	 * @param String cntIfSeq
	 */
    public void setCntIfSeq(String cntIfSeq) {
        this.cntIfSeq = cntIfSeq;
    }

    /**
	 * 
	 * @return String cntIfSeq
	 */
    public String getCntIfSeq() {
        return this.cntIfSeq;
    }

    /**
	 *
	 * @param String cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
    }

    /**
	 * 
	 * @return String cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
    }

    /**
	 *
	 * @param String cntNm
	 */
    public void setCntNm(String cntNm) {
        this.cntNm = cntNm;
    }

    /**
	 * 
	 * @return String cntNm
	 */
    public String getCntNm() {
        return this.cntNm;
    }

    /**
	 *
	 * @param String scontiCd
	 */
    public void setScontiCd(String scontiCd) {
        this.scontiCd = scontiCd;
    }

    /**
	 * 
	 * @return String scontiCd
	 */
    public String getScontiCd() {
        return this.scontiCd;
    }

    /**
	 *
	 * @param String currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * 
	 * @return String currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 *
	 * @param String cntIsoCd
	 */
    public void setCntIsoCd(String cntIsoCd) {
        this.cntIsoCd = cntIsoCd;
    }

    /**
	 * 
	 * @return String cntIsoCd
	 */
    public String getCntIsoCd() {
        return this.cntIsoCd;
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

    public String getEuCntFlg() {
		return euCntFlg;
	}

	public void setEuCntFlg(String euCntFlg) {
		this.euCntFlg = euCntFlg;
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
        setCntIfSeq(JSPUtil.getParameter(request, prefix + "cnt_if_seq", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
        setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setCntIsoCd(JSPUtil.getParameter(request, prefix + "cnt_iso_cd", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
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
        setEuCntFlg(JSPUtil.getParameter(request, prefix + "eu_cnt_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CountryIfVO[]
	 */
    public CountryIfVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CountryIfVO[]
	 */
    public CountryIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CountryIfVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cntIfSeq = (JSPUtil.getParameter(request, prefix + "cnt_if_seq", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] cntNm = (JSPUtil.getParameter(request, prefix + "cnt_nm", length));
            String[] scontiCd = (JSPUtil.getParameter(request, prefix + "sconti_cd", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] cntIsoCd = (JSPUtil.getParameter(request, prefix + "cnt_iso_cd", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
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
	    	String[] euCntFlg = (JSPUtil.getParameter(request, prefix + "eu_cnt_flg", length));
	    	
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CountryIfVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cntIfSeq[i] != null)
                    model.setCntIfSeq(cntIfSeq[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (cntNm[i] != null)
                    model.setCntNm(cntNm[i]);
                if (scontiCd[i] != null)
                    model.setScontiCd(scontiCd[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (cntIsoCd[i] != null)
                    model.setCntIsoCd(cntIsoCd[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
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
				if (euCntFlg[i] != null) 
		    		model.setEuCntFlg(euCntFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCountryIfVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CountryIfVO[]
	 */
    public CountryIfVO[] getCountryIfVOs() {
        CountryIfVO[] vos = (CountryIfVO[]) models.toArray(new CountryIfVO[models.size()]);
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
        this.cntIfSeq = this.cntIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntNm = this.cntNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scontiCd = this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntIsoCd = this.cntIsoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
        this.euCntFlg = this.euCntFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
