/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt023Event.java
*@FileTitle : 중국 Inbound 대리점 정보 관리 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.07.28 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtChnLaneAgnVO;


/**
 * ESM_AGT_023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Jin
 * @see ESM_AGT_0023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtChnLaneAgnVO agtChnLaneAgnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtChnLaneAgnVO[] agtChnLaneAgnVOs = null;

	public EsmAgt0023Event(){}
	
	public void setAgtChnLaneAgnVO(AgtChnLaneAgnVO agtChnLaneAgnVO){
		this. agtChnLaneAgnVO = agtChnLaneAgnVO;
	}

	public void setAgtChnLaneAgnVOS(AgtChnLaneAgnVO[] agtChnLaneAgnVOs){
		this. agtChnLaneAgnVOs = agtChnLaneAgnVOs;
	}

	public AgtChnLaneAgnVO getAgtChnLaneAgnVO(){
		return agtChnLaneAgnVO;
	}

	public AgtChnLaneAgnVO[] getAgtChnLaneAgnVOS(){
		return agtChnLaneAgnVOs;
	}

}