/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0445Event.java
*@FileTitle : Booking Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.04 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.event;

import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0445 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0445HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0445HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0445Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMovementHistoryVO ctmMvmtXchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CtmMovementHistoryVO[] ctmMvmtXchVOs = null;

	public EesCtm0445Event(){}
	
	public void setCtmMovementHistoryVO(CtmMovementHistoryVO ctmMvmtXchVO){
		this. ctmMvmtXchVO = ctmMvmtXchVO;
	}

	public void setCtmMovementHistoryVOS(CtmMovementHistoryVO[] ctmMvmtXchVOs){
		if (ctmMvmtXchVOs != null) {
			CtmMovementHistoryVO[] tmpVOs = new CtmMovementHistoryVO[ctmMvmtXchVOs.length];
			System.arraycopy(ctmMvmtXchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMvmtXchVOs = tmpVOs;
		}
	}

	public CtmMovementHistoryVO getCtmMovementHistoryVO(){
		return ctmMvmtXchVO;
	}

	public CtmMovementHistoryVO[] getCtmMovementHistoryVOS(){
		CtmMovementHistoryVO[] tmpVOs = null;
		if (this.ctmMvmtXchVOs != null) {
			tmpVOs = new CtmMovementHistoryVO[ctmMvmtXchVOs.length];
			System.arraycopy(ctmMvmtXchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}