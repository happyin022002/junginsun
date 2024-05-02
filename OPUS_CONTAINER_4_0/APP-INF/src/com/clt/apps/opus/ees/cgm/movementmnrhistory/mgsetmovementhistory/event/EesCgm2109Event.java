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
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event;

 
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSmgstChkINVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2109HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MVMTHistoryListVO mVMTHistoryListVO = null;
	
	/**
	 * @return the cHSmgstChkINVO
	 */
	public MGSmgstChkINVO getMGSmgstChkINVO() {
		return mGSmgstChkINVO;
	}

	/**
	 * @param smgstChkINVO the cHSmgstChkINVO to set
	 */
	public void setMGSmgstChkINVO(MGSmgstChkINVO smgstChkINVO) {
		mGSmgstChkINVO = smgstChkINVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSmgstChkINVO mGSmgstChkINVO = null;

	/** Table Value Object Multi Data 처리 */
	private MVMTHistoryListVO[] mVMTHistoryListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MVMTBookingInfoVO ctmMovementVO = null;

	/** Table Value Object Multi Data 처리 */
	private MVMTBookingInfoVO[] ctmMovementVOs = null;

	/** Table Value Object Multi Data 처리 */
	private CusCtmMovementVO[] cusCtmMovementVOs = null;
	public EesCgm2109Event(){}

	public void setMVMTHistoryListVO(MVMTHistoryListVO mVMTHistoryListVO){
		this. mVMTHistoryListVO = mVMTHistoryListVO;
	}

	public void setMVMTHistoryListVOS(MVMTHistoryListVO[] mVMTHistoryListVOs){
		if(mVMTHistoryListVOs != null){
			MVMTHistoryListVO[] tmpVOs = java.util.Arrays.copyOf(mVMTHistoryListVOs, mVMTHistoryListVOs.length);
			this.mVMTHistoryListVOs = tmpVOs;
		}
	}

	public void setCtmMovementVO(MVMTBookingInfoVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(MVMTBookingInfoVO[] ctmMovementVOs){
		if(ctmMovementVOs != null){
			MVMTBookingInfoVO[] tmpVOs = java.util.Arrays.copyOf(ctmMovementVOs, ctmMovementVOs.length);
			this.ctmMovementVOs = tmpVOs;
		}
	}

	public void setCusCtmMovementVOS(CusCtmMovementVO[] cusCtmMovementVOs){
		if(cusCtmMovementVOs != null){
			CusCtmMovementVO[] tmpVOs = java.util.Arrays.copyOf(cusCtmMovementVOs, cusCtmMovementVOs.length);
			this.cusCtmMovementVOs = tmpVOs;
		}
	}

	public MVMTHistoryListVO getMVMTHistoryListVO(){
		return mVMTHistoryListVO;
	}

	public MVMTHistoryListVO[] getMVMTHistoryListVOS(){
		MVMTHistoryListVO[] rtnVOs = null;
		if (this.mVMTHistoryListVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mVMTHistoryListVOs, mVMTHistoryListVOs.length);
		}
		return rtnVOs;
	}

	public MVMTBookingInfoVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public MVMTBookingInfoVO[] getCtmMovementVOS(){
		MVMTBookingInfoVO[] rtnVOs = null;
		if (this.ctmMovementVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(ctmMovementVOs, ctmMovementVOs.length);
		}
		return rtnVOs;
	}

	public CusCtmMovementVO[] getCusCtmMovementVOS(){
		CusCtmMovementVO[] rtnVOs = null;
		if (this.cusCtmMovementVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cusCtmMovementVOs, cusCtmMovementVOs.length);
		}
		return rtnVOs;
	}

}