/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0021Event.java
*@FileTitle : Own Container Booking Forecast Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.07.07 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFSummaryVO;


/**
 * VOP_OPF_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ji Seok Woo
 * @see VOP_OPF_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CBFSummaryVO cBFSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CBFSummaryVO[] cBFSummaryVOs = null;

	public VopOpf0021Event(){}
	
	public void setCBFSummaryVO(CBFSummaryVO cBFSummaryVO){
		this. cBFSummaryVO = cBFSummaryVO;
	}

	public void setCBFSummaryVOS(CBFSummaryVO[] cBFSummaryVOs){
		if (cBFSummaryVOs != null) {
			CBFSummaryVO[] tmpVOs = new CBFSummaryVO[cBFSummaryVOs.length];
			System.arraycopy(cBFSummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cBFSummaryVOs = tmpVOs;
		}
	}

	public CBFSummaryVO getCBFSummaryVO(){
		return cBFSummaryVO;
	}

	public CBFSummaryVO[] getCBFSummaryVOS(){
		CBFSummaryVO[] rtnVOs = null;
		
		if (this.cBFSummaryVOs != null) {
			rtnVOs = new CBFSummaryVO[cBFSummaryVOs.length];
			System.arraycopy(cBFSummaryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}		
		return rtnVOs;	
	}

}