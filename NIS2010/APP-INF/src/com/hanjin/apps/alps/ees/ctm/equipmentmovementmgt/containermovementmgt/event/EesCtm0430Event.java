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
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	
	private String bkgNo = "";
	
	private String cntrId = "";
	
	public EesCtm0430Event(){}

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
	
	public void setBkgNo(String bkgNo){
		this. bkgNo = bkgNo;
	}
	
	public void setCntrId(String cntrId){
		this. cntrId = cntrId;
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
	
	public String getBkgNo(){
		return bkgNo;
	}
	
	public String getCntrId(){
		return cntrId;
	}
}