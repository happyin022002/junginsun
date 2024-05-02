/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri201804Event.java
*@FileTitle : RFA Guideline Inquiry - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.12 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgArbVO;


/**
 * UI_PRI_0002_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_PRI_0002_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_2018_03HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri201803Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgArbVO priRgArbVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRgArbVO[] priRgArbVOs = null;

	public EsmPri201803Event(){}
	
	public void setPriRgArbVO(PriRgArbVO priRgArbVO){
		this. priRgArbVO = priRgArbVO;
	}

	public void setPriRgArbVOS(PriRgArbVO[] priRgArbVOs){
		if (priRgArbVOs != null) {
			PriRgArbVO[] tmpVOs = new PriRgArbVO[priRgArbVOs.length];
			System.arraycopy(priRgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRgArbVOs = tmpVOs;
		}
	}

	public PriRgArbVO getPriRgArbVO(){
		return priRgArbVO;
	}

	public PriRgArbVO[] getPriRgArbVOS(){
		PriRgArbVO[] tmpVOs = null;
		if (this.priRgArbVOs != null) {
			tmpVOs = new PriRgArbVO[priRgArbVOs.length];
			System.arraycopy(priRgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}