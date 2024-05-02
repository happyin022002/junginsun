/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0465Event.java
*@FileTitle : Multi Container Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.09
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.12.09 문동선 (EES_CTM_0408 화면 Copy 로 생성)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByMultiContainerVO;


/**
 * ees_ctm_0465 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_ctm_0465HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon, Dong-sun
 * @see ees_ctm_0465HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0465Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEdiMsgVO searchEdiMsgVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO = null;

	public EesCtm0465Event(){}

	public void setSearchEdiMsgVO(SearchEdiMsgVO searchEdiMsgVO){
		this. searchEdiMsgVO = searchEdiMsgVO;
	}

	public void setSearchMovementListByMultiContainerVO(SearchMovementListByMultiContainerVO searchMovementListByMultiContainerVO){
		this. searchMovementListByMultiContainerVO = searchMovementListByMultiContainerVO;
	}

	public SearchEdiMsgVO getSearchEdiMsgVO(){
		return searchEdiMsgVO;
	}

	public SearchMovementListByMultiContainerVO getSearchMovementListByMultiContainerVO(){
		return searchMovementListByMultiContainerVO;
	}

}