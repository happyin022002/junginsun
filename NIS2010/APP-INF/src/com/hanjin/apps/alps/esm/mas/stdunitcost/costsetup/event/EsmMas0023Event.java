/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmMas0023Event.java
*@FileTitle : General Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.09.26 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.GeneralExpenseVO;


/**
 * ESM_MAS_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sung-Min CHOI
 * @see ESM_MAS_0023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private GeneralExpenseVO generalExpenseVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private GeneralExpenseVO[] generalExpenseVOs = null;

	public EsmMas0023Event(){}
	
	public void setGeneralExpenseVO(GeneralExpenseVO generalExpenseVO){
		this. generalExpenseVO = generalExpenseVO;
	}

	public void setGeneralExpenseVOS(GeneralExpenseVO[] generalExpenseVOs){
		this. generalExpenseVOs = generalExpenseVOs;
	}

	public GeneralExpenseVO getGeneralExpenseVO(){
		return generalExpenseVO;
	}

	public GeneralExpenseVO[] getGeneralExpenseVOS(){
		return generalExpenseVOs;
	}

}