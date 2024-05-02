/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInquiryBCImpl.java
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration.TCharterIOInquiryDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.CondSearchFleetStatusVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchCapitalBudgetSumListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchFleetStatusSumListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo.SearchStatementOfAccountSumListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-TimeCharterInOutFleetManagement Business Logic Basic Command implementation<br>
 * - Handling Business Logic of OPUS-TimeCharterInOutFleetManagement<br>
 *
 * @author 
 * @see ESM_FMS_0060EventResponse,TCharterIOInquiryBC Reference to each DAO Class
 * @since J2EE 1.6
 */
public class TCharterIOInquiryBCImpl extends BasicCommandSupport implements TCharterIOInquiryBC {

	// Database Access Object
	private transient TCharterIOInquiryDBDAO dbDao = null;

	/**
	 * Generating TCharterIOInquiryBCImpl Object<br>
	 * Generating TCharterIOInquiryDBDAO<br>
	 */
	public TCharterIOInquiryBCImpl() {
		dbDao = new TCharterIOInquiryDBDAO();
	}
	
	/**
	 * Retrieving current Fleet status<br>
	 * 
	 * @param condSearchFleetStatusVO CondSearchFleetStatusVO
	 * @return List<SearchFleetStatusListVO>
	 * @exception EventException
	 */
	public List<SearchFleetStatusListVO> searchFleetStatusList(CondSearchFleetStatusVO condSearchFleetStatusVO) throws EventException {
		try {
			condSearchFleetStatusVO.setVslSize1(condSearchFleetStatusVO.getVslSize1().replaceAll(",", ""));
			condSearchFleetStatusVO.setVslSize2(condSearchFleetStatusVO.getVslSize2().replaceAll(",", ""));
			return dbDao.searchFleetStatusList(condSearchFleetStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01602",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01602",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Calculating Hire Sum of Fleet status by Currency<br>
	 * 
	 * @param condSearchFleetStatusSumVO CondSearchFleetStatusSumVO
	 * @return List<SearchFleetStatusSumListVO>
	 * @exception EventException
	 */
	public List<SearchFleetStatusSumListVO> searchFleetStatusSumList(CondSearchFleetStatusSumVO condSearchFleetStatusSumVO) throws EventException {
		try {
			condSearchFleetStatusSumVO.setVslSize1(condSearchFleetStatusSumVO.getVslSize1().replaceAll(",", ""));
			condSearchFleetStatusSumVO.setVslSize2(condSearchFleetStatusSumVO.getVslSize2().replaceAll(",", ""));
			return dbDao.searchFleetStatusSumList(condSearchFleetStatusSumVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01602",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01602",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving total summary about Calculating Requirement executed after starting Vessel Charter/Hire Out one by one by Sequence<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountListVO>
	 * @exception EventException
	 */
	public List<SearchStatementOfAccountListVO> searchStatementOfAccountList(String fletCtrtNo, String hirNo) throws EventException {
		try {
			return dbDao.searchStatementOfAccountList(fletCtrtNo, hirNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01601",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01601",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving total summary about Calculating Requirement executed after starting Vessel Charter/Hire Out by Sequence and Currency<br>
	 * 
	 * @param fletCtrtNo String
	 * @param hirNo String
	 * @return List<SearchStatementOfAccountSumListVO>
	 * @exception EventException
	 */
	public List<SearchStatementOfAccountSumListVO> searchStatementOfAccountSumList(String fletCtrtNo, String hirNo) throws EventException {
		try {
			return dbDao.searchStatementOfAccountSumList(fletCtrtNo, hirNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01601",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01601",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Capital Budget data<br>
	 * 
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchCapitalBudgetListVO>
	 * @exception EventException
	 */
	public List<SearchCapitalBudgetListVO> searchCapitalBudgetList(String effDt, String expDt, String vslCd) throws EventException {
		try {
			effDt = JSPUtil.removeCharacter(effDt,"-");
			expDt = JSPUtil.removeCharacter(expDt,"-");
			
			return dbDao.searchCapitalBudgetList(effDt, expDt, vslCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Capital Budget Sum by Currency <br>
	 * 
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchCapitalBudgetSumListVO>
	 * @exception EventException
	 */
	public List<SearchCapitalBudgetSumListVO> searchCapitalBudgetSumList(String effDt, String expDt, String vslCd) throws EventException {
		try {
			effDt = JSPUtil.removeCharacter(effDt,"-");
			expDt = JSPUtil.removeCharacter(expDt,"-");
			
			return dbDao.searchCapitalBudgetSumList(effDt, expDt, vslCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01600",new String[]{}).getMessage(), ex);
		}
	}
}