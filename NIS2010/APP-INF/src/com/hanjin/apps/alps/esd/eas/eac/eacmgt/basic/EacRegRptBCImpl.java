/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EacRegRptBCImpl.java
*@FileTitle : Expense Audit case Report
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic;



import java.util.List;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration.EacRegRptDBDAO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcPerfVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRegRptVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRhqStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchSpPerfVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-Eac Business Logic Command Interface<br>
 * - ALPS-Eac에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI JONG HYEK
 * @see EacRegRptBC 참조
 * @since J2EE 1.6
 */

public class EacRegRptBCImpl extends BasicCommandSupport implements EacRegRptBC {

	// Database Access Object
	private transient EacRegRptDBDAO dbDao = null;

	/**
	 * EacRegRptBCImpl 객체 생성<br>
	 * EacMgtDBDAO를 생성한다.<br>
	 */
	public EacRegRptBCImpl() {
		dbDao = new EacRegRptDBDAO();
	}

	/**
	 * 오피스/월별 비용심사 실적 조회<br>
	 * @param SearchRegRptVO searchRegRptVO
	 * @return List<SearchOfcStatisticsVO>
	 * @exception EventException
	 */
	public List<SearchOfcStatisticsVO> searchOfcStatistics(SearchRegRptVO searchRegRptVO) throws EventException {
		try {
			// 조회
			return dbDao.searchOfcStatistics(searchRegRptVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * RHQ/월별 비용심사 실적 조회<br>
	 * @param SearchRegRptVO searchRegRptVO
	 * @return List<SearchRhqStatisticsVO>
	 * @exception EventException
	 */
	public List<SearchRhqStatisticsVO> searchRhqStatistics(SearchRegRptVO searchRegRptVO) throws EventException {
		try {
			// 조회
			return dbDao.searchRhqStatistics(searchRegRptVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Audit office 또는 Responsible Office별 실적 조회<br>
	 * @param SearchRegRptVO searchRegRptVO
	 * @return List<SearchOfcPerfVO>
	 * @exception EventException
	 */
	public List<SearchOfcPerfVO> searchOfcPerf(SearchRegRptVO searchRegRptVO) throws EventException {
		try {
			// 조회
			return dbDao.searchOfcPerf(searchRegRptVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * S/P별 실적 조회<br>
	 * @param SearchRegRptVO searchRegRptVO
	 * @return List<SearchSpPerfVO>
	 * @exception EventException
	 */
	public List<SearchSpPerfVO> searchSpPerf(SearchRegRptVO searchRegRptVO) throws EventException {
		try {
			// 조회
			return dbDao.searchSpPerf(searchRegRptVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}