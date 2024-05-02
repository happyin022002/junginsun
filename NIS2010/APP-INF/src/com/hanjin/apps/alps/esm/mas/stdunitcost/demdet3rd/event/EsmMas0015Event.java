/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0015Event.java
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.25 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.vo.DemDet3rdVO;


/**
 * ESM_MAS_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_MAS_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DemDet3rdVO demDet3rdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DemDet3rdVO[] demDet3rdVOs = null;

	private SearchConditionVO searchConditionVO = null;
	
	public EsmMas0015Event(){}
	
	public void setDemDet3rdVO(DemDet3rdVO demDet3rdVO){
		this. demDet3rdVO = demDet3rdVO;
	}

	public void setDemDet3rdVOS(DemDet3rdVO[] demDet3rdVOs){
		this. demDet3rdVOs = demDet3rdVOs;
	}

	public DemDet3rdVO getDemDet3rdVO(){
		return demDet3rdVO;
	}

	public DemDet3rdVO[] getDemDet3rdVOS(){
		return demDet3rdVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}