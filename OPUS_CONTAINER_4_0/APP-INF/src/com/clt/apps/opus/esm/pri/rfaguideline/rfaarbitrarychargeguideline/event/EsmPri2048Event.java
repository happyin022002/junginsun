/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmsPri2048Event.java
*@FileTitle : RFA Guideline Creation - Arbitrary[Load Excel]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.29 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event;

import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbKeyVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgArbVO;


/**
 * ESM_PRI_2048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_2048HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgArbVO priRgArbVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRgArbKeyVO rsltPriRgArbKeyVO = null;


	/** Table Value Object Multi Data 처리 */
	private PriRgArbVO[] priRgArbVOs = null;

	public EsmPri2048Event(){}
	
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
	
	public void setRsltPriRgArbKeyVO(RsltPriRgArbKeyVO rsltPriRgArbKeyVO) {
		this.rsltPriRgArbKeyVO = rsltPriRgArbKeyVO;
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
	
	public RsltPriRgArbKeyVO getRsltPriRgArbKeyVO() {
		return rsltPriRgArbKeyVO;
	}


}