/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0805Event.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event;

import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchAdjustmentManageListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0805 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0805HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0805HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0805Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAdjustmentManageListVO searchAdjustmentManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAdjustmentManageListVO[] searchAdjustmentManageListVOs = null;

	public EsdTpb0805Event(){}
	
	public void setSearchAdjustmentManageListVO(SearchAdjustmentManageListVO searchAdjustmentManageListVO){
		this. searchAdjustmentManageListVO = searchAdjustmentManageListVO;
	}

	public void setSearchAdjustmentManageListVOS(SearchAdjustmentManageListVO[] searchAdjustmentManageListVOs){
		this. searchAdjustmentManageListVOs = searchAdjustmentManageListVOs;
	}

	public SearchAdjustmentManageListVO getSearchAdjustmentManageListVO(){
		return searchAdjustmentManageListVO;
	}

	public SearchAdjustmentManageListVO[] getSearchAdjustmentManageListVOS(){
		return searchAdjustmentManageListVOs;
	}

}