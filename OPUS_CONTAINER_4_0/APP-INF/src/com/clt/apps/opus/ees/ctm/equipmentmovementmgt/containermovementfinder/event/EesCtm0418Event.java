/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0418Event.java
*@FileTitle : MVMT Timely Update Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.27 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0418 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0418HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0418HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0418Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MovementEDIReportVO  movementEDIReportVO  = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UpdateRatioDetailVO  updateRatioDetailVO  = null;
		
	/** Table Value Object Multi Data 처리 */
	private MovementEDIReportVO [] movementEDIReportVOs = null;
	/** Table Value Object Multi Data 처리 */
	private UpdateRatioDetailVO [] updateRatioDetailVOs = null;

	public EesCtm0418Event(){}
	
	public void setMovementEDIReportVO (MovementEDIReportVO  movementEDIReportVO ){
		this. movementEDIReportVO  = movementEDIReportVO ;
	}

	public void setUpdateRatioDetailVO (UpdateRatioDetailVO  updateRatioDetailVO ){
		this. updateRatioDetailVO  = updateRatioDetailVO ;
	}

	public void setUpdateRatioDetailVOS (UpdateRatioDetailVO[]  updateRatioDetailVOs ){
		if (updateRatioDetailVOs != null) {
			UpdateRatioDetailVO[] tmpVOs = new UpdateRatioDetailVO[updateRatioDetailVOs.length];
			System.arraycopy(updateRatioDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.updateRatioDetailVOs = tmpVOs;
		}
	}

	public void setMovementEDIReportVOS(MovementEDIReportVO [] movementEDIReportVOs){
		if (movementEDIReportVOs != null) {
			MovementEDIReportVO[] tmpVOs = new MovementEDIReportVO[movementEDIReportVOs.length];
			System.arraycopy(movementEDIReportVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.movementEDIReportVOs = tmpVOs;
		}
	}

	public MovementEDIReportVO  getMovementEDIReportVO (){
		return movementEDIReportVO ;
	}

	public UpdateRatioDetailVO  getUpdateRatioDetailVO (){
		return updateRatioDetailVO ;
	}

	public UpdateRatioDetailVO[]  getUpdateRatioDetailVOS (){
		UpdateRatioDetailVO[] tmpVOs = null;
		if (this.updateRatioDetailVOs != null) {
			tmpVOs = new UpdateRatioDetailVO[updateRatioDetailVOs.length];
			System.arraycopy(updateRatioDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public MovementEDIReportVO [] getMovementEDIReportVOS(){
		MovementEDIReportVO[] tmpVOs = null;
		if (this.movementEDIReportVOs != null) {
			tmpVOs = new MovementEDIReportVO[movementEDIReportVOs.length];
			System.arraycopy(movementEDIReportVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}