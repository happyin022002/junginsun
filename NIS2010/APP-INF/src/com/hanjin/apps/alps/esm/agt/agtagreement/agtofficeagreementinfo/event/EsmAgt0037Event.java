/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_037Event.java
*@FileTitle : Other Information info(Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : Sang-Jun Kwon
*@LastVersion : 1.0
* 2006-12-28 Sang-Jun Kwon
* 1.0 최초 생성
* 2009-09-05  Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event;

import com.hanjin.apps.alps.esm.agt.common.event.AGTEvent;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtAgnCtrtRefVO;
import com.hanjin.syscommon.common.table.AgtAgnOtrRefVO;


/**
 * ESM_AGT_037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sang-Jun Kwon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0037Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnOtrRefVO agtAgnOtrRefVO = null;

	private AgtAgnOtrRefVO[] agtAgnOtrRefVOs = null;
	
	private AgtAgnCtrtRefVO agtAgnCtrtRefVO = null;
	
	private AgtAgnCtrtRefVO[] agtAgnCtrtRefVOs = null;
	
	public EsmAgt0037Event(){}
	
	public void setAgtAgnOtrRefVO(AgtAgnOtrRefVO agtAgnOtrRefVO) {
    	this.agtAgnOtrRefVO = agtAgnOtrRefVO;
    }
	
	public void setAgtAgnOtrRefVOs(AgtAgnOtrRefVO[] agtAgnOtrRefVOs) {
    	this.agtAgnOtrRefVOs = agtAgnOtrRefVOs;
    }
	
	public void setAgtAgnCtrtRefVO(AgtAgnCtrtRefVO agtAgnCtrtRefVO) {
    	this.agtAgnCtrtRefVO = agtAgnCtrtRefVO;
    }
	
	public void setAgtAgnCtrtRefVOs(AgtAgnCtrtRefVO[] agtAgnCtrtRefVOs) {
    	this.agtAgnCtrtRefVOs = agtAgnCtrtRefVOs;
    }
	
	public AgtAgnOtrRefVO getAgtAgnOtrRefVO() {
    	return agtAgnOtrRefVO;
    }
	
	public AgtAgnOtrRefVO[] getAgtAgnOtrRefVOs() {
    	return agtAgnOtrRefVOs;
    }

	public AgtAgnCtrtRefVO getAgtAgnCtrtRefVO() {
    	return agtAgnCtrtRefVO;
    }

	public AgtAgnCtrtRefVO[] getAgtAgnCtrtRefVOs() {
    	return agtAgnCtrtRefVOs;
    }
}
