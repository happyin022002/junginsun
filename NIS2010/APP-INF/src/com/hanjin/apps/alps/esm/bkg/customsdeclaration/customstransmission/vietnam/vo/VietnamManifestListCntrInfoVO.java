/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamManifestListCntrInfoVO.java
*@FileTitle : VietnamManifestListCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.24 조원주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo;

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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VietnamManifestListCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VietnamManifestListCntrInfoVO> models = new ArrayList<VietnamManifestListCntrInfoVO>();
	
	/* Column Info */
	private String cntrStatus = null;
	/* Column Info */
	private String cntrNbr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoTmpUnit = null;
	/* Column Info */
	private String cntrTWgtUnit = null;
	/* Column Info */
	private String cntrGWgtUnit = null;
	/* Column Info */
	private String cntrTWgt = null;
	/* Column Info */
	private String cntrGWgt = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String cntrTmp = null;
	/* Column Info */
	private String cntrFmInd = null;
	/* Column Info */
	private String cntrType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VietnamManifestListCntrInfoVO() {}

	public VietnamManifestListCntrInfoVO(String ibflag, String pagerows, String cntrNbr, String cntrType, String cntrStatus, String cntrFmInd, String cntrGWgt, String cntrGWgtUnit, String cntrTWgt, String cntrTWgtUnit, String cntrTmp, String cgoTmpUnit, String measQty, String measUtCd) {
		this.cntrStatus = cntrStatus;
		this.cntrNbr = cntrNbr;
		this.ibflag = ibflag;
		this.cgoTmpUnit = cgoTmpUnit;
		this.cntrTWgtUnit = cntrTWgtUnit;
		this.cntrGWgtUnit = cntrGWgtUnit;
		this.cntrTWgt = cntrTWgt;
		this.cntrGWgt = cntrGWgt;
		this.measQty = measQty;
		this.measUtCd = measUtCd;
		this.cntrTmp = cntrTmp;
		this.cntrFmInd = cntrFmInd;
		this.cntrType = cntrType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_status", getCntrStatus());
		this.hashColumns.put("cntr_nbr", getCntrNbr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_tmp_unit", getCgoTmpUnit());
		this.hashColumns.put("cntr_t_wgt_unit", getCntrTWgtUnit());
		this.hashColumns.put("cntr_g_wgt_unit", getCntrGWgtUnit());
		this.hashColumns.put("cntr_t_wgt", getCntrTWgt());
		this.hashColumns.put("cntr_g_wgt", getCntrGWgt());
		this.hashColumns.put("cntr_tmp", getCntrTmp());
		this.hashColumns.put("cntr_fm_ind", getCntrFmInd());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_status", "cntrStatus");
		this.hashFields.put("cntr_nbr", "cntrNbr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_tmp_unit", "cgoTmpUnit");
		this.hashFields.put("cntr_t_wgt_unit", "cntrTWgtUnit");
		this.hashFields.put("cntr_g_wgt_unit", "cntrGWgtUnit");
		this.hashFields.put("cntr_t_wgt", "cntrTWgt");
		this.hashFields.put("cntr_g_wgt", "cntrGWgt");
		this.hashFields.put("cntr_tmp", "cntrTmp");
		this.hashFields.put("cntr_fm_ind", "cntrFmInd");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrStatus
	 */
	public String getCntrStatus() {
		return this.cntrStatus;
	}
	
	/**
	 * Column Info
	 * @return cntrNbr
	 */
	public String getCntrNbr() {
		return this.cntrNbr;
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
	 * @return cgoTmpUnit
	 */
	public String getCgoTmpUnit() {
		return this.cgoTmpUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrTWgtUnit
	 */
	public String getCntrTWgtUnit() {
		return this.cntrTWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrGWgtUnit
	 */
	public String getCntrGWgtUnit() {
		return this.cntrGWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrTWgt
	 */
	public String getCntrTWgt() {
		return this.cntrTWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrGWgt
	 */
	public String getCntrGWgt() {
		return this.cntrGWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrTmp
	 */
	public String getCntrTmp() {
		return this.cntrTmp;
	}
	
	/**
	 * Column Info
	 * @return cntrFmInd
	 */
	public String getCntrFmInd() {
		return this.cntrFmInd;
	}
	
	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @param cntrStatus
	 */
	public void setCntrStatus(String cntrStatus) {
		this.cntrStatus = cntrStatus;
	}
	
	/**
	 * Column Info
	 * @param cntrNbr
	 */
	public void setCntrNbr(String cntrNbr) {
		this.cntrNbr = cntrNbr;
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
	 * @param cgoTmpUnit
	 */
	public void setCgoTmpUnit(String cgoTmpUnit) {
		this.cgoTmpUnit = cgoTmpUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrTWgtUnit
	 */
	public void setCntrTWgtUnit(String cntrTWgtUnit) {
		this.cntrTWgtUnit = cntrTWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrGWgtUnit
	 */
	public void setCntrGWgtUnit(String cntrGWgtUnit) {
		this.cntrGWgtUnit = cntrGWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrTWgt
	 */
	public void setCntrTWgt(String cntrTWgt) {
		this.cntrTWgt = cntrTWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrGWgt
	 */
	public void setCntrGWgt(String cntrGWgt) {
		this.cntrGWgt = cntrGWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrTmp
	 */
	public void setCntrTmp(String cntrTmp) {
		this.cntrTmp = cntrTmp;
	}
	
	/**
	 * Column Info
	 * @param cntrFmInd
	 */
	public void setCntrFmInd(String cntrFmInd) {
		this.cntrFmInd = cntrFmInd;
	}
	
	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
		setCntrStatus(JSPUtil.getParameter(request, prefix + "cntr_status", ""));
		setCntrNbr(JSPUtil.getParameter(request, prefix + "cntr_nbr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCgoTmpUnit(JSPUtil.getParameter(request, prefix + "cgo_tmp_unit", ""));
		setCntrTWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_t_wgt_unit", ""));
		setCntrGWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_g_wgt_unit", ""));
		setCntrTWgt(JSPUtil.getParameter(request, prefix + "cntr_t_wgt", ""));
		setCntrGWgt(JSPUtil.getParameter(request, prefix + "cntr_g_wgt", ""));
		setCntrTmp(JSPUtil.getParameter(request, prefix + "cntr_tmp", ""));
		setCntrFmInd(JSPUtil.getParameter(request, prefix + "cntr_fm_ind", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VietnamManifestListCntrInfoVO[]
	 */
	public VietnamManifestListCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VietnamManifestListCntrInfoVO[]
	 */
	public VietnamManifestListCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VietnamManifestListCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrStatus = (JSPUtil.getParameter(request, prefix	+ "cntr_status", length));
			String[] cntrNbr = (JSPUtil.getParameter(request, prefix	+ "cntr_nbr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoTmpUnit = (JSPUtil.getParameter(request, prefix	+ "cgo_tmp_unit", length));
			String[] cntrTWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_t_wgt_unit", length));
			String[] cntrGWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_g_wgt_unit", length));
			String[] cntrTWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_t_wgt", length));
			String[] cntrGWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_g_wgt", length));
			String[] cntrTmp = (JSPUtil.getParameter(request, prefix	+ "cntr_tmp", length));
			String[] cntrFmInd = (JSPUtil.getParameter(request, prefix	+ "cntr_fm_ind", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VietnamManifestListCntrInfoVO();
				if (cntrStatus[i] != null)
					model.setCntrStatus(cntrStatus[i]);
				if (cntrNbr[i] != null)
					model.setCntrNbr(cntrNbr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoTmpUnit[i] != null)
					model.setCgoTmpUnit(cgoTmpUnit[i]);
				if (cntrTWgtUnit[i] != null)
					model.setCntrTWgtUnit(cntrTWgtUnit[i]);
				if (cntrGWgtUnit[i] != null)
					model.setCntrGWgtUnit(cntrGWgtUnit[i]);
				if (cntrTWgt[i] != null)
					model.setCntrTWgt(cntrTWgt[i]);
				if (cntrGWgt[i] != null)
					model.setCntrGWgt(cntrGWgt[i]);
				if (cntrTmp[i] != null)
					model.setCntrTmp(cntrTmp[i]);
				if (cntrFmInd[i] != null)
					model.setCntrFmInd(cntrFmInd[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVietnamManifestListCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VietnamManifestListCntrInfoVO[]
	 */
	public VietnamManifestListCntrInfoVO[] getVietnamManifestListCntrInfoVOs(){
		VietnamManifestListCntrInfoVO[] vos = (VietnamManifestListCntrInfoVO[])models.toArray(new VietnamManifestListCntrInfoVO[models.size()]);
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
		this.cntrStatus = this.cntrStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNbr = this.cntrNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTmpUnit = this.cgoTmpUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTWgtUnit = this.cntrTWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGWgtUnit = this.cntrGWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTWgt = this.cntrTWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGWgt = this.cntrGWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTmp = this.cntrTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFmInd = this.cntrFmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
