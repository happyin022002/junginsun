/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri204103Event.java
*@FileTitle : Amendment History - Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.event;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRpScpGrpCmdtVO;


/**
 * ESM_PRI_2041_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2041_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_2041_03HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri204103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpGrpCmdtVO priRpScpGrpCmdtVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltGrpCmdtDtlListVO rsltGrpCmdtDtlListVO = null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltGrpCmdtListVO rsltGrpCmdtListVO = null;
		
	public EsmPri204103Event(){}
	
	public void setPriRpScpGrpCmdtDtlVO(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO){
		this. priRpScpGrpCmdtDtlVO = priRpScpGrpCmdtDtlVO;
	}
	public void setPriRpScpGrpCmdtVO(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO){
		this. priRpScpGrpCmdtVO = priRpScpGrpCmdtVO;
	}

	public PriRpScpGrpCmdtDtlVO getPriRpScpGrpCmdtDtlVO(){
		return priRpScpGrpCmdtDtlVO;
	}


	public PriRpScpGrpCmdtVO getPriRpScpGrpCmdtVO(){
		return priRpScpGrpCmdtVO;
	}

	/**
	 * @return the rsltGrpCmdtDtlListVO
	 */
	public RsltGrpCmdtDtlListVO getRsltGrpCmdtDtlListVO() {
		return rsltGrpCmdtDtlListVO;
	}

	/**
	 * @return the rsltGrpCmdtListVO
	 */
	public RsltGrpCmdtListVO getRsltGrpCmdtListVO() {
		return rsltGrpCmdtListVO;
	}

	/**
	 * @param rsltGrpCmdtDtlListVO the rsltGrpCmdtDtlListVO to set
	 */
	public void setRsltGrpCmdtDtlListVO(RsltGrpCmdtDtlListVO rsltGrpCmdtDtlListVO) {
		this.rsltGrpCmdtDtlListVO = rsltGrpCmdtDtlListVO;
	}

	/**
	 * @param rsltGrpCmdtListVO the rsltGrpCmdtListVO to set
	 */
	public void setRsltGrpCmdtListVO(RsltGrpCmdtListVO rsltGrpCmdtListVO) {
		this.rsltGrpCmdtListVO = rsltGrpCmdtListVO;
	}

	
	

}