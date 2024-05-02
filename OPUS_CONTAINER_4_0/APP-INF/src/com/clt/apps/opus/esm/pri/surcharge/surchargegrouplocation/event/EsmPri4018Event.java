/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4018Event.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.29 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.event;

import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.SurchargeGroupLocationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jaeyeon Kim
 * @see ESM_PRI_4018HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri4018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	SurchargeGroupLocationVO surchargeGroupLocationVO = new SurchargeGroupLocationVO();

	public EsmPri4018Event(){}
	
	public SurchargeGroupLocationVO getSurchargeGroupLocationVO() {
		return surchargeGroupLocationVO;
	}

	public void setSurchargeGroupLocationVO(
			SurchargeGroupLocationVO surchargeGroupLocationVO) {
		this.surchargeGroupLocationVO = surchargeGroupLocationVO;
	}
}