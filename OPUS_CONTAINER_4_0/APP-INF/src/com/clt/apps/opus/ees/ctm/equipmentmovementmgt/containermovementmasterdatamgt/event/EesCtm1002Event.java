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

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CtmMvmtStsDcsnVO;

/**
 * PDTO(Data Transfer Object including Parameters) about EES_CTM_1002<br>
 *
 * @author 
 * @see EES_CTM_1002HTMLAction 참조
 * @since J2EE 1.5
 * 
 */

public class EesCtm1002Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private CtmMvmtStsDcsnVO ctmMvmtStsDcsnVO = null;
	
	private CtmMvmtStsDcsnVO[] ctmMvmtStsDcsnVOs = null;
	
	public EesCtm1002Event(){}

	public CtmMvmtStsDcsnVO getCtmMvmtStsDcsnVO() {
		return ctmMvmtStsDcsnVO;
	}

	public void setCtmMvmtStsDcsnVO(CtmMvmtStsDcsnVO ctmMvmtStsDcsnVO) {
		this.ctmMvmtStsDcsnVO = ctmMvmtStsDcsnVO;
	}

	public CtmMvmtStsDcsnVO[] getCtmMvmtStsDcsnVOs() {
		CtmMvmtStsDcsnVO[] tmpVOs = null;
		if (this.ctmMvmtStsDcsnVOs != null) {
			tmpVOs = new CtmMvmtStsDcsnVO[ctmMvmtStsDcsnVOs.length];
			System.arraycopy(ctmMvmtStsDcsnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCtmMvmtStsDcsnVOs(CtmMvmtStsDcsnVO[] ctmMvmtStsDcsnVOs) {
		if (ctmMvmtStsDcsnVOs != null) {
			CtmMvmtStsDcsnVO[] tmpVOs = new CtmMvmtStsDcsnVO[ctmMvmtStsDcsnVOs.length];
			System.arraycopy(ctmMvmtStsDcsnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ctmMvmtStsDcsnVOs = tmpVOs;
		}
	}

	
}
