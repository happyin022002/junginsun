/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SearchCustPerfCodeVO.java
*@FileTitle : SearchCustPerfCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.23  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo;

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
public class CustomerPerformanceVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustomerPerformanceVO> models = new ArrayList<CustomerPerformanceVO>();

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String custGrpId = null;

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String eaiIfId = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Column Info */
    private String srepCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String ofcCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vbsClssCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String custGrpNm = null;

    /* Column Info */
    private String nbsClssCd1 = null;

    /* Column Info */
    private String nbsClssCd2 = null;

    /* Column Info */
    private String nbsClssCd3 = null;

    /* Column Info */
    private String updUsrId = null;

    private String custGrpAbbrNm = null;

    private String matchRule = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String custStsCd = null;

    /* Column Info */
    private String grpIndivDiv = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CustomerPerformanceVO() {
    }

    public CustomerPerformanceVO(String ibflag, String pagerows, String custGrpId, String custGrpNm, String ofcCd, String srepCd, String vbsClssCd, String nbsClssCd1, String nbsClssCd2, String nbsClssCd3, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String eaiIfId, String custGrpAbbrNm, String matchRule, String custCntCd, String custSeq, String custCd, String custStsCd, String grpIndivDiv) {
        this.updDt = updDt;
        this.custGrpId = custGrpId;
        this.deltFlg = deltFlg;
        this.creDt = creDt;
        this.eaiIfId = eaiIfId;
        this.eaiEvntDt = eaiEvntDt;
        this.srepCd = srepCd;
        this.pagerows = pagerows;
        this.ofcCd = ofcCd;
        this.ibflag = ibflag;
        this.vbsClssCd = vbsClssCd;
        this.creUsrId = creUsrId;
        this.custGrpNm = custGrpNm;
        this.nbsClssCd1 = nbsClssCd1;
        this.nbsClssCd2 = nbsClssCd2;
        this.nbsClssCd3 = nbsClssCd3;
        this.updUsrId = updUsrId;
        this.custGrpAbbrNm = custGrpAbbrNm;
        this.matchRule = matchRule;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.custCd = custCd;
        this.custStsCd = custStsCd;
        this.grpIndivDiv = grpIndivDiv;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cust_grp_id", getCustGrpId());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("eai_if_id", getEaiIfId());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cust_grp_nm", getCustGrpNm());
        this.hashColumns.put("nbs_clss_cd1", getNbsClssCd1());
        this.hashColumns.put("nbs_clss_cd2", getNbsClssCd2());
        this.hashColumns.put("nbs_clss_cd3", getNbsClssCd3());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cust_grp_abbr_nm", getCustGrpAbbrNm());
        this.hashColumns.put("match_rule", getMatchRule());
        this.hashColumns.put("cust_cnt_cd", getcustCntCd());
        this.hashColumns.put("cust_seq", getcustSeq());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("cust_sts_cd", getCustStsCd());
        this.hashColumns.put("grp_indiv_div", getGrpIndivDiv());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cust_grp_id", "custGrpId");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("eai_if_id", "eaiIfId");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vbs_clss_cd", "vbsClssCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cust_grp_nm", "custGrpNm");
        this.hashFields.put("nbs_clss_cd1", "nbsClssCd1");
        this.hashFields.put("nbs_clss_cd2", "nbsClssCd2");
        this.hashFields.put("nbs_clss_cd3", "nbsClssCd3");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cust_grp_abbr_nm", "custGrpAbbrNm");
        this.hashFields.put("match_rule", "matchRule");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("cust_sts_cd", "custStsCd");
        this.hashFields.put("grp_indiv_div", "grpIndivDiv");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
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
	 * @return deltFlg
	 */
    public String getDeltFlg() {
        return this.deltFlg;
    }

    /**
	 * Column Info
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 * Column Info
	 * @return eaiIfId
	 */
    public String getEaiIfId() {
        return this.eaiIfId;
    }

    /**
	 * Column Info
	 * @return eaiEvntDt
	 */
    public String getEaiEvntDt() {
        return this.eaiEvntDt;
    }

    /**
	 * Column Info
	 * @return srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return vbsClssCd
	 */
    public String getVbsClssCd() {
        return this.vbsClssCd;
    }

    /**
	 * Column Info
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
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
	 * @return nbsClssCd1
	 */
    public String getNbsClssCd1() {
        return this.nbsClssCd1;
    }

    /**
	 * Column Info
	 * @return nbsClssCd2
	 */
    public String getNbsClssCd2() {
        return this.nbsClssCd2;
    }

    /**
	 * Column Info
	 * @return nbsClssCd3
	 */
    public String getNbsClssCd3() {
        return this.nbsClssCd3;
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
	 * @return custGrpAbbrNm
	 */
    public String getCustGrpAbbrNm() {
        return this.custGrpAbbrNm;
    }

    /**
	 * Column Info
	 * @return matchRule
	 */
    public String getMatchRule() {
        return this.matchRule;
    }

    /**
	 * Column Info
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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
	 * @param deltFlg
	 */
    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    /**
	 * Column Info
	 * @param creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param eaiIfId
	 */
    public void setEaiIfId(String eaiIfId) {
        this.eaiIfId = eaiIfId;
    }

    /**
	 * Column Info
	 * @param eaiEvntDt
	 */
    public void setEaiEvntDt(String eaiEvntDt) {
        this.eaiEvntDt = eaiEvntDt;
    }

    /**
	 * Column Info
	 * @param srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param vbsClssCd
	 */
    public void setVbsClssCd(String vbsClssCd) {
        this.vbsClssCd = vbsClssCd;
    }

    /**
	 * Column Info
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
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
	 * @param nbsClssCd1
	 */
    public void setNbsClssCd1(String nbsClssCd1) {
        this.nbsClssCd1 = nbsClssCd1;
    }

    /**
	 * Column Info
	 * @param nbsClssCd2
	 */
    public void setNbsClssCd2(String nbsClssCd2) {
        this.nbsClssCd2 = nbsClssCd2;
    }

    /**
	 * Column Info
	 * @param nbsClssCd3
	 */
    public void setNbsClssCd3(String nbsClssCd3) {
        this.nbsClssCd3 = nbsClssCd3;
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
	 * @param custGrpAbbrNm
	 */
    public void setCustGrpAbbrNm(String custGrpAbbrNm) {
        this.custGrpAbbrNm = custGrpAbbrNm;
    }

    /**
	 * Column Info
	 * @param matchRule
	 */
    public void setMatchRule(String matchRule) {
        this.matchRule = matchRule;
    }

    public void setcustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    public String getcustCntCd() {
        return this.custCntCd;
    }

    public void setcustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    public String getcustSeq() {
        return this.custSeq;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setCustStsCd(String custStsCd) {
        this.custStsCd = custStsCd;
    }

    public String getCustStsCd() {
        return this.custStsCd;
    }

    public void setGrpIndivDiv(String grpIndivDiv) {
        this.grpIndivDiv = grpIndivDiv;
    }

    public String getGrpIndivDiv() {
        return this.grpIndivDiv;
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
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
        setNbsClssCd1(JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", ""));
        setNbsClssCd2(JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", ""));
        setNbsClssCd3(JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCustGrpAbbrNm(JSPUtil.getParameter(request, prefix + "cust_grp_abbr_nm", ""));
        setMatchRule(JSPUtil.getParameter(request, prefix + "match_rule", ""));
        setcustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setcustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setCustStsCd(JSPUtil.getParameter(request, prefix + "cust_sts_cd", ""));
        setGrpIndivDiv(JSPUtil.getParameter(request, prefix + "grp_indiv_div", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustPerfCodeVO[]
	 */
    public CustomerPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustPerfCodeVO[]
	 */
    public CustomerPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustomerPerformanceVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] custGrpId = (JSPUtil.getParameter(request, prefix + "cust_grp_id", length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vbsClssCd = (JSPUtil.getParameter(request, prefix + "vbs_clss_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] custGrpNm = (JSPUtil.getParameter(request, prefix + "cust_grp_nm", length));
            String[] nbsClssCd1 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", length));
            String[] nbsClssCd2 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", length));
            String[] nbsClssCd3 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] custGrpAbbrNm = (JSPUtil.getParameter(request, prefix + "cust_grp_abbr_nm", length));
            String[] matchRule = (JSPUtil.getParameter(request, prefix + "match_rule", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] custStsCd = (JSPUtil.getParameter(request, prefix + "cust_sts_cd", length));
            String[] grpIndivDiv = (JSPUtil.getParameter(request, prefix + "grp_indiv_div", length));
				/* Add a Method line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustomerPerformanceVO();
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (custGrpId[i] != null)
                    model.setCustGrpId(custGrpId[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (eaiIfId[i] != null)
                    model.setEaiIfId(eaiIfId[i]);
                if (eaiEvntDt[i] != null)
                    model.setEaiEvntDt(eaiEvntDt[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vbsClssCd[i] != null)
                    model.setVbsClssCd(vbsClssCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (custGrpNm[i] != null)
                    model.setCustGrpNm(custGrpNm[i]);
                if (nbsClssCd1[i] != null)
                    model.setNbsClssCd1(nbsClssCd1[i]);
                if (nbsClssCd2[i] != null)
                    model.setNbsClssCd2(nbsClssCd2[i]);
                if (nbsClssCd3[i] != null)
                    model.setNbsClssCd3(nbsClssCd3[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (custGrpAbbrNm[i] != null)
                    model.setCustGrpAbbrNm(custGrpAbbrNm[i]);
                if (matchRule[i] != null)
                    model.setMatchRule(matchRule[i]);
                if (custCntCd[i] != null)
                    model.setcustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setcustSeq(custSeq[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (custStsCd[i] != null)
                    model.setCustStsCd(custStsCd[i]);
                if (grpIndivDiv[i] != null) 
		    		model.setGrpIndivDiv(grpIndivDiv[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchCustPerfCodeVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchCustPerfCodeVO[]
	 */
    public CustomerPerformanceVO[] getSearchCustPerfCodeVOs() {
        CustomerPerformanceVO[] vos = (CustomerPerformanceVO[]) models.toArray(new CustomerPerformanceVO[models.size()]);
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
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpId = this.custGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vbsClssCd = this.vbsClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpNm = this.custGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd1 = this.nbsClssCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd2 = this.nbsClssCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd3 = this.nbsClssCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpAbbrNm = this.custGrpAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.matchRule = this.matchRule.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custStsCd = this.custStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpIndivDiv = this.grpIndivDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
