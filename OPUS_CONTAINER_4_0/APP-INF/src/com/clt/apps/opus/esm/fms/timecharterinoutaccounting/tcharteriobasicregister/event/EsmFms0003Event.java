/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0003Event.java
*@FileTitle : Account Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.21 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctCateVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomAcctCateVO customacctcatevo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomAcctCateVO[] customacctcatevos = null;

	public EsmFms0003Event(){}
	
	public void setCustomAcctCateVO(CustomAcctCateVO customacctcatevo){
		this. customacctcatevo = customacctcatevo;
	}

	public void setCustomAcctCateVOS(CustomAcctCateVO[] customacctcatevos){
		if (customacctcatevos != null) {
			CustomAcctCateVO[] tmpVOs = new CustomAcctCateVO[customacctcatevos.length];
			System.arraycopy(customacctcatevos, 0, tmpVOs, 0, tmpVOs.length);
			this.customacctcatevos = tmpVOs;
		}
	}

	public CustomAcctCateVO getCustomAcctCateVO(){
		return customacctcatevo;
	}

	public CustomAcctCateVO[] getCustomAcctCateVOS(){
		CustomAcctCateVO[] tmpVOs = null;
		if (this.customacctcatevos != null) {
			tmpVOs = new CustomAcctCateVO[customacctcatevos.length];
			System.arraycopy(customacctcatevos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}