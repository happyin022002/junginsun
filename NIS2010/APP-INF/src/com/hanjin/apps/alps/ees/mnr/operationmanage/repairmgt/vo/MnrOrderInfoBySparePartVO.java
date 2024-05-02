/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MnrOrderInfoBySparePartVO.java
*@FileTitle : MnrOrderInfoBySparePartVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.04
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.06.04 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrOrderInfoBySparePartVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrOrderInfoBySparePartVO> models = new ArrayList<MnrOrderInfoBySparePartVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sprPrtNo = null;
	/* Column Info */
	private String sprPrtSplTpCd = null;
	/* Column Info */
	private String sprPrtNm = null;
	/* Column Info */
	private String totalAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslVvd = null;
	/* Column Info */
	private String sprUtTpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String ordIssOfcCd = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String sprPrtUcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MnrOrderInfoBySparePartVO() {}

	public MnrOrderInfoBySparePartVO(String ibflag, String pagerows, String currCd, String creDt, String sprPrtNo, String sprPrtNm, String totalAmt, String vslVvd, String sprUtTpNm, String ydCd, String mnrOrdSeq, String ordIssOfcCd, String rprQty, String sprPrtUcAmt, String sprPrtSplTpCd) {
		this.currCd = currCd;
		this.creDt = creDt;
		this.sprPrtNo = sprPrtNo;
		this.sprPrtSplTpCd = sprPrtSplTpCd;
		this.sprPrtNm = sprPrtNm;
		this.totalAmt = totalAmt;
		this.pagerows = pagerows;
		this.vslVvd = vslVvd;
		this.sprUtTpNm = sprUtTpNm;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.mnrOrdSeq = mnrOrdSeq;
		this.ordIssOfcCd = ordIssOfcCd;
		this.rprQty = rprQty;
		this.sprPrtUcAmt = sprPrtUcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spr_prt_no", getSprPrtNo());
		this.hashColumns.put("spr_prt_spl_tp_cd", getSprPrtSplTpCd());
		this.hashColumns.put("spr_prt_nm", getSprPrtNm());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_vvd", getVslVvd());
		this.hashColumns.put("spr_ut_tp_nm", getSprUtTpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("ord_iss_ofc_cd", getOrdIssOfcCd());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("spr_prt_uc_amt", getSprPrtUcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spr_prt_no", "sprPrtNo");
		this.hashFields.put("spr_prt_spl_tp_cd", "sprPrtSplTpCd");
		this.hashFields.put("spr_prt_nm", "sprPrtNm");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_vvd", "vslVvd");
		this.hashFields.put("spr_ut_tp_nm", "sprUtTpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("ord_iss_ofc_cd", "ordIssOfcCd");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("spr_prt_uc_amt", "sprPrtUcAmt");
		return this.hashFields;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return sprPrtNo
	 */
	public String getSprPrtNo() {
		return this.sprPrtNo;
	}
	
	/**
	 * Column Info
	 * @return sprPrtSplTpCd
	 */
	public String getSprPrtSplTpCd() {
		return this.sprPrtSplTpCd;
	}
	
	/**
	 * Column Info
	 * @return sprPrtNm
	 */
	public String getSprPrtNm() {
		return this.sprPrtNm;
	}
	
	/**
	 * Column Info
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
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
	 * @return vslVvd
	 */
	public String getVslVvd() {
		return this.vslVvd;
	}
	
	/**
	 * Column Info
	 * @return sprUtTpNm
	 */
	public String getSprUtTpNm() {
		return this.sprUtTpNm;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @return ordIssOfcCd
	 */
	public String getOrdIssOfcCd() {
		return this.ordIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rprQty
	 */
	public String getRprQty() {
		return this.rprQty;
	}
	
	/**
	 * Column Info
	 * @return sprPrtUcAmt
	 */
	public String getSprPrtUcAmt() {
		return this.sprPrtUcAmt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param sprPrtNo
	 */
	public void setSprPrtNo(String sprPrtNo) {
		this.sprPrtNo = sprPrtNo;
	}
	
	/**
	 * Column Info
	 * @param sprPrtSplTpCd
	 */
	public void setSprPrtSplTpCd(String sprPrtSplTpCd) {
		this.sprPrtSplTpCd = sprPrtSplTpCd;
	}
	
	/**
	 * Column Info
	 * @param sprPrtNm
	 */
	public void setSprPrtNm(String sprPrtNm) {
		this.sprPrtNm = sprPrtNm;
	}
	
	/**
	 * Column Info
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
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
	 * @param vslVvd
	 */
	public void setVslVvd(String vslVvd) {
		this.vslVvd = vslVvd;
	}
	
	/**
	 * Column Info
	 * @param sprUtTpNm
	 */
	public void setSprUtTpNm(String sprUtTpNm) {
		this.sprUtTpNm = sprUtTpNm;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @param ordIssOfcCd
	 */
	public void setOrdIssOfcCd(String ordIssOfcCd) {
		this.ordIssOfcCd = ordIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rprQty
	 */
	public void setRprQty(String rprQty) {
		this.rprQty = rprQty;
	}
	
	/**
	 * Column Info
	 * @param sprPrtUcAmt
	 */
	public void setSprPrtUcAmt(String sprPrtUcAmt) {
		this.sprPrtUcAmt = sprPrtUcAmt;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSprPrtNo(JSPUtil.getParameter(request, prefix + "spr_prt_no", ""));
		setSprPrtSplTpCd(JSPUtil.getParameter(request, prefix + "spr_prt_spl_tp_cd", ""));
		setSprPrtNm(JSPUtil.getParameter(request, prefix + "spr_prt_nm", ""));
		setTotalAmt(JSPUtil.getParameter(request, prefix + "total_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslVvd(JSPUtil.getParameter(request, prefix + "vsl_vvd", ""));
		setSprUtTpNm(JSPUtil.getParameter(request, prefix + "spr_ut_tp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setOrdIssOfcCd(JSPUtil.getParameter(request, prefix + "ord_iss_ofc_cd", ""));
		setRprQty(JSPUtil.getParameter(request, prefix + "rpr_qty", ""));
		setSprPrtUcAmt(JSPUtil.getParameter(request, prefix + "spr_prt_uc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrOrderInfoBySparePartVO[]
	 */
	public MnrOrderInfoBySparePartVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrOrderInfoBySparePartVO[]
	 */
	public MnrOrderInfoBySparePartVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrOrderInfoBySparePartVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sprPrtNo = (JSPUtil.getParameter(request, prefix	+ "spr_prt_no", length));
			String[] sprPrtSplTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_spl_tp_cd", length));
			String[] sprPrtNm = (JSPUtil.getParameter(request, prefix	+ "spr_prt_nm", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslVvd = (JSPUtil.getParameter(request, prefix	+ "vsl_vvd", length));
			String[] sprUtTpNm = (JSPUtil.getParameter(request, prefix	+ "spr_ut_tp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] ordIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "ord_iss_ofc_cd", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] sprPrtUcAmt = (JSPUtil.getParameter(request, prefix	+ "spr_prt_uc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrOrderInfoBySparePartVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sprPrtNo[i] != null)
					model.setSprPrtNo(sprPrtNo[i]);
				if (sprPrtSplTpCd[i] != null)
					model.setSprPrtSplTpCd(sprPrtSplTpCd[i]);
				if (sprPrtNm[i] != null)
					model.setSprPrtNm(sprPrtNm[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslVvd[i] != null)
					model.setVslVvd(vslVvd[i]);
				if (sprUtTpNm[i] != null)
					model.setSprUtTpNm(sprUtTpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (ordIssOfcCd[i] != null)
					model.setOrdIssOfcCd(ordIssOfcCd[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (sprPrtUcAmt[i] != null)
					model.setSprPrtUcAmt(sprPrtUcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrOrderInfoBySparePartVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrOrderInfoBySparePartVO[]
	 */
	public MnrOrderInfoBySparePartVO[] getMnrOrderInfoBySparePartVOs(){
		MnrOrderInfoBySparePartVO[] vos = (MnrOrderInfoBySparePartVO[])models.toArray(new MnrOrderInfoBySparePartVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNo = this.sprPrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplTpCd = this.sprPrtSplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNm = this.sprPrtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVvd = this.vslVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprUtTpNm = this.sprUtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordIssOfcCd = this.ordIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUcAmt = this.sprPrtUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
