/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0028Event.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.08 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpDlRecVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0028HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpDlRecVO priSpDlRecVo = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpDlRecVO[] priSpDlRecVos = null;

	public PriSpDlRecVO getPriSpDlRecVo() {
		return priSpDlRecVo;
	}

	public void setPriSpDlRecVo(PriSpDlRecVO priSpDlRecVo) {
		this.priSpDlRecVo = priSpDlRecVo;
	}

	public PriSpDlRecVO[] getPriSpDlRecVos() {
		PriSpDlRecVO[] rtnVOs = null;
		if (this.priSpDlRecVos != null) {
			rtnVOs = new PriSpDlRecVO[priSpDlRecVos.length];
			System.arraycopy(priSpDlRecVos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriSpDlRecVos(PriSpDlRecVO[] priSpDlRecVos) {
		if(priSpDlRecVos != null){
			PriSpDlRecVO[] tmpVOs = new PriSpDlRecVO[priSpDlRecVos.length];
			System.arraycopy(priSpDlRecVos, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpDlRecVos = tmpVOs;
		}
	}
	
}