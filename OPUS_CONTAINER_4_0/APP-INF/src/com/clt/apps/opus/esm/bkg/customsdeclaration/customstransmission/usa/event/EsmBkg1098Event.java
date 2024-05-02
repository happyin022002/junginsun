/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0253Event.java
*@FileTitle : Equalization Port 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.03 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.ESM_BKG_0253HTMLAction;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.BaplieAlarmSetupVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0253 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0253HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0253HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1098Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	private String strLocCd = null;
	private String strSlanCd = null;
	private String strUsrId = null;
	
	public String getStrLocCd() {
		return strLocCd;
	}

	public void setStrLocCd(String strLocCd) {
		this.strLocCd = strLocCd;
	}

	public String getStrSlanCd() {
		return strSlanCd;
	}

	public void setStrSlanCd(String strSlanCd) {
		this.strSlanCd = strSlanCd;
	}

	public String getStrUsrId() {
		return strUsrId;
	}

	public void setStrUsrId(String strUsrId) {
		this.strUsrId = strUsrId;
	}


	/** Table Value Object 조회 조건 및 단건 처리  */
	private BaplieAlarmSetupVO baplieAlarmSetupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BaplieAlarmSetupVO[] baplieAlarmSetupVOs = null;

	public EsmBkg1098Event(){}
	
	public void setBaplieAlarmSetupVO(BaplieAlarmSetupVO baplieAlarmSetupVO){
		this.baplieAlarmSetupVO = baplieAlarmSetupVO;
	}

	public void setBaplieAlarmSetupVOs(BaplieAlarmSetupVO[] baplieAlarmSetupVOs){
		if (baplieAlarmSetupVOs != null)
			this.baplieAlarmSetupVOs = Arrays.copyOf(baplieAlarmSetupVOs, baplieAlarmSetupVOs.length);;
	}

	public BaplieAlarmSetupVO getBaplieAlarmSetupVO(){
		return baplieAlarmSetupVO;
	}

	public BaplieAlarmSetupVO[] getBaplieAlarmSetupVOs(){
		BaplieAlarmSetupVO[] rtnVOs = null;
		if (baplieAlarmSetupVOs != null)
			rtnVOs = Arrays.copyOf(baplieAlarmSetupVOs, baplieAlarmSetupVOs.length);
		return rtnVOs;
	}

}