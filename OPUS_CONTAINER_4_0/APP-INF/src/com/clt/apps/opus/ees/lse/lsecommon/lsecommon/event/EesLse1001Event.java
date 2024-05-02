/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse1001Event.java
*@FileTitle :Lease Rental Charge & Account Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.event;

import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.LseRntlCostAcctOrdVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * UI_LSE_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_LSE_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0048HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesLse1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EesLse1001Event() {
	}

	private LseRntlCostAcctOrdVO[] lseRntlCostAcctOrdVOs;

	public LseRntlCostAcctOrdVO[] getLseRntlCostAcctOrdVOs() {
		LseRntlCostAcctOrdVO[] tmpVOs = null;
		if (this.lseRntlCostAcctOrdVOs != null) {
			tmpVOs = new LseRntlCostAcctOrdVO[lseRntlCostAcctOrdVOs.length];
			System.arraycopy(lseRntlCostAcctOrdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setLseRntlCostAcctOrdVOs(LseRntlCostAcctOrdVO[] lseRntlCostAcctOrdVOs) {
		if (lseRntlCostAcctOrdVOs != null) {
			LseRntlCostAcctOrdVO[] tmpVOs = new LseRntlCostAcctOrdVO[lseRntlCostAcctOrdVOs.length];
			System.arraycopy(lseRntlCostAcctOrdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lseRntlCostAcctOrdVOs = tmpVOs;
		}
	}
}