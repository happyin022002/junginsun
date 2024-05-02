/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : AdvJpCustomerVO.java
*@FileTitle : AdvJpCustomerVO
*Open Issues :
*Change history :
*	2017.09.07 하대성 podCd culumn Add
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.1
* 2017.09.07 하대성 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AdvJpCustomerVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AdvJpCustomerVO> models = new ArrayList<AdvJpCustomerVO>();

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String custAddr = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String bkgCustTpCd = null;

    /* Column Info */
    private String blSplitNo = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custZipId = null;

    /* Column Info */
    private String podCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public AdvJpCustomerVO() {
    }

    public AdvJpCustomerVO(String ibflag, String pagerows, String blNo, String blSplitNo, String bkgCustTpCd, String custSeq, String custCntCd, String custNm, String custAddr, String custZipId, String phnNo, String faxNo, String usrId, String podCd) {
        this.phnNo = phnNo;
        this.custNm = custNm;
        this.custAddr = custAddr;
        this.custSeq = custSeq;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.usrId = usrId;
        this.faxNo = faxNo;
        this.bkgCustTpCd = bkgCustTpCd;
        this.blSplitNo = blSplitNo;
        this.custCntCd = custCntCd;
        this.custZipId = custZipId;
        this.podCd = podCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("cust_addr", getCustAddr());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
        this.hashColumns.put("bl_split_no", getBlSplitNo());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_zip_id", getCustZipId());
        this.hashColumns.put("pod_cd", getPodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("cust_addr", "custAddr");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
        this.hashFields.put("bl_split_no", "blSplitNo");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_zip_id", "custZipId");
        this.hashFields.put("pod_cd", "podCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return phnNo
	 */
    public String getPhnNo() {
        return this.phnNo;
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
	 * @return custAddr
	 */
    public String getCustAddr() {
        return this.custAddr;
    }

    /**
	 * Column Info
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return faxNo
	 */
    public String getFaxNo() {
        return this.faxNo;
    }

    /**
	 * Column Info
	 * @return bkgCustTpCd
	 */
    public String getBkgCustTpCd() {
        return this.bkgCustTpCd;
    }

    /**
	 * Column Info
	 * @return blSplitNo
	 */
    public String getBlSplitNo() {
        return this.blSplitNo;
    }

    /**
	 * Column Info
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 * Column Info
	 * @return custZipId
	 */
    public String getCustZipId() {
        return this.custZipId;
    }

    /**
	 * Column Info
	 * @param phnNo
	 */
    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
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
	 * @param custAddr
	 */
    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    /**
	 * Column Info
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param faxNo
	 */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
	 * Column Info
	 * @param bkgCustTpCd
	 */
    public void setBkgCustTpCd(String bkgCustTpCd) {
        this.bkgCustTpCd = bkgCustTpCd;
    }

    /**
	 * Column Info
	 * @param blSplitNo
	 */
    public void setBlSplitNo(String blSplitNo) {
        this.blSplitNo = blSplitNo;
    }

    /**
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Column Info
	 * @param custZipId
	 */
    public void setCustZipId(String custZipId) {
        this.custZipId = custZipId;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public String getPodCd() {
        return this.podCd;
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
        setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
        setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
        setBlSplitNo(JSPUtil.getParameter(request, prefix + "bl_split_no", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustZipId(JSPUtil.getParameter(request, prefix + "cust_zip_id", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdvJpCustomerVO[]
	 */
    public AdvJpCustomerVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdvJpCustomerVO[]
	 */
    public AdvJpCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AdvJpCustomerVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] custAddr = (JSPUtil.getParameter(request, prefix + "cust_addr", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", length));
            String[] blSplitNo = (JSPUtil.getParameter(request, prefix + "bl_split_no", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custZipId = (JSPUtil.getParameter(request, prefix + "cust_zip_id", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AdvJpCustomerVO();
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (custAddr[i] != null)
                    model.setCustAddr(custAddr[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (bkgCustTpCd[i] != null)
                    model.setBkgCustTpCd(bkgCustTpCd[i]);
                if (blSplitNo[i] != null)
                    model.setBlSplitNo(blSplitNo[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custZipId[i] != null)
                    model.setCustZipId(custZipId[i]);
                if (podCd[i] != null) 
		    		model.setPodCd(podCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAdvJpCustomerVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AdvJpCustomerVO[]
	 */
    public AdvJpCustomerVO[] getAdvJpCustomerVOs() {
        AdvJpCustomerVO[] vos = (AdvJpCustomerVO[]) models.toArray(new AdvJpCustomerVO[models.size()]);
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
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custAddr = this.custAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustTpCd = this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blSplitNo = this.blSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custZipId = this.custZipId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
