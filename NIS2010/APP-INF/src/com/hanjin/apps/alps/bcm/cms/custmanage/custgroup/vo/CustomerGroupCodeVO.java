/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustomerGroupCodeVO.java
*@FileTitle : CustomerGroupCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.29
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2012.02.29 서미진 
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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CustomerGroupCodeVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustomerGroupCodeVO> models = new ArrayList<CustomerGroupCodeVO>();

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String eaiIfId = null;

    /* Column Info */
    private String srepCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vbsClssCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String custGrpNm = null;

    /* Column Info */
    private String matchRule = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custGrpAbbrNm = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String member = null;

    /* Column Info */
    private String custGrpId = null;

    /* Column Info */
    private String eaiEvntDt = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String custLglEngNm = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String nbsClssCd1 = null;

    /* Column Info */
    private String nbsClssCd2 = null;

    /* Column Info */
    private String nbsClssCd3 = null;

    /* Column Info */
    private String prmryChkFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CustomerGroupCodeVO() {
    }

    public CustomerGroupCodeVO(String ibflag, String pagerows, String custGrpId, String custLglEngNm, String ofcCd, String srepCd, String vbsClssCd, String nbsClssCd1, String nbsClssCd2, String nbsClssCd3, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String eaiIfId, String custGrpAbbrNm, String member, String locCd, String custGrpNm, String matchRule, String custCd, String custCntCd, String custSeq, String prmryChkFlg) {
        this.deltFlg = deltFlg;
        this.creDt = creDt;
        this.eaiIfId = eaiIfId;
        this.srepCd = srepCd;
        this.pagerows = pagerows;
        this.vbsClssCd = vbsClssCd;
        this.ibflag = ibflag;
        this.locCd = locCd;
        this.custGrpNm = custGrpNm;
        this.matchRule = matchRule;
        this.updUsrId = updUsrId;
        this.custCntCd = custCntCd;
        this.custGrpAbbrNm = custGrpAbbrNm;
        this.updDt = updDt;
        this.member = member;
        this.custGrpId = custGrpId;
        this.eaiEvntDt = eaiEvntDt;
        this.custSeq = custSeq;
        this.custLglEngNm = custLglEngNm;
        this.ofcCd = ofcCd;
        this.creUsrId = creUsrId;
        this.custCd = custCd;
        this.nbsClssCd1 = nbsClssCd1;
        this.nbsClssCd2 = nbsClssCd2;
        this.nbsClssCd3 = nbsClssCd3;
        this.prmryChkFlg = prmryChkFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("eai_if_id", getEaiIfId());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vbs_clss_cd", getVbsClssCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("cust_grp_nm", getCustGrpNm());
        this.hashColumns.put("match_rule", getMatchRule());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_grp_abbr_nm", getCustGrpAbbrNm());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("member", getMember());
        this.hashColumns.put("cust_grp_id", getCustGrpId());
        this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("nbs_clss_cd1", getNbsClssCd1());
        this.hashColumns.put("nbs_clss_cd2", getNbsClssCd2());
        this.hashColumns.put("nbs_clss_cd3", getNbsClssCd3());
        this.hashColumns.put("prmry_chk_flg", getPrmryChkFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("eai_if_id", "eaiIfId");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vbs_clss_cd", "vbsClssCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("cust_grp_nm", "custGrpNm");
        this.hashFields.put("match_rule", "matchRule");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_grp_abbr_nm", "custGrpAbbrNm");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("member", "member");
        this.hashFields.put("cust_grp_id", "custGrpId");
        this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("nbs_clss_cd1", "nbsClssCd1");
        this.hashFields.put("nbs_clss_cd2", "nbsClssCd2");
        this.hashFields.put("nbs_clss_cd3", "nbsClssCd3");
        this.hashFields.put("prmry_chk_flg", "prmryChkFlg");
        return this.hashFields;
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
	 * @return vbsClssCd
	 */
    public String getVbsClssCd() {
        return this.vbsClssCd;
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
	 * @return custGrpNm
	 */
    public String getCustGrpNm() {
        return this.custGrpNm;
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
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
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
	 * @return custGrpAbbrNm
	 */
    public String getCustGrpAbbrNm() {
        return this.custGrpAbbrNm;
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
	 * @return member
	 */
    public String getMember() {
        return this.member;
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
	 * @return eaiEvntDt
	 */
    public String getEaiEvntDt() {
        return this.eaiEvntDt;
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
	 * @return custLglEngNm
	 */
    public String getCustLglEngNm() {
        return this.custLglEngNm;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
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
	 * @param vbsClssCd
	 */
    public void setVbsClssCd(String vbsClssCd) {
        this.vbsClssCd = vbsClssCd;
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
	 * @param custGrpNm
	 */
    public void setCustGrpNm(String custGrpNm) {
        this.custGrpNm = custGrpNm;
    }

    /**
	 * Column Info
	 * @param matchRule
	 */
    public void setMatchRule(String matchRule) {
        this.matchRule = matchRule;
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
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
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
	 * @param updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param member
	 */
    public void setMember(String member) {
        this.member = member;
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
	 * @param eaiEvntDt
	 */
    public void setEaiEvntDt(String eaiEvntDt) {
        this.eaiEvntDt = eaiEvntDt;
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
	 * @param custLglEngNm
	 */
    public void setCustLglEngNm(String custLglEngNm) {
        this.custLglEngNm = custLglEngNm;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
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

    public void setPrmryChkFlg(String prmryChkFlg) {
        this.prmryChkFlg = prmryChkFlg;
    }

    public String getPrmryChkFlg() {
        return this.prmryChkFlg;
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
        setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVbsClssCd(JSPUtil.getParameter(request, prefix + "vbs_clss_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
        setMatchRule(JSPUtil.getParameter(request, prefix + "match_rule", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustGrpAbbrNm(JSPUtil.getParameter(request, prefix + "cust_grp_abbr_nm", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setMember(JSPUtil.getParameter(request, prefix + "member", ""));
        setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
        setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setNbsClssCd1(JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", ""));
        setNbsClssCd2(JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", ""));
        setNbsClssCd3(JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", ""));
        setPrmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerGroupCodeVO[]
	 */
    public CustomerGroupCodeVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerGroupCodeVO[]
	 */
    public CustomerGroupCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustomerGroupCodeVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] eaiIfId = (JSPUtil.getParameter(request, prefix + "eai_if_id", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vbsClssCd = (JSPUtil.getParameter(request, prefix + "vbs_clss_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] custGrpNm = (JSPUtil.getParameter(request, prefix + "cust_grp_nm", length));
            String[] matchRule = (JSPUtil.getParameter(request, prefix + "match_rule", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custGrpAbbrNm = (JSPUtil.getParameter(request, prefix + "cust_grp_abbr_nm", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] member = (JSPUtil.getParameter(request, prefix + "member", length));
            String[] custGrpId = (JSPUtil.getParameter(request, prefix + "cust_grp_id", length));
            String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix + "eai_evnt_dt", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] nbsClssCd1 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd1", length));
            String[] nbsClssCd2 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd2", length));
            String[] nbsClssCd3 = (JSPUtil.getParameter(request, prefix + "nbs_clss_cd3", length));
            String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix + "prmry_chk_flg", length));
				/* Add a Method line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustomerGroupCodeVO();
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (eaiIfId[i] != null)
                    model.setEaiIfId(eaiIfId[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vbsClssCd[i] != null)
                    model.setVbsClssCd(vbsClssCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (custGrpNm[i] != null)
                    model.setCustGrpNm(custGrpNm[i]);
                if (matchRule[i] != null)
                    model.setMatchRule(matchRule[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custGrpAbbrNm[i] != null)
                    model.setCustGrpAbbrNm(custGrpAbbrNm[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (member[i] != null)
                    model.setMember(member[i]);
                if (custGrpId[i] != null)
                    model.setCustGrpId(custGrpId[i]);
                if (eaiEvntDt[i] != null)
                    model.setEaiEvntDt(eaiEvntDt[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (custLglEngNm[i] != null)
                    model.setCustLglEngNm(custLglEngNm[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (nbsClssCd1[i] != null)
                    model.setNbsClssCd1(nbsClssCd1[i]);
                if (nbsClssCd2[i] != null)
                    model.setNbsClssCd2(nbsClssCd2[i]);
                if (nbsClssCd3[i] != null)
                    model.setNbsClssCd3(nbsClssCd3[i]);
                if (prmryChkFlg[i] != null) 
		    		model.setPrmryChkFlg(prmryChkFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCustomerGroupCodeVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CustomerGroupCodeVO[]
	 */
    public CustomerGroupCodeVO[] getCustomerGroupCodeVOs() {
        CustomerGroupCodeVO[] vos = (CustomerGroupCodeVO[]) models.toArray(new CustomerGroupCodeVO[models.size()]);
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
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiIfId = this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vbsClssCd = this.vbsClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpNm = this.custGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.matchRule = this.matchRule.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpAbbrNm = this.custGrpAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.member = this.member.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGrpId = this.custGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eaiEvntDt = this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd1 = this.nbsClssCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd2 = this.nbsClssCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nbsClssCd3 = this.nbsClssCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmryChkFlg = this.prmryChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
