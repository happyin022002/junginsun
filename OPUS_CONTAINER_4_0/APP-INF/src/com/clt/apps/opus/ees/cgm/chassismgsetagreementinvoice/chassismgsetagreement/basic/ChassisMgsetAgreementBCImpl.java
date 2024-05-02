/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementBCImpl.java
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBC;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration.ChassisMgsetAgreementDBDAO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ChassisMgsetAgreementInvoice Business Logic Basic Command implementation<br>
 * - OPUS-ChassisMgsetAgreementInvoice biz logic handling.<br>
 *
 * @author 
 * @see ees_cgm_1021EventResponse,ChassisMgsetAgreementBC each DAO class reference
 * @since J2EE 1.4
 */
public class ChassisMgsetAgreementBCImpl extends BasicCommandSupport implements ChassisMgsetAgreementBC {

	// Database Access Object
	private transient ChassisMgsetAgreementDBDAO dbDao = null;

	/**
	 * ChassisMgsetAgreementBCImpl objects creation<br>
	 * ChassisMgsetAgreementDBDAO creation.<br>
	 */
	public ChassisMgsetAgreementBCImpl() {
		dbDao = new ChassisMgsetAgreementDBDAO();
	}
	
	/**
	 * Retrieve Chassis Eq lease agreement list [EES_CGM_1021]<br>
	 * 
	 * @param chsAgreementListINVO CHSAgreementListINVO 
	 * @return List<CHSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<CHSAgreementListMGTVO> searchCHSAgreementListBasic(CHSAgreementListINVO chsAgreementListINVO) throws EventException {
		try {
			return dbDao.searchCHSAgreementListData(chsAgreementListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve M.G.Set Eq lease agreement list. [EES_CGM_2023]<br>
	 * 
	 * @param mgsAgreementListINVO MGSAgreementListINVO 
	 * @return List<MGSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<MGSAgreementListMGTVO> searchMGSAgreementListBasic(MGSAgreementListINVO mgsAgreementListINVO) throws EventException {
		try {
			return dbDao.searchMGSAgreementListData(mgsAgreementListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve lease agreement info. [EES_CGM_1117]<br>
	 * 
	 * @param chsAgreementListINVO CHSAgreementListINVO 
	 * @return List<CHSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<CHSAgreementListMGTVO> searchCHSAgreementSelectionListBasic(CHSAgreementListINVO chsAgreementListINVO) throws EventException {
		try {
			return dbDao.searchCHSAgreementSelectionListData(chsAgreementListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve lease agreement info. [EES_CGM_2022]<br>
	 * 
	 * @param mgsAgreementListINVO MGSAgreementListINVO 
	 * @return List<MGSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<MGSAgreementListMGTVO> searchMGSAgreementSelectionListBasic(MGSAgreementListINVO mgsAgreementListINVO) throws EventException {
		try {
			return dbDao.searchMGSAgreementSelectionListData(mgsAgreementListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}	
	
	/**
	 * agreement info and (by Type Size) Depreciation rate & initial rate, <br>
	 * Surcharge, Rental rate etc information retrieve. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return CHSAgreementGroupVO
	 * @exception EventException
	 */
	public CHSAgreementGroupVO searchCHSAgreementAllBasic(CHSAgreementINVO chsAgreementINVO) throws EventException {
		
		CHSAgreementGroupVO agmtList = new CHSAgreementGroupVO();
		
		try {
			// Map object for ETC Data
			Map<String, String> etcData = new HashMap<String, String>();
	 
			//----------------------------
			// Agreement Main data retrieve
			//----------------------------
			List<CHSAgreementMGTVO> agreementList = dbDao.searchCHSAgreementMainData(chsAgreementINVO);
			
			CHSAgreementMGTVO agreementInfo = new CHSAgreementMGTVO();
			
			if(agreementList != null){
				if(agreementList.size() > 0){

					agreementInfo = (CHSAgreementMGTVO)agreementList.get(agreementList.size()-1);
				
					// Agreement Number setting
					String agmtSeq = "000000" + agreementInfo.getAgmtSeq();
					String agmtNo =  agreementInfo.getAgmtOfcCtyCd() + agmtSeq.substring(agmtSeq.length() - 6)  ;
					
					// INVO setting 
					agreementInfo.setAgmtNo(agmtNo);
					chsAgreementINVO.setAgmtVerNo(agreementInfo.getAgmtVerNo());	// 
					chsAgreementINVO.setEqRntlTpCd(agreementInfo.getEqRntlTpCd());	// CGM_AGMT_LSE_TR_RT retrieve  CODE 
					
				}
			}
			
			
			etcData = agreementInfo.getColumnValues();
			
			agmtList.setEtcData(etcData);
//			agmtList.add(etcData);
			
			
			// etc information
			if(agreementList != null){
				if(agreementList.size() > 0){
					//------------------------------
					//	CGM_AGMT_LSE_RT retrieve
					//-------------------------------
					List<CHSAgreementMGTVO> chsAgreementLseRtData = dbDao.searchCHSAgreementLseRtData(chsAgreementINVO);
					agmtList.setChsagreementmgtvo(chsAgreementLseRtData);
//					agmtList.add(chsAgreementLseRtData);
					
					//------------------------------
					// CGM_AGMT_LSE_SCG retrieve
					//------------------------------
					List<CHSAgreementMGTVO> chsAgreementLseScgData = dbDao.searchCHSAgreementLseScgData(chsAgreementINVO);
					agmtList.setChsagreementmgtvo2(chsAgreementLseScgData);
//					agmtList.add(chsAgreementLseScgData);
					
					//-----------------------------
					// CGM_AGMT_LSE_TR_RT retrieve
					//-----------------------------
					List<CHSAgreementMGTVO> chsAgreementLseTrRtData = dbDao.searchCHSAgreementLseTrRtData(chsAgreementINVO);
					agmtList.setChsagreementmgtvo3(chsAgreementLseTrRtData);
//					agmtList.add(chsAgreementLseTrRtData);
					
					//-------------------------------
					// Version No list setting
					//------------------------------
					chsAgreementINVO.setAgmtVerNo("");	// for Agreement No data getting
					List<CHSAgreementMGTVO> agreementList2 = dbDao.searchCHSAgreementMainData(chsAgreementINVO);
					agmtList.setChsagreementmgtvo4(agreementList2);
//					agmtList.add(agreementList2);
				}
			} 
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return agmtList;
	}	
	
	/**
	 * New Agreement creation and existed Agreement information editing. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVOs List<CHSAgreementINVO[]> 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return CHSAgreementMGTVO
	 * @exception EventException
	 */
	public CHSAgreementMGTVO modifyCHSAgreementBasic(List<CHSAgreementINVO[]> chsAgreementINVOs, 
			CHSAgreementINVO chsAgreementINVO, SignOnUserAccount account) throws EventException {
		
		CHSAgreementMGTVO chsAgreementMGTVO = new CHSAgreementMGTVO();
		
		try {
			
			// var setting
			String actionFlag = chsAgreementINVO.getActionFlag();
			String chssPoolCd = chsAgreementINVO.getChssPoolCd();
			String agmtOfcCtyCd = "";
			String agmtSeq = "";
			
			// new insert -> Agreement No creation
			if(actionFlag.equalsIgnoreCase("N")){
				agmtOfcCtyCd = chsAgreementINVO.getAgmtIssOfcCd().substring(0, 3);
				agmtSeq = dbDao.searchCHSAgreemetAgmtSeqData(chsAgreementINVO);
				
				// Agreement No ->  VO setting
				chsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);	
				chsAgreementINVO.setAgmtSeq(agmtSeq);
				chsAgreementINVO.setAgmtVerNo("1");
				
				String tempAgmtSeq = "000000" + agmtSeq;
				String tempAgmtNo = agmtOfcCtyCd + tempAgmtSeq.substring(tempAgmtSeq.length() - 6) ;
				chsAgreementINVO.setAgmtNo(tempAgmtNo);
				
			}
			
			if(actionFlag.equalsIgnoreCase("V")){
				String preVerNo = String.valueOf(Integer.parseInt(chsAgreementINVO.getAgmtVerNo())-1);
				String agmtVerNo = chsAgreementINVO.getAgmtVerNo();
				chsAgreementINVO.setAgmtVerNo(preVerNo);
				// Charge Creation  data existing check
				boolean chkChargeCreData = dbDao.checkCHSExistChgCreDataByAgreementData(chsAgreementINVO);
				if(!chkChargeCreData){
					throw new EventException(new ErrorHandler("CGM20033",new String[]{}).getMessage());
				}
				chsAgreementINVO.setAgmtVerNo(agmtVerNo);
			}

			List<CHSAgreementMGTVO> chkPoolMatch = null;
			if(!chssPoolCd.equals("") && chssPoolCd != null){
				chkPoolMatch = dbDao.checkCHSAgreementPoolMatchData(chsAgreementINVO);
				if(chkPoolMatch != null){
					if(chkPoolMatch.size() > 0){
						String sAgmtOfcCtyCd = chkPoolMatch.get(0).getAgmtOfcCtyCd();
						String sAgmtSeq = chkPoolMatch.get(0).getAgmtSeq();
						String sAgmtNo = sAgmtOfcCtyCd + JSPUtil.getLPAD(sAgmtSeq, 6, "0");
						

						throw new EventException(new ErrorHandler("CGM20014",new String[]{sAgmtNo}).getMessage());
					}
				}
			} 
			
			/*---------------------------------------------
			 * process action start
			 *-------------------------------------------*/
			// CGM_AGREEMENT data existing check
			List<CHSAgreementMGTVO> agmtList = dbDao.searchCHSAgreementMainData(chsAgreementINVO);
				
			if(agmtList != null){
		
				if(agmtList.size() > 0){
					/*--------------------------------
						CGM_AGREEMENT Modify
					----------------------------------*/
					String agmtNo = chsAgreementINVO.getAgmtNo();
					agmtOfcCtyCd = agmtNo.substring(0, 3);
					agmtSeq = agmtNo.substring(3);
						
					chsAgreementINVO.setCreUsrId(account.getUsr_id());
					chsAgreementINVO.setUpdUsrId(account.getUsr_id());
					chsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);
					chsAgreementINVO.setAgmtSeq(agmtSeq);
						
					dbDao.modifyCHSAgreemetMainData(chsAgreementINVO);
				} else {
					/*----------------------------------
					 	CGM_AGREEMENT Insert
					 -----------------------------------*/
					chsAgreementINVO.setCreUsrId(account.getUsr_id());
					chsAgreementINVO.setUpdUsrId(account.getUsr_id());
					chsAgreementINVO.setLstVerFlg("Y");	
					
					dbDao.addCHSAgreemetMainData(chsAgreementINVO);
					dbDao.modifyEQAgreementVersionData(chsAgreementINVO);
					List<CHSStatusInfoINVO> list = dbDao.searchEQAgmtListData(chsAgreementINVO);
					for(int i = 0; i < list.size(); i++){
						chsAgreementINVO.setEqNo(list.get(i).getEqNo());
						dbDao.addEQAgreementHisData(chsAgreementINVO);
					}

					if(actionFlag.equalsIgnoreCase("V")){
						CHSAgreementINVO preVO = new CHSAgreementINVO();
						String preAgmtVerNo = String.valueOf(Integer.parseInt(chsAgreementINVO.getAgmtVerNo())-1);
						String effDt = chsAgreementINVO.getEffDt().replaceAll("-", "");
						//String expDt = chsAgreementINVO.getExpDt().replaceAll("-", "");
						String preEffDt = chsAgreementINVO.getPreEffDt().replaceAll("-", "");
						String preExpDt = chsAgreementINVO.getPreExpDt().replaceAll("-", "") ;
							
						preVO.setAgmtOfcCtyCd(chsAgreementINVO.getAgmtOfcCtyCd());
						preVO.setAgmtSeq(chsAgreementINVO.getAgmtSeq());
						preVO.setAgmtVerNo(preAgmtVerNo);
						preVO.setEqKndCd(chsAgreementINVO.getEqKndCd());
						preVO.setUpdUsrId(account.getUsr_id());
						preVO.setLstVerFlg("N");
					

						int day = 1;
						if(effDt.compareTo(preEffDt) > 0 && effDt.compareTo(preExpDt) <= 0){
							SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd", java.util.Locale.KOREA);
							Date date = formatter.parse(effDt);
							date.setTime(date.getTime() - ((long)day * 1000 * 60 * 60 * 24));
							preExpDt = formatter.format(date);
						}
							
						preVO.setEffDt(preEffDt);
						preVO.setExpDt(preExpDt);
							
						// Previous data modification 
						dbDao.modifyCHSAgreemetPreviousMainData(preVO);
							
					}
				}
					
				/*--------------------------------------------
			 		CGM_AGMT_LSE_RT
			 	---------------------------------------------*/
				CHSAgreementINVO[] lseRt1VO = (CHSAgreementINVO[])chsAgreementINVOs.get(0);
				CHSAgreementINVO[] lseScgVO = (CHSAgreementINVO[])chsAgreementINVOs.get(1);
				CHSAgreementINVO[] lseRt2VO = (CHSAgreementINVO[])chsAgreementINVOs.get(2);
				CHSAgreementINVO[] lseTrRt1VO = (CHSAgreementINVO[])chsAgreementINVOs.get(3);
				CHSAgreementINVO[] lseTrRt2VO = (CHSAgreementINVO[])chsAgreementINVOs.get(4);

				if(lseRt1VO != null){
					List<CHSAgreementINVO> lseRtList = new ArrayList<CHSAgreementINVO>();
					
					if(lseRt2VO != null){
							
						if(chsAgreementINVO.getEqRntlTpCd().equals("F")){
							lseRtList = setLseRtDataList(chsAgreementINVO, lseRt1VO[0], lseRt2VO[0]);
						} else {
							lseRtList = setLseRtDataList(chsAgreementINVO, lseRt1VO[0], null);
						}
					} else {
						lseRtList = setLseRtDataList(chsAgreementINVO, lseRt1VO[0], null);
					}
					
					dbDao.removeCHSAgreementLseRtData(chsAgreementINVO);
					dbDao.addCHSAgreementLseRtData(lseRtList);
				}
					
				/*----------------------------------
				 	CGM_AGMT_LSE_SCG 
				 -----------------------------------*/
				if(lseScgVO != null){
					List<CHSAgreementINVO> lseScgList = new ArrayList<CHSAgreementINVO>();
					for(int i = 0; i < lseScgVO.length; i++){
						CHSAgreementINVO tempVo = lseScgVO[i];
						String steCd = JSPUtil.getNull(lseScgVO[i].getSteCd());
							

						if(!steCd.equals("") && !lseScgVO[i].getIbflag().equalsIgnoreCase("D")){
							tempVo.setAgmtOfcCtyCd(chsAgreementINVO.getAgmtOfcCtyCd());
							tempVo.setAgmtSeq(chsAgreementINVO.getAgmtSeq());
							tempVo.setAgmtVerNo(chsAgreementINVO.getAgmtVerNo());
							tempVo.setEqKndCd(chsAgreementINVO.getEqKndCd());
							tempVo.setCreUsrId(account.getUsr_id());
							tempVo.setUpdUsrId(account.getUsr_id());
							
							lseScgList.add(tempVo);
						}
					}
						
					dbDao.removeCHSAgreementLseScgData(chsAgreementINVO);
					dbDao.addCHSAgreementLseScgData(lseScgList);
				}

				/*-------------------------------------
					CGM_AGMT_LSE_TR_RT
				 -------------------------------------*/
				if(lseTrRt1VO != null || lseTrRt2VO != null){
					
					if(chsAgreementINVO.getEqRntlTpCd().equals("F")){
						dbDao.removeCHSAgreementLseTrRtData(chsAgreementINVO);
					} else {
						
						List<CHSAgreementINVO> lseTrRtList = new ArrayList<CHSAgreementINVO>();
						
						if(chsAgreementINVO.getEqRntlTpCd().equals("U")){
							lseTrRtList = setLseTrRtDataList(chsAgreementINVO, lseTrRt1VO);
						} else if(chsAgreementINVO.getEqRntlTpCd().equals("D")) {
							lseTrRtList = setLseTrRtDataList(chsAgreementINVO, lseTrRt2VO);
						}
							
						dbDao.removeCHSAgreementLseTrRtData(chsAgreementINVO);
						dbDao.addCHSAgreementLseTrRtData(lseTrRtList);
					}
				}
			}
			
			
			chsAgreementMGTVO.setAgmtNo(chsAgreementINVO.getAgmtNo());
			chsAgreementMGTVO.setAgmtOfcCtyCd(chsAgreementINVO.getAgmtOfcCtyCd());
			chsAgreementMGTVO.setAgmtSeq(chsAgreementINVO.getAgmtSeq());
			chsAgreementMGTVO.setAgmtVerNo(chsAgreementINVO.getAgmtVerNo());
			chsAgreementMGTVO.setLstVerFlg(chsAgreementINVO.getLstVerFlg());
			
			
		} catch (EventException ex){
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
				
		return chsAgreementMGTVO;
	}
	
