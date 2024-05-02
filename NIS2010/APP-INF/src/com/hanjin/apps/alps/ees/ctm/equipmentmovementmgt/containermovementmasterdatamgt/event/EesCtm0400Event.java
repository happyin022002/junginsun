/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiCtm0400Event.java
*@FileTitle : Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.24 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.hanjin.syscommon.common.table.CtmMvmtStsVO;


/**
 * ui_ctm_0400 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ui_ctm_0400HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KyungMin Woo
 * @see EES_CTM_0400HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCtm0400Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RCtmMvmtStsVO rCtmMvmtStsVO = null;

	/** Table Value Object Multi Data 처리 */
	private RCtmMvmtStsVO[] rCtmMvmtStsVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMvmtStsVO ctmMvmtStsVO = null;

	/** Table Value Object Multi Data 처리 */
	private CtmMvmtStsVO[] ctmMvmtStsVOs = null;

	public EesCtm0400Event(){}

	public void setRCtmMvmtStsVO(RCtmMvmtStsVO rCtmMvmtStsVO){
		this. rCtmMvmtStsVO = rCtmMvmtStsVO;
	}

	public void setRCtmMvmtStsVOS(RCtmMvmtStsVO[] rCtmMvmtStsVOs){
		this. rCtmMvmtStsVOs = rCtmMvmtStsVOs;
	}

	public void setCtmMvmtStsVO(CtmMvmtStsVO ctmMvmtStsVO){
		this. ctmMvmtStsVO = ctmMvmtStsVO;
	}

	public void setCtmMvmtStsVOS(CtmMvmtStsVO[] ctmMvmtStsVOs){
		this. ctmMvmtStsVOs = ctmMvmtStsVOs;
	}

	public RCtmMvmtStsVO getRCtmMvmtStsVO(){
		return rCtmMvmtStsVO;
	}

	public RCtmMvmtStsVO[] getRCtmMvmtStsVOS(){
		return rCtmMvmtStsVOs;
	}

	public CtmMvmtStsVO getCtmMvmtStsVO(){
		return ctmMvmtStsVO;
	}

	public CtmMvmtStsVO[] getCtmMvmtStsVOS(){
		return ctmMvmtStsVOs;
	}

}