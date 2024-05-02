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
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
		this. updateRatioDetailVOs  = updateRatioDetailVOs;
	}

	public void setMovementEDIReportVOS(MovementEDIReportVO [] movementEDIReportVOs){
		this. movementEDIReportVOs = movementEDIReportVOs;
	}

	public MovementEDIReportVO  getMovementEDIReportVO (){
		return movementEDIReportVO ;
	}

	public UpdateRatioDetailVO  getUpdateRatioDetailVO (){
		return updateRatioDetailVO ;
	}

	public UpdateRatioDetailVO[]  getUpdateRatioDetailVOS (){
		return updateRatioDetailVOs ;
	}

	public MovementEDIReportVO [] getMovementEDIReportVOS(){
		return movementEDIReportVOs;
	}

}