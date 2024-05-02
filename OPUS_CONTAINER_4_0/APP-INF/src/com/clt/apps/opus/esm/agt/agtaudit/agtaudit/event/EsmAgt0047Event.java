/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Esmagt0036Event.java
*@FileTitle : Agent Commission Approval No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.12 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTVVDRateVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EsmAgt0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EsmAgt0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Jin
 * @see EsmAgt0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGTVVDRateVO agtVVDRateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AGTVVDRateVO[] agtVVDRateVOs = null;
	
	public EsmAgt0047Event(){}

	public AGTVVDRateVO getAgtVVDRateVO() {
		return agtVVDRateVO;
	}

	public void setAgtVVDRateVO(AGTVVDRateVO agtVVDRateVO) {
		this.agtVVDRateVO = agtVVDRateVO;
	}

	public AGTVVDRateVO[] getAgtVVDRateVOs() {
		return agtVVDRateVOs;
	}

	public void setAgtVVDRateVOs(AGTVVDRateVO[] agtVVDRateVOs) {
		this.agtVVDRateVOs = agtVVDRateVOs;
	}
	

	

}