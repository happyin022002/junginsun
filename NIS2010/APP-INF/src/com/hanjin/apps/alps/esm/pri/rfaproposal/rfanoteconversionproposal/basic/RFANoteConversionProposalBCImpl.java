/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteConversionProposalBCImpl.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================
 * History
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpNoteCtntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCnoteVO;

/**
 * ALPS-SCProposal Business Logic Basic Command implementation<br>
 * - ALPS-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0032EventResponse,RFANoteConversionProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RFANoteConversionProposalBCImpl extends BasicCommandSupport implements RFANoteConversionProposalBC {

	// Database Access Object
	private transient RFANoteConversionProposalDBDAO dbDao = null;

	/**
	 * RFANoteConversionProposalBCImpl 객체 생성<br>
	 * RFANoteConversionProposalDBDAO를 생성한다.<br>
	 */
	public RFANoteConversionProposalBCImpl() {
		dbDao = new RFANoteConversionProposalDBDAO();
	}


	/**
	 * [Special Note 의 DETAIL]을 [조회] 합니다.<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchNoteContentList(priRpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * [Special Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<PriRfaNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws EventException {
		try {
			return dbDao.searchNoteConversionList(priRfaNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [Special Note Conversion]을 [붙여넣기] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<PriRfaNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO , SignOnUserAccount account) throws EventException {
		try {
			//로그인 아이디로 조회
			priRfaNoteConvVO.setCreUsrId(account.getUsr_id());
			
			return dbDao.searchNoteConversionListCopy(priRfaNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * [Special Note Conversion]을 [복사] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRfaNoteConvListVO> insertVoList = new ArrayList<PriRfaNoteConvListVO>();
			
			for ( int i=0; i<priRfaNoteConvListVOs.length; i++ ) {
				if ( priRfaNoteConvListVOs[i].getIbflag().equals("I")){
					priRfaNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
					priRfaNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRfaNoteConvListVOs[i]);
				}
			}			
			if ( insertVoList.size() > 0 ) {
				dbDao.removeNoteConversionCopy(priRfaNoteConvListVOs[0]);				
				dbDao.addNoteConversionCopy(insertVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [Commodity Note 의 DETAIL]을 [조회] 합니다.<br>
	 * 
	 * @param PriRpScpRtCnoteVO priRpScpRtCnoteVO
	 * @return List<PriRpScpRtCnoteVO>
	 * @exception EventException
	 */
	public List<PriRpScpRtCnoteVO> searchCommodityNoteContentList(PriRpScpRtCnoteVO priRpScpRtCnoteVO) throws EventException {
		try {
			return dbDao.searchCommodityNoteContentList(priRpScpRtCnoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * Amend Request를 처리합니다.<br>
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
			insertVoList.add(priRpMnVO);
// pri_sc_note_conv) 신규 생성
// pri_sp_scp_note_ctnt 신규 생성			
			log.debug("amendProposal==exp_dt==conversion="+priRpMnVO.getExpDt());
			
			dbDao.addProposalNoteConversionAmend (insertVoList);
			if (!priRpMnVO.getExpDt().equals("")){
				dbDao.modifyProposalNoteConversionAmendExp (insertVoList);	
				log.debug("exp_dt==============conversion="+priRpMnVO.getExpDt());
			}
			
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Master RFA의 Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposalMst(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
	
			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			
			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priRpMnVO);
	//pri_sc_note_conv) 신규 생성
	//pri_sp_scp_note_ctnt 신규 생성			
			log.debug("amendProposal==exp_dt==conversion="+priRpMnVO.getExpDt());
			
			dbDao.addProposalNoteConversionAmendMst (insertVoList);
			if (!priRpMnVO.getExpDt().equals("")){
				dbDao.modifyProposalNoteConversionAmendExp (insertVoList);	
				log.debug("exp_dt==============conversion="+priRpMnVO.getExpDt());
			}
			
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Master RFA의 Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param RsltRoutHdrSmryListVO amdBasicVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposalBasic(PriRpMnVO priRpMnVO, RsltRoutHdrSmryListVO amdBasicVo, SignOnUserAccount account) throws EventException{
		try {
	
			List<RsltRoutHdrSmryListVO> insertVoList = new ArrayList<RsltRoutHdrSmryListVO>();
			
			amdBasicVo.setCreUsrId(account.getUsr_id());
			amdBasicVo.setUpdUsrId(account.getUsr_id());
			insertVoList.add(amdBasicVo);
			
			List<PriRpMnVO> updateExpList = new ArrayList<PriRpMnVO>();
			
			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());
			updateExpList.add(priRpMnVO);
			
	//pri_sc_note_conv) 신규 생성
	//pri_sp_scp_note_ctnt 신규 생성
			log.debug("amendProposal==exp_dt==conversion="+amdBasicVo.getExpDt());
			
			dbDao.addProposalNoteConversionAmendBasic(insertVoList);
			if (!amdBasicVo.getExpDt().equals("")){
				dbDao.modifyProposalNoteConversionAmendExp (updateExpList);
				log.debug("exp_dt==============conversion="+amdBasicVo.getExpDt());
			}
			
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Main Duration Expire Date변경시 Conversion 의 Expire Date를 변경한다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionExpireDate(PriRpScpMnVO[] priRpScpMnVO,SignOnUserAccount account)throws EventException{
		try {		
			if ( priRpScpMnVO != null ) {
				List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
				for ( int i=0; i<priRpScpMnVO .length; i++ ) {
					if ("U".equals(priRpScpMnVO[i].getIbflag())){
						priRpScpMnVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priRpScpMnVO[i]);						
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
     * RFA Proposal Special Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRfaNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RFA_NOTE_CONV COPY
            dbDao.addCopyProposalRfaNoteConversion(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Rate Route Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRoutNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RFA_NOTE_CONV COPY
            dbDao.addCopyProposalRoutNoteConversion(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Master RFA Proposal Rate Route Note Conversion 정보를 Copy 합니다.<br>
     * 
	 * @param RsltRfaPropCopyVO vo
	 * @param RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs
	 * @param SignOnUserAccount account
	 * @param PriRpMnVO priRpMnVO
     * @exception EventException
     */
    public void copyProposalRoutNoteConversionMst(RsltRfaPropCopyVO vo, RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs, SignOnUserAccount account, PriRpMnVO priRpMnVO) throws EventException{
        try {
            List<String> routSeqList = new ArrayList<String>();
			
			// Batch 일괄 수행을 위해 list로 변경 
			for(int i = 0; i < rsltRoutHdrSmryListVOs.length; i++){
				// 선택한 Route 의 route seq
				routSeqList.add(rsltRoutHdrSmryListVOs[i].getRoutSeq());
			}
			
			RsltRoutHdrSmryListVO smryVo = rsltRoutHdrSmryListVOs[0];
			
			smryVo.setCreUsrId(account.getUsr_id());
			smryVo.setUpdUsrId(account.getUsr_id());
			smryVo.setOfcCd(account.getOfc_cd());
			smryVo.setNewPropNo(vo.getNewPropNo());
			smryVo.setEffDt(priRpMnVO.getEffDt());
			smryVo.setExpDt(priRpMnVO.getExpDt());
        	
            // PRI_RFA_NOTE_CONV COPY
            dbDao.addCopyProposalRoutNoteConversionMst(smryVo, routSeqList);
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    	
    }

    /**
     * RFA Proposal Rate Commodity Note Conversion 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyProposalCmdtNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RFA_NOTE_CONV COPY
            dbDao.addCopyProposalCmdtNoteConversion(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * SPECIAL NOTE저장시 CONVERSION 데이터를 저장합니다.<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(NotePropVO notePropVO, SignOnUserAccount account) throws EventException{
		try {
			PriRpScpNoteListVO[] vo = notePropVO.getPriRpScpNoteListVOs();
			PriRpScpNoteCtntListVO[] dtlvo = notePropVO.getPriRpScpNoteCtntListVOs();
			PriRfaNoteConvListVO[] priRfaNoteConvListVO = notePropVO.getPriRfaNoteConvListVOs();
			String masterDelChk = notePropVO.getMasterDelChk();
			PriRpScpNoteListVO priRpScpNoteListVO = notePropVO.getPriRpScpNoteListVO();
			
			List<PriRpScpNoteListVO> insertVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteListVO> updateVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteListVO> deleteVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteCtntListVO> insertDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();
			List<PriRpScpNoteCtntListVO> updateDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();
			List<PriRpScpNoteCtntListVO> deleteDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();		
			List<PriRfaNoteConvListVO> insertConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					vo[i].setEffDt(priRpScpNoteListVO.getEffDt()); //CONVERSION 수정시 사용
					vo[i].setExpDt(priRpScpNoteListVO.getExpDt()); //CONVERSION 수정시 사용
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
			
			for ( int i = 0; priRfaNoteConvListVO != null && i < priRfaNoteConvListVO.length; i++ ) {
				if ( priRfaNoteConvListVO[i].getIbflag().equals("I")){
					priRfaNoteConvListVO[i].setCreUsrId(account.getUsr_id());
					priRfaNoteConvListVO[i].setUpdUsrId(account.getUsr_id());
					insertConvVoList.add(priRfaNoteConvListVO[i]);
				} else if ( priRfaNoteConvListVO[i].getIbflag().equals("U")){
					priRfaNoteConvListVO[i].setUpdUsrId(account.getUsr_id());
					updateConvVoList.add(priRfaNoteConvListVO[i]);
				} else if ( priRfaNoteConvListVO[i].getIbflag().equals("D")){
					deleteConvVoList.add(priRfaNoteConvListVO[i]);
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
			
			if ( updateDtlVoList.size() > 0 ) {
				//AMEND CANCEL이면 CONVERSION DELETE
				//1) 화면에서 이전 SEQ의 데이터를 조회하여 SHEET에 STATUS = 'I'로 나타낸다.
				//2) 서버에서 삭제한다.(이부분)
				//3) 화면에 세팅된 SHEET데이터를 INSERT한다.(아래부분에 해당함-> if ( insertConvVoList.size() > 0 ) {})
				if(priRpScpNoteListVO.getAmendFunc().equals("12")){	// COMMAND02 - AMEND CANCEL
					PriRpScpNoteCtntVO priRpScpNoteCtntVO = new PriRpScpNoteCtntVO();
					ObjectCloner.build(priRpScpNoteListVO, priRpScpNoteCtntVO);
					dbDao.removeNoteConversion(priRpScpNoteCtntVO);
				} 
				//AMEND DELETE
				//MASTER에서 AMEND DELETE할경우는 DETAIL에서 멀티로 AMEND DELETE가 될 경우가 존재하기 때문에 
				//CONVERSION을 서버에서 전체 삭제한다.
				else if(priRpScpNoteListVO.getAmendFunc().equals("8")) { //IBDELETE
					dbDao.removeNoteContent(updateDtlVoList);
				}
				else {
					//AMEND일경우는 CONVERSION SHEET에서 수정처리하기 때문에 여기에서 처리할 필요는 없다.
					//dbDao.modifyNoteContent(updateDtlVoList);
				}
				
			}
			
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeNoteContent(deleteDtlVoList);
			}
			
			if ( insertConvVoList.size() > 0 ) {
				dbDao.addNoteConversion(insertConvVoList);
			}
			
			if ( updateConvVoList.size() > 0 ) {
				dbDao.modifyNoteConversion(updateConvVoList);
			}
			
			if ( deleteConvVoList.size() > 0 ) {
				dbDao.removeNoteConversion(deleteConvVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate의 Commodity 및 Note 삭제시 Conversion정보를 같이 처리한다.<br>
	 * 
	 * @param RfaRtPropCmdtVO rfaRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeCommodity(RfaRtPropCmdtVO rfaRtPropCmdtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtHdrVO[] vo = rfaRtPropCmdtVO.getPriRpScpRtCmdtHdrVOS();
			PriRpScpRtCnoteVO[] cnotevo = rfaRtPropCmdtVO.getPriRpScpRtCnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropCmdtVO.getPriRfaNoteConvListVOS();

			List<PriRpScpRtCmdtHdrVO> deleteVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
			List<PriRpScpRtCnoteVO> deleteCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
			List<PriRfaNoteConvListVO> insertConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvVoList = new ArrayList<PriRfaNoteConvListVO>();

			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("U")) {
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
				if (cnotevo[i].getIbflag().equals("D")) {
					deleteCnoteVoList.add(cnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvVoList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvVoList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvVoList.add(convvo[i]);
				}
			}


			if (deleteConvVoList.size() > 0) {
				dbDao.removeNoteConversion(deleteConvVoList);
			}
			if (deleteCnoteVoList.size() > 0) {
				dbDao.removeCNoteConvCascadeCnote(deleteCnoteVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCNoteConvCascadeCommodity(deleteVoList);
				dbDao.removeRNoteConvCascadeCommodity(deleteVoList);
			}
			if (updateConvVoList.size() > 0) {
				dbDao.modifyRfaNoteConv(updateConvVoList, "N");
			}
			if (insertConvVoList.size() > 0) {
				dbDao.addRfaNoteConv(insertConvVoList);
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
	 * Rate의 Route Note수정시 Conversion정보를 같이 처리한다.<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeRoute(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtRoutVO[] routvo = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVOS();
			PriRpScpRtCmdtRnoteVO[] rnotevo = rfaRtPropRtVO.getPriRpScpRtCmdtRnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropRtVO.getPriRfaNoteConvListVOS();
	
			List<PriRpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRfaNoteConvListVO> insertConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvList = new ArrayList<PriRfaNoteConvListVO>();
	
			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("U")) {
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
				if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvList.add(convvo[i]);
				}
			}
	
			if (deleteConvList.size() > 0) {
				dbDao.removeNoteConversion(deleteConvList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeRNoteConvCascadeRnote(deleteRnoteList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRNoteConvCascadeRoute(deleteRoutList);
			}
			if (updateConvList.size() > 0) {
				dbDao.modifyRfaNoteConv(updateConvList, "N");
			}
			if (insertConvList.size() > 0) {
				dbDao.addRfaNoteConv(insertConvList);
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
	 * Master RFA의 Conversion정보 처리<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeRouteMst(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtRoutVO[] routvo = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVOS();
			PriRpScpRtCmdtRnoteVO[] rnotevo = rfaRtPropRtVO.getPriRpScpRtCmdtRnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropRtVO.getPriRfaNoteConvListVOS();
	
			List<PriRpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRfaNoteConvListVO> insertConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvList = new ArrayList<PriRfaNoteConvListVO>();
	
			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("U")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(routvo[i].getN1stCmncAmdtSeq())) {
						routvo[i].setN1stCmncAmdtSeq(routvo[i].getAmdtSeq());
						deleteRoutList.add(routvo[i]);
					}
				} else if (routvo[i].getIbflag().equals("D")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					deleteRoutList.add(routvo[i]);
				}
			}
			for (int i = 0; rnotevo != null && i < rnotevo.length; i++) {
				if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvList.add(convvo[i]);
				}
			}
	
			if (insertConvList.size() > 0) {
				dbDao.addRfaNoteConvMst(insertConvList);
			}
			if (updateConvList.size() > 0) { // amend update 여부 제어 필요
				dbDao.modifyRfaNoteConvMst(updateConvList, "N");
			}
			if (deleteConvList.size() > 0) {
				dbDao.removeNoteConversion(deleteConvList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeRNoteConvCascadeRnote(deleteRnoteList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRNoteConvCascadeRouteMst(deleteRoutList);
				
				dbDao.removeRNoteConvDelAmend(deleteRoutList);
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
	 * Main Duration Effective Date변경시 Conversion 의 Effective Date를 변경한다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDate(PriRpScpMnVO[] priRpScpMnVO,SignOnUserAccount account)throws EventException{
		try {		
			if ( priRpScpMnVO != null ) {
				List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
				for ( int i=0; i<priRpScpMnVO .length; i++ ) {
					if ("U".equals(priRpScpMnVO[i].getIbflag())){
						priRpScpMnVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priRpScpMnVO[i]);
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
	 * Proposal Cancel시 Conversion을 삭제한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalConversion(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
		

	/**
	 * Master RFA의 APP Note Conversion을 처리한다.<br>
	 * 
	 * @param RsltRoutHdrSmryListVO appInfo
	 * @param String noteConvMapgId
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAppNoteConversion(RsltRoutHdrSmryListVO appInfo, String noteConvMapgId, SignOnUserAccount account) throws EventException{
		try {
			
			PriRfaNoteConvListVO appNoteConv = new PriRfaNoteConvListVO();
			
			appNoteConv.setNoteConvMapgId(noteConvMapgId);
			appNoteConv.setNoteConvTpCd("R");
			appNoteConv.setRtApplTpCd("S"); // Application
			appNoteConv.setSvcScpCd(appInfo.getSvcScpCd());
			appNoteConv.setPropNo(appInfo.getPropNo());
			appNoteConv.setAmdtSeq(appInfo.getAmdtSeq());
			appNoteConv.setChgRuleTpCd("R");
			appNoteConv.setNoteConvRuleCd("APP");
			appNoteConv.setEffDt(appInfo.getEffDt());
			appNoteConv.setExpDt(appInfo.getExpDt());
			appNoteConv.setNoteConvSeq(appInfo.getNoteConvSeq());
			appNoteConv.setBkgDirCallFlg(appInfo.getBkgDirCallFlg());
			appNoteConv.setBkgSlanCd(appInfo.getBkgSlanCd());
			// T/S port
			appNoteConv.setBkgTsPortDefCd(appInfo.getBkgTsPortDefCd());
			if(!appInfo.getBkgTsPortDefCd().equals("")) {
				appNoteConv.setBkgTsPortTpCd("L");
			}
			// bkg_vsl_cd
			if(!appInfo.getBkgVvdCd().equals("") && appInfo.getBkgVvdCd().length() == 9) {
				appNoteConv.setBkgVslCd(appInfo.getBkgVvdCd().substring(0, 4));
				appNoteConv.setBkgSkdVoyNo(appInfo.getBkgVvdCd().substring(4, 8));
				appNoteConv.setBkgSkdDirCd(appInfo.getBkgVvdCd().substring(8, 9));
			}
			
			appNoteConv.setCreUsrId(account.getUsr_id());
			appNoteConv.setUpdUsrId(account.getUsr_id());
			
			if(!appInfo.getNoteConvSeq().equals("")) {
				// Route & Summary에 네개 항목 모두 다 삭제 했을 경우 delete 처리
				if(appInfo.getBkgDirCallFlg().equals("") && appInfo.getBkgSlanCd().equals("") && appInfo.getBkgTsPortDefCd().equals("") && appInfo.getBkgVvdCd().equals("")) {
					List<PriRfaNoteConvListVO> list = new ArrayList<PriRfaNoteConvListVO>();
					list.add(appNoteConv);
					dbDao.removeNoteConversion(list);
				} else {
					dbDao.mergeMstNoteConversion(appNoteConv);
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
}