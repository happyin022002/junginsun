/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPri000203Event.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.01 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgroupcommodityguideline.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSgGrpCmdtVO;


/**
 * ESM_PRI_0002_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0002_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0002_03HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000203Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgGrpCmdtVO priSgGrpCmdtVO = null;
	
	public EsmPri000203Event(){}
	
	public void setPriSgGrpCmdtVO(PriSgGrpCmdtVO priSgGrpCmdtVO){
		this. priSgGrpCmdtVO = priSgGrpCmdtVO;
	}

	public PriSgGrpCmdtVO getPriSgGrpCmdtVO(){
		return priSgGrpCmdtVO;
	}

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgGrpCmdtDtlVO priSgGrpCmdtDtlVO = null;
		
	public void setPriSgGrpCmdtDtlVO(PriSgGrpCmdtDtlVO priSgGrpCmdtDtlVO){
		this. priSgGrpCmdtDtlVO = priSgGrpCmdtDtlVO;
	}

	public PriSgGrpCmdtDtlVO getPriSgGrpCmdtDtlVO(){
		return priSgGrpCmdtDtlVO;
	}
}