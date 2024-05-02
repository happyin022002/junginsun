/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri000103Event.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.event;

import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;


/**
 * ESM_PRI_0001_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0001_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0001_03HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	private GrpCmdtGlineVO grpCmdtGlineVO = null;
	
	public GrpCmdtGlineVO getGrpCmdtGlineVO() {
		return grpCmdtGlineVO;
	}

	public void setGrpCmdtGlineVO(GrpCmdtGlineVO grpCmdtGlineVO) {
		this.grpCmdtGlineVO = grpCmdtGlineVO;
	}
	
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgGrpCmdtVO priSgGrpCmdtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgGrpCmdtVO[] priSgGrpCmdtVOs = null;

	public EsmPri000103Event(){}
	
	public void setPriSgGrpCmdtVO(PriSgGrpCmdtVO priSgGrpCmdtVO){
		this. priSgGrpCmdtVO = priSgGrpCmdtVO;
	}

	public void setPriSgGrpCmdtVOS(PriSgGrpCmdtVO[] priSgGrpCmdtVOs){
		this. priSgGrpCmdtVOs = priSgGrpCmdtVOs;
	}

	public PriSgGrpCmdtVO getPriSgGrpCmdtVO(){
		return priSgGrpCmdtVO;
	}

	public PriSgGrpCmdtVO[] getPriSgGrpCmdtVOS(){
		return priSgGrpCmdtVOs;
	}
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgGrpCmdtDtlVO priSgGrpCmdtDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOs = null;


	
	public void setPriSgGrpCmdtDtlVO(PriSgGrpCmdtDtlVO priSgGrpCmdtDtlVO){
		this. priSgGrpCmdtDtlVO = priSgGrpCmdtDtlVO;
	}

	public void setPriSgGrpCmdtDtlVOS(PriSgGrpCmdtDtlVO[] priSgGrpCmdtDtlVOs){
		this. priSgGrpCmdtDtlVOs = priSgGrpCmdtDtlVOs;
	}

	public PriSgGrpCmdtDtlVO getPriSgGrpCmdtDtlVO(){
		return priSgGrpCmdtDtlVO;
	}

	public PriSgGrpCmdtDtlVO[] getPriSgGrpCmdtDtlVOS(){
		return priSgGrpCmdtDtlVOs;
	}	

}