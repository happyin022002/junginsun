/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1110Event.java
*@FileTitle : Outbound Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.01 김기종
* 1.0 Creation
* 1.1 2010.09.27 이재위 [CHM-201005253-01] [BKG/DOC] EIR Exchange & Customs Release Check Report 신규개발(ESM_BKG_1110)[SZPBB]
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_1110HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1110Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OutBdEirMovementStatusListVO outBdEirMovementStatusListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OutBdEirMovementStatusListVO[] outBdEirMovementStatusListVOs = null;

	public EsmBkg1110Event(){}
	
	public void setOutBdEirMovementStatusListVO(OutBdEirMovementStatusListVO outBdEirMovementStatusListVO){
		this. outBdEirMovementStatusListVO = outBdEirMovementStatusListVO;
	}

	public OutBdEirMovementStatusListVO getOutBdEirMovementStatusListVO(){
		return outBdEirMovementStatusListVO;
	}

	public OutBdEirMovementStatusListVO[] getOutBdEirMovementStatusListVOs() {
		OutBdEirMovementStatusListVO[] rtnVOs = null;
		if (this.outBdEirMovementStatusListVOs != null) {
			rtnVOs = Arrays.copyOf(outBdEirMovementStatusListVOs,
					outBdEirMovementStatusListVOs.length);
		}
		return rtnVOs;
	}

	public void setOutBdEirMovementStatusListVOs(
			OutBdEirMovementStatusListVO[] outBdEirMovementStatusListVOs) {
		if (outBdEirMovementStatusListVOs != null) {
			OutBdEirMovementStatusListVO[] tmpVOs = Arrays.copyOf(outBdEirMovementStatusListVOs,
					outBdEirMovementStatusListVOs.length);
			this.outBdEirMovementStatusListVOs = tmpVOs;
		}
	}

}