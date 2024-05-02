/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2016Event.java
*@FileTitle : M.G Set의 Attach 또는 Detach를 Manual로 Creation 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.20 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.MGSAtdtHistoryMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSAtdtHistoryMGTVO mGSAtdtHistoryMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSAtdtHistoryMGTVO[] mGSAtdtHistoryMGTVOs = null;

	public EesCgm2016Event(){}

	/**
	 * @return the mGSAtdtHistoryMGTVO
	 */
	public MGSAtdtHistoryMGTVO getMGSAtdtHistoryMGTVO() {
		return mGSAtdtHistoryMGTVO;
	}

	/**
	 * @param atdtHistoryMGTVO the mGSAtdtHistoryMGTVO to set
	 */
	public void setMGSAtdtHistoryMGTVO(MGSAtdtHistoryMGTVO atdtHistoryMGTVO) {
		mGSAtdtHistoryMGTVO = atdtHistoryMGTVO;
	}

	/**
	 * @return the mGSAtdtHistoryMGTVOs
	 */
	public MGSAtdtHistoryMGTVO[] getMGSAtdtHistoryMGTVOs() {
		MGSAtdtHistoryMGTVO[] rtnVOs = null;
		if (this.mGSAtdtHistoryMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSAtdtHistoryMGTVOs, mGSAtdtHistoryMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param atdtHistoryMGTVOs the mGSAtdtHistoryMGTVOs to set
	 */
	public void setMGSAtdtHistoryMGTVOs(MGSAtdtHistoryMGTVO[] atdtHistoryMGTVOs){
		if(atdtHistoryMGTVOs != null){
			MGSAtdtHistoryMGTVO[] tmpVOs = java.util.Arrays.copyOf(atdtHistoryMGTVOs, atdtHistoryMGTVOs.length);
			this.mGSAtdtHistoryMGTVOs = tmpVOs;
		}
	}
	
	

}