	/**
	 * selected Agreement  deleting handling . [EES_CGM_1020] <br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeCHSAgreementBasic(CHSAgreementINVO chsAgreementINVO, SignOnUserAccount account) throws EventException{
		try {
			/*---------------------------
			 	Validation check
			 ----------------------------*/

			if(!chsAgreementINVO.getLstVerFlg().equals("Y")){ 
				throw new EventException(new ErrorHandler("CGM20007",new String[]{}).getMessage());
			}
				
			boolean chkChargeCreData = dbDao.checkCHSExistChgCreDataByAgreementData(chsAgreementINVO);
			if(!chkChargeCreData){
				throw new EventException(new ErrorHandler("CGM20034",new String[]{}).getMessage());
			}
			
			if(chsAgreementINVO.getAgmtVerNo().equals("1")){
				boolean checkUseEquipment = dbDao.checkCHSAgreementUseEquipmentData(chsAgreementINVO);
				if(checkUseEquipment){

					throw new EventException(new ErrorHandler("CGM20016",new String[]{}).getMessage());
				} 
			} 
//			else {
//
//				boolean chkChargeCreData = dbDao.checkCHSExistChgCreDataByAgreementData(chsAgreementINVO);
//				if(!chkChargeCreData){
//					throw new EventException(new ErrorHandler("CGM20026",new String[]{}).getMessage());
//				}
//			}
				
