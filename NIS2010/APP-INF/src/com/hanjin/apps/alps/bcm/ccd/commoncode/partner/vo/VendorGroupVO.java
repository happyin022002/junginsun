/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VendorGroupVO.java
*@FileTitle : VendorGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.06
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.03.06  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VendorGroupVO {

	//private static final long serialVersionUID = 1L;
	
	//private Collection<VendorGroupVO> models = new ArrayList<VendorGroupVO>();
	
	private VendorVO vendorVO = null ;
	
	private VendorContactVO vendorContactVO = null ;
	
	private VendorContactVO[] vendorContactVOs = null ;
	
	private VendorContactVO[] vendorPhnContactVOs = null ;
	
	private VendorContactVO[] vendorEmailContactVOs = null ;
	
	private List<VendorContactVO> vendorContactVOS = null ;
	
	private List<VendorContactVO> vendorPhnContactVOS = null ;
	
	private List<VendorContactVO> vendorEmailContactVOS = null ;
	
	private VendorClassificationVO vendorClassificationVO = null ;
	
	private VendorClassificationVO[] vendorClassificationVOs = null ;
	
	private List<VendorClassificationVO> VendorClassificationVOS = null ;

	public VendorContactVO[] getVendorPhnContactVOs() {
		return vendorPhnContactVOs;
	}

	public void setVendorPhnContactVOs(VendorContactVO[] vendorPhnContactVOs) {
		this.vendorPhnContactVOs = vendorPhnContactVOs;
	}

	public VendorContactVO[] getVendorEmailContactVOs() {
		return vendorEmailContactVOs;
	}

	public void setVendorEmailContactVOs(VendorContactVO[] vendorEmailContactVOs) {
		this.vendorEmailContactVOs = vendorEmailContactVOs;
	}
	
	public List<VendorContactVO> getVendorPhnContactVOS() {
		return vendorPhnContactVOS;
	}

	public void setVendorPhnContactVOS(List<VendorContactVO> vendorPhnContactVOS) {
		this.vendorPhnContactVOS = vendorPhnContactVOS;
	}

	public List<VendorContactVO> getVendorEmailContactVOS() {
		return vendorEmailContactVOS;
	}

	public void setVendorEmailContactVOS(List<VendorContactVO> vendorEmailContactVOS) {
		this.vendorEmailContactVOS = vendorEmailContactVOS;
	}
	
	public List<VendorContactVO> getVendorContactVOS() {
		return vendorContactVOS;
	}

	public void setVendorContactVOS(List<VendorContactVO> vendorContactVOS) {
		this.vendorContactVOS = vendorContactVOS;
	}

	public List<VendorClassificationVO> getVendorClassificationVOS() {
		return VendorClassificationVOS;
	}

	public void setVendorClassificationVOS(
			List<VendorClassificationVO> vendorClassificationVOS) {
		VendorClassificationVOS = vendorClassificationVOS;
	}

	public VendorVO getVendorVO() {
		return vendorVO;
	}

	public void setVendorVO(VendorVO vendorVO) {
		this.vendorVO = vendorVO;
	}

	public VendorContactVO getVendorContactVO() {
		return vendorContactVO;
	}

	public void setVendorContactVO(VendorContactVO vendorContactVO) {
		this.vendorContactVO = vendorContactVO;
	}

	public VendorContactVO[] getVendorContactVOs() {
		//return vendorContactVOs;
		if(vendorContactVOs != null) {
			return vendorContactVOs;
		}else if(vendorContactVOS != null && vendorContactVOS.size() > 0) {
			return vendorContactVOS.toArray(new VendorContactVO[vendorContactVOS.size()]);
		}else{
			return null;
		}
	}

	public void setVendorContactVOs(VendorContactVO[] vendorContactVOs) {
		this.vendorContactVOs = vendorContactVOs;
	}

	public VendorClassificationVO getVendorClassificationVO() {
		return vendorClassificationVO;
	}

	public void setVendorClassificationVO(
			VendorClassificationVO vendorClassificationVO) {
		this.vendorClassificationVO = vendorClassificationVO;
	}

	public VendorClassificationVO[] getVendorClassificationVOs() {
		return vendorClassificationVOs;
	}

	public void setVendorClassificationVOs(
			VendorClassificationVO[] vendorClassificationVOs) {
		this.vendorClassificationVOs = vendorClassificationVOs;
	}
	
}