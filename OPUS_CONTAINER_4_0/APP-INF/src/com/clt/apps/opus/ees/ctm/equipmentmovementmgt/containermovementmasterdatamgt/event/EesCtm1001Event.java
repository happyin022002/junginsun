/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm1001Event.java
*@FileTitle : CNTR MVMT Sequence
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.CntrMvmtSeqVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * PDTO(Data Transfer Object including Parameters) about EES_CTM_1001<br>
 *
 * @author 
 * @see EES_CTM_1001HTMLAction 참조
 * @since J2EE 1.5
 * 
 */

public class EesCtm1001Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private CntrMvmtSeqVO cntrMvmtSeqVO = null;
	
	private CntrMvmtSeqVO[] cntrMvmtSeqVOs = null;
	
	public EesCtm1001Event(){}

	public CntrMvmtSeqVO getCntrMvmtSeqVO() {
		return cntrMvmtSeqVO;
	}

	public void setCntrMvmtSeqVO(CntrMvmtSeqVO cntrMvmtSeqVO) {
		this.cntrMvmtSeqVO = cntrMvmtSeqVO;
	}

	public CntrMvmtSeqVO[] getCntrMvmtSeqVOs() {
		CntrMvmtSeqVO[] tmpVOs = null;
		if (this.cntrMvmtSeqVOs != null) {
			tmpVOs = new CntrMvmtSeqVO[cntrMvmtSeqVOs.length];
			System.arraycopy(cntrMvmtSeqVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrMvmtSeqVOs(CntrMvmtSeqVO[] cntrMvmtSeqVOs) {
		if (cntrMvmtSeqVOs != null) {
			CntrMvmtSeqVO[] tmpVOs = new CntrMvmtSeqVO[cntrMvmtSeqVOs.length];
			System.arraycopy(cntrMvmtSeqVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrMvmtSeqVOs = tmpVOs;
		}
	}
	
}
