/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaCncusCntrVO.java
*@FileTitle : RussiaCncusCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

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

public class RussiaCncusCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiaCncusCntrVO> models = new ArrayList<RussiaCncusCntrVO>();
	
	/* Column Info */
	private String ovrDimRearLen = null;
	/* Column Info */
	private String cntrTpszIsoCd = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String cntrWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ovrDimFntLen = null;
	/* Column Info */
	private String cntrMeasQty = null;
	/* Column Info */
	private String ovrDimRtLen = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String tareWgt = null;
	/* Column Info */
	private String pkgQty = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ovrDimLfLen = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiaCncusCntrVO() {}

	public RussiaCncusCntrVO(String ibflag, String pagerows, String cntrTpszIsoCd, String cntrWgt, String cntrMeasQty, String ovrDimRtLen, String blNo, String ovrDimRearLen, String ovrHgt, String ovrDimFntLen, String cntrNo, String fullMtyCd, String cntrSealNo, String tareWgt, String ovrDimLfLen, String pkgQty) {
		this.ovrDimRearLen = ovrDimRearLen;
		this.cntrTpszIsoCd = cntrTpszIsoCd;
		this.ovrHgt = ovrHgt;
		this.cntrWgt = cntrWgt;
		this.ibflag = ibflag;
		this.ovrDimFntLen = ovrDimFntLen;
		this.cntrMeasQty = cntrMeasQty;
		this.ovrDimRtLen = ovrDimRtLen;
		this.cntrNo = cntrNo;
		this.fullMtyCd = fullMtyCd;
		this.cntrSealNo = cntrSealNo;
		this.tareWgt = tareWgt;
		this.pkgQty = pkgQty;
		this.blNo = blNo;
		this.ovrDimLfLen = ovrDimLfLen;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ovr_dim_rear_len", getOvrDimRearLen());
		this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ovr_dim_fnt_len", getOvrDimFntLen());
		this.hashColumns.put("cntr_meas_qty", getCntrMeasQty());
		this.hashColumns.put("ovr_dim_rt_len", getOvrDimRtLen());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("tare_wgt", getTareWgt());
		this.hashColumns.put("pkg_qty", getPkgQty());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ovr_dim_lf_len", getOvrDimLfLen());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ovr_dim_rear_len", "ovrDimRearLen");
		this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ovr_dim_fnt_len", "ovrDimFntLen");
		this.hashFields.put("cntr_meas_qty", "cntrMeasQty");
		this.hashFields.put("ovr_dim_rt_len", "ovrDimRtLen");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("pkg_qty", "pkgQty");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ovr_dim_lf_len", "ovrDimLfLen");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ovrDimRearLen
	 */
	public String getOvrDimRearLen() {
		return this.ovrDimRearLen;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszIsoCd
	 */
	public String getCntrTpszIsoCd() {
		return this.cntrTpszIsoCd;
	}
	
	/**
	 * Column Info
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
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
	 * @return ovrDimFntLen
	 */
	public String getOvrDimFntLen() {
		return this.ovrDimFntLen;
	}
	
	/**
	 * Column Info
	 * @return cntrMeasQty
	 */
	public String getCntrMeasQty() {
		return this.cntrMeasQty;
	}
	
	/**
	 * Column Info
	 * @return ovrDimRtLen
	 */
	public String getOvrDimRtLen() {
		return this.ovrDimRtLen;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return tareWgt
	 */
	public String getTareWgt() {
		return this.tareWgt;
	}
	
	/**
	 * Column Info
	 * @return pkgQty
	 */
	public String getPkgQty() {
		return this.pkgQty;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ovrDimLfLen
	 */
	public String getOvrDimLfLen() {
		return this.ovrDimLfLen;
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
	 * @param ovrDimRearLen
	 */
	public void setOvrDimRearLen(String ovrDimRearLen) {
		this.ovrDimRearLen = ovrDimRearLen;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszIsoCd
	 */
	public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
		this.cntrTpszIsoCd = cntrTpszIsoCd;
	}
	
	/**
	 * Column Info
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
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
	 * @param ovrDimFntLen
	 */
	public void setOvrDimFntLen(String ovrDimFntLen) {
		this.ovrDimFntLen = ovrDimFntLen;
	}
	
	/**
	 * Column Info
	 * @param cntrMeasQty
	 */
	public void setCntrMeasQty(String cntrMeasQty) {
		this.cntrMeasQty = cntrMeasQty;
	}
	
	/**
	 * Column Info
	 * @param ovrDimRtLen
	 */
	public void setOvrDimRtLen(String ovrDimRtLen) {
		this.ovrDimRtLen = ovrDimRtLen;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param tareWgt
	 */
	public void setTareWgt(String tareWgt) {
		this.tareWgt = tareWgt;
	}
	
	/**
	 * Column Info
	 * @param pkgQty
	 */
	public void setPkgQty(String pkgQty) {
		this.pkgQty = pkgQty;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ovrDimLfLen
	 */
	public void setOvrDimLfLen(String ovrDimLfLen) {
		this.ovrDimLfLen = ovrDimLfLen;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setOvrDimRearLen(JSPUtil.getParameter(request, prefix + "ovr_dim_rear_len", ""));
		setCntrTpszIsoCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", ""));
		setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOvrDimFntLen(JSPUtil.getParameter(request, prefix + "ovr_dim_fnt_len", ""));
		setCntrMeasQty(JSPUtil.getParameter(request, prefix + "cntr_meas_qty", ""));
		setOvrDimRtLen(JSPUtil.getParameter(request, prefix + "ovr_dim_rt_len", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setTareWgt(JSPUtil.getParameter(request, prefix + "tare_wgt", ""));
		setPkgQty(JSPUtil.getParameter(request, prefix + "pkg_qty", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setOvrDimLfLen(JSPUtil.getParameter(request, prefix + "ovr_dim_lf_len", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiaCncusCntrVO[]
	 */
	public RussiaCncusCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiaCncusCntrVO[]
	 */
	public RussiaCncusCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiaCncusCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ovrDimRearLen = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_rear_len", length));
			String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_iso_cd", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ovrDimFntLen = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_fnt_len", length));
			String[] cntrMeasQty = (JSPUtil.getParameter(request, prefix	+ "cntr_meas_qty", length));
			String[] ovrDimRtLen = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_rt_len", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] tareWgt = (JSPUtil.getParameter(request, prefix	+ "tare_wgt", length));
			String[] pkgQty = (JSPUtil.getParameter(request, prefix	+ "pkg_qty", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ovrDimLfLen = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_lf_len", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiaCncusCntrVO();
				if (ovrDimRearLen[i] != null)
					model.setOvrDimRearLen(ovrDimRearLen[i]);
				if (cntrTpszIsoCd[i] != null)
					model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ovrDimFntLen[i] != null)
					model.setOvrDimFntLen(ovrDimFntLen[i]);
				if (cntrMeasQty[i] != null)
					model.setCntrMeasQty(cntrMeasQty[i]);
				if (ovrDimRtLen[i] != null)
					model.setOvrDimRtLen(ovrDimRtLen[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (tareWgt[i] != null)
					model.setTareWgt(tareWgt[i]);
				if (pkgQty[i] != null)
					model.setPkgQty(pkgQty[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ovrDimLfLen[i] != null)
					model.setOvrDimLfLen(ovrDimLfLen[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiaCncusCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiaCncusCntrVO[]
	 */
	public RussiaCncusCntrVO[] getRussiaCncusCntrVOs(){
		RussiaCncusCntrVO[] vos = (RussiaCncusCntrVO[])models.toArray(new RussiaCncusCntrVO[models.size()]);
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
		this.ovrDimRearLen = this.ovrDimRearLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszIsoCd = this.cntrTpszIsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimFntLen = this.ovrDimFntLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeasQty = this.cntrMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimRtLen = this.ovrDimRtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt = this.tareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgQty = this.pkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimLfLen = this.ovrDimLfLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
