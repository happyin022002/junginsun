/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiCtm0412Event.java
*@FileTitle : BKG container update Irr.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.29 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmMvmtIrrVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * UI_CTM_0412 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_CTM_0412HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KyungMin Woo
 * @see ees_ctm_0412HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0412Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CtmMvmtIrrVO ctmMvmtIrrVO = null;

	/** Table Value Object Multi Data 처리 */
	private CtmMvmtIrrVO[] ctmMvmtIrrVOs = null;

	public void setCtmMvmtIrrVO(CtmMvmtIrrVO ctmMvmtIrrVO){
		this. ctmMvmtIrrVO = ctmMvmtIrrVO;
	}

	public void setCtmMvmtIrrVO(CtmMvmtIrrVO[] ctmMvmtIrrVOs){
		if (ctmMvmtIrrVOs != null) {
			CtmMvmtIrrVO[] tmpVOs = new CtmMvmtIrrVO[ctmMvmtIrrVOs.length];
			System.arraycopy(ctmMvmtIrrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMvmtIrrVOs = tmpVOs;
		}
	}

	public CtmMvmtIrrVO getCtmMvmtIrrVO(){
		return ctmMvmtIrrVO;
	}

	public CtmMvmtIrrVO[] getCtmMvmtIrrVOS(){
		CtmMvmtIrrVO[] tmpVOs = null;
		if (this.ctmMvmtIrrVOs != null) {
			tmpVOs = new CtmMvmtIrrVO[ctmMvmtIrrVOs.length];
			System.arraycopy(ctmMvmtIrrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}