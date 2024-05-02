/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6047Event.java
*@FileTitle : S/C Proposal/Amendment CMPB/OPB View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.12 송민석
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmpbViewAllListVO;


/**
 * ESM_PRI_6047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6047HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri6047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriRateCmpbViewAllListVO[] rsltPriRateCmpbViewAllListVOs = null;

	public EsmPri6047Event(){}
	
	public void setRsltPriRateCmpbViewAllListVO(RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO){
		this. rsltPriRateCmpbViewAllListVO = rsltPriRateCmpbViewAllListVO;
	}

	public void setRsltPriRateCmpbViewAllListVOS(RsltPriRateCmpbViewAllListVO[] rsltPriRateCmpbViewAllListVOs){
		if(rsltPriRateCmpbViewAllListVOs != null){
			RsltPriRateCmpbViewAllListVO[] tmpVOs = new RsltPriRateCmpbViewAllListVO[rsltPriRateCmpbViewAllListVOs.length];
			System.arraycopy(rsltPriRateCmpbViewAllListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriRateCmpbViewAllListVOs = tmpVOs;
		}
	}

	public RsltPriRateCmpbViewAllListVO getRsltPriRateCmpbViewAllListVO(){
		return rsltPriRateCmpbViewAllListVO;
	}

	public RsltPriRateCmpbViewAllListVO[] getRsltPriRateCmpbViewAllListVOS(){
		RsltPriRateCmpbViewAllListVO[] rtnVOs = null;
		if (this.rsltPriRateCmpbViewAllListVOs != null) {
			rtnVOs = new RsltPriRateCmpbViewAllListVO[rsltPriRateCmpbViewAllListVOs.length];
			System.arraycopy(rsltPriRateCmpbViewAllListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}