/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustCoverTeamVO.java
*@FileTitle : CustCoverTeamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.08.05 박찬민 
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
 * @author 박찬민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CustCoverTeamVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustCoverTeamVO> models = new ArrayList<CustCoverTeamVO>();

    /* Column Info */
    private String deltFlg = null;

    /* Column Info */
    private String srepFlg = null;

    /* Column Info */
    private String preSrepCd = null;

    /* Column Info */
    private String srepFtNm = null;

    /* Column Info */
    private String mphnNo = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String srepAbbrNm = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String srepLtNm = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String srepPrmryFlg = null;

    /* Column Info */
    private String ofcCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String prntOfcCd = null;

    /* Column Info */
    private String chkSrepCd = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String opCd = null;

    /* Column Info */
    private String userId = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String srepNm = null;

    /* Column Info */
    private String intlMphnNo = null;

    /* Column Info */
    private String srepEml = null;

    /* Column Info */
    private String prmryChkFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CustCoverTeamVO() {
    }

    public CustCoverTeamVO(String ibflag, String pagerows, String srepPrmryFlg, String srepFtNm, String srepLtNm, String srepAbbrNm, String srepCd, String srepFlg, String ofcCd, String prntOfcCd, String mphnNo, String userId, String custCd, String custCntCd, String custSeq, String preSrepCd, String chkSrepCd, String deltFlg, String opCd, String srepNm, String intlMphnNo, String srepEml, String prmryChkFlg) {
        this.deltFlg = deltFlg;
        this.srepFlg = srepFlg;
        this.preSrepCd = preSrepCd;
        this.srepFtNm = srepFtNm;
        this.mphnNo = mphnNo;
        this.custSeq = custSeq;
        this.srepAbbrNm = srepAbbrNm;
        this.srepCd = srepCd;
        this.srepLtNm = srepLtNm;
        this.pagerows = pagerows;
        this.srepPrmryFlg = srepPrmryFlg;
        this.ofcCd = ofcCd;
        this.ibflag = ibflag;
        this.prntOfcCd = prntOfcCd;
        this.chkSrepCd = chkSrepCd;
        this.custCd = custCd;
        this.opCd = opCd;
        this.userId = userId;
        this.custCntCd = custCntCd;
        this.srepNm = srepNm;
        this.intlMphnNo = intlMphnNo;
        this.srepEml = srepEml;
        this.prmryChkFlg = prmryChkFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("srep_flg", getSrepFlg());
        this.hashColumns.put("pre_srep_cd", getPreSrepCd());
        this.hashColumns.put("srep_ft_nm", getSrepFtNm());
        this.hashColumns.put("mphn_no", getMphnNo());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("srep_abbr_nm", getSrepAbbrNm());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("srep_lt_nm", getSrepLtNm());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("srep_prmry_flg", getSrepPrmryFlg());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
        this.hashColumns.put("chk_srep_cd", getChkSrepCd());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("op_cd", getOpCd());
        this.hashColumns.put("user_id", getUserId());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("srep_nm", getSrepNm());
        this.hashColumns.put("intl_mphn_no", getIntlMphnNo());
        this.hashColumns.put("srep_eml", getSrepEml());
        this.hashColumns.put("prmry_chk_flg", getprmryChkFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("srep_flg", "srepFlg");
        this.hashFields.put("pre_srep_cd", "preSrepCd");
        this.hashFields.put("srep_ft_nm", "srepFtNm");
        this.hashFields.put("mphn_no", "mphnNo");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("srep_abbr_nm", "srepAbbrNm");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("srep_lt_nm", "srepLtNm");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("srep_prmry_flg", "srepPrmryFlg");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
        this.hashFields.put("chk_srep_cd", "chkSrepCd");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("op_cd", "opCd");
        this.hashFields.put("user_id", "userId");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("srep_nm", "srepNm");
        this.hashFields.put("intl_mphn_no", "intlMphnNo");
        this.hashFields.put("srep_eml", "srepEml");
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
	 * @return srepFlg
	 */
    public String getSrepFlg() {
        return this.srepFlg;
    }

    /**
	 * Column Info
	 * @return preSrepCd
	 */
    public String getPreSrepCd() {
        return this.preSrepCd;
    }

    /**
	 * Column Info
	 * @return srepFtNm
	 */
    public String getSrepFtNm() {
        return this.srepFtNm;
    }

    /**
	 * Column Info
	 * @return mphnNo
	 */
    public String getMphnNo() {
        return this.mphnNo;
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
	 * @return srepAbbrNm
	 */
    public String getSrepAbbrNm() {
        return this.srepAbbrNm;
    }

    /**
	 * Column Info
	 * @return srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
    }

    /**
	 * Column Info
	 * @return srepLtNm
	 */
    public String getSrepLtNm() {
        return this.srepLtNm;
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
	 * @return srepPrmryFlg
	 */
    public String getSrepPrmryFlg() {
        return this.srepPrmryFlg;
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
	 * @return prntOfcCd
	 */
    public String getPrntOfcCd() {
        return this.prntOfcCd;
    }

    /**
	 * Column Info
	 * @return chkSrepCd
	 */
    public String getChkSrepCd() {
        return this.chkSrepCd;
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
	 * @return opCd
	 */
    public String getOpCd() {
        return this.opCd;
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
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
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
	 * @param srepFlg
	 */
    public void setSrepFlg(String srepFlg) {
        this.srepFlg = srepFlg;
    }

    /**
	 * Column Info
	 * @param preSrepCd
	 */
    public void setPreSrepCd(String preSrepCd) {
        this.preSrepCd = preSrepCd;
    }

    /**
	 * Column Info
	 * @param srepFtNm
	 */
    public void setSrepFtNm(String srepFtNm) {
        this.srepFtNm = srepFtNm;
    }

    /**
	 * Column Info
	 * @param mphnNo
	 */
    public void setMphnNo(String mphnNo) {
        this.mphnNo = mphnNo;
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
	 * @param srepAbbrNm
	 */
    public void setSrepAbbrNm(String srepAbbrNm) {
        this.srepAbbrNm = srepAbbrNm;
    }

    /**
	 * Column Info
	 * @param srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
    }

    /**
	 * Column Info
	 * @param srepLtNm
	 */
    public void setSrepLtNm(String srepLtNm) {
        this.srepLtNm = srepLtNm;
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
	 * @param srepPrmryFlg
	 */
    public void setSrepPrmryFlg(String srepPrmryFlg) {
        this.srepPrmryFlg = srepPrmryFlg;
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
	 * @param prntOfcCd
	 */
    public void setPrntOfcCd(String prntOfcCd) {
        this.prntOfcCd = prntOfcCd;
    }

    /**
	 * Column Info
	 * @param chkSrepCd
	 */
    public void setChkSrepCd(String chkSrepCd) {
        this.chkSrepCd = chkSrepCd;
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
	 * @param opCd
	 */
    public void setOpCd(String opCd) {
        this.opCd = opCd;
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
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    public void setSrepNm(String srepNm) {
        this.srepNm = srepNm;
    }

    public String getSrepNm() {
        return this.srepNm;
    }

    public void setIntlMphnNo(String intlMphnNo) {
        this.intlMphnNo = intlMphnNo;
    }

    public String getIntlMphnNo() {
        return this.intlMphnNo;
    }

    public void setSrepEml(String srepEml) {
        this.srepEml = srepEml;
    }

    public String getSrepEml() {
        return this.srepEml;
    }

    public void setprmryChkFlg(String prmryChkFlg) {
        this.prmryChkFlg = prmryChkFlg;
    }

    public String getprmryChkFlg() {
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
        setSrepFlg(JSPUtil.getParameter(request, prefix + "srep_flg", ""));
        setPreSrepCd(JSPUtil.getParameter(request, prefix + "pre_srep_cd", ""));
        setSrepFtNm(JSPUtil.getParameter(request, prefix + "srep_ft_nm", ""));
        setMphnNo(JSPUtil.getParameter(request, prefix + "mphn_no", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setSrepAbbrNm(JSPUtil.getParameter(request, prefix + "srep_abbr_nm", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setSrepLtNm(JSPUtil.getParameter(request, prefix + "srep_lt_nm", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSrepPrmryFlg(JSPUtil.getParameter(request, prefix + "srep_prmry_flg", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
        setChkSrepCd(JSPUtil.getParameter(request, prefix + "chk_srep_cd", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setOpCd(JSPUtil.getParameter(request, prefix + "op_cd", ""));
        setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
        setIntlMphnNo(JSPUtil.getParameter(request, prefix + "intl_mphn_no", ""));
        setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
        setprmryChkFlg(JSPUtil.getParameter(request, prefix + "prmry_chk_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustCoverTeamVO[]
	 */
    public CustCoverTeamVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustCoverTeamVO[]
	 */
    public CustCoverTeamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustCoverTeamVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
            String[] srepFlg = (JSPUtil.getParameter(request, prefix + "srep_flg", length));
            String[] preSrepCd = (JSPUtil.getParameter(request, prefix + "pre_srep_cd", length));
            String[] srepFtNm = (JSPUtil.getParameter(request, prefix + "srep_ft_nm", length));
            String[] mphnNo = (JSPUtil.getParameter(request, prefix + "mphn_no", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] srepAbbrNm = (JSPUtil.getParameter(request, prefix + "srep_abbr_nm", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] srepLtNm = (JSPUtil.getParameter(request, prefix + "srep_lt_nm", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] srepPrmryFlg = (JSPUtil.getParameter(request, prefix + "srep_prmry_flg", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] prntOfcCd = (JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", length));
            String[] chkSrepCd = (JSPUtil.getParameter(request, prefix + "chk_srep_cd", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] opCd = (JSPUtil.getParameter(request, prefix + "op_cd", length));
            String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] srepNm = (JSPUtil.getParameter(request, prefix + "srep_nm", length));
            String[] intlMphnNo = (JSPUtil.getParameter(request, prefix + "intl_mphn_no", length));
            String[] srepEml = (JSPUtil.getParameter(request, prefix + "srep_eml", length));
            String[] prmryChkFlg = (JSPUtil.getParameter(request, prefix + "prmry_chk_flg", length));
				/* Add a Method line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustCoverTeamVO();
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (srepFlg[i] != null)
                    model.setSrepFlg(srepFlg[i]);
                if (preSrepCd[i] != null)
                    model.setPreSrepCd(preSrepCd[i]);
                if (srepFtNm[i] != null)
                    model.setSrepFtNm(srepFtNm[i]);
                if (mphnNo[i] != null)
                    model.setMphnNo(mphnNo[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (srepAbbrNm[i] != null)
                    model.setSrepAbbrNm(srepAbbrNm[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (srepLtNm[i] != null)
                    model.setSrepLtNm(srepLtNm[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (srepPrmryFlg[i] != null)
                    model.setSrepPrmryFlg(srepPrmryFlg[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (prntOfcCd[i] != null)
                    model.setPrntOfcCd(prntOfcCd[i]);
                if (chkSrepCd[i] != null)
                    model.setChkSrepCd(chkSrepCd[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (opCd[i] != null)
                    model.setOpCd(opCd[i]);
                if (userId[i] != null)
                    model.setUserId(userId[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (srepNm[i] != null)
                    model.setSrepNm(srepNm[i]);
                if (intlMphnNo[i] != null)
                    model.setIntlMphnNo(intlMphnNo[i]);
                if (srepEml[i] != null)
                    model.setSrepEml(srepEml[i]);
                if (prmryChkFlg[i] != null) 
		    		model.setprmryChkFlg(prmryChkFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCustCoverTeamVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CustCoverTeamVO[]
	 */
    public CustCoverTeamVO[] getCustCoverTeamVOs() {
        CustCoverTeamVO[] vos = (CustCoverTeamVO[]) models.toArray(new CustCoverTeamVO[models.size()]);
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
        this.srepFlg = this.srepFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preSrepCd = this.preSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepFtNm = this.srepFtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mphnNo = this.mphnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepAbbrNm = this.srepAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepLtNm = this.srepLtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepPrmryFlg = this.srepPrmryFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prntOfcCd = this.prntOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkSrepCd = this.chkSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opCd = this.opCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepNm = this.srepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intlMphnNo = this.intlMphnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepEml = this.srepEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prmryChkFlg = this.prmryChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
