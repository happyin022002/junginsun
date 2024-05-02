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
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0135 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chung young hun
 * @see EES_MNR_0135HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0135Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO ;
	


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public OfficeGeneralInfoListGRPVO getOfficeGeneralInfoListGRPVO() {
		return officeGeneralInfoListGRPVO;
	}



	public void setOfficeGeneralInfoListGRPVO(
			OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO) {
		this.officeGeneralInfoListGRPVO = officeGeneralInfoListGRPVO;
	}






	
	

}