/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastBCImpl.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration.MTYEquipmentForecastDBDAO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyOptionVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalRptOtrVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceCommonListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceRepoListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * -MTYEquipmentForecast Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_CIM_5001EventResponse,MTYEquipmentForecastBC
 * @since J2EE 1.6
 */
public class MTYEquipmentForecastBCImpl extends BasicCommandSupport implements MTYEquipmentForecastBC {

	// Database Access Object
	private transient MTYEquipmentForecastDBDAO dbDao = null;

	/**
	 * creating MTYEquipmentForecastBCImpl<br>
	 * creating MTYEquipmentForecastDBDAO<br>
	 */
	public MTYEquipmentForecastBCImpl() {
		dbDao = new MTYEquipmentForecastDBDAO();
	}
	/**
	 *  retrieving for  MTY Balance Data <br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceListVO> searchMtyBalanceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			mtyBalanceOptionVO.setRepoPlnYrwk(mtyBalanceOptionVO.getFcastYrwk());
			String repoPlnId= dbDao.searchRepoPlnId(mtyBalanceOptionVO);
			mtyBalanceOptionVO.setRepoPlnId(repoPlnId);
			
			return dbDao.searchMtyBalanceList(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 *  retrieving for MTY Balance reference Data <br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceReferenceListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceReferenceListVO> searchMtyBalanceReferenceList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceReferenceList(mtyBalanceOptionVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Detail Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Detail Retrieve"}).getMessage(),ex);
		}			
	}	
	
	/**
	 * saving MTY Balace data<br>
	 * 
	 * @param MtyBalanceListVO[] mtyBalanceListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMtyBalance(MtyBalanceListVO[] mtyBalanceListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<MtyBalanceListVO> insertVoList = new ArrayList<MtyBalanceListVO>();
			List<MtyBalanceListVO> updateVoList = new ArrayList<MtyBalanceListVO>();
			//String locCd  = mtyBalanceListVOs[0].getLocCd();
			//String inputYearWeek = mtyBalanceListVOs[0].getInpYrwk();
			//if ( account.getOfc_cd().length() < 6) {
				//String updateAval= validationUpdateAval(locCd,inputYearWeek,"1");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday/
				/*
				if ( updateAval.equals("1")) {
					throw new EventException(new ErrorHandler("EQR70004").getMessage());
				} else if ( updateAval.equals("2")) {
					throw new EventException(new ErrorHandler("EQR70005").getMessage());
				} else if ( updateAval.equals("3")) {
					throw new EventException(new ErrorHandler("EQR70006").getMessage());
				}
				*/
			//} else {
//				if ( !account.getOfc_cd().substring(0, 6).equals("SELCDO")) {
				/*
				if (!OfficeCodeMgr.checkContainOfficeCode("000001", "EQR", account.getOfc_cd().substring(0, 6))) {
					String updateAval= validationUpdateAval(locCd,inputYearWeek,"1");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
					if ( updateAval.equals("1")) {
						throw new EventException(new ErrorHandler("EQR70004").getMessage());
					} else if ( updateAval.equals("2")) {
						throw new EventException(new ErrorHandler("EQR70005").getMessage());
					} else if ( updateAval.equals("3")) {
						throw new EventException(new ErrorHandler("EQR70006").getMessage());
					}
				}
				*/
			//}

			for ( int i=0; i<mtyBalanceListVOs .length; i++ ) {

				int checkAddModifyMtyCnt = dbDao.checkAddModifyMtyBalance(mtyBalanceListVOs[i]);
				
				mtyBalanceListVOs[i].setCreUsrId(account.getUsr_id());
				mtyBalanceListVOs[i].setUpdUsrId(account.getUsr_id());
				mtyBalanceListVOs[i].unDataFormat();
				if ( checkAddModifyMtyCnt == 0) {
					insertVoList.add(mtyBalanceListVOs[i]);
				} else {
					updateVoList.add(mtyBalanceListVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMtyBalance(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMtyBalance(updateVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Create"}).getMessage(),ex);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Balance Report Create"}).getMessage(),ex);
		}
	}
	
