/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf2025Event.java
*@FileTitle : CBF Weight Group Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFWgtGroupSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_2025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_2025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_OPF_2025HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf2025Event extends EventSupport {
	

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFWgtGroupSummaryVO cBFWgtGroupSummaryVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private CBFWgtGroupSummaryVO[] cBFWgtGroupSummaryVOs = null;

	
	public VopOpf2025Event(){}
	
	public void setCBFWgtGroupSummaryVO(CBFWgtGroupSummaryVO cBFWgtGroupSummaryVO){
		this. cBFWgtGroupSummaryVO = cBFWgtGroupSummaryVO;
	}
	


	public void setCBFWgtGroupSummaryVOS(CBFWgtGroupSummaryVO[] cBFWgtGroupSummaryVOs){
		if (cBFWgtGroupSummaryVOs != null) {
			CBFWgtGroupSummaryVO[] tmpVOs = new CBFWgtGroupSummaryVO[cBFWgtGroupSummaryVOs.length];
			System.arraycopy(cBFWgtGroupSummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cBFWgtGroupSummaryVOs = tmpVOs;
		}		
	}



	public CBFWgtGroupSummaryVO getCBFWgtGroupSummaryVO(){
		return cBFWgtGroupSummaryVO;
	}


	public CBFWgtGroupSummaryVO[] getCBFWgtGroupSummaryVOS(){
		CBFWgtGroupSummaryVO[] rtnVOs = null;
		
		if (this.cBFWgtGroupSummaryVOs != null) {
			rtnVOs = new CBFWgtGroupSummaryVO[cBFWgtGroupSummaryVOs.length];
			System.arraycopy(cBFWgtGroupSummaryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;	
	}


}