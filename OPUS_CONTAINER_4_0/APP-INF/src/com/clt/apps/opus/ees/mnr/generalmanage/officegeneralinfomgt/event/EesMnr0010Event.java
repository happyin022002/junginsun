/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0217Event.java
*@FileTitle : M&R Colleague Tree
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chung young hun
 * @see EES_MNR_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0010HTMLAction에서 사용하는 container vo를 선언
	 */
	private OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO ;
	


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * EES_MNR_0010HTMLAction에서 사용하는 container vo를 get메소드
	 */

	public OfficeGeneralInfoListGRPVO getOfficeGeneralInfoListGRPVO() {
		return officeGeneralInfoListGRPVO;
	}

	/**
	 * EES_MNR_0010HTMLAction에서 사용하는 container vo를 set메소드
	 */
	
	public void setOfficeGeneralInfoListGRPVO(
			OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO) {
		this.officeGeneralInfoListGRPVO = officeGeneralInfoListGRPVO;
	}






	
	

}