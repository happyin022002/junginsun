/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaInquiryBCImpl.java
*@FileTitle      : QtaInquiryBCImpl
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2014.07.30 이혜민 [CHM-201431302] QTA Inquiry_Quarterly Current QTA Report for IAS Sector 에서 Raw Data Export 산출 로직 변경 CSR
* 2015.01.16 이혜민 [CHM-201533644] Raw data Export 보완
* 2015.07.17 김용습 [CHM-201537066] [CSR 전환건] QTA Inquiry_Yearly Current QTA Report for IAS Sector 조회 로직 변경
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.integration.QtaInquiryDBDAO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchCurrentQtaIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchQuarterlyCurrnetQtaListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchYearlyCurrnetQtaListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-QtaInquiry Business Logic Command Interface<br>
 * - ALPS-QtaInquiry 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see QtaInquiryDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class QtaInquiryBCImpl extends BasicCommandSupport implements QtaInquiryBC {
	
	// Database Access Object
	private transient QtaInquiryDBDAO dbDao = null;
	
	/**
	 * QtaInquiryBCImpl 객체 생성<br>
	 * QtaInquiryDBDAO를 생성한다.<br>
	 */
	public QtaInquiryBCImpl() {
		dbDao = new QtaInquiryDBDAO();
	}
	
	/**
	 * ESM_SQM_0036 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchYearlyCurrnetQtaListVO>
	 * @throws EventException
	 */
	public List<SearchYearlyCurrnetQtaListVO> searchYearlyCurrnetQtaList(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchYearlyCurrnetQtaList(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0036 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다. (Previous Version)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchYearlyCurrnetQtaListVO>
	 * @throws EventException
	 */
	public List<SearchYearlyCurrnetQtaListVO> searchYearlyCurrnetQtaListPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchYearlyCurrnetQtaListPreviousVersion(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0036 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownYearlyCurrentQta(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownYearlyCurrentQta(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0036 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다. (PreviousVersion)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownYearlyCurrentQtaPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownYearlyCurrentQtaPreviousVersion(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0037 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchQuarterlyCurrnetQtaListVO>
	 * @throws EventException
	 */
	public List<SearchQuarterlyCurrnetQtaListVO> searchQuarterlyCurrnetQtaList(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchQuarterlyCurrnetQtaList(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0037 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다. (PreviousVersion)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchQuarterlyCurrnetQtaListVO>
	 * @throws EventException
	 */
	public List<SearchQuarterlyCurrnetQtaListVO> searchQuarterlyCurrnetQtaListPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchQuarterlyCurrnetQtaListPreviousVersion(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0037 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownQuarterlyCurrentQta(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownQuarterlyCurrentQta(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0037 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다. (Previous Version)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownQuarterlyCurrentQtaPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownQuarterlyCurrentQtaPreviousVersion(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0225: Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (Initially Fixed)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptYrIasSector(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchCurrQtaReptYrIasSector(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0225: Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptYrIasSectorPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchCurrQtaReptYrIasSectorPreviousVersion(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0225: Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (Currently Updated)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptYrIasSectorCurrentlyUpdated(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchCurrQtaReptYrIasSectorCurrentlyUpdated(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.(Initially Fixed)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSector(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownCurrQtaReptYrIasSector(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSectorCurrentlyUpdated(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownCurrQtaReptYrIasSectorCurrentlyUpdated(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.(Initially Fixed) (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSectorPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownCurrQtaReptYrIasSectorPreviousVersion(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSectorCurrentlyUpdatedPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownCurrQtaReptYrIasSectorCurrentlyUpdatedPreviousVersion(conditionVO, excelFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0226 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptQtrIasSector(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchCurrQtaReptQtrIasSector(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0226 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다. (Previous Version)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws EventException
	 */
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptQtrIasSectorPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException{
		try {
			return dbDao.searchCurrQtaReptQtrIasSectorPreviousVersion(conditionVO, excelFlg);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0226 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownCurrQtaReptQtrIasSector(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownCurrQtaReptQtrIasSector(conditionVO, excelFlg);
		} catch (DAOException ex) {
			
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SQM_0226 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다. (PreviousVersion)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet excelDownCurrQtaReptQtrIasSectorPreviousVersion(ConditionVO conditionVO, String excelFlg) throws EventException {
		try {
			return dbDao.excelDownCurrQtaReptQtrIasSectorPreviousVersion(conditionVO, excelFlg);
		} catch (DAOException ex) {
			
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}