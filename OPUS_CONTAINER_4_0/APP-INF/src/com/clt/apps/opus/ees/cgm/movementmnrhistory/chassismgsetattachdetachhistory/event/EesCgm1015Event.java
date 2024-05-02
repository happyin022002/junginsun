/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1015Event.java
*@FileTitle : OW,LP,OL Chassis의 인수시 Chassis Master Creation 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.07 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSAtdtHistoryMGTVO  chsMgsAtdtHistroyMGTvo = null;
	
	private CHSAtdtHistoryMGTVO[] chsMgsAtdtHistroyMGTvos = null;
	



	/**
	 * @return the chsMgsAtdtHistroyMGTvo
	 */
	public CHSAtdtHistoryMGTVO getChsMgsAtdtHistroyMGTvo() {
		return chsMgsAtdtHistroyMGTvo;
	}




	/**
	 * @param chsMgsAtdtHistroyMGTvo the chsMgsAtdtHistroyMGTvo to set
	 */
	public void setChsMgsAtdtHistroyMGTvo(CHSAtdtHistoryMGTVO chsMgsAtdtHistroyMGTvo) {
		this.chsMgsAtdtHistroyMGTvo = chsMgsAtdtHistroyMGTvo;
	}




	/**
	 * @return the chsMgsAtdtHistroyMGTvos
	 */
	public CHSAtdtHistoryMGTVO[] getChsMgsAtdtHistroyMGTvos() {
		CHSAtdtHistoryMGTVO[] rtnVOs = null;
		if (this.chsMgsAtdtHistroyMGTvos != null) {
			rtnVOs = java.util.Arrays.copyOf(chsMgsAtdtHistroyMGTvos, chsMgsAtdtHistroyMGTvos.length);
		}
		return rtnVOs;
	}




	/**
	 * @param chsMgsAtdtHistroyMGTvos the chsMgsAtdtHistroyMGTvos to set
	 */
	public void setChsMgsAtdtHistroyMGTvos(CHSAtdtHistoryMGTVO[] chsMgsAtdtHistroyMGTvos){
		if(chsMgsAtdtHistroyMGTvos != null){
			CHSAtdtHistoryMGTVO[] tmpVOs = java.util.Arrays.copyOf(chsMgsAtdtHistroyMGTvos, chsMgsAtdtHistroyMGTvos.length);
			this.chsMgsAtdtHistroyMGTvos = tmpVOs;
		}
	}




	public EesCgm1015Event(){}



}