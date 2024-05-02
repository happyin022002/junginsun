/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0409Event.java
*@FileTitle : Each Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.25 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByBkgInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrTpszCdVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListBySplitBkgNoForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByVvdForMultiComboVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0409 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0409HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see EES_CTM_0409HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0409Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementListByBkgInfoVO searchMovementListByBkgInfoVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementListByVvdForMultiComboVO searchMovementListByVvdForMultiComboVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementListBySplitBkgNoForMultiComboVO searchMovementListBySplitBkgNoForMultiComboVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementListByCntrTpszCdVO searchMovementListByCntrTpszCdVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMovementListByCntrInfoVO searchMovementListByCntrInfoVO = null;

	public EesCtm0409Event(){}

	public void setSearchMovementListByBkgInfoVO(SearchMovementListByBkgInfoVO searchMovementListByBkgInfoVO){
		this. searchMovementListByBkgInfoVO = searchMovementListByBkgInfoVO;
	}

	public void setSearchMovementListByVvdForMultiComboVO(SearchMovementListByVvdForMultiComboVO searchMovementListByVvdForMultiComboVO){
		this. searchMovementListByVvdForMultiComboVO = searchMovementListByVvdForMultiComboVO;
	}

	public void setSearchMovementListBySplitBkgNoForMultiComboVO(SearchMovementListBySplitBkgNoForMultiComboVO searchMovementListBySplitBkgNoForMultiComboVO){
		this. searchMovementListBySplitBkgNoForMultiComboVO = searchMovementListBySplitBkgNoForMultiComboVO;
	}

	public void setSearchMovementListByCntrTpszCdVO(SearchMovementListByCntrTpszCdVO searchMovementListByCntrTpszCdVO){
		this. searchMovementListByCntrTpszCdVO = searchMovementListByCntrTpszCdVO;
	}

	public void setSearchMovementListByCntrInfoVO(SearchMovementListByCntrInfoVO searchMovementListByCntrInfoVO){
		this. searchMovementListByCntrInfoVO = searchMovementListByCntrInfoVO;
	}

	public SearchMovementListByBkgInfoVO getSearchMovementListByBkgInfoVO(){
		return searchMovementListByBkgInfoVO;
	}

	public SearchMovementListByVvdForMultiComboVO getSearchMovementListByVvdForMultiComboVO(){
		return searchMovementListByVvdForMultiComboVO;
	}

	public SearchMovementListBySplitBkgNoForMultiComboVO getSearchMovementListBySplitBkgNoForMultiComboVO(){
		return searchMovementListBySplitBkgNoForMultiComboVO;
	}

	public SearchMovementListByCntrTpszCdVO getSearchMovementListByCntrTpszCdVO(){
		return searchMovementListByCntrTpszCdVO;
	}

	public SearchMovementListByCntrInfoVO getSearchMovementListByCntrInfoVO(){
		return searchMovementListByCntrInfoVO;
	}

}