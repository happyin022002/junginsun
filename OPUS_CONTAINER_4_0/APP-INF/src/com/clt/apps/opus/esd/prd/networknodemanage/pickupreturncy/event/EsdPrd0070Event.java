/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_002Event.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.event;

import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0070Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public EsdPrd0070Event() {
	}

	private PickupReturnCYVO pickupReturnCYVO;
	private PickupReturnCYVO[] pickupReturnCYVOs;

	/**
	 * @return the pickupReturnCYVO
	 */
	public PickupReturnCYVO getPickupReturnCYVO() {
		return pickupReturnCYVO;
	}

	/**
	 * @param pickupReturnCYVO the pickupReturnCYVO to set
	 */
	public void setPickupReturnCYVO(PickupReturnCYVO pickupReturnCYVO) {
		this.pickupReturnCYVO = pickupReturnCYVO;
	}

	/**
	 * @return the pickupReturnCYVOs
	 */
	public PickupReturnCYVO[] getPickupReturnCYVOs() {
		PickupReturnCYVO[] tmpVOs = null;
		if (this.pickupReturnCYVOs != null) {
			tmpVOs = new PickupReturnCYVO[this.pickupReturnCYVOs.length];
			System.arraycopy(this.pickupReturnCYVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param pickupReturnCYVOs the pickupReturnCYVOs to set
	 */
	public void setPickupReturnCYVOs(PickupReturnCYVO[] pickupReturnCYVOs) {
		if (pickupReturnCYVOs != null) {
			PickupReturnCYVO[] tmpVOs = new PickupReturnCYVO[pickupReturnCYVOs.length];
			System.arraycopy(pickupReturnCYVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pickupReturnCYVOs = tmpVOs;
		}
	}
}
