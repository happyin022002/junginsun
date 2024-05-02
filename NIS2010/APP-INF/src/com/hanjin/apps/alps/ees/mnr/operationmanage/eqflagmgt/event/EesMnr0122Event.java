/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0122Event.java
*@FileTitle : Damage Flagging/Unflagging
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * EES_MNR_0122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author park myoung sin
 * @see EES_MNR_0122HTMLAction 참조
 * @since J2EE 1.4
 */
   
public class EesMnr0122Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQFlagListINVO eQFlagListINVO = null;
	 
	/** Table Value Object Multi Data 처리 */ 
	private CustomMnrEqStsVO[] customMnrEqStsVOs = null;
	
	/** Table Value Object Multi Data 처리 */  
	private CustomMnrFlgHisVO[] customMnrFlgHisVOs = null; 
  
	public CustomMnrFlgHisVO[] getCustomMnrFlgHisVOs() {
		return customMnrFlgHisVOs;  
	} 

	public void setCustomMnrFlgHisVOs(CustomMnrFlgHisVO[] customMnrFlgHisVOs) {
		this.customMnrFlgHisVOs = customMnrFlgHisVOs;
	}

	public EesMnr0122Event(){} 
	   
	public EQFlagListINVO getEQFlagListINVO() {
		return eQFlagListINVO; 
	}

	public void setEQFlagListINVO(EQFlagListINVO flagListINVO) {
		eQFlagListINVO = flagListINVO;
	}  

	public CustomMnrEqStsVO[] getCustomMnrEqStsVOs() {
		return customMnrEqStsVOs;
	}   
	 
	public void setCustomMnrEqStsVOs(CustomMnrEqStsVO[] customMnrEqStsVOs) {
		this.customMnrEqStsVOs = customMnrEqStsVOs;
	}   
}
