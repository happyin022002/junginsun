/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0019Event.java
*@FileTitle : Maximum L/F Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.08.12 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO; 
import com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.vo.SearchMaxLoadFactorListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcMaxLodFctrVO;


/**
 * ESM_SPC_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HJ.LEE
 * @see ESM_SPC_0019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ConditionVO conditionVO =  null;		

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcMaxLodFctrVO spcMaxLodFctrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcMaxLodFctrVO[] spcMaxLodFctrVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMaxLoadFactorListVO searchMaxLoadFactorListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMaxLoadFactorListVO[] searchMaxLoadFactorListVOs = null;

	public EsmSpc0019Event(){}
	
	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	} 
	
	public void setSpcMaxLodFctrVO(SpcMaxLodFctrVO spcMaxLodFctrVO){
		this. spcMaxLodFctrVO = spcMaxLodFctrVO;
	}

	public void setSpcMaxLodFctrVOS(SpcMaxLodFctrVO[] spcMaxLodFctrVOs){
		this. spcMaxLodFctrVOs = spcMaxLodFctrVOs;
	}

	public void setSearchMaxLoadFactorListVO(SearchMaxLoadFactorListVO searchMaxLoadFactorListVO){
		this. searchMaxLoadFactorListVO = searchMaxLoadFactorListVO;
	}

	public void setSearchMaxLoadFactorListVOS(SearchMaxLoadFactorListVO[] searchMaxLoadFactorListVOs){
		this. searchMaxLoadFactorListVOs = searchMaxLoadFactorListVOs;
	}

	public SpcMaxLodFctrVO getSpcMaxLodFctrVO(){
		return spcMaxLodFctrVO;
	}

	public SpcMaxLodFctrVO[] getSpcMaxLodFctrVOS(){
		return spcMaxLodFctrVOs;
	}

	public SearchMaxLoadFactorListVO getSearchMaxLoadFactorListVO(){
		return searchMaxLoadFactorListVO;
	}

	public SearchMaxLoadFactorListVO[] getSearchMaxLoadFactorListVOS(){
		return searchMaxLoadFactorListVOs;
	}

}