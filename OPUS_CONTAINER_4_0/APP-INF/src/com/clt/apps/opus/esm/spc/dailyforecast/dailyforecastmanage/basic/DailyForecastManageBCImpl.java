/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName      : DailyforecastmanageBCImpl.java
 *@FileTitle     : Dailyforecastmanage
 *Open Issues    :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier  : 
 *@LastVersion   :  2016.04.01 체크 로직 수정 (File import 시 POL_YD/POD_YD 5자리이면 alert 메세지)

=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration.DailyForecastManageDBDAO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistoryOfcListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastSrepAccountManageListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDlyFctSplListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SpcOfcLvlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpcDlyFcastCustVO;
//import com.clt.syscommon.common.table.SpcSlsRepCustMapgVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SpcSlsRepCustMapgNewVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;

/**
 * DailyForecast Business Logic Basic Command implementation<br>
 * - handling business transaction for DailyForecast<br>
 * 
 * @author 
 * @see ESM_SPC_0103EventResponse,DailyforecastmanageBC (Reference DAO Class of each)
 * @since J2EE 1.6
 */
public class DailyForecastManageBCImpl extends BasicCommandSupport implements DailyForecastManageBC { 

	// Database Access Object
	private transient DailyForecastManageDBDAO dbDao = null;

	/**
	 * DailyforecastmanageBCImpl Object Creation<br>
	 * DailyforecastmanageDBDAO Object creation.<br>
	 */
	public DailyForecastManageBCImpl() {
		dbDao = new DailyForecastManageDBDAO();
	}

