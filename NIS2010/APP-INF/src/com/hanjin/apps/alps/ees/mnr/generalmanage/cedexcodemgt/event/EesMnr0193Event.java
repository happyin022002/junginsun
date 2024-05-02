/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0193Event.java
*@FileTitle : EQ Component POP UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrEqLocCdVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.DamageLocationCodeListINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * EES_MNR_013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MNR_0193HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author park myoung sin 
 * @see EES_MNR_0193HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0193Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DamageLocationCodeListINVO damageLocationCodeListINVO = null;  
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrEqLocCdVO[] customMnrEqLocCdVOs = null;
	
	public EesMnr0193Event(){}    
	
	public void setCustomMnrEqLocCdVOS(CustomMnrEqLocCdVO[] customMnrEqLocCdVOs){
		this.customMnrEqLocCdVOs = customMnrEqLocCdVOs; 
	} 

	public DamageLocationCodeListINVO getDamageLocationCodeListINVO() {
		return damageLocationCodeListINVO;      
	} 

	public void setDamageLocationCodeListINVO(DamageLocationCodeListINVO damageLocationCodeListINVO) {
		this.damageLocationCodeListINVO = damageLocationCodeListINVO;
	}  

	public CustomMnrEqLocCdVO[] getCustomMnrEqLocCdVOS(){ 
		return customMnrEqLocCdVOs; 
	}

}