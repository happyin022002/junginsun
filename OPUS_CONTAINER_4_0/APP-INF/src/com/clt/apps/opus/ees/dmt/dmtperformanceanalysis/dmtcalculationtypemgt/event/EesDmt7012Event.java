/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7012Event.java
*@FileTitle : Skip Location Set-up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtSkpLocVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_dmt_7012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_7012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Bong Gyoon
 * @see ees_dmt_7012HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt7012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DmtSkpLocVO dmtSkpLocVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DmtSkpLocVO[] dmtSkpLocVOs = null;

	public EesDmt7012Event(){}

	public DmtSkpLocVO getDmtSkpLocVO() {
		return dmtSkpLocVO;
	}

	public void setDmtSkpLocVO(DmtSkpLocVO dmtSkpLocVO) {
		this.dmtSkpLocVO = dmtSkpLocVO;
	}

	public DmtSkpLocVO[] getDmtSkpLocVOs() {
		DmtSkpLocVO[] tmpVOs = null;
		if (this.dmtSkpLocVOs != null) {
			tmpVOs = new DmtSkpLocVO[dmtSkpLocVOs.length];
			System.arraycopy(dmtSkpLocVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setDmtSkpLocVOs(DmtSkpLocVO[] dmtSkpLocVOs) {
		if (dmtSkpLocVOs != null) {
			DmtSkpLocVO[] tmpVOs = new DmtSkpLocVO[dmtSkpLocVOs.length];
			System.arraycopy(dmtSkpLocVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtSkpLocVOs = tmpVOs;
		}
	}
}