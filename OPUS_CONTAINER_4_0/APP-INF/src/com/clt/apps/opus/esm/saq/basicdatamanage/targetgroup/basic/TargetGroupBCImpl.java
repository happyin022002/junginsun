/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : TargetGroupBCImpl.java
 *@FileTitle      : TargetGroup
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    : 
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration.TargetGroupDBDAO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchCostManagement0170ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroup0014ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroupTrade0013ListVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ModelConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqCostApplBseVO;
import com.clt.syscommon.common.table.SaqTgtGrpTrdVO;
import com.clt.syscommon.common.table.SaqTgtGrpVO;

/**
 * BasicDataManage Business Logic Basic Command implementation<br>
 * - handling business transaction<br>
 * 
 * @author
 * @see ESM_SAQ_0014EventResponse,TargetGroupBC
 * @since J2EE 1.6
 */
public class TargetGroupBCImpl extends BasicCommandSupport implements TargetGroupBC {

	// Database Access Object
	private transient TargetGroupDBDAO dbDao = null;

	/**
	 * related objects creation<br>
	 */
	public TargetGroupBCImpl() {
		dbDao = new TargetGroupDBDAO();
	}

	/**
	 * retrieving [Traget Group Control] <br>
	 * 
	 * 
	 * @return List<SearchTargetGroup0014ListVO>
	 * @exception EventException
	 */
	public List<SearchTargetGroup0014ListVO> searchTargetGroup0014List() throws EventException {
		try {
			return dbDao.searchTargetGroup0014List();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * retrieving [Traget Group Control] <br>
	 * 
	 * @param saqTgtGrpVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiTargetGroup0014(SaqTgtGrpVO[] saqTgtGrpVO, SignOnUserAccount account) throws EventException {
		try {
			List<SaqTgtGrpVO> insertVoList = new ArrayList<SaqTgtGrpVO>();
			List<SaqTgtGrpVO> updateVoList = new ArrayList<SaqTgtGrpVO>();
			List<SaqTgtGrpVO> deleteVoList = new ArrayList<SaqTgtGrpVO>();
			for (int i = 0; i < saqTgtGrpVO.length; i++) {
				if (saqTgtGrpVO[i].getIbflag().equals("I")) {
					saqTgtGrpVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqTgtGrpVO[i]);
				} else if (saqTgtGrpVO[i].getIbflag().equals("U")) {
					saqTgtGrpVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqTgtGrpVO[i]);
				} else if (saqTgtGrpVO[i].getIbflag().equals("D")) {
					deleteVoList.add(saqTgtGrpVO[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addMultiSaqTgtGrp0014(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyMultiSaqTgtGrp0014(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeMultiSaqTgtGrp0014(deleteVoList);
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
	 * retrieving [Sales Quota Scope] <br>
	 * 
	 * @param modelConditionVO
	 * @return List<SearchTargetGroupTrade0013ListVO>
	 * @exception EventException
	 */
	public List<SearchTargetGroupTrade0013ListVO> searchTargetGroupTrade0013List(ModelConditionVO modelConditionVO) throws EventException {
		try {
			return dbDao.searchTargetGroupTrade0013List(modelConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * retrieving [Sales Quota Scope] <br>
	 * 
	 * @param saqTgtGrpTrdVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiTargetGroupTrade0013(SaqTgtGrpTrdVO[] saqTgtGrpTrdVO, SignOnUserAccount account) throws EventException {
		try {
			List<SaqTgtGrpTrdVO> insertVoList = new ArrayList<SaqTgtGrpTrdVO>();
			List<SaqTgtGrpTrdVO> updateVoList = new ArrayList<SaqTgtGrpTrdVO>();
			List<SaqTgtGrpTrdVO> deleteVoList = new ArrayList<SaqTgtGrpTrdVO>();
			for (int i = 0; i < saqTgtGrpTrdVO.length; i++) {
				if (saqTgtGrpTrdVO[i].getIbflag().equals("I")) {
					saqTgtGrpTrdVO[i].setCreUsrId(account.getUsr_id());
					saqTgtGrpTrdVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(saqTgtGrpTrdVO[i]);
				} else if (saqTgtGrpTrdVO[i].getIbflag().equals("U")) {
					saqTgtGrpTrdVO[i].setCreUsrId(account.getUsr_id());
					saqTgtGrpTrdVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqTgtGrpTrdVO[i]);
				} else if (saqTgtGrpTrdVO[i].getIbflag().equals("D")) {
					deleteVoList.add(saqTgtGrpTrdVO[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addMultiTargetGroupTrade0013(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyMultiTargetGroupTrade0013(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeMultiTargetGroupTrade0013(deleteVoList);
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
	 * retrieving Year/Month Set for Cost Management <br>
	 * 
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @return List<SearchCostManagement0170ListVO>
	 * @exception EventException
	 */
	public List<SearchCostManagement0170ListVO> searchCostManagement0170List(String bse_yr, String bse_qtr_cd) throws EventException {
		try {
			return dbDao.searchCostManagement0170List(bse_yr, bse_qtr_cd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * retrieving Year/Month Set for Cost Management <br>
	 * 
	 * @param saqCostApplBseVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostManagementSave0170(SaqCostApplBseVO[] saqCostApplBseVO, SignOnUserAccount account) throws EventException {
		try {
			List<SaqCostApplBseVO> insertVoList = new ArrayList<SaqCostApplBseVO>();
			for (int i = 0; i < saqCostApplBseVO.length; i++) {
				if (!saqCostApplBseVO[i].getApplMon().equals("")) {
					saqCostApplBseVO[i].setUpdUsrId(account.getUsr_id());
					saqCostApplBseVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqCostApplBseVO[i]);
				}
				if (insertVoList.size() > 0) {
					dbDao.addMultiCostManagementSave0170(insertVoList);
				}
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
	 * retrieving Year/Month Set for Cost Management <br>
	 * 
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostManagementCopy0170(String bse_yr, String bse_qtr_cd, SignOnUserAccount account) throws EventException {

		DBRowSet rowSet = null;
		String copyBse_yr = "";
		String copyBse_qtr_cd = "";

		try {
			String cre_usr_id = account.getUsr_id();

			rowSet = dbDao.getCostManagementPreviousCheckKey0170(bse_yr, bse_qtr_cd);
			if (rowSet.next()) {
				copyBse_yr = rowSet.getString("bse_yr");
				copyBse_qtr_cd = rowSet.getString("bse_qtr_cd");
			}
			dbDao.removeMultiCostManagementCopy0170(bse_yr, bse_qtr_cd);
			dbDao.addMultiCostManagementCopy0170(bse_yr, bse_qtr_cd, cre_usr_id, copyBse_yr, copyBse_qtr_cd);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [Year/Month Set for Cost Management] checking whether data exists or not <br>
	 * 
	 * @param bse_yr
	 * @param bse_qtr_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchCostManagementExistCheck0170(String bse_yr, String bse_qtr_cd) throws EventException {
		String check = null;
		try {
			check = dbDao.searchCostManagementExistCheck0170(bse_yr, bse_qtr_cd);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
}