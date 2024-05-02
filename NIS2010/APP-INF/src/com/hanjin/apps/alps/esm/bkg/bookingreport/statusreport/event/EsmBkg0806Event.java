/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0806Event.java
*@FileTitle : Loading Confirmation by Shipper Preview And Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.06 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;


/**
 * ESM_BKG_0806 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0806HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0806HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0806Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OutBdMovementStsListInVO outBdMovementStsListInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OutBdMovementStsListInVO[] outBdMovementStsListInVOs = null;

	public EsmBkg0806Event(){}
	
	public void setOutBdMovementStsListInVO(OutBdMovementStsListInVO outBdMovementStsListInVO){
		this. outBdMovementStsListInVO = outBdMovementStsListInVO;
	}

	public void setOutBdMovementStsListInVOS(OutBdMovementStsListInVO[] outBdMovementStsListInVOs){
		this. outBdMovementStsListInVOs = outBdMovementStsListInVOs;
	}

	public OutBdMovementStsListInVO getOutBdMovementStsListInVO(){
		return outBdMovementStsListInVO;
	}

	public OutBdMovementStsListInVO[] getOutBdMovementStsListInVOS(){
		return outBdMovementStsListInVOs;
	}

}