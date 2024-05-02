/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-08
*@LastModifier : 심성윤
*@LastVersion : 1.0
* 2015-07-08 심성윤
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.authorization.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.bizcommon.authorization.integration.AuthorizationDBDAO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationCommonVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationProgramInfoVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationRouteVO;
import com.hanjin.bizcommon.authorization.vo.ComAuthAproRqstVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SungYoon Shim
 * @see COM_APR_0T1EventResponse,StaffBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AuthorizationBCImpl extends BasicCommandSupport implements AuthorizationBC {

	// Database Access Object
	private transient AuthorizationDBDAO dbDao=null;
	/**
	 * StaffBCImpl 객체 생성<br>
	 * StaffDBDAO를 생성한다.<br>
	 */
	public AuthorizationBCImpl(){
		dbDao = new AuthorizationDBDAO();
	}

	/**
	 * Authorization Apro Rqst 항목 생성 
	 * @param authorizationRouteVOs
	 * @param authorizationCommonVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String saveAuthorizationRoute(AuthorizationRouteVO[] authorizationRouteVOs, 
			AuthorizationCommonVO authorizationCommonVO,SignOnUserAccount account) throws EventException {
		try {
//			AuthorizationRouteVO authorizationRouteVO = null;
			List<AuthorizationRouteVO> insertVoList = new ArrayList<AuthorizationRouteVO>();
			
			String authAproRqstNo = "";
			authAproRqstNo = dbDao.searchAuthAproSeq(); // 시퀀스 No 채번
			
			//COM_AUTH_APRO_RQST 추가
			ComAuthAproRqstVO authRqstVO = new ComAuthAproRqstVO();
			authRqstVO.setAuthAproRqstNo(authAproRqstNo);
			authRqstVO.setAuthPgmBtnSeq(authorizationCommonVO.getAuthPgmBtnSeq());
			authRqstVO.setRqstUsrId(account.getUsr_id());
			authRqstVO.setRqstUsrNm(account.getUsr_nm());
			authRqstVO.setRqstOfcCd(account.getOfc_cd());
			authRqstVO.setRqstOfcNm(account.getOfc_eng_nm());
			authRqstVO.setCreUsrId(account.getUsr_id());
			authRqstVO.setUpdUsrId(account.getUsr_id());
			authRqstVO.setAuthRqstRsn(authorizationCommonVO.getAuthRqstRsn());
			
			//COM_AUTH_APRO_RQST 추가
			dbDao.createAuthorizationAproRqst(authRqstVO);
			
			
        	if(authorizationRouteVOs != null) {
        		for ( int i=0; i<authorizationRouteVOs.length; i++ ) {
        			authorizationRouteVOs[i].setAuthAproRqstNo(authAproRqstNo);
        			authorizationRouteVOs[i].setUsrId(account.getUsr_id());
        			insertVoList.add(authorizationRouteVOs[i]);
        		}
        	}
        	
        	if (insertVoList.size() > 0) {
        		for(int i=0; i<insertVoList.size(); i++){
        			insertVoList.get(i).setAuthAproRoutUsrSeq(authorizationRouteVOs[i].getAuthAproRoutUsrSeq());
        		}
        		//기본결재라인 디테일의 승인권자 정보를 생성한다 
        		dbDao.addAuthAproRouteDetail(insertVoList);
        	}
        	return authAproRqstNo;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	
	
	/**
	 * COM_APR_0T1
	 * Self 결재자 인지 Check 하는 로직<br>
	 * 
	 * @param AuthorizationRouteVO authorizationRouteVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthSelfApprovalCheck(AuthorizationRouteVO authorizationRouteVO, 
			SignOnUserAccount account) throws EventException {
		String  chkApproval = "";
		try {
			chkApproval = dbDao.searchAuthSelfApprovalCheck(authorizationRouteVO, account);
        	return chkApproval;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	
	/**
	 * Authorization Approval Default Line 조회
	 * COM_APR_0T1
	 * @param SearchAuthAproVO searchAuthAproVO
	 * @return List<SearchAuthAproVO>
	 * @throws EventException
	 */
	public List<SearchAuthAproVO> searchAuthAproDflt(SearchAuthAproVO searchAuthAproVO) throws EventException {
		try {
			
			return  dbDao.searchAuthAproDflt(searchAuthAproVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	/**
	 * Authorization 설정 정보 조회
	 * COM_APR_0T1
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return List<AuthorizationProgramInfoVO>
	 * @throws EventException
	 */
	public List<AuthorizationProgramInfoVO> searchAuthPgmInfo(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException {
		try {
			
			return  dbDao.searchAuthPgmInfo(authorizationProgramInfoVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	/**
	 * Excel Download 승인 대상 화면인지 확인
	 * COM_APR_0T1 searchAuthChkXlsBtnPrmt
	 * @param SearchAuthAproVO searchAuthAproVO
	 * @return String
	 * @throws EventException
	 */
	public String searchAuthChkXlsBtnPrmt(SearchAuthAproVO searchAuthAproVO) throws EventException{
		String  chkPrmt = "";
		try {
			chkPrmt = dbDao.searchAuthChkXlsBtnPrmt(searchAuthAproVO);
        	return chkPrmt;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	/**
	 * 결재자 E-mail 유/무 확인
	 * COM_APR_0T1
	 * @param String authAproRqstNo
	 * @return String
	 * @throws EventException
	 */
	public String searchNoEmlAddr(String authAproRqstNo) throws EventException{
		String  retval = "";
		try {
			retval = dbDao.searchNoEmlAddr(authAproRqstNo);
        	return retval;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	/**
	 * 결재자 E-mail 유/무 확인 사유 update
	 * COM_APR_0T1
	 * @param String authAproRqstNo
	 * @param String noEmlApro
	 * @throws EventException
	 */
	public void updateNoEmlAddrRmk(String authAproRqstNo, String noEmlApro) throws EventException{
		try {
			dbDao.updateNoEmlAddrRmk(authAproRqstNo, noEmlApro);
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	
	/**
	 * Authorization 전체 설정 정보 조회
	 * COM_APR_0S1
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return List<AuthorizationProgramInfoVO>
	 * @throws EventException
	 */
	public List<AuthorizationProgramInfoVO> searchAllAuthPgmInfo(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException {
		try {
			
			return  dbDao.searchAllAuthPgmInfo(authorizationProgramInfoVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	/**
	 * 0S2 팝업 콤보 데이터 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse getComboData(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String[] comboList = new String[2];
		try {
				if(authorizationProgramInfoVO != null){
					comboList = dbDao.getComboDataSubSysCdAuth();					
				}
				for(int i = 0; i < comboList.length; i++){
					log.error("comboLists[ " + i + " ] = " + comboList[i] + "\n\n");					
				}
				eventResponse.setETCData("SUB_SYS_CD_AUTH", comboList[0]);
				eventResponse.setETCData("SUB_SYS_CD", comboList[1]);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
		return eventResponse;
	}

	/**
	 * 0S2 팝업 콤보 데이터 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse getPgmNm(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String pgmNm = "";
		try {
				if(authorizationProgramInfoVO != null){
					pgmNm = dbDao.getPgmNm(authorizationProgramInfoVO);					
				}
				
				eventResponse.setETCData("PGM_NM", pgmNm);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
		return eventResponse;
	}
	
	/**
	 * 0S2 팝업 콤보 데이터 조회
	 * 
	 * @param AuthorizationProgramInfoVO authorizationProgramInfoVO
	 * @return AuthorizationProgramInfoVO
	 * @exception EventException
	 */
	public AuthorizationProgramInfoVO searchPgmDetail(AuthorizationProgramInfoVO authorizationProgramInfoVO) throws EventException {
		AuthorizationProgramInfoVO vo = new AuthorizationProgramInfoVO();
		try {
				if(authorizationProgramInfoVO != null){
					vo = dbDao.searchPgmDetail(authorizationProgramInfoVO);					
				}
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
		return vo;
	}
	
	
	
	/**
	 * 0S2 팝업 데이터 저장
	 * 
	 * @param AuthorizationProgramInfoVO[] authorizationProgramInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void savePgmAuth(AuthorizationProgramInfoVO[] authorizationProgramInfoVOs, SignOnUserAccount account) throws EventException {
		try {
        	if(authorizationProgramInfoVOs != null) {
        		for ( int i=0; i<authorizationProgramInfoVOs.length; i++ ) {
        			authorizationProgramInfoVOs[i].setUsrId(account.getUsr_id());
        			dbDao.addAuthPgm(authorizationProgramInfoVOs[i]);
            		dbDao.addAuthPgmBtn(authorizationProgramInfoVOs[i]);
            		dbDao.addAuthPgmFld(authorizationProgramInfoVOs[i]);
        		}
        	}       	
        	

				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203",
					new String[] { "Save Approval Route" }).getMessage(), ex);

		}
	}
	
	
	
	
}