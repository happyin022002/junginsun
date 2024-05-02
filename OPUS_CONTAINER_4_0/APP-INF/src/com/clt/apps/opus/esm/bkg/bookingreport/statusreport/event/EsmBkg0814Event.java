/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0814Event.java
*@FileTitle : Outbound Container Movement Status by Yard Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.09.09 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0814 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0814HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0814HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0814Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OutBdMovementStsListInVO outBdMovementStsListInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OutBdMovementStsListInVO[] outBdMovementStsListInVOs = null;

	public EsmBkg0814Event(){}
	
	public void setOutBdMovementStsListInVO(OutBdMovementStsListInVO outBdMovementStsListInVO){
		this. outBdMovementStsListInVO = outBdMovementStsListInVO;
	}

	public OutBdMovementStsListInVO getOutBdMovementStsListInVO(){
		return outBdMovementStsListInVO;
	}

	public OutBdMovementStsListInVO[] getOutBdMovementStsListInVOs() {
		OutBdMovementStsListInVO[] rtnVOs = null;
		if (this.outBdMovementStsListInVOs != null) {
			rtnVOs = Arrays.copyOf(outBdMovementStsListInVOs,
					outBdMovementStsListInVOs.length);
		}
		return rtnVOs;
	}

	public void setOutBdMovementStsListInVOs(OutBdMovementStsListInVO[] outBdMovementStsListInVOs) {
		if(outBdMovementStsListInVOs != null){
			OutBdMovementStsListInVO[] tmpVOs = Arrays.copyOf(outBdMovementStsListInVOs, outBdMovementStsListInVOs.length);
			this.outBdMovementStsListInVOs = tmpVOs;
		}
	}

}