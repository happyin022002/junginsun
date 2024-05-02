/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtBCImpl.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박희동
*@LastVersion : 1.0 
* 2009.04.24 박희동 
* 1.0 Creation
* 2011.02.17 남궁진호 [CHM-201108954-01] FNS_JOO_0002 : Financial Affairs Creation & Inquiry 화면의 저장 로직 수정 
*            manageCarFinancialMtrx 로직변경 : 존재유무 체크 후 false= Insert, true=update
*            checkedJooCarrier: joo_carrier 데이터 체크 메소드 추가 
* -------------------------------------------------------
* 2012.04.05 조병연[CHM-201217059-01]
* Title : [ALPS JOO] Estimate VVD Code Check - Current Estimate Cost 0 조회 기능 추가
* 내용 :
* 1. BSA adjustment 칼럼 추가  :
* 기존 통합선복사용실적조회 화면에 있던 BSA adjustment 기능을 Basic Info 화면으로 옮겨, 
* 해당 Lane, Carrier에 일괄적으로 적용 (TEU, WT 분리하여 적용)
* 2. Add Carriers 수정 : 
* Main에서 Lane, Rep. Carrier를 신규로 생성했을 때, Add Carriers로 자동으로 저장되도록 수정
* 3. Bay plan table에서 같은 포트가 2개 이상일 경우, 가장 늦은 ETD에 해당하는 plan의 data를 적용 수정 : 
* 테스트 서버 적용된 사항 미반영 상태. 
* 모든 레인에서 같은 포트가 두 개 이상이라면 마지막에 CALLING 한 포트를 기준으로 해야 함 
* (ALX, BRSSZ & ALW, MXZLO)
* EX. ALX/ HJAA0014E : ETD 2011-10-15 data (현재 ETD 2011-10-03 data 임)
* 4. RF sub alloc 수정 : 
* Basic Info에 입력된 RF sub alloc 을 반영하여, sub alloc 보다 loading 개수가 
* 적은 경우 “0”으로 표기되도록 쿼리 수정
* 2013.05.06 김현화[CHM-201324350]BSA Information Entry 로직 추가- old_ver_no 구해 오는 로직변경.
* 2013.06.14 이수진 [CHM-201325358]BSA Information Entry 기능 추가
*            - Row copy하여  Add Carrier 값이 존재하면 Add BSA 정보를 자동으로 생성되어지도록 로직 변경 
* 2015-12-04 [CHM-201539268] XPR > IAS > LCFIA > CHG OFC 기능 관련 보완            
* =========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration.JointOperationMasterDataMgtDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AdditionalSlotManageVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BlkVygSttsVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaCarrieHistoryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaInformationEntryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BzcAgmtCrrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.StlBssPortVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooCrrMrgVO;
import com.hanjin.syscommon.common.table.JooStlBssPortVO;
import com.hanjin.syscommon.common.table.JooStlItmAcctVO;
import com.hanjin.syscommon.common.table.JooStlVvdVO;

