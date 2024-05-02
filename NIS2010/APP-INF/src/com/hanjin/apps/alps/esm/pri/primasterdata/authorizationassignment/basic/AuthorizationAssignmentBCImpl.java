/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuthorizationAssignmentBCImpl.java
*@FileTitle : Authority Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.28 문동규
* 1.0 Creation
* =========================================================
* History
* 2011.08.11 송민석 [CHM-201112844] PRI 유지 보수를 위한 User 정보 변경 프로그램 개발
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.integration.AuthorizationAssignmentDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.ChangeUserVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthAproVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthHisVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUserVO;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0009EventResponse,AuthorizationAssignmentBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class AuthorizationAssignmentBCImpl extends BasicCommandSupport implements AuthorizationAssignmentBC {

	// Database Access Object
	private transient AuthorizationAssignmentDBDAO dbDao = null;

	/**
	 * AuthorizationAssignmentBCImpl 객체 생성<br>
	 * AuthorizationAssignmentDBDAO를 생성한다.<br>
	 */
	public AuthorizationAssignmentBCImpl() {
		dbDao = new AuthorizationAssignmentDBDAO();
	}

	/**
	 * S/C Authority 정보를 조회합니다.<br>
	 * 
	 * @param RsltAuthorizationVO rsltAuthorizationVO
	 * @return List<RsltAuthorizationVO>
	 * @exception EventException
	 */
	public List<RsltAuthorizationVO> searchScAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException {
		try {
		    rsltAuthorizationVO.setPrcCtrtTpCd("S");
			return dbDao.searchAuthorizationAssignmentList(rsltAuthorizationVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Trade Authority 정보를 조회합니다.<br>
	 * 
	 * @param RsltAuthorizationVO rsltAuthorizationVO
	 * @return List<RsltAuthorizationVO>
	 * @exception EventException
	 */
	public List<RsltAuthorizationVO> searchTradeAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException {
		try {
			rsltAuthorizationVO.setPrcCtrtTpCd("C");
			return dbDao.searchTradeAuthorizationAssignmentList(rsltAuthorizationVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

    /**
     * RFA Authority 정보를 조회합니다.<br>
     * 
     * @param RsltAuthorizationVO rsltAuthorizationVO
     * @return List<RsltAuthorizationVO>
     * @exception EventException
     */
    public List<RsltAuthorizationVO> searchRfaAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException {
        try {
            rsltAuthorizationVO.setPrcCtrtTpCd("R");
            return dbDao.searchAuthorizationAssignmentList(rsltAuthorizationVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Authority 정보를 저장합니다.<br>
	 * 
	 * @param RsltAuthorizationVO[] rsltAuthorizationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAuthorizationAssignment (RsltAuthorizationVO[] rsltAuthorizationVOs, SignOnUserAccount account)
            throws EventException {
        try {
            for (int i = 0; i < rsltAuthorizationVOs.length; i++) {
                if (rsltAuthorizationVOs[i].getIbflag().equals("U")) {
                	rsltAuthorizationVOs[i].setCreUsrId(account.getUsr_id());
                	rsltAuthorizationVOs[i].setUpdUsrId(account.getUsr_id());

                    if (rsltAuthorizationVOs[i].getAuthFlg().equals("Y")) {
                        if (dbDao.modifyScAuthorizationAssignment(rsltAuthorizationVOs[i]) <= 0) {
                            dbDao.addScAuthorizationAssignment(rsltAuthorizationVOs[i]);
                        }
                    } else {
                        dbDao.removeScAuthorizationAssignment(rsltAuthorizationVOs[i]);
                    }
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Authority Creation 화면에서 조직별 사용자 콤보 리스트를 조회합니다.<br>
	 * 
	 * @param ComUserVO comUserVO
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchComUserList (ComUserVO comUserVO) throws EventException {
		try {
			return dbDao.searchComUserList(comUserVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}


    /**
     * RFA Authorization 의 조직도를 조회합니다.<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception EventException
     */
    public List<OrganizationVO> searchRFAOfficeTreeList (OrganizationVO organizationVO) throws EventException {
        try {
            return dbDao.searchRFAOfficeTreeList(organizationVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * S/C Authorization 의 조직도를 조회합니다.<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception EventException
     */
    public List<OrganizationVO> searchSCOfficeTreeList (OrganizationVO organizationVO) throws EventException {
        try {
            return dbDao.searchSCOfficeTreeList(organizationVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }
    
    
    
    /**
     * 사용자 정보를 조회 한다.<br>
     * 
     * @param ChangeUserVO changeUserVO
     * @return ChangeUserVO
     * @exception EventException
     */
    public ChangeUserVO searchComUserForChangeInquiry (ChangeUserVO changeUserVO) throws EventException {
        try {
        	List<ChangeUserVO> vo = dbDao.searchComUserForChangeInquiry(changeUserVO);
        	if( vo != null && vo.size() != 0){
        		return vo.get(0);
        	}else{
        		return null;
        	}
         } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }    
    
	/**
	 * Authority 정보를 저장합니다.<br>
	 * 
	 * @param RsltAuthorizationVO[] rsltAuthorizationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTradeAuthorizationAssignment(RsltAuthorizationVO[] rsltAuthorizationVOs, SignOnUserAccount account)
            throws EventException {
        try {
            for (int i = 0; i < rsltAuthorizationVOs.length; i++) {
                if (rsltAuthorizationVOs[i].getIbflag().equals("U")) {
                	rsltAuthorizationVOs[i].setCreUsrId(account.getUsr_id());
                	rsltAuthorizationVOs[i].setUpdUsrId(account.getUsr_id());

                    if (rsltAuthorizationVOs[i].getAuthFlg().equals("Y")) {
                        if (dbDao.modifyTradeAuthorizationAssignment(rsltAuthorizationVOs[i]) <= 0) {
                            dbDao.addTradeAuthorizationAssignment(rsltAuthorizationVOs[i]);
                        }
                    } else {
                        dbDao.removeTradeAuthorizationAssignment(rsltAuthorizationVOs[i]);
                    }
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
	
	/**
	 * 2016.09.02 추가 <br>
	 * Hard coding 권한을 조회한다.
	 * 
	 * @param RsltAuthAproVO rsltAuthAproVO
	 * @return List<RsltAuthAproVO>
	 * @exception EventException
	 */
	public List<RsltAuthAproVO> searchAuthorizationApprovalList(RsltAuthAproVO rsltAuthAproVO) throws EventException {
		try {
			if(rsltAuthAproVO.getPrcUsrAuthTpCd()==null||rsltAuthAproVO.getPrcUsrAuthTpCd().equals("")){//Office
				return dbDao.searchOfficeAuthorizationApprovalList(rsltAuthAproVO);				
			}else{//User
				return dbDao.searchUserAuthorizationApprovalList(rsltAuthAproVO);				
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 2016.09.02 추가 <br>
	 * Hard Coding User Authorization History 를 조회한다.<br>
	 * 
	 * @return RsltAuthAproVO RsltAuthAproVO
	 * @exception EventException
	 */
	public List<RsltAuthHisVO> searchAuthorizationApprovalHistoryList(RsltAuthHisVO rsltAuthHisVO) throws EventException {
		try {
			if(rsltAuthHisVO.getPrcUsrAuthTpCd()==null||rsltAuthHisVO.getPrcUsrAuthTpCd().equals("")){//Office
				return dbDao.searchOfficeAuthorizationApprovalHistoryList(rsltAuthHisVO);				
			}else{//User
				return dbDao.searchUserAuthorizationApprovalHistoryList(rsltAuthHisVO);				

			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) { 
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 2016.09.02 추가 <br>
	 * Hard Coding 권한 및 History를 저장한다.
	 * 
	 * @param RsltAuthAproVO[] rsltAuthAproVOs,UsrAuthHisVO[] usrAuthHisVOs, SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int multiAuthorizationApprovalList(RsltAuthAproVO[] rsltAuthAproVOs,RsltAuthHisVO[] rsltAuthHisVOs, SignOnUserAccount account) throws EventException {
		int result = 0;
		try {
					for (int i = 0; i < rsltAuthAproVOs.length; i++) {
								//Data Setting
								if(rsltAuthAproVOs[i].getIbflag().equals("I")){ // 신규 권한 생성일 경우만 CreUsrId입력
									rsltAuthAproVOs[i].setCreUsrId(account.getUsr_id());
								}
			                	rsltAuthAproVOs[i].setUpdUsrId(account.getUsr_id());
			                	rsltAuthHisVOs[i].setCreUsrId(account.getUsr_id());
			                	rsltAuthHisVOs[i].setUpdUsrId(account.getUsr_id());
			                	rsltAuthHisVOs[i].setProgUsrId(account.getUsr_id());
			                	rsltAuthHisVOs[i].setProgOfcCd(account.getOfc_cd());
			                	
			                	//DBDAO호출
			                	if(rsltAuthAproVOs[i].getPrcUsrAuthTpCd()==null||rsltAuthAproVOs[i].getPrcUsrAuthTpCd().equals("")){//Office
									dbDao.mergeOfficeAuthorizationApprovalVO(rsltAuthAproVOs[i]);//권한 저장	
									dbDao.insertOfficeAuthorizationApprovalHistoryVO(rsltAuthHisVOs[i]);//History 저장
			                	}else{//User
			                		dbDao.mergeUserAuthorizationApprovalVO(rsltAuthAproVOs[i]);//권한 저장	
			                		dbDao.insertUserAuthorizationApprovalHistoryVO(rsltAuthHisVOs[i]);//History 저장
			                	}
						}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return result;
	}
	
	

	
}