			/*-------------------------------
				 deletinghandling
			--------------------------------*/
			// CGM_AGMT_LSE_RT information deleting
			dbDao.removeCHSAgreementLseRtData(chsAgreementINVO);
			// CGM_AGMT_LSE_SCG information deleting
			dbDao.removeCHSAgreementLseScgData(chsAgreementINVO);
			// CGM_AGMT_LSE_TR_RT information deleting
			dbDao.removeCHSAgreementLseTrRtData(chsAgreementINVO);
			
			String preAgmtVerNo = String.valueOf(Integer.parseInt(chsAgreementINVO.getAgmtVerNo())-1);
			CHSAgreementINVO preVO = new CHSAgreementINVO();
			
			preVO.setAgmtOfcCtyCd(chsAgreementINVO.getAgmtOfcCtyCd());
			preVO.setAgmtSeq(chsAgreementINVO.getAgmtSeq());
			preVO.setAgmtVerNo(preAgmtVerNo);
			preVO.setEqKndCd(chsAgreementINVO.getEqKndCd());
			preVO.setUpdUsrId(account.getUsr_id());
			preVO.setLstVerFlg("Y");
			preVO.setAgmtExpDt(chsAgreementINVO.getAgmtExpDt().replaceAll("-", ""));
			preVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyEQAgreementVersionData(preVO);
			
			List<CHSStatusInfoINVO> list = dbDao.searchEQAgmtListData(preVO);
			for(int i = 0; i < list.size(); i++){
				preVO.setEqNo(list.get(i).getEqNo());
				dbDao.addEQAgreementHisData(preVO);
			}
			
			// CGM_AGREEMENT information deleting
			dbDao.removeCHSAgreementMainData(chsAgreementINVO);
				
