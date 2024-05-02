/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0430Event.java
*@FileTitle : CNTR History Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.08 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0430 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0430HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KyungMin Woo
 * @see EES_CTM_0430HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCtm0430Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MVMTHistoryListVO mVMTHistoryListVO = null;

	/** Table Value Object Multi Data 처리 */
	private MVMTHistoryListVO[] mVMTHistoryListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MVMTBookingInfoVO ctmMovementVO = null;

	/** Table Value Object Multi Data 처리 */
	private MVMTBookingInfoVO[] ctmMovementVOs = null;

	/** Table Value Object Multi Data 처리 */
	private CusCtmMovementVO[] cusCtmMovementVOs = null;
	public EesCtm0430Event(){}

	public void setMVMTHistoryListVO(MVMTHistoryListVO mVMTHistoryListVO){
		this. mVMTHistoryListVO = mVMTHistoryListVO;
	}

	public void setMVMTHistoryListVOS(MVMTHistoryListVO[] mVMTHistoryListVOs){
		if (mVMTHistoryListVOs != null) {
			MVMTHistoryListVO[] tmpVOs = new MVMTHistoryListVO[mVMTHistoryListVOs.length];
			System.arraycopy(mVMTHistoryListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mVMTHistoryListVOs = tmpVOs;
		}
	}

	public void setCtmMovementVO(MVMTBookingInfoVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(MVMTBookingInfoVO[] ctmMovementVOs){
		if (ctmMovementVOs != null) {
			MVMTBookingInfoVO[] tmpVOs = new MVMTBookingInfoVO[ctmMovementVOs.length];
			System.arraycopy(ctmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMovementVOs = tmpVOs;
		}
	}

	public void setCusCtmMovementVOS(CusCtmMovementVO[] cusCtmMovementVOs){
		if (cusCtmMovementVOs != null) {
			CusCtmMovementVO[] tmpVOs = new CusCtmMovementVO[cusCtmMovementVOs.length];
			System.arraycopy(cusCtmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cusCtmMovementVOs = tmpVOs;
		}
	}

	public MVMTHistoryListVO getMVMTHistoryListVO(){
		return mVMTHistoryListVO;
	}

	public MVMTHistoryListVO[] getMVMTHistoryListVOS(){
		MVMTHistoryListVO[] tmpVOs = null;
		if (this.mVMTHistoryListVOs != null) {
			tmpVOs = new MVMTHistoryListVO[mVMTHistoryListVOs.length];
			System.arraycopy(mVMTHistoryListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public MVMTBookingInfoVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public MVMTBookingInfoVO[] getCtmMovementVOS(){
		MVMTBookingInfoVO[] tmpVOs = null;
		if (this.ctmMovementVOs != null) {
			tmpVOs = new MVMTBookingInfoVO[ctmMovementVOs.length];
			System.arraycopy(ctmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CusCtmMovementVO[] getCusCtmMovementVOS(){
		CusCtmMovementVO[] tmpVOs = null;
		if (this.cusCtmMovementVOs != null) {
			tmpVOs = new CusCtmMovementVO[cusCtmMovementVOs.length];
			System.arraycopy(cusCtmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}