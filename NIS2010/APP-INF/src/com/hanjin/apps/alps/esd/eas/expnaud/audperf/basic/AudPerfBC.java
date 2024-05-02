/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AudPerfBC   
*@FileTitle : Performance For Logistics Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 : 9014613
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.audperf.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchLgsCostCdVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfCostDtlListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfOfcListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfSpDtlListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * AudPerfBC PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @see List<SearchPerfOfcListVO> 참조
 * @since J2EE 1.4
 */
public interface AudPerfBC {
	/**
	 * Performance For Logistics Expense 조회.
	 * 
	 * @category EDS_EAS_0317
	 * @param e EsdEas0317Event
	 * @return List<SearchPerfOfcListVO>
	 * @throws EventException
	 */
	public List<SearchPerfOfcListVO> searchPerfOfcList(Event e) throws EventException;
	
	/**
	 * Performance For Logistics Expense - Cost Code 조회.
	 * 
	 * @category EDS_EAS_0317
	 * @param e EsdEas0317Event
	 * @return List<SearchLgsCostCdVO>
	 * @throws EventException
	 */
	public List<SearchLgsCostCdVO> searchLgsCostCd(Event e) throws EventException;
	
	/**
	 * Performance For Logistics Expense - S/P Detail 조회.
	 * 
	 * @category EDS_EAS_0318
	 * @param e EsdEas0318Event
	 * @return List<SearchPerfSpDtlListVO>
	 * @throws EventException
	 */
	public List<SearchPerfSpDtlListVO> searchPerfSpDtlList(Event e) throws EventException;
	
	/**
	 * Performance For Logistics Expense - Cost Detail 조회.
	 * 
	 * @category EDS_EAS_0319
	 * @param e EsdEas0319Event
	 * @return List<SearchPerfCostDtlListVO>
	 * @throws EventException
	 */
	public List<SearchPerfCostDtlListVO> searchPerfCostDtlList(Event e) throws EventException;
}