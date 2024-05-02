/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SlotXchPartnerVO.java
*@FileTitle : SlotXchPartnerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.20 장강철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

import java.lang.reflect.Field;
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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SlotXchPartnerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SlotXchPartnerVO> models = new ArrayList<SlotXchPartnerVO>();
	
	/* Column Info */
	private String curStlBsaQty = null;
	/* Column Info */
	private String termStlPrc = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String termStlBsaQty = null;
	/* Column Info */
	private String bsaSltPrc = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String stlLoclAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String costWkTo = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String costMon = null;
	/* Column Info */
	private String costWkFr = null;
	/* Column Info */
	private String termStlLoclAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SlotXchPartnerVO() {}

	public SlotXchPartnerVO(String ibflag, String pagerows, String costYrmon, String costYr, String costMon, String skdDirCd, String rlaneCd, String trdCd, String acctYrmon, String reDivrCd, String joCrrCd, String curStlBsaQty, String stlLoclAmt, String bsaSltPrc, String termStlBsaQty, String termStlPrc, String termStlLoclAmt, String costWkFr, String costWkTo, String costWk, String ofcCd) {
		this.curStlBsaQty = curStlBsaQty;
		this.termStlPrc = termStlPrc;
		this.trdCd = trdCd;
		this.joCrrCd = joCrrCd;
		this.rlaneCd = rlaneCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.acctYrmon = acctYrmon;
		this.costYrmon = costYrmon;
		this.termStlBsaQty = termStlBsaQty;
		this.bsaSltPrc = bsaSltPrc;
		this.costYr = costYr;
		this.stlLoclAmt = stlLoclAmt;
		this.costWk = costWk;
		this.costWkTo = costWkTo;
		this.reDivrCd = reDivrCd;
		this.costMon = costMon;
		this.costWkFr = costWkFr;
		this.termStlLoclAmt = termStlLoclAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cur_stl_bsa_qty", getCurStlBsaQty());
		this.hashColumns.put("term_stl_prc", getTermStlPrc());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("term_stl_bsa_qty", getTermStlBsaQty());
		this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("stl_locl_amt", getStlLoclAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cost_wk_to", getCostWkTo());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("cost_mon", getCostMon());
		this.hashColumns.put("cost_wk_fr", getCostWkFr());
		this.hashColumns.put("term_stl_locl_amt", getTermStlLoclAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cur_stl_bsa_qty", "curStlBsaQty");
		this.hashFields.put("term_stl_prc", "termStlPrc");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("term_stl_bsa_qty", "termStlBsaQty");
		this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("stl_locl_amt", "stlLoclAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cost_wk_to", "costWkTo");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("cost_mon", "costMon");
		this.hashFields.put("cost_wk_fr", "costWkFr");
		this.hashFields.put("term_stl_locl_amt", "termStlLoclAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return curStlBsaQty
	 */
	public String getCurStlBsaQty() {
		return this.curStlBsaQty;
	}
	
	/**
	 * Column Info
	 * @return termStlPrc
	 */
	public String getTermStlPrc() {
		return this.termStlPrc;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return termStlBsaQty
	 */
	public String getTermStlBsaQty() {
		return this.termStlBsaQty;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrc
	 */
	public String getBsaSltPrc() {
		return this.bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return stlLoclAmt
	 */
	public String getStlLoclAmt() {
		return this.stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return costWkTo
	 */
	public String getCostWkTo() {
		return this.costWkTo;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return costMon
	 */
	public String getCostMon() {
		return this.costMon;
	}
	
	/**
	 * Column Info
	 * @return costWkFr
	 */
	public String getCostWkFr() {
		return this.costWkFr;
	}
	
	/**
	 * Column Info
	 * @return termStlLoclAmt
	 */
	public String getTermStlLoclAmt() {
		return this.termStlLoclAmt;
	}
	

	/**
	 * Column Info
	 * @param curStlBsaQty
	 */
	public void setCurStlBsaQty(String curStlBsaQty) {
		this.curStlBsaQty = curStlBsaQty;
	}
	
	/**
	 * Column Info
	 * @param termStlPrc
	 */
	public void setTermStlPrc(String termStlPrc) {
		this.termStlPrc = termStlPrc;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param termStlBsaQty
	 */
	public void setTermStlBsaQty(String termStlBsaQty) {
		this.termStlBsaQty = termStlBsaQty;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrc
	 */
	public void setBsaSltPrc(String bsaSltPrc) {
		this.bsaSltPrc = bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param stlLoclAmt
	 */
	public void setStlLoclAmt(String stlLoclAmt) {
		this.stlLoclAmt = stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param costWkTo
	 */
	public void setCostWkTo(String costWkTo) {
		this.costWkTo = costWkTo;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param costMon
	 */
	public void setCostMon(String costMon) {
		this.costMon = costMon;
	}
	
	/**
	 * Column Info
	 * @param costWkFr
	 */
	public void setCostWkFr(String costWkFr) {
		this.costWkFr = costWkFr;
	}
	
	/**
	 * Column Info
	 * @param termStlLoclAmt
	 */
	public void setTermStlLoclAmt(String termStlLoclAmt) {
		this.termStlLoclAmt = termStlLoclAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurStlBsaQty(JSPUtil.getParameter(request, "cur_stl_bsa_qty", ""));
		setTermStlPrc(JSPUtil.getParameter(request, "term_stl_prc", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setTermStlBsaQty(JSPUtil.getParameter(request, "term_stl_bsa_qty", ""));
		setBsaSltPrc(JSPUtil.getParameter(request, "bsa_slt_prc", ""));
		setCostYr(JSPUtil.getParameter(request, "cost_yr", ""));
		setStlLoclAmt(JSPUtil.getParameter(request, "stl_locl_amt", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setCostWkTo(JSPUtil.getParameter(request, "cost_wk_to", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setCostMon(JSPUtil.getParameter(request, "cost_mon", ""));
		setCostWkFr(JSPUtil.getParameter(request, "cost_wk_fr", ""));
		setTermStlLoclAmt(JSPUtil.getParameter(request, "term_stl_locl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SlotXchPartnerVO[]
	 */
	public SlotXchPartnerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SlotXchPartnerVO[]
	 */
	public SlotXchPartnerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SlotXchPartnerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] curStlBsaQty = (JSPUtil.getParameter(request, prefix	+ "cur_stl_bsa_qty", length));
			String[] termStlPrc = (JSPUtil.getParameter(request, prefix	+ "term_stl_prc", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] termStlBsaQty = (JSPUtil.getParameter(request, prefix	+ "term_stl_bsa_qty", length));
			String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] stlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "stl_locl_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] costWkTo = (JSPUtil.getParameter(request, prefix	+ "cost_wk_to", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] costMon = (JSPUtil.getParameter(request, prefix	+ "cost_mon", length));
			String[] costWkFr = (JSPUtil.getParameter(request, prefix	+ "cost_wk_fr", length));
			String[] termStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "term_stl_locl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SlotXchPartnerVO();
				if (curStlBsaQty[i] != null)
					model.setCurStlBsaQty(curStlBsaQty[i]);
				if (termStlPrc[i] != null)
					model.setTermStlPrc(termStlPrc[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (termStlBsaQty[i] != null)
					model.setTermStlBsaQty(termStlBsaQty[i]);
				if (bsaSltPrc[i] != null)
					model.setBsaSltPrc(bsaSltPrc[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (stlLoclAmt[i] != null)
					model.setStlLoclAmt(stlLoclAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (costWkTo[i] != null)
					model.setCostWkTo(costWkTo[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (costMon[i] != null)
					model.setCostMon(costMon[i]);
				if (costWkFr[i] != null)
					model.setCostWkFr(costWkFr[i]);
				if (termStlLoclAmt[i] != null)
					model.setTermStlLoclAmt(termStlLoclAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSlotXchPartnerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SlotXchPartnerVO[]
	 */
	public SlotXchPartnerVO[] getSlotXchPartnerVOs(){
		SlotXchPartnerVO[] vos = (SlotXchPartnerVO[])models.toArray(new SlotXchPartnerVO[models.size()]);
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
		this.curStlBsaQty = this.curStlBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termStlPrc = this.termStlPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termStlBsaQty = this.termStlBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrc = this.bsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLoclAmt = this.stlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWkTo = this.costWkTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMon = this.costMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWkFr = this.costWkFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termStlLoclAmt = this.termStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
