/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiMnr0003Event.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrEqLocCdVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DamageLocationCodeListINVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * UI_MNR_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_MNR_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author park myoung sin 
 * @see EES_MNR_0003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DamageLocationCodeListINVO damageLocationCodeListINVO = null;  
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrEqLocCdVO[] customMnrEqLocCdVOs = null;
		 
	public EesMnr0003Event(){}   
     
	public void setCustomMnrEqLocCdVOS(CustomMnrEqLocCdVO[] customMnrEqLocCdVOs){
		if(customMnrEqLocCdVOs != null){
			CustomMnrEqLocCdVO[] tmpVOs = java.util.Arrays.copyOf(customMnrEqLocCdVOs, customMnrEqLocCdVOs.length);
			this.customMnrEqLocCdVOs = tmpVOs;
		}
	} 

	public DamageLocationCodeListINVO getDamageLocationCodeListINVO() {
		return damageLocationCodeListINVO;      
	} 

	public void setDamageLocationCodeListINVO(DamageLocationCodeListINVO damageLocationCodeListINVO) {
		this.damageLocationCodeListINVO = damageLocationCodeListINVO;
	}  

	public CustomMnrEqLocCdVO[] getCustomMnrEqLocCdVOS(){ 
		CustomMnrEqLocCdVO[] rtnVOs = null;
		if (this.customMnrEqLocCdVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrEqLocCdVOs, customMnrEqLocCdVOs.length);
		}
		return rtnVOs;
	}

}