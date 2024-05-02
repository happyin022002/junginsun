/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0004Event.java
*@FileTitle : EQ Damage Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CedexOtherCodeListINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCedexOtrCdVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * EES_MNR_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MNR_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author park myoung sin 
 * @see EES_MNR_0004HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CedexOtherCodeListINVO cedexOtherCodeListINVO = null;  
	 
	/** Table Value Object Multi Data 처리 */
	private CustomMnrCedexOtrCdVO[] customMnrCedexOtrCdVOS = null;
 		  
	public EesMnr0004Event(){}
 
	public CedexOtherCodeListINVO getCedexOtherCodeListINVO() {
		return cedexOtherCodeListINVO;
	}

	public void setCedexOtherCodeListINVO(
			CedexOtherCodeListINVO cedexOtherCodeListINVO) {
		this.cedexOtherCodeListINVO = cedexOtherCodeListINVO;
	}

	public CustomMnrCedexOtrCdVO[] getCustomMnrCedexOtrCdVOS() {
		return customMnrCedexOtrCdVOS;
	}

	public void setCustomMnrCedexOtrCdVOS(
			CustomMnrCedexOtrCdVO[] customMnrCedexOtrCdVOS) {
		this.customMnrCedexOtrCdVOS = customMnrCedexOtrCdVOS;
	}     

}