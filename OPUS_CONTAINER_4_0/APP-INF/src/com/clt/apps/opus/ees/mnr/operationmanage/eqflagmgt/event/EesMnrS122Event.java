/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnrS122Event.java
*@FileTitle : Damage Flagging/Unflagging
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * EES_MNR_0122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author park myoung sin
 * @see EES_MNR_0122HTMLAction 참조
 * @since J2EE 1.4
 */
   
public class EesMnrS122Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQFlagListINVO eQFlagListINVO = null;
	 
	/** Table Value Object Multi Data 처리 */ 
	private CustomMnrEqStsVO[] customMnrEqStsVOs = null;
	
	/** Table Value Object Multi Data 처리 */  
	private CustomMnrFlgHisVO[] customMnrFlgHisVOs = null; 
  
	public CustomMnrFlgHisVO[] getCustomMnrFlgHisVOs() {
		CustomMnrFlgHisVO[] rtnVOs = null;
		if (this.customMnrFlgHisVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrFlgHisVOs, customMnrFlgHisVOs.length);
		}
		return rtnVOs;
	} 

	public void setCustomMnrFlgHisVOs(CustomMnrFlgHisVO[] customMnrFlgHisVOs){
		if(customMnrFlgHisVOs != null){
			CustomMnrFlgHisVO[] tmpVOs = java.util.Arrays.copyOf(customMnrFlgHisVOs, customMnrFlgHisVOs.length);
			this.customMnrFlgHisVOs = tmpVOs;
		}
	}

	public EesMnrS122Event(){} 
	   
	public EQFlagListINVO getEQFlagListINVO() {
		return eQFlagListINVO; 
	} 
	
	public void setEQFlagListINVO(EQFlagListINVO flagListINVO) {
		eQFlagListINVO = flagListINVO;
	}  

	public CustomMnrEqStsVO[] getCustomMnrEqStsVOs() {
		CustomMnrEqStsVO[] rtnVOs = null;
		if (this.customMnrEqStsVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrEqStsVOs, customMnrEqStsVOs.length);
		}
		return rtnVOs;
	}   
	 
	public void setCustomMnrEqStsVOs(CustomMnrEqStsVO[] customMnrEqStsVOs){
		if(customMnrEqStsVOs != null){
			CustomMnrEqStsVO[] tmpVOs = java.util.Arrays.copyOf(customMnrEqStsVOs, customMnrEqStsVOs.length);
			this.customMnrEqStsVOs = tmpVOs;
		}
	}   
}
