/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamManifestDgGoodsInfoVO.java
*@FileTitle : VietnamManifestDgGoodsInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.27 조원주 
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

public class VietnamManifestDgGoodsInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VietnamManifestDgGoodsInfoVO> models = new ArrayList<VietnamManifestDgGoodsInfoVO>();
	
	/* Column Info */
	private String mfag = null;
	/* Column Info */
	private String flashPoint = null;
	/* Column Info */
	private String undgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tremCardNo = null;
	/* Column Info */
	private String hazardCd = null;
	/* Column Info */
	private String imoClassNo = null;
	/* Column Info */
	private String imoPageNo = null;
	/* Column Info */
	private String emsNo = null;
	/* Column Info */
	private String packingGroup = null;
	/* Column Info */
	private String flashPointUnit = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VietnamManifestDgGoodsInfoVO() {}

	public VietnamManifestDgGoodsInfoVO(String ibflag, String pagerows, String imoClassNo, String imoPageNo, String hazardCd, String undgNo, String flashPoint, String flashPointUnit, String packingGroup, String emsNo, String mfag, String tremCardNo) {
		this.mfag = mfag;
		this.flashPoint = flashPoint;
		this.undgNo = undgNo;
		this.ibflag = ibflag;
		this.tremCardNo = tremCardNo;
		this.hazardCd = hazardCd;
		this.imoClassNo = imoClassNo;
		this.imoPageNo = imoPageNo;
		this.emsNo = emsNo;
		this.packingGroup = packingGroup;
		this.flashPointUnit = flashPointUnit;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mfag", getMfag());
		this.hashColumns.put("flash_point", getFlashPoint());
		this.hashColumns.put("undg_no", getUndgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trem_card_no", getTremCardNo());
		this.hashColumns.put("hazard_cd", getHazardCd());
		this.hashColumns.put("imo_class_no", getImoClassNo());
		this.hashColumns.put("imo_page_no", getImoPageNo());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("packing_group", getPackingGroup());
		this.hashColumns.put("flash_point_unit", getFlashPointUnit());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mfag", "mfag");
		this.hashFields.put("flash_point", "flashPoint");
		this.hashFields.put("undg_no", "undgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trem_card_no", "tremCardNo");
		this.hashFields.put("hazard_cd", "hazardCd");
		this.hashFields.put("imo_class_no", "imoClassNo");
		this.hashFields.put("imo_page_no", "imoPageNo");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("packing_group", "packingGroup");
		this.hashFields.put("flash_point_unit", "flashPointUnit");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mfag
	 */
	public String getMfag() {
		return this.mfag;
	}
	
	/**
	 * Column Info
	 * @return flashPoint
	 */
	public String getFlashPoint() {
		return this.flashPoint;
	}
	
	/**
	 * Column Info
	 * @return undgNo
	 */
	public String getUndgNo() {
		return this.undgNo;
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
	 * @return tremCardNo
	 */
	public String getTremCardNo() {
		return this.tremCardNo;
	}
	
	/**
	 * Column Info
	 * @return hazardCd
	 */
	public String getHazardCd() {
		return this.hazardCd;
	}
	
	/**
	 * Column Info
	 * @return imoClassNo
	 */
	public String getImoClassNo() {
		return this.imoClassNo;
	}
	
	/**
	 * Column Info
	 * @return imoPageNo
	 */
	public String getImoPageNo() {
		return this.imoPageNo;
	}
	
	/**
	 * Column Info
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
	}
	
	/**
	 * Column Info
	 * @return packingGroup
	 */
	public String getPackingGroup() {
		return this.packingGroup;
	}
	
	/**
	 * Column Info
	 * @return flashPointUnit
	 */
	public String getFlashPointUnit() {
		return this.flashPointUnit;
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
	 * @param mfag
	 */
	public void setMfag(String mfag) {
		this.mfag = mfag;
	}
	
	/**
	 * Column Info
	 * @param flashPoint
	 */
	public void setFlashPoint(String flashPoint) {
		this.flashPoint = flashPoint;
	}
	
	/**
	 * Column Info
	 * @param undgNo
	 */
	public void setUndgNo(String undgNo) {
		this.undgNo = undgNo;
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
	 * @param tremCardNo
	 */
	public void setTremCardNo(String tremCardNo) {
		this.tremCardNo = tremCardNo;
	}
	
	/**
	 * Column Info
	 * @param hazardCd
	 */
	public void setHazardCd(String hazardCd) {
		this.hazardCd = hazardCd;
	}
	
	/**
	 * Column Info
	 * @param imoClassNo
	 */
	public void setImoClassNo(String imoClassNo) {
		this.imoClassNo = imoClassNo;
	}
	
	/**
	 * Column Info
	 * @param imoPageNo
	 */
	public void setImoPageNo(String imoPageNo) {
		this.imoPageNo = imoPageNo;
	}
	
	/**
	 * Column Info
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
	}
	
	/**
	 * Column Info
	 * @param packingGroup
	 */
	public void setPackingGroup(String packingGroup) {
		this.packingGroup = packingGroup;
	}
	
	/**
	 * Column Info
	 * @param flashPointUnit
	 */
	public void setFlashPointUnit(String flashPointUnit) {
		this.flashPointUnit = flashPointUnit;
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
		setMfag(JSPUtil.getParameter(request, prefix + "mfag", ""));
		setFlashPoint(JSPUtil.getParameter(request, prefix + "flash_point", ""));
		setUndgNo(JSPUtil.getParameter(request, prefix + "undg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTremCardNo(JSPUtil.getParameter(request, prefix + "trem_card_no", ""));
		setHazardCd(JSPUtil.getParameter(request, prefix + "hazard_cd", ""));
		setImoClassNo(JSPUtil.getParameter(request, prefix + "imo_class_no", ""));
		setImoPageNo(JSPUtil.getParameter(request, prefix + "imo_page_no", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setPackingGroup(JSPUtil.getParameter(request, prefix + "packing_group", ""));
		setFlashPointUnit(JSPUtil.getParameter(request, prefix + "flash_point_unit", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VietnamManifestDgGoodsInfoVO[]
	 */
	public VietnamManifestDgGoodsInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VietnamManifestDgGoodsInfoVO[]
	 */
	public VietnamManifestDgGoodsInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VietnamManifestDgGoodsInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mfag = (JSPUtil.getParameter(request, prefix	+ "mfag", length));
			String[] flashPoint = (JSPUtil.getParameter(request, prefix	+ "flash_point", length));
			String[] undgNo = (JSPUtil.getParameter(request, prefix	+ "undg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tremCardNo = (JSPUtil.getParameter(request, prefix	+ "trem_card_no", length));
			String[] hazardCd = (JSPUtil.getParameter(request, prefix	+ "hazard_cd", length));
			String[] imoClassNo = (JSPUtil.getParameter(request, prefix	+ "imo_class_no", length));
			String[] imoPageNo = (JSPUtil.getParameter(request, prefix	+ "imo_page_no", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] packingGroup = (JSPUtil.getParameter(request, prefix	+ "packing_group", length));
			String[] flashPointUnit = (JSPUtil.getParameter(request, prefix	+ "flash_point_unit", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VietnamManifestDgGoodsInfoVO();
				if (mfag[i] != null)
					model.setMfag(mfag[i]);
				if (flashPoint[i] != null)
					model.setFlashPoint(flashPoint[i]);
				if (undgNo[i] != null)
					model.setUndgNo(undgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tremCardNo[i] != null)
					model.setTremCardNo(tremCardNo[i]);
				if (hazardCd[i] != null)
					model.setHazardCd(hazardCd[i]);
				if (imoClassNo[i] != null)
					model.setImoClassNo(imoClassNo[i]);
				if (imoPageNo[i] != null)
					model.setImoPageNo(imoPageNo[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (packingGroup[i] != null)
					model.setPackingGroup(packingGroup[i]);
				if (flashPointUnit[i] != null)
					model.setFlashPointUnit(flashPointUnit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVietnamManifestDgGoodsInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VietnamManifestDgGoodsInfoVO[]
	 */
	public VietnamManifestDgGoodsInfoVO[] getVietnamManifestDgGoodsInfoVOs(){
		VietnamManifestDgGoodsInfoVO[] vos = (VietnamManifestDgGoodsInfoVO[])models.toArray(new VietnamManifestDgGoodsInfoVO[models.size()]);
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
		this.mfag = this.mfag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flashPoint = this.flashPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.undgNo = this.undgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tremCardNo = this.tremCardNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazardCd = this.hazardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoClassNo = this.imoClassNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoPageNo = this.imoPageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packingGroup = this.packingGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flashPointUnit = this.flashPointUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
