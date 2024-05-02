/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SceAdminManageBCImpl.java
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.basic;

import java.util.List;
import java.util.Set;

import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration.SceAdminManageDBDAO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.CntrDiffVO;
import com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.SceActTmlIfVO;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * SceAdminManage Business Logic Command Interface<br>
 * <br>
 *
 * @author
 * @see SceAdminManageBC
 * @since J2EE 1.6
 */
public class SceAdminManageBCImpl extends BasicCommandSupport implements SceAdminManageBC {

	// Database Access Object
	private transient SceAdminManageDBDAO dbDao = null;

	/**
	 * SceAdminManageBCImpl objects creation<br>
	 * creating SceAdminManageDBDAO.<br>
	 */
	public SceAdminManageBCImpl() {
		dbDao = new SceAdminManageDBDAO();
	}
	
	/**
	 * retrieving terminal change result<br>
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
	 * @see com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBC#searchRplnCops(com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO)
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
	 * @see com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBC#modifyActTmlIfSts(com.clt.syscommon.common.table.SceActTmlIfVO)
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
	 * @see com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC#interfaceCoaDailyBtch(java.util.Set)
	 */
	public void interfaceCoaDailyBtch(Set<String> bkgNoSet) throws EventException {
		try {
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
	 * @see com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC#searchMstCopNoDiff(java.lang.String, java.lang.String)
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
	 * @see com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.basic.SceAdminManageBC#searchCntrDiff(java.lang.String, java.lang.String)
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
}