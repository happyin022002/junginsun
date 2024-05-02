/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SimulationInvoiceListVO.java
*@FileTitle : SimulationInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.03.03 정명훈 
* 1.0 Creation
* 
* History
* 2010.11.22 진마리아 CHM-201006692-01 Port charge simulation 이 터미널별로 한번에 계산이 될수 있도록 멀티 기능 추가
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SimulationInvoiceListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SimulationInvoiceListVO> models = new ArrayList<SimulationInvoiceListVO>();

    /* Column Info */
    private String rmk = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String dpIoBndCd = null;

    /* Column Info */
    private String fomlDesc = null;

    /* Column Info */
    private String loclAmt = null;

    /* Column Info */
    private String adjAmt = null;

    /* Column Info */
    private String calcAmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vndrNm = null;

    /* Column Info */
    private String invNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String usdAmt = null;

    /* Column Info */
    private String totalI = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String invTotal = null;

    /* Column Info */
    private String xprDesc = null;

    /* Column Info */
    private String totalO = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String costCd = null;

    /* Column Info */
    private String lgsCostFullNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SimulationInvoiceListVO() {
    }

    public SimulationInvoiceListVO(String ibflag, String pagerows, String rmk, String invNo, String usdAmt, String currCd, String fomlDesc, String invTotal, String loclAmt, String xprDesc, String calcAmt, String adjAmt, String vndrSeq, String vndrNm, String dpIoBndCd, String totalI, String totalO, String acctCd, String costCd, String lgsCostFullNm) {
        this.rmk = rmk;
        this.currCd = currCd;
        this.dpIoBndCd = dpIoBndCd;
        this.fomlDesc = fomlDesc;
        this.loclAmt = loclAmt;
        this.adjAmt = adjAmt;
        this.calcAmt = calcAmt;
        this.pagerows = pagerows;
        this.vndrNm = vndrNm;
        this.invNo = invNo;
        this.ibflag = ibflag;
        this.usdAmt = usdAmt;
        this.totalI = totalI;
        this.vndrSeq = vndrSeq;
        this.invTotal = invTotal;
        this.xprDesc = xprDesc;
        this.totalO = totalO;
        this.acctCd = acctCd;
        this.costCd = costCd;
        this.lgsCostFullNm = lgsCostFullNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("rmk", getRmk());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("dp_io_bnd_cd", getDpIoBndCd());
        this.hashColumns.put("foml_desc", getFomlDesc());
        this.hashColumns.put("locl_amt", getLoclAmt());
        this.hashColumns.put("adj_amt", getAdjAmt());
        this.hashColumns.put("calc_amt", getCalcAmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_nm", getVndrNm());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("usd_amt", getUsdAmt());
        this.hashColumns.put("total_i", getTotalI());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("inv_total", getInvTotal());
        this.hashColumns.put("xpr_desc", getXprDesc());
        this.hashColumns.put("total_o", getTotalO());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("cost_cd", getCostCd());
        this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("rmk", "rmk");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("dp_io_bnd_cd", "dpIoBndCd");
        this.hashFields.put("foml_desc", "fomlDesc");
        this.hashFields.put("locl_amt", "loclAmt");
        this.hashFields.put("adj_amt", "adjAmt");
        this.hashFields.put("calc_amt", "calcAmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_nm", "vndrNm");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("usd_amt", "usdAmt");
        this.hashFields.put("total_i", "totalI");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("inv_total", "invTotal");
        this.hashFields.put("xpr_desc", "xprDesc");
        this.hashFields.put("total_o", "totalO");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("cost_cd", "costCd");
        this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rmk
	 */
    public String getRmk() {
        return this.rmk;
    }

    /**
	 * Column Info
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return dpIoBndCd
	 */
    public String getDpIoBndCd() {
        return this.dpIoBndCd;
    }

    /**
	 * Column Info
	 * @return fomlDesc
	 */
    public String getFomlDesc() {
        return this.fomlDesc;
    }

    /**
	 * Column Info
	 * @return loclAmt
	 */
    public String getLoclAmt() {
        return this.loclAmt;
    }

    /**
	 * Column Info
	 * @return adjAmt
	 */
    public String getAdjAmt() {
        return this.adjAmt;
    }

    /**
	 * Column Info
	 * @return calcAmt
	 */
    public String getCalcAmt() {
        return this.calcAmt;
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
	 * @return vndrNm
	 */
    public String getVndrNm() {
        return this.vndrNm;
    }

    /**
	 * Column Info
	 * @return invNo
	 */
    public String getInvNo() {
        return this.invNo;
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
	 * @return usdAmt
	 */
    public String getUsdAmt() {
        return this.usdAmt;
    }

    /**
	 * Column Info
	 * @return totalI
	 */
    public String getTotalI() {
        return this.totalI;
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
	 * @return invTotal
	 */
    public String getInvTotal() {
        return this.invTotal;
    }

    /**
	 * Column Info
	 * @return xprDesc
	 */
    public String getXprDesc() {
        return this.xprDesc;
    }

    /**
	 * Column Info
	 * @return totalO
	 */
    public String getTotalO() {
        return this.totalO;
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
	 * @param rmk
	 */
    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    /**
	 * Column Info
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param dpIoBndCd
	 */
    public void setDpIoBndCd(String dpIoBndCd) {
        this.dpIoBndCd = dpIoBndCd;
    }

    /**
	 * Column Info
	 * @param fomlDesc
	 */
    public void setFomlDesc(String fomlDesc) {
        this.fomlDesc = fomlDesc;
    }

    /**
	 * Column Info
	 * @param loclAmt
	 */
    public void setLoclAmt(String loclAmt) {
        this.loclAmt = loclAmt;
    }

    /**
	 * Column Info
	 * @param adjAmt
	 */
    public void setAdjAmt(String adjAmt) {
        this.adjAmt = adjAmt;
    }

    /**
	 * Column Info
	 * @param calcAmt
	 */
    public void setCalcAmt(String calcAmt) {
        this.calcAmt = calcAmt;
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
	 * @param vndrNm
	 */
    public void setVndrNm(String vndrNm) {
        this.vndrNm = vndrNm;
    }

    /**
	 * Column Info
	 * @param invNo
	 */
    public void setInvNo(String invNo) {
        this.invNo = invNo;
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
	 * @param usdAmt
	 */
    public void setUsdAmt(String usdAmt) {
        this.usdAmt = usdAmt;
    }

    /**
	 * Column Info
	 * @param totalI
	 */
    public void setTotalI(String totalI) {
        this.totalI = totalI;
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
	 * @param invTotal
	 */
    public void setInvTotal(String invTotal) {
        this.invTotal = invTotal;
    }

    /**
	 * Column Info
	 * @param xprDesc
	 */
    public void setXprDesc(String xprDesc) {
        this.xprDesc = xprDesc;
    }

    /**
	 * Column Info
	 * @param totalO
	 */
    public void setTotalO(String totalO) {
        this.totalO = totalO;
    }

    /**
	 * Column Info
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    public void setCostCd(String costCd) {
        this.costCd = costCd;
    }

    public String getCostCd() {
        return this.costCd;
    }

    public void setLgsCostFullNm(String lgsCostFullNm) {
        this.lgsCostFullNm = lgsCostFullNm;
    }

    public String getLgsCostFullNm() {
        return this.lgsCostFullNm;
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
        setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setDpIoBndCd(JSPUtil.getParameter(request, prefix + "dp_io_bnd_cd", ""));
        setFomlDesc(JSPUtil.getParameter(request, prefix + "foml_desc", ""));
        setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
        setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
        setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
        setTotalI(JSPUtil.getParameter(request, prefix + "total_i", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setInvTotal(JSPUtil.getParameter(request, prefix + "inv_total", ""));
        setXprDesc(JSPUtil.getParameter(request, prefix + "xpr_desc", ""));
        setTotalO(JSPUtil.getParameter(request, prefix + "total_o", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
        setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SimulationInvoiceListVO[]
	 */
    public SimulationInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SimulationInvoiceListVO[]
	 */
    public SimulationInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SimulationInvoiceListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rmk = (JSPUtil.getParameter(request, prefix + "rmk", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] dpIoBndCd = (JSPUtil.getParameter(request, prefix + "dp_io_bnd_cd", length));
            String[] fomlDesc = (JSPUtil.getParameter(request, prefix + "foml_desc", length));
            String[] loclAmt = (JSPUtil.getParameter(request, prefix + "locl_amt", length));
            String[] adjAmt = (JSPUtil.getParameter(request, prefix + "adj_amt", length));
            String[] calcAmt = (JSPUtil.getParameter(request, prefix + "calc_amt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrNm = (JSPUtil.getParameter(request, prefix + "vndr_nm", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] usdAmt = (JSPUtil.getParameter(request, prefix + "usd_amt", length));
            String[] totalI = (JSPUtil.getParameter(request, prefix + "total_i", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] invTotal = (JSPUtil.getParameter(request, prefix + "inv_total", length));
            String[] xprDesc = (JSPUtil.getParameter(request, prefix + "xpr_desc", length));
            String[] totalO = (JSPUtil.getParameter(request, prefix + "total_o", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] costCd = (JSPUtil.getParameter(request, prefix + "cost_cd", length));
            String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SimulationInvoiceListVO();
                if (rmk[i] != null)
                    model.setRmk(rmk[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (dpIoBndCd[i] != null)
                    model.setDpIoBndCd(dpIoBndCd[i]);
                if (fomlDesc[i] != null)
                    model.setFomlDesc(fomlDesc[i]);
                if (loclAmt[i] != null)
                    model.setLoclAmt(loclAmt[i]);
                if (adjAmt[i] != null)
                    model.setAdjAmt(adjAmt[i]);
                if (calcAmt[i] != null)
                    model.setCalcAmt(calcAmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrNm[i] != null)
                    model.setVndrNm(vndrNm[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (usdAmt[i] != null)
                    model.setUsdAmt(usdAmt[i]);
                if (totalI[i] != null)
                    model.setTotalI(totalI[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (invTotal[i] != null)
                    model.setInvTotal(invTotal[i]);
                if (xprDesc[i] != null)
                    model.setXprDesc(xprDesc[i]);
                if (totalO[i] != null)
                    model.setTotalO(totalO[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (costCd[i] != null)
                    model.setCostCd(costCd[i]);
                if (lgsCostFullNm[i] != null) 
		    		model.setLgsCostFullNm(lgsCostFullNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSimulationInvoiceListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SimulationInvoiceListVO[]
	 */
    public SimulationInvoiceListVO[] getSimulationInvoiceListVOs() {
        SimulationInvoiceListVO[] vos = (SimulationInvoiceListVO[]) models.toArray(new SimulationInvoiceListVO[models.size()]);
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
        this.rmk = this.rmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpIoBndCd = this.dpIoBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fomlDesc = this.fomlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclAmt = this.loclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.adjAmt = this.adjAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.calcAmt = this.calcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdAmt = this.usdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalI = this.totalI.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invTotal = this.invTotal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xprDesc = this.xprDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalO = this.totalO.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costCd = this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsCostFullNm = this.lgsCostFullNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
