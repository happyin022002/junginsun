/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaSearchCntrInfoVO.java
*@FileTitle : ManilaSearchCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

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

public class ManilaSearchCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManilaSearchCntrInfoVO> models = new ArrayList<ManilaSearchCntrInfoVO>();
	
	/* Column Info */
	private String cntrRealNo = null;
	/* Column Info */
	private String containerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String typeSize = null;
	/* Column Info */
	private String deliveryType = null;
	/* Column Info */
	private String regNumber3 = null;
	/* Column Info */
	private String blNo2 = null;
	/* Column Info */
	private String seq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManilaSearchCntrInfoVO() {}

	public ManilaSearchCntrInfoVO(String ibflag, String pagerows, String regNumber3, String blNo2, String containerNo, String typeSize, String cntrRealNo, String deliveryType, String seq) {
		this.cntrRealNo = cntrRealNo;
		this.containerNo = containerNo;
		this.ibflag = ibflag;
		this.typeSize = typeSize;
		this.deliveryType = deliveryType;
		this.regNumber3 = regNumber3;
		this.blNo2 = blNo2;
		this.seq = seq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_real_no", getCntrRealNo());
		this.hashColumns.put("container_no", getContainerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("type_size", getTypeSize());
		this.hashColumns.put("delivery_type", getDeliveryType());
		this.hashColumns.put("reg_number3", getRegNumber3());
		this.hashColumns.put("bl_no2", getBlNo2());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_real_no", "cntrRealNo");
		this.hashFields.put("container_no", "containerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("type_size", "typeSize");
		this.hashFields.put("delivery_type", "deliveryType");
		this.hashFields.put("reg_number3", "regNumber3");
		this.hashFields.put("bl_no2", "blNo2");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrRealNo
	 */
	public String getCntrRealNo() {
		return this.cntrRealNo;
	}
	
	/**
	 * Column Info
	 * @return containerNo
	 */
	public String getContainerNo() {
		return this.containerNo;
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
	 * @return typeSize
	 */
	public String getTypeSize() {
		return this.typeSize;
	}
	
	/**
	 * Column Info
	 * @return deliveryType
	 */
	public String getDeliveryType() {
		return this.deliveryType;
	}
	
	/**
	 * Column Info
	 * @return regNumber3
	 */
	public String getRegNumber3() {
		return this.regNumber3;
	}
	
	/**
	 * Column Info
	 * @return blNo2
	 */
	public String getBlNo2() {
		return this.blNo2;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @param cntrRealNo
	 */
	public void setCntrRealNo(String cntrRealNo) {
		this.cntrRealNo = cntrRealNo;
	}
	
	/**
	 * Column Info
	 * @param containerNo
	 */
	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
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
	 * @param typeSize
	 */
	public void setTypeSize(String typeSize) {
		this.typeSize = typeSize;
	}
	
	/**
	 * Column Info
	 * @param deliveryType
	 */
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	
	/**
	 * Column Info
	 * @param regNumber3
	 */
	public void setRegNumber3(String regNumber3) {
		this.regNumber3 = regNumber3;
	}
	
	/**
	 * Column Info
	 * @param blNo2
	 */
	public void setBlNo2(String blNo2) {
		this.blNo2 = blNo2;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setCntrRealNo(JSPUtil.getParameter(request, "cntr_real_no", ""));
		setContainerNo(JSPUtil.getParameter(request, "container_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTypeSize(JSPUtil.getParameter(request, "type_size", ""));
		setDeliveryType(JSPUtil.getParameter(request, "delivery_type", ""));
		setRegNumber3(JSPUtil.getParameter(request, "reg_number3", ""));
		setBlNo2(JSPUtil.getParameter(request, "bl_no2", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaSearchCntrInfoVO[]
	 */
	public ManilaSearchCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaSearchCntrInfoVO[]
	 */
	public ManilaSearchCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManilaSearchCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrRealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_real_no", length));
			String[] containerNo = (JSPUtil.getParameter(request, prefix	+ "container_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] typeSize = (JSPUtil.getParameter(request, prefix	+ "type_size", length));
			String[] deliveryType = (JSPUtil.getParameter(request, prefix	+ "delivery_type", length));
			String[] regNumber3 = (JSPUtil.getParameter(request, prefix	+ "reg_number3", length));
			String[] blNo2 = (JSPUtil.getParameter(request, prefix	+ "bl_no2", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManilaSearchCntrInfoVO();
				if (cntrRealNo[i] != null)
					model.setCntrRealNo(cntrRealNo[i]);
				if (containerNo[i] != null)
					model.setContainerNo(containerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (typeSize[i] != null)
					model.setTypeSize(typeSize[i]);
				if (deliveryType[i] != null)
					model.setDeliveryType(deliveryType[i]);
				if (regNumber3[i] != null)
					model.setRegNumber3(regNumber3[i]);
				if (blNo2[i] != null)
					model.setBlNo2(blNo2[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManilaSearchCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManilaSearchCntrInfoVO[]
	 */
	public ManilaSearchCntrInfoVO[] getManilaSearchCntrInfoVOs(){
		ManilaSearchCntrInfoVO[] vos = (ManilaSearchCntrInfoVO[])models.toArray(new ManilaSearchCntrInfoVO[models.size()]);
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
		this.cntrRealNo = this.cntrRealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.containerNo = this.containerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeSize = this.typeSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliveryType = this.deliveryType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regNumber3 = this.regNumber3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo2 = this.blNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
