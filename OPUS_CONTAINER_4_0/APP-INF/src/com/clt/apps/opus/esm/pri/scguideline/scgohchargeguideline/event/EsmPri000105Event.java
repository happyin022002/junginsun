/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri0001005Event.java
*@FileTitle : S/C GOH Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.16 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.event;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgGohChgVO;


/**
 * ESM_PRI_0001_005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0001_005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0001_05HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCdListVO rsltCdListVO = null;	
	
	public RsltCdListVO getRsltCdListVO() {
		return rsltCdListVO;
	}

	public void setRsltCdListVO(RsltCdListVO rsltCdListVO) {
		this.rsltCdListVO = rsltCdListVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgGohChgVO priSgGohChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgGohChgVO[] priSgGohChgVOs = null;

	public EsmPri000105Event(){}
	
	public void setPriSgGohChgVO(PriSgGohChgVO priSgGohChgVO){
		this. priSgGohChgVO = priSgGohChgVO;
	}

	public void setPriSgGohChgVOS(PriSgGohChgVO[] priSgGohChgVOs){
		if (priSgGohChgVOs != null) {
			PriSgGohChgVO[] tmpVOs = new PriSgGohChgVO[priSgGohChgVOs.length];
			System.arraycopy(priSgGohChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgGohChgVOs = tmpVOs;
		}
	}

	public PriSgGohChgVO getPriSgGohChgVO(){
		return priSgGohChgVO;
	}

	public PriSgGohChgVO[] getPriSgGohChgVOS(){
		PriSgGohChgVO[] tmpVOs = null;
		if (this.priSgGohChgVOs != null) {
			tmpVOs = new PriSgGohChgVO[priSgGohChgVOs.length];
			System.arraycopy(priSgGohChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}