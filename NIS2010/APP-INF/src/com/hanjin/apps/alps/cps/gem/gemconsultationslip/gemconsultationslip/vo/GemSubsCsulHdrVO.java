/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GemSubsCsulHdrVO.java
*@FileTitle : GemSubsCsulHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class GemSubsCsulHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemSubsCsulHdrVO> models = new ArrayList<GemSubsCsulHdrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String expnDivCd = null;
	/* Column Info */
	private String invLoclTtlAmt = null;
	/* Column Info */
	private String invUsdTtlAmt = null;
	/* Column Info */
	private String payVndrNm = null;
	/* Column Info */
	private String subsCsrNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String gwCsrRqstrId = null;
	/* Column Info */
	private String inpDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subsOfcCd = null;
	/* Column Info */
	private String gwAproUrlCtnt = null;
	/* Column Info */
	private String gwCsrRqstId = null;
	/* Column Info */
	private String gwAprorId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproRsltCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GemSubsCsulHdrVO() {}

	public GemSubsCsulHdrVO(String ibflag, String pagerows, String subsCsrNo, String subsOfcCd, String inpDt, String invDt, String aproDt, String aproRsltCd, String gwAproUrlCtnt, String gwCsrRqstId, String gwCsrRqstrId, String gwAprorId, String payVndrNm, String invCurrCd, String invLoclTtlAmt, String invUsdTtlAmt, String expnDivCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.expnDivCd = expnDivCd;
		this.invLoclTtlAmt = invLoclTtlAmt;
		this.invUsdTtlAmt = invUsdTtlAmt;
		this.payVndrNm = payVndrNm;
		this.subsCsrNo = subsCsrNo;
		this.creDt = creDt;
		this.invCurrCd = invCurrCd;
		this.aproDt = aproDt;
		this.gwCsrRqstrId = gwCsrRqstrId;
		this.inpDt = inpDt;
		this.pagerows = pagerows;
		this.subsOfcCd = subsOfcCd;
		this.gwAproUrlCtnt = gwAproUrlCtnt;
		this.gwCsrRqstId = gwCsrRqstId;
		this.gwAprorId = gwAprorId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.aproRsltCd = aproRsltCd;
		this.updUsrId = updUsrId;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("expn_div_cd", getExpnDivCd());
		this.hashColumns.put("inv_locl_ttl_amt", getInvLoclTtlAmt());
		this.hashColumns.put("inv_usd_ttl_amt", getInvUsdTtlAmt());
		this.hashColumns.put("pay_vndr_nm", getPayVndrNm());
		this.hashColumns.put("subs_csr_no", getSubsCsrNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("gw_csr_rqstr_id", getGwCsrRqstrId());
		this.hashColumns.put("inp_dt", getInpDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("subs_ofc_cd", getSubsOfcCd());
		this.hashColumns.put("gw_apro_url_ctnt", getGwAproUrlCtnt());
		this.hashColumns.put("gw_csr_rqst_id", getGwCsrRqstId());
		this.hashColumns.put("gw_apror_id", getGwAprorId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_rslt_cd", getAproRsltCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("expn_div_cd", "expnDivCd");
		this.hashFields.put("inv_locl_ttl_amt", "invLoclTtlAmt");
		this.hashFields.put("inv_usd_ttl_amt", "invUsdTtlAmt");
		this.hashFields.put("pay_vndr_nm", "payVndrNm");
		this.hashFields.put("subs_csr_no", "subsCsrNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("gw_csr_rqstr_id", "gwCsrRqstrId");
		this.hashFields.put("inp_dt", "inpDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("subs_ofc_cd", "subsOfcCd");
		this.hashFields.put("gw_apro_url_ctnt", "gwAproUrlCtnt");
		this.hashFields.put("gw_csr_rqst_id", "gwCsrRqstId");
		this.hashFields.put("gw_apror_id", "gwAprorId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_rslt_cd", "aproRsltCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
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
	 * @return expnDivCd
	 */
	public String getExpnDivCd() {
		return this.expnDivCd;
	}
	
	/**
	 * Column Info
	 * @return invLoclTtlAmt
	 */
	public String getInvLoclTtlAmt() {
		return this.invLoclTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return invUsdTtlAmt
	 */
	public String getInvUsdTtlAmt() {
		return this.invUsdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return payVndrNm
	 */
	public String getPayVndrNm() {
		return this.payVndrNm;
	}
	
	/**
	 * Column Info
	 * @return subsCsrNo
	 */
	public String getSubsCsrNo() {
		return this.subsCsrNo;
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
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return gwCsrRqstrId
	 */
	public String getGwCsrRqstrId() {
		return this.gwCsrRqstrId;
	}
	
	/**
	 * Column Info
	 * @return inpDt
	 */
	public String getInpDt() {
		return this.inpDt;
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
	 * @return subsOfcCd
	 */
	public String getSubsOfcCd() {
		return this.subsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return gwAproUrlCtnt
	 */
	public String getGwAproUrlCtnt() {
		return this.gwAproUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @return gwCsrRqstId
	 */
	public String getGwCsrRqstId() {
		return this.gwCsrRqstId;
	}
	
	/**
	 * Column Info
	 * @return gwAprorId
	 */
	public String getGwAprorId() {
		return this.gwAprorId;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return aproRsltCd
	 */
	public String getAproRsltCd() {
		return this.aproRsltCd;
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
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @param expnDivCd
	 */
	public void setExpnDivCd(String expnDivCd) {
		this.expnDivCd = expnDivCd;
	}
	
	/**
	 * Column Info
	 * @param invLoclTtlAmt
	 */
	public void setInvLoclTtlAmt(String invLoclTtlAmt) {
		this.invLoclTtlAmt = invLoclTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param invUsdTtlAmt
	 */
	public void setInvUsdTtlAmt(String invUsdTtlAmt) {
		this.invUsdTtlAmt = invUsdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param payVndrNm
	 */
	public void setPayVndrNm(String payVndrNm) {
		this.payVndrNm = payVndrNm;
	}
	
	/**
	 * Column Info
	 * @param subsCsrNo
	 */
	public void setSubsCsrNo(String subsCsrNo) {
		this.subsCsrNo = subsCsrNo;
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
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param gwCsrRqstrId
	 */
	public void setGwCsrRqstrId(String gwCsrRqstrId) {
		this.gwCsrRqstrId = gwCsrRqstrId;
	}
	
	/**
	 * Column Info
	 * @param inpDt
	 */
	public void setInpDt(String inpDt) {
		this.inpDt = inpDt;
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
	 * @param subsOfcCd
	 */
	public void setSubsOfcCd(String subsOfcCd) {
		this.subsOfcCd = subsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param gwAproUrlCtnt
	 */
	public void setGwAproUrlCtnt(String gwAproUrlCtnt) {
		this.gwAproUrlCtnt = gwAproUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @param gwCsrRqstId
	 */
	public void setGwCsrRqstId(String gwCsrRqstId) {
		this.gwCsrRqstId = gwCsrRqstId;
	}
	
	/**
	 * Column Info
	 * @param gwAprorId
	 */
	public void setGwAprorId(String gwAprorId) {
		this.gwAprorId = gwAprorId;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param aproRsltCd
	 */
	public void setAproRsltCd(String aproRsltCd) {
		this.aproRsltCd = aproRsltCd;
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
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setExpnDivCd(JSPUtil.getParameter(request, prefix + "expn_div_cd", ""));
		setInvLoclTtlAmt(JSPUtil.getParameter(request, prefix + "inv_locl_ttl_amt", ""));
		setInvUsdTtlAmt(JSPUtil.getParameter(request, prefix + "inv_usd_ttl_amt", ""));
		setPayVndrNm(JSPUtil.getParameter(request, prefix + "pay_vndr_nm", ""));
		setSubsCsrNo(JSPUtil.getParameter(request, prefix + "subs_csr_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setGwCsrRqstrId(JSPUtil.getParameter(request, prefix + "gw_csr_rqstr_id", ""));
		setInpDt(JSPUtil.getParameter(request, prefix + "inp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSubsOfcCd(JSPUtil.getParameter(request, prefix + "subs_ofc_cd", ""));
		setGwAproUrlCtnt(JSPUtil.getParameter(request, prefix + "gw_apro_url_ctnt", ""));
		setGwCsrRqstId(JSPUtil.getParameter(request, prefix + "gw_csr_rqst_id", ""));
		setGwAprorId(JSPUtil.getParameter(request, prefix + "gw_apror_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAproRsltCd(JSPUtil.getParameter(request, prefix + "apro_rslt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemSubsCsulHdrVO[]
	 */
	public GemSubsCsulHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemSubsCsulHdrVO[]
	 */
	public GemSubsCsulHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemSubsCsulHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] expnDivCd = (JSPUtil.getParameter(request, prefix	+ "expn_div_cd", length));
			String[] invLoclTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_locl_ttl_amt", length));
			String[] invUsdTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_ttl_amt", length));
			String[] payVndrNm = (JSPUtil.getParameter(request, prefix	+ "pay_vndr_nm", length));
			String[] subsCsrNo = (JSPUtil.getParameter(request, prefix	+ "subs_csr_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] gwCsrRqstrId = (JSPUtil.getParameter(request, prefix	+ "gw_csr_rqstr_id", length));
			String[] inpDt = (JSPUtil.getParameter(request, prefix	+ "inp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subsOfcCd = (JSPUtil.getParameter(request, prefix	+ "subs_ofc_cd", length));
			String[] gwAproUrlCtnt = (JSPUtil.getParameter(request, prefix	+ "gw_apro_url_ctnt", length));
			String[] gwCsrRqstId = (JSPUtil.getParameter(request, prefix	+ "gw_csr_rqst_id", length));
			String[] gwAprorId = (JSPUtil.getParameter(request, prefix	+ "gw_apror_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproRsltCd = (JSPUtil.getParameter(request, prefix	+ "apro_rslt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemSubsCsulHdrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (expnDivCd[i] != null)
					model.setExpnDivCd(expnDivCd[i]);
				if (invLoclTtlAmt[i] != null)
					model.setInvLoclTtlAmt(invLoclTtlAmt[i]);
				if (invUsdTtlAmt[i] != null)
					model.setInvUsdTtlAmt(invUsdTtlAmt[i]);
				if (payVndrNm[i] != null)
					model.setPayVndrNm(payVndrNm[i]);
				if (subsCsrNo[i] != null)
					model.setSubsCsrNo(subsCsrNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (gwCsrRqstrId[i] != null)
					model.setGwCsrRqstrId(gwCsrRqstrId[i]);
				if (inpDt[i] != null)
					model.setInpDt(inpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subsOfcCd[i] != null)
					model.setSubsOfcCd(subsOfcCd[i]);
				if (gwAproUrlCtnt[i] != null)
					model.setGwAproUrlCtnt(gwAproUrlCtnt[i]);
				if (gwCsrRqstId[i] != null)
					model.setGwCsrRqstId(gwCsrRqstId[i]);
				if (gwAprorId[i] != null)
					model.setGwAprorId(gwAprorId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproRsltCd[i] != null)
					model.setAproRsltCd(aproRsltCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemSubsCsulHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemSubsCsulHdrVO[]
	 */
	public GemSubsCsulHdrVO[] getGemSubsCsulHdrVOs(){
		GemSubsCsulHdrVO[] vos = (GemSubsCsulHdrVO[])models.toArray(new GemSubsCsulHdrVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnDivCd = this.expnDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclTtlAmt = this.invLoclTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdTtlAmt = this.invUsdTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payVndrNm = this.payVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrNo = this.subsCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwCsrRqstrId = this.gwCsrRqstrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDt = this.inpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsOfcCd = this.subsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAproUrlCtnt = this.gwAproUrlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwCsrRqstId = this.gwCsrRqstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAprorId = this.gwAprorId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRsltCd = this.aproRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