	/**
	 * EsmSpc0103Event retrieve event process<br>
	 * forecast srep account retrieve<br>
	 * 
	 * @author
	 * @param dailyforecastmanageConditionVO DailyforecastmanageConditionVO
	 *            
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastSrepAccountManageList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException {
		try {

			List<SearchDailyForecastSrepAccountManageListVO> voList = dbDao.searchDailyForecastSrepAccountManageList(dailyforecastmanageConditionVO);
			DailyforecastmanageMainVO main = new DailyforecastmanageMainVO();
			main.setVoList(voList);

			List<DailyforecastmanageMainVO> mainList = new ArrayList<DailyforecastmanageMainVO>();
			mainList.add(main);

			return mainList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * EsmSpc0103Event save event process<br>
	 * forecast srep account save<br>
	 * 
	 * @param spcSlsRepCustMapgVO SpcSlsRepCustMapgVO [] 
	 * @param account  SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForecastSrepAccountManage(SpcSlsRepCustMapgNewVO[] spcSlsRepCustMapgVO, SignOnUserAccount account) throws EventException {
		try {
			List<SpcSlsRepCustMapgNewVO> insertVoList = new ArrayList<SpcSlsRepCustMapgNewVO>();
			List<SpcSlsRepCustMapgNewVO> updateVoList = new ArrayList<SpcSlsRepCustMapgNewVO>();
			List<SpcSlsRepCustMapgNewVO> deleteVoList = new ArrayList<SpcSlsRepCustMapgNewVO>();		
			log.debug("start multiDailyForecastSrepAccountManage");
			for (int i = 0; i < spcSlsRepCustMapgVO.length; i++) {				
				if (spcSlsRepCustMapgVO[i].getIbflag().equals("I")) {
					spcSlsRepCustMapgVO[i].setCreUsrId(account.getUsr_id());
					spcSlsRepCustMapgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(spcSlsRepCustMapgVO[i]);
				} else if (spcSlsRepCustMapgVO[i].getIbflag().equals("U")) {					
					spcSlsRepCustMapgVO[i].setCreUsrId(account.getUsr_id());
					spcSlsRepCustMapgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(spcSlsRepCustMapgVO[i]);
				} else if (spcSlsRepCustMapgVO[i].getIbflag().equals("D")) {
					deleteVoList.add(spcSlsRepCustMapgVO[i]);
				}
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.removemultiDailyForecastSrepAccountManageS(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addmultiDailyForecastSrepAccountManageS(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifymultiDailyForecastSrepAccountManageS(updateVoList);
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
	 * EsmSpc0104Event retrieve event process<br>
	 * forecast history list retrieve<br>
	 * 
	 * @author
	 * @param dailyforecastmanageConditionVO DailyforecastmanageConditionVO
	 *            
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastHistoryOfcList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException {
		try {
			String vslcd = "";
			String skdvoyno = "";
			String skddircd = "";
			String ofckndcd = "";

			String vvd = dailyforecastmanageConditionVO.getVvd();
			String salesOffice = dailyforecastmanageConditionVO.getSalesOffice();
			String subOffice = dailyforecastmanageConditionVO.getSubOffice();

			if (vvd.length() > 0) {
				vslcd = vvd.substring(0, 4);
				skdvoyno = vvd.substring(4, 8);
				skddircd = vvd.substring(8);
				dailyforecastmanageConditionVO.setVslcd(vslcd);
				dailyforecastmanageConditionVO.setSkdvoyno(skdvoyno);
				dailyforecastmanageConditionVO.setSkddircd(skddircd);
			}
			if (salesOffice.length() > 0 && subOffice.length() == 0) {
				ofckndcd = "3";
				dailyforecastmanageConditionVO.setOfckndcd(ofckndcd);
			}
			if (subOffice.length() > 0 && salesOffice.length() == 0 || subOffice.length() > 0 && salesOffice.length() > 0) {
				ofckndcd = "4";
				dailyforecastmanageConditionVO.setOfckndcd(ofckndcd);
			}

			List<SearchDailyForecastHistoryOfcListVO> historyOfcList = dbDao.searchDailyForecastHistoryOfcList(dailyforecastmanageConditionVO);
			DailyforecastmanageMainVO main = new DailyforecastmanageMainVO();
			main.setHistoryOfcList(historyOfcList);

			List<DailyforecastmanageMainVO> mainList = new ArrayList<DailyforecastmanageMainVO>();
			mainList.add(main);

			return mainList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * EsmSpc0104Event retrieve event process<br>
	 * forecast history info retrieve<br>
	 * 
	 * @author
	 * @param dailyforecastmanageConditionVO DailyforecastmanageConditionVO
	 *            
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastHistorySrepAcctList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException {
		try {
			String vslcd = "";
			String skdvoyno = "";
			String skddircd = "";
			String custcntcd = "";
			String custseq = "";

			String vvd = dailyforecastmanageConditionVO.getVvd();
			String customer = dailyforecastmanageConditionVO.getCustomer();

			if (vvd.length() > 0) {
				vslcd = vvd.substring(0, 4);
				skdvoyno = vvd.substring(4, 8);
				skddircd = vvd.substring(8);
				dailyforecastmanageConditionVO.setVslcd(vslcd);
				dailyforecastmanageConditionVO.setSkdvoyno(skdvoyno);
				dailyforecastmanageConditionVO.setSkddircd(skddircd);
			}
			if (customer.length() > 0) {
				custcntcd = customer.substring(0, 2);
				custseq = customer.substring(2);
				dailyforecastmanageConditionVO.setCustcntcd(custcntcd);
				dailyforecastmanageConditionVO.setCustseq(custseq);
			}

			List<SearchDailyForecastHistorySrepAcctListVO> serpAcctList = dbDao.searchDailyForecastHistorySrepAcctList(dailyforecastmanageConditionVO);
			DailyforecastmanageMainVO main = new DailyforecastmanageMainVO();
			main.setSerpAcctList(serpAcctList);

			List<DailyforecastmanageMainVO> mainList = new ArrayList<DailyforecastmanageMainVO>();
			mainList.add(main);

			return mainList;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * EsmSpc0102Event retrieve event process<br>
	 * daily forecast manage retrieve<br>
	 * 
	 * @author
	 * @param conditionVO ConditionVO
	 *            
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForecastManageListVO> searchDailyForecastManage2List(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDailyForecastManage2List(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EsmSpc0102Event save event process<br>
	 * daily forecast manage save<br>
	 * 	
	 * @param spcDlyFcastCustVO SpcDlyFcastCustVO[] 
	 * @param account  SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForecastManage2(SpcDlyFcastCustVO[] spcDlyFcastCustVO, SignOnUserAccount account) throws EventException {
		try {
			List<SpcDlyFcastCustVO> insertVoList = new ArrayList<SpcDlyFcastCustVO>();
			List<SpcDlyFcastCustVO> updateVoList = new ArrayList<SpcDlyFcastCustVO>();
			List<SpcDlyFcastCustVO> deleteVoList = new ArrayList<SpcDlyFcastCustVO>();			
			
			for (int i = 0; i < spcDlyFcastCustVO.length; i++) {
				if (spcDlyFcastCustVO[i].getIbflag().equals("I") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")) {
					spcDlyFcastCustVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(spcDlyFcastCustVO[i]);

					if (spcDlyFcastCustVO[i].getPodYdCd().equals("")) {
						deleteVoList.add(spcDlyFcastCustVO[i]);
					}
				} else if (spcDlyFcastCustVO[i].getIbflag().equals("U") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")) {
					spcDlyFcastCustVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(spcDlyFcastCustVO[i]);
				} else if (spcDlyFcastCustVO[i].getIbflag().equals("D") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")) {
					deleteVoList.add(spcDlyFcastCustVO[i]);
				}
			}

			if (insertVoList.size() > 0) {				
				dbDao.addmultiSpcDlyFcastCustS(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifymultiSpcDlyFcastCustS(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removemultiSpcDlyFcastCustS(deleteVoList);
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
	 * EsmSpc0102Event save event process
	 * daily forecast history save
	 * 
	 * @param conditionVO ConditionVO 
	 * @param SignOnUserAccount account            
	 * @exception EventException
	 */
	public void multiDailyForcastForHistory(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<SpcDlyFcastCustVO> updateVoList = new ArrayList<SpcDlyFcastCustVO>();

			String vvdList = conditionVO.getVvdList();
			String salesRepCodeList = conditionVO.getSalesRepCodeList();

			String[] vvdListArr = (vvdList.replace('|', ',')).split(",");
			String[] salesRepCodeListArr = (salesRepCodeList.replace('|', ',')).split(",");

			for (int j = 0; j < vvdListArr.length; j++) {
				if (!"".equals(vvdListArr[j])) {
					for (int k = 0; k < salesRepCodeListArr.length; k++) {
						if (!"".equals(salesRepCodeListArr[k])) {
							SpcDlyFcastCustVO spcDlyFcastCustVO = new SpcDlyFcastCustVO();
							spcDlyFcastCustVO.setVslCd(vvdListArr[j].substring(0, 4));
							spcDlyFcastCustVO.setSkdVoyNo(vvdListArr[j].substring(4, 8));
							spcDlyFcastCustVO.setSkdDirCd(vvdListArr[j].substring(8));
							spcDlyFcastCustVO.setIocCd(conditionVO.getIoc());
							spcDlyFcastCustVO.setSrepUsrId(salesRepCodeListArr[k]);
							spcDlyFcastCustVO.setUpdUsrId(account.getUsr_id());
							updateVoList.add(spcDlyFcastCustVO);
						}
					}
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifymultiSpcDlyFcastCust2(updateVoList);
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
	 * search event process
	 * 	  	
	 * @return
	 * @exception EventException
	 */
	public List<SpcOfcLvlVO> searchOfcLvlList() throws EventException {
		try {
			return dbDao.searchOfcLvlList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EsmSpc0100Event save event process<br>
	 * office level manage save<br>
	 * 	
	 * @exception EventException
	 */
	@Override
	public void multiOfficeLevelManage() throws EventException {
		try {
			dbDao.removeMultiOfficeLevelManage();
			dbDao.addMultiOfficeLevelManage();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * EsmSpc9010Event retrieve event process<br>
	 * daily forecast manage retrieve<br>
	 * 
	 * @author
	 * @param conditionVO ConditionVO
	 *            
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchDlyFctSplListVO> searchDailyForecastManage3List(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDailyForecastManage3List(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EsmSpc9010Event retrieve event process<br>
	 * daily forecast manage retrieve<br>
	 * 
	 * @author
	 * @param conditionVO ConditionVO
	 *            
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchDlyFctSplListVO> searchDailyForecastTemplateList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDailyForecastTemplateList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EsmSpc9010Event save event process<br>
	 * daily forecast manage save<br>
	 * 	 
	 * @param dlyFctInpListVO DlyFctInpListVO [] 
	 * @param account  SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForecastManage3(DlyFctInpListVO[] dlyFctInpListVO, SignOnUserAccount account) throws EventException {
		try {
			List<DlyFctInpListVO> insertVoList = new ArrayList<DlyFctInpListVO>();
			// String tradeYn = "";
			// String subTradeYn = "";
			// String rLane = "";
//			String slsOfcCdYn = "";
//			String csCstCdYn = "";
//			String polPodCdYn = "";
//			String vvdCdYn = "";
//			String polCdYn = "";
//			String podCdYn = "";
//			String polDblYn = "";

			for (int i = 0; i < dlyFctInpListVO.length; i++) {
				//if (dlyFctInpListVO[i].getIbflag().equals("I") && !dlyFctInpListVO[i].getVslCd().equals("TTL")) {
					dlyFctInpListVO[i].setUpdUsrId(account.getUsr_id());
					/*
					 * // tradeYn = dbDao.searchTradeCheck(spcDlyFcastCustVO[i]); // subTradeYn = dbDao.searchSubTradeCheck(spcDlyFcastCustVO[i]); // rLane = dbDao.searchRlaneCheck(spcDlyFcastCustVO[i]);
					 * 
					 * vvdCdYn = dbDao.searchVvdCdCheck(dlyFctInpListVO[i]); //VVD Check
					 * 
					 * if("N".equals(vvdCdYn)) { throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong VVD Code : ["+dlyFctInpListVO[i].getVslCd() + dlyFctInpListVO[i].getSkdVoyNo() + dlyFctInpListVO[i].getSkdDirCd() + "]"}).getMessage()); }
					 * 
					 * if(dlyFctInpListVO[i].getSrepUsrId().length() != 0){ slsOfcCdYn = dbDao.searchOfficeMapgCheck(dlyFctInpListVO[i]); }
					 * 
					 * if("N".equals(slsOfcCdYn)) { throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Sales Office Code, Sales Rep Code : ["+dlyFctInpListVO[i].getFcastOfcCd() + "," + dlyFctInpListVO[i].getSrepUsrId() + "]"}).getMessage()); }
					 * 
					 * csCstCdYn = dbDao.searchCsCstCdCheck(dlyFctInpListVO[i]); //Customer Check
					 * 
					 * if("N".equals(csCstCdYn)) { throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Customer Code : ["+dlyFctInpListVO[i].getCustCntCd() + "/"+ dlyFctInpListVO[i].getCustSeq() + "]"}).getMessage()); }
					 * 
					 * polPodCdYn = dbDao.searchPolPodCdCheck(dlyFctInpListVO[i]); //POL, POD Skip Check
					 * 
					 * if("N".equals(polPodCdYn)) { throw new EventException(new ErrorHandler("COM12114", new String[]{"VVD SKIP POL/POD Code : ["+ dlyFctInpListVO[i].getVslCd() + dlyFctInpListVO[i].getSkdVoyNo() + dlyFctInpListVO[i].getSkdDirCd() +"/" + dlyFctInpListVO[i].getPolYdCd() + "/" + dlyFctInpListVO[i].getPodYdCd() + "]"}).getMessage()); }
					 * 
					 * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// String strPol = dlyFctInpListVO[i].getPolYdCd();
					 * 
					 * String strPod = ""; if(dlyFctInpListVO[i].getPodYdCd().length() != 0){ strPod = dlyFctInpListVO[i].getPodYdCd(); }
					 * 
					 * // POL Only check : exist, double calling YN if(strPol.length() == 5 && strPod.length() == 0){ polCdYn = dbDao.searchPolCdCheck(dlyFctInpListVO[i]); //POL Exist Check polDblYn = dbDao.searchPolDblCheck(dlyFctInpListVO[i]); //POL double calling YN }
					 * 
					 * // POL YD_CD Only check : exist, double calling YN if(strPol.length() == 7 && strPod.length() == 0){ polCdYn = dbDao.searchPolYdCdCheck(dlyFctInpListVO[i]); //POL Exist Check polDblYn = dbDao.searchPolYDDblCheck(dlyFctInpListVO[i]); //POL double calling YN }
					 * 
					 * if("N".equals(polDblYn)) { throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong POL Code : ["+dlyFctInpListVO[i].getPodYdCd() + "]"}).getMessage()); }
					 * 
					 * // POL, POD check : Pol exist, Pod exist & sequence if(strPol.length() == 5){ polCdYn = dbDao.searchPolCdCheck(dlyFctInpListVO[i]); //POL Exist Check
					 * 
					 * if(strPod.length() == 5){ podCdYn = dbDao.searchPodCdCheck(dlyFctInpListVO[i]); //POD Exist & sequence }
					 * 
					 * if(strPod.length() == 7){ podCdYn = dbDao.searchPodYDCdCheck(dlyFctInpListVO[i]); //POD_YD_CD Exist & sequence } }
					 * 
					 * // POL, POD YD_CD check : Pol exist, Pod exist & sequence if(strPol.length() == 7){ polCdYn = dbDao.searchPolYdCdCheck(dlyFctInpListVO[i]); //POL_YD_CD Exist Check
					 * 
					 * if(strPod.length() == 5){ podCdYn = dbDao.searchPodCdCheck(dlyFctInpListVO[i]); //POD Exist & sequence }
					 * 
					 * if(strPod.length() == 7){ podCdYn = dbDao.searchPodYDCdCheck(dlyFctInpListVO[i]); //POD_YD_CD & sequence } }
					 * 
					 * if("N".equals(polCdYn)) { throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong POL Code, Sales Office Code  : ["+dlyFctInpListVO[i].getPolYdCd() + "," + dlyFctInpListVO[i].getFcastOfcCd() + "]"}).getMessage()); }
					 * 
					 * if("N".equals(podCdYn)) { throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong POD Code : ["+dlyFctInpListVO[i].getPodYdCd() + "]"}).getMessage()); } ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					 * 
					 * // if("N".equals(tradeYn)) { // throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Trade Code : ["+dlyFctInpListVO[i].getTrdCd() + "]"}).getMessage()); // } // // if("N".equals(subTradeYn)) { // throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Sub Trade Code : ["+dlyFctInpListVO[i].getSubTrdCd() + "]"}).getMessage()); // } // // if("N".equals(rLane)) { // throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Revenue Lane Code : ["+dlyFctInpListVO[i].getRlaneCd() + "]"}).getMessage()); // }
					 */

					insertVoList.add(dlyFctInpListVO[i]);
				}
			//}

			if (insertVoList.size() > 0) {
				dbDao.multiSpcFileImptDlyFct(insertVoList);
				dbDao.multiSpcFileImptCustMapg(insertVoList);
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
	 * EsmSpc9010Event retrieve event process<br>
	 * daily forecast file import validation check<br>
	 * 
	 * @author
	 * @param dlyFctInpListVO DlyFctInpListVO
	 *            
	 * @return List<DlyFctInpListVO>
	 * @exception EventException
	 */
	public List<DlyFctInpListVO> checkFileImportList(DlyFctInpListVO[] dlyFctInpListVO) throws EventException {
		try {
			List<DlyFctInpListVO> rtnList = new ArrayList<DlyFctInpListVO>();
			List<DlyFctInpListVO> chkList = new ArrayList<DlyFctInpListVO>();
			// String tradeYn = "";
			// String subTradeYn = "";
			// String rLane = "";
			String slsOfcCdYn = "";
			//String ofcLvlYn = "";			
			String csCstCdYn = "";
			String polPodCdYn = "";
			String vvdCdYn = "";
			String polCdYn = "";
			String podCdYn = "";
			String polDblYn = "";
			String polPodCntiYn = "";
			

			for (int i = 0; i < dlyFctInpListVO.length; i++) {
				//if (dlyFctInpListVO[i].getIbflag().equals("I") && !dlyFctInpListVO[i].getVslCd().equals("TTL")) {
					chkList = dbDao.searchYrWKCheck(dlyFctInpListVO[i]); // Year Week Check					
					
					if(!chkList.isEmpty()){
						//입력된 Year Week 가 실제 정보와 상이할 경우 값을 변경하고 화면에 빨간 글씨로 표시한다.
						if(!dlyFctInpListVO[i].getSlsYrmon().equals(chkList.get(0).getSlsYrmon()) && !dlyFctInpListVO[i].getCostWk().equals(chkList.get(0).getCostWk())){
							dlyFctInpListVO[i].setDateChk("YW");
						} else if(!dlyFctInpListVO[i].getSlsYrmon().equals(chkList.get(0).getSlsYrmon())){
							dlyFctInpListVO[i].setDateChk("Y");
						} else if(!dlyFctInpListVO[i].getCostWk().equals(chkList.get(0).getCostWk())){
							dlyFctInpListVO[i].setDateChk("W");
						} else {
							dlyFctInpListVO[i].setDateChk("N");
						}
						
						dlyFctInpListVO[i].setSlsYrmon(chkList.get(0).getSlsYrmon());
						dlyFctInpListVO[i].setCostWk(chkList.get(0).getCostWk());
					} else {
						dlyFctInpListVO[i].setDateChk("YW");						
					}
					
					String strRemark = "";
					// tradeYn = dbDao.searchTradeCheck(spcDlyFcastCustVO[i]);
					// subTradeYn = dbDao.searchSubTradeCheck(spcDlyFcastCustVO[i]);
					// rLane = dbDao.searchRlaneCheck(spcDlyFcastCustVO[i]);

					vvdCdYn = dbDao.searchVvdCdCheck(dlyFctInpListVO[i]); // VVD Check

					if ("N".equals(vvdCdYn)) {
						strRemark += "[VVD] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong VVD Code : ["+dlyFctInpListVO[i].getVslCd() + dlyFctInpListVO[i].getSkdVoyNo() + dlyFctInpListVO[i].getSkdDirCd() + "]"}).getMessage());
					} else if("D".equals(vvdCdYn)) {
						strRemark += "[VVD Duplicate] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong VVD Code : ["+dlyFctInpListVO[i].getVslCd() + dlyFctInpListVO[i].getSkdVoyNo() + dlyFctInpListVO[i].getSkdDirCd() + "]"}).getMessage());
					} 

					if (dlyFctInpListVO[i].getSrepUsrId().length() != 0) {
						slsOfcCdYn = dbDao.searchOfficeMapgCheck(dlyFctInpListVO[i]);
					}

					if ("N".equals(slsOfcCdYn)) {
						strRemark += "[Sales Office/Sales Rep] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Sales Office Code, Sales Rep Code : ["+dlyFctInpListVO[i].getFcastOfcCd() + "," + dlyFctInpListVO[i].getSrepUsrId() + "]"}).getMessage());
					}
					
//					if (dlyFctInpListVO[i].getFcastOfcCd().length() != 0) {
//						ofcLvlYn = dbDao.searchOfficeLvlCheck(dlyFctInpListVO[i]);
//					}
//
//					if ("N".equals(ofcLvlYn)) {
//						strRemark += "[Sales Office Level] ";
//						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Sales Office Code, Sales Rep Code : ["+dlyFctInpListVO[i].getFcastOfcCd() + "," + dlyFctInpListVO[i].getSrepUsrId() + "]"}).getMessage());
//					}
					
					csCstCdYn = dbDao.searchCsCstCdCheck(dlyFctInpListVO[i], "G1"); // Customer Check

					if ("N".equals(csCstCdYn)) {
						strRemark += "[Customer] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Customer Code : ["+dlyFctInpListVO[i].getCustCntCd() + "/"+ dlyFctInpListVO[i].getCustSeq() + "]"}).getMessage());
					}
					
					//20160203.ADD : SC/RFA 검증 SKIP
					if(dlyFctInpListVO[i].getCtrtCustCntCd().length() != 0) {
						csCstCdYn = dbDao.searchCsCstCdCheck(dlyFctInpListVO[i], "G2"); // Contract Customer Check

						if ("N".equals(csCstCdYn)) {
							strRemark += "[Contract Customer] ";
							// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Customer Code : ["+dlyFctInpListVO[i].getCustCntCd() + "/"+ dlyFctInpListVO[i].getCustSeq() + "]"}).getMessage());
						}	
					}
//					polPodCdYn = dbDao.searchPolPodCdCheck(dlyFctInpListVO[i]); // POL, POD Skip Check
//
//					if ("N".equals(polPodCdYn)) {
//						strRemark += "[VVD SKIP] ";
//						// throw new EventException(new ErrorHandler("COM12114", new String[]{"VVD SKIP POL/POD Code : ["+ dlyFctInpListVO[i].getVslCd() + dlyFctInpListVO[i].getSkdVoyNo() + dlyFctInpListVO[i].getSkdDirCd() +"/" + dlyFctInpListVO[i].getPolYdCd() + "/" + dlyFctInpListVO[i].getPodYdCd() + "]"}).getMessage());
//					}

					// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					String strPol = dlyFctInpListVO[i].getPolYdCd();

					String strPod = "";
					if (dlyFctInpListVO[i].getPodYdCd().length() != 0) {
						strPod = dlyFctInpListVO[i].getPodYdCd();
					}

					// POL Only check : exist, double calling YN
					if (strPol.length() == 5 && strPod.length() == 0) {
						strRemark += "[You should input 7 digits for POL Yard.] ";
//						polCdYn = dbDao.searchPolCdCheck(dlyFctInpListVO[i]); // POL Exist Check
//						polDblYn = dbDao.searchPolDblCheck(dlyFctInpListVO[i]); // POL double calling YN
					}

					// POL YD_CD Only check : exist, double calling YN
					if (strPol.length() == 7 && strPod.length() == 0) {
						polCdYn = dbDao.searchPolYdCdCheck(dlyFctInpListVO[i]); // POL Exist Check
						polDblYn = dbDao.searchPolYDDblCheck(dlyFctInpListVO[i]); // POL double calling YN
					}

					if ("N".equals(polDblYn)) {
						strRemark += "[You need to input POD Yard because POL is  Double Calling Port.  ] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong POL Code : ["+dlyFctInpListVO[i].getPodYdCd() + "]"}).getMessage());
					}

