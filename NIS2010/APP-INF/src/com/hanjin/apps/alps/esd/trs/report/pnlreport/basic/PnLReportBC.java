/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLReportBC.java
*@FileTitle : Profit & Loss Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.pnlreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLBkgDtlListVO;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLBkgListVO;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLRptOptionVO;
import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLRptSmryListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EsdTrs3004EventResponse 참조
 * @since J2EE 1.4
 */
public interface PnLReportBC  {
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<PnLRptSmryListVO> searchPnLSlsVwList(PnLRptOptionVO inputVO) throws EventException;
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<PnLRptSmryListVO> searchPnLOpVwList(PnLRptOptionVO inputVO) throws EventException;
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<PnLBkgListVO> searchPnLBkgList(PnLRptOptionVO inputVO) throws EventException;
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<PnLBkgDtlListVO> searchPnLBkgDtlList(PnLBkgDtlListVO inputVO) throws EventException;
	
	/**
	 * @return
	 * @throws EventException
	 */
	public String[] searchSvcScp() throws EventException;
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCustomerInfo(PnLRptOptionVO inputVO) throws EventException;
}