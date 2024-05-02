/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6077Event.java
*@FileTitle : SC CM/OP View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.17 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.PriRqRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRqRtCmdtRoutVO;


/**
 * ESM_PRI_6077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6077Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRqRtCmdtRoutVO priRqRtCmdtRoutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRqRtCmdtRoutVO[] priRqRtCmdtRoutVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRateCmViewAllVO[] rsltPriRateCmViewAllVOs = null;
	
	/** Table Value와 그외 변수를 member로 갖는 VO */
	private PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO = null;

	public EsmPri6077Event(){}
	
	public void setPriRqRtCmdtRoutVO(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO){
		this. priRqRtCmdtRoutVO = priRqRtCmdtRoutVO;
	}

	public void setPriRqRtCmdtRoutVOS(PriRqRtCmdtRoutVO[] priRqRtCmdtRoutVOs){
		this. priRqRtCmdtRoutVOs = priRqRtCmdtRoutVOs;
	}
	
	
	public void setPriRqRtCmdtRoutSetVO(PriRqRtCmdtRoutSetVO priRqRtCmdtRoutSetVO){
		this. priRqRtCmdtRoutSetVO = priRqRtCmdtRoutSetVO;
	}	

	public void setRsltPriRateCmViewAllVO(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO){
		this.rsltPriRateCmViewAllVO = rsltPriRateCmViewAllVO;
	}

	public void setRsltPriRateCmViewAllVOS(RsltPriRateCmViewAllVO[] rsltPriRateCmViewAllVOs){
		this. rsltPriRateCmViewAllVOs = rsltPriRateCmViewAllVOs;
	}

	public PriRqRtCmdtRoutVO getPriRqRtCmdtRoutVO(){
		return priRqRtCmdtRoutVO;
	}

	public PriRqRtCmdtRoutVO[] getPriRqRtCmdtRoutVOS(){
		return priRqRtCmdtRoutVOs;
	}
	public PriRqRtCmdtRoutSetVO getPriRqRtCmdtRoutSetVO(){
		return priRqRtCmdtRoutSetVO;
	}	

	public RsltPriRateCmViewAllVO getRsltPriRateCmViewAllVO(){
		return rsltPriRateCmViewAllVO;
	}

	public RsltPriRateCmViewAllVO[] getRsltPriRateCmViewAllVOS(){
		return rsltPriRateCmViewAllVOs;
	}
 
}