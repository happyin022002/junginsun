/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOutstandinggroupManageBCImpl.java
*@FileTitle : JOOutstandinggroupManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.integration.JOOutstandinggroupManageDBDAO;
import com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo.SearchTPBGroupModifyListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -JOOutstandinggroupManageManage Business Logic Basic Command implementation<br>
 * - -JOOutstandinggroupManageManage business logic interface<br>
 *
 * @author 
 * @see ESD_TPB_105EventResponse,JOOutstandinggroupManageBC DAO class reference
 * @since J2EE 1.6
 */
public class JOOutstandinggroupManageBCImpl extends BasicCommandSupport implements JOOutstandinggroupManageBC {

	// Database Access Object
	private transient JOOutstandinggroupManageDBDAO dbDao = null;

	/**
	 * JOOutstandinggroupManageBCImpl object creation<br>
	 * JOOutstandinggroupManageDBDAO creation<br>
	 */
	public JOOutstandinggroupManageBCImpl() {
		dbDao = new JOOutstandinggroupManageDBDAO();
	}
	/**
	 * <br>
	 * 
	 * @param SearchTPBGroupModifyListVO searchTPBGroupModifyListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> searchTPBGroupModifyList(SearchTPBGroupModifyListVO searchTPBGroupModifyListVO,SignOnUserAccount account) throws EventException{
		try {
			searchTPBGroupModifyListVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchTPBGroupModifyList(searchTPBGroupModifyListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * <br>
	 * 
	 * @param SearchTPBGroupModifyListVO[] multiTPBGroupModifyListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> multiTPBGroupModify(SearchTPBGroupModifyListVO[] multiTPBGroupModifyListVO, SignOnUserAccount account) throws EventException{
		try {
			
			List<SearchTPBGroupModifyListVO> updateVoList = new ArrayList<SearchTPBGroupModifyListVO>();
			
			for ( int i=0; i<multiTPBGroupModifyListVO .length; i++ ) {
				if ( multiTPBGroupModifyListVO[i].getIbflag().equals("U")){
					multiTPBGroupModifyListVO[i].setUserId(account.getUsr_id());
					multiTPBGroupModifyListVO[i].setUserOfcCd(account.getOfc_cd());
					updateVoList.add(multiTPBGroupModifyListVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTPBGroupModify(updateVoList);
			}
			return this.searchTPBGroupModifyList(multiTPBGroupModifyListVO[0], account);
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * <br>
	 * 
	 * @param SearchTPBGroupModifyListVO[] multiTPBGroupModifyListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBGroupModifyListVO>
	 * @exception EventException
	 */
	public List<SearchTPBGroupModifyListVO> updateJOTPBCancel(SearchTPBGroupModifyListVO[] multiTPBGroupModifyListVO, SignOnUserAccount account) throws EventException{
		try {
			
			List<SearchTPBGroupModifyListVO> updateVoList = new ArrayList<SearchTPBGroupModifyListVO>();
			
			for ( int i=0; i<multiTPBGroupModifyListVO .length; i++ ) {
				if ( multiTPBGroupModifyListVO[i].getIbflag().equals("U")){
					multiTPBGroupModifyListVO[i].setUserId(account.getUsr_id());
					multiTPBGroupModifyListVO[i].setUserOfcCd(account.getOfc_cd());
					updateVoList.add(multiTPBGroupModifyListVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyJOTPBCancel(updateVoList);
			}
			return this.searchTPBGroupModifyList(multiTPBGroupModifyListVO[0], account);
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
}