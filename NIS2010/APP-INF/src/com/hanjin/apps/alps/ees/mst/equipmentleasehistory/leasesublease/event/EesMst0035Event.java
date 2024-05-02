/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0035Event.java
*@FileTitle : Container Check Digit and Container Checking Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;

/**
 * EES_MST_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Multi Data 처리 
	 * 
	 * */
	public CntrStatusListVO[] cntrStatusListVOs = null;

	/** 검색 조건 */
	private CntrStatusListVO cntrStatusListVO = null;
	
	/** 검색 조건 */
	private CntrStatusOptionVO containerConditionVO = null;
	
	/**
	 * @return the cntrStatusListVO
	 */
	public CntrStatusListVO getCntrStatusListVO() {
		return cntrStatusListVO;
	}

	/**
	 * @param cntrStatusListVO the cntrStatusListVO to set
	 */
	public void setCntrStatusListVO(CntrStatusListVO cntrStatusListVO) {
		this.cntrStatusListVO = cntrStatusListVO;
	}	
	
	/**
	 * @return the containerConditionVO
	 */
	public CntrStatusOptionVO getContainerConditionVO() {
		return containerConditionVO;
	}

	/**
	 * @param containerConditionVO the containerConditionVO to set
	 */
	public void setContainerConditionVO(CntrStatusOptionVO containerConditionVO) {
		this.containerConditionVO = containerConditionVO;
	}

	/**
	 * @return the cntrStatusListVOs
	 */
	public CntrStatusListVO[] getCntrStatusListVOs() {
		return cntrStatusListVOs;
	}

	/**
	 * @param cntrStatusListVOs the cntrStatusListVOs to set
	 */
	public void setCntrStatusListVOs(CntrStatusListVO[] cntrStatusListVOs) {
		this.cntrStatusListVOs = cntrStatusListVOs;
	}
}