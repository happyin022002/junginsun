/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4001Event.java
*@FileTitle : Rating Unit Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.12 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.ratingunit.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRatUtVO;


/**
 * ESM_PRI_4002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_4002HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri4002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRatUtVO priRatUtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRatUtVO[] priRatUtVOs = null;

	public EsmPri4002Event(){}
	
	public void setPriRatUtVO(PriRatUtVO priRatUtVO){
		this. priRatUtVO = priRatUtVO;
	}

	public void setPriRatUtVOS(PriRatUtVO[] priRatUtVOs){
		if (priRatUtVOs != null) {
			PriRatUtVO[] tmpVOs = new PriRatUtVO[priRatUtVOs.length];
			System.arraycopy(priRatUtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRatUtVOs = tmpVOs;
		}
	}

	public PriRatUtVO getPriRatUtVO(){
		return priRatUtVO;
	}

	public PriRatUtVO[] getPriRatUtVOS(){
		PriRatUtVO[] tmpVOs = null;
		if (this.priRatUtVOs != null) {
			tmpVOs = new PriRatUtVO[priRatUtVOs.length];
			System.arraycopy(priRatUtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}