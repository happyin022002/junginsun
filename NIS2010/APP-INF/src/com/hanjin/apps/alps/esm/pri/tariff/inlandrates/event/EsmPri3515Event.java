/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3515Event.java
*@FileTitle : Inland Rates Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.11.01 김민아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfInlndRtVO;
import com.hanjin.syscommon.common.table.PriTrfInlndVO;


/**
 * ESM_PRI_3515 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3515HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM MINAH
 * @see ESM_PRI_3515HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3515Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndVO priTrfInlndVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndRtVO priTrfInlndRtVO = null;

	public EsmPri3515Event(){}
	
	public PriTrfInlndVO getPriTrfInlndVO() {
		return priTrfInlndVO;
	}

	public void setPriTrfInlndVO(PriTrfInlndVO priTrfInlndVO) {
		this.priTrfInlndVO = priTrfInlndVO;
	}

	public void setPriTrfInlndRtVO(PriTrfInlndRtVO priTrfInlndRtVO){
		this. priTrfInlndRtVO = priTrfInlndRtVO;
	}

	public PriTrfInlndRtVO getPriTrfInlndRtVO(){
		return priTrfInlndRtVO;
	}

}