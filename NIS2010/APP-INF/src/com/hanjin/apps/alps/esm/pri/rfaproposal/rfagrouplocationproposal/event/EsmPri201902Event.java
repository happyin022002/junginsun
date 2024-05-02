/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri201902Event.java
*@FileTitle : RFA Proposal Inquiry - Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocVO;


/**
 * ESM_PRI_2019_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2019_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_2019_02HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri201902Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpGrpLocVO priRpScpGrpLocVO = null;
	
	public EsmPri201902Event(){}
	
	public void setPriRpScpGrpLocDtlVO(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO){
		this. priRpScpGrpLocDtlVO = priRpScpGrpLocDtlVO;
	}

	public void setPriRpScpGrpLocVO(PriRpScpGrpLocVO priRpScpGrpLocVO){
		this. priRpScpGrpLocVO = priRpScpGrpLocVO;
	}

	public PriRpScpGrpLocDtlVO getPriRpScpGrpLocDtlVO(){
		return priRpScpGrpLocDtlVO;
	}

	public PriRpScpGrpLocVO getPriRpScpGrpLocVO(){
		return priRpScpGrpLocVO;
	}

}