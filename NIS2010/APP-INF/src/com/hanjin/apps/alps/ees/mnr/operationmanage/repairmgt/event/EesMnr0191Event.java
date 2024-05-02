/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0191Event.java
*@FileTitle : Repair History_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2009.06.03 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomEQWorkOrderHistoryListVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EQWorkOrderHistoryListINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
         
/** 
 * ESS_MNR_0191 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0191HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신 
 * @see EES_MNR_0191HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0191Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	      
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EQWorkOrderHistoryListINVO eQWorkOrderHistoryListINVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private CustomEQWorkOrderHistoryListVO[] customEQWorkOrderHistoryListVOs = null;
     
	public EesMnr0191Event(){}
    
	public EQWorkOrderHistoryListINVO getEQWorkOrderHistoryListINVO() {
		return eQWorkOrderHistoryListINVO;
	}

	public void setEQWorkOrderHistoryListINVO(
			EQWorkOrderHistoryListINVO workOrderHistoryListINVO) {
		eQWorkOrderHistoryListINVO = workOrderHistoryListINVO;
	}

	public CustomEQWorkOrderHistoryListVO[] getCustomEQWorkOrderHistoryListVOs() {
		return customEQWorkOrderHistoryListVOs;
	}

	public void setCustomEQWorkOrderHistoryListVOs(
			CustomEQWorkOrderHistoryListVO[] customEQWorkOrderHistoryListVOs) {
		this.customEQWorkOrderHistoryListVOs = customEQWorkOrderHistoryListVOs;
	}
}