/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EsdTrs0977Event.java
 *@FileTitle : Change Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event;

import java.util.Arrays;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD_TRS_083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0983HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.7
 */
public class EsdTrs0983Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;

	/**
	 * 
	 * @return
	 */
	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOs() {
		TrsTrspSvcOrdVO[] rtnVOs = null;
		if (this.trsTrspSvcOrdVOs != null) {
			rtnVOs = Arrays.copyOf(trsTrspSvcOrdVOs, trsTrspSvcOrdVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * 
	 * @param TrsTrspSvcOrdVOs
	 */
	public void setTrsTrspSvcOrdVOs(TrsTrspSvcOrdVO[] TrsTrspSvcOrdVOs) {
		if (TrsTrspSvcOrdVOs != null) {
			TrsTrspSvcOrdVO[] tmpVOs = Arrays.copyOf(TrsTrspSvcOrdVOs, TrsTrspSvcOrdVOs.length);
			this.trsTrspSvcOrdVOs = tmpVOs;
		}
	}

}
