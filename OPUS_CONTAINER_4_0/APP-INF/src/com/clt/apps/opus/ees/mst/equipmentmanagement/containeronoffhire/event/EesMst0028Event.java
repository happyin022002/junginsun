/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0028Event.java
*@FileTitle :  Container Status Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.17 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * EES_MST_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0028HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstEtcVO mstEtcVO = null;
	
	/** 검색결과 **/
	private StatusHistoryVO[] statusHistoryVOs = null;

	/**
	 * @return the mstEtcVO
	 */
	public MstEtcVO getMstEtcVO() {
		return mstEtcVO;
	}

	/**
	 * @param mstEtcVO the mstEtcVO to set
	 */
	public void setMstEtcVO(MstEtcVO mstEtcVO) {
		this.mstEtcVO = mstEtcVO;
	}

	/**
	 * @return the statusHistoryVOs
	 */
	public StatusHistoryVO[] getStatusHistoryVOs() {
		StatusHistoryVO[] tmpVOs = null;
		  if (this.statusHistoryVOs != null) {
		   tmpVOs = new StatusHistoryVO[statusHistoryVOs.length];
		   System.arraycopy(statusHistoryVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

	/**
	 * @param statusHistoryVOs the statusHistoryVOs to set
	 */
	public void setStatusHistoryVOs(StatusHistoryVO[] statusHistoryVOs) {
		  if (statusHistoryVOs != null) {
			  StatusHistoryVO[] tmpVOs = new StatusHistoryVO[statusHistoryVOs.length];
			   System.arraycopy(statusHistoryVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.statusHistoryVOs = tmpVOs;
			  }

	}

}