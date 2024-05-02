/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EsdPrd0038Event.java
 *@FileTitle :  Inland Cut Off Time
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PrdInlndCutOffTmMgmtVO;

/**
 * ESD_PRD_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0038Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private PrdInlndCutOffTmMgmtVO prdInlndCutOffTmMgmtVO = null;

	private PrdInlndCutOffTmMgmtVO[] prdInlndCutOffTmMgmtVOs = null;

	public PrdInlndCutOffTmMgmtVO getPrdInlndCutOffTmMgmtVO() {
		return prdInlndCutOffTmMgmtVO;
	}

	public void setPrdInlndCutOffTmMgmtVO(PrdInlndCutOffTmMgmtVO prdInlndCutOffTmMgmtVO) {
		this.prdInlndCutOffTmMgmtVO = prdInlndCutOffTmMgmtVO;
	}

	public PrdInlndCutOffTmMgmtVO[] getPrdInlndCutOffTmMgmtVOs() {
		PrdInlndCutOffTmMgmtVO[] tmpVOs = null;
		if (this.prdInlndCutOffTmMgmtVOs != null) {
			tmpVOs = new PrdInlndCutOffTmMgmtVO[this.prdInlndCutOffTmMgmtVOs.length];
			System.arraycopy(this.prdInlndCutOffTmMgmtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public void setPrdInlndCutOffTmMgmtVOs(PrdInlndCutOffTmMgmtVO[] prdInlndCutOffTmMgmtVOs) {
		if (prdInlndCutOffTmMgmtVOs != null) {
			PrdInlndCutOffTmMgmtVO[] tmpVOs = new PrdInlndCutOffTmMgmtVO[prdInlndCutOffTmMgmtVOs.length];
			System.arraycopy(prdInlndCutOffTmMgmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.prdInlndCutOffTmMgmtVOs = tmpVOs;
		}
	}

}
