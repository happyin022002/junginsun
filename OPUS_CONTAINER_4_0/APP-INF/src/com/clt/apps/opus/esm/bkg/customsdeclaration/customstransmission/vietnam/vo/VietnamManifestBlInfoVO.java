/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamManifestBlInfoVO.java
*@FileTitle : VietnamManifestBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.24 조원주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo;

import java.lang.reflect.Field;
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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VietnamManifestBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VietnamManifestBlInfoVO> models = new ArrayList<VietnamManifestBlInfoVO>();
	
	/* Column Info */
	private String blInd = null;
	/* Column Info */
	private String blMea = null;
	/* Column Info */
	private String blpkgUnit = null;
	/* Column Info */
	private String commodityCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blWgt = null;
	/* Column Info */
	private String blmeaUnit = null;
	/* Column Info */
	private String blwgtUnit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String blVol = null;
	/* Column Info */
	private String loopInd = null;
	/* Column Info */
	private String blvolUnit = null;
	/* Column Info */
	private String blPkg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VietnamManifestBlInfoVO() {}

	public VietnamManifestBlInfoVO(String ibflag, String pagerows, String loopInd, String blNo, String bkgNo, String blInd, String blPkg, String blpkgUnit, String blWgt, String blwgtUnit, String blVol, String blvolUnit, String blMea, String blmeaUnit, String commodityCd) {
		this.blInd = blInd;
		this.blMea = blMea;
		this.blpkgUnit = blpkgUnit;
		this.commodityCd = commodityCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blWgt = blWgt;
		this.blmeaUnit = blmeaUnit;
		this.blwgtUnit = blwgtUnit;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.blVol = blVol;
		this.loopInd = loopInd;
		this.blvolUnit = blvolUnit;
		this.blPkg = blPkg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_ind", getBlInd());
		this.hashColumns.put("bl_mea", getBlMea());
		this.hashColumns.put("blpkg_unit", getBlpkgUnit());
		this.hashColumns.put("commodity_cd", getCommodityCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_wgt", getBlWgt());
		this.hashColumns.put("blmea_unit", getBlmeaUnit());
		this.hashColumns.put("blwgt_unit", getBlwgtUnit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bl_vol", getBlVol());
		this.hashColumns.put("loop_ind", getLoopInd());
		this.hashColumns.put("blvol_unit", getBlvolUnit());
		this.hashColumns.put("bl_pkg", getBlPkg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_ind", "blInd");
		this.hashFields.put("bl_mea", "blMea");
		this.hashFields.put("blpkg_unit", "blpkgUnit");
		this.hashFields.put("commodity_cd", "commodityCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_wgt", "blWgt");
		this.hashFields.put("blmea_unit", "blmeaUnit");
		this.hashFields.put("blwgt_unit", "blwgtUnit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_vol", "blVol");
		this.hashFields.put("loop_ind", "loopInd");
		this.hashFields.put("blvol_unit", "blvolUnit");
		this.hashFields.put("bl_pkg", "blPkg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blInd
	 */
	public String getBlInd() {
		return this.blInd;
	}
	
	/**
	 * Column Info
	 * @return blMea
	 */
	public String getBlMea() {
		return this.blMea;
	}
	
	/**
	 * Column Info
	 * @return blpkgUnit
	 */
	public String getBlpkgUnit() {
		return this.blpkgUnit;
	}
	
	/**
	 * Column Info
	 * @return commodityCd
	 */
	public String getCommodityCd() {
		return this.commodityCd;
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
	 * Column Info
	 * @return blWgt
	 */
	public String getBlWgt() {
		return this.blWgt;
	}
	
	/**
	 * Column Info
	 * @return blmeaUnit
	 */
	public String getBlmeaUnit() {
		return this.blmeaUnit;
	}
	
	/**
	 * Column Info
	 * @return blwgtUnit
	 */
	public String getBlwgtUnit() {
		return this.blwgtUnit;
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
	 * @return blVol
	 */
	public String getBlVol() {
		return this.blVol;
	}
	
	/**
	 * Column Info
	 * @return loopInd
	 */
	public String getLoopInd() {
		return this.loopInd;
	}
	
	/**
	 * Column Info
	 * @return blvolUnit
	 */
	public String getBlvolUnit() {
		return this.blvolUnit;
	}
	
	/**
	 * Column Info
	 * @return blPkg
	 */
	public String getBlPkg() {
		return this.blPkg;
	}
	

	/**
	 * Column Info
	 * @param blInd
	 */
	public void setBlInd(String blInd) {
		this.blInd = blInd;
	}
	
	/**
	 * Column Info
	 * @param blMea
	 */
	public void setBlMea(String blMea) {
		this.blMea = blMea;
	}
	
	/**
	 * Column Info
	 * @param blpkgUnit
	 */
	public void setBlpkgUnit(String blpkgUnit) {
		this.blpkgUnit = blpkgUnit;
	}
	
	/**
	 * Column Info
	 * @param commodityCd
	 */
	public void setCommodityCd(String commodityCd) {
		this.commodityCd = commodityCd;
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
	 * Column Info
	 * @param blWgt
	 */
	public void setBlWgt(String blWgt) {
		this.blWgt = blWgt;
	}
	
	/**
	 * Column Info
	 * @param blmeaUnit
	 */
	public void setBlmeaUnit(String blmeaUnit) {
		this.blmeaUnit = blmeaUnit;
	}
	
	/**
	 * Column Info
	 * @param blwgtUnit
	 */
	public void setBlwgtUnit(String blwgtUnit) {
		this.blwgtUnit = blwgtUnit;
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
	 * @param blVol
	 */
	public void setBlVol(String blVol) {
		this.blVol = blVol;
	}
	
	/**
	 * Column Info
	 * @param loopInd
	 */
	public void setLoopInd(String loopInd) {
		this.loopInd = loopInd;
	}
	
	/**
	 * Column Info
	 * @param blvolUnit
	 */
	public void setBlvolUnit(String blvolUnit) {
		this.blvolUnit = blvolUnit;
	}
	
	/**
	 * Column Info
	 * @param blPkg
	 */
	public void setBlPkg(String blPkg) {
		this.blPkg = blPkg;
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
		setBlInd(JSPUtil.getParameter(request, prefix + "bl_ind", ""));
		setBlMea(JSPUtil.getParameter(request, prefix + "bl_mea", ""));
		setBlpkgUnit(JSPUtil.getParameter(request, prefix + "blpkg_unit", ""));
		setCommodityCd(JSPUtil.getParameter(request, prefix + "commodity_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlWgt(JSPUtil.getParameter(request, prefix + "bl_wgt", ""));
		setBlmeaUnit(JSPUtil.getParameter(request, prefix + "blmea_unit", ""));
		setBlwgtUnit(JSPUtil.getParameter(request, prefix + "blwgt_unit", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBlVol(JSPUtil.getParameter(request, prefix + "bl_vol", ""));
		setLoopInd(JSPUtil.getParameter(request, prefix + "loop_ind", ""));
		setBlvolUnit(JSPUtil.getParameter(request, prefix + "blvol_unit", ""));
		setBlPkg(JSPUtil.getParameter(request, prefix + "bl_pkg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VietnamManifestBlInfoVO[]
	 */
	public VietnamManifestBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VietnamManifestBlInfoVO[]
	 */
	public VietnamManifestBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VietnamManifestBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blInd = (JSPUtil.getParameter(request, prefix	+ "bl_ind", length));
			String[] blMea = (JSPUtil.getParameter(request, prefix	+ "bl_mea", length));
			String[] blpkgUnit = (JSPUtil.getParameter(request, prefix	+ "blpkg_unit", length));
			String[] commodityCd = (JSPUtil.getParameter(request, prefix	+ "commodity_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blWgt = (JSPUtil.getParameter(request, prefix	+ "bl_wgt", length));
			String[] blmeaUnit = (JSPUtil.getParameter(request, prefix	+ "blmea_unit", length));
			String[] blwgtUnit = (JSPUtil.getParameter(request, prefix	+ "blwgt_unit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] blVol = (JSPUtil.getParameter(request, prefix	+ "bl_vol", length));
			String[] loopInd = (JSPUtil.getParameter(request, prefix	+ "loop_ind", length));
			String[] blvolUnit = (JSPUtil.getParameter(request, prefix	+ "blvol_unit", length));
			String[] blPkg = (JSPUtil.getParameter(request, prefix	+ "bl_pkg", length));
			
			for (int i = 0; i < length; i++) {
				model = new VietnamManifestBlInfoVO();
				if (blInd[i] != null)
					model.setBlInd(blInd[i]);
				if (blMea[i] != null)
					model.setBlMea(blMea[i]);
				if (blpkgUnit[i] != null)
					model.setBlpkgUnit(blpkgUnit[i]);
				if (commodityCd[i] != null)
					model.setCommodityCd(commodityCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blWgt[i] != null)
					model.setBlWgt(blWgt[i]);
				if (blmeaUnit[i] != null)
					model.setBlmeaUnit(blmeaUnit[i]);
				if (blwgtUnit[i] != null)
					model.setBlwgtUnit(blwgtUnit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (blVol[i] != null)
					model.setBlVol(blVol[i]);
				if (loopInd[i] != null)
					model.setLoopInd(loopInd[i]);
				if (blvolUnit[i] != null)
					model.setBlvolUnit(blvolUnit[i]);
				if (blPkg[i] != null)
					model.setBlPkg(blPkg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVietnamManifestBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VietnamManifestBlInfoVO[]
	 */
	public VietnamManifestBlInfoVO[] getVietnamManifestBlInfoVOs(){
		VietnamManifestBlInfoVO[] vos = (VietnamManifestBlInfoVO[])models.toArray(new VietnamManifestBlInfoVO[models.size()]);
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
		this.blInd = this.blInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMea = this.blMea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkgUnit = this.blpkgUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodityCd = this.commodityCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWgt = this.blWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmeaUnit = this.blmeaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blwgtUnit = this.blwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blVol = this.blVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loopInd = this.loopInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blvolUnit = this.blvolUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPkg = this.blPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
