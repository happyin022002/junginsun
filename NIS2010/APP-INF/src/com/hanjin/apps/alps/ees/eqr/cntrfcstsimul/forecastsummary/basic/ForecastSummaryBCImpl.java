/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ForecastSummaryBCImpl.java
*@FileTitle : Forecast Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2015-12-14
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration.ForecastSummaryDBDAO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQBalanceSheetListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryINVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hyung Choon_Roh
 * @see COM_ENS_0O1EventResponse,ForecastSummaryBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ForecastSummaryBCImpl   extends BasicCommandSupport implements ForecastSummaryBC {

	// Database Access Object
	private transient ForecastSummaryDBDAO dbDao=null;

	/**
	 * ForecastSummaryBCImpl 객체 생성<br>
	 * ForecastSummaryDBDAO를 생성한다.<br>
	 */
	public ForecastSummaryBCImpl(){
		dbDao = new ForecastSummaryDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * EQ Balance Sheet Set-up 화면에 대한 조회 이벤트 처리<br>
	 * @param eQForecastSummaryINVO
	 * @return List<EQBalanceSheetListVO>
	 * @exception EventException
	 */
	public List<EQBalanceSheetListVO> searchEQBalanceSheetList(EQForecastSummaryINVO eQForecastSummaryINVO) throws EventException {
		List<EQBalanceSheetListVO> list = null;
        try {
        	list   = dbDao.searchEQBalanceSheetList(eQForecastSummaryINVO);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return list;
	}
	
	/**
	 * 입력, 수정이벤트 처리<br>
	 * EQ Forecast Summary Filter Save<br>
	 * @param eQBalanceSheetListVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageEQForecastSummaryFilter(EQBalanceSheetListVO[] eQBalanceSheetListVOs, SignOnUserAccount account) throws EventException{
		 try { 
			List<EQBalanceSheetListVO> filterVoList = new ArrayList<EQBalanceSheetListVO>();

			int cnt = 0;
			for ( int i=0; i<eQBalanceSheetListVOs.length; i++ ) {
				eQBalanceSheetListVOs[i].setCreUsrId(account.getUsr_id());
				
				if("I".equals(eQBalanceSheetListVOs[i].getIbflag())){
					cnt = dbDao.checkEQForecastSummaryFilter(eQBalanceSheetListVOs[i]);
					if(cnt > 0){
						throw new EventException(new ErrorHandler("COM12226",  new String[]{" RCC : " + eQBalanceSheetListVOs[i].getRccCd() + ", Location : " + eQBalanceSheetListVOs[i].getLocCd() + "("+eQBalanceSheetListVOs[i].getLocGrpCd()+")" }).getMessage());
					}
				}
				
				dbDao.manageEQForecastSummaryFilter(eQBalanceSheetListVOs[i]);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * EES_EQR_1101 : [이벤트]<br>
	 * RCC_CD, LOC_GRP_CD에 따른 LOCATION코드 조회 <br>
	 * GRID COMBO에 사용
	 * @param eQForecastSummaryINVO
	 * @return count
	 * @exception EventException
	 */
	public int checkLocationByGroupCode(EQForecastSummaryINVO eQForecastSummaryINVO) throws EventException {
		int count = 0;
        try {
        	count = dbDao.checkLocationByGroupCode(eQForecastSummaryINVO);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return count;
	}


	
	/**
	 * 조회 이벤트 처리<br>
	 * EQ Forecast Summary 화면에 대한 조회 이벤트 처리<br>
	 * @param eQForecastSummaryINVO
	 * @return List<EQForecastSummaryListVO>
	 * @exception EventException
	 */
	public List<EQForecastSummaryListVO> searchEQForecastSummaryList(EQForecastSummaryINVO eQForecastSummaryINVO) throws EventException {
		List<EQForecastSummaryListVO> list = null;
		int cnt = 0;
        try {
        	list   = dbDao.searchEQForecastSummaryList(eQForecastSummaryINVO);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return list;
	}
	
	/**
	 * EQC Organization Chart 화면에 대한 저장 이벤트 처리<br>
	 * @param EQCOrgChartListVO[] eQCOrgChartListVOs
	 * @param SignOnUserAccount account
	 * @return int[]
	 * @exception EventException
	 */
	/*
	public int[] multiEqrCtrlFcastLocBasic(EQCOrgChartListVO[] eQCOrgChartListVOs, SignOnUserAccount account) throws EventException {
		int[] result = null;
        String usrId = account.getUsr_id();
        try {
        	List<EQCOrgChartListVO> insertVoList = new ArrayList<EQCOrgChartListVO>();		
			
			for ( int i=0; i<eQCOrgChartListVOs.length; i++ ) {
				if ( eQCOrgChartListVOs[i].getChk().equals("1")){
					eQCOrgChartListVOs[i].setCreUsrId(account.getUsr_id());					
					insertVoList.add(eQCOrgChartListVOs[i]);
				}
			}
			
			dbDao.removeEqrCtrlFcastLocData(usrId);
			if ( insertVoList.size() > 0 ) {
				result = dbDao.addEqrCtrlFcastLocData(insertVoList);
			}
        	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return result;
	}
	*/
	
	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * EQOrgChart업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}