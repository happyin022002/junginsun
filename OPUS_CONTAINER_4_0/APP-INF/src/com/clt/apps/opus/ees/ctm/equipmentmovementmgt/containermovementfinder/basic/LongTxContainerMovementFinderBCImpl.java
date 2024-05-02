/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LongTxContainerMovementFinderBCImpl.java
 *@FileTitle : LongTxContainerMovementFinderBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration.LongTxContainerMovementFinderDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIErrorVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.VLVDUpdateStatusVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-EquipmentMovementMgt Business Logic Basic Command implementation
 * handling business logic about OPUS-EquipmentMovementMgt
 *
 * @author 
 * @see LongTxContainerMovementFinderBC DAO class reference
 * @since J2EE 1.6
 */
public class LongTxContainerMovementFinderBCImpl extends BasicCommandSupport implements LongTxContainerMovementFinderBC {

	// Database Access Object
	private transient LongTxContainerMovementFinderDBDAO dbDao = null;

	/**
	 * creating LongTxContainerMovementFinderBCImpl Object
	 * creating LongTxContainerMovementFinderDBDAO
	 */
	public LongTxContainerMovementFinderBCImpl() {
		dbDao = new LongTxContainerMovementFinderDBDAO();
	}

	/**
	 * EES_CTM_0418
	 * retrieving RCC Combo List when loading screen
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
	 * retrieving LCC when changing RCC Combo List
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

	/**
	 * EES_CTM_0418 : starting BackEndJob
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
	 * retrieving details about EES_CTM_0418 Movement Update time gap
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

	/**
	 * EES_CTM_0417 : starting BackEndJob
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
	 * EES_CTM_0417 : BackEndJob result
	 * retrieving EDI Error List Long Tx result
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
	 * EES_CTM_0417 : retrieving EDI error details for excel down including EDI error, row data 
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

	/**
	 * EES_CTM_0420 : starting BackEndJob
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
	 * EES_CTM_0420 : BackEndJob result
	 * retrieving EDI Result List Long Tx result
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
	 * EES_CTM_0420 : retrieving EDI result detail for excel down
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

	/**
	 * EES_CTM_0460 : starting BackEndJob
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
	 * BackEndJob - returning BackEndJob status
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
	 * retrieving auto created Movement list
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

	/**
	 * EES_CTM_0462 : starting BackEndJob
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
	 * EES_CTM_0418 : BackEndJob result
	 * retrieving MVMT Timely Update Ratio Long Tx result
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
	 * EES_CTM_0462 : BackEndJob result
	 * retrieving Auto Creation Status List Long Tx result
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