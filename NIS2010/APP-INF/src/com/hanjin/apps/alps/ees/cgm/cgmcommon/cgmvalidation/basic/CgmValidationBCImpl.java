/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmValidationBCImpl.java
*@FileTitle : cgm_validation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.21 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration.CgmValidationDBDAO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.ChsMasterMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.LocationMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmCurrencyMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmVendorMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.YardINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.YardMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CgmCommon Business Logic Basic Command implementation<br>
 * - ALPS-CgmCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM CHANG SIK
 * @see cgm_validationEventResponse,CgmValidationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CgmValidationBCImpl extends BasicCommandSupport implements CgmValidationBC {

	// Database Access Object
	private transient CgmValidationDBDAO dbDao = null;

	/**
	 * CgmValidationBCImpl 객체 생성<br>
	 * CgmValidationDBDAO를 생성한다.<br>
	 */
	public CgmValidationBCImpl() {
		dbDao = new CgmValidationDBDAO();
	}
	
	/**
	 * 입력한 Office code 가 유효한지 체크 . Retrieve. <br>
	 * 
	 * @param officeINVO OfficeINVO 
	 * @return List<OfficeMGTVO>
	 * @exception EventException
	 */
	public List<OfficeMGTVO> checkOfficeBasic(OfficeINVO officeINVO) throws EventException {
		try {
			return dbDao.checkOfficeData(officeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * 입력 yard code 가 valid 한지 체크  . Retrieve. <br>
	 * 
	 * @param yardINVO YardINVO 
	 * @return List<YardMGTVO>
	 * @exception EventException
	 */
	public List<YardMGTVO> checkYardBasic(YardINVO yardINVO) throws EventException {
		try {
			return dbDao.checkYardData(yardINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	} 
	/**
	 * 입력 available yard code 가 valid 한지 체크  . Retrieve. <br>
	 * 
	 * @param yardINVO YardINVO 
	 * @return List<YardMGTVO>
	 * @exception EventException
	 */
	public List<YardMGTVO> checkYardAvailableYardBasic(YardINVO yardINVO) throws EventException {
		try {
			return dbDao.checkYardAvailableYardData(yardINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Agreement 가 등록되어있는지 체크한다 . Retrieve. <br>
	 * 
	 * @param agrementINVO AgrementINVO 
	 * @return List<AgrementMGTVO>
	 * @exception EventException
	 */
	public List<AgrementMGTVO> checkAgreementBasic(AgrementINVO agrementINVO) throws EventException {
		try {
			log.debug("agrementINVO.setAgmtOfcCtyCd=======================");
			String sTmp  = agrementINVO.getAgmtOfcCtyCd();
			log.debug("agrementINVO. sTmp======================="+ sTmp);
			int seq      = Integer.parseInt(sTmp.substring(3,sTmp.length()));
			
			agrementINVO.setAgmtOfcCtyCd(sTmp.substring(0,3));
			agrementINVO.setAgmtSeq(Integer.toString(seq));
//			
			log.debug("agrementINVO.setAgmtOfcCtyCd======================="+agrementINVO.getAgmtOfcCtyCd());
			log.debug("agrementINVO.setAgmtSeq============================"+agrementINVO.getAgmtSeq());
			
			return dbDao.checkAgreementData(agrementINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * CGM EQUIPMENT 테이블로부터  Chassis 마스터 정보를 조회한다 . Retrieve. <br>
	 * 
	 * @param chsMasterMGTVO ChsMasterMGTVO 
	 * @return List<ChsMasterMGTVO>
	 * @exception EventException
	 */
	public List<ChsMasterMGTVO> searchCGMMasterBasic(ChsMasterMGTVO chsMasterMGTVO) throws EventException{
		// Response 객체를 담기위한 Map 객체
		try {
			return dbDao.searchCGMMasterData(chsMasterMGTVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
	}
	
	/**
	 * DM_VENDOR 테이블에서 Vendor 정보 조회한다 . Retrieve. <br>
	 * 
	 * @param mdmVendorMGTVO MdmVendorMGTVO 
	 * @return List<MdmVendorMGTVO>
	 * @exception EventException
	 */
	public List<MdmVendorMGTVO>  searchVendorListBasic(MdmVendorMGTVO mdmVendorMGTVO) throws EventException{
		// Response 객체를 담기위한 Map 객체
		try {
			return  dbDao.searchVendorListData(mdmVendorMGTVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * CGM_EQ_TP_SZ 테이블로부터  정보를 조회한다 . Retrieve. <br>
	 * 
	 * @param tpSzDupChkINVO TpSzDupChkINVO 
	 * @return List<TpSzDupChkMGTVO>
	 * @exception EventException
	 */
	public List<TpSzDupChkMGTVO> searchEqTpSzDupChkBasic(TpSzDupChkINVO tpSzDupChkINVO) throws EventException {
		try {
			return dbDao.searchEqTpSzDupChkData(tpSzDupChkINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	} 
	
	/**
	 * MST_CONTAINER 정보를 조회한다 . Retrieve. <br>
	 * 
	 * @param chsMasterMGTVO ChsMasterMGTVO 
	 * @return List<ChsMasterMGTVO>
	 * @exception EventException
	 */
	public List<ChsMasterMGTVO>  searchCNTRMasterBasic(ChsMasterMGTVO chsMasterMGTVO) throws EventException{
		try {
//			List<ChsMasterMGTVO> list = dbDao.searchCNTRMasterData(chsMasterMGTVO);
//			
//			
//			if(list != null){
//				if(list.size() > 0){
//					for(int i = 0; i < list.size(); i++){
//						tmpMGTVO = (ChsMasterMGTVO)list.get(0);
//					}
//				}
//			}
			return   dbDao.searchCNTRMasterData(chsMasterMGTVO);
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Location Code가 유효한지 체크한다 . Retrieve. <br>
	 * 
	 * @param locationMGTVO LocationMGTVO 
	 * @return List<LocationMGTVO>
	 * @exception EventException
	 */
	public List<LocationMGTVO> checkLocationBasic(LocationMGTVO locationMGTVO) throws EventException{
		try {
			return dbDao.checkLocationData(locationMGTVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	

	/**
	 * CGM_CHSS_POOL 테이블 정보를 조회한다 Retrieve. <br>
	 * 
	 * @param cgmChssPoolINVO CgmChssPoolINVO 
	 * @return List<CgmChssPoolMGTVO>
	 * @exception EventException
	 */
	public List<CgmChssPoolMGTVO> seachChssPoolListBasic(CgmChssPoolINVO cgmChssPoolINVO) throws EventException{
		try {
			return dbDao.searchChssPoolData(cgmChssPoolINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * MDM_CURRENCY 테이블 정보를 조회한다 Retrieve. <br>
	 * 
	 * @param mdmCurrencyMGTVO MdmCurrencyMGTVO 
	 * @return List<MdmCurrencyMGTVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyMGTVO> searchMDMCurrencyBasic(MdmCurrencyMGTVO mdmCurrencyMGTVO) throws EventException{
		try {
			return dbDao.searchMDMCurrencyData(mdmCurrencyMGTVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Location Code가 유효한지 체크한다 . Retrieve. <br>
	 * 
	 * @param locationMGTVO LocationMGTVO 
	 * @return List<LocationMGTVO>
	 * @exception EventException
	 */
	public List<LocationMGTVO> searchOfficeYardControlOfficeMatchBasic(LocationMGTVO locationMGTVO) throws EventException{
		try {
			return dbDao.searchOfficeYardControlOfficeMatchData(locationMGTVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * CGM 공통 조회 기능 <br>
	 * OFFICE CODE 의 AGMT NO 를 조회하여 AGMT NO 를 리턴<br>
	 * 
	 * @param String agmt_no
	 * @param String ofc_cd
	 * @return String return_agmt_no
	 * @exception DAOException
	 */
	public String searchCgmAgmtNoBasic(String agmt_no, String ofc_cd) throws EventException {
		try{	
			return dbDao.searchCgmAgmtNoData(agmt_no, ofc_cd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}			
}