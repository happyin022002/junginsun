/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalBCImpl.java
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.14 변영주
* 1.0 Creation
=========================================================
* History
* 2011.05.02 이행지 [CHM-201110601-01] [PRI] S/C Contract Parties Information 중 첨부 파일 소실 되는 문제 해결
*                                    Main에서 호출되는 S/C Contract Parties Information 정보 Update에는 파일수정하는 부분이 없는 쿼리로 새로 생성하여 연결
* 2012.02.16 이석준[CHM-201216141] 미주 법인화에 따른 미주 지역의 Signatory Name 변경
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청                                    
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.integration.SCContractPartyProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.CstPriSpCtrtPtyHVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.CstPriSpCtrtPtyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.PriSpCtrtPtyInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtCustTpVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyTypeVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0022EventResponse,SCContractPartyProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */ 
public class SCContractPartyProposalBCImpl extends BasicCommandSupport implements SCContractPartyProposalBC {

	// Database Access Object
	private transient SCContractPartyProposalDBDAO dbDao = null;

	/**
	 * SCContractPartyProposalBCImpl 객체 생성<br>
	 * SCContractPartyProposalDBDAO를 생성한다.<br>
	 */
	public SCContractPartyProposalBCImpl() {
		dbDao = new SCContractPartyProposalDBDAO(); 
	}
	
