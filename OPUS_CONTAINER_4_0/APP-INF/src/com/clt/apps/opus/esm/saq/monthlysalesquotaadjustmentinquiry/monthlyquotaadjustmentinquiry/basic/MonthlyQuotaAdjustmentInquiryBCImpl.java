/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : MonthlyQuotaAdjustmentInquiryBCImpl.java
 *@FileTitle      : Trade Group
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    :
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.integration.MonthlyQuotaAdjustmentInquiryDBDAO;
import com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.vo.SearchMonthlyQuotaInquiryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * MonthlySalesQuotaAdjustmentInquiry Business Logic Command Interface<br>
 * - handling business transaction<br>
 * 
 * @see MonthlyQuotaAdjustmentInquiryBC
 * @author
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentInquiryBCImpl extends BasicCommandSupport implements MonthlyQuotaAdjustmentInquiryBC {

	// Database Access Object
	private transient MonthlyQuotaAdjustmentInquiryDBDAO dbDao = null;

	/**
	 * related objects creation<br>
	 */
	public MonthlyQuotaAdjustmentInquiryBCImpl() {
		dbDao = new MonthlyQuotaAdjustmentInquiryDBDAO();
	}

	/**
	 * handling business transaction
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab01(QuotaConditionVO conditionvo) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaInquiry0049Tab01(conditionvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * handling business transaction
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab02(QuotaConditionVO conditionvo) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaInquiry0049Tab02(conditionvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * handling business transaction
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab03(QuotaConditionVO conditionvo) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaInquiryHR0049Tab03(conditionvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * handling business transaction
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab03Sub(QuotaConditionVO conditionvo) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaInquiry0049HRTab03Sub(conditionvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * handling business transaction
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab04(QuotaConditionVO conditionvo) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaInquiry0049Tab04(conditionvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * handling business transaction
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab05(QuotaConditionVO conditionvo) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaInquiry0049Tab05(conditionvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;

		try {

			String isRhq = dbDao.isRhq(conditionVO.getRhqCd());
			conditionVO.setIsRhq(isRhq);
			conditionVO.setOrgType("RHQ");
			conditionVO.setOfcCd("");

			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0088Tab01(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab02(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;

		try {

			String isRhq = dbDao.isRhq(conditionVO.getRhqCd());
			conditionVO.setIsRhq(isRhq);
			conditionVO.setOrgType("RHQ");
			conditionVO.setOfcCd("");

			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0088Tab02(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab03(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;

		try {

			String isRhq = dbDao.isRhq(conditionVO.getRhqCd());
			conditionVO.setIsRhq(isRhq);

			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0088Tab03(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab03Child(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;

		try {

			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0088Tab03Child(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab04(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;

		try {

			String isRhq = dbDao.isRhq(conditionVO.getRhqCd());
			conditionVO.setIsRhq(isRhq);

			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0088Tab04(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab05(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;

		try {

			String isRhq = dbDao.isRhq(conditionVO.getRhqCd());
			conditionVO.setIsRhq(isRhq);

			// LIST 조회
			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0088Tab05(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0089Tab01(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;

		try {

			conditionVO.setIsRhq("");
			conditionVO.setOrgType("OFC");
			conditionVO.setRhqCd("");

			// LIST 조회
			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0088Tab01(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0089Tab02(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;

		try {

			conditionVO.setIsRhq("");
			conditionVO.setOrgType("OFC");
			conditionVO.setRhqCd("");

			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0088Tab02(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0089Tab04(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaInquiryListVO> searchMonthlyQuotaInquiryListVOs = null;
		try {
			searchMonthlyQuotaInquiryListVOs = dbDao.searchMonthlyQuotaInquiry0089Tab04(conditionVO);
			listVO.addList(searchMonthlyQuotaInquiryListVOs);

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}