/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0062Event.java
*@FileTitle : S/C List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.31 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_0062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh Kim
 * @see ESM_PRI_0062HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0062Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCListVO rsltSearchSCListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCListVO[] rsltSearchSCListVOs = null;

	
	public EsmPri0062Event(){}
	
	/* set */
	public void setRsltSearchSCListVO(RsltSearchSCListVO rsltSearchSCListVO){
		this.rsltSearchSCListVO = rsltSearchSCListVO;
	}
	public void setRsltSearchSCListVOS(RsltSearchSCListVO[] rsltSearchSCListVO){
		if (rsltSearchSCListVO != null) {
			RsltSearchSCListVO[] tmpVOs = new RsltSearchSCListVO[rsltSearchSCListVO.length];
			System.arraycopy(rsltSearchSCListVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCListVOs = tmpVOs;
		}
	}
	
	/* get */
	public RsltSearchSCListVO getRsltSearchSCListVO(){
		return rsltSearchSCListVO;
	}
	public RsltSearchSCListVO[] getRsltSearchSCListVOS(){
		RsltSearchSCListVO[] tmpVOs = null;
		if (this.rsltSearchSCListVOs != null) {
			tmpVOs = new RsltSearchSCListVO[rsltSearchSCListVOs.length];
			System.arraycopy(rsltSearchSCListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}