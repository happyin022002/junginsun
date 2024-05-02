/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: CntrAccuracyTrendBCImpl.java
*@FileTitle 	: Accuracy Trend
*Open Issues 	:
*Change history :
* No.	Ver.		Modifier			modifier date    explanation
* 1     1.0      	SHIN DONG IL		2013.07.11		 Creation
*
*@LastModifyDate : 2013.07.11
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.07.11 SHIN DONG IL
* 1.0 Creation 
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.basic;

import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.integration.CntrAccuracyTrendDBDAO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * @author SHIN DONG IL
 * @see EES_EQR_1025EventResponse,CntrAccuracyTrendBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrAccuracyTrendBCImpl extends BasicCommandSupport implements CntrAccuracyTrendBC {

	// Database Access Object
	private transient CntrAccuracyTrendDBDAO dbDao = null;

	/**
	 * CntrAccuracyTrendBCImpl 객체 생성<br>
	 * CntrAccuracyTrendDBDAO 생성한다.<br>
	 */
	public CntrAccuracyTrendBCImpl() {
		dbDao = new CntrAccuracyTrendDBDAO();
	}
	
	/**
	 * [ EES_EQR_1025 :  Loading Trend By Lane List ]<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchLoadingTrendByLaneDefault(EesEqr1025ConditionVO condVO) throws EventException {
		CommonVO defaultData = null; 
		try {
			defaultData =dbDao.searchLoadingTrendByLaneDefault(condVO);
			return defaultData;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ EES_EQR_1025 : Loading Trend By Lane ] <br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLoadingTrendByLaneList(EesEqr1025ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchLoadingTrendByLaneList(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 입력 받은 Loaction Code가 LCC/ECC/SCC에 해당하는지 체크<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckLocCd(EesEqr1025ConditionVO condVO) throws EventException {
		try{
			return dbDao.searchCheckLocCd(condVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"checkLocCd"}).getMessage(),ex);
		}
    }
    
	/**
	 * 입력 받은 VVD CD 유효성 체크<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckVvdCd(EesEqr1025ConditionVO condVO) throws EventException {
		try{
			return dbDao.searchCheckVvdCd(condVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"checkLocCd"}).getMessage(),ex);
		}
    }

	/**
	 * [ EES_EQR_1066 :  Loading Trend By Port List ]<br>
	 * 화면 로딩시 기본 설정 데이터 
	 * @param EesEqr1066ConditionVO condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchLoadingTrendByPortDefault(EesEqr1066ConditionVO condVO) throws EventException {
		CommonVO defaultData = null; 
		try {
			defaultData =dbDao.searchLoadingTrendByPortDefault(condVO);
			return defaultData;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	 
	
	/**
	 * [ EES_EQR_1066 : Loading Trend By Port ] <br>
	 * @param EesEqr1066ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLoadingTrendByPortList(EesEqr1066ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchLoadingTrendByPortList(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1026 : Discharge Result Default ]<br>
	 * 화면 로딩시 기본 설정 데이터
	 * @param EesEqr1026ConditionVO condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchDischargeResultDefault(EesEqr1026ConditionVO condVO) throws EventException {
		CommonVO defaultData = null; 
		try {
			defaultData =dbDao.searchDischargeResultDefault(condVO);
			return defaultData;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1026 : Discharge Result ] <br>
	 * @param EesEqr1026ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDischargeResultList(EesEqr1026ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchDischargeResultList(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
}