					// POL, POD check : Pol exist, Pod exist & sequence
					if (strPol.length() == 5) {
						strRemark += "[You should input 7 digits for POL Yard.] ";
//						polCdYn = dbDao.searchPolCdCheck(dlyFctInpListVO[i]); // POL Exist Check
//						polPodCntiYn = dbDao.searchPolPodCntiCheck(dlyFctInpListVO[i]); // POL POD CONTI Check

						if (strPod.length() == 5) {
							strRemark += "[You should input 7 digits for POD Yard.] ";
//							podCdYn = dbDao.searchPodCdCheck(dlyFctInpListVO[i]); // POD Exist & sequence
						}

//						if (strPod.length() == 7) {
//							podCdYn = dbDao.searchPodYDCdCheck(dlyFctInpListVO[i]); // POD_YD_CD Exist & sequence
//						}
					}

					// POL, POD YD_CD check : Pol exist, Pod exist & sequence
					if (strPol.length() == 7) {
						polCdYn = dbDao.searchPolYdCdCheck(dlyFctInpListVO[i]); // POL_YD_CD Exist Check
						polPodCntiYn = dbDao.searchPolPodCntiCheck(dlyFctInpListVO[i]); // POL POD CONTI Check
						polPodCdYn = dbDao.searchPolPodCdCheck(dlyFctInpListVO[i]); // POL, POD Skip Check

						if (strPod.length() == 5) {
							strRemark += "[You should input 7 digits for POD Yard.] ";
//							podCdYn = dbDao.searchPodCdCheck(dlyFctInpListVO[i]); // POD Exist & sequence
						}

						if (strPod.length() == 7) {
							podCdYn = dbDao.searchPodYDCdCheck(dlyFctInpListVO[i]); // POD_YD_CD & sequence
						}
					}

