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
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CtmMovementVO;


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
		if (correctionVLVDLists != null) {
			CorrectionVLVDListVO[] tmpVOs = new CorrectionVLVDListVO[correctionVLVDLists.length];
			System.arraycopy(correctionVLVDLists, 0, tmpVOs, 0, tmpVOs.length);
			this.correctionVLVDLists = tmpVOs;
		}
	}

	public void setCtmMovementVO(CtmMovementVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(CtmMovementVO[] ctmMovementVOs){
		if (ctmMovementVOs != null) {
			CtmMovementVO[] tmpVOs = new CtmMovementVO[ctmMovementVOs.length];
			System.arraycopy(ctmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMovementVOs = tmpVOs;
		}
	}

	public CorrectionVLVDListVO getCorrectionVLVDList(){
		return correctionVLVDList;
	}

	public CorrectionVLVDListVO[] getCorrectionVLVDListS(){
		CorrectionVLVDListVO[] tmpVOs = null;
		if (this.correctionVLVDLists != null) {
			tmpVOs = new CorrectionVLVDListVO[correctionVLVDLists.length];
			System.arraycopy(correctionVLVDLists, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CtmMovementVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public CtmMovementVO[] getCtmMovementVOS(){
		CtmMovementVO[] tmpVOs = null;
		if (this.ctmMovementVOs != null) {
			tmpVOs = new CtmMovementVO[ctmMovementVOs.length];
			System.arraycopy(ctmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public CusCtmMovementVO getCusCtmMovementVO(){
		return cusMovementVO;
	}

	public CusCtmMovementVO[] getCusCtmMovementVOS(){
		CusCtmMovementVO[] tmpVOs = null;
		if (this.cusMovementVOs != null) {
			tmpVOs = new CusCtmMovementVO[cusMovementVOs.length];
			System.arraycopy(cusMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public MVMTBookingInfoVO getMVMTBookingInfoVO(){
		return mvmtBookingInfoVO;
	}

	public MVMTBookingInfoVO[] getMVMTBookingInfoVOS(){
		MVMTBookingInfoVO[] tmpVOs = null;
		if (this.mvmtBookingInfoVOs != null) {
			tmpVOs = new MVMTBookingInfoVO[mvmtBookingInfoVOs.length];
			System.arraycopy(mvmtBookingInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setMVMTBookingInfoVO(MVMTBookingInfoVO vo){
		mvmtBookingInfoVO = vo;
	}

	public void setMVMTBookingInfoVOS(MVMTBookingInfoVO[] mvmtBookingInfoVOs){
		if (mvmtBookingInfoVOs != null) {
			MVMTBookingInfoVO[] tmpVOs = new MVMTBookingInfoVO[mvmtBookingInfoVOs.length];
			System.arraycopy(mvmtBookingInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mvmtBookingInfoVOs = tmpVOs;
		}
	}

	public void setCusCtmMovementVO(CusCtmMovementVO vo){
		cusMovementVO = vo;
	}

	public void setCusCtmMovementVOS(CusCtmMovementVO[] cusMovementVOs){
		if (cusMovementVOs != null) {
			CusCtmMovementVO[] tmpVOs = new CusCtmMovementVO[cusMovementVOs.length];
			System.arraycopy(cusMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cusMovementVOs = tmpVOs;
		}
	}
}