/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri201802Event.java
*@FileTitle : RFA Guideline Inquiry - Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.21 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRgGrpCmdtVO;


/**
 * ESM_PRI_2001_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2001_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_2001_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri201802Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgGrpCmdtDtlVO priSgGrpCmdtDtlVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRgGrpCmdtVO priSgGrpCmdtVO = null;
	

	public EsmPri201802Event(){}
	
	public void setPriRgGrpCmdtVO(PriRgGrpCmdtVO priSgGrpCmdtVO){
		this. priSgGrpCmdtVO = priSgGrpCmdtVO;
	}


	public PriRgGrpCmdtVO getPriRgGrpCmdtVO(){
		return priSgGrpCmdtVO;
	}
	
	
	public void setPriRgGrpCmdtDtlVO(PriRgGrpCmdtDtlVO priSgGrpCmdtDtlVO){
		this. priSgGrpCmdtDtlVO = priSgGrpCmdtDtlVO;
	}

	public PriRgGrpCmdtDtlVO getPriRgGrpCmdtDtlVO(){
		return priSgGrpCmdtDtlVO;
	}

}