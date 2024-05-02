/**
 * 
 */
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

import java.util.List;


/**
 * @author zero
 *
 */
public class ServiceProviderInfoListGRPVO {

	private ServiceProviderInfoListINVO serviceProviderInfoListINVO;
	private CustomMdmVendorVO customMdmVendorVO ;
	private List<CustomMdmVendorVO>  customMdmVendorVOS;
	
	
	public ServiceProviderInfoListINVO getServiceProviderInfoListINVO() {
		return serviceProviderInfoListINVO;
	}
	public void setServiceProviderInfoListINVO(
			ServiceProviderInfoListINVO serviceProviderInfoListINVO) {
		this.serviceProviderInfoListINVO = serviceProviderInfoListINVO;
	}
	public CustomMdmVendorVO getCustomMdmVendorVO() {
		return customMdmVendorVO;
	}
	public void setCustomMdmVendorVO(CustomMdmVendorVO customMdmVendorVO) {
		this.customMdmVendorVO = customMdmVendorVO;
	}
	public List<CustomMdmVendorVO> getCustomMdmVendorVOS() {
		return customMdmVendorVOS;
	}
	public void setCustomMdmVendorVOS(List<CustomMdmVendorVO> customMdmVendorVOS) {
		this.customMdmVendorVOS = customMdmVendorVOS;
	}
	
	
	
}
