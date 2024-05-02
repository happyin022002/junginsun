/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgBlNoVO.java
*@FileTitle : BkgBlNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.04.01 이진서 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.11.16 김보배 [CHM-201221290] [BKG] B/L Issue 화면에 B/L HOLD 기능 추가 & B/L Status Report 기능 보완 (NSC #2 & #3)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgBlNoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgBlNoVO> models = new ArrayList<BkgBlNoVO>();

    /* Column Info */
    private String ncbNo = null;

    /* Column Info */
    private String caExistFlg = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String mapSeq = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String blTpCd = null;

    /* Column Info */
    private String pctlNo = null;

    /* Column Info */
    private String pageType = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String blNoChk = null;

    /* Column Info */
    private String applicationDate = null;

    /* Column Info */
    private String caNo = null;

    /* Column Info */
    private String caFlg = null;

    /* Column Info */
    private String caUsrId = null;

    /* Column Info */
    private String oblIssFlg = null;

    /* Column Info */
    private String blHldFlg = null;

    /* Column Info */
    private String blHldRsnCd = null;

    /* Column Info */
    private String blHldDt = null;

    /* Column Info */
    private String blHldUsrId = null;

    /* Column Info */
    private String docType = null;

    /* Column Info */
    private String uiId = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgBlNoVO() {
    }

    public BkgBlNoVO(String ibflag, String pagerows, String ncbNo, String caExistFlg, String bdrFlg, String bkgStsCd, String mapSeq, String blNo, String blTpCd, String pctlNo, String polCd, String bkgNo, String blNoChk, String caNo, String caFlg, String caUsrId, String applicationDate, String pageType, String oblIssFlg, String blHldFlg, String blHldRsnCd, String blHldDt, String blHldUsrId, String docType, String uiId) {
        this.ncbNo = ncbNo;
        this.caExistFlg = caExistFlg;
        this.bdrFlg = bdrFlg;
        this.bkgStsCd = bkgStsCd;
        this.mapSeq = mapSeq;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.blTpCd = blTpCd;
        this.pctlNo = pctlNo;
        this.pageType = pageType;
        this.ibflag = ibflag;
        this.polCd = polCd;
        this.bkgNo = bkgNo;
        this.blNoChk = blNoChk;
        this.applicationDate = applicationDate;
        this.caNo = caNo;
        this.caFlg = caFlg;
        this.caUsrId = caUsrId;
        this.oblIssFlg = oblIssFlg;
        this.blHldFlg = blHldFlg;
        this.blHldRsnCd = blHldRsnCd;
        this.blHldDt = blHldDt;
        this.blHldUsrId = blHldUsrId;
        this.docType = docType;
        this.uiId = uiId;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ncb_no", getNcbNo());
        this.hashColumns.put("ca_exist_flg", getCaExistFlg());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("map_seq", getMapSeq());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bl_tp_cd", getBlTpCd());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("page_type", getPageType());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("bl_no_chk", getBlNoChk());
        this.hashColumns.put("application_date", getApplicationDate());
        this.hashColumns.put("ca_no", getCaNo());
        this.hashColumns.put("ca_flg", getCaFlg());
        this.hashColumns.put("ca_usr_id", getCaUsrId());
        this.hashColumns.put("obl_iss_flg", getOblIssFlg());
        this.hashColumns.put("bl_hld_flg", getBlHldFlg());
        this.hashColumns.put("bl_hld_rsn_cd", getBlHldRsnCd());
        this.hashColumns.put("bl_hld_dt", getBlHldDt());
        this.hashColumns.put("bl_hld_usr_id", getBlHldUsrId());
        this.hashColumns.put("doc_type", getDocType());
        this.hashColumns.put("ui_id", getUiId());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ncb_no", "ncbNo");
        this.hashFields.put("ca_exist_flg", "caExistFlg");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("map_seq", "mapSeq");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bl_tp_cd", "blTpCd");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("page_type", "pageType");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("bl_no_chk", "blNoChk");
        this.hashFields.put("application_date", "applicationDate");
        this.hashFields.put("ca_no", "caNo");
        this.hashFields.put("ca_flg", "caFlg");
        this.hashFields.put("ca_usr_id", "caUsrId");
        this.hashFields.put("obl_iss_flg", "oblIssFlg");
        this.hashFields.put("bl_hld_flg", "blHldFlg");
        this.hashFields.put("bl_hld_rsn_cd", "blHldRsnCd");
        this.hashFields.put("bl_hld_dt", "blHldDt");
        this.hashFields.put("bl_hld_usr_id", "blHldUsrId");
        this.hashFields.put("doc_type", "docType");
        this.hashFields.put("ui_id", "uiId");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ncbNo
	 */
    public String getNcbNo() {
        return this.ncbNo;
    }

    /**
	 * Column Info
	 * @return caExistFlg
	 */
    public String getCaExistFlg() {
        return this.caExistFlg;
    }

    /**
	 * Column Info
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
    }

    /**
	 * Column Info
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 * Column Info
	 * @return mapSeq
	 */
    public String getMapSeq() {
        return this.mapSeq;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @return blTpCd
	 */
    public String getBlTpCd() {
        return this.blTpCd;
    }

    /**
	 * Column Info
	 * @return pctlNo
	 */
    public String getPctlNo() {
        return this.pctlNo;
    }

    /**
	 * Column Info
	 * @return pageType
	 */
    public String getPageType() {
        return this.pageType;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return blNoChk
	 */
    public String getBlNoChk() {
        return this.blNoChk;
    }

    /**
	 * Column Info
	 * @return applicationDate
	 */
    public String getApplicationDate() {
        return this.applicationDate;
    }

    /**
	 * Column Info
	 * @return caNo
	 */
    public String getCaNo() {
        return this.caNo;
    }

    /**
	 * Column Info
	 * @return caFlg
	 */
    public String getCaFlg() {
        return this.caFlg;
    }

    /**
	 * Column Info
	 * @return caUsrId
	 */
    public String getCaUsrId() {
        return this.caUsrId;
    }

    /**
	 * Column Info
	 * @return oblIssFlg
	 */
    public String getOblIssFlg() {
        return this.oblIssFlg;
    }

    /**
	 * Column Info
	 * @return blHldFlg
	 */
    public String getBlHldFlg() {
        return this.blHldFlg;
    }

    /**
	 * Column Info
	 * @return blHldRsnCd
	 */
    public String getBlHldRsnCd() {
        return this.blHldRsnCd;
    }

    /**
	 * Column Info
	 * @return blHldDt
	 */
    public String getBlHldDt() {
        return this.blHldDt;
    }

    /**
	 * Column Info
	 * @return blHldUsrId
	 */
    public String getBlHldUsrId() {
        return this.blHldUsrId;
    }

    /**
	 * Column Info
	 * @return docType
	 */
    public String getDocType() {
        return this.docType;
    }

    /**
	 * Column Info
	 * @param docType
	 */
    public void setDocType(String docType) {
        this.docType = docType;
    }

    /**
	 * Column Info
	 * @param ncbNo
	 */
    public void setNcbNo(String ncbNo) {
        this.ncbNo = ncbNo;
    }

    /**
	 * Column Info
	 * @param caExistFlg
	 */
    public void setCaExistFlg(String caExistFlg) {
        this.caExistFlg = caExistFlg;
    }

    /**
	 * Column Info
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
    }

    /**
	 * Column Info
	 * @param bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * @param mapSeq
	 */
    public void setMapSeq(String mapSeq) {
        this.mapSeq = mapSeq;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
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
	 * @param blTpCd
	 */
    public void setBlTpCd(String blTpCd) {
        this.blTpCd = blTpCd;
    }

    /**
	 * Column Info
	 * @param pctlNo
	 */
    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
    }

    /**
	 * Column Info
	 * @param pageType
	 */
    public void setPageType(String pageType) {
        this.pageType = pageType;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param blNoChk
	 */
    public void setBlNoChk(String blNoChk) {
        this.blNoChk = blNoChk;
    }

    /**
	 * Column Info
	 * @param applicationDate
	 */
    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    /**
	 * Column Info
	 * @param caNo
	 */
    public void setCaNo(String caNo) {
        this.caNo = caNo;
    }

    /**
	 * Column Info
	 * @param caFlg
	 */
    public void setCaFlg(String caFlg) {
        this.caFlg = caFlg;
    }

    /**
	 * Column Info
	 * @param caUsrId
	 */
    public void setCaUsrId(String caUsrId) {
        this.caUsrId = caUsrId;
    }

    /**
	 * Column Info
	 * @param oblIssFlg
	 */
    public void setOblIssFlg(String oblIssFlg) {
        this.oblIssFlg = oblIssFlg;
    }

    /**
	 * Column Info
	 * @param blHldFlg
	 */
    public void setBlHldFlg(String blHldFlg) {
        this.blHldFlg = blHldFlg;
    }

    /**
	 * Column Info
	 * @param blHldRsnCd
	 */
    public void setBlHldRsnCd(String blHldRsnCd) {
        this.blHldRsnCd = blHldRsnCd;
    }

    /**
	 * Column Info
	 * @param blHldDt
	 */
    public void setBlHldDt(String blHldDt) {
        this.blHldDt = blHldDt;
    }

    /**
	 * Column Info
	 * @param blHldUsrId
	 */
    public void setBlHldUsrId(String blHldUsrId) {
        this.blHldUsrId = blHldUsrId;
    }

    public void setUiId(String uiId) {
        this.uiId = uiId;
    }

    public String getUiId() {
        return this.uiId;
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
        setNcbNo(JSPUtil.getParameter(request, prefix + "ncb_no", ""));
        setCaExistFlg(JSPUtil.getParameter(request, prefix + "ca_exist_flg", ""));
        setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setMapSeq(JSPUtil.getParameter(request, prefix + "map_seq", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setPageType(JSPUtil.getParameter(request, prefix + "page_type", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setBlNoChk(JSPUtil.getParameter(request, prefix + "bl_no_chk", ""));
        setApplicationDate(JSPUtil.getParameter(request, prefix + "application_date", ""));
        setCaNo(JSPUtil.getParameter(request, prefix + "ca_no", ""));
        setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
        setCaUsrId(JSPUtil.getParameter(request, prefix + "ca_usr_id", ""));
        setOblIssFlg(JSPUtil.getParameter(request, prefix + "obl_iss_flg", ""));
        setBlHldFlg(JSPUtil.getParameter(request, "bl_hld_flg", ""));
        setBlHldRsnCd(JSPUtil.getParameter(request, "bl_hld_rsn_cd", ""));
        setBlHldDt(JSPUtil.getParameter(request, "bl_hld_dt", ""));
        setBlHldUsrId(JSPUtil.getParameter(request, "bl_hld_usr_id", ""));
        setDocType(JSPUtil.getParameter(request, "doc_type", ""));
        setUiId(JSPUtil.getParameter(request, prefix + "ui_id", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgBlNoVO[]
	 */
    public BkgBlNoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgBlNoVO[]
	 */
    public BkgBlNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgBlNoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ncbNo = (JSPUtil.getParameter(request, prefix + "ncb_no", length));
            String[] caExistFlg = (JSPUtil.getParameter(request, prefix + "ca_exist_flg", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] mapSeq = (JSPUtil.getParameter(request, prefix + "map_seq", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] blTpCd = (JSPUtil.getParameter(request, prefix + "bl_tp_cd", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] pageType = (JSPUtil.getParameter(request, prefix + "page_type", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] blNoChk = (JSPUtil.getParameter(request, prefix + "bl_no_chk", length));
            String[] applicationDate = (JSPUtil.getParameter(request, prefix + "application_date", length));
            String[] caNo = (JSPUtil.getParameter(request, prefix + "ca_no", length));
            String[] caFlg = (JSPUtil.getParameter(request, prefix + "ca_flg", length));
            String[] caUsrId = (JSPUtil.getParameter(request, prefix + "ca_usr_id", length));
            String[] oblIssFlg = (JSPUtil.getParameter(request, prefix + "obl_iss_flg", length));
            String[] blHldFlg = (JSPUtil.getParameter(request, prefix + "bl_hld_flg", length));
            String[] blHldRsnCd = (JSPUtil.getParameter(request, prefix + "bl_hld_rsn_cd", length));
            String[] blHldDt = (JSPUtil.getParameter(request, prefix + "bl_hld_dt", length));
            String[] docType = (JSPUtil.getParameter(request, prefix + "doc_type", length));
            String[] blHldUsrId = (JSPUtil.getParameter(request, prefix + "bl_hld_usr_id", length));
            String[] uiId = (JSPUtil.getParameter(request, prefix + "ui_id", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgBlNoVO();
                if (ncbNo[i] != null)
                    model.setNcbNo(ncbNo[i]);
                if (caExistFlg[i] != null)
                    model.setCaExistFlg(caExistFlg[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (mapSeq[i] != null)
                    model.setMapSeq(mapSeq[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (blTpCd[i] != null)
                    model.setBlTpCd(blTpCd[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (pageType[i] != null)
                    model.setPageType(pageType[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (blNoChk[i] != null)
                    model.setBlNoChk(blNoChk[i]);
                if (applicationDate[i] != null)
                    model.setApplicationDate(applicationDate[i]);
                if (caNo[i] != null)
                    model.setCaNo(caNo[i]);
                if (caFlg[i] != null)
                    model.setCaFlg(caFlg[i]);
                if (caUsrId[i] != null)
                    model.setCaUsrId(caUsrId[i]);
                if (oblIssFlg[i] != null)
                    model.setOblIssFlg(oblIssFlg[i]);
                if (blHldFlg[i] != null)
                    model.setBlHldFlg(blHldFlg[i]);
                if (blHldRsnCd[i] != null)
                    model.setBlHldRsnCd(blHldRsnCd[i]);
                if (blHldDt[i] != null)
                    model.setBlHldDt(blHldDt[i]);
                if (blHldUsrId[i] != null)
                    model.setBlHldUsrId(blHldUsrId[i]);
                if (docType[i] != null)
                    model.setDocType(docType[i]);
                if (uiId[i] != null) 
		    		model.setUiId(uiId[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgBlNoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgBlNoVO[]
	 */
    public BkgBlNoVO[] getBkgBlNoVOs() {
        BkgBlNoVO[] vos = (BkgBlNoVO[]) models.toArray(new BkgBlNoVO[models.size()]);
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
        this.ncbNo = this.ncbNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caExistFlg = this.caExistFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapSeq = this.mapSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blTpCd = this.blTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pageType = this.pageType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNoChk = this.blNoChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.applicationDate = this.applicationDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caNo = this.caNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caFlg = this.caFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caUsrId = this.caUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblIssFlg = this.oblIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blHldFlg = this.blHldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blHldRsnCd = this.blHldRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blHldDt = this.blHldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blHldUsrId = this.blHldUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docType = this.docType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.uiId = this.uiId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
