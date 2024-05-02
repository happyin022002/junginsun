/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0069Event.java
*@FileTitle : Item Detail Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.20
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.20 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctItmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0069HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0069Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** acctCd Account Code */
	private String acctCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomAcctItmVO customacctitmvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomAcctItmVO[] customacctitmvos = null;

	public EsmFms0069Event(){}
	
	public void setCustomAcctItmVO(CustomAcctItmVO customacctitmvo){
		this. customacctitmvo = customacctitmvo;
	}

	public void setCustomAcctItmVOS(CustomAcctItmVO[] customacctitmvos){
		if (customacctitmvos != null) {
			CustomAcctItmVO[] tmpVOs = new CustomAcctItmVO[customacctitmvos.length];
			System.arraycopy(customacctitmvos, 0, tmpVOs, 0, tmpVOs.length);
			this.customacctitmvos = tmpVOs;
		}
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}

	public CustomAcctItmVO getCustomAcctItmVO(){
		return customacctitmvo;
	}

	public CustomAcctItmVO[] getCustomAcctItmVOS(){
		CustomAcctItmVO[] tmpVOs = null;
		if (this.customacctitmvos != null) {
			tmpVOs = new CustomAcctItmVO[customacctitmvos.length];
			System.arraycopy(customacctitmvos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public String getAcctCd() {
		return acctCd;
	}

}