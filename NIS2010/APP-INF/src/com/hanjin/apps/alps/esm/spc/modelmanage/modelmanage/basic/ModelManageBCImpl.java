/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageBCImpl.java
*@FileTitle : Modelship by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.17 진마리아
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.05.06 [CHM-201324211-01] 프로젝트 안정화 및 HELP DESK - SMP Season Creation 배치->backend로 변경
* 2013.07.01 [선처리] ALPS ERROR LOG 관련, SMP IMPORT시 EXCEL UPLOAD 기능으로 인해 CUSTOMER SEQUENCE에 문자열이 들어가면 에러처리
* 2013.07.25 [CHM-201325929-01] SMP save 후 Yield Group변경시, SPC_MDL_CUST_REV_LANE UPDATE
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청
* 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
* 2014.11.13 박은주 [CHM-201432794] SMP 사용 편의기능 보완 요청(RHQ Add/DEL, OFC/Lane Load Guide가 0 인것들 일과 삭제, RHQ Load Guide 변경시 OFC Load Guide 배부로직 제거)
* 2015.01.29 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가
* 2015.06.18 박은주 Save 오류 수정 
* 2015.07.03 이혜민 [CHM-201536449] SMP Load Guide Summary 오류 수정(주석 추가)
* 2015.07.23 이혜민 [CHM-201536881] SMP 보완 요청 (1.Import 팝업 Acct.add시 계약번호 Valid 및 MVC, C.OFC 가져옴. 2.Amend 팝업 계약번호 중복체크)
* 2015.09.15 이혜민 [CHM-201537538] SMP 오류 수정 건 및 Sub Trade Add 기능 추가
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.basic;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration.ModelManageDBDAO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustCtrlGrpVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.CustManageVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.ModelPfmcVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SearchModelManageListVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpCustHisVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpHisVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SmpRptVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcBkgCmpbVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SpcHdHulVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcMdlCustRevLaneHisVO;
import com.hanjin.syscommon.common.table.SpcMdlExptWkVO;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;


