/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchKpiUploadVO.java
*@FileTitle : SearchKpiUploadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.12  
* 1.0 Creation
* 2015.04.15 김용습 [CHM-201535206] KPI Management "Week" 조건 추가
* 2015.04.27 김용습 [CHM-201535626] (SQM) TPS 자리수 Validation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchKpiUploadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchKpiUploadVO> models = new ArrayList<SearchKpiUploadVO>();
	
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String raCmpbAmt = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String bseMon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String acctTgtCd = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String trdBndCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchKpiUploadVO() {}

	public SearchKpiUploadVO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String bseMon, String trdCd, String subTrdCd, String convDirCd, String acctTgtCd, String custGrpId, String custGrpNm, String lodQty, String raCmpbAmt, String bseWk, String trdBndCd) {
		this.lodQty = lodQty;
		this.raCmpbAmt = raCmpbAmt;
		this.custGrpId = custGrpId;
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.bseMon = bseMon;
		this.ibflag = ibflag;
		this.convDirCd = convDirCd;
		this.acctTgtCd = acctTgtCd;
		this.custGrpNm = custGrpNm;
		this.subTrdCd = subTrdCd;
		this.bseWk = bseWk;
		this.trdBndCd = trdBndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("ra_cmpb_amt", getRaCmpbAmt());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("acct_tgt_cd", getAcctTgtCd());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("trd_bnd_cd", getTrdBndCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("ra_cmpb_amt", "raCmpbAmt");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("acct_tgt_cd", "acctTgtCd");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("trd_bnd_cd", "trdBndCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return raCmpbAmt
	 */
	public String getRaCmpbAmt() {
		return this.raCmpbAmt;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
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
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return acctTgtCd
	 */
	public String getAcctTgtCd() {
		return this.acctTgtCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return trdBndCd
	 */
	public String getTrdBndCd() {
		return this.trdBndCd;
	}
	

	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param raCmpbAmt
	 */
	public void setRaCmpbAmt(String raCmpbAmt) {
		this.raCmpbAmt = raCmpbAmt;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
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
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param acctTgtCd
	 */
	public void setAcctTgtCd(String acctTgtCd) {
		this.acctTgtCd = acctTgtCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param trdBndCd
	 */
	public void setTrdBndCd(String trdBndCd) {
		this.trdBndCd = trdBndCd;
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
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setRaCmpbAmt(JSPUtil.getParameter(request, prefix + "ra_cmpb_amt", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setAcctTgtCd(JSPUtil.getParameter(request, prefix + "acct_tgt_cd", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setTrdBndCd(JSPUtil.getParameter(request, prefix + "trd_bnd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchKpiUploadVO[]
	 */
	public SearchKpiUploadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchKpiUploadVO[]
	 */
	public SearchKpiUploadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchKpiUploadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] raCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cmpb_amt", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] acctTgtCd = (JSPUtil.getParameter(request, prefix	+ "acct_tgt_cd", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] trdBndCd = (JSPUtil.getParameter(request, prefix	+ "trd_bnd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchKpiUploadVO();
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (raCmpbAmt[i] != null)
					model.setRaCmpbAmt(raCmpbAmt[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (acctTgtCd[i] != null)
					model.setAcctTgtCd(acctTgtCd[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (trdBndCd[i] != null)
					model.setTrdBndCd(trdBndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchKpiUploadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchKpiUploadVO[]
	 */
	public SearchKpiUploadVO[] getSearchKpiUploadVOs(){
		SearchKpiUploadVO[] vos = (SearchKpiUploadVO[])models.toArray(new SearchKpiUploadVO[models.size()]);
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
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmpbAmt = this.raCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTgtCd = this.acctTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdBndCd = this.trdBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