	/** 
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			 
			priSpMnVO.setCreUsrId(account.getUsr_id());
			priSpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priSpMnVO);
 
			dbDao.addProposalContractPartyAmend(insertVoList);
			dbDao.addProposalContractCustomerTypeAmend(insertVoList);				
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		

	/**
	 * Contract Customer Type  List를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpCtrtCustTpVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtCustTpVO> searchProposalContractCustomerTypeList(PriSpCtrtCustTpVO priSpCtrtCustTpVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchProposalContractCustomerTypeList(priSpCtrtCustTpVO,priSpHistoryInquiryParamVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Contract Customer Type 데이터를 Accept 합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalContractCustomerType(PriSpCtrtCustTpVO priSpCtrtCustTpVO,SignOnUserAccount account)  throws EventException{
		try {
		
			List<PriSpCtrtCustTpVO> updateVoList = new ArrayList<PriSpCtrtCustTpVO>();
			
			priSpCtrtCustTpVO.setUpdUsrId(account.getUsr_id());	
			priSpCtrtCustTpVO.setAcptUsrId(account.getUsr_id());
			priSpCtrtCustTpVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpCtrtCustTpVO.setAcptDt(currentDate);
			
			updateVoList.add(priSpCtrtCustTpVO);

			dbDao.modifyProposalContractCustomerType (updateVoList);		
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	/**
	 * Contract Customer Type 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalContractCustomerType(PriSpCtrtCustTpVO priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpCtrtCustTpVO> updateVoList = new ArrayList<PriSpCtrtCustTpVO>();
			
			priSpCtrtCustTpVO.setUpdUsrId(account.getUsr_id());	
			//cancel 
			priSpCtrtCustTpVO.setAcptUsrId("C");
			priSpCtrtCustTpVO.setAcptOfcCd("C");		
			priSpCtrtCustTpVO.setAcptDt("C");

			updateVoList.add(priSpCtrtCustTpVO);

			dbDao.modifyProposalContractCustomerType (updateVoList);
		
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	/**
	 * Contract Customer Type 데이터를 저장 합니다.<br>
	 * 
	 * @param PriSpCtrtCustTpVO[] priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalContractCustomerType(PriSpCtrtCustTpVO[] priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriSpCtrtCustTpVO> updateVoList = new ArrayList<PriSpCtrtCustTpVO>();
			for ( int i=0; i<priSpCtrtCustTpVO.length; i++ ) {
				if ( priSpCtrtCustTpVO[i].getIbflag().equals("U")){
					priSpCtrtCustTpVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpCtrtCustTpVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalContractCustomerType (updateVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	
	/**
	 * Contract Parties List를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyList(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	/**
	 * Contract Party Type을 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyTypeVO> searchProposalContractPartyTypeList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyTypeList(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Contract Parties 데이터를 Accept 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalContractParty(PriSpCtrtPtyVO priSpCtrtPtyVO,SignOnUserAccount account)  throws EventException{
		try {
		
			List<PriSpCtrtPtyVO> updateVoList = new ArrayList<PriSpCtrtPtyVO>();
			
			priSpCtrtPtyVO.setUpdUsrId(account.getUsr_id());	
			priSpCtrtPtyVO.setAcptUsrId(account.getUsr_id());
			priSpCtrtPtyVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpCtrtPtyVO.setAcptDt(currentDate);
			
			updateVoList.add(priSpCtrtPtyVO);

			dbDao.modifyProposalContractParty (updateVoList);		
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	/**
	 * Contract Parties 데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalContractParty(PriSpCtrtPtyVO priSpCtrtPtyVO,SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpCtrtPtyVO> updateVoList = new ArrayList<PriSpCtrtPtyVO>();			
			priSpCtrtPtyVO.setUpdUsrId(account.getUsr_id());	
			priSpCtrtPtyVO.setAcptUsrId("");
			priSpCtrtPtyVO.setAcptOfcCd("");		
			priSpCtrtPtyVO.setAcptDt(null);
			updateVoList.add(priSpCtrtPtyVO);
			dbDao.modifyProposalContractParty (updateVoList);	
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	/**
	 * Contract Parties 데이터를 저장 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO[] priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalContractParty(PriSpCtrtPtyVO[] priSpCtrtPtyVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriSpCtrtPtyVO> updateVoList = new ArrayList<PriSpCtrtPtyVO>();
			for ( int i=0; i<priSpCtrtPtyVO.length; i++ ) {
				if ( priSpCtrtPtyVO[i].getIbflag().equals("U")){
					priSpCtrtPtyVO[i].setUpdUsrId(account.getUsr_id());
					if (priSpCtrtPtyVO[i].getPrcCtrtPtyTpCd().equals("H")){
						priSpCtrtPtyVO[i].setCustSeq("");
					}
					updateVoList.add(priSpCtrtPtyVO[i]);
				} 
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalContractParty (updateVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
		
	/**
	 * Contract Parties,Customer Type 데이터를 저장한다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpCtrtCustTpVO[] custVo = scPropMnVO.getPriSpCtrtCustTpVOs();
			PriSpCtrtPtyVO[] ptyVo = scPropMnVO.getPriSpCtrtPtyVOs();	
			PriSpMnVO[] mnVo = scPropMnVO.getPriSpMnVOs();
			
			List<PriSpCtrtCustTpVO> insertCustVoList = new ArrayList<PriSpCtrtCustTpVO>();			
			List<CstPriSpCtrtPtyVO> insertPtyVoList = new ArrayList<CstPriSpCtrtPtyVO>();			
			List<CstPriSpCtrtPtyHVO> insertPtyHanVoList = new ArrayList<CstPriSpCtrtPtyHVO>();			
			List<PriSpCtrtCustTpVO> updateCustVoList = new ArrayList<PriSpCtrtCustTpVO>();
			List<PriSpCtrtPtyVO> updatePtyVoList = new ArrayList<PriSpCtrtPtyVO>();

			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());
			for ( int i = 0; custVo != null && i < custVo.length; i++ ) {
				if ( custVo[i].getIbflag().equals("I")){
					custVo[i].setPropNo(propNo);
					custVo[i].setCreUsrId(account.getUsr_id());
					custVo[i].setUpdUsrId(account.getUsr_id());					
					insertCustVoList.add(custVo[i]);
				} else if ( custVo[i].getIbflag().equals("U")){
					custVo[i].setUpdUsrId(account.getUsr_id());
					updateCustVoList.add(custVo[i]);
				} 
			}

			for ( int i = 0; ptyVo != null && i < ptyVo.length; i++ ) {
				if ( ptyVo[i].getIbflag().equals("I")){
					ptyVo[i].setPropNo(propNo);
					ptyVo[i].setCreUsrId(account.getUsr_id());
					ptyVo[i].setUpdUsrId(account.getUsr_id());	
					
					CstPriSpCtrtPtyVO cstPtyVO = new CstPriSpCtrtPtyVO();
					CstPriSpCtrtPtyHVO ptyHVo = new CstPriSpCtrtPtyHVO();
					
					ObjectCloner.build(ptyVo[i], cstPtyVO);
					cstPtyVO.setOfcCd(mnVo[0].getPropOfcCd());					
					insertPtyVoList.add(cstPtyVO);					
					ObjectCloner.build(ptyVo[i], ptyHVo);
					//hamjin contract party
					ptyHVo.setOfcCd(mnVo[0].getPropOfcCd());
					ptyHVo.setPropSrepCd(mnVo[0].getPropSrepCd()); //Sales Rep 추가
					ptyHVo.setCntCd(account.getCnt_cd());
					insertPtyHanVoList.add(ptyHVo);
				} else if ( ptyVo[i].getIbflag().equals("U")){
					ptyVo[i].setUpdUsrId(account.getUsr_id());
					updatePtyVoList.add(ptyVo[i]);
				} 
			}

			//mn 이 신규 추가 되었을 경우
			if ( insertCustVoList.size() > 0 ) {
				dbDao.addProposalContractParty(insertPtyVoList);		
				dbDao.addProposalContractPartyHanjin(insertPtyHanVoList);	
				dbDao.addProposalContractCustomerType(insertCustVoList);
			}

			//기존 mn 에 대한 update
			if ( updateCustVoList.size() > 0 ) {
				dbDao.modifyProposalContractPartyForMain(updatePtyVoList);				
				dbDao.modifyProposalContractCustomerType(updateCustVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

    /**
     * Proposal Contract Party 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalContractParty(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setSrepCd(account.getSrep_cd());
            vo.setOfcCd(account.getOfc_cd());
            vo.setCntCd(account.getCnt_cd());
            // PRI_SP_CTRT_PTY COPY
            dbDao.addCopyProposalContractParty(vo);
            // PRI_SP_CTRT_CUST_TP COPY
            dbDao.addCopyProposalContractCustType(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalCustTp(priSpMnVO);
			dbDao.removeProposalCtrtPty(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	 
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalCustTpRequestCancel(priSpMnVO);
			dbDao.modifyProposalCtrtPtyRequestCancel(priSpMnVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Request Cancel시 Cust Type Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelCustType(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalCustTpRequestCancel(priSpMnVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
	 *Option의 Font 처리를 한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyFont(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyFont(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Contract Parties Amend History List를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyHistoryList(PriSpCtrtPtyVO priSpCtrtPtyVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyHistoryList(priSpCtrtPtyVO,priSpHistoryInquiryParamVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SC Contract Party History Option의 Font 처리를 한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyHistoryFont(PriSpCtrtPtyVO priSpCtrtPtyVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyHistoryFont(priSpCtrtPtyVO,priSpHistoryInquiryParamVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * Contract Parties Information Inquiry List를 조회한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<PriSpCtrtPtyInqVO>
	 * @exception EventException
	 */
	public List<PriSpCtrtPtyInqVO> searchProposalContractPartyInquiryList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyInquiryList(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 *Inquiry - Option의 Font 처리를 한다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyFontInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyFontInquiry(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * COPY TO PROPOSAL Contract Party<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * 
	 * @exception EventException
	 */
	public void copyToProposalCtrtPty(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException{ 
		try {
			rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
			rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
			//office
			rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
			rsltCopyToProposalVO.setCntCd(account.getCnt_cd());
			int chk = 0;
			
			//PRI_SP_CTRT_PTY
			chk = dbDao.addCopyToProposalSpCtrtPty(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			
			//PRI_SP_CTRT_CUST_TP
			chk = dbDao.addCopyToProposalSpCtrtCustTp(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}