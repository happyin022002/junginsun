/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0032Event.java
*@FileTitle : Estimation Closing Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.18 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.GlEstmRevVvdVO;


/**
 * ESM_AGT_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GlEstmRevVvdVO glEstmRevVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private GlEstmRevVvdVO[] glEstmRevVvdVOs = null;

	public EsmAgt0032Event(){}
	
	public void setGlEstmRevVvdVO(GlEstmRevVvdVO glEstmRevVvdVO){
		this. glEstmRevVvdVO = glEstmRevVvdVO;
	}

	public void setGlEstmRevVvdVOS(GlEstmRevVvdVO[] glEstmRevVvdVOs){
		this. glEstmRevVvdVOs = glEstmRevVvdVOs;
	}

	public GlEstmRevVvdVO getGlEstmRevVvdVO(){
		return glEstmRevVvdVO;
	}

	public GlEstmRevVvdVO[] getGlEstmRevVvdVOS(){
		return glEstmRevVvdVOs;
	}

}