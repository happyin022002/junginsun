/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaInquiryBC.java
*@FileTitle      : QtaInquiryBC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
* 2014.07.30 이혜민 [CHM-201431302] QTA Inquiry_Quarterly Current QTA Report for IAS Sector 에서 Raw Data Export 산출 로직 변경 CSR
* 2015.01.16 이혜민 [CHM-201533644] Raw data Export 보완
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtainquiry.basic;

import java.util.List;

import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchCurrentQtaIasSectorVO;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchQuarterlyCurrnetQtaListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchYearlyCurrnetQtaListVO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-QtaInquiry Business Logic Command Interface<br>
 * - ALPS-QtaInquiry 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see
 * @since J2EE 1.6
 */
public interface QtaInquiryBC {
	
	/**
	 * ESM_CSQ_0057 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchYearlyCurrnetQtaListVO>
	 * @throws EventException
	 */
	public List<SearchYearlyCurrnetQtaListVO> searchYearlyCurrnetQtaList(ConditionVO conditionVO, String excelFlg) throws EventException;
	/**
	 * ESM_CSQ_0057 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownYearlyCurrentQta(ConditionVO conditionVO, String excelFlg) throws EventException;
	/**
	 * ESM_CSQ_0058 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchQuarterlyCurrnetQtaListVO>
	 * @throws EventException
	 */
	public List<SearchQuarterlyCurrnetQtaListVO> searchQuarterlyCurrnetQtaList(ConditionVO conditionVO, String excelFlg) throws EventException;
	/**
	 * ESM_CSQ_0058 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownQuarterlyCurrentQta(ConditionVO conditionVO, String excelFlg) throws EventException;
	/**
	 * ESM_CSQ_0223: Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptYrIasSector(ConditionVO conditionVO, String excelFlg) throws EventException;
	/**
	 * ESM_CSQ_0223 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSector(ConditionVO conditionVO, String excelFlg) throws EventException;
	/**
	 * ESM_CSQ_0224 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptQtrIasSector(ConditionVO conditionVO, String excelFlg) throws EventException;
	/**
	 * ESM_CSQ_0224 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownCurrQtaReptQtrIasSector(ConditionVO conditionVO, String excelFlg) throws EventException;
}