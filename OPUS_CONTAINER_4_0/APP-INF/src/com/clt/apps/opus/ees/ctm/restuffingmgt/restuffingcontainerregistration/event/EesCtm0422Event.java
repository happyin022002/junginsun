/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0422Event.java
*@FileTitle : Restuffing Creation
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
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0422 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0422HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0422HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0422Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
//	private CtmMvmtXchVO ctmMvmtXchVO = null;

	/** Table Value Object Multi Data 처리 */
	private CtmRestuffingDetailVO[] ctmMvmtXchVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMovementHistoryVO ctmVo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CtmMovementHistoryVO[] ctmVos = null;

	public EesCtm0422Event(){}

	/**
	 * EES_CTM_0422
	 * @param ctmMvmtXchVOs CtmRestuffingDetailVO[]
	 */
	public EesCtm0422Event(CtmRestuffingDetailVO[] ctmMvmtXchVOs){
		this.ctmMvmtXchVOs = ctmMvmtXchVOs;
	}


	public void setCtmMovementHistoryVO(CtmMovementHistoryVO ctmMvmtXchVO){
		this. ctmVo = ctmMvmtXchVO;
	}

	public void setCtmMovementHistoryVOS(CtmMovementHistoryVO[] ctmVos){
		if (ctmVos != null) {
			CtmMovementHistoryVO[] tmpVOs = new CtmMovementHistoryVO[ctmVos.length];
			System.arraycopy(ctmVos, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmVos = tmpVOs;
		}
	}

	public CtmMovementHistoryVO getCtmMovementHistoryVO(){
		return ctmVo;
	}

	public CtmMovementHistoryVO[] getCtmMovementHistoryVOS(){
		CtmMovementHistoryVO[] tmpVOs = null;
		if (this.ctmVos != null) {
			tmpVOs = new CtmMovementHistoryVO[ctmVos.length];
			System.arraycopy(ctmVos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCtmRestuffingDetailVOS(CtmRestuffingDetailVO[] ctmMvmtXchVOs){
		if (ctmMvmtXchVOs != null) {
			CtmRestuffingDetailVO[] tmpVOs = new CtmRestuffingDetailVO[ctmMvmtXchVOs.length];
			System.arraycopy(ctmMvmtXchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMvmtXchVOs = tmpVOs;
		}
	}

	public CtmRestuffingDetailVO[] getCtmRestuffingDetailVOS(){
		CtmRestuffingDetailVO[] tmpVOs = null;
		if (this.ctmMvmtXchVOs != null) {
			tmpVOs = new CtmRestuffingDetailVO[ctmMvmtXchVOs.length];
			System.arraycopy(ctmMvmtXchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}