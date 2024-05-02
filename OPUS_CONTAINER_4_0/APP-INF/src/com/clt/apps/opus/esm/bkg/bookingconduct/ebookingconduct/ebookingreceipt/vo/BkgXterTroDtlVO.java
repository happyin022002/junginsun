/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgXterTroDtlVO.java
*@FileTitle : BkgXterTroDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.29 전용진 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgXterTroDtlVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgXterTroDtlVO> models = new ArrayList<BkgXterTroDtlVO>();

    /* Column Info */
    private String troSubSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String troSeq = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String cntrQty = null;

    /* Column Info */
    private String dorRqstDt = null;

    /* Column Info */
    private String pkupDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String xterSndrId = null;

    /* Column Info */
    private String xterRqstNo = null;

    /* Column Info */
    private String xterRqstSeq = null;

    /* Column Info */
    private String bkgTrspModCd = null;

    /* Column Info */
    private String custRefNo = null;

    /* Column Info */
    private String pkupLocCd = null;

    /* Column Info */
    private String pkupYdCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String eurTroDorZipId = null;

    /* Column Info */
    private String eurTroDorAddr = null;

    /* Column Info */
    private String eurTroCntcPsonNm = null;

    /* Column Info */
    private String eurTroCntcPhnNo = null;

    /* Column Info */
    private String eurTroCntcEml = null;

    /* Column Info */
    private String pkupLocNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgXterTroDtlVO() {
    }

    public BkgXterTroDtlVO(String ibflag, String pagerows, String troSeq, String troSubSeq, String cntrTpszCd, String cntrQty, String dorRqstDt, String pkupDt, String xterSndrId, String xterRqstNo, String xterRqstSeq, String bkgTrspModCd, String custRefNo, String pkupLocCd, String pkupYdCd, String creUsrId, String creDt, String updUsrId, String updDt, String eurTroDorZipId, String eurTroDorAddr, String eurTroCntcPsonNm, String eurTroCntcPhnNo, String eurTroCntcEml, String pkupLocNm) {
        this.troSubSeq = troSubSeq;
        this.ibflag = ibflag;
        this.troSeq = troSeq;
        this.cntrTpszCd = cntrTpszCd;
        this.cntrQty = cntrQty;
        this.dorRqstDt = dorRqstDt;
        this.pagerows = pagerows;
        this.pkupDt = pkupDt;
        this.xterSndrId = xterSndrId;
        this.xterRqstNo = xterRqstNo;
        this.xterRqstSeq = xterRqstSeq;
        this.bkgTrspModCd = bkgTrspModCd;
        this.custRefNo = custRefNo;
        this.pkupLocCd = pkupLocCd;
        this.pkupYdCd = pkupYdCd;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.eurTroDorZipId = eurTroDorZipId;
        this.eurTroDorAddr = eurTroDorAddr;
        this.eurTroCntcPsonNm = eurTroCntcPsonNm;
        this.eurTroCntcPhnNo = eurTroCntcPhnNo;
        this.eurTroCntcEml = eurTroCntcEml;
        this.pkupLocNm = pkupLocNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("tro_sub_seq", getTroSubSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("tro_seq", getTroSeq());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("cntr_qty", getCntrQty());
        this.hashColumns.put("dor_rqst_dt", getDorRqstDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pkup_dt", getPkupDt());
        this.hashColumns.put("xter_sndr_id", getXterSndrId());
        this.hashColumns.put("xter_rqst_no", getXterRqstNo());
        this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
        this.hashColumns.put("bkg_trsp_mod_cd", getBkgTrspModCd());
        this.hashColumns.put("cust_ref_no", getCustRefNo());
        this.hashColumns.put("pkup_loc_cd", getPkupLocCd());
        this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("eur_tro_dor_zip_id", getEurTroDorZipId());
        this.hashColumns.put("eur_tro_dor_addr", getEurTroDorAddr());
        this.hashColumns.put("eur_tro_cntc_pson_nm", getEurTroCntcPsonNm());
        this.hashColumns.put("eur_tro_cntc_phn_no", getEurTroCntcPhnNo());
        this.hashColumns.put("eur_tro_cntc_eml", getEurTroCntcEml());
        this.hashColumns.put("pkup_loc_nm", getPkupLocNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("tro_sub_seq", "troSubSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("tro_seq", "troSeq");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("cntr_qty", "cntrQty");
        this.hashFields.put("dor_rqst_dt", "dorRqstDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pkup_dt", "pkupDt");
        this.hashFields.put("xter_sndr_id", "xterSndrId");
        this.hashFields.put("xter_rqst_no", "xterRqstNo");
        this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
        this.hashFields.put("bkg_trsp_mod_cd", "bkgTrspModCd");
        this.hashFields.put("cust_ref_no", "custRefNo");
        this.hashFields.put("pkup_loc_cd", "pkupLocCd");
        this.hashFields.put("pkup_yd_cd", "pkupYdCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("eur_tro_dor_zip_id", "eurTroDorZipId");
        this.hashFields.put("eur_tro_dor_addr", "eurTroDorAddr");
        this.hashFields.put("eur_tro_cntc_pson_nm", "eurTroCntcPsonNm");
        this.hashFields.put("eur_tro_cntc_phn_no", "eurTroCntcPhnNo");
        this.hashFields.put("eur_tro_cntc_eml", "eurTroCntcEml");
        this.hashFields.put("pkup_loc_nm", "pkupLocNm");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return troSubSeq
	 */
    public String getTroSubSeq() {
        return this.troSubSeq;
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
	 * @return troSeq
	 */
    public String getTroSeq() {
        return this.troSeq;
    }

    /**
	 * Column Info
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 * Column Info
	 * @return cntrQty
	 */
    public String getCntrQty() {
        return this.cntrQty;
    }

    /**
	 * Column Info
	 * @return dorRqstDt
	 */
    public String getDorRqstDt() {
        return this.dorRqstDt;
    }

    /**
	 * Column Info
	 * @return pkupDt
	 */
    public String getPkupDt() {
        return this.pkupDt;
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
	 * @param troSubSeq
	 */
    public void setTroSubSeq(String troSubSeq) {
        this.troSubSeq = troSubSeq;
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
	 * @param troSeq
	 */
    public void setTroSeq(String troSeq) {
        this.troSeq = troSeq;
    }

    /**
	 * Column Info
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * Column Info
	 * @param cntrQty
	 */
    public void setCntrQty(String cntrQty) {
        this.cntrQty = cntrQty;
    }

    /**
	 * Column Info
	 * @param dorRqstDt
	 */
    public void setDorRqstDt(String dorRqstDt) {
        this.dorRqstDt = dorRqstDt;
    }

    /**
	 * Column Info
	 * @param pkupDt
	 */
    public void setPkupDt(String pkupDt) {
        this.pkupDt = pkupDt;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setXterSndrId(String xterSndrId) {
        this.xterSndrId = xterSndrId;
    }

    public String getXterSndrId() {
        return this.xterSndrId;
    }

    public void setXterRqstNo(String xterRqstNo) {
        this.xterRqstNo = xterRqstNo;
    }

    public String getXterRqstNo() {
        return this.xterRqstNo;
    }

    public void setXterRqstSeq(String xterRqstSeq) {
        this.xterRqstSeq = xterRqstSeq;
    }

    public String getXterRqstSeq() {
        return this.xterRqstSeq;
    }

    public void setBkgTrspModCd(String bkgTrspModCd) {
        this.bkgTrspModCd = bkgTrspModCd;
    }

    public String getBkgTrspModCd() {
        return this.bkgTrspModCd;
    }

    public void setCustRefNo(String custRefNo) {
        this.custRefNo = custRefNo;
    }

    public String getCustRefNo() {
        return this.custRefNo;
    }

    public void setPkupLocCd(String pkupLocCd) {
        this.pkupLocCd = pkupLocCd;
    }

    public String getPkupLocCd() {
        return this.pkupLocCd;
    }

    public void setPkupYdCd(String pkupYdCd) {
        this.pkupYdCd = pkupYdCd;
    }

    public String getPkupYdCd() {
        return this.pkupYdCd;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setEurTroDorZipId(String eurTroDorZipId) {
        this.eurTroDorZipId = eurTroDorZipId;
    }

    public String getEurTroDorZipId() {
        return this.eurTroDorZipId;
    }

    public void setEurTroDorAddr(String eurTroDorAddr) {
        this.eurTroDorAddr = eurTroDorAddr;
    }

    public String getEurTroDorAddr() {
        return this.eurTroDorAddr;
    }

    public void setEurTroCntcPsonNm(String eurTroCntcPsonNm) {
        this.eurTroCntcPsonNm = eurTroCntcPsonNm;
    }

    public String getEurTroCntcPsonNm() {
        return this.eurTroCntcPsonNm;
    }

    public void setEurTroCntcPhnNo(String eurTroCntcPhnNo) {
        this.eurTroCntcPhnNo = eurTroCntcPhnNo;
    }

    public String getEurTroCntcPhnNo() {
        return this.eurTroCntcPhnNo;
    }

    public void setEurTroCntcEml(String eurTroCntcEml) {
        this.eurTroCntcEml = eurTroCntcEml;
    }

    public String getEurTroCntcEml() {
        return this.eurTroCntcEml;
    }

    /**
	 * Column Info
	 * @return pkupLocNm
	 */
    public String getPkupLocNm() {
        return this.pkupLocNm;
    }

    /**
	 * Column Info
	 * @param pkupLocNm
	 */
    public void setPkupLocNm(String pkupLocNm) {
        this.pkupLocNm = pkupLocNm;
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
        setTroSubSeq(JSPUtil.getParameter(request, prefix + "tro_sub_seq", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
        setDorRqstDt(JSPUtil.getParameter(request, prefix + "dor_rqst_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPkupDt(JSPUtil.getParameter(request, prefix + "pkup_dt", ""));
        setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
        setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
        setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
        setBkgTrspModCd(JSPUtil.getParameter(request, prefix + "bkg_trsp_mod_cd", ""));
        setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
        setPkupLocCd(JSPUtil.getParameter(request, prefix + "pkup_loc_cd", ""));
        setPkupYdCd(JSPUtil.getParameter(request, prefix + "pkup_yd_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setEurTroDorZipId(JSPUtil.getParameter(request, prefix + "eur_tro_dor_zip_id", ""));
        setEurTroDorAddr(JSPUtil.getParameter(request, prefix + "eur_tro_dor_addr", ""));
        setEurTroCntcPsonNm(JSPUtil.getParameter(request, prefix + "eur_tro_cntc_pson_nm", ""));
        setEurTroCntcPhnNo(JSPUtil.getParameter(request, prefix + "eur_tro_cntc_phn_no", ""));
        setEurTroCntcEml(JSPUtil.getParameter(request, prefix + "eur_tro_cntc_eml", ""));
        setPkupLocNm(JSPUtil.getParameter(request, prefix + "pkup_loc_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterTroDtlVO[]
	 */
    public BkgXterTroDtlVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterTroDtlVO[]
	 */
    public BkgXterTroDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgXterTroDtlVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] troSubSeq = (JSPUtil.getParameter(request, prefix + "tro_sub_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] troSeq = (JSPUtil.getParameter(request, prefix + "tro_seq", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] cntrQty = (JSPUtil.getParameter(request, prefix + "cntr_qty", length));
            String[] dorRqstDt = (JSPUtil.getParameter(request, prefix + "dor_rqst_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pkupDt = (JSPUtil.getParameter(request, prefix + "pkupDt", length));
            String[] xterSndrId = (JSPUtil.getParameter(request, prefix + "xter_sndr_id", length));
	    	String[] xterRqstNo = (JSPUtil.getParameter(request, prefix + "xter_rqst_no", length));
	    	String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_seq", length));
	    	String[] bkgTrspModCd = (JSPUtil.getParameter(request, prefix + "bkg_trsp_mod_cd", length));
	    	String[] custRefNo = (JSPUtil.getParameter(request, prefix + "cust_ref_no", length));
	    	String[] pkupLocCd = (JSPUtil.getParameter(request, prefix + "pkup_loc_cd", length));
	    	String[] pkupYdCd = (JSPUtil.getParameter(request, prefix + "pkup_yd_cd", length));
	    	String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
	    	String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
	    	String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
	    	String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
	    	String[] eurTroDorZipId = (JSPUtil.getParameter(request, prefix + "eur_tro_dor_zip_id", length));
	    	String[] eurTroDorAddr = (JSPUtil.getParameter(request, prefix + "eur_tro_dor_addr", length));
	    	String[] eurTroCntcPsonNm = (JSPUtil.getParameter(request, prefix + "eur_tro_cntc_pson_nm", length));
	    	String[] eurTroCntcPhnNo = (JSPUtil.getParameter(request, prefix + "eur_tro_cntc_phn_no", length));
	    	String[] eurTroCntcEml = (JSPUtil.getParameter(request, prefix + "eur_tro_cntc_eml", length));
	    	String[] pkupLocNm = (JSPUtil.getParameter(request, prefix + "pkup_loc_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgXterTroDtlVO();
                if (troSubSeq[i] != null)
                    model.setTroSubSeq(troSubSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (troSeq[i] != null)
                    model.setTroSeq(troSeq[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (cntrQty[i] != null)
                    model.setCntrQty(cntrQty[i]);
                if (dorRqstDt[i] != null)
                    model.setDorRqstDt(dorRqstDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pkupDt[i] != null)
                    model.setPkupDt(pkupDt[i]);
                if (xterSndrId[i] != null) 
		    		model.setXterSndrId(xterSndrId[i]);
				if (xterRqstNo[i] != null) 
		    		model.setXterRqstNo(xterRqstNo[i]);
				if (xterRqstSeq[i] != null) 
		    		model.setXterRqstSeq(xterRqstSeq[i]);
				if (bkgTrspModCd[i] != null) 
		    		model.setBkgTrspModCd(bkgTrspModCd[i]);
				if (custRefNo[i] != null) 
		    		model.setCustRefNo(custRefNo[i]);
				if (pkupLocCd[i] != null) 
		    		model.setPkupLocCd(pkupLocCd[i]);
				if (pkupYdCd[i] != null) 
		    		model.setPkupYdCd(pkupYdCd[i]);
				if (creUsrId[i] != null) 
		    		model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
		    		model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
		    		model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
		    		model.setUpdDt(updDt[i]);
				if (eurTroDorZipId[i] != null) 
		    		model.setEurTroDorZipId(eurTroDorZipId[i]);
				if (eurTroDorAddr[i] != null) 
		    		model.setEurTroDorAddr(eurTroDorAddr[i]);
				if (eurTroCntcPsonNm[i] != null) 
		    		model.setEurTroCntcPsonNm(eurTroCntcPsonNm[i]);
				if (eurTroCntcPhnNo[i] != null) 
		    		model.setEurTroCntcPhnNo(eurTroCntcPhnNo[i]);
				if (eurTroCntcEml[i] != null) 
		    		model.setEurTroCntcEml(eurTroCntcEml[i]);
				if (pkupLocNm[i] != null) 
		    		model.setPkupLocNm(pkupLocNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgXterTroDtlVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgXterTroDtlVO[]
	 */
    public BkgXterTroDtlVO[] getBkgXterTroDtlVOs() {
        BkgXterTroDtlVO[] vos = (BkgXterTroDtlVO[]) models.toArray(new BkgXterTroDtlVO[models.size()]);
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
        this.troSubSeq = this.troSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troSeq = this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrQty = this.cntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dorRqstDt = this.dorRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupDt = this.pkupDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSndrId = this.xterSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstNo = this.xterRqstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstSeq = this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTrspModCd = this.bkgTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custRefNo = this.custRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupLocCd = this.pkupLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupYdCd = this.pkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eurTroDorZipId = this.eurTroDorZipId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eurTroDorAddr = this.eurTroDorAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eurTroCntcPsonNm = this.eurTroCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eurTroCntcPhnNo = this.eurTroCntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eurTroCntcEml = this.eurTroCntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pkupLocNm = this.pkupLocNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
