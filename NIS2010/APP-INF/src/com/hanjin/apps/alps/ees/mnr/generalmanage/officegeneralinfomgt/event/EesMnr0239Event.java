/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0239Event.java
*@FileTitle : Offece Control Info
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.02.10 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0239 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0239HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chung young hun
 * @see EES_MNR_0239HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0239Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0239HTMLAction에서 사용하는 container vo를 선언
	 */
	private OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO ;
	


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * EES_MNR_0239HTMLAction에서 사용하는 container vo를 get메소드
	 */

	public OfficeGeneralInfoListGRPVO getOfficeGeneralInfoListGRPVO() {
		return officeGeneralInfoListGRPVO;
	}

	/**
	 * EES_MNR_0239HTMLAction에서 사용하는 container vo를 set메소드
	 */

	public void setOfficeGeneralInfoListGRPVO(
			OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO) {
		this.officeGeneralInfoListGRPVO = officeGeneralInfoListGRPVO;
	}






	
	

}