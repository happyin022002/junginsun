/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerInqChoiceVO.java
*@FileTitle : CustomerInqChoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.15 이중환 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CustomerInqChoiceVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustomerInqChoiceVO> models = new ArrayList<CustomerInqChoiceVO>();

    /* Column Info */
    private String ediGrpDesc = null;

    /* Column Info */
    private String ediGrpCd = null;

    /* Column Info */
    private String custEdiStsCd = null;

    /* Column Info */
    private String csCd = null;

    /* Column Info */
    private String csGrpId = null;

    /* Column Info */
    private String ediStndStsCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ediCgoRmk = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String ediGrpId = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String userId = null;

    /* Column Info */
    private String custTrdPrnrId = null;

    /* Column Info */
    private String tpId = null;

    /* Column Info */
    private String csNm = null;

    /* Column Info */
    private String ediStsSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CustomerInqChoiceVO() {
    }

    public CustomerInqChoiceVO(String ibflag, String pagerows, String csCd, String scNo, String tpId, String csNm, String ediGrpCd, String custTrdPrnrId, String ediGrpDesc, String ediGrpId, String ediStndStsCd, String custEdiStsCd, String ediCgoRmk, String userId, String csGrpId, String ediStsSeq) {
        this.ediGrpDesc = ediGrpDesc;
        this.ediGrpCd = ediGrpCd;
        this.custEdiStsCd = custEdiStsCd;
        this.csCd = csCd;
        this.csGrpId = csGrpId;
        this.ediStndStsCd = ediStndStsCd;
        this.pagerows = pagerows;
        this.ediCgoRmk = ediCgoRmk;
        this.ibflag = ibflag;
        this.ediGrpId = ediGrpId;
        this.scNo = scNo;
        this.userId = userId;
        this.custTrdPrnrId = custTrdPrnrId;
        this.tpId = tpId;
        this.csNm = csNm;
        this.ediStsSeq = ediStsSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("edi_grp_desc", getEdiGrpDesc());
        this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
        this.hashColumns.put("cust_edi_sts_cd", getCustEdiStsCd());
        this.hashColumns.put("cs_cd", getCsCd());
        this.hashColumns.put("cs_grp_id", getCsGrpId());
        this.hashColumns.put("edi_stnd_sts_cd", getEdiStndStsCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("edi_cgo_rmk", getEdiCgoRmk());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("edi_grp_id", getEdiGrpId());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("user_id", getUserId());
        this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
        this.hashColumns.put("tp_id", getTpId());
        this.hashColumns.put("cs_nm", getCsNm());
        this.hashColumns.put("edi_sts_seq", getEdiStsSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("edi_grp_desc", "ediGrpDesc");
        this.hashFields.put("edi_grp_cd", "ediGrpCd");
        this.hashFields.put("cust_edi_sts_cd", "custEdiStsCd");
        this.hashFields.put("cs_cd", "csCd");
        this.hashFields.put("cs_grp_id", "csGrpId");
        this.hashFields.put("edi_stnd_sts_cd", "ediStndStsCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("edi_cgo_rmk", "ediCgoRmk");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("edi_grp_id", "ediGrpId");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("user_id", "userId");
        this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
        this.hashFields.put("tp_id", "tpId");
        this.hashFields.put("cs_nm", "csNm");
        this.hashFields.put("edi_sts_seq", "ediStsSeq");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ediGrpDesc
	 */
    public String getEdiGrpDesc() {
        return this.ediGrpDesc;
    }

    /**
	 * Column Info
	 * @return ediGrpCd
	 */
    public String getEdiGrpCd() {
        return this.ediGrpCd;
    }

    /**
	 * Column Info
	 * @return custEdiStsCd
	 */
    public String getCustEdiStsCd() {
        return this.custEdiStsCd;
    }

    /**
	 * Column Info
	 * @return csCd
	 */
    public String getCsCd() {
        return this.csCd;
    }

    /**
	 * Column Info
	 * @return csGrpId
	 */
    public String getCsGrpId() {
        return this.csGrpId;
    }

    /**
	 * Column Info
	 * @return ediStndStsCd
	 */
    public String getEdiStndStsCd() {
        return this.ediStndStsCd;
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
	 * @return ediCgoRmk
	 */
    public String getEdiCgoRmk() {
        return this.ediCgoRmk;
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
	 * @return ediGrpId
	 */
    public String getEdiGrpId() {
        return this.ediGrpId;
    }

    /**
	 * Column Info
	 * @return scNo
	 */
    public String getScNo() {
        return this.scNo;
    }

    /**
	 * Column Info
	 * @return userId
	 */
    public String getUserId() {
        return this.userId;
    }

    /**
	 * Column Info
	 * @return custTrdPrnrId
	 */
    public String getCustTrdPrnrId() {
        return this.custTrdPrnrId;
    }

    /**
	 * Column Info
	 * @return tpId
	 */
    public String getTpId() {
        return this.tpId;
    }

    /**
	 * Column Info
	 * @return csNm
	 */
    public String getCsNm() {
        return this.csNm;
    }

    /**
	 * Column Info
	 * @param ediGrpDesc
	 */
    public void setEdiGrpDesc(String ediGrpDesc) {
        this.ediGrpDesc = ediGrpDesc;
    }

    /**
	 * Column Info
	 * @param ediGrpCd
	 */
    public void setEdiGrpCd(String ediGrpCd) {
        this.ediGrpCd = ediGrpCd;
    }

    /**
	 * Column Info
	 * @param custEdiStsCd
	 */
    public void setCustEdiStsCd(String custEdiStsCd) {
        this.custEdiStsCd = custEdiStsCd;
    }

    /**
	 * Column Info
	 * @param csCd
	 */
    public void setCsCd(String csCd) {
        this.csCd = csCd;
    }

    /**
	 * Column Info
	 * @param csGrpId
	 */
    public void setCsGrpId(String csGrpId) {
        this.csGrpId = csGrpId;
    }

    /**
	 * Column Info
	 * @param ediStndStsCd
	 */
    public void setEdiStndStsCd(String ediStndStsCd) {
        this.ediStndStsCd = ediStndStsCd;
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
	 * @param ediCgoRmk
	 */
    public void setEdiCgoRmk(String ediCgoRmk) {
        this.ediCgoRmk = ediCgoRmk;
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
	 * @param ediGrpId
	 */
    public void setEdiGrpId(String ediGrpId) {
        this.ediGrpId = ediGrpId;
    }

    /**
	 * Column Info
	 * @param scNo
	 */
    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    /**
	 * Column Info
	 * @param userId
	 */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
	 * Column Info
	 * @param custTrdPrnrId
	 */
    public void setCustTrdPrnrId(String custTrdPrnrId) {
        this.custTrdPrnrId = custTrdPrnrId;
    }

    /**
	 * Column Info
	 * @param tpId
	 */
    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    /**
	 * Column Info
	 * @param csNm
	 */
    public void setCsNm(String csNm) {
        this.csNm = csNm;
    }

    public void setEdiStsSeq(String ediStsSeq) {
        this.ediStsSeq = ediStsSeq;
    }

    public String getEdiStsSeq() {
        return this.ediStsSeq;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setEdiGrpDesc(JSPUtil.getParameter(request, "edi_grp_desc", ""));
        setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
        setCustEdiStsCd(JSPUtil.getParameter(request, "cust_edi_sts_cd", ""));
        setCsCd(JSPUtil.getParameter(request, "cs_cd", ""));
        setCsGrpId(JSPUtil.getParameter(request, "cs_grp_id", ""));
        setEdiStndStsCd(JSPUtil.getParameter(request, "edi_stnd_sts_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setEdiCgoRmk(JSPUtil.getParameter(request, "edi_cgo_rmk", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setEdiGrpId(JSPUtil.getParameter(request, "edi_grp_id", ""));
        setScNo(JSPUtil.getParameter(request, "sc_no", ""));
        setUserId(JSPUtil.getParameter(request, "user_id", ""));
        setCustTrdPrnrId(JSPUtil.getParameter(request, "cust_trd_prnr_id", ""));
        setTpId(JSPUtil.getParameter(request, "tp_id", ""));
        setCsNm(JSPUtil.getParameter(request, "cs_nm", ""));
        setEdiStsSeq(JSPUtil.getParameter(request, "edi_sts_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerInqChoiceVO[]
	 */
    public CustomerInqChoiceVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerInqChoiceVO[]
	 */
    public CustomerInqChoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustomerInqChoiceVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ediGrpDesc = (JSPUtil.getParameter(request, prefix + "edi_grp_desc", length));
            String[] ediGrpCd = (JSPUtil.getParameter(request, prefix + "edi_grp_cd", length));
            String[] custEdiStsCd = (JSPUtil.getParameter(request, prefix + "cust_edi_sts_cd", length));
            String[] csCd = (JSPUtil.getParameter(request, prefix + "cs_cd", length));
            String[] csGrpId = (JSPUtil.getParameter(request, prefix + "cs_grp_id", length));
            String[] ediStndStsCd = (JSPUtil.getParameter(request, prefix + "edi_stnd_sts_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ediCgoRmk = (JSPUtil.getParameter(request, prefix + "edi_cgo_rmk", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ediGrpId = (JSPUtil.getParameter(request, prefix + "edi_grp_id", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
            String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", length));
            String[] tpId = (JSPUtil.getParameter(request, prefix + "tp_id", length));
            String[] csNm = (JSPUtil.getParameter(request, prefix + "cs_nm", length));
            String[] ediStsSeq = (JSPUtil.getParameter(request, prefix + "edi_sts_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustomerInqChoiceVO();
                if (ediGrpDesc[i] != null)
                    model.setEdiGrpDesc(ediGrpDesc[i]);
                if (ediGrpCd[i] != null)
                    model.setEdiGrpCd(ediGrpCd[i]);
                if (custEdiStsCd[i] != null)
                    model.setCustEdiStsCd(custEdiStsCd[i]);
                if (csCd[i] != null)
                    model.setCsCd(csCd[i]);
                if (csGrpId[i] != null)
                    model.setCsGrpId(csGrpId[i]);
                if (ediStndStsCd[i] != null)
                    model.setEdiStndStsCd(ediStndStsCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ediCgoRmk[i] != null)
                    model.setEdiCgoRmk(ediCgoRmk[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ediGrpId[i] != null)
                    model.setEdiGrpId(ediGrpId[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (userId[i] != null)
                    model.setUserId(userId[i]);
                if (custTrdPrnrId[i] != null)
                    model.setCustTrdPrnrId(custTrdPrnrId[i]);
                if (tpId[i] != null)
                    model.setTpId(tpId[i]);
                if (csNm[i] != null)
                    model.setCsNm(csNm[i]);
                if (ediStsSeq[i] != null) 
		    		model.setEdiStsSeq(ediStsSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCustomerInqChoiceVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CustomerInqChoiceVO[]
	 */
    public CustomerInqChoiceVO[] getCustomerInqChoiceVOs() {
        CustomerInqChoiceVO[] vos = (CustomerInqChoiceVO[]) models.toArray(new CustomerInqChoiceVO[models.size()]);
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
        this.ediGrpDesc = this.ediGrpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediGrpCd = this.ediGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custEdiStsCd = this.custEdiStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csCd = this.csCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csGrpId = this.csGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediStndStsCd = this.ediStndStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediCgoRmk = this.ediCgoRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediGrpId = this.ediGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custTrdPrnrId = this.custTrdPrnrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tpId = this.tpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csNm = this.csNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediStsSeq = this.ediStsSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
