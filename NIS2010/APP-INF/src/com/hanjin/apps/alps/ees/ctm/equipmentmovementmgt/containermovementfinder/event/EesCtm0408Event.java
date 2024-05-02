/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0408Event.java
*@FileTitle : Each Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.19 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;


/**
 * ees_ctm_0408 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_ctm_0408HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ees_ctm_0408HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0408Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEdiMsgVO searchEdiMsgVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementListByContainerVO searchMovementListByContainerVO = null;

	public EesCtm0408Event(){}

	public void setSearchEdiMsgVO(SearchEdiMsgVO searchEdiMsgVO){
		this. searchEdiMsgVO = searchEdiMsgVO;
	}

	public void setSearchMovementListByContainerVO(SearchMovementListByContainerVO searchMovementListByContainerVO){
		this. searchMovementListByContainerVO = searchMovementListByContainerVO;
	}

	public SearchEdiMsgVO getSearchEdiMsgVO(){
		return searchEdiMsgVO;
	}

	public SearchMovementListByContainerVO getSearchMovementListByContainerVO(){
		return searchMovementListByContainerVO;
	}

}