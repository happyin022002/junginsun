/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsrSlipVO.java
*@FileTitle : CsrSlipVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.19 박희동 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CsrSlipVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CsrSlipVO> models = new ArrayList<CsrSlipVO>();

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String effDt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String issuer = null;

    /* Column Info */
    private String csrDesc = null;

    /* Column Info */
    private String aproFlg = null;

    /* Column Info */
    private String csrOffstNo = null;

    /* Column Info */
    private String slpIssDt = null;

    /* Column Info */
    private String csrLoclAmt = null;

    /* Column Info */
    private String csrLoclCurrCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String apRcvErrFlg = null;

    /* Column Info */
    private String apRcvErrRsn = null;

    /* Column Info */
    private String invStsCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CsrSlipVO() {
    }

    public CsrSlipVO(String ibflag, String pagerows, String aproFlg, String csrNo, String csrOffstNo, String slpIssDt, String effDt, String csrLoclCurrCd, String csrLoclAmt, String issuer, String csrDesc, String apRcvErrFlg, String apRcvErrRsn, String invStsCd) {
        this.csrNo = csrNo;
        this.effDt = effDt;
        this.ibflag = ibflag;
        this.issuer = issuer;
        this.csrDesc = csrDesc;
        this.aproFlg = aproFlg;
        this.csrOffstNo = csrOffstNo;
        this.slpIssDt = slpIssDt;
        this.csrLoclAmt = csrLoclAmt;
        this.csrLoclCurrCd = csrLoclCurrCd;
        this.pagerows = pagerows;
        this.apRcvErrFlg = apRcvErrFlg;
        this.apRcvErrRsn = apRcvErrRsn;
        this.invStsCd = invStsCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("issuer", getIssuer());
        this.hashColumns.put("csr_desc", getCsrDesc());
        this.hashColumns.put("apro_flg", getAproFlg());
        this.hashColumns.put("csr_offst_no", getCsrOffstNo());
        this.hashColumns.put("slp_iss_dt", getSlpIssDt());
        this.hashColumns.put("csr_locl_amt", getCsrLoclAmt());
        this.hashColumns.put("csr_locl_curr_cd", getCsrLoclCurrCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ap_rcv_err_flg", getApRcvErrFlg());
        this.hashColumns.put("ap_rcv_err_rsn", getApRcvErrRsn());
        this.hashColumns.put("inv_sts_cd", getInvStsCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("issuer", "issuer");
        this.hashFields.put("csr_desc", "csrDesc");
        this.hashFields.put("apro_flg", "aproFlg");
        this.hashFields.put("csr_offst_no", "csrOffstNo");
        this.hashFields.put("slp_iss_dt", "slpIssDt");
        this.hashFields.put("csr_locl_amt", "csrLoclAmt");
        this.hashFields.put("csr_locl_curr_cd", "csrLoclCurrCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ap_rcv_err_flg", "apRcvErrFlg");
        this.hashFields.put("ap_rcv_err_rsn", "apRcvErrRsn");
        this.hashFields.put("inv_sts_cd", "invStsCd");
        return this.hashFields;
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
	 * @return effDt
	 */
    public String getEffDt() {
        return this.effDt;
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
	 * @return issuer
	 */
    public String getIssuer() {
        return this.issuer;
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
	 * @return aproFlg
	 */
    public String getAproFlg() {
        return this.aproFlg;
    }

    /**
	 * Column Info
	 * @return csrOffstNo
	 */
    public String getCsrOffstNo() {
        return this.csrOffstNo;
    }

    /**
	 * Column Info
	 * @return slpIssDt
	 */
    public String getSlpIssDt() {
        return this.slpIssDt;
    }

    /**
	 * Column Info
	 * @return csrLoclAmt
	 */
    public String getCsrLoclAmt() {
        return this.csrLoclAmt;
    }

    /**
	 * Column Info
	 * @return csrLoclCurrCd
	 */
    public String getCsrLoclCurrCd() {
        return this.csrLoclCurrCd;
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
	 * @param csrNo
	 */
    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    /**
	 * Column Info
	 * @param effDt
	 */
    public void setEffDt(String effDt) {
        this.effDt = effDt;
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
	 * @param issuer
	 */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
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
	 * @param aproFlg
	 */
    public void setAproFlg(String aproFlg) {
        this.aproFlg = aproFlg;
    }

    /**
	 * Column Info
	 * @param csrOffstNo
	 */
    public void setCsrOffstNo(String csrOffstNo) {
        this.csrOffstNo = csrOffstNo;
    }

    /**
	 * Column Info
	 * @param slpIssDt
	 */
    public void setSlpIssDt(String slpIssDt) {
        this.slpIssDt = slpIssDt;
    }

    /**
	 * Column Info
	 * @param csrLoclAmt
	 */
    public void setCsrLoclAmt(String csrLoclAmt) {
        this.csrLoclAmt = csrLoclAmt;
    }

    /**
	 * Column Info
	 * @param csrLoclCurrCd
	 */
    public void setCsrLoclCurrCd(String csrLoclCurrCd) {
        this.csrLoclCurrCd = csrLoclCurrCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setApRcvErrFlg(String apRcvErrFlg) {
        this.apRcvErrFlg = apRcvErrFlg;
    }

    public String getApRcvErrFlg() {
        return this.apRcvErrFlg;
    }

    public void setApRcvErrRsn(String apRcvErrRsn) {
        this.apRcvErrRsn = apRcvErrRsn;
    }

    public String getApRcvErrRsn() {
        return this.apRcvErrRsn;
    }

    public void setInvStsCd(String invStsCd) {
        this.invStsCd = invStsCd;
    }

    public String getInvStsCd() {
        return this.invStsCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
        setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setIssuer(JSPUtil.getParameter(request, "issuer", ""));
        setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
        setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
        setCsrOffstNo(JSPUtil.getParameter(request, "csr_offst_no", ""));
        setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
        setCsrLoclAmt(JSPUtil.getParameter(request, "csr_locl_amt", ""));
        setCsrLoclCurrCd(JSPUtil.getParameter(request, "csr_locl_curr_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setApRcvErrFlg(JSPUtil.getParameter(request, "ap_rcv_err_flg", ""));
        setApRcvErrRsn(JSPUtil.getParameter(request, "ap_rcv_err_rsn", ""));
        setInvStsCd(JSPUtil.getParameter(request, "inv_sts_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CsrSlipVO[]
	 */
    public CsrSlipVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CsrSlipVO[]
	 */
    public CsrSlipVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CsrSlipVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] issuer = (JSPUtil.getParameter(request, prefix + "issuer", length));
            String[] csrDesc = (JSPUtil.getParameter(request, prefix + "csr_desc", length));
            String[] aproFlg = (JSPUtil.getParameter(request, prefix + "apro_flg", length));
            String[] csrOffstNo = (JSPUtil.getParameter(request, prefix + "csr_offst_no", length));
            String[] slpIssDt = (JSPUtil.getParameter(request, prefix + "slp_iss_dt", length));
            String[] csrLoclAmt = (JSPUtil.getParameter(request, prefix + "csr_locl_amt", length));
            String[] csrLoclCurrCd = (JSPUtil.getParameter(request, prefix + "csr_locl_curr_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] apRcvErrFlg = (JSPUtil.getParameter(request, prefix + "ap_rcv_err_flg", length));
            String[] apRcvErrRsn = (JSPUtil.getParameter(request, prefix + "ap_rcv_err_rsn", length));
            String[] invStsCd = (JSPUtil.getParameter(request, prefix + "inv_sts_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CsrSlipVO();
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (issuer[i] != null)
                    model.setIssuer(issuer[i]);
                if (csrDesc[i] != null)
                    model.setCsrDesc(csrDesc[i]);
                if (aproFlg[i] != null)
                    model.setAproFlg(aproFlg[i]);
                if (csrOffstNo[i] != null)
                    model.setCsrOffstNo(csrOffstNo[i]);
                if (slpIssDt[i] != null)
                    model.setSlpIssDt(slpIssDt[i]);
                if (csrLoclAmt[i] != null)
                    model.setCsrLoclAmt(csrLoclAmt[i]);
                if (csrLoclCurrCd[i] != null)
                    model.setCsrLoclCurrCd(csrLoclCurrCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (apRcvErrFlg[i] != null)
                    model.setApRcvErrFlg(apRcvErrFlg[i]);
                if (apRcvErrRsn[i] != null)
                    model.setApRcvErrRsn(apRcvErrRsn[i]);
                if (invStsCd[i] != null) 
		    		model.setInvStsCd(invStsCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCsrSlipVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CsrSlipVO[]
	 */
    public CsrSlipVO[] getCsrSlipVOs() {
        CsrSlipVO[] vos = (CsrSlipVO[]) models.toArray(new CsrSlipVO[models.size()]);
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
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issuer = this.issuer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrDesc = this.csrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproFlg = this.aproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrOffstNo = this.csrOffstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpIssDt = this.slpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrLoclAmt = this.csrLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrLoclCurrCd = this.csrLoclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apRcvErrFlg = this.apRcvErrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apRcvErrRsn = this.apRcvErrRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invStsCd = this.invStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
