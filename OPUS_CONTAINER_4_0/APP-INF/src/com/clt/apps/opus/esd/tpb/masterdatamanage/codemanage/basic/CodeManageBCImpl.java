/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TpbCodeManageBCImpl.java
*@FileTitle : TPB Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.integration.CodeManageDBDAO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeInquiryListVO;
import com.clt.apps.opus.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -TpbMasterDataManage Business Logic Basic Command implementation<br>
 * - -TpbMasterDataManage business logic interface<br>
 *
 * @author 
 * @see EsdTpb101EventResponse,TpbCodeManageBC DAO class reference
 * @since J2EE 1.6
 */
public class CodeManageBCImpl extends BasicCommandSupport implements CodeManageBC {

	// Database Access Object
	private transient CodeManageDBDAO dbDao = null;

	/**
	 * TpbCodeManageBCImpl object creation<br>
	 * TpbCodeManageDBDAO creation<br>
	 */
	public CodeManageBCImpl() {
		dbDao = new CodeManageDBDAO();
	}
	/**
	 * retrieve event process<br>
	 *  TpbCodeManage screen retrieve event process<br>
	 * 
	 * @param SearchCodeListVO searchTPBCodeListVO
	 * @return List<SearchCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCodeListVO> searchCodeList(SearchCodeListVO searchTPBCodeListVO) throws EventException {
		try {
			return dbDao.searchCodeListValue(searchTPBCodeListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * multi event<br>
	 * UI_COM_EDM_001 screen multi event<br>
	 * 
	 * @param SearchCodeListVO[] searchCodeListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void searchCodeList(SearchCodeListVO[] searchCodeListVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchCodeListVO> insertVoList = new ArrayList<SearchCodeListVO>();
			List<SearchCodeListVO> updateVoList = new ArrayList<SearchCodeListVO>();
			List<SearchCodeListVO> deleteVoList = new ArrayList<SearchCodeListVO>();
			
			for ( int i=0; i<searchCodeListVO.length; i++ ) {
				if ( searchCodeListVO[i].getIbflag().equals("I")){
					searchCodeListVO[i].setCreUsrId(account.getUsr_id());
					searchCodeListVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(searchCodeListVO[i]);
				} else if ( searchCodeListVO[i].getIbflag().equals("U")){
					searchCodeListVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchCodeListVO[i]);
				} else if ( searchCodeListVO[i].getIbflag().equals("D")){
					searchCodeListVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(searchCodeListVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSearchCodeList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySearchCodeList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSearchCodeList(deleteVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * retrieve event<br>
	 *  TpbCodeManage screen retrieve event<br>
	 * 
	 * @param SearchCodeInquiryListVO searchCodeInquiryListVO
	 * @return List<SearchCodeInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchCodeInquiryListVO> searchCodeInquiryList(SearchCodeInquiryListVO searchCodeInquiryListVO) throws EventException {
		try {
			return dbDao.searchCodeInquiryList(searchCodeInquiryListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}