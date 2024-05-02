/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0101Event.java
*@FileTitle : CNTR Type Size List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.09.02 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtCntrTypeSizeVO;


/**
 * ESM_AGT_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0101HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtCntrTypeSizeVO agtCntrTypeSizeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtCntrTypeSizeVO[] agtCntrTypeSizeVOs = null;

	public EsmAgt0101Event(){}
	
	public void setAgtCntrTypeSizeVO(AgtCntrTypeSizeVO agtCntrTypeSizeVO){
		this. agtCntrTypeSizeVO = agtCntrTypeSizeVO;
	}

	public void setAgtCntrTypeSizeVOS(AgtCntrTypeSizeVO[] agtCntrTypeSizeVOs){
		this. agtCntrTypeSizeVOs = agtCntrTypeSizeVOs;
	}

	public AgtCntrTypeSizeVO getAgtCntrTypeSizeVO(){
		return agtCntrTypeSizeVO;
	}

	public AgtCntrTypeSizeVO[] getAgtCntrTypeSizeVOS(){
		return agtCntrTypeSizeVOs;
	}

}