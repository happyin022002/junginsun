/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserBCImpl.java
*@FileTitle : User Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.19
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.19 김경범
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.user.basic;

import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.management.alps.user.integration.UserDAO;
import com.hanjin.syscommon.management.alps.user.vo.ComUserInfoVO;
import com.hanjin.syscommon.management.alps.user.vo.ComUserVO;
import com.hanjin.syscommon.management.alps.user.vo.ComUsrPgmMtchVO;
import com.hanjin.syscommon.management.alps.user.vo.UserResponseContainerVO;

/**
 * NIS2010-UserManagement Business Logic Basic Command implementation<br>
 * - NIS2010-UserManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KyungBum Kim
 * @see UserManagementEventResponse,UserBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class UserBCImpl extends BasicCommandSupport implements UserBC {

	// Database Access Object
	private transient UserDAO dbDao = null;

	/**
	 * $UserBCImpl 객체 생성<br>
	 * UserDBDAO를 생성한다.<br>
	 */
	public UserBCImpl() {
		dbDao = new UserDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 *  User화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ComUserVO comuservo
	 * @param SignOnUserAccount account
	 * @return UserResponseContainerVO
	 * @exception EventException
	 */
	public UserResponseContainerVO searchComUserVO(ComUserVO comuservo, SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet rowSet = null;
		UserResponseContainerVO containerVO = new UserResponseContainerVO();
		try {
			rowSet = dbDao.searchComUserVO(comuservo, account);
			if(rowSet!=null){
				List<Object> list = RowSetUtil.rowSetToVOs(rowSet, ComUserVO .class);
				containerVO.setComUserVO(list.toArray(new ComUserVO[list.size()]));
				containerVO.setEtcKey1("SEARCH ETC DATA1");
				containerVO.setEtcKey2("SEARCH ETC DATA2");
				//containerVO.setUsrMessage(new ErrorHandler("SPC00001",new String[]{"Schedule Information"}).getUserMessage());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return containerVO;
	}
	
	/**
	 * Office 리스트 조회 <br>
	 * Office 리스트를 조회한다<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param String rhq
	 * @param String arOfcCd
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchMdmOrganization(SignOnUserAccount account, String rhq, String arOfcCd) throws EventException{
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchMdmOrganization(account, rhq, arOfcCd);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return rowSet;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * User Program 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @param String ofcCd
	 * @param String pgmNo
	 * @param String loginUsrId
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchUserProgramMapping(String usrId, String ofcCd, String pgmNo, String loginUsrId) throws EventException{
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchUserProgramMapping(usrId,ofcCd,pgmNo,loginUsrId);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return rowSet;
	}
	/**
	 * 멀티 이벤트 처리<br>
	 * user 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ComUserVO[] comuservo
	 * @param SignOnUserAccount account
	 * @return UserResponseContainerVO
	 * @exception EventException
	 */
	public UserResponseContainerVO multiComUserVO(ComUserVO[] comuservo, SignOnUserAccount account) throws EventException{
		UserResponseContainerVO containerVO = new UserResponseContainerVO();
		try {
			dbDao.multiComUserVO(comuservo, account);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		containerVO.setEtcKey1("SAVE ETC DATA1");
		containerVO.setEtcKey2("SAVE ETC DATA2");
		containerVO.setUsrMessage(new ErrorHandler("TOT10003").getUserMessage());
		
		return containerVO;
	}
	
	/**
	 * update 이벤트 처리<br>
	 * main 화면에 대한 update 이벤트 처리<br>
	 * 
	 * @param ComUserVO comuservo
	 * @param SignOnUserAccount account
	 * @return UserResponseContainerVO
	 * @exception EventException
	 */
	public UserResponseContainerVO updateComUsrMain(ComUserVO comuservo, SignOnUserAccount account) throws EventException{
		UserResponseContainerVO containerVO = new UserResponseContainerVO();
		try {
			dbDao.updateComUsrMain(comuservo, account);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		containerVO.setEtcKey1("SAVE ETC DATA1");
		containerVO.setEtcKey2("SAVE ETC DATA2");
		containerVO.setUsrMessage(new ErrorHandler("TOT10003").getUserMessage());
		
		return containerVO;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * User Match 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param ComUsrPgmMtchVO[] comUsrPgmMtchVOs
	 * @param SignOnUserAccount account
	 * @return UserResponseContainerVO
	 * @exception EventException
	 */
	public UserResponseContainerVO multiComUsrPgmMtch(ComUsrPgmMtchVO[] comUsrPgmMtchVOs, SignOnUserAccount account) throws EventException{
		UserResponseContainerVO containerVO = new UserResponseContainerVO();
		try {
			dbDao.multiComUsrPgmMtch(comUsrPgmMtchVOs, account);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		containerVO.setUsrMessage(new ErrorHandler("TOT10003").getUserMessage());
		
		return containerVO;
		
	}
	
	/**
	 * 
	 * @param flg
	 * @param usrId
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public void multiComAppBaseMenuViewFlg(String flg, String usrId, SignOnUserAccount account) throws EventException{
		try {
			dbDao.multiComAppBaseMenuViewFlg(flg, usrId, account);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * User Info 화면 <br>
	 * 
	 * @param String usrId
	 * @return List<ComUserInfoVO>
	 * @exception EventException
	 */
	public List<ComUserInfoVO> comUsrInfo(String usrId) throws EventException{
		try {
			return dbDao.getComUsrInfo(usrId);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * DFLT_EML 업데이트<br>
	 * 업무 모듈에서 호출(BKG/DMT)<br>
	 * 
	 * @param String usrId
	 * @param String dfltEml
	 * @exception EventException
	 */
	public void modifyDfltEml(String usrId, String dfltEml) throws EventException {
		try {
			dbDao.modifyDfltEml(usrId, dfltEml);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * 업데이트<br>
	 * Adjusement Request 정보를 수신 한다.
	 * 
	 * @param ComUserVO comUsrVo
	 * @throws EventException
	 */
	public void manageComUsrMbl(ComUserVO comUsrVo) throws EventException{
		try {
			dbDao.manageComUsrMbl(comUsrVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}	
	}
	
	/**
	 * 업데이트<br>
	 * HANSAP 전체 메뉴에 대한 접근 권한지정을 수신한다.
	 * 
	 * @param ComUserVO comUsrVo
	 * @throws EventException
	 */
	public void manageComUsrMblSpr(ComUserVO comUsrVo) throws EventException{
		try {
			dbDao.manageComUsrMblSpr(comUsrVo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}	
	}
}