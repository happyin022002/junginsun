/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxFillingBC.java
*@FileTitle : TonnageTaxFilling
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.11.25 이병훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.integration.TonnageTaxFillingDBDAO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.FnsTot0027ConditionVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchActualBsaSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchBasicBsaSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchHiringOutAndLayingUpSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchSummaryCreationBatchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-TonnageTaxOutput Business Logic Basic Command implementation<br>
 * - ALPS-TonnageTaxOutput에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Byoung Hun
 * @see EvetnException 참조
 * @since J2EE 1.6
 */
public class TonnageTaxFillingBCImpl extends BasicCommandSupport implements TonnageTaxFillingBC {

	// Database Access Object
	private transient TonnageTaxFillingDBDAO dbDao = null;

	/**
	 * TonnageTaxFillingBCImpl 객체 생성<br>
	 * TonnageTaxFillingDBDAO 생성한다.<br>
	 */
	public TonnageTaxFillingBCImpl() {
		dbDao = new TonnageTaxFillingDBDAO();
	}
	
	/**
	 * FNS_TOT_0024 : SEARCHLIST<br>
	 * 운항중인 모든 선박(피더선박 제외)들의 기본 BSA 변동별 내역을 조회한다.<br>
	 *
	 * @param year String
	 * @return List<SearchBasicBsaSummaryVO>
	 * @exception EventException
	 */
	public List<SearchBasicBsaSummaryVO> searchBasicBsaSummary(String year) throws EventException {
		try {
			return dbDao.searchBasicBsaSummary(year);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * FNS_TOT_0025 : SEARCH <br>
	 * 운항중인 모든 선박(피더선박 제외)들의 초과 BSA 변동별 내역을 조회한다.<br>
	 * 
	 * @param year String
	 * @return List<SearchActualBsaSummaryVO>
	 * @exception EventException
	 */
	public List<SearchActualBsaSummaryVO> searchActualBsaSummary(String year) throws EventException {
		try {
			return dbDao.searchActualBsaSummary(year);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * FNS_TOT_0026 : SEARCH <br>
	 * 대선선박과 계선선박의 내역을 조회한다.<br>
	 * 
	 * @param year String
	 * @return List<SearchHiringOutAndLayingUpSummaryVO>
	 * @exception EventException
	 */
	public List<SearchHiringOutAndLayingUpSummaryVO> searchHiringOutAndLayingUpSummary(String year) throws EventException {
		try {
			return dbDao.searchHiringOutAndLayingUpSummary(year);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * 운항중인 모든 선박(피더선박 제외)들의 최신 Update Date 조회한다.<br>
	 * 
	 * @param year String
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicBsaSummaryUpdate(String year) throws EventException {
		try {
			return dbDao.searchBasicBsaSummaryUpdate(year);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * FNS_TOT_0027 : Retrive <br>
	 * 해당기간의 배치정보를 조회한다. <br>
	 * 
	 * @param conditionVO FnsTot0027ConditionVO
	 * @param hisType String
	 * @return List<SearchSummaryCreationBatchVO>
	 * @exception EventException
	 */
	public List<SearchSummaryCreationBatchVO> searchSummaryCreationBatch(FnsTot0027ConditionVO conditionVO, String hisType) throws EventException {
		try {
			log.debug(conditionVO.getColumnValues().toString());
			return dbDao.searchSummaryCreationBatch(conditionVO, hisType);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}	

	/**
	 * FNS_TOT_0027 : Submit <br>
	 * 해당기간의 배치 history정보를 저장한다. <br>
	 * 
	 * @param conditionVO FnsTot0027ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createSummaryCreationBatch (FnsTot0027ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.addSummaryCreationBatch(conditionVO, account.getUsr_id());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		}
	}

	/**
	 * FNS_TOT_0027 : Cancel <br>
	 * 해당기간의 배치 history정보를 삭제한다. <br>
	 * 
	 * @param jobID String
	 * @exception EventException
	 */
	public void removeSummaryCreationBatch (String jobID) throws EventException{
		try {
			   dbDao.removeSummaryCreationBatch(jobID);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00002", new String[]{" Save"}).getMessage(),ex);
		}
	}
	
	/**
	 * 배치 실행 여부 확인 <br>
	 * 
	 * @param String pgmNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isRunningBatch(String pgmNo) throws EventException {
		ScheduleUtil su = new ScheduleUtil();
		
		try {
			return su.isRunning(pgmNo);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
	}
}