/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchBunkerVO.java
*@FileTitle : SearchBunkerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.02.01 윤세영 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchBunkerVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchBunkerVO> models = new ArrayList<SearchBunkerVO>();

    /* Column Info */
    private String acctItmNm = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String bunkerVvd = null;

    /* Column Info */
    private String fletMeasUtCd = null;

    /* Column Info */
    private String bnkPrcAmt = null;

    /* Column Info */
    private String totalAmt = null;

    /* Column Info */
    private String bnkYrmon = null;

    /* Column Info */
    private String bnkSeq = null;

    /* Column Info */
    private String bnkTpCd = null;

    /* Column Info */
    private String bnkDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String fletCtrtNo = null;

    /* Column Info */
    private String acctItmSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String bnkAmt = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String bnkQty = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String slpTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchBunkerVO() {
    }

    public SearchBunkerVO(String ibflag, String pagerows, String fletCtrtNo, String bnkSeq, String bnkYrmon, String bnkTpCd, String acctCd, String acctItmSeq, String acctItmNm, String bnkDt, String vslCd, String portCd, String fletMeasUtCd, String bnkQty, String bnkPrcAmt, String bnkAmt, String totalAmt, String bunkerVvd, String slpTpCd) {
        this.acctItmNm = acctItmNm;
        this.vslCd = vslCd;
        this.bunkerVvd = bunkerVvd;
        this.fletMeasUtCd = fletMeasUtCd;
        this.bnkPrcAmt = bnkPrcAmt;
        this.totalAmt = totalAmt;
        this.bnkYrmon = bnkYrmon;
        this.bnkSeq = bnkSeq;
        this.bnkTpCd = bnkTpCd;
        this.bnkDt = bnkDt;
        this.pagerows = pagerows;
        this.fletCtrtNo = fletCtrtNo;
        this.acctItmSeq = acctItmSeq;
        this.ibflag = ibflag;
        this.bnkAmt = bnkAmt;
        this.acctCd = acctCd;
        this.bnkQty = bnkQty;
        this.portCd = portCd;
        this.slpTpCd = slpTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("acct_itm_nm", getAcctItmNm());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("bunker_vvd", getBunkerVvd());
        this.hashColumns.put("flet_meas_ut_cd", getFletMeasUtCd());
        this.hashColumns.put("bnk_prc_amt", getBnkPrcAmt());
        this.hashColumns.put("total_amt", getTotalAmt());
        this.hashColumns.put("bnk_yrmon", getBnkYrmon());
        this.hashColumns.put("bnk_seq", getBnkSeq());
        this.hashColumns.put("bnk_tp_cd", getBnkTpCd());
        this.hashColumns.put("bnk_dt", getBnkDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
        this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bnk_amt", getBnkAmt());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("bnk_qty", getBnkQty());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("slp_tp_cd", getSlpTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("acct_itm_nm", "acctItmNm");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("bunker_vvd", "bunkerVvd");
        this.hashFields.put("flet_meas_ut_cd", "fletMeasUtCd");
        this.hashFields.put("bnk_prc_amt", "bnkPrcAmt");
        this.hashFields.put("total_amt", "totalAmt");
        this.hashFields.put("bnk_yrmon", "bnkYrmon");
        this.hashFields.put("bnk_seq", "bnkSeq");
        this.hashFields.put("bnk_tp_cd", "bnkTpCd");
        this.hashFields.put("bnk_dt", "bnkDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
        this.hashFields.put("acct_itm_seq", "acctItmSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bnk_amt", "bnkAmt");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("bnk_qty", "bnkQty");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("slp_tp_cd", "slpTpCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return acctItmNm
	 */
    public String getAcctItmNm() {
        return this.acctItmNm;
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
	 * @return bunkerVvd
	 */
    public String getBunkerVvd() {
        return this.bunkerVvd;
    }

    /**
	 * Column Info
	 * @return fletMeasUtCd
	 */
    public String getFletMeasUtCd() {
        return this.fletMeasUtCd;
    }

    /**
	 * Column Info
	 * @return bnkPrcAmt
	 */
    public String getBnkPrcAmt() {
        return this.bnkPrcAmt;
    }

    /**
	 * Column Info
	 * @return totalAmt
	 */
    public String getTotalAmt() {
        return this.totalAmt;
    }

    /**
	 * Column Info
	 * @return bnkYrmon
	 */
    public String getBnkYrmon() {
        return this.bnkYrmon;
    }

    /**
	 * Column Info
	 * @return bnkSeq
	 */
    public String getBnkSeq() {
        return this.bnkSeq;
    }

    /**
	 * Column Info
	 * @return bnkTpCd
	 */
    public String getBnkTpCd() {
        return this.bnkTpCd;
    }

    /**
	 * Column Info
	 * @return bnkDt
	 */
    public String getBnkDt() {
        return this.bnkDt;
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
	 * @return fletCtrtNo
	 */
    public String getFletCtrtNo() {
        return this.fletCtrtNo;
    }

    /**
	 * Column Info
	 * @return acctItmSeq
	 */
    public String getAcctItmSeq() {
        return this.acctItmSeq;
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
	 * @return bnkAmt
	 */
    public String getBnkAmt() {
        return this.bnkAmt;
    }

    /**
	 * Column Info
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return bnkQty
	 */
    public String getBnkQty() {
        return this.bnkQty;
    }

    /**
	 * Column Info
	 * @return portCd
	 */
    public String getPortCd() {
        return this.portCd;
    }

    /**
	 * Column Info
	 * @param acctItmNm
	 */
    public void setAcctItmNm(String acctItmNm) {
        this.acctItmNm = acctItmNm;
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
	 * @param bunkerVvd
	 */
    public void setBunkerVvd(String bunkerVvd) {
        this.bunkerVvd = bunkerVvd;
    }

    /**
	 * Column Info
	 * @param fletMeasUtCd
	 */
    public void setFletMeasUtCd(String fletMeasUtCd) {
        this.fletMeasUtCd = fletMeasUtCd;
    }

    /**
	 * Column Info
	 * @param bnkPrcAmt
	 */
    public void setBnkPrcAmt(String bnkPrcAmt) {
        this.bnkPrcAmt = bnkPrcAmt;
    }

    /**
	 * Column Info
	 * @param totalAmt
	 */
    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    /**
	 * Column Info
	 * @param bnkYrmon
	 */
    public void setBnkYrmon(String bnkYrmon) {
        this.bnkYrmon = bnkYrmon;
    }

    /**
	 * Column Info
	 * @param bnkSeq
	 */
    public void setBnkSeq(String bnkSeq) {
        this.bnkSeq = bnkSeq;
    }

    /**
	 * Column Info
	 * @param bnkTpCd
	 */
    public void setBnkTpCd(String bnkTpCd) {
        this.bnkTpCd = bnkTpCd;
    }

    /**
	 * Column Info
	 * @param bnkDt
	 */
    public void setBnkDt(String bnkDt) {
        this.bnkDt = bnkDt;
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
	 * @param fletCtrtNo
	 */
    public void setFletCtrtNo(String fletCtrtNo) {
        this.fletCtrtNo = fletCtrtNo;
    }

    /**
	 * Column Info
	 * @param acctItmSeq
	 */
    public void setAcctItmSeq(String acctItmSeq) {
        this.acctItmSeq = acctItmSeq;
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
	 * @param bnkAmt
	 */
    public void setBnkAmt(String bnkAmt) {
        this.bnkAmt = bnkAmt;
    }

    /**
	 * Column Info
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param bnkQty
	 */
    public void setBnkQty(String bnkQty) {
        this.bnkQty = bnkQty;
    }

    /**
	 * Column Info
	 * @param portCd
	 */
    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    public void setSlpTpCd(String slpTpCd) {
        this.slpTpCd = slpTpCd;
    }

    public String getSlpTpCd() {
        return this.slpTpCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setBunkerVvd(JSPUtil.getParameter(request, "bunker_vvd", ""));
        setFletMeasUtCd(JSPUtil.getParameter(request, "flet_meas_ut_cd", ""));
        setBnkPrcAmt(JSPUtil.getParameter(request, "bnk_prc_amt", ""));
        setTotalAmt(JSPUtil.getParameter(request, "total_amt", ""));
        setBnkYrmon(JSPUtil.getParameter(request, "bnk_yrmon", ""));
        setBnkSeq(JSPUtil.getParameter(request, "bnk_seq", ""));
        setBnkTpCd(JSPUtil.getParameter(request, "bnk_tp_cd", ""));
        setBnkDt(JSPUtil.getParameter(request, "bnk_dt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
        setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setBnkAmt(JSPUtil.getParameter(request, "bnk_amt", ""));
        setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
        setBnkQty(JSPUtil.getParameter(request, "bnk_qty", ""));
        setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
        setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBunkerVO[]
	 */
    public SearchBunkerVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBunkerVO[]
	 */
    public SearchBunkerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchBunkerVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] acctItmNm = (JSPUtil.getParameter(request, prefix + "acct_itm_nm", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] bunkerVvd = (JSPUtil.getParameter(request, prefix + "bunker_vvd", length));
            String[] fletMeasUtCd = (JSPUtil.getParameter(request, prefix + "flet_meas_ut_cd", length));
            String[] bnkPrcAmt = (JSPUtil.getParameter(request, prefix + "bnk_prc_amt", length));
            String[] totalAmt = (JSPUtil.getParameter(request, prefix + "total_amt", length));
            String[] bnkYrmon = (JSPUtil.getParameter(request, prefix + "bnk_yrmon", length));
            String[] bnkSeq = (JSPUtil.getParameter(request, prefix + "bnk_seq", length));
            String[] bnkTpCd = (JSPUtil.getParameter(request, prefix + "bnk_tp_cd", length));
            String[] bnkDt = (JSPUtil.getParameter(request, prefix + "bnk_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix + "flet_ctrt_no", length));
            String[] acctItmSeq = (JSPUtil.getParameter(request, prefix + "acct_itm_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] bnkAmt = (JSPUtil.getParameter(request, prefix + "bnk_amt", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] bnkQty = (JSPUtil.getParameter(request, prefix + "bnk_qty", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] slpTpCd = (JSPUtil.getParameter(request, prefix + "slp_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchBunkerVO();
                if (acctItmNm[i] != null)
                    model.setAcctItmNm(acctItmNm[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (bunkerVvd[i] != null)
                    model.setBunkerVvd(bunkerVvd[i]);
                if (fletMeasUtCd[i] != null)
                    model.setFletMeasUtCd(fletMeasUtCd[i]);
                if (bnkPrcAmt[i] != null)
                    model.setBnkPrcAmt(bnkPrcAmt[i]);
                if (totalAmt[i] != null)
                    model.setTotalAmt(totalAmt[i]);
                if (bnkYrmon[i] != null)
                    model.setBnkYrmon(bnkYrmon[i]);
                if (bnkSeq[i] != null)
                    model.setBnkSeq(bnkSeq[i]);
                if (bnkTpCd[i] != null)
                    model.setBnkTpCd(bnkTpCd[i]);
                if (bnkDt[i] != null)
                    model.setBnkDt(bnkDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fletCtrtNo[i] != null)
                    model.setFletCtrtNo(fletCtrtNo[i]);
                if (acctItmSeq[i] != null)
                    model.setAcctItmSeq(acctItmSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (bnkAmt[i] != null)
                    model.setBnkAmt(bnkAmt[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (bnkQty[i] != null)
                    model.setBnkQty(bnkQty[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (slpTpCd[i] != null) 
		    		model.setSlpTpCd(slpTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchBunkerVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchBunkerVO[]
	 */
    public SearchBunkerVO[] getSearchBunkerVOs() {
        SearchBunkerVO[] vos = (SearchBunkerVO[]) models.toArray(new SearchBunkerVO[models.size()]);
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
        this.acctItmNm = this.acctItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bunkerVvd = this.bunkerVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletMeasUtCd = this.fletMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkPrcAmt = this.bnkPrcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalAmt = this.totalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkYrmon = this.bnkYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkSeq = this.bnkSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkTpCd = this.bnkTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkDt = this.bnkDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtNo = this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctItmSeq = this.acctItmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkAmt = this.bnkAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bnkQty = this.bnkQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpTpCd = this.slpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
