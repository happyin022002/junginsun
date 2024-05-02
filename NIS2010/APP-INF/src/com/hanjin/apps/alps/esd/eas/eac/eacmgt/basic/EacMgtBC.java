/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EacMgtBC.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic;




import java.util.List;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.AutoAuditFileVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACCdVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACCfmVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACEditVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACInqEacVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACInqVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACNtcHisVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACNtcVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACOfcCfgVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACPsonCfgVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACRgstVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACSpCtrtVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACTpbDtlVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacFileInVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacFileOutVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Eac Business Logic Command Interface<br>
 * - ALPS-Eac에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author BAEK HYOUNG IN
 * @see  EacmgtEventResponse 참조
 * @since J2EE 1.6
 */

public interface EacMgtBC {

	/**
	 * 공통 테이블에 담긴 값을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchCommonCombo(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * EAC Type 명을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchBilTpCd(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * 로그한 유저의 ofc 레벨을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchOfcLvl(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * 로그한 유저의 ofc 레벨과 초기필요값을 조회한다..<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchOfcLvlPls(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * S/P Code 의 명칭을 조회한다. <br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchVendor(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Responsible Office 에 값이 존재하는지 체크 한다. <br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> chkResponsibleOffice(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Location 에 값이 존재하는지 체크 한다. <br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> validLoc(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Yard coded 에 값이 존재하는지 체크 한다. <br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> validYard(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Currency 콤보데이터를 조회한다. <br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchCurrency(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Currency 콤보데이터를 조회한다. <br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchCurrency2(EacSearchVO eacSearchVO) throws EventException;
	
	
	/**
	 * Exchange Rate 조회한다. <br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchUsdXch(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * EAC Registration 를 저장한다. <br>
	 * 
	 * @param EACTpbDtlVO[] eacTpbDtlVOs
	 * @param EACRgstVO eacRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String eac_no
	 * @exception EventException
	 */
	public String  multiEacReg(EACTpbDtlVO[] eacTpbDtlVOs,EACRgstVO eacRegistrationVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * TPB 테이블에 자료를 등록한다. <br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void  multiEacTpbIf(EacSearchVO eacSearchVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * RHQ OFFCE 콤보값을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchRhqList(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * OFFCE 콤보값을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchOfcList(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * S/P Contact point 의  MDM S/P Information 을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACSpContactPointVO>
	 * @exception EventException
	 */
	public List<EACSpCtrtVO> searchVndrList(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * S/P Code 가 선택되면  등록된 Contact point 을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACSpContactPointVO>
	 * @exception EventException
	 */
	public List<EACSpCtrtVO> searchVndrCntc(EacSearchVO eacSearchVO) throws EventException;

	/**
	 * Contact Point 콤보값을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchCntcPnt(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Rejection Notice Tab 을 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @param String usrid
	 * @return List<EACSpContactPointVO>
	 * @exception EventException
	 */
	public List<EACRgstVO> searchEacRjctNtc(EacSearchVO eacSearchVO,String usrid) throws EventException;
	
	/**
	 * EAC Registration 을 조회한다.<br>
	 * 
	 * @param EACRgstVO eacRegistrationVO
	 * @return List<EACRegistrationVO> 
	 * @exception EventException
	 */
	public List<EACRgstVO> searchEacReg(EACRgstVO eacRegistrationVO) throws EventException;
	
	/**
	 * EAC Tpb DTL Grid 를 조회한다.<br>
	 * 
	 * @param EACRgstVO eacRegistrationVO
	 * @return List<EACTpbDtlVO> 
	 * @exception EventException
	 */
	public List<EACTpbDtlVO> searchTrpDtlGrid(EACRgstVO eacRegistrationVO) throws EventException;
	
	/**
	 * Expense Audit case Registration 저장전 중복된 데이터 인지 확인한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO> 
	 * @exception EventException
	 */
	public List<EacSearchVO> verifyEacReg(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Booking No 가 존재하는지 확인한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO> 
	 * @exception EventException
	 */
	public List<EacSearchVO> verifyBkgNO(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * I/F 전에 중복 여부를 체크한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO> 
	 * @exception EventException
	 */
	public List<EacSearchVO> verifyTpbIf(EacSearchVO eacSearchVO) throws EventException;

	/**
	 * Responsible Office 가 TPB 에 등록된 office 인지 확인한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO> 
	 * @exception EventException
	 */
	public List<EacSearchVO> verifyTpbOfc(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Personnel Config, Office Config 가 등록되어 있는지 확인하고 발송자 메일 정보를 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @param SignOnUserAccount account
	 * @return List<EacSearchVO> 
	 * @exception EventException
	 */
	public List<EacSearchVO> searchPsonCfg(EacSearchVO eacSearchVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 입력한 3rdParty Value 값이 유효한지 체크한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO> 
	 * @exception EventException
	 */
	public List<EacSearchVO> verify3rdVale(EacSearchVO eacSearchVO) throws EventException;
	
	
	/**
	 * SP Contact point 를 저장한다.<br>
	 * 
	 * @param EACSpCtrtVO[] eacSpContactPointVOs
	 * @param String usrid
	 * @exception EventException
	 */
	public void multiVndrCntc(EACSpCtrtVO[] eacSpContactPointVOs,String usrid) throws EventException;
	
	/**
	 * Office Config 를 저장한다.<br>
	 * 
	 * @param EACOfcCfgVO eacOfficeConfigVO
	 * @param String usrid
	 * @exception EventException
	 */
	public void multiEacOfc(EACOfcCfgVO eacOfficeConfigVO,String usrid) throws EventException;
	
	/**
	 * Office Config 를 조회한다.<br>
	 * @return List<EACOfcCfgVO> 
	 * @param EACOfcCfgVO eacOfficeConfigVO
	 * @exception EventException
	 */
	public List<EACOfcCfgVO> searchEacOfc(EACOfcCfgVO eacOfficeConfigVO) throws EventException;
	
	/**
	 * Personnel Config 를 저장한다.<br>
	 * 
	 * @param EACPsonCfgVO eacPersonnelConfigVO
	 * @param String usrid
	 * @exception EventException
	 */
	public void multiEacPsn(EACPsonCfgVO eacPersonnelConfigVO,String usrid) throws EventException;
	
	/**
	 * Personnel Config 를 삭제한다.<br>
	 * 
	 * @param EACPsonCfgVO eacPersonnelConfigVO
	 * @param String usrid
	 * @exception EventException
	 */
	public void deleteEacPsn(EACPsonCfgVO eacPersonnelConfigVO,String usrid) throws EventException;
	
	/**
	 * Personnel Config 를 조회한다.<br>
	 * @param EACPsonCfgVO eacPersonnelConfigVO
	 * @return List<EACPsonCfgVO> 
	 * @exception EventException
	 */
	public List<EACPsonCfgVO> searchEacPsn(EACPsonCfgVO eacPersonnelConfigVO) throws EventException;
	
	/**
	 * Personnel Config Inquiry 를 삭제한다.<br>
	 * 
	 * @param EACPsonCfgVO[] eacPersonnelConfigVOs
	 * @param String usrid
	 * @exception EventException
	 */
	public void deleteEacPsnList(EACPsonCfgVO[] eacPersonnelConfigVOs,String usrid) throws EventException;
	
	/**
	 * Personnel Config Inquiry 를 조회한다.<br>
	 * @param EACPsonCfgVO eacPersonnelConfigVO
	 * @return List<EACPsonCfgVO> 
	 * @exception EventException
	 */
	public List<EACPsonCfgVO> searchEacPsnList(EACPsonCfgVO eacPersonnelConfigVO) throws EventException;
	
	
	/**
	 * EAC 등록 자료를 리스트로 조회한다.<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACEditVO> 
	 * @exception EventException
	 */
	public List<EACEditVO> searchEacEditList(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Auditor 리스트를 조회한다.<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACEditVO> 
	 * @exception EventException
	 */
	public List<EACEditVO> searchEacAuditorList(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * EAC 등록 자료를 리스트로 조회한다(Confirm) <br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACCfmVO> 
	 * @exception EventException
	 */
	public List<EACCfmVO> searchEacCfmList(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * EAC 등록 자료를 리스트로 조회한다(Inquiry) <br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACCdVO> 
	 * @exception EventException
	 */
	public List<EACCdVO> searchEacCode(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * 등록된 EAC 자료의 상태를 변경한다. <br>
	 * @param EacSearchVO[] eacSearchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyEacSts(EacSearchVO[] eacSearchVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Expense Audit case 조회 <br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACInqVO> 
	 * @exception EventException
	 */
	public List<EACInqVO> searchEacReadList(EacSearchVO eacSearchVO) throws EventException;

	/**
	 * EAC Rejection Notice 메일 발송 <br>
	 * @param EACNtcVO eacNtcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void saveEacNotice(EACNtcVO eacNtcVO, SignOnUserAccount account) throws EventException;

	/**
	 * EAC 첨부 파일 내역 조회<br>
	 * @param EacFileInVO eacFileInVO
	 * @return List<EacFileOutVO> 
	 * @exception EventException
	 */
	public List<EacFileOutVO> searchEacFile(EacFileInVO eacFileInVO) throws EventException;
	
	/**
	 * EAC 첨부 파일 저장<br>
	 * @paramEacFileInVO eacFileInVO
	 * @exception EventException
	 */
	public void manageEacFile(EacFileInVO eacFileInVO) throws EventException;
	
	/**
	 * EAC Rejection Notice History 시퀀스 조회<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO> 
	 * @exception EventException
	 */
	public List<EacSearchVO> searchRjctNtcHis(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * Rejection Notice Send History 내역 조회<br>
	 * @param EACNtcHisVO eacNtcHisVO
	 * @return List<EACNtcHisVO> 
	 * @exception EventException
	 */
	public List<EACNtcHisVO> searchRjctNtcSendHis(EACNtcHisVO eacNtcHisVO) throws EventException;
	
	/**
	 * 메일 발송 정보를 조회한다. <br>
	 * 
	 * @param EACNtcVO eacNtcVO
	 * @param SignOnUserAccount account
	 * @return List<EACNtcVO> 
	 * @exception EventException
	 */
	public List<EACNtcVO>  searchEacNotice(EACNtcVO eacNtcVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * TPB Inquiry by EAC 내역 조회. <br>
	 * @param EACInqEacVO eacInqEacVO
	 * @return List<EACInqEacVO> 
	 * @exception EventException
	 */
	public List<EACInqEacVO>  searchTpbIfDetail(EACInqEacVO eacInqEacVO) throws EventException;
	
	/**
	 *  Personnel Config의 KPI Office를 Update한다.<br>
	 * 
	 * @param EACPsonCfgVO[] eacPersonnelConfigVOs
	 * @param String usrid
	 * @exception EventException
	 */
	public void multiEacPsnList(EACPsonCfgVO[] eacPersonnelConfigVOs,String usrid) throws EventException;
	
	
	/**
	 *  Auto Audit 첨부파일 저장/삭제<br>
	 * 
	 * @param AutoAuditFileVO[] autoAuditFileVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageAutoAuditFile(AutoAuditFileVO[] autoAuditFileVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Auto Audit 첨부 파일 내역 조회<br>
	 * @param AutoAuditFileVO autoAuditFileVO
	 * @return List<AutoAuditFileVO> 
	 * @exception EventException
	 */
	public List<AutoAuditFileVO> searchAutoAudFile(AutoAuditFileVO autoAuditFileVO) throws EventException;
	
	/**
	 *  Auto Audit 첨부파일 전체 삭제<br>
	 * 
	 * @param AutoAuditFileVO autoAuditFileVO
	 * @return void
	 * @exception EventException
	 */
	public void removeAutoAudFileAll(AutoAuditFileVO autoAuditFileVO) throws EventException;
	
	/**
	 * EAC 결재 경로를 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> SearchEacStatus(EacSearchVO eacSearchVO) throws EventException;
	
	/**
	 * 환율정보를 조회한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchMonthExchange(EacSearchVO eacSearchVO) throws EventException;
	
}