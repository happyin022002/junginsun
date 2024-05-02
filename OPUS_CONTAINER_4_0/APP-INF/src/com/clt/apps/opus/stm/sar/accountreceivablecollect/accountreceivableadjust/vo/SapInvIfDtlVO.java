/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SapInvIfDtlVO.java
*@FileTitle : SapInvIfDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SapInvIfDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SapInvIfDtlVO> models = new ArrayList<SapInvIfDtlVO>();
	
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String ifSrcNm = null;
	/* Column Info */
	private String adjCrsCurrAmt = null;
	/* Column Info */
	private String acctgDt = null;
	/* Column Info */
	private String interCoCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String attrCtnt3 = null;
	/* Column Info */
	private String dtrbAmt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String dtrbDesc = null;
	/* Column Info */
	private String gainAndLssAmt = null;
	/* Column Info */
	private String dtrbVatCd = null;
	/* Column Info */
	private String lineTpLuCd = null;
	/* Column Info */
	private String invLineNo = null;
	/* Column Info */
	private String fnlMtchStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SapInvIfDtlVO() {}

	public SapInvIfDtlVO(String ibflag, String pagerows, String invLineNo, String lineTpLuCd, String dtrbAmt, String acctgDt, String dtrbDesc, String dtrbVatCd, String fnlMtchStsCd, String attrCtnt3, String ifSrcNm, String ofcCd, String coCd, String cntCd, String ctrCd, String interCoCd, String adjCrsCurrAmt, String gainAndLssAmt) {
		this.coCd = coCd;
		this.ifSrcNm = ifSrcNm;
		this.adjCrsCurrAmt = adjCrsCurrAmt;
		this.acctgDt = acctgDt;
		this.interCoCd = interCoCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.attrCtnt3 = attrCtnt3;
		this.dtrbAmt = dtrbAmt;
		this.cntCd = cntCd;
		this.dtrbDesc = dtrbDesc;
		this.gainAndLssAmt = gainAndLssAmt;
		this.dtrbVatCd = dtrbVatCd;
		this.lineTpLuCd = lineTpLuCd;
		this.invLineNo = invLineNo;
		this.fnlMtchStsCd = fnlMtchStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("if_src_nm", getIfSrcNm());
		this.hashColumns.put("adj_crs_curr_amt", getAdjCrsCurrAmt());
		this.hashColumns.put("acctg_dt", getAcctgDt());
		this.hashColumns.put("inter_co_cd", getInterCoCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("dtrb_amt", getDtrbAmt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("dtrb_desc", getDtrbDesc());
		this.hashColumns.put("gain_and_lss_amt", getGainAndLssAmt());
		this.hashColumns.put("dtrb_vat_cd", getDtrbVatCd());
		this.hashColumns.put("line_tp_lu_cd", getLineTpLuCd());
		this.hashColumns.put("inv_line_no", getInvLineNo());
		this.hashColumns.put("fnl_mtch_sts_cd", getFnlMtchStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("if_src_nm", "ifSrcNm");
		this.hashFields.put("adj_crs_curr_amt", "adjCrsCurrAmt");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("inter_co_cd", "interCoCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("dtrb_amt", "dtrbAmt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("dtrb_desc", "dtrbDesc");
		this.hashFields.put("gain_and_lss_amt", "gainAndLssAmt");
		this.hashFields.put("dtrb_vat_cd", "dtrbVatCd");
		this.hashFields.put("line_tp_lu_cd", "lineTpLuCd");
		this.hashFields.put("inv_line_no", "invLineNo");
		this.hashFields.put("fnl_mtch_sts_cd", "fnlMtchStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return ifSrcNm
	 */
	public String getIfSrcNm() {
		return this.ifSrcNm;
	}
	
	/**
	 * Column Info
	 * @return adjCrsCurrAmt
	 */
	public String getAdjCrsCurrAmt() {
		return this.adjCrsCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return acctgDt
	 */
	public String getAcctgDt() {
		return this.acctgDt;
	}
	
	/**
	 * Column Info
	 * @return interCoCd
	 */
	public String getInterCoCd() {
		return this.interCoCd;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return this.attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return dtrbAmt
	 */
	public String getDtrbAmt() {
		return this.dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbDesc
	 */
	public String getDtrbDesc() {
		return this.dtrbDesc;
	}
	
	/**
	 * Column Info
	 * @return gainAndLssAmt
	 */
	public String getGainAndLssAmt() {
		return this.gainAndLssAmt;
	}
	
	/**
	 * Column Info
	 * @return dtrbVatCd
	 */
	public String getDtrbVatCd() {
		return this.dtrbVatCd;
	}
	
	/**
	 * Column Info
	 * @return lineTpLuCd
	 */
	public String getLineTpLuCd() {
		return this.lineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return invLineNo
	 */
	public String getInvLineNo() {
		return this.invLineNo;
	}
	
	/**
	 * Column Info
	 * @return fnlMtchStsCd
	 */
	public String getFnlMtchStsCd() {
		return this.fnlMtchStsCd;
	}
	

	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param ifSrcNm
	 */
	public void setIfSrcNm(String ifSrcNm) {
		this.ifSrcNm = ifSrcNm;
	}
	
	/**
	 * Column Info
	 * @param adjCrsCurrAmt
	 */
	public void setAdjCrsCurrAmt(String adjCrsCurrAmt) {
		this.adjCrsCurrAmt = adjCrsCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param acctgDt
	 */
	public void setAcctgDt(String acctgDt) {
		this.acctgDt = acctgDt;
	}
	
	/**
	 * Column Info
	 * @param interCoCd
	 */
	public void setInterCoCd(String interCoCd) {
		this.interCoCd = interCoCd;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt3
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param dtrbAmt
	 */
	public void setDtrbAmt(String dtrbAmt) {
		this.dtrbAmt = dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbDesc
	 */
	public void setDtrbDesc(String dtrbDesc) {
		this.dtrbDesc = dtrbDesc;
	}
	
	/**
	 * Column Info
	 * @param gainAndLssAmt
	 */
	public void setGainAndLssAmt(String gainAndLssAmt) {
		this.gainAndLssAmt = gainAndLssAmt;
	}
	
	/**
	 * Column Info
	 * @param dtrbVatCd
	 */
	public void setDtrbVatCd(String dtrbVatCd) {
		this.dtrbVatCd = dtrbVatCd;
	}
	
	/**
	 * Column Info
	 * @param lineTpLuCd
	 */
	public void setLineTpLuCd(String lineTpLuCd) {
		this.lineTpLuCd = lineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param invLineNo
	 */
	public void setInvLineNo(String invLineNo) {
		this.invLineNo = invLineNo;
	}
	
	/**
	 * Column Info
	 * @param fnlMtchStsCd
	 */
	public void setFnlMtchStsCd(String fnlMtchStsCd) {
		this.fnlMtchStsCd = fnlMtchStsCd;
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
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setIfSrcNm(JSPUtil.getParameter(request, prefix + "if_src_nm", ""));
		setAdjCrsCurrAmt(JSPUtil.getParameter(request, prefix + "adj_crs_curr_amt", ""));
		setAcctgDt(JSPUtil.getParameter(request, prefix + "acctg_dt", ""));
		setInterCoCd(JSPUtil.getParameter(request, prefix + "inter_co_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, prefix + "ctr_cd", ""));
		setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
		setDtrbAmt(JSPUtil.getParameter(request, prefix + "dtrb_amt", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setDtrbDesc(JSPUtil.getParameter(request, prefix + "dtrb_desc", ""));
		setGainAndLssAmt(JSPUtil.getParameter(request, prefix + "gain_and_lss_amt", ""));
		setDtrbVatCd(JSPUtil.getParameter(request, prefix + "dtrb_vat_cd", ""));
		setLineTpLuCd(JSPUtil.getParameter(request, prefix + "line_tp_lu_cd", ""));
		setInvLineNo(JSPUtil.getParameter(request, prefix + "inv_line_no", ""));
		setFnlMtchStsCd(JSPUtil.getParameter(request, prefix + "fnl_mtch_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SapInvIfDtlVO[]
	 */
	public SapInvIfDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SapInvIfDtlVO[]
	 */
	public SapInvIfDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SapInvIfDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] ifSrcNm = (JSPUtil.getParameter(request, prefix	+ "if_src_nm", length));
			String[] adjCrsCurrAmt = (JSPUtil.getParameter(request, prefix	+ "adj_crs_curr_amt", length));
			String[] acctgDt = (JSPUtil.getParameter(request, prefix	+ "acctg_dt", length));
			String[] interCoCd = (JSPUtil.getParameter(request, prefix	+ "inter_co_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt3", length));
			String[] dtrbAmt = (JSPUtil.getParameter(request, prefix	+ "dtrb_amt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] dtrbDesc = (JSPUtil.getParameter(request, prefix	+ "dtrb_desc", length));
			String[] gainAndLssAmt = (JSPUtil.getParameter(request, prefix	+ "gain_and_lss_amt", length));
			String[] dtrbVatCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_vat_cd", length));
			String[] lineTpLuCd = (JSPUtil.getParameter(request, prefix	+ "line_tp_lu_cd", length));
			String[] invLineNo = (JSPUtil.getParameter(request, prefix	+ "inv_line_no", length));
			String[] fnlMtchStsCd = (JSPUtil.getParameter(request, prefix	+ "fnl_mtch_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SapInvIfDtlVO();
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (ifSrcNm[i] != null)
					model.setIfSrcNm(ifSrcNm[i]);
				if (adjCrsCurrAmt[i] != null)
					model.setAdjCrsCurrAmt(adjCrsCurrAmt[i]);
				if (acctgDt[i] != null)
					model.setAcctgDt(acctgDt[i]);
				if (interCoCd[i] != null)
					model.setInterCoCd(interCoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (attrCtnt3[i] != null)
					model.setAttrCtnt3(attrCtnt3[i]);
				if (dtrbAmt[i] != null)
					model.setDtrbAmt(dtrbAmt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (dtrbDesc[i] != null)
					model.setDtrbDesc(dtrbDesc[i]);
				if (gainAndLssAmt[i] != null)
					model.setGainAndLssAmt(gainAndLssAmt[i]);
				if (dtrbVatCd[i] != null)
					model.setDtrbVatCd(dtrbVatCd[i]);
				if (lineTpLuCd[i] != null)
					model.setLineTpLuCd(lineTpLuCd[i]);
				if (invLineNo[i] != null)
					model.setInvLineNo(invLineNo[i]);
				if (fnlMtchStsCd[i] != null)
					model.setFnlMtchStsCd(fnlMtchStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSapInvIfDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SapInvIfDtlVO[]
	 */
	public SapInvIfDtlVO[] getSapInvIfDtlVOs(){
		SapInvIfDtlVO[] vos = (SapInvIfDtlVO[])models.toArray(new SapInvIfDtlVO[models.size()]);
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
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSrcNm = this.ifSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjCrsCurrAmt = this.adjCrsCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt = this.acctgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interCoCd = this.interCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 = this.attrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbAmt = this.dtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbDesc = this.dtrbDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainAndLssAmt = this.gainAndLssAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbVatCd = this.dtrbVatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineTpLuCd = this.lineTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLineNo = this.invLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMtchStsCd = this.fnlMtchStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
