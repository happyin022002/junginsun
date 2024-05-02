/*=========================================================
*Copyright(c) 2006~2010 CyberLogitec
*@FileName : CommonCodeBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.basic;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD Business Logic Command Interface<br>
 * - -ESD Business Logic Interface<br>
 *
 * @author 
 * @see EsdTpb001EventResponse reference
 * @since J2EE 1.4
 */
public interface CommonCodeBC  {

	/**
	 *  retrieving cnt_cd of MNR base by ofc_cd of session 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getMDMCntCd(String ofc_cd) throws EventException;	
	/**
	 * retrieve event<br>
	 * CodeManage event<br>
	 * 
	 * @param e EsdTpb001Event
	 * @return EventResponse EsdTpb001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCode(Event e) throws EventException;

	/**
	 * Office Level retrieve<br>
	 * @param officeCode - Office Code 
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @exception EventException
	 */
	public String[] searchOfficeLevel(String officeCode) throws EventException;
	/**
	 * <br>
	 * 
	 * @param String mainCode
	 * @param String sDefaultSelectCode
	 * @param String[][] addOptionInfo
	 * @param String[] codeConditionPositiveArr
	 * @param String[] codeConditionNegativeArr
	 * @param int sortKey
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchCodeComboData(
			String mainCode, 
			String sDefaultSelectCode, 
			String[][] addOptionInfo, 
			String[] codeConditionPositiveArr, 
			String[] codeConditionNegativeArr, 
			int sortKey
			) throws EventException;
	/**
	 * <br>
	 * 
	 * @param String officeCode
	 * @param boolean isIncludeControlOffice
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchHandleOfficeLevel(String officeCode, boolean isIncludeControlOffice) throws EventException;
	/**
	 * <br>
	 * 
	 * @param String officeCode
	 * @return String searchOfficeTopLevel
	 * @exception EventException
	 */
	public String searchOfficeTopLevel(String officeCode) throws EventException;
	/**
	 * <br>
	 * @return String
	 * @exception EventException
	 */
	public String searchTPBSeq() throws EventException;
	/**
	 * <br>
	 * @param officeCode - Office Code 
	 * @return String - Y/N
	 * @exception EventException
	 */
	public String searchIsTPBOffice(String officeCode) throws EventException;
	/**
	 * CodeManage screen retrieve event<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBillingCaseCodeByTES() throws EventException;

}