/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0015Event.java
*@FileTitle : No-Show Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcNshwRfltVO;
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.vo.SearchNoShowReflectionListVO;


/**
 * ESM_SPC_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcNshwRfltVO spcNshwRfltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcNshwRfltVO[] spcNshwRfltVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNoShowReflectionListVO searchNoShowReflectionListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchNoShowReflectionListVO[] searchNoShowReflectionListVOs = null;

	public EsmSpc0015Event(){}
	
	public void setSpcNshwRfltVO(SpcNshwRfltVO spcNshwRfltVO){
		this. spcNshwRfltVO = spcNshwRfltVO;
	}

	public void setSpcNshwRfltVOS(SpcNshwRfltVO[] spcNshwRfltVOs){
		this. spcNshwRfltVOs = spcNshwRfltVOs;
	}

	public void setSearchNoShowReflectionListVO(SearchNoShowReflectionListVO searchNoShowReflectionListVO){
		this. searchNoShowReflectionListVO = searchNoShowReflectionListVO;
	}

	public void setSearchNoShowReflectionListVOS(SearchNoShowReflectionListVO[] searchNoShowReflectionListVOs){
		this. searchNoShowReflectionListVOs = searchNoShowReflectionListVOs;
	}

	public SpcNshwRfltVO getSpcNshwRfltVO(){
		return spcNshwRfltVO;
	}

	public SpcNshwRfltVO[] getSpcNshwRfltVOS(){
		return spcNshwRfltVOs;
	}

	public SearchNoShowReflectionListVO getSearchNoShowReflectionListVO(){
		return searchNoShowReflectionListVO;
	}

	public SearchNoShowReflectionListVO[] getSearchNoShowReflectionListVOS(){
		return searchNoShowReflectionListVOs;
	}

}