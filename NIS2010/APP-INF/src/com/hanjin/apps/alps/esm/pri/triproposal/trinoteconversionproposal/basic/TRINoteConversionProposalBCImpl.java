/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalBCImpl.java
*@FileTitle : Tariff Fomula Rule Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration.TRINoteConversionProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.vo.RsltPriTriNoteConvVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTriNoteConvVO;
import com.hanjin.syscommon.common.table.PriTriNoteVO;
import com.hanjin.syscommon.common.table.PriTriRtVO;

/**
 * ALPS-TRIProposal Business Logic Command Interface<br>
 * - ALPS-TRIProposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @since J2EE 1.6
 */
public class TRINoteConversionProposalBCImpl extends BasicCommandSupport implements TRINoteConversionProposalBC {

	// Database Access Object
	private transient TRINoteConversionProposalDBDAO dbDao = null;

	/**
	 * TRINoteConversionProposalBCImpl 객체 생성<br>
	 * TRINoteConversionProposalDBDAO를 생성한다.<br>
	 */
	public TRINoteConversionProposalBCImpl() {
		dbDao = new TRINoteConversionProposalDBDAO();
	}

	/**
	 * Tariff Fomula Rule 화면에서 Duration 리스트를 조회한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @return List<PriTriNoteVO>
	 * @exception EventException
	 */
	public List<PriTriNoteVO> searchTRIFomulaRuleInfo(PriTriNoteVO priTriNoteVO) throws EventException {
		try {
			return dbDao.searchTRIFomulaRuleInfo(priTriNoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Note 정보를 조회한다.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltPriTriNoteConvVO> searchNoteConversionList(PriTriNoteConvVO priTriNoteConvVO) throws EventException {
		try {
			return dbDao.searchNoteConversionList(priTriNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 복사된 TRI NOTE CONVERSION 데이터를 조회합니다.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltPriTriNoteConvVO> searchNoteConversionCopyList(PriTriNoteConvVO priTriNoteConvVO, SignOnUserAccount account) throws EventException {
		try {
			//로그인 아이디로 조회
			priTriNoteConvVO.setCreUsrId(account.getUsr_id());
			
			return dbDao.searchNoteConversionCopyList(priTriNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Note 정보를 저장합니다.<br>
	 * 
	 * @param PriTriNoteConvListVO[] priTriNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(PriTriNoteConvListVO[] priTriNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriTriNoteConvListVO> insertVoList = new ArrayList<PriTriNoteConvListVO>();
			List<PriTriNoteConvListVO> updateVoList = new ArrayList<PriTriNoteConvListVO>();
			List<PriTriNoteConvListVO> deleteVoList = new ArrayList<PriTriNoteConvListVO>();
			
			if(priTriNoteConvListVOs != null){
				for ( int i=0; i<priTriNoteConvListVOs .length; i++ ) {
					if ( priTriNoteConvListVOs[i].getIbflag().equals("I")){
						priTriNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
						priTriNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(priTriNoteConvListVOs[i]);
					} else if ( priTriNoteConvListVOs[i].getIbflag().equals("U")){
						priTriNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priTriNoteConvListVOs[i]);
					} else if ( priTriNoteConvListVOs[i].getIbflag().equals("D")){
						deleteVoList.add(priTriNoteConvListVOs[i]);
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
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * TRI Note 정보를 복사합니다.<br>
	 * 
	 * @param PriTriNoteConvListVO[] priTriNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriTriNoteConvListVO[] priTriNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriTriNoteConvListVO> insertVoList = new ArrayList<PriTriNoteConvListVO>();
			
			for ( int i=0; i<priTriNoteConvListVOs .length; i++ ) {
				if ( priTriNoteConvListVOs[i].getIbflag().equals("I")){
					priTriNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
					priTriNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priTriNoteConvListVOs[i]);
				}
			}			
			if ( insertVoList.size() > 0 ) {
				dbDao.removeNoteConversionCopy(priTriNoteConvListVOs[0]);				
				dbDao.addNoteConversionCopy(insertVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SERVICE SCOPE CODE를 조회한다. <br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws EventException {
		try {
			return dbDao.searchServiceScopeCodeList(priTriNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Tariff Fomula Rule 정보를 저장합니다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException{
		try {
			String tNoteSeq = priTriNoteVO.getNoteSeq();
			boolean isValidDate = dbDao.searchTRIFomulaRuleEffDate(priTriNoteVO);

			if (!isValidDate) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			
			if(tNoteSeq.equals("") || tNoteSeq.equals("X")) {
				priTriNoteVO.setUpdUsrId(account.getUsr_id());
				priTriNoteVO.setCreUsrId(account.getUsr_id());
				//create
				dbDao.addTRIFomulaRule(priTriNoteVO);
			} else {
				priTriNoteVO.setUpdUsrId(account.getUsr_id());				
				//update
				dbDao.modifyTRIFomulaRule(priTriNoteVO, "N");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Fomula Rule 정보를 Confirmation 합니다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException{
		try {			
			priTriNoteVO.setCfmFlg("Y");
			priTriNoteVO.setCfmUsrId(account.getUsr_id());
			priTriNoteVO.setCfmOfcCd(account.getOfc_cd());
			priTriNoteVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyTRIFomulaRule(priTriNoteVO, "Y");
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Tariff Fomula Rule 정보를 Confirm Cancel 합니다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException{
		try {			
			priTriNoteVO.setCfmFlg("N");
			priTriNoteVO.setCfmUsrId("");
			priTriNoteVO.setCfmOfcCd("");
			priTriNoteVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyTRIFomulaRule(priTriNoteVO, "Y");
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Tariff Fomula Rule 정보를 Delete 합니다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @exception EventException
	 */
	public void deleteTRIFomulaRule(PriTriNoteVO priTriNoteVO) throws EventException{
		try {		
			dbDao.removeNoteConversion(priTriNoteVO);
			dbDao.removeTRIFomulaRule(priTriNoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Proposal 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param TriPropVO triPropVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public void manageTRIRateProposal(TriPropVO triPropVO, SignOnUserAccount account) throws EventException {
		try {
			PriTriRtVO[] rtvo = triPropVO.getPriTriRtVOS();

			List<PriTriRtVO> updateRtList = new ArrayList<PriTriRtVO>();

			for (int i = 0; rtvo != null && i < rtvo.length; i++) {
				if (rtvo[i].getIbflag().equals("U")) {
					rtvo[i].setUpdUsrId(account.getUsr_id());
					updateRtList.add(rtvo[i]);
				}
			}

			if (updateRtList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeRt(updateRtList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Proposal 데이터를 Amend한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				priTriRtVO.setCreUsrId(account.getUsr_id());
				priTriRtVO.setUpdUsrId(account.getUsr_id());
				dbDao.addCopyNoteConversionOnAmend(priTriRtVO);
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
	 * TRI Proposal 데이터를 Cancel한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				String sPropStsCd = priTriRtVO.getPropStsCd();
				
				if ("I".equals(sPropStsCd)) { // Initial. 해당로우를 삭제함.
					dbDao.removeNoteConversionOnCancel(priTriRtVO);
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
	 * 다건의 TRI Proposal 데이터를 Cancel한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					String sPropStsCd = priTriRtVOs[i].getPropStsCd();
				
					if ("I".equals(sPropStsCd)) { // Initial. 해당로우를 삭제함.
						dbDao.removeNoteConversionOnCancel(priTriRtVOs[i]);
					}
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
	 * TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				priTriRtVO.setPropStsCd("F");
				priTriRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyNoteConversionDurationOnPublish(priTriRtVO);
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
	 * 다건의 TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					priTriRtVOs[i].setPropStsCd("F");
					priTriRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyNoteConversionDurationOnPublish(priTriRtVOs[i]);
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
	 * GRI Calculation을 적용합니다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException {
		try {
			if (triPropGRIVO != null) {
				dbDao.addCopyNoteConversionOnGRIApply(triPropGRIVO);
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
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException {
		try {
			if (triPropGRIVO != null) {
				dbDao.removeNoteConversionOnGRICancel(triPropGRIVO);
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
	 * SCOPE 별 사용자 승인권한 유무를 조회한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthScopeCount(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException {
		try {
			String authCount = "";
		  	String noteSeq = priTriNoteVO.getNoteSeq();
            if(noteSeq.equals("") || noteSeq.equals("X")) {
            	priTriNoteVO.setCreUsrId(account.getUsr_id());
            	authCount = dbDao.searchAuthScopeCount(priTriNoteVO);
            } else {
            	authCount = "0";
            }
            
            return authCount;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Tariff Code 에 해당하는 Service Scope 별 RULE CODE, CHARGE CODE를 조회한다.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRuleChargeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws EventException {
		try {
			return dbDao.searchRuleChargeCodeList(priTriNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

}