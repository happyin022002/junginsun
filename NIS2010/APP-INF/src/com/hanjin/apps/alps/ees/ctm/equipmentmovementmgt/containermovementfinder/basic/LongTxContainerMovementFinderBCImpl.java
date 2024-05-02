/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LongTxContainerMovementFinderBCImpl.java
 *@FileTitle : LongTxContainerMovementFinderBCImpl
 *Open Issues :
 *Change history : 2009.08.27 (우경민) - EES_CTM_0418 관련업무 최초생성
 *                 2009.08.28 (김상수) - EES_CTM_0417 관련업무 추가
 *@LastModifyDate : 2009.08.28
 *@LastModifier : 김상수
 *@LastVersion : 1.1
 * 2009.08.27 우경민
 * 1.0 Creation
 * 2009.08.28 김상수  
 * 1.1 Modification
 * --------------------------------------------------------
 * History
 * 2010.10.12 이병훈 [CHM-201006402-01] Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경] 
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration.LongTxContainerMovementFinderDBDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIErrorVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.VLVDUpdateStatusVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-EquipmentMovementMgt Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentMovementMgt에 대한 비지니스 로직을 처리<br>
 *
 * @author Kyung Min Woo
 * @see LongTxContainerMovementFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class LongTxContainerMovementFinderBCImpl extends BasicCommandSupport implements LongTxContainerMovementFinderBC {

	// Database Access Object
	private transient LongTxContainerMovementFinderDBDAO dbDao = null;

	/**
	 * LongTxContainerMovementFinderBCImpl 객체 생성<br>
	 * LongTxContainerMovementFinderDBDAO를 생성<br>
	 */
	public LongTxContainerMovementFinderBCImpl() {
		dbDao = new LongTxContainerMovementFinderDBDAO();
	}

	/**
	 * EES_CTM_0418
	 * 화면 로딩시  RCC Combo List를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @exception DAOException, Exception
	 */
	public String getRccList(String ofcCd) throws EventException {
		try {
			return dbDao.getRccList(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0418
	 * RCC Combo List 변경시 LCC 를 조회<br>
	 *
	 * @param String rccCd
	 * @return String
	 * @throws EventException
	 * @exception DAOException, Exception
	 */
	public String getLccList(String rccCd) throws EventException {
		try {
			return dbDao.getLccList(rccCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

    /*=========================================================
     * 2010.10.12 이병훈 [CHM-201006402-01]
     *                   Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경] 
     *=========================================================*/
	/**
	 * EES_CTM_0418 : 0418의 BackEnd Job를 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param MovementEDIReportVO movementEDIReportVO
	 * @return String
	 */
	@Override
	public String doBackEndJob(SignOnUserAccount account, MovementEDIReportVO movementEDIReportVO) {
		LongTxContainerMovementFinderBackEndJob backEndResult = new LongTxContainerMovementFinderBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setMovementEDIReportVO(movementEDIReportVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_CTM_0418 Back End");
	}

	/**
	 * EES_CTM_0418 Movement Update 시차에 대한 상세정보를 조회<br>
	 *
	 * @param UpdateRatioDetailVO updateRatioDetailVO
	 * @return List<UpdateRatioDetailVO>
	 * @exception EventException
	 */
	public List<UpdateRatioDetailVO> getUpdateRatioDetail(UpdateRatioDetailVO updateRatioDetailVO) throws EventException {
		try {
			return dbDao.getUpdateRatioDetail(updateRatioDetailVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

    /*=========================================================
     * 2010.10.12 이병훈 [CHM-201006402-01]
     *                   Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경] 
     *=========================================================*/
	/**
	 * EES_CTM_0417 : BackEndJob을 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return String
	 * @exception EventException, BackEndJobException
	 */
	public String doBackEndJobEDIErrList(SignOnUserAccount account, SearchEDIErrorVO searchEDIErrorVO) {
		LongTxContainerMovementEdiErrBackEndJob backEndResult = new LongTxContainerMovementEdiErrBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setSearchEDIErrorVO(searchEDIErrorVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_CTM_0417 Back End");
	}

	/**
	 * EES_CTM_0417 : BackEndJob 결과<br>
	 * EDI Error List Long Tx 결과 조회<br>
	 *
	 * @param String key
	 * @return List<SearchEDIErrorVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchEDIErrorVO> searchEDIErrorList(String key) throws EventException {
		try {
			return (List<SearchEDIErrorVO>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
		}
	}

	/**
	 * EES_CTM_0417 : EDI error율, row data 및 엑셀 다운용 EDI error 상세 데이터를 조회<br>
	 *
	 * @param SearchEDIErrorVO searchEDIErrorVO
	 * @return List<SearchEDIErrorVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<SearchEDIErrorVO> searchEDIErrorDetailExcel(SearchEDIErrorVO searchEDIErrorVO) throws EventException {
		try {
			return dbDao.searchEDIErrorDetailExcel(searchEDIErrorVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

    /*=========================================================
     * 2010.10.12 이병훈 [CHM-201006402-01]
     *                   Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경] 
     *=========================================================*/
	/**
	 * EES_CTM_0420 : 0420의 BackEnd Job를 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return String
	 */
	public String doBackEndJobEDIRst(SignOnUserAccount account, SearchEDIResultVO searchEDIResultVO) {
		LongTxContainerMovementEdiRstBackEndJob backEndResult = new LongTxContainerMovementEdiRstBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setSearchEDIResultVO(searchEDIResultVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_CTM_0420 Back End");
	}

	/**
	 * EES_CTM_0420 : BackEndJob 결과<br>
	 * EDI Result List Long Tx 결과 조회<br>
	 *
	 * @param String key
	 * @return List<SearchEDIResultVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchEDIResultVO> searchEDIResultList(String key) throws EventException {
		try {
			return (List<SearchEDIResultVO>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
		}
	}

	/**
	 * EES_CTM_0420 : 엑셀 다운용 EDI result 상세 데이터를 조회<br>
	 *
	 * @param SearchEDIResultVO searchEDIResultVO
	 * @return List<SearchEDIResultVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<SearchEDIResultVO> searchEDIResultDetailExcel(SearchEDIResultVO searchEDIResultVO) throws EventException {
		try {
			return dbDao.searchEDIResultDetailExcel(searchEDIResultVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

    /*=========================================================
     * 2010.10.12 이병훈 [CHM-201006402-01]
     *                   Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경] 
     *=========================================================*/
	/**
	 * EES_CTM_0460 : 0460의 BackEndJob을 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param VLVDUpdateStatusVO vlvdUpdateStatusVO
	 * @return String
	 */
	public String doBackEndJobVLVDStatus(SignOnUserAccount account, VLVDUpdateStatusVO vlvdUpdateStatusVO) {
		LongTxVLVDUpdateStatusBackEndJob backEndResult = new LongTxVLVDUpdateStatusBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setVLVDUpdateStatusVO(vlvdUpdateStatusVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_CTM_0460 Back End");
	}

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJob(String key) throws EventException {
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch (SQLException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch (InterruptedException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch(Exception e){
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		}
	}

	/**
	 * 자동 생성된 Movement 리스트를 조회.<br>
	 *
	 * @param AutoCreStsListVO	autoCreStsListVO
	 * @return List<AutoCreStsListVO>
	 * @exception EventException
	 */
	public List<AutoCreStsListVO> getAutoCreSts(AutoCreStsListVO	autoCreStsListVO) throws EventException {
		try {
			return dbDao.getAutoCreSts(autoCreStsListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage() ,ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage() ,ex);
		}

	}

    /*=========================================================
     * 2010.10.12 이병훈 [CHM-201006402-01]
     *                   Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경] 
     *=========================================================*/
	/**
	 * EES_CTM_0462 : 0462의 BackEndJob을 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param AutoCreStsListVO autoCreStsListVO
	 * @return String
	 */
	public String doBackEndJobAutoCreStatus(SignOnUserAccount account, AutoCreStsListVO autoCreStsListVO) {
		LongTxAutoCreStatusBackEndJob backEndResult = new LongTxAutoCreStatusBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setSearchAutoCreStatus(autoCreStsListVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_CTM_0462 Back End");
	}

	/**
	 * EES_CTM_0418 : BackEndJob 결과<br>
	 * MVMT Timely Update Ratio Long Tx 결과 조회<br>
	 *
	 * @param String key
	 * @return List<MovementEDIReportVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<MovementEDIReportVO> searchEDIOnTimeDetailList(String key) throws EventException {
		try {
			return (List<MovementEDIReportVO>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
		}
	}

	/**
	 * EES_CTM_0462 : BackEndJob 결과<br>
	 * Auto Creation Status List Long Tx 결과 조회<br>
	 *
	 * @param String key
	 * @return List<AutoCreStsListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<AutoCreStsListVO> searchAutoCreStatus(String key) throws EventException {
		try {
			return (List<AutoCreStsListVO>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
		}
	}

}