/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0310Event.java
*@FileTitle : Rejection Notice Send History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.testoraud.event;

import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.vo.RehandlingExpenseTorVsTpbVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0310 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0310HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0310HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0310Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	RehandlingExpenseTorVsTpbVO rehandlingExpenseTorVsTpbVO = null;
	
	/** Table Value Object Multi Data 처리 */
	RehandlingExpenseTorVsTpbVO[] rehandlingExpenseTorVsTpbVOs = null;

	public EsdEas0310Event(){}
	
	// RehandlingExpenseTorVsTpbVO
	public RehandlingExpenseTorVsTpbVO getRehandlingExpenseTorVsTpbVO() {
		return rehandlingExpenseTorVsTpbVO;
	}

	public void setRehandlingExpenseTorVsTpbVO(RehandlingExpenseTorVsTpbVO rehandlingExpenseTorVsTpbVO) {
		this.rehandlingExpenseTorVsTpbVO = rehandlingExpenseTorVsTpbVO;
	}

	public RehandlingExpenseTorVsTpbVO[] getRehandlingExpenseTorVsTpbVOs() {
		RehandlingExpenseTorVsTpbVO[] rtnVOs = null;
		if (this.rehandlingExpenseTorVsTpbVOs != null) {
			rtnVOs = new RehandlingExpenseTorVsTpbVO[rehandlingExpenseTorVsTpbVOs.length];
			System.arraycopy(rehandlingExpenseTorVsTpbVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRehandlingExpenseTorVsTpbVOs(RehandlingExpenseTorVsTpbVO[] rehandlingExpenseTorVsTpbVOs){
		if(rehandlingExpenseTorVsTpbVOs != null){
			RehandlingExpenseTorVsTpbVO[] tmpVOs = new RehandlingExpenseTorVsTpbVO[rehandlingExpenseTorVsTpbVOs.length];
			System.arraycopy(rehandlingExpenseTorVsTpbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rehandlingExpenseTorVsTpbVOs = tmpVOs;
		}
	}

}