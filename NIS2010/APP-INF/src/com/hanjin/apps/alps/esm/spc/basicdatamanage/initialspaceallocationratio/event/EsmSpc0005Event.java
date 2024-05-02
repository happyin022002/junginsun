/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0004Event.java
*@FileTitle : Initial Allocation Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.07.24 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.event;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.vo.SearchInitialSpaceAllocationRatioListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcInitAlocRtoVO;


/**
 * ESM_SPC_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInitialSpaceAllocationRatioListVO[] searchInitialSpaceAllocationRatioListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcInitAlocRtoVO spcInitAlocRtoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcInitAlocRtoVO[] spcInitAlocRtoVOs = null;

	public EsmSpc0005Event(){}
	
	public void setSearchInitialSpaceAllocationRatioListVO(SearchInitialSpaceAllocationRatioListVO searchInitialSpaceAllocationRatioListVO){
		this. searchInitialSpaceAllocationRatioListVO = searchInitialSpaceAllocationRatioListVO;
	}

	public void setSearchInitialSpaceAllocationRatioListVOS(SearchInitialSpaceAllocationRatioListVO[] searchInitialSpaceAllocationRatioListVOs){
		this. searchInitialSpaceAllocationRatioListVOs = searchInitialSpaceAllocationRatioListVOs;
	}

	public void setSpcInitAlocRtoVO(SpcInitAlocRtoVO spcInitAlocRtoVO){
		this. spcInitAlocRtoVO = spcInitAlocRtoVO;
	}

	public void setSpcInitAlocRtoVOS(SpcInitAlocRtoVO[] spcInitAlocRtoVOs){
		this. spcInitAlocRtoVOs = spcInitAlocRtoVOs;
	}

	public SearchInitialSpaceAllocationRatioListVO getSearchInitialSpaceAllocationRatioListVO(){
		return searchInitialSpaceAllocationRatioListVO;
	}

	public SearchInitialSpaceAllocationRatioListVO[] getSearchInitialSpaceAllocationRatioListVOS(){
		return searchInitialSpaceAllocationRatioListVOs;
	}

	public SpcInitAlocRtoVO getSpcInitAlocRtoVO(){
		return spcInitAlocRtoVO;
	}

	public SpcInitAlocRtoVO[] getSpcInitAlocRtoVOS(){
		return spcInitAlocRtoVOs;
	}

}