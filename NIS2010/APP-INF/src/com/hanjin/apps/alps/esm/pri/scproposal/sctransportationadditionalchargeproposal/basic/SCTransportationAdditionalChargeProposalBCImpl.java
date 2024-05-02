/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalBCImpl.java
*@FileTitle : S/C Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.18 김재연
* 1.0 Creation
=========================================================
* 2011.07.01 서미진 [CHM-201111837]  R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration.SCTransportationAdditionalChargeProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ArbitraryExcelDupCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstArbAcceptVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.IHCExcelDupCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltAddChgListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0003_04EventResponse,SCTransportationAdditionalChargeProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SCTransportationAdditionalChargeProposalBCImpl extends BasicCommandSupport implements SCTransportationAdditionalChargeProposalBC {
 
	// Database Access Object
	private transient SCTransportationAdditionalChargeProposalDBDAO dbDao = null;

	/**
	 * SCTransportationAdditionalChargeProposalBCImpl 객체 생성<br>
	 * SCTransportationAdditionalChargeProposalDBDAO를 생성한다.<br>
	 */
	public SCTransportationAdditionalChargeProposalBCImpl() {
		dbDao = new SCTransportationAdditionalChargeProposalDBDAO();
	} 
	
	/**
	 * Arbitrary List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeList(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Arbitrary List를 수정한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpTrspAddChgVO> insertVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			List<PriSpScpTrspAddChgVO> deleteVoList = new ArrayList<PriSpScpTrspAddChgVO>();
		
			for ( int i=0; i<priSpScpTrspAddChgVO .length; i++ ) {
				if ( priSpScpTrspAddChgVO[i].getIbflag().equals("I")){
					priSpScpTrspAddChgVO[i].setCreUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpScpTrspAddChgVO[i]);
				} else if ( priSpScpTrspAddChgVO[i].getIbflag().equals("U")){
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				} else if ( priSpScpTrspAddChgVO[i].getIbflag().equals("D")){
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addArbitraryCharge(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyArbitraryCharge(updateVoList, "N");
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeArbitraryCharge(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Arbitrary Accept를 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			
			for(int i=0; priSpScpTrspAddChgVO != null && i < priSpScpTrspAddChgVO.length; i++) {
				if(priSpScpTrspAddChgVO[i].getIbflag().equals("U")) {
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priSpScpTrspAddChgVO[i].setAcptDt(currentDate);
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}

			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
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
	 * Arbitrary Accept Cancel을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			
			for(int i=0; priSpScpTrspAddChgVO != null && i < priSpScpTrspAddChgVO.length; i++) {
				if(priSpScpTrspAddChgVO[i].getIbflag().equals("U")) {
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setFnlFrtRtAmt(null);
					priSpScpTrspAddChgVO[i].setAcptUsrId("");
					priSpScpTrspAddChgVO[i].setAcptOfcCd("");			
					priSpScpTrspAddChgVO[i].setAcptDt(null);
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
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
	 * Arbitrary Accept All을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			
			for(int i=0; priSpScpTrspAddChgVO != null && i < priSpScpTrspAddChgVO.length; i++) {
				if(priSpScpTrspAddChgVO[i].getIbflag().equals("U")) {
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priSpScpTrspAddChgVO[i].setAcptDt(currentDate);
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
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
	 * Arbitrary Accept All을 진행한다. <br>
	 * 
	 * @param CstArbAcceptVO cstArbAcceptVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllArbitraryChargeFast(CstArbAcceptVO cstArbAcceptVO, SignOnUserAccount account) throws EventException {
		int rValue = 0;
		try {
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if (cstArbAcceptVO != null){
				cstArbAcceptVO.setPrcProgStsCd("A");
				cstArbAcceptVO.setUpdUsrId(account.getUsr_id());					
				cstArbAcceptVO.setAcptUsrId(account.getUsr_id());
				cstArbAcceptVO.setAcptOfcCd(account.getOfc_cd());
				cstArbAcceptVO.setAcptDt(currentDate);
			}			
			rValue = dbDao.modifyAcceptAllArbitrary (cstArbAcceptVO);	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return rValue;
	}	
	
	
	/**
	 * Arbitrary Accept Cancel All을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			
			for(int i=0; priSpScpTrspAddChgVO != null && i < priSpScpTrspAddChgVO.length; i++) {
				if(priSpScpTrspAddChgVO[i].getIbflag().equals("U")) {
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setFnlFrtRtAmt(null);
					priSpScpTrspAddChgVO[i].setAcptUsrId("");
					priSpScpTrspAddChgVO[i].setAcptOfcCd("");			
					priSpScpTrspAddChgVO[i].setAcptDt(null);
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
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
	 * Arbitrary Accept Cancel All을 진행한다. <br>
	 * 
	 * @param CstArbAcceptVO cstArbAcceptVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllArbitraryChargeFast(CstArbAcceptVO cstArbAcceptVO, SignOnUserAccount account) throws EventException {
		int rValue = 0;
		try {
			if (cstArbAcceptVO != null){
				cstArbAcceptVO.setFnlFrtRtAmt(null);
				cstArbAcceptVO.setUpdUsrId(account.getUsr_id());					
				cstArbAcceptVO.setAcptUsrId("");
				cstArbAcceptVO.setAcptOfcCd("");
				cstArbAcceptVO.setAcptDt(null);
			}
			
			rValue = dbDao.modifyAcceptAllCancelArbitrary (cstArbAcceptVO);	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return rValue;
	}		
	
	/**
	 * IHC List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeList(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * IHC List의 변경 내역을 반영한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpTrspAddChgVO> insertVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			List<PriSpScpTrspAddChgVO> deleteVoList = new ArrayList<PriSpScpTrspAddChgVO>();
		
			for ( int i=0; i<priSpScpTrspAddChgVO .length; i++ ) {
				if ( priSpScpTrspAddChgVO[i].getIbflag().equals("I")){
					priSpScpTrspAddChgVO[i].setCreUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpScpTrspAddChgVO[i]);
				} else if ( priSpScpTrspAddChgVO[i].getIbflag().equals("U")){
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				} else if ( priSpScpTrspAddChgVO[i].getIbflag().equals("D")){
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addArbitraryCharge(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyArbitraryCharge(updateVoList, "N");
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeArbitraryCharge(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * IHC Accept를 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			
			for(int i=0; priSpScpTrspAddChgVO != null && i < priSpScpTrspAddChgVO.length; i++) {
				if(priSpScpTrspAddChgVO[i].getIbflag().equals("U")) {
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priSpScpTrspAddChgVO[i].setAcptDt(currentDate);
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * IHC Accept Cancel 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			
			for(int i=0; priSpScpTrspAddChgVO != null && i < priSpScpTrspAddChgVO.length; i++) {
				if(priSpScpTrspAddChgVO[i].getIbflag().equals("U")) {
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setFnlFrtRtAmt(null);
					priSpScpTrspAddChgVO[i].setAcptUsrId("");
					priSpScpTrspAddChgVO[i].setAcptOfcCd("");			
					priSpScpTrspAddChgVO[i].setAcptDt(null);
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * IHC Accept All을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			
			for(int i=0; priSpScpTrspAddChgVO != null && i < priSpScpTrspAddChgVO.length; i++) {
				if(priSpScpTrspAddChgVO[i].getIbflag().equals("U")) {
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priSpScpTrspAddChgVO[i].setAcptDt(currentDate);
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * IHC Accept Cancel All을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpTrspAddChgVO> updateVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			
			for(int i=0; priSpScpTrspAddChgVO != null && i < priSpScpTrspAddChgVO.length; i++) {
				if(priSpScpTrspAddChgVO[i].getIbflag().equals("U")) {
					priSpScpTrspAddChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpTrspAddChgVO[i].setFnlFrtRtAmt(null);
					priSpScpTrspAddChgVO[i].setAcptUsrId("");
					priSpScpTrspAddChgVO[i].setAcptOfcCd("");			
					priSpScpTrspAddChgVO[i].setAcptDt(null);
					updateVoList.add(priSpScpTrspAddChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyArbitraryCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Arbitrary Cuideline Copy를 진행한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineArbitraryCharge(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException {
		try {
			cstPriSpScpTrspAddChgVO.setCreUsrId(account.getUsr_id());
			cstPriSpScpTrspAddChgVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.addCopyGuidelineArbitraryCharge(cstPriSpScpTrspAddChgVO, account);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
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
//pri_sp_scp_trsp_add_chg)
			dbDao.addArbitraryChargeAmend (insertVoList);
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), de);
		}
	}

    /**
     * S/C Proposal Scope Transportation Additional Charge 데이터를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeTransport(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_TRSP_ADD_CHG COPY
            dbDao.addCopyProposalScopeTransport(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Guideline Origin/Destination Arbitrary 를 Proposal 로 Copy 합니다.<br>
     * 
     * @param vo SpScpGlineCopyVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void copyScopeGuidelineArbitrary(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
//            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_TRSP_ADD_CHG COPY
            dbDao.addCopyScopeGuidelineArbitrary(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
        }
    }
  
	/**
     * Guideline Copy 시 Copy할 Guideline이 존재하는지 확인한다. <br>
     * 
     * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
     * @return List<PriSgArbVO>
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeExist(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchGuidelineArbitraryChargeExist(cstPriSpScpTrspAddChgVO);
		} catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
     * Guideline Copy 시 Copy할 Guideline의 Gruop Location이 존재하는지 확인한다. <br>
     * 
     * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeGroupLocationExist(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchGuidelineArbitraryChargeGroupLocationExist(cstPriSpScpTrspAddChgVO);
		} catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalRequestCancel(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeProposal(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchFontStyle(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Creation - Arbitrary Amend History List를 조회합니다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeHistoryList(priSpScpTrspAddChgVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Arbitrary Amend History의 ORIGIN과 DESTINATION의 FONT STYLE를 조회한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchHistoryFontStyle(cstPriRpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * IHC Amend History List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeHistoryList(priSpScpTrspAddChgVO, priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Arbitrary Inquiry List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeInquiryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeInquiryList(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * IHC Inquiry List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeInquiryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeInquiryList(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalGRICalculationArbOK(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO, SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; pVO != null && i < pVO.length; i++) {
				if (pVO[i].getIbflag().equals("U")) {
					pVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyProposalGRICalculationArbOK(pVO[i]); // Arbitrary 항목 적용
				}
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용 취소를 한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalGRICalculationArbCancle(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO, SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; pVO != null && i < pVO.length; i++) {
				if (pVO[i].getIbflag().equals("U")) {
					pVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyProposalGRICalculationArbCancle(pVO[i]); // Arbitrary 항목 되돌리기.
				}
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
	 * Arbitrary와 IHC에서 중복을 확인합니다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] PriSpScpTrspAddChgVOs
	 * @return String
	 * @exception EventException
	 */
	public String checkArbitraryChargeDuplicate(PriSpScpTrspAddChgVO[] PriSpScpTrspAddChgVOs) throws EventException {
		String rtnVal = "";
		
		try {
			for(int i=0; i<PriSpScpTrspAddChgVOs.length; i++ ) {
				if(dbDao.searchArbitraryChargeDuplicate(PriSpScpTrspAddChgVOs[i])) {
					rtnVal = String.valueOf(i+1);
					break;
				}
			}
			return rtnVal;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Load Excel시 기존 데이터와의 중복 체크를 위하여 db에 저장되어 있는 <br>
	 * Arbitrary List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<ArbitraryExcelDupCheckVO>
	 * @exception EventException
	 */
	public List<ArbitraryExcelDupCheckVO> searchArbitraryLoadExcelDupList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryLoadExcelDupList(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Arbitrary upload 엑셀파일 데이터를 VALIDATION 체크한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs
	 * @return List<PriSpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgVO> searchCodeCheckResult(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs) throws EventException{
		try {
			List<PriSpScpTrspAddChgVO> checkVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();
			String propNo = priSpScpTrspAddChgVOs[0].getPropNo();
			String amdtSeq = priSpScpTrspAddChgVOs[0].getAmdtSeq();
			String svcScpCd = priSpScpTrspAddChgVOs[0].getSvcScpCd();

			for ( int i=0; i<priSpScpTrspAddChgVOs.length; i++ ) {
				//Point
				vo.setCd(priSpScpTrspAddChgVOs[i].getRoutPntLocDefCd());
				cdList = null;
				if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);
				}				
				if(cdList != null && cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setRoutPntLocDefCd("1");
				} else {
					priSpScpTrspAddChgVOs[i].setRoutPntLocDefCd("0");
				}
				
				//Base Port
				vo.setCd(priSpScpTrspAddChgVOs[i].getBsePortDefCd());
				vo.setEtc1(propNo);
				vo.setEtc2(amdtSeq);
				vo.setEtc3(svcScpCd);
				cdList = null;
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchGroupLocationExists(vo);
					log.debug("length=====4====="+vo.getCd().length());
				} else if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);
					log.debug("length=====5====="+vo.getCd().length());
				}    			
				
				if(cdList != null && cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setBsePortDefCd("1");
				} else {
					priSpScpTrspAddChgVOs[i].setBsePortDefCd("0");
				}
				
				//VIA
				vo.setCd(priSpScpTrspAddChgVOs[i].getViaPortDefCd());
				vo.setEtc1(propNo);
				vo.setEtc2(amdtSeq);
				vo.setEtc3(svcScpCd);
				cdList = null;
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchGroupLocationExists(vo);				
				} else if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);								
				}    	
				
				priSpScpTrspAddChgVOs[i].setViaPortDefCd("0");
				if(cdList != null && cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setViaPortDefCd("1");
				}			
				
				//COMMODITY
				vo.setCd(priSpScpTrspAddChgVOs[i].getPrcCmdtDefCd());
				vo.setEtc1(propNo);
				vo.setEtc2(amdtSeq);
				vo.setEtc3(svcScpCd);
				cdList = null;
				
				if(vo.getCd().length() == 5) {
					cdList = dbDao.searchGroupCommodityExists(vo);	
						
				} else {
					if (!"".equals(vo.getCd())){
						cdList = dbDao.searchCommodityExists(vo);	
					}					
				}    			
				priSpScpTrspAddChgVOs[i].setPrcCmdtDefCd("0");
				//2011-07-01 서미진 R4J Rule Upgrade : 객체에 null이 배정된 이후 객체에 대한 참조를 하지 않도록 변경
				if(cdList != null) {
			           if(cdList.size()>0){
			                     priSpScpTrspAddChgVOs[i].setPrcCmdtDefCd("1");
			           }
				}          
			
				checkVoList.add(priSpScpTrspAddChgVOs[i]);
			} 
			
			return checkVoList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);

		}
	}	 	
	
	/**
	 * Load Excel시 기존 데이터와의 중복 체크를 위하여 db에 저장되어 있는 <br>
	 * IHC Charge List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<IHCExcelDupCheckVO>
	 * @exception EventException
	 */
	public List<IHCExcelDupCheckVO> searchIHCLoadExcelDupList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchIHCLoadExcelDupList(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * IHC upload 엑셀파일 데이터를 VALIDATION 체크한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs
	 * @return List<PriSpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgVO> searchIhcCodeCheckResult(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs) throws EventException{
		try {
			List<PriSpScpTrspAddChgVO> checkVoList = new ArrayList<PriSpScpTrspAddChgVO>();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();
			String propNo = priSpScpTrspAddChgVOs[0].getPropNo();
			String amdtSeq = priSpScpTrspAddChgVOs[0].getAmdtSeq();
			String svcScpCd = priSpScpTrspAddChgVOs[0].getSvcScpCd();

			for ( int i=0; i<priSpScpTrspAddChgVOs.length; i++ ) {
				//Point
				vo.setCd(priSpScpTrspAddChgVOs[i].getRoutPntLocDefCd());
				cdList = null;
				if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);
				}				
				if(cdList != null && cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setRoutPntLocDefCd("1");
				} else {
					priSpScpTrspAddChgVOs[i].setRoutPntLocDefCd("0");
				}
				
				//Base Port
				vo.setCd(priSpScpTrspAddChgVOs[i].getBsePortDefCd());
				vo.setEtc1(propNo);
				vo.setEtc2(amdtSeq);
				vo.setEtc3(svcScpCd);
				cdList = null;
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchGroupLocationExists(vo);
					log.debug("length=====4====="+vo.getCd().length());
				} else if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);
					log.debug("length=====5====="+vo.getCd().length());
				}    			
				
				//2011-07-01 서미진 R4J Rule Upgrade : 객체에 null이 배정된 이후 객체에 대한 참조를 하지 않도록 변경
				if(cdList != null) {
			           if(cdList.size()>0){
			                     priSpScpTrspAddChgVOs[i].setBsePortDefCd("1");
			           }else {
							priSpScpTrspAddChgVOs[i].setBsePortDefCd("0");
					   } 
				}else {
					priSpScpTrspAddChgVOs[i].setBsePortDefCd("0");
				}  
				checkVoList.add(priSpScpTrspAddChgVOs[i]);
			} 
			
			return checkVoList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);

		}
	}	 	
	
	
	/**
	 * Init이외의 상태를 가지고 있는 데이터를 조회합니다.<br>
	 * 	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchArbGriCheck(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbGriCheck(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
	}	
	
}