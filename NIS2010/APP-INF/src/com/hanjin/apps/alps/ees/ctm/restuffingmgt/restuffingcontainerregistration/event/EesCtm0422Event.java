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
package com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.event;

import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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


	public void setCtmMovementHistoryVO(CtmMovementHistoryVO ctmMvmtXchVO){
		this. ctmVo = ctmMvmtXchVO;
	}

	public void setCtmMovementHistoryVOS(CtmMovementHistoryVO[] ctmMvmtXchVOs){
		this. ctmVos = ctmMvmtXchVOs;
	}

	public CtmMovementHistoryVO getCtmMovementHistoryVO(){
		return ctmVo;
	}

	public CtmMovementHistoryVO[] getCtmMovementHistoryVOS(){
		return ctmVos;
	}

	public void setCtmRestuffingDetailVOS(CtmRestuffingDetailVO[] ctmMvmtXchVOs){
		this. ctmMvmtXchVOs = ctmMvmtXchVOs;
	}

	public CtmRestuffingDetailVO[] getCtmRestuffingDetailVOS(){
		return ctmMvmtXchVOs;
	}

}