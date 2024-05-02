/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3522Event.java
*@FileTitle : Inland Rates Creation &amp; Amendment[Load Excel]
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.10 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event;

import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndListVO;
import com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfInlndRtVO;


/**
 * ESM_PRI_3522 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3522HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNGMIN
 * @see ESM_PRI_3522HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3522Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndRtVO priTrfInlndRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfInlndRtVO[] priTrfInlndRtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfInlndParamVO priTrfInlndParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	PriTrfInlndListVO priTrfInlndListVO = null;
	
	public EsmPri3522Event(){}
	
	public void setPriTrfInlndRtVO(PriTrfInlndRtVO priTrfInlndRtVO){
		this. priTrfInlndRtVO = priTrfInlndRtVO;
	}

	public void setPriTrfInlndRtVOS(PriTrfInlndRtVO[] priTrfInlndRtVOs){
		this. priTrfInlndRtVOs = priTrfInlndRtVOs;
	}

	public PriTrfInlndRtVO getPriTrfInlndRtVO(){
		return priTrfInlndRtVO;
	}

	public PriTrfInlndRtVO[] getPriTrfInlndRtVOS(){
		return priTrfInlndRtVOs;
	}

	public PriTrfInlndParamVO getPriTrfInlndParamVO() {
		return priTrfInlndParamVO;
	}

	public void setPriTrfInlndParamVO(PriTrfInlndParamVO priTrfInlndParamVO) {
		this.priTrfInlndParamVO = priTrfInlndParamVO;
	}

	public PriTrfInlndListVO getPriTrfInlndListVO() {
		return priTrfInlndListVO;
	}

	public void setPriTrfInlndListVO(PriTrfInlndListVO priTrfInlndListVO) {
		this.priTrfInlndListVO = priTrfInlndListVO;
	}
	
	

}