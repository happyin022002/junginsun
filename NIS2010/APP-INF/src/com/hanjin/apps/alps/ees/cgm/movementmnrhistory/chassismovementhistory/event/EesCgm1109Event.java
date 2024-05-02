/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EesCgm1109Event.java
*@FileTitle : Chassis Movement Update by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.11 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.event;

 
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSmgstChkINVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1109HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MVMTHistoryListVO mVMTHistoryListVO = null;
	
	/**
	 * @return the cHSmgstChkINVO
	 */
	public CHSmgstChkINVO getCHSmgstChkINVO() {
		return cHSmgstChkINVO;
	}

	/**
	 * @param smgstChkINVO the cHSmgstChkINVO to set
	 */
	public void setCHSmgstChkINVO(CHSmgstChkINVO smgstChkINVO) {
		cHSmgstChkINVO = smgstChkINVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSmgstChkINVO cHSmgstChkINVO = null;

	/** Table Value Object Multi Data 처리 */
	private MVMTHistoryListVO[] mVMTHistoryListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MVMTBookingInfoVO ctmMovementVO = null;

	/** Table Value Object Multi Data 처리 */
	private MVMTBookingInfoVO[] ctmMovementVOs = null;

	/** Table Value Object Multi Data 처리 */
	private CusCtmMovementVO[] cusCtmMovementVOs = null;
	public EesCgm1109Event(){}

	public void setMVMTHistoryListVO(MVMTHistoryListVO mVMTHistoryListVO){
		this. mVMTHistoryListVO = mVMTHistoryListVO;
	}

	public void setMVMTHistoryListVOS(MVMTHistoryListVO[] mVMTHistoryListVOs){
		this. mVMTHistoryListVOs = mVMTHistoryListVOs;
	}

	public void setCtmMovementVO(MVMTBookingInfoVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(MVMTBookingInfoVO[] ctmMovementVOs){
		this. ctmMovementVOs = ctmMovementVOs;
	}

	public void setCusCtmMovementVOS(CusCtmMovementVO[] cusCtmMovementVOs){
		this. cusCtmMovementVOs = cusCtmMovementVOs;
	}

	public MVMTHistoryListVO getMVMTHistoryListVO(){
		return mVMTHistoryListVO;
	}

	public MVMTHistoryListVO[] getMVMTHistoryListVOS(){
		return mVMTHistoryListVOs;
	}

	public MVMTBookingInfoVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public MVMTBookingInfoVO[] getCtmMovementVOS(){
		return ctmMovementVOs;
	}

	public CusCtmMovementVO[] getCusCtmMovementVOS(){
		return cusCtmMovementVOs;
	}

}