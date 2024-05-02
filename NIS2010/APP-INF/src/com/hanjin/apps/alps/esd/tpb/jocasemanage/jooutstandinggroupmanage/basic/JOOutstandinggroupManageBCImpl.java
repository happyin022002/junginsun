/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOutstandinggroupManageBCImpl.java
*@FileTitle : JOOutstandinggroupManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.integration.JOOutstandinggroupManageDBDAO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo.SearchTPBGroupModifyListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-JOOutstandinggroupManageManage Business Logic Basic Command implementation<br>
 * - ALPS-JOOutstandinggroupManageManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_105EventResponse,JOOutstandinggroupManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class JOOutstandinggroupManageBCImpl extends BasicCommandSupport implements JOOutstandinggroupManageBC {

	// Database Access Object
	private transient JOOutstandinggroupManageDBDAO dbDao = null;

	/**
	 * JOOutstandinggroupManageBCImpl 객체 생성<br>
	 * JOOutstandinggroupManageDBDAO를 생성한다.<br>
	 */
	public JOOutstandinggroupManageBCImpl() {
		dbDao = new JOOutstandinggroupManageDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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