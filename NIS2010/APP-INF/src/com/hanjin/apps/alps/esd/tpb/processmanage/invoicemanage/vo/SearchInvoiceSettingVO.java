/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchInvoiceSettingVO.java
*@FileTitle : SearchInvoiceSettingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.09.16 최덕우 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo;

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
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchInvoiceSettingVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchInvoiceSettingVO> models = new ArrayList<SearchInvoiceSettingVO>();

    /* Column Info */
    private String sInvIssOfcCd = null;

    /* Column Info */
    private String coNm = null;

    /* Column Info */
    private String invRmk2 = null;

    /* Column Info */
    private String invRmk1 = null;

    /* Column Info */
    private String vatXchRtDiv = null;

    /* Column Info */
    private String invIssOfcCd = null;

    /* Column Info */
    private String bilToLocDivCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String creUsrId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vatXchRt = null;

    /* Column Info */
    private String eurVatRefNo = null;

    /* Column Info */
    private String ofcPhnNo = null;

    /* Column Info */
    private String ofcAddr = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String ofcFaxNo = null;

    /* Column Info */
    private String idaSteCd = null;

    /* Column Info */
    private String idaGstRgstNo = null;

    /* Column Info */
    private String idaPanNo = null;

    /* Column Info */
    private String idaBankAcctNo = null;

    /* Column Info */
    private String idaIfscCd = null;

    /* Column Info */
    private String idaTaxCinNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchInvoiceSettingVO() {
    }

    public SearchInvoiceSettingVO(String ibflag, String pagerows, String sInvIssOfcCd, String coNm, String invRmk2, String invRmk1, String vatXchRtDiv, String invIssOfcCd, String bilToLocDivCd, String vatXchRt, String ofcPhnNo, String ofcAddr, String ofcFaxNo, String creUsrId, String updUsrId, String eurVatRefNo, String idaSteCd, String idaGstRgstNo, String idaPanNo, String idaBankAcctNo, String idaIfscCd, String idaTaxCinNo) {
        this.sInvIssOfcCd = sInvIssOfcCd;
        this.coNm = coNm;
        this.invRmk2 = invRmk2;
        this.invRmk1 = invRmk1;
        this.vatXchRtDiv = vatXchRtDiv;
        this.invIssOfcCd = invIssOfcCd;
        this.bilToLocDivCd = bilToLocDivCd;
        this.pagerows = pagerows;
        this.creUsrId = creUsrId;
        this.ibflag = ibflag;
        this.vatXchRt = vatXchRt;
        this.eurVatRefNo = eurVatRefNo;
        this.ofcPhnNo = ofcPhnNo;
        this.ofcAddr = ofcAddr;
        this.updUsrId = updUsrId;
        this.ofcFaxNo = ofcFaxNo;
        this.idaSteCd = idaSteCd;
        this.idaGstRgstNo = idaGstRgstNo;
        this.idaPanNo = idaPanNo;
        this.idaBankAcctNo = idaBankAcctNo;
        this.idaIfscCd = idaIfscCd;
        this.idaTaxCinNo = idaTaxCinNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("s_inv_iss_ofc_cd", getSInvIssOfcCd());
        this.hashColumns.put("co_nm", getCoNm());
        this.hashColumns.put("inv_rmk2", getInvRmk2());
        this.hashColumns.put("inv_rmk1", getInvRmk1());
        this.hashColumns.put("vat_xch_rt_div", getVatXchRtDiv());
        this.hashColumns.put("inv_iss_ofc_cd", getInvIssOfcCd());
        this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vat_xch_rt", getVatXchRt());
        this.hashColumns.put("eur_vat_ref_no", getEurVatRefNo());
        this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
        this.hashColumns.put("ofc_addr", getOfcAddr());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("ofc_fax_no", getOfcFaxNo());
        this.hashColumns.put("ida_ste_cd", getIdaSteCd());
        this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());
        this.hashColumns.put("ida_pan_no", getIdaPanNo());
        this.hashColumns.put("ida_bank_acct_no", getIdaBankAcctNo());
        this.hashColumns.put("ida_ifsc_cd", getIdaIfscCd());
        this.hashColumns.put("ida_tax_cin_no", getIdaTaxCinNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("s_inv_iss_ofc_cd", "sInvIssOfcCd");
        this.hashFields.put("co_nm", "coNm");
        this.hashFields.put("inv_rmk2", "invRmk2");
        this.hashFields.put("inv_rmk1", "invRmk1");
        this.hashFields.put("vat_xch_rt_div", "vatXchRtDiv");
        this.hashFields.put("inv_iss_ofc_cd", "invIssOfcCd");
        this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vat_xch_rt", "vatXchRt");
        this.hashFields.put("eur_vat_ref_no", "eurVatRefNo");
        this.hashFields.put("ofc_phn_no", "ofcPhnNo");
        this.hashFields.put("ofc_addr", "ofcAddr");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("ofc_fax_no", "ofcFaxNo");
        this.hashFields.put("ida_ste_cd", "idaSteCd");
        this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
        this.hashFields.put("ida_pan_no", "idaPanNo");
        this.hashFields.put("ida_bank_acct_no", "idaBankAcctNo");
        this.hashFields.put("ida_ifsc_cd", "idaIfscCd");
        this.hashFields.put("ida_tax_cin_no", "idaTaxCinNo");
        return this.hashFields;
    }

    /**
	 * @return the idaSteCd
	 */
    public String getIdaSteCd() {
        return idaSteCd;
    }

    /**
	 * @param idaSteCd the idaSteCd to set
	 */
    public void setIdaSteCd(String idaSteCd) {
        this.idaSteCd = idaSteCd;
    }

    /**
	 * @return the idaGstRgstNo
	 */
    public String getIdaGstRgstNo() {
        return idaGstRgstNo;
    }

    /**
	 * @param idaGstRgstNo the idaGstRgstNo to set
	 */
    public void setIdaGstRgstNo(String idaGstRgstNo) {
        this.idaGstRgstNo = idaGstRgstNo;
    }

    /**
	 * @return the idaPanNo
	 */
    public String getIdaPanNo() {
        return idaPanNo;
    }

    /**
	 * @param idaPanNo the idaPanNo to set
	 */
    public void setIdaPanNo(String idaPanNo) {
        this.idaPanNo = idaPanNo;
    }

    /**
	 * @return the idaBankAcctNo
	 */
    public String getIdaBankAcctNo() {
        return idaBankAcctNo;
    }

    /**
	 * @param idaBankAcctNo the idaBankAcctNo to set
	 */
    public void setIdaBankAcctNo(String idaBankAcctNo) {
        this.idaBankAcctNo = idaBankAcctNo;
    }

    /**
	 * @return the idaIfscCd
	 */
    public String getIdaIfscCd() {
        return idaIfscCd;
    }

    /**
	 * @param idaIfscCd the idaIfscCd to set
	 */
    public void setIdaIfscCd(String idaIfscCd) {
        this.idaIfscCd = idaIfscCd;
    }

    /**
	 * Column Info
	 * @return sInvIssOfcCd
	 */
    public String getSInvIssOfcCd() {
        return this.sInvIssOfcCd;
    }

    /**
	 * Column Info
	 * @return coNm
	 */
    public String getCoNm() {
        return this.coNm;
    }

    /**
	 * Column Info
	 * @return invRmk2
	 */
    public String getInvRmk2() {
        return this.invRmk2;
    }

    /**
	 * Column Info
	 * @return invRmk1
	 */
    public String getInvRmk1() {
        return this.invRmk1;
    }

    /**
	 * Column Info
	 * @return vatXchRtDiv
	 */
    public String getVatXchRtDiv() {
        return this.vatXchRtDiv;
    }

    /**
	 * Column Info
	 * @return invIssOfcCd
	 */
    public String getInvIssOfcCd() {
        return this.invIssOfcCd;
    }

    /**
	 * Column Info
	 * @return bilToLocDivCd
	 */
    public String getBilToLocDivCd() {
        return this.bilToLocDivCd;
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
	 * @return vatXchRt
	 */
    public String getVatXchRt() {
        return this.vatXchRt;
    }

    /**
	 * Column Info
	 * @return eurVatRefNo
	 */
    public String getEurVatRefNo() {
        return this.eurVatRefNo;
    }

    /**
	 * Column Info
	 * @return ofcPhnNo
	 */
    public String getOfcPhnNo() {
        return this.ofcPhnNo;
    }

    /**
	 * Column Info
	 * @return ofcAddr
	 */
    public String getOfcAddr() {
        return this.ofcAddr;
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
	 * @return ofcFaxNo
	 */
    public String getOfcFaxNo() {
        return this.ofcFaxNo;
    }

    /**
	 * Column Info
	 * @param sInvIssOfcCd
	 */
    public void setSInvIssOfcCd(String sInvIssOfcCd) {
        this.sInvIssOfcCd = sInvIssOfcCd;
    }

    /**
	 * Column Info
	 * @param coNm
	 */
    public void setCoNm(String coNm) {
        this.coNm = coNm;
    }

    /**
	 * Column Info
	 * @param invRmk2
	 */
    public void setInvRmk2(String invRmk2) {
        this.invRmk2 = invRmk2;
    }

    /**
	 * Column Info
	 * @param invRmk1
	 */
    public void setInvRmk1(String invRmk1) {
        this.invRmk1 = invRmk1;
    }

    /**
	 * Column Info
	 * @param vatXchRtDiv
	 */
    public void setVatXchRtDiv(String vatXchRtDiv) {
        this.vatXchRtDiv = vatXchRtDiv;
    }

    /**
	 * Column Info
	 * @param invIssOfcCd
	 */
    public void setInvIssOfcCd(String invIssOfcCd) {
        this.invIssOfcCd = invIssOfcCd;
    }

    /**
	 * Column Info
	 * @param bilToLocDivCd
	 */
    public void setBilToLocDivCd(String bilToLocDivCd) {
        this.bilToLocDivCd = bilToLocDivCd;
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
	 * @param vatXchRt
	 */
    public void setVatXchRt(String vatXchRt) {
        this.vatXchRt = vatXchRt;
    }

    /**
	 * Column Info
	 * @param eurVatRefNo
	 */
    public void setEurVatRefNo(String eurVatRefNo) {
        this.eurVatRefNo = eurVatRefNo;
    }

    /**
	 * Column Info
	 * @param ofcPhnNo
	 */
    public void setOfcPhnNo(String ofcPhnNo) {
        this.ofcPhnNo = ofcPhnNo;
    }

    /**
	 * Column Info
	 * @param ofcAddr
	 */
    public void setOfcAddr(String ofcAddr) {
        this.ofcAddr = ofcAddr;
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
	 * @param ofcFaxNo
	 */
    public void setOfcFaxNo(String ofcFaxNo) {
        this.ofcFaxNo = ofcFaxNo;
    }

    public void setIdaTaxCinNo(String idaTaxCinNo) {
        this.idaTaxCinNo = idaTaxCinNo;
    }

    public String getIdaTaxCinNo() {
        return this.idaTaxCinNo;
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
        setSInvIssOfcCd(JSPUtil.getParameter(request, prefix + "s_inv_iss_ofc_cd", ""));
        setCoNm(JSPUtil.getParameter(request, prefix + "co_nm", ""));
        setInvRmk2(JSPUtil.getParameter(request, prefix + "inv_rmk2", ""));
        setInvRmk1(JSPUtil.getParameter(request, prefix + "inv_rmk1", ""));
        setVatXchRtDiv(JSPUtil.getParameter(request, prefix + "vat_xch_rt_div", ""));
        setInvIssOfcCd(JSPUtil.getParameter(request, prefix + "inv_iss_ofc_cd", ""));
        setBilToLocDivCd(JSPUtil.getParameter(request, prefix + "bil_to_loc_div_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVatXchRt(JSPUtil.getParameter(request, prefix + "vat_xch_rt", ""));
        setEurVatRefNo(JSPUtil.getParameter(request, prefix + "eur_vat_ref_no", ""));
        setOfcPhnNo(JSPUtil.getParameter(request, prefix + "ofc_phn_no", ""));
        setOfcAddr(JSPUtil.getParameter(request, prefix + "ofc_addr", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setOfcFaxNo(JSPUtil.getParameter(request, prefix + "ofc_fax_no", ""));
        setIdaSteCd(JSPUtil.getParameter(request, prefix + "ida_ste_cd", ""));
        setIdaGstRgstNo(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", ""));
        setIdaPanNo(JSPUtil.getParameter(request, prefix + "ida_pan_no", ""));
        setIdaBankAcctNo(JSPUtil.getParameter(request, prefix + "ida_bank_acct_no", ""));
        setIdaIfscCd(JSPUtil.getParameter(request, prefix + "ida_ifsc_cd", ""));
        setIdaTaxCinNo(JSPUtil.getParameter(request, prefix + "ida_tax_cin_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoiceSettingVO[]
	 */
    public SearchInvoiceSettingVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoiceSettingVO[]
	 */
    public SearchInvoiceSettingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchInvoiceSettingVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] sInvIssOfcCd = (JSPUtil.getParameter(request, prefix + "s_inv_iss_ofc_cd", length));
            String[] coNm = (JSPUtil.getParameter(request, prefix + "co_nm", length));
            String[] invRmk2 = (JSPUtil.getParameter(request, prefix + "inv_rmk2", length));
            String[] invRmk1 = (JSPUtil.getParameter(request, prefix + "inv_rmk1", length));
            String[] vatXchRtDiv = (JSPUtil.getParameter(request, prefix + "vat_xch_rt_div", length));
            String[] invIssOfcCd = (JSPUtil.getParameter(request, prefix + "inv_iss_ofc_cd", length));
            String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix + "bil_to_loc_div_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vatXchRt = (JSPUtil.getParameter(request, prefix + "vat_xch_rt", length));
            String[] eurVatRefNo = (JSPUtil.getParameter(request, prefix + "eur_vat_ref_no", length));
            String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix + "ofc_phn_no", length));
            String[] ofcAddr = (JSPUtil.getParameter(request, prefix + "ofc_addr", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] ofcFaxNo = (JSPUtil.getParameter(request, prefix + "ofc_fax_no", length));
            String[] idaSteCd = (JSPUtil.getParameter(request, prefix + "ida_ste_cd", length));
            String[] idaGstRgstNo = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", length));
            String[] idaPanNo = (JSPUtil.getParameter(request, prefix + "ida_pan_no", length));
            String[] idaBankAcctNo = (JSPUtil.getParameter(request, prefix + "ida_bank_acct_no", length));
            String[] idaIfscCd = (JSPUtil.getParameter(request, prefix + "ida_ifsc_cd", length));
            String[] idaTaxCinNo = (JSPUtil.getParameter(request, prefix + "ida_tax_cin_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchInvoiceSettingVO();
                if (sInvIssOfcCd[i] != null)
                    model.setSInvIssOfcCd(sInvIssOfcCd[i]);
                if (coNm[i] != null)
                    model.setCoNm(coNm[i]);
                if (invRmk2[i] != null)
                    model.setInvRmk2(invRmk2[i]);
                if (invRmk1[i] != null)
                    model.setInvRmk1(invRmk1[i]);
                if (vatXchRtDiv[i] != null)
                    model.setVatXchRtDiv(vatXchRtDiv[i]);
                if (invIssOfcCd[i] != null)
                    model.setInvIssOfcCd(invIssOfcCd[i]);
                if (bilToLocDivCd[i] != null)
                    model.setBilToLocDivCd(bilToLocDivCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vatXchRt[i] != null)
                    model.setVatXchRt(vatXchRt[i]);
                if (eurVatRefNo[i] != null)
                    model.setEurVatRefNo(eurVatRefNo[i]);
                if (ofcPhnNo[i] != null)
                    model.setOfcPhnNo(ofcPhnNo[i]);
                if (ofcAddr[i] != null)
                    model.setOfcAddr(ofcAddr[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (ofcFaxNo[i] != null)
                    model.setOfcFaxNo(ofcFaxNo[i]);
                if (idaSteCd[i] != null)
                    model.setIdaSteCd(idaSteCd[i]);
                if (idaGstRgstNo[i] != null)
                    model.setIdaGstRgstNo(idaGstRgstNo[i]);
                if (idaPanNo[i] != null)
                    model.setIdaPanNo(idaPanNo[i]);
                if (idaBankAcctNo[i] != null)
                    model.setIdaBankAcctNo(idaBankAcctNo[i]);
                if (idaIfscCd[i] != null)
                    model.setIdaIfscCd(idaIfscCd[i]);
                if (idaTaxCinNo[i] != null) 
		    		model.setIdaTaxCinNo(idaTaxCinNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchInvoiceSettingVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchInvoiceSettingVO[]
	 */
    public SearchInvoiceSettingVO[] getSearchInvoiceSettingVOs() {
        SearchInvoiceSettingVO[] vos = (SearchInvoiceSettingVO[]) models.toArray(new SearchInvoiceSettingVO[models.size()]);
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
        this.sInvIssOfcCd = this.sInvIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.coNm = this.coNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk2 = this.invRmk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk1 = this.invRmk1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatXchRtDiv = this.vatXchRtDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssOfcCd = this.invIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilToLocDivCd = this.bilToLocDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatXchRt = this.vatXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eurVatRefNo = this.eurVatRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcPhnNo = this.ofcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcAddr = this.ofcAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcFaxNo = this.ofcFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSteCd = this.idaSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstNo = this.idaGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaPanNo = this.idaPanNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaBankAcctNo = this.idaBankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIfscCd = this.idaIfscCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTaxCinNo = this.idaTaxCinNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
