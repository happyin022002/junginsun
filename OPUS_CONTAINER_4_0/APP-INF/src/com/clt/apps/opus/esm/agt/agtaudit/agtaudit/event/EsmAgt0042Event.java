/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0042Event.java
*@FileTitle : Commission Unit Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.13 추경원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtAgnCommVO;


/**
 * ESM_AGT_0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0042HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0042Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnCommVO agtAgnCommVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtAgnCommVO[] agtAgnCommVOs = null;

	public EsmAgt0042Event(){}
	
	public void setAgtAgnCommVO(AgtAgnCommVO agtAgnCommVO){
		this. agtAgnCommVO = agtAgnCommVO;
	}

	public void setAgtAgnCommVOS(AgtAgnCommVO[] agtAgnCommVOs){
		this. agtAgnCommVOs = agtAgnCommVOs;
	}

	public AgtAgnCommVO getAgtAgnCommVO(){
		return agtAgnCommVO;
	}

	public AgtAgnCommVO[] getAgtAgnCommVOS(){
		return agtAgnCommVOs;
	}

}