/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserRoleApprovalBCImpl.java
*@FileTitle : Role Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
* 1.8 master@hanjin email 추가
=========================================================*/
package com.hanjin.syscommon.management.alps.role.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComAproRoleDtlVO;
import com.hanjin.syscommon.common.table.ComAproRoleRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRoleRqstRoutVO;
import com.hanjin.syscommon.common.table.ComUsrRoleMtchVO;
import com.hanjin.syscommon.management.alps.role.integration.UserRoleApprovalDBDAO;
import com.hanjin.syscommon.management.alps.role.vo.AuthorityVO;
import com.hanjin.syscommon.management.alps.role.vo.ComUsrRoleConditionVO;
import com.hanjin.syscommon.management.alps.role.vo.MenuListVO;
import com.hanjin.syscommon.management.alps.role.vo.SearchModulePicVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleAuthAproVO;
import com.hanjin.syscommon.management.alps.role.vo.UserRoleRqstEmlVO;

/**
 * ALPS-UserRoleApproval Business Logic Command Interface<br>
 * - ALPS-UserRoleApproval에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see 
 * @since J2EE 1.6
 */
public class UserRoleApprovalBCImpl extends BasicCommandSupport implements UserRoleApprovalBC {

	// Database Access Object
	private transient UserRoleApprovalDBDAO dbDao = null;

	/**
	 * UserRoleApprovalBCImpl 객체 생성<br>
	 * UserRoleApprovalDBDAO를 생성한다.<br>
	 */
	public UserRoleApprovalBCImpl() {
		dbDao = new UserRoleApprovalDBDAO();
	}
	
