/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainBCImpl.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.08 공백진
* 1.0 Creation
=========================================================
* History
* 2011.04.08 김민아 [CHM-201110030-01] Approve 상태에서 Save 시 Request Office 와 Sales Rep 을 비교하여 수정 사항이 존재할 경우 EDI 호출하도록 수정
* 2012.09.26 원종규[CHM-201220110] 계약 변경 통보 기능 : 계약이 사용된 BKG에대해 BKG의 Rating을 진행한 유저에게  G/W 메일 발송
* 2012.11.08 원종규[CHM-201221251] 계약 변경 통보 기능 발송 메일 Header 변경: 발송 메일 제목에 적용 계약 #를 포함 
* 2013.07.08 전윤주 [CHM-201324601] RFA Request 시 Port 운임에 속한 Route (Origin, Dest) 를 체크하여 call_port_flag가 'N' 인 경우 validation 처리 
* 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
* 2013.12.20 서미진 [선처리 CSR] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
* 2014.12.10 최성환 [CHM-201432700] Retroactive RFA Minimization관련 시스템 개발요청
* 2015.01.02 최성환 [CHM-201433110] RFA Proposal & Amendment Status 조회 기능 개선
* 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
* 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.05.23.CHM-201641745_[RFA 효율화를 위한 요청 (1차)] APP 오류 발견(SHA16M0374 case) 및 Service Scope validation 미적용
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration.RFAProposalMainDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration.RFAProposalMainEAIDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstRequestCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShHistVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstShRInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.DmtScExptVerVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.InPrsMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.MasterInfoFromBasicVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriEdiRfGenInfVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpRetroVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForCalculationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForMatchBackVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaSlsLdCtrtInfoVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltAmdtHisMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltCheckMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltMQCEstimateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriCrmSlLdVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpAmdHstMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropInqListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltReturnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefByOfcVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaMainStsVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPRSCMDataVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltStatusVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.SchSaleLeadRfaVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.PriRpScpRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefUsrVO;
import com.hanjin.syscommon.common.table.PriRpAproRqstRefVO;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * NIS2010-RFAProposal Business Logic Basic Command implementation<br>
 * - NIS2010-RFAProposal에 대한 비지니스 로직을 처리한다.<br> 
 * 
 * @author Byeon Young Joo
 * @see ESM_PRI_2003EventResponse,RFAProposalMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RFAProposalMainBCImpl extends BasicCommandSupport implements RFAProposalMainBC {

	// Database Access Object
	private transient RFAProposalMainDBDAO dbDao = null;

	/**
	 * RFAProposalMainBCImpl 객체 생성<br>
	 * RFAProposalMainDBDAO를 생성한다.<br>
	 */
	public RFAProposalMainBCImpl() {
		dbDao = new RFAProposalMainDBDAO();
	}
	/**
	 *  RFA Proposal 을 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMain(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropListVO vo = new RsltPropListVO();
			vo.setRsltPropMnVOs(dbDao.searchProposalMain(priRpHdrVO, account));
			vo.setRsltPropMnScpListVOs(dbDao.searchProposalMainScpList(priRpHdrVO, account.getUsr_id()));			

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  RFA Proposal 을 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMainSpot(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropListVO vo = new RsltPropListVO();
			vo.setRsltPropMnVOs(dbDao.searchProposalMainSpot(priRpHdrVO, account));
			vo.setRsltPropMnScpListVOs(dbDao.searchProposalMainScpList(priRpHdrVO, account.getUsr_id()));			

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  Master RFA Proposal 을 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMainMst(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropListVO vo = new RsltPropListVO();
			vo.setRsltPropMnMstVOs(dbDao.searchProposalMainMst(priRpHdrVO, account));
			vo.setRsltPropMnScpListVOs(dbDao.searchProposalMainScpList(priRpHdrVO, account.getUsr_id()));

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  Customer 정보를 조회합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO> 
	 * @exception EventException
	 */
	public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalCustomerInfo(priSpCtrtPtyVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
	 * RFA Main을 저장합니다.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageProposal(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{
		String newPropNo = "";
		try {			
			PriRpHdrVO[] hdrVo = rfaPropMnVO.getPriRpHdrVOs();
			PriRpMnVO[] vo = rfaPropMnVO.getPriRpMnVOs();
			PriRpScpMnVO[] scpVo = rfaPropMnVO.getPriRpScpMnVOs();
			
			PriRpProgVO[] progVo = rfaPropMnVO.getPriRpProgVOs();
			PriRpAmdtSmryVO[] smryVo = rfaPropMnVO.getPriRpAmdtSmryVOs();			
			PriRpScpProgVO[] scpProgVo = rfaPropMnVO.getPriRpScpProgVOs();
			PriRpScpAmdtSmryVO[] scpSmryVo = rfaPropMnVO.getPriRpScpAmdtSmryVOs();
			
			List<PriRpHdrVO> insertHdrVoList = new ArrayList<PriRpHdrVO>();
			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			List<PriRpScpMnVO> insertScpVoList = new ArrayList<PriRpScpMnVO>();
			
			List<PriRpProgVO> insertProgVoList = new ArrayList<PriRpProgVO>();
			List<PriRpAmdtSmryVO> insertSmryVoList = new ArrayList<PriRpAmdtSmryVO>();			
			List<PriRpScpProgVO> insertScpProgVoList = new ArrayList<PriRpScpProgVO>();
			List<PriRpScpAmdtSmryVO> insertScpSmryVoList = new ArrayList<PriRpScpAmdtSmryVO>();

			List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpScpMnVO> updateScpVoList = new ArrayList<PriRpScpMnVO>();
		
			newPropNo = dbDao.searchCreationProposalNo(vo[0].getPropOfcCd());

			for ( int i = 0; hdrVo != null && i < hdrVo.length; i++ ) {
			    if (JSPUtil.getNull(hdrVo[i].getPrcPropCreTpCd()).equals("")) {
			        hdrVo[i].setPrcPropCreTpCd("G");
			    }
			    
				if ( hdrVo[i].getIbflag().equals("I")){
					hdrVo[i].setPropNo(newPropNo);
					hdrVo[i].setCreUsrId(account.getUsr_id());
					hdrVo[i].setUpdUsrId(account.getUsr_id());					
					insertHdrVoList.add(hdrVo[i]);
				} else if ( hdrVo[i].getIbflag().equals("U")){
					hdrVo[i].setUpdUsrId(account.getUsr_id());
					updateHdrVoList.add(hdrVo[i]);
				}
			}			
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setPropNo(newPropNo);	
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());	

					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());				
					updateVoList.add(vo[i]);
				} 
			}
			
			
			for ( int i = 0; progVo != null && i < progVo.length; i++ ) {
				if ( progVo[i].getIbflag().equals("I")){
					progVo[i].setPropNo(newPropNo);	
					progVo[i].setCreUsrId(account.getUsr_id());
					progVo[i].setUpdUsrId(account.getUsr_id());		
					progVo[i].setProgOfcCd(account.getOfc_cd());
					progVo[i].setProgUsrId(account.getUsr_id());								
					insertProgVoList.add(progVo[i]);
				}
			}
			
			for ( int i = 0; smryVo != null && i < smryVo.length; i++ ) {
				if ( smryVo[i].getIbflag().equals("I")){
					smryVo[i].setPropNo(newPropNo);	
					smryVo[i].setCreUsrId(account.getUsr_id());
					smryVo[i].setUpdUsrId(account.getUsr_id());					
					insertSmryVoList.add(smryVo[i]);
				}
			}			

			for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
				if ( scpVo[i].getIbflag().equals("I")){
					if(scpVo[i].getPropNo().equals("")){
						scpVo[i].setPropNo(newPropNo);
						scpVo[i].setAmdtSeq("0");
					}
					scpVo[i].setCreUsrId(account.getUsr_id());
					scpVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpVoList.add(scpVo[i]);
				} else if ( scpVo[i].getIbflag().equals("U")){
					scpVo[i].setUpdUsrId(account.getUsr_id());
					updateScpVoList.add(scpVo[i]);
				}
			}

			for ( int i = 0; scpProgVo != null && i < scpProgVo.length; i++ ) {
				if ( scpProgVo[i].getIbflag().equals("I")){
					if(scpProgVo[i].getPropNo().equals("")){
						scpProgVo[i].setPropNo(newPropNo);
						scpProgVo[i].setAmdtSeq("0");
					}					
					scpProgVo[i].setCreUsrId(account.getUsr_id());
					scpProgVo[i].setUpdUsrId(account.getUsr_id());
					scpProgVo[i].setProgOfcCd(account.getOfc_cd());
					scpProgVo[i].setProgUsrId(account.getUsr_id());					
					insertScpProgVoList.add(scpProgVo[i]);
				}
			}
			
			for ( int i = 0; scpSmryVo != null && i < scpSmryVo.length; i++ ) {
				if ( scpSmryVo[i].getIbflag().equals("I")){
					if(scpSmryVo[i].getPropNo().equals("")){
						scpSmryVo[i].setPropNo(newPropNo);
						scpSmryVo[i].setAmdtSeq("0");
					}						
					scpSmryVo[i].setCreUsrId(account.getUsr_id());
					scpSmryVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpSmryVoList.add(scpSmryVo[i]);
				}
			}			
			
			//mn 이 신규 추가 되었을 경우
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalHeader(insertHdrVoList);
				dbDao.addProposalMain(insertVoList);
				dbDao.addProposalProgress(insertProgVoList);
				dbDao.addProposalAmendmentSummary(insertSmryVoList);
			}
			
			if ( updateHdrVoList.size() > 0 ) {
				dbDao.modifyProposalHeader(updateHdrVoList);
			}			

			//기존 mn 에 대한 update
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}		
			
			// scp mn 이 신규 추가되었을 경우
			if ( insertScpVoList.size() > 0 ) {
				dbDao.addProposalScopeMain(insertScpVoList);
				dbDao.addProposalScopeProgress(insertScpProgVoList);
				dbDao.addProposalScopeAmendmentSummary(insertScpSmryVoList);
			}
			
			// 기존 scp mn 이 update
			if ( updateScpVoList.size() > 0 ) {
				dbDao.modifyProposalScopeMain(updateScpVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
		return newPropNo;
	}		
	
	/**
	 * RFA Proposal Master Creation의 상태를 변경합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void counterofferProposal(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		try {			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();			
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();	
			
			if (vo != null){
				for ( int i = 0; i< vo.length ; i++ ) {
					if ( vo[i].getIbflag().equals("U")){
						vo[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vo[i]);
					} 
				}
			}
			for ( int i = 0; i < pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalProgress(insertVoList);	
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
     * Request, Request Cancel시 Accept 상태를 수정합니다.<br>
	 * @param PriRpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(PriRpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("Y");
			updateVoList.add(vo);
			
			dbDao.modifyProposalAutoAcceptAmendmentSummary(updateVoList);
			
			// pri_sp_scp_amdt_smry update 함
			// pri_sp_scp_mn 의 status update 함
			// pri_sp_scp_prog 에 insert ( mn 에 대해서  status 가 변경되었을 경우만 ) 
			//
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * S/C Proposal Request시 자동 Accept되는 항목에대한 Summary정보를 수정 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeAutoAcceptAmendmentSummary(PriRpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpScpAmdtSmryVO> updateVoList = new ArrayList<PriRpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("Y");
			updateVoList.add(vo);			
			dbDao.modifyProposalScopeAutoAcceptAmendmentSummary(updateVoList);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeAmdtSmry(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeAmdtSmry(priRpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Scope이 삭제될 때 해당 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeProgress(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeProgress(priRpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * Terms의 Summary 정보를 조회 합니다.<br>
	 * 확인 후 삭제
	 * @param PriRpAmdtSmryVO priRpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalAmendmentSummary(priRpAmdtSmryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
     * Scope Terms의 Summary 정보를 조회 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAmendmentSummary(priRpScpAmdtSmryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}  	
	
	/**
     * Main의 상태를 Approve로 변경하기 위하여 Terms가 ACCEPT 되었는지 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception EventException
	 */
	public List<PriRpMnVO> searchProposalAcceptCheck(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalAcceptCheck(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   	
	
	/**
     * C/offer를 실행 하기 위하여 Terms에 Init인 데이터가 있는지 조회합니다. <br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltStatusVO>
	 * @exception EventException
	 */
	public List<RsltStatusVO> searchCountOfferStatus(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchCountOfferStatus(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Reqeust 시 필수 입력 데이터를 조회합니다<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception EventException
	 */
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchRequestTermsCheck(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	


	/**
     * Reqeust 시 Calcualte를 하지 않은 scope를 조회 합니다<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws EventException {
		try {
			return dbDao.searchRequestCheckCalculate(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Request 시 Match Back 조회 하지 않은 Scope를 조회합니다<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForMatchBackVO>
	 * @exception EventException
	 */
	public List<RequestCheckForMatchBackVO> searchRequestCheckMatchBack(PriRpScpMnVO priRpScpMnVO) throws EventException {
		try {
			return dbDao.searchRequestCheckMatchBack(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}


	/**
     * M/B 활성화 여부를 위해 calcutae 하지 않는 scope를 가져옵니다.<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchMatchBackCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws EventException {
		try {
			return dbDao.searchMatchBackCheckCalculate(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Scope의 상태를 조회합니다..<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
     * @return List<PriRpScpMnVO>
	 * @exception EventException
	 */
	public List<PriRpScpMnVO> searchProposalScopeStatusCheck(PriRpScpMnVO  priRpScpMn) throws EventException {
		try {
			return dbDao.searchProposalScopeStatusCheck(priRpScpMn);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * Sales Lead Contract Info를 CRM으로 전송합니다.<br>
     * 
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transferRfaSalesLeadContractInfo(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
        try {
            List<RfaSlsLdCtrtInfoVO> list = dbDao.searchRfaSalesLeadContractInfo(priRpMnVO);
            if (list != null && list.size() > 0) {
                RFAProposalMainEAIDAO eaiDao = new RFAProposalMainEAIDAO();
                eaiDao.transferRfaSalesLeadContractInfo(list.get(0));
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
    }
    
	/**
	 * Scope삭제시 Terms의 데이터가 있는지 확인합니다.<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriRpScpMnVO  priRpScpMn) throws EventException {
		try {
			return dbDao.searchProposalScopeDeleteCheck(priRpScpMn);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}     
	
	/**
	 * RFA main의 Approve를 진행합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposal(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		String rfaNo = "";
		try {
			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();			
			PriRpHdrVO[] hVo = rfaPropProgVO.getPriRpHdrVOs();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();	
			
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());					
					vo[i].setPropAproOfcCd(account.getOfc_cd());
					vo[i].setPropAproDt(account.getUpd_dt());					
					updateVoList.add(vo[i]);
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);	
			//APPROVAL DATE
			dbDao.modifyProposalApprovalDate(updateVoList);
			
			if (vo[0].getAmdtSeq().equals("0") && hVo[0].getRfaNo().equals("") ){
				PriRpHdrVO hdrVo = new PriRpHdrVO();
				List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();				
				hdrVo.setUpdUsrId(account.getUsr_id());
				//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
				rfaNo = dbDao.searchMstCreationRFANo(vo[0].getPropOfcCd(), vo[0].getRfaCtrtTpCd() );	
				//rfaNo = dbDao.searchCreationRFANo(vo[0].getPropOfcCd());
				
				hdrVo.setRfaNo(rfaNo);
				hdrVo.setPropNo(vo[0].getPropNo());
				updateHdrVoList.add(hdrVo);
				dbDao.modifyProposalRFANO(updateHdrVoList);//RFA No Update				
			}
			
			/////////////////////////////main exp_dt변경
			List<PriRpMnVO> insertMnVoList = new ArrayList<PriRpMnVO>();
			PriRpMnVO mnVo = new PriRpMnVO();
			ObjectCloner.build(vo[0], mnVo);
			mnVo.setAmdtSeq(String.valueOf(Integer.valueOf(vo[0].getAmdtSeq())-1));
			
			insertMnVoList.add(mnVo);
			dbDao.modifyProposalMainAmend(insertMnVoList);
			dbDao.modifyProposalScopeMainAmend(insertMnVoList);	
			/////////////////////////////
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return rfaNo;
	}	
	
	/**
	 * RFA main Spot 의 Approve를 진행합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposalSpot(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		String rfaNo = "";
		try {
			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();			
			PriRpHdrVO[] hVo = rfaPropProgVO.getPriRpHdrVOs();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();	
			
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());					
					vo[i].setPropAproOfcCd(account.getOfc_cd());
					vo[i].setPropAproDt(account.getUpd_dt());					
					updateVoList.add(vo[i]);
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);	
			//APPROVAL DATE
			dbDao.modifyProposalApprovalDate(updateVoList);
			
			if (vo[0].getAmdtSeq().equals("0") && hVo[0].getRfaNo().equals("") ){
				PriRpHdrVO hdrVo = new PriRpHdrVO();
				List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();				
				hdrVo.setUpdUsrId(account.getUsr_id());
				
				//##### make a Spot Guide RFA No. #####
				rfaNo = dbDao.searchCreationSpotRFANo(vo[0].getPropOfcCd());
				//##### make a Spot Guide RFA No. #####
				
				hdrVo.setRfaNo(rfaNo);
				hdrVo.setPropNo(vo[0].getPropNo());
				updateHdrVoList.add(hdrVo);
				dbDao.modifyProposalRFANO(updateHdrVoList);//RFA No Update				
			}
			
			/////////////////////////////main exp_dt변경
			List<PriRpMnVO> insertMnVoList = new ArrayList<PriRpMnVO>();
			PriRpMnVO mnVo = new PriRpMnVO();
			ObjectCloner.build(vo[0], mnVo);
			mnVo.setAmdtSeq(String.valueOf(Integer.valueOf(vo[0].getAmdtSeq())-1));
			
			insertMnVoList.add(mnVo);
			dbDao.modifyProposalMainAmend(insertMnVoList);
			dbDao.modifyProposalScopeMainAmend(insertMnVoList);	
			/////////////////////////////
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return rfaNo;
	}		
	
	/**
	 * Master RFA main 의 Approve를 진행합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposalMst(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		String rfaNo = "";
		try {
			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();			
			PriRpHdrVO[] hVo = rfaPropProgVO.getPriRpHdrVOs();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();	
			
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());					
					vo[i].setPropAproOfcCd(account.getOfc_cd());
					vo[i].setPropAproDt(account.getUpd_dt());					
					updateVoList.add(vo[i]);
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);	
			//APPROVAL DATE
			dbDao.modifyProposalApprovalDate(updateVoList);
			
			if (vo[0].getAmdtSeq().equals("0") && hVo[0].getRfaNo().equals("") ){
				PriRpHdrVO hdrVo = new PriRpHdrVO();
				List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();				
				hdrVo.setUpdUsrId(account.getUsr_id());
				
				//##### make a Master RFA No. #####
				rfaNo = dbDao.searchCreationMstRFANo(vo[0].getPropOfcCd());
				//##### make a Master RFA No. #####
				
				hdrVo.setRfaNo(rfaNo);
				hdrVo.setPropNo(vo[0].getPropNo());
				updateHdrVoList.add(hdrVo);
				dbDao.modifyProposalRFANO(updateHdrVoList);//RFA No Update				
			}
			
			/////////////////////////////main exp_dt변경
			List<PriRpMnVO> insertMnVoList = new ArrayList<PriRpMnVO>();
			PriRpMnVO mnVo = new PriRpMnVO();
			ObjectCloner.build(vo[0], mnVo);
			mnVo.setAmdtSeq(String.valueOf(Integer.valueOf(vo[0].getAmdtSeq())-1));
			
			insertMnVoList.add(mnVo);
			dbDao.modifyProposalMainAmend(insertMnVoList);
			dbDao.modifyProposalScopeMainAmend(insertMnVoList);	
			/////////////////////////////
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return rfaNo;
	}
	
	/**
	 * RFA Proposal Master Creation의 상태를 이전 상태로 변경합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposal(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();
			
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();			
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					if (vo[i].getPropStsCd().equals("Q")){
						vo[i].setPropAproOfcCd("A");
					}
					updateVoList.add(vo[i]);
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);		
						
//			if (vo[0].getAmdtSeq().equals("0") && vo[0].getPropStsCd().equals("Q")){
//				PriRpHdrVO hdrVo = new PriRpHdrVO();
//				List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();		
//				hdrVo.setUpdUsrId(account.getUpd_usr_id());
//				hdrVo.setRfaNo("XX");
//				hdrVo.setPropNo(vo[0].getPropNo());
//				updateHdrVoList.add(hdrVo);
//				dbDao.modifyProposalHeader(updateHdrVoList);//RFA No Update
//			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		

	/**
     * Request Cancel시 자동으로 Accept된 항목을 Init 상태로 돌린다.<br>
	 * @param PriRpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelAmendmentSummary(PriRpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);
			
			dbDao.modifyProposalRequestCancelAmendmentSummary(updateVoList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * Request Cancel시 자동으로 Accept된 항목을 이전상태로 돌린다.(Scope)<br>
	 * @param PriRpScpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeRequestCancelAmendmentSummary(PriRpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpScpAmdtSmryVO> updateVoList = new ArrayList<PriRpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);			
			dbDao.modifyProposalScopeRequestCancelAmendmentSummary(updateVoList);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Scope상태를 모두 INIT으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAllScopeStatus(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
				
			priRpScpMnVO.setUpdUsrId(account.getUsr_id());
			priRpScpMnVO.setPropScpStsCd("I");
			dbDao.modifyAllScopeStatus(priRpScpMnVO);
			

			PriRpScpProgVO vo = new PriRpScpProgVO();
			ObjectCloner.build(priRpScpMnVO, vo);
			vo.setProgOfcCd(account.getOfc_cd());
			vo.setProgUsrId(account.getUsr_id());
			vo.setPropScpStsCd("I");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			dbDao.addProposalScopeProgressChange(vo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
	 * Proposal의 상태가 Init이고 Initial상태를 Cancel 할 경우 Main Expire Date를 수정 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiryCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {
			int amdtSeq = 0;
			
			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());	
				PriRpMnVO vo = new PriRpMnVO();
				ObjectCloner.build(priRpMnVO, vo);
				amdtSeq = Integer.parseInt(vo.getAmdtSeq()) -1 ;				
				vo.setAmdtSeq(String.valueOf(amdtSeq));
				dbDao.modifyProposalMainExpiry (vo);
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
	 * Init Cancel시 모든 데이터를 삭제처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalAproRqstRefUsr(priRpMnVO);
			dbDao.removeProposalAproRqstRef(priRpMnVO);			
			dbDao.removeProposal(priRpMnVO);
			if (priRpMnVO.getAmdtSeq().equals("0")){
				dbDao.removeProposalHdr(priRpMnVO);
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
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalProgress(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalProgress(priRpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalAmdtSmry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalAmdtSmry(priRpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Init Cancel시 Amend seq에 해당하는 모든 데이터를 삭제처리합니다. <br>
	 * 
	 * @param priRpScpMnVO PriRpScpMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeProposalScopeMain(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeMain(priRpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Proposal의 상태가 Init이고 Initial상태를 Cancel 할 경우 Scope Main Expire Date를 수정 합니다.<br>
	 * 
	 * @param priRpScpMnVO PriRpScpMnVO
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiryCancel(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			int amdtSeq = 0;
			if (priRpScpMnVO != null  ) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());	
				PriRpScpMnVO vo = new PriRpScpMnVO();
				ObjectCloner.build(priRpScpMnVO, vo);
				amdtSeq = Integer.parseInt(vo.getAmdtSeq()) -1 ;				
				vo.setAmdtSeq(String.valueOf(amdtSeq));
				dbDao.modifyProposalScopeMainExpiryChange (vo);
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
     * Terms의 상태 변경 시 Terms Summary정보를 수정 합니다.<br>
	 * 
	 * @param PriRpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAmendmentSummary(PriRpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalAmendmentSummary(updateVoList);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * Terms의 상태 변경 시 Terms Summary정보를 수정 합니다.<br>
	 * summary 데이터를 확인하여 Main의 Status를 변경한다.<br>
	 * @param PriRpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAmendmentSummary(PriRpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);			
			dbDao.modifyProposalAmendmentSummary(updateVoList);
			
			PriRpMnVO priRpMnVO = new PriRpMnVO();
			ObjectCloner.build(vo, priRpMnVO);
			dbDao.modifyAutoChangeMainStatus(priRpMnVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	
	
	/**
     * Terms의 상태 변경 시 Scope별  Terms Summary정보를 수정 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpScpAmdtSmryVO> updateVoList = new ArrayList<PriRpScpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
			dbDao.modifyProposalScopeStatus(updateVoList);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
     * Terms의 상태 변경 시 Scope별  Terms Summary정보를 수정 합니다.<br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageScopeAmendmentSummary(PriRpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRpScpAmdtSmryVO> updateVoList = new ArrayList<PriRpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);			
			dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
			dbDao.modifyProposalScopeStatus(updateVoList);			
			
			// TERMS가 모두 ACCEPT되었는지 확인하여 SCOPE MAIN의 상태를 ACCEPT로 변경한다.
			PriRpScpMnVO scpVo = new PriRpScpMnVO();
			ObjectCloner.build(vo, scpVo);
			int cnt = dbDao.searchProposalScopeAcceptCheck(scpVo);
			
			if (cnt == 0) {// scope status ALL accept
				List<PriRpScpMnVO> updateScpVoList = new ArrayList<PriRpScpMnVO>();
				List<PriRpScpProgVO> insertProgVoList =  new ArrayList<PriRpScpProgVO>(); 
				PriRpScpMnVO[] priRpScpMnVO = new PriRpScpMnVO[1];
				priRpScpMnVO[0] = new PriRpScpMnVO();				
				ObjectCloner.build(scpVo, priRpScpMnVO[0]);
				priRpScpMnVO[0].setPropScpStsCd("A");// Accept로 변경
				priRpScpMnVO[0].setUpdUsrId(account.getUsr_id());				
				updateScpVoList.add(priRpScpMnVO[0]);				
				PriRpScpProgVO progVo = new PriRpScpProgVO();
				ObjectCloner.build(priRpScpMnVO[0], progVo);
				progVo.setProgOfcCd(account.getOfc_cd());	
				progVo.setProgUsrId(account.getUsr_id());
				progVo.setCreUsrId(account.getUsr_id());
				insertProgVoList .add(progVo);				
				if ( updateScpVoList.size() > 0 ) {				
					dbDao.modifyScopeStatus(updateScpVoList);
				}
				//pregress 변경			
				if ( insertProgVoList.size() > 0 ) {				
					dbDao.addProposalScopeProgress(insertProgVoList);
				}
				
			} else {				
				List<PriRpScpProgVO> insertProgVoList =  new ArrayList<PriRpScpProgVO>();				
            	scpVo.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyAutoScopeReturnStatus (scpVo);				
				if (dbDao.searchScopeProgressStatus(scpVo) == 0){
					//prog와 Mn의 상태가 다르다면 prog에 insert
					PriRpScpProgVO rpScpProgVo = new PriRpScpProgVO();
					ObjectCloner.build(scpVo, rpScpProgVo);
					rpScpProgVo.setProgOfcCd(account.getOfc_cd());	
					rpScpProgVo.setProgUsrId(account.getUsr_id());
					rpScpProgVo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(rpScpProgVo);	
					if ( insertProgVoList.size() > 0 ) {				
						dbDao.addProposalScopeProgressScopeMn(insertProgVoList);
					}
				}	
			}

			PriRpMnVO mnVo = new PriRpMnVO();
            ObjectCloner.build(vo, mnVo); 
            mnVo.setUpdUsrId(account.getUsr_id());            
            dbDao.modifyAutoChangeMainStatus(mnVo);			

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	/**
	 * TERMS가  모두 ACCEPT되었는지 확인합니다.<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeAcceptCheck(PriRpScpMnVO  priRpScpMn) throws EventException {
		try {
			return dbDao.searchProposalScopeAcceptCheck(priRpScpMn);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
     * Scope상태를 Scope별로 변경 합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyScopeStatus(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			List<PriRpScpProgVO> insertProgVoList =  new ArrayList<PriRpScpProgVO>(); 
			
			for ( int i=0; i<priRpScpMnVOs .length; i++ ) {
				if ( priRpScpMnVOs[i].getIbflag().equals("U")){
					priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpScpMnVOs[i]);
					PriRpScpProgVO vo = new PriRpScpProgVO();
					ObjectCloner.build(priRpScpMnVOs[i], vo);
					vo.setProgOfcCd(account.getOfc_cd());	
					vo.setProgUsrId(account.getUsr_id());
					vo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(vo);					
				}

			}		
			
			if ( updateVoList.size() > 0 ) {				
				dbDao.modifyScopeStatus(updateVoList);
			}
			//pregress 변경
		
			if ( insertProgVoList.size() > 0 ) {				
				dbDao.addProposalScopeProgress(insertProgVoList);
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
	 * Terms중 하나라도 Returned 가 있다면 Scope의 상태를 Returned로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeAutoScopeReturnStatus(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpProgVO> insertProgVoList =  new ArrayList<PriRpScpProgVO>(); 
			if (priRpScpMnVO != null  ) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyAutoScopeReturnStatus (priRpScpMnVO);
				
				if (dbDao.searchScopeProgressStatus(priRpScpMnVO) == 0){
					//prog와 Mn의 상태가 다르다면 prog에 insert
					PriRpScpProgVO vo = new PriRpScpProgVO();
					ObjectCloner.build(priRpScpMnVO, vo);
					vo.setProgOfcCd(account.getOfc_cd());	
					vo.setProgUsrId(account.getUsr_id());
					vo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(vo);	
					if ( insertProgVoList.size() > 0 ) {				
						dbDao.addProposalScopeProgressScopeMn(insertProgVoList);
					}						
				}
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
     * Proposal  Main 의 Status 컬럼을 업데이트 합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyMainStatus (PriRpMnVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setUpdUsrId(account.getUsr_id());
            
            dbDao.modifyMainStatus(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }		
    
	/**
     * MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiry(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());					
				dbDao.modifyProposalMainExpiry (priRpMnVO);
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
     * Duration 변경시 Scope MAIN의  Expire Date를 변경 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiry(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalScopeMainExpiry (priRpMnVO);
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
	 * DURATION 변경시  SCOPE MAIN  Expire Date를 수정 합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeProposalScopeMainExpiry(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priRpScpMnVO != null  ) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalScopeMainExpiryChange (priRpScpMnVO);
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
     * RFA Main 에 Amend Data를 생성합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();

			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());
			priRpMnVO.setPropOfcCd(account.getOfc_cd());

			insertVoList.add(priRpMnVO);
		
			
			dbDao.addProposalMainAmend(insertVoList);
			dbDao.addProposalScopeMainAmend(insertVoList);			
			log.debug("amendProposal==exp_dt=="+priRpMnVO.getExpDt());
			if (!priRpMnVO.getExpDt().equals("")){
				log.debug("exp_dt===========main=="+priRpMnVO.getExpDt());
				dbDao.modifyProposalScopeMainAmd(insertVoList);
			}
			
			dbDao.addProposalProgressAmend(insertVoList);
			dbDao.addProposalAmendmentSummaryAmend(insertVoList);
			dbDao.addProposalScopeProgressAmend(insertVoList);
			dbDao.addProposalScopeAmendmentSummaryAmend(insertVoList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * c/offer 이 있는 terms 에서 returned 인 데이터를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltReturnVO>
	 * @exception EventException
	 */
	public List<RsltReturnVO> searchProposalReturnedList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalReturnedList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
    /**
     * Proposal  Main 의 Status 컬럼을 Returned에서 Request로 업데이트 합니다.<br>
     * 
     * @param PriRpMnVO vo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int changeAutoRequestMainStatus (PriRpMnVO vo, SignOnUserAccount account) throws EventException {
        int result = 0;
    	try {
            vo.setUpdUsrId(account.getUsr_id());
            
            result = dbDao.modifyAutoChangeMainStatus(vo);
            log.debug("changeAutoRequestMainStatus==result=="+result);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
        return result;
    }	
    
	/**
	 * Amend시 duration의 amenddentSummary를 자동 수정합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAmendmentSummaryDuration(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {			
			log.debug("amendProposal==exp_dt==amendsummary="+priRpMnVO.getExpDt());
			if (!priRpMnVO.getExpDt().equals("")){
				log.debug("exp_dt==============summaryduration="+priRpMnVO.getExpDt());
				List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();
				PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
				ObjectCloner.build(priRpMnVO, priRpAmdtSmryVO);
				priRpAmdtSmryVO.setPropTermTpCd("01");
				priRpAmdtSmryVO.setAmdtSeq(String.valueOf(Integer.parseInt(priRpAmdtSmryVO.getAmdtSeq()) + 1));
				priRpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpAmdtSmryVO);			
				dbDao.modifyProposalAmendmentSummary(updateVoList);
				
				List<PriRpScpAmdtSmryVO> updateScpVoList = new ArrayList<PriRpScpAmdtSmryVO>();
				List<PriRpScpMnVO> list = dbDao.searchProposalScope(priRpMnVO);
				if (list != null && list.size() > 0){
					for (int i = 0; i< list.size(); i++){
						PriRpScpAmdtSmryVO vo = new PriRpScpAmdtSmryVO();
						ObjectCloner.build(priRpMnVO, vo);
            			vo.setSvcScpCd(list.get(i).getSvcScpCd());
            			vo.setPropScpTermTpCd("11");
            			vo.setAmdtSeq(String.valueOf(Integer.parseInt(vo.getAmdtSeq()) + 1)) ;
            			
            			vo.setUpdUsrId(account.getUsr_id());
            			updateScpVoList.add(vo);	
            			dbDao.modifyProposalScopeAmendmentSummary(updateScpVoList);
					}
				}
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
	 * Approve Cancel시 Main,Scope Expire Date를 Approve 이전 값으로 수정 합니다.<br>
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalApproveCancel(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {			
			PriRpMnVO mnVo = new PriRpMnVO();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();

			if (priRpMnVO != null  ) {
				mnVo.setUpdUsrId(account.getUsr_id());
				mnVo.setPropNo(priRpMnVO.getPropNo());
				mnVo.setAmdtSeq(String.valueOf(Integer.valueOf(priRpMnVO.getAmdtSeq())-1));
				
				priRpMnVO.setUpdUsrId(account.getUsr_id());				
				updateVoList.add(priRpMnVO);
				
				
//				priRpMnVO.setUpdUsrId(account.getUsr_id());
//				priRpMnVO.setAmdtSeq(String.valueOf(Integer.valueOf(priRpMnVO.getAmdtSeq())-1));
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<manageProposalApproveCancel<<<<<<<<<<<<<<<<<<<<<<<");
				dbDao.modifyProposalApproveCancelMain(mnVo);
				dbDao.modifyProposalApproveCancelScopeMain(mnVo);
				//APPROVAL DATE
				dbDao.modifyProposalApprovalDate(updateVoList);
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<manageProposalApproveCancel<<<<<<<<<<<<<<<<<<<<<<<");
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
	 * Request 시 validation 을 하기 위해 DEM/DET Exception의 Status를 가져온다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<DmtScExptVerVO>
	 * @exception EventException
	 */
	public List<DmtScExptVerVO> searchCheckDmdtList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchCheckDmdtList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Duration(Main,Scope)과 Dem/Det 데이터가 변경 되었는지 조회 한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckDurationList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchCheckDurationList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *Sale Lead 를 조회합니다.<br>
	 * 
	 * @param SchSaleLeadRfaVO schSaleLeadRfaVO
	 * @return List<RsltPriCrmSlLdVO>
	 * @exception EventException
	 */
	public List<RsltPriCrmSlLdVO> searchProposalMainSaleLeadList (SchSaleLeadRfaVO schSaleLeadRfaVO) throws EventException {
		try {
			return dbDao.searchProposalMainSaleLeadList (schSaleLeadRfaVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	
	
	/**
	 * Amend History Main정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMain(PriRpHdrVO priRpHdrVO) throws EventException {
		try {
			
			return dbDao.searchAmendmentHistoryMain(priRpHdrVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}  
	
	/**
	 * Amend History Main Spot 정보를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMainSpot(PriRpHdrVO priRpHdrVO) throws EventException {
		try {
			
			return dbDao.searchAmendmentHistoryMainSpot(priRpHdrVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 
	
	/**
	 * Amend History Scope List 정보를 조회합니다.<br>
	 * 
	 * @param CstShHistVO CstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception EventException
	 */
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws EventException {
		try {
			return dbDao.searchAmendmentHistoryList(cstShHistVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	
	
	
	/**
	 * Amend 된 Terms를 조회합니다.
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriSpScpGrpLocDtlVO>
	 * @exception EventException
	 */	
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchHistoryAmendTermList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   
	

	
	/**
     * 각 Terms에 수정된 정보가 있는 지 조회합니다.<br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO> 
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws EventException {
		try {
			return dbDao.searchAmendmentHistorySummary(cstShHistVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}  		
	
	/**
	 * Proposal No.에 해당 하는 모든 Scope 을 조회합니다.
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchHistoryScopeList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchHistoryScopeList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 		
	
    /**
     * RFA Proposal Affiliate 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception EventException
     */
    public List<RsltRfaPropCopyVO> searchProposalCopyAfilList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws EventException {
        try {
            return dbDao.searchProposalCopyAfilList (rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Main / Scope 의 Copy 정보를 조회합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception EventException
     */
    public List<RsltRfaPropCopyVO> searchProposalCopyList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws EventException {
        try {
            return dbDao.searchProposalCopyList (rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Copy 시 새로운 Proposal Number 를 조회합니다.<br>
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String searchMaxPropNo (SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchCreationProposalNo(account.getOfc_cd());
        } catch (DAOException ex) {
            // Insert 시 호출하므로 에러메세지는 저장에러메세지를 지정
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            // Insert 시 호출하므로 에러메세지는 저장에러메세지를 지정
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Main 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMain(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
            rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
            rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
            rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            rsltRfaPropCopyVO.setSrepCd(account.getSrep_cd());

            // PRI_RP_HDR COPY
            dbDao.addCopyProposalHdr(rsltRfaPropCopyVO);

            // PRI_RP_MN COPY
            dbDao.addCopyProposalMain(rsltRfaPropCopyVO);

            // PRI_RP_AMDT_SMRY
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(rsltRfaPropCopyVO.getNewPropNo());
            priRpAmdtSmryVO.setAmdtSeq("0");
            priRpAmdtSmryVO.setCreUsrId(account.getUsr_id());
            priRpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            dbDao.addProposalAmendmentSummary(priRpAmdtSmryVO);

            // PRI_RP_PROG
            dbDao.addCopyProposalProg(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Master RFA Proposal Main 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
	 * @param String rfaTypeCode
     * @exception EventException
     */
    public void copyProposalMainMst(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account, String rfaTypeCode) throws EventException{
        try {
            rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
            rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
            rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            rsltRfaPropCopyVO.setSrepCd(account.getSrep_cd());

            // PRI_RP_HDR COPY
            dbDao.addCopyProposalHdrMst(rsltRfaPropCopyVO);

            // PRI_RP_MN COPY
            dbDao.addCopyProposalMainMst(rsltRfaPropCopyVO, rfaTypeCode);

            // PRI_RP_AMDT_SMRY
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(rsltRfaPropCopyVO.getNewPropNo());
            priRpAmdtSmryVO.setAmdtSeq("0");
            priRpAmdtSmryVO.setCreUsrId(account.getUsr_id());
            priRpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            dbDao.addProposalAmendmentSummary(priRpAmdtSmryVO);

            // PRI_RP_PROG
            dbDao.addCopyProposalProg(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Main Amendment Summary 를 수정합니다.<br>
     * 
     * @param PriRpAmdtSmryVO priRpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void manageProposalAmendmentSummaryAll(PriRpAmdtSmryVO priRpAmdtSmryVO, SignOnUserAccount account) throws EventException{
        try {
            priRpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01739",0);
            
            for (int j = 0, m = cdList.size(); j < m; j++) {
                priRpAmdtSmryVO.setPropTermTpCd(cdList.get(j).getCode());
                dbDao.modifyProposalAmendmentSummary(priRpAmdtSmryVO);
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
     * RFA Proposal Scope 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMain(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_MN COPY
            dbDao.addCopyProposalScopeMain(vo);
            
            List<PriRpScpProgVO> progList = new ArrayList<PriRpScpProgVO>();
            PriRpScpProgVO scpVo = new PriRpScpProgVO();
            scpVo.setPropNo(vo.getNewPropNo());
            scpVo.setAmdtSeq("0");
            scpVo.setSvcScpCd(vo.getSvcScpCd());
            scpVo.setPropScpStsCd("I");
            scpVo.setProgUsrId(account.getUsr_id());
            scpVo.setProgOfcCd(account.getOfc_cd());
            scpVo.setCreUsrId(account.getUsr_id());
            scpVo.setUpdUsrId(account.getUsr_id());
            progList.add(scpVo);
            
            // PRI_RP_SCP_PROG
            dbDao.addProposalScopeProgress(progList);
            
            List<PriRpScpAmdtSmryVO> smryList = new ArrayList<PriRpScpAmdtSmryVO>();
            PriRpScpAmdtSmryVO smVo = new PriRpScpAmdtSmryVO();
            smVo.setPropNo(vo.getNewPropNo());
            smVo.setAmdtSeq("0");
            smVo.setSvcScpCd(vo.getSvcScpCd());
            smVo.setCreUsrId(account.getUsr_id());
            smVo.setUpdUsrId(account.getUsr_id());
            smryList.add(smVo);
            
            // PRI_RP_SCP_AMDT_SMRY INSERT
            dbDao.addProposalScopeAmendmentSummary(smryList);
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Amendment Summary 정보를 수정합니다.<br>
     * 
     * @param RsltRfaPropCopyVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void copyProposalScopeAmdtSmry(RsltRfaPropCopyVO[] vos, SignOnUserAccount account) throws EventException{
        try {
            PriRpScpAmdtSmryVO smVo = new PriRpScpAmdtSmryVO();
            
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01740",0);
            
            for (int i = 0, n = vos.length; i < n; i++) {
                for (int j = 0, m = cdList.size(); j < m; j++) {
                    smVo = new PriRpScpAmdtSmryVO();
                    smVo.setPropNo(vos[i].getNewPropNo());
                    smVo.setAmdtSeq("0");
                    smVo.setSvcScpCd(vos[i].getSvcScpCd());
                    smVo.setPropScpTermTpCd(cdList.get(j).getCode());
                    smVo.setUpdUsrId(account.getUsr_id());
                    dbDao.modifyProposalScopeAmendmentSummary(smVo);
                }
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
     * Proposal Request 정보를 저장합니다.<br>
     * 
     * @param PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRequestMessage(PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs, SignOnUserAccount account) throws EventException{
        try {
            PriRpAproRqstRefVO priRpAproRqstRefVO = new PriRpAproRqstRefVO();
            if (priRpAproRqstRefUsrVOs != null && priRpAproRqstRefUsrVOs[0] != null) {
                priRpAproRqstRefVO.setPropNo(priRpAproRqstRefUsrVOs[0].getPropNo());
                priRpAproRqstRefVO.setAmdtSeq(priRpAproRqstRefUsrVOs[0].getAmdtSeq());
            }
            
            String newSeq = dbDao.searchProposalRequestNewSeq(priRpAproRqstRefVO);
            priRpAproRqstRefVO.setAproRqstSeq(newSeq);
            priRpAproRqstRefVO.setAproRqstUsrOfcCd(account.getOfc_cd());
            priRpAproRqstRefVO.setAproRqstUsrId(account.getUsr_id());
            priRpAproRqstRefVO.setPrcAproRqstStsCd("R");
            priRpAproRqstRefVO.setCreUsrId(account.getUsr_id());
            priRpAproRqstRefVO.setUpdUsrId(account.getUsr_id());

            dbDao.addProposalRequestRef(priRpAproRqstRefVO);
            
            for ( int i = 0; i < priRpAproRqstRefUsrVOs.length ; i++ ) {
                if (priRpAproRqstRefUsrVOs[i].getIbflag().equals("I")){
                    priRpAproRqstRefUsrVOs[i].setCreUsrId(account.getUsr_id());
                    priRpAproRqstRefUsrVOs[i].setUpdUsrId(account.getUsr_id());
                    priRpAproRqstRefUsrVOs[i].setAproRqstSeq(newSeq);
                    
                    dbDao.addProposalRequestRefUser(priRpAproRqstRefUsrVOs[i]);
                }
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
     * Proposal Request 상태를 수정합니다.<br>
     * 
     * @param PriRpAproRqstRefVO priRpAproRqstRefVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalRequestStatus(PriRpAproRqstRefVO priRpAproRqstRefVO, SignOnUserAccount account) throws EventException{
        try {
            priRpAproRqstRefVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyProposalRequestStatus(priRpAproRqstRefVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }

    /**
     * RFA 승인을 위해 신청하거나 접수한 Proposal Request 를 조회합니다.<br>
     * 
     * @param RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO
     * @return List<RsltRfaAproRqstRefVO>
     * @exception EventException
     */
    public List<RsltRfaAproRqstRefVO> searchProposalRequestList (RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) throws EventException {
        try {
            if (JSPUtil.getNull(rsltRfaAproRqstRefVO.getTransTpCd()).equals("S")) {
                return dbDao.searchProposalSentRequestList(rsltRfaAproRqstRefVO);
            } else {
                return dbDao.searchProposalReceivedRequestList(rsltRfaAproRqstRefVO);
            }
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * RFA 대상에서  [Requested/ Approval/ Effective] 조건으로 Requested 정보와 Approval 정보를  조회합니다.<br>
     * 
     * @param RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstReByOfcfVO
     * @return List<RsltRfaAproRqstRefByOfcVO>
     * @exception EventException
     */
    public List<RsltRfaAproRqstRefByOfcVO> searchProposalRequestByOfficeList (RsltRfaAproRqstRefByOfcVO rsltRfaAproRqstReByOfcfVO) throws EventException {
        try {
        	 if (JSPUtil.getNull(rsltRfaAproRqstReByOfcfVO.getDtType()).equals("RQST")) {
        		//Requested
        		 // searchProposalRequestList
        		 return dbDao.searchProposalRequestList(rsltRfaAproRqstReByOfcfVO);
        	 } else if (JSPUtil.getNull(rsltRfaAproRqstReByOfcfVO.getDtType()).equals("APRO")) {
        		 //Approval
        		// searchProposalApprovalList
        		 return dbDao.searchProposalApprovalList(rsltRfaAproRqstReByOfcfVO);
        	 } else { 
        		 //Effective
        		// searchProposalEffectiveList
        		 return dbDao.searchProposalEffectiveList(rsltRfaAproRqstReByOfcfVO);
        	 }
        	 
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Proposal & Amendment Search List 를 조회합니다.<br>
	 * 
	 * @param CstShRInqVO cstShRInqVO
	 * @return List<RsltPriRpInqVO>
	 * @exception EventException
	 */
	public List<RsltPriRpInqVO> searchProposalMainInquiryList(CstShRInqVO cstShRInqVO) throws EventException {
		try {
			return dbDao.searchProposalMainInquiryList (cstShRInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Proposal & Amendment Search List 를 조회합니다.<br>
	 * 
	 * @param CstShRInqVO cstShRInqVO
	 * @return List<RsltPriRpInqVO>
	 * @exception EventException
	 */
	public List<RsltPriRpInqVO> searchProposalMainSpotInquiryList(CstShRInqVO cstShRInqVO) throws EventException {
		try {
			return dbDao.searchProposalMainSpotInquiryList (cstShRInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	

	/**
	 * Proposal & Amendment 정보를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @return RsltPropInqListVO
	 * @exception EventException
	 */
	public RsltPropInqListVO searchProposalMainInquiry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropInqListVO vo = new RsltPropInqListVO();
			vo.setRsltPropMnInqVOs(dbDao.searchProposalMainInquiry(priRpMnVO));
			vo.setRsltPropMnScpInqListVOs(dbDao.searchProposalMainScpInquiryList(priRpMnVO));	

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Proposal & Amendment 정보를 조회합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @return RsltPropInqListVO
	 * @exception EventException
	 */
	public RsltPropInqListVO searchProposalMainSpotInquiry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropInqListVO vo = new RsltPropInqListVO();
			vo.setRsltPropMnInqVOs(dbDao.searchProposalMainSpotInquiry(priRpMnVO));
			vo.setRsltPropMnScpInqListVOs(dbDao.searchProposalMainScpInquiryList(priRpMnVO));	

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 *  Inquiry Main에서 Customer 정보를 조회 합니다.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception EventException
	 */
	public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalCustomerInfoInquiry(priSpCtrtPtyVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * Summry 테이블에서 terms의 데이터가 수정 되었는지 조회합니다.<br>
     *
     * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAmendmentSummaryInquiry(priRpScpAmdtSmryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}    

	/**
	 * Approval Cancel 시 BKG에서 사용되는 RFA_NO가 있는지 조회합니다. <br>
	 * 데이터가 있다면 Cancel 할 수 없다.<br>
	 * @param CstApprovalVO cstApprovalVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalCancelCheck(CstApprovalVO cstApprovalVO) throws EventException {
		try {
			return dbDao.searchApprovalCancelCheck(cstApprovalVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * Guideline Copy 대상 정보를 조회합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return List<RpScpGlineCopyVO>
     * @exception EventException
     */
    public List<RpScpGlineCopyVO> searchGuidelineCopyCheck(RpScpGlineCopyVO rpScpGlineCopyVO) throws EventException {
        try {
            return dbDao.searchGuidelineCopyCheck(rpScpGlineCopyVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copy 할 Guideline 의 gline_seq 를 조회합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return String
     * @exception EventException
     */
    public String searchCopyGlineSeq(RpScpGlineCopyVO rpScpGlineCopyVO) throws EventException {
        try {
            return dbDao.searchCopyGlineSeq(rpScpGlineCopyVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Proposal Scope Amendment Summary 를 업데이트 합니다.<br>
     * 
     * @param RpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void copyScopeGuidelineScopeAmdtSmry(RpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            PriRpScpAmdtSmryVO smVo = new PriRpScpAmdtSmryVO();
            
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01740",0);
            
            for (int i = 0, m = cdList.size(); i < m; i++) {
                smVo = new PriRpScpAmdtSmryVO();
                smVo.setPropNo(vo.getPropNo());
                smVo.setAmdtSeq(vo.getAmdtSeq());
                smVo.setSvcScpCd(vo.getSvcScpCd());
                smVo.setPropScpTermTpCd(cdList.get(i).getCode());
                smVo.setUpdUsrId(account.getUsr_id());
                dbDao.modifyProposalScopeAmendmentSummary(smVo);
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
     * PRS 정보를 Copy 하여 RFA Proposal Main 관련 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO vo 
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyToProposalBase(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException{
       try {
    	    vo.setCreUsrId(account.getUsr_id());
    	    vo.setUpdUsrId(account.getUsr_id());
			//office
    	    vo.setQttnOfcCd(account.getOfc_cd());
    	    
    	    int chk = 0;
			
			//PRI_RP_HDR
    	    chk  = dbDao.addCopyRfaQuotationPriRpHdr(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_RP_MN
    	    chk  = dbDao.addCopyRfaQuotationPriRpMn(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_RP_Amdt_Smry
    	    chk  = dbDao.addCopyRfaQuotationPriRpAmdtSmry(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_RP_Prog
    	    chk  = dbDao.addCopyRfaQuotationPriRpProg(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			
			//PRI_SP_RP_MN
    	    chk  = dbDao.addCopyRfaQuotationPriRpScpMn(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_SP_RP_Prog
    	    chk  = dbDao.addCopyRfaQuotationPriRpScpProg(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_SP_RP_Amdt_Smry
    	    chk  = dbDao.addCopyRfaQuotationPriRpScpAmdtSmry(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
       } catch(EventException ex) {
			throw ex;
       } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       }
    }

    /**
     * RFA General Information 을 EDI 로 전송합니다.<br>
     * 
     * @param PriEdiRfGenInfVO priEdiRfGenInfVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void transferRfaGeneralInfo (PriEdiRfGenInfVO priEdiRfGenInfVO, SignOnUserAccount account) throws EventException {
        try {
            List<PriEdiRfGenInfVO> list = dbDao.searchRfaGeneralInfo(priEdiRfGenInfVO);
            if (list != null && list.size() > 0) {
                RFAProposalMainEAIDAO eaiDao = new RFAProposalMainEAIDAO();
                eaiDao.transferRfaGeneralInfo(list.get(0));
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    
    /**
     * PRS CM Data를 조회합니다.<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltRfaPRSCMDataVO>
     * @exception EventException
     */
	public List<RsltRfaPRSCMDataVO> searchProposalMainPRSCMData(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalMainPRSCMData (priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	  
	
	
	/**
     * Main의 상태를 조회한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltRfaMainStsVO>
	 * @exception EventException
	 */
	public List<RsltRfaMainStsVO> searchProposalMainStatus(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalMainStatus(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	} 	
	
	
	/**
	 * RFA Main을 삭제합니다.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRemove(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{

		try {			
			PriRpScpMnVO[] scpVo = rfaPropMnVO.getPriRpScpMnVOs();
			List<PriRpScpMnVO> deleteScpVoList = new ArrayList<PriRpScpMnVO>();

			for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
				if ( scpVo[i].getIbflag().equals("D")){
					deleteScpVoList.add(scpVo[i]);
				}
			}

			// 기존 scp mn 이 delete ( 관련 하위 데이터 삭제 ) 
			if ( deleteScpVoList.size() > 0 ) {				
				dbDao.removeProposalScopeAmdtSmry(deleteScpVoList);
				dbDao.removeProposalScopeProgress(deleteScpVoList);
				dbDao.removeProposalScopeMain(deleteScpVoList);
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
	 * Proposal No., Amend Seq 에 해당 하는 Scope 을 조회 합니다.
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchScopeList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchScopeList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
    /**
     * Rate Save시, Scope Main의 PRS Calc 관련 테이블을 업데이트한다.<br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void updatePrsCalcFlgOnSaveRt(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpMnVO != null) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyPrsCalcFlgOnSaveRt(priRpScpMnVO);
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
     * Rate Save시, Scope Main의 PRS MB 관련 테이블을 업데이트한다.<br>
     * 
     * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void updatePrsMBFlgOnSaveRt(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpMnVO != null) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyPrsMBFlgOnSaveRt(priRpScpMnVO);
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
	 * C/Offer/Request Cancel 시 Rate  CALCULATE  Flag를 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRateCalcFlag(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priRpScpMnVO != null) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());
			}
			
			dbDao.modifyPrsCalcFlgOnChangeStatus(priRpScpMnVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
    /**
     * 작성자가 Reqeust Cancel 시 Accept, Returned 데이터가 있는지 조회한다.<br>
     * @param PriRpMnVO priRpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
	public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalRequestCancelCheck(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   	
    
    
	/**
	 * CM/OP View 의 Load 값이 변한것에 맞춰 scope main의 summary 값을 갱신처리 합니다.<BR>
	 * 
	 * @param PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyScopeMainSummary(PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO, SignOnUserAccount account)
			throws EventException {
		try {
			PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVO = priRpScpRtCmdtRoutSetVO.getPriRpScpRtCmdtRoutVOS();
			for (int i = 0; i < priRpScpRtCmdtRoutVO.length; i++) {
				if (priRpScpRtCmdtRoutVO[i].getIbflag().equals("U")) {
					priRpScpRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyScopeMainSummary(priRpScpRtCmdtRoutVO[i]);	
					break;
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
    /**
     * Target MVC estimate 를 저장하지 않은 내용이 있는지 check한다..<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltCheckMQCEstimateVO>
     * @exception EventException
     */
    public List<RsltCheckMQCEstimateVO> searchCheckMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO)  throws EventException {
		try {
			return dbDao.searchCheckMQCEstimateList(inPrsMQCEstimateVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}    	
    
    /**
     * Target MVC estimate Popup의 List를 조회한다..<br>
     *
     * @param InPrsMQCEstimateVO inPrsMQCEstimateVO
     * @return List<RsltMQCEstimateVO>
     * @exception EventException
     */
    public List<RsltMQCEstimateVO> searchMQCEstimateList(InPrsMQCEstimateVO inPrsMQCEstimateVO)  throws EventException {
		try {
			return dbDao.searchMQCEstimateList(inPrsMQCEstimateVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}     
    
	/**
	 *  Target MVC estimate 정보를 갱신합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMQCEstimateList(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException{
		try {

			 
			List<PriRpScpMnVO> updateScpVoList = new ArrayList<PriRpScpMnVO>(); 
			for ( int i = 0; priRpScpMnVOs != null && i < priRpScpMnVOs.length; i++ ) {
				if ( priRpScpMnVOs[i].getIbflag().equals("U")){
					updateScpVoList.add(priRpScpMnVOs[i]);
				}
			}
		 
			dbDao.modifyMQCEstimateList(updateScpVoList);
 
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}	
		
	}		
	
    /**
     * Request Office 또는 Sales Rep 정보가 변경된 경우 EAI I/F 를 위한 정보를 조회한다.<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @return int
     * @exception EventException
     */
    public int searchCheckOfcSrepDiffList(PriRpMnVO priRpMnVO)  throws EventException {
		try {
			return dbDao.searchCheckOfcSrepDiffList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * RFA_NO에 해당한 PROP_NO를 조회합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return PriRpHdrVO
	 * @exception EventException
	 */
	public PriRpHdrVO searchProposalNoFromRfaNo(PriRpHdrVO priRpHdrVO) throws EventException {
		try {
			List<PriRpHdrVO> list = dbDao.searchProposalNoFromRfaNo(priRpHdrVO);
			
			if(list != null && list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	
	/**
	 * ESM_PRI_2003 : Request Check <br>
	 * Rquest 처리시 Rate(AEE/AEW)의 FIC_PROP_RT_AMT값이 O인 값이 존재하는지 체크<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception EventException
     */
    public String searchProposalRequestIhcRateCheck(PriRpMnVO priRpMnVO) throws EventException {
    	try {
			return dbDao.searchProposalRequestIhcRateCheck(priRpMnVO);
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }   	
    }
    
    /**
	 * ESM_PRI_2003 : Request Check <br>
	 * Rquest 처리 시 Port CY 운임에 Port 가 아닌 Route가 존재하는지 체크<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
     */
    public List<RsltCdListVO> searchProposalRequestPortCyCheck(PriRpMnVO priRpMnVO) throws EventException {
    	try {    		
			return dbDao.searchProposalRequestPortCyCheck(priRpMnVO);			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }   	
    }
    
    /**
     * RFA APPROVE 시 유저에게 G/W 메일 발송<br>
     *
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @return List<PriEmailTargetListVO>
     * @exception EventException
     */
    public List<PriEmailTargetListVO> sendEmail(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
        try {
            TriPropSendMailVO sendMailVO = new TriPropSendMailVO();
            List<String> emailList = new ArrayList<String>();            
           
            // mail 대상 조회
            List<PriEmailTargetListVO> list = dbDao.searchEmailTargetUser(priRpMnVO);
            
            if (list != null && list.size() > 0) { 
	            // mail content
	            sendMailVO.setFromUser(account.getUsr_eml());
	            sendMailVO.setFromUserNm(account.getUsr_nm());
	            sendMailVO.setOfcCd(account.getOfc_cd());
	            
	            sendMailVO.setSubject("Notice of The RFA Approval("+list.get(0).getRfaNo()+")");
	            
	            StringBuilder sbHtmlContent = new StringBuilder();
	            sbHtmlContent.append("<html>");
	            sbHtmlContent.append("<head>");
	            sbHtmlContent.append("<title></title>");
	            sbHtmlContent.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">");
	            sbHtmlContent.append("<link rel=\"stylesheet\" href=\"include/style.css\" type=\"text/css\">");
	            sbHtmlContent.append("</head>");
	            sbHtmlContent.append("<table style=\"width:100%\" class=\"popup\" cellpadding=\"0\" border=\"0\">");
	            sbHtmlContent.append("<tr><td class=\"top\"></td></tr>");
	            sbHtmlContent.append("<tr><td valign=\"top\">");
	            sbHtmlContent.append("<table width=\"100%\" border=\"0\">");
	            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">To whom it may concerned</td></tr>");
	            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Notice of The RFA Approval<br><br></td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("<table class=\"search\">");
	            sbHtmlContent.append("<tr><td class=\"bg\">");    
	            sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
	            sbHtmlContent.append("<tr>");
	            sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");
	            
	            sbHtmlContent.append("Your contract ("+list.get(0).getRfaNo()+") for the following bookings has been amended by salesperson.<br>");
	            sbHtmlContent.append("Please, check and rerate it accordingly.<br><br>");
	            sbHtmlContent.append("Booking Number / Your ID (This mail is sent to all documentation staffs who have a B/L with the contract)<br><br>");
	            
	            // booking list 
	            sbHtmlContent.append("<table cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"#ffffff\" border=\"0\" style=\"width:100%;\">");          
	            for(int i=0;i<list.size();i++){
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 16px; padding-right:3px;\">"+list.get(i).getSeq()+". "+list.get(i).getBkgNo()+" / "+list.get(i).getUpdUsrId()+"</td></tr></table></td></tr>");
	            }
	            sbHtmlContent.append("</table><br>");
	        
	            sbHtmlContent.append("* This notification is automatically made by system when your contract is amended after your rating.<br>");
	            sbHtmlContent.append("Since the sender of your mail does not send the mail, you are not to reply to him and may figure out the amendment of contract thru ALPS on your own.<br>"); 
	            sbHtmlContent.append("* It may not be the amendment on amount of charges/surcharges.<br>"); 
	            
	            sbHtmlContent.append("<table class=\"search\" border=\"0\" style=\"width:100%;\">");
	            sbHtmlContent.append("<tr>");
	            sbHtmlContent.append("<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px;\"><br>Thank you.<br>");
	            sbHtmlContent.append("Best Regards,</td>");
	            sbHtmlContent.append("</tr>");
	            sbHtmlContent.append("</table>");            
	            sbHtmlContent.append("</td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("</td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("</html>");
	            sendMailVO.setHtmlContent(sbHtmlContent.toString());
	            
	            // mail 대상 Key(email send Seq) List 에 담기
	            String preUsrId = "";
	            for (int i = 0 ; i < list.size() ; i++) {            	
	            	if(!list.get(i).getUpdUsrId().equals(preUsrId)){
	                   emailList.add(list.get(i).getUsrEml());
	            	}            	
	            	preUsrId = list.get(i).getUpdUsrId();
	            }
	          
	              RFAProposalMainEAIDAO eaiDao = new RFAProposalMainEAIDAO();
	              eaiDao.sendEmail(sendMailVO, emailList);
           }
            
          return list; 
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("FMS01187",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("FMS01187",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * ESM_PRI_2003 : Requsest <br>
	 * RFA Type이 Contract 일때 마지막으로 actual customer가 commodity 별로 같은지 check<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception EventException
     */
    public String checkRfaContractTpActCust(PriRpMnVO priRpMnVO) throws EventException {
    	String checkRfaContractTp = "";
    	try {
    		checkRfaContractTp = dbDao.checkRfaContractTpActCust(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }   	
		return checkRfaContractTp;
    }
    
    /**
	 * ESM_PRI_2003 : Requsest <br>
	 * check Duration Basic Copy<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception EventException
     */
    public String checkExpDurationBasicRFACopy(PriRpMnVO priRpMnVO) throws EventException {
    	String checkRfaContractTp = "";
    	try {
    		checkRfaContractTp = dbDao.checkExpDurationBasicRFACopy(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }   	
		return checkRfaContractTp;
    }
    
	/**
	 * ESM_PRI_2003 : Approve Check <br>				
	 * Approve 이전에 Retroactive 대상이 존재하는지 체크<br>		
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
     */
    public String searchRetroactiveExistCheck(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {			
    	try {		
    		
			return dbDao.searchRetroactiveExistCheck(priRpMnVO, account);
			
		} catch (DAOException ex) {	
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);			
		} catch (Exception ex) {	
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);			
        }   			
    }
    
    /**
	 * ESM_PRI_2045 : onLoad시 조회 <br>				
	 * Approve 이전에 Retroactive RFA 사유 코드 조회<br>		

	 * @return List<PriRpRetroVO>
	 * @exception EventException
     */
    public List<PriRpRetroVO> searchRetroactiveRFANote()  throws EventException {			
    	try {		
    		
			return dbDao.searchRetroactiveRFANote();
			
		} catch (DAOException ex) {	
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);			
		} catch (Exception ex) {	
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);			
        }   			
    }


    /**
	 * ESM_PRI_2045 : Save <br>			
	 * Retroactive RFA 사유를 저장한다.<br>		
     * 
     * @param PriRpRetroVO priRpRetroVO
     * @param SignOnUserAccount account
     * @exception EventException
     */    
    public void manageRetroactiveRFANote(PriRpRetroVO priRpRetroVO, SignOnUserAccount account) throws EventException {
		try {
			priRpRetroVO.setCreUsrId(account.getUsr_id());
			priRpRetroVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addRetroactiveRFANote(priRpRetroVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}   	
    }
    
    
	// ============================ESM_PRI_2244_Start====================================
    /**				
	 * ESM_PRI_2244 : Retrieve <br>			
	 * RFA Proposal Creation [Copy]를 조회한다.<br>			
	 * 			
	 * @param RsltRoutHdrSmryListVO  rsltRoutHdrSmryListVO		
	 * @return  List<RsltRoutHdrSmryListVO> 			
	 * @exception EventException			
	 */	
	public List<RsltRoutHdrSmryListVO> rfaProposalCreationCopy(RsltRoutHdrSmryListVO  rsltRoutHdrSmryListVO) throws EventException {
		try {
			return dbDao.rfaProposalCreationCopy(rsltRoutHdrSmryListVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * Master RFA에서 Copy 후 RFA Main의 Duration 정보를 적용합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @param String svcScpCd
	 * @return String
	 * @exception EventException
	 */
	public String manageProposalMst(PriRpMnVO priRpMnVO, SignOnUserAccount account, String svcScpCd) throws EventException{
		String newPropNo = "";
		try {			
			PriRpHdrVO[] hdrVo = new PriRpHdrVO[1];
			PriRpMnVO[] vo = new PriRpMnVO[1];
			PriRpScpMnVO[] scpVo = new PriRpScpMnVO[1];
			
			hdrVo[0] = new PriRpHdrVO();
			vo[0] = new PriRpMnVO();
			scpVo[0] = new PriRpScpMnVO();
			
			ObjectCloner.build(priRpMnVO, hdrVo[0]);
			ObjectCloner.build(priRpMnVO, vo[0]);
			ObjectCloner.build(priRpMnVO, scpVo[0]);
			
			List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpScpMnVO> updateScpVoList = new ArrayList<PriRpScpMnVO>();
		
			newPropNo = priRpMnVO.getPropNo();

			hdrVo[0].setPrcPropCreTpCd("G");
			hdrVo[0].setUpdUsrId(account.getUsr_id());
			hdrVo[0].setPropPrprFlg("Y");
			updateHdrVoList.add(hdrVo[0]);
			
			vo[0].setUpdUsrId(account.getUsr_id());				
			updateVoList.add(vo[0]);
			
			scpVo[0].setUpdUsrId(account.getUsr_id());
			scpVo[0].setSvcScpCd(svcScpCd);
			updateScpVoList.add(scpVo[0]);
			
			if ( updateHdrVoList.size() > 0 ) {
				dbDao.modifyProposalHeader(updateHdrVoList);
			}
			
			//기존 mn 에 대한 update
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}		
			
			// 기존 scp mn 이 update
			if ( updateScpVoList.size() > 0 ) {
				dbDao.modifyProposalScopeMain(updateScpVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
		return newPropNo;
	}
	// ============================ESM_PRI_2244_End====================================
	
	/**
	 * RFA main의 Approve를 진행합니다.<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposalBasic(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		String rfaNo = "";
		try {
			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();			
			PriRpHdrVO[] hVo = rfaPropProgVO.getPriRpHdrVOs();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();	
			
			//승인시 승인자정보를 Master 승인자로 대치함.
			String propNo = vo[0].getPropNo();
			String amdtSeq = vo[0].getAmdtSeq();
			String propAproOfcCd 	= dbDao.searchMstAproOfcRslt( propNo , amdtSeq );
			String progUsrId 			= dbDao.searchMstAproUsrRslt( propNo , amdtSeq );
			if(propAproOfcCd == null || propAproOfcCd.equals("")){
				propAproOfcCd = account.getOfc_cd();
			}
			if(progUsrId == null || progUsrId.equals("")){
				progUsrId = account.getUsr_id();
			}
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
					vo[i].setPropAproOfcCd(propAproOfcCd);	
					vo[i].setPropAproDt(account.getUpd_dt());	
					vo[i].setUpdUsrId(progUsrId);					
					vo[i].setPropAproOfcCd(propAproOfcCd);
					vo[i].setPropAproDt(account.getUpd_dt());		
					vo[i].setPropStsCd("A");
					
					updateVoList.add(vo[i]);
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
					pVo[i].setUpdUsrId(progUsrId);	
					pVo[i].setCreUsrId(progUsrId);	
					pVo[i].setProgUsrId(progUsrId);	
					pVo[i].setProgOfcCd(propAproOfcCd);	
					pVo[i].setProgDt(account.getUpd_dt());	
					pVo[i].setPropStsCd("A");
								
					insertVoList.add(pVo[i]);
				} 
			}			
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);	
			//APPROVAL DATE
			dbDao.modifyProposalApprovalDate(updateVoList);
			
			if (vo[0].getAmdtSeq().equals("0") && hVo[0].getRfaNo().equals("") ){
				PriRpHdrVO hdrVo = new PriRpHdrVO();
				List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();				
				hdrVo.setUpdUsrId(account.getUsr_id());
				
				//choi
				//------------------//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
				rfaNo = dbDao.searchMstCreationRFANo(vo[0].getPropOfcCd(), vo[0].getRfaCtrtTpCd() );	
//				rfaNo = dbDao.searchCreationRFANo(vo[0].getPropOfcCd());	//--이전것 생성.
				
				
				hdrVo.setRfaNo(rfaNo);
				hdrVo.setPropNo(vo[0].getPropNo());
				updateHdrVoList.add(hdrVo);
				dbDao.modifyProposalRFANO(updateHdrVoList);//RFA No Update				
			}
			
			/////////////////////////////main exp_dt변경
			List<PriRpMnVO> insertMnVoList = new ArrayList<PriRpMnVO>();
			PriRpMnVO mnVo = new PriRpMnVO();
			ObjectCloner.build(vo[0], mnVo);
			mnVo.setAmdtSeq(String.valueOf(Integer.valueOf(vo[0].getAmdtSeq())-1));
			
			insertMnVoList.add(mnVo);
			dbDao.modifyProposalMainAmend(insertMnVoList);
			dbDao.modifyProposalScopeMainAmend(insertMnVoList);	
			/////////////////////////////
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return rfaNo;
	}
	

	/**
	 * Master RFA에서 Accept 가 되었는지 Terms를 조회 합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception EventException
	 */
	public List<PriRpMnVO> searchProposalAcceptCheckMst(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalAcceptCheckMst(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Master RFA에서 Approval Cancel 시  자식 Basic이 있는지 여부 체크 합니다. <br>
	 * 데이터가 있다면 화면에서 경고 alert 발생합니다.<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalCancelCheckChildren(PriRpHdrVO priRpHdrVO) throws EventException {
		try {
			return dbDao.searchApprovalCancelCheckChildren(priRpHdrVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Approved Basic RFA 조회 시 Master RFA를 체크해서 Master의 AMD No.가 변경되었는지 체크한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String checkBasicAmendable(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.checkBasicAmendable(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Basic RFA Amend 시 승인된 최종버전 Master RFA 정보를 조회한다.<br>
	 * 
	 * @param String
	 * @return List<PriRpScpMnVO>
	 * @exception EventException
	 */
	public List<PriRpScpMnVO> searchApprovedMstInfo(String mstRfaNo) throws EventException {
		try {
			return dbDao.searchApprovedMstInfo(mstRfaNo);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
    /**
     * Basic RFA의 Proposal No로 Master RFA의 Propsal no를 조회한다.<br>
     * 
     * @param PriRpMnVO priRpMnVO
     * @return List<MasterInfoFromBasicVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<MasterInfoFromBasicVO> searchMasterInfoFromBasicRFA(PriRpMnVO priRpMnVO) throws EventException {
        try {
            return dbDao.searchMasterInfoFromBasicRFA(priRpMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
	
}