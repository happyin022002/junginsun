/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0189Event.java
*@FileTitle : M&R Service Provider Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 정영훈 
*@LastVersion : 1.0
* 2009.06.12 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.event;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ServiceProviderInfoListGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * EES_MNR_0189 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0189HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chung young hun
 * @see EES_MNR_0189HTMLAction 참조
 * @since J2EE 1.6
 */


public class EesMnr0189Event extends EventSupport {

   private static final long serialVersionUID = 1L;
   /** Table Value Object 조회 조건 */
	//EES_MNR_0189HTMLAction에서 사용하는  container VO 를 정의한다.
	private ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO = null;

	/**
	 * EES_MNR_0189HTMLAction에서 사용하는 container VO 의 get메소드이다.
	 */
	public ServiceProviderInfoListGRPVO getServiceProviderInfoListGRPVO() {
		return serviceProviderInfoListGRPVO;
	}

	/**
	 * EES_MNR_0189HTMLAction에서 사용하는 container VO 의 set메소드이다.
	 */
	public void setServiceProviderInfoListGRPVO(
			ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO) {
		this.serviceProviderInfoListGRPVO = serviceProviderInfoListGRPVO;
	}

    // class용 serial no 반환
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    


}
