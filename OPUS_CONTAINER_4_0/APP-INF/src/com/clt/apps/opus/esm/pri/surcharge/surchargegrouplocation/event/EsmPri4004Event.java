/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4004Event.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.06 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.event;

import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.SurchargeGroupLocationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_4004HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri4004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	SurchargeGroupLocationVO surchargeGroupLocationVO = new SurchargeGroupLocationVO();

	public EsmPri4004Event(){}

	
	public SurchargeGroupLocationVO getSurchargeGroupLocationVO() {
		return surchargeGroupLocationVO;
	}

	public void setSurchargeGroupLocationVO(
			SurchargeGroupLocationVO surchargeGroupLocationVO) {
		this.surchargeGroupLocationVO = surchargeGroupLocationVO;
	}


}