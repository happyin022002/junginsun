/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : EsmPri0034Event.java
*@FileTitle : S/C Open Record Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.01.10 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpInqRecSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpInqRecSearchVO priSpInqRecSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpInqRecSearchVO[] priSpInqRecSearchVOs = null;

	public PriSpInqRecSearchVO getPriSpInqRecSearchVO() {
		return priSpInqRecSearchVO;
	}

	public void setPriSpInqRecSearchVO(PriSpInqRecSearchVO priSpInqRecSearchVO) {
		this.priSpInqRecSearchVO = priSpInqRecSearchVO;
	}

	public PriSpInqRecSearchVO[] getPriSpInqRecSearchVOs() {
		PriSpInqRecSearchVO[] rtnVOs = null;
		if (this.priSpInqRecSearchVOs != null) {
			rtnVOs = new PriSpInqRecSearchVO[priSpInqRecSearchVOs.length];
			System.arraycopy(priSpInqRecSearchVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriSpInqRecSearchVOs(PriSpInqRecSearchVO[] priSpInqRecSearchVOs) {
		if(priSpInqRecSearchVOs != null){
			PriSpInqRecSearchVO[] tmpVOs = new PriSpInqRecSearchVO[priSpInqRecSearchVOs.length];
			System.arraycopy(priSpInqRecSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpInqRecSearchVOs = tmpVOs;
		}
	}
	
}