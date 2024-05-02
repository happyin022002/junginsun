/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf2019Event.java
*@FileTitle : CBF Summary Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.27 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFAllSummaryPreviewVO;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_2023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_2023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see VOP_OPF_2023HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf2023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFAllSummaryPreviewVO cBFAllSummaryPreviewVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private CBFAllSummaryPreviewVO[] cBFAllSummaryPreviewVOs = null;


	public VopOpf2023Event(){}
	
	public void setCBFAllSummaryPreviewVO(CBFAllSummaryPreviewVO cBFAllSummaryPreviewVO){
		this. cBFAllSummaryPreviewVO = cBFAllSummaryPreviewVO;
	}

	public void setCBFAllSummaryPreviewVOS(CBFAllSummaryPreviewVO[] cBFAllSummaryPreviewVOs){
		if (cBFAllSummaryPreviewVOs != null) {
			CBFAllSummaryPreviewVO[] tmpVOs = new CBFAllSummaryPreviewVO[cBFAllSummaryPreviewVOs.length];
			System.arraycopy(cBFAllSummaryPreviewVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cBFAllSummaryPreviewVOs = tmpVOs;
		}		
	}


	public CBFAllSummaryPreviewVO getCBFAllSummaryPreviewVO(){
		return cBFAllSummaryPreviewVO;
	}


	public CBFAllSummaryPreviewVO[] getCBFAllSummaryPreviewVOS(){
		CBFAllSummaryPreviewVO[] rtnVOs = null;
		
		if (this.cBFAllSummaryPreviewVOs != null) {
			rtnVOs = new CBFAllSummaryPreviewVO[cBFAllSummaryPreviewVOs.length];
			System.arraycopy(cBFAllSummaryPreviewVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;	
	}


}