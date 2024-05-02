/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanBCImpl.java
*@FileTitle : Long Term Lease CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration.LeasePlanDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanPerformanceDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePerformanceVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanRccVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanSearchVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.PlanSearchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LseOffhPlnVO;

/**
 * ALPS-ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * - ALPS-ContainerLeaseMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Nho Jung Yong
 * @see UI_LSE_0048EventResponse,LeasePlanBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class LeasePlanBCImpl extends BasicCommandSupport implements LeasePlanBC {

	// Database Access Object
	private transient LeasePlanDBDAO dbDao = null;

	/**
	 * LeasePlanBCImpl 객체 생성<br>
	 * LeasePlanDBDAO를 생성한다.<br>
	 */
	public LeasePlanBCImpl() {
		dbDao = new LeasePlanDBDAO();
	}

	/**
	 * Long Term Lease CNTR Delivery Plan 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanVO>
	 * @exception EventException
	 */
	public List<LeasePlanVO> searchLongTermCNTRDeliveryPlanBasic(PlanSearchVO planSearchVO) throws EventException {
		int cnt = 0;                       // 조회 데이터 총카운트
		List<LeasePlanVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			cnt       = dbDao.searchLongTermCNTRDeliveryPlanListCountData(planSearchVO);
			resultVOs = dbDao.searchLongTermCNTRDeliveryPlanListData(planSearchVO);

			if ( resultVOs.size() > 0 ) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Long Term Delivery Plan Search"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Long Term Delivery Plan Search"}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 *  Long Term Lease Delivery Plan 데이타 건수 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return int
	 * @exception EventException
	 */
	public int searchLongTermCNTRDeliveryPlanAgreementCheckBasic(PlanSearchVO planSearchVO) throws EventException {
		int cnt = 0;                       // 조회 데이터 총카운트

		try {
			cnt = dbDao.searchLongTermCNTRDeliveryPlanListCountData(planSearchVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Lease Agreement Check"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Lease Agreement Check"}).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * Long Term Lease Delivery Performance 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceVO>
	 * @exception EventException
	 */
	public List<LeasePlanPerformanceVO> searchLongTermCNTRDeliveryPerformanceBasic(PlanSearchVO planSearchVO) throws EventException {
		List<LeasePlanPerformanceVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchLongTermCNTRDeliveryPerformanceListData(planSearchVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Long Term Delivery Plan and Performance Search"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Long Term Delivery Plan and Performance Search"}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * Long Term Lease CNTR Delivery Plan & Performance 화면의 Container Detail 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceDetailVO>
	 * @exception EventException
	 */
	public List<LeasePlanPerformanceDetailVO> searchLongTermCNTRDeliveryPerformanceDetailBasic(PlanSearchVO planSearchVO) throws EventException {
		List<LeasePlanPerformanceDetailVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchLongTermCNTRDeliveryPerformanceDetailData(planSearchVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Long Term Delivery Plan and Performance Container Detail Search"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Long Term Delivery Plan and Performance Container Detail Search"}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * Long Term Lease CNTR Delivery Plan 데이터 저장합니다.<br>
	 *
	 * @param PlanSearchVO planSearchVO
	 * @param LeasePlanVO[] leasePlanVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLongTermCNTRDeliveryPlanBasic(PlanSearchVO planSearchVO, LeasePlanVO[] leasePlanVOs, SignOnUserAccount account) throws EventException{
		try {
			List<LeasePlanVO> insertVoList  = new ArrayList<LeasePlanVO>();
			List<LeasePlanVO> updateVoList  = new ArrayList<LeasePlanVO>();
			List<LeasePlanVO> deleteVoList  = new ArrayList<LeasePlanVO>();
			List<LeasePlanVO> deleteVoList2 = new ArrayList<LeasePlanVO>();
			int cnt = 0;

			if ( planSearchVO.getExcelFlg().equals("Y") ) {
				/* 전체 Data 삭제 */
				LeasePlanVO delVO = new LeasePlanVO();

				delVO.setPlnYr(planSearchVO.getPlnYr());
				delVO.setAgmtCtyCd(planSearchVO.getAgmtCtyCd());
				delVO.setAgmtSeq(planSearchVO.getAgmtSeq());

				deleteVoList2.add(delVO);

				for ( int i = 0 ; i < leasePlanVOs.length ; i++ ) {
					leasePlanVOs[i].setCreUsrId(account.getUsr_id());
					leasePlanVOs[i].setInsertSeq(String.valueOf(cnt++));
					insertVoList.add(leasePlanVOs[i]);
				}
			} else {
				for ( int i = 0 ; i < leasePlanVOs.length ; i++ ) {
					if ( leasePlanVOs[i].getIbflag().equals("I") ) {
						//기존 데이터 존재 여부에 따라 delete 후 insert
						List<LeasePlanVO> voList = dbDao.searchLongTermCNTRDeliveryPlanData(leasePlanVOs[i]);

						if ( voList.size() > 0 ) {
							deleteVoList.add(leasePlanVOs[i]);
						}

						leasePlanVOs[i].setCreUsrId(account.getUsr_id());
						leasePlanVOs[i].setInsertSeq(String.valueOf(cnt++));
						insertVoList.add(leasePlanVOs[i]);
					} else if ( leasePlanVOs[i].getIbflag().equals("U")){
						leasePlanVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(leasePlanVOs[i]);
					} else if ( leasePlanVOs[i].getIbflag().equals("D")){
						deleteVoList.add(leasePlanVOs[i]);
					}
				}
			}

			if ( deleteVoList2.size() > 0 ) {
				dbDao.removeAllLongTermCNTRDeliveryPlansData(deleteVoList2);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLongTermCNTRDeliveryPlansData(deleteVoList);
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addLongTermCNTRDeliveryPlansData(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyLongTermCNTRDeliveryPlansData(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Long Term Delivery Plan Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Long Term Delivery Plan Save"}).getMessage(), ex);
		}
	}

	/**
	 * Off-Hire Plan Input &amp; Update by H/Q 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePlanVO>
	 * @exception EventException
	 */
	public List<OffHirePlanVO> searchOffHirePlanBasic(OffHirePlanSearchVO offHirePlanSearchVO) throws EventException {
		List<OffHirePlanVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchOffHirePlanData(offHirePlanSearchVO);

			//if ( resultVOs.size() < 1 ) {
			//	new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			//}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by H/Q Search"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by H/Q Search"}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * Off-Hire Plan Input &amp; Update by H/Q 데이터 저장합니다.<br>
	 *
	 * @param OffHirePlanVO[] offHirePlanVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOffHirePlanBasic(OffHirePlanVO[] offHirePlanVOs, SignOnUserAccount account) throws EventException {
		try {
			List<LseOffhPlnVO> insertVoList = new ArrayList<LseOffhPlnVO>();
			List<LseOffhPlnVO> deleteVoList = new ArrayList<LseOffhPlnVO>();

			int		offhVerMaxSeq	= 0;
			String	sLstmCd			= "";

			for ( int i = 0; i < offHirePlanVOs.length; i++ ) {
				if ( offHirePlanVOs[i].getIbflag().equals("I") ) {
					/* 저장 처리 전 Off-Hire Plan 의 Max Version Sequence 채번 */
					OffHirePlanSearchVO searchOffHirePlanVO = new OffHirePlanSearchVO();

					if ( offHirePlanVOs != null && offHirePlanVOs.length > 0 ) {
						searchOffHirePlanVO.setPlnYr(offHirePlanVOs[0].getPlnYr());
						searchOffHirePlanVO.setOffhPlnTpCd(offHirePlanVOs[0].getOffhPlnTpCd());
						searchOffHirePlanVO.setOffhLocTpCd(offHirePlanVOs[0].getOffhLocTpCd());
					}

					if ( i == 0 ) {
						offhVerMaxSeq = dbDao.searchOffHirePlanMaxVersionData(searchOffHirePlanVO);
					}

					/* 채번된 Max Version Sequence 를 처리할 VO 에 Setting */
					offHirePlanVOs[i].setOffhVerSeq(offhVerMaxSeq+"");
					offHirePlanVOs[i].setCreUsrId(account.getUsr_id());
					offHirePlanVOs[i].setUpdUsrId(account.getUsr_id());

					//if ( i == 0 ) {
					//	/* Max Version Sequence Data 를 삭제용 VO List 에 추가 */
					//	makeRemoveLseOffhPlnBasic(offHirePlanVOs[i], offHirePlanVOs[i].getIbflag(), deleteVoList);
					//}
					/* Term 별로 삭제 처리. 2009.11.09 정필성 차장 요청 */
					if ( !sLstmCd.equals(offHirePlanVOs[i].getLstmCd()) ) {
						/* Max Version Sequence Data 를 삭제용 VO List 에 추가 */
						makeRemoveLseOffhPlnBasic(offHirePlanVOs[i], offHirePlanVOs[i].getIbflag(), deleteVoList);

						sLstmCd = offHirePlanVOs[i].getLstmCd();
					}

					/* Max Version Sequence Data 를 입력용 VO List 에 추가 */
					makeAddLseOffhPlnBasic(offHirePlanVOs[i], insertVoList);
				} else if ( offHirePlanVOs[i].getIbflag().equals("U") ) {
					makeRemoveLseOffhPlnBasic(offHirePlanVOs[i], offHirePlanVOs[i].getIbflag(), deleteVoList);

					offHirePlanVOs[i].setCreUsrId(account.getUsr_id());
					offHirePlanVOs[i].setUpdUsrId(account.getUsr_id());

					makeAddLseOffhPlnBasic(offHirePlanVOs[i], insertVoList);
				}
			}

			if ( deleteVoList != null && deleteVoList.size() > 0 ) {
				/* 단건씩 Loop 처리 */
				for ( int i = 0 ; i < deleteVoList.size() ; i++ ) {
					dbDao.removeOffHirePlanData(deleteVoList.get(i));
				}
			}
			if ( insertVoList != null && insertVoList.size() > 0 ) {
				/* 단건씩 Loop 처리 */
				for ( int i = 0 ; i < insertVoList.size() ; i++ ) {
					dbDao.addOffHirePlanData(insertVoList.get(i));
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by H/Q Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by H/Q Save"}).getMessage(), ex);
		}
	}

	/**
	 * Off-Hire Plan by H/Q의 Plan 데이터를 LseOffhPlnVO Table VO에 mapping 처리합니다.<br>
	 *
	 * @param OffHirePlanVO offHirePlanVO
	 * @param lseOffhPlnVOs List<LseOffhPlnVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private void makeAddLseOffhPlnBasic(OffHirePlanVO offHirePlanVO, List<LseOffhPlnVO> lseOffhPlnVOs) throws EventException {
		try {
			String execMethodNm = "";
			String offhQty = "";
			Class offHirePlanVOClass = offHirePlanVO.getClass();
			Method[] methods = offHirePlanVOClass.getMethods();

			for ( int i = 0 ; i < 12 ; i++ ) {
				execMethodNm = "getMnth" + JSPUtil.getLPAD(""+(i+1), 2, "0");

				for ( int k = 0 ; k < methods.length ; k++ ) {
					if ( methods[k].getName().equals(execMethodNm) ) {
						offhQty = (String)methods[k].invoke(offHirePlanVO);
					}
				}

				if ( !JSPUtil.getNull(offhQty).equals("") && Integer.parseInt(offhQty) != 0 ) {
					LseOffhPlnVO addLseOffhPlnVO = new LseOffhPlnVO();

					addLseOffhPlnVO.setPlnYr(offHirePlanVO.getPlnYr());
					addLseOffhPlnVO.setOffhVerSeq(offHirePlanVO.getOffhVerSeq());
					addLseOffhPlnVO.setOffhYrmon(offHirePlanVO.getPlnYr()+JSPUtil.getLPAD(""+(i+1), 2, "0"));
					addLseOffhPlnVO.setOffhPlnTpCd(offHirePlanVO.getOffhPlnTpCd());
					addLseOffhPlnVO.setOffhLocTpCd(offHirePlanVO.getOffhLocTpCd());
					addLseOffhPlnVO.setOffhRgnLocCd(offHirePlanVO.getOffhRgnLocCd());
					addLseOffhPlnVO.setCntrTpszCd(offHirePlanVO.getCntrTpszCd());
					addLseOffhPlnVO.setOffhLocCd(offHirePlanVO.getOffhRgnLocCd());
					addLseOffhPlnVO.setOffhQty(offhQty);
					addLseOffhPlnVO.setLstmCd(offHirePlanVO.getLstmCd());
					addLseOffhPlnVO.setCreUsrId(offHirePlanVO.getCreUsrId());
					addLseOffhPlnVO.setUpdUsrId(offHirePlanVO.getUpdUsrId());

					lseOffhPlnVOs.add(addLseOffhPlnVO);
				}
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan"}).getMessage(), ex);
		}
	}

	/**
	 * Off-Hire Plan by H/Q의 Plan 데이터를 LseOffhPlnVO Table VO에 mapping 처리합니다.<br>
	 *
	 * @param OffHirePlanVO offHirePlanVO
	 * @param String strIbFlag
	 * @param deleteVoList List<LseOffhPlnVO>
	 * @exception EventException
	 */
	private void makeRemoveLseOffhPlnBasic(OffHirePlanVO offHirePlanVO, String strIbFlag, List<LseOffhPlnVO> lseOffhPlnVOs) throws EventException {
		try {
			LseOffhPlnVO removeLseOffhPlnVO = new LseOffhPlnVO();

			removeLseOffhPlnVO.setPlnYr(offHirePlanVO.getPlnYr());
			removeLseOffhPlnVO.setOffhVerSeq(offHirePlanVO.getOffhVerSeq());
			removeLseOffhPlnVO.setOffhPlnTpCd(offHirePlanVO.getOffhPlnTpCd());
			removeLseOffhPlnVO.setOffhLocTpCd(offHirePlanVO.getOffhLocTpCd());
			removeLseOffhPlnVO.setLstmCd(offHirePlanVO.getLstmCd());

			if ( strIbFlag.equals("U") ) {
				removeLseOffhPlnVO.setOffhRgnLocCd(offHirePlanVO.getOffhRgnLocCd());
				removeLseOffhPlnVO.setCntrTpszCd(offHirePlanVO.getCntrTpszCd());
			}

			lseOffhPlnVOs.add(removeLseOffhPlnVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan"}).getMessage(), ex);
		}
	}

	/**
	 * Off Hire Plan Input &amp; Update by H/Q 의 Version 생성합니다.<br>
	 *
	 * @param OffHirePlanSearchVO offHirePlanSearchVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createOffHirePlanNewVerBasic(OffHirePlanSearchVO offHirePlanSearchVO, SignOnUserAccount account) throws EventException {
		try {
			offHirePlanSearchVO.setUsrId(account.getUsr_id());
			dbDao.addOffHirePlanNewVerData(offHirePlanSearchVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by H/Q Vesrion Up"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by H/Q Vesrion Up"}).getMessage(), ex);
		}
	}

	/**
	 * 입력받은 AGMT No.에 대한 유효성을 검증합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return String
	 * @exception EventException
	 */
	public String searchNewVanCNTRDeliveryPlanAvailBasic(PlanSearchVO planSearchVO) throws EventException {
		String dupYrmon = null;

		try {
			dupYrmon = dbDao.searchNewVanCNTRDeliveryPlanAvailData(planSearchVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerAgreementNoAvail Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerAgreementNoAvail Search"}).getMessage(),ex);
		}

		return dupYrmon;
	}

	/**
	 * 신조장비(OW/LP/OL) 계획목록을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanVO>
	 * @exception EventException
	 */
	public List<LeasePlanVO> searchNewVanCNTRDeliveryPlanListBasic(PlanSearchVO planSearchVO) throws EventException {
		List<LeasePlanVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchNewVanCNTRDeliveryPlanListData(planSearchVO);

			if(resultVOs.size() > 0) {
				resultVOs.get(0).setMaxRows(dbDao.searchNewVanCNTRDeliveryPlanListCountData(planSearchVO));
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerDeliveryPlanList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerDeliveryPlanList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 신조장비(OW/LP/OL) 계획목록을 일괄 저장합니다.<br>
	 *
	 * @param LeasePlanVO[] leasePlanVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageNewVanCNTRDeliveryPlanListBasic(LeasePlanVO[] leasePlanVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			List<LeasePlanVO> insertVoList = new ArrayList<LeasePlanVO>();
			List<LeasePlanVO> updateVoList = new ArrayList<LeasePlanVO>();
			List<LeasePlanVO> deleteVoList = new ArrayList<LeasePlanVO>();

			for(int i = 0, cnt = 0; i < leasePlanVOs.length; i++ ) {
				if(leasePlanVOs[i].getIbflag().equals("I")) {
					//기존 데이터 존재 여부에 따라 insert 여부 결정
					if(!dbDao.isExistNewVanCNTRDeliveryPlanData(leasePlanVOs[i])) {
						leasePlanVOs[i].setCreUsrId(userAccount.getUsr_id());
						leasePlanVOs[i].setInsertSeq(String.valueOf(cnt++));
						insertVoList.add(leasePlanVOs[i]);
					}
				} else if(leasePlanVOs[i].getIbflag().equals("U")) {
					leasePlanVOs[i].setUpdUsrId(userAccount.getUsr_id());
					updateVoList.add(leasePlanVOs[i]);
				} else if(leasePlanVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(leasePlanVOs[i]);
				}
			}

			if(insertVoList.size() > 0) {
				dbDao.addNewVanCNTRDeliveryPlanListData(insertVoList);
			}
			if(updateVoList.size() > 0) {
				dbDao.modifyNewVanCNTRDeliveryPlanListData(updateVoList);
			}
			if(deleteVoList.size() > 0) {
				dbDao.removeNewVanCNTRDeliveryPlanListData(deleteVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerDeliveryPlanList Manage"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerDeliveryPlanList Manage"}).getMessage(),ex);
		}
	}

	/**
	 * 신조(자가/장기)장비 인수계획 대비 실적목록을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceVO>
	 * @exception EventException
	 */
	public List<LeasePlanPerformanceVO> searchNewVanCNTRDeliveryPlanPerformanceListBasic(PlanSearchVO planSearchVO) throws EventException {
		List<LeasePlanPerformanceVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchNewVanCNTRDeliveryPlanPerformanceListData(planSearchVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerDeliveryPlanPerformance Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerDeliveryPlanPerformance Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 신조(자가/장기)장비 인수계획 대비 실적별 상세내역을 조회합니다.<br>
	 *
	 * @param  PlanSearchVO planSearchVO
	 * @return List<LeasePlanPerformanceDetailVO>
	 * @exception EventException
	 */
	public List<LeasePlanPerformanceDetailVO> searchNewVanCNTRDeliveryPlanPerformanceDetailBasic(PlanSearchVO planSearchVO) throws EventException {
		List<LeasePlanPerformanceDetailVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchNewVanCNTRDeliveryPlanPerformanceDetailData(planSearchVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerDeliveryPlanPerformDetail Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"NewVanContainerDeliveryPlanPerformDetail Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * Off-Hire Plan Input &amp; Update by RCC 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePlanRccVO>
	 * @exception EventException
	 */
	public List<OffHirePlanRccVO> searchOffHirePlanByRCCBasic(OffHirePlanSearchVO offHirePlanSearchVO) throws EventException {
		List<OffHirePlanRccVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchOffHirePlanByRCCData(offHirePlanSearchVO);

			//if ( resultVOs.size() < 1 ) {
			//	new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			//}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by RCC Search"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by RCC Search"}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * Off Hire Plan Input &amp; Update by RCC 데이터 저장합니다.<br>
	 *
	 * @param OffHirePlanSearchVO offHirePlanSearchVO
	 * @param OffHirePlanRccVO[] offHirePlanRccVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void manageOffHirePlanByRCCBasic(OffHirePlanSearchVO offHirePlanSearchVO, OffHirePlanRccVO[] offHirePlanRccVOs, SignOnUserAccount account) throws EventException {
		try {
			//LseOffhPlnVO       deleteVo     = new LseOffhPlnVO();
			List<LseOffhPlnVO> deleteVoList = new ArrayList<LseOffhPlnVO>();
			List<LseOffhPlnVO> insertVoList = new ArrayList<LseOffhPlnVO>();
			List<String> arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(offHirePlanSearchVO.getCntrTpszCd(),",","|"));

			/* Delete VO 객체 생성 */
			/*
			deleteVo.setPlnYr(searchOffHirePlanVO.getOffhYrmon().substring(0, 4));
			deleteVo.setOffhVerSeq(searchOffHirePlanVO.getOffhVerSeq());
			deleteVo.setOffhYrmon(searchOffHirePlanVO.getOffhYrmon());
			deleteVo.setOffhPlnTpCd(searchOffHirePlanVO.getOffhPlnTpCd());
			deleteVo.setOffhLocTpCd(searchOffHirePlanVO.getOffhLocTpCd());
			deleteVo.setOffhRgnLocCd(searchOffHirePlanVO.getOffhRgnLocCd());
			deleteVo.setLstmCd(searchOffHirePlanVO.getLstmCd());
			*/

			/* Insert VO List 객체 생성 */
			Class offHirePlanRccVoClass = new OffHirePlanRccVO().getClass();

			String[] strGetMethodNm = new String[arrCntrTpszCd.size()];
			for ( int i = 0 ; i < arrCntrTpszCd.size() ; i++ ) {
				strGetMethodNm[i] = new String();
				strGetMethodNm[i] = "getCntr"+(i+1)+"Qty";
			}

			for ( int i = 0; i < offHirePlanRccVOs.length; i++ ) {
				if ( offHirePlanRccVOs[i].getIbflag().equals("I") || offHirePlanRccVOs[i].getIbflag().equals("U") ) {
					LseOffhPlnVO delVO = new LseOffhPlnVO();

					delVO.setPlnYr(offHirePlanRccVOs[i].getPlnYr());
					delVO.setOffhVerSeq(offHirePlanSearchVO.getOffhVerSeq());
					delVO.setOffhYrmon(offHirePlanRccVOs[i].getOffhYrmon());
					delVO.setOffhPlnTpCd(offHirePlanSearchVO.getOffhPlnTpCd());
					delVO.setOffhLocTpCd(offHirePlanSearchVO.getOffhLocTpCd());
					delVO.setOffhRgnLocCd(offHirePlanRccVOs[i].getOffhRgnLocCd());
					delVO.setOffhLocCd(offHirePlanRccVOs[i].getOffhLocCd());
					delVO.setLstmCd(offHirePlanSearchVO.getLstmCd());

					deleteVoList.add(delVO);

					for ( int j = 0 ; j < arrCntrTpszCd.size() ; j++ ) {
						Method method = offHirePlanRccVoClass.getMethod(strGetMethodNm[j], new Class[]{});
						String strQty = (String)method.invoke(offHirePlanRccVOs[i]);

						if ( !strQty.equals("") && !strQty.equals("0") ) {
							LseOffhPlnVO vo = new LseOffhPlnVO();

							vo.setPlnYr(offHirePlanRccVOs[i].getPlnYr());
							vo.setOffhVerSeq(offHirePlanSearchVO.getOffhVerSeq());
							vo.setOffhYrmon(offHirePlanRccVOs[i].getOffhYrmon());
							vo.setOffhPlnTpCd(offHirePlanSearchVO.getOffhPlnTpCd());
							vo.setOffhLocTpCd(offHirePlanSearchVO.getOffhLocTpCd());
							vo.setOffhRgnLocCd(offHirePlanRccVOs[i].getOffhRgnLocCd());
							vo.setCntrTpszCd(arrCntrTpszCd.get(j));
							vo.setOffhLocCd(offHirePlanRccVOs[i].getOffhLocCd());
							vo.setOffhQty(strQty);
							vo.setLstmCd(offHirePlanSearchVO.getLstmCd());
							vo.setCreUsrId(account.getUsr_id());
							vo.setUpdUsrId(account.getUsr_id());

							insertVoList.add(vo);
						}
					}
				}
			}

			/* Delete VO 처리 */
			//dbDao.removeOffHirePlanByRCCData(deleteVo);
			/* Delete VO List 처리 : 단건씩 Loop */
			if ( deleteVoList != null && deleteVoList.size() > 0 ) {
				for ( int i = 0 ; i < deleteVoList.size() ; i++ ) {
					dbDao.removeOffHirePlanByRCCData(deleteVoList.get(i));
				}
			}

			/* Insert VO List 처리 : 단건씩 Loop */
			if ( insertVoList != null && insertVoList.size() > 0 ) {
				for ( int i = 0 ; i < insertVoList.size() ; i++ ) {
					dbDao.addOffHirePlanByRCCData(insertVoList.get(i));
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by RCC Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by RCC Save"}).getMessage(), ex);
		}
	}

	/**
	 * Off-Hire Plan & Performance 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePerformanceVO>
	 * @exception EventException
	 */
	public List<OffHirePerformanceVO> searchOffHirePerformanceBasic(OffHirePlanSearchVO offHirePlanSearchVO) throws EventException {
		List<OffHirePerformanceVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchOffHirePerformanceData(offHirePlanSearchVO);

			//if ( resultVOs.size() < 1 ) {
			//	new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			//}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan and Performance Search"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan and Performance Search"}).getMessage(), ex);
		}

		return resultVOs;
	}

	/**
	 * Off Hire Plan Input &amp; Update by RCC DOL 팝업 조회합니다.<br>
	 *
	 * @param  OffHirePlanSearchVO offHirePlanSearchVO
	 * @return List<OffHirePlanVO>
	 * @exception EventException
	 */
	public List<OffHirePlanRccVO> searchOffHirePlanByRCCDOLBasic(OffHirePlanSearchVO offHirePlanSearchVO) throws EventException {
		List<OffHirePlanRccVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchOffHirePlanByRCCDOLData(offHirePlanSearchVO);

			//if ( resultVOs.size() < 1 ) {
			//	new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			//}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by RCC DOL Search"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{"Off-Hire Plan by RCC DOL Search"}).getMessage(), ex);
		}

		return resultVOs;
	}
}