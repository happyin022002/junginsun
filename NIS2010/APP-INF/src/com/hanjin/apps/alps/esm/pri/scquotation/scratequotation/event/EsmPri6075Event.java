/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6075Event.java
*@FileTitle : SC CM/OP View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.17 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;

import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.PriSqRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;


/**
 * ESM_PRI_6075 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6075HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6075HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6075Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSqRtCmdtRoutVO priSqRtCmdtRoutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSqRtCmdtRoutVO[] priSqRtCmdtRoutVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRateCmViewAllVO[] rsltPriRateCmViewAllVOs = null;
	
	/** Table Value와 그외 변수를 member로 갖는 VO */
	private PriSqRtCmdtRoutSetVO priSqRtCmdtRoutSetVO = null;

	public EsmPri6075Event(){}
	
	public void setPriSqRtCmdtRoutVO(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO){
		this. priSqRtCmdtRoutVO = priSqRtCmdtRoutVO;
	}

	public void setPriSqRtCmdtRoutVOS(PriSqRtCmdtRoutVO[] priSqRtCmdtRoutVOs){
		this. priSqRtCmdtRoutVOs = priSqRtCmdtRoutVOs;
	}
	
	public void setPriSqRtCmdtRoutSetVO(PriSqRtCmdtRoutSetVO priSqRtCmdtRoutSetVO){
		this. priSqRtCmdtRoutSetVO = priSqRtCmdtRoutSetVO;
	}	

	public void setRsltPriRateCmViewAllVO(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO){
		this.rsltPriRateCmViewAllVO = rsltPriRateCmViewAllVO;
	}

	public void setRsltPriRateCmViewAllVOS(RsltPriRateCmViewAllVO[] rsltPriRateCmViewAllVOs){
		this. rsltPriRateCmViewAllVOs = rsltPriRateCmViewAllVOs;
	}

	public PriSqRtCmdtRoutVO getPriSqRtCmdtRoutVO(){
		return priSqRtCmdtRoutVO;
	}

	public PriSqRtCmdtRoutVO[] getPriSqRtCmdtRoutVOS(){
		return priSqRtCmdtRoutVOs;
	}
	public PriSqRtCmdtRoutSetVO getPriSqRtCmdtRoutSetVO(){
		return priSqRtCmdtRoutSetVO;
	}	

	public RsltPriRateCmViewAllVO getRsltPriRateCmViewAllVO(){
		return rsltPriRateCmViewAllVO;
	}

	public RsltPriRateCmViewAllVO[] getRsltPriRateCmViewAllVOS(){
		return rsltPriRateCmViewAllVOs;
	}
 
 
}