			if(preAgmtVerNo.compareTo("0") > 0){	
				dbDao.modifyCHSAgreemetPreviousMainData(preVO);
				
			}
			
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * LSE_RT Collection handling<br>
	 * Lease Agreement Creation (Chassis) - EES_CGM_1020 <br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO
	 * @param lseRtVO1 CHSAgreementINVO
	 * @param lseRtVO2 CHSAgreementINVO
	 * @return List<CHSAgreementINVO>
	 * @exception EventException
	 */
	private List<CHSAgreementINVO> setLseRtDataList(CHSAgreementINVO chsAgreementINVO, CHSAgreementINVO lseRtVO1, CHSAgreementINVO lseRtVO2) throws EventException{
		
		List<CHSAgreementINVO> lseRtList = new ArrayList<CHSAgreementINVO>();
		String ohnInitValAmt = "";
		String chssLseRtAmt = "";
		String eqTpszCd = "";
		
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		ComboINVO comboINVO = new ComboINVO();
		comboINVO.setEqKndCd("Z");
		List<ComboMGTVO> list = command.searchEqTpszListBasic(comboINVO);
		
		List<String> lseRtList1 = new ArrayList<String>();
		List<String>  lseRtList2 = new ArrayList<String>();
		if(lseRtVO1 != null){		
			lseRtList1.add(lseRtVO1.getEqTpszCd1());
			lseRtList1.add(lseRtVO1.getEqTpszCd2());
			lseRtList1.add(lseRtVO1.getEqTpszCd3());
			lseRtList1.add(lseRtVO1.getEqTpszCd4());
			lseRtList1.add(lseRtVO1.getEqTpszCd5());
			lseRtList1.add(lseRtVO1.getEqTpszCd6());
			lseRtList1.add(lseRtVO1.getEqTpszCd7());
			lseRtList1.add(lseRtVO1.getEqTpszCd8());
			lseRtList1.add(lseRtVO1.getEqTpszCd9());
			lseRtList1.add(lseRtVO1.getEqTpszCd10());
			lseRtList1.add(lseRtVO1.getEqTpszCd11());
			lseRtList1.add(lseRtVO1.getEqTpszCd12());
			lseRtList1.add(lseRtVO1.getEqTpszCd13());
			lseRtList1.add(lseRtVO1.getEqTpszCd14());
			lseRtList1.add(lseRtVO1.getEqTpszCd15());
			lseRtList1.add(lseRtVO1.getEqTpszCd16());
			lseRtList1.add(lseRtVO1.getEqTpszCd17());
			lseRtList1.add(lseRtVO1.getEqTpszCd18());
			lseRtList1.add(lseRtVO1.getEqTpszCd19());
			lseRtList1.add(lseRtVO1.getEqTpszCd20());
		}	
		
		if(lseRtVO2 != null){
			lseRtList2.add(lseRtVO2.getEqTpszCd1());
			lseRtList2.add(lseRtVO2.getEqTpszCd2());
			lseRtList2.add(lseRtVO2.getEqTpszCd3());
			lseRtList2.add(lseRtVO2.getEqTpszCd4());
			lseRtList2.add(lseRtVO2.getEqTpszCd5());
			lseRtList2.add(lseRtVO2.getEqTpszCd6());
			lseRtList2.add(lseRtVO2.getEqTpszCd7());
			lseRtList2.add(lseRtVO2.getEqTpszCd8());
			lseRtList2.add(lseRtVO2.getEqTpszCd9());
			lseRtList2.add(lseRtVO2.getEqTpszCd10());
			lseRtList2.add(lseRtVO2.getEqTpszCd11());
			lseRtList2.add(lseRtVO2.getEqTpszCd12());
			lseRtList2.add(lseRtVO2.getEqTpszCd13());
			lseRtList2.add(lseRtVO2.getEqTpszCd14());
			lseRtList2.add(lseRtVO2.getEqTpszCd15());
			lseRtList2.add(lseRtVO2.getEqTpszCd16());
			lseRtList2.add(lseRtVO2.getEqTpszCd17());
			lseRtList2.add(lseRtVO2.getEqTpszCd18());
			lseRtList2.add(lseRtVO2.getEqTpszCd19());
			lseRtList2.add(lseRtVO2.getEqTpszCd20());
		}
		
		for(int i = 0; i < list.size(); i++){
			eqTpszCd =  JSPUtil.getNull(list.get(i).getCode1());
			ohnInitValAmt = JSPUtil.getNull(lseRtList1.get(i).toString());
			
			if(lseRtVO2 != null){
				chssLseRtAmt = JSPUtil.getNull(lseRtList2.get(i).toString());

				if(!ohnInitValAmt.equals("") || !chssLseRtAmt.equals("")){
					if((!"0".equals(ohnInitValAmt) || !"0".equals(chssLseRtAmt))  && (ohnInitValAmt != null || chssLseRtAmt != null)){
						
					//	System.out.println("RT1 :  "+eqTpszCd+"=====>>>> "+ohnInitValAmt+"=====>>>> "+chssLseRtAmt);	
						CHSAgreementINVO tempVo = new CHSAgreementINVO();
						
						tempVo.setAgmtOfcCtyCd(chsAgreementINVO.getAgmtOfcCtyCd());
						tempVo.setAgmtSeq(chsAgreementINVO.getAgmtSeq());
						tempVo.setAgmtVerNo(chsAgreementINVO.getAgmtVerNo());
						tempVo.setEqKndCd(chsAgreementINVO.getEqKndCd());
						tempVo.setCreUsrId(chsAgreementINVO.getCreUsrId());
						tempVo.setUpdUsrId(chsAgreementINVO.getUpdUsrId());
						
						tempVo.setEqTpszCd(eqTpszCd);
						tempVo.setOhnInitValAmt(ohnInitValAmt);
						tempVo.setChssLseRtAmt(chssLseRtAmt);
						
						lseRtList.add(tempVo);
					}
				}
			}
			else{
				if(!ohnInitValAmt.equals("")){
					if((!"0".equals(ohnInitValAmt)  && ohnInitValAmt != null )){
						
					//	System.out.println("RT2 :  "+eqTpszCd+"=====>>>> "+ohnInitValAmt+"=====>>>> "+chssLseRtAmt);	
						CHSAgreementINVO tempVo = new CHSAgreementINVO();
						
						tempVo.setAgmtOfcCtyCd(chsAgreementINVO.getAgmtOfcCtyCd());
						tempVo.setAgmtSeq(chsAgreementINVO.getAgmtSeq());
						tempVo.setAgmtVerNo(chsAgreementINVO.getAgmtVerNo());
						tempVo.setEqKndCd(chsAgreementINVO.getEqKndCd());
						tempVo.setCreUsrId(chsAgreementINVO.getCreUsrId());
						tempVo.setUpdUsrId(chsAgreementINVO.getUpdUsrId());
						
						tempVo.setEqTpszCd(eqTpszCd);
						tempVo.setOhnInitValAmt(ohnInitValAmt);
						tempVo.setChssLseRtAmt(chssLseRtAmt);
						
						lseRtList.add(tempVo);
					}
				}
				
			}

		}
		
		return lseRtList;
	}
	
