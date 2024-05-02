/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckBCImpl.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.07 박희동
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.08 이준범 [CHM-201006731-01]
* 1. 대상 기능
*   - JO Member Information Creation(JOO_0066)
*   - Inquiry of JO Member Information(JOO_0067)
* 2. 보완 대상
*   - Revenue Lane 정보 반영 
*   - MS Office( Excel, Worl, Power Point등) 첨부
*   - Carrier Name등 컬럼 반영
* 3. 목 적
*   - 그동안 Excel로 관리되던  선사별 이력 관리를 시스템내에서 관리하도록 하며
*   - Pending 사항에 대한 등록을 통해 선사별  Pending 사항이 간과 , 누락되지 않도록 함 
*
* 2012.01.26 조병연[CHM-201215460-01]
* 제목 : [ALPS JOO] Estimate Performance Change Status I 신규개발 (2011년 12월 4차)
* 내용 : 매월 결산 후 "공동운항 선복 용/대선료 실적 현황" 보고 시, 전월 대상항차의 Estimate 변동 현황 분석을 위해 
* 첨부와 같이 신규개발을 요청 드립니다.
* (동일한 대상 기간의 추정실적 Data를 비교하여 변동 건을 포착/분석하는 기능)
* - 기대효과 1 : 기존의 Excel 수작업 업무를 시스템화함으로써 업무 편의성 및 효율성 제고
* - 기대효과 2 : Initial Estimate(ALPS BSA 모듈의 Data) 뿐 아니라 Adjusted Estimate
*   (ALPS JOO 모듈의 추정실적 생성 메뉴에서 User가 Manual로 조정한 Data)까지 자동으로 비교함으로써 변동 현황 
*  분석의 다각화 가능
*  
* 2012.02.10 조병연[CHM-201215990-01]
* Title : [ALPS JOO] Estimate Performance Change Status II 신규개발 (2012년 1월 2차)
* 내용 :
* - ALPS JOO 전월 대상항차 Estimate 변동 현황 분석기능 개발		
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration.JOOFindCodeAndCheckDBDAO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoGrpVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusVO;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;

