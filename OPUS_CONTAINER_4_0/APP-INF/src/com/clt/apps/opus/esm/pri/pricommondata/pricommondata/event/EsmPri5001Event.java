/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri5001Event.java
*@FileTitle : Booking Term Mapping Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.23 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.PriRcvDeTermMapgVO;


/**
 * ESM_PRI_5001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_5001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-Sun Moon
 * @see ESM_PRI_5001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri5001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRcvDeTermMapgVO priRcvDeTermMapgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRcvDeTermMapgVO[] priRcvDeTermMapgVOs = null;

	public EsmPri5001Event(){}
	
	public void setPriRcvDeTermMapgVO(PriRcvDeTermMapgVO priRcvDeTermMapgVO){
		this. priRcvDeTermMapgVO = priRcvDeTermMapgVO;
	}

	public void setPriRcvDeTermMapgVOS(PriRcvDeTermMapgVO[] priRcvDeTermMapgVOs){
		if (priRcvDeTermMapgVOs != null) {
			PriRcvDeTermMapgVO[] tmpVOs = new PriRcvDeTermMapgVO[priRcvDeTermMapgVOs.length];
			System.arraycopy(priRcvDeTermMapgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRcvDeTermMapgVOs = tmpVOs;
		}
	}

	public PriRcvDeTermMapgVO getPriRcvDeTermMapgVO(){
		return priRcvDeTermMapgVO;
	}

	public PriRcvDeTermMapgVO[] getPriRcvDeTermMapgVOS(){
		PriRcvDeTermMapgVO[] tmpVOs = null;
		if (this.priRcvDeTermMapgVOs != null) {
			tmpVOs = new PriRcvDeTermMapgVO[priRcvDeTermMapgVOs.length];
			System.arraycopy(priRcvDeTermMapgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}