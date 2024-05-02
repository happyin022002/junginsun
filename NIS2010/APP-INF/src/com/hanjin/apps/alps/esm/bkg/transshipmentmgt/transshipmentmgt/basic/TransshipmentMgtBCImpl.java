/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtBCImpl.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2012.01.27 김경섭 [CHM-201115348] [BKG] T/S 화물 Transit Time 조회/분석 report 신규개발
* 2014.04.07 조인영 [CHM-201429635] NMC ( Non-Manipulation Certificate) Form 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration.TransshipmentMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration.TransshipmentMgtEAIDAO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgRouteForPortAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgTsCoffTmVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgVslDchgYdInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.CntrSumByPodVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SendTsListVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainSumVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemianListVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSSummaryVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSTimeRptVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsBkgListForBayPlanInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsVvdFor1st2ndInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDischargingVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetBkgVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgTsRmkVO;
import com.hanjin.syscommon.common.table.BkgVslDchgYdVO;
import com.hanjin.syscommon.common.table.BkgVslOopVO;
import com.hanjin.syscommon.common.table.BkgVslOpCrrCdVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;

/**
 * alps-TransshipmentMgt Business Logic Basic Command implementation<br>
 * - alps-TransshipmentMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG-0580EventResponse,TransshipmentMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TransshipmentMgtBCImpl extends BasicCommandSupport implements TransshipmentMgtBC {

	// Database Access Object
	private transient TransshipmentMgtDBDAO dbDao = null;
	private transient TransshipmentMgtEAIDAO dbEaiDao = null;

	/**
	 * TransshipmentMgtBCImpl 객체 생성
	 * TransshipmentMgtDBDAO를 생성한다.
	 */
	public TransshipmentMgtBCImpl() {
		dbDao = new TransshipmentMgtDBDAO();
		dbEaiDao = new TransshipmentMgtEAIDAO();
	}
	
	/**
	 * 선복 사용 식별에 사용하는 oop code를 저장한다.<br>
	 * 
	 * @param BkgVslOpCrrCdVO[] bkgVslOpCrrCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOopCode(BkgVslOpCrrCdVO[] bkgVslOpCrrCdVO, SignOnUserAccount account) throws EventException{
		try {
			List<BkgVslOpCrrCdVO> insertVoList = new ArrayList<BkgVslOpCrrCdVO>();
			List<BkgVslOpCrrCdVO> updateVoList = new ArrayList<BkgVslOpCrrCdVO>();
			List<BkgVslOpCrrCdVO> deleteVoList = new ArrayList<BkgVslOpCrrCdVO>();
			for ( int i=0; i<bkgVslOpCrrCdVO .length; i++ ) {
				if ( bkgVslOpCrrCdVO[i].getIbflag().equals("I")){
					bkgVslOpCrrCdVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(bkgVslOpCrrCdVO[i]);
				} else if ( bkgVslOpCrrCdVO[i].getIbflag().equals("U")){
					bkgVslOpCrrCdVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(bkgVslOpCrrCdVO[i]);
				} else if ( bkgVslOpCrrCdVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgVslOpCrrCdVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addBkgVslOpCrrCdS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyBkgVslOpCrrCdS(updateVoList); 
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeBkgVslOpCrrCdS(deleteVoList);
			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
		
	/**
	 * Feeder 선사가 운영하는 선박에 대해 당사 T/S booking 선복 사용에 대해 선박별 이용 선사를 구분 정보를 저장한다.<br>
	 * 
	 * @param BkgVslOopVO[] bkgVslOopVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslOopMatch(BkgVslOopVO[] bkgVslOopVO, SignOnUserAccount account) throws EventException{
		try {
			List<BkgVslOopVO> updateVoList = new ArrayList<BkgVslOopVO>();
			List<BkgVslOopVO> deleteVoList = new ArrayList<BkgVslOopVO>();
			
			for ( int i=0; i<bkgVslOopVO.length; i++ ) {
				if ( bkgVslOopVO[i].getIbflag().equals("U")){
					bkgVslOopVO[i].setCreUsrId(account.getUsr_id()); 
					bkgVslOopVO[i].setUpdUsrId(account.getUsr_id()); 	
					updateVoList.add(bkgVslOopVO[i]);
				} else if ( bkgVslOopVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgVslOopVO[i]);
				}
			}
						
			for(int i=0;i<updateVoList.size();i++){ 
				if (dbDao.modifyBkgVslOop(updateVoList.get(i))==0){
					dbDao.addBkgVslOop(updateVoList.get(i));
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeBkgVslOopS(deleteVoList);
			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}	
	
	/**
	 * bkg_vsl_op_crr_cd를 조회한다<br>
	 * 
	 * @return List<BkgVslOpCrrCdVO>
	 * @exception EventException
	 */
    public List<BkgVslOpCrrCdVO> searchCarrierCode() throws EventException{
    	try {
    		return dbDao.searchOopCode();
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage());
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    
    /**
	 * Feeder 선사가 운영하는 선박에 대해 당사 T/S booking 선복 사용에 대해 선박별 이용 선사를 구분 정보와 선사 구분 code를 조회한다.<br>
	 * 
	 * @param  InputVO inputVO
	 * @return VslOOPVO
	 * @exception EventException
	 */
    public VslOopVO searchVslOopMatch(VslOopInputVO inputVO) throws EventException{
    	try {
    		VslOopVO vslOOPVO = new VslOopVO();
    		vslOOPVO.setVslOopInqVO(dbDao.searchVslOopMatch(inputVO));
    		vslOOPVO.setBkgVslOpCrrCdVO(dbDao.searchOopCode()); 
    		
    		return vslOOPVO;
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	/**
	 * 조회 조건에 맞는 vessel schedule과 지정되어 있는 crn, uvi no를 조회한다.<br>
	 * 
	 * @param  BkgVslDchgYdInputVO bkgVslDchgYdInputVO
	 * @return VslDischargingVO
	 * @exception EventException
	 */
	public VslDischargingVO searchVslDischarging(BkgVslDchgYdInputVO bkgVslDchgYdInputVO) throws EventException {
		try {
			VslDischargingVO vslDischargingVO = new VslDischargingVO();
			vslDischargingVO.setVslDchgYdListVO(dbDao.searchVslDischarging(bkgVslDchgYdInputVO));
			vslDischargingVO.setMdmYardVO(dbDao.searchVslDischargingYard(bkgVslDchgYdInputVO));
			
			return vslDischargingVO;	 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Port 별로 입항하는 VVD의 port와 터미널 코드 및 CRN No, UVI No를 저장한다.<br>
	 * 
	 * @param BkgVslDchgYdVO[] bkgVslDchgYdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslDischarging(BkgVslDchgYdVO[] bkgVslDchgYdVO, SignOnUserAccount account) throws EventException{
		try {
			List<BkgVslDchgYdVO> insertVoList = new ArrayList<BkgVslDchgYdVO>();
			List<BkgVslDchgYdVO> updateVoList = new ArrayList<BkgVslDchgYdVO>();
			List<BkgVslDchgYdVO> deleteVoList = new ArrayList<BkgVslDchgYdVO>();
			for ( int i=0; i<bkgVslDchgYdVO .length; i++ ) {
				if ( bkgVslDchgYdVO[i].getIbflag().equals("I")){
					bkgVslDchgYdVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(bkgVslDchgYdVO[i]);
				} else if ( bkgVslDchgYdVO[i].getIbflag().equals("U")){ 
					bkgVslDchgYdVO[i].setCreUsrId(account.getUsr_id());
					bkgVslDchgYdVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(bkgVslDchgYdVO[i]);
				} else if ( bkgVslDchgYdVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgVslDchgYdVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addVslDchgYdS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				for(int i=0;i<updateVoList.size();i++){
					if (dbDao.modifyVslDchgYd((BkgVslDchgYdVO)updateVoList.get(i))==0){
						dbDao.addVslDchgYd((BkgVslDchgYdVO)updateVoList.get(i));
					}
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeVslDchgYdS(deleteVoList);
			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * t/s port에서 next vessel이 재지정 되지 않고 port에 머물러 있는 booking들을 조회한다.<br>
     * 신규화면이며 long staying을 막기 위해 사용한다.<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemianListVO> 
	 * @exception EventException
	 */
	public List<TSRemianListVO> searchTSRemainList(TSRemainListInputVO tSRemainListInputVO) throws EventException{
		try {
    		return dbDao.searchTSRemainList(tSRemainListInputVO);
    	 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 전달받은 location에 전달받은 날짜를 기준으로 cnmv_sts_cd가 'TS', 'TN'인 container들을<br>
     * type/size, cargo type별로 합계를 내서 조회한다.<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemainSumVO>
	 * @exception EventException
	 */
	public List<TSRemainSumVO> searchTSRemainSumByLoc(TSRemainListInputVO tSRemainListInputVO) throws EventException{
		try {
    		return dbDao.searchTSRemainSumByLoc(tSRemainListInputVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * t/s port를 기준으로 booking들의 입항 vessel과 출항 vessel을 조회한다.<br>
	 * 
	 * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO 
	 * @return List<TSListBy1st2ndVVDListVO>
	 * @exception EventException
	 */
	public List<TSListBy1st2ndVVDListVO> searchTSListBy1st2ndVVDList(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws EventException{
		try {
    		return dbDao.searchTSListBy1st2ndVVDList(tSListBy1st2ndVVDListInputVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	/**
     * vvd를 drop down으로 조회한다.<br>
	 * 
     * @param  TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchTSVvdFor1st2nd (TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO) throws EventException{
    	try {
    		return dbDao.searchTSVvdFor1st2nd(tsVvdFor1st2ndInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * 팩스 보내기 이벤트 처리
     * 
     * @param SendTsListVO sendTsListVO
     * @param SignOnUserAccount account
     * @return List<String>
     * @exception EventException
     */
    public List<String> sendTsListByFax (SendTsListVO sendTsListVO,SignOnUserAccount account)throws EventException{
    	try {
    		 StringBuffer sContent=new StringBuffer();
    		 List<CntrSumByPodVO> list = null;
    		 list=dbDao.searchCntrSumByPod(sendTsListVO);
    		 for(int i=0;i<list.size();i++){
    			 sContent.append(list.get(i).getPodCd()).append("    ").append("40' x ")
    			         .append(list.get(i).getFt40()).append(" ,  20' x ").append(list.get(i).getFt20());
    			 if(i>0){
    				 sContent.append("\n");
    			 }
    		 }    		 
    		 sendTsListVO.setContent(sContent.toString());
    		 return dbEaiDao.sendTsListByFax(sendTsListVO,account);
    	} catch (EAIException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}    		 
    }
    
    
    /**
     * 이메일 보내기 이벤트 처리
     * 
     * @param SendTsListVO sendTsListVO
     * @param String vvd
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String sendTsListByEmail (SendTsListVO sendTsListVO,String vvd,SignOnUserAccount account)throws EventException{
    	try {
    		StringBuffer sContent=new StringBuffer();
    		 List<CntrSumByPodVO> list = null;
    		 String strVsNm=dbDao.searchTsListTitleVvd(vvd);
    		 sendTsListVO.setRdtitle(strVsNm+" T/S Loading List");
    		 list=dbDao.searchCntrSumByPod(sendTsListVO);
    		 for(int i=0;i<list.size();i++){
    			 sContent.append(list.get(i).getPodCd()).append("    ").append("40' x ").append(list.get(i).getFt40())
    			 .append(" .  20' x ").append(list.get(i).getFt20());
    			 if(i>0){
    				 sContent.append("\n");
    			 }
    		 }    		  
    		 sendTsListVO.setContent(sContent.toString());
    		 return dbEaiDao.sendTsListByEmail(sendTsListVO,account);
    	} catch (EAIException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    		 
    }
    
    /**
     * 메일 내용에 들어가는 POD별 컨테이너 VOLUMN 표시<br>
     * 
     * @param  SendTsListVO sendTsListVO
     * @return List<CntrSumByPodVO>
     * @exception EventException
     */
    public List<CntrSumByPodVO> searchCntrSumByPod (SendTsListVO sendTsListVO)throws EventException{
    	try {
    		return dbDao.searchCntrSumByPod(sendTsListVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
        
    /**
     * T/S port에 입항한 1st VVD를 기준으로 연결되는 선명 별로 물량을 조회한다.<br>
	 * 
     * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO
     * @return List<TSSummaryVO>
     * @exception EventException
     */
    public List<TSSummaryVO> searchTSSummary(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws EventException{
    	try {
    		return dbDao.searchTSSummary(tSListBy1st2ndVVDListInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * Relay Vessel Group Assign by Relay Port 화면에서 assing을 위해 list를 조회한다.<br>
     * 
     * @param  RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO
     * @return List<RlyVslGrpAssignVO>
     * @exception EventException
     */
    public List<RlyVslGrpAssignVO>searchRlyVslGrpAssign ( RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO )throws EventException{
    	try {
    		return dbDao.searchRlyVslGrpAssign(rlyVslGrpAssignInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * Next VVD Assign T/S Remark 화면에서 T/S remark를 조회한다.<br>
     * 
     * @param  BkgTsRmkVO bkgTsRmkVO 
     * @return BkgTsRmkVO
     * @exception EventException
     */
    public BkgTsRmkVO searchTSRemark (BkgTsRmkVO bkgTsRmkVO ) throws EventException{
    	try {
    		return dbDao.searchTSRemark(bkgTsRmkVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * t/s port에서 next vessel을 재지정시 입력한 remark를 저장한다.<br>
     * 
     * @param  BkgTsRmkVO bkgTsRmkVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void manageTSRemark (BkgTsRmkVO bkgTsRmkVO, SignOnUserAccount account ) throws EventException{
    	try {
    		 if(bkgTsRmkVO.getTsRmk().trim().length()==0){
    			 dbDao.removeTSRemark(bkgTsRmkVO,account);
    		 } 
    		 if(dbDao.modifyTSRemark(bkgTsRmkVO,account)==0){
    			 dbDao.addTSRemark(bkgTsRmkVO,account);
    		 }
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * VVD Assign을 위해 입항 vvd와 출항 vvd, 대상 Bkg들을 조회한다.<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return List<FormerVvdVO>
     * @exception EventException
     */
    public List<FormerVvdVO>searchFormerVvdForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException{
    	try {
    		return dbDao.searchFormerVvdForAssign(nextVvdAssignInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * vvd assign에서 next vvd를 지정할 대상을 조회한다.<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return VvdAssignTargetListVO
     * @exception EventException
     */
    public VvdAssignTargetListVO searchTargetForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException{
    	try {
    		VvdAssignTargetListVO vvdAssignTargetListVO = new VvdAssignTargetListVO();
    		vvdAssignTargetListVO.setFormerVvdSkdVO(dbDao.searchFormerVvdSkd(nextVvdAssignInputVO));
    		vvdAssignTargetListVO.setVvdAssignTargetBkgVO(dbDao.searchTargerBkgForAssign(nextVvdAssignInputVO));
    		vvdAssignTargetListVO.setVvdAssignTargetVvdVO(dbDao.searchTargetVvdForAssign(nextVvdAssignInputVO));
    		
    		return vvdAssignTargetListVO;
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}    	
    }
    
    /**
     * vvd assign에서 next vvd가 될 수 있는 vvd를 조회한다.<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return List<NextVvdVO>
     * @exception EventException
     */
    public List<NextVvdVO>searchNextVvdForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException{
    	try {
    		return dbDao.searchNextVvdForAssign(nextVvdAssignInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * 조건에 맞는 Booking을 route 별로 group으로 조회한다.<br>
     * 
     * @param String vvd
     * @param String portCd
     * @param String pol
     * @param String pod
     * @param String bkgOfcCd
     * @param String yardCd
     * @return List<BkgRouteForPortAssignVO>
     * @exception EventException
     */
    public List<BkgRouteForPortAssignVO>searchBkgRouteForPortAssign(String vvd,String portCd,String pol, String pod, String bkgOfcCd, String yardCd)throws EventException{
    	try {
     		return dbDao.searchBkgRouteForPortAssign(vvd,portCd,pol,pod,bkgOfcCd,yardCd);
    	} catch (DAOException de) {
     		log.error("err " + de.toString(), de);
 			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
     	} catch (Exception ex) {
     		log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
 		}
    }
    
    /**
	 * route 별로 group으로 조회한 것을 기준으로 상세 Booking들을 조회한다.<br>
     * 
     * @param  BkgListForPortAssignInputVO bkgListForPortAssignInputVO
     * @return List<BkgListForPortAssignVO>
     * @exception EventException
     */
    public List<BkgListForPortAssignVO>searchBkgListForPortAssign(BkgListForPortAssignInputVO bkgListForPortAssignInputVO)throws EventException{
    	try {
     		return dbDao.searchBkgListForPortAssign(bkgListForPortAssignInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * bkg vvd port를 조회한다.<br>
	 * 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return List<BkgVvdVO>
     * @exception EventException
     */
    public List<BkgVvdVO>searchBkgVvdForVvdPortAssign(BkgBlNoVO bkgBlNoVO)throws EventException{
    	try {
     		return dbDao.searchBkgVvdForVvdPortAssign(bkgBlNoVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
	/**
	 * 조회 조건에 맞는 출발 vvd들을 조회한다.<br>
     * 
	 * @param  TSTimeRptVO tSTimeRptVO
	 * @return List<TSTimeRptVO>
	 * @exception EventException
	 */
	public List<TSTimeRptVO> searchPortTurnTimeVVDList(TSTimeRptVO tSTimeRptVO)throws EventException {
		try {
     		return dbDao.searchPortTurnTimeVVDList(tSTimeRptVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Transit Time report in T/S port Summary를 조회한다. - UI-ESM_BKG_0499<br>
	 * 
	 * @param  TSTimeRptVO tSTimeRptVO
	 * @return List<TSTimeRptVO>
	 * @exception EventException
	 */
	public List<TSTimeRptVO> searchTSTimeRptSmry(TSTimeRptVO tSTimeRptVO)throws EventException {
		try {
			return dbDao.searchTSTimeRptSmry(tSTimeRptVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Transit Time report in T/S port Detail을 조회한다. - UI-ESM_BKG_0499<br>
	 * 
	 * @param  TSTimeRptVO tSTimeRptVO
	 * @return List<TSTimeRptVO>
	 * @exception EventException
	 */
	public List<TSTimeRptVO> searchTSTimeRptDtl(TSTimeRptVO tSTimeRptVO)throws EventException {
		try {
			return dbDao.searchTSTimeRptDtl(tSTimeRptVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Booking close / reopen하기 위한 list를 조회한다.<br>
	 *
	 * @param TsBkgListForBayPlanInputVO tsBkgListForBayPlanInputVO
	 * @param String subChk
	 * @return List<BkgTsCoffTmVO>
	 * @exception EventException
	 */
	public List<BkgTsCoffTmVO> searchTsBkgCoffTm(TsBkgListForBayPlanInputVO tsBkgListForBayPlanInputVO, String subChk) throws EventException {
		try {
			return dbDao.searchTsBkgCoffTm(tsBkgListForBayPlanInputVO, subChk);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1157:checkTsCloseByBayPlan<br>
	 * Transshipment Close에 해당되는지 확인<br>
	 * 
	 * @param VvdAssignTargetBkgVO[] vvdAssignTargetBkgVOs
	 * @param String newVvd
	 * @return String
	 * @exception EventException
	 */
	public String checkTsCloseByBayPlan(VvdAssignTargetBkgVO[] vvdAssignTargetBkgVOs, String newVvd) throws EventException{
		String closedVvds = "";
		String closeVvd = "";
		List<String> closeVvdArr = new ArrayList<String>();
		String[] closeVvdStr = null;
		
		Boolean unique = true;
		try {
			for(int i=0; i < vvdAssignTargetBkgVOs.length; i++){
				// 중복은 skip
				if(i>0 && vvdAssignTargetBkgVOs[i].getBkgNo().equals(vvdAssignTargetBkgVOs[i-1].getBkgNo())){
					continue;
				}
				closeVvd = dbDao.checkTsCloseByBayPlan(vvdAssignTargetBkgVOs[i], newVvd);
				if(closeVvd == null || closeVvd.length() < 1) continue;					
				closeVvdStr = (" "+closeVvd+" ").split(",");
				
				for(int j=0; j < closeVvdStr.length; j++){
					closeVvdStr[j] = closeVvdStr[j].trim();
				}
				
				unique = true;
				for(int j=0; j < closeVvdArr.size(); j++){
					if(closeVvdArr.get(j).equals(closeVvdStr[0])){
						unique = false;
					}
				}
				if(unique && closeVvdStr.length > 0 && closeVvdStr[0].length() > 0){
					closeVvdArr.add(closeVvdStr[0]);
				} else {				
					if(closeVvdStr.length > 1 && closeVvdStr[1].length() > 0){
						unique = true;
						for(int j=0; j < closeVvdArr.size(); j++){
							if(closeVvdArr.get(j).equals(closeVvdStr[1])){
								unique = false;
							}
						}
						if(unique && closeVvdStr.length > 0) {
							closeVvdArr.add(closeVvdStr[1]);
						}
					}
				}
			}
			
			for(int i=0; i < closeVvdArr.size(); i++){
				if(i==0){
					closedVvds = closeVvdArr.get(i);
				} else {
					closedVvds = closedVvds + "," + closeVvdArr.get(i);
				}
			}
			return closedVvds;
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_1157:checkTsCloseByBayPlan<br>
	 * Transshipment Close에 해당되는지 확인<br>
	 * 
	 * @param BkgVvdVO[] BkgVvdVOs
	 * @param BkgBlNoVO[] bkgBlNoVOs
	 * @return String
	 * @exception EventException
	 */
	public String checkTsCloseByBayPlanForVvdPortAssign(BkgVvdVO[] bkgVvdVOs,
			BkgBlNoVO[] bkgBlNoVOs) throws EventException{
		String closedVvds = "";
		List<String> closeVvdArr = new ArrayList<String>();		
		try {
			if(bkgVvdVOs == null || bkgVvdVOs.length < 1){
				throw new EventException((String)new ErrorHandler("BKG00833",new String[]{}).getMessage());
			}
			if(bkgBlNoVOs == null || bkgBlNoVOs.length < 1){
				throw new EventException((String)new ErrorHandler("BKG00835",new String[]{}).getMessage());
			}
			closeVvdArr = dbDao.checkTsCloseByBayPlanForVvdPortAssign(bkgVvdVOs, bkgBlNoVOs);
			
			for(int i=0; i < closeVvdArr.size(); i++){
				if(i==0){
					closedVvds = closeVvdArr.get(i);
				} else {
					closedVvds = closedVvds + "," + closeVvdArr.get(i);
				}
			}
			return closedVvds;
		} catch (EventException ex){
			throw ex;
		} catch (DAOException de) {
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
    	} catch (Exception ex) {
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * <br>
	 * ESM_BKG_1174: NMC (Non-Manipulation Certificate)<br>
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @param String cntrNo
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchNmc(String bkgNo, String blNo, String cntrNo) throws EventException {
		

		DBRowSet hdrSet		= null;
		DBRowSet cntrSet	= null;
		
		try {

			hdrSet		= dbDao.searchNmc(bkgNo, blNo, cntrNo);
			cntrSet		= dbDao.searchNmcCntr(bkgNo, blNo, cntrNo);

			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			if(hdrSet.next()){
				eventResponse.setETCData("item_desc", 		hdrSet.getString("ITEM_DESC"));
				eventResponse.setETCData("tp", 		hdrSet.getString("TP"));
				eventResponse.setETCData("qty", 		hdrSet.getString("QTY"));
				eventResponse.setETCData("wgt", 		hdrSet.getString("WGT"));
				eventResponse.setETCData("pol", 		hdrSet.getString("POL"));
				eventResponse.setETCData("inbound", 		hdrSet.getString("INBOUND"));
				eventResponse.setETCData("a_date", 		hdrSet.getString("A_DATE"));
				eventResponse.setETCData("kr_pol", 		hdrSet.getString("KR_POL"));
				eventResponse.setETCData("outbound", 		hdrSet.getString("OUTBOUND"));
				eventResponse.setETCData("d_date", 		hdrSet.getString("D_DATE"));
				eventResponse.setETCData("del", 		hdrSet.getString("DEL"));
				eventResponse.setETCData("bl_no", 		hdrSet.getString("BL_NO"));
				eventResponse.setETCData("cntr_no", 		hdrSet.getString("CNTR_NO"));
				eventResponse.setETCData("today", 		hdrSet.getString("TODAY"));
			}
			eventResponse.setRsVo(cntrSet);
			return eventResponse;			
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());									
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
}