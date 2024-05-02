/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0029Event.java
*@FileTitle : 임차 및 반납 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.event;

import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MST_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrMstHeadVO cntrMstHeadVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrMstHeadVO[] cntrMstHeadVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrStatusListVO[] cntrStatusListVOs = null;

	/** 검색 조건 */
	private CntrStatusOptionVO containerConditionVO = null;
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
	 * @return the cntrMstHeadVO
	 */
	public CntrMstHeadVO getCntrMstHeadVO() {
		return cntrMstHeadVO;
	}

	/**
	 * @param cntrMstHeadVO the cntrMstHeadVO to set
	 */
	public void setCntrMstHeadVO(CntrMstHeadVO cntrMstHeadVO) {
		this.cntrMstHeadVO = cntrMstHeadVO;
	}

	/**
	 * @return the cntrMstHeadVOs
	 */
	public CntrMstHeadVO[] getCntrMstHeadVOs() {
		CntrMstHeadVO[] tmpVOs = null;
		if (this.cntrMstHeadVOs != null) {
		   tmpVOs = new CntrMstHeadVO[cntrMstHeadVOs.length];
		   System.arraycopy(cntrMstHeadVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		  return tmpVOs;
	}

	/**
	 * @param cntrMstHeadVOs the cntrMstHeadVOs to set
	 */
	public void setCntrMstHeadVOs(CntrMstHeadVO[] cntrMstHeadVOs) {
		  if (cntrMstHeadVOs != null) {
			  CntrMstHeadVO[] tmpVOs = new CntrMstHeadVO[cntrMstHeadVOs.length];
			  System.arraycopy(cntrMstHeadVOs, 0, tmpVOs, 0, tmpVOs.length);
			  this.cntrMstHeadVOs = tmpVOs;
		  }
	}

	/**
	 * @return the cntrStatusListVOs
	 */
	public CntrStatusListVO[] getCntrStatusListVOs() {
		CntrStatusListVO[] tmpVOs = null;
		if (this.cntrStatusListVOs != null) {
		   tmpVOs = new CntrStatusListVO[cntrStatusListVOs.length];
		   System.arraycopy(cntrStatusListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		  return tmpVOs;
	}

	/**
	 * @param cntrStatusListVOs the cntrStatusListVOs to set
	 */
	public void setCntrStatusListVOs(CntrStatusListVO[] cntrStatusListVOs) {
		 if (cntrStatusListVOs != null) {
			 CntrStatusListVO[] tmpVOs = new CntrStatusListVO[cntrStatusListVOs.length];
			  System.arraycopy(cntrStatusListVOs, 0, tmpVOs, 0, tmpVOs.length);
			  this.cntrStatusListVOs = tmpVOs;
		  }
	}
}