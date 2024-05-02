/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0038Event.java
*@FileTitle : Security & AR Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.14 추경원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtsecurity.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtFincOfcInfoVO;


/**
 * ESM_AGT_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0038HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtFincOfcInfoVO agtFincOfcInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtFincOfcInfoVO[] agtFincOfcInfoVOs = null;

	public EsmAgt0038Event(){}
	
	public void setAgtFincOfcInfoVO(AgtFincOfcInfoVO agtFincOfcInfoVO){
		this. agtFincOfcInfoVO = agtFincOfcInfoVO;
	}

	public void setAgtFincOfcInfoVOS(AgtFincOfcInfoVO[] agtFincOfcInfoVOs){
		this. agtFincOfcInfoVOs = agtFincOfcInfoVOs;
	}

	public AgtFincOfcInfoVO getAgtFincOfcInfoVO(){
		return agtFincOfcInfoVO;
	}

	public AgtFincOfcInfoVO[] getAgtFincOfcInfoVOS(){
		return agtFincOfcInfoVOs;
	}

}