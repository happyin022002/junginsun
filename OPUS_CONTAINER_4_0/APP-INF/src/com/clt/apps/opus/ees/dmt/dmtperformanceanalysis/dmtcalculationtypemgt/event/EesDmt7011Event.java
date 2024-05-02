/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7011Event.java
*@FileTitle : Combination Set-up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtCmbSetVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_dmt_7011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_7011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see ees_dmt_7011HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt7011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DmtCmbSetVO dmtCmbSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DmtCmbSetVO[] dmtCmbSetVOs = null;

	public EesDmt7011Event(){}

	public DmtCmbSetVO getDmtCmbSetVO() {
		return dmtCmbSetVO;
	}

	public void setDmtCmbSetVO(DmtCmbSetVO dmtCmbSetVO) {
		this.dmtCmbSetVO = dmtCmbSetVO;
	}

	public DmtCmbSetVO[] getDmtCmbSetVOs() {
		DmtCmbSetVO[] tmpVOs = null;
		if (this.dmtCmbSetVOs != null) {
			tmpVOs = new DmtCmbSetVO[dmtCmbSetVOs.length];
			System.arraycopy(dmtCmbSetVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setDmtCmbSetVOs(DmtCmbSetVO[] dmtCmbSetVOs) {
		if (dmtCmbSetVOs != null) {
			DmtCmbSetVO[] tmpVOs = new DmtCmbSetVO[dmtCmbSetVOs.length];
			System.arraycopy(dmtCmbSetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtCmbSetVOs = tmpVOs;
		}
	}
}