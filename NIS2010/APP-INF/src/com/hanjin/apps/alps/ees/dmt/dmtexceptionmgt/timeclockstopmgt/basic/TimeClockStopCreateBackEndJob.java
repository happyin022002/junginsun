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
* 2010.11.25 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTDualChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration.TimeClockStopMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockChargeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockStopParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.YardByOfficeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - APLS-DMTExceptionMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Sung Hwan
 * @see UI_DMT_2010EventResponse,TimeClockStopMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TimeClockStopCreateBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = 9016372863642005395L;
	
	private SignOnUserAccount account;
	private DmtTimeClockStopVO dmtTimeClockStopVO; 

	// Database Access Object
	private TimeClockStopMgtDBDAO dbDao = null;
    
	public TimeClockStopCreateBackEndJob() {
		dbDao = new TimeClockStopMgtDBDAO();
	}
	
	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 */
	public void setTimeClockStopVO(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) {
		this.account = account;
		this.dmtTimeClockStopVO = dmtTimeClockStopVO;
	}

	/**
	 * BackEndJob Start
	 * @return DmtTimeClockStopVO
	 * @throws Exception
	 */
	public DmtTimeClockStopVO doStart() throws Exception {
		DmtTimeClockStopVO dmtTimeClockStop = new DmtTimeClockStopVO();
		try {
			dmtTimeClockStop = createTimeClockStop(this.dmtTimeClockStopVO, this.account);
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
	    }
		return dmtTimeClockStop;
	}

	/**
	 * DATA 조회를 위한 BackEndJob 호출<br>
	 * 
	 * @param DmtTimeClockStopVO dmtTimeClockStopVO
	 * @param SignOnUserAccount account
	 * @return DmtTimeClockStopVO
	 * @throws Exception
	 */
	private DmtTimeClockStopVO createTimeClockStop(DmtTimeClockStopVO dmtTimeClockStopVO, SignOnUserAccount account) throws Exception {
		DmtTimeClockStopVO dmtTimeClockStop = new DmtTimeClockStopVO();
		
		StringBuffer yard_codes = new StringBuffer();
		//StringBuffer yard_names = new StringBuffer();
		List<YardByOfficeVO> yardByOfficeVOs = null;
		
		try {			
			dmtTimeClockStopVO.setCreUsrId(account.getUsr_id());
			dmtTimeClockStopVO.setCreOfcCd(account.getOfc_cd());
			dmtTimeClockStopVO.setUpdUsrId(account.getUsr_id());
			dmtTimeClockStopVO.setUpdOfcCd(account.getOfc_cd());			
			dmtTimeClockStopVO.setClkStopOfcCd(dmtTimeClockStopVO.getClkStopOfcCd().substring(0, 5));		
			dmtTimeClockStopVO.setClkStopFmDt(dmtTimeClockStopVO.getClkStopFmDt().replaceAll("-", ""));
			dmtTimeClockStopVO.setClkStopToDt(dmtTimeClockStopVO.getClkStopToDt().replaceAll("-", ""));
			//1. 저장시 해당조건의 값이 있는지 확인 없다면 처리
			String exist = StringUtils.defaultString(dbDao.searchDmtTimeClockStopExist(dmtTimeClockStopVO));
			
//			log.debug("[exist]"+exist);
			
			if(exist == null || exist.equals("")){
				//1.1. 저장시 해당조건의 값이 있는지 확인 후 저장
				String no_exist = dbDao.searchDmtTimeClockStopNoExist(dmtTimeClockStopVO);
				if(no_exist == null || no_exist.equals("")){					
					String clk_stop_pk = dbDao.searchTimeClockStopPK(dmtTimeClockStopVO);
					dmtTimeClockStopVO.setClkStopNo(clk_stop_pk);
					dbDao.addDmtTimeClockStopNo(dmtTimeClockStopVO);
					dbDao.addDmtTimeClockStop(dmtTimeClockStopVO);
					
					if("Y".equals(dmtTimeClockStopVO.getAllYdFlg())){
						//yard 데이터 생성 하지 않는다.
						//저장  완료 후 저장한 내용 조회 
						dmtTimeClockStop = dbDao.searchNewTimeClockStop(dmtTimeClockStopVO);
						
						TimeClockStopParmVO timeClockStopParmVO = new TimeClockStopParmVO();
						timeClockStopParmVO.setClkStopOfcCd(dmtTimeClockStopVO.getClkStopOfcCd());
						
						//Time Clock Stop Yard 정보 조회
						yardByOfficeVOs = dbDao.searchDMTYardByOffice(timeClockStopParmVO);
					}else{
						//2010.11.23. YARD 추가
						String ydCdList = (String)dmtTimeClockStopVO.getClkStopYdCd();
						
						//log.debug("[ydCdList]==>"+ydCdList);
						
						StringTokenizer st = new StringTokenizer(ydCdList, ",");
						String tempS = "";
						DmtTimeClockStopVO dmtTimeClockStopYardVO = dmtTimeClockStopVO;//Yard VO
						
						while (st.hasMoreTokens()) {
					    	tempS = st.nextToken(); 
					    	//log.debug("[tempS]==>"+tempS);
					    	dmtTimeClockStopYardVO.setClkStopYdCd(tempS);
					    	
					    	dbDao.addDmtTimeClockStopYard(dmtTimeClockStopYardVO);
					    }
						//2010.04.08 배치적용으로 주석처리 - 타임클락 저장후에 계산 처리 프로세스 
						//modifyCharge(clk_stop_pk, account);
						//저장  완료 후 저장한 내용 조회 
						dmtTimeClockStop = dbDao.searchNewTimeClockStop(dmtTimeClockStopVO);
						
						//Time Clock Stop Yard 정보 조회
						yardByOfficeVOs = dbDao.searchDmtTimeClockStopYard(dmtTimeClockStopVO);
					}
					int tot_cnt = yardByOfficeVOs.size();
					for(int i = 0 ; i < yardByOfficeVOs.size() ; i++) {
						if(i == tot_cnt-1) {
							yard_codes.append(yardByOfficeVOs.get(i).getYdCd());
						}else{
							yard_codes.append(yardByOfficeVOs.get(i).getYdCd()).append(",");
						}
						//yard_codes.append(yardByOfficeVOs.get(i).getYdCd()).append(",");
						//yard_names.append(yardByOfficeVOs.get(i).getYdNm()).append(",");
					}
					dmtTimeClockStop.setClkStopYdCd(yard_codes.toString());
					dmtTimeClockStop.setClkStopYdNm(yard_codes.toString());
					
					dmtTimeClockStop.setAuthYn(searchAuthExist(dmtTimeClockStop.getClkStopOfcCd()));
					
				} else {	
					//2. 저장시 해당조건의 값이 있는지 확인 후 값이 있다면 처리 
					int seq = dbDao.searchDmtTimeClockStopNoSeq(dmtTimeClockStopVO);
					dmtTimeClockStopVO.setSeq(String.valueOf(seq));
					String clk_stop_seq_pk = dbDao.searchTimeClockStopSeqPK(dmtTimeClockStopVO);
					dmtTimeClockStopVO.setClkStopNo(clk_stop_seq_pk);
					//2.1. 해당 조건의 대한 최대값을 구한 후  저장
					dbDao.addDmtTimeClockStopNoSeq(dmtTimeClockStopVO);
					dbDao.addDmtTimeClockStopSeq(dmtTimeClockStopVO);
					
					if("Y".equals(dmtTimeClockStopVO.getAllYdFlg())){
						//yard 데이터 생성 하지 않는다.
						//저장  완료 후 저장한 내용 조회 
						dmtTimeClockStop = dbDao.searchNewTimeClockStop(dmtTimeClockStopVO);
						
						TimeClockStopParmVO timeClockStopParmVO = new TimeClockStopParmVO();
						timeClockStopParmVO.setClkStopOfcCd(dmtTimeClockStopVO.getClkStopOfcCd());
						//Time Clock Stop Yard 정보 조회
						yardByOfficeVOs = dbDao.searchDMTYardByOffice(timeClockStopParmVO);
					}else{
						//2010.11.23. YARD 추가
						String ydCdList = (String)dmtTimeClockStopVO.getClkStopYdCd();
						
						StringTokenizer st = new StringTokenizer(ydCdList, ",");
						String tempS = "";
						DmtTimeClockStopVO dmtTimeClockStopYardVO = dmtTimeClockStopVO;//Yard VO
						
						while (st.hasMoreTokens()) {
					    	tempS = st.nextToken(); 
					    	dmtTimeClockStopYardVO.setClkStopYdCd(tempS);
					    	
					    	dbDao.addDmtTimeClockStopYardSeq(dmtTimeClockStopYardVO);
					    }
						//2010.04.08 배치적용으로 주석처리 - 타임클락 저장후에 계산 처리 프로세스 
						//modifyCharge(clk_stop_pk, account);
						//저장  완료 후 저장한 내용 조회 
						dmtTimeClockStop = dbDao.searchNewTimeClockStop(dmtTimeClockStopVO);
						
						//Time Clock Stop Yard 정보 조회
						yardByOfficeVOs = dbDao.searchDmtTimeClockStopYard(dmtTimeClockStopVO);
					}					
					
					int tot_cnt = yardByOfficeVOs.size();
					for(int i = 0 ; i < yardByOfficeVOs.size() ; i++) {
						if(i == tot_cnt-1) {
							yard_codes.append(yardByOfficeVOs.get(i).getYdCd());
						}else{
							yard_codes.append(yardByOfficeVOs.get(i).getYdCd()).append(",");
						}
						//yard_codes.append(yardByOfficeVOs.get(i).getYdCd()).append(",");
						//yard_names.append(yardByOfficeVOs.get(i).getYdNm()).append(",");
					}
					dmtTimeClockStop.setClkStopYdCd(yard_codes.toString());
					dmtTimeClockStop.setClkStopYdNm(yard_codes.toString());
					
					dmtTimeClockStop.setAuthYn(searchAuthExist(dmtTimeClockStop.getClkStopOfcCd()));
				}
				
				
			} else {
				//data 존재시
				dmtTimeClockStop.setDupYn("Y");
			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
		}
		return dmtTimeClockStop;
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
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00006", new String[] {}).getMessage());
		}
	}
	
}