	/**
	 * LSE_RT Collection handling<br>
	 * Lease Agreement Creation (Chassis) - EES_CGM_1020 <br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @return List<MGSAgreementINVO>
	 * @exception EventException
	 */
	private List<MGSAgreementINVO> setLseRtDataList(MGSAgreementINVO mgsAgreementINVO,MGSAgreementINVO[] lseRtVO1, MGSAgreementINVO[] lseRtVO2, MGSAgreementINVO[] lseRtVO3) throws EventException{
		
		List<MGSAgreementINVO> lseRtList = new ArrayList<MGSAgreementINVO>();
		
		String eqTpszCd 		= "";
		String onhInitValAmt 	= "";
		String mgstLseFxRtAmt 	= "";
		String mgstBldpRtAmt 	= "";
		String mgstPotcScgRtAmt = "";
		String mgstPrtcScgRtAmt = "";
		
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		ComboINVO comboINVO = new ComboINVO();
		comboINVO.setEqKndCd("G");
		List<ComboMGTVO> list = command.searchEqTpszListBasic(comboINVO);
		
		List<String> lseRtList1 = new ArrayList<String>();
		List<String> lseRtList1_1 = new ArrayList<String>();
		List<String>  lseRtList2 = new ArrayList<String>();
		List<String>  lseRtList3 = new ArrayList<String>();
		List<String>  lseRtList3_1 = new ArrayList<String>();
		
		if(lseRtVO1 != null){	// Rental Rate Tab
			lseRtList1.add(lseRtVO1[0].getEqTpszCd1());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd2());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd3());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd4());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd5());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd6());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd7());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd8());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd9());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd10());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd11());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd12());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd13());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd14());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd15());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd16());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd17());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd18());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd19());
			lseRtList1.add(lseRtVO1[0].getEqTpszCd20());
			
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd1());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd2());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd3());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd4());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd5());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd6());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd7());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd8());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd9());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd10());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd11());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd12());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd13());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd14());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd15());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd16());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd17());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd18());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd19());
			lseRtList1_1.add(lseRtVO1[1].getEqTpszCd20());			
		}	
		
		if(lseRtVO2 != null){ // Depr. For Casualty Value Tab

			lseRtList2.add(lseRtVO2[0].getEqTpszCd1());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd2());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd3());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd4());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd5());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd6());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd7());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd8());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd9());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd10());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd11());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd12());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd13());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd14());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd15());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd16());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd17());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd18());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd19());
			lseRtList2.add(lseRtVO2[0].getEqTpszCd20());
		}
		
		if(lseRtVO3 != null){  // SurCharge Tab
			lseRtList3.add(lseRtVO3[0].getEqTpszCd1());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd2());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd3());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd4());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd5());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd6());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd7());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd8());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd9());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd10());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd11());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd12());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd13());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd14());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd15());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd16());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd17());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd18());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd19());
			lseRtList3.add(lseRtVO3[0].getEqTpszCd20());

			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd1());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd2());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd3());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd4());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd5());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd6());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd7());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd8());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd9());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd10());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd11());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd12());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd13());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd14());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd15());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd16());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd17());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd18());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd19());
			lseRtList3_1.add(lseRtVO3[1].getEqTpszCd20());		
		}		
		
		for(int i = 0; i < list.size(); i++){
			eqTpszCd =  JSPUtil.getNull(list.get(i).getCode1());
			
			onhInitValAmt 	 = JSPUtil.getNull(lseRtList2.get(i).toString());
			mgstLseFxRtAmt	 = JSPUtil.getNull(lseRtList1_1.get(i).toString());
			
			mgstBldpRtAmt	 = JSPUtil.getNull(lseRtList1.get(i).toString());
			
			mgstPotcScgRtAmt = JSPUtil.getNull(lseRtList3.get(i).toString());
			mgstPrtcScgRtAmt = JSPUtil.getNull(lseRtList3_1.get(i).toString());

			if((!onhInitValAmt.equals("") && !onhInitValAmt.equals("0")) ||
			   (!mgstLseFxRtAmt.equals("") && !mgstLseFxRtAmt.equals("0")) ||
			   (!mgstBldpRtAmt.equals("") && !mgstBldpRtAmt.equals("0")) ||
			   (!mgstPotcScgRtAmt.equals("") && !mgstPotcScgRtAmt.equals("0")) ||
			   (!mgstPrtcScgRtAmt.equals("") && !mgstPrtcScgRtAmt.equals("0"))) {
				
				MGSAgreementINVO tempVo = new MGSAgreementINVO();
				
				tempVo.setAgmtOfcCtyCd(mgsAgreementINVO.getAgmtOfcCtyCd());
				tempVo.setAgmtSeq(mgsAgreementINVO.getAgmtSeq());
				tempVo.setAgmtVerNo(mgsAgreementINVO.getAgmtVerNo());
				tempVo.setEqKndCd(mgsAgreementINVO.getEqKndCd());
				tempVo.setCreUsrId(mgsAgreementINVO.getCreUsrId());
				tempVo.setUpdUsrId(mgsAgreementINVO.getUpdUsrId());
				
				tempVo.setEqTpszCd(eqTpszCd);
				tempVo.setOnhInitValAmt(onhInitValAmt);
				tempVo.setMgstLseFxRtAmt(mgstLseFxRtAmt);
				tempVo.setMgstBldpRtAmt(mgstBldpRtAmt);
				tempVo.setMgstPotcScgRtAmt(mgstPotcScgRtAmt);
				tempVo.setMgstPrtcScgRtAmt(mgstPrtcScgRtAmt);

				
				lseRtList.add(tempVo);
			}
		
		}
		return lseRtList;
	}
	
	/**
	 * LSE_TR_RT  Collection handling<br>
	 * Lease Agreement Creation (Chassis) - EES_CGM_1020 <br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO
	 * @param lseTrRtVO CHSAgreementINVO[]
	 * @return List<CHSAgreementINVO>
	 * @exception EventException
	 */
	private List<CHSAgreementINVO> setLseTrRtDataList(CHSAgreementINVO chsAgreementINVO, CHSAgreementINVO[] lseTrRtVO) throws EventException{
		List<CHSAgreementINVO> lseTrRtList = new ArrayList<CHSAgreementINVO>();
		String trRtAmt = "";
		String eqTpszCd = "";
		
		CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
		ComboINVO comboINVO = new ComboINVO();
		comboINVO.setEqKndCd("Z");
		List<ComboMGTVO> list = command.searchEqTpszListBasic(comboINVO);
		List<String> lseRtList1 = null;
		
		String[] arrTrRtAmt	= new String[list.size()];	
		
		for(int x = 0; x < list.size(); x++){
			arrTrRtAmt[x] = new String(); // 배열 초기화
		}
		
		
		for(int i = 0; i < lseTrRtVO.length; i++){		 // Rental Rate Type 'Tier(Unit/Day),Tier(User Days)' Sheet Data Row Count 
			if(!lseTrRtVO[i].getIbflag().equals("D")){
				lseRtList1 = new ArrayList<String>();
				
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd1());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd2());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd3());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd4());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd5());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd6());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd7());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd8());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd9());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd10());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd11());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd12());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd13());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd14());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd15());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd16());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd17());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd18());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd19());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd20());
				
				for(int x = 0; x < list.size(); x++){
					StringBuffer tmp = new StringBuffer(arrTrRtAmt[x]);
					tmp.append(JSPUtil.getNull(lseRtList1.get(x).toString()));
					arrTrRtAmt[x] = tmp.toString(); // Type/Size 별 Row Data Set
				}
			}
		}
		
		for(int i = 0; i < lseTrRtVO.length; i++){		
			
			if(!lseTrRtVO[i].getIbflag().equals("D")){ // 삭제가 아니면...
				
				lseRtList1 = new ArrayList<String>();
				
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd1());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd2());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd3());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd4());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd5());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd6());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd7());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd8());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd9());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd10());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd11());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd12());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd13());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd14());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd15());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd16());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd17());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd18());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd19());
				lseRtList1.add(lseTrRtVO[i].getEqTpszCd20());
		
				for(int x = 0; x < list.size(); x++){
					eqTpszCd =  JSPUtil.getNull(list.get(x).getCode1());
					trRtAmt = JSPUtil.getNull(lseRtList1.get(x).toString());
					
				//	System.out.println("arrTrRtAmt[x] :====>>>   "+StringUtil.delete(arrTrRtAmt[x],".")+"  Integer.parseInt(arrTrRtAmt[x]) ====>>>>  "+Float.parseFloat(StringUtil.delete(arrTrRtAmt[x],".")));	
					
					if(Float.compare(Float.parseFloat(StringUtil.delete(arrTrRtAmt[x],".")), 0.f) > 0 && arrTrRtAmt[x] != null){ // Type/Size 별 하나라도 값이 존재 하면... 

						CHSAgreementINVO tempVo = new CHSAgreementINVO();
							
						tempVo.setAgmtOfcCtyCd(chsAgreementINVO.getAgmtOfcCtyCd());
						tempVo.setAgmtSeq(chsAgreementINVO.getAgmtSeq());
						tempVo.setAgmtVerNo(chsAgreementINVO.getAgmtVerNo());
						tempVo.setEqKndCd(chsAgreementINVO.getEqKndCd());
						tempVo.setCreUsrId(chsAgreementINVO.getCreUsrId());
						tempVo.setUpdUsrId(chsAgreementINVO.getUpdUsrId());
						tempVo.setRntlFmTrVal(lseTrRtVO[i].getRntlFmTrVal());
						tempVo.setRntlToTrVal(lseTrRtVO[i].getRntlToTrVal());
							
						tempVo.setEqTpszCd(eqTpszCd);
						tempVo.setTrRtAmt(trRtAmt);
							
						lseTrRtList.add(tempVo);
					}
				}
			}
		}		
			
		return lseTrRtList;
	}
	
	/**
	 * agreement info and (by Type Size) Depreciation rate & initial rate, <br>
	 * Surcharge, Rental rate etc information retrieve. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @return MGSAgreementGroupVO
	 * @exception EventException
	 */
	public MGSAgreementGroupVO searchMGSAgreementAllBasic(MGSAgreementINVO mgsAgreementINVO) throws EventException {
		
		// Map object for Response object
		MGSAgreementGroupVO agmtList = new MGSAgreementGroupVO();
		//Map<String, Object> responseData = new HashMap<String, Object>();
		
		try {
			// Map object for ETC Data
			Map<String, String> etcData = new HashMap<String, String>();
			
			//----------------------------
			// Agreement Main data retrieve
			//----------------------------
			List<MGSAgreementMGTVO> agreementList = dbDao.searchMGSAgreementMainData(mgsAgreementINVO);
			
			MGSAgreementMGTVO agreementInfo = new MGSAgreementMGTVO();
		//	MGSAgreementMGTVO mgsAgreementLseRtData =  new MGSAgreementMGTVO();
			
			if(agreementList != null){
				if(agreementList.size() > 0){

					agreementInfo = (MGSAgreementMGTVO)agreementList.get(agreementList.size()-1);
				
					// Agreement Number setting
					String agmtSeq = "000000" + agreementInfo.getAgmtSeq();
					String agmtNo =  agreementInfo.getAgmtOfcCtyCd() + agmtSeq.substring(agmtSeq.length() - 6)  ;
					
					// INVO setting 
					agreementInfo.setAgmtNo(agmtNo);
					mgsAgreementINVO.setAgmtVerNo(agreementInfo.getAgmtVerNo());	//  Agreement Version 을 setting
					

				}
			}
			
			// ETCDATA setting
			etcData = agreementInfo.getColumnValues();
			
/*			etcData.put("onh_init_val_amt_clg", 	mgsAgreementLseRtData.getOnhInitValAmtClg());
			etcData.put("onh_init_val_amt_umg", 	mgsAgreementLseRtData.getOnhInitValAmtUmg());
			etcData.put("mgst_lse_fx_rt_amt_clg", 	mgsAgreementLseRtData.getMgstLseFxRtAmtClg());
			etcData.put("mgst_lse_fx_rt_amt_umg", 	mgsAgreementLseRtData.getMgstLseFxRtAmtUmg());
			etcData.put("mgst_bldp_rt_amt_clg", 	mgsAgreementLseRtData.getMgstBldpRtAmtClg());
			etcData.put("mgst_bldp_rt_amt_umg", 	mgsAgreementLseRtData.getMgstBldpRtAmtUmg());
			etcData.put("mgst_potc_scg_rt_amt_clg", mgsAgreementLseRtData.getMgstPotcScgRtAmtClg());
			etcData.put("mgst_potc_scg_rt_amt_umg", mgsAgreementLseRtData.getMgstPotcScgRtAmtUmg());
			etcData.put("mgst_prtc_scg_rt_amt_clg", mgsAgreementLseRtData.getMgstPrtcScgRtAmtClg());
			etcData.put("mgst_prtc_scg_rt_amt_umg", mgsAgreementLseRtData.getMgstPrtcScgRtAmtUmg());*/
			agmtList.setEtcData(etcData);
			//agmtList.add(etcData);		
			
			// etc Agreement info
			if(agreementList != null){
				if(agreementList.size() > 0){		
					
					//------------------------------
					//	CGM_AGMT_LSE_RT retrieve
					//-------------------------------
					List<MGSAgreementMGTVO> mgsAgreementLseRtData = dbDao.searchMGSAgreementLseRtData(mgsAgreementINVO);
					agmtList.setMgsagreementmgtvo(mgsAgreementLseRtData);
					
					List<MGSAgreementMGTVO> mgsAgreementLseRt2Data = dbDao.searchMGSAgreementLseRt2Data(mgsAgreementINVO);
					agmtList.setMgsagreementmgtvo2(mgsAgreementLseRt2Data);
					
					List<MGSAgreementMGTVO> mgsAgreementLseRt3Data = dbDao.searchMGSAgreementLseRt3Data(mgsAgreementINVO);
					agmtList.setMgsagreementmgtvo3(mgsAgreementLseRt3Data);
					
					
					//-------------------------------
					// setting for Version No list
					//------------------------------
					mgsAgreementINVO.setAgmtVerNo("");	
					List<MGSAgreementMGTVO> agreementList2 = dbDao.searchMGSAgreementMainData(mgsAgreementINVO);
					agmtList.setMgsagreementmgtvervo(agreementList2);
					
				}
			} 
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return agmtList;
	}	
	
	/**
	 * Init Agreement creation(UI_CGM_2021) and existed Agreement information modification. [EES_CGM_2021]<br>
	 * 
	 * @param List<MGSAgreementINVO[]> mgsAgreementINVOs
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return MGSAgreementMGTVO
	 * @exception EventException
	 */
	public MGSAgreementMGTVO modifyMGSAgreementBasic(List<MGSAgreementINVO[]> mgsAgreementINVOs,MGSAgreementINVO mgsAgreementINVO, SignOnUserAccount account) throws EventException {
		
		MGSAgreementMGTVO mgsAgreementMGTVO = new MGSAgreementMGTVO();
		
		try {
			
			// var setting
			String actionFlag = mgsAgreementINVO.getActionFlag();

			String agmtOfcCtyCd = "";
			String agmtSeq = "";
			
			// new insert -> Agreement No creation
			if(actionFlag.equalsIgnoreCase("N")){
				agmtOfcCtyCd = mgsAgreementINVO.getAgmtIssOfcCd().substring(0, 3);
				agmtSeq = dbDao.searchMGSAgreemetAgmtSeqData(mgsAgreementINVO);
				
				// Agreement No ->  VO setting
				mgsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);	
				mgsAgreementINVO.setAgmtSeq(agmtSeq);
				mgsAgreementINVO.setAgmtVerNo("1");
				
				String tempAgmtSeq = "000000" + agmtSeq;
				String tempAgmtNo = agmtOfcCtyCd + tempAgmtSeq.substring(tempAgmtSeq.length() - 6) ;
				mgsAgreementINVO.setAgmtNo(tempAgmtNo);
				
			}
			

			if(actionFlag.equalsIgnoreCase("V")){
				String preVerNo = String.valueOf(Integer.parseInt(mgsAgreementINVO.getAgmtVerNo())-1);
				CHSAgreementINVO vo = new CHSAgreementINVO();
				vo.setAgmtOfcCtyCd(mgsAgreementINVO.getAgmtOfcCtyCd());
				vo.setAgmtSeq(mgsAgreementINVO.getAgmtSeq());
				vo.setAgmtEffDt(mgsAgreementINVO.getAgmtEffDt());
				vo.setAgmtVerNo(preVerNo);
				vo.setActionFlag(actionFlag);
				// Charge Creation  data existing check
				boolean chkChargeCreData = dbDao.checkCHSExistChgCreDataByAgreementData(vo);
				if(!chkChargeCreData){
					throw new EventException(new ErrorHandler("CGM20033",new String[]{}).getMessage());
				}
			}
			

			List<MGSAgreementMGTVO> agmtList = dbDao.searchMGSAgreementMainData(mgsAgreementINVO);
				
			if(agmtList != null){

				if(agmtList.size() > 0){
					/*--------------------------------
						CGM_AGREEMENT Modify
					----------------------------------*/
					String agmtNo = mgsAgreementINVO.getAgmtNo();
					agmtOfcCtyCd = agmtNo.substring(0, 3);
					agmtSeq = agmtNo.substring(3);
						
					mgsAgreementINVO.setCreUsrId(account.getUsr_id());
					mgsAgreementINVO.setUpdUsrId(account.getUsr_id());
					mgsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);
					mgsAgreementINVO.setAgmtSeq(agmtSeq);
						
					dbDao.modifyMGSAgreemetMainData(mgsAgreementINVO);
				} else {
					/*----------------------------------
						 CGM_AGREEMENT Insert
					-----------------------------------*/
					mgsAgreementINVO.setCreUsrId(account.getUsr_id());
					mgsAgreementINVO.setUpdUsrId(account.getUsr_id());
					mgsAgreementINVO.setLstVerFlg("Y");	
						
					dbDao.addMGSAgreemetMainData(mgsAgreementINVO);
					
					CHSAgreementINVO vo = new CHSAgreementINVO();
					vo.setAgmtOfcCtyCd(mgsAgreementINVO.getAgmtOfcCtyCd());
					vo.setAgmtSeq(mgsAgreementINVO.getAgmtSeq());
					vo.setAgmtVerNo(mgsAgreementINVO.getAgmtVerNo());
					vo.setUpdUsrId(account.getUsr_id());
					dbDao.modifyEQAgreementVersionData(vo);
					List<CHSStatusInfoINVO> list = dbDao.searchEQAgmtListData(vo);
					for(int i = 0; i < list.size(); i++){
						vo.setEqNo(list.get(i).getEqNo());
						dbDao.addEQAgreementHisData(vo);
					}
					
					if(actionFlag.equalsIgnoreCase("V")){
							

						MGSAgreementINVO preVO = new MGSAgreementINVO();
						String preAgmtVerNo = String.valueOf(Integer.parseInt(mgsAgreementINVO.getAgmtVerNo())-1);
						String effDt = mgsAgreementINVO.getEffDt().replaceAll("-", "");
						String preEffDt = mgsAgreementINVO.getPreEffDt().replaceAll("-", "");
						String preExpDt = mgsAgreementINVO.getPreExpDt().replaceAll("-", "") ;
							
						preVO.setAgmtOfcCtyCd(mgsAgreementINVO.getAgmtOfcCtyCd());
						preVO.setAgmtSeq(mgsAgreementINVO.getAgmtSeq());
						preVO.setAgmtVerNo(preAgmtVerNo);
						preVO.setEqKndCd(mgsAgreementINVO.getEqKndCd());
						preVO.setUpdUsrId(account.getUsr_id());
						preVO.setLstVerFlg("N");
					

						int day = 1;
						if(effDt.compareTo(preEffDt) > 0 && effDt.compareTo(preExpDt) <= 0){
							SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd", java.util.Locale.KOREA);
							Date date = formatter.parse(effDt);
							date.setTime(date.getTime() - ((long)day * 1000 * 60 * 60 * 24));
							preExpDt = formatter.format(date);
						}
							
						preVO.setEffDt(preEffDt);
						preVO.setExpDt(preExpDt);
							
						// Previous data modification 
						dbDao.modifyMGSAgreemetPreviousMainData(preVO);
							
					}
				}
				
				/*--------------------------------------------
					CGM_AGMT_LSE_RT
				---------------------------------------------*/
				MGSAgreementINVO[] lseRt1VO = (MGSAgreementINVO[])mgsAgreementINVOs.get(0);
				MGSAgreementINVO[] lseRt2VO = (MGSAgreementINVO[])mgsAgreementINVOs.get(1);
				MGSAgreementINVO[] lseRt3VO = (MGSAgreementINVO[])mgsAgreementINVOs.get(2);
				
				if(lseRt1VO != null && lseRt2VO != null && lseRt3VO != null){
					List<MGSAgreementINVO> lseRtList = new ArrayList<MGSAgreementINVO>();
					
						lseRtList = setLseRtDataList(mgsAgreementINVO, lseRt1VO, lseRt2VO,lseRt3VO);
						
					dbDao.removeMGSAgreementLseRtData(mgsAgreementINVO);
					dbDao.addMGSAgreementLseRtData(lseRtList);
				}
					
			}
			
			mgsAgreementMGTVO.setAgmtNo(mgsAgreementINVO.getAgmtNo());
			mgsAgreementMGTVO.setAgmtOfcCtyCd(mgsAgreementINVO.getAgmtOfcCtyCd());
			mgsAgreementMGTVO.setAgmtSeq(mgsAgreementINVO.getAgmtSeq());
			mgsAgreementMGTVO.setAgmtVerNo(mgsAgreementINVO.getAgmtVerNo());
			mgsAgreementMGTVO.setLstVerFlg(mgsAgreementINVO.getLstVerFlg());
			
		} catch (EventException ex){
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
				
		return mgsAgreementMGTVO;
	}
	
	/**
	 * selected Agreement  deleting handling  [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeMGSAgreementBasic(MGSAgreementINVO mgsAgreementINVO, SignOnUserAccount account) throws EventException {
		try {
			/*---------------------------
			 	Validation check
			 ----------------------------*/

			if(!mgsAgreementINVO.getLstVerFlg().equals("Y")){ 
				throw new EventException(new ErrorHandler("CGM20007",new String[]{}).getMessage());
			} 
			
			CHSAgreementINVO vo = new CHSAgreementINVO();
			vo.setAgmtOfcCtyCd(mgsAgreementINVO.getAgmtOfcCtyCd());
			vo.setAgmtSeq(mgsAgreementINVO.getAgmtSeq());
			vo.setAgmtVerNo(mgsAgreementINVO.getAgmtVerNo());
			vo.setAgmtEffDt(mgsAgreementINVO.getAgmtEffDt());
			vo.setUpdUsrId(account.getUsr_id());
			boolean chkChargeCreData = dbDao.checkCHSExistChgCreDataByAgreementData(vo);
			if(!chkChargeCreData){
				throw new EventException(new ErrorHandler("CGM20034",new String[]{}).getMessage());
			}
			
			if(mgsAgreementINVO.getAgmtVerNo().equals("1")){
				boolean checkUseEquipment = dbDao.checkMGSAgreementUseEquipmentData(mgsAgreementINVO);
				if(checkUseEquipment){

					throw new EventException(new ErrorHandler("CGM20016",new String[]{}).getMessage());
				} 
			} 
