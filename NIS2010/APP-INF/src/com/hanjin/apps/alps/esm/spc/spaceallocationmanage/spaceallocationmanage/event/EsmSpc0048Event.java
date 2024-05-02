/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSpc0048Event.java
*@FileTitle : WAF Allocation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.08.11 이행지
* 1.0 Creation
=========================================================
* History
* 2011.08.11 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 - WAF 노선에 대한 Allocation 팝업 추가
=========================================================
*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;


/**
 * ESM_SPC_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SPC_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_SPC_0048HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	private ConditionVO conditionVO = null;
	private SpcAlocPolPodVO SpcAlocPolPodVO = null;
	private SpcAlocPolPodVO[] SpcAlocPolPodVOs = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	public SpcAlocPolPodVO getSpcAlocPolPodVO() {
		return SpcAlocPolPodVO;
	}

	public void setSpcAlocPolPodVO(SpcAlocPolPodVO spcAlocPolPodVO) {
		SpcAlocPolPodVO = spcAlocPolPodVO;
	}

	public SpcAlocPolPodVO[] getSpcAlocPolPodVOs() {
		SpcAlocPolPodVO[] rtnVOs = null;
		if (this.SpcAlocPolPodVOs != null) {
			rtnVOs = new SpcAlocPolPodVO[SpcAlocPolPodVOs.length];
			System.arraycopy(SpcAlocPolPodVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSpcAlocPolPodVOs(SpcAlocPolPodVO[] spcAlocPolPodVOs) {
		if (spcAlocPolPodVOs != null) {
			SpcAlocPolPodVO[] tmpVOs = new SpcAlocPolPodVO[spcAlocPolPodVOs.length];
			System.arraycopy(spcAlocPolPodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.SpcAlocPolPodVOs = tmpVOs;
		}
	}
}