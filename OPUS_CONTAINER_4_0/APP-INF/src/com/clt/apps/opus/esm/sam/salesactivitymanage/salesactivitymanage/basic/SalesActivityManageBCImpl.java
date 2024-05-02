/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageBCImpl.java
*@FileTitle : Sales Activity Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration.SalesActivityManageDBDAO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SRepInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInputVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamPFMCbyCustInputVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-SalesActivityManage Business Logic Command Interface<br>
 * - ALPS-SalesActivityManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author LEEKUANSIAN
 * @see SalesActivityManageBCImpl
 * @since J2EE 1.6
 */
public class SalesActivityManageBCImpl extends BasicCommandSupport implements SalesActivityManageBC {

	// Database Access Object
	private transient SalesActivityManageDBDAO dbDao = null;

	/**
	 * SalesActivityManageBCImpl 객체 생성<br>
	 * SalesActivityManageDBDAO를 생성한다.<br>
	 */
	public SalesActivityManageBCImpl() {
		dbDao = new SalesActivityManageDBDAO();
	}
	
	/**
	 * ESM_SAM_0008
	 * [Sheet1]을 [조회] 합니다.<br>
	 * 
	 * @param SRepInfoVO sRepInfoVO
	 * @return List<SRepInfoVO>
	 * @exception EventException
	 */
	public List<SRepInfoVO> searchSalesReportInfo(SRepInfoVO sRepInfoVO) throws EventException, DAOException {
		try {
			return dbDao.searchSalesReportInfo(sRepInfoVO);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SAM_0008
	 * [Sheet1]을 [저장] 합니다.<br>
	 * 
	 * @param SRepInfoVO[] sRepInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageSalesReportInfo(SRepInfoVO[] sRepInfoVOs, SignOnUserAccount account) throws EventException, DAOException{
		try {
			List<SRepInfoVO> insertVoList = new ArrayList<SRepInfoVO>();
			List<SRepInfoVO> updateVoList = new ArrayList<SRepInfoVO>();
			List<SRepInfoVO> deleteVoList = new ArrayList<SRepInfoVO>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			
			for ( int i=0; i<sRepInfoVOs.length; i++ ) {
				if ( sRepInfoVOs[i].getIbflag().equals("I")){
					sRepInfoVOs[i].setCreUsrId(account.getUsr_id());
					sRepInfoVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(sRepInfoVOs[i]);
				} else if ( sRepInfoVOs[i].getIbflag().equals("U")){
					sRepInfoVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(sRepInfoVOs[i]);
				} else if ( sRepInfoVOs[i].getIbflag().equals("D")){
					
					deleteVoList.add(sRepInfoVOs[i]);
				}
			}			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSalesReportInfo(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySalesReportInfo(updateVoList);
				dbDao.modifyCallFlgActDt(updateVoList);
			}

			return eventResponse;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SAM_0008
	 * [Sheet2]을 [조회] 합니다.<br>
	 * 
	 * @param SRepInfoVO sRepInfoVO
	 * @return List<SRepInfoVO>
	 * @exception EventException
	 */
	public List<SRepInfoVO> searchCustSatisFaction(SRepInfoVO sRepInfoVO) throws EventException, DAOException {
		try {
			return dbDao.searchCustSatisFaction(sRepInfoVO);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SAM_0008
	 * [Sheet2]을 [저장] 합니다.<br>
	 * 
	 * @param SRepInfoVO[] sRepInfoVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageCustSatisFaction(SRepInfoVO[] sRepInfoVOs, SignOnUserAccount account) throws EventException, DAOException{
		try {
			List<SRepInfoVO> modifyVoList = new ArrayList<SRepInfoVO>();
			SRepInfoVO insRepInfoVO = null; 
			SRepInfoVO sRepInfoVO = null;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			int modMaxSize = 0;
			for ( int i=0; i<sRepInfoVOs.length; i++ ) {
				insRepInfoVO = sRepInfoVOs[i];
				
				if( insRepInfoVO.getSes() != null && !insRepInfoVO.getSes().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("SES");
					sRepInfoVO.setGrd(insRepInfoVO.getSes());
					sRepInfoVO.setRsn(insRepInfoVO.getSesRsn());
					modifyVoList.add(sRepInfoVO);
				} 
				if( insRepInfoVO.getScr() != null && !insRepInfoVO.getScr().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("SCR");
					sRepInfoVO.setGrd(insRepInfoVO.getScr());
					sRepInfoVO.setRsn(insRepInfoVO.getScrRsn());
					modifyVoList.add(sRepInfoVO);
				} 
				if( insRepInfoVO.getEqs() != null && !insRepInfoVO.getEqs().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("EQS");
					sRepInfoVO.setGrd(insRepInfoVO.getEqs());
					sRepInfoVO.setRsn(insRepInfoVO.getEqsRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getCah() != null && !insRepInfoVO.getCah().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("CAH");
					sRepInfoVO.setGrd(insRepInfoVO.getCah());
					sRepInfoVO.setRsn(insRepInfoVO.getCahRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getSep() != null && !insRepInfoVO.getSep().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("SEP");
					sRepInfoVO.setGrd(insRepInfoVO.getSep());
					sRepInfoVO.setRsn(insRepInfoVO.getSepRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getRel() != null && !insRepInfoVO.getRel().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("REL");
					sRepInfoVO.setGrd(insRepInfoVO.getRel());
					sRepInfoVO.setRsn(insRepInfoVO.getRelRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getUsf() != null && !insRepInfoVO.getUsf().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("USF");
					sRepInfoVO.setGrd(insRepInfoVO.getUsf());
					sRepInfoVO.setRsn(insRepInfoVO.getUsfRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getBoc() != null && !insRepInfoVO.getBoc().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("BOC");
					sRepInfoVO.setGrd(insRepInfoVO.getBoc());
					sRepInfoVO.setRsn(insRepInfoVO.getBocRsn());
					modifyVoList.add(sRepInfoVO);

				}
				if( insRepInfoVO.getDob() != null && !insRepInfoVO.getDob().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("DOB");
					sRepInfoVO.setGrd(insRepInfoVO.getDob());
					sRepInfoVO.setRsn(insRepInfoVO.getDobRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getAts() != null && !insRepInfoVO.getAts().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("ATS");
					sRepInfoVO.setGrd(insRepInfoVO.getAts());
					sRepInfoVO.setRsn(insRepInfoVO.getAtsRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getClh() != null && !insRepInfoVO.getClh().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("CLH");
					sRepInfoVO.setGrd(insRepInfoVO.getClh());
					sRepInfoVO.setRsn(insRepInfoVO.getClhRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getQur() != null && !insRepInfoVO.getQur().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("QUR");
					sRepInfoVO.setGrd(insRepInfoVO.getQur());
					sRepInfoVO.setRsn(insRepInfoVO.getQurRsn());
					modifyVoList.add(sRepInfoVO);
				}
				if( insRepInfoVO.getCun() != null && !insRepInfoVO.getCun().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("CUN");
					sRepInfoVO.setGrd(insRepInfoVO.getCun());
					sRepInfoVO.setRsn(insRepInfoVO.getCunRsn());
					modifyVoList.add(sRepInfoVO);

				}
				// Null 인경우도 save 되도록 주석처리함
//				if( insRepInfoVO.getCurRsn() != null && !insRepInfoVO.getCurRsn().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("CUR");
					sRepInfoVO.setGrd("");
					sRepInfoVO.setRsn(insRepInfoVO.getCurRsn());
					modifyVoList.add(sRepInfoVO);
//				}
//				if( insRepInfoVO.getSrcRsn() != null && !insRepInfoVO.getSrcRsn().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("SRC");
					sRepInfoVO.setGrd(insRepInfoVO.getSrc());
					sRepInfoVO.setRsn(insRepInfoVO.getSrcRsn());
					modifyVoList.add(sRepInfoVO);
//				}
//				if( insRepInfoVO.getWsiRsn() != null && !insRepInfoVO.getWsiRsn().trim().equals("")) {
					sRepInfoVO = new SRepInfoVO();
					sRepInfoVO.setCustSatsfcItmCd("WSI");
					sRepInfoVO.setGrd("");
					sRepInfoVO.setRsn(insRepInfoVO.getWsiRsn());
					modifyVoList.add(sRepInfoVO);
//				}

				modMaxSize = modifyVoList.size();
				for(int j = 0; j <modMaxSize; j++) {
					modifyVoList.get(j).setCustCntCd(insRepInfoVO.getCustCntCd());
					modifyVoList.get(j).setCustSeq(insRepInfoVO.getCustSeq());
					modifyVoList.get(j).setSrepCd(insRepInfoVO.getSrepCd());
					modifyVoList.get(j).setSlsActSeq(insRepInfoVO.getSlsActSeq());
					modifyVoList.get(j).setCreUsrId(account.getUsr_id());
					modifyVoList.get(j).setUpdUsrId(account.getUsr_id());
					modifyVoList.get(j).setIbflag(insRepInfoVO.getIbflag());
				}
			}			
			
			int retVal = 0;
			for(int i=0; i<modMaxSize; i++) {
				/*
				 * update
				 */				
				retVal = dbDao.modifyCustSatisFaction(modifyVoList.get(i));
		
				/*
				 * update 수행 결과가 0건 이면 insert
				 */
				if(retVal == 0) {
					dbDao.addCustSatisFaction(modifyVoList.get(i));
				}
			}
			
			return eventResponse;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SAM_0901 : Retrieve<br>
	 * Activity No 조회<br>
	 * ESM_SAM_0007 : Retrieve<br>
	 * Sales 활동 내역(활동 계획)을 조회<br>
	 * 
	 * @param SamActivityInputVO samActivityInputVO
	 * @return List<SamActivityInputVO>
	 * @exception EventException
	 */
	public List<SamActivityInputVO> searchSalesActivityList(SamActivityInputVO samActivityInputVO) throws EventException {
		try {
			samActivityInputVO.setFromDate(samActivityInputVO.getFromDate().replaceAll("-", ""));
			samActivityInputVO.setToDate(samActivityInputVO.getToDate().replaceAll("-", ""));
			return dbDao.searchSalesActivityList(samActivityInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SAM_0009 : Retrieve<br>
	 * Customer 의 Booking 실적 조회<br>
	 * 
	 * @param SamPFMCbyCustInputVO samPFMCbyCustInputVO
	 * @return List<SamPFMCbyCustInputVO>
	 * @exception EventException
	 */
	public List<SamPFMCbyCustInputVO> searchPFMCbyCustList(SamPFMCbyCustInputVO samPFMCbyCustInputVO) throws EventException {
		try {
			samPFMCbyCustInputVO.setFromDate(samPFMCbyCustInputVO.getFromDate().replaceAll("-", "/"));
			samPFMCbyCustInputVO.setToDate(samPFMCbyCustInputVO.getToDate().replaceAll("-", "/"));
			return dbDao.searchPFMCbyCustList(samPFMCbyCustInputVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SAM_0007 : 저장<br>
	 * 
	 * 
	 * @param SamActivityInfoVO[] samActivityInfoVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageSalesActivityInfo(SamActivityInfoVO[] samActivityInfoVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SamActivityInfoVO> insertVoList = new ArrayList<SamActivityInfoVO>();
			List<SamActivityInfoVO> updateVoList = new ArrayList<SamActivityInfoVO>();
			
			for ( int i=0; i<samActivityInfoVOs.length; i++ ) {
				if ( samActivityInfoVOs[i].getIbflag().equals("U")){
					samActivityInfoVOs[i].setActualDt(samActivityInfoVOs[i].getActualDt().replaceAll("-", ""));
					samActivityInfoVOs[i].setPlanDt(samActivityInfoVOs[i].getPlanDt().replaceAll("-", ""));
					samActivityInfoVOs[i].setCreUserId(account.getUsr_id());
					updateVoList.add(samActivityInfoVOs[i]);		
				}	else if ( samActivityInfoVOs[i].getIbflag().equals("I")){
					samActivityInfoVOs[i].setActualDt(samActivityInfoVOs[i].getActualDt().replaceAll("-", ""));
					samActivityInfoVOs[i].setPlanDt(samActivityInfoVOs[i].getPlanDt().replaceAll("-", ""));
					samActivityInfoVOs[i].setCreUserId(account.getUsr_id());
					insertVoList.add(samActivityInfoVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySalesActivityInfo(updateVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSalesActivityInfo(insertVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SAM_0007 : CUS_NAME<br>
	 * CUS_NAME 확인  <br>
	 * 
	 * @param SamActivityInfoVO samActivityInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustName(SamActivityInfoVO samActivityInfoVO) throws EventException {

		try {
			return dbDao.searchCustName(samActivityInfoVO);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SAM_0007 : CUS_CODE<br>
	 * CUS_CODE 확인  <br>
	 * 
	 * @param SamActivityInfoVO samActivityInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSrepsManageCustList(SamActivityInfoVO samActivityInfoVO) throws EventException {

		try {
			return dbDao.searchSrepsManageCustList(samActivityInfoVO);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SAM_0008
	 * srep_cd on_change
	 * @param SRepInfoVO sRepInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSalesRepName(SRepInfoVO sRepInfoVO) throws EventException {

		try {
			return dbDao.searchSalesRepName(sRepInfoVO);
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	
}