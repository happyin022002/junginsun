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
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
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
	public StatusHistoryVO[] statusHistoryVOs = null;
	
	private StatusHistoryVO statusHistoryVO = null;

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
		return statusHistoryVOs;
	}

	/**
	 * @param statusHistoryVOs the statusHistoryVOs to set
	 */
	public void setStatusHistoryVOs(StatusHistoryVO[] statusHistoryVOs) {
		this.statusHistoryVOs = statusHistoryVOs;
	}
	
	/**
	 * @return the statusHistoryVOs
	 */
	public StatusHistoryVO getStatusHistoryVO() {
		return statusHistoryVO;
	}

	/**
	 * @param statusHistoryVOs the statusHistoryVOs to set
	 */
	public void setStatusHistoryVO(StatusHistoryVO statusHistoryVO) {
		this.statusHistoryVO = statusHistoryVO;
	}

}