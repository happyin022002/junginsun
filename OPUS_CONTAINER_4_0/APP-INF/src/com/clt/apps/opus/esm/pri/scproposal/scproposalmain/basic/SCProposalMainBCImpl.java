/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainBCImpl.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltReturnVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration.SCProposalMainDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ChkScNoVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstPriSpHdrVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstRequestCheckVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstShHistVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstShInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RequestCheckForCalculationVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltAmdtHisMnVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltExpChkVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltMainStsVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltMdmOrganizationVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPriSpAmdHstMnVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPriSpInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropAmdtSmryVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropInqListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropMnScpListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltStatusVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropProgVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgGrpCmdtVO;
import com.clt.syscommon.common.table.PriSpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriSpHdrVO;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpProgVO;
import com.clt.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpScpDurVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpProgVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0003EventResponse,SCProposalMainBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class SCProposalMainBCImpl extends BasicCommandSupport implements SCProposalMainBC {  

	// Database Access Object
	private transient SCProposalMainDBDAO dbDao = null;

	/**
	 * Creating SCProposalMainBCImpl object<br>
	 * Creating SCProposalMainDBDAO<br>
	 */
	public SCProposalMainBCImpl() {
		dbDao = new SCProposalMainDBDAO();
	}

	/**
	 * Retrieving S/C Proposal Main information<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMain(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropListVO vo = new RsltPropListVO();
			
			// Checking whether account is under HQ Office
			RsltMdmOrganizationVO orgVO = dbDao.searchMemOrganization(account);
			vo.setRsltPropMnVOs(dbDao.searchProposalMain(priSpHdrVO,orgVO, account));
			vo.setRsltPropMnScpListVOs(dbDao.searchProposalMainScpList(priSpHdrVO, account));			

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Saving S/C Main information.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageProposal(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		String newPropNo = "";
		try {			
			PriSpHdrVO[] hdrVo = scPropMnVO.getPriSpHdrVOs();
			PriSpMnVO[] vo = scPropMnVO.getPriSpMnVOs();
			PriSpProgVO[] progVo = scPropMnVO.getPriSpProgVOs();
			PriSpAmdtSmryVO[] smryVo = scPropMnVO.getPriSpAmdtSmryVOs();
			PriSpScpMnVO[] scpVo = scPropMnVO.getPriSpScpMnVOs();
			PriSpScpProgVO[] scpProgVo = scPropMnVO.getPriSpScpProgVOs();
			PriSpScpAmdtSmryVO[] scpSmryVo = scPropMnVO.getPriSpScpAmdtSmryVOs();			
			PriSpCtrtPtyVO[] ptyVo = scPropMnVO.getPriSpCtrtPtyVOs();	
			List<PriSpHdrVO> insertHdrVoList = new ArrayList<PriSpHdrVO>();
			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			List<PriSpProgVO> insertProgVoList = new ArrayList<PriSpProgVO>();
			List<PriSpAmdtSmryVO> insertSmryVoList = new ArrayList<PriSpAmdtSmryVO>();
			List<PriSpScpMnVO> insertScpVoList = new ArrayList<PriSpScpMnVO>();
			List<PriSpScpProgVO> insertScpProgVoList = new ArrayList<PriSpScpProgVO>();
			List<PriSpScpAmdtSmryVO> insertScpSmryVoList = new ArrayList<PriSpScpAmdtSmryVO>();
			List<PriSpHdrVO> updateHdrVoList = new ArrayList<PriSpHdrVO>();
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			List<PriSpScpMnVO> updateScpVoList = new ArrayList<PriSpScpMnVO>();
		
			newPropNo = dbDao.searchCreationProposalNo(vo[0].getPropOfcCd());
			for ( int i = 0; hdrVo != null && i < hdrVo.length; i++ ) {
			    if (JSPUtil.getNull(hdrVo[i].getPrcPropCreTpCd()).equals("")) {
			        hdrVo[i].setPrcPropCreTpCd("G");
			    }
                if (JSPUtil.getNull(hdrVo[i].getPrcMstPropTpCd()).equals("")) {
                    hdrVo[i].setPrcMstPropTpCd("P");
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
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug("getRealCustCntCd======"+vo[0].getRealCustCntCd());
			log.debug("getRealCustSrepCd====="+vo[0].getRealCustSrepCd());
			log.debug("getRealCustSlsOfcCd====="+vo[0].getRealCustSlsOfcCd());
			log.debug("                                                      ");
			log.debug("setRespbSrepCd=========="+vo[0].getRespbSrepCd() );
			log.debug("setRespbSlsOfcCd========"+vo[0].getRespbSlsOfcCd());
			log.debug("                                                      ");			
			log.debug("getCtrtCustSrepCd======="+ptyVo[0].getCtrtCustSrepCd());
			log.debug("getCtrtCustSrepCd======="+ptyVo[0].getCtrtCustSlsOfcCd());
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			
			////////////////////////////////////////////////////////////////////////////////////////
//			for ( int i = 0; vo != null && i < vo.length; i++ ) {
//				if ( vo[i].getIbflag().equals("I")){
//					vo[i].setPropNo(newPropNo);	
//					vo[i].setCreUsrId(account.getUsr_id());
//					vo[i].setUpdUsrId(account.getUsr_id());	
//					if (vo[i].getAmdtSeq().equals("0")){
////						log.debug(" amdt_seq=0");
//						if (vo[i].getRealCustCntCd().equals("")){
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}
//						}else{
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}else{
//								vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
//							}
//						}
//					}else{
////						log.debug(" amdt_seq != 0");
//						if (vo[i].getRespbSrepCd().equals("")){
//							vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//							vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//						}
//					}
//					insertVoList.add(vo[i]);
//				} else if ( vo[i].getIbflag().equals("U")){
//					vo[i].setUpdUsrId(account.getUsr_id());
//					if (vo[i].getAmdtSeq().equals("0")){
////						log.debug(" amdt_seq=0");
//						if (vo[i].getRealCustCntCd().equals("")){
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}
//						}else{
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}else{
//								vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
//							}
//						}
//					}else{
//
////						if (vo[i].getRespbSrepCd().equals("")){
////							vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
////							vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
////						}
//						if (vo[i].getRealCustCntCd().equals("")){
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}
//						}else{
//							if (vo[i].getRealCustSrepCd().equals("")){
//								vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
//							}else{
//								vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
//								vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
//							}
//						}						
//						
//					}					
//					if (vo[i].getRealCustCntCd().equals("") || vo[i].getRealCustSeq().equals("")){
//						vo[i].setRealCustCntCd("XX"); //값이 비어 있다면 real customer 빈값으로 update
//					}
//					if (vo[i].getSlsLdNo().equals("")){
//						vo[i].setSlsLdNo("XX");
//					}
//					updateVoList.add(vo[i]);
//				} 
//			}			
			////////////////////////////////////////////////////////////////////////////////////////
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setPropNo(newPropNo);	
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());	

					if (vo[i].getRealCustCntCd().equals("")){
						vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
						vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
					}else{
						if (vo[i].getRealCustSrepCd().equals("")){
							vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
							vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
						}else{
							vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
							vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
						}
					}

					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());

					if (vo[i].getRealCustCntCd().equals("")){
						vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
						vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());					
					}else{
						if (vo[i].getRealCustSrepCd().equals("")){
							vo[i].setRespbSrepCd(ptyVo[i].getCtrtCustSrepCd()) ;
							vo[i].setRespbSlsOfcCd(ptyVo[i].getCtrtCustSlsOfcCd());
						}else{
							vo[i].setRespbSrepCd(vo[i].getRealCustSrepCd()) ;
							vo[i].setRespbSlsOfcCd(vo[i].getRealCustSlsOfcCd());
						}
					}								
					
					if (vo[i].getRealCustCntCd().equals("") || vo[i].getRealCustSeq().equals("")){
						vo[i].setRealCustCntCd("XX"); //Updating real customer as dummy code in case of no value
					}
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
			
			//In case of creation MN
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalHeader(insertHdrVoList);
				dbDao.addProposalMain(insertVoList);
				dbDao.addProposalProgress(insertProgVoList);
				dbDao.addProposalAmendmentSummary(insertSmryVoList);
			}
			
			if ( updateHdrVoList.size() > 0 ) {
				dbDao.modifyProposalHeader(updateHdrVoList);
			}			

			//Updating for existed mn
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}

			// in case of adding scp mn 
			if ( insertScpVoList.size() > 0 ) {
				dbDao.addProposalScopeMain(insertScpVoList);
				dbDao.addProposalScopeProgress(insertScpProgVoList);
				dbDao.addProposalScopeAmendmentSummary(insertScpSmryVoList);
			}
			
			// update existed scp mn
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
	 *   Retrieving Amend Request information<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltPropAmdtListVO>
	 * @exception EventException
	 */
	public List<RsltPropAmdtListVO> searchProposalAmendList (PriSpHdrVO priSpHdrVO) throws EventException {
		try {
			return dbDao.searchProposalAmendList (priSpHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Requesting amendment<br>
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
			priSpMnVO.setPropOfcCd(account.getOfc_cd());
			insertVoList.add(priSpMnVO);
		
			dbDao.addProposalMainAmend(priSpMnVO);
			dbDao.addProposalScopeMainAmend(insertVoList);
			
//			dbDao.modifyProposalMainAmend(insertVoList);			
//			dbDao.modifyProposalScopeMainAmend(insertVoList);	
			dbDao.addProposalProgressAmend(insertVoList);
			dbDao.addProposalAmendmentSummaryAmend(insertVoList);
			dbDao.addProposalScopeProgressAmend(insertVoList);
			dbDao.addProposalScopeAmendmentSummaryAmend(insertVoList);
			
// pri_sp_prog  insert
// pri_sp_amdt_smry  insert
// pri_sp_scp_prog  insert
// pri_sp_scp_amdt_smry  insert
			
	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Retrieving TPW Group Commodity Guideline Effective Date <br>
	 * 
	 * @param rsltPriSgGrpCmdtVO   RsltPriSgGrpCmdtVO
	 * @return List<String>
	 * @exception EventException
	 */
//	public PriSpScpMnVO searchGRIGroupCommodityEffectiveDt (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws EventException {
//		try {
//			return dbDao.searchGRIGroupCommodityEffectiveDt (rsltPriSgGrpCmdtVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//	}

	/**
	 * Retrieving TPW Group Commodity Guideline List <br>
	 * 
	 * @param RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriSgGrpCmdtVO> searchGRIGroupCommodityList (RsltPriSgGrpCmdtVO rsltPriSgGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGRIGroupCommodityList (rsltPriSgGrpCmdtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * Modifying S/C Proposal Master Creation's status<br>
	 * 
	 * @param ScPropProgVO scPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void counterofferProposal(ScPropProgVO scPropProgVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpMnVO[] vo =  scPropProgVO.getPriSpMnVOs();
//			log.debug("=====count bc ibflag==="+vo[0].getIbflag() );
			PriSpProgVO[] pVo = scPropProgVO.getPriSpProgVOs();
			
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();			
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
     * Changing S/C Proposal Master Creation's status to Approve.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void approveProposal(ScPropProgVO scPropProgVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpMnVO[] vo =  scPropProgVO.getPriSpMnVOs();
			PriSpProgVO[] pVo = scPropProgVO.getPriSpProgVOs();
			
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();			
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
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
			//approval date update
			dbDao.modifyProposalApprovalDate(updateVoList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
    /**
     * Changing S/C Proposal Master Creation's status to previous status.<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void cancelProposal(ScPropProgVO scPropProgVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpMnVO[] vo =  scPropProgVO.getPriSpMnVOs();
			PriSpProgVO[] pVo = scPropProgVO.getPriSpProgVOs();
//			PriSpHdrVO hdrVo =  new PriSpHdrVO();// 
			
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();	
//			List<PriSpHdrVO> updateHdrVoList = new ArrayList<PriSpHdrVO>();
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
//					if (vo[i].getPropStsCd().equals("Q") && vo[i].getAmdtSeq().equals("0")){
//						hdrVo.setPropNo(vo[i].getPropNo());
//						hdrVo.setScNo("INIT");
//						hdrVo.setUpdUsrId(account.getUsr_id());
//						updateHdrVoList.add(hdrVo);
//					}
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
			
//			dbDao.modifyProposalHeader(updateHdrVoList);
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);		
			//approval date update
			log.debug("modifyProposalApprovalDate===================>");
			log.debug(vo[0].getPropStsCd());
			log.debug("modifyProposalApprovalDate===================>");
			if (vo[0].getPropStsCd().equals("Q")){
				dbDao.modifyProposalApprovalDate(updateVoList);	
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
     * Modifying terms summary information by scope when modifying terms data<br>
     *
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
			//Scope Main의 status를 변경한다.
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
     * Modifying terms summary information by scope when modifying terms status<br>
     *
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageScopeAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
			dbDao.modifyProposalScopeStatus(updateVoList);
						
            PriSpScpMnVO scpVo = new PriSpScpMnVO();
            ObjectCloner.build(vo, scpVo);
            int cnt = dbDao.searchProposalScopeAcceptCheck(scpVo);
            
            if (cnt == 0){//scope status accept change
                PriSpScpMnVO[] priSpScpMnVO = new PriSpScpMnVO[1];
                priSpScpMnVO[0] = new PriSpScpMnVO();
                ObjectCloner.build(scpVo, priSpScpMnVO[0]);
                priSpScpMnVO[0].setPropScpStsCd("A");//Chaking to Accept
                
    			List<PriSpScpMnVO> updateScpVoList = new ArrayList<PriSpScpMnVO>();
    			List<PriSpScpProgVO> insertProgVoList =  new ArrayList<PriSpScpProgVO>(); 
    			
    			priSpScpMnVO[0].setUpdUsrId(account.getUsr_id());
    			updateScpVoList.add(priSpScpMnVO[0]);
    			
    			PriSpScpProgVO progVo = new PriSpScpProgVO();
				ObjectCloner.build(priSpScpMnVO[0], progVo);
				progVo.setProgOfcCd(account.getOfc_cd());	
				progVo.setProgUsrId(account.getUsr_id());
				progVo.setCreUsrId(account.getUsr_id());
				insertProgVoList .add(progVo);	
				
    			if ( updateVoList.size() > 0 ) {				
    				dbDao.modifymanageScopeStatus(updateScpVoList);
    			}    			
    			//Changing pregress     			
    			if ( insertProgVoList.size() > 0 ) {				
    				log.debug("progvo propno============"+progVo.getPropNo());
    				dbDao.addProposalScopeProgress(insertProgVoList);
    			}                
            }else{
            	scpVo.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyAutoScopeReturnStatus (scpVo);
				List<PriSpScpProgVO> insertProgVoList =  new ArrayList<PriSpScpProgVO>(); 
				if (dbDao.searchScopeProgressStatus(scpVo) == 0){
					//Inserting to prog in case of prog status != Mn status
					PriSpScpProgVO spScpProgVo = new PriSpScpProgVO();
					ObjectCloner.build(scpVo, spScpProgVo);
					spScpProgVo.setProgOfcCd(account.getOfc_cd());	
					spScpProgVo.setProgUsrId(account.getUsr_id());
					spScpProgVo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(spScpProgVo);	
					if ( insertProgVoList.size() > 0 ) {				
						dbDao.addProposalScopeProgressScopeMn(insertProgVoList);
					}						
				}
            	
            }
                        
            PriSpMnVO mnVo = new PriSpMnVO();
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
     * Modifying summary information about auto-accepted items when requesting S/C Proposal Request.<br>
     *  
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalScopeAutoAcceptAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("Y");
			vo.setSvcScpCd("");
			updateVoList.add(vo);
			if (vo.getPropScpTermTpCd().equals("31")){
				dbDao.modifyProposalScopeAutoAcceptNoteAmendmentSummary(updateVoList);				
			}else{
				dbDao.modifyProposalScopeAutoAcceptAmendmentSummary(updateVoList);	
			}
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
     * Rollback auto-accepted items to previous status when canceling Request(Scope)<br>
     *
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalScopeRequestCancelAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
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
     *Rollback auto-accepted items to previous status when canceling Request(Scope)<br>
     *
     * @param PriSpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalAutoScopeRequestCancelAmendmentSummary(PriSpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);			
			dbDao.modifyProposalAutoScopeRequestCancelAmendmentSummary(updateVoList);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
    /**
     * Modifying terms summary information when modifying Terms status<br>
     *
     * @param PriSpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalAmendmentSummary(PriSpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpAmdtSmryVO> updateVoList = new ArrayList<PriSpAmdtSmryVO>();
		
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
     * Modifying terms summary information when modifying Terms status<.<br> 
     * Modifying main's status to "request" inf all terms is accepted in case main's status is "returned"<br>
     * @param PriSpAmdtSmryVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageAmendmentSummary(PriSpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpAmdtSmryVO> updateVoList = new ArrayList<PriSpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			dbDao.modifyProposalAmendmentSummary(updateVoList);
			
			PriSpMnVO  mnVo = new PriSpMnVO();
			mnVo.setPropNo(vo.getPropNo());
			mnVo.setAmdtSeq(vo.getAmdtSeq());
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
     * Modifying accept status when cancelling Request<br>
	 * 
	 * @param PriSpAmdtSmryVO vo
	 * @param List<String> termList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(PriSpAmdtSmryVO vo, List<String> termList, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpAmdtSmryVO> updateVoList = new ArrayList<PriSpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("Y");
			updateVoList.add(vo);
			
			dbDao.modifyProposalAutoAcceptAmendmentSummary(updateVoList,termList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	 
	
	
	/**
     * Rollbacking auto-accepted items to "init" status when canceling Request<br>
	 * 
	 * @param PriSpAmdtSmryVO vo
	 * @param List<String> termList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAutoRequestCancelAmendmentSummary(PriSpAmdtSmryVO vo, List<String> termList,SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpAmdtSmryVO> updateVoList = new ArrayList<PriSpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);
			
			dbDao.modifyProposalAutoRequestCancelAmendmentSummary(updateVoList,termList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 *  Retrieving S/C Proposal Customer information<br>
	 * 
	 * @param SchCustVO schCustVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception EventException
	 */
	public List<RsltPropCustInfoVO> searchProposalCustomerInfo(SchCustVO schCustVO) throws EventException {
		try {
			return dbDao.searchProposalCustomerInfo(schCustVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	//------------------JIN START---------------------------------------
    /**
     * Retrieving S/C Proposal Boiler Plate/Affiliate's Copied information.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @return List<RsltPropCopyVO>
     * @exception EventException
     */
    public List<RsltPropCopyVO> searchProposalCopyBlplAfilList (RsltPropCopyVO rsltPropCopyVO) throws EventException {
        try {
            return dbDao.searchProposalCopyBlplAfilList (rsltPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Retrieving S/C Proposal Main/Scope's Copy information .<br>
	 * 
	 * @param RsltPropCopyVO rsltPropCopyVO
	 * @return List<RsltPropCopyVO>
	 * @exception EventException
	 */
	public List<RsltPropCopyVO> searchProposalCopyList (RsltPropCopyVO rsltPropCopyVO) throws EventException {
		try {
			return dbDao.searchProposalCopyList (rsltPropCopyVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Copying S/C Proposal Main information<br>
	 * 
	 * @param RsltPropCopyVO rsltPropCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyProposalMain(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
            rsltPropCopyVO.setCreUsrId(account.getUsr_id());
            rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
            rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            rsltPropCopyVO.setSrepCd(account.getSrep_cd());
            // PRI_SP_HDR COPY
            dbDao.addCopyProposalHdr(rsltPropCopyVO);

            // PRI_SP_MN COPY
            dbDao.addCopyProposalMain(rsltPropCopyVO);
            
            // PRI_SP_AMDT_SMRY
            PriSpAmdtSmryVO priSpAmdtSmryVO = new PriSpAmdtSmryVO();
            priSpAmdtSmryVO.setPropNo(rsltPropCopyVO.getNewPropNo());
            priSpAmdtSmryVO.setAmdtSeq("0");
            priSpAmdtSmryVO.setCreUsrId(account.getUsr_id());
            priSpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            dbDao.addProposalAmendmentSummary(priSpAmdtSmryVO);

            // PRI_SP_PROG
            dbDao.addCopyProposalProg(rsltPropCopyVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

    /**
     * Modifying S/C Proposal Main Amendment Summary<br>
     * 
     * @param PriSpAmdtSmryVO priSpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void manageProposalAmendmentSummaryAll(PriSpAmdtSmryVO priSpAmdtSmryVO, SignOnUserAccount account) throws EventException{
        try {
//            PriSpAmdtSmryVO priSpAmdtSmryVO = null;
            priSpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01737",0);
            
            for (int j = 0, m = cdList.size(); j < m; j++) {
                priSpAmdtSmryVO.setPropTermTpCd(cdList.get(j).getCode());
                dbDao.modifyProposalAmendmentSummary(priSpAmdtSmryVO);
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
     * Retrieving new proposal number when copying S/C Proposal<br>
     * 
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String searchMaxPropNo (SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchCreationProposalNo(account.getOfc_cd());
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }
	//------------------JIN END---------------------------------------
    
	/**
     * Retrieving Terms's Summary information<br>
	 * 
	 * @param PriSpAmdtSmryVO priSpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception EventException
	 */
	
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriSpAmdtSmryVO priSpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalAmendmentSummary(priSpAmdtSmryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
     * Retrieving Scope Terms's Summary information<br>
	 * 
	 * @param PriSpScpAmdtSmryVO priSpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAmendmentSummary(priSpScpAmdtSmryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    

    /**
     * Copying S/C Proposal Scope information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMain(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_MN COPY
            dbDao.addCopyProposalScopeMain(vo);
            
            List<PriSpScpProgVO> progList = new ArrayList<PriSpScpProgVO>();
            PriSpScpProgVO scpVo = new PriSpScpProgVO();
            scpVo.setPropNo(vo.getNewPropNo());
            scpVo.setAmdtSeq("0");
            scpVo.setSvcScpCd(vo.getSvcScpCd());
            scpVo.setPropScpStsCd("I");
            scpVo.setProgUsrId(account.getUsr_id());
            scpVo.setProgOfcCd(account.getOfc_cd());
            scpVo.setCreUsrId(account.getUsr_id());
            scpVo.setUpdUsrId(account.getUsr_id());
            progList.add(scpVo);
            
            // PRI_SP_SCP_PROG
            dbDao.addProposalScopeProgress(progList);
            
            List<PriSpScpAmdtSmryVO> smryList = new ArrayList<PriSpScpAmdtSmryVO>();
            PriSpScpAmdtSmryVO smVo = new PriSpScpAmdtSmryVO();
            smVo.setPropNo(vo.getNewPropNo());
            smVo.setAmdtSeq("0");
            smVo.setSvcScpCd(vo.getSvcScpCd());
            smVo.setCreUsrId(account.getUsr_id());
            smVo.setUpdUsrId(account.getUsr_id());
            smryList.add(smVo);
            
            // PRI_SP_SCP_AMDT_SMRY INSERT
            dbDao.addProposalScopeAmendmentSummary(smryList);
            
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }

    /**
     * Saving Proposal Scope Amendment Summary data<br>
     * 
     * @param RsltPropCopyVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void copyProposalScopeAmdtSmry(RsltPropCopyVO[] vos, SignOnUserAccount account) throws EventException{
        try {
//            List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();
            PriSpScpAmdtSmryVO smVo = new PriSpScpAmdtSmryVO();
            
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01738",0);
            
            for (int i = 0, n = vos.length; i < n; i++) {
                for (int j = 0, m = cdList.size(); j < m; j++) {
                    smVo = new PriSpScpAmdtSmryVO();
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
     * Retrieving informations to be copied for guideline<br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return List<SpScpGlineCopyVO>
     * @exception EventException
     */
    public List<SpScpGlineCopyVO> searchGuidelineCopyCheck(SpScpGlineCopyVO spScpGlineCopyVO) throws EventException {
        try {
            return dbDao.searchGuidelineCopyCheck(spScpGlineCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Request gline_seq of guideline to be copied<br>
     * 
     * @param SpScpGlineCopyVO spScpGlineCopyVO
     * @return String
     * @exception EventException
     */
    public String searchCopyGlineSeq(SpScpGlineCopyVO spScpGlineCopyVO) throws EventException {
        try {
            return dbDao.searchCopyGlineSeq(spScpGlineCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Updating Proposal Scope Main's note_hdr_seq column.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyScpMnNoteHdrSeqGlineCopy (SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            
            dbDao.modifyScpMnNoteHdrSeqGlineCopy(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }

    /**
     * Updating Proposal Scope Amendment Summary <br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void copyScopeGuidelineScopeAmdtSmry(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
//            List<PriSpScpAmdtSmryVO> updateVoList = new ArrayList<PriSpScpAmdtSmryVO>();
            PriSpScpAmdtSmryVO smVo = new PriSpScpAmdtSmryVO();
            
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01738",0);
            
            for (int i = 0, m = cdList.size(); i < m; i++) {
                smVo = new PriSpScpAmdtSmryVO();
                smVo.setPropNo(vo.getPropNo());
                smVo.setAmdtSeq(vo.getAmdtSeq());
                smVo.setSvcScpCd(vo.getSvcScpCd());
                smVo.setPropScpTermTpCd(cdList.get(i).getCode());
                smVo.setUpdUsrId(account.getUsr_id());
//                updateVoList.add(smVo);
                dbDao.modifyProposalScopeAmendmentSummary(smVo);
            }

//            dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }
    
	/**
     * Checking whether terms is accepted or not to modify Main's status to Approve<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<PriSpMnVO>
	 * @exception EventException
	 */
	public List<PriSpMnVO> searchProposalAcceptCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalAcceptCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    
	
	
	/**
     * Retrieving Main's status.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltMainStsVO>
	 * @exception EventException
	 */
	public List<RsltMainStsVO> searchProposalMainStatus(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalMainStatus(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	} 	
	
	
	/**
     * modifying Scope status by Scope<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyScopeStatus(PriSpScpMnVO[] priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpMnVO> updateVoList = new ArrayList<PriSpScpMnVO>();
			List<PriSpScpProgVO> insertProgVoList =  new ArrayList<PriSpScpProgVO>(); 
			
			for ( int i=0; i<priSpScpMnVO .length; i++ ) {
				if ( priSpScpMnVO[i].getIbflag().equals("U")){
					priSpScpMnVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpMnVO[i]);
					PriSpScpProgVO vo = new PriSpScpProgVO();
					ObjectCloner.build(priSpScpMnVO[i], vo);
					vo.setProgOfcCd(account.getOfc_cd());	
					vo.setProgUsrId(account.getUsr_id());
					vo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(vo);					
				}
			}		
			
			if ( updateVoList.size() > 0 ) {				
				dbDao.modifymanageScopeStatus(updateVoList);
			}
			//pregress modification		
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
	 * Modifying Scope status.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAllScopeStatus(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {				
			priSpScpMnVO.setUpdUsrId(account.getUsr_id());
			priSpScpMnVO.setPropScpStsCd("I");
			dbDao.modifymanageAllScopeStatus(priSpScpMnVO);
			
			PriSpScpProgVO vo = new PriSpScpProgVO();
			ObjectCloner.build(priSpScpMnVO, vo);
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
     * Updating Proposal Main's  Status column.<br>
     * 
     * @param PriSpMnVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyMainStatus (PriSpMnVO vo, SignOnUserAccount account) throws EventException {
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
	 * Checking whether all terms is accepted or not <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeAcceptCheck(PriSpScpMnVO  priSpScpMnVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAcceptCheck(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}        
	
	
	/**
	 * Retrieving Scope's status.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return List<PriSpScpMnVO>
	 * @exception EventException
	 */
	public List<PriSpScpMnVO> searchProposalScopeStatusCheck(PriSpScpMnVO  priSpScpMnVO) throws EventException {
		try {
			return dbDao.searchProposalScopeStatusCheck(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}      
	
	/**
	 * Deleting all related data when related amend seq when deleting Scope<br>
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeAmdtSmry(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeAmdtSmry(priSpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
	 * Deleteing all data with related amend seq when canceling init<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalAmdtSmry(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalAmdtSmry(priSpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
    
	/**
	 * Deleteing all data with related amend seq when deleting scope <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeProgress(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeProgress(priSpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
	 * Deleteing all data with related amend seq when canceling init <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalProgress(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalProgress(priSpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	/**
	 * Deleteing all data with related amend seq when canceling init <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeMain(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeMain(priSpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	    
	/**
     * Retrieving current filed data and previous filed date<br>
	 * 
	 * @param CstPriSpMnFileDtVO cstPriSpMnFileDtVO
	 * @param SignOnUserAccount account
	 * @return List<CstPriSpMnFileDtVO>
	 * @exception EventException
	 */
	public List<CstPriSpMnFileDtVO> searchProposalFilingList (CstPriSpMnFileDtVO cstPriSpMnFileDtVO, SignOnUserAccount account) throws EventException {
		try {
			cstPriSpMnFileDtVO.setPropOfcCd(account.getOfc_cd());
			return dbDao.searchProposalFilingList (cstPriSpMnFileDtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
     * Filing Proposal<br>
	 * 
	 * @param CstPriSpMnFileVO cstPriSpMnFileVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalFiling(CstPriSpMnFileVO cstPriSpMnFileVO, SignOnUserAccount account) throws EventException{
	
		try {			

			List<PriSpMnVO > updateVoList = new ArrayList<PriSpMnVO >();
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();	
			
//			cstPriSpMnFileVO.setUpdUsrId(account.getUpd_usr_id());		
			cstPriSpMnFileVO.setUpdUsrId(account.getUsr_id());
			cstPriSpMnFileVO.setPropStsCd("F");
			PriSpMnVO mnVO = new PriSpMnVO();
			ObjectCloner.build(cstPriSpMnFileVO, mnVO);
			updateVoList.add(mnVO);
			
			PriSpProgVO vo = new PriSpProgVO();
			vo.setAmdtSeq(cstPriSpMnFileVO.getAmdtSeq());
			vo.setPropNo(cstPriSpMnFileVO.getPropNo());
			vo.setPropStsCd("F");
			vo.setProgUsrId(account.getUsr_id());
			vo.setProgOfcCd(account.getOfc_cd());
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			insertVoList.add(vo);


			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);//status change
				dbDao.addProposalProgress(insertVoList);

				//changing all without comparison with eff_dt and file dt according user's choice
				if (cstPriSpMnFileVO.getEffDtChg().equals("Y")){
					dbDao.modifyProposalMainFile(updateVoList);
					dbDao.modifyProposalScopeMainFile(updateVoList);
				}

			}
		

			dbDao.modifyProposalMainAmend(updateVoList);
			dbDao.modifyProposalScopeMainAmend(updateVoList);	

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
	}		
	
	/**
     * Retrieving Proposal Scope List<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPropMnScpListVO>
	 * @exception EventException
	 */
	public List<RsltPropMnScpListVO> searchProposalMainScpList(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchProposalMainScpList (priSpHdrVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
     * Checking whether terms with "init" exists or not to put in action C/offer<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltStatusVO>
	 * @exception EventException
	 */
	public List<RsltStatusVO> searchCountOfferStatus(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchCountOfferStatus(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
			
	
	/**
	 * Checking whether terms data exists or not when deleting Scope<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriSpScpMnVO  priSpScpMnVO) throws EventException {
		try {
			return dbDao.searchProposalScopeDeleteCheck(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   
	
	/**
     * Saving S/C Number<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createaProposalSCNumber (PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpHdrVO> updateVoList = new ArrayList<PriSpHdrVO>();

			priSpHdrVO.setCreUsrId(account.getUsr_id());
			priSpHdrVO.setUpdUsrId(account.getUsr_id());

			updateVoList.add(priSpHdrVO);
		
			dbDao.modifyProposalHeader(updateVoList);
			
	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
    /**
     * Checking duplication before saving S/C Number <br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @return List<PriSpHdrVO>
     * @exception EventException
     */
    public List<PriSpHdrVO> checkProposalSCNumber (PriSpHdrVO priSpHdrVO) throws EventException {
        try {
            return dbDao.searchCheckProposalSCNumber(priSpHdrVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }	
    /**
     * Retrieving whether S/C Number PreFix is valid or not. <br>
     * 
     * @param CstPriSpHdrVO cstPriSpHdrVO
     * @return List<CstPriSpHdrVO>
     * @exception EventException
     */
    public List<CstPriSpHdrVO> checkProposalPreFixNumber (CstPriSpHdrVO cstPriSpHdrVO) throws EventException {
        try {
            return dbDao.searchCheckProposalPreFixNumber(cstPriSpHdrVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }    
    
	/**
     * Retrieving mandatory data on Reqeust time<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception EventException
	 */
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchRequestTermsCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
     * Retrieving scopes without canclucation when Reqeusting<br>
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriSpScpMnVO priSpScpMnVO) throws EventException {
		try {
			return dbDao.searchRequestCheckCalculate(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	
	/**
	 * Deleting all data when canceling init<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalforContract(PriSpHdrVO priSpHdrVO, PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			String amdtSeq = priSpMnVO.getAmdtSeq();
			String minAmdtSeq = dbDao.searchCancelMinAmdtSeq(priSpMnVO);
			
			dbDao.addContractAmendmentDeleteHistory(priSpMnVO, account);
			dbDao.removeProposal(priSpMnVO);
			
			if(amdtSeq.equals("0") || (!amdtSeq.equals("0") && amdtSeq.equals(minAmdtSeq))){
				dbDao.modifyContractHdrDeleteHistory(priSpHdrVO, amdtSeq);
				dbDao.removeProposalHdr(priSpMnVO);
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
	 * Deleting all data when canceling init<br>
	 * 
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposal(priSpMnVO);
//			log.debug("priSpMnVO.getAmdtSeq()==================="+priSpMnVO.getAmdtSeq());
			if (priSpMnVO.getAmdtSeq().equals("0")){
				dbDao.removeProposalHdr(priSpMnVO);
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
     * Modifying expire date in case filing date is later when proposaling and filing.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalTerms(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {

			if (priSpScpDurVO != null  ) {
				priSpScpDurVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalTerms (priSpScpDurVO);
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
     * Modifying exp_dt with previous amend sequence when filing<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalPreTerms(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalMainPreTerms (priSpMnVO);
				dbDao.modifyProposalScopePreTerms (priSpMnVO);
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
     * Modifying MAIN's Expire Date.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiry(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				
				dbDao.modifyProposalMainExpiry (priSpMnVO);
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
	 * Modifying main expire data when canceling inital status in case of init Proposal status.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiryCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			int amdtSeq = 0;
			
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				PriSpMnVO vo = new PriSpMnVO();
				ObjectCloner.build(priSpMnVO, vo);
				amdtSeq = Integer.parseInt(vo.getAmdtSeq()) -1 ;				
				vo.setAmdtSeq(String.valueOf(amdtSeq));
				vo.setPropStsCd("F");
				dbDao.modifyProposalMainExpiry (vo);
//				log.debug("manageProposalMainExpiryCancel==PriSpMnVO amdtseq"+ priSpMnVO.getAmdtSeq());
//				log.debug("manageProposalMainExpiryCancel==vo amdtseq"+ vo.getAmdtSeq());
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
     * Modifying  Scope MAIN's Expire Date when modifying duration<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiry(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalScopeMainExpiry (priSpMnVO);
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
	 * Modifying Scope Main Expire Date in case that Proposal's status is Init and  Initial status is canceled.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiryCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			int amdtSeq = 0;
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				PriSpScpMnVO vo = new PriSpScpMnVO();
				ObjectCloner.build(priSpScpMnVO, vo);
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
     * Retrieving S/C No to be added.<br>
	 * @param CstPriSpHdrVO cstPriSpHdrVO
	 * @return List<CstPriSpHdrVO>
	 * @exception EventException
	 */
	public List<CstPriSpHdrVO> searchProposalSCNumberMain(CstPriSpHdrVO cstPriSpHdrVO) throws EventException {
		try {
			CstPriSpHdrVO vo = new CstPriSpHdrVO();
			List<CstPriSpHdrVO> rVo = new ArrayList<CstPriSpHdrVO>();
			vo.setScNo("");
			List<CstPriSpHdrVO> list1 = dbDao.searchProposalSCNumberMain(cstPriSpHdrVO);
			if (list1 != null && list1.size() > 0){
				vo.setScNo(list1.get(0).getScNo()) ;
			}
//			if (vo.getScNo().equals("")){
//				List<CstPriSpHdrVO> list2 = dbDao.searchProposalMaxSCNumberMain(cstPriSpHdrVO);
//				if (list2 != null && list2.size() > 0){
//					vo.setScNo(list2.get(0).getScNo()) ;
//				}
//			}
						
			rVo.add(vo);
			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Changing scope's status to "returned" in case there is "Returned" in Terms<br>
	 * 
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeAutoScopeReturnStatus(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpProgVO> insertProgVoList =  new ArrayList<PriSpScpProgVO>(); 
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyAutoScopeReturnStatus (priSpScpMnVO);
				
				if (dbDao.searchScopeProgressStatus(priSpScpMnVO) == 0){
					//Inserting to prog in case prog's status != Mn's status
					PriSpScpProgVO vo = new PriSpScpProgVO();
					ObjectCloner.build(priSpScpMnVO, vo);
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
     * Applying S/C Proposal Master to Proposal<br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmMasterProposal(PriSpHdrVO priSpHdrVO, SignOnUserAccount account) throws EventException{
        try {
        	priSpHdrVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyConfirmMasterProposal(priSpHdrVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }

	/**
	 * Modifying Proposal Main's Boiler Plate Header Seq<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainBoilerPlateSeq(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriSpMnVO> updateVoList = new ArrayList<PriSpMnVO>();
			
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				if (priSpMnVO.getBlplHdrSeq().equals("")){
					priSpMnVO.setBlplHdrSeq("XX");
				}
				
				updateVoList.add(priSpMnVO);
				
				dbDao.modifyProposalMain (updateVoList);
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
	 * Modifying  SCOPE MAIN  Expire Date when modifying DURATION.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeProposalScopeMainExpiry(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalScopeMainExpiryChange (priSpScpMnVO);
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
     * Checking duplication of S/C no when creating S/C Master<br>
     * 
     * @param PriSpHdrVO priSpHdrVO
     * @return boolean
     * @exception EventException
     */
    public boolean checkScNumberDup(PriSpHdrVO priSpHdrVO) throws EventException {
        try {
            return dbDao.searchCheckScNumberDup(priSpHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
    }

    /**
     * Checking  S/C Number Prefix compatibility when creating S/C Master<br>
     * 
     * @param ChkScNoVO chkScNoVO
     * @return String
     * @exception EventException
     */
    public String checkScNumberPrefix(ChkScNoVO chkScNoVO) throws EventException {
        try {
            return dbDao.searchCheckScNumberPrefix(chkScNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
    }
    
	/**
	 * Retrieving "Returned" data in terms with c/offer<br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltReturnVO>
	 * @exception EventException
	 */
	public List<RsltReturnVO> searchProposalReturnedList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalReturnedList(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
    /**
     * Updating Proposal  Main's Status column from Returned to Request<br>
     * 
     * @param PriSpMnVO vo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int changeAutoRequestMainStatus (PriSpMnVO vo, SignOnUserAccount account) throws EventException {
        int result = 0;
    	try {
            vo.setUpdUsrId(account.getUsr_id());            
            result = dbDao.modifyAutoChangeMainStatus(vo);
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
	 * Getting  DEM/DET Exception's Status to validate when approving<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckDmdtList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchCheckDmdtList=======================bc ");
			return dbDao.searchCheckDmdtList(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    
	
	/**
	 * Retrieving Amend History Main information<br>
	 * 
	 * @param PriSpHdrVO priSpHdrVO
	 * @return List<RsltPriSpAmdHstMnVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAmdHstMnVO> searchAmendmentHistoryMain(PriSpHdrVO priSpHdrVO) throws EventException {
		try {
			
			return dbDao.searchAmendmentHistoryMain(priSpHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   	
	
	/**
	 * Retrieving Amend History Scope List information<br>
	 * 
	 * @param CstShHistVO CstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception EventException
	 */
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws EventException {
		try {
			log.debug("cstShHistVO.getConvFlg()==bc=="+cstShHistVO.getConvFlg());
			return dbDao.searchAmendmentHistoryList(cstShHistVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
	 * Retrieving Amended Terms
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */	
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchHistoryAmendTermList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   
	/**
	 * Retrieving all scope by Proposal No.
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchHistoryScopeList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchHistoryScopeList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
     * Retrieving whether modified information in each terms exists or not<br>
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws EventException {
		try {
			log.debug("searchAmendmentHistorySummary=========svcscpcd======"+cstShHistVO.getSvcScpCd());
			if (cstShHistVO.getLgcyIfFlg().equals("Y")){ //legary data
				return dbDao.searchAmendmentHistoryLgcy(cstShHistVO);
			}else{
				return dbDao.searchAmendmentHistorySummary(cstShHistVO);
			}
			
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
     * retrieving scope with duration expire date before inputted file date to valiate main, scope when Filing<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltExpChkVO>
	 * @exception EventException
	 */
	public List<RsltExpChkVO> searchExpireDateCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchExpireDateCheck(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * Retrieving Proposal & Amendment Search List<br>
	 * 
	 * @param CstShInqVO cstShInqVO
	 * @return List<RsltPriSpInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpInqVO> searchProposalMainInquiryList(CstShInqVO cstShInqVO) throws EventException {
		try {
			log.debug("searchProposalMainInquiryList====cstShInqVO="+ cstShInqVO.getSprcCtrtCustTpCd());
			return dbDao.searchProposalMainInquiryList (cstShInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * Retrieving Proposal & Amendment information<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @return RsltPropInqListVO
	 * @exception EventException
	 */
	public RsltPropInqListVO searchProposalMainInquiry(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropInqListVO vo = new RsltPropInqListVO();
			vo.setRsltPropMnInqVOs(dbDao.searchProposalMainInquiry(priSpMnVO));
			vo.setRsltPropMnScpInqListVOs(dbDao.searchProposalMainScpInquiryList(priSpMnVO));	

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
     * Retrieving Customer information.<br>
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
	 * Checking whether terms's data in summary table is modified or not<br>
	 * 
	 * @param priSpScpAmdtSmryVO PriSpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAmendmentSummaryInquiry(priSpScpAmdtSmryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * Retrieving Commodity Group,Rate,Standard Note의 data in case of modifying cutomer type<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
	public List<RsltCdListVO> searchProposalMainCustTypeChkList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			log.debug("searchProposalMainCustTypeChkList=======================bc ");
			return dbDao.searchProposalMainCustTypeChkList(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Retrieving  HEADER SEQ information when copying Guideline Standard Note information<br>
	 * 
	 * @param PriSpScpNoteListVO priSpScpNoteListVO
	 * @param String isCopy
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyNoteHeaderSeq(PriSpScpNoteListVO priSpScpNoteListVO, String isCopy, SignOnUserAccount account) throws EventException{		
		try {
			priSpScpNoteListVO.setCreUsrId(account.getUsr_id());
			priSpScpNoteListVO.setUpdUsrId(account.getUsr_id());
			if(priSpScpNoteListVO != null){
				dbDao.modifyProposalNoteHeaderSequence (priSpScpNoteListVO, isCopy);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * Running BackEndJob to retrieve Performance.<br>
     *
	 * @param SignOnUserAccount account
	 * @param PriSpMnVO priSpMnVO
	 * @return String
	 * @exception EventException
	 */
	/*public String searchSCPerformanceDoStart(SignOnUserAccount account, PriSpMnVO priSpMnVO) throws EventException {
		SearchSCPerformanceBackEndJob searchSCPerformanceBackEndJob = new SearchSCPerformanceBackEndJob();
		searchSCPerformanceBackEndJob.setPerfromanceVO(account, priSpMnVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchSCPerformanceBackEndJob, account.getUsr_id(), "ESM_PRI_0003 - Search");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}*/
	/**
	 * retrieving status value for BackEndJob result<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	/*public String comBakEndJbVOs(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}	*/
	
    /**
     * Modifying Conversion Flag<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void changeConversionFlg (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalMainConversionFlg (priSpMnVO);
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
	 * Retrieving DEM/DET data for validation when canceling "init"<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalMainInitCancelCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			List<RsltCdListVO> rsltCdListVO = null;
			String minAmdtSeq = null;
			if(!priSpMnVO.getAmdtSeq().equals("0")){
				minAmdtSeq = dbDao.searchCancelMinAmdtSeq(priSpMnVO);
			}
			if(priSpMnVO.getAmdtSeq().equals("0") || priSpMnVO.getAmdtSeq().equals(minAmdtSeq)){
				rsltCdListVO = dbDao.searchProposalMainInitCancelCheck(priSpMnVO);
			}
			return rsltCdListVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}       
	
	/**
	 * Retrieving scope by Proposal No., Amend Seq <br>
	 * @param PriSpMnVO priSpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchScopeList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchScopeList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	
	/**
	 * Deleting S/C Scope Main information.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRemove(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpMnVO[] scpVo = scPropMnVO.getPriSpScpMnVOs();
			List<PriSpScpMnVO> deleteScpVoList = new ArrayList<PriSpScpMnVO>();
			for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
				if ( scpVo[i].getIbflag().equals("D")){
					deleteScpVoList.add(scpVo[i]);
				}
			}

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
     * Checking whether accepted or returned data exists or not when canceling Reqeust<br>
     * @param PriSpMnVO priSpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
	public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProposalRequestCancelCheck(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    
    
    /**
     * Retrieving conditions to open G/W main popup when requesting<br>
     * Not opening G/W main popup when requesting next time if cancelling request once<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchProgRequestList(PriSpMnVO priSpMnVO) throws EventException {
		try {
			return dbDao.searchProgRequestList(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
    
    /**
     * Cancelling filed S/C as hidden function to be able to run by super user<br>
     *
     * @param ScPropProgVO scPropProgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelFilingForSuperuser(ScPropProgVO scPropProgVO,SignOnUserAccount account) throws EventException{
		try {
			PriSpMnVO priSpMnVO = scPropProgVO.getPriSpMnVOs()[0];
			PriSpProgVO priSpProgVO = scPropProgVO.getPriSpProgVOs()[0];


			priSpMnVO.setUpdUsrId(account.getUsr_id());

			//Changing main information update status to A and  filed_dt to null
			dbDao.modifyProposalMainCancelFiling(priSpMnVO);

			
			// No need to update about previous seq if amdt_seq = 0
			if( !priSpMnVO.getAmdtSeq().equals("0") ){
				PriSpMnVO clonePriSpMnVo = (PriSpMnVO)priSpMnVO.clone();//new PriSpMnVO();
				//ObjectCloner.build(priSpMnVO,clonePriSpMnVo);
				// changing SEQ to previous seq
				clonePriSpMnVo.setAmdtSeq(String.valueOf(Integer.parseInt(priSpMnVO.getAmdtSeq()) - 1 ));
				// Updating previous seq's exp_dt of Main
				dbDao.modifyProposalMainCancelFilingExpDt(clonePriSpMnVo);
				// Updating previous seq's exp_dt of Scope Main.(for all scope)
				dbDao.modifyProposalScopeMainCancelFilingExpDt(clonePriSpMnVo);
			}
			
			
			// propStsCd is "A" from screen
			// Inserting "A" because the previous status should be "approved" after cancelling Filed S/C
			List<PriSpProgVO> insertVoList = new ArrayList<PriSpProgVO>();
			priSpProgVO.setUpdUsrId(account.getUsr_id());
			priSpProgVO.setCreUsrId(account.getUsr_id());
			priSpProgVO.setProgUsrId(account.getUsr_id());
			priSpProgVO.setProgOfcCd(account.getOfc_cd());
			priSpProgVO.setProgDt(account.getUpd_dt());	
			insertVoList.add(priSpProgVO);
			dbDao.addProposalProgress(insertVoList);		
			
 
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
    
    
    /**
     * (REVERT) Cancelling filed S/C<br>
     *
     * @param PriSpProgVO[] priSpProgVOs
     * @param PriSpScpProgVO[] priSpScpProgVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalMainRevertState(PriSpProgVO[] priSpProgVOs, PriSpScpProgVO[] priSpScpProgVOs, SignOnUserAccount account)  throws EventException{
    	// Filing Revert or Filing
    	// Filing된 상태를 모두 Cancel하는 Revert 또는 Revert된 Filing을 모두 다시 Filing
    	// Revert 또는 Filing 구분은 
    	//Detail ----------------------
    	//(1) Org/Dst
    	//(2) LOC Group
    	//(3) CMDT Group
    	//(4) Arbitrary / IHC
    	//(5) Special Note
    	//(6) L/Agent
    	//(7) GOH
    	//(8) Rate PRI_SP_SCP_RT_CMDT
    	//(9) Rate PRI_SP_SCP_RT_ACT_CUST
    	//(10) Rate PRI_SP_SCP_RT_CNOTE
    	//(11) Rate PRI_SP_SCP_RT_ROUT_PNT
    	//(12) Rate PRI_SP_SCP_RT_ROUT_VIA
    	//(13) Rate PRI_SP_SCP_RT_ROUT_DIR
    	//(14) Rate PRI_SP_SCP_RT_CMDT_RNOTE
    	//(15) Rate PRI_SP_SCP_RT
    	
    	//Header ----------------------(2015.07.10 추가)
    	//(1)Affiliate PRI_SP_AFIL
    	//(2)Boiler Plate PRI_SP_BLPL
    	//(3)Boiler Plate PRI_SP_BLPL_CTNT
    	//(4)Contract Parties PRI_SP_CTRT_PTY
    	//(5)Customer Type PRI_SP_CTRT_CUST_TP
    	//(6)MQC PRI_SP_MQC
    	//(7)MQC PRI_SP_SCP_MQC
    	//(8)MQC PRI_SP_SUB_MQC
    	//(9)Duration PRI_SP_DUR
    	//(10)Duration PRI_SP_SCP_DUR
    	
    	//공통 ----------------------
    	//(1) PRI_SP_SCP_AMDT_SMRY
    	//(2) PRI_SP_SCP_MN 
    	//(3) PRI_SP_SCP_PROG (multi-insert) service scope별로
    	//(4) PRI_SP_AMDT_SMRY (2015.07.10 추가)
    	//(5) PRI_SP_MN 
    	//(6) PRI_SP_PROG 
    	
    	
    	try {
    		
    		if(priSpProgVOs != null && priSpProgVOs.length > 0) {
	    		//Basic Vo Setting for revert
	    		priSpProgVOs[0].setUpdUsrId(account.getUsr_id());
	    		priSpProgVOs[0].setCreUsrId(account.getUsr_id());
	    		priSpProgVOs[0].setProgUsrId(account.getUsr_id());
	    		priSpProgVOs[0].setProgOfcCd(account.getOfc_cd());
	        	
	    		//PRI_SP_SCP_PROG 용
	        	List<PriSpScpProgVO> insertVoList =  new ArrayList<PriSpScpProgVO>();
	        	//PRI_SP_PROG 용
	        	List<PriSpProgVO> insertpPiSpProgVO =  new ArrayList<PriSpProgVO>();
	        	insertpPiSpProgVO.add(priSpProgVOs[0]);
	    		
	        	if(priSpScpProgVOs != null && priSpScpProgVOs.length > 0) {
	    			for ( int i=0; i<priSpScpProgVOs.length; i++ ) {
	    				
	    				priSpScpProgVOs[i].setCreUsrId(account.getUsr_id());
	    				priSpScpProgVOs[i].setUpdUsrId(account.getUsr_id());
	    				priSpScpProgVOs[i].setProgUsrId(account.getUsr_id());
	    				priSpScpProgVOs[i].setProgOfcCd(account.getOfc_cd());
	    				String prop_sts_cd = priSpProgVOs[0].getPropStsCd();
	    				priSpScpProgVOs[i].setPropScpStsCd(prop_sts_cd);
	    				insertVoList.add(priSpScpProgVOs[i]);
	    			
	    			}	
	        	}
	        	
	        	//(Detail)
	        	//(1)Org/Dst
	        	dbDao.modifyRevertOrgDst(priSpProgVOs[0]);
	        	//(2)LOC Group
	        	dbDao.modifyRevertLocGroup(priSpProgVOs[0]);
	        	//(3)CMDT Group
	        	dbDao.modifyRevertCmdtGroup(priSpProgVOs[0]);
	        	//(4)Arbitrary / IHC
	        	dbDao.modifyRevertArbitraryIch(priSpProgVOs[0]);
	        	//(5)Special Note
	        	dbDao.modifyRevertSpecialNote(priSpProgVOs[0]);
	        	//(6)L/Agent
	        	dbDao.modifyRevertLAgent(priSpProgVOs[0]);
	        	//(7)GOH
	        	dbDao.modifyRevertGoh(priSpProgVOs[0]);
	        	//(8)Rate PRI_SP_SCP_RT_CMDT
	        	dbDao.modifyRevertRateCmdt(priSpProgVOs[0]);
	        	//(9)Rate PRI_SP_SCP_RT_ACT_CUST
	        	dbDao.modifyRevertRateActCust(priSpProgVOs[0]);
	        	//(10)Rate PRI_SP_SCP_RT_CNOTE
	        	dbDao.modifyRevertRateCnote(priSpProgVOs[0]);
	        	//(11)Rate PRI_SP_SCP_RT_ROUT_PNT
	        	dbDao.modifyRevertRateRoutPnt(priSpProgVOs[0]);
	        	//(12)Rate PRI_SP_SCP_RT_ROUT_VIA
	        	dbDao.modifyRevertRateRoutVia(priSpProgVOs[0]);
	        	//(13)Rate PRI_SP_SCP_RT_ROUT_DIR
	        	dbDao.modifyRevertRateRoutDir(priSpProgVOs[0]);
	        	//(14)Rate PRI_SP_SCP_RT_CMDT_RNOTE
	        	dbDao.modifyRevertRateRoutRnote(priSpProgVOs[0]);
	        	//(15)Rate PRI_SP_SCP_RT
	        	dbDao.modifyRevertPriSpSvcRt(priSpProgVOs[0]);
	        	
	        	//(Header)-- 2015.07.10  추가
	        	//(1)Affiliate PRI_SP_AFIL
	        	dbDao.modifyRevertPriSpAfil(priSpProgVOs[0]);
	        	//(2)Boiler Plate PRI_SP_BLPL
	        	dbDao.modifyRevertPriSpBlPl(priSpProgVOs[0]);
	        	//(3)Boiler Plate PRI_SP_BLPL_CTNT
	        	dbDao.modifyRevertPriSpBlplCtnt(priSpProgVOs[0]);
	        	//(4)Contract Parties PRI_SP_CTRT_PTY
	        	dbDao.modifyRevertPriSpCtrtPty(priSpProgVOs[0]);
	        	//(5)Customer Type PRI_SP_CTRT_CUST_TP
	        	dbDao.modifyRevertPriSpCtrtCustTp(priSpProgVOs[0]);
	        	//(6)MQC PRI_SP_MQC
	        	dbDao.modifyRevertPriSpMqc(priSpProgVOs[0]);
	        	//(7)MQC PRI_SP_SCP_MQC
	        	dbDao.modifyRevertPriSpScpMqc(priSpProgVOs[0]);
	        	//(8)MQC PRI_SP_SUB_MQC
	        	dbDao.modifyRevertPriSpSubMqc(priSpProgVOs[0]);
	        	//(9)Duration PRI_SP_DUR
	        	dbDao.modifyRevertPriSpDur(priSpProgVOs[0]);
	        	//(10)Duration PRI_SP_SCP_DUR
	        	dbDao.modifyRevertPriSpScpDur(priSpProgVOs[0]);
	        	
	        	
	        	
	        	//(공통)
	        	//(1)PRI_SP_SCP_AMDT_SMRY
	        	dbDao.modifyRevertPriSpScpAmdtSmry(priSpProgVOs[0]);
	        	//(2)PRI_SP_SCP_MN 
	        	dbDao.modifyRevertPriSpScpMn(priSpProgVOs[0]);
	        	//(3)PRI_SP_SCP_PROG (multi-insert) service scope별로
	    		if ( insertVoList.size() > 0 ) {
	    			dbDao.addProposalScopeProgress(insertVoList);
	    		}
	    		//(4)PRI_SP_AMDT_SMRY -- 2015.07.10  추가
	        	dbDao.modifyRevertPriSpAmdtSmrt(priSpProgVOs[0]);
	    		//(5)PRI_SP_MN
	        	dbDao.modifyRevertPriSpMn(priSpProgVOs[0]);
	        	//(6)PRI_SP_PROG
	        	if ( insertpPiSpProgVO.size() > 0 ) {
		        	insertpPiSpProgVO.get(0).setUpdUsrId("Revert State");
		        	dbDao.addProposalProgress(insertpPiSpProgVO);
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
	
	
}