/**
 * ALPS-ModelManage Business Logic Command Interface<br>
 * - ALPS-ModelManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0090EventResponse, ModelManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ModelManageBCImpl extends BasicCommandSupport implements ModelManageBC {

	// Database Access Object
	private transient ModelManageDBDAO dbDao = null;

	/**
	 * ModelManageBCImpl 객체 생성<br>
	 * ModelManageDBDAO를 생성한다.<br>
	 */
	public ModelManageBCImpl() {
		dbDao = new ModelManageDBDAO();
	}

	/**
	 * 해당 Season,Version의 Performance(최초) 또는 SMP 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchModelManageListVO>
	 * @exception EventException
	 */
	public List<SearchModelManageListVO> searchModelList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchModelList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Season/Version에 등록되어 있는 Modelship Account를 조회합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return List<CustManageVO>
	 * @exception EventException
	 */
	public List<CustManageVO> searchModelshipAcctList(CustManageVO custManageVO) throws EventException {
		try {
			return dbDao.searchModelshipAcctList(custManageVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 선택된 Customer, SC 에 대한 Sub Trade별, 노선별 PFMC를 조회합니다.<br>
	 * 
	 * @param ModelPfmcVO modelPfmcVO
	 * @return List<ModelPfmcVO>
	 * @exception EventException
	 */
	public List<ModelPfmcVO> searchWeeklyAvgPfmc(ModelPfmcVO modelPfmcVO) throws EventException {
		try {
			return dbDao.searchWeeklyAvgPfmc(modelPfmcVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Season/Version 미컨펌시 Account 정보를 수정 / 컨펌시 version up 하며 Account 정보를 등록합니다.<br>
	 * ESM_SPC_0095 Import 화면에서 Save시 적용
	 * 
	 * @param CustManageVO[] custManageVOs
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> manageModelshipAcctList(CustManageVO[] custManageVOs, SignOnUserAccount account) throws EventException {
		List<String> errList = new ArrayList<String>();
		try {
			if(custManageVOs != null){
				String season = null;
				String[] rtnVer = new String[2];
				String lastestVer = null;
				String lastestCfmFlg = null;
				String newVer = null;
				String popYn = custManageVOs[0].getPopYn(); // Y-성수기
				String trade = custManageVOs[0].getTrade();
				String allSave = custManageVOs[0].getAllSave(); // Y - excel import 사용
				
				
				if("Y".equals(popYn)){
					season = custManageVOs[0].getCostYrwk();
					rtnVer = dbDao.searchLastestVer(trade, season, "");
					lastestVer = rtnVer[0];
					lastestCfmFlg = rtnVer[1];
				}else{ //비수기 하드코딩
					season = "200001";
					lastestVer = "1";
					lastestCfmFlg = "";
				}
				
				if("Y".equals(lastestCfmFlg)){
					newVer = Integer.toString(Integer.parseInt(lastestVer)+1);
				}else{
					newVer = lastestVer;
				}
				
				errList.add(newVer);//신규 version으로 화면에서 재조회하기 위해 return.

				List<CustManageVO> insertVOList = new ArrayList<CustManageVO>();
				List<SmpCustHisVO> hisList = new ArrayList<SmpCustHisVO>();
				CustManageVO tempVo = new CustManageVO();
				
				for(CustManageVO mainVO : custManageVOs){
					mainVO.setTrade(trade);
					mainVO.setCostYrwk(season);
					mainVO.setVerSeq(newVer);
					
					String[] sub_trd_cd = (mainVO.getSubTrdCd()).split(",");
					
					for( int j=0; j<sub_trd_cd.length; j++) {
						
						checkCustSeqNumber(mainVO);
						
						CustManageVO infoVO = dbDao.searchAcctEtcData(mainVO);//searchAcctEtcData
						
						// AES/IAS 이면서 SC 값 일 경우 화면에서 RFA_NO 로 넘어온 값이 SC_NO 이므로 값 변환
						if ( ("AES".equals(mainVO.getTrade()) || "IAS".equals(mainVO.getTrade())) && infoVO!=null) {
							if ( "SC".equals(mainVO.getScRfaFlg()) || ( "I".equals(mainVO.getIbflag()) && !"".equals(infoVO.getScNo())) ) {
								mainVO.setScNo(mainVO.getRfaNo());
								mainVO.setRfaNo("");
							}
						}
						
						SmpCustHisVO hisVO = new SmpCustHisVO();
						if(!"D".equals(mainVO.getIbflag())){
							
							if(infoVO==null){
								if(!"I".equals(mainVO.getIbflag())){	//화면상에 존재했던 data가 invalid한 경우 history에 삭제처럼 남긴다.
									//errHistory
									hisVO.setTrdCd(mainVO.getTrade());
									hisVO.setSubTrdCd(sub_trd_cd[j]);
									hisVO.setCostYrwk(mainVO.getCostYrwk());
									hisVO.setVerSeq(mainVO.getVerSeq());
									hisVO.setOldCustCd(mainVO.getCustCd());
									hisVO.setOldScNo(mainVO.getScNo());
									hisVO.setOldRfaNo(mainVO.getRfaNo());
									hisVO.setOldCustCtrlCd(mainVO.getCustCtrlCd());
									hisVO.setCngItmNm("Invalid Data");
									hisVO.setOldWkMqcQty(mainVO.getWkMqcQty());
									hisList.add(hisVO);
								}
								errList.add(mainVO.getSeq());
							}else{
								if ( "TPS".equals(mainVO.getTrade()) || "AES".equals(mainVO.getTrade()) || "IAS".equals(mainVO.getTrade()) ) {
									if("".equals(mainVO.getWkMqcQty()) || mainVO.getWkMqcQty()==null){
										mainVO.setWkMqcQty(infoVO.getWkMqcQty());
									}
								}
								if("".equals(mainVO.getCustCd()) || mainVO.getCustCd()==null){
									mainVO.setCustCd(infoVO.getCustCd());
								}
								if("".equals(mainVO.getCustGrpId()) || mainVO.getCustGrpId()==null){
									mainVO.setCustGrpId(infoVO.getCustGrpId());
								}
								

								if("R".equals(mainVO.getIbflag())){
									tempVo = (CustManageVO) mainVO.clone();
									tempVo.setSubTrdCd(sub_trd_cd[j]);
									insertVOList.add(tempVo);
								}else if("I".equals(mainVO.getIbflag())){
									hisVO.setTrdCd(mainVO.getTrade());
									hisVO.setSubTrdCd(sub_trd_cd[j]);
									hisVO.setCostYrwk(mainVO.getCostYrwk());
									hisVO.setVerSeq(mainVO.getVerSeq());
									hisVO.setCustCd(mainVO.getCustCd());
									hisVO.setScNo(mainVO.getScNo());
									hisVO.setRfaNo(mainVO.getRfaNo());
									hisVO.setCustCtrlCd(mainVO.getCustCtrlCd());
									if("Y".equals(allSave)){
										hisVO.setCngItmNm("Import");
									}else{
										hisVO.setCngItmNm("ADD");
									}
									hisVO.setWkMqcQty(mainVO.getWkMqcQty());
									hisList.add(hisVO);
									
									tempVo = (CustManageVO) mainVO.clone();
									tempVo.setSubTrdCd(sub_trd_cd[j]);
									insertVOList.add(tempVo);
								}else if("U".equals(mainVO.getIbflag())){
									tempVo = (CustManageVO) mainVO.clone();
									tempVo.setSubTrdCd(sub_trd_cd[j]);
									hisVO = dbDao.searchSmpCustOldData(tempVo, lastestVer);
									
									String cngMvc = "";
									String cngCate = "";
									if(!hisVO.getWkMqcQty().equals(hisVO.getOldWkMqcQty())){
										cngMvc = "Y";
									}
									if(!hisVO.getCustCtrlCd().equals(hisVO.getOldCustCtrlCd())){
										cngCate = "Y";
									}
									if("Y".equals(cngMvc) && "Y".equals(cngCate)){
										hisVO.setCngItmNm("MVC, Level");
									}else if("Y".equals(cngMvc)){
										hisVO.setCngItmNm("MVC");
									}else{
										hisVO.setCngItmNm("Level");
									}
									
									hisVO.setSubTrdCd(sub_trd_cd[j]);
									hisList.add(hisVO);
									
									insertVOList.add(tempVo);
								}
							}
						}else{ //ibflag : D
							hisVO.setTrdCd(mainVO.getTrade());
							hisVO.setSubTrdCd(sub_trd_cd[j]);
							hisVO.setCostYrwk(mainVO.getCostYrwk());
							hisVO.setVerSeq(mainVO.getVerSeq());
							hisVO.setOldCustCd(mainVO.getCustCd());
							hisVO.setOldScNo(mainVO.getScNo());
							hisVO.setOldRfaNo(mainVO.getRfaNo());
							hisVO.setOldCustCtrlCd(mainVO.getCustCtrlCd());
							hisVO.setCngItmNm("DEL");
							hisVO.setOldWkMqcQty(mainVO.getWkMqcQty());
							hisList.add(hisVO);
						}
					}
				}
				
				if("Y".equals(lastestCfmFlg)){
					//1.최신버전의 master insert
					dbDao.addMdlVerMst(trade, season, newVer, account.getUsr_id());
					//2.최신버전의 account Amend His 정보를 그대로 insert
					dbDao.addModelshipAcctAmendHisCopy(trade, season, newVer, account.getUsr_id());
					//3.기version의 REV_LANE 데이터를 전부 copy
					dbDao.addModelRevLaneCopy(trade, season, newVer, account.getUsr_id());
				}else{ //미컨펌된 version 정보가 존재하면, account 정보를 삭제. & 비수기
					CustManageVO delVO = new CustManageVO();
					delVO.setTrade(trade);
					delVO.setCostYrwk(season);
					delVO.setVerSeq(newVer);
					dbDao.deleteModelshipAcctList(delVO);
				}
				
				if(hisList.size()>0){
					Date today=new Date();
					SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddkkmmss");
					String modiGdt = formater.format(today);
					for(SmpCustHisVO vo : hisList){
						vo.setModiGdt(modiGdt);
						vo.setUsrId(account.getUsr_id());
						dbDao.addSmpCustHis(vo);
					}
				}
				
				for(CustManageVO vo : insertVOList){
					if(!"D".equals(vo.getIbflag())){
						vo.setCreUsrId(account.getUsr_id());
						int insCnt = dbDao.addModelshipAcct(vo);
						if(insCnt==0){
							errList.add(vo.getSeq());
						}
					}
				}
				
				//이전 ver의 acct에는 있었으나, 새로운 ver의 acct에는 해당하지 않는 경우의 rev_lane 삭제
				dbDao.deleteDelAcctRevLane(trade, season, newVer);
				
				//account yield group 이 SMP Main 입력해 둔 정보와 달라지는 경우, 기존재하는 smp data 내 yield group을 변경
				dbDao.modifyExistSmpYieldGroup(trade, season, newVer, account.getUsr_id());
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return errList;
	}
	

	/**
	 * SMP 저장을 BackEnd Job으로 변경
	 * 
	 * @param searchModelManageListVOs
	 * @param account
	 * @return
	 */
	public String multSMP(SearchModelManageListVO[] searchModelManageListVOs, SignOnUserAccount account) throws EventException{
		ModelManageBackEndJob backEndJob = new ModelManageBackEndJob();
		backEndJob.setSignOnUserAccount(account);
		backEndJob.setSearchModelManageListVOs(searchModelManageListVOs);
		backEndJob.setJobType("Save");
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "SMP Season - Save");		
        } catch (Exception ex) {
        	throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Space Management Plan 을 수립합니다.(H/O & RHQ)<br>
	 * 
	 * @param SearchModelManageListVO[] searchModelManageListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSpaceManagementPlan(SearchModelManageListVO[] searchModelManageListVOs, SignOnUserAccount account) throws EventException {
		try {
			if(searchModelManageListVOs != null){
				String[] rtnVer = new String[2];
				String lastestVer = null;
				String lastestCfmFlg = null;
				String newVer = null;
				
				String trade = searchModelManageListVOs[0].getTrdCd();
				String season = searchModelManageListVOs[0].getSeason();
				String verSeq = searchModelManageListVOs[0].getVersion();
//				String viewType = searchModelManageListVOs[0].getViewType();
				String unitCd = searchModelManageListVOs[0].getUnit();
				rtnVer = dbDao.searchLastestVer(trade, season, verSeq);
				lastestVer = rtnVer[0];
				lastestCfmFlg = rtnVer[1];
				
				if("Y".equals(lastestCfmFlg)){ 	//기컨펌된 경우. version up
					newVer = Integer.toString(Integer.parseInt(lastestVer)+1);
					//1.최신버전의 master insert
					dbDao.addMdlVerMst(trade, season, newVer, account.getUsr_id());
					//1.1 Exception Week를 insert Confirm 받을때 입력 받기때문에 copy가 필요 없다.
					//dbDao.addSpcMdlExptWkNew(trade, season, newVer, account.getUsr_id());
					
					
					//2.최신버전의 account 정보를 그대로 insert
					dbDao.addModelshipAcctCopy(trade, season, newVer, account.getUsr_id());
					//3.최신버전의 account Amend His 정보를 그대로 insert
					dbDao.addModelshipAcctAmendHisCopy(trade, season, newVer, account.getUsr_id());
					//4.기version의 REV_LANE 데이터를 전부 copy
					dbDao.addModelRevLaneCopy(trade, season, newVer, account.getUsr_id());
					//5.화면에서의 정보를 저장 (HO / RHQ 분리)
//					if("H".equals(viewType)){ //HO
//						addSpaceManagementPlanHO(trade, season, newVer, account.getUsr_id(), searchModelManageListVOs, unitCd);
//					}else if("R".equals(viewType)){ //RHQ
						//1.화면에서의 정보를 입력 - merge(SC별 key row 때문)
						addSpaceManagementPlanRHQ(trade, season, newVer, account.getUsr_id(), searchModelManageListVOs, unitCd);
//					}else if("L".equals(viewType)){ //Loading OFC
//						addSpaceManagementPlanLOfc(trade, season, newVer, account.getUsr_id(), searchModelManageListVOs, unitCd);
//					}
				}else if("N".equals(lastestCfmFlg)){					//미컨펌된 version 정보가 존재하는 경우. SPC_MDL_CUST_REV_LANE 정보를 삭제
					newVer = lastestVer; //화면에서의 값과 동일
//					if("H".equals(viewType)){ //HO
//						addSpaceManagementPlanHO(trade, season, newVer, account.getUsr_id(), searchModelManageListVOs, unitCd);
//					}else if("R".equals(viewType)){ //RHQ
						//1.화면에서의 정보를 입력 - merge(SC별 key row 때문)
						addSpaceManagementPlanRHQ(trade, season, newVer, account.getUsr_id(), searchModelManageListVOs, unitCd);
//					}else if("L".equals(viewType)){ //Loading OFC
//						addSpaceManagementPlanLOfc(trade, season, newVer, account.getUsr_id(), searchModelManageListVOs, unitCd);
//					}
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 미컨펌 상태의 Space Management Plan(H/O) 정보 수정한 경우, 저장합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String newVer
	 * @param String usrId
	 * @param SearchModelManageListVO[] searchModelManageListVOs
	 * @param String unitCd
	 * @exception EventException
	 */
//	private void addSpaceManagementPlanHO(String trade, String season, String newVer, String usrId, SearchModelManageListVO[] searchModelManageListVOs, String unitCd) throws EventException {
//		try{
//			
////			deleteList  : SPC_MDL_CUST_REV_LANE에 기존재하면서 삭제된 경우
////			modifyList  : SPC_MDL_CUST_REV_LANE에 기존재하면서 수정된 건 update
////			modifyList2 : SPC_MDL_CUST_REV_LANE에 기존재하면서  RHQ Load Guide(=cust_adj_qty)가 수정된 경우(산하 ofc에  RHQ guide값 모두 update)
////			insertList  : SPC_MDL_CUST_REV_LANE에 없고 SPC_MDL_CUST_PERF에만 있어서 조회된 후 저장할때 SPC_MDL_CUST_REV_LANE에 INSERT.	
////			checkList   : RHQ, OFC ADD
//			List<SearchModelManageListVO> deleteList = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> modifyList = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> modifyList2 = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> insertList = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> checkList = new ArrayList<SearchModelManageListVO>();
//
//			List<SearchModelManageListVO> hisMstList = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> hisDtlList = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> raplyFlgList = new ArrayList<SearchModelManageListVO>();
//			
//			String hoFlg = checkHOUser(usrId);
//			for(SearchModelManageListVO vo : searchModelManageListVOs){
//				
//				if ( ("AES".equals(vo.getTrdCd()) || "IAS".equals(vo.getTrdCd())) && "SC".equals(vo.getScRfaFlg()) ) {
//					vo.setScNo(vo.getRfaNo());
//					vo.setRfaNo("");
//				}
//				
//				vo.setTrdCd(trade);
//				vo.setCostYrwk(season);
//				vo.setVerSeq(newVer);
//				vo.setUsrId(usrId);
//				//FEU인 경우, TEU로 변환하여 저장
//				vo.setUnit(unitCd);
//				vo.setHoFlg(hoFlg);
//				if(!"TTL".equals(vo.getSlsRgnOfcCd())){ //TTL Row 아닌경우
//					if("D".equals(vo.getRealIbflag())){
//						vo.setDeltFlg("Y");
//					}
//					//SPC_MDL_CUST_REV_LANE에 기존재하면서 삭제된 경우
//					if("Y".equals(vo.getStrdFlag()) && "D".equals(vo.getRealIbflag())){
//						deleteList.add(vo);
//					}
//					//SPC_MDL_CUST_REV_LANE에 기존재하면서 수정된 경우
//					if("Y".equals(vo.getStrdFlag()) && "U".equals(vo.getRealIbflag())){
//						modifyList.add(vo);
//					}
//					//SPC_MDL_CUST_REV_LANE에 기존재하면서  RHQ Load Guide(=cust_adj_qty)가 수정된 경우(산하 ofc에  RHQ guide값 모두 update)
//					if("Y".equals(vo.getStrdFlag()) && "U".equals(vo.getRealIbflag()) && "Y".equals(vo.getCustAdjQtyUpdFlg())){
//						modifyList2.add(vo);
//					}
//					//SPC_MDL_CUST_REV_LANE에 없고 SPC_MDL_CUST_PERF에만 있어서 조회된 후 저장할때 SPC_MDL_CUST_REV_LANE에 INSERT.	
//					if("N".equals(vo.getStrdFlag())){ 
//						insertList.add(vo);
//					}
//					// RHQ, OFC ADD 
//					if(("".equals(vo.getStrdFlag()) || vo.getStrdFlag() == null) && "I".equals(vo.getRealIbflag())){ 
//						vo.setSpcCtrlMdlMnlCd("O");
//						checkList.add(vo);
//					}
//					//OFC Load guide 값이 바뀐경우
//					if("USER".equals(vo.getG2CngUsr()) || "AUTO".equals(vo.getG2CngUsr())){
//						hisDtlList.add(vo);
//					}
//				}else{
//					//RHQ나 OFC Load guide 값이 바뀐경우
//					if("USER".equals(vo.getG1CngUsr()) || "USER".equals(vo.getG2CngUsr()) ){
//						if("I".equals(vo.getRealIbflag()) && "USER".equals(vo.getG1CngUsr())){
//							//OFC 가 변경되어도 같이 저장이 이루어지기 때문에 Flag와 G1_CNG_USR데이터를 보고 세팅
//							vo.setSpcCtrlMdlMnlCd("O");
//						} else if("D".equals(vo.getRealIbflag())){
//							vo.setDeltFlg("Y");
//						}
//						hisMstList.add(vo);
//					}
//				}
//			}
//
//			//history 저장시 old 컬럼 값들을 저장로직 이전에 조회한다.
//			List<SpcMdlCustRevLaneHisVO> hisVOList = new ArrayList<SpcMdlCustRevLaneHisVO>();
//			// RHQ 물량이 변경되었을때 
//			if(hisMstList.size()>0){
//				for(SearchModelManageListVO hisVO : hisMstList){
//					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "1");
//					
//					if("O".equals(hisVO.getSpcCtrlMdlMnlCd()) || "I".equals(hisVO.getRealIbflag())){
//						vo.setMdlAddFlg("Y");
//					}else if("Y".equals(hisVO.getDeltFlg())){
//						vo.setMdlAddFlg("N");
//					}
//					vo.setModiUsrId("1");
//					vo.setG1CngUsr(hisVO.getG1CngUsr());
//					hisVOList.add(vo);
//				}
//			}
//			// Office 물량이 변경되었을 때
//			if(hisDtlList.size()>0){
//				for(SearchModelManageListVO hisVO : hisDtlList){
//					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "2");
//					if("O".equals(hisVO.getSpcCtrlMdlMnlCd())){
//						vo.setMdlAddFlg("Y");
//					}else if("Y".equals(hisVO.getDeltFlg())){
//						vo.setMdlAddFlg("N");
//						vo.setOldSlsRgnOfcCd(vo.getSlsRgnOfcCd());
//						vo.setOldSubTrdAdjQty(vo.getSubTrdAdjQty());
//						vo.setSlsRgnOfcCd("");
//						vo.setSubTrdAdjQty("");
//					}else{
//						vo.setOldSlsRgnOfcCd(vo.getSlsRgnOfcCd());
//					}
//					vo.setG2CngUsr(hisVO.getG2CngUsr());
//					vo.setModiUsrId("2");
//					hisVOList.add(vo);
//					
//                    // 쿼리에서는 0으로 보이는데 vo에서 꺼내면 빈값으로 나와서 해당 부분에 대해서 처리해 줌
//                    String subTrdAdjQty = "0";
//                    String oldSubTrdAdjQty = "0";
//                    
//					if (!vo.getSubTrdAdjQty().equals("")){
//						subTrdAdjQty = vo.getSubTrdAdjQty();
//                    } 
//					if (!vo.getOldSubTrdAdjQty().equals("")){
//						oldSubTrdAdjQty = vo.getOldSubTrdAdjQty();
//                    }
//					
//					//Office의 물량정보가 이전 물량보다 커질 경우 정보를 변경한다.
//					if (Integer.parseInt(subTrdAdjQty) > Integer.parseInt(oldSubTrdAdjQty)){
//						hisVO.setRaplyCfmFlg("1");
//						raplyFlgList.add(hisVO);
//					}
//				}
//			}
//			//SPC_MDL_CUST_REV_LANE에 기존재하면서 삭제된 경우
//			if(deleteList.size()>0){
//				dbDao.deleteSmpRhqOfcByHo(deleteList);
//			}
//			//SPC_MDL_CUST_REV_LANE에 기존재하면서 수정된 경우 물량만 업데이트
//			if(modifyList.size()>0){
//				for(SearchModelManageListVO modifyVO : modifyList){
//					dbDao.modifySpaceManagementPlanHO(modifyVO, "N");
//				}
//			}
//			//SPC_MDL_CUST_REV_LANE에 기존재하면서  RHQ Load Guide(=cust_adj_qty)가 수정된 경우(산하 ofc에  RHQ guide값 모두 update)
//			if(modifyList2.size()>0){
//				dbDao.modifySpaceManagementPlanRhqGuideHO(modifyList2);
//			}
//			//SPC_MDL_CUST_REV_LANE에 없고 SPC_MDL_CUST_PERF에만 있어서 조회된 후 저장할때 SPC_MDL_CUST_REV_LANE에 INSERT.	
//			if(insertList.size()>0){  
//				for(SearchModelManageListVO insertVO : insertList){
//					dbDao.addSpaceManagementPlanHO(insertVO);
//				}
//			}
//			// RHQ, OFC ADD 
//			if(checkList.size()>0){
//				List<SearchModelManageListVO> reuseList = new ArrayList<SearchModelManageListVO>();
//				for(SearchModelManageListVO vo : checkList){
//					//RHQ, OFC ADD한 건인데 이미 삭제된 게 있을 경우 delt_flg를 N으로 바꿔줌.
//					String existFlg = dbDao.checkSMPHOExist(vo);
//					if("Y".equals(existFlg)){
//						vo.setDeltFlg("N");
//						reuseList.add(vo);
//					}else{
//						//순수 RHQ, OFC ADD
//						dbDao.addSpaceManagementPlanHO(vo);
//					}
//				}
//				//OFC Add로 들어왔으나 동일한 OFC가 이전에 삭제되어 DB에 들어있을때 물량과 Delt_flg 둘다 업데이트
//				if(reuseList.size()>0){
//					//OFC 물량 업데이트
//					for(SearchModelManageListVO reuseVO : reuseList){
//						dbDao.modifySpaceManagementPlanHO(reuseVO, "Y");
//					}
//					//RHQ 물량 업데이트
//					dbDao.modifySpaceManagementPlanRhqGuideHO(reuseList);
//				}
//			}
//
//			//history를 저장합니다.
//			if(hisVOList.size()>0){
//				Date today=new Date();
//				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddkkmmss");
//				String modiGdt = formater.format(today);
//				for(SpcMdlCustRevLaneHisVO hisVO : hisVOList){
//					hisVO.setModiGdt(modiGdt);
//					hisVO.setFlg("HO");
//					dbDao.addSmpMainHistory(hisVO);
//				}
//			}
//			
//			// Office Guide 물량이 변경되었을 경우 Flag 변경(단 물량이 커지는 경우만)
//			if (raplyFlgList.size()>0){
//				dbDao.updSmpRaplyCfmFlg(raplyFlgList);
//			}
//			
//		} catch(DAOException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}
	
	/**
	 * Space Management Plan RHQ 정보를 저장합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String newVer
	 * @param String usrId
	 * @param SearchModelManageListVO[] searchModelManageListVOs
	 * @param String unitCd
	 * @exception EventException
	 */
	private void addSpaceManagementPlanRHQ(String trade, String season, String newVer, String usrId, SearchModelManageListVO[] searchModelManageListVOs, String unitCd) throws EventException {
		try{
			List<SearchModelManageListVO> updateList = new ArrayList<SearchModelManageListVO>();
			List<SearchModelManageListVO> deleteList = new ArrayList<SearchModelManageListVO>();
			List<SearchModelManageListVO> insertList = new ArrayList<SearchModelManageListVO>();
			List<SearchModelManageListVO> changeMainLaneList = new ArrayList<SearchModelManageListVO>();
			
			List<SearchModelManageListVO> hisMstList = new ArrayList<SearchModelManageListVO>();
			List<SearchModelManageListVO> hisOfcList = new ArrayList<SearchModelManageListVO>();
			List<SearchModelManageListVO> hisLaneList = new ArrayList<SearchModelManageListVO>();
	        List<SearchModelManageListVO> hisDtlList = new ArrayList<SearchModelManageListVO>();
            List<SearchModelManageListVO> hisMstList2 = new ArrayList<SearchModelManageListVO>();
            List<SearchModelManageListVO> raplyFlgList = new ArrayList<SearchModelManageListVO>();

			String hoFlg = checkHOUser(usrId);
			
			for(SearchModelManageListVO vo : searchModelManageListVOs){
				
				if ( ("AES".equals(vo.getTrdCd()) || "IAS".equals(vo.getTrdCd())) && "SC".equals(vo.getScRfaFlg()) ) {
					vo.setScNo(vo.getRfaNo());
					vo.setRfaNo("");
				}
				
				vo.setTrdCd(trade);
				vo.setCostYrwk(season);
				vo.setVerSeq(newVer);
				vo.setUsrId(usrId);
				//FEU인 경우, TEU로 변환하여 저장
				vo.setUnit(unitCd);
				vo.setHoFlg(hoFlg);
				if(!"TTL".equals(vo.getSlsRgnOfcCd()) && !"0".equals(vo.getRevLaneCustCnt())){ //RevLaneCustCnt - HO에서도 저장하지 않은 경우에는 RHQ에서 저장할 수 없다.
					//LANE Delete
					if("D".equals(vo.getRealIbflag())){
						vo.setDeltFlg("Y");
						vo.setRlaneAdjQty("0");
					//LANE Add
					}else if("I".equals(vo.getRealIbflag())){
						vo.setSpcCtrlMdlMnlCd("L");
					}
					
					//office add해서 무작위로 들어온 Lane을 변경하거나 물량을 update
					if("U".equals(vo.getRealIbflag())){ 
						changeMainLaneList.add(vo);
					//LANE Delete
					}else if("D".equals(vo.getRealIbflag())){
						deleteList.add(vo);
					//LANE Add
					}else if("I".equals(vo.getRealIbflag())){
						insertList.add(vo);
					//물량을 Update
					}else{
						updateList.add(vo);
					}

					if("USER".equals(vo.getG3CngUsr())){
						hisLaneList.add(vo);
					}
	                   //OFC Load guide 값이 바뀐경우
                    if("USER".equals(vo.getG2CngUsr()) || "AUTO".equals(vo.getG2CngUsr())){
                        hisDtlList.add(vo);
                    }
					        
				}else{
                    //RHQ나 OFC Load guide 값이 바뀐경우
                    if("USER".equals(vo.getG1CngUsr()) || "USER".equals(vo.getG2CngUsr()) ){
                        if("I".equals(vo.getRealIbflag()) && "USER".equals(vo.getG1CngUsr())){
                            //OFC 가 변경되어도 같이 저장이 이루어지기 때문에 Flag와 G1_CNG_USR데이터를 보고 세팅
                            vo.setSpcCtrlMdlMnlCd("O");
                        } else if("D".equals(vo.getRealIbflag())){
                            vo.setDeltFlg("Y");
                        }
                        hisMstList2.add(vo);
                    }
                    
					if("USER".equals(vo.getG3CngUsr())){
						hisMstList.add(vo);
						String strOfc = vo.getCngOfcList();
						String[] strArr = strOfc.split(",");
						int idx = 0;
						for(int i=0; i<strArr.length; i++){
							// 배열 strArr에서 i번째 아이템의 값과 일치하는 인덱스를 찾는다.
						    idx = Arrays.binarySearch(strArr, strArr[i]);
						    //office가 중복인 경우에 추려낸다.
						    if(i == idx){
						    	SearchModelManageListVO tmpVO = new SearchModelManageListVO();
						    	tmpVO.setTrdCd(vo.getTrdCd());
						    	tmpVO.setCostYrwk(vo.getCostYrwk());
						    	tmpVO.setVerSeq(vo.getVerSeq());
						    	tmpVO.setUsrId(vo.getUsrId());
						    	tmpVO.setCustCntCd(vo.getCustCntCd());
						    	tmpVO.setCustSeq(vo.getCustSeq());
						    	tmpVO.setCtrtOfcCd(vo.getCtrtOfcCd());
						    	tmpVO.setScNo(vo.getScNo());
						    	tmpVO.setRfaNo(vo.getRfaNo());
						    	tmpVO.setCustCtrlCd(vo.getCustCtrlCd());
						    	tmpVO.setSubTrdCd(vo.getSubTrdCd());
						    	tmpVO.setSlsRhqCd(vo.getSlsRhqCd());
						    	tmpVO.setSlsRgnOfcCd(strArr[i]);
						    	hisOfcList.add(tmpVO);
						    }
						}
					}
				}
			}
			
			//history 저장시 old 컬럼 값들을 저장로직 이전에 조회한다.
			List<SpcMdlCustRevLaneHisVO> hisVOList = new ArrayList<SpcMdlCustRevLaneHisVO>();
			
			//추가
	         if(hisMstList2.size()>0){
 

	                 for(SearchModelManageListVO hisVO : hisMstList2){
	                        SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "1");
                        
                        if("O".equals(hisVO.getSpcCtrlMdlMnlCd()) || "I".equals(hisVO.getRealIbflag())){
                            vo.setMdlAddFlg("Y");
                        }else if("Y".equals(hisVO.getDeltFlg())){
                            vo.setMdlAddFlg("N");
                        }
                        vo.setModiUsrId("1");
                        vo.setG1CngUsr(hisVO.getG1CngUsr());
                        vo.setFlg("HO");
                        hisVOList.add(vo);
                  }
                
            }
	         
			if(hisMstList.size()>0){
 				for(SearchModelManageListVO hisVO : hisMstList){
					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "1");
					vo.setModiUsrId("1");
					hisVOList.add(vo);
				}
 
			    
			}
			
	         // Office 물량이 변경되었을 때
            if(hisDtlList.size()>0){
                for(SearchModelManageListVO hisVO : hisDtlList){
                    SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "2");
                    if("O".equals(hisVO.getSpcCtrlMdlMnlCd())){
                        vo.setMdlAddFlg("Y");
                    }else if("Y".equals(hisVO.getDeltFlg())){
                        vo.setMdlAddFlg("N");
                        vo.setOldSlsRgnOfcCd(vo.getSlsRgnOfcCd());
                        vo.setOldSubTrdAdjQty(vo.getSubTrdAdjQty());
                        vo.setSlsRgnOfcCd("");
                        vo.setSubTrdAdjQty("");
                    }else{
                        vo.setOldSlsRgnOfcCd(vo.getSlsRgnOfcCd());
                    }
                    vo.setG2CngUsr(hisVO.getG2CngUsr());
                    vo.setModiUsrId("2");
                    hisVOList.add(vo);
                    
                    // 쿼리에서는 0으로 보이는데 vo에서 꺼내면 빈값으로 나와서 해당 부분에 대해서 처리해 줌
                    String subTrdAdjQty = "0";
                    String oldSubTrdAdjQty = "0";
                    
                    if (!vo.getSubTrdAdjQty().equals("")){
                        subTrdAdjQty = vo.getSubTrdAdjQty();
                    } 
                    if (!vo.getOldSubTrdAdjQty().equals("")){
                        oldSubTrdAdjQty = vo.getOldSubTrdAdjQty();
                    }
                    
                    //Office의 물량정보가 이전 물량보다 커질 경우 정보를 변경한다.
                    if (Integer.parseInt(subTrdAdjQty) > Integer.parseInt(oldSubTrdAdjQty)){
                        hisVO.setRaplyCfmFlg("1");
                        raplyFlgList.add(hisVO);
                    }
                }
            }
            
            
			if(hisOfcList.size()>0){
				for(SearchModelManageListVO hisVO : hisOfcList){
					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "2");
					vo.setOldSlsRgnOfcCd(vo.getSlsRgnOfcCd());
					vo.setModiUsrId("2");
					hisVOList.add(vo);
				}
			}
			if(hisLaneList.size()>0){
				for(SearchModelManageListVO hisVO : hisLaneList){
					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "3");
					if("L".equals(hisVO.getSpcCtrlMdlMnlCd()) || "I".equals(hisVO.getRealIbflag())){   //Lane Add & office add의 대표 lane 변경 - history에서는 lane add로 인식한다.
						vo.setMdlAddFlg("Y");
					}else if("Y".equals(hisVO.getDeltFlg())){
						vo.setMdlAddFlg("N");
						vo.setOldRlaneCd(vo.getRlaneCd());
						vo.setRlaneCd("");
						vo.setOldRlaneAdjQty(vo.getRlaneAdjQty());
						vo.setRlaneAdjQty("");
					}else{
						vo.setOldRlaneCd(vo.getRlaneCd());
					}
					vo.setOldSlsRgnOfcCd(vo.getSlsRgnOfcCd());
					vo.setModiUsrId("3");
					hisVOList.add(vo);
				}
			}
			
			//LANE Delete
			if(deleteList.size()>0){				
				for(SearchModelManageListVO deleteVO : deleteList){
					dbDao.updateSpaceManagementPlanRHQ(deleteVO, "");
				}
				dbDao.deleteSmpLaneByRhq(deleteList);
			}
			
			//LANE Add
			if(insertList.size()>0){
				List<SearchModelManageListVO> reuseList = new ArrayList<SearchModelManageListVO>();
				for(SearchModelManageListVO vo : insertList){
					//Lane ADD한 건인데 이미 삭제된 게 있을 경우 delt_flg를 N으로 바꿔줌.
					String existFlg = dbDao.checkSMPRhqExist(vo);
					if("Y".equals(existFlg)){
						vo.setDeltFlg("N");
						reuseList.add(vo);
					}else{
						//순수 Lane Add
						dbDao.addSpaceManagementPlanRHQ(vo);
					}
				}
				//Lane Add로 들어왔으나 동일한 Lane이 이전에 삭제되어 DB에 들어있을때 물량과 Delt_flg 둘다 업데이트
				if(reuseList.size()>0){
					for(SearchModelManageListVO reuseVO : reuseList){
						dbDao.updateSpaceManagementPlanRHQ(reuseVO, "");
					}
				}
			}
			//물량만 Update
			if(updateList.size()>0){
				for(SearchModelManageListVO updateVO : updateList){
					dbDao.updateSpaceManagementPlanRHQ(updateVO, "");
				}
			}
			//office add해서 무작위로 들어온 Lane을 변경하거나 물량을 update
			if(changeMainLaneList.size()>0){
				for(SearchModelManageListVO updateVO : changeMainLaneList){
					dbDao.updateSpaceManagementPlanRHQ(updateVO, "");
				}
				dbDao.modifyMainLaneOfAddedOfc(changeMainLaneList);
			}
			
			//history를 저장합니다.
			if(hisVOList.size()>0){
				Date today=new Date();
				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddkkmmss");
				String modiGdt = formater.format(today);
				for(SpcMdlCustRevLaneHisVO hisVO : hisVOList){
					hisVO.setModiGdt(modiGdt);
					if( hisVO.getFlg() == null || hisVO.getFlg().length() == 0){
					    hisVO.setFlg("RHQ");
					}
					dbDao.addSmpMainHistory(hisVO);
				}
			}
	         // Office Guide 물량이 변경되었을 경우 Flag 변경(단 물량이 커지는 경우만)
            if (raplyFlgList.size()>0){
                dbDao.updSmpRaplyCfmFlg(raplyFlgList);
            }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Space Management Plan L.OFC로부터의 정보를 저장합니다.<br>
	 * 
	 * @param String trade
	 * @param String season
	 * @param String newVer
	 * @param String usrId
	 * @param SearchModelManageListVO[] searchModelManageListVOs
	 * @param String unitCd
	 * @exception EventException
	 */
//	private void addSpaceManagementPlanLOfc(String trade, String season, String newVer, String usrId, SearchModelManageListVO[] searchModelManageListVOs, String unitCd) throws EventException {
//		try{
//			List<SearchModelManageListVO> mergeList = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> hisMstList = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> hisOfcList = new ArrayList<SearchModelManageListVO>();
//			List<SearchModelManageListVO> hisLaneList = new ArrayList<SearchModelManageListVO>();
//			
//			for(SearchModelManageListVO vo : searchModelManageListVOs){
//				
//				if ( ("AES".equals(vo.getTrdCd()) || "IAS".equals(vo.getTrdCd())) && "SC".equals(vo.getScRfaFlg()) ) {
//					vo.setScNo(vo.getRfaNo());
//					vo.setRfaNo("");
//				}
//				
//				vo.setTrdCd(trade);
//				vo.setCostYrwk(season);
//				vo.setVerSeq(newVer);
//				vo.setUsrId(usrId);
//				//FEU인 경우, TEU로 변환하여 저장
//				vo.setUnit(unitCd);
//				if(!"TTL".equals(vo.getSlsRgnOfcCd()) && !"0".equals(vo.getRevLaneCustCnt())){
//					if("U".equals(vo.getRealIbflag())){
//						mergeList.add(vo);
//					}
//					if("USER".equals(vo.getG3CngUsr())){
//						hisLaneList.add(vo);
//					}
//				}else{
//					if("USER".equals(vo.getG3CngUsr())){
//						hisMstList.add(vo);
//						String strOfc = vo.getCngOfcList();
//						String[] strArr = strOfc.split(",");
//						int idx = 0;
//						for(int i=0; i<strArr.length; i++){
//							// 배열 strArr에서 i번째 아이템의 값과 일치하는 인덱스를 찾는다.
//						    idx = Arrays.binarySearch(strArr, strArr[i]);
//						    //office가 중복인 경우에 추려낸다.
//						    if(i == idx){
//						    	SearchModelManageListVO tmpVO = new SearchModelManageListVO();
//						    	tmpVO.setTrdCd(vo.getTrdCd());
//						    	tmpVO.setCostYrwk(vo.getCostYrwk());
//						    	tmpVO.setVerSeq(vo.getVerSeq());
//						    	tmpVO.setUsrId(vo.getUsrId());
//						    	tmpVO.setCustCntCd(vo.getCustCntCd());
//						    	tmpVO.setCustSeq(vo.getCustSeq());
//						    	tmpVO.setCtrtOfcCd(vo.getCtrtOfcCd());
//						    	tmpVO.setScNo(vo.getScNo());
//						    	tmpVO.setRfaNo(vo.getRfaNo());
//						    	tmpVO.setCustCtrlCd(vo.getCustCtrlCd());
//						    	tmpVO.setSubTrdCd(vo.getSubTrdCd());
//						    	tmpVO.setSlsRhqCd(vo.getSlsRhqCd());
//						    	tmpVO.setSlsRgnOfcCd(strArr[i]);
//						    	hisOfcList.add(tmpVO);
//						    }
//						}
//					}
//				}
//			}
//			
//			//history 저장시 old 컬럼 값들을 저장로직 이전에 조회한다.
//			List<SpcMdlCustRevLaneHisVO> hisVOList = new ArrayList<SpcMdlCustRevLaneHisVO>();
//			if(hisMstList.size()>0){
//				for(SearchModelManageListVO hisVO : hisMstList){
//					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "1");
//					vo.setModiUsrId("1");
//					hisVOList.add(vo);
//				}
//			}
//			if(hisOfcList.size()>0){
//				for(SearchModelManageListVO hisVO : hisOfcList){
//					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "2");
//					vo.setOldSlsRgnOfcCd(vo.getSlsRgnOfcCd());
//					vo.setModiUsrId("2");
//					hisVOList.add(vo);
//				}
//			}
//			if(hisLaneList.size()>0){
//				for(SearchModelManageListVO hisVO : hisLaneList){
//					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(hisVO, "3");
//					vo.setOldSlsRgnOfcCd(vo.getSlsRgnOfcCd());
//					vo.setOldRlaneCd(vo.getRlaneCd());
//					vo.setModiUsrId("3");
//					hisVOList.add(vo);
//					
//					SpcMdlCustRevLaneHisVO vo2 = dbDao.searchSmpOldData(hisVO, "4");
//					vo2.setOldSlsRgnOfcCd(vo2.getSlsRgnOfcCd());
//					vo2.setOldRlaneCd(vo2.getRlaneCd());
//					vo2.setModiUsrId("4");
//					hisVOList.add(vo2);
//				}
//			}
//			
//			
//			if(mergeList.size()>0){
//				for(SearchModelManageListVO mergeVO : mergeList){
//					dbDao.updateSpaceManagementPlanRHQ(mergeVO, "LOFC");
//				}
//			}
//			
//			//history를 저장합니다.
//			if(hisVOList.size()>0){
//				Date today=new Date();
//				SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddkkmmss");
//				String modiGdt = formater.format(today);
//				for(SpcMdlCustRevLaneHisVO hisVO : hisVOList){
//					hisVO.setModiGdt(modiGdt);
//					hisVO.setFlg("LOFC");
//					dbDao.addSmpMainHistory(hisVO);
//				}
//			}
//		} catch(DAOException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}
	
	/**
	 * 해당 season 의 실적 기준 - from, to, duration 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSeasonInfo(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSeasonInfo(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 새로운 Space Management Plan 의 Season을 생성합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param CustCtrlGrpVO[] custCtrlGrpVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createNewSeason(SpcMdlVerMstVO spcMdlVerMstVO, CustCtrlGrpVO[] custCtrlGrpVOs, SignOnUserAccount account) throws EventException {

		ModelManageBackEndJob backEndJob = new ModelManageBackEndJob();
		spcMdlVerMstVO.setCreUsrId(account.getUsr_id());
		backEndJob.setSpcMdlVerMstVO(spcMdlVerMstVO);
		backEndJob.setCustCtrlGrpVOs(custCtrlGrpVOs);
		backEndJob.setJobType("Creation");
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "SMP Season - Creation");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	

    /**
     * 새로운 Space Management Plan 의 Season을 COPY합니다.<br>
     * 
     * @param SpcMdlVerMstVO spcMdlVerMstVO
     * @param CustCtrlGrpVO[] custCtrlGrpVOs
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String copyNewSeason(SpcMdlVerMstVO spcMdlVerMstVO,   SignOnUserAccount account) throws EventException {

        ModelManageBackEndJob backEndJob = new ModelManageBackEndJob();
        spcMdlVerMstVO.setCreUsrId(account.getUsr_id());
        spcMdlVerMstVO.setUpdUsrId(account.getUsr_id());
        backEndJob.setSpcMdlVerMstVO(spcMdlVerMstVO);
        backEndJob.setJobType("Copy");
        BackEndJobManager backEndJobManager = new BackEndJobManager();
        try {
            return backEndJobManager.execute(backEndJob, account.getUsr_id(), "SMP Season - Creation");     
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(),ex);
        }
    }
    
    
    
    
	/**
	 * Space Management Plan 의 version을 Confirm합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param List<SpcMdlExptWkVO> spcMdlExptWkVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmVersion(SpcMdlVerMstVO spcMdlVerMstVO,List<SpcMdlExptWkVO> spcMdlExptWkVOs, SignOnUserAccount account) throws EventException {
		try {
			//해당 version의 confirm flg, 적용주차 를 입력합니다.
			dbDao.modifyMstConfirm(spcMdlVerMstVO, account.getUsr_id());
			//Exception Week를 삭제
	        dbDao.removeSpcMdlExptWk(spcMdlVerMstVO);

			//Exception Week Insert
	         dbDao.addSpcMdlExptWk(spcMdlExptWkVOs, account.getUsr_id());

			//이전 version의 적용 end 주차를 수정합니다.(현재 version start 주차의 1주 이전으로)
			dbDao.modifyPreVerEndWk(spcMdlVerMstVO, account.getUsr_id());
			//contract ofc에 화주를 밀어넣어준다.
			dbDao.addSmpCtrtFcstMapg(spcMdlVerMstVO);
			//smp history
			dbDao.addSmpConfirmHis(spcMdlVerMstVO, account.getUsr_id());
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 선택된 Customer, SC 에 대한 Sub Trade별, 노선별 BKG pol,pod CMPB를 조회합니다.<br>
	 * 
	 * @param SpcBkgCmpbVO spcBkgCmpbVO
	 * @return List<SpcBkgCmpbVO>
	 * @exception EventException
	 */
	public List<SpcBkgCmpbVO> searchBkgCmpb(SpcBkgCmpbVO spcBkgCmpbVO) throws EventException {
		try {
			return dbDao.searchBkgCmpb(spcBkgCmpbVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 조건에 맞는 SMP Loading 정보 Lane 관점에서 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpRptVO>
	 * @exception EventException
	 */
	public List<SmpRptVO> searchSmpRptByLane(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSmpRptByLane(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 조건에 맞는 SMP Loading 정보 Office 관점에서 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpRptVO>
	 * @exception EventException
	 */
	public List<SmpRptVO> searchSmpRptByOfc(ConditionVO conditionVO) throws EventException {
		try {
			List<String> subTrds = dbDao.searchExistSubTrd(conditionVO);
			
			int subTrdCnt = subTrds.size();
			
			List<SmpRptVO> list = dbDao.searchSmpRptByOfc(conditionVO, subTrdCnt);
			
			if(list.size()>0){
				list.get(0).setSubTrdCnt(Integer.toString(subTrdCnt)); 
			}
			return list;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 삭제 처리된 office 또는 lane을 재사용하기 위해 살립니다.<br>
	 * 
	 * @param SearchModelManageListVO searchModelManageListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageReviveOfcLane(SearchModelManageListVO searchModelManageListVO, SignOnUserAccount account) throws EventException {
		try {
			if(searchModelManageListVO != null){
				
				// AES 이면서 SC 값 일 경우 화면에서 RFA_NO 로 넘어온 값이 SC_NO 이므로 값 변환
				if ( ("AES".equals(searchModelManageListVO.getTrdCd()) || "IAS".equals(searchModelManageListVO.getTrdCd())) && "SC".equals(searchModelManageListVO.getScRfaFlg()) ) {
					searchModelManageListVO.setScNo(searchModelManageListVO.getRfaNo());
					searchModelManageListVO.setRfaNo("");
				}
				
				searchModelManageListVO.setUsrId(account.getUsr_id());
				if(searchModelManageListVO.getRlaneCd()==""){	//HO
					searchModelManageListVO.setSpcCtrlMdlMnlCd("O");
				}else{											//RHQ
					searchModelManageListVO.setSpcCtrlMdlMnlCd("L");//Lane Add인 경우- manual code는 저장하지 않음.
				}
				
				List<SpcMdlCustRevLaneHisVO> hisVOList = new ArrayList<SpcMdlCustRevLaneHisVO>();
				String flg = "";
				//history 저장시 old 컬럼 값들을 저장로직 이전에 조회한다.
				if("".equals(searchModelManageListVO.getRlaneCd())){ //HO
					flg = "HO";
					SpcMdlCustRevLaneHisVO vo = dbDao.searchSmpOldData(searchModelManageListVO, "1");
					vo.setModiUsrId("1");
					hisVOList.add(vo);

					SpcMdlCustRevLaneHisVO vo2 = dbDao.searchSmpOldData(searchModelManageListVO, "2");
					vo2.setMdlAddFlg("Y");
					vo2.setOldSlsRgnOfcCd(vo2.getSlsRgnOfcCd());
					vo2.setModiUsrId("2");
					vo2.setCngItmNm("REUSE");
					hisVOList.add(vo2);
				}else{ //RHQ
					flg = "RHQ";
					SpcMdlCustRevLaneHisVO vo1 = dbDao.searchSmpOldData(searchModelManageListVO, "1");
					vo1.setModiUsrId("1");
					hisVOList.add(vo1);

					SpcMdlCustRevLaneHisVO vo2 = dbDao.searchSmpOldData(searchModelManageListVO, "2");
					vo2.setOldSlsRgnOfcCd(vo2.getSlsRgnOfcCd());
					vo2.setModiUsrId("2");
					hisVOList.add(vo2);
					
					SpcMdlCustRevLaneHisVO vo3 = dbDao.searchSmpOldData(searchModelManageListVO, "3");
					vo3.setMdlAddFlg("Y");
					vo3.setOldRlaneCd(vo3.getRlaneCd());
					vo3.setOldSlsRgnOfcCd(vo3.getSlsRgnOfcCd());
					vo3.setModiUsrId("3");
					vo3.setCngItmNm("REUSE");
					hisVOList.add(vo3);
				}
				
				//OFC/LANE REUSE시 delt_flg와 rmk만 update 해줌. 
				dbDao.modifyReviveOfcLane(searchModelManageListVO); //merge

				if(hisVOList.size()>0){
					Date today=new Date();
					SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddkkmmss");
					String modiGdt = formater.format(today);
					for(SpcMdlCustRevLaneHisVO hisVO : hisVOList){
						hisVO.setModiGdt(modiGdt);
						hisVO.setFlg(flg);
						dbDao.addSmpMainHistory(hisVO);
					}
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 노선별 Head Haul Bound 조회한다.<br>
	 *  
	 * @param conditionVO
	 * @return List<SpcHdHulVO>
	 * @throws EventException
	 */
	public List<SpcHdHulVO> searchHdHul(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchHdHul(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 노선별 Head Haul Bound 저장한다.<br>
	 *  
	 * @param SpcHdHulVO[] spcHdHulVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHdHul(SpcHdHulVO[] spcHdHulVOs, SignOnUserAccount account) throws EventException {
		List<SpcHdHulVO> list = new ArrayList<SpcHdHulVO>();
		
		try {
			if(spcHdHulVOs != null){
				for(int i=0; i<spcHdHulVOs.length; i++){
					spcHdHulVOs[i].setUsrId(account.getUsr_id());
					
					list.add(spcHdHulVOs[i]);
				}
				
				if(list.size() > 0)
					dbDao.addHdHul(list);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * SMP History를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpHisVO>
	 * @throws EventException
	 */
	public List<SmpHisVO> searchSMPHistory(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSMPHistory(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * SMP Customer History를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SmpCustHisVO>
	 * @throws EventException
	 */
	public List<SmpCustHisVO> searchSMPCustHistory(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSMPCustHistory(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
//	/**
//	 * 입력한 ofc가 삭제되어 있는 상태라면, 본사의 intention인지 아닌지 확인합니다.
//	 * 
//	 * @param SearchModelManageListVO searchModelManageListVO
//	 * @return String
//	 * @exception EventException
//	 */
//	public String checkDelAuth(SearchModelManageListVO searchModelManageListVO) throws EventException {
//		try {
//			return dbDao.checkDelAuth(searchModelManageListVO);
//		} catch(DAOException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBackEndJobVO(String key) throws EventException {
		DBRowSet rowSet;
		String[] rtnArr = new String[2];
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			rtnArr[0] = (String) rowSet.getObject("jb_sts_flg");
			rtnArr[1] = (String) rowSet.getObject("jb_usr_err_msg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
		return rtnArr;
	}
	
	/**
	 * Import시 Customer Sequence 자리에 숫자 이외에 값을 입력한 경우 Exception 처리<br>
	 * 
	 * @param CustManageVO vo
	 * @exception EventException
	 */
	private void checkCustSeqNumber(CustManageVO vo) throws EventException {
		try{
			if(vo != null && !"".equals(vo.getCustCd())){
				Integer.parseInt(vo.getCustCd().substring(2));
			}
		} catch (NumberFormatException e){
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Data"}).getMessage());  
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * 입력하는 사람이 본사 소속인지 확인합니다.<br>
	 * 
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	private String checkHOUser(String usrId) throws EventException {
		try{
			String rtnYn = "N";
			if(usrId != null && !"".equals(usrId)){
				rtnYn = dbDao.checkHOUser(usrId);
			}
			return rtnYn;
		} catch (NumberFormatException e){
			throw new EventException(new ErrorHandler("COM12192", new String[] {"Data"}).getMessage());  
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 조회합니다.<br>
	 *  
	 * @param conditionVO
	 * @return List<CustCtrlGrpVO>
	 * @throws EventException
	 */
	public List<CustCtrlGrpVO> searchCustCtrlGrp(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCustCtrlGrp(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Trade, 조회주차에 해당하는 Season의 Yield Group 정보를 저장합니다.<br>
	 * 
	 * @param CustCtrlGrpVO[] CustCtrlGrpVOs
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCtrlGrp(CustCtrlGrpVO[] CustCtrlGrpVOs, ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<CustCtrlGrpVO> mergeList = new ArrayList<CustCtrlGrpVO>();
			
			for ( int i=0; i<CustCtrlGrpVOs .length; i++ ) {
				CustCtrlGrpVOs[i].setTrdCd(conditionVO.getTrdCd());
				CustCtrlGrpVOs[i].setCostYrwk(conditionVO.getSeason());
				CustCtrlGrpVOs[i].setCreUsrId(account.getUsr_id());
				CustCtrlGrpVOs[i].setUpdUsrId(account.getUsr_id());
				mergeList.add(CustCtrlGrpVOs[i]);
			}
			
			if ( mergeList.size() > 0 ) {
				dbDao.manageCustCtrlGrp(mergeList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Season/Version에 등록되어 있는 Modelship Account 중 유효하지 않은 S/C, RFA 를 조회합니다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return List<CustManageVO>
	 * @exception EventException
	 */
	public List<CustManageVO> searchModelshipAcctAmendList(CustManageVO custManageVO) throws EventException {
		try {
			return dbDao.searchModelshipAcctAmendList(custManageVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 입력한 S/C, RFA 가 유효 한지 확인합니다.
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkAmendScRfa(CustManageVO custManageVO) throws EventException {
		try {
			return dbDao.checkAmendScRfa(custManageVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * S/C, RFA 정보를 Update 한다. <br>
	 *  
	 * @param CustManageVO[] custManageVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageModelshipAcctAmend(CustManageVO[] custManageVOs, SignOnUserAccount account) throws EventException {
		List<CustManageVO> list = new ArrayList<CustManageVO>();
		
		try {
			if ( custManageVOs != null ){
				for(int i=0; i<custManageVOs.length; i++){
					custManageVOs[i].setCreUsrId(account.getUsr_id());
					custManageVOs[i].setUpdUsrId(account.getUsr_id());
					
					// AES 이면서 SC 값 일 경우 화면에서 RFA_NO 로 넘어온 값이 SC_NO 이므로 값 변환
					if ( ("AES".equals(custManageVOs[i].getTrdCd()) || "IAS".equals(custManageVOs[i].getTrdCd())) && "SC".equals(custManageVOs[i].getScRfaFlg()) ) {
						custManageVOs[i].setScNo(custManageVOs[i].getRfaNo());
						custManageVOs[i].setPreScNo(custManageVOs[i].getPreRfaNo());
						custManageVOs[i].setRfaNo("");
						custManageVOs[i].setPreRfaNo("");
					}
					
					list.add(custManageVOs[i]);
				}
				
				if ( list.size() > 0 ) {
					for(CustManageVO vo : list){
						// SPC_MDL_CUST_CTRL_HIS 에 Insert
						dbDao.addSmpCustAmendHis(vo);
					}
					
					// SPC_MDL_CUST_CTRL 정보 Update
					dbDao.updateSmpCustAmend(list);
					
					// SPC_MDL_CUST_REV_LANE 정보 Update
					dbDao.updateSmpCustRevLaneAmend(list);
					
					// SPC_CTRT_FCAST_OFC_MAPG 정보 Update
					dbDao.updateSmpCtrtFcastOfcMapgAmend(list);
					
					// SPC_CTRT_FCAST_CUST 정보 Update
					dbDao.updateSmpCtrtFcastCustAmend(list);
					
					// SPC_DLY_FCAST_CUST 정보 Update
					dbDao.updateSmpDlyFcastCustAmend(list);
					
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Amend 해야할 S/C, RFA 존재 여부 확인합니다.
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkSmpAmendList(CustManageVO custManageVO) throws EventException {
		try {
			return dbDao.checkSmpAmendList(custManageVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SPC_0092 : SEARCH02
	 * Amend 팝업에서 입력한 SC, RFA#의 중복을 체크합니다. (SPC_MDL_CUST_CTRL 테이블내)
	 * 
	 * @param CustManageVO custManageVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkScRfaDup(CustManageVO custManageVO) throws EventException {
		try {
			return dbDao.checkScRfaDup(custManageVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Space Management Plan 의 PERF 를 재생성합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageSeasonRegeneration(SpcMdlVerMstVO spcMdlVerMstVO, SignOnUserAccount account) throws EventException {

		ModelManageBackEndJob backEndJob = new ModelManageBackEndJob();
		spcMdlVerMstVO.setCreUsrId(account.getUsr_id());
		spcMdlVerMstVO.setUpdUsrId(account.getUsr_id());
		backEndJob.setSpcMdlVerMstVO(spcMdlVerMstVO);
		backEndJob.setJobType("Regeneration");
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "SMP Season - Regeneration");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SPC_0090 : MULTI05<br>
	 * 실적이 아예 없는 화주를 조회 후 Sub Trade Add 했을 경우 해당 Account 기본 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchModelManageListVO>
	 * @exception EventException
	 */
	public List<SearchModelManageListVO> searchNewAccountInfo(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchNewAccountInfo(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SPC_0095 : SEARCHLIST01<br>
	 * Acct. Add 후 Account, SC, RFA 입력 시 해당 계약의 유효성 체크 및  MVC, C.OFC 조회해온다.<br>
	 * 
	 * @param CustManageVO custManageVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAcctValidEtcData(CustManageVO custManageVO) throws EventException {
		try {
			return dbDao.searchAcctValidEtcData(custManageVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}