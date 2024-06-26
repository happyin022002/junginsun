/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SearchCustGroupVO.java
*@FileTitle : SearchCustGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.27  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo;

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
public class SearchCustGroupVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchCustGroupVO> models = new ArrayList<SearchCustGroupVO>();

    /* Column Info */
    private String ofcCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String custGrpId = null;

    /* Column Info */
    private String mdmYn = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String custGrpNm = null;

    /* Column Info */
    private String no = null;

    /* Column Info */
    private String custGrpAbbrNm = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String vbsClssCd = null;

    /* Column Info */
    private String nbsClssCd1 = null;

    /* Column Info */
    private String nbsClssCd2 = null;

    /* Column Info */
    private String nbsClssCd3 = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchCustGroupVO() {
    }

    public SearchCustGroupVO(String ibflag, String pagerows, String no, String custGrpId, String custGrpNm, String ofcCd, String deltFlg, String mdmYn, String custGrpAbbrNm, String srepCd, String vbsClssCd, String nbsClssCd1, String nbsClssCd2, String nbsClssCd3) {
        this.ofcCd = ofcCd;
        this.ibflag = ibflag;
        this.custGrpId = custGrpId;
        this.mdmYn = mdmYn;
        this.deltFlg = deltFlg;
        this.custGrpNm = custGrpNm;
        this.no = no;
        this.custGrpAbbrNm = custGrpAbbrNm;
        this.pagerows = pagerows;
        this.srepCd = srepCd;
        this.vbsClssCd = vbsClssCd;
        this.nbsClssCd1 = nbsClssCd1;
        this.nbsClssCd2 = nbsClssCd2;
        this.nbsClssCd3 = nbsClssCd3;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cust_grp_id", getCustGrpId());
        this.hashColumns.put("mdm_yn", getMdmYn());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cust_grp_nm", getCustGrpNm());
        this.hashColumns.put("no", getNo());
        this.hashColumns.put("cust_grp_abbr_nm", getCustGrpAbbrNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
        this.hashColumns.put("nbs_clss_cd1", getNbsClssCd1());
        this.hashColumns.put("nbs_clss_cd2", getNbsClssCd2());
        this.hashColumns.put("nbs_clss_cd3", getNbsClssCd3());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cust_grp_id", "custGrpId");
        this.hashFields.put("mdm_yn", "mdmYn");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cust_grp_nm", "custGrpNm");
        this.hashFields.put("no", "no");
        this.hashFields.put("cust_grp_abbr_nm", "custGrpAbbrNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("vbs_clss_cd", "vbsClssCd");
        this.hashFields.put("nbs_clss_cd1", "nbsClssCd1");
        this.hashFields.put("nbs_clss_cd2", "nbsClssCd2");
        this.hashFields.put("nbs_clss_cd3", "nbsClssCd3");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
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
	 * @return custGrpId
	 */
    public String getCustGrpId() {
        return this.custGrpId;
    }

    /**
	 * Column Info
	 * @return mdmYn
	 */
    public String getMdmYn() {
        return this.mdmYn;
    }

    /**
	 * Column Info
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 * Column Info
	 * @return custGrpNm
	 */
    public String getCustGrpNm() {
        return this.custGrpNm;
    }

    /**
	 * Column Info
	 * @return no
	 */
    public String getNo() {
        return this.no;
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
	 * @param custGrpAbbrNm
	 */
    public String getCustGrpAbbrNm() {
        return custGrpAbbrNm;
    }

    /**
	 * Column Info
	 * @param custGrpAbbrNm
	 */
    public void setCustGrpAbbrNm(String custGrpAbbrNm) {
        this.custGrpAbbrNm = custGrpAbbrNm;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
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
	 * @param custGrpId
	 */
    public void setCustGrpId(String custGrpId) {
        this.custGrpId = custGrpId;
    }

    /**
	 * Column Info
	 * @param mdmYn
	 */
    public void setMdmYn(String mdmYn) {
        this.mdmYn = mdmYn;
    }

    /**
	 * Column Info
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Column Info
	 * @param custGrpNm
	 */
    public void setCustGrpNm(String custGrpNm) {
        this.custGrpNm = custGrpNm;
    }

    /**
	 * Column Info
	 * @param no
	 */
    public void setNo(String no) {
        this.no = no;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    public String getSrepCd() {
        return this.srepCd;
    }

    public void setVbsClssCd(String vbsClssCd) {
        this.vbsClssCd = vbsClssCd;
    }

    public String getVbsClssCd() {
        return this.vbsClssCd;
    }

    public void setNbsClssCd1(String nbsClssCd1) {
        this.nbsClssCd1 = nbsClssCd1;
    }

    public String getNbsClssCd1() {
        return this.nbsClssCd1;
    }

    public void setNbsClssCd2(String nbsClssCd2) {
        this.nbsClssCd2 = nbsClssCd2;
    }

    public String getNbsClssCd2() {
        return this.nbsClssCd2;
    }

    public void setNbsClssCd3(String nbsClssCd3) {
        this.nbsClssCd3 = nbsClssCd3;
    }

    public String getNbsClssCd3() {
        return this.nbsClssCd3;
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
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
        setMdmYn(JSPUtil.getParameter(request, prefix + "mdm_yn", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
        setNo(JSPUtil.getParameter(request, prefix + "no", ""));
        setCustGrpAbbrNm(JSPUtil.getParameter(request, prefix + "cust_grp_abbr_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
        setNbsClssCd1(JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", ""));
        setNbsClssCd2(JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", ""));
        setNbsClssCd3(JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustGroupVO[]
	 */
    public SearchCustGroupVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustGroupVO[]
	 */
    public SearchCustGroupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchCustGroupVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] custGrpId = (JSPUtil.getParameter(request, prefix + "cust_grp_id", length));
            String[] mdmYn = (JSPUtil.getParameter(request, prefix + "mdm_yn", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] custGrpNm = (JSPUtil.getParameter(request, prefix + "cust_grp_nm", length));
            String[] no = (JSPUtil.getParameter(request, prefix + "no", length));
            String[] custGrpAbbrNm = (JSPUtil.getParameter(request, prefix + "cust_grp_abbr_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] vbsClssCd = (JSPUtil.getParameter(request, prefix + "vbs_clss_cd", length));
            String[] nbsClssCd1 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", length));
            String[] nbsClssCd2 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", length));
            String[] nbsClssCd3 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", length));
				/* Add a Method line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchCustGroupVO();
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (custGrpId[i] != null)
                    model.setCustGrpId(custGrpId[i]);
                if (mdmYn[i] != null)
                    model.setMdmYn(mdmYn[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (custGrpNm[i] != null)
                    model.setCustGrpNm(custGrpNm[i]);
                if (no[i] != null)
                    model.setNo(no[i]);
                if (custGrpAbbrNm[i] != null)
                    model.setCustGrpAbbrNm(custGrpAbbrNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (srepCd[i] != null) 
		    		model.setSrepCd(srepCd[i]);
				if (vbsClssCd[i] != null) 
		    		model.setVbsClssCd(vbsClssCd[i]);
				if (nbsClssCd1[i] != null) 
		    		model.setNbsClssCd1(nbsClssCd1[i]);
				if (nbsClssCd2[i] != null) 
		    		model.setNbsClssCd2(nbsClssCd2[i]);
				if (nbsClssCd3[i] != null) 
		    		model.setNbsClssCd3(nbsClssCd3[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchCustGroupVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchCustGroupVO[]
	 */
    public SearchCustGroupVO[] getSearchCustGroupVOs() {
        SearchCustGroupVO[] vos = (SearchCustGroupVO[]) models.toArray(new SearchCustGroupVO[models.size()]);
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
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpId = this.custGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mdmYn = this.mdmYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpNm = this.custGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.no = this.no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpAbbrNm = this.custGrpAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vbsClssCd = this.vbsClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd1 = this.nbsClssCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd2 = this.nbsClssCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd3 = this.nbsClssCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
