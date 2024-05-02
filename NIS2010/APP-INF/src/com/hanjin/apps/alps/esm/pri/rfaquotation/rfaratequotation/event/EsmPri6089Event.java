/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri6089Event.java
*@FileTitle : RFA Quotation Surcharge View All
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.21 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRqRtCmdtHdrVO;


/**
 * ESM_PRI_6089 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6089HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6089HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6089Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRqRtCmdtHdrVO[] priRqRtCmdtHdrVOs = null;

	public EsmPri6089Event(){}
	
	public void setPriRqRtCmdtHdrVO(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO){
		this. priRqRtCmdtHdrVO = priRqRtCmdtHdrVO;
	}

	public void setPriRqRtCmdtHdrVOS(PriRqRtCmdtHdrVO[] priRqRtCmdtHdrVOs){
		this. priRqRtCmdtHdrVOs = priRqRtCmdtHdrVOs;
	}

	public PriRqRtCmdtHdrVO getPriRqRtCmdtHdrVO(){
		return priRqRtCmdtHdrVO;
	}

	public PriRqRtCmdtHdrVO[] getPriRqRtCmdtHdrVOS(){
		return priRqRtCmdtHdrVOs;
	}

}