/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DominicanManifestContainerVO.java
*@FileTitle : DominicanManifestContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DominicanManifestContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DominicanManifestContainerVO> models = new ArrayList<DominicanManifestContainerVO>();
	
	/* Column Info */
	private String netWeight = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String containerType = null;
	/* Column Info */
	private String containerNo = null;
	/* Column Info */
	private String sealNo2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sealNo1 = null;
	/* Column Info */
	private String placaNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String grossWeight = null;
	/* Column Info */
	private String packageCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DominicanManifestContainerVO() {}

	public DominicanManifestContainerVO(String ibflag, String pagerows, String blNo, String containerNo, String placaNo, String containerType, String packageCode, String amount, String grossWeight, String netWeight, String sealNo1, String sealNo2) {
		this.netWeight = netWeight;
		this.amount = amount;
		this.containerType = containerType;
		this.containerNo = containerNo;
		this.sealNo2 = sealNo2;
		this.ibflag = ibflag;
		this.sealNo1 = sealNo1;
		this.placaNo = placaNo;
		this.blNo = blNo;
		this.grossWeight = grossWeight;
		this.packageCode = packageCode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("net_weight", getNetWeight());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("container_type", getContainerType());
		this.hashColumns.put("container_no", getContainerNo());
		this.hashColumns.put("seal_no2", getSealNo2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seal_no1", getSealNo1());
		this.hashColumns.put("placa_no", getPlacaNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("gross_weight", getGrossWeight());
		this.hashColumns.put("package_code", getPackageCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("net_weight", "netWeight");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("container_type", "containerType");
		this.hashFields.put("container_no", "containerNo");
		this.hashFields.put("seal_no2", "sealNo2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seal_no1", "sealNo1");
		this.hashFields.put("placa_no", "placaNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("gross_weight", "grossWeight");
		this.hashFields.put("package_code", "packageCode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return netWeight
	 */
	public String getNetWeight() {
		return this.netWeight;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return containerType
	 */
	public String getContainerType() {
		return this.containerType;
	}
	
	/**
	 * Column Info
	 * @return containerNo
	 */
	public String getContainerNo() {
		return this.containerNo;
	}
	
	/**
	 * Column Info
	 * @return sealNo2
	 */
	public String getSealNo2() {
		return this.sealNo2;
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
	 * @return sealNo1
	 */
	public String getSealNo1() {
		return this.sealNo1;
	}
	
	/**
	 * Column Info
	 * @return placaNo
	 */
	public String getPlacaNo() {
		return this.placaNo;
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
	 * @return grossWeight
	 */
	public String getGrossWeight() {
		return this.grossWeight;
	}
	
	/**
	 * Column Info
	 * @return packageCode
	 */
	public String getPackageCode() {
		return this.packageCode;
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
	 * @param netWeight
	 */
	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}
	
	/**
	 * Column Info
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param containerType
	 */
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	
	/**
	 * Column Info
	 * @param containerNo
	 */
	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}
	
	/**
	 * Column Info
	 * @param sealNo2
	 */
	public void setSealNo2(String sealNo2) {
		this.sealNo2 = sealNo2;
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
	 * @param sealNo1
	 */
	public void setSealNo1(String sealNo1) {
		this.sealNo1 = sealNo1;
	}
	
	/**
	 * Column Info
	 * @param placaNo
	 */
	public void setPlacaNo(String placaNo) {
		this.placaNo = placaNo;
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
	 * @param grossWeight
	 */
	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}
	
	/**
	 * Column Info
	 * @param packageCode
	 */
	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
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
		setNetWeight(JSPUtil.getParameter(request, prefix + "net_weight", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setContainerType(JSPUtil.getParameter(request, prefix + "container_type", ""));
		setContainerNo(JSPUtil.getParameter(request, prefix + "container_no", ""));
		setSealNo2(JSPUtil.getParameter(request, prefix + "seal_no2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSealNo1(JSPUtil.getParameter(request, prefix + "seal_no1", ""));
		setPlacaNo(JSPUtil.getParameter(request, prefix + "placa_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setGrossWeight(JSPUtil.getParameter(request, prefix + "gross_weight", ""));
		setPackageCode(JSPUtil.getParameter(request, prefix + "package_code", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DominicanManifestContainerVO[]
	 */
	public DominicanManifestContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DominicanManifestContainerVO[]
	 */
	public DominicanManifestContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DominicanManifestContainerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] netWeight = (JSPUtil.getParameter(request, prefix	+ "net_weight", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] containerType = (JSPUtil.getParameter(request, prefix	+ "container_type", length));
			String[] containerNo = (JSPUtil.getParameter(request, prefix	+ "container_no", length));
			String[] sealNo2 = (JSPUtil.getParameter(request, prefix	+ "seal_no2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sealNo1 = (JSPUtil.getParameter(request, prefix	+ "seal_no1", length));
			String[] placaNo = (JSPUtil.getParameter(request, prefix	+ "placa_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] grossWeight = (JSPUtil.getParameter(request, prefix	+ "gross_weight", length));
			String[] packageCode = (JSPUtil.getParameter(request, prefix	+ "package_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DominicanManifestContainerVO();
				if (netWeight[i] != null)
					model.setNetWeight(netWeight[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (containerType[i] != null)
					model.setContainerType(containerType[i]);
				if (containerNo[i] != null)
					model.setContainerNo(containerNo[i]);
				if (sealNo2[i] != null)
					model.setSealNo2(sealNo2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sealNo1[i] != null)
					model.setSealNo1(sealNo1[i]);
				if (placaNo[i] != null)
					model.setPlacaNo(placaNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (grossWeight[i] != null)
					model.setGrossWeight(grossWeight[i]);
				if (packageCode[i] != null)
					model.setPackageCode(packageCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDominicanManifestContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DominicanManifestContainerVO[]
	 */
	public DominicanManifestContainerVO[] getDominicanManifestContainerVOs(){
		DominicanManifestContainerVO[] vos = (DominicanManifestContainerVO[])models.toArray(new DominicanManifestContainerVO[models.size()]);
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
		this.netWeight = this.netWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.containerType = this.containerType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.containerNo = this.containerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo2 = this.sealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo1 = this.sealNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.placaNo = this.placaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossWeight = this.grossWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packageCode = this.packageCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
