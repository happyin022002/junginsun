/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalFinderBCImpl.java
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.24 정윤태
* 1.0 Creation
* 2010.08.16 윤진영 CHM-201005318 searchMdmAccountCodeList 에서 account_code와 account_name으로 조회가능하도록 수정
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration.ExternalFinderDBDAO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCenterCodeVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchPaymenetOfficeCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchSplRgstNoVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-FMSCommon Business Logic Basic Command implementation<br>
 * - ALPS-FMSCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon-Tae, Jung 
 * @see Esm_Fms-0022EventResponse,ExternalfinderBC 각 DAO 클래스 참조
 * @since J2EE 1.5
 */

public class ExternalFinderBCImpl extends BasicCommandSupport implements ExternalFinderBC {

	// Database Access Object
	private transient ExternalFinderDBDAO dbDao = null;

	/**
	 * ExternalFinderBCImpl 객체 생성<br>
	 * ExternalFinderDBDAO를 생성한다.<br>
	 */
	public ExternalFinderBCImpl() {
		dbDao = new ExternalFinderDBDAO();
	}
	
	/**
	 *  Externalfinder화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchVesselVO SearchVesselVO
	 * @return List<SearchVesselVO>
	 * @exception EventException
	 */
	public List<SearchVesselVO> searchVesselCodeList(SearchVesselVO searchVesselVO) throws EventException {
		try {
			return dbDao.searchVesselCodeList(searchVesselVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01329",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01329",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 사선/용선/대선에 대한 Owner Code 조회<br>
	 * FMS 화면에서 Vessel Code에 대한 Vessel Name 정보 가져오기<br>
	 * 
	 * @param vslCd String
	 * @return List<SearchVesselVO>
	 * @exception EventException
	 */
	public List<SearchVesselVO> searchVesselCodeName(String vslCd) throws EventException {
		
		try {
			return dbDao.searchVesselCodeName(vslCd);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01554",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01554",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Location Code에 대한 Location Name 정보 가져오기<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchLocCdName(String locCd) throws EventException {
		
		try {
			return dbDao.searchLocCdName(locCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01557",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01557",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Flag 코드에 해당하는 Name 정보 조회<br>
	 * 
	 * @param vslCntCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchFlag(String vslCntCd) throws EventException {
		
		try {
			return dbDao.searchFlag(vslCntCd);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01552",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Account Code 조회<br>
	 * FMS 화면에서 Account Code Popup<br>
	 * 
	 * @param acctCd String
	 * @param acctGb String
	 * @return List<SearchMdmAccountCodeListVO>
	 * @exception EventException
	 */
	public List<SearchMdmAccountCodeListVO> searchMdmAccountCodeList(String acctCd,String acctGb) throws EventException {
		
		try {
			return dbDao.searchMdmAccountCodeList(acctCd,acctGb);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01318",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01318",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *  D/Dock Schedule Input에서  Location Code 입력시 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCode(String locCd) throws EventException {
		try {
			return dbDao.searchCheckLocCode(locCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01019",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01019",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *  D/Dock Schedule Review-Graph에서  Lane Code 입력시)화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLaneCode(String laneCd) throws EventException {
		try {
			return dbDao.searchCheckLaneCode(laneCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01562",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01562",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 화면에서 VVD Code 입력시 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vvdCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkMdmVvdCode(String vvdCd) throws EventException {
		try {
			return dbDao.searchCheckMdmVvdCode(vvdCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01558",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Carrier Code Selection - Window 조회<br>
	 * FMS 화면에서                     Carrier Code Selection - Window<br>
	 * 
	 * @param carrNm String
	 * @return List<SearchCarrierCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCarrierCodeListVO> searchCarrierCodeList(String carrNm) throws EventException {
		
		try {
			return dbDao.searchCarrierCodeList(carrNm);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01014",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01014",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Lane Code Search - Window 조회<br>
	 * FMS 화면에서Lane Code Search - Window<br>
	 * 
	 * @param searchLaneCodeListVO SearchLaneCodeListVO
	 * @return List<SearchLaneCodeList>
	 * @exception EventException
	 */
	public List<SearchLaneCodeListVO> searchLaneCodeList(SearchLaneCodeListVO searchLaneCodeListVO) throws EventException {
		
		try {
			return dbDao.searchLaneCodeList(searchLaneCodeListVO);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01555",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01555",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *  Revenue Lane Code 입력시 이벤트 처리<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkRevenueLaneCode(String laneCd) throws EventException {
		try {
			return dbDao.searchCheckRevenueLaneCode(laneCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01563",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01563",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Carrier Code 가져오기<br>
	 * 
	 * @param crrCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckCarrierCode(String crrCd) throws EventException {
		
		try {
			return dbDao.searchCheckCarrierCode(crrCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01564",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01564",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Effective Date 조회<br>
	 * 
	 * @param slpOfcCd String
	 * @param effDt String
	 * @return String
	 * @exception EventException
	 */
	public String checkEffectiveDate(String slpOfcCd, String effDt) throws EventException {
		
		try {
			return dbDao.searchCheckEffectiveDate(slpOfcCd, effDt);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01556",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Center Code / City Code 를 조회한다<br>
	 * 
	 * @param slpOfcCd String
	 * @return List<SearchCenterCodeVO>
	 * @exception EventException
	 */
	public List<SearchCenterCodeVO> searchCenterCode(String slpOfcCd) throws EventException {
		try {
			return dbDao.searchCenterCode(slpOfcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01566",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01566",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Office Code / Officd Name 을 조회한다<br>
	 * 
	 * @return List<searchPaymenetOfficeCodeList>
	 * @exception EventException
	 */
	public List<SearchPaymenetOfficeCodeListVO> searchPaymenetOfficeCodeList() throws EventException {
		try {
			return dbDao.searchPaymenetOfficeCodeList();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01408",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01408",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 사업자 등록 번호를 조회한다<br>
	 * 
	 * @param String splRgstNo
	 * @return List<SearchSplRgstNoVO>
	 * @exception EventException
	 */
	public List<SearchSplRgstNoVO> searchSplRgstNo(String splRgstNo) throws EventException {
		try {
			return dbDao.searchSplRgstNo(JSPUtil.removeCharacter(splRgstNo, "-"));
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01409",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01409",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 환율 조회<br>
	 * 
	 * @param acctXchRtYrmon String
	 * @return String
	 * @exception EventException
	 */
	public String searchExchangeRate(String acctXchRtYrmon) throws EventException {
		
		try {
			return dbDao.searchExchangeRate(acctXchRtYrmon.substring(0,6));
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01557",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01557",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Account 별 VVD Level Check<br>
	 * 화면에서 VVD Code 입력시 화면에 대한 항차 레벨 조회 이벤트 처리<br>
	 * 
	 * @param acctCd String
	 * @param vvdCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkAcctCdVvdLevel(String acctCd, String vvdCd) throws EventException {
		try {
			return dbDao.searchCheckAcctCdVvdLevel(acctCd, vvdCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01474",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01474",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Contract 존재하는 체크를 합니다 (Notice 에서 사용).<br>
	 * @param String agmtNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchContractCtrtNtcInfo(String agmtNo) throws EventException { 
		try {
			return dbDao.searchContractCtrtNtcInfo(agmtNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01004", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("FMS01004", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Contract No Search <br>
	 * 
	 * @param vo SearchContractNoVO
	 * @return List<SearchContractNoVO>
	 * @throws EventException
	 */
	public List<SearchContractNoVO> searchContractNoInfo(SearchContractNoVO vo) throws EventException {
		try {
			return dbDao.searchContractNoInfo(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Pay Term Search by Supplier <br>
	 * 
	 * @param String sValue
	 * @return String
	 * @throws EventException
	 */
	public String searchPayTermByVndrSeq(String sValue) throws EventException {
		try {
			return dbDao.searchPayTermByVndrSeq(sValue);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Rgst No Search by Supplier <br>
	 * 
	 * @param String sValue
	 * @return String
	 * @throws EventException
	 */
	public String searchRgstNoByVndrSeq(String sValue) throws EventException {
		try {
			return dbDao.searchRgstNoByVndrSeq(sValue);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",new String[]{}).getMessage(), ex);
		}
	}
}