/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2045Event.java
*@FileTitle : Retroactive RFA Note
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.11.24 최성환
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpRetroVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_2045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 최성환
 * @see ESM_PRI_2045HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2045Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpRetroVO priRpRetroVO = null;
	/** Table Value Object Multi Data 처리 */
	private PriRpRetroVO[] priRpRetroVOs = null;

	public EsmPri2045Event(){}
	
	/* set */
	public void setPriRpRetroVO(PriRpRetroVO priRpRetroVO){
		this.priRpRetroVO = priRpRetroVO;
	}
	public void setPriRpRetroVOS(PriRpRetroVO[] priRpRetroVOs){
		if(priRpRetroVOs != null){
			PriRpRetroVO[] tmpVOs = new PriRpRetroVO[priRpRetroVOs.length];
			System.arraycopy(priRpRetroVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpRetroVOs = tmpVOs;
		}
	}
	
	/* get */
	public PriRpRetroVO getPriRpRetroVO(){
		return priRpRetroVO;
	}
	public PriRpRetroVO[] getPriRpRetroVOS(){
		PriRpRetroVO[] rtnVOs = null;
		if (this.priRpRetroVOs != null) {
			rtnVOs = new PriRpRetroVO[priRpRetroVOs.length];
			System.arraycopy(priRpRetroVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}