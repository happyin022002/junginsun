/*=========================================================
 *	Copyright(c) 2006 CyberLogitec
 *	@FileName 			: COM_ENS_0C1Event.java
 *	@FileTitle 			: ServiceProvider정보조회(공통 Popup)
 *	Open Issues 		:
 *	Change history 		:
 *	@LastModifyDate 	: 2006-08-18
 *	@LastModifier 		: sungseok, choi
 *	@LastVersion 		: 1.0
 *	2006-08-07 sungseok, choi
 *	1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.event;

import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * COM_ENS_0C1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * COM_ENS_0C1HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author sungseok, choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0026Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private ServiceProviderVO serviceProviderVO = null;
	private String ofccd = "";

	/**
	 * 
	 * @return
	 */
	public String getOfccd() {
		return ofccd;
	}

	/**
	 * 
	 * @param ofccd
	 */
	public void setOfccd(String ofccd) {
		this.ofccd = ofccd;
	}

	/**
	 * 
	 * @return
	 */
	public ServiceProviderVO getServiceProviderVO() {
		return serviceProviderVO;
	}

	/**
	 * 
	 * @param serviceProviderVO
	 */
	public void setServiceProviderVO(ServiceProviderVO serviceProviderVO) {
		this.serviceProviderVO = serviceProviderVO;
	}

}