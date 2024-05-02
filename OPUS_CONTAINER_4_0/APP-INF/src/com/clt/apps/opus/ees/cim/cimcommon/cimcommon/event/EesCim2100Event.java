/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMst0005Event.java
 *@FileTitle : ISO Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CimTpSzDpSeqVO;

/**
 * PDTO(Data Transfer Object including Parameters) for EES_CIM_2100 implementing
 * in EES_CIM_2100HTMLAction using as PDTO for transmit to ServiceCommand Layer
 * 
 * @author Chang Hun Kim
 * @see EES_CIM_2100HTMLAction reference
 * @since J2EE 1.4
 */

public class EesCim2100Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object retrieving option, handling single data */
	private CimTpSzDpSeqVO cimTpSzDpSeqVO = null;

	/** handling Table Value Object Multi Data */
	private CimTpSzDpSeqVO[] cimTpSzDpSeqVOs = null;

	public EesCim2100Event() {
	}

	public void setCimTpSzDpSeqVO(CimTpSzDpSeqVO cimTpSzDpSeqVO) {
		this.cimTpSzDpSeqVO = cimTpSzDpSeqVO;
	}

	public void setCimTpSzDpSeqVOS(CimTpSzDpSeqVO[] cimTpSzDpSeqVOs) {
		if (cimTpSzDpSeqVOs != null) {
			CimTpSzDpSeqVO[] tmpVOs = new CimTpSzDpSeqVO[cimTpSzDpSeqVOs.length];
			System.arraycopy(cimTpSzDpSeqVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cimTpSzDpSeqVOs = tmpVOs;
		}
	}

	public CimTpSzDpSeqVO getCimTpSzDpSeqVO() {
		return cimTpSzDpSeqVO;
	}

	public CimTpSzDpSeqVO[] getCimTpSzDpSeqVOS() {
		CimTpSzDpSeqVO[] tmpVOs = null;
		if (this.cimTpSzDpSeqVOs != null) {
			tmpVOs = new CimTpSzDpSeqVO[cimTpSzDpSeqVOs.length];
			System.arraycopy(cimTpSzDpSeqVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}