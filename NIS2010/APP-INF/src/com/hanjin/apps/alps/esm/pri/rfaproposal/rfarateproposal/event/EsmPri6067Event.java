/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6067Event.java
*@FileTitle : S/C Proposal/Amendment Cost Detail by Trans. Mode
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.04 송민석
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostDetailByTransModeListVO;

/**
 * ESM_PRI_6067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6067HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri6067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriCostDetailByTransModeListVO[] rsltPriCostDetailByTransModeListVOs = null;

	public EsmPri6067Event(){}
	
	public void setRsltPriCostDetailByTransModeListVO(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO){
		this. rsltPriCostDetailByTransModeListVO = rsltPriCostDetailByTransModeListVO;
	}

	public void setRsltPriCostDetailByTransModeListVOS(RsltPriCostDetailByTransModeListVO[] rsltPriCostDetailByTransModeListVOs){
		if(rsltPriCostDetailByTransModeListVOs != null){
			RsltPriCostDetailByTransModeListVO[] tmpVOs = new RsltPriCostDetailByTransModeListVO[rsltPriCostDetailByTransModeListVOs.length];
			System.arraycopy(rsltPriCostDetailByTransModeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriCostDetailByTransModeListVOs = tmpVOs;
		}
	}

	public RsltPriCostDetailByTransModeListVO getRsltPriCostDetailByTransModeListVO(){
		return rsltPriCostDetailByTransModeListVO;
	}

	public RsltPriCostDetailByTransModeListVO[] getRsltPriCostDetailByTransModeListVOS(){
		RsltPriCostDetailByTransModeListVO[] rtnVOs = null;
		if (this.rsltPriCostDetailByTransModeListVOs != null) {
			rtnVOs = new RsltPriCostDetailByTransModeListVO[rsltPriCostDetailByTransModeListVOs.length];
			System.arraycopy(rsltPriCostDetailByTransModeListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}