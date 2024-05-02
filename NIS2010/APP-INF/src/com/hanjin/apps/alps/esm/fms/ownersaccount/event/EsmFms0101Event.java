/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmFms0101Event.java
*@FileTitle : O/A Inquiry for Cancellation
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.CondOwnrAcctForCnclVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_FMS_0101HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	CondOwnrAcctForCnclVO condOwnrAcctForCnclVO = null;

	/** Table Value Object Multi Data 처리 */
	CondOwnrAcctForCnclVO[] condOwnrAcctForCnclVOs = null;

	public EsmFms0101Event() {
	}

	public void setCondOwnrAcctForCnclVO(CondOwnrAcctForCnclVO condOwnrAcctForCnclVO) {
		this.condOwnrAcctForCnclVO = condOwnrAcctForCnclVO;
	}

	public void setCondOwnrAcctForCnclVOs(CondOwnrAcctForCnclVO[] condOwnrAcctForCnclVOs) {
		if (condOwnrAcctForCnclVOs != null) {
			CondOwnrAcctForCnclVO[] tmpVOs = Arrays.copyOf(condOwnrAcctForCnclVOs, condOwnrAcctForCnclVOs.length);
			this.condOwnrAcctForCnclVOs = tmpVOs;
		}
	}
	
	public CondOwnrAcctForCnclVO getCondOwnrAcctForCnclVO() {
		return condOwnrAcctForCnclVO;
	}

	public CondOwnrAcctForCnclVO[] getCondOwnrAcctForCnclVOs() {
		CondOwnrAcctForCnclVO[] tmpVOs = null;
		if (this.condOwnrAcctForCnclVOs != null) {
			tmpVOs = Arrays.copyOf(condOwnrAcctForCnclVOs, condOwnrAcctForCnclVOs.length);
		}
		return tmpVOs;
	}
}