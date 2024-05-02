/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0025Event.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.RsltAfilListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_0057_09 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057_09HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0057_09HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri005709Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltAfilListVO rsltAfilListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltAfilListVO[] rsltAfilListVOs = null;

	public EsmPri005709Event(){}
	
	/* set */
	public void setRsltAfilListVO(RsltAfilListVO rsltAfilListVO){
		this. rsltAfilListVO = rsltAfilListVO;
	}
	public void setRsltAfilListVOS(RsltAfilListVO[] rsltAfilListVOs){
		if (rsltAfilListVOs != null) {
			RsltAfilListVO[] tmpVOs = new RsltAfilListVO[rsltAfilListVOs.length];
			System.arraycopy(rsltAfilListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltAfilListVOs = tmpVOs;
		}
	}

	/* get */
	public RsltAfilListVO getRsltAfilListVO(){
		return rsltAfilListVO;
	}
	public RsltAfilListVO[] getRsltAfilListVOS(){
		RsltAfilListVO[] tmpVOs = null;
		if (this.rsltAfilListVOs != null) {
			tmpVOs = new RsltAfilListVO[rsltAfilListVOs.length];
			System.arraycopy(rsltAfilListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}