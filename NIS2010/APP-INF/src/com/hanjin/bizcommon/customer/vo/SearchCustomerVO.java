/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchCustomerVO.java
*@FileTitle : SearchCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.05  
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.customer.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchCustomerVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchCustomerVO> models = new ArrayList<SearchCustomerVO>();

    /* Column Info */
    private String custGrpId = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String use = null;

    /* Column Info */
    private String bzetAddr = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String rvisCntrCustTpCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String steCd = null;

    /* Column Info */
    private String srepCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchCustomerVO() {
    }

    public SearchCustomerVO(String ibflag, String pagerows, String custCd, String custNm, String ofcCd, String use, String bzetAddr, String steCd, String zipCd, String locCd, String rvisCntrCustTpCd, String custGrpId, String vndrSeq, String srepCd) {
        this.custGrpId = custGrpId;
        this.custNm = custNm;
        this.use = use;
        this.bzetAddr = bzetAddr;
        this.pagerows = pagerows;
        this.ofcCd = ofcCd;
        this.rvisCntrCustTpCd = rvisCntrCustTpCd;
        this.ibflag = ibflag;
        this.locCd = locCd;
        this.custCd = custCd;
        this.zipCd = zipCd;
        this.vndrSeq = vndrSeq;
        this.steCd = steCd;
        this.srepCd = srepCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cust_grp_id", getCustGrpId());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("use", getUse());
        this.hashColumns.put("bzet_addr", getBzetAddr());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("ste_cd", getSteCd());
        this.hashColumns.put("srep_cd", getSrepCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cust_grp_id", "custGrpId");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("use", "use");
        this.hashFields.put("bzet_addr", "bzetAddr");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("srep_cd", "srepCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return custGrpId
	 */
    public String getCustGrpId() {
        return this.custGrpId;
    }

    /**
	 * Column Info
	 * @return custNm
	 */
    public String getCustNm() {
        return this.custNm;
    }

    /**
	 * Column Info
	 * @return use
	 */
    public String getUse() {
        return this.use;
    }

    /**
	 * Column Info
	 * @return bzetAddr
	 */
    public String getBzetAddr() {
        return this.bzetAddr;
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
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return rvisCntrCustTpCd
	 */
    public String getRvisCntrCustTpCd() {
        return this.rvisCntrCustTpCd;
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
	 * @return locCd
	 */
    public String getLocCd() {
        return this.locCd;
    }

    /**
	 * Column Info
	 * @return custCd
	 */
    public String getCustCd() {
        return this.custCd;
    }

    /**
	 * Column Info
	 * @return zipCd
	 */
    public String getZipCd() {
        return this.zipCd;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return steCd
	 */
    public String getSteCd() {
        return this.steCd;
    }

    /**
	 * Column Info
	 * @param custGrpId
	 */
    public void setCustGrpId(String custGrpId) {
        this.custGrpId = custGrpId;
    }

    /**
	 * Column Info
	 * @param custNm
	 */
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    /**
	 * Column Info
	 * @param use
	 */
    public void setUse(String use) {
        this.use = use;
    }

    /**
	 * Column Info
	 * @param bzetAddr
	 */
    public void setBzetAddr(String bzetAddr) {
        this.bzetAddr = bzetAddr;
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
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param rvisCntrCustTpCd
	 */
    public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
        this.rvisCntrCustTpCd = rvisCntrCustTpCd;
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
	 * @param locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    /**
	 * Column Info
	 * @param custCd
	 */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    /**
	 * Column Info
	 * @param zipCd
	 */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param steCd
	 */
    public void setSteCd(String steCd) {
        this.steCd = steCd;
    }

    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    public String getSrepCd() {
        return this.srepCd;
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
        setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setUse(JSPUtil.getParameter(request, prefix + "use", ""));
        setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerVO[]
	 */
    public SearchCustomerVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerVO[]
	 */
    public SearchCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchCustomerVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] custGrpId = (JSPUtil.getParameter(request, prefix + "cust_grp_id", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] use = (JSPUtil.getParameter(request, prefix + "use", length));
            String[] bzetAddr = (JSPUtil.getParameter(request, prefix + "bzet_addr", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] steCd = (JSPUtil.getParameter(request, prefix + "ste_cd", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
				/* Add a Method line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchCustomerVO();
                if (custGrpId[i] != null)
                    model.setCustGrpId(custGrpId[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (use[i] != null)
                    model.setUse(use[i]);
                if (bzetAddr[i] != null)
                    model.setBzetAddr(bzetAddr[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (rvisCntrCustTpCd[i] != null)
                    model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (zipCd[i] != null)
                    model.setZipCd(zipCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (steCd[i] != null)
                    model.setSteCd(steCd[i]);
                if (srepCd[i] != null) 
		    		model.setSrepCd(srepCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchCustomerVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchCustomerVO[]
	 */
    public SearchCustomerVO[] getSearchCustomerVOs() {
        SearchCustomerVO[] vos = (SearchCustomerVO[]) models.toArray(new SearchCustomerVO[models.size()]);
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
        this.custGrpId = this.custGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.use = this.use.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzetAddr = this.bzetAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rvisCntrCustTpCd = this.rvisCntrCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
