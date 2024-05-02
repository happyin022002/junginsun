/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3516Event.java
*@FileTitle : Inland Rates History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.11.08 김민아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event;

import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndHistoryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_3516 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3516HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM MINAH
 * @see ESM_PRI_3516HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3516Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndHistoryVO priTrfInlndHistoryVO = null;

	public PriTrfInlndHistoryVO getPriTrfInlndHistoryVO() {
		return priTrfInlndHistoryVO;
	}

	public void setPriTrfInlndHistoryVO(PriTrfInlndHistoryVO priTrfInlndHistoryVO) {
		this.priTrfInlndHistoryVO = priTrfInlndHistoryVO;
	}

}