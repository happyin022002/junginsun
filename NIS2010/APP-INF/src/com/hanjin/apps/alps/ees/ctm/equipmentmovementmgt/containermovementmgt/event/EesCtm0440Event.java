/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0440Event.java
*@FileTitle : VL/VD correction by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.02
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CtmMovementVO;


/**
 * EES_CTM_0440 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0440HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see EES_CTM_0440HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0440Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CorrectionVLVDListVO correctionVLVDList = null;

	/** Table Value Object Multi Data 처리 */
	private CorrectionVLVDListVO[] correctionVLVDLists = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMovementVO ctmMovementVO = null;

	/** Table Value Object Multi Data 처리 */
	private CtmMovementVO[] ctmMovementVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CusCtmMovementVO cusMovementVO = null;

	/** Table Value Object Multi Data 처리 */
	private CusCtmMovementVO[] cusMovementVOs = null;
	
	private MVMTBookingInfoVO mvmtBookingInfoVO = null;

	private MVMTBookingInfoVO[] mvmtBookingInfoVOs = null;
	
	public EesCtm0440Event(){}

	public void setCorrectionVLVDList(CorrectionVLVDListVO correctionVLVDList){
		this. correctionVLVDList = correctionVLVDList;
	}

	public void setCorrectionVLVDListS(CorrectionVLVDListVO[] correctionVLVDLists){
		this. correctionVLVDLists = correctionVLVDLists;
	}

	public void setCtmMovementVO(CtmMovementVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(CtmMovementVO[] ctmMovementVOs){
		this. ctmMovementVOs = ctmMovementVOs;
	}

	public CorrectionVLVDListVO getCorrectionVLVDList(){
		return correctionVLVDList;
	}

	public CorrectionVLVDListVO[] getCorrectionVLVDListS(){
		return correctionVLVDLists;
	}

	public CtmMovementVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public CtmMovementVO[] getCtmMovementVOS(){
		return ctmMovementVOs;
	}

	public CusCtmMovementVO getCusCtmMovementVO(){
		return cusMovementVO;
	}

	public CusCtmMovementVO[] getCusCtmMovementVOS(){
		return cusMovementVOs;
	}

	public MVMTBookingInfoVO getMVMTBookingInfoVO(){
		return mvmtBookingInfoVO;
	}

	public MVMTBookingInfoVO[] getMVMTBookingInfoVOS(){
		return mvmtBookingInfoVOs;
	}

	public void setMVMTBookingInfoVO(MVMTBookingInfoVO vo){
		mvmtBookingInfoVO = vo;
	}

	public void setMVMTBookingInfoVOS(MVMTBookingInfoVO[] vos){
		mvmtBookingInfoVOs = vos;
	}

	public void setCusCtmMovementVO(CusCtmMovementVO vo){
		cusMovementVO = vo;
	}

	public void setCusCtmMovementVOS(CusCtmMovementVO[] vos){
		cusMovementVOs = vos;
	}
}