//			else {
//
//				boolean chkChargeCreData = dbDao.checkMGSExistChgCreDataByAgreementData(mgsAgreementINVO);
//				if(!chkChargeCreData){
//					throw new EventException(new ErrorHandler("CGM20026",new String[]{}).getMessage());
//				}
//			}	
			
			/*-------------------------------
				 deletinghandling
			--------------------------------*/
						
			// CGM_AGMT_LSE_RT information deleting
			dbDao.removeMGSAgreementLseRtData(mgsAgreementINVO);
			
			String preAgmtVerNo = String.valueOf(Integer.parseInt(mgsAgreementINVO.getAgmtVerNo())-1);
			vo.setAgmtVerNo(preAgmtVerNo);
			dbDao.modifyEQAgreementVersionData(vo);
			
			List<CHSStatusInfoINVO> list = dbDao.searchEQAgmtListData(vo);
			for(int i = 0; i < list.size(); i++){
				vo.setEqNo(list.get(i).getEqNo());
				dbDao.addEQAgreementHisData(vo);
			}
			
			
			// CGM_AGREEMENT information deleting
			dbDao.removeMGSAgreementMainData(mgsAgreementINVO);
								

//			String preAgmtVerNo = String.valueOf(Integer.parseInt(mgsAgreementINVO.getAgmtVerNo())-1);
								
			if(preAgmtVerNo.compareTo("0") > 0){
				MGSAgreementINVO preVO = new MGSAgreementINVO();
									
				preVO.setAgmtOfcCtyCd(mgsAgreementINVO.getAgmtOfcCtyCd());
				preVO.setAgmtSeq(mgsAgreementINVO.getAgmtSeq());
				preVO.setAgmtVerNo(preAgmtVerNo);
				preVO.setEqKndCd(mgsAgreementINVO.getEqKndCd());
				preVO.setUpdUsrId(account.getUsr_id());
				preVO.setLstVerFlg("Y");
				preVO.setAgmtExpDt(mgsAgreementINVO.getAgmtExpDt().replaceAll("-", ""));
									
				dbDao.modifyMGSAgreemetPreviousMainData(preVO);
			}
		} catch (EventException ex){
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * selected Agreement Term change Chassis  retrieve. [EES_CGM_1026]<br>
	 * 
	 * @param chsTermStatusINVO CHSTermStatusINVO 
	 * @return List<CHSTermStatusMGTVO>
	 * @exception EventException
	 */
	public List<CHSTermStatusMGTVO> searchCHSTermChangeEqListBasic(CHSTermStatusINVO chsTermStatusINVO) throws EventException {
		try {
			return dbDao.searchCHSTermChangeEqListData(chsTermStatusINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Chassis master information retrieve. [EES_CGM_1026]<br>
	 * 
	 * @param chsTermStatusINVO CHSTermStatusINVO 
	 * @return CHSTermStatusGroupVO
	 * @exception EventException
	 */
	public CHSTermStatusGroupVO searchCHSEqMainBasic(CHSTermStatusINVO chsTermStatusINVO) throws EventException {
		CHSTermStatusGroupVO responseData = new CHSTermStatusGroupVO();
		try {
			
			List<CHSTermStatusMGTVO> list = dbDao.searchCHSEqMainData(chsTermStatusINVO);
			
			CHSTermStatusMGTVO chsTermStatusMGTVO = new CHSTermStatusMGTVO();
			
			if(list != null){
				if(list.size() > 0){
					chsTermStatusMGTVO = (CHSTermStatusMGTVO)list.get(0);
				}
				responseData.setChstermstatusmgtvos(list);
			}
			
			responseData.setChstermstatusmgtvo(chsTermStatusMGTVO);
			
//			responseData.add(list);	// 
//			responseData.add(chsTermStatusMGTVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return responseData;
	}
	
	/**
	 * selected Agreement Term change M.G.Set list  retrieve. [EES_CGM_2026]<br>
	 * 
	 * @param mgsTermStatusINVO MGSTermStatusINVO 
	 * @return List<MGSTermStatusMGTVO>
	 * @exception EventException
	 */
	public List<MGSTermStatusMGTVO> searchMGSTermChangeEqListBasic(MGSTermStatusINVO mgsTermStatusINVO) throws EventException {
		try {
			return dbDao.searchMGSTermChangeEqListData(mgsTermStatusINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set master information retrieve. [EES_CGM_2026]<br>
	 * 
	 * @param mgsTermStatusINVO MGSTermStatusINVO 
	 * @return MGSTermStatusGroupVO
	 * @exception EventException
	 */
	public MGSTermStatusGroupVO searchMGSEqMainBasic(MGSTermStatusINVO mgsTermStatusINVO) throws EventException {
		
		MGSTermStatusGroupVO responseData = new MGSTermStatusGroupVO();
		try {
			List<MGSTermStatusMGTVO> list = dbDao.searchMGSEqMainData(mgsTermStatusINVO);
			
			MGSTermStatusMGTVO mgsTermStatusMGTVO = new MGSTermStatusMGTVO();
			
			if(list != null){
				if(list.size() > 0){
					mgsTermStatusMGTVO = (MGSTermStatusMGTVO)list.get(0);
				}
				responseData.setMgstermstatusmgtvos(list);
			}
			
			responseData.setMgstermstatusmgtvo(mgsTermStatusMGTVO);
//			responseData.add(list);	// 
//			responseData.add(mgsTermStatusMGTVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return responseData;
	}
	
	/**
	 * Retrieve Summary of term changed Eq count. [EES_CGM_1118]<br>
	 * 
	 * @param chsTermChangeResultINVO CHSTermChangeResultINVO 
	 * @return List<CHSTermChangeResultMGTVO>
	 * @exception EventException
	 */
	public List<CHSTermChangeResultMGTVO> searchCHSTermChangeResultSmryBasic(CHSTermChangeResultINVO chsTermChangeResultINVO) throws EventException {
		try {
			

			String ofcCd = chsTermChangeResultINVO.getStsEvntOfcCd();
			String oldAgmtLstmCd = chsTermChangeResultINVO.getOldAgmtLstmCd();
			String newAgmtLstmCd = chsTermChangeResultINVO.getNewAgmtLstmCd();
			String stsEvntDtFr = chsTermChangeResultINVO.getStsEvntDtFr().replaceAll("-", "");
			String stsEvntDtTo = chsTermChangeResultINVO.getStsEvntDtTo().replaceAll("-", "");
			
			if(ofcCd != null && !ofcCd.equals("")){
				ofcCd = "'" + ofcCd.replaceAll(",", "','") + "'";
				chsTermChangeResultINVO.setStsEvntOfcCd(ofcCd);
			}
			
			if(oldAgmtLstmCd != null && !oldAgmtLstmCd.equals("")){
				oldAgmtLstmCd = "'" + oldAgmtLstmCd.replaceAll(",", "','") + "'";
				chsTermChangeResultINVO.setOldAgmtLstmCd(oldAgmtLstmCd);
			}
			
			if(newAgmtLstmCd != null && !newAgmtLstmCd.equals("")){
				newAgmtLstmCd = "'" + newAgmtLstmCd.replaceAll(",", "','") + "'";
				chsTermChangeResultINVO.setNewAgmtLstmCd(newAgmtLstmCd);
			}
			
			chsTermChangeResultINVO.setStsEvntDtFr(stsEvntDtFr);
			chsTermChangeResultINVO.setStsEvntDtTo(stsEvntDtTo);

			// retrieve
			return dbDao.searchCHSTermChangeResultSmryData(chsTermChangeResultINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Summary of term changed Eq count. [EES_CGM_2028]<br>
	 *  
	 * @param mgsTermChangeResultINVO MGSTermChangeResultINVO 
	 * @return List<MGSTermChangeResultMGTVO>
	 * @exception EventException
	 */
	public List<MGSTermChangeResultMGTVO> searchMGSTermChangeResultSmryBasic(MGSTermChangeResultINVO mgsTermChangeResultINVO) throws EventException {
		try {
			

			String ofcCd 			= mgsTermChangeResultINVO.getStsEvntOfcCd();
			String oldAgmtLstmCd 	= mgsTermChangeResultINVO.getOldAgmtLstmCd();
			String newAgmtLstmCd 	= mgsTermChangeResultINVO.getNewAgmtLstmCd();
			String stsEvntDtFr 		= mgsTermChangeResultINVO.getStsEvntDtFr().replaceAll("-", "");
			String stsEvntDtTo 		= mgsTermChangeResultINVO.getStsEvntDtTo().replaceAll("-", "");
			
			if(ofcCd != null && !ofcCd.equals("")){
				ofcCd = "'" + ofcCd.replaceAll(",", "','") + "'";
				mgsTermChangeResultINVO.setStsEvntOfcCd(ofcCd);
			}

			if(oldAgmtLstmCd != null && !oldAgmtLstmCd.equals("")){
				oldAgmtLstmCd = "'" + oldAgmtLstmCd.replaceAll(",", "','") + "'";
				mgsTermChangeResultINVO.setOldAgmtLstmCd(oldAgmtLstmCd);
			}
			
			if(newAgmtLstmCd != null && !newAgmtLstmCd.equals("")){
				newAgmtLstmCd = "'" + newAgmtLstmCd.replaceAll(",", "','") + "'";
				mgsTermChangeResultINVO.setNewAgmtLstmCd(newAgmtLstmCd);
			}
			
			mgsTermChangeResultINVO.setStsEvntDtFr(stsEvntDtFr);
			mgsTermChangeResultINVO.setStsEvntDtTo(stsEvntDtTo);

			// retrieve
			return dbDao.searchMGSTermChangeResultSmryData(mgsTermChangeResultINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
}