/**
 * ALPS-JointOperationMasterDataMgtSC Business Logic Basic Command implementation<br>
 * - ALPS-JointOperationMasterDataMgtSC에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Hee Dong
 * @see UI_JOO_0028EventResponse,JointOperationMasterDataMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class JointOperationMasterDataMgtBCImpl extends BasicCommandSupport implements JointOperationMasterDataMgtBC {

	// Database Access Object
	private transient JointOperationMasterDataMgtDBDAO dbDao = null;

	/**
	 * JointOperationMasterDataMgtBCImpl 객체 생성<br>
	 * JointOperationMasterDataMgtBCDBDAO를 생성한다.<br>
	 */
	public JointOperationMasterDataMgtBCImpl() {
		dbDao = new JointOperationMasterDataMgtDBDAO();
	}

	/**
	 * Account Item List 조회
	 * @return List<STLItemAcctVO>
	 * @throws EventException
	 */
	public List<STLItemAcctVO> searchSTLItemAcctList() throws EventException {
		try {
			return dbDao.searchSTLItemAcctList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Item", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Item", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * Settlement Item 정보를 저장한다. 
	 * @param STLItemAcctVO[] sTLItemAcctVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageSTLItemAcct(STLItemAcctVO[] sTLItemAcctVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			JooStlItmAcctVO rJooStlItmAcctVO = null;
			JooStlItmAcctVO eJooStlItmAcctVO = null;
			
			for ( int i=0; i<sTLItemAcctVOs.length; i++ ) {
				//1이면 Y, 0이면 N
				String joAutoCreFlg = "1".equals(sTLItemAcctVOs[i].getJoAutoCreFlg())?"Y":"N";
				String joMnlCreFlg  = "1".equals(sTLItemAcctVOs[i].getJoMnlCreFlg ())?"Y":"N";
				
				sTLItemAcctVOs[i].setJoAutoCreFlg(joAutoCreFlg);
				sTLItemAcctVOs[i].setJoMnlCreFlg (joMnlCreFlg);
				sTLItemAcctVOs[i].setUsrId(signOnUserAccount.getUsr_id());
				
				rJooStlItmAcctVO = makeJooStlItmAcctVOBySTLItemAcctVO(sTLItemAcctVOs[i], "R");
				eJooStlItmAcctVO = makeJooStlItmAcctVOBySTLItemAcctVO(sTLItemAcctVOs[i], "E");
				
				if ( sTLItemAcctVOs[i].getIbflag().equals("I")){
					//JOO_STL_ITM테이블에 INSERT
					dbDao.addJooStlItm(sTLItemAcctVOs[i]);
					
					//JOO_STL_ITM_ACCT테이블에 REVENUE정보 입력
					dbDao.addJooStlItmAcct(rJooStlItmAcctVO);

					//JOO_STL_ITM_ACCT테이블에 EXPENSE정보 입력
					dbDao.addJooStlItmAcct(eJooStlItmAcctVO);
				} else if ( sTLItemAcctVOs[i].getIbflag().equals("U")){
					//JOO_STL_ITM테이블에 UPDATE
					dbDao.modifyJooStlItm(sTLItemAcctVOs[i]);
					
					//JOO_STL_ITM_ACCT테이블에 REVENUE정보 update
					dbDao.modifyJooStlItmAcct(rJooStlItmAcctVO);

					//JOO_STL_ITM_ACCT테이블에 EXPENSE정보 update
					dbDao.modifyJooStlItmAcct(eJooStlItmAcctVO);
				} else if ( sTLItemAcctVOs[i].getIbflag().equals("D")){					
					//JOO_STL_ITM_ACCT테이블에 REVENUE정보 remove
					dbDao.removeJooStlItmAcct(rJooStlItmAcctVO);

					//JOO_STL_ITM_ACCT테이블에 EXPENSE정보 입력
					dbDao.removeJooStlItmAcct(eJooStlItmAcctVO);

					//JOO_STL_ITM테이블에서 remove
					dbDao.removeJooStlItm(sTLItemAcctVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Item", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Item", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * Financial Matrix를 조회한다.
	 * @param CarrierVO carrierVO
	 * @return CarFinanMtrxGrpVO
	 * @throws EventException
	 */
	public CarFinanMtrxGrpVO searchCarFinancialMtrxList(CarrierVO carrierVO) throws EventException {
		CarFinanMtrxGrpVO grpVO = new CarFinanMtrxGrpVO();
		try {
			CarrierVO rtnCarrierVO = dbDao.searchCarCustVndrCd(carrierVO);;
			carrierVO.setReDivrCd("R"); //REVENUE 조회
			List<CarFinanMtrxVO> rCarFinanMtrxVOs = dbDao.searchFinanMtrxList(carrierVO);
			carrierVO.setReDivrCd("E"); //EXPENSE 조회
			List<CarFinanMtrxVO> eCarFinanMtrxVOs = dbDao.searchFinanMtrxList(carrierVO);

			grpVO.setCarrierVO(rtnCarrierVO);
			grpVO.setECarFinanMtrxVOs(eCarFinanMtrxVOs);
			grpVO.setRCarFinanMtrxVOs(rCarFinanMtrxVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Retrieve"}).getMessage(), ex);
		}
		return grpVO;
	}

	/**
	 * Financial Matrix를 생성하기 위해 존재하지 않는 Settlement Item을 조회한다.
	 * @param CarrierVO carrierVO
	 * @return CarFinanMtrxGrpVO
	 * @throws EventException
	 */
	public CarFinanMtrxGrpVO calCarFinancialMtrx(CarrierVO carrierVO) throws EventException {
		CarFinanMtrxGrpVO grpVO = new CarFinanMtrxGrpVO();
		try {
			if (carrierVO.getCustSeq() != null && !"".equals(carrierVO.getCustSeq())){
				carrierVO.setReDivrCd("R"); //REVENUE 조회
				List<CarFinanMtrxVO> rCarFinanMtrxVOs = dbDao.searchCalFinanMtrxList(carrierVO);
				grpVO.setRCarFinanMtrxVOs(rCarFinanMtrxVOs);
			}
			if (carrierVO.getVndrSeq() != null && !"".equals(carrierVO.getVndrSeq())){
				carrierVO.setReDivrCd("E"); //EXPENSE 조회
				List<CarFinanMtrxVO> eCarFinanMtrxVOs = dbDao.searchCalFinanMtrxList(carrierVO);
				grpVO.setECarFinanMtrxVOs(eCarFinanMtrxVOs);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Create"}).getMessage(), ex);
		}
		return grpVO;
	}

	/**
	 * Financial Matrix를 저장한다.
	 * @param CarFinanMtrxGrpVO carFinanMtrxGrpVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarFinancialMtrx(CarFinanMtrxGrpVO carFinanMtrxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			
			//==============================
			// JOO_CARRIER 부분 처리
			//==============================
			CarrierVO carrierVO = carFinanMtrxGrpVO.getCarrierVO();

			boolean revDel = false;
			boolean expDel = false;
			
			if (carrierVO != null){
				//carrier 체크 후  insert 및 update한다?
				carrierVO.setUsrId(signOnUserAccount.getUsr_id());
				
				if (!dbDao.checkedJooCarrier(carrierVO) ){
				    dbDao.addJooCarrier(carrierVO);
				}else{
					dbDao.modifyJooCarrier(carrierVO);
				}
				
				revDel = (carrierVO.getCustSeq() == null || "".equals(carrierVO.getCustSeq()));
				expDel = (carrierVO.getVndrSeq() == null || "".equals(carrierVO.getVndrSeq()));				
			}
			
			List<CarrierVO> list = null;
			
			//Carrier정보의 Delt_flg = 'Y'이면 Matrix정보 모두 삭제
			if (carrierVO != null && "Y".equals(carrierVO.getDeltFlg())){
				carrierVO.setReDivrCd(""); //re_divr_cd 에 상관없이 모두 삭제하기 위함
				
				//TargetVVD에 해당 Carrier정보가 있으면 삭제불가
				list = dbDao.searchChkVvdForDelCar(carrierVO);
				
				if (!list.isEmpty()){
					throw new EventException(new ErrorHandler("JOO10010").getMessage());
				}
				dbDao.removeJooFincMtxByCarrierLane(carrierVO);
			}else{
				//그외는 정상처리
				List<CarFinanMtrxVO> revVOs = (List<CarFinanMtrxVO>)carFinanMtrxGrpVO.getRCarFinanMtrxVOs();
				List<CarFinanMtrxVO> expVOs = (List<CarFinanMtrxVO>)carFinanMtrxGrpVO.getECarFinanMtrxVOs();
				
				//==============================
				//REVENUE 부분 처리				
				//==============================
				
				//Customer 정보가 없으면 re_divr_cd = 'R'인 정보를 모두 삭제한다.
				if (revDel){
					carrierVO.setReDivrCd("R"); //re_divr_cd = 'R' 인 정보 삭제

					//TargetVVD에 해당 Carrier의 Revenue정보가 있으면 삭제불가
					list = dbDao.searchChkVvdForDelCar(carrierVO);
					
					if (!list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10010").getMessage());
					}
					dbDao.removeJooFincMtxByCarrierLane(carrierVO);
				}else{
					if (revVOs != null){
						Iterator itr = (Iterator) revVOs.iterator();
						while(itr.hasNext()){
							CarFinanMtrxVO revVO = (CarFinanMtrxVO)itr.next();
							revVO.setUsrId   (signOnUserAccount.getUsr_id());
							//Customer 정보가 없으면 revenue 정보를 모두 삭제한다.
							if ("I".equals(revVO.getIbflag())){
								dbDao.addJooFincMtx(revVO);
							}else if("U".equals(revVO.getIbflag())){
								dbDao.modifyJooFincMtx(revVO);
							}else if("D".equals(revVO.getIbflag())){
								dbDao.removeJooFincMtx(revVO);
							}
						}
					}
				}
	
				//==============================
				//EXPENSE 부분 처리
				//==============================
				//Customer 정보가 없으면 re_divr_cd = 'E'인 정보를 모두 삭제한다.
				if (expDel){
					carrierVO.setReDivrCd("E"); //re_divr_cd 가 E인 정보만 삭제
					//TargetVVD에 해당 Carrier의 Revenue정보가 있으면 삭제불가
					list = dbDao.searchChkVvdForDelCar(carrierVO);
					
					if (!list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10010").getMessage());
					}
					dbDao.removeJooFincMtxByCarrierLane(carrierVO);
				}else{
					if (expVOs != null){
						Iterator itr = (Iterator) expVOs.iterator();
						while(itr.hasNext()){
							CarFinanMtrxVO expVO = (CarFinanMtrxVO)itr.next();
							expVO.setUsrId   (signOnUserAccount.getUsr_id());
							if ("I".equals(expVO.getIbflag())){
								dbDao.addJooFincMtx(expVO);
							}else if("U".equals(expVO.getIbflag())){
								dbDao.modifyJooFincMtx(expVO);
							}else if("D".equals(expVO.getIbflag())){
								dbDao.removeJooFincMtx(expVO);
							}
						}
					}
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Save"}).getMessage(), ex);
		}
	}

	
	/**
	 * Settlement Pic를 저장한다.
	 * @param CarFinanMtrxGrpVO carFinanMtrxGrpVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void managePic(CarFinanMtrxGrpVO carFinanMtrxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			//그외는 정상처리
			List<CarFinanMtrxVO> revVOs = (List<CarFinanMtrxVO>)carFinanMtrxGrpVO.getRCarFinanMtrxVOs();
			List<CarFinanMtrxVO> expVOs = (List<CarFinanMtrxVO>)carFinanMtrxGrpVO.getECarFinanMtrxVOs();
			
			if (revVOs != null){
				Iterator itr = (Iterator) revVOs.iterator();
				while(itr.hasNext()){
					CarFinanMtrxVO revVO = (CarFinanMtrxVO)itr.next();
					revVO.setUsrId   (signOnUserAccount.getUsr_id());
					//Customer 정보가 없으면 revenue 정보를 모두 삭제한다.
					if("U".equals(revVO.getIbflag())){
						dbDao.modifyPic(revVO);
					}else if("D".equals(revVO.getIbflag())){
						dbDao.removePic(revVO);
					}
				}
			}
			
			if (expVOs != null){
				Iterator itr = (Iterator) expVOs.iterator();
				while(itr.hasNext()){
					CarFinanMtrxVO expVO = (CarFinanMtrxVO)itr.next();
					expVO.setUsrId   (signOnUserAccount.getUsr_id());
					if("U".equals(expVO.getIbflag())){
						dbDao.modifyPic(expVO);
					}else if("D".equals(expVO.getIbflag())){
						dbDao.removePic(expVO);
					}
				}
			}						
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement PIC", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement PIC", "Save"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Financial Matrix를 저장한다.(Change Ofc 버튼 실행시)
	 * @param CarFinanMtrxGrpVO carFinanMtrxGrpVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarFinancialMtrxChgOfc(CarFinanMtrxGrpVO carFinanMtrxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			
			//==============================
			// JOO_CARRIER 부분 처리
			//==============================
			CarrierVO carrierVO = carFinanMtrxGrpVO.getCarrierVO();
			String chgOfcGubun = carFinanMtrxGrpVO.getCarrierVO().getChgOfcGubun();

			boolean revDel = false;
			boolean expDel = false;
									
			//Carrier정보의 Delt_flg = 'Y'이면 Matrix정보 모두 삭제
			if (!(carrierVO != null && "Y".equals(carrierVO.getDeltFlg()))){
				//그외는 정상처리
				List<CarFinanMtrxVO> revVOs = (List<CarFinanMtrxVO>)carFinanMtrxGrpVO.getRCarFinanMtrxVOs();
				List<CarFinanMtrxVO> expVOs = (List<CarFinanMtrxVO>)carFinanMtrxGrpVO.getECarFinanMtrxVOs();
				
				//==============================
				//REVENUE 부분 처리				
				//==============================
				
				//Customer 정보가 없으면 re_divr_cd = 'R'인 정보를 모두 삭제한다.
				if (!revDel){
					if (revVOs != null){
						Iterator itr = (Iterator) revVOs.iterator();
						while(itr.hasNext()){
							CarFinanMtrxVO revVO = (CarFinanMtrxVO)itr.next();
							revVO.setUsrId   (signOnUserAccount.getUsr_id());
							
/*
 *2014.12.15 민정호
 *
1) 조건 : Carrier  - XPR, Trade - IAS,  Lane - LCFIA  일 경우만
   : SINWA 및 SELFAR 로그인 시에 Change OFC 버튼 실행되게 처리 
 
2) Change OFC 버튼 실행 시 로직
  : Center - 111234, City - HQADG을  Center - 123711 City - SGSIN  변경
    Center - 123711 City - SGSIN 을  Center - 111234, City - HQADG 변경							
 */
							
							if("111234".equals(revVO.getDrCtrCd())){								
								revVO.setDrCtrCd("123711");								
							}else if("123711".equals(revVO.getDrCtrCd())){
								revVO.setDrCtrCd("111234");
							}
							if("HQADG".equals(revVO.getDrLocCd())){
								revVO.setDrLocCd("SGSIN");								
							}else if("SGSIN".equals(revVO.getDrLocCd())){
								revVO.setDrLocCd("HQADG");								
							}
							
							if("111234".equals(revVO.getCrCtrCd())){								
								revVO.setCrCtrCd("123711");								
							}else if("123711".equals(revVO.getCrCtrCd())){
								revVO.setCrCtrCd("111234");
							}
							if("HQADG".equals(revVO.getCrLocCd())){
								revVO.setCrLocCd("SGSIN");								
							}else if("SGSIN".equals(revVO.getCrLocCd())){
								revVO.setCrLocCd("HQADG");								
							}	
							revVO.setChgOfcGubun(chgOfcGubun);
							//Customer 정보가 없으면 revenue 정보를 모두 삭제한다.
							dbDao.modifyJooFincMtx(revVO);
						}
					}
				}
	
				//==============================
				//EXPENSE 부분 처리
				//==============================
				//Customer 정보가 없으면 re_divr_cd = 'E'인 정보를 모두 삭제한다.
				if (!expDel){
					if (expVOs != null){
						Iterator itr = (Iterator) expVOs.iterator();
						while(itr.hasNext()){
							CarFinanMtrxVO expVO = (CarFinanMtrxVO)itr.next();
							expVO.setUsrId   (signOnUserAccount.getUsr_id());
							
							/*
							 *2014.12.15 민정호
							 *
							1) 조건 : Carrier  - XPR, Trade - IAS,  Lane - LCFIA  일 경우만
							   : SINWA 및 SELFAR 로그인 시에 Change OFC 버튼 실행되게 처리 
							 
							2) Change OFC 버튼 실행 시 로직
							  : Center - 111234, City - HQADG을  Center - 123711 City - SGSIN  변경
							    Center - 123711 City - SGSIN 을  Center - 111234, City - HQADG 변경							
							 */
														
							if("111234".equals(expVO.getDrCtrCd())){								
								expVO.setDrCtrCd("123711");								
							}else if("123711".equals(expVO.getDrCtrCd())){
								expVO.setDrCtrCd("111234");
							}
							if("HQADG".equals(expVO.getDrLocCd())){
								expVO.setDrLocCd("SGSIN");								
							}else if("SGSIN".equals(expVO.getDrLocCd())){
								expVO.setDrLocCd("HQADG");								
							}
							
							if("111234".equals(expVO.getCrCtrCd())){								
								expVO.setCrCtrCd("123711");								
							}else if("123711".equals(expVO.getCrCtrCd())){
								expVO.setCrCtrCd("111234");
							}
							if("HQADG".equals(expVO.getCrLocCd())){
								expVO.setCrLocCd("SGSIN");								
							}else if("SGSIN".equals(expVO.getCrLocCd())){
								expVO.setCrLocCd("HQADG");								
							}							
																		
							expVO.setChgOfcGubun(chgOfcGubun);														
							dbDao.modifyJooFincMtx(expVO);
						}
					}
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Financial Matrix", "Save"}).getMessage(), ex);
		}
	}
	
	
	
	
	/**
	 * Carrier Merge 정보를 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @return List<JooCrrMrgVO>
	 * @throws EventException
	 */
	public List<JooCrrMrgVO> searchCarrierMerge(MstComInputVO mstComInputVO) throws EventException {
		try {
			return dbDao.searchCarrierMerge(mstComInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Carrier Merge정보를 저장한다.
	 * @param JooCrrMrgVO[] jooCrrMrgVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarrierMerge(JooCrrMrgVO[] jooCrrMrgVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<JooCrrMrgVO> insertVoList = new ArrayList<JooCrrMrgVO>();
			List<JooCrrMrgVO> updateVoList = new ArrayList<JooCrrMrgVO>();
			List<JooCrrMrgVO> deleteVoList = new ArrayList<JooCrrMrgVO>();
			
			for (int inx=0; inx<jooCrrMrgVOs.length; inx++){
				if ("I".equals(jooCrrMrgVOs[inx].getIbflag())){
					jooCrrMrgVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					jooCrrMrgVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(jooCrrMrgVOs[inx]);
				}else if("U".equals(jooCrrMrgVOs[inx].getIbflag())){
					jooCrrMrgVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(jooCrrMrgVOs[inx]);
				}else if("D".equals(jooCrrMrgVOs[inx].getIbflag())){
					deleteVoList.add(jooCrrMrgVOs[inx]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addCarrierMergeS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCarrierMergeS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCarrierMergeS(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * Carrier의 Service Provider/Customer 정보를 조회한다.
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @throws EventException
	 */
	public List<CarrierVO> searchVndrCustListByCar(CarrierVO carrierVO) throws EventException {
		try {
			return dbDao.searchVndrCustListByCar(carrierVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Service Provider and Customer's Information of Carrier", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Service Provider and Customer's Information of Carrier", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * Basic Port List를 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @param String lsAbbr
	 * @param String lsDir
	 * @return List<StlBssPortVO>
	 * @throws EventException
	 */
	public List<StlBssPortVO> searchSettlementBasicPortList(MstComInputVO mstComInputVO, String lsAbbr, String lsDir) throws EventException {
		try {
			return dbDao.searchSettlementBasicPortList(mstComInputVO, lsAbbr, lsDir);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * Basic Port를 저장한다.
	 * @param JooStlBssPortVO[] jooStlBssPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @throws EventException
	 */
	public int manageSettlementBasicPort(JooStlBssPortVO[] jooStlBssPortVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		int rtnVal = 0;
		try {
			List<JooStlBssPortVO> insertVoList = new ArrayList<JooStlBssPortVO>();
			List<JooStlBssPortVO> updateVoList = new ArrayList<JooStlBssPortVO>();
			List<JooStlBssPortVO> deleteVoList = new ArrayList<JooStlBssPortVO>();
			
			for (int inx=0; inx<jooStlBssPortVOs.length; inx++){
				if ("I".equals(jooStlBssPortVOs[inx].getIbflag())){
					//Copy해서 입력할 경우 Carrier와 Trade와 Lane의 관계가 없는 data일 수 있으므로 validation check를 한다.
					if (inx==0){
						CarrierVO carrierVO = new CarrierVO();
						List<CarrierVO> list = null;
						carrierVO.setJoCrrCd(jooStlBssPortVOs[inx].getJoCrrCd());
						carrierVO.setTrdCd  (jooStlBssPortVOs[inx].getTrdCd  ());
						carrierVO.setRlaneCd(jooStlBssPortVOs[inx].getRlaneCd());
						
						list = dbDao.searchCarrierList(carrierVO);
						
						//Carrier-Trade-Lane관계가 존재하지 않으면 뱉어낸다.
						if (list.isEmpty()){
							rtnVal = 999;
							return rtnVal;
						}
					}
					jooStlBssPortVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					jooStlBssPortVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(jooStlBssPortVOs[inx]);
				}else if("U".equals(jooStlBssPortVOs[inx].getIbflag())){
					jooStlBssPortVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(jooStlBssPortVOs[inx]);
				}else if("D".equals(jooStlBssPortVOs[inx].getIbflag())){
					deleteVoList.add(jooStlBssPortVOs[inx]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				rtnVal = dbDao.addSettlementBasicPort(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySettlementBasicPort(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSettlementBasicPort(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Save"}).getMessage(), ex);
		}
		
		return rtnVal;
	}

	/**
	 * Copy된 자료가 중복되는 경우 사용자의 Confirm을 받아 삭제 후 재 생성한다.
	 * @param JooStlBssPortVO[] jooStlBssPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCopyBasicPort(JooStlBssPortVO[] jooStlBssPortVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<JooStlBssPortVO> insertVoList = new ArrayList<JooStlBssPortVO>();
			
			for (int inx=0; inx<jooStlBssPortVOs.length; inx++){
				if ("I".equals(jooStlBssPortVOs[inx].getIbflag())){
					jooStlBssPortVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					jooStlBssPortVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(jooStlBssPortVOs[inx]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				//삭제 후 insert한다.
				dbDao.removeSettlementBasicPort(insertVoList);
				dbDao.addSettlementBasicPort   (insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * Basic Port를 생성하기 위해 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @return List<StlBssPortVO>
	 * @throws EventException
	 */
	public List<StlBssPortVO> searchItemDirList(MstComInputVO mstComInputVO) throws EventException {
		try {
			return dbDao.searchItemDirList(mstComInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Port", "Create"}).getMessage(), ex);
		}
	}

	/**
	 * Target VVD를 조회한다. 
	 * @param TargetVVDVO targetVVDVO
	 * @return List<TargetVVDVO>
	 * @throws EventException
	 */
	public List<TargetVVDVO> searchTargetVVDList(TargetVVDVO targetVVDVO) throws EventException {
		try {
			return dbDao.searchTargetVVDList(targetVVDVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * Target VVD를 생성하기위해 조회한다.
	 * @param TargetVVDVO targetVVDVO
	 * @param String joStlOptCd
	 * @return List<TargetVVDVO>
	 * @throws EventException
	 */
	public List<TargetVVDVO> createTargetVVDList(TargetVVDVO targetVVDVO, String joStlOptCd) throws EventException {
		try {
			return dbDao.searchSKDVVDList(targetVVDVO, joStlOptCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Create"}).getMessage(), ex);
		}
	}

	/**
	 * Target VVD를 저장한다.
	 * 
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooStlVvdVO>
	 * @throws EventException
	 */
	public List<JooStlVvdVO> manageTargetVVD(JooStlVvdVO[] jooStlVvdVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		
		List<JooStlVvdVO> list2 = new ArrayList<JooStlVvdVO>();
		
		try {
			List<JooStlVvdVO> insertVoList = new ArrayList<JooStlVvdVO>();
			List<JooStlVvdVO> updateVoList = new ArrayList<JooStlVvdVO>();
			List<JooStlVvdVO> deleteVoList = new ArrayList<JooStlVvdVO>();
			List<JooStlVvdVO> list = null;
			
			String ibflag = "";
			for (int inx=0; inx<jooStlVvdVOs.length; inx++){
				ibflag = jooStlVvdVOs[inx].getIbflag();
				if ("I".equals(ibflag)){
					jooStlVvdVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					jooStlVvdVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(jooStlVvdVOs[inx]);
				}else if("U".equals(ibflag)){
					jooStlVvdVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(jooStlVvdVOs[inx]);
				}else if("D".equals(ibflag)){
					deleteVoList.add(jooStlVvdVOs[inx]);
				}
			}

			//중복체크를 위해 삭제먼저 실행한다.
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeTargetVVD(deleteVoList);
			}

			if ( insertVoList.size() > 0 ) {
				for (int inx=0; inx<insertVoList.size(); inx++){
					//Duplicate Check
					list = dbDao.searchTargetVvdDup(insertVoList.get(inx));					
					if (!list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10008").getMessage());
					}
					//Financial Matrix Item Check
					list = dbDao.searchFincMtxItmForStlVvdList(insertVoList.get(inx));
					if (list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10011", insertVoList.get(inx).getJoStlItmCd()).getMessage());
					}
					
					dbDao.addTargetVVD(insertVoList.get(inx));
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				for (int inx=0; inx<updateVoList.size(); inx++){
					//Duplicate Check
					list = dbDao.searchTargetVvdDup(updateVoList.get(inx));					
					if (!list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10008").getMessage());
					}
					//Financial Matrix Item Check
					list = dbDao.searchFincMtxItmForStlVvdList(updateVoList.get(inx));
					if (list.isEmpty()){
						throw new EventException(new ErrorHandler("JOO10011", updateVoList.get(inx).getJoStlItmCd()).getMessage());
					}
				}
				dbDao.modifyTargetVVD(updateVoList);
			}
			
			//VVD & ITEM 2년전까지 비교 - 20150622 수정 
			List<JooStlVvdVO> list1 = null;
			if ( insertVoList.size() > 0 ) {
				for (int inx=0; inx<insertVoList.size(); inx++){
					list1 = dbDao.searchTargetVvdDup2(insertVoList.get(inx));	
					
					if (!list1.isEmpty()){
						list2.add(list1.get(0));
					}
				}				
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err ===>" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Save"}).getMessage(), ex);
		}
		
		return list2;
	}

	/**
	 * Target VVD에서 OUS인 경우 jo_mnu_nm을 Basis Port 의 jo_stl_tgt_tp_cd에서 조회한다. (TDR/RDR)
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return List<JooStlVvdVO>
	 * @throws EventException
	 */
	public List<JooStlVvdVO> searchOusTdrRdrInBssPort(JooStlVvdVO jooStlVvdVO) throws EventException {
		try {
			return dbDao.searchOusTdrRdrInBssPort(jooStlVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Search Settlement Type of OUS"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Search Settlement Type of OUS"}).getMessage(), ex);
		}
	}

	/**
	 * Settlement시 JOO_STL_VVD의 PROC_JB_FLG를 Y로 UPDATE한다.
	 * 삭제시에는 최종 settlement삭제시 N으로 UPDATE한다. 
	 * @param ProcSettlementVO[] procSettlementVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageTargetVVDForSettlement(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<ProcSettlementVO> updateVoList = new ArrayList<ProcSettlementVO>();

			String ibFlag = "";
			//Insert와 delete인 경우만 update하면 된다.
			for (int inx=0; inx<procSettlementVOs.length; inx++){
				ibFlag = procSettlementVOs[inx].getIbflag();
				if ("I".equals(ibFlag) || "D".equals(ibFlag)){
					procSettlementVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(procSettlementVOs[inx]);
				}
			}
			if (updateVoList.size() > 0)
				dbDao.modifyJooStlVVDForSettlement(updateVoList);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Process", "Update Flag of Target VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Process", "Update Flag of Target VVD"}).getMessage(), ex);
		}
	}

	/**
	 * STLItemAcctVO를 JooStlItmAcctVO로 mapping한다. 
	 * @param STLItemAcctVO sTLItemAcctVO
	 * @param String reDivrCd
	 * @return JooStlItmAcctVO
	 * @throws Exception
	 */
	private JooStlItmAcctVO makeJooStlItmAcctVOBySTLItemAcctVO(STLItemAcctVO sTLItemAcctVO, String reDivrCd) throws Exception{
		JooStlItmAcctVO jooStlItmAcctVO = new JooStlItmAcctVO();

		jooStlItmAcctVO.setReDivrCd(reDivrCd);
		jooStlItmAcctVO.setJoStlItmCd(sTLItemAcctVO.getJoStlItmCd());
		if ("R".equals(reDivrCd)){
			jooStlItmAcctVO.setCrAcctCd(sTLItemAcctVO.getRCrAcctCd());
			jooStlItmAcctVO.setDrAcctCd(sTLItemAcctVO.getRDrAcctCd());
			jooStlItmAcctVO.setJoEstmAcctCd(sTLItemAcctVO.getREsAcctCd());
		}else{
			jooStlItmAcctVO.setCrAcctCd(sTLItemAcctVO.getECrAcctCd());
			jooStlItmAcctVO.setDrAcctCd(sTLItemAcctVO.getEDrAcctCd());
			jooStlItmAcctVO.setJoEstmAcctCd(sTLItemAcctVO.getEEsAcctCd());
		}
		jooStlItmAcctVO.setUpdUsrId(sTLItemAcctVO.getUsrId());
		return jooStlItmAcctVO;
	}

    /**
     * Authority Office Creation 의 권한정보를 조회  합니다
     * @param  AuthorityOfficeVO authorityOfficeVO
     * @return List<AuthorityOfficeVO>
     * @throws EventException
     */
    public List<AuthorityOfficeVO> searchAuthorityOffice(AuthorityOfficeVO authorityOfficeVO) throws EventException{
        try {
            return dbDao.searchAuthorityOffice(authorityOfficeVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Office", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Office", "Retrieve"}).getMessage(), ex);
        }
    }
	/**
     * Authority Office Creation 의 지역 권한정보를 저장  합니다
     * @param  AuthorityOfficeVO[] authorityOfficeVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageAuthorityOffice(AuthorityOfficeVO[] authorityOfficeVOs,      
            SignOnUserAccount signOnUserAccount) throws EventException {
        try{
            List<AuthorityOfficeVO> removeVoList = new ArrayList<AuthorityOfficeVO>();
            List<AuthorityOfficeVO> insertVoList = new ArrayList<AuthorityOfficeVO>();            
            for( int i=0;i< authorityOfficeVOs.length;i++){
                authorityOfficeVOs[i].setCreUsrId( signOnUserAccount.getUsr_id() );
                removeVoList.add ( authorityOfficeVOs[i]  );
                insertVoList.add ( authorityOfficeVOs[i]  );
            }
            if ( insertVoList.size() > 0 ) {
                dbDao.removeAuthorityOffice(removeVoList);
                dbDao.addAuthorityOffice   (insertVoList);
            }
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Office", "Creation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Authority Office", "Creation"}).getMessage(), ex);
        }
  
    }

    /**
     * S/H Adjustment시 Target VVD에 없는 VVD는 강제 생성한다.
     * @param AdjustSettlementVO[] adjustSettlementVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageTargetVVDForAdjustment(AdjustSettlementVO[] adjustSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			AdjustSettlementVO adjustSettlementVO = null;
			List<AdjustSettlementVO> adjStls = null;
			JooStlVvdVO targetVVDVO = null; 
			
			for (int i=0; i<adjustSettlementVOs.length; i++){
				adjustSettlementVO = adjustSettlementVOs[i];
				
				//JO_STL_JB_CD 즉 BSA Type이 없는 경우는 COA, JOO에 둘다 없는 경우이므로 Adjustment하지 않는다.
				if (adjustSettlementVO.getJoStlJbCd() == null || "".equals(adjustSettlementVO.getJoStlJbCd()))
					continue;
				
				if ("I".equals(adjustSettlementVO.getIbflag())){
					//대상항차의 sequence를 조회한다.
					adjStls = dbDao.searchStlVvdByVvd(adjustSettlementVO);
					
					//없으면 새로 딴다. => BSA에만 있고 JOO에는 없는 경우이므로 
					if (adjStls.size() == 0){
						targetVVDVO = new JooStlVvdVO();
						targetVVDVO.setAcctYrmon (adjustSettlementVO.getAcctYrmon());
						targetVVDVO.setTrdCd     (adjustSettlementVO.getTrdCd     ());
						targetVVDVO.setJoCrrCd   (adjustSettlementVO.getJoCrrCd   ());
						targetVVDVO.setRlaneCd   (adjustSettlementVO.getRlaneCd   ());
						targetVVDVO.setReDivrCd  (adjustSettlementVO.getReDivrCd  ());
						targetVVDVO.setJoStlItmCd(adjustSettlementVO.getJoStlItmCd());
						targetVVDVO.setJoMnuNm   (adjustSettlementVO.getJoMnuNm   ());
						targetVVDVO.setVslCd     (adjustSettlementVO.getVslCd     ());
						targetVVDVO.setSkdVoyNo  (adjustSettlementVO.getSkdVoyNo  ());
						targetVVDVO.setSkdDirCd  (adjustSettlementVO.getSkdDirCd  ());
						targetVVDVO.setRevDirCd  (adjustSettlementVO.getRevDirCd  ());
						targetVVDVO.setJoStlCfmCd("N"); //Creation할때 나오면 안되므로 N
						targetVVDVO.setProcJbFlg ("Y"); //Settlement에는 있으므로 Y 
						targetVVDVO.setStlTgtVvdBssCd("A"); //사용하지 않는 field이나 Adjust용으로 쓴다.
						targetVVDVO.setCreUsrId  (signOnUserAccount.getUsr_id());
						targetVVDVO.setStlRmk    ("Create for S/H Adjustment");
						
						dbDao.addTargetVVD(targetVVDVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment Process", "Insert a new VVD exists COA not JOO"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"S/H Adjustment Process", "Insert a new VVD exists COA not JOO"}).getMessage(), ex);
		}
	}

	/**
	 * Target VVD의 Close여부 조회
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCloseYn(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchCloseYn(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Check close"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Check close"}).getMessage(), ex);
		}
	}
	
    /**
     * Office Mapping 정보 조회 합니다
     * @param  CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO
     * @return List<CustomSearchOfficeMappingManagementVO>
     * @throws EventException
     */
	public List<CustomSearchOfficeMappingManagementVO> searchOfficeMappingManagementList(CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) throws EventException 
	{
        try {
            return dbDao.searchOfficeMappingManagementList(customSearchOfficeMappingManagementVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Retrieve"}).getMessage(), ex);
        }
    }
	
    /**
     * Office Mapping 정보를 저장 합니다.<br> 
     * @param  CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     * @author Jong Kyu Weon
     */
	public String manageOfficeMappingManagement(CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs, SignOnUserAccount signOnUserAccount) throws EventException {

		StringBuilder rtnVal = new StringBuilder();
		rtnVal.append("");
        try{
    			List<CustomSearchOfficeMappingManagementVO> insertVoList = new ArrayList<CustomSearchOfficeMappingManagementVO>();
    			List<CustomSearchOfficeMappingManagementVO> updateVoList = new ArrayList<CustomSearchOfficeMappingManagementVO>();
    			
    			String ibflag = "";
				String tmpVal = null;

    			for (int inx=0; inx < customSearchOfficeMappingManagementVOs.length; inx++){
    				ibflag = customSearchOfficeMappingManagementVOs[inx].getIbflag();
    				if ("I".equals(ibflag)){
    					customSearchOfficeMappingManagementVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
    					customSearchOfficeMappingManagementVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
    					customSearchOfficeMappingManagementVOs[inx].setDeltFlg("N");			

    					//Duplicate Check
    					tmpVal = "";
    					tmpVal = dbDao.searchOfficeMappingDupCheck(customSearchOfficeMappingManagementVOs[inx]);    					
    					
    					if ("".equals(tmpVal)){  		
        					insertVoList.add(customSearchOfficeMappingManagementVOs[inx]);
    					} else {
    						rtnVal.append(tmpVal + "\n");
    					}
    				}else if("U".equals(ibflag)){
    					customSearchOfficeMappingManagementVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
    					    					
    					//Duplicate Check
	    					tmpVal = "";
	    					tmpVal = dbDao.searchOfficeMappingDupCheck(customSearchOfficeMappingManagementVOs[inx]);
	    					
	    					if ("".equals(tmpVal)){  	
	    						updateVoList.add(customSearchOfficeMappingManagementVOs[inx]);
	    					} else {
	    						rtnVal.append(tmpVal + "\n");
	    					}
    				}
	    			else if("D".equals(ibflag)){
	    				customSearchOfficeMappingManagementVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
	    				customSearchOfficeMappingManagementVOs[inx].setDeltFlg("Y");
    					updateVoList.add(customSearchOfficeMappingManagementVOs[inx]);	    				
	    			}
    			}
    			if ("".equals(rtnVal.toString()) && insertVoList.size() > 0 ) {
					dbDao.addOfficeMappingManagement(insertVoList);
    			}
    			
    			if ("".equals(rtnVal.toString()) && updateVoList.size() > 0 ) {
    				dbDao.modifyOfficeMappingManagement(updateVoList);
    			}
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Mapping", "Save"}).getMessage(), ex);
        }
        
		return rtnVal.toString();
  
    }

	/**
	 * Target VVD를 삭제한다.
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @throws EventException
	 */
	public void removeTargetVVD(JooStlVvdVO[] jooStlVvdVOs) throws EventException{

		try {
			List<JooStlVvdVO> deleteVoList = new ArrayList<JooStlVvdVO>();

			for (int inx=0; inx<jooStlVvdVOs.length; inx++){
				deleteVoList.add(jooStlVvdVOs[inx]);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeTargetVVD(deleteVoList);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Remove"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err ===>" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Target VVD", "Remove"}).getMessage(), ex);
		}
	}

	/**
	 * JOO_BZC_AGMT를 저장한다.
	 * @param CusBzcAgmtVO[] cusBzcAgmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String manageJooBzcAgmt(CusBzcAgmtVO[] cusBzcAgmtVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		String rtnVal = "";
		String rtnAddCrrVal = "";
		try {
			List<CusBzcAgmtVO> updateVoList = new ArrayList<CusBzcAgmtVO>();
			List<CusBzcAgmtVO> list = new ArrayList<CusBzcAgmtVO>();
			
			List<CusBzcAgmtVO> AddCrrList = new ArrayList<CusBzcAgmtVO>();
            List<CusBzcAgmtVO> insertVoList = null;
            List<CusBzcAgmtVO> deleteCrrList = new ArrayList<CusBzcAgmtVO>();
            List<CusBzcAgmtVO> insertCrrList = new ArrayList<CusBzcAgmtVO>();
            
			String ibflag = "";
			for (int inx=0; inx<cusBzcAgmtVOs.length; inx++){
				ibflag = cusBzcAgmtVOs[inx].getIbflag();
				insertVoList = new ArrayList<CusBzcAgmtVO>();
				//기간이 겹치는 부분이 있는 체크한다.
				if (!"D".equals(ibflag)){
					list = dbDao.searchOverlappedRefNoList(cusBzcAgmtVOs[inx]);
					if (!list.isEmpty()){
						rtnVal = "Office ["+cusBzcAgmtVOs[inx].getOfcCd()+"]\n"
						       + "R/E    ["+cusBzcAgmtVOs[inx].getReDivrCd()+"]\n"
						       + "Trade  ["+cusBzcAgmtVOs[inx].getTrdCd()+"]\n"
						       + "Lane   ["+cusBzcAgmtVOs[inx].getRlaneCd()+"]\n"
						       + "Carrier["+cusBzcAgmtVOs[inx].getJoCrrCd()+"]\n"
						       + "From   ["+cusBzcAgmtVOs[inx].getAgmtEffDt()+"]\n"
						       + "To     ["+cusBzcAgmtVOs[inx].getAgmtExpDt()+"]\n\n"
						       + "is overlapped by\n\n"
							   + "Ref No ["+list.get(0).getJoRefNo()+"]\n"
							   + "Period ["+list.get(0).getAgmtEffDt()+ " ~ "+list.get(0).getAgmtExpDt()+"]";
						break;
					}
				}
				if ("I".equals(ibflag)){
					String joRefNo  = cusBzcAgmtVOs[inx].getJoRefNo();
					String joRefSeq = "1";
					
					if ("".equals(joRefNo)){
						//같은 OFFICE + R/E + Trade + Rlane + 'RRMM' 이 있다면 그 REF_NO를 사용한다.
						//list = dbDao.searchRefNo(cusBzcAgmtVOs[inx]);
						joRefNo = dbDao.searchNextJoRefNo(cusBzcAgmtVOs[inx]);
					}
					cusBzcAgmtVOs[inx].setJoRefNo(joRefNo);
					joRefSeq = dbDao.searchNextJoRefSeq(cusBzcAgmtVOs[inx]);
					cusBzcAgmtVOs[inx].setJoRefSeq(joRefSeq);
					cusBzcAgmtVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					cusBzcAgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					dbDao.addJooBzcAgmt(cusBzcAgmtVOs[inx]); //JOO_BZC_AGMT insert
					
					//같은 REF NO의 period 수정
					//dbDao.modifyJooBzcAgmtPeriod(cusBzcAgmtVOs[inx]);
					
					//Add Carriers 처리
					AddCrrList = dbDao.searchAddCarrierListChk(cusBzcAgmtVOs[inx]);
					
					if (AddCrrList.isEmpty()){
						insertVoList.add(cusBzcAgmtVOs[inx]);
					} else {
						rtnAddCrrVal = "JoCrrCd ["+cusBzcAgmtVOs[inx].getJoCrrCd()+"]\n"
					       + "JoRepCrrCd    ["+cusBzcAgmtVOs[inx].getJoCrrCd()+"]\n"
					       + "RlaneCd  ["+cusBzcAgmtVOs[inx].getRlaneCd()+"]\n"
					;
					break;
					}

					// Add Carrier 저장처리
		            if ( insertVoList.size() > 0 ) {
						dbDao.addCarriersII(insertVoList);
					}
					
				}else if("U".equals(ibflag)){
					cusBzcAgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					//같은 REF NO의 period 수정
					//dbDao.modifyJooBzcAgmtPeriod(cusBzcAgmtVOs[inx]);
					if( !cusBzcAgmtVOs[inx].getJoCrrCd().equals(cusBzcAgmtVOs[inx].getJoRefCrrCd()) ) {
						// Delete 후 하나만 입력..
						deleteCrrList.add(cusBzcAgmtVOs[inx]);
						insertCrrList.add(cusBzcAgmtVOs[inx]);
					}
					updateVoList.add(cusBzcAgmtVOs[inx]);
				}else if("D".equals(ibflag)){
					cusBzcAgmtVOs[inx].setDeltFlg ("Y");
					cusBzcAgmtVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(cusBzcAgmtVOs[inx]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyJooBzcAgmt(updateVoList);
			}
			if ( deleteCrrList.size() > 0 ) {
				dbDao.deleteAllCarriers(updateVoList);
			}
			if ( insertCrrList.size() > 0 ) {
				dbDao.addCarriersII(insertCrrList);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Information for Loading Summary", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err ===>" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Basic Information for Loading Summary", "Save"}).getMessage(), ex);
		}
		return rtnVal;
	}

	/**
	 * Business Agreement list를 조회한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws EventException
	 */
	public List<CusBzcAgmtVO> searchJooBzcAgmtList(CusBzcAgmtVO cusBzcAgmtVO) throws EventException {
		try {
			return dbDao.searchJooBzcAgmtList(cusBzcAgmtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * Business Agreement Ref No list를 조회한다.
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchRefNoList(JooCodeParamVO jooCodeParamVO) throws EventException {
		try {
			return dbDao.searchRefNoList(jooCodeParamVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement Reference Number", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement Reference Number", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * 같은 OFFICE, R/E, TRADE, RLANE 인 경우 PERIOD가 같으므로 조회하여 Setting한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws EventException
	 */
	public List<CusBzcAgmtVO> searchRefNoNPeriod(CusBzcAgmtVO cusBzcAgmtVO) throws EventException {
		try {
			return dbDao.searchRefNoNPeriod(cusBzcAgmtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Business Agreement", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * Add Carriers list를 조회한다.
	 * @param BzcAgmtCrrVO bzcAgmtCrrVO
	 * @return List<BzcAgmtCrrVO>
	 * @throws EventException
	 */
	public List<BzcAgmtCrrVO> searchAddCarriersList(BzcAgmtCrrVO bzcAgmtCrrVO) throws EventException {
		try {
			return dbDao.searchAddCarriersList(bzcAgmtCrrVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Add Carriers", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Add Carriers", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * Add Carriers 를 저장한다.
	 * @param BzcAgmtCrrVO[] bzcAgmtCrrVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String addCarriersList(BzcAgmtCrrVO[] bzcAgmtCrrVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		String rtnVal = "";
		try{
			String iudflag = "";
			List<BzcAgmtCrrVO> list = new ArrayList<BzcAgmtCrrVO>();
            List<BzcAgmtCrrVO> insertVoList = new ArrayList<BzcAgmtCrrVO>();   
            List<BzcAgmtCrrVO> updateVoList = new ArrayList<BzcAgmtCrrVO>();    
            List<BzcAgmtCrrVO> deleteVoList = new ArrayList<BzcAgmtCrrVO>();   
            for( int i=0;i< bzcAgmtCrrVOs.length;i++){
            	bzcAgmtCrrVOs[i].setCreUsrId( signOnUserAccount.getUsr_id() );                
                iudflag = bzcAgmtCrrVOs[i].getIudFlag();
                
                if ("I".equals(iudflag)){			//저장    
					list = dbDao.searchAddCarrierList(bzcAgmtCrrVOs[i]);
					if (list.isEmpty()){
						insertVoList.add(bzcAgmtCrrVOs[i]);
					} else {
						rtnVal = "JoCrrCd ["+bzcAgmtCrrVOs[i].getJoCrrCd()+"]\n"
					       + "JoRepCrrCd    ["+bzcAgmtCrrVOs[i].getJoRepCrrCd()+"]\n"
					       + "RlaneCd  ["+bzcAgmtCrrVOs[i].getRlaneCd()+"]\n"
					;
					break;
					}
    			} else if ("U".equals(iudflag)){	//수정     
    				updateVoList.add(bzcAgmtCrrVOs[i]);
    				
    			} else if ("D".equals(iudflag)){	//삭제         
    				deleteVoList.add(bzcAgmtCrrVOs[i]);
    			}  
            }
                  
            if ( insertVoList.size() > 0 ) {
				dbDao.addCarriers(insertVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteCarriers(deleteVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCarriers(updateVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Add Carriers", "Creation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Add Carriers", "Creation"}).getMessage(), ex);
        }
        return rtnVal;
	}
	

	/**
	 * BSA Information Entry를 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws EventException
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryList(BsaInformationEntryVO bsaInformationEntryVO) throws EventException {
		try {
			return dbDao.searchBsaInformationEntryList(bsaInformationEntryVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * YYYY-WW, Date 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws EventException
	 */
	public List<BsaInformationEntryVO> searchBsaInformationYyyyWwDt(BsaInformationEntryVO bsaInformationEntryVO) throws EventException {
		try {
			return dbDao.searchBsaInformationYyyyWwDt(bsaInformationEntryVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry YYYY-WW", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry YYYY-WW", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * BSA Information Entry를 조회한다.  Target Excel을 위한 조회
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws EventException
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryListForTargetExcel(BsaInformationEntryVO bsaInformationEntryVO) throws EventException {
		try {
			
			if("PM1".equals(bsaInformationEntryVO.getRlaneCd().substring(0, 3)) ||
					"IMU".equals(bsaInformationEntryVO.getRlaneCd().substring(0, 3)) ||
					"PSG".equals(bsaInformationEntryVO.getRlaneCd().substring(0, 3))
					){
				return dbDao.searchBsaInformationEntryListForTargetExcelDulTrd(bsaInformationEntryVO);				
			}else{
				return dbDao.searchBsaInformationEntryListForTargetExcel(bsaInformationEntryVO);				
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * BSA Information Entry 신규입력 등록 한다.
	 *
	 * @param BsaInformationEntryVO[] bsaInformationEntryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBsaInformationEntryList(BsaInformationEntryVO[] bsaInformationEntryVOs, SignOnUserAccount account) throws EventException {
		try {
			List<BsaInformationEntryVO> insertVoList = new ArrayList<BsaInformationEntryVO>();
			List<BsaInformationEntryVO> updateVoList = new ArrayList<BsaInformationEntryVO>();
			List<BsaInformationEntryVO> deleteVoList = new ArrayList<BsaInformationEntryVO>();
									
			for ( int i=0; i<bsaInformationEntryVOs.length; i++ ) {
				bsaInformationEntryVOs[i].setUpdUsrId(account.getUsr_id());
				
				// YYYY-WW와 Date, RDR Port를 가져옴.
				List<BsaInformationEntryVO> yyyyList = dbDao.searchBsaInformationYyyyWwDt(bsaInformationEntryVOs[i]);
				
				for(int j=0; j<yyyyList.size(); j++){
					bsaInformationEntryVOs[i].setYrwk(yyyyList.get(j).getYrwk());
					bsaInformationEntryVOs[i].setRevPortEtdDt(yyyyList.get(j).getRevPortEtdDt());
					if (! bsaInformationEntryVOs[i].getIbflag().equals("U")){
						bsaInformationEntryVOs[i].setJoRdrPortCd(yyyyList.get(j).getJoRdrPortCd());
					}
				}
				
				if ( bsaInformationEntryVOs[i].getIbflag().equals("I")){					
					insertVoList.add(bsaInformationEntryVOs[i]);
				}else if ( bsaInformationEntryVOs[i].getIbflag().equals("U")){
					updateVoList.add(bsaInformationEntryVOs[i]);
				}else if ( bsaInformationEntryVOs[i].getIbflag().equals("D")){
					deleteVoList.add(bsaInformationEntryVOs[i]);
				}
				
			}  // END FOR
												
			if ( insertVoList.size() > 0 ) {
//				2016.03.15 DELETE METHOD주석처리 단순 ROW ADD시 모든 VVD삭제
//				for(int i=0; i<insertVoList.size(); i++){
//					dbDao.deleteBsaInformationEntry(insertVoList.get(i));
//				}				
				for(int i2=0; i2<insertVoList.size(); i2++){
					dbDao.addBsaInformationEntryHis(insertVoList.get(i2));			// 추가				
					dbDao.addBsaInformationEntry(insertVoList.get(i2));					
				}				
			}
			
			if ( updateVoList.size() > 0 ) {
				//History 저장												
				dbDao.addBsaInformationEntryHisList(updateVoList);				
				dbDao.modifyBsaInformationEntryList(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				//History 저장
				dbDao.addBsaInformationEntryHisList(deleteVoList);				
				dbDao.removeBsaInformationEntryList(deleteVoList);
			}
			
/*			
AS-IS 소스 시작			
			bsaInformationEntryVO.setUpdUsrId(account.getUsr_id());
			BsaInformationParmVO bsaInformationParmVO  = new BsaInformationParmVO();
			String voyCheck = "";
				
			//변경된 데이터가 있는 경우에도 신규로 저장하고 기존 데이터는 JO_VER_FLG값만 업데이트
				if (bsaInformationEntryVO.getIbflag().equals("I") || (bsaInformationEntryVO.getIbflag().equals("U"))){
					String oldJoVerNo = dbDao.searchBsaInformationEntryLastVersion(bsaInformationParmVO);
					bsaInformationParmVO.setOldJoVerNo(oldJoVerNo);		
						if (bsaInformationEntryVO.getIbflag().equals("I")) {
							// 2013. 01. 21 이수진
							// 신규 버젼 생성시를 제외하고, 기존 버젼을  UP하고자 할때 이전 버젼의 EDN VVD, PORT가 존재해야만 한다. 그렇지 않은 경우에는 저장되지 않도록 한다.
							
							String joVerNo = dbDao.searchBsaInformationEntryVersionChk(bsaInformationEntryVO.getVslCd(), bsaInformationEntryVO.getSkdDirCd(), bsaInformationEntryVO.getPortCd(), bsaInformationEntryVO.getPortSeq(), bsaInformationEntryVO.getJoCrrCd(), bsaInformationEntryVO.getRlaneCd());
							String zeroJoVerNo = joVerNo.replace(" ", "");
							
							//VESSEL, DIRECTION, PORT, PORT SEQ., CARRIER 가 같지않은 경우에만 JO_BSA_REF_NO신규생성
							//bsaInformationEntryVO.setJoVerNo(joVerNo.replace(" ", ""));

					

							if( !oldJoVerNo.equals("0")){
								// 이전 버젼에 END VVD, Port 정보가 있는지 유무를 파악한다.
								String beforeVvd = dbDao.searchBsaInformationEntryJoBeforeVVD(bsaInformationParmVO);
								
								if(beforeVvd == null || beforeVvd.length()< 4){
									throw new EventException(new ErrorHandler("JOO10012", new String[]{vslCd +"," + skdDirCd +","+ portCd+"," +portSeq+"," +rlaneCd+"," +joCrrCd+","+ oldJoVerNo}).getMessage());
								} 
			                     voyCheck = dbDao.checkVoyage(bsaInformationParmVO);
								
								if(voyCheck.equals("N")){
									throw new EventException(new ErrorHandler("JOO10014", new String[]{vslCd +"," + skdDirCd +","+ portCd+"," +portSeq+"," +rlaneCd+"," +joCrrCd}).getMessage());
								} 
	
							}
							
							//VESSEL, DIRECTION, PORT, PORT SEQ., CARRIER 가 같지않은 경우에만 JO_BSA_REF_NO신규생성							
							//JO_BSA_REF_NO = VSL_CD + RLANE_CD + SKD_DIR_CD + PORT_CD+ PORT_SEQ+ JO_VER_NO + 001(순번)
							//bsaInformationEntryVO.setJoBsaRefNo(
							//		bsaInformationEntryVO.getVslCd() + "-" + 
							//		bsaInformationEntryVO.getRlaneCd() + "-" +
							//		bsaInformationEntryVO.getSkdDirCd() + "-" + 
							//		bsaInformationEntryVO.getPortCd() + "-" +
							//		bsaInformationEntryVO.getPortSeq() + "-" +
							//		bsaInformationEntryVO.getJoCrrCd() + "-" +
							//		nextVoyNo(zeroJoVerNo));				

							
						}
						
						if (bsaInformationEntryVO.getIbflag().equals("U")) {
							//if( (!oldJoVerNo.equals("0") && !"".equals(stSkdVoyNo)) || (!"".equals(stSkdVoyNo) && !"".equals(endSkdVoyNo) )){
						          voyCheck = dbDao.checkVoyage(bsaInformationParmVO);
						
						        if(voyCheck.equals("N")){
							       throw new EventException(new ErrorHandler("JOO10014", new String[]{vslCd +"," + skdDirCd +","+ portCd+"," +portSeq+"," +rlaneCd+"," +joCrrCd}).getMessage());
						         } 	
						    //}
						}	
					String joBsaRefSeq = dbDao.searchBsaInformationEntryJoBsaRefSeq(bsaInformationEntryVO.getJoBsaRefNo());
					
					bsaInformationEntryVO.setJoBsaRefSeq(joBsaRefSeq);
					//log.debug("BC===+bsaInformationEntryVO.getIbflag()"+bsaInformationEntryVO.getIbflag());
					
					if (bsaInformationEntryVO.getIbflag().equals("U")) {
						updateVoList.add(bsaInformationEntryVO);
						dbDao.modifyBsaInformationEntryList(updateVoList);
					}
					
					
					//시작
					insertVoList.add(bsaInformationEntryVO);
					dbDao.addBsaInformationEntryList(insertVoList);
					
					if (bsaInformationEntryVO.getIbflag().equals("I")) {
					
//					// Row copy시 BSA Entry화면에 Add BSA 정보가 Add Carrier Table에 자동 생성되도록.
//						if( (!"".equals(joBsaRefNoCopy) && Integer.parseInt(joBsaAddTeuQty) > 0) ){
							dbDao.addBsaAddTeuQtyCopy(bsaInformationEntryVO);
//						}				
					}
					
					// Add Carrier Flag가 "N"인 경우 JOO_BSA_ADD_CRR 테이블의 Verson Flag를 "N"으로 update 한다.(삭제개념)
					if(bsaInformationEntryVO.getJoAddBsaCrrFlg().equals("N")){
						modifyVoList.add(bsaInformationEntryVO);
//						dbDao.modifyBsaCarrierList(insertVoList);
						dbDao.modifyExcelBsaCarrieList(modifyVoList);
					}
									
					
				} 

				else if (bsaInformationEntryVO.getIbflag().equals("D")) {
					deleteVoList.add(bsaInformationEntryVO);
					dbDao.removeBsaInformationEntryList(deleteVoList);
				}
AS-IS 소스 끝
*/
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * BSA Information Add Carrier 신규입력 등록 한다.  
	 *
	 * @param BsaInformationEntryVO[] bsaInformationEntryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAddCarrierList(BsaInformationEntryVO[] bsaInformationEntryVOs, SignOnUserAccount account) throws EventException {
		try {
			List<BsaInformationEntryVO> insertVoList = new ArrayList<BsaInformationEntryVO>();
			//List<BsaInformationEntryVO> updateVoList = new ArrayList<BsaInformationEntryVO>();
			
			for ( int i=0; i<bsaInformationEntryVOs.length; i++ ) {
				//VVD+Port+Seq(vvd_port) 값으로 VVD, Port, Seq 로 나누기
				//VSL_CD(V4), SKD_VOY_NO(V4), SKD_DIR_CD(V1)은 고정되어 있음
				bsaInformationEntryVOs[i].setVslCd( bsaInformationEntryVOs[i].getVvdPort().substring(0, 4) );
				bsaInformationEntryVOs[i].setSkdVoyNo( bsaInformationEntryVOs[i].getVvdPort().substring(4, 8) );
				bsaInformationEntryVOs[i].setSkdDirCd( bsaInformationEntryVOs[i].getVvdPort().substring(8, 9) );
				//PORT_CD(V5)는 코드값 5자리 또는 'ALL'(3자리) / PORT_SEQ(N3)은 1~3자리 올 수 있음
				
				if ("ALL".equalsIgnoreCase(bsaInformationEntryVOs[i].getVvdPort().substring(9,12))) {
					bsaInformationEntryVOs[i].setPortCd("ALL");
					bsaInformationEntryVOs[i].setPortSeq( bsaInformationEntryVOs[i].getVvdPort().substring(12, bsaInformationEntryVOs[i].getVvdPort().length()-3) );					
					
				} else {
					bsaInformationEntryVOs[i].setPortCd( bsaInformationEntryVOs[i].getVvdPort().substring(9, 14) );
					bsaInformationEntryVOs[i].setPortSeq( bsaInformationEntryVOs[i].getVvdPort().substring(14, bsaInformationEntryVOs[i].getVvdPort().length()-3) );
				}	
				//JOC_CRR_CD(V3) 구하기
				bsaInformationEntryVOs[i].setJoCrrCd(bsaInformationEntryVOs[i].getVvdPort().substring(bsaInformationEntryVOs[i].getVvdPort().length()-3));
				
				bsaInformationEntryVOs[i].setUpdUsrId(account.getUsr_id());
				if ( bsaInformationEntryVOs[i].getIbflag().equals("I") || bsaInformationEntryVOs[i].getIbflag().equals("U")){
					insertVoList.add(bsaInformationEntryVOs[i]);
				}
				//기존 Key값 데이터 삭제
				dbDao.delExcelBsaCarrieList(bsaInformationEntryVOs[i]);
			}  // END FOR
			
			
			if ( insertVoList.size() > 0 ) {
				
				dbDao.addExcelBsaCarrieList(insertVoList);	
				dbDao.modifyAddBsaCarrieList(insertVoList);
			}
/*
AS-IS 소스 시작
			//모든 데이터 신규로 저장하고 기존 데이터는 JO_VER_FLG값만 업데이트 (Y->N)
			for ( int i=0; i<bsaInformationEntryVOs.length; i++ ) {
				List<BsaInformationEntryVO> modifyVoList = new ArrayList<BsaInformationEntryVO>();

				
				String refNo    = bsaInformationEntryVOs[i].getJoBsaRefNo();
				String joCrrCd  = bsaInformationEntryVOs[i].getJoCrrCd();
								
				if ( bsaInformationEntryVOs[i].getIbflag().equals("I")){
					
					// Ref No가 존재하는를 체크하여 존재하면 메세지를 보여주고 종료한다.
					String refNoCnt = dbDao.searchBsaInformationEntryExistRefNo(refNo, joCrrCd);
					
					if(Integer.parseInt(refNoCnt) > 0) {
						throw new EventException(new ErrorHandler("JOO10013", new String[]{refNo+"," +joCrrCd}).getMessage());
					} 			 
					
					//
					bsaInformationEntryVOs[i].setUpdUsrId(account.getUsr_id());
				    int joBsaAddRefSeqVal = 1;
				    bsaInformationEntryVOs[i].setJoBsaAddRefSeq(Integer.toString(joBsaAddRefSeqVal));
					
					insertVoList.add(bsaInformationEntryVOs[i]);
					modifyVoList.add(bsaInformationEntryVOs[i]);
//					dbDao.modifyAddBsaCarrieList(modifyVoList); NOW
					
				}else if ( bsaInformationEntryVOs[i].getIbflag().equals("U")){
					bsaInformationEntryVOs[i].setUpdUsrId(account.getUsr_id());
					String joBsaAddRefSeq = dbDao.searchBsaCarrieListChk(bsaInformationEntryVOs[i].getJoBsaRefNo());
					int joBsaAddRefSeqVal = 0;
					joBsaAddRefSeqVal = Integer.parseInt(joBsaAddRefSeq)+1;
					bsaInformationEntryVOs[i].setJoBsaAddRefSeq(Integer.toString(joBsaAddRefSeqVal));
					
					updateVoList.add(bsaInformationEntryVOs[i]);
					modifyVoList.add(bsaInformationEntryVOs[i]);

				}
				
			}  // END FOR
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addExcelBsaCarrieList(insertVoList);	
				dbDao.modifyAddBsaCarrieList(insertVoList);  // 2.22 추가
			}
			
			if ( updateVoList.size() > 0 ) {
				//dbDao.modifyExcelBsaCarrieList(updateVoList);	
				dbDao.addExcelBsaCarrieList(updateVoList);
				dbDao.modifyAddBsaCarrieList(updateVoList);  // 2.22 추가
			}
AS-IS 소스 끝
*/
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	
	
	
	
	
	
	
	/**
	 * 주어진 자연수 타입 문자열의 길이가 4이하인 경우, 지정한 수만큼 증가시키고 좌측을 0으로 채운다.
	 * 예) "14" ==> "0014"
	 * 
	 * @param String voyNo 자연수 타입의 문자열
	 * @return String
	 */
	public String nextVoyNo(String voyNo){		
		int iVoyNo = (voyNo==null || voyNo.length()==0) ? 0 : Integer.parseInt(voyNo);
		
		//String nextVoyNo = Integer.toString(iVoyNo);
		StringBuffer nextVoyNo = new StringBuffer();
		nextVoyNo.append(Integer.toString(iVoyNo));
		
		String tmp = "0";
		while(nextVoyNo.length()<3){
			//nextVoyNo = tmp + nextVoyNo;
			nextVoyNo.append(tmp);
		}		
		return nextVoyNo.toString();		
	}
	

	/**
	 * BSA Information Entry History를 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws EventException
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryHistoryList(BsaInformationEntryVO bsaInformationEntryVO) throws EventException {
		try {
			return dbDao.searchBsaInformationEntryHistoryList(bsaInformationEntryVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry", "Retrieve"}).getMessage(), ex);
		}
	}


	/**
	 * BSA Information Entry Add Carrier를 조회한다.
	 * @param BsaCarrieHistoryVO bsaCarrieHistoryVO
	 * @return List<BsaCarrieHistoryVO>
	 * @throws EventException
	 */
	public List<BsaCarrieHistoryVO> searchAddBsaCarrieList(BsaCarrieHistoryVO bsaCarrieHistoryVO) throws EventException {
		try {
			return dbDao.searchAddBsaCarrieList(bsaCarrieHistoryVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"BSA Information Entry", "Retrieve"}).getMessage(), ex);
		}
	}
		
	/**
	 * BSA Information Entry Add Carrier를 신규입력 등록 한다.
	 *
	 * @param BsaCarrieHistoryVO bsaCarrieHistoryVO
	 * @param BsaCarrieHistoryVO[] bsaCarrieHistoryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAddBsaCarrieList(BsaCarrieHistoryVO bsaCarrieHistoryVO, BsaCarrieHistoryVO[] bsaCarrieHistoryVOs, SignOnUserAccount account) throws EventException {
		List<BsaCarrieHistoryVO> insertVoList = new ArrayList<BsaCarrieHistoryVO>();
//		List<BsaCarrieHistoryVO> updateVoList = new ArrayList<BsaCarrieHistoryVO>();
		try {
			//저장하기 전에 Key값에 해당하는 데이터 모두 삭제
			dbDao.delBsaCarrieList(bsaCarrieHistoryVO);
			for (int i=0;i < bsaCarrieHistoryVOs.length;i++) {
				bsaCarrieHistoryVOs[i].setUpdUsrId(account.getUsr_id());
				bsaCarrieHistoryVOs[i].setVslCd(bsaCarrieHistoryVO.getVslCd());
				bsaCarrieHistoryVOs[i].setSkdVoyNo(bsaCarrieHistoryVO.getSkdVoyNo());
				bsaCarrieHistoryVOs[i].setSkdDirCd(bsaCarrieHistoryVO.getSkdDirCd());
				bsaCarrieHistoryVOs[i].setPortCd(bsaCarrieHistoryVO.getPortCd());
				bsaCarrieHistoryVOs[i].setPortSeq(bsaCarrieHistoryVO.getPortSeq());	
				bsaCarrieHistoryVOs[i].setJoCrrCd(bsaCarrieHistoryVO.getJoCrrCd());				
				//모든 데이터 신규로 저장하고 기존 데이터는 JO_VER_FLG값만 업데이트 (Y->N)
//					bsaCarrieHistoryVOs[i].setUpdUsrId(account.getUsr_id());
//					if (bsaCarrieHistoryVOs[i].getUdpFlg().equals("U")) {
//						updateVoList.add(bsaCarrieHistoryVOs[i]);
//						dbDao.modifyBsaCarrieList(updateVoList);
//					} else if (bsaCarrieHistoryVOs[i].getUdpFlg().equals("I")) {
//						String joBsaRefNo = bsaCarrieHistoryVOs[i].getVslCd()+bsaCarrieHistoryVOs[i].getSkdVoyNO()+bsaCarrieHistoryVOs[i].getSkdDirCd()+bsaCarrieHistoryVOs[i].getPortCd()+bsaCarrieHistoryVOs[i].getPortSeq();
//						String joBsaAddRefSeq = dbDao.searchBsaCarrieListChk(joBsaRefNo);
//						int joBsaAddRefSeqVal = 0;
//						joBsaAddRefSeqVal = Integer.parseInt(joBsaAddRefSeq)+1;
//						bsaCarrieHistoryVOs[i].setJoBsaAddRefSeq(Integer.toString(joBsaAddRefSeqVal));
						insertVoList.add(bsaCarrieHistoryVOs[i]);
//					}
			}
			// 새로 신규 저장
			dbDao.addBsaCarrieList(insertVoList);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 

	/**
	 * Additional Slot Manage 정보를 조회한다.
	 * @param AdditionalSlotManageVO additionalSlotManageVO
	 * @return List<additionalSlotManageVO>
	 * @throws EventException
	 */
	public List<AdditionalSlotManageVO> searchAdditionalSlotManage(AdditionalSlotManageVO additionalSlotManageVO) throws EventException {
		try {
			return dbDao.searchAdditionalSlotManage(additionalSlotManageVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Retrieve"}).getMessage(), ex);

		}
	}

	/**
	 * Additional Slot Manage정보를 저장한다.
	 * @param AdditionalSlotManageVO[] additionalSlotManageVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageAdditionalSlotManage(AdditionalSlotManageVO[] additionalSlotManageVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<AdditionalSlotManageVO> insertVoList = new ArrayList<AdditionalSlotManageVO>();
			List<AdditionalSlotManageVO> updateVoList = new ArrayList<AdditionalSlotManageVO>();
			List<AdditionalSlotManageVO> deleteVoList = new ArrayList<AdditionalSlotManageVO>();
			
			for (int inx=0; inx<additionalSlotManageVOs.length; inx++){
				
				if ("I".equals(additionalSlotManageVOs[inx].getIbflag())){
					additionalSlotManageVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					additionalSlotManageVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(additionalSlotManageVOs[inx]);
				}else if("U".equals(additionalSlotManageVOs[inx].getIbflag())){
					additionalSlotManageVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(additionalSlotManageVOs[inx]);
				}else if("D".equals(additionalSlotManageVOs[inx].getIbflag())){
					additionalSlotManageVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					deleteVoList.add(additionalSlotManageVOs[inx]);
				}
				
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addAdditionalSlotManageS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAdditionalSlotManageS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeAdditionalSlotManageS(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * Blank Voyage Status 정보를 저장한다.
	 * @param BlkVygSttsVO[] BlkVygSttsVOS
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageBlankVoyageStatus(BlkVygSttsVO[] blkVygSttsVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<BlkVygSttsVO> insertVoList = new ArrayList<BlkVygSttsVO>();
			List<BlkVygSttsVO> updateVoList = new ArrayList<BlkVygSttsVO>();
			
			for (int inx=0; inx<blkVygSttsVOs.length; inx++){
				if ("I".equals(blkVygSttsVOs[inx].getIbflag())){
					blkVygSttsVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					blkVygSttsVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(blkVygSttsVOs[inx]);
				}else if("U".equals(blkVygSttsVOs[inx].getIbflag())){
					blkVygSttsVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(blkVygSttsVOs[inx]);
				}else if("D".equals(blkVygSttsVOs[inx].getIbflag())){
					blkVygSttsVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					blkVygSttsVOs[inx].setDeltFlg("Y");
					updateVoList.add(blkVygSttsVOs[inx]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addBlankVoyageStatus(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyBlankVoyageStatus(updateVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Save"}).getMessage(), ex);
		}
	}
	

	/**
	 * Blank Voyage Status 정보를 조회한다.
	 * @param BlkVygSttsVO blkVygSttsVO
	 * @return List<BlkVygSttsVO>
	 * @throws EventException
	 */
	public List<BlkVygSttsVO> searchBlankVoyageStatus(BlkVygSttsVO blkVygSttsVO) throws EventException {
		try {
			return dbDao.searchBlankVoyageStatus(blkVygSttsVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Merge", "Retrieve"}).getMessage(), ex);

		}
	}
}