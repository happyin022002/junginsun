/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SceAdminManageBCImpl.java
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.02 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.basic;

import java.util.List;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.event.EsdSce6000Event;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration.SceAdminManageDBDAO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.CntrDiffVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchLeaMonthlyWorkVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchSceMnlRplnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.SceActTmlIfVO;
import com.hanjin.syscommon.common.table.SceCopHdrVO;
import com.hanjin.framework.core.layer.event.Event;
/**
 * ALPS-SceAdminManage Business Logic Command Interface<br>
 * - ALPS-SceAdminManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim In-soo
 * @see SceAdminManageBC 참조
 * @since J2EE 1.6
 */
public class SceAdminManageBCImpl extends BasicCommandSupport implements SceAdminManageBC {

	// Database Access Object
	private transient SceAdminManageDBDAO dbDao = null;

	/**
	 * SceAdminManageBCImpl 객체 생성<br>
	 * SceAdminManageDBDAO를 생성한다.<br>
	 */
	public SceAdminManageBCImpl() {
		dbDao = new SceAdminManageDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SceAdminObjVO sceAdminObjVO
	 * @return List<SceActTmlIfVO>
	 * @exception EventException
	 */
	public List<SceActTmlIfVO> searchTmlChgRslt(SceAdminObjVO sceAdminObjVO) throws EventException {
		try {
			
			return dbDao.searchTmlChgRslt(sceAdminObjVO.getTmlFmDt(), sceAdminObjVO.getTmlToDt());
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	/**
	 * @param SceAdminObjVO sceAdminObjVO
	 * @return List<SceCopHdrVO>
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBC#searchRplnCops(com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO)
	 */
	public List<SceCopHdrVO> searchRplnCops(SceAdminObjVO sceAdminObjVO) throws EventException {
		try {
			
			return dbDao.searchRplnCops(sceAdminObjVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * @param SceActTmlIfVO sceActTmlIfVO
	 * @return int
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBC#modifyActTmlIfSts(com.hanjin.syscommon.common.table.SceActTmlIfVO)
	 */
	@Override
	public int modifyActTmlIfSts(SceActTmlIfVO sceActTmlIfVO) throws EventException {
		// TODO Auto-generated method stub
		try {

			return dbDao.modifyActTmlIfSts(sceActTmlIfVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param Set<String> bkgNoSet
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#interfaceCoaDailyBtch(java.util.Set)
	 */
	public void interfaceMasDailyBtch(Set<String> bkgNoSet) throws EventException {
		try {
			dbDao.mergeMasCopIfMgmt(bkgNoSet);
			dbDao.mergeCoaCopIfMgmt(bkgNoSet);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * @param fm_dt
	 * @param to_dt
	 * @return List<SceCopHdrVO>
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#searchMstCopNoDiff(java.lang.String, java.lang.String)
	 */
	public List<SceCopHdrVO> searchMstCopNoDiff(String fm_dt, String to_dt) throws EventException {
		
		List<SceCopHdrVO> rtnList = null;
		try {
			rtnList = dbDao.searchMstCopNoDiff(fm_dt, to_dt);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rtnList;
	}
	
	/**
	 * @param String fm_dt
	 * @param String to_dt
	 * @return List<CntrDiffVO>
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBC#searchCntrDiff(java.lang.String, java.lang.String)
	 */
	public List<CntrDiffVO> searchCntrDiff(String fm_dt, String to_dt) throws EventException {
		
		List<CntrDiffVO> rtnList = null;
		try {
			rtnList = dbDao.searchCntrDiff(fm_dt, to_dt);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rtnList;
	}
	
	/**
	 * @param sceAdminObjVO - SceAdminObjVO
	 * @return List<SceActRcvIfVO>
	 * @throws EventException
	 */
	public List<SceActRcvIfVO> searchActDatRcvIf(SceAdminObjVO sceAdminObjVO) throws EventException {
		
		List<SceActRcvIfVO> rtnList = null;
		try {
			rtnList = dbDao.searchActDatRcvIf(sceAdminObjVO);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rtnList;
	
	}
	
	/**
	 * LEA 월말 결산 대상을 조회한다.
	 * @param Event e
	 * @return List<SearchLeaMonthlyWorkVO>
	 * @throws EventException
	 */	
	public List<SearchLeaMonthlyWorkVO> searchLeaMonthlyWorkCandidate(Event e) throws EventException {
		List<SearchLeaMonthlyWorkVO> rtnList = null;
		try {
			rtnList = dbDao.searchLeaMonthlyWorkCandidate(e);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rtnList;
	}
	
	/**
	 * LEA 대상을 SCE로 IF 한다.
	 * @param SearchLeaMonthlyWorkVO searchLeaMonthlyWorkVO
	 * @return int
	 * @throws EventException
	 */
	public int addCandidateSceCsrMntr(SearchLeaMonthlyWorkVO searchLeaMonthlyWorkVO) throws EventException {
		// TODO Auto-generated method stub
		try {

			return dbDao.addCandidateSceCsrMntr(searchLeaMonthlyWorkVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Manual Replan table에 replan대상을 추가한다.
	 * @param SearchSceMnlRplnVO rplnVo
	 * @return int
	 * @throws EventException
	 */
	public int addSceMngRpln(SearchSceMnlRplnVO rplnVo) throws EventException {
		// TODO Auto-generated method stub
		try {

			return dbDao.addSceMngRpln(rplnVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SCE_CSR_MNTR TABLE의 DATA를 삭제한다.
	 * @return int
	 * @throws EventException
	 */
	public int delSceCsrMntr() throws EventException {
		// TODO Auto-generated method stub
		try {

			return dbDao.delSceCsrMntr();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * LEA 결산 대상 데이타를 조회한다.
	 * @return List<SearchSceMnlRplnVO>
	 * @throws EventException
	 */
	public List<SearchSceMnlRplnVO> searchSceMngRplnCandidate() throws EventException {
		List<SearchSceMnlRplnVO> searchSceMnlRplnVOs = null;
		try {
			searchSceMnlRplnVOs = dbDao.searchSceMngRplnCandidate();
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return searchSceMnlRplnVOs;
	}
	
	/**
	 * LEA 결산 대상 데이타를 조회한다.
	 * @return DBRowSet
	 * @throws EventException
	 */	
	public DBRowSet searchSceMngRpln() throws EventException {
		DBRowSet dSet = null;
		try {
			dSet = dbDao.searchSceMngRpln();
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return dSet;
	}
}