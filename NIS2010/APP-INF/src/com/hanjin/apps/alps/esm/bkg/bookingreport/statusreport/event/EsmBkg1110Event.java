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
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;


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

//	public void setOutBdEirMovementStatusListVOS(OutBdEirMovementStatusListVO[] outBdEirMovementStatusListVOs){
//		this. outBdEirMovementStatusListVOs = outBdEirMovementStatusListVOs;
//	}

	public OutBdEirMovementStatusListVO getOutBdEirMovementStatusListVO(){
		return outBdEirMovementStatusListVO;
	}

//	public OutBdEirMovementStatusListVO[] getOutBdEirMovementStatusListVOS(){
//		return outBdEirMovementStatusListVOs;
//	}
	
	//2015.03.01 Secure Coding 적용 [CWE-495]
	public OutBdEirMovementStatusListVO[] getOutBdEirMovementStatusListVOS(){
		OutBdEirMovementStatusListVO[] rtnVOs = null;
		if (this.outBdEirMovementStatusListVOs != null) {
			rtnVOs = new OutBdEirMovementStatusListVO[outBdEirMovementStatusListVOs.length];
			System.arraycopy(outBdEirMovementStatusListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.03.01 Secure Coding 적용[CWE-496]
	public void setOutBdEirMovementStatusListVOS(OutBdEirMovementStatusListVO[] outBdEirMovementStatusListVOs){
		if (outBdEirMovementStatusListVOs != null) {
			OutBdEirMovementStatusListVO[] tmpVOs = new OutBdEirMovementStatusListVO[outBdEirMovementStatusListVOs.length];
			System.arraycopy(outBdEirMovementStatusListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.outBdEirMovementStatusListVOs = tmpVOs;
		}
	}			

}