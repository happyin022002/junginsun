/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3517Event.java
*@FileTitle : Inland Rates Publish
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.02
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.11.02 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.inlandrates.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTrfInlndVO;


/**
 * ESM_PRI_3517 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3517HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNGMIN
 * @see ESM_PRI_3517HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3517Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndVO priTrfInlndVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfInlndVO[] priTrfInlndVOs = null;

	public EsmPri3517Event(){}
	
	public void setPriTrfInlndVO(PriTrfInlndVO priTrfInlndVO){
		this. priTrfInlndVO = priTrfInlndVO;
	}

	public void setPriTrfInlndVOS(PriTrfInlndVO[] priTrfInlndVOs){
		if (priTrfInlndVOs != null) {
			PriTrfInlndVO[] tmpVOs = new PriTrfInlndVO[priTrfInlndVOs.length];
			System.arraycopy(priTrfInlndVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTrfInlndVOs = tmpVOs;
		}
	}

	public PriTrfInlndVO getPriTrfInlndVO(){
		return priTrfInlndVO;
	}

	public PriTrfInlndVO[] getPriTrfInlndVOS(){
		PriTrfInlndVO[] tmpVOs = null;
		if (this.priTrfInlndVOs != null) {
			tmpVOs = new PriTrfInlndVO[priTrfInlndVOs.length];
			System.arraycopy(priTrfInlndVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}