/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EacMgtBCImpl.java
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



import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration.EacMgtDBDAO;
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
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.basic.CandidateConfirmBCImpl;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.basic.ManualRegisterBCImpl;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Eac Business Logic Command Interface<br>
 * - ALPS-Eac에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author BAEK HYOUNG IN
 * @see  EventResponse,EacMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class EacMgtBCImpl extends BasicCommandSupport implements EacMgtBC {

	// Database Access Object
	private transient EacMgtDBDAO dbDao = null;

	/**
	 * EacMgtBCImpl 객체 생성<br>
	 * EacMgtDBDAO를 생성한다.<br>
	 */
	public EacMgtBCImpl() {
		dbDao = new EacMgtDBDAO();
	}

	/**
	 * 공통 테이블에 담긴 값을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchCommonCombo(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchCommonCombo(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 *  EAC Type 명을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchBilTpCd(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchBilTpCd(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * 로그한 유저의 ofc 레벨을 조회한다. <br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchOfcLvl(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchOfcLvl(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * 로그한 유저의 ofc 레벨과 초기필요값을 조회한다.. <br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchOfcLvlPls(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchOfcLvlPls(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * S/P Code 의 명칭을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchVendor(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchVendor(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Responsible Office 에 값이 존재하는지 체크 한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> chkResponsibleOffice(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.chkResponsibleOffice(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Location 에 값이 존재하는지 체크 한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> validLoc(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.validLoc(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Yeard Code 에 값이 존재하는지 체크 한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> validYard(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.validYard(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Currency 콤보데이터를 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchCurrency(EacSearchVO eacSearchVO) throws EventException {
		try {
			if(eacSearchVO.getOffceLvl().equals("H")||eacSearchVO.getOffceLvl().equals("R") || eacSearchVO.getEacSysIfCd().length() > 1  ){
				return dbDao.searchCurrencyH(eacSearchVO);
			}else{
				return dbDao.searchCurrency(eacSearchVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Currency 콤보데이터를 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchCurrency2(EacSearchVO eacSearchVO) throws EventException {
		try {
				return dbDao.searchCurrencyH(eacSearchVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Exchange Rate를 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchUsdXch(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchUsdXch(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EAC Registration 를 저장한다.<br>
	 * 
	 * @param EACTpbDtlVO[] eacTpbDtlVOs
	 * @param EACRgstVO eacRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiEacReg(EACTpbDtlVO[] eacTpbDtlVOs,EACRgstVO eacRegistrationVO,SignOnUserAccount account) throws EventException {
		String eacNo = "";
		String usrId = account.getUsr_id();
		try {
			if(!eacRegistrationVO.getEacNo().equals("")){
				eacNo = eacRegistrationVO.getEacNo();
				eacRegistrationVO.setAudrUsrId(usrId);

				dbDao.updateEacReg(eacRegistrationVO); // eas_expn_aud_cs_mgmt 수정
				dbDao.updateN3rdPtyEacReg(eacRegistrationVO); // eas_expn_aud_cs_n3rd_pty 수정

				if(null != eacTpbDtlVOs){
					for(int i=0;i<eacTpbDtlVOs.length;i++){
						eacTpbDtlVOs[i].setAudrUsrId(usrId);				 
						if(eacTpbDtlVOs[i].getIbflag().equals("I")){
							eacTpbDtlVOs[i].setEacNo(eacNo);
							dbDao.multiN3rdPtyDtlEacReg(eacTpbDtlVOs[i]);  // eas_expn_aud_n3rd_pty_dtl 에저장
						}else if(eacTpbDtlVOs[i].getIbflag().equals("U")){
							dbDao.updateN3rdPtyDtlEacReg(eacTpbDtlVOs[i]);  // eas_expn_aud_n3rd_pty_dtl 수정
						}else if(eacTpbDtlVOs[i].getIbflag().equals("D")){
							dbDao.delN3rdPtyDtlEacReg(eacTpbDtlVOs[i]);  // eas_expn_aud_n3rd_pty_dtl 삭제
						}
					}
				}
			}else{
				eacNo = dbDao.makeEasExpnAudMgmtKey(account);
				eacRegistrationVO.setAudrUsrId(usrId);
				eacRegistrationVO.setEacNo(eacNo);
				dbDao.multiEacReg(eacRegistrationVO); // eas_expn_aud_cs_mgmt 에저장
				dbDao.multiN3rdPtyEacReg(eacRegistrationVO); // eas_expn_aud_cs_n3rd_pty 에저장

				if(null != eacTpbDtlVOs){
					for(int i=0;i<eacTpbDtlVOs.length;i++){
						eacTpbDtlVOs[i].setAudrUsrId(usrId);				 
						eacTpbDtlVOs[i].setEacNo(eacNo);

						if(eacTpbDtlVOs[i].getIbflag().equals("I")){
							dbDao.multiN3rdPtyDtlEacReg(eacTpbDtlVOs[i]);  // eas_expn_aud_n3rd_pty_dtl 에저장
						}
					}
				}

				if(eacRegistrationVO.getEacSysIfCd().equals("PSO")){
					dbDao.multiEacPSO(eacRegistrationVO);
				}else if(eacRegistrationVO.getEacSysIfCd().equals("TR1") || eacRegistrationVO.getEacSysIfCd().equals("TR2") || eacRegistrationVO.getEacSysIfCd().equals("TR3")){
					dbDao.multiEacTRS(eacRegistrationVO);
				}else if(eacRegistrationVO.getEacSysIfCd().equals("TR4")){
					dbDao.multiEacDropOff(eacRegistrationVO);
				}else if(eacRegistrationVO.getEacSysIfCd().equals("TE2")){
					dbDao.multiEacRhndChg(eacRegistrationVO);
				}else if(eacRegistrationVO.getEacSysIfCd().equals("TE1")){ // BKG COD
					dbDao.multiEacBkgCod(eacRegistrationVO);
				}else if(eacRegistrationVO.getEacSysIfCd().equals("MR1")){ // H/Bar Inquiry by BKG
					dbDao.multiEacBkgCntrScg(eacRegistrationVO);
				}else if(eacRegistrationVO.getEacSysIfCd().equals("TRS")){ // TRS Auto Audit
					dbDao.multiEacTRSAutoAudit(eacRegistrationVO);
				}else if(eacRegistrationVO.getEacSysIfCd().equals("MNR")){ // MNR Auto Audit
					dbDao.multiEacMNRAutoAudit(eacRegistrationVO);
				}else if(eacRegistrationVO.getEacSysIfCd().equals("TES")){ // TES Auto Audit
					dbDao.multiEacTESAutoAudit(eacRegistrationVO);
				}
			}
			return eacNo;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * TPB 테이블에 자료를 등록한다.<br>
	 * 
	 * @param EacSearchVO eacSearchVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEacTpbIf(EacSearchVO eacSearchVO,SignOnUserAccount account) throws EventException {
		try {
			DBRowSet dbRowset2 = null;
			DBRowSet dbRowset = dbDao.searchTpbIfInfo(eacSearchVO);
			dbRowset2=dbRowset.createCopy();
			List<CreateTPBCandidateVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CreateTPBCandidateVO .class);
			List<SearchCandidateListVO> list2 = (List)RowSetUtil.rowSetToVOs(dbRowset2, SearchCandidateListVO .class);
			
			
			ManualRegisterBCImpl manualRegisterBCImpl = new ManualRegisterBCImpl();
			CandidateConfirmBCImpl candidateConfirmBCImpl = new  CandidateConfirmBCImpl();
			
			CreateTPBCandidateVO createTPBCandidateVO = new CreateTPBCandidateVO();
			CreateTPBCandidateVO[] createTPBCandidateVOs = new CreateTPBCandidateVO[list.size()];
			
			SearchCandidateListVO searchCandidateListVO = new SearchCandidateListVO();
			SearchCandidateListVO[] searchCandidateListVOs = new SearchCandidateListVO[list2.size()];;
			
			for(int i=0; i<list.size(); i++){
				createTPBCandidateVO = list.get(i);
				createTPBCandidateVO.setIbflag("I");
				createTPBCandidateVOs[i] = createTPBCandidateVO;
			}
			manualRegisterBCImpl.createTPBCandidate(createTPBCandidateVOs,account);
			
			for(int k=0; k<list2.size(); k++){
				searchCandidateListVO = list2.get(k);
				searchCandidateListVO.setIbflag("U");
				searchCandidateListVOs[k] = searchCandidateListVO;
			}
			List<SearchCandidateListVO> sclvoList = candidateConfirmBCImpl.multiCandidateConfirm(searchCandidateListVOs,account);
			String n3pty_no = "";
			if(sclvoList!=null){
				n3pty_no = ((SearchCandidateListVO)sclvoList.get(0)).getN3ptyNo(); 
			}
			
			dbDao.updateN3rdPty(n3pty_no,eacSearchVO.getEacNo(),account.getUsr_id());
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	
	
	/**
	 * RHQ OFFCE 콤보값을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchRhqList(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchRhqList(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * OFFCE 콤보값을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchOfcList(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchOfcList(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EAC Registration 을 조회한다.<br>
	 * 
	 * @param EACRgstVO eacRegistrationVO
	 * @return List<EACRgstVO>
	 * @exception EventException
	 */
	public List<EACRgstVO> searchEacReg(EACRgstVO eacRegistrationVO) throws EventException {
		try {
			List<EACRgstVO> list = dbDao.searchEacReg(eacRegistrationVO);
			List<EACRgstVO> list2 = null;
			String  n3ptyno = ((EACRgstVO)list.get(0)).getN3ptyNo();
			if(null!=n3ptyno && !n3ptyno.equals("")){
				list2 = dbDao.searchTPB(n3ptyno);
				
				if(list2!=null){
					((EACRgstVO)list.get(0)).setTpbOfcCd(((EACRgstVO)list2.get(0)).getTpbOfcCd());
					((EACRgstVO)list.get(0)).setOtsStsNm(((EACRgstVO)list2.get(0)).getOtsStsNm());
					((EACRgstVO)list.get(0)).setTpbInvAmt(((EACRgstVO)list2.get(0)).getTpbInvAmt());
				}
			}
			return list;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * EAC Tpb DTL Grid 를 조회한다.<br>
	 * 
	 * @param EACRgstVO eacRegistrationVO
	 * @return List<EACTpbDtlVO>
	 * @exception EventException
	 */
	public List<EACTpbDtlVO> searchTrpDtlGrid(EACRgstVO eacRegistrationVO) throws EventException {
		try {
			return dbDao.searchTrpDtlGrid(eacRegistrationVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EAC Registration 을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchCntcPnt(EacSearchVO eacSearchVO)  throws EventException {
		try {
			return dbDao.searchCntcPnt(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Rejection Notice Tab 을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @param String usrid
	 * @return List<EACRgstVO>
	 * @exception EventException
	 */
	public List<EACRgstVO> searchEacRjctNtc(EacSearchVO eacSearchVO,String usrid) throws EventException {
		try {
			return dbDao.searchEacRjctNtc(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Expense Audit case Registration 저장전 중복된 데이터 인지 확인한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> verifyEacReg(EacSearchVO EacSearchVO) throws EventException {
		try {
			return dbDao.verifyEacReg(EacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Booking No 가 존재하는지 확인한다. <br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> verifyBkgNO(EacSearchVO EacSearchVO) throws EventException {
		try {
			return dbDao.verifyBkgNO(EacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * I/F 전에 중복 여부를 체크한다. <br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> verifyTpbIf(EacSearchVO EacSearchVO) throws EventException {
		try {
			return dbDao.verifyTpbIf(EacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Responsible Office 가 TPB 에 등록된 office 인지 확인한다. <br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> verifyTpbOfc(EacSearchVO EacSearchVO) throws EventException {
		try {
			return dbDao.verifyTpbOfc(EacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Personnel Config, Office Config 가 등록되어 있는지 확인하고 발송자 메일 정보를 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @param SignOnUserAccount account
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchPsonCfg(EacSearchVO EacSearchVO,SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchPsonCfg(EacSearchVO,account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * 입력한 3rdParty Value 값이 유효한지 체크한다. <br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> verify3rdVale(EacSearchVO EacSearchVO) throws EventException { 
		try {
			return dbDao.verify3rdVale(EacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * S/P Contact point 의  MDM S/P Information 을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EACSpContactPointVO>
	 * @exception EventException
	 */
	public List<EACSpCtrtVO> searchVndrList(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchVndrList(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * S/P Code 가 선택되면  등록된 Contact point 을 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EACSpContactPointVO>
	 * @exception EventException
	 */
	public List<EACSpCtrtVO> searchVndrCntc(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchVndrCntc(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * SP Contact point 를 저장한다.<br>
	 * 
	 * @param EACSpCtrtVO[] eacpContactPointVOs
	 * @param String usrid
	 * @exception EventException
	 */
	public void multiVndrCntc(EACSpCtrtVO[] eacpContactPointVOs, String usrid) throws EventException {
		try {
			EACSpCtrtVO eacSpVO = new EACSpCtrtVO();
			for ( int i=0; i<eacpContactPointVOs.length; i++ ) {
				eacSpVO = eacpContactPointVOs[i];
				eacSpVO.setCreUsrId(usrid);
				eacSpVO.setUpdUsrId(usrid);
				if(eacSpVO.getIbflag().equals("I")){
					dbDao.multiVndrCntc(eacSpVO);
				}else if(eacSpVO.getIbflag().equals("U")){
					dbDao.updateVndrCntc(eacSpVO);
				}else if(eacSpVO.getIbflag().equals("D")){
					eacSpVO.setDeltFlg("Y");
					dbDao.updateVndrCntc(eacSpVO);
				}
				
//				addList.add(eacpContactPointVOs[i]);
		    }			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Office Config 를 저장한다.<br>
	 * 
	 * @param EACOfcCfgVO eacOfficeConfigVO
	 * @param String usrid
	 * @exception EventException
	 */
	public void multiEacOfc(EACOfcCfgVO eacOfficeConfigVO, String usrid) throws EventException {
		try {
			String cntFlag = dbDao.searchEacOfcSubsist(eacOfficeConfigVO);
			eacOfficeConfigVO.setCreUsrId(usrid);
			eacOfficeConfigVO.setUpdUsrId(usrid);
            if(Integer.parseInt(cntFlag) > 0){
            	// Update
            	dbDao.updateEacOfc(eacOfficeConfigVO);
            	
            }else{ 
            	// Insert
            	dbDao.multiEacOfc(eacOfficeConfigVO);
            }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Office Config 를 조회한다.<br>
	 * @return List<EACOfficeConfigVO>
	 * @param EACOfcCfgVO eacOfficeConfigVO
	 * @exception EventException
	 */
	public List<EACOfcCfgVO> searchEacOfc(EACOfcCfgVO eacOfficeConfigVO) throws EventException {
		try {
				// 조회
		   return dbDao.searchEacOfc(eacOfficeConfigVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Personnel Config 를 저장한다.<br>
	 * 
	 * @param EACPsonCfgVO eacPersonnelConfigVO
	 * @param String usrid
	 * @exception EventException
	 */
	public void multiEacPsn(EACPsonCfgVO eacPersonnelConfigVO, String usrid) throws EventException {
		try {
			String cntFlag = dbDao.searchEacPsnSubsist(eacPersonnelConfigVO);
			eacPersonnelConfigVO.setCreUsrId(usrid);
			eacPersonnelConfigVO.setUpdUsrId(usrid);
			if(Integer.parseInt(cntFlag) > 0){
				// Update
				dbDao.updateEacPsn(eacPersonnelConfigVO);
				
			}else{ 
				// Insert
				dbDao.multiEacPsn(eacPersonnelConfigVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Personnel Config 를 삭제한다.<br>
	 * 
	 * @param EACPsonCfgVO eacPersonnelConfigVO
	 * @param String usrid
	 * @exception EventException
	 */
	public void deleteEacPsn(EACPsonCfgVO eacPersonnelConfigVO, String usrid) throws EventException {
		try {
			String cntFlag = dbDao.searchEacPsnSubsist(eacPersonnelConfigVO);
			eacPersonnelConfigVO.setUpdUsrId(usrid);
			if(Integer.parseInt(cntFlag) > 0){
				// Update
				dbDao.deleteEacPsn(eacPersonnelConfigVO);
				
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Personnel Config 를 조회한다.<br>
	 * @param EACPsonCfgVO eacPersonnelConfigVO
	 * @return List<EACPersonnelConfigVO>
	 * @exception EventException
	 */
	public List<EACPsonCfgVO> searchEacPsn(EACPsonCfgVO eacPersonnelConfigVO) throws EventException {
		try {
			// 조회
			return dbDao.searchEacPsn(eacPersonnelConfigVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Personnel Config Inquiry 를 삭제한다.<br>
	 * 
	 * @param EACPsonCfgVO[] eacPersonnelConfigVOs
	 * @param String usrid
	 * @exception EventException
	 */
	public void deleteEacPsnList(EACPsonCfgVO[] eacPersonnelConfigVOs, String usrid) throws EventException {
		try {
			
			for(int i=0;i<eacPersonnelConfigVOs.length;i++){
				// Update
				eacPersonnelConfigVOs[i].setUpdUsrId(usrid);
				dbDao.deleteEacPsnList(eacPersonnelConfigVOs[i]);
				
			}
				
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Personnel Config Inquiry 를 조회한다.<br>
	 * @param EACPsonCfgVO eacPersonnelConfigVO
	 * @return List<EACPersonnelConfigVO>
	 * @exception EventException
	 */
	public List<EACPsonCfgVO> searchEacPsnList(EACPsonCfgVO eacPersonnelConfigVO) throws EventException {
		try {
			// 조회
			return dbDao.searchEacPsnList(eacPersonnelConfigVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * EAC 등록 자료를 리스트로 조회한다.<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACEditVO>
	 * @exception EventException
	 */
	public List<EACEditVO> searchEacEditList(EacSearchVO eacSearchVO) throws EventException {
		try {
			// 조회
			return dbDao.searchEacEditList(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Auditor 리스트를 조회한다.<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACEditVO>
	 * @exception EventException
	 */
	public List<EACEditVO> searchEacAuditorList(EacSearchVO eacSearchVO) throws EventException {
		try {
			// 조회
			return dbDao.searchEacAuditorList(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * EAC 등록 자료를 리스트로 조회한다(Confirm)<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACCfmVO>
	 * @exception EventException
	 */
	public List<EACCfmVO> searchEacCfmList(EacSearchVO eacSearchVO) throws EventException {
		try {
			// 조회
			return dbDao.searchEacCfmList(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * EAC 등록 자료를 리스트로 조회한다(Inquiry)<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACCdVO>
	 * @exception EventException
	 */
	public List<EACCdVO> searchEacCode(EacSearchVO eacSearchVO) throws EventException {
		try {
			// 조회
			return dbDao.searchEacCode(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 등록된 EAC 자료를 상태를 변경한다.<br>
	 * 상태 테이블에 이력을 등록한다. <br>
	 * 
	 * @param EacSearchVO[] eacSearchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyEacSts(EacSearchVO[] eacSearchVOs,SignOnUserAccount account) throws EventException {
		try {
		    boolean bEacSts = false;
			for(int i=0;i<eacSearchVOs.length;i++){
				bEacSts = dbDao.searchVerifyEacSts(eacSearchVOs[i]);
				if (bEacSts == true) {
					throw new EventException(new ErrorHandler("TRS00099", new String[]{"Already been confirmed/rejected.\nPlease proceed after retrieve again"}).getMessage());
				}
			}
			
			for(int i=0;i<eacSearchVOs.length;i++){
				eacSearchVOs[i].setOfcCd(account.getOfc_cd());
				eacSearchVOs[i].setUsrId(account.getUsr_id());
				dbDao.modifyEacSts(eacSearchVOs[i]);
				dbDao.addAproHis(eacSearchVOs[i]);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Expense Audit case 조회<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EACInqVO>
	 * @exception EventException
	 */
	public List<EACInqVO> searchEacReadList(EacSearchVO eacSearchVO) throws EventException {
		try {
			// 조회
			return dbDao.searchEacReadList(eacSearchVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * EAC Rejection Notice 메일 발송<br>
	 * @param EACNtcVO eacNtcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void saveEacNotice(EACNtcVO eacNtcVO,SignOnUserAccount account) throws EventException {
		try {
			eacNtcVO.setCreUsrId(account.getUsr_id());
			eacNtcVO.setUpdUsrId(account.getUsr_id());
			eacNtcVO.setEacOfcCd(account.getOfc_cd());
			dbDao.sendMail(eacNtcVO);
			dbDao.updateNoticeCnt(eacNtcVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * EAC 첨부 파일 내역 조회<br>
	 * @param EacFileInVO eacFileInVO
	 * @return List<EacFileOutVO>
	 * @exception EventException
	 */
	public List<EacFileOutVO> searchEacFile(EacFileInVO eacFileInVO) throws EventException {
		try {
			// 조회
			return dbDao.searchEacFile(eacFileInVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESD_EAS_0213 멀티 이벤트 처리<br>
	 * ESD_EAS_0213 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * //1.UPDATE 상태를 확인한다. <br>
	 * //1-1 delete List 추가 <br>
	 * //1-1-1 UpdateFileMetaInfo file_meta 정보 삭제 (FILE_SAVE_ID)<br>
	 * //1-2 insert List 추가 <br>
	 * //2. DELETE 상태를 확인 <br>
	 * //2-1 delete List 추가 <br>
	 * //2-1-1 UpdateFileMetaInfo file_meta 정보 삭제 (FILE_SAVE_ID)<br>
	 * //3. INSERT 상태를 확인 <br>
	 * //3-1 insert List 추가 <br>
	 * //4. 삭제먼저 수행하고 추가를 수행한다. <br>
	 * //5. 맨마지막에 일괄 com_upload 테이블과 동기화 쿼리 <br>
	 *
	 * @author Lee Jin Seo
	 * @param EacFileInVO eacFileIn
	 * @exception EventException
	 */
	public void manageEacFile(EacFileInVO eacFileIn) throws EventException {
		log.debug("[START:: SpecialCargoRiderBCImpl == manageBlRider  ]==========");
		EacFileOutVO[] eacFileOutVO = eacFileIn.getEacFileOutVOs(); // blRiderIn.getBkgImgStoVOs();
		SignOnUserAccount account = eacFileIn.getAccount();
		String use_id = account.getUsr_id();// user id
		String ofc_cd = account.getOfc_cd();// user office code
		String[] fileSavId = eacFileIn.getKeys();
		try {
			List<EacFileOutVO> insertVoList = new ArrayList<EacFileOutVO>();
			List<EacFileOutVO> deleteVoList = new ArrayList<EacFileOutVO>();
			int save_id_cnt = 0;
			for (int i = 0; i < eacFileOutVO.length; i++) {
				if (eacFileOutVO[i].getIbflag().equals("D")) {
					log.debug("[START:: EacMgtBCImpl deleteVoList =====" + eacFileOutVO[i].getFileSavId());
					deleteVoList.add(eacFileOutVO[i]);
					UpdateFileMetaInfo.delete(eacFileOutVO[i].getFileSavId());

				} else if (eacFileOutVO[i].getIbflag().equals("I")) {
					log.debug("[START:: EacMgtBCImpl insertVoList =====" + eacFileOutVO[i].getFileSavId());

					if (eacFileOutVO[i].getFileSavId() == null || eacFileOutVO[i].getFileSavId().length() == 0) {
						eacFileOutVO[i].setFileSavId(fileSavId[save_id_cnt++]);
					}
					eacFileOutVO[i].setCreUsrId(use_id);
					eacFileOutVO[i].setRgstOfcCd(ofc_cd);
					eacFileOutVO[i].setUpdUsrId(use_id);
					insertVoList.add(eacFileOutVO[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeEacFile(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addEacFile(insertVoList);
			}

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
	}	
	
	/**
	 * EAC Rejection Notice History 시퀀스 조회<br>
	 * @param EacSearchVO eacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchRjctNtcHis(EacSearchVO eacSearchVO) throws EventException {
		try {
			// 조회
			return dbDao.searchRjctNtcHis(eacSearchVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * EAC Rejection Notice History 시퀀스 조회<br>
	 * @param EACNtcHisVO eacNtcHisVO
	 * @return List<EACNtcHisVO>
	 * @exception EventException
	 */
	public List<EACNtcHisVO> searchRjctNtcSendHis(EACNtcHisVO eacNtcHisVO) throws EventException {
		try {
			// 조회
			return dbDao.searchRjctNtcSendHis(eacNtcHisVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 *  메일 발송 정보를 조회한다.<br>
	 * 
	 * @param EACNtcVO eacNtcVO
	 * @param SignOnUserAccount account
	 * @return List<EACNtcVO>
	 * @exception EventException
	 */
	public List<EACNtcVO> searchEacNotice(EACNtcVO eacNtcVO,SignOnUserAccount account) throws EventException {
		try {
			eacNtcVO.setCreUsrId(account.getUsr_id());
			return dbDao.searchEacNotice(eacNtcVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 *  메일 발송 정보를 조회한다.<br>
	 * 
	 * @param EACInqEacVO eacInqEacVO
	 * @return List<EACInqEacVO>
	 * @exception EventException
	 */
	public List<EACInqEacVO>  searchTpbIfDetail(EACInqEacVO eacInqEacVO) throws EventException {
		try {
			return dbDao.searchTpbIfDetail(eacInqEacVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Personnel Config의 KPI Office를 Update한다.<br>
	 * 
	 * @param EACPsonCfgVO[] eacPersonnelConfigVOs
	 * @param String usrid
	 * @exception EventException
	 */
	public void multiEacPsnList(EACPsonCfgVO[] eacPersonnelConfigVOs, String usrid) throws EventException {
		try {
			
			for(int i=0;i<eacPersonnelConfigVOs.length;i++){
				// Update
				eacPersonnelConfigVOs[i].setUpdUsrId(usrid);
				dbDao.multiEacPsnList(eacPersonnelConfigVOs[i]);
				
			}
				
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * @param AutoAuditFileVO[] autoAuditFileVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageAutoAuditFile(AutoAuditFileVO[] autoAuditFileVOs, SignOnUserAccount account) throws EventException {
		String use_id = account.getUsr_id();// user id
		String ofc_cd = account.getOfc_cd();// user office code
		String fileSavId = "";
		String atchFileLnkId = "";
		try {
			for (int i = 0; i < autoAuditFileVOs.length; i++) {
				fileSavId = autoAuditFileVOs[i].getFileSavId();
				autoAuditFileVOs[i].setCreUsrId(use_id);
				autoAuditFileVOs[i].setCreOfcCd(ofc_cd);
				autoAuditFileVOs[i].setUpdUsrId(use_id);
				if(autoAuditFileVOs[i].getAtchFileLnkId().equals("")) {
					atchFileLnkId = dbDao.makeAutoAuditFileNo(autoAuditFileVOs[i]);
					autoAuditFileVOs[i].setAtchFileLnkId(atchFileLnkId);
				}else{
					atchFileLnkId = autoAuditFileVOs[i].getAtchFileLnkId();
				}
				if (autoAuditFileVOs[i].getIbflag().equals("D")) {
					UpdateFileMetaInfo.delete(fileSavId);
					dbDao.removeAutoAudFile(autoAuditFileVOs[i]);
				} else if (autoAuditFileVOs[i].getIbflag().equals("I")) {
					if (autoAuditFileVOs[i].getFileSavId().equals(""))
						throw new EventException(new ErrorHandler("TRS00099", new String[]{"The file is open."}).getMessage());
					dbDao.addAutoAudFile(autoAuditFileVOs[i]);
				}
			}
			return atchFileLnkId;
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
	}
	
	/**
	 * EAC 첨부 파일 내역 조회<br>
	 * @param AutoAuditFileVO autoAuditFileVO
	 * @return List<AutoAuditFileVO>
	 * @exception EventException
	 */
	public List<AutoAuditFileVO> searchAutoAudFile(AutoAuditFileVO autoAuditFileVO) throws EventException {
		try {
			// 조회
			return dbDao.searchAutoAudFile(autoAuditFileVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 *
	 * @author Lee Jin Seo
	 * @param AutoAuditFileVO autoAuditFileVO
	 * @return void
	 * @exception EventException
	 */
	public void removeAutoAudFileAll(AutoAuditFileVO autoAuditFileVO) throws EventException {
		List<AutoAuditFileVO> list = null;
		String fileSavId = "";
		try {
			list = dbDao.searchAutoAudFileAll(autoAuditFileVO);
			for (int i = 0; i < list.size(); i++) {
				fileSavId = list.get(i).getFileSavId();
				UpdateFileMetaInfo.delete(fileSavId);
				dbDao.removeAutoAudFile(list.get(i));
			}

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
	}
	
	/**
	 * EAC 결재 경로를 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> SearchEacStatus(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.SearchEacStatus(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * 환율정보를 조회한다.<br>
	 * 
	 * @param EacSearchVO EacSearchVO
	 * @return List<EacSearchVO>
	 * @exception EventException
	 */
	public List<EacSearchVO> searchMonthExchange(EacSearchVO eacSearchVO) throws EventException {
		try {
			return dbDao.searchMonthExchange(eacSearchVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

}