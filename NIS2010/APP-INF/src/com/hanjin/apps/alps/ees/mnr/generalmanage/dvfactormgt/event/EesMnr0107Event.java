/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EssMnr0107Event.java
*@FileTitle : DV Factor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.20 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.CustomMnrEqDpcVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorINVO;
import com.hanjin.framework.support.layer.event.EventSupport;
   

/**
 * ESS_MNR_0107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESS_MNR_0107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see EES_MNR_0107HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DVFactorINVO dVFactorINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrEqDpcVO[] customMnrEqDpcVOs = null;

	public EesMnr0107Event(){}

	public DVFactorINVO getDVFactorINVO() {
		return dVFactorINVO;
	}

	public void setDVFactorINVO(DVFactorINVO factorINVO) {
		dVFactorINVO = factorINVO;
	}

	public CustomMnrEqDpcVO[] getCustomMnrEqDpcVOs() {
		return customMnrEqDpcVOs;
	}

	public void setCustomMnrEqDpcVOs(CustomMnrEqDpcVO[] customMnrEqDpcVOs) {
		this.customMnrEqDpcVOs = customMnrEqDpcVOs;
	}
}