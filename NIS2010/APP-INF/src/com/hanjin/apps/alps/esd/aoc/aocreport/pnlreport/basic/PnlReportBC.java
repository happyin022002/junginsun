/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnlReportBC.java
*@FileTitle : Profit & Loss Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Inland BIZ 생성
* 2013.03.26 이재위 [CHM-201323626] AOC P&L Report 대상 확대 - BKG/TRS DATA 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgDtlListVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgListVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLRptOptionVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLRptSmryListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-AOC Business Logic Command Interface<br>
 * - ESD-AOC에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface PnlReportBC  {
	
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
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public String[] searchSvcScp(PnLRptOptionVO inputVO) throws EventException;
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCustomerInfo(PnLRptOptionVO inputVO) throws EventException;
}