/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0056Event.java
*@FileTitle : Invoice File import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.22 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 *  PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cim_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Young Jin
 * @see ees_cim_2001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OscarBookingSearchVO oscarBookingSearchVO = null;
	private SearchMovementListByContainerVO searchMovementListByContainerVO = null;
	private SearchEDIMovementListVO searchEDIMovementListVO = null;
	private CntrStatusOptionVO containerConditionVO = null;
	
	/** 검색결과 **/
	private OscarBookingSearchVO[] oscarBookingSearchVOs = null;
		
	public EesCim2001Event(){}
	
	/**
	 * @return the getOscarBookingSearchVOs
	 */
	public OscarBookingSearchVO[] getOscarBookingSearchVOs() {
		OscarBookingSearchVO[] tmpVOs = null;
		if (this.oscarBookingSearchVOs != null) {
			tmpVOs = new OscarBookingSearchVO[oscarBookingSearchVOs.length];
			System.arraycopy(oscarBookingSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param oscarBookingSearchVOs
	 *            the oscarBookingSearchVOs to set
	 */
	public void setOscarBookingSearchVOs(OscarBookingSearchVO[] oscarBookingSearchVOs) {
		if (oscarBookingSearchVOs != null) {
			OscarBookingSearchVO[] tmpVOs = new OscarBookingSearchVO[oscarBookingSearchVOs.length];
			System.arraycopy(oscarBookingSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.oscarBookingSearchVOs = tmpVOs;
		}

	}
	
	public void setOscarBookingSearchVO(OscarBookingSearchVO oscarBookingSearchVO){
		this.oscarBookingSearchVO = oscarBookingSearchVO;
	}
	
	public OscarBookingSearchVO getOscarBookingSearchVO(){
		return oscarBookingSearchVO;
	}
	
	
	public void setSearchMovementListByContainerVO(SearchMovementListByContainerVO searchMovementListByContainerVO){
		this. searchMovementListByContainerVO = searchMovementListByContainerVO;
	}


	public SearchMovementListByContainerVO getSearchMovementListByContainerVO(){
		return searchMovementListByContainerVO;
	}
	
	
	public void setSearchEDIMovementListVO(SearchEDIMovementListVO searchEDIMovementListVO){
		this. searchEDIMovementListVO = searchEDIMovementListVO;
	}
	
	public SearchEDIMovementListVO getSearchEDIMovementListVO(){
		return searchEDIMovementListVO;
	}
	
	/**
	 * @param containerConditionVO the containerConditionVO to set
	 */
	public void setContainerConditionVO(CntrStatusOptionVO containerConditionVO) {
		this.containerConditionVO = containerConditionVO;
	}
	
	/**
	 * @return the containerConditionVO
	 */
	public CntrStatusOptionVO getContainerConditionVO() {
		return containerConditionVO;
	}
}