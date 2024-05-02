/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0619Event.java
*@FileTitle : Outbound Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.01 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;


/**
 * ESM_BKG_0619 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0619HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0619HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0619Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OutBdMovementStsListInVO outBdMovementStsListInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OutBdMovementStsListInVO[] outBdMovementStsListInVOs = null;

	public EsmBkg0619Event(){}
	
	public void setOutBdMovementStsListInVO(OutBdMovementStsListInVO outBdMovementStsListInVO){
		this. outBdMovementStsListInVO = outBdMovementStsListInVO;
	}

//	public void setOutBdMovementStsListInVOS(OutBdMovementStsListInVO[] outBdMovementStsListInVOs){
//		this. outBdMovementStsListInVOs = outBdMovementStsListInVOs;
//	}

	public OutBdMovementStsListInVO getOutBdMovementStsListInVO(){
		return outBdMovementStsListInVO;
	}

//	public OutBdMovementStsListInVO[] getOutBdMovementStsListInVOS(){
//		return outBdMovementStsListInVOs;
//	}

	//2015.03.01 Secure Coding 적용 [CWE-495]
	public OutBdMovementStsListInVO[] getOutBdMovementStsListInVOS(){
		OutBdMovementStsListInVO[] rtnVOs = null;
		if (this.outBdMovementStsListInVOs != null) {
			rtnVOs = new OutBdMovementStsListInVO[outBdMovementStsListInVOs.length];
			System.arraycopy(outBdMovementStsListInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.03.01 Secure Coding 적용[CWE-496]
	public void setOutBdMovementStsListInVOS(OutBdMovementStsListInVO[] outBdMovementStsListInVOs){
		if (outBdMovementStsListInVOs != null) {
			OutBdMovementStsListInVO[] tmpVOs = new OutBdMovementStsListInVO[outBdMovementStsListInVOs.length];
			System.arraycopy(outBdMovementStsListInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.outBdMovementStsListInVOs = tmpVOs;
		}
	}			
	
}