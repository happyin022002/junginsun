/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_013Event.java
*@FileTitle : Brokerage Commission Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-11
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-11 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrkgCommVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_AGT_013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0013Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private BrkgCommVO brkgCommVO = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private BrkgCommVO[] brkgCommVOs = null;
	
	public EsmAgt0013Event(){}
	
	public void setBrkgCommVO(BrkgCommVO brkgCommVO){
		this. brkgCommVO = brkgCommVO;
	}

	public void setBrkgCommVOS(BrkgCommVO[] brkgCommVOs){
		this. brkgCommVOs = brkgCommVOs;
	}

	public BrkgCommVO getBrkgCommVO(){
		return brkgCommVO;
	}

	public BrkgCommVO[] getBrkgCommVOS(){
		return brkgCommVOs;
	}
}
