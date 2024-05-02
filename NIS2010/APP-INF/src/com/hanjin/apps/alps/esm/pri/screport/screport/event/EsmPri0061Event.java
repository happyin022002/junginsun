/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0061Event.java
*@FileTitle : S/C Retrieval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.30 변영주
* 1.0 Creation
* =========================================================
* History
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropMnDlRecVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpMnVO;


/**
 * ESM_PRI_0061 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0061HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0061Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpMnVO[] priSpMnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPropMnDlRecVO rsltPropMnDlRecVO = null;

	public EsmPri0061Event(){}
	
	public void setPriSpMnVO(PriSpMnVO priSpMnVO){
		this. priSpMnVO = priSpMnVO;
	}

	public void setPriSpMnVOS(PriSpMnVO[] priSpMnVOs){
		if(priSpMnVOs != null){
			PriSpMnVO[] tmpVOs = new PriSpMnVO[priSpMnVOs.length];
			System.arraycopy(priSpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpMnVOs = tmpVOs;
		}
	}

	public void setRsltPropMnDlRecVO(RsltPropMnDlRecVO rsltPropMnDlRecVO){
		this.rsltPropMnDlRecVO = rsltPropMnDlRecVO;
	}
	
	public PriSpMnVO getPriSpMnVO(){
		return priSpMnVO;
	}

	public PriSpMnVO[] getPriSpMnVOS(){
		PriSpMnVO[] rtnVOs = null;
		if (this.priSpMnVOs != null) {
			rtnVOs = new PriSpMnVO[priSpMnVOs.length];
			System.arraycopy(priSpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public RsltPropMnDlRecVO getRsltPropMnDlRecVO(){
		return rsltPropMnDlRecVO;
	}	

}