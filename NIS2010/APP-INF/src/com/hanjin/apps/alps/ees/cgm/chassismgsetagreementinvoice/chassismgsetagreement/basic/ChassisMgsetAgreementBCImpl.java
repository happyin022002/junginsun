/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementBCImpl.java
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.19 김창식
* 1.0 Creation
* 2014-06-16 BY JUSTIN HAN CSR ID : CHM-201430737, TITLE : ALPS-CHSS-Invoice에서 chassis estimated Expense 로직 수정 요청
*               MODIFIED CHECK LOGIC FOR USING AGREEMENT
* 2014.11 Chagn Young Kim 10만불 결제관련
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration.ChassisMgsetAgreementDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ChassisMgsetAgreementInvoice Business Logic Basic Command implementation<br>
 * - ALPS-ChassisMgsetAgreementInvoice에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1021EventResponse,ChassisMgsetAgreementBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ChassisMgsetAgreementBCImpl extends BasicCommandSupport implements ChassisMgsetAgreementBC {

	// Database Access Object
	private transient ChassisMgsetAgreementDBDAO dbDao = null;

	/**
	 * ChassisMgsetAgreementBCImpl 객체 생성<br>
	 * ChassisMgsetAgreementDBDAO를 생성한다.<br>
	 */
	public ChassisMgsetAgreementBCImpl() {
		dbDao = new ChassisMgsetAgreementDBDAO();
	}
	
	/**
	 * 입력된 Office에 속한 현재까지 저장되어 있는 Chassis의 장비 임대 계약 Agreement list 를 조회한다. [EES_CGM_1021]<br>
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
	 * 입력된 Office에 속한 현재까지 저장되어 있는 M.G.Set의 장비 임대 계약 Agreement list 를 조회한다. [EES_CGM_2023]<br>
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
	 * 기존에 저장된 장비 임차 계약의 기본정보를 조회한다. [EES_CGM_1117]<br>
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
	 * 기존에 저장된 장비 임차 계약의 기본정보를 조회한다. [EES_CGM_2022]<br>
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
	 * agreement 기본정보 및 Type Size 별 Depreciation rate & initial rate, <br>
	 * Surcharge, Rental rate 등의 모든 정보를 조회한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return CHSAgreementGroupVO
	 * @exception EventException
	 */
	public CHSAgreementGroupVO searchCHSAgreementAllBasic(CHSAgreementINVO chsAgreementINVO) throws EventException {
		
		// Response 객체를 담기위한 List 객체
		CHSAgreementGroupVO agmtList = new CHSAgreementGroupVO();
		
		try {
			// ETC Data 를  담기위한 Map 객체
			Map<String, String> etcData = new HashMap<String, String>();
	 
			//----------------------------
			// Agreement Main 데이터 조회
			//----------------------------
			List<CHSAgreementMGTVO> agreementList = dbDao.searchCHSAgreementMainData(chsAgreementINVO);
			
			CHSAgreementMGTVO agreementInfo = new CHSAgreementMGTVO();
			
			if(agreementList != null){
				if(agreementList.size() > 0){
					// 리스트 중에서 AGMT_VER_NO 가 가장 높은 데이터 한건을 ETCDATA 에 설정한다.(마지막 건)	Form Data
					agreementInfo = (CHSAgreementMGTVO)agreementList.get(agreementList.size()-1);
				
					// Agreement Number 세팅
					String agmtSeq = "000000" + agreementInfo.getAgmtSeq();
					String agmtNo =  agreementInfo.getAgmtOfcCtyCd() + agmtSeq.substring(agmtSeq.length() - 6)  ;
					
					// INVO 세팅 
					agreementInfo.setAgmtNo(agmtNo);
					chsAgreementINVO.setAgmtVerNo(agreementInfo.getAgmtVerNo());	// 현재 Agreement Version 을 설정
					chsAgreementINVO.setEqRntlTpCd(agreementInfo.getEqRntlTpCd());	// CGM_AGMT_LSE_TR_RT 조회 를 위한 CODE 정의
					
				}
			}
			
			// 해당하는 Agreement No 의 최신버전 정보를 취득한다.
			etcData = agreementInfo.getColumnValues();
			
			agmtList.setEtcData(etcData);
//			agmtList.add(etcData);
			
			
			// 기타 정보를 수집한다.
			if(agreementList != null){
				if(agreementList.size() > 0){
					//------------------------------
					//	CGM_AGMT_LSE_RT 조회
					//-------------------------------
					List<CHSAgreementMGTVO> chsAgreementLseRtData = dbDao.searchCHSAgreementLseRtData(chsAgreementINVO);
					agmtList.setChsagreementmgtvo(chsAgreementLseRtData);
//					agmtList.add(chsAgreementLseRtData);
					
					//------------------------------
					// CGM_AGMT_LSE_SCG 조회
					//------------------------------
					List<CHSAgreementMGTVO> chsAgreementLseScgData = dbDao.searchCHSAgreementLseScgData(chsAgreementINVO);
					agmtList.setChsagreementmgtvo2(chsAgreementLseScgData);
//					agmtList.add(chsAgreementLseScgData);
					
					//-----------------------------
					// CGM_AGMT_LSE_TR_RT 조회
					//-----------------------------
					List<CHSAgreementMGTVO> chsAgreementLseTrRtData = dbDao.searchCHSAgreementLseTrRtData(chsAgreementINVO);
					agmtList.setChsagreementmgtvo3(chsAgreementLseTrRtData);
//					agmtList.add(chsAgreementLseTrRtData);
					
					//-------------------------------
					// Version No 목록을 위해서 설정
					//------------------------------
					chsAgreementINVO.setAgmtVerNo("");	// Agreement No 에 해당하는 전체 데이터를 가져오기 위해.
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
	 * 화면에서 입력된 내용대로 최초 Agreement 생성 및 기존의 Agreement 정보를 수정한다. [EES_CGM_1020]<br>
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
			
			// 작업변수 설정
			String actionFlag = chsAgreementINVO.getActionFlag();
			String chssPoolCd = chsAgreementINVO.getChssPoolCd();
//			String 
			String agmtOfcCtyCd = "";
			String agmtSeq = "";
			
			// 신규입력시 Agreement No 생성
			if(actionFlag.equalsIgnoreCase("N")){
				agmtOfcCtyCd = chsAgreementINVO.getAgmtIssOfcCd().substring(0, 3);
				agmtSeq = dbDao.searchCHSAgreemetAgmtSeqData(chsAgreementINVO);
				
				// Agreement No 를  VO에 설정
				chsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);	
				chsAgreementINVO.setAgmtSeq(agmtSeq);
				chsAgreementINVO.setAgmtVerNo("1");
				
				String tempAgmtSeq = "000000" + agmtSeq;
				String tempAgmtNo = agmtOfcCtyCd + tempAgmtSeq.substring(tempAgmtSeq.length() - 6) ;
				chsAgreementINVO.setAgmtNo(tempAgmtNo);
				
			}
			
			// G/W Contract 입력시 action_flag는 "G"로 세팅되며 
			// 기존계약데이터도 G/W Contract를 입력하여 새로 저장해야 하기때문에 체크로직을 스킵하도록 만듬
			// UI상에서는 Retrieve시에 모든 화면요소가 비활성화 되기 때문에
			if(chsAgreementINVO.getGwUqDocNo().length() > 0 && !actionFlag.equalsIgnoreCase("R")) {
				// Charge Creation 된 데이터가 존재하는지 체크
				boolean chkChargeCreData = dbDao.checkCHSExistChgCreDataByAgreementData(chsAgreementINVO);
				if(!chkChargeCreData){
					throw new EventException(new ErrorHandler("CGM20026",new String[]{}).getMessage());
				}
				
				// Pool Code 에 값이 들어왔을 경우 다른 Agreement No 에  동일한 Pool Code 가  존재하는지 체크
				List<CHSAgreementMGTVO> chkPoolMatch = null;
				if(!chssPoolCd.equals("") && chssPoolCd != null){
					chkPoolMatch = dbDao.checkCHSAgreementPoolMatchData(chsAgreementINVO);
					if(chkPoolMatch != null){
						if(chkPoolMatch.size() > 0){
							String sAgmtOfcCtyCd = chkPoolMatch.get(0).getAgmtOfcCtyCd();
							String sAgmtSeq = chkPoolMatch.get(0).getAgmtSeq();
							String sAgmtNo = sAgmtOfcCtyCd + JSPUtil.getLPAD(sAgmtSeq, 6, "0");
							
							// 다른 Agreement 에 Pool Code 가 존재하면 Exception 처리
							throw new EventException(new ErrorHandler("CGM20014",new String[]{sAgmtNo}).getMessage());
						}
					}
				}
			}
			
			/*---------------------------------------------
			 * 프로세스 	실행 시작
			 *-------------------------------------------*/
			// CGM_AGREEMENT 에 데이터 존재하는지 체크
			List<CHSAgreementMGTVO> agmtList = dbDao.searchCHSAgreementMainData(chsAgreementINVO);
				
			if(agmtList != null){
				// CGM Agreement 에 데이터가 존재하면 Modify 수행, 존재하지 않으면 ADD 수행
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
						
					// Version Up 일 경우 이전 Version 의 데이터 중  Master 데이터를 Update 한다. 
					if(actionFlag.equalsIgnoreCase("V")){
							
						// 이전 Version 의 데이터를 조회 및 수정하기 위한 VO
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
					
						// Version Up 된 effDt 가 이전  Version의 effDt와 expDt 에 있을 때 체크
						int day = 1;
						if(effDt.compareTo(preEffDt) > 0 && effDt.compareTo(preExpDt) <= 0){
							SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd", java.util.Locale.KOREA);
							Date date = formatter.parse(effDt);
							date.setTime(date.getTime() - ((long)day * 1000 * 60 * 60 * 24));
							preExpDt = formatter.format(date);
						}
							
						preVO.setEffDt(preEffDt);
						preVO.setExpDt(preExpDt);
							
						// Previous 데이터 수정 
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
							
						// State Code 가 공백이 아니거나 ibflag 가 삭제상태가 아닌 경우에 한해 처리
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
	 * 선택된 Agreement 를 삭제 처리 한다. [EES_CGM_1020] <br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeCHSAgreementBasic(CHSAgreementINVO chsAgreementINVO, SignOnUserAccount account) throws EventException{
		try {
			/*---------------------------
			 	Validation 체크
			 ----------------------------*/
			// Last Version 이 아닐 경우 Exception 처리
			if(!chsAgreementINVO.getLstVerFlg().equals("Y")){ 
				throw new EventException(new ErrorHandler("CGM20007",new String[]{}).getMessage());
			}
				
			// Version 1일 경우는 장비가 있을 때 Exception 처리, 다른 버전일 경우에는 장비 History 가 있을 경우 Exception 처리 	
			// 2014-06-16 BY JUSTIN HAN CSR ID : CHM-201430737, TITLE : ALPS-CHSS-Invoice에서 chassis estimated Expense 로직 수정 요청
            //               MODIFIED CHECK LOGIC FOR USING AGREEMENT
//			if(chsAgreementINVO.getAgmtVerNo().equals("1")){
			boolean checkUseEquipment = dbDao.checkCHSAgreementUseEquipmentData(chsAgreementINVO);
			if(checkUseEquipment){
				// 장비에서 Agreement No 를 사용하고 있으면  Exception 처리
				throw new EventException(new ErrorHandler("CGM20016",new String[]{}).getMessage());
			} 
//			} else {
				// Charge Creation 된 데이터가 존재하는지 체크
			boolean chkChargeCreData = dbDao.checkCHSExistChgCreDataByAgreementData(chsAgreementINVO);
			if(!chkChargeCreData){
//					throw new EventException(new ErrorHandler("CGM20026",new String[]{}).getMessage());
				throw new EventException(new ErrorHandler("CGM10076",new String[]{chsAgreementINVO.getAgmtOfcCtyCd()+chsAgreementINVO.getAgmtSeq()}).getMessage());
			}
//			}
				
			/*-------------------------------
				 삭제처리
			--------------------------------*/
			// CGM_AGMT_LSE_RT 정보 삭제
			dbDao.removeCHSAgreementLseRtData(chsAgreementINVO);
			// CGM_AGMT_LSE_SCG 정보 삭제
			dbDao.removeCHSAgreementLseScgData(chsAgreementINVO);
			// CGM_AGMT_LSE_TR_RT 정보 삭제
			dbDao.removeCHSAgreementLseTrRtData(chsAgreementINVO);
			// CGM_AGREEMENT 정보 삭제
			dbDao.removeCHSAgreementMainData(chsAgreementINVO);
					
			// 이전 버전의 Version Last flag 를  'Y'로 변경처리
			String preAgmtVerNo = String.valueOf(Integer.parseInt(chsAgreementINVO.getAgmtVerNo())-1);
							
			if(preAgmtVerNo.compareTo("0") > 0){
				CHSAgreementINVO preVO = new CHSAgreementINVO();
								
				preVO.setAgmtOfcCtyCd(chsAgreementINVO.getAgmtOfcCtyCd());
				preVO.setAgmtSeq(chsAgreementINVO.getAgmtSeq());
				preVO.setAgmtVerNo(preAgmtVerNo);
				preVO.setEqKndCd(chsAgreementINVO.getEqKndCd());
				preVO.setUpdUsrId(account.getUsr_id());
				preVO.setLstVerFlg("Y");
				preVO.setAgmtExpDt(chsAgreementINVO.getAgmtExpDt().replaceAll("-", ""));
						
				dbDao.modifyCHSAgreemetPreviousMainData(preVO);
			}
			
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * LSE_RT 관련 Collection 처리<br>
	 * Lease Agreement Creation (Chassis) - EES_CGM_1020 화면<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO
	 * @param lseRtVO1 CHSAgreementINVO
	 * @param lseRtVO2 CHSAgreementINVO
	 * @return List<CHSAgreementINVO>
	 * @exception EventException
	 */
	private List<CHSAgreementINVO> setLseRtDataList(CHSAgreementINVO chsAgreementINVO, CHSAgreementINVO lseRtVO1, CHSAgreementINVO lseRtVO2){
		
		List<CHSAgreementINVO> lseRtList = new ArrayList<CHSAgreementINVO>();
		String ohnInitValAmt = "";
		String chssLseRtAmt = "";
		String eqTpszCd = "";
		
		for(int i = 1; i <= 10; i++){
			if(i == 1){
				eqTpszCd = "SF2";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdSf2());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdSf2());
				}
			} else if(i == 2){
				eqTpszCd = "SL2";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdSl2());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdSl2());
				}
			} else if(i == 3){
				eqTpszCd = "TA2";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdTa2());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdTa2());
				}
			} else if(i == 4){
				eqTpszCd = "SF4";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdSf4());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdSf4());
				}
			} else if(i == 5){
				eqTpszCd = "GN4";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdGn4());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdGn4());
				}
			} else if(i == 6){
				eqTpszCd = "CB4";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdCb4());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdCb4());
				}
			} else if(i == 7){
				eqTpszCd = "EG5";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdEg5());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdEg5());
				}
			} else if(i == 8){
				eqTpszCd = "EG8";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdEg8());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdEg8());
				}
			} else if(i == 9){
				eqTpszCd = "GN5";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdGn5());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdGn5());
				}
			} else if(i == 10){	
				eqTpszCd = "ZT4";
				ohnInitValAmt = JSPUtil.getNull(lseRtVO1.getEqTpszCdZt4());
				if(lseRtVO2 != null){
					chssLseRtAmt = JSPUtil.getNull(lseRtVO2.getEqTpszCdZt4());
				}
			}
			
			if(!ohnInitValAmt.equals("") || !chssLseRtAmt.equals("")){
				
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
		
		return lseRtList;
	}
	
	/**
	 * LSE_RT 관련 Collection 처리<br>
	 * Lease Agreement Creation (Chassis) - EES_CGM_1020 화면<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @return List<MGSAgreementINVO>
	 * @exception EventException
	 */
	private List<MGSAgreementINVO> setLseRtDataList(MGSAgreementINVO mgsAgreementINVO){
		
		List<MGSAgreementINVO> lseRtList = new ArrayList<MGSAgreementINVO>();
		
		String eqTpszCd 		= "";
		String onhInitValAmt 	= "";
		String mgstLseFxRtAmt 	= "";
		String mgstBldpRtAmt 	= "";
		String mgstPotcScgRtAmt = "";
		String mgstPrtcScgRtAmt = "";
		
		
		for(int i = 1; i <= 2; i++){
			if(i == 1){
				eqTpszCd = "CLG";
				onhInitValAmt 	 = JSPUtil.getNull(mgsAgreementINVO.getOnhInitValAmtClg());
				mgstLseFxRtAmt	 = JSPUtil.getNull(mgsAgreementINVO.getMgstLseFxRtAmtClg());
				mgstBldpRtAmt	 = JSPUtil.getNull(mgsAgreementINVO.getMgstBldpRtAmtClg());
				mgstPotcScgRtAmt = JSPUtil.getNull(mgsAgreementINVO.getMgstPotcScgRtAmtClg());	
				mgstPrtcScgRtAmt = JSPUtil.getNull(mgsAgreementINVO.getMgstPrtcScgRtAmtClg());
				
			} else if(i == 2){
				eqTpszCd = "UMG";
				onhInitValAmt 	 = JSPUtil.getNull(mgsAgreementINVO.getOnhInitValAmtUmg());
				mgstLseFxRtAmt	 = JSPUtil.getNull(mgsAgreementINVO.getMgstLseFxRtAmtUmg());
				mgstBldpRtAmt	 = JSPUtil.getNull(mgsAgreementINVO.getMgstBldpRtAmtUmg());
				mgstPotcScgRtAmt = JSPUtil.getNull(mgsAgreementINVO.getMgstPotcScgRtAmtUmg());	
				mgstPrtcScgRtAmt = JSPUtil.getNull(mgsAgreementINVO.getMgstPrtcScgRtAmtUmg());
			}
			
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
	 * LSE_TR_RT 관련 Collection 처리<br>
	 * Lease Agreement Creation (Chassis) - EES_CGM_1020 화면<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO
	 * @param lseTrRtVO CHSAgreementINVO[]
	 * @return List<CHSAgreementINVO>
	 * @exception EventException
	 */
	private List<CHSAgreementINVO> setLseTrRtDataList(CHSAgreementINVO chsAgreementINVO, CHSAgreementINVO[] lseTrRtVO){
		List<CHSAgreementINVO> lseTrRtList = new ArrayList<CHSAgreementINVO>();
		String trRtAmt = "";
		String eqTpszCd = "";
				
		for(int i = 0; i < lseTrRtVO.length; i++){
			
			// ibflag 가 삭제상태가 아닌 경우에 한해서 처리한다.
			if(!lseTrRtVO[i].getIbflag().equals("D")){
			
				for(int k = 1; k <= 10; k++){
				
					if(k == 1){
						eqTpszCd = "SF2";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdSf2());
					} else if(k == 2){
						eqTpszCd = "SL2";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdSl2());
					} else if(k == 3){
						eqTpszCd = "TA2";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdTa2());
					} else if(k == 4){	
						eqTpszCd = "SF4";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdSf4());
					} else if(k == 5){
						eqTpszCd = "GN4";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdGn4());
					} else if(k == 6){	
						eqTpszCd = "CB4";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdCb4());
					} else if(k == 7){
						eqTpszCd = "EG5";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdEg5());
					} else if(k == 8){
						eqTpszCd = "EG8";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdEg8());
					} else if(k == 9){
						eqTpszCd = "GN5";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdGn5());
					} else if(k == 10){
						eqTpszCd = "ZT4";
						trRtAmt = JSPUtil.getNull(lseTrRtVO[i].getEqTpszCdZt4());
					}
					
					
					if(!trRtAmt.equals("")){
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
	 * agreement 기본정보 및 Type Size 별 Depreciation rate & initial rate, <br>
	 * Surcharge, Rental rate 등의 모든 정보를 조회한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @return MGSAgreementGroupVO
	 * @exception EventException
	 */
	public MGSAgreementGroupVO searchMGSAgreementAllBasic(MGSAgreementINVO mgsAgreementINVO) throws EventException {
		
		// Response 객체를 담기위한 Map 객체
		MGSAgreementGroupVO agmtList = new MGSAgreementGroupVO();
		//Map<String, Object> responseData = new HashMap<String, Object>();
		
		try {
			// ETC Data 를  담기위한 Map 객체
			Map<String, String> etcData = new HashMap<String, String>();
			
			//----------------------------
			// Agreement Main 데이터 조회
			//----------------------------
			List<MGSAgreementMGTVO> agreementList = dbDao.searchMGSAgreementMainData(mgsAgreementINVO);
			
			MGSAgreementMGTVO agreementInfo = new MGSAgreementMGTVO();
			MGSAgreementMGTVO mgsAgreementLseRtData =  new MGSAgreementMGTVO();
			
			if(agreementList != null){
				if(agreementList.size() > 0){
					// 리스트 중에서 AGMT_VER_NO 가 가장 높은 데이터 한건을 ETCDATA 에 설정한다.(마지막 건)	Form Data
					agreementInfo = (MGSAgreementMGTVO)agreementList.get(agreementList.size()-1);
				
					// Agreement Number 세팅
					String agmtSeq = "000000" + agreementInfo.getAgmtSeq();
					String agmtNo =  agreementInfo.getAgmtOfcCtyCd() + agmtSeq.substring(agmtSeq.length() - 6)  ;
					
					// INVO 세팅 
					agreementInfo.setAgmtNo(agmtNo);
					mgsAgreementINVO.setAgmtVerNo(agreementInfo.getAgmtVerNo());	// 현재 Agreement Version 을 설정
					
					//------------------------------
					//	CGM_AGMT_LSE_RT 조회
					//-------------------------------
					mgsAgreementLseRtData = dbDao.searchMGSAgreementLseRtData(mgsAgreementINVO);
				}
			}
			
			// ETCDATA 설정
			etcData = agreementInfo.getColumnValues();
			
			etcData.put("onh_init_val_amt_clg", 	mgsAgreementLseRtData.getOnhInitValAmtClg());
			etcData.put("onh_init_val_amt_umg", 	mgsAgreementLseRtData.getOnhInitValAmtUmg());
			etcData.put("mgst_lse_fx_rt_amt_clg", 	mgsAgreementLseRtData.getMgstLseFxRtAmtClg());
			etcData.put("mgst_lse_fx_rt_amt_umg", 	mgsAgreementLseRtData.getMgstLseFxRtAmtUmg());
			etcData.put("mgst_bldp_rt_amt_clg", 	mgsAgreementLseRtData.getMgstBldpRtAmtClg());
			etcData.put("mgst_bldp_rt_amt_umg", 	mgsAgreementLseRtData.getMgstBldpRtAmtUmg());
			etcData.put("mgst_potc_scg_rt_amt_clg", mgsAgreementLseRtData.getMgstPotcScgRtAmtClg());
			etcData.put("mgst_potc_scg_rt_amt_umg", mgsAgreementLseRtData.getMgstPotcScgRtAmtUmg());
			etcData.put("mgst_prtc_scg_rt_amt_clg", mgsAgreementLseRtData.getMgstPrtcScgRtAmtClg());
			etcData.put("mgst_prtc_scg_rt_amt_umg", mgsAgreementLseRtData.getMgstPrtcScgRtAmtUmg());
			agmtList.setEtcData(etcData);
			//agmtList.add(etcData);		
			
			// 기타 Agreement 관련정보
			if(agreementList != null){
				if(agreementList.size() > 0){		
					//-------------------------------
					// Version No 목록을 위해서 설정
					//------------------------------
					mgsAgreementINVO.setAgmtVerNo("");	// Agreement No 에 해당하는 전체 데이터를 가져오기 위해.
					List<MGSAgreementMGTVO> agreementList2 = dbDao.searchMGSAgreementMainData(mgsAgreementINVO);
					agmtList.setMgsagreementmgtvo(agreementList2);
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
	 * 화면에서 입력된 내용대로 최초 Agreement 생성(UI_CGM_2021) 및 기존의 Agreement 정보를 수정한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return MGSAgreementMGTVO
	 * @exception EventException
	 */
	public MGSAgreementMGTVO modifyMGSAgreementBasic(MGSAgreementINVO mgsAgreementINVO, SignOnUserAccount account) throws EventException {
		
		MGSAgreementMGTVO mgsAgreementMGTVO = new MGSAgreementMGTVO();
		
		try {
			
			// 작업변수 설정
			String actionFlag = mgsAgreementINVO.getActionFlag();

			String agmtOfcCtyCd = "";
			String agmtSeq = "";
			
			// 신규입력시 Agreement No 생성
			if(actionFlag.equalsIgnoreCase("N")){
				agmtOfcCtyCd = mgsAgreementINVO.getAgmtIssOfcCd().substring(0, 3);
				agmtSeq = dbDao.searchMGSAgreemetAgmtSeqData(mgsAgreementINVO);
				
				// Agreement No 를  VO에 설정
				mgsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);	
				mgsAgreementINVO.setAgmtSeq(agmtSeq);
				mgsAgreementINVO.setAgmtVerNo("1");
				
				String tempAgmtSeq = "000000" + agmtSeq;
				String tempAgmtNo = agmtOfcCtyCd + tempAgmtSeq.substring(tempAgmtSeq.length() - 6) ;
				mgsAgreementINVO.setAgmtNo(tempAgmtNo);
				
			}
			
			// G/W Contract 입력시 action_flag는 "G"로 세팅되며 
			// 기존계약데이터도 G/W Contract를 입력하여 새로 저장해야 하기때문에 체크로직을 스킵하도록 만듬
			// UI상에서는 Retrieve시에 모든 화면요소가 비활성화 되기 때문에
			if(mgsAgreementINVO.getGwUqDocNo().length() > 0 && !actionFlag.equalsIgnoreCase("R")) {
				// Charge Creation 된 데이터가 존재하는지 체크
				boolean chkChargeCreData = dbDao.checkMGSExistChgCreDataByAgreementData(mgsAgreementINVO);
				if(!chkChargeCreData){
					throw new EventException(new ErrorHandler("CGM20026",new String[]{}).getMessage());
				}
			}
			
			// CGM_AGREEMENT 에 데이터 존재하는지 체크
			List<MGSAgreementMGTVO> agmtList = dbDao.searchMGSAgreementMainData(mgsAgreementINVO);
				
			if(agmtList != null){
				// CGM Agreement 에 데이터가 존재하면 Modify 수행, 존재하지 않으면 ADD 수행
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
						
					// Version Up 일 경우 이전 Version 의 데이터 중  Master 데이터를 Update 한다. 
					if(actionFlag.equalsIgnoreCase("V")){
							
						// 이전 Version 의 데이터를 조회 및 수정하기 위한 VO
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
					
						// Version Up 된 effDt 가 이전  Version의 effDt와 expDt 사이에 있을 때 체크
						int day = 1;
						if(effDt.compareTo(preEffDt) > 0 && effDt.compareTo(preExpDt) <= 0){
							SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd", java.util.Locale.KOREA);
							Date date = formatter.parse(effDt);
							date.setTime(date.getTime() - ((long)day * 1000 * 60 * 60 * 24));
							preExpDt = formatter.format(date);
						}
							
						preVO.setEffDt(preEffDt);
						preVO.setExpDt(preExpDt);
							
						// Previous 데이터 수정 
						dbDao.modifyMGSAgreemetPreviousMainData(preVO);
							
					}
				}
					
				/*--------------------------------------------
						CGM_AGMT_LSE_RT
				---------------------------------------------*/
				List<MGSAgreementINVO> lseRtList = new ArrayList<MGSAgreementINVO>();
				lseRtList = setLseRtDataList(mgsAgreementINVO);
					
				dbDao.removeMGSAgreementLseRtData(mgsAgreementINVO);
				dbDao.addMGSAgreementLseRtData(lseRtList);
					
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
	 * 선택된 Agreement 를 삭제 처리 한다 [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeMGSAgreementBasic(MGSAgreementINVO mgsAgreementINVO, SignOnUserAccount account) throws EventException {
		try {
			/*---------------------------
			 	Validation 체크
			 ----------------------------*/
			// Last Version 이 아닐 경우 Exception 처리
			if(!mgsAgreementINVO.getLstVerFlg().equals("Y")){ 
				throw new EventException(new ErrorHandler("CGM20007",new String[]{}).getMessage());
			} 
			
			// Version 1일 경우는 장비가 있을 때 Exception 처리, 다른 버전일 경우에는 장비 History 가 있을 경우 Exception 처리 			
			if(mgsAgreementINVO.getAgmtVerNo().equals("1")){
				boolean checkUseEquipment = dbDao.checkMGSAgreementUseEquipmentData(mgsAgreementINVO);
				if(checkUseEquipment){
					// 장비에서 Agreement No 를 사용하고 있으면  Exception 처리
					throw new EventException(new ErrorHandler("CGM20016",new String[]{}).getMessage());
				} 
			} else {
				// Charge Creation 된 데이터가 존재하는지 체크
				boolean chkChargeCreData = dbDao.checkMGSExistChgCreDataByAgreementData(mgsAgreementINVO);
				if(!chkChargeCreData){
					throw new EventException(new ErrorHandler("CGM20026",new String[]{}).getMessage());
				}
			}	
			
			/*-------------------------------
				 삭제처리
			--------------------------------*/
						
			// CGM_AGMT_LSE_RT 정보 삭제
			dbDao.removeMGSAgreementLseRtData(mgsAgreementINVO);
								
			// CGM_AGREEMENT 정보 삭제
			dbDao.removeMGSAgreementMainData(mgsAgreementINVO);
								
			// 이전 버전의 Version Last flag 를  'Y'로 변경처리
			String preAgmtVerNo = String.valueOf(Integer.parseInt(mgsAgreementINVO.getAgmtVerNo())-1);
								
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
	 * 선택된 Agreement 에 해당하는 Term change 대상이 될  Chassis 를 조회한다. [EES_CGM_1026]<br>
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
	 * Chassis의 마스터 정보를 조회한다. [EES_CGM_1026]<br>
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
			}
			responseData.setChstermstatusmgtvos(list);
			responseData.setChstermstatusmgtvo(chsTermStatusMGTVO);
			
//			responseData.add(list);	// 데이터 건수를 표시하기 위해 VO LIST를 설정
//			responseData.add(chsTermStatusMGTVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return responseData;
	}
	
	/**
	 * 선택된 Agreement 에 해당하는 Term change 대상이 될  M.G.Set list 를 조회한다. [EES_CGM_2026]<br>
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
	 * M.G.Set 의 마스터 정보를 조회한다. [EES_CGM_2026]<br>
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
			}
			responseData.setMgstermstatusmgtvos(list);
			responseData.setMgstermstatusmgtvo(mgsTermStatusMGTVO);
//			responseData.add(list);	// 데이터 건수를 표시하기 위해 VO LIST를 설정
//			responseData.add(mgsTermStatusMGTVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		
		return responseData;
	}
	
	/**
	 * Term change 된 EQ 를 대상으로 EQ 카운트를 Summary 하여 보여준다. [EES_CGM_1118]<br>
	 * 
	 * @param chsTermChangeResultINVO CHSTermChangeResultINVO 
	 * @return List<CHSTermChangeResultMGTVO>
	 * @exception EventException
	 */
	public List<CHSTermChangeResultMGTVO> searchCHSTermChangeResultSmryBasic(CHSTermChangeResultINVO chsTermChangeResultINVO) throws EventException {
		try {
			
			// 조회 파라메터 변경처리
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

			// 조회실행
			return dbDao.searchCHSTermChangeResultSmryData(chsTermChangeResultINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * Term change 된 EQ 를 대상으로 EQ 카운트를 Summary 하여 보여준다. [EES_CGM_2028]<br>
	 *  
	 * @param mgsTermChangeResultINVO MGSTermChangeResultINVO 
	 * @return List<MGSTermChangeResultMGTVO>
	 * @exception EventException
	 */
	public List<MGSTermChangeResultMGTVO> searchMGSTermChangeResultSmryBasic(MGSTermChangeResultINVO mgsTermChangeResultINVO) throws EventException {
		try {
			
			// 조회 파라메터 변경처리
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

			// 조회실행
			return dbDao.searchMGSTermChangeResultSmryData(mgsTermChangeResultINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
	
	/**
	 * CPS Agreement 기본정보 및 Rate, Condition 등의 모든 정보를 조회한다.(Chassis)<br>
	 * 
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	 * @return CHSCpsAgreementGroupVO
	 * @exception EventException
	 */
	public CHSCpsAgreementGroupVO searchCHSCpsAgreementAllBasic(CHSCpsAgreementINVO chsCpsAgreementINVO) throws EventException {
		
		// Response 객체를 담기위한 List 객체
		CHSCpsAgreementGroupVO agmtList = new CHSCpsAgreementGroupVO();
		
		try {
			// ETC Data 를  담기위한 Map 객체
			Map<String, String> etcData = new HashMap<String, String>();
	 
			//----------------------------
			// Agreement Main 데이터 조회
			//----------------------------
			List<CHSCpsAgreementMGTVO> agreementList = dbDao.searchCHSCpsAgreementMainData(chsCpsAgreementINVO);
			
			CHSCpsAgreementMGTVO agreementInfo = new CHSCpsAgreementMGTVO();
			
			if(agreementList != null){
				if(agreementList.size() > 0){
					// 리스트 중에서 AGMT_VER_NO 가 가장 높은 데이터 한건을 ETCDATA 에 설정한다.(마지막 건)	Form Data
					agreementInfo = (CHSCpsAgreementMGTVO)agreementList.get(agreementList.size()-1);
				
					// Agreement Number 세팅
					String agmtSeq = "000000" + agreementInfo.getAgmtSeq();
					String agmtNo =  agreementInfo.getAgmtOfcCtyCd() + agmtSeq.substring(agmtSeq.length() - 6)  ;
					
					// INVO 세팅 
					agreementInfo.setAgmtNo(agmtNo);
					chsCpsAgreementINVO.setAgmtVerNo(agreementInfo.getAgmtVerNo());	// 현재 Agreement Version 을 설정
				}
			}
			
			// 해당하는 Agreement No 의 최신버전 정보를 취득한다.
			etcData = agreementInfo.getColumnValues();
			
			agmtList.setEtcData(etcData);
//			agmtList.add(etcData);
			
			
			// 기타 정보를 수집한다.
			if(agreementList != null){
				if(agreementList.size() > 0){
					//-------------------------------
					//	CGM_AGMT_CPS_RT 조회
					//-------------------------------
					List<CHSCpsAgreementMGTVO> chsCpsAgreementRateData = dbDao.searchCHSCpsAgreementRateData(chsCpsAgreementINVO);
					agmtList.setChsCpsAgreementMGTVO(chsCpsAgreementRateData);
//					agmtList.add(chsAgreementLseRtData);
					
					//------------------------------
					// CGM_AGMT_CPS_COND 조회
					//------------------------------
					List<CHSCpsAgreementMGTVO> chsCpsAgreementCondData = dbDao.searchCHSCpsAgreementCondData(chsCpsAgreementINVO);
					agmtList.setChsCpsAgreementMGTVO2(chsCpsAgreementCondData);
//					agmtList.add(chsAgreementLseScgData);
					
					//-------------------------------
					// Version No 목록을 위해서 설정
					//------------------------------
					chsCpsAgreementINVO.setAgmtVerNo("");	// Agreement No 에 해당하는 전체 데이터를 가져오기 위해.
					List<CHSCpsAgreementMGTVO> agreementList2 = dbDao.searchCHSCpsAgreementMainData(chsCpsAgreementINVO);
					agmtList.setChsCpsAgreementMGTVO3(agreementList2);
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
	 * Tab2에서 입력된 Yard Code로부터 Yard Name과 Tab1의 SCC를 체크한다.<br>
	 * 
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	 * @return CHSCpsAgreementMGTVO
	 * @exception EventException
	 */
	public CHSCpsAgreementMGTVO checkCHSCpsAgreementYardBasic(CHSCpsAgreementINVO chsCpsAgreementINVO) throws EventException {
		CHSCpsAgreementMGTVO chsCpsAgreementMGTVO = new CHSCpsAgreementMGTVO();
		try{
			chsCpsAgreementMGTVO = dbDao.checkCHSCpsAgreementYardData(chsCpsAgreementINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		return chsCpsAgreementMGTVO;
	}
	
	/**
	 * 화면에서 입력된 내용대로 최초 NP(ZP) Agreement 생성 및 기존의 NP(ZP) Agreement 정보를 수정한다. [EES_CGM_1202]<br>
	 * 
	 * @param chsCpsAgreementINVOs List<CHSCpsAgreementINVO[]> 
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return CHSCpsAgreementMGTVO
	 * @exception EventException
	 */
	public CHSCpsAgreementMGTVO modifyCHSCpsAgreementBasic(List<CHSCpsAgreementINVO[]> chsCpsAgreementINVOs, 
			CHSCpsAgreementINVO chsCpsAgreementINVO, SignOnUserAccount account) throws EventException {
		
		CHSCpsAgreementMGTVO chsCpsAgreementMGTVO = new CHSCpsAgreementMGTVO();
		
		try {
			
			// 작업변수 설정
			String actionFlag = chsCpsAgreementINVO.getActionFlag();
			String chssPoolCd = chsCpsAgreementINVO.getChssPoolCd();
			String agmtOfcCtyCd = "";
			String agmtSeq = "";
			
			// 신규입력시 Agreement No 생성
			if(actionFlag.equalsIgnoreCase("N")){
				agmtOfcCtyCd = "NYC";
//				agmtOfcCtyCd = cpsAgreementINVO.getAgmtIssOfcCd().substring(0, 3);
				agmtSeq = dbDao.searchCHSCpsAgreemetAgmtSeqData(chsCpsAgreementINVO);
				
				// Agreement No 를  VO에 설정
				chsCpsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);	
				chsCpsAgreementINVO.setAgmtSeq(agmtSeq);
				chsCpsAgreementINVO.setAgmtVerNo("1");
				
				String tempAgmtSeq = "000000" + agmtSeq;
				String tempAgmtNo = agmtOfcCtyCd + tempAgmtSeq.substring(tempAgmtSeq.length() - 6) ;
				chsCpsAgreementINVO.setAgmtNo(tempAgmtNo);
				
			}
			
			// Charge Creation 된 데이터가 존재하는지 체크
//			boolean chkChargeCreData = dbDao.checkCPSExistChgCreDataByAgreementData(cpsAgreementINVO);
//			if(!chkChargeCreData){
//				throw new EventException(new ErrorHandler("CGM20026",new String[]{}).getMessage());
//			}
			
			// G/W Contract 입력시 action_flag는 "G"로 세팅되며 
			// 기존계약데이터도 G/W Contract를 입력하여 새로 저장해야 하기때문에 체크로직을 스킵하도록 만듬
			// UI상에서는 Retrieve시에 모든 화면요소가 비활성화 되기 때문에
//			if(chsCpsAgreementINVO.getGwUqDocNo().length() > 0 && !actionFlag.equalsIgnoreCase("R")) {
//			}
			
			// Pool Code 에 값이 들어왔을 경우 다른 Agreement No 에  동일한 Pool Code 가  존재하는지 체크
			List<CHSCpsAgreementMGTVO> chkPoolMatch = null;
			if(!chssPoolCd.equals("") && chssPoolCd != null){
				chkPoolMatch = dbDao.checkCHSCpsAgreementPoolMatchData(chsCpsAgreementINVO);
				if(chkPoolMatch != null){
					if(chkPoolMatch.size() > 0){
						String sAgmtOfcCtyCd = chkPoolMatch.get(0).getAgmtOfcCtyCd();
						String sAgmtSeq = chkPoolMatch.get(0).getAgmtSeq();
						String sAgmtNo = sAgmtOfcCtyCd + JSPUtil.getLPAD(sAgmtSeq, 6, "0");
						
						// 다른 Agreement 에 Pool Code 가 존재하면 Exception 처리
						throw new EventException(new ErrorHandler("CGM20014",new String[]{sAgmtNo}).getMessage());
					}
				}
			}
			
			/*---------------------------------------------
			 * 프로세스 	실행 시작
			 *-------------------------------------------*/
			// CGM_AGREEMENT 에 데이터 존재하는지 체크
			List<CHSCpsAgreementMGTVO> agmtList = dbDao.searchCHSCpsAgreementMainData(chsCpsAgreementINVO);
				
			if(agmtList != null){
				// CGM Agreement 에 데이터가 존재하면 Modify 수행, 존재하지 않으면 ADD 수행
				if(agmtList.size() > 0){
					/*--------------------------------
						CGM_AGREEMENT Modify
					----------------------------------*/
					String agmtNo = chsCpsAgreementINVO.getAgmtNo();
					agmtOfcCtyCd = agmtNo.substring(0, 3);
					agmtSeq = agmtNo.substring(3);
						
					chsCpsAgreementINVO.setCreUsrId(account.getUsr_id());
					chsCpsAgreementINVO.setUpdUsrId(account.getUsr_id());
					chsCpsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);
					chsCpsAgreementINVO.setAgmtSeq(agmtSeq);
						
					dbDao.modifyCHSCpsAgreemetMainData(chsCpsAgreementINVO);
				} else {
					/*----------------------------------
					 	CGM_AGREEMENT Insert
					 -----------------------------------*/
					chsCpsAgreementINVO.setCreUsrId(account.getUsr_id());
					chsCpsAgreementINVO.setUpdUsrId(account.getUsr_id());
					chsCpsAgreementINVO.setLstVerFlg("Y");	
					
					dbDao.addCHSCpsAgreemetMainData(chsCpsAgreementINVO);
					
					// Version Up 일 경우 이전 Version 의 데이터 중  Master 데이터를 Update 한다. 
					if(actionFlag.equalsIgnoreCase("V")){
						
						// 이전 Version 의 데이터를 조회 및 수정하기 위한 VO
						CHSCpsAgreementINVO preVO = new CHSCpsAgreementINVO();
						String preAgmtVerNo = String.valueOf(Integer.parseInt(chsCpsAgreementINVO.getAgmtVerNo())-1);
						String agmtEffDt = chsCpsAgreementINVO.getAgmtEffDt().replaceAll("-", "");
//						String agmtExpDt = cpsAgreementINVO.getAgmtExpDt().replaceAll("-", "");
						String preEffDt = chsCpsAgreementINVO.getPreEffDt().replaceAll("-", "");
						String preExpDt = chsCpsAgreementINVO.getPreExpDt().replaceAll("-", "") ;
						
						preVO.setAgmtOfcCtyCd(chsCpsAgreementINVO.getAgmtOfcCtyCd());
						preVO.setAgmtSeq(chsCpsAgreementINVO.getAgmtSeq());
						preVO.setAgmtVerNo(preAgmtVerNo);
						preVO.setUpdUsrId(account.getUsr_id());
						preVO.setLstVerFlg("N");
						
						// Version Up 된 effDt 가 이전  Version의 effDt와 expDt 에 있을 때 체크
						int day = 1;
						if(agmtEffDt.compareTo(preEffDt) > 0 && agmtEffDt.compareTo(preExpDt) <= 0){
							SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd", java.util.Locale.KOREA);
							Date date = formatter.parse(agmtEffDt);
							date.setTime(date.getTime() - ((long)day * 1000 * 60 * 60 * 24));
							preExpDt = formatter.format(date);
						}
						
						preVO.setAgmtEffDt(preEffDt);
						preVO.setAgmtExpDt(preExpDt);
						
						// Previous 데이터 수정 
						dbDao.modifyCHSCpsAgreemetPreviousMainData(preVO);
							
					}
				}
				
				CHSCpsAgreementINVO[] rateVO = (CHSCpsAgreementINVO[])chsCpsAgreementINVOs.get(0);
				CHSCpsAgreementINVO[] condVO = (CHSCpsAgreementINVO[])chsCpsAgreementINVOs.get(1);
				
				/*--------------------------------------------
			 		CGM_AGMT_CPS_RT
			 	---------------------------------------------*/
				
				if(rateVO != null){
					List<CHSCpsAgreementINVO> rateList = new ArrayList<CHSCpsAgreementINVO>();
					for(int i = 0; i < rateVO.length; i++){
						CHSCpsAgreementINVO tempVo = rateVO[i];
						
						// ibflag 가 삭제상태가 아닌 경우에 한해 처리
						if(!rateVO[i].getIbflag().equalsIgnoreCase("D")){
							tempVo.setAgmtOfcCtyCd(chsCpsAgreementINVO.getAgmtOfcCtyCd());
							tempVo.setAgmtSeq(chsCpsAgreementINVO.getAgmtSeq());
							tempVo.setAgmtVerNo(chsCpsAgreementINVO.getAgmtVerNo());
							tempVo.setCreUsrId(account.getUsr_id());
							tempVo.setUpdUsrId(account.getUsr_id());
							
							rateList.add(tempVo);
						}
					}
					dbDao.removeCHSCpsAgreementRateData(chsCpsAgreementINVO);
					dbDao.addCHSCpsAgreementRateData(rateList);
				}
					
				/*----------------------------------
				 	CGM_AGMT_CPS_COND 
				 -----------------------------------*/
				if(condVO != null){
					List<CHSCpsAgreementINVO> condList = new ArrayList<CHSCpsAgreementINVO>();
					for(int i = 0; i < condVO.length; i++){
						CHSCpsAgreementINVO tempVo = condVO[i];
							
						// ibflag 가 삭제상태가 아닌 경우에 한해 처리
						if(!condVO[i].getIbflag().equalsIgnoreCase("D")){
							tempVo.setAgmtOfcCtyCd(chsCpsAgreementINVO.getAgmtOfcCtyCd());
							tempVo.setAgmtSeq(chsCpsAgreementINVO.getAgmtSeq());
							tempVo.setAgmtVerNo(chsCpsAgreementINVO.getAgmtVerNo());
							tempVo.setCreUsrId(account.getUsr_id());
							tempVo.setUpdUsrId(account.getUsr_id());
							
							condList.add(tempVo);
						}
					}
						
					dbDao.removeCHSCpsAgreementCondData(chsCpsAgreementINVO);
					dbDao.addCHSCpsAgreementCondData(condList);
				}
			}
			
			chsCpsAgreementMGTVO.setAgmtNo(chsCpsAgreementINVO.getAgmtNo());
			chsCpsAgreementMGTVO.setAgmtOfcCtyCd(chsCpsAgreementINVO.getAgmtOfcCtyCd());
			chsCpsAgreementMGTVO.setAgmtSeq(chsCpsAgreementINVO.getAgmtSeq());
			chsCpsAgreementMGTVO.setAgmtVerNo(chsCpsAgreementINVO.getAgmtVerNo());
			chsCpsAgreementMGTVO.setLstVerFlg(chsCpsAgreementINVO.getLstVerFlg());
			
			
		} catch (EventException ex){
			throw ex;	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
				
		return chsCpsAgreementMGTVO;
	}
	
	/**
	 * 선택된 NP(ZP) Agreement 를 삭제 처리 한다. [EES_CGM_1202] <br>
	 * 
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeCHSCpsAgreementBasic(CHSCpsAgreementINVO chsCpsAgreementINVO, SignOnUserAccount account) throws EventException{
		try {
			/*---------------------------
			 	Validation 체크
			 ----------------------------*/
			// Last Version 이 아닐 경우 Exception 처리
			if(!chsCpsAgreementINVO.getLstVerFlg().equals("Y")){ 
				throw new EventException(new ErrorHandler("CGM20007",new String[]{}).getMessage());
			}
				
			// Charge Creation 된 데이터가 존재하는지 체크
			boolean chkChargeCreData = dbDao.checkCHSCpsExistChgCreDataByAgreementData(chsCpsAgreementINVO);
			if(!chkChargeCreData){
				throw new EventException(new ErrorHandler("CGM20026",new String[]{}).getMessage());
			}
			
			/*-------------------------------
				 삭제처리
			--------------------------------*/
			// CGM_AGMT_CPS_RT 정보 삭제
			dbDao.removeCHSCpsAgreementRateData(chsCpsAgreementINVO);
			// CGM_AGMT_CPS_COND 정보 삭제
			dbDao.removeCHSCpsAgreementCondData(chsCpsAgreementINVO);
			// CGM_AGREEMENT 정보 삭제
			dbDao.removeCHSCpsAgreementMainData(chsCpsAgreementINVO);
			
			// 이전 버전의 Version Last flag 를  'Y'로 변경처리
			String preAgmtVerNo = String.valueOf(Integer.parseInt(chsCpsAgreementINVO.getAgmtVerNo())-1);
			
			if(preAgmtVerNo.compareTo("0") > 0){
				CHSCpsAgreementINVO preVO = new CHSCpsAgreementINVO();
								
				preVO.setAgmtOfcCtyCd(chsCpsAgreementINVO.getAgmtOfcCtyCd());
				preVO.setAgmtSeq(chsCpsAgreementINVO.getAgmtSeq());
				preVO.setAgmtVerNo(preAgmtVerNo);
				preVO.setUpdUsrId(account.getUsr_id());
				preVO.setLstVerFlg("Y");
//				preVO.setAgmtExpDt(cpsAgreementINVO.getAgmtExpDt().replaceAll("-", ""));
				
				dbDao.modifyCHSCpsAgreemetPreviousMainData(preVO);
			}
			
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}
}