/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CSRDetailVO.java
*@FileTitle : CSRDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.17
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.17 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CSRDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CSRDetailVO> models = new ArrayList<CSRDetailVO>();
	
	/* Column Info */
	private String commStndCostCd = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String nRev = null;
	/* Column Info */
	private String docOth = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String gRev = null;
	/* Column Info */
	private String inBound = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String brog = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trans = null;
	/* Column Info */
	private String chf = null;
	/* Column Info */
	private String dmdt = null;
	/* Column Info */
	private String revVvdCd = null;
	/* Column Info */
	private String outBound = null;
	/* Column Info */
	private String costMu = null;
	/* Column Info */
	private String vslOpr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CSRDetailVO() {}

	public CSRDetailVO(String ibflag, String pagerows, String bkgNo, String qty, String gRev, String nRev, String outBound, String inBound, String trans, String chf, String brog, String docOth, String dmdt, String vslOpr, String costMu, String agnCd, String csrNo, String revVvdCd, String commStndCostCd) {
		this.commStndCostCd = commStndCostCd;
		this.agnCd = agnCd;
		this.nRev = nRev;
		this.docOth = docOth;
		this.csrNo = csrNo;
		this.gRev = gRev;
		this.inBound = inBound;
		this.qty = qty;
		this.brog = brog;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.trans = trans;
		this.chf = chf;
		this.dmdt = dmdt;
		this.revVvdCd = revVvdCd;
		this.outBound = outBound;
		this.costMu = costMu;
		this.vslOpr = vslOpr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("comm_stnd_cost_cd", getCommStndCostCd());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("n_rev", getNRev());
		this.hashColumns.put("doc_oth", getDocOth());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("g_rev", getGRev());
		this.hashColumns.put("in_bound", getInBound());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("brog", getBrog());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trans", getTrans());
		this.hashColumns.put("chf", getChf());
		this.hashColumns.put("dmdt", getDmdt());
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());
		this.hashColumns.put("out_bound", getOutBound());
		this.hashColumns.put("cost_mu", getCostMu());
		this.hashColumns.put("vsl_opr", getVslOpr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("comm_stnd_cost_cd", "commStndCostCd");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("n_rev", "nRev");
		this.hashFields.put("doc_oth", "docOth");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("g_rev", "gRev");
		this.hashFields.put("in_bound", "inBound");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("brog", "brog");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trans", "trans");
		this.hashFields.put("chf", "chf");
		this.hashFields.put("dmdt", "dmdt");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		this.hashFields.put("out_bound", "outBound");
		this.hashFields.put("cost_mu", "costMu");
		this.hashFields.put("vsl_opr", "vslOpr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return commStndCostCd
	 */
	public String getCommStndCostCd() {
		return this.commStndCostCd;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return nRev
	 */
	public String getNRev() {
		return this.nRev;
	}
	
	/**
	 * Column Info
	 * @return docOth
	 */
	public String getDocOth() {
		return this.docOth;
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
	 * @return gRev
	 */
	public String getGRev() {
		return this.gRev;
	}
	
	/**
	 * Column Info
	 * @return inBound
	 */
	public String getInBound() {
		return this.inBound;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return brog
	 */
	public String getBrog() {
		return this.brog;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return trans
	 */
	public String getTrans() {
		return this.trans;
	}
	
	/**
	 * Column Info
	 * @return chf
	 */
	public String getChf() {
		return this.chf;
	}
	
	/**
	 * Column Info
	 * @return dmdt
	 */
	public String getDmdt() {
		return this.dmdt;
	}
	
	/**
	 * Column Info
	 * @return revVvdCd
	 */
	public String getRevVvdCd() {
		return this.revVvdCd;
	}
	
	/**
	 * Column Info
	 * @return outBound
	 */
	public String getOutBound() {
		return this.outBound;
	}
	
	/**
	 * Column Info
	 * @return costMu
	 */
	public String getCostMu() {
		return this.costMu;
	}
	
	/**
	 * Column Info
	 * @return vslOpr
	 */
	public String getVslOpr() {
		return this.vslOpr;
	}
	

	/**
	 * Column Info
	 * @param commStndCostCd
	 */
	public void setCommStndCostCd(String commStndCostCd) {
		this.commStndCostCd = commStndCostCd;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param nRev
	 */
	public void setNRev(String nRev) {
		this.nRev = nRev;
	}
	
	/**
	 * Column Info
	 * @param docOth
	 */
	public void setDocOth(String docOth) {
		this.docOth = docOth;
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
	 * @param gRev
	 */
	public void setGRev(String gRev) {
		this.gRev = gRev;
	}
	
	/**
	 * Column Info
	 * @param inBound
	 */
	public void setInBound(String inBound) {
		this.inBound = inBound;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param brog
	 */
	public void setBrog(String brog) {
		this.brog = brog;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param trans
	 */
	public void setTrans(String trans) {
		this.trans = trans;
	}
	
	/**
	 * Column Info
	 * @param chf
	 */
	public void setChf(String chf) {
		this.chf = chf;
	}
	
	/**
	 * Column Info
	 * @param dmdt
	 */
	public void setDmdt(String dmdt) {
		this.dmdt = dmdt;
	}
	
	/**
	 * Column Info
	 * @param revVvdCd
	 */
	public void setRevVvdCd(String revVvdCd) {
		this.revVvdCd = revVvdCd;
	}
	
	/**
	 * Column Info
	 * @param outBound
	 */
	public void setOutBound(String outBound) {
		this.outBound = outBound;
	}
	
	/**
	 * Column Info
	 * @param costMu
	 */
	public void setCostMu(String costMu) {
		this.costMu = costMu;
	}
	
	/**
	 * Column Info
	 * @param vslOpr
	 */
	public void setVslOpr(String vslOpr) {
		this.vslOpr = vslOpr;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCommStndCostCd(JSPUtil.getParameter(request, prefix + "comm_stnd_cost_cd", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setNRev(JSPUtil.getParameter(request, prefix + "n_rev", ""));
		setDocOth(JSPUtil.getParameter(request, prefix + "doc_oth", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setGRev(JSPUtil.getParameter(request, prefix + "g_rev", ""));
		setInBound(JSPUtil.getParameter(request, prefix + "in_bound", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setBrog(JSPUtil.getParameter(request, prefix + "brog", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTrans(JSPUtil.getParameter(request, prefix + "trans", ""));
		setChf(JSPUtil.getParameter(request, prefix + "chf", ""));
		setDmdt(JSPUtil.getParameter(request, prefix + "dmdt", ""));
		setRevVvdCd(JSPUtil.getParameter(request, prefix + "rev_vvd_cd", ""));
		setOutBound(JSPUtil.getParameter(request, prefix + "out_bound", ""));
		setCostMu(JSPUtil.getParameter(request, prefix + "cost_mu", ""));
		setVslOpr(JSPUtil.getParameter(request, prefix + "vsl_opr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CSRDetailVO[]
	 */
	public CSRDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CSRDetailVO[]
	 */
	public CSRDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CSRDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] commStndCostCd = (JSPUtil.getParameter(request, prefix	+ "comm_stnd_cost_cd", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] nRev = (JSPUtil.getParameter(request, prefix	+ "n_rev", length));
			String[] docOth = (JSPUtil.getParameter(request, prefix	+ "doc_oth", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] gRev = (JSPUtil.getParameter(request, prefix	+ "g_rev", length));
			String[] inBound = (JSPUtil.getParameter(request, prefix	+ "in_bound", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] brog = (JSPUtil.getParameter(request, prefix	+ "brog", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trans = (JSPUtil.getParameter(request, prefix	+ "trans", length));
			String[] chf = (JSPUtil.getParameter(request, prefix	+ "chf", length));
			String[] dmdt = (JSPUtil.getParameter(request, prefix	+ "dmdt", length));
			String[] revVvdCd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_cd", length));
			String[] outBound = (JSPUtil.getParameter(request, prefix	+ "out_bound", length));
			String[] costMu = (JSPUtil.getParameter(request, prefix	+ "cost_mu", length));
			String[] vslOpr = (JSPUtil.getParameter(request, prefix	+ "vsl_opr", length));
			
			for (int i = 0; i < length; i++) {
				model = new CSRDetailVO();
				if (commStndCostCd[i] != null)
					model.setCommStndCostCd(commStndCostCd[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (nRev[i] != null)
					model.setNRev(nRev[i]);
				if (docOth[i] != null)
					model.setDocOth(docOth[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (gRev[i] != null)
					model.setGRev(gRev[i]);
				if (inBound[i] != null)
					model.setInBound(inBound[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (brog[i] != null)
					model.setBrog(brog[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trans[i] != null)
					model.setTrans(trans[i]);
				if (chf[i] != null)
					model.setChf(chf[i]);
				if (dmdt[i] != null)
					model.setDmdt(dmdt[i]);
				if (revVvdCd[i] != null)
					model.setRevVvdCd(revVvdCd[i]);
				if (outBound[i] != null)
					model.setOutBound(outBound[i]);
				if (costMu[i] != null)
					model.setCostMu(costMu[i]);
				if (vslOpr[i] != null)
					model.setVslOpr(vslOpr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCSRDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CSRDetailVO[]
	 */
	public CSRDetailVO[] getCSRDetailVOs(){
		CSRDetailVO[] vos = (CSRDetailVO[])models.toArray(new CSRDetailVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.commStndCostCd = this.commStndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nRev = this.nRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docOth = this.docOth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRev = this.gRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBound = this.inBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brog = this.brog .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trans = this.trans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chf = this.chf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdt = this.dmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd = this.revVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outBound = this.outBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMu = this.costMu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOpr = this.vslOpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
