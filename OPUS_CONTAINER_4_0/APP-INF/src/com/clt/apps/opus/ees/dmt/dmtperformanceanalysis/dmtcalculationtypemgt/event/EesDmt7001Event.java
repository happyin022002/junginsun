/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7001Event.java
*@FileTitle : Tariff Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.13 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_7001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang Hyo Keun
 * @see EES_DMT_7001HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt7001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DmtTrfTpVO dmtTrfTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DmtTrfTpVO[] dmtTrfTpVOs = null;

	public EesDmt7001Event(){}
	
	public void setDmtTrfTpVO(DmtTrfTpVO dmtTrfTpVO){
		this. dmtTrfTpVO = dmtTrfTpVO;
	}

	public void setDmtTrfTpVOS(DmtTrfTpVO[] dmtTrfTpVOs){
		if (dmtTrfTpVOs != null) {
			DmtTrfTpVO[] tmpVOs = new DmtTrfTpVO[dmtTrfTpVOs.length];
			System.arraycopy(dmtTrfTpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtTrfTpVOs = tmpVOs;
		}
	}

	public DmtTrfTpVO getDmtTrfTpVO(){
		return dmtTrfTpVO;
	}

	public DmtTrfTpVO[] getDmtTrfTpVOS(){
		DmtTrfTpVO[] tmpVOs = null;
		if (this.dmtTrfTpVOs != null) {
			tmpVOs = new DmtTrfTpVO[dmtTrfTpVOs.length];
			System.arraycopy(dmtTrfTpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}