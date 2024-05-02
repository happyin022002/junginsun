/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AutoAuditRptBC   
*@FileTitle : Performance For Logistics Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2016-02-04
*@LastModifier : 9014613
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditChangeHistoryVO;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditStatisticsVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * AutoAuditRptBC PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @since J2EE 1.4
 */
public interface AutoAuditRptBC {
	/**
	 * Performance For Logistics Expense 조회.
	 * 
	 * @category EDS_EAS_0227
	 * @param e EsdEas0227Event
	 * @return List<SearchAutoAuditChangeHistoryVO>
	 * @throws EventException
	 */
	public List<SearchAutoAuditChangeHistoryVO> searchAutoAuditChangeHistory(SearchAutoAuditChangeHistoryVO searchAutoAuditChangeHistoryVO) throws EventException;

	
	/**
	 * Auto Audit Statistics 조회
	 * 
	 * @category EDS_EAS_0228
	 * @param e EsdEas0228Event
	 * @return List<SearchAutoAuditStatisticsVO>
	 * @throws EventException
	 */
	public List<SearchAutoAuditStatisticsVO> searchAutoAuditStatistics(SearchAutoAuditStatisticsVO searchAutoAuditStatisticsVO) throws EventException;

}