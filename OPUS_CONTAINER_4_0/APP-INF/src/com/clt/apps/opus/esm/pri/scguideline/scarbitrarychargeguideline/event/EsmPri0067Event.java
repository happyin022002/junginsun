/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0067Event.java
*@FileTitle : Guideline Arbitrary - Excel Import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.18 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.event;

import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbKeyVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgArbVO;


/**
 * ESM_PRI_0067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0067HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgArbVO priSgArbVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSgArbKeyVO rsltPriSgArbKeyVO = null;


	/** Table Value Object Multi Data 처리 */
	private PriSgArbVO[] priSgArbVOs = null;

	public EsmPri0067Event(){}
	
	public void setPriSgArbVO(PriSgArbVO priSgArbVO){
		this. priSgArbVO = priSgArbVO;
	}

	public void setPriSgArbVOS(PriSgArbVO[] priSgArbVOs){
		if (priSgArbVOs != null) {
			PriSgArbVO[] tmpVOs = new PriSgArbVO[priSgArbVOs.length];
			System.arraycopy(priSgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgArbVOs = tmpVOs;
		}
	}
	
	public void setRsltPriSgArbKeyVO(RsltPriSgArbKeyVO rsltPriSgArbKeyVO) {
		this.rsltPriSgArbKeyVO = rsltPriSgArbKeyVO;
	}

	public PriSgArbVO getPriSgArbVO(){
		return priSgArbVO;
	}

	public PriSgArbVO[] getPriSgArbVOS(){
		PriSgArbVO[] tmpVOs = null;
		if (this.priSgArbVOs != null) {
			tmpVOs = new PriSgArbVO[priSgArbVOs.length];
			System.arraycopy(priSgArbVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public RsltPriSgArbKeyVO getRsltPriSgArbKeyVO() {
		return rsltPriSgArbKeyVO;
	}

	

}