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
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.CntrTpSelectVO;


/**
 * ESM_AGT_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_ACM_0104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrTpSelectVO cntrTpSelectVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrTpSelectVO[] cntrTpSelectVOs = null;

	public EsmAcm0104Event(){}
	
	public void setCntrTpSelectVO(CntrTpSelectVO cntrTpSelectVO){
		this. cntrTpSelectVO = cntrTpSelectVO;
	}

	public void setCntrTpSelectVOs(CntrTpSelectVO[] cntrTpSelectVOs){
		this. cntrTpSelectVOs = cntrTpSelectVOs;
	}

	public CntrTpSelectVO getCntrTpSelectVO(){
		return cntrTpSelectVO;
	}

	public CntrTpSelectVO[] getCntrTpSelectVOs(){
		return cntrTpSelectVOs;
	}

}