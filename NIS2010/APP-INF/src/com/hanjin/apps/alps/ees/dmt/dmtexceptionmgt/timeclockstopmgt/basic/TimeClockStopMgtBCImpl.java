/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtBCImpl.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
* 2010.10.04 김태균 [CHM-201006288-01] [EES-DMT] Session 정보 관련 수정
* 2010.11.25 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration.TimeClockStopMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockStopParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.YardByOfficeVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - APLS-DMTExceptionMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Sung Hwan
 * @see UI_DMT_2010EventResponse,TimeClockStopMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TimeClockStopMgtBCImpl extends BasicCommandSupport implements TimeClockStopMgtBC {

	// Database Access Object
	private transient TimeClockStopMgtDBDAO dbDao = null;
	/**
	 * TimeClockStopMgtBCImpl 객체 생성<br>
	 * TimeClockStopMgtDBDAO를 생성한다.<br>
	 */
	public TimeClockStopMgtBCImpl() {
		dbDao = new TimeClockStopMgtDBDAO();
	}
	/**
	 * Clock Stop no의 대한 해당 데이터를 조회한다.
	 * 2010.11.24. Clock Stop Yard 항목 추가
	 * @param TimeClockStopParmVO timeClockStopParmVO
	 * @return List<DmtTimeClockStopVO>
	 * @exception EventException
	 */
	public List<DmtTimeClockStopVO> searchTimeClockStop(TimeClockStopParmVO  timeClockStopParmVO ) throws EventException {
		List<DmtTimeClockStopVO> dmtTimeClockStopVOs = null;
		List<YardByOfficeVO> yardByOfficeVOs = null;
		StringBuffer yard_codes = new StringBuffer();
		StringBuffer yard_names = new StringBuffer();
		DmtTimeClockStopVO dmtTimeClockStop = new DmtTimeClockStopVO();

		try {
			String all_yd_flg = "";
			String clk_stop_ofc_cd = "";
			
			dmtTimeClockStopVOs = dbDao.searchTimeClockStop(timeClockStopParmVO);
			if(dmtTimeClockStopVOs != null && dmtTimeClockStopVOs.size() > 0) {
				dmtTimeClockStop = (DmtTimeClockStopVO)dmtTimeClockStopVOs.get(0);

				all_yd_flg 		= dmtTimeClockStop.getAllYdFlg();
				clk_stop_ofc_cd = dmtTimeClockStop.getClkStopOfcCd();
				timeClockStopParmVO.setClkStopOfcCd(clk_stop_ofc_cd);

				//Time Clock Stop Yard 정보 조회
				if(all_yd_flg.equals("Y")){
					yardByOfficeVOs = dbDao.searchDMTYardByOffice(timeClockStopParmVO);
				}else{
					yardByOfficeVOs = dbDao.searchDmtTimeClockStopYard(dmtTimeClockStop);
				}
				int tot_cnt = yardByOfficeVOs.size();
				for(int i = 0 ; i < yardByOfficeVOs.size() ; i++) {
					if(i == tot_cnt-1) {
						yard_codes.append(yardByOfficeVOs.get(i).getYdCd());
						yard_names.append(yardByOfficeVOs.get(i).getYdNm());
					}else{
						yard_codes.append(yardByOfficeVOs.get(i).getYdCd()).append(",");
						yard_names.append(yardByOfficeVOs.get(i).getYdNm()).append(",");
					}
				}
				
				log.debug("[yard_codes]"+yard_codes.toString());
				log.debug("[yard_names]"+yard_names.toString());
				
				for(int i = 0 ; i < dmtTimeClockStopVOs.size() ; i++) {
					DmtTimeClockStopVO tempVO = (DmtTimeClockStopVO)dmtTimeClockStopVOs.get(0);
					tempVO.setClkStopYdCd(yard_codes.toString());
					tempVO.setClkStopYdNm(yard_names.toString());
					dmtTimeClockStopVOs.set(i, tempVO);
				}
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return dmtTimeClockStopVOs;
	}

	/**
	 * Clock Stop no의 대한 List 데이터를 조회한다.
	 * 
	 * @param TimeClockStopParmVO timeClockStopParmVO
	 * @return List<DmtTimeClockStopVO>
	 * @exception EventException
	 */
	public List<DmtTimeClockStopVO> searchTimeClockStopList(TimeClockStopParmVO timeClockStopParmVO) throws EventException {
		try {
			timeClockStopParmVO.setFmDt(timeClockStopParmVO.getFmDt().replaceAll("-", ""));
			timeClockStopParmVO.setToDt(timeClockStopParmVO.getToDt().replaceAll("-", ""));
			return dbDao.searchTimeClockStopList(timeClockStopParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 사용자의 권한을 체크한다.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthExist(String ofcCd) throws EventException {
		try {
			return dbDao.searchAuthExist(ofcCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
	}
	
    /////////////////////////////////////////////////////////////////////////////////////
	////////// START BACK END JOB AREA //////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * EES_DMT_2010 : BackEnd Job를 시작한다.<br>
	 *
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String doBackEndJob(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) {
		TimeClockStopCreateBackEndJob backEndResult = new TimeClockStopCreateBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setTimeClockStopVO(dmtTimeClockStopVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_DMT_2010 Create Back End");
	}
	
	/**
	 * BACKENDJOB 공통. 상태를 리턴 합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJb(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			log.error("[BackEndJobException]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
		} catch (SQLException e) {
			log.error("[SQLException]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
		} catch (InterruptedException e) {
			log.error("[InterruptedException]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
		} catch(Exception e){
			log.error("[Exception]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{""}).getUserMessage(),e);
		}

	}
	
	/**
	 * EES_DMT_2010 : BackEndJob의 결과를 리턴<br>
	 *
	 * @param String key
	 * @return DmtTimeClockStopVO
	 * @throws EventException
	 * @exception EventException
	 */
	public DmtTimeClockStopVO createTimeClockStopBackEndJob(String key) throws EventException {
		DmtTimeClockStopVO dmtTimeClockStopVO = new DmtTimeClockStopVO();
		try {
			dmtTimeClockStopVO = (DmtTimeClockStopVO)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ea) {
			log.error("[BackEndJobException]"+ea.getMessage());
			throw new EventException(ea.getMessage());
		} catch (Exception er){
			log.error("[Exception]"+er.getMessage());
			throw new EventException(er.getMessage());
		}

		return dmtTimeClockStopVO;
	}
	
	/**
	 * EES_DMT_2010 : BackEnd Job를 시작한다.<br>
	 *
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String doCancelBackEndJob(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) {
		TimeClockStopCancelBackEndJob backEndResult = new TimeClockStopCancelBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setTimeClockStopVO(dmtTimeClockStopVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_DMT_2010 Cancel Back End");
	}
	
	/**
	 * BACKENDJOB 공통. 상태를 리턴 합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comCancelBakEndJb(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			log.error("[BackEndJobException]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
		} catch (SQLException e) {
			log.error("[SQLException]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
		} catch (InterruptedException e) {
			log.error("[InterruptedException]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
		} catch(Exception e){
			log.error("[Exception]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{""}).getUserMessage(),e);
		}

	}	
	
	/**
	 * EES_DMT_2010 : BackEndJob의 결과를 리턴<br>
	 *
	 * @param String key
	 * @return DmtTimeClockStopVO
	 * @throws EventException
	 * @exception EventException
	 */
	public DmtTimeClockStopVO cancelTimeClockStopBackEndJob(String key) throws EventException {
		DmtTimeClockStopVO dmtTimeClockStopVO = new DmtTimeClockStopVO();
		try {
			dmtTimeClockStopVO = (DmtTimeClockStopVO)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ea) {
			log.error("[BackEndJobException]"+ea.getMessage());
			throw new EventException(ea.getMessage());
		} catch (Exception er){
			log.error("[Exception]"+er.getMessage());
			throw new EventException(er.getMessage());
		}

		return dmtTimeClockStopVO;
	}	
	
	/**
	 * Office에 대한 Yard Code를 조회한다.<br>
	 * 
	 * @param TimeClockStopParmVO timeClockStopParamVO
	 * @return List<YardByOfficeVO>
	 * @exception EventException
	 */
	public List<YardByOfficeVO> searchDMTYardByOffice(TimeClockStopParmVO timeClockStopParamVO ) throws EventException {
		try {
			return dbDao.searchDMTYardByOffice(timeClockStopParamVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
}