/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgCalculationVO.java
*@FileTitle : BkgCalculationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.08.24 김영오
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCalculationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgCalculationVO> models = new ArrayList<BkgCalculationVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String calculate = null;
	/* Column Info */
	private String chkCommCmpn = null;
	/* Column Info */
	private String polEtdDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String revVvdCd = null;
	/* Column Info */
	private String chkAll = null;
	/* Column Info */
	private String chkFac = null;
	/* Column Info */
	private String chkCmpn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgCalculationVO() {}

	public BkgCalculationVO(String ibflag, String pagerows, String bkgNo, String blNo, String bkgStsCd, String polEtdDt, String updDt, String calculate, String chkCommCmpn, String chkFac, String chkCmpn, String chkAll, String revVvdCd) {
		this.updDt = updDt;
		this.bkgStsCd = bkgStsCd;
		this.calculate = calculate;
		this.chkCommCmpn = chkCommCmpn;
		this.polEtdDt = polEtdDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.revVvdCd = revVvdCd;
		this.chkAll = chkAll;
		this.chkFac = chkFac;
		this.chkCmpn = chkCmpn;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("calculate", getCalculate());
		this.hashColumns.put("chk_comm_cmpn", getChkCommCmpn());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());
		this.hashColumns.put("chk_all", getChkAll());
		this.hashColumns.put("chk_fac", getChkFac());
		this.hashColumns.put("chk_cmpn", getChkCmpn());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("calculate", "calculate");
		this.hashFields.put("chk_comm_cmpn", "chkCommCmpn");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		this.hashFields.put("chk_all", "chkAll");
		this.hashFields.put("chk_fac", "chkFac");
		this.hashFields.put("chk_cmpn", "chkCmpn");
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}

	/**
	 * Column Info
	 * @return calculate
	 */
	public String getCalculate() {
		return this.calculate;
	}

	/**
	 * Column Info
	 * @return chkCommCmpn
	 */
	public String getChkCommCmpn() {
		return this.chkCommCmpn;
	}

	/**
	 * Column Info
	 * @return polEtdDt
	 */
	public String getPolEtdDt() {
		return this.polEtdDt;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return revVvdCd
	 */
	public String getRevVvdCd() {
		return this.revVvdCd;
	}

	/**
	 * Column Info
	 * @return chkAll
	 */
	public String getChkAll() {
		return this.chkAll;
	}

	/**
	 * Column Info
	 * @return chkFac
	 */
	public String getChkFac() {
		return this.chkFac;
	}

	/**
	 * Column Info
	 * @return chkCmpn
	 */
	public String getChkCmpn() {
		return this.chkCmpn;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

	/**
	 * Column Info
	 * @param calculate
	 */
	public void setCalculate(String calculate) {
		this.calculate = calculate;
	}

	/**
	 * Column Info
	 * @param chkCommCmpn
	 */
	public void setChkCommCmpn(String chkCommCmpn) {
		this.chkCommCmpn = chkCommCmpn;
	}

	/**
	 * Column Info
	 * @param polEtdDt
	 */
	public void setPolEtdDt(String polEtdDt) {
		this.polEtdDt = polEtdDt;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param revVvdCd
	 */
	public void setRevVvdCd(String revVvdCd) {
		this.revVvdCd = revVvdCd;
	}

	/**
	 * Column Info
	 * @param chkAll
	 */
	public void setChkAll(String chkAll) {
		this.chkAll = chkAll;
	}

	/**
	 * Column Info
	 * @param chkFac
	 */
	public void setChkFac(String chkFac) {
		this.chkFac = chkFac;
	}

	/**
	 * Column Info
	 * @param chkCmpn
	 */
	public void setChkCmpn(String chkCmpn) {
		this.chkCmpn = chkCmpn;
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
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCalculate(JSPUtil.getParameter(request, prefix + "calculate", ""));
		setChkCommCmpn(JSPUtil.getParameter(request, prefix + "chk_comm_cmpn", ""));
		setPolEtdDt(JSPUtil.getParameter(request, prefix + "pol_etd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRevVvdCd(JSPUtil.getParameter(request, prefix + "rev_vvd_cd", ""));
		setChkAll(JSPUtil.getParameter(request, prefix + "chk_all", ""));
		setChkFac(JSPUtil.getParameter(request, prefix + "chk_fac", ""));
		setChkCmpn(JSPUtil.getParameter(request, prefix + "chk_cmpn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCalculationVO[]
	 */
	public BkgCalculationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgCalculationVO[]
	 */
	public BkgCalculationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCalculationVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] calculate = (JSPUtil.getParameter(request, prefix	+ "calculate", length));
			String[] chkCommCmpn = (JSPUtil.getParameter(request, prefix	+ "chk_comm_cmpn", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] revVvdCd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_cd", length));
			String[] chkAll = (JSPUtil.getParameter(request, prefix	+ "chk_all", length));
			String[] chkFac = (JSPUtil.getParameter(request, prefix	+ "chk_fac", length));
			String[] chkCmpn = (JSPUtil.getParameter(request, prefix	+ "chk_cmpn", length));

			for (int i = 0; i < length; i++) {
				model = new BkgCalculationVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (calculate[i] != null)
					model.setCalculate(calculate[i]);
				if (chkCommCmpn[i] != null)
					model.setChkCommCmpn(chkCommCmpn[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (revVvdCd[i] != null)
					model.setRevVvdCd(revVvdCd[i]);
				if (chkAll[i] != null)
					model.setChkAll(chkAll[i]);
				if (chkFac[i] != null)
					model.setChkFac(chkFac[i]);
				if (chkCmpn[i] != null)
					model.setChkCmpn(chkCmpn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCalculationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCalculationVO[]
	 */
	public BkgCalculationVO[] getBkgCalculationVOs(){
		BkgCalculationVO[] vos = (BkgCalculationVO[])models.toArray(new BkgCalculationVO[models.size()]);
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
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calculate = this.calculate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCommCmpn = this.chkCommCmpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd = this.revVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkAll = this.chkAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFac = this.chkFac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCmpn = this.chkCmpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
