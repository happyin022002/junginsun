/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : MonthlyCustomizedConditionBCImpl.java
 *@FileTitle      : Customized Conditions
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    :
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.integration.MonthlyCustomizedConditionDBDAO;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonDirConvVO;
import com.clt.syscommon.common.table.SaqMonLodTgtOfcVO;

/**
 * BasicDataManage Business Logic Basic Command implementation<br>
 * - handling business transaction<br>
 * 
 * @author
 * @see ESM_SAQ_0163EventResponse,MonthlyCustomizedConditionBC
 * @since J2EE 1.6
 */
public class MonthlyCustomizedConditionBCImpl extends BasicCommandSupport implements MonthlyCustomizedConditionBC {

	// Database Access Object
	private transient MonthlyCustomizedConditionDBDAO dbDao = null;

	/**
	 * related objects creation<br>
	 */
	public MonthlyCustomizedConditionBCImpl() {
		dbDao = new MonthlyCustomizedConditionDBDAO();
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyCustomizedConditionTabLoadTarget0163Tab01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		try {
			// MonthlyCustomizedConditionTabLoadTargetVO rsVO = new MonthlyCustomizedConditionTabLoadTargetVO();
			listVO.setDbRowset(dbDao.searchMonthlyCustomizedConditionTabLoadTarget0163Tab01(conditionVO));

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}

	/**
	 * retrieving 2tab status<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String getMonthlyCustomizedConditionLodTargetStatus(QuotaConditionVO conditionVO) throws EventException {
		String status = "";
		try {

			status = dbDao.getMonthlyCustomizedConditionLodTargetStatus0163Tab01(conditionVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return status;
	}

	/**
	 * retrieving 2tab status<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String getMonthlyCustomizedConditionLaneBoundStatus(QuotaConditionVO conditionVO) throws EventException {
		String status = "";
		try {
			status = dbDao.getMonthlyCustomizedConditionLaneBoundStatus0163Tab02(conditionVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return status;
	}

	/**
	 * retrieving 2tab status<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyCustomizedConditionTabLaneBound0163Tab02(QuotaConditionVO conditionVO) throws EventException {
		// List<MonthlyCustomizedConditionTabLaneBoundVO> returnVO = new ArrayList<MonthlyCustomizedConditionTabLaneBoundVO>();
		ReturnVO listVO = new ReturnVO();
		try {
			// MonthlyCustomizedConditionTabLaneBoundVO rsVO = new MonthlyCustomizedConditionTabLaneBoundVO();

			// DBRowSet rowSet = dbDao.searchMonthlyCustomizedConditionTabLaneBound0163Tab02(conditionVO);
			listVO.setDbRowset(dbDao.searchMonthlyCustomizedConditionTabLaneBound0163Tab02(conditionVO));
			// rsVO.setDbRowset(rowSet);
			// rsVO.setConditionVO(monthlyCustomizedConditionTabLoadTargetConditionVO);

			// returnVO.add(rsVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;

	}

	/**
	 * copy 1 tab<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		DBRowSet rowSet = null;
		String copyBse_yr = "";
		String copyBse_qtr_cd = "";
		try {
			// 1. retrieving key value
			rowSet = dbDao.searchLodTargetPreviousCheckKey0163Tab01(conditionVO);
			if (rowSet.next()) {
				copyBse_yr = rowSet.getString("bse_yr");
				copyBse_qtr_cd = rowSet.getString("bse_qtr_cd");
			} else {
				return "Fail";
			}
			conditionVO.setCopyBseQtrCd(copyBse_qtr_cd);
			conditionVO.setCopyBseYr(copyBse_yr);
			conditionVO.setCreUsrId(account.getUsr_id());
			// 2. delete & insert
			dbDao.multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01BeforeDel(conditionVO);
			dbDao.multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01(conditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return "";
	}

	/**
	 * copy 2 tab<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		DBRowSet rowSet = null;
		String copyBse_yr = "";
		String copyBse_qtr_cd = "";
		try {
			// 1. retrieving key value
			rowSet = dbDao.searchLaneBoundPreviousCheckKey0163Tab02(conditionVO);
			if (rowSet.next()) {
				copyBse_yr = rowSet.getString("bse_yr");
				copyBse_qtr_cd = rowSet.getString("bse_qtr_cd");
			} else {
				return "Fail";
			}
			conditionVO.setCopyBseQtrCd(copyBse_qtr_cd);
			conditionVO.setCopyBseYr(copyBse_yr);
			conditionVO.setCreUsrId(account.getUsr_id());
			// 2. delete & insert
			dbDao.multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02BeforeDel(conditionVO);
			dbDao.multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02(conditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return "";
	}

	/**
	 * event process<br>
	 * 
	 * @param SaqMonLodTgtOfcVO[] saqMonLodTgtOfcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyCustomizedConditionTabLoadTargetSave0163Tab01(SaqMonLodTgtOfcVO[] saqMonLodTgtOfcVO, SignOnUserAccount account) throws EventException {
		List<SaqMonLodTgtOfcVO> insertVoList = new ArrayList<SaqMonLodTgtOfcVO>();
		List<SaqMonLodTgtOfcVO> deleteVoList = new ArrayList<SaqMonLodTgtOfcVO>();

		try {
			if (saqMonLodTgtOfcVO != null) {
				for (int i = 0; i < saqMonLodTgtOfcVO.length; i++) {
					if ("I".equals(saqMonLodTgtOfcVO[i].getIbflag())) {
						saqMonLodTgtOfcVO[i].setUpdUsrId(account.getUsr_id());
						saqMonLodTgtOfcVO[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(saqMonLodTgtOfcVO[i]);
					} else if ("D".equals(saqMonLodTgtOfcVO[i].getIbflag())) {
						deleteVoList.add(saqMonLodTgtOfcVO[i]);
					}
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeMonthlyCustomizedConditionTabLoadTargetSaveS0163Tab01(deleteVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.multiMonthlyCustomizedConditionTabLoadTargetSaveS0163Tab01(insertVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * event process<br>
	 * 
	 * @param SaqMonDirConvVO[] saqMonDirConvVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyCustomizedConditionTabLaneBoundSave0163Tab02(SaqMonDirConvVO[] saqMonDirConvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SaqMonDirConvVO> insertVoListA = new ArrayList<SaqMonDirConvVO>();
			List<SaqMonDirConvVO> insertVoListB = new ArrayList<SaqMonDirConvVO>();
			List<SaqMonDirConvVO> updateVoList = new ArrayList<SaqMonDirConvVO>();
			List<SaqMonDirConvVO> deleteVoList = new ArrayList<SaqMonDirConvVO>();

			String tempDirCd = null;

			for (int i = 0; i < saqMonDirConvVOs.length; i++) {
				if (saqMonDirConvVOs[i].getIbflag().equals("I")) {
					saqMonDirConvVOs[i].setCreUsrId(account.getUsr_id());
					saqMonDirConvVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoListA.add(saqMonDirConvVOs[i]);
				} else if (saqMonDirConvVOs[i].getIbflag().equals("U")) {
					saqMonDirConvVOs[i].setUpdUsrId(account.getUsr_id());
					saqMonDirConvVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqMonDirConvVOs[i]);
				} else if (saqMonDirConvVOs[i].getIbflag().equals("D")) {
					saqMonDirConvVOs[i].setUpdUsrId(account.getUsr_id());
					saqMonDirConvVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(saqMonDirConvVOs[i]);
				}
			}

			if (insertVoListA.size() > 0) {
				dbDao.multiMonthlyCustomizedConditionTabLaneBoundSaveVOC0163Tab02(insertVoListA);
			}

			for (int i = 0; i < saqMonDirConvVOs.length; i++) {
				if (saqMonDirConvVOs[i].getIbflag().equals("I")) {
					saqMonDirConvVOs[i].setCreUsrId(account.getUsr_id());
					saqMonDirConvVOs[i].setUpdUsrId(account.getUsr_id());

					tempDirCd = saqMonDirConvVOs[i].getDirCd();
					saqMonDirConvVOs[i].setDirCd(saqMonDirConvVOs[i].getConvDirCd());
					saqMonDirConvVOs[i].setConvDirCd(tempDirCd);

					insertVoListB.add(saqMonDirConvVOs[i]);
				}
			}
			if (insertVoListB.size() > 0) {
				dbDao.multiMonthlyCustomizedConditionTabLaneBoundSaveVOC0163Tab02(insertVoListB);
			}

			if (deleteVoList.size() > 0) {
				dbDao.multiMonthlyCustomizedConditionTabLaneBoundSaveVOD0163Tab02(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * event process<br>
	 * 2tab confirm/cancel
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyCustomizedConditionTabLaneBound0163Tab02(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setCreUsrId(account.getUsr_id());
			conditionVO.setUpdUsrId(account.getUsr_id());
			dbDao.updateMonthlyCustomizedConditionTabLaneBound0163Tab02(conditionVO);

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * event process<br>
	 * 1tab confirm/cancel
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyCustomizedConditionTabLoadTarget0163Tab01(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setCreUsrId(account.getUsr_id());
			conditionVO.setUpdUsrId(account.getUsr_id());
			dbDao.updateMonthlyCustomizedConditionTabLoadTarget0163Tab01(conditionVO);

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

}