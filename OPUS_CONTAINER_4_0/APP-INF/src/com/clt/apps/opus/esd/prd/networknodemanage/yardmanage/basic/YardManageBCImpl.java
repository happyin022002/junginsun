/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : YardManageBCImpl.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.basic;

import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.integration.YardManageDBDAO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchZonePostCodeVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import java.util.List;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse,YardManageBC 
 * @since J2EE 1.4
 */
public class YardManageBCImpl extends BasicCommandSupport implements YardManageBC{

	// Database Access Object
	private transient YardManageDBDAO dbDao = null;

	/**
	 * creating YardManageBCImpl Object<br>
	 * creating YardManageDBDAO<br>
	 */
	public YardManageBCImpl(){
		dbDao = new YardManageDBDAO();
	}

	/**
	 * retrieving - YardManage
	 * 
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List searchNodeList(SearchNodeListVO vo) throws EventException{
		try{
			return dbDao.searchNodeList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving - YardManage
	 *
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@Override
	public List<SearchYardDetailVO> searchYardDetail(SearchYardDetailVO vo) throws EventException{
		try{
			return dbDao.searchYardDetail(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@Override
	public List<SearchZonePostCodeVO> searchZonePostCode(SearchZonePostCodeVO vo) throws EventException{
		try{
			return dbDao.searchZonePostCode(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * retrieving - YardManage
	 *
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@Override
	public List<SearchZoneDetailVO> searchZoneDetail(SearchZoneDetailVO vo) throws EventException{
		try{
			return dbDao.searchZoneDetail(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	public void doEnd(){
		dbDao = null;
	}

	/**
	 * YardManageBCImpl's searchLeaseList
	 *
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@Override
	public List<SearchLeaseListVO> searchLeaseList(SearchLeaseListVO vo) throws EventException{
		try{
			return dbDao.searchLeaseList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
}
