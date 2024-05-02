/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportBC.java
*@FileTitle : Rail Transit Report BC
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.common.setup.basic;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;


/**
 * user별 customized Rpt Setup 정보를 access Component. <br>
 * 
 * @author HanSung Shin.
 * @see UI_ID_11EventResponse 참조
 * @since J2EE 1.4
 */
public interface CustomizedReportSetupBC  {

	
	/**
     * user별 Rpt Setup 정보를 조회한다
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @return DBRowSet
     * @throws EventException
     */
	public DBRowSet searchCustmRptForm(String usrId, String usrOfcCd, String pgmNo) throws EventException ;
	
	/**
     * user별 Rpt Setup 정보를 등록 한다.
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @param String rptInfoCtnt
     * @throws EventException
     */
	public void insertCustmRptForm(String usrId, String usrOfcCd, String pgmNo, String rptInfoCtnt) throws EventException ;
	
	/**
     * user별 Rpt Setup 정보를 수정 한다.
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @param String rptInfoCtnt
     * @throws EventException
     */
	public void updateCustmRptForm(String usrId, String usrOfcCd, String pgmNo, String rptInfoCtnt) throws EventException ;
}