/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri5002Event.java
*@FileTitle : Percent Base Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.04.19
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriScgPctBseChgVO;
import com.clt.syscommon.common.table.PriScgPctBseVO;

/**
 * ESM_PRI_5002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_5002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_5002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri5002Event extends EventSupport {

	private static final long serialVersionUID = 1L;	

	public EsmPri5002Event(){}
	
	private PriScgPctBseVO priScgPctBseVO = null;
	
	private PriScgPctBseVO[] priScgPctBseVOs = null;
	
	private PriScgPctBseChgVO priScgPctBseChgVO = null;
	
	private PriScgPctBseChgVO[] priScgPctBseChgVOs = null;

	public PriScgPctBseVO getPriScgPctBseVO() {
		return priScgPctBseVO;
	}

	public void setPriScgPctBseVO(PriScgPctBseVO priScgPctBseVO) {
		this.priScgPctBseVO = priScgPctBseVO;
	}

	public PriScgPctBseVO[] getPriScgPctBseVOs() {
		PriScgPctBseVO[] tmpVOs = null;
		if (this.priScgPctBseVOs != null) {
			tmpVOs = new PriScgPctBseVO[priScgPctBseVOs.length];
			System.arraycopy(priScgPctBseVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriScgPctBseVOs(PriScgPctBseVO[] priScgPctBseVOs) {
		if (priScgPctBseVOs != null) {
			PriScgPctBseVO[] tmpVOs = new PriScgPctBseVO[priScgPctBseVOs.length];
			System.arraycopy(priScgPctBseVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgPctBseVOs = tmpVOs;
		}
	}

	public PriScgPctBseChgVO getPriScgPctBseChgVO() {
		return priScgPctBseChgVO;
	}

	public void setPriScgPctBseChgVO(PriScgPctBseChgVO priScgPctBseChgVO) {
		this.priScgPctBseChgVO = priScgPctBseChgVO;
	}

	public PriScgPctBseChgVO[] getPriScgPctBseChgVOs() {
		PriScgPctBseChgVO[] tmpVOs = null;
		if (this.priScgPctBseChgVOs != null) {
			tmpVOs = new PriScgPctBseChgVO[priScgPctBseChgVOs.length];
			System.arraycopy(priScgPctBseChgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setPriScgPctBseChgVOs(PriScgPctBseChgVO[] priScgPctBseChgVOs) {
		if (priScgPctBseChgVOs != null) {
			PriScgPctBseChgVO[] tmpVOs = new PriScgPctBseChgVO[priScgPctBseChgVOs.length];
			System.arraycopy(priScgPctBseChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgPctBseChgVOs = tmpVOs;
		}
	}


}