	/**
	 * 메뉴 리스트 조회<br>
	 * 
	 * @param MenuListVO menuListVO
	 * @return List<MenuListVO>
	 * @exception EventException
	 */
	public List<MenuListVO> selectMenuList(MenuListVO menuListVO) throws EventException {
		try {
			return dbDao.selectMenuList(menuListVO);
		} catch(DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	/**
	 * module별 role 리스트 조회<br>
	 * 
	 * @param String subSysCd
	 * @param SignOnUserAccount account
	 * @return List<ComUsrRoleConditionVO>
	 * @exception EventException
	 */
	public List<ComUsrRoleConditionVO> selectModuleRole(String subSysCd, SignOnUserAccount account) throws EventException {
		String usr_id = account.getUsr_id();
		
		try {
			return dbDao.selectModuleRole(subSysCd, usr_id);
		} catch(DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * rqst user의 role 리스트를 조회<br>
	 * 
	 * @param String subSysCd
	 * @param String rqstUsrId
	 * @return List<ComUsrRoleConditionVO>
	 * @exception EventException
	 */
	public List<ComUsrRoleConditionVO> selectRqstRoleModuleList(String subSysCd, String rqstUsrId) throws EventException {
		
		try {
			return dbDao.selectModuleRole(subSysCd, rqstUsrId);
		} catch(DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * user role을 신청<br>
	 * 
	 * @param UserRoleAuthAproVO[] userRoleAuthAproVOs
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> manageUserRoleRpst(UserRoleAuthAproVO[] userRoleAuthAproVOs, SignOnUserAccount account) throws EventException{
		try {
			//COM_APRO_ROLE_RQST_HDR Add
			List<ComAproRoleRqstHdrVO> rqstHdrList = new ArrayList<ComAproRoleRqstHdrVO>();			
			List<ComAproRoleRqstRoutVO> rqstRoutVoList = new ArrayList<ComAproRoleRqstRoutVO>();
			List<ComAproRoleDtlVO> dtlVoList = new ArrayList<ComAproRoleDtlVO>();
			List<String> rqstList = new ArrayList<String>();
			
			
			for ( int i=0; i< userRoleAuthAproVOs.length; i++ ) {
				if ( userRoleAuthAproVOs[i].getIbflag().equals("I")){
					
					String aproRqstNo = dbDao.getNewAproRqstNo();
					rqstList.add(aproRqstNo);
					
					ComAproRoleRqstHdrVO rqstHdrVo = new ComAproRoleRqstHdrVO();
					rqstHdrVo.setAproRqstNo(aproRqstNo);
					rqstHdrVo.setRqstUsrId(account.getUsr_id());
					rqstHdrVo.setRqstUsrNm(account.getUsr_nm());
					rqstHdrVo.setRqstOfcCd(account.getOfc_cd());
					rqstHdrVo.setRqstOfcNm(account.getOfc_eng_nm());
					rqstHdrVo.setCreUsrId(account.getUsr_id());
					rqstHdrVo.setUpdUsrId(account.getUsr_id());
					rqstHdrVo.setRqstRmk(userRoleAuthAproVOs[0].getRqstRmk());
					rqstHdrList.add(rqstHdrVo);
					
					ComAproRoleDtlVO roleDtl = new ComAproRoleDtlVO();
					roleDtl.setAproRqstNo(aproRqstNo);
					roleDtl.setUsrRoleCd(userRoleAuthAproVOs[i].getUsrRoleCd());
					roleDtl.setCreUsrId(account.getUsr_id());
					roleDtl.setUpdUsrId(account.getUsr_id());
					dtlVoList.add(roleDtl);
					
					ComAproRoleRqstRoutVO rqstRout = new ComAproRoleRqstRoutVO();
					rqstRout.setAproRqstNo(aproRqstNo);
					rqstRout.setCreUsrId(account.getUsr_id());
					rqstRout.setUpdUsrId(account.getUsr_id());
					rqstRout.setAproRqstSeq(Integer.toString(i+1));
					rqstRoutVoList.add(rqstRout);		
					
				}
			}
			
			if ( rqstHdrList.size() > 0 ) {
				dbDao.addUserRoleRpst(rqstHdrList);
			}
			
			if ( dtlVoList.size() > 0 ) {
				dbDao.addUserRoleRqstDtl(dtlVoList);
			}
			
			if ( rqstRoutVoList.size() > 0 ) {
				dbDao.addUserRoleRqstRout(rqstRoutVoList);
			}
			
			return rqstList;

		} catch(DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * user role 신청 조회<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return List<UserRoleAuthAproVO>
	 * @exception EventException
	 */
	@Override
	public List<UserRoleAuthAproVO> selectUserRoleAuthAproList(SignOnUserAccount account) throws EventException {
		String usr_id = account.getUsr_id();
		String usr_auth_tp_cd = account.getUsr_auth_tp_cd();
		
		try {
			return dbDao.selectUserRoleAuthAproList(usr_id, usr_auth_tp_cd);
		} catch(DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * super User Module 조회<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return List<UserRoleAuthAproVO>
	 * @exception EventException
	 */	
	@Override
	public List<UserRoleAuthAproVO> selectSuperUserRoleModule(SignOnUserAccount account) throws EventException {
		String usr_id = account.getUsr_id();
		
		try {
			return dbDao.selectSuperUserRoleModule(usr_id);
		} catch(DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * user role 승인<br>
	 * 
	 * @param UserRoleAuthAproVO[] userRoleAuthAproVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void manageUserRoleAuthApro(UserRoleAuthAproVO[] userRoleAuthAproVO, SignOnUserAccount account) throws EventException {
		try {
			List<ComAproRoleRqstRoutVO> updateVoList = new ArrayList<ComAproRoleRqstRoutVO>();
			List<ComUsrRoleMtchVO> insModels =new ArrayList<ComUsrRoleMtchVO>();
			List<ComAproRoleDtlVO> roleInsModels = new ArrayList<ComAproRoleDtlVO>();
			List<ComAproRoleDtlVO> roleUpdModels = new ArrayList<ComAproRoleDtlVO>();
			
			for ( int i=0; i< userRoleAuthAproVO .length; i++ ) {
				if ( userRoleAuthAproVO[i].getIbflag().equals("U")){
					
					ComAproRoleRqstRoutVO updateVo = new ComAproRoleRqstRoutVO();
					ComUsrRoleMtchVO insModel= new ComUsrRoleMtchVO();
					//ComUsrRoleMtchVO delModel= new ComUsrRoleMtchVO();
					
					String apro_rqst_no = userRoleAuthAproVO[i].getAproRqstNo();
					String usr_role_cd = userRoleAuthAproVO[i].getUsrRoleCd();
					String apro_role_cd = userRoleAuthAproVO[i].getAproRoleCd();
					String apsts_cd = userRoleAuthAproVO[i].getApstsCd();
					

					updateVo.setAproRqstNo(apro_rqst_no);
					updateVo.setApstsCd(apsts_cd);
					updateVo.setAproRmk(userRoleAuthAproVO[i].getAproRmk());

					updateVo.setAproUsrId(account.getUsr_id());
					updateVo.setAproUsrNm(account.getUsr_nm());
					updateVo.setAproOfcCd(account.getOfc_cd());
					updateVo.setUpdUsrId(account.getUsr_id());
					
					updateVoList.add(updateVo);
					
					//결제완료 시 Role 생성
					if(apsts_cd.equals("C")){
						
						//승인 시 변경된 role 있을 경우 신규 role 생성하고 이전 요청한 role은 상태를 R로 변경해준다.
						if(apro_role_cd != null && !"".equals(apro_role_cd)){
							
							ComAproRoleDtlVO roleDtl = new ComAproRoleDtlVO();					
							roleDtl.setAproRqstNo(apro_rqst_no);
							roleDtl.setUsrRoleCd(apro_role_cd);
							roleDtl.setCreUsrId(account.getUsr_id());
							roleDtl.setUpdUsrId(account.getUsr_id());
							roleInsModels.add(roleDtl);				
							
							ComAproRoleDtlVO roleUpdDtl = new ComAproRoleDtlVO();
							roleUpdDtl.setAproRqstNo(apro_rqst_no);
							roleUpdDtl.setUsrRoleCd(usr_role_cd);
							roleUpdDtl.setCreUsrId(account.getUsr_id());
							roleUpdDtl.setUpdUsrId(account.getUsr_id());
							roleUpdModels.add(roleUpdDtl);		
							
							//role 생성을 위해 변경한다.
							usr_role_cd = apro_role_cd;
						}
						
						//insModel.setUsrId(account.getUsr_id());
						insModel.setUsrId(userRoleAuthAproVO[i].getRqstUsrId());
						insModel.setUsrRoleCd(usr_role_cd);
						insModel.setCreUsrId(account.getUsr_id());
						insModel.setUpdDt(account.getUsr_id());
						insModels.add(insModel);
					}
					
					//결제완료 시 Role 삭제
//					if(apsts_cd.equals("R")){
//						delModel.setUsrId(account.getUsr_id());
//						delModel.setUsrRoleCd(userRoleAuthAproVO[i].getUsrRoleCd());
//						delModel.setCreUsrId(account.getUsr_id());
//						delModel.setUpdDt(account.getUsr_id());
//						delModels.add(delModel);
//					}
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyUserRoleAuthApro(updateVoList);
			}
			
			if ( insModels.size() > 0 ) {
				dbDao.addUserRoleMatch(insModels);
			}
			
			if ( roleInsModels.size() > 0 ){
				dbDao.addUserRoleRqstDtl(roleInsModels);
			}
			
			if ( roleUpdModels.size() > 0 ){
				dbDao.modifyUserRoleRqstDtl(roleUpdModels);
			}
			
//			if ( delModels.size() > 0 ) {
//				dbDao.removeUserRoleMatch(delModels);
//			}

		} catch(DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [COM_SEC_0004]<br>
	 * ALPS Role Authority Approval Monitoring<br>
	 *
	 * @param HashMap<String, String> param
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AuthorityVO> searchRoleAuthorityApprovalMonitoring(HashMap<String, String> param) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<AuthorityVO> list = null;
		try {
			list = dbDao.getApprovalList(param);
			
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [COM_SEC_0003]<br>
	 * ALPS Role Validation Check<br>
	 * 
	 * @param String rqstRoleCd
	 * @param String rqstUsrId
	 * @return String
	 * @exception EventException
	 */
	@Override
	public String selectRqstRoleCd(String rqstRoleCd, String rqstUsrId) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.selectRqstRoleCd(rqstRoleCd, rqstUsrId);
		} catch(DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [COM_SEC_0003]<br>
	 * ALPS Role Request List<br>
	 * 
	 * @param List<String> rqstList
	 * @return List<UserRoleAuthAproVO>
	 * @exception EventException
	 */
	@Override
	public List<UserRoleAuthAproVO> selectRqstRoleList(List<String> rqstList) throws EventException {
		// TODO Auto-generated method stub
		List<UserRoleAuthAproVO> roleRqstList = null;
		try {
			roleRqstList = dbDao.selectRqstRoleList(rqstList);
			
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return roleRqstList;
	}

	/**
	 * [COM_SEC_0003]<br>
	 * ALPS Role Request Send Email<br>
	 * 
	 * @param List<UserRoleAuthAproVO> userRoleAuthAproVOs
	 * @return List<UserRoleRqstEmlVO>
	 * @exception EventException
	 */
	@Override
	public List<UserRoleRqstEmlVO> sendUserRoleRqstEml(List<UserRoleAuthAproVO> userRoleAuthAproVOs) throws EventException {
		// TODO Auto-generated method stub
		List<UserRoleRqstEmlVO> emlSndVolist = new ArrayList<UserRoleRqstEmlVO>();
		String groupRoleModule = "";
		StringBuffer sbContents = new StringBuffer();
		UserRoleRqstEmlVO emlSndVo = new UserRoleRqstEmlVO();
		boolean emlSndVoEnable = false;
		
		try{
			for(int i=0; i < userRoleAuthAproVOs.size(); i++){
				UserRoleAuthAproVO usrRoleRqst = (UserRoleAuthAproVO) userRoleAuthAproVOs.get(i);		
				
				String roleModule = usrRoleRqst.getRoleModule();
				String rqstUsrId = usrRoleRqst.getRqstUsrId();
				String rqstUsrNm = usrRoleRqst.getRqstUsrNm();
				String rqstOfcCd = usrRoleRqst.getRqstOfcCd();
				String rqstRoleCd = usrRoleRqst.getUsrRoleCd();
				String rqstdt = usrRoleRqst.getRqstStDtHr();
				String sendUsrEmail = usrRoleRqst.getRqstUsrEml();
				
				if(sendUsrEmail == null || "".equals(sendUsrEmail)){
					sendUsrEmail = "postmaster@hanjin.com";
				}
				
				if(!roleModule.equals(groupRoleModule)){
					
					if(i!= 0){
						//메일내용
						sbContents.append("\n					</table>  ");
						sbContents.append("\n					</td>  ");
						sbContents.append("\n				</tr>  ");
						sbContents.append("\n		</table>  ");
						sbContents.append("\n		</td>  ");
						sbContents.append("\n	</tr>  ");
						sbContents.append("\n</table>  ");
						sbContents.append("\n</body>  ");
						
						emlSndVo.setContent(sbContents.toString());
						emlSndVolist.add(emlSndVo);
					}
					
					sbContents = new StringBuffer();
					emlSndVo = new UserRoleRqstEmlVO();
					emlSndVoEnable = true;
					
					emlSndVo.setSendUsrEmail(sendUsrEmail);
					emlSndVo.setSubject("RQST for approval of ALPS Role – "+roleModule+"(Module)");

					List<SearchModulePicVO> picList = dbDao.selectModulePicList(roleModule);

					StringBuffer pidEml = new StringBuffer();
					if(picList != null && picList.size() > 0){
						for(int j=0; j < picList.size(); j++){
							pidEml.append((String)picList.get(j).getUsrEml());
							
							if(j+1 != picList.size()){
								pidEml.append(",");
							}
						}
					}	
					
					emlSndVo.setReceiptUsrEmail(pidEml.toString());		
					
					
				}
				
				if(emlSndVoEnable == true){

					sbContents.append("\n<html>  ");
					sbContents.append("\n<head>  ");
					sbContents.append("\n<title></title>  ");
					sbContents.append("\n<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>  ");
					sbContents.append("\n</head>  ");
					sbContents.append("\n<body>  ");
					sbContents.append("\n<table width='800' border='0' cellpadding='0' cellspacing='0' style='padding-top: 2; padding-left: 5;'>  ");
					sbContents.append("\n	<tr>  ");
					sbContents.append("\n		<td valign='top'>  ");
					sbContents.append("\n		<table border='0' cellpadding='0' cellspacing='0' width='100%'>  ");
					sbContents.append("\n			<tr>  ");
					sbContents.append("\n				<td>  ");
					sbContents.append("\n				<table border='0' cellpadding='0' cellspacing='0' width='100%'>  ");
					sbContents.append("\n					<tr>  ");
					sbContents.append("\n						<td width='100%' colspan='2'>  ");
					sbContents.append("\n					</tr>  ");
					sbContents.append("\n				</table>  ");
					sbContents.append("\n				</td>  ");
					sbContents.append("\n			</tr>  ");
					sbContents.append("\n				<tr><td height='30'></td></tr>  ");
					sbContents.append("\n				<tr>  ");
					sbContents.append("\n					<td>  ");
					sbContents.append("\n					<table border='0' cellpadding='0' cellspacing='0' width='100%'>  ");
					sbContents.append("\n						<tr>  ");
					sbContents.append("\n							<td width='100%' colspan='2'>Please allow me to access the below function on ALPS. </td>  ");
					sbContents.append("\n						</tr>  ");
					sbContents.append("\n					</table>  ");
					sbContents.append("\n					</td>  ");
					sbContents.append("\n				</tr>  ");
					sbContents.append("\n				<tr><td height='20'></td></tr>  ");
					sbContents.append("\n				<tr>  ");
					sbContents.append("\n					<td>  ");
					sbContents.append("\n					<table border='0' cellpadding='0' cellspacing='0' width='100%'>  ");
					sbContents.append("\n						<tr>  ");
					sbContents.append("\n							<td width='100%' colspan='2'>Request Info. </td>  ");
					sbContents.append("\n						</tr>  ");
					sbContents.append("\n					</table>  ");
					sbContents.append("\n					</td>  ");
					sbContents.append("\n				</tr>  ");
					sbContents.append("\n				<tr><td height='10'></td></tr>  ");
					sbContents.append("\n				<tr>  ");
					sbContents.append("\n					<td>  ");
					sbContents.append("\n					<table border='0' cellpadding='1' cellspacing='1' width='100%' style='background-color:#F3F2F8; border:1px solid #A3A4C7;'>  ");
					sbContents.append("\n						<tr height='25' align='center' style='background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold;'>  ");
					sbContents.append("\n							<td width='15%'>RQST ID</td>  ");
					sbContents.append("\n							<td width='20%'>Name</td>  ");
					sbContents.append("\n							<td width='15%'>Office</td>  ");
					sbContents.append("\n							<td width='15%'>Module</td>  ");
					sbContents.append("\n							<td width='15%'>Role</td>  ");
					sbContents.append("\n							<td width='20%'>RQST DT</td>  ");
					sbContents.append("\n						</tr>  ");
					
					emlSndVoEnable = false;
				}
				
				
				sbContents.append("\n						<tr height='23' style='background-color: #FFFFFF; color: #313131; text-align : center;'>  ");
				sbContents.append("\n							<td>" + rqstUsrId + "</td>  ");
				sbContents.append("\n							<td>" + rqstUsrNm + "</td>  ");
				sbContents.append("\n							<td>" + rqstOfcCd + "</td>  ");
				sbContents.append("\n							<td>" + roleModule + "</td>  ");
				sbContents.append("\n							<td>" + rqstRoleCd + "</td>  ");
				sbContents.append("\n							<td>" + rqstdt + "</td>  ");
				sbContents.append("\n						</tr>  ");

				
				if(i == userRoleAuthAproVOs.size()-1 ){
					sbContents.append("\n					</table>  ");
					sbContents.append("\n					</td>  ");
					sbContents.append("\n				</tr>  ");
					sbContents.append("\n		</table>  ");
					sbContents.append("\n		</td>  ");
					sbContents.append("\n	</tr>  ");
					sbContents.append("\n</table>  ");
					sbContents.append("\n</body>  ");
					
					emlSndVo.setSubject("RQST for approval of ALPS Role – "+roleModule+"(Module)");
					emlSndVo.setContent(sbContents.toString());
					emlSndVo.setSendUsrEmail(sendUsrEmail);
					
					
					List<SearchModulePicVO> picList = dbDao.selectModulePicList(roleModule);

					StringBuffer pidEml = new StringBuffer();
					if(picList != null && picList.size() > 0){
						for(int j=0; j < picList.size(); j++){
							pidEml.append((String)picList.get(j).getUsrEml());
							
							if(j+1 != picList.size()){
								pidEml.append(",");
							}
						}
					}	
					
					emlSndVo.setReceiptUsrEmail(pidEml.toString());	
					emlSndVolist.add(emlSndVo);
				}
				groupRoleModule = roleModule;
			}
			
			//Mail Send
			for(int j=0 ; j < emlSndVolist.size(); j++){
				UserRoleRqstEmlVO userRoleRqstEmlVO = emlSndVolist.get(j);
				String usrEml = userRoleRqstEmlVO.getReceiptUsrEmail();
				
				if(usrEml!= null && !usrEml.equals("")){
					String sendResult = dbDao.sendRoleRqstMail(userRoleRqstEmlVO);
					log.debug(sendResult);
				}
			}
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} catch (MailerAppException e) {
			log.error(e.getMessage(), e);
			// TODO Auto-generated catch block
			throw new EventException(new ErrorHandler(e).getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		
		return emlSndVolist;

	}
	
	
}