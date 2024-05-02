/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : IdaGstRtoVO.java
*@FileTitle : IdaGstRtoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
public class IdaGstRtoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<IdaGstRtoVO> models = new ArrayList<IdaGstRtoVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String idaCgstRto = null;

    /* Column Info */
    private String idaSgstRto = null;

    /* Column Info */
    private String idaIgstRto = null;

    /* Column Info */
    private String idaUgstRto = null;

    /* Column Info */
    private String idaGstRgstNo = null;

    /* Column Info */
    private String idaGstRgstStsNm = null;

    /* Column Info */
    private String idaSteCd = null;

    /* Column Info */
    private String idaSteNm = null;

    /* Column Info */
    private String idaBankAcctNo = null;

    /* Column Info */
    private String idaBankIfscCd = null;

    /* Column Info */
    private String idaPanNo = null;

    /* Column Info */
    private String idaSvcCateRmk = null;

    /* Column Info */
    private String idaSacCd = null;

    /* Column Info */
    private String idaSacNm = null;

    /* Column Info */
    private String idaTaxCin = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public IdaGstRtoVO() {
    }

    public IdaGstRtoVO(String ibflag, String pagerows, String idaCgstRto, String idaSgstRto, String idaIgstRto, String idaUgstRto, String idaGstRgstNo, String idaGstRgstStsNm, String idaSteCd, String idaSteNm, String idaBankAcctNo, String idaBankIfscCd, String idaPanNo, String idaSvcCateRmk, String idaSacCd, String idaSacNm, String idaTaxCin) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.idaCgstRto = idaCgstRto;
        this.idaSgstRto = idaSgstRto;
        this.idaIgstRto = idaIgstRto;
        this.idaUgstRto = idaUgstRto;
        this.idaGstRgstNo = idaGstRgstNo;
        this.idaGstRgstStsNm = idaGstRgstStsNm;
        this.idaSteCd = idaSteCd;
        this.idaSteNm = idaSteNm;
        this.idaBankAcctNo = idaBankAcctNo;
        this.idaBankIfscCd = idaBankIfscCd;
        this.idaPanNo = idaPanNo;
        this.idaSvcCateRmk = idaSvcCateRmk;
        this.idaSacCd = idaSacCd;
        this.idaSacNm = idaSacNm;
        this.idaTaxCin = idaTaxCin;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());
        this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());
        this.hashColumns.put("ida_igst_rto", getIdaIgstRto());
        this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());
        this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());
        this.hashColumns.put("ida_gst_rgst_sts_nm", getIdaGstRgstStsNm());
        this.hashColumns.put("ida_ste_cd", getIdaSteCd());
        this.hashColumns.put("ida_ste_nm", getIdaSteNm());
        this.hashColumns.put("ida_bank_acct_no", getIdaBankAcctNo());
        this.hashColumns.put("ida_bank_ifsc_cd", getIdaBankIfscCd());
        this.hashColumns.put("ida_pan_no", getIdaPanNo());
        this.hashColumns.put("ida_svc_cate_rmk", getIdaSvcCateRmk());
        this.hashColumns.put("ida_sac_cd", getIdaSacCd());
        this.hashColumns.put("ida_sac_nm", getIdaSacNm());
        this.hashColumns.put("ida_tax_cin", getIdaTaxCin());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ida_cgst_rto", "idaCgstRto");
        this.hashFields.put("ida_sgst_rto", "idaSgstRto");
        this.hashFields.put("ida_igst_rto", "idaIgstRto");
        this.hashFields.put("ida_ugst_rto", "idaUgstRto");
        this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
        this.hashFields.put("ida_gst_rgst_sts_nm", "idaGstRgstStsNm");
        this.hashFields.put("ida_ste_cd", "idaSteCd");
        this.hashFields.put("ida_ste_nm", "idaSteNm");
        this.hashFields.put("ida_bank_acct_no", "idaBankAcctNo");
        this.hashFields.put("ida_bank_ifsc_cd", "idaBankIfscCd");
        this.hashFields.put("ida_pan_no", "idaPanNo");
        this.hashFields.put("ida_svc_cate_rmk", "idaSvcCateRmk");
        this.hashFields.put("ida_sac_cd", "idaSacCd");
        this.hashFields.put("ida_sac_nm", "idaSacNm");
        this.hashFields.put("ida_tax_cin", "idaTaxCin");
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
	 * @param String idaCgstRto
	 */
    public void setIdaCgstRto(String idaCgstRto) {
        this.idaCgstRto = idaCgstRto;
    }

    /**
	 * 
	 * @return String idaCgstRto
	 */
    public String getIdaCgstRto() {
        return this.idaCgstRto;
    }

    /**
	 *
	 * @param String idaSgstRto
	 */
    public void setIdaSgstRto(String idaSgstRto) {
        this.idaSgstRto = idaSgstRto;
    }

    /**
	 * 
	 * @return String idaSgstRto
	 */
    public String getIdaSgstRto() {
        return this.idaSgstRto;
    }

    /**
	 *
	 * @param String idaIgstRto
	 */
    public void setIdaIgstRto(String idaIgstRto) {
        this.idaIgstRto = idaIgstRto;
    }

    /**
	 * 
	 * @return String idaIgstRto
	 */
    public String getIdaIgstRto() {
        return this.idaIgstRto;
    }

    /**
	 *
	 * @param String idaUgstRto
	 */
    public void setIdaUgstRto(String idaUgstRto) {
        this.idaUgstRto = idaUgstRto;
    }

    /**
	 * 
	 * @return String idaUgstRto
	 */
    public String getIdaUgstRto() {
        return this.idaUgstRto;
    }

    public void setIdaGstRgstNo(String idaGstRgstNo) {
        this.idaGstRgstNo = idaGstRgstNo;
    }

    public String getIdaGstRgstNo() {
        return this.idaGstRgstNo;
    }

    public void setIdaGstRgstStsNm(String idaGstRgstStsNm) {
        this.idaGstRgstStsNm = idaGstRgstStsNm;
    }

    public String getIdaGstRgstStsNm() {
        return this.idaGstRgstStsNm;
    }

    public void setIdaSteCd(String idaSteCd) {
        this.idaSteCd = idaSteCd;
    }

    public String getIdaSteCd() {
        return this.idaSteCd;
    }

    public void setIdaSteNm(String idaSteNm) {
        this.idaSteNm = idaSteNm;
    }

    public String getIdaSteNm() {
        return this.idaSteNm;
    }

    public void setIdaBankAcctNo(String idaBankAcctNo) {
        this.idaBankAcctNo = idaBankAcctNo;
    }

    public String getIdaBankAcctNo() {
        return this.idaBankAcctNo;
    }

    public void setIdaBankIfscCd(String idaBankIfscCd) {
        this.idaBankIfscCd = idaBankIfscCd;
    }

    public String getIdaBankIfscCd() {
        return this.idaBankIfscCd;
    }

    public void setIdaPanNo(String idaPanNo) {
        this.idaPanNo = idaPanNo;
    }

    public String getIdaPanNo() {
        return this.idaPanNo;
    }

    public void setIdaSvcCateRmk(String idaSvcCateRmk) {
        this.idaSvcCateRmk = idaSvcCateRmk;
    }

    public String getIdaSvcCateRmk() {
        return this.idaSvcCateRmk;
    }

    public void setIdaSacCd(String idaSacCd) {
        this.idaSacCd = idaSacCd;
    }

    public String getIdaSacCd() {
        return this.idaSacCd;
    }

    public void setIdaSacNm(String idaSacNm) {
        this.idaSacNm = idaSacNm;
    }

    public String getIdaSacNm() {
        return this.idaSacNm;
    }

    public void setIdaTaxCin(String idaTaxCin) {
        this.idaTaxCin = idaTaxCin;
    }

    public String getIdaTaxCin() {
        return this.idaTaxCin;
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
        setIdaCgstRto(JSPUtil.getParameter(request, prefix + "ida_cgst_rto", ""));
        setIdaSgstRto(JSPUtil.getParameter(request, prefix + "ida_sgst_rto", ""));
        setIdaIgstRto(JSPUtil.getParameter(request, prefix + "ida_igst_rto", ""));
        setIdaUgstRto(JSPUtil.getParameter(request, prefix + "ida_ugst_rto", ""));
        setIdaGstRgstNo(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", ""));
        setIdaGstRgstStsNm(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_sts_nm", ""));
        setIdaSteCd(JSPUtil.getParameter(request, prefix + "ida_ste_cd", ""));
        setIdaSteNm(JSPUtil.getParameter(request, prefix + "ida_ste_nm", ""));
        setIdaBankAcctNo(JSPUtil.getParameter(request, prefix + "ida_bank_acct_no", ""));
        setIdaBankIfscCd(JSPUtil.getParameter(request, prefix + "ida_bank_ifsc_cd", ""));
        setIdaPanNo(JSPUtil.getParameter(request, prefix + "ida_pan_no", ""));
        setIdaSvcCateRmk(JSPUtil.getParameter(request, prefix + "ida_svc_cate_rmk", ""));
        setIdaSacCd(JSPUtil.getParameter(request, prefix + "ida_sac_cd", ""));
        setIdaSacNm(JSPUtil.getParameter(request, prefix + "ida_sac_nm", ""));
        setIdaTaxCin(JSPUtil.getParameter(request, prefix + "ida_tax_cin", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaGstRtoVO[]
	 */
    public IdaGstRtoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaGstRtoVO[]
	 */
    public IdaGstRtoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        IdaGstRtoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] idaCgstRto = (JSPUtil.getParameter(request, prefix + "ida_cgst_rto", length));
            String[] idaSgstRto = (JSPUtil.getParameter(request, prefix + "ida_sgst_rto", length));
            String[] idaIgstRto = (JSPUtil.getParameter(request, prefix + "ida_igst_rto", length));
            String[] idaUgstRto = (JSPUtil.getParameter(request, prefix + "ida_ugst_rto", length));
            String[] idaGstRgstNo = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", length));
            String[] idaGstRgstStsNm = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_sts_nm", length));
            String[] idaSteCd = (JSPUtil.getParameter(request, prefix + "ida_ste_cd", length));
            String[] idaSteNm = (JSPUtil.getParameter(request, prefix + "ida_ste_nm", length));
            String[] idaBankAcctNo = (JSPUtil.getParameter(request, prefix + "ida_bank_acct_no", length));
            String[] idaBankIfscCd = (JSPUtil.getParameter(request, prefix + "ida_bank_ifsc_cd", length));
            String[] idaPanNo = (JSPUtil.getParameter(request, prefix + "ida_pan_no", length));
            String[] idaSvcCateRmk = (JSPUtil.getParameter(request, prefix + "ida_svc_cate_rmk", length));
            String[] idaSacCd = (JSPUtil.getParameter(request, prefix + "ida_sac_cd", length));
            String[] idaSacNm = (JSPUtil.getParameter(request, prefix + "ida_sac_nm", length));
            String[] idaTaxCin = (JSPUtil.getParameter(request, prefix + "ida_tax_cin", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new IdaGstRtoVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (idaCgstRto[i] != null)
                    model.setIdaCgstRto(idaCgstRto[i]);
                if (idaSgstRto[i] != null)
                    model.setIdaSgstRto(idaSgstRto[i]);
                if (idaIgstRto[i] != null)
                    model.setIdaIgstRto(idaIgstRto[i]);
                if (idaUgstRto[i] != null)
                    model.setIdaUgstRto(idaUgstRto[i]);
                if (idaGstRgstNo[i] != null)
                    model.setIdaGstRgstNo(idaGstRgstNo[i]);
                if (idaGstRgstStsNm[i] != null)
                    model.setIdaGstRgstStsNm(idaGstRgstStsNm[i]);
                if (idaSteCd[i] != null)
                    model.setIdaSteCd(idaSteCd[i]);
                if (idaSteNm[i] != null)
                    model.setIdaSteNm(idaSteNm[i]);
                if (idaBankAcctNo[i] != null)
                    model.setIdaBankAcctNo(idaBankAcctNo[i]);
                if (idaBankIfscCd[i] != null)
                    model.setIdaBankIfscCd(idaBankIfscCd[i]);
                if (idaPanNo[i] != null)
                    model.setIdaPanNo(idaPanNo[i]);
                if (idaSvcCateRmk[i] != null)
                    model.setIdaSvcCateRmk(idaSvcCateRmk[i]);
                if (idaSacCd[i] != null)
                    model.setIdaSacCd(idaSacCd[i]);
                if (idaSacNm[i] != null)
                    model.setIdaSacNm(idaSacNm[i]);
                if (idaTaxCin[i] != null) 
		    		model.setIdaTaxCin(idaTaxCin[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getIdaGstRtoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return IdaGstRtoVO[]
	 */
    public IdaGstRtoVO[] getIdaGstRtoVOs() {
        IdaGstRtoVO[] vos = (IdaGstRtoVO[]) models.toArray(new IdaGstRtoVO[models.size()]);
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
        this.idaCgstRto = this.idaCgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSgstRto = this.idaSgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIgstRto = this.idaIgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaUgstRto = this.idaUgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstNo = this.idaGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstStsNm = this.idaGstRgstStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSteCd = this.idaSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSteNm = this.idaSteNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaBankAcctNo = this.idaBankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaBankIfscCd = this.idaBankIfscCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaPanNo = this.idaPanNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSvcCateRmk = this.idaSvcCateRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSacCd = this.idaSacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSacNm = this.idaSacNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTaxCin = this.idaTaxCin.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
