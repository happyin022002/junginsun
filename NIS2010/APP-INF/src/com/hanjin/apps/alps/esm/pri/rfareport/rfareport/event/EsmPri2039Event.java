/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2039Event.java
*@FileTitle : RFA Proposal Creation – Draft
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.15 변영주
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpMnVO;


/**
 * ESM_PRI_2039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_2039HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpMnVO priRpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpMnVO[] priRpMnVOs = null;

	public EsmPri2039Event(){}
	
	public void setPriRpMnVO(PriRpMnVO priRpMnVO){
		this. priRpMnVO = priRpMnVO;
	}

	public void setPriRpMnVOS(PriRpMnVO[] priRpMnVOs){
		if(priRpMnVOs != null){
			PriRpMnVO[] tmpVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpMnVOs = tmpVOs;
		}
	}

	public PriRpMnVO getPriRpMnVO(){
		return priRpMnVO;
	}

	public PriRpMnVO[] getPriRpMnVOS(){
		PriRpMnVO[] rtnVOs = null;
		if (this.priRpMnVOs != null) {
			rtnVOs = new PriRpMnVO[priRpMnVOs.length];
			System.arraycopy(priRpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}