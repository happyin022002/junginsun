/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ProductCatalogPoupCheckVO.java
*@FileTitle : ProductCatalogPoupCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

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
public class ProductCatalogPoupCheckVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ProductCatalogPoupCheckVO> models = new ArrayList<ProductCatalogPoupCheckVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String sCustCntCd = null;

    /* Column Info */
    private String cCustCntCd = null;

    /* Column Info */
    private String pctlNo = null;

    /* Column Info */
    private String bkgNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ProductCatalogPoupCheckVO() {
    }

    public ProductCatalogPoupCheckVO(String ibflag, String pagerows, String rfaNo, String scNo, String sCustCntCd, String cCustCntCd, String pctlNo, String bkgNo) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.rfaNo = rfaNo;
        this.scNo = scNo;
        this.sCustCntCd = sCustCntCd;
        this.cCustCntCd = cCustCntCd;
        this.pctlNo = pctlNo;
        this.bkgNo = bkgNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
        this.hashColumns.put("c_cust_cnt_cd", getCCustCntCd());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("bkg_no", getBkgNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
        this.hashFields.put("c_cust_cnt_cd", "cCustCntCd");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("bkg_no", "bkgNo");
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
	 * @param String rfaNo
	 */
    public void setRfaNo(String rfaNo) {
        this.rfaNo = rfaNo;
    }

    /**
	 * 
	 * @return String rfaNo
	 */
    public String getRfaNo() {
        return this.rfaNo;
    }

    /**
	 *
	 * @param String scNo
	 */
    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    /**
	 * 
	 * @return String scNo
	 */
    public String getScNo() {
        return this.scNo;
    }

    /**
	 *
	 * @param String sCustCntCd
	 */
    public void setSCustCntCd(String sCustCntCd) {
        this.sCustCntCd = sCustCntCd;
    }

    /**
	 * 
	 * @return String sCustCntCd
	 */
    public String getSCustCntCd() {
        return this.sCustCntCd;
    }

    /**
	 *
	 * @param String cCustCntCd
	 */
    public void setCCustCntCd(String cCustCntCd) {
        this.cCustCntCd = cCustCntCd;
    }

    /**
	 * 
	 * @return String cCustCntCd
	 */
    public String getCCustCntCd() {
        return this.cCustCntCd;
    }

    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
    }

    public String getPctlNo() {
        return this.pctlNo;
    }

    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    public String getBkgNo() {
        return this.bkgNo;
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
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setSCustCntCd(JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", ""));
        setCCustCntCd(JSPUtil.getParameter(request, prefix + "c_cust_cnt_cd", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProductCatalogPoupCheckVO[]
	 */
    public ProductCatalogPoupCheckVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProductCatalogPoupCheckVO[]
	 */
    public ProductCatalogPoupCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ProductCatalogPoupCheckVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] sCustCntCd = (JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", length));
            String[] cCustCntCd = (JSPUtil.getParameter(request, prefix + "c_cust_cnt_cd", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ProductCatalogPoupCheckVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (sCustCntCd[i] != null)
                    model.setSCustCntCd(sCustCntCd[i]);
                if (cCustCntCd[i] != null)
                    model.setCCustCntCd(cCustCntCd[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (bkgNo[i] != null) 
		    		model.setBkgNo(bkgNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getProductCatalogPoupCheckVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ProductCatalogPoupCheckVO[]
	 */
    public ProductCatalogPoupCheckVO[] getProductCatalogPoupCheckVOs() {
        ProductCatalogPoupCheckVO[] vos = (ProductCatalogPoupCheckVO[]) models.toArray(new ProductCatalogPoupCheckVO[models.size()]);
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
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustCntCd = this.sCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cCustCntCd = this.cCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