					if ("N".equals(polCdYn)) {
						strRemark += "[POL/Sales Office] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong POL Code, Sales Office Code  : ["+dlyFctInpListVO[i].getPolYdCd() + "," + dlyFctInpListVO[i].getFcastOfcCd() + "]"}).getMessage());
					}
					
					if ("N".equals(polPodCdYn)) {
						strRemark += "[POL/POD SKIP] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"VVD SKIP POL/POD Code : ["+ dlyFctInpListVO[i].getVslCd() + dlyFctInpListVO[i].getSkdVoyNo() + dlyFctInpListVO[i].getSkdDirCd() +"/" + dlyFctInpListVO[i].getPolYdCd() + "/" + dlyFctInpListVO[i].getPodYdCd() + "]"}).getMessage());
					}

					if ("N".equals(podCdYn)) {
						strRemark += "[POD] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong POD Code : ["+dlyFctInpListVO[i].getPodYdCd() + "]"}).getMessage());
					}

					if ("N".equals(polPodCntiYn)) {
						strRemark += "[POL/POD CONTI] ";
						// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong POD Code : ["+dlyFctInpListVO[i].getPodYdCd() + "]"}).getMessage());
					}
					// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					// if("N".equals(tradeYn)) {
					// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Trade Code : ["+dlyFctInpListVO[i].getTrdCd() + "]"}).getMessage());
					// }
					//
					// if("N".equals(subTradeYn)) {
					// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Sub Trade Code : ["+dlyFctInpListVO[i].getSubTrdCd() + "]"}).getMessage());
					// }
					//
					// if("N".equals(rLane)) {
					// throw new EventException(new ErrorHandler("COM12114", new String[]{"Wrong Revenue Lane Code : ["+dlyFctInpListVO[i].getRlaneCd() + "]"}).getMessage());
					// }

					if (strRemark.length() > 0) {
						dlyFctInpListVO[i].setRemark("Wrong " + strRemark);
					} else {
						dlyFctInpListVO[i].setRemark("");
					}

					rtnList.add(dlyFctInpListVO[i]);
				}
			//}

			return rtnList;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
}