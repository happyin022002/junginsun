/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckBCImpl.java
*@FileTitle : common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration.JOOFindCodeAndCheckDBDAO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoGrpVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComActualCarrierVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComCodeVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComRlaneVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-JOOCommon Business Logic Basic Command implementation<br>
 * - OPUS-JOOCommon: handling business logic<br>
 *
 * @author
 * @see JOOCommonEventResponse,JOOFindCodeAndCheckBC DAO class
 * @since J2EE 1.4
 */

public class JOOFindCodeAndCheckBCImpl extends BasicCommandSupport implements JOOFindCodeAndCheckBC {

	// Database Access Object
	private transient JOOFindCodeAndCheckDBDAO dbDao = null;

	/**
	 * JOOFindCodeAndCheckBCImpl object creation<br>
	 * JOOFindCodeAndCheckDBDAO creation<br>
	 */
	public JOOFindCodeAndCheckBCImpl() {
		dbDao = new JOOFindCodeAndCheckDBDAO();
	}

	/**
	 * retrieving MDM TRADE CODE
	 * Search Condition : code = trade code (optional) 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchMdmTrdCdList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchMdmTrdCdList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"MDM Trade", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"MDM Trade", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/**
	 * retrieving MDM Revenue Lane
	 * Search Condition 
	 * - super_cd1 : representative Trade
	 * - code : Lane code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchMdmRlaneCdList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchMdmRlaneCdList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"MDM Lane", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"MDM Lane", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Common Code (com_intg_cd_dtl)
	 * Search Condition
	 *  - super_cd1 : group code(intg_cd_id) - mandatory
	 *  - code : (intg_cd_val_ctnt) - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchComCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchComCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		}
	}


	/**
	 * validation checking and retrieving customer name in case of inpputing  customer code by key-in
	 * Search Condition 
	 *  - code : cust_cnt_cd, cust_seq
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCustomerList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCustomerList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Customer Information", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Customer Information", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * validation checking and retrieving vendor name in case of inpputing  vendor code by key-in
	 * Search Condition
	 *  - code : vendor code - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchVendorList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchVendorList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Service Provider Information", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Service Provider Information", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving trade code list used in joint operation 
	 * Search Condition
	 *  - super_cd1 : Carrier (optional)
	 *  - code : trade code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTradeCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchTradeCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Trade", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Trade", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving lane code list used in joint operation
	 * Search Condition 
	 *  - super_cd1 : Carrier code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRlaneCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRLaneCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving trade and lane list used in joint operation
	 * Search Condition : exists not
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRLaneCodeListByTrade(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRLaneCodeListByTrade(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/**
	 * retrieving carrier code used in joint operation
	 * Search Condition 
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCarrierCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * VVD Validation Check in Vessel schedule
	 * Search Condition 
	 *  - code : Vessel Code, Voyage Number, Direction (mandatory)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> checkVVD(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.checkVVD(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"VSK VVD Validation", "Check"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"VSK VVD Validation", "Check"}).getUserMessage(), ex);
		}
	}


	/**
	 * checking validation of account item by key-in
	 * Search Condition 
	 *  - code : account item code(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchItemAcctList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchItemAcctList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Account Item Validation", "Check"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Account Item Validation", "Check"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Settlement Account Code List (joo_stl_itm)
	 * Search Condition
	 *  - super_cd1 : jo_auto_cre_flg (optional)
	 *  - super_cd2 : jo_mnl_cre_flg (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchStlItemCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchStlItemCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Settlement Item", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Settlement Item", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Rev Dir, Basic Port List, Pair Port List, Unit Cost Port List 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return JooCodeInfoGrpVO
	 * @throws EventException
	 */
	public JooCodeInfoGrpVO searchRevDirPortList(JooCodeParamVO jooCodeParamVO) throws EventException {
		JooCodeInfoGrpVO grpVO = null;
		try {
			grpVO = new JooCodeInfoGrpVO();
			grpVO.setJooCodeInfoVO1s(dbDao.searchRevDirBasicPortList(jooCodeParamVO));
			grpVO.setJooCodeInfoVO2s(dbDao.searchPairPortList(jooCodeParamVO));
			grpVO.setJooCodeInfoVO3s(dbDao.searchUnitCostPortList(jooCodeParamVO));
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenue Direction, Ports", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenue Direction, Ports", "Retrieve"}).getUserMessage(), ex);
		}
		return grpVO;
	}

	/**
	 * retrieving port list that ETA is after -100 days
	 * Search Condition
	 *  - super_cd1 : lane code 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchPortListByLane(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchPortListByLane(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Port List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Port List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving VSK_CARRIER
	 * Search Condition
	 *  - code : Carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchVskCarrierList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchVskCarrierList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"VSK Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"VSK Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Office Code and name in AP_WORKPLACE
	 * Search Condition : exists not
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTaxOfcList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchTaxOfcList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Office Code and Name in AP_WORKPLACE", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Office Code and Name in AP_WORKPLACE", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Unit Cost Port in Vessel Port Schedule by Lane and VVD
	 * Search Condition
	 *  - super_cd1 : lane code - mandatory
	 *  - super_cd2 : VVD (9 digits) - mandatory
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchUnitCostPortList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchUnitCostPortList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Unit Cost Port", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Unit Cost Port", "Retrieve"}).getUserMessage(), ex);
		}
	}


	/**
	 * retrieving Lane, RTU, Currency
	 * Search Condition
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : settlement ITEM (mandatory)
	 *  - name : (re_divr_cd) (mandatory)  
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRlaneRTUList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRLaneRTUList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Lane, RTU, Currency", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Lane, RTU, Currency", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * getting Rlane and Currency of Financial Matix in case of changing Trade
	 * Search Condition
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : settlement ITEM (mandatory)
	 *  - name : (re_divr_cd) (mandatory)  
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRlaneCurrList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRLaneCurrList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Lane, Currency", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Lane, Currency", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving combined no in JOO_STL_CMB
	 * Search Condition
	 *  - super_cd1 : Account Month (ACCT_YRMON)
	 *  - super_cd2 : Carrier Code (JO_CRR_CD)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCombinedNoList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCombinedNoList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Combined No List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Combined No List", "Retrieve"}).getUserMessage(), ex);
		}
	}
    /**
     * 
     * retrieving JOO_STL_ITM<br>
     * @param jooCodeParamVO
     * @throws EventException
     * @return List<JooCodeInfoVO>
     * @author 
     */ 
    public List<JooCodeInfoVO> searchSettlementItemCodeList(
            JooCodeParamVO jooCodeParamVO) throws EventException {
        try {
            return dbDao.searchSettlementItemCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Settlement Item List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Settlement Item List", "Retrieve"}).getUserMessage(), ex);
        }
    }

    /**
     * checking Estimation closing status
     * @param JooCodeParamVO jooCodeParamVO
     * @return JooCodeInfoVO
     * @throws EventException
     */
    public JooCodeInfoVO searchCheckEstmClz(JooCodeParamVO jooCodeParamVO) throws EventException {
        try {
            return dbDao.searchCheckEstmClz(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Estimation Closing Flag", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Estimation Closing Flag", "Retrieve"}).getUserMessage(), ex);
        }
    }

	/**
	 * retrieving carrier code used in joint operation
	 * Search Condition 
	 *  - super_cd2 : trade code (optional)
	 *  - super_cd1 : rlane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierCodeListByTradeAndRlane(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCarrierCodeListByTradeAndRlane(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving REVENUE MONTH MINIMUM, MAXMUM
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<EstmConditionVO> searchRevYrmonFrTo(EstmConditionVO estmConditionVO) throws EventException {
		try {
			return dbDao.searchRevYrmonFrTo(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenue month Min ~ Max", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenue month Min ~ Max", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Trade code list
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<EstmConditionVO> searchTradeCodeListEstm(EstmConditionVO estmConditionVO) throws EventException {
		try {
			return dbDao.searchTradeCodeListEstm(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Rlane code list
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<EstmConditionVO> searchRlaneCodeListEstm(EstmConditionVO estmConditionVO) throws EventException {
		try {
			return dbDao.searchRlaneCodeListEstm(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Carrier code list
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws EventException
	 */
	public List<EstmConditionVO> searchCarrierCodeListEstm(EstmConditionVO estmConditionVO) throws EventException {
		try {
			return dbDao.searchCarrierCodeListEstm(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
 
    /**
     * retrieving MDM_VSL_SVC_LANE Rlane code list used in joint operation
     * Search Condition 
     *  - code : Lane code (optional)
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchSvcRlaneCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
        try {
            return dbDao.searchSvcRlaneCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"MDM_VSL_SVC_LANE Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"MDM_VSL_SVC_LANE Code List", "Retrieve"}).getUserMessage(), ex);
		}
    } 

	/**
	 * retrieving Rlane list in case of changing carrier, trade code
	 * Search Condition 
	 *  - super_cd1 : Carrier code (mandatory)
	 *  - super_cd2 : Trade code (mandatory)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRLaneStlOptList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRLaneStlOptList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Lane and Settlement Option", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Lane and Settlement Option", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving AR HQ office code of login user
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return String
	 * @throws EventException
	 */
	public String searchArHqOfcCd(JooCodeParamVO jooCodeParamVO) throws EventException {
		String arHqOfcCd = "";
		try {
			List<JooCodeInfoVO> list = dbDao.searchArHqOfcList(jooCodeParamVO);
			
			if (!list.isEmpty() && list.size() > 0){
				arHqOfcCd = list.get(0).getCode();
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"AR Head Quarter Office Code", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"AR Head Quarter Office Code", "Retrieve"}).getUserMessage(), ex);
		}
		
		return arHqOfcCd;
	}
	
	/**
	 * retrieving AR RHQ OFFICE code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchArHqOfcAllList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchArHqOfcAllList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"AR Head Quarter Office Code list", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"AR Head Quarter Office Code list", "Retrieve"}).getUserMessage(), ex);
		} 
	}
	
	/**
	 * returning local datetime of login user
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchLocalDateTime(String ofcCd) throws EventException {
		try {
			return dbDao.searchLocalDateTime(ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Get Local DateTime", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Get Local DateTime", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving  Revenue Direction, UnitCostPort List
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRevDirAndUnitCostPortList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRevDirAndUnitCostPortList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenu Direction and Unit Cost Port List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenu Direction and Unit Cost Port List", "Retrieve"}).getUserMessage(), ex);
		}
	}
    /**
     * retrieving  SLP_OFC_CD of JOO_SLIP 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO> 
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchOfcCdSlip(JooCodeParamVO jooCodeParamVO)  throws EventException {
        try {
            return dbDao.searchOfcCdSlip(jooCodeParamVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Get Office Code List", "Retrieve"}).getUserMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Get Office Code List", "Retrieve"}).getUserMessage(), ex);
        }
    }

    /**
     * retrieving  Authority Office Code 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO> 
     * @throws EventException
     */
 
    public List<JooCodeInfoVO> searchAuthOfficeList(JooCodeParamVO jooCodeParamVO)  throws EventException {
        try { 
            return dbDao.searchAuthOfficeList(jooCodeParamVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Get Office Code List", "Retrieve"}).getUserMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Get Office Code List", "Retrieve"}).getUserMessage(), ex);
        }
    }
    /**
     * retrieving office code check 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchOfcCd(JooCodeParamVO jooCodeParamVO) throws EventException {
 
        try {
            return  dbDao.searchOfcCd(jooCodeParamVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Office Code", "Retrieve"}).getUserMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Office Code", "Retrieve"}).getUserMessage(), ex);
        }
    }
    /**
     * retrieving carrier code 3 digits 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchRLaneStlOpt3CodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
 
        try {
            return  dbDao.searchRLaneStlOpt3CodeList(jooCodeParamVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Office Code", "Retrieve"}).getUserMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Office Code", "Retrieve"}).getUserMessage(), ex);
        }
    }
    
 
    /**
     * retrieving Combined No
     * 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchCombinedNoOptAuthList(
            JooCodeParamVO jooCodeParamVO) throws EventException {
        try {
            return  dbDao.searchCombinedNoOptAuthList(jooCodeParamVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Office Code", "Retrieve"}).getUserMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Office Code", "Retrieve"}).getUserMessage(), ex);
        }
    }
    /**
     * checking validation of VSL CODE + VOYAGE NUMBER
     * 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchVslVoyageList(JooCodeParamVO jooCodeParamVO) throws EventException{
        try {
            return  dbDao.searchVslVoyageList(jooCodeParamVO);
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Vsl Voyage", "Retrieve"}).getUserMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO00032", new String[]{"Vsl Voyage", "Retrieve"}).getUserMessage(), ex);
        }
    }
 
	/**
	 * retrieving carrier code used in joint operation
	 * Search Condition 
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving trade code list used in joint operation 
	 * Search Condition
	 *  - super_cd1 : Carrier (optional)
	 *  - code : trade code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTradeCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchTradeCodeWithoutAuthorityList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Trade", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Trade", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving lane code list used in joint operation
	 * Search Condition 
	 *  - super_cd1 : Carrier code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRlaneCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRLaneCodeWithoutAuthorityList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/**
	 * retrieving lane code list used in joint operation
	 * Search Condition 
	 * @param String ofcCd
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierByLaneList(String ofcCd) throws EventException {
		try {
			return dbDao.searchCarrierByLaneList(ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	
	/**
	 * retrieving Carrier, Trade, Lane Code used in joint operation only
	 * Search Condition 
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierTradeLaneWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCarrierTradeLaneWithoutAuthorityList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	
	/**
	 * Common Tax Type Search.
	 * Search Condition 
	 *  - code : tax group code (optional)
	 *  - sortkey : 0 - dp_seq
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTaxTypeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchTaxTypeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Tax Type", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Tax Type", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Direction list
	 * Search Condition
	 *  - super_cd1 : lane code 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchVslSlanDirCdByLane(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchVslSlanDirCdByLane(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Direction List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Direction List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Direction list
	 * Search Condition
	 *  - code : joo_com_ppt 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooComCodeVO> searchJooComCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchJooComCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joo Com ppt List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joo Com ppt List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Direction list
	 * Search Condition
	 *  - code : joo_com_ppt Laden
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooComCodeVO> searchJooComCodeByLadenList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchJooComCodeByLadenList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joo Com ppt List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joo Com ppt List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Direction list
	 * Search Condition
	 *  - code : joo_com_ppt Empty
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO> 
	 * @throws EventException
	 */
	public List<JooComCodeVO> searchJooComCodeByEmptyList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchJooComCodeByEmptyList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joo Com ppt List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joo Com ppt List", "Retrieve"}).getUserMessage(), ex);
		}
	}
 
    /**
     * retrieving 공동운항에서 사용하는 VSK_VSL_SKD, MDM_VSL_SVC_LANE vsl_slan_cd used in joint operation
     * Search Condition 
     *  - code : vsl_cd + skd_voy_no
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws EventException
     */
    public List<JooCodeInfoVO> searchVslSlanCdInfoByVvd(JooCodeParamVO jooCodeParamVO) throws EventException {
        try {
            return dbDao.searchVslSlanCdInfoByVvd(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"VSK_VSL_SKD & MDM_VSL_SVC_LANE Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"VSK_VSL_SKD & MDM_VSL_SVC_LANE Code List", "Retrieve"}).getUserMessage(), ex);
		}
    }

	/**
	 * JOO_STL_CMB 전표 번호를 체크 한다.
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckDBDAOCheckSlipByStlCmbSeq(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCheckDBDAOCheckSlipByStlCmbSeq(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
     * 공통 Rlane_cd 조회 
     *  -rlane_cd, JO_CRR_CD, TRD_CD, JO_STL_OPT_CD, JO_CRR_AUTH_CD, LOCL_CURR_CD, JO_STL_TGT_TP_CD
	 * @param JooComRlaneVO jooComRlaneVO
	 * @return List<JooComRlaneVO>
	 * @throws EventException
	 */
	public List<JooComRlaneVO> searchRlaneCodeList(JooComRlaneVO jooComRlaneVO) throws EventException {
		try {
			return dbDao.searchRlaneCodeList(jooComRlaneVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * retrieving Common Code: Region (com_intg_cd_dtl)
	 * Search Condition
	 *  - super_cd1 : group code(intg_cd_id) - mandatory
	 *  - code : (intg_cd_val_ctnt) - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRegionList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRegionList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * Actual Carrier/Vender/Coustomer 조회합니다.
	 * 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooComActualCarrierVO>
	 * @throws EventException
	 */
	public List<JooComActualCarrierVO> searchActualCarrierList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchActualCarrierList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Actual Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Actual Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}
}