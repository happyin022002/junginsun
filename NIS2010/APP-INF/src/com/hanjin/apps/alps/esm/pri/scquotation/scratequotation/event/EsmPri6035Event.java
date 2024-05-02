/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6078Event.java
*@FileTitle : Surcharge Adjust-Commodity
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.08 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSqRtCmdtHdrVO;


/**
 * ESM_PRI_6035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSqRtCmdtHdrVO priSqRtCmdtHdrVO = null;
	
	
	public EsmPri6035Event(){}


	/**
	 * @return the priSqRtCmdtHdrVO
	 */
	public PriSqRtCmdtHdrVO getPriSqRtCmdtHdrVO() {
		return priSqRtCmdtHdrVO;
	}


	/**
	 * @param priSqRtCmdtHdrVO the priSqRtCmdtHdrVO to set
	 */
	public void setPriSqRtCmdtHdrVO(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) {
		this.priSqRtCmdtHdrVO = priSqRtCmdtHdrVO;
	}
	
	
}