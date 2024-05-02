/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7012Event.java
*@FileTitle : Tariff Type Entry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_dmt_7013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_7013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Bong Gyoon
 * @see ees_dmt_7013HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt7013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DmtTrfTpVO dmtTrfTpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DmtTrfTpVO[] dmtTrfTpVOs = null;

	public EesDmt7013Event(){}

	public DmtTrfTpVO getDmtTrfTpVO() {
		return dmtTrfTpVO;
	}

	public void setDmtTrfTpVO(DmtTrfTpVO dmtTrfTpVO) {
		this.dmtTrfTpVO = dmtTrfTpVO;
	}

	public DmtTrfTpVO[] getDmtTrfTpVOs() {
		DmtTrfTpVO[] tmpVOs = null;
		if (this.dmtTrfTpVOs != null) {
			tmpVOs = new DmtTrfTpVO[dmtTrfTpVOs.length];
			System.arraycopy(dmtTrfTpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setDmtTrfTpVOs(DmtTrfTpVO[] dmtTrfTpVOs) {
		if (dmtTrfTpVOs != null) {
			DmtTrfTpVO[] tmpVOs = new DmtTrfTpVO[dmtTrfTpVOs.length];
			System.arraycopy(dmtTrfTpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtTrfTpVOs = tmpVOs;
		}
	}
}