/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalBCImpl.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration.SCNoteConversionProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.PriScNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.PriSpMnConvAuthFlagVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCnoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScNoteConvVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCnoteVO;

/**
 * ALPS-SCProposal Business Logic Basic Command implementation<br>
 * - ALPS-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0032EventResponse,SCNoteConversionProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCNoteConversionProposalBCImpl extends BasicCommandSupport implements SCNoteConversionProposalBC {

	// Database Access Object
	private transient SCNoteConversionProposalDBDAO dbDao = null;

	/**
	 * SCNoteConversionProposalBCImpl 객체 생성<br>
	 * SCNoteConversionProposalDBDAO를 생성한다.<br>
	 */
	public SCNoteConversionProposalBCImpl() {
		dbDao = new SCNoteConversionProposalDBDAO();
	}


	/**
	 * [Special Note 의 DETAIL]을 [조회] 합니다.<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchNoteContentList(priSpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [Commodity Note 의 DETAIL]을 [조회] 합니다.<br>
	 * 
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception EventException
	 */
	public List<RsltRtCnoteListVO> searchCommodityNoteContentList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws EventException {
		try {
			return dbDao.searchCommodityNoteContentList(priSpScpRtCnoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [Commodity Note 의 DETAIL]을 [조회] 합니다.<br>
	 * 
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception EventException
	 */
	public List<RsltRtCnoteListVO> searchCommodityNoteContentInquiryList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws EventException {
		try {
			return dbDao.searchCommodityNoteContentInquiryList(priSpScpRtCnoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [Special Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchNoteConversionList(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [Special Note Conversion]을 [붙여넣기] 합니다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriScNoteConvVO priScNoteConvVO , SignOnUserAccount account) throws EventException {
		try {
			//로그인 아이디로 조회
			priScNoteConvVO.setCreUsrId(account.getUsr_id());
			
			return dbDao.searchNoteConversionListCopy(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * [Special Note Conversion]을 [생성/수정/삭제] 합니다.<br>
	 * 
	 * @param PriScNoteConvListVO[] priScNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(PriScNoteConvListVO[] priScNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriScNoteConvListVO> insertVoList = new ArrayList<PriScNoteConvListVO>();
			List<PriScNoteConvListVO> updateVoList = new ArrayList<PriScNoteConvListVO>();
			List<PriScNoteConvListVO> deleteVoList = new ArrayList<PriScNoteConvListVO>();
			
			for ( int i=0; i<priScNoteConvListVOs .length; i++ ) {
				if ( priScNoteConvListVOs[i].getIbflag().equals("I")){
					priScNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
					priScNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priScNoteConvListVOs[i]);
				} else if ( priScNoteConvListVOs[i].getIbflag().equals("U")){
					priScNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priScNoteConvListVOs[i]);
				} else if ( priScNoteConvListVOs[i].getIbflag().equals("D")){
					deleteVoList.add(priScNoteConvListVOs[i]);
				}
			}
						
			if ( insertVoList.size() > 0 ) {
				dbDao.addNoteConversion(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyNoteConversion(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeNoteConversion(deleteVoList);
			}
			/*
			if ( priScNoteConvCommVO != null ) {
				dbDao.modifyNoteChargeTypeCode(priScNoteConvCommVO, priScNoteConvVO[0].getNoteConvTpCd()); //Proposal Special Note
			}
			*/		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * [Special Note Conversion]을 [복사] 합니다.<br>
	 * 
	 * @param PriScNoteConvListVO[] priScNoteConvListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriScNoteConvListVO[] priScNoteConvListVO, SignOnUserAccount account) throws EventException{
		try {			
			List<PriScNoteConvListVO> insertVoList = new ArrayList<PriScNoteConvListVO>();
			
			for ( int i=0; i<priScNoteConvListVO .length; i++ ) {
				if ( priScNoteConvListVO[i].getIbflag().equals("I")){
					priScNoteConvListVO[i].setCreUsrId(account.getUsr_id());
					priScNoteConvListVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priScNoteConvListVO[i]);
				}
			}			
			if ( insertVoList.size() > 0 ) {
				dbDao.removeNoteConversionCopy(priScNoteConvListVO[0]);				
				dbDao.addNoteConversionCopy(insertVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
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
// pri_sc_note_conv) 신규 생성
// pri_sp_scp_note_ctnt 신규 생성			
			dbDao.addProposalNoteConversionAmend (insertVoList);
				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Main Duration Expire Date 변경시 Conversion 의 Expire Date를 변경한다.<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionExpireDate(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account)throws EventException{
		try {		
			if ( priSpScpMnVO != null ) {
				List<PriSpScpMnVO> updateVoList = new ArrayList<PriSpScpMnVO>();
				for ( int i=0; i<priSpScpMnVO .length; i++ ) {
					if ("U".equals(priSpScpMnVO[i].getIbflag())){
						priSpScpMnVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priSpScpMnVO[i]);
						log.debug("manageNoteConversionExpireDate============"+priSpScpMnVO[i].getIbflag());						
					}
				}
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyNoteConversionExpDate(updateVoList); //Proposal Special Note
				}				
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Duration Effective Date 변경시 Conversion 의 Effective Date를 변경한다.<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDate(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account)throws EventException{
		try {		
			if ( priSpScpMnVO != null ) {
				List<PriSpScpMnVO> updateVoList = new ArrayList<PriSpScpMnVO>();
				for ( int i=0; i<priSpScpMnVO .length; i++ ) {
					if ("U".equals(priSpScpMnVO[i].getIbflag())){
						priSpScpMnVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priSpScpMnVO[i]);							
					}
				}
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyNoteConversionEffDate(updateVoList); //Proposal Special Note
				}
				
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	
    /**
     * S/C Proposal Special Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_SC_NOTE_CONV COPY
            dbDao.addCopyProposalScNoteConversion(rsltPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * S/C Proposal Rate Route Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRoutNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_SC_NOTE_CONV COPY
            dbDao.addCopyProposalRoutNoteConversion(rsltPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * S/C Proposal Rate Commodity Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyProposalCmdtNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_SC_NOTE_CONV COPY
            dbDao.addCopyProposalCmdtNoteConversion(rsltPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
	 * SCOPE에 해당하는 모든 CONVERSION 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalConversion(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Standard Note Conversion 정보를 저장한다.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpNoteListVO priSpScpNoteListVO = notePropVO.getPriSpScpNoteListVO();
			PriSpScpNoteListVO[] vo = notePropVO.getPriSpScpNoteListVOs();
			PriSpScpNoteCtntListVO[] dtlvo = notePropVO.getPriSpScpNoteCtntListVOs();
			String masterDelChk = notePropVO.getMasterDelChk();
			
			List<PriSpScpNoteListVO> insertVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteListVO> updateVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteListVO> deleteVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteCtntListVO> insertDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();
			List<PriSpScpNoteCtntListVO> updateDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();
			List<PriSpScpNoteCtntListVO> deleteDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();			
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					
					vo[i].setEffDt(priSpScpNoteListVO.getEffDt());
					vo[i].setExpDt(priSpScpNoteListVO.getExpDt());
					
					updateVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("D")){
					deleteVoList.add(vo[i]);
				}
			}
			
			for ( int i = 0; dtlvo != null && i < dtlvo.length; i++ ) {
				if ( dtlvo[i].getIbflag().equals("I")){
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());					
					insertDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("U")){
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("D")){
					deleteDtlVoList.add(dtlvo[i]);
				}
			}	
									
			if ( updateVoList.size() > 0 ) {
				if("Y".equals(masterDelChk)) {
					//CONVERSION 모두 삭제- NOTE 삭제가 먼저 발생하게 처리 : SOURCE CODE로 삭제 DATA구분
					dbDao.removeNoteMasterAmend(updateVoList);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeNote(deleteVoList);
			}
			
			if ( updateDtlVoList.size() > 0 && !"Y".equals(masterDelChk)) {
				//CONVERSION 
				PriSpScpNoteCtntListVO priSpScpNoteCtntListVO = new PriSpScpNoteCtntListVO();				
								
				for(int i = 0; i<updateDtlVoList.size(); i++) {
					priSpScpNoteCtntListVO = updateDtlVoList.get(i);
					
					////////////
					// 11-COMMAND01 : AMEND
					// 12-COMMAND02 : AMEND CANCEL
					//  8-IBDELETE : AMEND DELETE
					
					if("11".equals(priSpScpNoteCtntListVO.getActionMode())) {				            
			            //1. 날짜가 포함되어 있지 않으면 삭제
						dbDao.removeNoteContentAmend(priSpScpNoteCtntListVO);
			            
			            //2.날짜 변경
						dbDao.modifyNoteContentAmend(priSpScpNoteCtntListVO);			            
						
					} else if("12".equals(priSpScpNoteCtntListVO.getActionMode())) {							
						//1. 기존데이터 삭제
						dbDao.removeNoteContentAmend(priSpScpNoteCtntListVO);
						
						//2. 원복
						dbDao.addNoteContentAmend(priSpScpNoteCtntListVO);
						
					} else if("8".equals(priSpScpNoteCtntListVO.getActionMode())) {
						//12.14 데이터 삭제로 변경됨
						priSpScpNoteCtntListVO.setActionMode("XX");
						dbDao.removeNoteContentAmend(priSpScpNoteCtntListVO);
						
						//1. 날짜가 포함되어 있지 않으면 삭제
						//dbDao.removeNoteContentAmend(priSpScpNoteCtntListVO);
			            
			            //2.날짜 변경
						//dbDao.modifyNoteContentAmend(priSpScpNoteCtntListVO);
					} 
				}				
			}
			
			if ( deleteDtlVoList.size() > 0 && !"Y".equals(masterDelChk)) {
				dbDao.removeNoteContent(deleteDtlVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * S/C Standard Note Copy 시 Conversion 데이터를 생성합니다.<br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPriSgStndNoteHdrCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
        	
            // PRI_SC_NOTE_CONV COPY
            dbDao.addCopyScStndNoteConversion(rsltPriSgStndNoteHdrCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    
    /**
     * STANDARD NOTE에서 CTNT 삭제시 해당 CONVERSION 삭제한다.<br>
     * 
     * @param PriSgStndNoteCtntVO priSgStndNoteCtntVO
     * @exception EventException
     */
    public void removeScStndNoteConversion(PriSgStndNoteCtntVO priSgStndNoteCtntVO) throws EventException{
        try {
        	 // PRI_SC_NOTE_CONV remove
            dbDao.removeScStndNoteConversion(priSgStndNoteCtntVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * S/C Standard Note DURATION UPDATE 시 Conversion 데이터 DURATION 를 수정합니다.<br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyDurationScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
        	
            // PRI_SC_NOTE_CONV duration update
            dbDao.modifyDurationScStndNoteConversion(rsltPriSgStndNoteHdrCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Filing시 Conversion 의 Effective Date를 변경한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDateFiling(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			priSpMnVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyNoteConversionEffDateFiling(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}    
    
	
	/**
	 * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param ScRtPropCmdtVO scRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtPropCmdtVO scRtPropCmdtVO, SignOnUserAccount account) throws EventException {
		try {
			PriSpScpRtCmdtHdrVO[] vo = scRtPropCmdtVO.getPriSpScpRtCmdtHdrVOS();
			PriSpScpRtCnoteVO[] cnotevo = scRtPropCmdtVO.getPriSpScpRtCnoteVOS();

			List<PriSpScpRtCmdtHdrVO> deleteVoList = new ArrayList<PriSpScpRtCmdtHdrVO>();
			List<PriSpScpRtCnoteVO> deleteCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
			List<PriSpScpRtCnoteVO> amendCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
			List<PriSpScpRtCnoteVO> amendCancelCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
			
			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("U")) {
					// AMDT_SEQ = 0 일때는 패스. 본래 if위에 있던것.
					//이 부분때문에 prop단계에서 conversion이 삭제되지 않는 현상이 발생하여 이곳으로 이동. 2010-05-13 17:12
					if ("0".equals(vo[i].getAmdtSeq())) {
						continue;
					}
					vo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(vo[i].getN1stCmncAmdtSeq())) {
						deleteVoList.add(vo[i]);
					}
				} else if (vo[i].getIbflag().equals("D")) {
					vo[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(vo[i]);
				}
			}
			for (int i = 0; cnotevo != null && i < cnotevo.length; i++) {
				if (cnotevo[i].getIbflag().equals("U")) {
					// AMDT_SEQ = 0 일때는 패스. 본래 if위에 있던것.
					//이 부분때문에 prop단계에서 conversion이 삭제되지 않는 현상이 발생하여 이곳으로 이동. 2010-05-13 17:12
					if ("0".equals(cnotevo[i].getAmdtSeq())) {
						continue;
					}
					cnotevo[i].setCreUsrId(account.getUsr_id());
					cnotevo[i].setUpdUsrId(account.getUsr_id());
					if (("AM".equals(cnotevo[i].getSrcInfoCd())
							|| "AD".equals(cnotevo[i].getSrcInfoCd())) && cnotevo[i].getAmdtSeq().equals(cnotevo[i].getN1stCmncAmdtSeq())) {
						amendCnoteVoList.add(cnotevo[i]);
					} else if (!cnotevo[i].getAmdtSeq().equals(cnotevo[i].getN1stCmncAmdtSeq())) {
						amendCancelCnoteVoList.add(cnotevo[i]);
					}
				} else if (cnotevo[i].getIbflag().equals("D")) {
					deleteCnoteVoList.add(cnotevo[i]);
				}
			}

			if (amendCnoteVoList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeCNote(amendCnoteVoList);
			}
			if (amendCancelCnoteVoList.size() > 0) {
				dbDao.removeNoteConversionCascadeCNote(amendCancelCnoteVoList);
				dbDao.addCopyNoteConversionCascadeCNote(amendCancelCnoteVoList);
			}
			if (deleteCnoteVoList.size() > 0) {
				dbDao.removeNoteConversionCascadeCNote(deleteCnoteVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeCommodityCNote(deleteVoList);
				dbDao.modifyNoteConversionDurationCascadeCommodityRNote(deleteVoList);
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
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param ScRtPropRtVO scRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(ScRtPropRtVO scRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriSpScpRtCmdtRoutVO[] routvo = scRtPropRtVO.getPriSpScpRtCmdtRoutVOS();
			PriSpScpRtCmdtRnoteVO[] rnotevo = scRtPropRtVO.getPriSpScpRtCmdtRnoteVOS();

			List<PriSpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriSpScpRtCmdtRoutVO>();
			List<PriSpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();
			List<PriSpScpRtCmdtRnoteVO> amendRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();
			List<PriSpScpRtCmdtRnoteVO> amendCancelRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();

			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("U")) {
					// AMDT_SEQ = 0 일때는 패스. 본래 if위에 있던것.
					//이 부분때문에 prop단계에서 conversion이 삭제되지 않는 현상이 발생하여 이곳으로 이동. 2010-05-13 17:12
					if ("0".equals(routvo[i].getAmdtSeq())) {
						continue;
					}
					routvo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(routvo[i].getN1stCmncAmdtSeq())) {
						deleteRoutList.add(routvo[i]);
					}
				} else if (routvo[i].getIbflag().equals("D")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					deleteRoutList.add(routvo[i]);
				}
			}
			for (int i = 0; rnotevo != null && i < rnotevo.length; i++) {
				if (rnotevo[i].getIbflag().equals("U")) {
					// AMDT_SEQ = 0 일때는 패스. 본래 if위에 있던것.
					//이 부분때문에 prop단계에서 conversion이 삭제되지 않는 현상이 발생하여 이곳으로 이동. 2010-05-13 17:12
					if ("0".equals(rnotevo[i].getAmdtSeq())) {
						continue;
					}
					rnotevo[i].setCreUsrId(account.getUsr_id());
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					if (("AM".equals(rnotevo[i].getSrcInfoCd())
							|| "AD".equals(rnotevo[i].getSrcInfoCd())) && rnotevo[i].getAmdtSeq().equals(rnotevo[i].getN1stCmncAmdtSeq())) {
						amendRnoteList.add(rnotevo[i]);
					} else if (!rnotevo[i].getAmdtSeq().equals(rnotevo[i].getN1stCmncAmdtSeq())) {
						amendCancelRnoteList.add(rnotevo[i]);
					}
				} else if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}

			if (amendRnoteList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeRNote(amendRnoteList);
			}
			if (amendCancelRnoteList.size() > 0) {
				dbDao.removeNoteConversionCascadeRNote(amendCancelRnoteList);
				dbDao.addCopyNoteConversionCascadeRNote(amendCancelRnoteList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeNoteConversionCascadeRNote(deleteRnoteList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeRouteRNote(deleteRoutList);
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
	 * 이행데이터를 구분하기 위해서 헤더정보를 조회한다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCreationTypeCode(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchCreationTypeCode(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Legacy I/F Flag 정보를 조회한다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLegacyIfFlag(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchLegacyIfFlag(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CONVERSION 입력 가능한가를 확인하기 위해서 CONVERSION CONFIRM FLAG정보를 조회한다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchConversionConfirmFlag(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchConversionConfirmFlag(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
     * CONVERSION 입력 가능한가를 확인하기 위해서 CONVERSION 권한 정보를 조회한다.<br>
     * 
     * @param PriScNoteConvVO priScNoteConvVO
     * @param SignOnUserAccount account
     * @return List<PriSpMnConvAuthFlagVO>
     * @exception EventException
     */
    public List<PriSpMnConvAuthFlagVO> searchConversionAuthFlag(PriScNoteConvVO priScNoteConvVO,SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchConversionAuthFlag(priScNoteConvVO,account);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * 이전 Amend Seq.를 기준으로 Conversion을 추가합니다..<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			priSpMnVO.setUpdUsrId(account.getUsr_id());

			//conversion 삭제
			dbDao.removeConversionUpdate(priSpMnVO);
			//special note
			dbDao.addConversionSpecialNote(priSpMnVO);
			dbDao.addConversionRateCnote(priSpMnVO);
			dbDao.addConversionRateCommodity(priSpMnVO);
			
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}   	
	
	/**
	 * CONVERSION HISTORY 입력할때 EXP_DT를 입력하기 위해서 현재 AMDT_SEQ의 DURATION EXP_DT를 조회한다.<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDurationExpDate(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchDurationExpDate(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}