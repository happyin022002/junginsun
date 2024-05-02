/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri6088Event.java
*@FileTitle : SC Quotation Surcharge View All
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.21 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSqRtCmdtHdrVO;


/**
 * ESM_PRI_6088 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6088HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6088Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSqRtCmdtHdrVO priSqRtCmdtHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSqRtCmdtHdrVO[] priSqRtCmdtHdrVOs = null;

	public EsmPri6088Event(){}
	
	public void setPriSqRtCmdtHdrVO(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO){
		this. priSqRtCmdtHdrVO = priSqRtCmdtHdrVO;
	}

	public void setPriSqRtCmdtHdrVOS(PriSqRtCmdtHdrVO[] priSqRtCmdtHdrVOs){
		this. priSqRtCmdtHdrVOs = priSqRtCmdtHdrVOs;
	}

	public PriSqRtCmdtHdrVO getPriSqRtCmdtHdrVO(){
		return priSqRtCmdtHdrVO;
	}

	public PriSqRtCmdtHdrVO[] getPriSqRtCmdtHdrVOS(){
		return priSqRtCmdtHdrVOs;
	}

}