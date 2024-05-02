/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TesAdvanceAuditBCImpl
*@FileTitle : Equipment Auto Audit
*Open Issues :   
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.basic;


import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration.TesAdvanceAuditDBDAO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.LgsCostSubjCdVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAudCfgVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditConditionVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditMRHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditOndockRailHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceAuditVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceConfirmVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMRStorageFreeDayHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMRStorageFreePoolHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineStorageDetailCostByDayVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineStorageDetailCostByPoolVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineTerminalDetailVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailCostByDayVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailCostByPoolVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailTMNLVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYFreeDayHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYFreePoolHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYGateOutDateVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYTerminalHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOndockRailChargeInvoiceVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TesAdvanceAuditBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author Jong-Ock Kim
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class TesAdvanceAuditBCImpl extends BasicCommandSupport implements TesAdvanceAuditBC {

	
	// Database Access Object
	private transient TesAdvanceAuditDBDAO dbDao = null;

	/**
	 * TesAdvanceAuditBCImpl 객체 생성<br>
	 * TesAdvanceAuditDBDAO 생성한다.<br>
	 */
	public TesAdvanceAuditBCImpl(){
		dbDao = new TesAdvanceAuditDBDAO();
	}

	/**
	 * ESD_EAS_0370 조회<br>
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAudCfgVO>
	 * @exception EventException
	 */
	public List<TesAudCfgVO> searchTesAudCfgList(TesAuditConditionVO tesAuditConditionVO) throws EventException{
		try {
			return dbDao.searchTesAudCfgList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0370 - Save<br>
	 * @param TesAudCfgVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyTesAudCfg(TesAudCfgVO[] listVos, SignOnUserAccount account) throws EventException{ 
		try {
			List<TesAudCfgVO> updateVoList = new ArrayList<TesAudCfgVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTesAudCfg(updateVoList);
			}
	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0370 - Cost Group
	 * 
	 * @return List<LgsCostSubjCdVO>
	 * @throws DAOException
	 */
	public List<LgsCostSubjCdVO> searchLgsCostSubjCd() throws EventException{
		try {
			return dbDao.searchLgsCostSubjCd();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESD_EAS_0378 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAuditMRHistoryVO>
	 * @throws DAOException
	 */
	public List<TesAuditMRHistoryVO> searchTesAuditMRHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesAuditMRHistoryList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0379 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOndockRailChargeInvoiceVO>
	 * @throws DAOException
	 */
	public List<TesOndockRailChargeInvoiceVO> searchTesOndockRailChargeInvoiceAuditDetailList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesOndockRailChargeInvoiceAuditDetailList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0371 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesInvoiceConfirmVO>
	 * @exception EventException
	 */
	public List<TesInvoiceConfirmVO> searchTesInvoiceConfirmList(TesAuditConditionVO tesAuditConditionVO) throws EventException{
		try {
			return dbDao.searchTesInvoiceConfirmList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESD_EAS_0373, ESD_EAS_0375 - Init
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYGateOutDateVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYGateOutDateVO> searchTesOffdockCYInvoiceGateOutDate(TesAuditConditionVO tesAuditConditionVO) throws EventException{
		try {
			return dbDao.searchTesOffdockCYInvoiceGateOutDate(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(TMNL)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailTMNLVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYDetailTMNLVO> searchTesOffdockCYInvoiceAuditDetailTMNLList(TesAuditConditionVO tesAuditConditionVO) throws EventException{
		try {
			return dbDao.searchTesOffdockCYInvoiceAuditDetailTMNLList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(SRbyFD)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailCostByDayVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYDetailCostByDayVO> searchTesOffdockCYInvoiceAuditDetailCostByDayList(TesAuditConditionVO tesAuditConditionVO) throws EventException{
		try {
			return dbDao.searchTesOffdockCYInvoiceAuditDetailCostByDayList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(SRbyFP)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailCostByPoolVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYDetailCostByPoolVO> searchTesOffdockCYInvoiceAuditDetailCostByPoolList(TesAuditConditionVO tesAuditConditionVO) throws EventException{
		try {
			return dbDao.searchTesOffdockCYInvoiceAuditDetailCostByPoolList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0375 - Cost Calc.(SRbyFD)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineStorageDetailCostByDayVO>
	 * @exception EventException
	 */
	public List<TesMarineStorageDetailCostByDayVO> searchTesMarineStorageInvoiceAuditDetailCostByDayList(TesAuditConditionVO tesAuditConditionVO) throws EventException{
		try {
			return dbDao.searchTesMarineStorageInvoiceAuditDetailCostByDayList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0375 - Cost Calc.(SRbyFP)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineStorageDetailCostByPoolVO>
	 * @exception EventException
	 */
	public List<TesMarineStorageDetailCostByPoolVO> searchTesMarineStorageInvoiceAuditDetailCostByPoolList(TesAuditConditionVO tesAuditConditionVO) throws EventException{
		try {
			return dbDao.searchTesMarineStorageInvoiceAuditDetailCostByPoolList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0380 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAuditOndockRailHistoryVO>
	 * @throws DAOException
	 */
	public List<TesAuditOndockRailHistoryVO> searchTesAuditOndockRailHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesAuditOndockRailHistoryList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0377 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineTerminalDetailVO>
	 * @throws DAOException
	 */
	public List<TesMarineTerminalDetailVO> searchTesMarineTerminalInvoiceAuditDetailList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesMarineTerminalInvoiceAuditDetailList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0372 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesInvoiceAuditVO>
	 * @exception EventException
	 */
	public List<TesInvoiceAuditVO> searchTesInvoiceAuditList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesInvoiceAuditList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0372 - Confirm<br>
	 * 
	 * @param TesInvoiceAuditVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyTesInvoiceAudit(TesInvoiceAuditVO[] listVos, SignOnUserAccount account) throws EventException{ 
		try {
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					listVos[i].setSSaveTpCd(listVos[0].getSSaveTpCd());

					dbDao.modifyTesInvoiceAudit((TesInvoiceAuditVO)listVos[i]);
				}
			}
			
	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0372 - Batch(5분 매뉴얼) 등록<br>
	 * 
	 * @param TesInvoiceAuditVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTesInvoiceAuditBatch(TesInvoiceAuditVO[] listVos, SignOnUserAccount account) throws EventException { 
		try {
			for ( int i=0; i<listVos.length; i++ ) {
				listVos[i].setCreOfcCd(account.getOfc_cd());
				dbDao.createTesInvoiceAuditBatch((TesInvoiceAuditVO)listVos[i]);
		    }
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0374 - TMNL
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYTerminalHistoryVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYTerminalHistoryVO> searchTesAuditOffdockCYTerminalHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesAuditOffdockCYTerminalHistoryList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESD_EAS_0374 - SR by FD
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYFreeDayHistoryVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYFreeDayHistoryVO> searchTesAuditOffdockCYFreeDayHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesAuditOffdockCYFreeDayHistoryList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESD_EAS_0374 - SR by FP
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYFreePoolHistoryVO>
	 * @exception EventException
	 */
	public List<TesOffdockCYFreePoolHistoryVO> searchTesAuditOffdockCYFreePoolHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesAuditOffdockCYFreePoolHistoryList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0376 - SR by FD
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMRStorageFreeDayHistoryVO>
	 * @exception EventException
	 */
	public List<TesMRStorageFreeDayHistoryVO> searchTesAuditMRStorageFreeDayHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesAuditMRStorageFreeDayHistoryList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESD_EAS_0376 - SR by FP
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMRStorageFreePoolHistoryVO>
	 * @exception EventException
	 */
	public List<TesMRStorageFreePoolHistoryVO> searchTesAuditMRStorageFreePoolHistoryList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			return dbDao.searchTesAuditMRStorageFreePoolHistoryList(tesAuditConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/********************	Batch Method START	*******************************/	
	/**
	 * ESD_EAS_B003
	 * 
	 * @param tesAuditConditionVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws EventException
	 */
	public List<TesInvoiceAuditVO> searchTesAutoAuditList(TesAuditConditionVO tesAuditConditionVO) throws EventException {
		try {
			List<TesInvoiceAuditVO> vvdList			= null;	// VVD조회 List
			List<TesInvoiceAuditVO> audTargetList	= new ArrayList<TesInvoiceAuditVO>();	// 심사대상 List
			List<TesInvoiceAuditVO> audList			= new ArrayList<TesInvoiceAuditVO>();	// 심사결과 List
			List<TesInvoiceAuditVO> audInsList		= new ArrayList<TesInvoiceAuditVO>();	// 심사결과 List
			
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// 1. VVD 물량 집계
	        // Manual 물량 Batch 실행시 VVD 물량만 최대 한달치 실행
			// VVD 별 물량 조회 (2시간 내에 Confirm된 invoice에 포함된 VVD가 대상)
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			vvdList		= dbDao.searchVvdQty(tesAuditConditionVO);                                                                                                                                                                                                                                                                                                  

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// 2. VVD 물량 입력
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if ( vvdList.size() > 0 ) {
				dbDao.multiVvdQty(vvdList);                                                                                                                                                                                                                                                                                                  
			}
			
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// 3. Invoice 심사
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//#3.1 심사 기준 자료가 없을 경우 심사 내역을 초기화
			// BAT_VOL_RSLT_CD, BAT_AMT_RSLT_CD, BAT_ESTM_VOL_RSLT_CD 값이 없을 경우 심사내역을 초기화
			// (Off-dock등은 Terminal, Free Day, Free Pool을 따로 따로 심사하여 합산하게 되는데 기존에 배치가 수행되어 있으면 금액이 중복 될 수 있으므로)
			dbDao.modifyInitialInvAud(tesAuditConditionVO);
			
			//#3.2 대상 Invoice 조회
			audTargetList	= dbDao.searchTesAutoAuditList(tesAuditConditionVO);
			
			TesInvoiceAuditVO vResult				= null;
			String					sTmlInvTpCd		= "";
			String					sCalcCostGrpCd	= "";
			
			// Auto Audit Data 조회되는지 임시 로그. 확인후 삭제. - 20160518
//			String					sRhqCd			= "";
//			String					sInvOfcCd		= "";
//			int						iTm				= 0;
//			int						iTmNYCRA		= 0;
//			int						iTmHAMRU		= 0;
//			int						iTmVVOIA		= 0;
//			int						iOn				= 0;
			//#3.3 Invoice 심사결과 조회
			for ( int i = 0; i < audTargetList.size(); i++ ) {
				vResult			= new TesInvoiceAuditVO();
				audList.clear();
				sTmlInvTpCd		= (String)audTargetList.get(i).getTmlInvTpCd();
				sCalcCostGrpCd	= (String)audTargetList.get(i).getCalcCostGrpCd();
				
//				sRhqCd			= (String)audTargetList.get(i).getRhqCd();
//				sInvOfcCd		= (String)audTargetList.get(i).getInvOfcCd();
				
				// Invoice Type 별로 심사를 실행한다. 
				// Marine Terminal Invoice
				if ( "TM".equals( sTmlInvTpCd ) && "TM".equals( sCalcCostGrpCd ) ) {
					// Auto Audit Data 조회되는지 임시 로그. 확인후 삭제.
//					if ( "NYCRA".equals(sRhqCd) || "HAMRU".equals(sRhqCd) || "VVOIA".equals(sRhqCd)) {
//						if ( "NYCRA".equals(sRhqCd) ) { iTmNYCRA++;}
//						if ( "HAMRU".equals(sRhqCd) ) { iTmHAMRU++;}
//						if ( "VVOIA".equals(sRhqCd) ) { iTmVVOIA++;}
//						log.error("\n [][][] >>>>>>>> TM : Batch Type : " + tesAuditConditionVO.getBatchTpCd() + " : RhqCd = " + sRhqCd + " : Inv No = " + (String)audTargetList.get(i).getInvNo() + " : SP = " + (String)audTargetList.get(i).getVndrSeq() + " : Inv CFM DT = " + (String)audTargetList.get(i).getInvCfmDt() );
//					}
					audList = dbDao.searchMrInvAud( (TesInvoiceAuditVO)audTargetList.get(i) );
					
				// Off-Dock Terminal Invoice
				} else if ( "OF".equals( sTmlInvTpCd ) && "TM".equals( sCalcCostGrpCd ) ) {
					audList = dbDao.searchOffDockTmnlAud( (TesInvoiceAuditVO)audTargetList.get(i) );
					
				// Marine Storage & Off-Dock Storage Invoice FreeDay
				} else if ( "SD".equals( sCalcCostGrpCd ) ) {
					audList = dbDao.searchFreeDayAud( (TesInvoiceAuditVO)audTargetList.get(i) );

				// Marine Storage & Off-Dock Storage Invoice FreePool
				} else if ( "SP".equals( sCalcCostGrpCd ) ) {
					audList = dbDao.searchFreePoolAud( (TesInvoiceAuditVO)audTargetList.get(i) );
				
				// On-Dock Rail Ramp Invoice
				} else if ( "ON".equals( sTmlInvTpCd ) ) {
					// Auto Audit Data 조회되는지 임시 로그. 확인후 삭제.
//					if ( "NYCRA".equals(sRhqCd) || "HAMRU".equals(sRhqCd) || "VVOIA".equals(sRhqCd)) {
//						iOn++;
//						log.error("\n [][][] >>>>>>>> ON : Batch Type : " + tesAuditConditionVO.getBatchTpCd() + " : RhqCd = " + sRhqCd + " : Inv No = " + (String)audTargetList.get(i).getInvNo() + " : SP = " + (String)audTargetList.get(i).getVndrSeq() + " : Inv CFM DT = " + (String)audTargetList.get(i).getInvCfmDt() );
//					}
					audList = dbDao.searchOnDockRailAud( (TesInvoiceAuditVO)audTargetList.get(i) );

				}
			
				if ( audList.size() > 0 ) {
					vResult	= (TesInvoiceAuditVO)audList.get(0);
					if ( vResult != null ) {
						audInsList.add( vResult );
					}
				}
			}
//			log.error("\n\n [][][] >>>>>>>> iTm = " + iTm + " : iTmNYCRA = " + iTmNYCRA + " : iTmHAMRU = " + iTmHAMRU + " : iTmVVOIA = " + iTmVVOIA + " : iOn = " + iOn + " : audInsList.size() = " + audInsList.size());			
			
			return audInsList; 
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 *  ESD_EAS_B003 Invoice 심사 결과 등록 수정<br>
	 * 
	 * @param List<TesInvoiceAuditVO> listVos
	 * @exception EventException
	 */
	public void createInvAud(List<TesInvoiceAuditVO> listVos) throws EventException { 
		try {
				dbDao.createInvAud(listVos);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0372 - Batch(5분 매뉴얼) 상태 수정<br>
	 * 
	 * @param List<TesInvoiceAuditVO> listVos
	 * @exception EventException
	 */
	public void updateBatchStatus(List<TesInvoiceAuditVO> listVos) throws EventException { 
		try {
			dbDao.updateBatchStatus(listVos);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/********************	Batch Method END	*******************************/	

}
