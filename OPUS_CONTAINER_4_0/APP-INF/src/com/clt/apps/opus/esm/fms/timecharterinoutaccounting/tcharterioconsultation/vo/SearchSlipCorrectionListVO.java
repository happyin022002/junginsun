/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSlipCorrectionListVO.java
*@FileTitle : SearchSlipCorrectionListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.03 정윤태 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchSlipCorrectionListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchSlipCorrectionListVO> models = new ArrayList<SearchSlipCorrectionListVO>();

    /* Column Info */
    private String rqstAmt = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String producedBy = null;

    /* Column Info */
    private String cxlFlg = null;

    /* Column Info */
    private String csrDt = null;

    /* Column Info */
    private String csrCurrCd = null;

    /* Column Info */
    private String csrDesc = null;

    /* Column Info */
    private String evidTp = null;

    /* Column Info */
    private String diffDesc = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String requestTeam = null;

    /* Column Info */
    private String cxlDesc = null;

    /* Column Info */
    private String ownrCd = null;

    /* Column Info */
    private String deduction = null;

    /* Column Info */
    private String csrAmt = null;

    /* Column Info */
    private String ownrNm = null;

    /* Column Info */
    private String aproFlg = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String invStsCd = null;

    /* Column Info */
    private String ownrFullNm = null;

    /* Column Info */
    private String ownrTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchSlipCorrectionListVO() {
    }

    public SearchSlipCorrectionListVO(String ibflag, String pagerows, String aproFlg, String csrNo, String csrDt, String producedBy, String csrCurrCd, String csrAmt, String csrDesc, String requestTeam, String rqstDt, String ownrCd, String ownrNm, String evidTp, String deduction, String rqstAmt, String diffDesc, String cxlFlg, String cxlDesc, String vslCd, String vslEngNm, String invStsCd, String ownrFullNm, String ownrTpCd) {
        this.rqstAmt = rqstAmt;
        this.csrNo = csrNo;
        this.rqstDt = rqstDt;
        this.producedBy = producedBy;
        this.cxlFlg = cxlFlg;
        this.csrDt = csrDt;
        this.csrCurrCd = csrCurrCd;
        this.csrDesc = csrDesc;
        this.evidTp = evidTp;
        this.diffDesc = diffDesc;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.requestTeam = requestTeam;
        this.cxlDesc = cxlDesc;
        this.ownrCd = ownrCd;
        this.deduction = deduction;
        this.csrAmt = csrAmt;
        this.ownrNm = ownrNm;
        this.aproFlg = aproFlg;
        this.vslCd = vslCd;
        this.vslEngNm = vslEngNm;
        this.invStsCd = invStsCd;
        this.ownrFullNm = ownrFullNm;
        this.ownrTpCd = ownrTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("rqst_amt", getRqstAmt());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("produced_by", getProducedBy());
        this.hashColumns.put("cxl_flg", getCxlFlg());
        this.hashColumns.put("csr_dt", getCsrDt());
        this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
        this.hashColumns.put("csr_desc", getCsrDesc());
        this.hashColumns.put("evid_tp", getEvidTp());
        this.hashColumns.put("diff_desc", getDiffDesc());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("request_team", getRequestTeam());
        this.hashColumns.put("cxl_desc", getCxlDesc());
        this.hashColumns.put("ownr_cd", getOwnrCd());
        this.hashColumns.put("deduction", getDeduction());
        this.hashColumns.put("csr_amt", getCsrAmt());
        this.hashColumns.put("ownr_nm", getOwnrNm());
        this.hashColumns.put("apro_flg", getAproFlg());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("inv_sts_cd", getInvStsCd());
        this.hashColumns.put("ownr_full_nm", getOwnrFullNm());
        this.hashColumns.put("ownr_tp_cd", getOwnrTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("rqst_amt", "rqstAmt");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("produced_by", "producedBy");
        this.hashFields.put("cxl_flg", "cxlFlg");
        this.hashFields.put("csr_dt", "csrDt");
        this.hashFields.put("csr_curr_cd", "csrCurrCd");
        this.hashFields.put("csr_desc", "csrDesc");
        this.hashFields.put("evid_tp", "evidTp");
        this.hashFields.put("diff_desc", "diffDesc");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("request_team", "requestTeam");
        this.hashFields.put("cxl_desc", "cxlDesc");
        this.hashFields.put("ownr_cd", "ownrCd");
        this.hashFields.put("deduction", "deduction");
        this.hashFields.put("csr_amt", "csrAmt");
        this.hashFields.put("ownr_nm", "ownrNm");
        this.hashFields.put("apro_flg", "aproFlg");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("inv_sts_cd", "invStsCd");
        this.hashFields.put("ownr_full_nm", "ownrFullNm");
        this.hashFields.put("ownr_tp_cd", "ownrTpCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rqstAmt
	 */
    public String getRqstAmt() {
        return this.rqstAmt;
    }

    /**
	 * Column Info
	 * @return csrNo
	 */
    public String getCsrNo() {
        return this.csrNo;
    }

    /**
	 * Column Info
	 * @return rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	 * Column Info
	 * @return producedBy
	 */
    public String getProducedBy() {
        return this.producedBy;
    }

    /**
	 * Column Info
	 * @return cxlFlg
	 */
    public String getCxlFlg() {
        return this.cxlFlg;
    }

    /**
	 * Column Info
	 * @return csrDt
	 */
    public String getCsrDt() {
        return this.csrDt;
    }

    /**
	 * Column Info
	 * @return csrCurrCd
	 */
    public String getCsrCurrCd() {
        return this.csrCurrCd;
    }

    /**
	 * Column Info
	 * @return csrDesc
	 */
    public String getCsrDesc() {
        return this.csrDesc;
    }

    /**
	 * Column Info
	 * @return evidTp
	 */
    public String getEvidTp() {
        return this.evidTp;
    }

    /**
	 * Column Info
	 * @return diffDesc
	 */
    public String getDiffDesc() {
        return this.diffDesc;
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
	 * @return requestTeam
	 */
    public String getRequestTeam() {
        return this.requestTeam;
    }

    /**
	 * Column Info
	 * @return cxlDesc
	 */
    public String getCxlDesc() {
        return this.cxlDesc;
    }

    /**
	 * Column Info
	 * @return ownrCd
	 */
    public String getOwnrCd() {
        return this.ownrCd;
    }

    /**
	 * Column Info
	 * @return deduction
	 */
    public String getDeduction() {
        return this.deduction;
    }

    /**
	 * Column Info
	 * @return csrAmt
	 */
    public String getCsrAmt() {
        return this.csrAmt;
    }

    /**
	 * Column Info
	 * @return ownrNm
	 */
    public String getOwnrNm() {
        return this.ownrNm;
    }

    /**
	 * Column Info
	 * @return aproFlg
	 */
    public String getAproFlg() {
        return this.aproFlg;
    }

    /**
	 * Column Info
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 * Column Info
	 * @param rqstAmt
	 */
    public void setRqstAmt(String rqstAmt) {
        this.rqstAmt = rqstAmt;
    }

    /**
	 * Column Info
	 * @param csrNo
	 */
    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    /**
	 * Column Info
	 * @param rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * Column Info
	 * @param producedBy
	 */
    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    /**
	 * Column Info
	 * @param cxlFlg
	 */
    public void setCxlFlg(String cxlFlg) {
        this.cxlFlg = cxlFlg;
    }

    /**
	 * Column Info
	 * @param csrDt
	 */
    public void setCsrDt(String csrDt) {
        this.csrDt = csrDt;
    }

    /**
	 * Column Info
	 * @param csrCurrCd
	 */
    public void setCsrCurrCd(String csrCurrCd) {
        this.csrCurrCd = csrCurrCd;
    }

    /**
	 * Column Info
	 * @param csrDesc
	 */
    public void setCsrDesc(String csrDesc) {
        this.csrDesc = csrDesc;
    }

    /**
	 * Column Info
	 * @param evidTp
	 */
    public void setEvidTp(String evidTp) {
        this.evidTp = evidTp;
    }

    /**
	 * Column Info
	 * @param diffDesc
	 */
    public void setDiffDesc(String diffDesc) {
        this.diffDesc = diffDesc;
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
	 * @param requestTeam
	 */
    public void setRequestTeam(String requestTeam) {
        this.requestTeam = requestTeam;
    }

    /**
	 * Column Info
	 * @param cxlDesc
	 */
    public void setCxlDesc(String cxlDesc) {
        this.cxlDesc = cxlDesc;
    }

    /**
	 * Column Info
	 * @param ownrCd
	 */
    public void setOwnrCd(String ownrCd) {
        this.ownrCd = ownrCd;
    }

    /**
	 * Column Info
	 * @param deduction
	 */
    public void setDeduction(String deduction) {
        this.deduction = deduction;
    }

    /**
	 * Column Info
	 * @param csrAmt
	 */
    public void setCsrAmt(String csrAmt) {
        this.csrAmt = csrAmt;
    }

    /**
	 * Column Info
	 * @param ownrNm
	 */
    public void setOwnrNm(String ownrNm) {
        this.ownrNm = ownrNm;
    }

    /**
	 * Column Info
	 * @param aproFlg
	 */
    public void setAproFlg(String aproFlg) {
        this.aproFlg = aproFlg;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    public void setInvStsCd(String invStsCd) {
        this.invStsCd = invStsCd;
    }

    public String getInvStsCd() {
        return this.invStsCd;
    }

    public void setOwnrFullNm(String ownrFullNm) {
        this.ownrFullNm = ownrFullNm;
    }

    public String getOwnrFullNm() {
        return this.ownrFullNm;
    }

    public void setOwnrTpCd(String ownrTpCd) {
        this.ownrTpCd = ownrTpCd;
    }

    public String getOwnrTpCd() {
        return this.ownrTpCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setRqstAmt(JSPUtil.getParameter(request, "rqst_amt", ""));
        setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
        setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
        setProducedBy(JSPUtil.getParameter(request, "produced_by", ""));
        setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
        setCsrDt(JSPUtil.getParameter(request, "csr_dt", ""));
        setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
        setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
        setEvidTp(JSPUtil.getParameter(request, "evid_tp", ""));
        setDiffDesc(JSPUtil.getParameter(request, "diff_desc", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setRequestTeam(JSPUtil.getParameter(request, "request_team", ""));
        setCxlDesc(JSPUtil.getParameter(request, "cxl_desc", ""));
        setOwnrCd(JSPUtil.getParameter(request, "ownr_cd", ""));
        setDeduction(JSPUtil.getParameter(request, "deduction", ""));
        setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
        setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
        setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
        setInvStsCd(JSPUtil.getParameter(request, "inv_sts_cd", ""));
        setOwnrFullNm(JSPUtil.getParameter(request, "ownr_full_nm", ""));
        setOwnrTpCd(JSPUtil.getParameter(request, "ownr_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSlipCorrectionListVO[]
	 */
    public SearchSlipCorrectionListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSlipCorrectionListVO[]
	 */
    public SearchSlipCorrectionListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchSlipCorrectionListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rqstAmt = (JSPUtil.getParameter(request, prefix + "rqst_amt", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] producedBy = (JSPUtil.getParameter(request, prefix + "produced_by", length));
            String[] cxlFlg = (JSPUtil.getParameter(request, prefix + "cxl_flg", length));
            String[] csrDt = (JSPUtil.getParameter(request, prefix + "csr_dt", length));
            String[] csrCurrCd = (JSPUtil.getParameter(request, prefix + "csr_curr_cd", length));
            String[] csrDesc = (JSPUtil.getParameter(request, prefix + "csr_desc", length));
            String[] evidTp = (JSPUtil.getParameter(request, prefix + "evid_tp", length));
            String[] diffDesc = (JSPUtil.getParameter(request, prefix + "diff_desc", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] requestTeam = (JSPUtil.getParameter(request, prefix + "request_team", length));
            String[] cxlDesc = (JSPUtil.getParameter(request, prefix + "cxl_desc", length));
            String[] ownrCd = (JSPUtil.getParameter(request, prefix + "ownr_cd", length));
            String[] deduction = (JSPUtil.getParameter(request, prefix + "deduction", length));
            String[] csrAmt = (JSPUtil.getParameter(request, prefix + "csr_amt", length));
            String[] ownrNm = (JSPUtil.getParameter(request, prefix + "ownr_nm", length));
            String[] aproFlg = (JSPUtil.getParameter(request, prefix + "apro_flg", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] invStsCd = (JSPUtil.getParameter(request, prefix + "inv_sts_cd", length));
            String[] ownrFullNm = (JSPUtil.getParameter(request, prefix + "ownr_full_nm", length));
            String[] ownrTpCd = (JSPUtil.getParameter(request, prefix + "ownr_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchSlipCorrectionListVO();
                if (rqstAmt[i] != null)
                    model.setRqstAmt(rqstAmt[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (producedBy[i] != null)
                    model.setProducedBy(producedBy[i]);
                if (cxlFlg[i] != null)
                    model.setCxlFlg(cxlFlg[i]);
                if (csrDt[i] != null)
                    model.setCsrDt(csrDt[i]);
                if (csrCurrCd[i] != null)
                    model.setCsrCurrCd(csrCurrCd[i]);
                if (csrDesc[i] != null)
                    model.setCsrDesc(csrDesc[i]);
                if (evidTp[i] != null)
                    model.setEvidTp(evidTp[i]);
                if (diffDesc[i] != null)
                    model.setDiffDesc(diffDesc[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (requestTeam[i] != null)
                    model.setRequestTeam(requestTeam[i]);
                if (cxlDesc[i] != null)
                    model.setCxlDesc(cxlDesc[i]);
                if (ownrCd[i] != null)
                    model.setOwnrCd(ownrCd[i]);
                if (deduction[i] != null)
                    model.setDeduction(deduction[i]);
                if (csrAmt[i] != null)
                    model.setCsrAmt(csrAmt[i]);
                if (ownrNm[i] != null)
                    model.setOwnrNm(ownrNm[i]);
                if (aproFlg[i] != null)
                    model.setAproFlg(aproFlg[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (invStsCd[i] != null)
                    model.setInvStsCd(invStsCd[i]);
                if (ownrFullNm[i] != null)
                    model.setOwnrFullNm(ownrFullNm[i]);
                if (ownrTpCd[i] != null) 
		    		model.setOwnrTpCd(ownrTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchSlipCorrectionListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchSlipCorrectionListVO[]
	 */
    public SearchSlipCorrectionListVO[] getSearchSlipCorrectionListVOs() {
        SearchSlipCorrectionListVO[] vos = (SearchSlipCorrectionListVO[]) models.toArray(new SearchSlipCorrectionListVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.rqstAmt = this.rqstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.producedBy = this.producedBy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cxlFlg = this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrDt = this.csrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrCurrCd = this.csrCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrDesc = this.csrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.evidTp = this.evidTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffDesc = this.diffDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.requestTeam = this.requestTeam.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cxlDesc = this.cxlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ownrCd = this.ownrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deduction = this.deduction.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrAmt = this.csrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ownrNm = this.ownrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproFlg = this.aproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invStsCd = this.invStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ownrFullNm = this.ownrFullNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ownrTpCd = this.ownrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
