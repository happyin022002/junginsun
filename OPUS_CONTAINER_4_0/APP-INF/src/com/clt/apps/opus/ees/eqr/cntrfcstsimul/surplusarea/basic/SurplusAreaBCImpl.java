/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurplusAreaBCImpl.java
*@FileTitle : Inventory Simulation - Surplus Area 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration.SurplusAreaDBDAO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.PortSurplusAreaConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-MTYWeeklySimulation Business Logic Basic Command implementation<br>
 * - OPUS-MTYWeeklySimulation 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_CIM_1003EventResponse,MTYWeeklySimulationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SurplusAreaBCImpl extends BasicCommandSupport implements SurplusAreaBC {

	// Database Access Object
	private transient SurplusAreaDBDAO dbDao = null;

	/**
	 * MTYEquipmentForecastBCImpl 객체 생성<br>
	 * MTYEquipmentForecastDBDAO를 생성한다.<br>
	 */
	public SurplusAreaBCImpl() {
		dbDao = new SurplusAreaDBDAO();
	}
	
	/**
	 *  Surplus Area 의 시트 헤더 타이틀 조회<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @return String
	 * @throws EventException
	 */
	 public String searchSurplusAreaTitleBasic(SurplusAreaConditionVO surplusAreaConditionVO) throws EventException {
		try {
			return dbDao.searchSurplusAreaTitleData(surplusAreaConditionVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Surplus Area Retrieve"}).getMessage(),ex);
		}
	}		

	/**
	 *  Surplus Area - History 시트를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	 public CommonRsVO searchSurplusAreaBasic(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws EventException {
		try {
			return dbDao.searchSurplusAreaData(surplusAreaConditionVO, rptTtl);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Surplus Area Retrieve"}).getMessage(),ex);
		}
	}	 

	 /**
	 *  현재시각 기준으로 기본 주차 ( 과거 3주 ~ 미래 3주 , 총 7주차 )가져오기<br>
	 * 
	 * @return String
	 * @throws EventException
	 */
	 public String searchCurrSevenWeeksBasic() throws EventException {
		try {
			return dbDao.searchCurrSevenWeeksData();
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Surplus Area Retrieve"}).getMessage(),ex);
		}
	}			 

	/**
	 * 로그인 의 수정 권한 조회<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String checkYardSurplusAreaAuthBasic(SignOnUserAccount account) throws EventException{
		try {
			return dbDao.checkYardSurplusAreaAuthData(account.getOfc_cd());
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		 

	 /**
	 * LOC Code 유효성 조회 (RCC_CD 반환)<br>
	 * 
	 * @param String loc_grp_cd
	 * @param String loc_cd
	 * @return String
	 * @exception EventException
	 */	
	public String checkRccCodeIs(String loc_grp_cd, String loc_cd) throws EventException{
		try {
			return dbDao.checkRccCodeIs(loc_grp_cd,  loc_cd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	/**
	 *  Surplus Area - Yard 시트를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	 public CommonRsVO searchYardSurplusAreaBasic(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws EventException {
		try {
			return dbDao.searchYardSurplusAreaData(surplusAreaConditionVO, rptTtl);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Surplus Area Retrieve"}).getMessage(),ex);
		}
	}	 

	/**
	 * Surplus Area - Yard 의 manual 데이터를 입력/수정/삭제<br>
	 * 
	 * @param SurplusAreaVO[] surplusAreaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	 public void manageYardSurplusAreaBasic(SurplusAreaVO[] surplusAreaVOs, SignOnUserAccount account) throws EventException{
		 try { 
			 List<SurplusAreaVO> updateVoList = new ArrayList<SurplusAreaVO>();
			 
			 List<SurplusAreaVO> updateQtyVoList = new ArrayList<SurplusAreaVO>();
//			 List<SurplusAreaVO> deleteQtyVoList = new ArrayList<SurplusAreaVO>();

			 String pre_fcast_yrwk = "";
			 String pre_yd_cd = "";
			 String pre_invt_sim_tp_cd = "";
			 String pre_cfm_flg = "";
			for ( int i=0; i<surplusAreaVOs.length; i++ ) {

//				if(surplusAreaVOs[i].getCntrQty().equals("D")){
//					// 삭제는 EQR_CTRL_INVT_SIM_QTY 테이블 만
//					deleteQtyVoList.add(surplusAreaVOs[i]);
//				}else{
				if(!surplusAreaVOs[i].getCntrQty().equals("D")){
					surplusAreaVOs[i].setCreUsrId(account.getUsr_id());
					surplusAreaVOs[i].setUpdUsrId(account.getUsr_id());
					
					if(!pre_fcast_yrwk.equals(surplusAreaVOs[i].getFcastYrwk())
						|| !pre_yd_cd.equals(surplusAreaVOs[i].getYdCd())
						|| !pre_invt_sim_tp_cd.equals(surplusAreaVOs[i].getInvtSimTpCd())
						|| !pre_cfm_flg.equals(surplusAreaVOs[i].getCfmFlg()) ){ 
						
						// 바로 전에 넣은 것과 다르면 EQR_CTRL_INVT_SIM Merge 문 실행
						// sheet 에서 sort 되어서 넘어옴
						updateVoList.add(surplusAreaVOs[i]);
						
						pre_fcast_yrwk     = surplusAreaVOs[i].getFcastYrwk();
						pre_yd_cd          = surplusAreaVOs[i].getYdCd();
						pre_invt_sim_tp_cd = surplusAreaVOs[i].getInvtSimTpCd();
						pre_cfm_flg        = surplusAreaVOs[i].getCfmFlg();
					}
					
					// EQR_CTRL_INVT_SIM_QTY Merge 문 실행
					updateQtyVoList.add(surplusAreaVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyYardSurplusAreaData(updateVoList);
				dbDao.modifyYardSurplusAreaQtyData(updateQtyVoList);
			}
//			if ( deleteQtyVoList.size() > 0 ) { 
//				dbDao.deleteYardSurplusAreaQtyData(deleteQtyVoList); // DAO 에 미생성
//			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MT Inventory Simulation by Yard Save"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MT Inventory Simulation by Yard Save"}).getMessage(),ex);
		}
	 }	 
	 
	/**
	 * Surplus Area - Yard 의 BKG for OP Ref 팝업 데이터를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	 public CommonRsVO searchBkgSurplusAreaBasic(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws EventException {
		try {
			return dbDao.searchBkgSurplusAreaData(surplusAreaConditionVO, rptTtl);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"BKG for OP Ref. Retrieve"}).getMessage(),ex);
		}
	}		 

	/**
	 * 로그인 의 수정 권한 조회<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String checkPortSurplusAreaAuthBasic(SignOnUserAccount account) throws EventException{
		try {
			return dbDao.checkPortSurplusAreaAuthData(account.getOfc_cd());
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}			 
	 
	/**
	 *  Surplus Area - Port 시트를 조회한다.<br>
	 * 
	 * @param PortSurplusAreaConditionVO portSurplusAreaConditionVO
	 * @param String rptTtl
	 * @return List<CommonRsVO>
	 * @throws EventException
	 */
	 public List<CommonRsVO> searchPortSurplusAreaBasic(PortSurplusAreaConditionVO portSurplusAreaConditionVO, String rptTtl) throws EventException {
		try {
			return dbDao.searchPortSurplusAreaData(portSurplusAreaConditionVO, rptTtl);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Surplus Area Retrieve"}).getMessage(),ex);
		}
	}	 

	/**
	 * Surplus Area - Port 의 manual 데이터를 입력/수정/삭제<br>
	 * 
	 * @param SurplusAreaVO[] surplusAreaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	 public void managePortSurplusAreaBasic(SurplusAreaVO[] surplusAreaVOs, SignOnUserAccount account) throws EventException{
		 try { 
			 List<SurplusAreaVO> updateVoList = new ArrayList<SurplusAreaVO>();
			 
			 List<SurplusAreaVO> updateQtyVoList = new ArrayList<SurplusAreaVO>();
//				 List<SurplusAreaVO> deleteQtyVoList = new ArrayList<SurplusAreaVO>();

			 String pre_fcast_yrwk = "";
			 String pre_port_cd = "";
			 String pre_invt_sim_tp_cd = "";
			 String pre_cfm_flg = "";
			for ( int i=0; i<surplusAreaVOs.length; i++ ) {

//				if(surplusAreaVOs[i].getCntrQty().equals("D")){
//					// 삭제는 EQR_CTRL_INVT_SIM_QTY 테이블 만
//						deleteQtyVoList.add(surplusAreaVOs[i]);
//				}else{
				if(!surplusAreaVOs[i].getCntrQty().equals("D")){
					surplusAreaVOs[i].setCreUsrId(account.getUsr_id());
					surplusAreaVOs[i].setUpdUsrId(account.getUsr_id());
					
					if(!surplusAreaVOs[i].getFcastYrwk().equals(pre_fcast_yrwk)
						|| !surplusAreaVOs[i].getPortCd().equals(pre_port_cd)
						|| !surplusAreaVOs[i].getInvtSimTpCd().equals(pre_invt_sim_tp_cd)
						|| !surplusAreaVOs[i].getCfmFlg().equals(pre_cfm_flg) ){ 
						
						// 바로 전에 넣은 것과 키가 다르면 EQR_CTRL_INVT_SIM Merge 문 실행
						// (js 에서 sort 되어서 넘어옴)
						updateVoList.add(surplusAreaVOs[i]);
						
						pre_fcast_yrwk     = surplusAreaVOs[i].getFcastYrwk();
						pre_port_cd        = surplusAreaVOs[i].getPortCd();
						pre_invt_sim_tp_cd = surplusAreaVOs[i].getInvtSimTpCd();
						pre_cfm_flg        = surplusAreaVOs[i].getCfmFlg();
					}
					
					// EQR_CTRL_INVT_SIM_QTY Merge 문 실행
					updateQtyVoList.add(surplusAreaVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyPortSurplusAreaData(updateVoList);
				dbDao.modifyPortSurplusAreaQtyData(updateQtyVoList);
			}
//				if ( deleteQtyVoList.size() > 0 ) { 
//					dbDao.deleteYardSurplusAreaQtyData(deleteQtyVoList); // DAO 에 미생성
//				}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MT Inventory Simulation by Port Save"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MT Inventory Simulation by Port Save"}).getMessage(),ex);
		}
	 }	
	 
	/**
	 * Sub-Conti 콤보 리스트 조회<br>
	 * @param portSurplusAreaConditionVO
	 * @return CommonRsVO
	 * @throws EventException
	 */	
	public CommonRsVO searchSubcontiListBasic(PortSurplusAreaConditionVO portSurplusAreaConditionVO) throws EventException{
		try {
			return dbDao.searchSubcontiListData(portSurplusAreaConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * (Port & Yard Simulation용) User의 Office level을 체크
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	 public String searchOfcLvl(String ofcCd) throws EventException {
		 try {
			 return dbDao.searchOfcLvl(ofcCd);
		 } catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(ex.getMessage(),ex);
		 }
	 }
}