/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0118Event.java
*@FileTitle : Terminal Internal Pricing (PA/RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.12.07 김종범 최초 생성
* 2009.09.11 0118 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchOwnTMLPfmcListVO;
import com.hanjin.syscommon.common.table.MasInterOwnTmlCostVO;


/**
 * ESM_MAS_0118 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0118HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0118HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0118Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOwnTMLPfmcListVO searchOwnTMLPfmcListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOwnTMLPfmcListVO[] searchOwnTMLPfmcListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasInterOwnTmlCostVO masInterOwnTmlCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasInterOwnTmlCostVO[] masInterOwnTmlCostVOs = null;
	
	/** 공통 입력 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0118Event(){}
	
	public void setSearchOwnTMLPfmcListVO(SearchOwnTMLPfmcListVO searchOwnTMLPfmcListVO){
		this. searchOwnTMLPfmcListVO = searchOwnTMLPfmcListVO;
	}

	public void setSearchOwnTMLPfmcListVOS(SearchOwnTMLPfmcListVO[] searchOwnTMLPfmcListVOs){
		this. searchOwnTMLPfmcListVOs = searchOwnTMLPfmcListVOs;
	}

	public void setMasInterOwnTmlCostVO(MasInterOwnTmlCostVO masInterOwnTmlCostVO){
		this. masInterOwnTmlCostVO = masInterOwnTmlCostVO;
	}

	public void setMasInterOwnTmlCostVOS(MasInterOwnTmlCostVO[] masInterOwnTmlCostVOs){
		this. masInterOwnTmlCostVOs = masInterOwnTmlCostVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public SearchOwnTMLPfmcListVO getSearchOwnTMLPfmcListVO(){
		return searchOwnTMLPfmcListVO;
	}

	public SearchOwnTMLPfmcListVO[] getSearchOwnTMLPfmcListVOS(){
		return searchOwnTMLPfmcListVOs;
	}

	public MasInterOwnTmlCostVO getMasInterOwnTmlCostVO(){
		return masInterOwnTmlCostVO;
	}

	public MasInterOwnTmlCostVO[] getMasInterOwnTmlCostVOS(){
		return masInterOwnTmlCostVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}