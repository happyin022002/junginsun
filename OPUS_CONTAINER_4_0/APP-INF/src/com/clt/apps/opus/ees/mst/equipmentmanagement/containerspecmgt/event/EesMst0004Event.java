/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0004Event.java
*@FileTitle : Lease Term Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.04 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.vo.LeaseTermVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MST_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LeaseTermVO leaseTermVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LeaseTermVO[] leaseTermVOs = null;

	public EesMst0004Event(){}
	
	public void setLeaseTermVO(LeaseTermVO mstLseTermVO){
		this. leaseTermVO = mstLseTermVO;
	}

	public void setLeaseTermVOS(LeaseTermVO[] leaseTermVOs){
		if (leaseTermVOs != null) {
			LeaseTermVO[] tmpVOs = new LeaseTermVO[leaseTermVOs.length];
			   System.arraycopy(leaseTermVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.leaseTermVOs = tmpVOs;
			  }

	}

	public LeaseTermVO getLeaseTermVO(){
		return leaseTermVO;
	}

	public LeaseTermVO[] getLeaseTermVOS(){
		LeaseTermVO[] tmpVOs = null;
		  if (this.leaseTermVOs != null) {
		   tmpVOs = new LeaseTermVO[leaseTermVOs.length];
		   System.arraycopy(leaseTermVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

}