/**
 * ALPS-JOOCommon Business Logic Basic Command implementation<br>
 * - ALPS-JOOCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Hee Dong
 * @see JOOCommonEventResponse,JOOFindCodeAndCheckBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class JOOFindCodeAndCheckBCImpl extends BasicCommandSupport implements JOOFindCodeAndCheckBC {

	// Database Access Object
	private transient JOOFindCodeAndCheckDBDAO dbDao = null;

	/**
	 * JOOFindCodeAndCheckBCImpl 객체 생성<br>
	 * JOOFindCodeAndCheckDBDAO를 생성한다.<br>
	 */
	public JOOFindCodeAndCheckBCImpl() {
		dbDao = new JOOFindCodeAndCheckDBDAO();
	}

	/**
	 * MDM TRADE CODE를 조회한다.
	 * 조회조건 : code = trade 코드 (optional) 
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
	 * MDM Revenue Lane을 조회한다.
	 * 조회조건 
	 * - super_cd1 : 대표Trade코드
	 * - code : Lane코드 
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
	 * Common Code 조회 (com_intg_cd_dtl)
	 * 조회조건
	 *  - super_cd1 : 그룹코드(intg_cd_id) - mandatory
	 *  - code : 코드(intg_cd_val_ctnt) - optional
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
	 * Key-in으로 customer code를 입력했을 경우 validation check 및 Customer 명을 조회한다.
	 * 조회조건 
	 *  - code : cust_cnt_cd, cust_seq를 붙여서 넘기고 substring으로 잘라서 사용 - mandatory
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
	 * Key-in으로 Vendor code를 입력했을 경우 올바른 Vendor코드인지 validation check 및 Vendor명을 조회하여 return한다.
	 * 조회조건
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
	 * 공동운항에서 사용하는 Trade 코드 List를 조회한다. 
	 * 조회조건
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
	 * 공동운항에서 사용하는 Lane 코드리스트를 조회한다.
	 * 조회조건 
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
	 * 공동운항에서 사용하는 TRADE와 LANE을 중복되지 않게 LIST 조회한다.
	 * 조회조건 : 없음
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
	 * 공동운항에서만 사용하는 Carrier Code 조회
	 * 조회조건 
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
	 * Vessel schedule에서 VVD Validation Check한다.
	 * 조회조건 
	 *  - code : Vessel Code, Voyage Number, Direction을 concat해서 substring으로 잘라서 사용한다. (mandatory)
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
	 * KEY-IN 한 Account Item을 MDM_ACCOUNT에서 해당 account item의 validation 을 check한다.
	 * 조회조건 
	 *  - code : account item 코드(optional)
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
	 * Settlement Account Code List를 조회한다. (joo_stl_itm)
	 * 조회조건
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
	 * Rlane과 VVD를 조회조건으로 Rev Dir과 Basic Port List, Pair Port List, Unit Cost Port List를 조회한다. 
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
	 * Vessel Port Schedule 에서 Rlane 변경시 ETA 일자가 100일전 이후 인 Port list를 조회한다.
	 * 조회조건
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
	 * VSK_CARRIER 를 조회
	 * 조회조건
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
	 * AP_WORKPLACE 에서 Office Code와 name을 조회한다.
	 * 조회조건 : 없음
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
	 * Lane코드와 VVD를 조회조건으로 Unit Cost Port를 Vessel Port Schedule에서 읽어온다.
	 * 조회조건
	 *  - super_cd1 : lane code - mandatory
	 *  - super_cd2 : VVD (9자리) - mandatory
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
	 * Settlement의 OUS RDR, OUS TDR, Reefer에서 적용할 Lane, RTU, Currency를 조회한다.
	 * 조회조건
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : 정산 ITEM (mandatory)
	 *  - name : 용,대선 구분(re_divr_cd) (mandatory)  
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
	 * Trade변경시 Rlane과 Financial Matrix의 Currency를 가져온다.
	 * OUS RDR, TDR, Reefer를 제외한 Settlement에서 사용한다.
	 * 조회조건
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : 정산 ITEM (mandatory)
	 *  - name : 용,대선 구분(re_divr_cd) (mandatory)  
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
	 * JOO_STL_CMB 에서 Combined No를 조회한다.
	 * 조회조건
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
     * JOO_STL_ITM 조회 합니다.<br>
     * @param jooCodeParamVO
     * @throws EventException
     * @return List<JooCodeInfoVO>
     * @author jang kang cheol
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
     * Estimation 마감여부를 check한다.
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
	 * TDR Carrier Code 조회, Period, rlane이 조회조건임
	 * @param TdrLoadVO tdrLoadVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTDRCarrierCodeListByPeriodAndRlane(TdrLoadVO tdrLoadVO) throws EventException {
		try {
			return dbDao.searchTDRCarrierCodeListByPeriodAndRlane(tdrLoadVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * RDR Carrier Code 조회, Period, rlane이 조회조건임
	 * @param RdrLoadVO rdrLoadVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRDRCarrierCodeListByPeriodAndRlane(RdrLoadVO rdrLoadVO) throws EventException {
		try {
			return dbDao.searchRDRCarrierCodeListByPeriodAndRlane(rdrLoadVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 공동운항에서만 사용하는 Carrier Code 조회, Trade, rlane이 조회조건임
	 * 조회조건 
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
	 * 추정결과테이블에서 시행월에 해당하는 REVENUE MONTH MINIMUM, MAXMUM을 조회한다.
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
	 * 추정결과테이블에서 조건에 해당하는 Trade코드List를 조회한다.
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
	 * 추정결과테이블에서 조건에 해당하는 Rlane코드List를 조회한다.
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
	 * 추정결과테이블에서 조건에 해당하는 Carrier코드List를 조회한다.
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
     * 공동운항에서 사용하는 MDM_VSL_SVC_LANE Rlane 코드리스트를 조회한다.
     * 조회조건 
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
	 * Carrier, Trade코드 변경시 Rlane List를 조회한다. (JO_STL_OPT_CD 함께 조회)
	 * 조회조건 
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
	 * Login한 User의 소속 AR HQ OFFICE코드를 조회한다.
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
	 * AR RHQ OFFICE 코드를 조회한다.
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
	 * Login한 User의 Office Code로 Location Code를 구해 Local DateTime을 return한다.
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
	 * Cycle의 경우 RevDir을 클릭하면 Revenue Direction과 UnitCostPort List를 조회한다.
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
     * JOO_SLIP의 SLP_OFC_CD을 조회한다. 
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
     * Authority Office Code를 조회한다. 
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
     * Office Code 체크 조회한다. 
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
     * Carrier 코드 조회 3자리 조회 
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
     * Combined No를 조회한다
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
     * VSL CODE + VOYAGE NUMBER 조합의 KEY 입력값 valide 체크.
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
	 * 공동운항에서만 사용하는 Carrier Code 조회
	 * 조회조건 
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
	 * 공동운항에서 사용하는 Trade 코드 List를 조회한다. 
	 * 조회조건
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
	 * 공동운항에서 사용하는 Lane 코드리스트를 조회한다.
	 * 조회조건 
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
	 * 공동운항에서 사용하는 Lane 코드리스트를 조회한다.
	 * 조회조건 
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
	 * 공동운항에서만 사용하는 Carrier, Trade, Lane Code 조회
	 * 조회조건 
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
	 * 추정결과테이블에서 시행월에 해당하는 REVENUE MONTH MINIMUM, MAXMUM을 조회한다.
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusVO>
	 * @throws EventException
	 */
	public List<EstmPerformanceChangeStatusVO> searchEstmRevYrmonFrTo(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws EventException {
		try {
			return dbDao.searchEstmRevYrmonFrTo(estmPerformanceChangeStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenue month Min ~ Max", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenue month Min ~ Max", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 추정결과테이블에서 조건에 해당하는 Trade코드List를 조회한다.
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusVO>
	 * @throws EventException
	 */
	public List<EstmPerformanceChangeStatusVO> searchEstmTradeCodeListEstm(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws EventException {
		try {
			return dbDao.searchEstmTradeCodeListEstm(estmPerformanceChangeStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 추정결과테이블에서 조건에 해당하는 Rlane코드List를 조회한다.
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusVO>
	 * @throws EventException
	 */
	public List<EstmPerformanceChangeStatusVO> searchEstmRlaneCodeListEstm(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws EventException {
		try {
			return dbDao.searchEstmRlaneCodeListEstm(estmPerformanceChangeStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 추정결과테이블에서 조건에 해당하는 Carrier코드List를 조회한다.
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusVO>
	 * @throws EventException
	 */
	public List<EstmPerformanceChangeStatusVO> searchEstmCarrierCodeListEstm(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws EventException {
		try {
			return dbDao.searchEstmCarrierCodeListEstm(estmPerformanceChangeStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * Common Code 조회 (com_intg_cd_dtl)
	 * 조회조건
	 *  - super_cd1 : 그룹코드(intg_cd_id) - mandatory
	 *  - code : 코드(intg_cd_val_ctnt) - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchComCodeNmList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchComCodeNmList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Common Code", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	
	
	/**
	 * 추정결과테이블에서 시행월에 해당하는 REVENUE MONTH MINIMUM, MAXMUM을 조회한다.
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusIIVO>
	 * @throws EventException
	 */
	public List<EstmPerformanceChangeStatusIIVO> searchEstmRevYrmonFrToEstmII(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusVO) throws EventException {
		try {
			return dbDao.searchEstmRevYrmonFrToEstmII(estmPerformanceChangeStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenue month Min ~ Max", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Revenue month Min ~ Max", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 추정결과테이블에서 조건에 해당하는 Trade코드List를 조회한다.
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
	 * @return List<EstmPerformanceChangeStatusIIVO>
	 * @throws EventException
	 */
	public List<EstmPerformanceChangeStatusIIVO> searchEstmTradeCodeListEstmII(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws EventException {
		try {
			return dbDao.searchEstmTradeCodeListEstmII(estmPerformanceChangeStatusIIVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Trade Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 추정결과테이블에서 조건에 해당하는 Rlane코드List를 조회한다.
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
	 * @return List<EstmPerformanceChangeStatusIIVO>
	 * @throws EventException
	 */
	public List<EstmPerformanceChangeStatusIIVO> searchEstmRlaneCodeListEstmII(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws EventException {
		try {
			return dbDao.searchEstmRlaneCodeListEstmII(estmPerformanceChangeStatusIIVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Rlane Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 추정결과테이블에서 조건에 해당하는 Carrier코드List를 조회한다.
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
	 * @return List<EstmPerformanceChangeStatusIIVO>
	 * @throws EventException
	 */
	public List<EstmPerformanceChangeStatusIIVO> searchEstmCarrierCodeListEstmII(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws EventException {
		try {
			return dbDao.searchEstmCarrierCodeListEstmII(estmPerformanceChangeStatusIIVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/**
	 * VVD code를 파라미터로 입력하여 Lane과 Region를 조회한다.
	 * 조회조건 
	 *  - code : Vvd code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchLaneRegion(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchLaneRegionList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	
	/**
	 * RDR Carrier Code 조회, Period, rlane이 조회조건임
	 * @param RdrLoadVO rdrLoadVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRDRCarrierCodeListByPeriodAndServiceLane(RdrLoadVO rdrLoadVO) throws EventException {
		try {
			return dbDao.searchRDRCarrierCodeListByPeriodAndServiceLane(rdrLoadVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier Code List", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/////////////
	

	/**
	 * 공통 : Lane Code 변경
	 * Lane변경시 Lane Code, Trade Code를 조회조건으로 VSK_VSL_PORT_SKD, MDM_REV_LANE 테이블에서 vsl_cd를 조회한다.
	 *  - super_cd1 : Lane code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRVslCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRVslCodeWithoutAuthorityList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * 공통 : Lane Code 변경
	 * Lane변경시 Lane Code, Trade Code, Vsl Code를 조회조건으로 VSK_VSL_PORT_SKD, MDM_REV_LANE 테이블에서 VPS_PORT_CD를 조회한다.
	 *  - super_cd1 : Lane code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - super_cd3 : Vsl code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRVpsPortCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRVpsPortCodeWithoutAuthorityList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Lane", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	
	
	
	/**
	 * BSA Information Entry 공통 MDM_VSL_CNTR 테이블에서 VSL_CD 조회
	 * 조회조건 
	 *  - super_cd1 : VSL_CD (optional)
	 *  - code : VSL_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchVslCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchVslCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}	
	
	
	/**
	 * BSA Information Entry 공통 MDM_LOCATION 테이블에서 LOC_CD 조회
	 * 조회조건 
	 *  - super_cd1 : LOC_CD (optional)
	 *  - code : LOC_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchLocCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchLocCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}	
	
	
	/**
	 * BSA Information Entry 공통 VSK_VSL_PORT_SKD 테이블에서 VSL_CD 조회
	 * 조회조건 
	 *  - super_cd1 : VSL_CD (optional)
	 *  - super_cd2 : SKD_VOY_NO (optional)
	 *  - super_cd3 : SKD_DIR_CD (optional)
	 *  - code : VSL_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchVslPortSkdCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchVslPortSkdCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}

	/**
	 * Blank Voyage Status 공통 AR_MST_REV_VVD 테이블에서 Voyage 조회
	 * 조회조건 
	 *  - super_cd1 : VSL_CD 
	 *  - super_cd2 : SKD_VOY_NO 
	 *  - super_cd3 : SKD_DIR_CD 
	 *  - code : VSL_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchArVvd(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchArVvd(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}	
	
	/**
	 * Additional Slot Manager 공통 VSK_VSL_PORT_SKD 테이블에서 Vvd, Port 조회
	 * 조회조건 
	 *  - super_cd1 : VVD_CD 
	 *  - code : Port CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchVvdPortCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchVvdPortCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Carrier", "Retrieve"}).getUserMessage(), ex);
		}
	}	
	
	/**
	 * Settlement Target에서 Carrier Code를 조회한다.
	 * 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchTgtCrrCodeList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchTgtCrrCodeList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Trade", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"Joint Operation Trade", "Retrieve"}).getUserMessage(), ex);
		}
	}
	/**
	 * Additional Slot Manager 공통 COM_USER에서 user정보를 조회한다.
	 *  
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchUsrInfo(JooCodeParamVO jooCodeParamVO) throws EventException{
		try {
			return dbDao.searchUsrInfo(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"USER ID", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"USER ID", "Retrieve"}).getUserMessage(), ex);
		}
	}
	
	/**
	 * CSR List Inquiry JOO_STL_CMB 테이블에서 JO_CRR_CD 조회.
	 *  
	 * @param SlipConditionVO slipConditionVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCarrierListByCsr(SlipConditionVO slipConditionVO) throws EventException{
		try{
			return dbDao.searchCarrierListByCsr(slipConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"USER ID", "Retrieve"}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO00032", new String[]{"USER ID", "Retrieve"}).getUserMessage(), ex);
		}
	}
}