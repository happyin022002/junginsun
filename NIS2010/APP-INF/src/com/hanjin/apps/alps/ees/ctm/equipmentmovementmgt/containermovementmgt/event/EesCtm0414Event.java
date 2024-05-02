/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0414Event.java
*@FileTitle : Update of EDI Message (Error)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.15 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0414 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CTM_0414HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see EES_CTM_0414HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0414Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MVMTBookingInfoVO ctmMovementVO = null;

	/** Table Value Object Multi Data 다건 처리  */
	private MVMTBookingInfoVO[] ctmMovementVOs = null;

	/** Table Value Object Multi Data 단건 처리  */
	private SearchEDIMovementListVO searchEDIMovementListVO = null;

	/** Table Value Object Multi Data 다건 처리 */
	private SearchEDIMovementListVO[] searchEDIMovementListVOs = null;

	/** Table Value Object Multi Data 다건 처리 */
	private CusCtmMovementVO[] cusCtmMovementVOs = null;


	public EesCtm0414Event(){}

	public void setCtmMovementVO(MVMTBookingInfoVO ctmMovementVO){
		this. ctmMovementVO = ctmMovementVO;
	}

	public void setCtmMovementVOS(MVMTBookingInfoVO[] ctmMovementVOs){
		this. ctmMovementVOs = ctmMovementVOs;
	}

	public void setSearchEDIMovementListVO(SearchEDIMovementListVO searchEDIMovementListVO){
		this. searchEDIMovementListVO = searchEDIMovementListVO;
	}

	public void setSearchEDIMovementListVOS(SearchEDIMovementListVO[] searchEDIMovementListVOs){
		this. searchEDIMovementListVOs = searchEDIMovementListVOs;
	}

	public void setCusCtmMovementVOS(CusCtmMovementVO[] cusCtmMovementVOs){
		this. cusCtmMovementVOs = cusCtmMovementVOs;
	}

	public MVMTBookingInfoVO getCtmMovementVO(){
		return ctmMovementVO;
	}

	public MVMTBookingInfoVO[] getCtmMovementVOS(){
		return ctmMovementVOs;
	}

	public SearchEDIMovementListVO getSearchEDIMovementListVO(){
		return searchEDIMovementListVO;
	}

	public SearchEDIMovementListVO[] getSearchEDIMovementListVOS(){
		return searchEDIMovementListVOs;
	}

	public CusCtmMovementVO[] getCusCtmMovementVOS(){
		return cusCtmMovementVOs;
	}

}