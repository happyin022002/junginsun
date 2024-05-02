/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6055Event.java
*@FileTitle : Revenue Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.29 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InRevenueLaneVO;


/**
 * ESM_PRI_6055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6055HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InRevenueLaneVO inRevenueLaneVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InRevenueLaneVO[] inRevenueLaneVOs = null;

	public EsmPri6055Event(){}
	
	public void setInRevenueLaneVO(InRevenueLaneVO inRevenueLaneVO){
		this. inRevenueLaneVO = inRevenueLaneVO;
	}

	public void setInRevenueLaneVOS(InRevenueLaneVO[] inRevenueLaneVOs){
		this. inRevenueLaneVOs = inRevenueLaneVOs;
	}

	public InRevenueLaneVO getInRevenueLaneVO(){
		return inRevenueLaneVO;
	}

	public InRevenueLaneVO[] getInRevenueLaneVOS(){
		return inRevenueLaneVOs;
	}

}