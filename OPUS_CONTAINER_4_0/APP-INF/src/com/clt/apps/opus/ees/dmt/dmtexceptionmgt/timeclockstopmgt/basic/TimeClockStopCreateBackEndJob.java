/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeClockStopMgtBCImpl.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic;

import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTDualChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration.TimeClockStopMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.DmtTimeClockStopVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockChargeListVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.TimeClockStopParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo.YardByOfficeVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * APLS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 *
 * @author
 * @see reference DAO class of UI_DMT_2010EventResponse,TimeClockStopMgtBC
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
	 * data setting 
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
	 * Call BackEndJob for serarching <br>
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
			//1. when save, if there is no data , then run continue.
			String exist = StringUtils.defaultString(dbDao.searchDmtTimeClockStopExist(dmtTimeClockStopVO));
			
//			log.debug("[exist]"+exist);
			
			if(exist == null || exist.equals("")){
				//1.1. in saving, if there is no data , then save.
				String no_exist = dbDao.searchDmtTimeClockStopNoExist(dmtTimeClockStopVO);
				if(no_exist == null || no_exist.equals("")){					
					String clk_stop_pk = dbDao.searchTimeClockStopPK(dmtTimeClockStopVO);
					dmtTimeClockStopVO.setClkStopNo(clk_stop_pk);
					dbDao.addDmtTimeClockStopNo(dmtTimeClockStopVO);
					dbDao.addDmtTimeClockStop(dmtTimeClockStopVO);
					
					if("Y".equals(dmtTimeClockStopVO.getAllYdFlg())){
						// not create yard .
						//after save, search saving data  
						dmtTimeClockStop = dbDao.searchNewTimeClockStop(dmtTimeClockStopVO);
						
						TimeClockStopParmVO timeClockStopParmVO = new TimeClockStopParmVO();
						timeClockStopParmVO.setClkStopOfcCd(dmtTimeClockStopVO.getClkStopOfcCd());
						
						//search Time Clock Stop Yard 
						yardByOfficeVOs = dbDao.searchDMTYardByOffice(timeClockStopParmVO);
					}else{
						
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
						//after save, search saving data  
						dmtTimeClockStop = dbDao.searchNewTimeClockStop(dmtTimeClockStopVO);
						
						//search Time Clock Stop Yard 
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
					//2. in saving if there is no data , then run .
					int seq = dbDao.searchDmtTimeClockStopNoSeq(dmtTimeClockStopVO);
					dmtTimeClockStopVO.setSeq(String.valueOf(seq));
					String clk_stop_seq_pk = dbDao.searchTimeClockStopSeqPK(dmtTimeClockStopVO);
					dmtTimeClockStopVO.setClkStopNo(clk_stop_seq_pk);
					//2.1. search max data  before saving 
					dbDao.addDmtTimeClockStopNoSeq(dmtTimeClockStopVO);
					dbDao.addDmtTimeClockStopSeq(dmtTimeClockStopVO);
					
					if("Y".equals(dmtTimeClockStopVO.getAllYdFlg())){
						// not create yard .
						//after save, search saving data
						dmtTimeClockStop = dbDao.searchNewTimeClockStop(dmtTimeClockStopVO);
						
						TimeClockStopParmVO timeClockStopParmVO = new TimeClockStopParmVO();
						timeClockStopParmVO.setClkStopOfcCd(dmtTimeClockStopVO.getClkStopOfcCd());
						//search Time Clock Stop Yard
						yardByOfficeVOs = dbDao.searchDMTYardByOffice(timeClockStopParmVO);
					}else{
						
						String ydCdList = (String)dmtTimeClockStopVO.getClkStopYdCd();
						
						StringTokenizer st = new StringTokenizer(ydCdList, ",");
						String tempS = "";
						DmtTimeClockStopVO dmtTimeClockStopYardVO = dmtTimeClockStopVO;//Yard VO
						
						while (st.hasMoreTokens()) {
					    	tempS = st.nextToken(); 
					    	dmtTimeClockStopYardVO.setClkStopYdCd(tempS);
					    	
					    	dbDao.addDmtTimeClockStopYardSeq(dmtTimeClockStopYardVO);
					    }
				
						//after save, search saving data 
						dmtTimeClockStop = dbDao.searchNewTimeClockStop(dmtTimeClockStopVO);
						
						//search Time Clock Stop Yard
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
				//data  exist
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
	 * check authority user
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