	/**
	 *  retrieving for EQ Demand & Supply<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalRptOtrVO>
	 * @exception EventException
	 */
	public List<MtyBalRptOtrVO> searchMtyBalanceOtherList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceOtherList(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"OW/ On-hire Receiving Plan Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieving for yard in the ECC<br>
	 * 
	 * @param eccCd
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchYardList(String eccCd) throws EventException {

		List<MtyBalanceCommonListVO> list = null;
		try {
			list = dbDao.searchYardList(eccCd);
			return list;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"ECC Yard  Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 * retrieving for the date by week<br>
	 * 
	 * @param yearWeek
	 * @return List<MtyBalanceCommonListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceCommonListVO> searchDateListByWeek(String yearWeek) throws EventException {

		List<MtyBalanceCommonListVO> list = null;
		try {
			list = dbDao.searchDateListByWeek(yearWeek);
			return list;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
			//throw new EventException(new ErrorHandler("EQR10028", new String[]{"Check Week List   Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * saving for EQ Demand & Supply<br>
	 * 
	 * @param MtyBalRptOtrVO[] mtyBalRptOtrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyBalanceOther(MtyBalRptOtrVO[] mtyBalRptOtrVOs, SignOnUserAccount account) throws EventException
	{
		try {
			List<MtyBalRptOtrVO> insertVoList = new ArrayList<MtyBalRptOtrVO>();
			List<MtyBalRptOtrVO> updateVoList = new ArrayList<MtyBalRptOtrVO>();
			List<MtyBalRptOtrVO> deleteVoList = new ArrayList<MtyBalRptOtrVO>();

			if(mtyBalRptOtrVOs != null) {
				String locCd  = mtyBalRptOtrVOs[0].getLocCd();
				String inputYearWeek = mtyBalRptOtrVOs[0].getInpYrwk();
				if ( account.getOfc_cd().length() < 6) {
					String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
					if ( updateAval.equals("1")) {
						throw new EventException(new ErrorHandler("EQR70004").getMessage());
					} 
				} else {
//					if ( !account.getOfc_cd().substring(0, 6).equals("SELCDO")) {
					if (!OfficeCodeMgr.checkContainOfficeCode("000001", "EQR", account.getOfc_cd().substring(0, 6))) {
						String updateAval= validationUpdateAval(locCd,inputYearWeek,"2");	//message : FCST revision for accuracy evaluation only available by 17:00, Friday
						if ( updateAval.equals("1")) {
							throw new EventException(new ErrorHandler("EQR70004").getMessage());
						} 
					}
				}				
				for ( int i=0; i<mtyBalRptOtrVOs.length; i++ ) {
					if ( mtyBalRptOtrVOs[i].getIbflag().equals("I")){
						mtyBalRptOtrVOs[i].setCreUsrId(account.getUsr_id());
						mtyBalRptOtrVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(mtyBalRptOtrVOs[i]);
					} else if ( mtyBalRptOtrVOs[i].getIbflag().equals("U")){
						mtyBalRptOtrVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(mtyBalRptOtrVOs[i]);
					} else if ( mtyBalRptOtrVOs[i].getIbflag().equals("D")){
						deleteVoList.add(mtyBalRptOtrVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMtyBalanceOther(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEqStatusCodeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMtyBalanceOther(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		}
	}
	
	/**
	 *  retrieving for MTY balace plan<br>
	 * 
	 * @param MtyBalanceOptionVO mtyBalanceOptionVO
	 * @return List<MtyBalanceRepoListVO>
	 * @exception EventException
	 */
	public List<MtyBalanceRepoListVO> searchMtyBalanceRepoList(MtyBalanceOptionVO mtyBalanceOptionVO) throws EventException {
		try {
			String repoPlnId= dbDao.searchRepoPlnId(mtyBalanceOptionVO);
			mtyBalanceOptionVO.setRepoPlnId(repoPlnId);
			return dbDao.searchMtyBalanceRepoList(mtyBalanceOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition In / Out Plan Retrieve"}).getMessage(),ex);
		}
	}	


	/**
	 *  retrieving for In&Out Bound FCST Data by week<br>
	 * 
	 * @param ForecastAccuracyOptionVO forecastAccuracyOptionVO
	 * @return List<ForecastAccuracyListVO>
	 * @exception EventException
	 */
	public List<ForecastAccuracyListVO> searcForecastAccuracyList(ForecastAccuracyOptionVO forecastAccuracyOptionVO) throws EventException {
		try {
			List<ForecastAccuracyListVO> list = null;
			if ( forecastAccuracyOptionVO.getSearchFlag().equals("WEEK") ) {
				list = dbDao.searcForecastAccuracyListByWeek(forecastAccuracyOptionVO);
			} else if ( forecastAccuracyOptionVO.getSearchFlag().equals("FACTOR") ) {
				list = dbDao.searcForecastAccuracyListByFactor(forecastAccuracyOptionVO);
			}
			return list;
		} catch (DAOException ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Forecast Accuracy Review (By Week) Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 * checking updating unavilable by week and time<br>
	 * 
	 * @param String locCd
	 * @param String inputYearWeek
	 * @param String chkTypeCd
	 * @return String Y,N
	 * @exception EventException
	 */
	public String validationUpdateAval(String locCd,String inputYearWeek,String chkTypeCd) throws EventException {
		try {
			return dbDao.validationUpdateAval(locCd, inputYearWeek,chkTypeCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Check Update Week, Time Retrieve"}).getMessage(),ex);
		}
	}
	
}