/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchRevenueVesselVO.java
*@FileTitle : UnmatchRevenueVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.08 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UnmatchRevenueVesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnmatchRevenueVesselVO> models = new ArrayList<UnmatchRevenueVesselVO>();
	
	/* Column Info */
	private String logRgstDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String blInvIfDt = null;
	/* Column Info */
	private String invTtlLoclAmt = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String oldVvd = null;
	/* Column Info */
	private String revVvdMtchFlg = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blInvCfmDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String newRlaneCd = null;
	/* Column Info */
	private String invDeltDivCd = null;
	/* Column Info */
	private String newVvd = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String znIocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UnmatchRevenueVesselVO() {}

	public UnmatchRevenueVesselVO(String ibflag, String pagerows, String revVvdMtchFlg, String arOfcCd, String arIfNo, String blSrcNo, String revVvd, String newVvd, String invTtlLoclAmt, String blInvIfDt, String blInvCfmDt, String invDeltDivCd, String revSrcCd, String bkgNo, String znIocCd, String newRlaneCd, String oldVvd, String trunkVvd, String logRgstDt) {
		this.logRgstDt = logRgstDt;
		this.blSrcNo = blSrcNo;
		this.blInvIfDt = blInvIfDt;
		this.invTtlLoclAmt = invTtlLoclAmt;
		this.trunkVvd = trunkVvd;
		this.oldVvd = oldVvd;
		this.revVvdMtchFlg = revVvdMtchFlg;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.blInvCfmDt = blInvCfmDt;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.revSrcCd = revSrcCd;
		this.arIfNo = arIfNo;
		this.newRlaneCd = newRlaneCd;
		this.invDeltDivCd = invDeltDivCd;
		this.newVvd = newVvd;
		this.revVvd = revVvd;
		this.znIocCd = znIocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("log_rgst_dt", getLogRgstDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("bl_inv_if_dt", getBlInvIfDt());
		this.hashColumns.put("inv_ttl_locl_amt", getInvTtlLoclAmt());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("old_vvd", getOldVvd());
		this.hashColumns.put("rev_vvd_mtch_flg", getRevVvdMtchFlg());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("new_rlane_cd", getNewRlaneCd());
		this.hashColumns.put("inv_delt_div_cd", getInvDeltDivCd());
		this.hashColumns.put("new_vvd", getNewVvd());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("zn_ioc_cd", getZnIocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("log_rgst_dt", "logRgstDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("bl_inv_if_dt", "blInvIfDt");
		this.hashFields.put("inv_ttl_locl_amt", "invTtlLoclAmt");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("old_vvd", "oldVvd");
		this.hashFields.put("rev_vvd_mtch_flg", "revVvdMtchFlg");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("new_rlane_cd", "newRlaneCd");
		this.hashFields.put("inv_delt_div_cd", "invDeltDivCd");
		this.hashFields.put("new_vvd", "newVvd");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("zn_ioc_cd", "znIocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return logRgstDt
	 */
	public String getLogRgstDt() {
		return this.logRgstDt;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return blInvIfDt
	 */
	public String getBlInvIfDt() {
		return this.blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @return invTtlLoclAmt
	 */
	public String getInvTtlLoclAmt() {
		return this.invTtlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return oldVvd
	 */
	public String getOldVvd() {
		return this.oldVvd;
	}
	
	/**
	 * Column Info
	 * @return revVvdMtchFlg
	 */
	public String getRevVvdMtchFlg() {
		return this.revVvdMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return blInvCfmDt
	 */
	public String getBlInvCfmDt() {
		return this.blInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return revSrcCd
	 */
	public String getRevSrcCd() {
		return this.revSrcCd;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return newRlaneCd
	 */
	public String getNewRlaneCd() {
		return this.newRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return invDeltDivCd
	 */
	public String getInvDeltDivCd() {
		return this.invDeltDivCd;
	}
	
	/**
	 * Column Info
	 * @return newVvd
	 */
	public String getNewVvd() {
		return this.newVvd;
	}
	
	/**
	 * Column Info
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	
	/**
	 * Column Info
	 * @return znIocCd
	 */
	public String getZnIocCd() {
		return this.znIocCd;
	}
	

	/**
	 * Column Info
	 * @param logRgstDt
	 */
	public void setLogRgstDt(String logRgstDt) {
		this.logRgstDt = logRgstDt;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param blInvIfDt
	 */
	public void setBlInvIfDt(String blInvIfDt) {
		this.blInvIfDt = blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @param invTtlLoclAmt
	 */
	public void setInvTtlLoclAmt(String invTtlLoclAmt) {
		this.invTtlLoclAmt = invTtlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param oldVvd
	 */
	public void setOldVvd(String oldVvd) {
		this.oldVvd = oldVvd;
	}
	
	/**
	 * Column Info
	 * @param revVvdMtchFlg
	 */
	public void setRevVvdMtchFlg(String revVvdMtchFlg) {
		this.revVvdMtchFlg = revVvdMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param blInvCfmDt
	 */
	public void setBlInvCfmDt(String blInvCfmDt) {
		this.blInvCfmDt = blInvCfmDt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param revSrcCd
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param newRlaneCd
	 */
	public void setNewRlaneCd(String newRlaneCd) {
		this.newRlaneCd = newRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param invDeltDivCd
	 */
	public void setInvDeltDivCd(String invDeltDivCd) {
		this.invDeltDivCd = invDeltDivCd;
	}
	
	/**
	 * Column Info
	 * @param newVvd
	 */
	public void setNewVvd(String newVvd) {
		this.newVvd = newVvd;
	}
	
	/**
	 * Column Info
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Column Info
	 * @param znIocCd
	 */
	public void setZnIocCd(String znIocCd) {
		this.znIocCd = znIocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLogRgstDt(JSPUtil.getParameter(request, "log_rgst_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setBlInvIfDt(JSPUtil.getParameter(request, "bl_inv_if_dt", ""));
		setInvTtlLoclAmt(JSPUtil.getParameter(request, "inv_ttl_locl_amt", ""));
		setTrunkVvd(JSPUtil.getParameter(request, "trunk_vvd", ""));
		setOldVvd(JSPUtil.getParameter(request, "old_vvd", ""));
		setRevVvdMtchFlg(JSPUtil.getParameter(request, "rev_vvd_mtch_flg", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request, "bl_inv_cfm_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setNewRlaneCd(JSPUtil.getParameter(request, "new_rlane_cd", ""));
		setInvDeltDivCd(JSPUtil.getParameter(request, "inv_delt_div_cd", ""));
		setNewVvd(JSPUtil.getParameter(request, "new_vvd", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setZnIocCd(JSPUtil.getParameter(request, "zn_ioc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnmatchRevenueVesselVO[]
	 */
	public UnmatchRevenueVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnmatchRevenueVesselVO[]
	 */
	public UnmatchRevenueVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnmatchRevenueVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] logRgstDt = (JSPUtil.getParameter(request, prefix	+ "log_rgst_dt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] blInvIfDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_dt", length));
			String[] invTtlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_locl_amt", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] oldVvd = (JSPUtil.getParameter(request, prefix	+ "old_vvd", length));
			String[] revVvdMtchFlg = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_mtch_flg", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_cfm_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] newRlaneCd = (JSPUtil.getParameter(request, prefix	+ "new_rlane_cd", length));
			String[] invDeltDivCd = (JSPUtil.getParameter(request, prefix	+ "inv_delt_div_cd", length));
			String[] newVvd = (JSPUtil.getParameter(request, prefix	+ "new_vvd", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] znIocCd = (JSPUtil.getParameter(request, prefix	+ "zn_ioc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnmatchRevenueVesselVO();
				if (logRgstDt[i] != null)
					model.setLogRgstDt(logRgstDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (blInvIfDt[i] != null)
					model.setBlInvIfDt(blInvIfDt[i]);
				if (invTtlLoclAmt[i] != null)
					model.setInvTtlLoclAmt(invTtlLoclAmt[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (oldVvd[i] != null)
					model.setOldVvd(oldVvd[i]);
				if (revVvdMtchFlg[i] != null)
					model.setRevVvdMtchFlg(revVvdMtchFlg[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blInvCfmDt[i] != null)
					model.setBlInvCfmDt(blInvCfmDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (newRlaneCd[i] != null)
					model.setNewRlaneCd(newRlaneCd[i]);
				if (invDeltDivCd[i] != null)
					model.setInvDeltDivCd(invDeltDivCd[i]);
				if (newVvd[i] != null)
					model.setNewVvd(newVvd[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (znIocCd[i] != null)
					model.setZnIocCd(znIocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnmatchRevenueVesselVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnmatchRevenueVesselVO[]
	 */
	public UnmatchRevenueVesselVO[] getUnmatchRevenueVesselVOs(){
		UnmatchRevenueVesselVO[] vos = (UnmatchRevenueVesselVO[])models.toArray(new UnmatchRevenueVesselVO[models.size()]);
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
		this.logRgstDt = this.logRgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvIfDt = this.blInvIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlLoclAmt = this.invTtlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVvd = this.oldVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdMtchFlg = this.revVvdMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt = this.blInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRlaneCd = this.newRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDeltDivCd = this.invDeltDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVvd = this.newVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znIocCd = this.znIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
