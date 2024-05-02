/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdSpe1013Event.java
*@FileTitle : Terminal Productivity Target Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.vo.TmlProdTgtInpVO;


/**
 * ESD_SPE_1013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_1013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_SPE_1013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe1013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	TmlProdTgtInpVO tmlProdTgtInpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	TmlProdTgtInpVO[] tmlProdTgtInpVOs = null;

	public EsdSpe1013Event(){}

	public TmlProdTgtInpVO getTmlProdTgtInpVO() {
		return tmlProdTgtInpVO;
	}

	public void setTmlProdTgtInpVO(TmlProdTgtInpVO tmlProdTgtInpVO) {
		this.tmlProdTgtInpVO = tmlProdTgtInpVO;
	}

	public TmlProdTgtInpVO[] getTmlProdTgtInpVOs() {
		return tmlProdTgtInpVOs;
	}

	public void setTmlProdTgtInpVOs(TmlProdTgtInpVO[] tmlProdTgtInpVOs) {
		this.tmlProdTgtInpVOs = tmlProdTgtInpVOs;
	}
	


}