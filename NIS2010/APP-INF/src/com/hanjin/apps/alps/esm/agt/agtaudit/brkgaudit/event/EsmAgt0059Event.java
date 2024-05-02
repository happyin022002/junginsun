/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_AGT_0059Event.java
*@FileTitle : Brokerage Maintenance & Audit for S.America
*Open Issues :
*Change history :
*@LastModifyDate : 2011-04-13
*@LastModifier : SungJin Park
*@LastVersion : 1.0
* 2011-04-13 SungJin Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event;

import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.CmpnCommVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_AGT_0059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_0059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0059Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private CmpnCommVO cmpnCommVO = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private CmpnCommVO[] cmpnCommVOs = null;
	
	public EsmAgt0059Event(){}
	
	public void setCmpnCommVO(CmpnCommVO cmpnCommVO){
		this. cmpnCommVO = cmpnCommVO;
	}

	public void setCmpnCommVOS(CmpnCommVO[] cmpnCommVOs){
		this. cmpnCommVOs = cmpnCommVOs;
	}

	public CmpnCommVO getCmpnCommVO(){
		return cmpnCommVO;
	}

	public CmpnCommVO[] getCmpnCommVOS(){
		return cmpnCommVOs;
	}
}
