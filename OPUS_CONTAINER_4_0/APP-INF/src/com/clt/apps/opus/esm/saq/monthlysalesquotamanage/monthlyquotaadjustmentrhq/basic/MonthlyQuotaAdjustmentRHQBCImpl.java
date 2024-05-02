/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaAdjustmentRHQBCImpl.java
 *@FileTitle : Monthly Sales Quota Adjustment RHQ
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.SAQUtil;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0075Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0149Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0161Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0162Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration.MonthlyQuotaAdjustmentRHQDBDAO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.MonthlyQuotaAdjustmentRhqVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaAdjustmentRhqModifyListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaForExcelListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonQtaOfcAddVO;
import com.clt.syscommon.common.table.SaqMonQtaRhqVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * MonthlySalesQuotaManage Business Logic Basic Command implementation<br>
 *  
 * @author
 * @see ESM_SAQ_0075EventResponse,MonthlyQuotaAdjustmentRHQBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentRHQBCImpl extends BasicCommandSupport implements MonthlyQuotaAdjustmentRHQBC {

	private transient MonthlyQuotaAdjustmentRHQDBDAO dbDao = null;

	public MonthlyQuotaAdjustmentRHQBCImpl() {
		dbDao = new MonthlyQuotaAdjustmentRHQDBDAO();
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01(QuotaConditionVO conditionVO) throws EventException {
		try {
			ReturnVO listVO = new ReturnVO();
			List<MonthlyQuotaAdjustmentRhqVO> key = dbDao.getPreviousCheckKey0075Tab01Sub01(conditionVO);
			conditionVO.setMqtaMdlVerNo(key.get(0).getMqtaMdlVerNo());
			conditionVO.setSlsFcastPubNo(key.get(0).getSlsFcastPubNo());
			conditionVO.setSaqStsCd(key.get(0).getSaqStsCd());
			conditionVO.setInclPortFlag(key.get(0).getInclPortFlg());
			conditionVO.setQuarter(SAQUtil.getBefYrQtr(conditionVO.getYear() + conditionVO.getBse_quarter()));
			conditionVO.setChkCommand("SEARCHLIST");
			List<MonthlyQuotaAdjustmentRhqVO> resultVO = dbDao.searchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01(conditionVO);
			listVO.addList(resultVO);
			listVO.addList(conditionVO);
			return listVO;
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
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01(QuotaConditionVO conditionVO) throws EventException {
		try {
			ReturnVO listVO = new ReturnVO();
			conditionVO.setChkCommand("SEARCHLIST01");

			List<MonthlyQuotaAdjustmentRhqVO> resultVO = dbDao.searchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01(conditionVO);

			listVO.addList(resultVO);
			listVO.addList(conditionVO);
			return listVO;
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
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentRHQTabTrade0075Tab01List02(QuotaConditionVO conditionVO) throws EventException {
		try {
			ReturnVO listVO = new ReturnVO();
			conditionVO.setChkCommand("SEARCHLIST02");

			List<MonthlyQuotaAdjustmentRhqVO> resultVO = dbDao.searchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01(conditionVO);
			listVO.addList(resultVO);
			listVO.addList(conditionVO);
			return listVO;
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
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentRHQTabSubTrade0075Tab02List01(QuotaConditionVO conditionVO) throws EventException {
		try {
			ReturnVO listVO = new ReturnVO();
			conditionVO.setChkCommand("SEARCHLIST03");
			conditionVO.setQuarter(SAQUtil.getBefYrQtr(conditionVO.getYear() + conditionVO.getBse_quarter()));
			List<MonthlyQuotaAdjustmentRhqVO> resultVO = dbDao.searchMonthlyAdjustmentRHQTabSubTrade0075Tab02List01(conditionVO);
			listVO.addList(resultVO);
			listVO.addList(conditionVO);
			return listVO;
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
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentRHQTabRhqLane0075Tab03List01(QuotaConditionVO conditionVO) throws EventException {
		try {
			ReturnVO listVO = new ReturnVO();
			conditionVO.setChkCommand("SEARCHLIST04");
			conditionVO.setQuarter(SAQUtil.getBefYrQtr(conditionVO.getYear() + conditionVO.getBse_quarter()));
			List<MonthlyQuotaAdjustmentRhqVO> resultVO = dbDao.searchMonthlyAdjustmentRHQTabRhqLane0075Tab03List01(conditionVO);
			listVO.addList(resultVO);
			listVO.addList(conditionVO);
			return listVO;
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
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdjustmentRHQVO>
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01(QuotaConditionVO conditionVO) throws EventException {
		try {
			ReturnVO listVO = new ReturnVO();
			conditionVO.setChkCommand("SEARCHLIST05");
			List<MonthlyQuotaAdjustmentRhqVO> resultVO = dbDao.searchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01(conditionVO);
			listVO.addList(resultVO);
			listVO.addList(conditionVO);
			return listVO;
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
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaForExcel0161List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();

		try {

			listVO = dbDao.searchMonthlyQuotaForExcel0161List(conditionVO);

			return listVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * updateMonthlyQuotaForExcelList <br>
	 * 
	 * @param EsmSaq0161Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyQuotaForExcel0161(EsmSaq0161Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaRhqVO[] saqConVOs = event.getSaqMonQtaRhqVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaRhqVO> insertVoList = new ArrayList<SaqMonQtaRhqVO>();
			List<SaqMonQtaRhqVO> updateVoList = new ArrayList<SaqMonQtaRhqVO>();
			List<SaqMonQtaRhqVO> deleteVoList = new ArrayList<SaqMonQtaRhqVO>();

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("U")) {
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.updateSaqMonQta0161(updateVoList, conditionVO);
			}

			conditionVO.setMQtaStepCd(conditionVO.getMqta_step_cd());
			conditionVO.setYear(conditionVO.getBse_yr());
			conditionVO.setBse_quarter(conditionVO.getBse_qtr_cd());
			conditionVO.setTrade(conditionVO.getTrd_cd());
			conditionVO.setBound(conditionVO.getDir_cd());
			conditionVO.setMQtaVerNo(conditionVO.getMqta_ver_no());
			dbDao.procAdjustmentLoadRoundOff(conditionVO);

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
	 * @param QuotaConditionVO conditionVO
	 * @return List<QuotaConditionVO>
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentRhqModify0149List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentRhqModifyListVO> searchMonthlyQuotaAdjustmentRhqModifyListVOs = null;

		try {

			searchMonthlyQuotaAdjustmentRhqModifyListVOs = dbDao.searchMonthlyQuotaAdjustmentRhqModify0149List(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentRhqModifyListVOs);
			listVO.addList(conditionVO);

			return listVO;
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
	 * @param EsmSaq0149Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyQuotaAdjustmentRhqModify0149(EsmSaq0149Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaRhqVO[] saqConVOs = event.getSaqMonQtaRhqVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaRhqVO> insertVoList = new ArrayList<SaqMonQtaRhqVO>();
			List<SaqMonQtaRhqVO> updateVoList = new ArrayList<SaqMonQtaRhqVO>();
			List<SaqMonQtaRhqVO> deleteVoList = new ArrayList<SaqMonQtaRhqVO>();

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("U")) {
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.multiMonthlyQuotaAdjustmentRhqModify0149(updateVoList, conditionVO);
			}

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
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaOfficeAdd0162List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaForExcelListVO> searchMonthlyQuotaForExcelListVOs = null;

		try {
			searchMonthlyQuotaForExcelListVOs = dbDao.searchMonthlyQuotaOfficeAdd0162List(conditionVO);
			listVO.addList(searchMonthlyQuotaForExcelListVOs);
			listVO.addList(conditionVO);

			return listVO;
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
	 * @param EsmSaq0162Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void insertMonthlyQuotaOfficeAdd0162(EsmSaq0162Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaOfcAddVO[] saqConVOs = event.getSaqMonQtaOfcAddVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaOfcAddVO> insertVoList = new ArrayList<SaqMonQtaOfcAddVO>();
			List<SaqMonQtaOfcAddVO> updateVoList = new ArrayList<SaqMonQtaOfcAddVO>();
			List<SaqMonQtaOfcAddVO> deleteVoList = new ArrayList<SaqMonQtaOfcAddVO>();

			String[] data_cnt = new String[20];
			boolean isInsert = false;
			String unitCostFlag = "Y";

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(saqConVOs[i]);

					isInsert = true;
					data_cnt[i] = dbDao.getMonthlyQuotaOfficeAddDataCnt0162(saqConVOs[i]);

				} else if (saqConVOs[i].getIbflag().equals("U")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}

			if (!isInsert) {
				data_cnt[0] = "0";
			}

			for (int i = 0; i < data_cnt.length; i++) {
				if (data_cnt[i] == null)
					break;

				if (data_cnt[i].equals("0")) {
					//throw new EventException((new ErrorHandler("SAQ00037")).getMessage());
					unitCostFlag = "N";
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.insertMonthlyQuotaOfficeAddList0162(insertVoList, conditionVO, unitCostFlag);
			}

			String mqta_step_cd = conditionVO.getMqta_step_cd();
			if (mqta_step_cd.equals("08")) {
				if (insertVoList.size() > 0) {
					dbDao.insertMonthlyQuotaOfficeAddLodTgt0162(insertVoList, conditionVO);
				}
			} else {
				if (insertVoList.size() > 0) {
					dbDao.insertMonthlyQuotaOfficeAddRhq0162(insertVoList, conditionVO);
				}
			}

			String tmp = "";
			String msg = "";

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					if (saqConVOs[i].getMqtaStepCd().equals("08")) {
						tmp = dbDao.getMonthlyQuotaOfficeAddLodTgtInsertList0162(saqConVOs[i]);
					} else {
						tmp = dbDao.getMonthlyQuotaOfficeAddRhqInsertList0162(saqConVOs[i]);
					}
					msg = msg + "\n" + tmp;
				}
			}

			conditionVO.setSaveList(msg);

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
	 * @param EsmSaq0075Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMonthlyAdjustmentRhqInfo0075(EsmSaq0075Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaRhqVO[] saqConVOs = event.getSaqMonQtaRhqVOs();
			QuotaConditionVO conditionVO = event.getCondition();
			conditionVO.setUserId(account.getUsr_id());

			String newVersionNo = "";

			List<SaqMonQtaRhqVO> insertVoList = new ArrayList<SaqMonQtaRhqVO>();
			List<SaqMonQtaRhqVO> updateVoList = new ArrayList<SaqMonQtaRhqVO>();
			List<SaqMonQtaRhqVO> deleteVoList = new ArrayList<SaqMonQtaRhqVO>();

			// new Version create
			newVersionNo = dbDao.getNewMonthlyQuotaStepVersionNumber0075(conditionVO);

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("U")) {
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					saqConVOs[i].setMqtaVerNo(newVersionNo);
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}

			conditionVO.setNewVersion(newVersionNo);
			dbDao.createMonthlyAdjustmentRhqInfoA0075(conditionVO);

			conditionVO.setMQtaVerNo(newVersionNo);
			if (updateVoList.size() > 0) {

				dbDao.updateSaqMonQtaRhq0075(updateVoList, conditionVO);
			}

			conditionVO.setMQtaVerNo(newVersionNo);

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
	 * @param EsmSaq0075Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentRhqFinal0075(EsmSaq0075Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaRhqVO[] saqConVOs = event.getSaqMonQtaRhqVOs();
			QuotaConditionVO conditionVO = event.getCondition();

			List<SaqMonQtaRhqVO> insertVoList = new ArrayList<SaqMonQtaRhqVO>();
			List<SaqMonQtaRhqVO> updateVoList = new ArrayList<SaqMonQtaRhqVO>();
			List<SaqMonQtaRhqVO> deleteVoList = new ArrayList<SaqMonQtaRhqVO>();

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("U")) {
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.updateSaqMonQtaRhq0075(updateVoList, conditionVO);
			}

			conditionVO.setMQtaStepCd("04");
			List<MonthlyQuotaAdjustmentRhqVO> key = dbDao.getPreviousCheckKey0075Tab01Sub01(conditionVO);

			conditionVO.setSaqStsCd(key.get(0).getSaqStsCd());
			conditionVO.setMqtaMdlVerNo(key.get(0).getMqtaMdlVerNo());
			conditionVO.setSlsFcastPubNo(key.get(0).getSlsFcastPubNo());
			conditionVO.setInclPortFlag(key.get(0).getInclPortFlg());

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
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentRhqCancelCurrentVersion0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			int cnt = 0;
			String stsCd = "XX";
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			cnt = dbDao.checkCancelAllCurrentVersion0075(conditionVO);

			if (cnt < 2) {
				throw new EventException((new ErrorHandler("SAQ00036")).getMessage());
			}

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("");
			dbDao.modifySaqMonQtaStepVerStatus0075(conditionVO);

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
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String procAdjustmentRhqFinalConfirmDraft0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		String rtn = "";
		try {

			String stsCd = "FC"; // 00 => DC
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());
			conditionVO.setStatusCd(stsCd);

			conditionVO.setMQtaStepCd("04");
			String months = dbDao.getLoadRoundOffNeedMonth0075(conditionVO);
			if (months.length() > 0) {
				return (new ErrorHandler("SAQ00020", new String[] { months })).getUserMessage().toString();
			}

			// STEP 06 status 변경 (00 => FC)
			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("00");
			dbDao.modifySaqMonQtaStepVerStatus0075(conditionVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentRhqFinalCancelConfirmation0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "00";
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("FC");
			dbDao.modifySaqMonQtaStepVerStatus0075(conditionVO);

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
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentRhqFinalNotifyDraft0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			boolean isTrue = false;

			String stsCd = "FN"; // FC => FN (Notify Draft)
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());
			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("FC");
			dbDao.modifySaqMonQtaStepVerStatus0075(conditionVO);

			dbDao.modifySaqMonQtaRhqRmkStatus0075(conditionVO);

			isTrue = dbDao.isGuidlineTrdDirAllMqtaVerNoFNFC0075(conditionVO);
			if (isTrue) {

				dbDao.procSaqMonQtaLodTgtCre(conditionVO);

				stsCd = "QN"; // FC => FN (Notify Draft)
			}
			conditionVO.setStatusCd(stsCd);

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
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentRhqFinalCancelNotification0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "FC"; // FN => FC
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			conditionVO.setSaq_sts_cd(stsCd);
			int statusFC = dbDao.getRgnSaqStsCdCount0075(conditionVO);
			if (statusFC > 0) {
				throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
			}

			conditionVO.setSaq_sts_cd("FN");
			conditionVO.setStatusCd(stsCd);
			dbDao.modifySaqMonQtaStepVerStatus0075(conditionVO);
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
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentRhqLoadZero0075List(QuotaConditionVO conditionVO) throws EventException {

		String retMsg = "";

		try {
			retMsg = dbDao.searchAdjustmentRhqLoadZero0075List(conditionVO);

			return retMsg;

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
	 * @param String mqtaStepCd
	 * @param String bseYr
	 * @param String bse_qtr_cd
	 * @param String trdCd
	 * @param String dirCd
	 * @param String mqtaVerNo
	 * @param String usrId
	 * @exception EventException
	 */
	public void createQtaAdjSmry(String mqtaStepCd, String bseYr, String bse_qtr_cd, String trdCd, String dirCd, String mqtaVerNo, String usrId) throws EventException {
		try {

			ScheduleUtil su = new ScheduleUtil();
			String msg = mqtaStepCd + "#" + bseYr + "#" + bse_qtr_cd + "#" + trdCd + "#" + dirCd + "#" + mqtaVerNo + "#" + usrId;

			su.directExecuteJob("ESM_SAQ_B005", msg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}