/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalBCImpl.java
*@FileTitle : S/C Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration.SCTransportationAdditionalChargeProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ArbitraryExcelDupCheckVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstArbAcceptVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.IHCExcelDupCheckVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltAddChgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpTrspAddChgVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a BIZ logic about SCProposal<br>
 *
 * @author
 * @see ESM_PRI_0003_04EventResponse,SCTransportationAdditionalChargeProposalBC - Refer to each DAO class.
 * @since J2EE 1.4
 */
public class SCTransportationAdditionalChargeProposalBCImpl extends BasicCommandSupport implements SCTransportationAdditionalChargeProposalBC {

	// Database Access Object
	private transient SCTransportationAdditionalChargeProposalDBDAO dbDao = null;

	/**
	 * Creating SCTransportationAdditionalChargeProposalBCImpl Object<br>
	 * Creating SCTransportationAdditionalChargeProposalDBDAO<br>
	 */
	public SCTransportationAdditionalChargeProposalBCImpl() {
		dbDao = new SCTransportationAdditionalChargeProposalDBDAO();
	}
	
	/**
	 *Retrieving Arbitrary List <br>
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
	 * Modifying Arbitrary List<br>
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
	 * Accepting Arbitrary<br>
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
	 * Cancelling Arbitrary Accept <br>
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
	 * Accepting all of Arbitrary <br>
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
	 * Accepting all of Arbitrary <br>
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
				rValue = dbDao.modifyAcceptAllArbitrary (cstArbAcceptVO);
			}				
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
	 * Cancelling all acceptance of Arbitrary<br>
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
	 * Cancelling all aceeptance of Arbitrary<br>
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
				rValue = dbDao.modifyAcceptAllCancelArbitrary (cstArbAcceptVO);	
			}
			
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
	 * Retrieving IHC List <br>
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
	 * Applying a history of IHC List<br>
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
	 * Accept IHC <br>
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
	 * Cancelling a acceptance of IHC<br>
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
	 * Accepting all of IHC<br>
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
	 * Cancelling all acceptance of IHC<br>
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
	 * Copying Arbitrary Guideline <br>
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
	 * Handling a request of Amend <br>
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
     * Copying S/C Proposal Scope Transportation Additional Charge data<br>
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
     * Copying Guideline Origin/Destination Arbitrary to Proposal.<br>
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
     * Checking whether Guideline to be copied exists or not when copying Guideline<br>
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
     * Checking whether group location of guideline to be copied exists or not when copying guideline<br>
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
	 * Changing accepted datas of Main duration to "init" at one time when cancelling rquest<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());		
				dbDao.modifyProposalRequestCancel(priSpScpMnVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00210",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Deleting all datas of related Amend Seq No when cancelling "Init" status of Main<br>
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
	 * Retrieving font style of Arbitrary's ORIGIN& DESTINATION<br>
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
	 * Retrieving S/C Proposal Creation - Arbitrary Amend History List<br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeHistoryList(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *Retrieving  Arbitrary Amend History's ORIGIN& DESTINATION<br>
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
	 * Retrieving IHC Amend History List<br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeHistoryList(priSpScpTrspAddChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Arbitrary Inquiry List<br>
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
	 * Retrieving IHC Inquiry List<br>
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
	 * Applying GRI on GRI Calculation - Arbitrary screen <br>
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
					dbDao.modifyProposalGRICalculationArbOK(pVO[i]); // Applying Arbitrary item
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
	 * Cancelling applied GRI on GRI Calculation - Arbitrary screen <br>
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
					dbDao.modifyProposalGRICalculationArbCancle(pVO[i]); //rollback Arbitrary item
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
	 * Checking duplication of Arbitrary& IHC<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] PriSpScpTrspAddChgVOs
	 * @return String
	 * @exception EventException
	 */
	public String checkArbitraryChargeDuplicate(PriSpScpTrspAddChgVO[] PriSpScpTrspAddChgVOs) throws EventException {
		String rtnVal = "";
		
		try {
			for(int i=0; i<PriSpScpTrspAddChgVOs.length; i++ ) {
				String check = "";
				check = dbDao.searchArbitraryChargeDuplicate(PriSpScpTrspAddChgVOs[i]);		
				if(check != null) {
					if (rtnVal.equals("")){
						rtnVal = rtnVal + check;
					}else{
						rtnVal = rtnVal +"\n"+ check;
					}
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
	 * Retrieving Arbitrary list to check duplicating with existing data when loading excel file<br>
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
	 * Checking a validation of uploaded Arbitrary excel data<br>
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
				cdList = new ArrayList<RsltCdListVO>();
				if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);
				}
				//if(cdList != null && cdList.size()>0) {
				if(cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setRoutPntLocDefCd("1");
				} else {
					priSpScpTrspAddChgVOs[i].setRoutPntLocDefCd("0");
				}
				
				//Base Port
				vo.setCd(priSpScpTrspAddChgVOs[i].getBsePortDefCd());
				vo.setEtc1(propNo);
				vo.setEtc2(amdtSeq);
				vo.setEtc3(svcScpCd);
				cdList = new ArrayList<RsltCdListVO>();
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchGroupLocationExists(vo);
					log.debug("length=====4====="+vo.getCd().length());
				} else if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);
					log.debug("length=====5====="+vo.getCd().length());
				}    			
				
				//if(cdList != null && cdList.size()>0) {
				if(cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setBsePortDefCd("1");
				} else {
					priSpScpTrspAddChgVOs[i].setBsePortDefCd("0");
				}
				
				//VIA
				vo.setCd(priSpScpTrspAddChgVOs[i].getViaPortDefCd());
				vo.setEtc1(propNo);
				vo.setEtc2(amdtSeq);
				vo.setEtc3(svcScpCd);
				cdList = new ArrayList<RsltCdListVO>();
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchGroupLocationExists(vo);				
				} else if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);								
				}    	
				
				priSpScpTrspAddChgVOs[i].setViaPortDefCd("0");
				//if(cdList != null && cdList.size()>0) {
				if(cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setViaPortDefCd("1");
				}			
				
				//COMMODITY
				vo.setCd(priSpScpTrspAddChgVOs[i].getPrcCmdtDefCd());
				vo.setEtc1(propNo);
				vo.setEtc2(amdtSeq);
				vo.setEtc3(svcScpCd);
				cdList = new ArrayList<RsltCdListVO>();
				
				if(vo.getCd().length() == 5) {
					cdList = dbDao.searchGroupCommodityExists(vo);	
						
				} else {
					if (!"".equals(vo.getCd())){
						cdList = dbDao.searchCommodityExists(vo);	
					}					
				}    			
				priSpScpTrspAddChgVOs[i].setPrcCmdtDefCd("0");
				//if(cdList != null && cdList.size()>0) {
				if(cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setPrcCmdtDefCd("1");
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
	 * Retrieving IHC Charge List to check duplicating with existing data when loading excel file<br>
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
	 * Checking validation of IHC upload Excel file data.<br>
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
				cdList = new ArrayList<RsltCdListVO>();
				if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);
				}	
				
				//if(cdList != null && cdList.size()>0) {
				if(cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setRoutPntLocDefCd("1");
				} else {
					priSpScpTrspAddChgVOs[i].setRoutPntLocDefCd("0");
				}
				
				//Base Port
				vo.setCd(priSpScpTrspAddChgVOs[i].getBsePortDefCd());
				vo.setEtc1(propNo);
				vo.setEtc2(amdtSeq);
				vo.setEtc3(svcScpCd);
				cdList = new ArrayList<RsltCdListVO>();
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchGroupLocationExists(vo);
					log.debug("length=====4====="+vo.getCd().length());
				} else if(vo.getCd().length() == 5){
					cdList = dbDao.searchLocationExists(vo);
					log.debug("length=====5====="+vo.getCd().length());
				}    			
				
				//if(cdList != null && cdList.size()>0) {
				if(cdList.size()>0) {
					priSpScpTrspAddChgVOs[i].setBsePortDefCd("1");
				} else {
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
	 * Retrieving datas without INIT status<br>
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
	
	
	/**
	 * Retrieving note sequence and content distinctly in current amend<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO>searchCurrentNoteSeqContent(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs) throws EventException {
		try {
			return dbDao.searchCurrentNoteSeqContent(priSpScpTrspAddChgVOs);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
	}
	
}