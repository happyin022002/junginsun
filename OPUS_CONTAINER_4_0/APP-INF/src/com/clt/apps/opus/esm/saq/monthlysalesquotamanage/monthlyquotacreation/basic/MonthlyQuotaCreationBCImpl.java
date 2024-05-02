/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaCreationBCImpl.java
 *@FileTitle : Model Execution
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration.MonthlyQuotaCreationDBDAO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataFromCoaListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataInterfaceVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaCheckListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaInfoList0077VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaModelLogListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * MonthlySalesQuotaManage Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESM_SAQ_0047EventResponse,MonthlyQuotaCreationBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaCreationBCImpl extends BasicCommandSupport implements MonthlyQuotaCreationBC {

	// Database Access Object
	private transient MonthlyQuotaCreationDBDAO dbDao = null;

	public MonthlyQuotaCreationBCImpl() {
		dbDao = new MonthlyQuotaCreationDBDAO();
	}

	/**
	 * 
	 * @param quotaConditionVO QuotaConditionVO
	 *            
	 * @return List<SearchMonthlyQuotaCheckListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaCheckListVO> searchMonthlyQuotaCheckList0047Tab01(QuotaConditionVO quotaConditionVO) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaCheckList0047Tab01(quotaConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 
	 * @param quotaConditionVO QuotaConditionVO
	 *            
	 * @return List<SearchMonthlyQuotaModelLogListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaModelLogListVO> searchMonthlyQuotaModelLogList0047Tab02(QuotaConditionVO quotaConditionVO) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaModelLogList0047Tab02(quotaConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Call Event <br>
	 * 
	 * @param quotaConditionVO
	 * @param account SignOnUserAccount
	 *            
	 * @exception EventException
	 */
	public void transferMonthlyProcess0047(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException {

		try {
			String usr_id = account.getUsr_id();
			String bse_yr = quotaConditionVO.getYear();
			String bse_qtr_cd = quotaConditionVO.getBseQtrCd();
			String fm_step = quotaConditionVO.getFmStep();
			String to_step = quotaConditionVO.getToStep();
			String msg = bse_yr + "#" + bse_qtr_cd + "#" + fm_step + "#" + to_step + "#" + usr_id;

			log.debug("======================================");
			log.debug("[MonthlyQuotaCreationBCImpl][transferMonthlyProcess] msg : " + msg);
			log.debug("======================================");

			ScheduleUtil su = new ScheduleUtil();
			String jobID = su.directExecuteJob("ESM_SAQ_B004", msg);
			log.debug(" jobID==> " + jobID);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * COMMAND ID : SEARCHLIST01~03<br>
	 * 
	 * @param quotaConditionVO
	 * @return List<SearchMonthlyQuotaModelLogListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInfoList0077VO> searchMonthlyQuotaInfoList0077(QuotaConditionVO quotaConditionVO) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaInfoList0077(quotaConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * COMMAND ID : MULTI01<br>
	 * 
	 * @param quotaConditionVO
	 * @param account SignOnUserAccount
	 *            
	 * @exception EventException
	 */
	public void confirmMonthlyQuotaFinalVersion0077(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException {

		try {

			String year = quotaConditionVO.getYear();
			String bseQtrCd = quotaConditionVO.getBseQtrCd();
			String version = quotaConditionVO.getNewVersion();
			String userId = account.getUsr_id();

			QuotaConditionVO resultVO = new QuotaConditionVO();

			resultVO = dbDao.searchSaqMonthlyModelResultStatusList(year, bseQtrCd);
			String str = resultVO.getStr();
			if (!"N".equals(str)) {
				throw new EventException((new ErrorHandler("SAQ00035")).getMessage());
			}

			dbDao.confirmMonthlyQuotaFinalVersion0077(year, bseQtrCd, version, userId);
			dbDao.createMonthlyQuotaGuidelineInfoVer0077(version, userId);
			dbDao.createMonthlyQuotaGuidelineInfoTrd0077(version, userId);
			dbDao.createMonthlyQuotaGuidelineInfoSub0077(version, userId);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * COMMAND ID : MODIFY01<br>
	 * 
	 * @param bseYr String
	 * @param bse_qtr_cd String
	 * @param account SignOnUserAccount             
	 * @exception EventException
	 */
	public void procMonthlyInitSmryCreation0077(String bseYr, String bse_qtr_cd, SignOnUserAccount account) throws EventException {
		try {
			ScheduleUtil su = new ScheduleUtil();

			String userId = account.getUsr_id();

			String msg = bseYr + "#" + bse_qtr_cd + "#" + userId;
			
			// program no, server code, parameter			
			String jobID = su.directExecuteJob("ESM_SAQ_B008", msg);
			
			log.debug("::::::::::::::::::::::::::::::::::: jobID==> " + jobID);			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param baseDataFromCoaListVO
	 * @param account
	 * @throws EventException
	 */
	public void createCoaInterfaceList(BaseDataFromCoaListVO baseDataFromCoaListVO, SignOnUserAccount account) throws EventException {
		try {
			baseDataFromCoaListVO.setUsrId(account.getUsr_id());
			dbDao.deleteCoaInterfaceList(baseDataFromCoaListVO);
			dbDao.createCoaInterfaceList(baseDataFromCoaListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchInterfaceList(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {
			return dbDao.searchInterfaceList(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchCOfcVerify(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {
			return dbDao.searchCOfcVerify(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchLOfcVerify(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {
			return dbDao.searchLOfcVerify(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO
	 * @return String
	 * @throws EventException
	 */
	public String checkOfficeValid(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {
			return dbDao.checkOfficeValid(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO[] 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateOfcVerify(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {
			List<BaseDataInterfaceVO> updateVoList = new ArrayList<BaseDataInterfaceVO>();
			List<BaseDataInterfaceVO> deleteVoList = new ArrayList<BaseDataInterfaceVO>();

			for (int i = 0; i < baseDataInterfaceVO.length; i++) {
				if (baseDataInterfaceVO[i].getIbflag().equals("U")) {
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					updateVoList.add(baseDataInterfaceVO[i]);
				}
				
				if (baseDataInterfaceVO[i].getIbflag().equals("D")) {	
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					deleteVoList.add(baseDataInterfaceVO[i]);
				}
			}			
			
			if (updateVoList.size() > 0) {
				dbDao.updateOfcVerify(updateVoList);
			}			
			
			if (deleteVoList.size() > 0) {
				dbDao.deleteOfcVerify(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO[] 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateReCalRpbCpb(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {
			List<BaseDataInterfaceVO> updateVoList = new ArrayList<BaseDataInterfaceVO>();

			for (int i = 0; i < baseDataInterfaceVO.length; i++) {
				if (baseDataInterfaceVO[i].getIbflag().equals("U")) {
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					updateVoList.add(baseDataInterfaceVO[i]);
				}				
			}

			if (updateVoList.size() > 0) {
				dbDao.updateReCalRpbCpb(updateVoList);
			}	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkConfirmFlg(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {	
			String strCfFlg = "";
			if (baseDataInterfaceVO != null) {				
				strCfFlg = dbDao.checkConfirmFlg(baseDataInterfaceVO);
			}
			return strCfFlg;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateConfirm(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {	
			if (baseDataInterfaceVO != null) {
				baseDataInterfaceVO.setUserId(account.getUsr_id());
				dbDao.updateConfirm(baseDataInterfaceVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateCancel(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {	
			if (baseDataInterfaceVO != null) {
				baseDataInterfaceVO.setUserId(account.getUsr_id());
				dbDao.updateCancel(baseDataInterfaceVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateNotify(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {	
			String strNotifyChk = "";
			strNotifyChk = dbDao.searchNotifyCheck(baseDataInterfaceVO); // confirm check
			
			if(!"F".equals(strNotifyChk)){				
				throw new EventException(new ErrorHandler("COM12114", new String[]{"There exist do not confirmed !  "+strNotifyChk}).getMessage());
			} else {				
				if (baseDataInterfaceVO != null) {
					baseDataInterfaceVO.setUserId(account.getUsr_id());
					dbDao.updateNotify(baseDataInterfaceVO);
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchOfcAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {
			return dbDao.searchOfcAdjust(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO[] 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateOfcAdjust(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {			
			List<BaseDataInterfaceVO> insertVoList = new ArrayList<BaseDataInterfaceVO>();
			List<BaseDataInterfaceVO> updateVoList = new ArrayList<BaseDataInterfaceVO>();
			List<BaseDataInterfaceVO> deleteVoList = new ArrayList<BaseDataInterfaceVO>();

			for (int i = 0; i < baseDataInterfaceVO.length; i++) {
				if (baseDataInterfaceVO[i].getIbflag().equals("I")) {
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					insertVoList.add(baseDataInterfaceVO[i]);
				}
				
				if (baseDataInterfaceVO[i].getIbflag().equals("U")) {
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					updateVoList.add(baseDataInterfaceVO[i]);
				}
				
				if (baseDataInterfaceVO[i].getIbflag().equals("D")) {	
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					deleteVoList.add(baseDataInterfaceVO[i]);
				}
			}
			
			if (insertVoList.size() > 0) {
				dbDao.createOfcAdjust(insertVoList);
			}	

			if (updateVoList.size() > 0) {
				dbDao.updateOfcAdjust(updateVoList);
			}			
			
			if (deleteVoList.size() > 0) {
				dbDao.deleteOfcAdjust(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchLaneAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {
			return dbDao.searchLaneAdjust(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO[] 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateLaneAdjust(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {			
			List<BaseDataInterfaceVO> insertVoList = new ArrayList<BaseDataInterfaceVO>();
			List<BaseDataInterfaceVO> updateVoList = new ArrayList<BaseDataInterfaceVO>();
			List<BaseDataInterfaceVO> deleteVoList = new ArrayList<BaseDataInterfaceVO>();

			for (int i = 0; i < baseDataInterfaceVO.length; i++) {
				if (baseDataInterfaceVO[i].getIbflag().equals("I")) {
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					insertVoList.add(baseDataInterfaceVO[i]);
				}
				
				if (baseDataInterfaceVO[i].getIbflag().equals("U")) {
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					updateVoList.add(baseDataInterfaceVO[i]);
				}
				
				if (baseDataInterfaceVO[i].getIbflag().equals("D")) {	
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					deleteVoList.add(baseDataInterfaceVO[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.createLaneAdjust(updateVoList);
			}
			
//			if (updateVoList.size() > 0) {
//				dbDao.updateLaneAdjust(updateVoList);
//			}
			
			if (deleteVoList.size() > 0) {
				dbDao.deleteLaneAdjust(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchCPBAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {
			return dbDao.searchCPBAdjust(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO[] 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateCPBAdjust(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {			
			List<BaseDataInterfaceVO> updateVoList = new ArrayList<BaseDataInterfaceVO>();
//			List<BaseDataInterfaceVO> deleteVoList = new ArrayList<BaseDataInterfaceVO>();

			for (int i = 0; i < baseDataInterfaceVO.length; i++) {
				if (baseDataInterfaceVO[i].getIbflag().equals("I") || baseDataInterfaceVO[i].getIbflag().equals("U")) {
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					updateVoList.add(baseDataInterfaceVO[i]);
				}
				
//				if (baseDataInterfaceVO[i].getIbflag().equals("D")) {	
//					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
//					deleteVoList.add(baseDataInterfaceVO[i]);
//				}
			}

			if (updateVoList.size() > 0) {
				dbDao.updateCPBAdjust(updateVoList);
			}			
			
//			if (deleteVoList.size() > 0) {
//				dbDao.deleteCPBAdjust(deleteVoList);
//			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @param account SignOnUserAccount 
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchGuidelineInitList(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {				
			
//			List<BaseDataInterfaceVO> searchList = dbDao.searchGuidelineInitList(baseDataInterfaceVO);
//			baseDataInterfaceVO.setMqtaMdlVerNo(searchList.get(0).getMqtaMdlVerNo());			
			baseDataInterfaceVO.setUserId(account.getUsr_id());

			//if (baseDataInterfaceVO != null) { //소스 품질 수정 요청건
				dbDao.deleteGuidelineInit(baseDataInterfaceVO);
				dbDao.createGuidelineInit(baseDataInterfaceVO);
			//}		
			
			return dbDao.searchGuidelineList(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws EventException
	 */
	public List<BaseDataInterfaceVO> searchGuidelineList(BaseDataInterfaceVO baseDataInterfaceVO) throws EventException {
		try {
			return dbDao.searchGuidelineList(baseDataInterfaceVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO[] 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuideline(BaseDataInterfaceVO[] baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {			
			List<BaseDataInterfaceVO> updateVoList = new ArrayList<BaseDataInterfaceVO>();

			for (int i = 0; i < baseDataInterfaceVO.length; i++) {
				if (baseDataInterfaceVO[i].getIbflag().equals("I") || baseDataInterfaceVO[i].getIbflag().equals("U")) {
					baseDataInterfaceVO[i].setUserId(account.getUsr_id());
					updateVoList.add(baseDataInterfaceVO[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.updateGuideline(updateVoList);
				//dbDao.updateFcastTrans(updateVoList.get(0));
			}	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuidelineConfirm(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {			
			if (baseDataInterfaceVO != null) {
				baseDataInterfaceVO.setUserId(account.getUsr_id());
				dbDao.updateGuidelineConfirm(baseDataInterfaceVO);
				dbDao.updateFcastTrans(baseDataInterfaceVO);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuidelineCancelConfirm(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {			
			if (baseDataInterfaceVO != null) {
				baseDataInterfaceVO.setUserId(account.getUsr_id());
				dbDao.updateGuidelineCancelConfirm(baseDataInterfaceVO);				
			}	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuidelineNotify(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {			
			if (baseDataInterfaceVO != null) {
				baseDataInterfaceVO.setUserId(account.getUsr_id());
				dbDao.updateGuidelineNotify(baseDataInterfaceVO);
				dbDao.updateFcastTrans(baseDataInterfaceVO);
			}	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	/**
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void updateGuidelineCancelNotify(BaseDataInterfaceVO baseDataInterfaceVO, SignOnUserAccount account) throws EventException {
		try {			
			if (baseDataInterfaceVO != null) {
				baseDataInterfaceVO.setUserId(account.getUsr_id());
				dbDao.updateGuidelineCancelNotify(baseDataInterfaceVO);
				//Todo apply_ 컬럼 값 삭제 필요
				//				dbDao.updateFcastTrans(baseDataInterfaceVO); 
			}	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}	
}