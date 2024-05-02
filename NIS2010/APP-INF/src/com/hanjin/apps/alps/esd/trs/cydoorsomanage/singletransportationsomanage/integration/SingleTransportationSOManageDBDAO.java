/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAO.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.12
*@LastModifier : 민정호
*@LastVersion : 1.7
* 2006.09.29 김상근
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.02.26 조풍연 1.1 [N200903060130] MEXICO RAIL S/O 대상에 조회도록 변경
* 2010.10.08 최 선   1.2 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2011.04.25 민정호 1.3 [CHM-201110290] [TRS] 중복 Door S/O 발행을 방지하기 위한 로직 추가 요청
* 2011.07.13 민정호 1.4 [CHM-201112130] [TRS] Door S/O 중복 발행을 방지하기 위한 로직 일부 수정요청
* 2011.11.29 민정호 1.5 [CHM-201114644] [TRS] S/O Correction 시 Delete flag 체크로직 추가요청
* 2011.12.09 민정호 1.6 [CLT-111121293] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2011.12.12 민정호 1.7 [CHM-201115019] [TRS] S/O creation 시 BKG cancel 여부 체크 로직 추가요청
* 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0930Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SoProcVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 김상근
 * @see SingleTransportationSOManageBCImpl 참조
 * @since J2EE 1.4
 */
public class SingleTransportationSOManageDBDAO extends DBDAOSupport {

	/**
	 * Office code의 conti_cd check.<br>
	 * 각 대륙별(미주, 구주, 아주) 별로 여러지역의 Office를 동시에 조회하거나
	 * 미주화면에서 아주의 Control Office 자료를 조회 할 경우 오류를 발생 시킨다.
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContiCodeCheck(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			String ui_conti_cd = event.getUi_conti_cd();
			String so_office = event.getPrnt_ofc_cd();
			List<String> arr_so_office = new ArrayList();
			arr_so_office = this.seperationParameter(so_office, ","); 
			String conti_cd  = "";
			String err_msg = "";
			param.put("arr_so_office", arr_so_office);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchContiCodeCheckRSQL template = new SingleTransportationSOManageDBDAOSearchContiCodeCheckRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

			if(dbRowset.next()){
				conti_cd = dbRowset.getString("conti_cd");
				//Africa 대륙은 Head Office가 없으므로 해당사항이 없다.
				if ( (!conti_cd.equals(ui_conti_cd)) || (dbRowset.getRowCount()>1)) {
					if (ui_conti_cd.equals("M")) {
						err_msg = "Please input America office code";
					}else if (ui_conti_cd.equals("E")) {
						err_msg = "Please input Europe office code";
					}else if (ui_conti_cd.equals("A")) {
						err_msg = "Please input Asia office code";
					}
                }
				if (err_msg.length()>1)
				throw new DAOException((new ErrorHandler("TRS00099",new String[]{err_msg})).getMessage());
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Creation Search View(Insert)
	 * 
	 * @return
	 * @throws DAOException
	 */
	public String searchSingleTransportationSOCandidatesListK() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
		String lSeq = "";
		try{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListGetSeqRSQL(), null, null);
			dbRowset.next();
			lSeq = dbRowset.getString("seq");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return lSeq;
	}
	
	
	/**
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리
	 * Creation Search View(Insert)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<SingleTransportationVO> searchSingleTransportationSOCandidatesListP(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		List<SingleTransportationVO> rtnList = new ArrayList<SingleTransportationVO> ();
		try{
//			String cydoor_div  = event.getCydoor_div ();
//			String ui_conti_cd = event.getUi_conti_cd ();
			String sUnplannedShuttleFlag = event.getSUnplannedShuttleFlag();

			//Control Office Split setting
			String so_office = event.getCtrl_so_office();
			List<String> arr_so_office = new ArrayList();
			arr_so_office = this.seperationParameter(so_office, ",");
			param.put("arr_so_office", arr_so_office);
			
			//Booking no Split setting
			String bkgno = event.getBkgno();
			List<String> arr_bkgno = new ArrayList();
			arr_bkgno = this.seperationParameter(bkgno, ",");
			param.put("arr_bkgno", arr_bkgno);
			
			//B/L no Split setting
			String billno = event.getBillno();
			List<String> arr_billno = new ArrayList();
			arr_billno = this.seperationParameter(billno, ",");
			param.put("arr_billno", arr_billno);
			
			//Container no Split setting
			String cntrno = event.getCntrno();
			List<String> arr_cntrno = new ArrayList();
			arr_cntrno = this.seperationParameter(cntrno, ",");
			param.put("arr_cntrno", arr_cntrno);
			
			//trunk VVD Splint setting
			String trunkvvd = event.getTrunkvvd();
			List<String> arr_trunkvvd = new ArrayList();
			arr_trunkvvd = this.seperationParameter(trunkvvd, ",");
			param.put("arr_trunkvvd", arr_trunkvvd);
			
			//feeder VVD Splint setting (Door S/O만 존재)
			String txt_feeder_vvd = event.getTxt_feeder_vvd();
			List<String> arr_feeder_vvd = new ArrayList();
			arr_feeder_vvd = this.seperationParameter(txt_feeder_vvd, ",");
			param.put("arr_feeder_vvd", arr_feeder_vvd);
			
			//Post code Splint setting (Door S/O만 존재 - TRO 자료 존재시)
			String zip_code = event.getZip_code();
			List<String> arr_zip_code = new ArrayList();
			arr_zip_code = this.seperationParameter(zip_code, ",");
			param.put("arr_zip_code", arr_zip_code);

		    param.put("dateCondition", event.getRad_dateSep().toString());
		    param.put("frm_plandate", event.getFrm_plandate().toString()); 
		    param.put("to_plandate", event.getTo_plandate().toString());
		    param.put("contract_no", event.getContract_no().toString());
		    param.put("contract_tp_cd", event.getContract_tp_cd().toString());
		    param.put("bound", event.getBound().toString());
		    param.put("transmode", event.getTransmode().toString());
		    param.put("costmode", event.getCostmode().toString());
		    param.put("frmnode", event.getSearchFmLoc().toString());
		    param.put("frmnodeyard", event.getSearchFmYard().toString());
		    param.put("vianode", event.getSearchViaLoc().toString());
		    param.put("vianodeyard", event.getSearchViaYard().toString());
		    param.put("tonode", event.getSearchToLoc().toString());
		    param.put("tonodeyard", event.getSearchToYard().toString());
		    param.put("dorloc", event.getSearchDoorLoc().toString());
		    param.put("dorlocyard", event.getSearchDoorYard().toString());
		    param.put("sUnplannedShuttleFlag",event.getSUnplannedShuttleFlag().toString());
		    param.put("TroUnConfirmDoor",event.getSTroUnConfirmDoor().toString());
		    param.put("feeder_vvd_tp", event.getFeeder_vvd().toString());
		    
		    param.put("cydoor_div", event.getCydoor_div().toString());   //UI에서 선택한 CY/DOOR구분 (CY : CY, DOOR : DR)
		    param.put("ui_conti_cd", event.getUi_conti_cd().toString()); //UI에서 셋팅한 대륙구분코드 (구주 : E, 미주 : M, 아주 : A)

			String sCopNo       = event.getsCopNo();
			String sCostActGrpSeq = event.getsCostActGrpSeq();

			List<String> CopNoArr = new ArrayList();
			
			if( !sCopNo.equals("") && !sCopNo.equals("null") && sCopNo != null) {
				CopNoArr = this.seperationParameter(sCopNo, ",");
			}

			List<String> sCostActGrpSeqArr = new ArrayList();
			
			if( !sCostActGrpSeq.equals("") && !sCostActGrpSeq.equals("null") && sCostActGrpSeq != null) {			
				sCostActGrpSeqArr = this.seperationParameter(sCostActGrpSeq, ",");
			}
			
			List<String> arrCopSeq = new ArrayList();
			for(int i=0; i<sCostActGrpSeqArr.size(); i++){
				arrCopSeq.add(i,CopNoArr.get(i)+"$"+sCostActGrpSeqArr.get(i));
			}

			param.put("arrCopSeq", arrCopSeq);

			//S/O Candidate 를 temp 테이블에 저장한다.
			if (sUnplannedShuttleFlag.equals("US")) {
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateRSQL(), param, param);
			}else{
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListCreateRSQL(), param, param);
			}
			rtnList = (List) RowSetUtil.rowSetToVOs(dbRowset, SingleTransportationVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnList;
	}
	
	/**
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리
	 * Creation Search View(Insert)
	 * 
	 * @param event
	 * @param vo
	 * @param lSeq
	 * @throws DAOException
	 */
	public void searchSingleTransportationSOCandidatesListC(EsdTrs0002Event event, List<SingleTransportationVO> vo, String lSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			String sUnplannedShuttleFlag = event.getSUnplannedShuttleFlag();
			param.put("trsp_tmp_seq", lSeq);
			if( vo != null && vo.size()>0 ) { 
				
				if (sUnplannedShuttleFlag.equals("US")) {
					new SQLExecuter("DEFAULT").executeBatch(new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUnplanCreateCSQL(), vo,param,param);
				}else{
					new SQLExecuter("DEFAULT").executeBatch(new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListCreateCSQL(), vo,param,param);
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Temp 테이블에 저정된 S/O Candidate 조회대상에 UPDATE하는 이벤트 처리<br>
	 * Creation Search View(Insert)
	 * 
	 * @param event
	 * @param lSeq
	 * @throws DAOException
	 */
	public void searchSingleTransportationSOCandidatesListU(EsdTrs0002Event event, String lSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
		    param.put("cydoor_div", event.getCydoor_div().toString());   //UI에서 선택한 CY/DOOR구분 (CY : CY, DOOR : DR)
		    param.put("ui_conti_cd", event.getUi_conti_cd().toString()); //UI에서 셋팅한 대륙구분코드 (구주 : E, 미주 : M, 아주 : A)
		    param.put("trsp_tmp_seq", lSeq);
			//Temp table에 있는 Customer 자료 UPDATE
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUptUSQL(), param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Creation Search View(Insert)
	 * 
	 * @param event
	 * @param lSeq
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSingleTransportationSOCandidatesList(EsdTrs0002Event event, String lSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			String cydoor_div  = event.getCydoor_div ();
			String ui_conti_cd = event.getUi_conti_cd ();
		    param.put("cydoor_div", event.getCydoor_div().toString());   //UI에서 선택한 CY/DOOR구분 (CY : CY, DOOR : DR)
		    param.put("ui_conti_cd", event.getUi_conti_cd().toString()); //UI에서 셋팅한 대륙구분코드 (구주 : E, 미주 : M, 아주 : A)
		    param.put("trsp_tmp_seq", lSeq);
		    param.put("cnt_flg", event.getCntFlg());
		    param.put("TroUnConfirmDoor",event.getSTroUnConfirmDoor().toString());
			if (cydoor_div.equals("DR")) {
				if (ui_conti_cd.equals("E")) { //구주
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListEurDrRSQL(), param, param);
				}else if (ui_conti_cd.equals("M")) { //미주
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListUsaDrRSQL(), param, param);
				}else if (ui_conti_cd.equals("A")) { //아주
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListAsiaDrRSQL(), param, param);
				}
			}else{
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListRSQL(), param, param);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리
	 * Creation Search View(Insert)
	 * 
	 * @param lSeq
	 * @throws DAOException
	 */
	public void searchSingleTransportationSOCandidatesListD(String lSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("trsp_tmp_seq", lSeq);
			//temp 테이블에 저장된 S/O Candidate를 삭제한다.
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSingleTransportationSOCandidatesListTmpDSQL(), param,param);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Creation Search View(Insert)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSingleTransportationSOList(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
		    param.put("dateCondition", event.getRad_dateSep().toString());
		    param.put("frm_plandate", event.getFrm_plandate().toString()); 
		    param.put("to_plandate", event.getTo_plandate().toString());
		    param.put("bound", event.getBound().toString());
		    param.put("transmode", event.getTransmode().toString());
		    param.put("costmode", event.getCostmode().toString());
		    param.put("frmnode", event.getSearchFmLoc().toString()+event.getSearchFmYard().toString());
		    param.put("vianode", event.getSearchViaLoc().toString()+event.getSearchViaYard().toString());
		    param.put("tonode", event.getSearchToLoc().toString()+event.getSearchToYard().toString());
		    param.put("dorloc", event.getSearchDoorLoc().toString()+event.getSearchDoorYard().toString());
			param.put("rad_wo_issued", event.getRad_wo_issued().toString());
			param.put("svc_provider", event.getCombo_svc_provider().toString());
			param.put("form_usr_ofc_cd", event.getForm_usr_ofc_cd().toString());
			param.put("spot_bid_flg", event.getSpotBidFlg());
			param.put("spot_bid_no", event.getSpotBidNo());

			String bkgno = event.getBkgno();
			List<String> arr_bkgno = new ArrayList();
			arr_bkgno = this.seperationParameter(bkgno, ","); 
			param.put("arr_bkgno", arr_bkgno);
			
			String billno = event.getBillno();
			List<String> arr_billno = new ArrayList();
			arr_billno = this.seperationParameter(billno, ","); 
			param.put("arr_billno", arr_billno);
			
			String cntrno = event.getCntrno();
			List<String> arr_cntrno = new ArrayList();
			arr_cntrno = this.seperationParameter(cntrno, ","); 
			param.put("arr_cntrno", arr_cntrno);
			
			String trunkvvd = event.getTrunkvvd();
			List<String> arr_trunkvvd = new ArrayList();
			arr_trunkvvd = this.seperationParameter(trunkvvd, ","); 
			param.put("arr_trunkvvd", arr_trunkvvd);

			String so_no = event.getSo_no();
			List<String> arr_so_no = new ArrayList();
			arr_so_no = this.seperationParameter(so_no, ","); 
			param.put("arr_so_no", arr_so_no);
			
			String wo_no = event.getWo_no();
			List<String> arr_wo_no = new ArrayList();
			arr_wo_no = this.seperationParameter(wo_no, ","); 
			param.put("arr_wo_no", arr_wo_no);
			
			String zip_code = event.getZip_code();
			List<String> arr_zip_code = new ArrayList();
			arr_zip_code = this.seperationParameter(zip_code, ","); 
			param.put("arr_zip_code", arr_zip_code);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");

			SingleTransportationSOManageDBDAOSearchSingleTransportationSOListRSQL template = new SingleTransportationSOManageDBDAOSearchSingleTransportationSOListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList modifySINGLE_TRANSPORTATION_VO(EsdTrs0002Event event) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
			Map<String,Object> param = new HashMap<String,Object>();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();

			SQLExecuter sqlExe = new SQLExecuter("");
			DBRowSet dbRowset1 = null;
			int insCnt[] = null;
			String cmbSeq = "";
			String cbstatus      = event.getCbstatus();
			String cost_act_grp_cd = null;
			param.put("cbstatus", 	 cbstatus);
			
			String form_usr_ofc_cd  = event.getForm_usr_ofc_cd();  //Session office
			String form_cre_usr_id  = event.getForm_cre_usr_id(); //Session user
			param.put("form_usr_ofc_cd", form_usr_ofc_cd);
			param.put("form_cre_usr_id", form_cre_usr_id);
			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				mSTVoList.add(singleTransportationVOS[i]);

				arrSeq.add(i, String.valueOf(singleTransportationVOS[i].getTrspSoSeq())); //TRSP_SO_SEQ : 객체를 넘긴다.

				param.put("SoOfcCtyCd", singleTransportationVOS[i].getTrspSoOfcCtyCd());
				param.put("SoSeq", singleTransportationVOS[i].getTrspSoSeq());
				SingleTransportationSOManageDBDAOCyDoorSeqRSQL template1 = new SingleTransportationSOManageDBDAOCyDoorSeqRSQL();
				dbRowset1 = sqlExe.executeQuery(template1, param, param);

				if(!dbRowset1.next()){
					throw new DAOException(new ErrorHandler("TRS00015").getMessage()+singleTransportationVOS[i].getTrspSoOfcCtyCd()+singleTransportationVOS[i].getTrspSoSeq());
				}
				
				/* Combined Column Setting */
				//'':SINGLE, CF:COMBINED ONE, FF/FM:COMBINED TWO
				if( cbstatus.equals("CS") ) {
					singleTransportationVOS[i].setTrspSoCmbTpCd(singleTransportationVOS[i].getTrspSoCmbTpCd());
				} else {
					singleTransportationVOS[i].setTrspSoCmbTpCd(cbstatus);
				}
				// JSP 화면에서는 trsp_so_cmb_seq를 trsp_so_cmb_srt_no로 사용하고 있다.
				if( cbstatus.equals("CF") || cbstatus.equals("CS") ) { //COMBINED에 대한 처리구문.
					String cmbSrtNo = String.valueOf(singleTransportationVOS[i].getTrspSoCmbSeq());
					singleTransportationVOS[i].setTrspSoCmbSrtNo(cmbSrtNo);
					if( cmbSrtNo.substring(2).equals("1") && cmbSrtNo.length() > 2 ) {
						SingleTransportationSOManageDBDAOCyDoorCombineSeqRSQL template2 = new SingleTransportationSOManageDBDAOCyDoorCombineSeqRSQL();
						dbRowset1 = sqlExe.executeQuery(template2, param, param); //Combind_SEQ
						if( dbRowset1.next() ) {
							cmbSeq = dbRowset1.getString("CMB_SEQ");
						}
					}
					singleTransportationVOS[i].setTrspSoCmbSeq(cmbSeq);
					if( cbstatus.equals("CF") ) {
						singleTransportationVOS[i].setCmbSoRltStsFlg("F");
					}else if( cbstatus.equals("CS") ) {
						singleTransportationVOS[i].setCmbSoRltStsFlg("S");
					}
				}else{
					singleTransportationVOS[i].setTrspSoCmbSrtNo("");
					singleTransportationVOS[i].setTrspSoCmbSeq("");
					singleTransportationVOS[i].setCmbSoRltStsFlg("");
				}

				//Trans Mode를 변경할 경우  cost_act_grp_cd 도 변경되어야 하기 때문에 새로 조합한다.
				cost_act_grp_cd  = singleTransportationVOS[i].getCostActGrpCd().substring(0,2)+singleTransportationVOS[i].getTrspCrrModCd();
				singleTransportationVOS[i].setCostActGrpCd(cost_act_grp_cd);
				
				if( String.valueOf(singleTransportationVOS[i].getTrspCostDtlModCd()).equals("DOOR") ) {
					singleTransportationVOS[i].setTrspCostDtlModCd("DR");
					//dor_de_addr은 변경없이 입력
				}else{
					if(singleTransportationVOS[i].getFmNodCd().equals(singleTransportationVOS[i].getToNodCd())){
						if( singleTransportationVOS[i].getTrspBndCd().equals("T") ) {
							singleTransportationVOS[i].setTrspCostDtlModCd("TS");
						} else {
							singleTransportationVOS[i].setTrspCostDtlModCd("LS");
						}
					} else {
						singleTransportationVOS[i].setTrspCostDtlModCd("CY");
					}
					singleTransportationVOS[i].setDorDeAddr("");
				}

				if(String.valueOf(singleTransportationVOS[i].getDorSvcTpCd()).equals("ALL")) {
					singleTransportationVOS[i].setDorSvcTpCd("");
				}else{
					//All이 아닐 경우 변경없이 입력
				}

			}
			insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOModifySingleTransportationVoTrsUSQL(), mSTVoList, param, param);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}
			
			return arrSeq;
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Separate를 실행 Combined 해제
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList modify01SINGLE_TRANSPORTATION_VO(EsdTrs0002Event event) throws DAOException {
		try{
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
			Map<String,Object> param = new HashMap<String,Object>();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			DBRowSet dbRowset1 = null;
			int cmbCnt = 0;
			String cre_ofc_cd = "";
			String trsp_so_cmb_seq = "";
			String pre_trsp_so_cmb_seq = "";
//			boolean cmb_flag = true;
			
			String form_usr_ofc_cd   = event.getForm_usr_ofc_cd();  //Session office
			String form_cre_usr_id  = event.getForm_cre_usr_id(); //Session user
			param.put("form_usr_ofc_cd", form_usr_ofc_cd);
			param.put("form_cre_usr_id", form_cre_usr_id);
			
			int vos_length = singleTransportationVOS.length;
			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				mSTVoList.add(singleTransportationVOS[i]);
				arrSeq.add(i, String.valueOf(singleTransportationVOS[i].getTrspSoSeq())); //TRSP_SO_SEQ : 객체를 넘긴다.
				
				cre_ofc_cd = singleTransportationVOS[i].getCreOfcCd();
				trsp_so_cmb_seq = singleTransportationVOS[i].getTrspSoCmbSeq();

				param.put("cre_ofc_cd", cre_ofc_cd);
				param.put("trsp_so_cmb_seq", trsp_so_cmb_seq);
				SingleTransportationSOManageDBDAOModify01SingleTransportationVoChkRSQL template1 = new SingleTransportationSOManageDBDAOModify01SingleTransportationVoChkRSQL();
				dbRowset1 = sqlExe.executeQuery(template1, param, param);
				dbRowset1.next();
				if (i>0 && !pre_trsp_so_cmb_seq.equals(trsp_so_cmb_seq)){
					throw new DAOException((new ErrorHandler("TRS00099",new String[]{"CB Seq same S/O can be separated only."})).getMessage());
				}
				
				pre_trsp_so_cmb_seq = trsp_so_cmb_seq;
				cmbCnt = dbRowset1.getInt("CNT");
			}
			if (cmbCnt > 0 && vos_length != cmbCnt) {
				throw new DAOException((new ErrorHandler("TRS00099",new String[]{"Combined S/O after all the views can be separated."})).getMessage());
			}

			if (mSTVoList.size()>0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOModify01SingleTransportationVoUSQL(), mSTVoList, param, param);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to SO Update No"+ i + " SQL");
				}
			}
			
			return arrSeq;
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 수정된 데이타 모델을 DB에 반영한다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList modify02SINGLE_TRANSPORTATION_VO(EsdTrs0002Event event) throws DAOException {
		try{
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
			Map<String,Object> param = new HashMap<String,Object>();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			String form_usr_ofc_cd  = event.getForm_usr_ofc_cd();  //Session office
			String form_cre_usr_id  = event.getForm_cre_usr_id(); //Session user
			param.put("form_usr_ofc_cd", form_usr_ofc_cd);
			param.put("form_cre_usr_id", form_cre_usr_id);

			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				mSTVoList.add(singleTransportationVOS[i]);
				arrSeq.add(i, String.valueOf(singleTransportationVOS[i].getTrspSoSeq())); //TRSP_SO_SEQ : 객체를 넘긴다.
			}
			
			if (mSTVoList.size()>0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOModify02SingleTransportationVoUSQL(), mSTVoList, param, param);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to SO Update No"+ i + " SQL");
				}
			}
			
			return arrSeq;
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CY&DOOR Correction S/O 삭제 이벤트 처리<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList removeSINGLE_TRANSPORTATION_VO(EsdTrs0002Event event) throws DAOException {
		try{
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
			Map<String,Object> param = new HashMap<String,Object>();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			List<SingleTransportationVO> mSceList = new ArrayList<SingleTransportationVO>();
			List<SingleTransportationVO> mEqrList = new ArrayList<SingleTransportationVO>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			String form_usr_ofc_cd   = event.getForm_usr_ofc_cd();  //Session office
			String form_cre_usr_id  = event.getForm_cre_usr_id(); //Session user
			param.put("form_usr_ofc_cd", form_usr_ofc_cd);
			param.put("form_cre_usr_id", form_cre_usr_id);
			
			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				mSTVoList.add(singleTransportationVOS[i]);
				arrSeq.add(i, String.valueOf(singleTransportationVOS[i].getTrspSoSeq())); //TRSP_SO_SEQ : 객체를 넘긴다.
				
				//COP,EQR상태코드를 UPDATE할 대상을 VO에 담는다.
				if (singleTransportationVOS[i].getCgoTpCd().equals("F")) { 
					if (!singleTransportationVOS[i].getRplnUmchFlg().equals("Y")) { //UnMatch일 경우엔 상태코드를 update하지 않는다.
						mSceList.add(singleTransportationVOS[i]);
					}
				}else{
					mEqrList.add(singleTransportationVOS[i]);
				}
			}
			
			if (mSTVoList.size()>0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAORemoveSingleTransportationVoTrsStsUSQL(), mSTVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to TRS SO Status Update No"+ i + " SQL");
				}
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAORemoveSingleTransportationVoEdiTmpCSQL(), mSTVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to SO# Temp Insert No"+ i + " SQL");
				}
			}
			
			if (mSceList.size()>0) {
				sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAORemoveSingleTransportationVoBeforeHisCSQL(), mSTVoList, param, param); //S/O삭제 Before history
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAORemoveSingleTransportationVoSceUSQL(), mSTVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to SCE SO Status Update No"+ i + " SQL");
				}
				sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAORemoveSingleTransportationVoAfterHisCSQL(), mSTVoList, param, param); //S/O삭제 After history
			}

			if (mEqrList.size()>0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAORemoveSingleTransportationVoEqrUSQL(), mSTVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to EQR SO Status Update No"+ i + " SQL");
				}
			}

			return arrSeq;
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * S/O Candidate 조회대상을 temp 테이블에 입력하는 이벤트 처리
	 * Creation Search View(Insert)
	 * 
	 * @param srcMap
	 * @throws DAOException
	 */
	public void verifySingleTransportationSOIRG(Map<String, String> srcMap) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String cop_no = srcMap.get("cop_no");
		String bnd_cd = srcMap.get("trsp_bnd_cd");
		String cost_act_grp_seq = srcMap.get("cost_act_grp_seq");
		String trsp_crr_mod_cd  = srcMap.get("trsp_crr_mod_cd");
		String frm_nod  = srcMap.get("fm_nod_cd") + srcMap.get("fm_nod_yard");
		String via_nod  = srcMap.get("via_nod_cd") + srcMap.get("via_nod_yard");
		String door_nod = srcMap.get("dor_nod_cd") + srcMap.get("dor_nod_yard");
		String to_nod   = srcMap.get("to_nod_cd") + srcMap.get("to_nod_yard");
		String bkg_no   = srcMap.get("bkg_no");
		String err_msg = "";
		param.put("v_cop_no", cop_no);
		param.put("v_bnd_cd", bnd_cd);
		param.put("v_cost_act_grp_seq", cost_act_grp_seq);
		param.put("v_trsp_crr_mod_cd", trsp_crr_mod_cd);
		param.put("v_fm_nod_cd", frm_nod);
		param.put("v_via_nod_cd", via_nod);
		param.put("v_dor_nod_cd", door_nod);
		param.put("v_to_nod_cd", to_nod);
		
		err_msg = "The route does not exist in IRG list.\nContact RHQ relevant to your office for creation of the IRG!!\n";
	    err_msg = err_msg + "(BKG NO : " + bkg_no + ", COP NO : " + cop_no + ")";
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOVerifySingleTransportationSOIRGRSQL template = new SingleTransportationSOManageDBDAOVerifySingleTransportationSOIRGRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);
			if(dbRowset.next()){
				if (dbRowset.getRowCount() > 0) {					
				    err_msg = "";
                }
			}

			if (err_msg.length() > 0)
				throw new DAOException((new ErrorHandler("TRS00099",new String[]{err_msg})).getMessage());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @param sRow
	 * @throws DAOException
	 */
	public void verifySingleTransportationDupChk(EsdTrs0002Event event, int sRow) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
//			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String,Object> param = new HashMap<String,Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			DBRowSet dbRowset3 = null;
			String sUnplannedShuttleFlag = event.getSUnplannedShuttleFlag();
			String cop_no = "";
			String cost_act_grp_seq = "";
			String fm_nod_cd = "";
			String to_nod_cd = "";
			String trsp_cost_dtl_mode_cd = "";
			String trsp_bnd_cd = "";
			String tro_seq = "";

			cop_no = singleTransportationVOS[sRow].getCopNo();
			cost_act_grp_seq = singleTransportationVOS[sRow].getCostActGrpSeq();
			fm_nod_cd = singleTransportationVOS[sRow].getFmNodCd()+singleTransportationVOS[sRow].getFmNodYard();
			to_nod_cd = singleTransportationVOS[sRow].getToNodCd()+singleTransportationVOS[sRow].getToNodYard();
			trsp_cost_dtl_mode_cd = singleTransportationVOS[sRow].getTrspCostDtlModCd();
			trsp_bnd_cd = singleTransportationVOS[sRow].getTrspBndCd();
			tro_seq = singleTransportationVOS[sRow].getTroSeq();
			
			param.put("cop_no", cop_no);
			param.put("cost_act_grp_seq", cost_act_grp_seq);
			param.put("fm_nod_cd", fm_nod_cd);
			param.put("to_nod_cd", to_nod_cd);
			param.put("trsp_cost_dtl_mode_cd", trsp_cost_dtl_mode_cd);
			param.put("trsp_bnd_cd", trsp_bnd_cd);
			param.put("ui_conti_cd", event.getUi_conti_cd().toString()); //UI에서 셋팅한 대륙구분코드 (구주 : E, 미주 : M, 아주 : A)
			param.put("tro_seq", tro_seq);

			if (sUnplannedShuttleFlag.equals("US")) {  //UnPlaned 대상일 경우
				String err_msg = "Unplanned S/O of the route for this CNTR is already issued!! \nGo to 'S/O Correction' for modification or delete.";
				SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedRSQL template = new SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedRSQL();
				dbRowset3 = sqlExe.executeQuery(template, param, param);
				StringBuffer sb_dup_chk = new StringBuffer();
				sb_dup_chk.append("(   ");
				while( dbRowset3.next() ) {
					sb_dup_chk.append(dbRowset3.getString("CHK_UNIT"));
				}
				sb_dup_chk.append(")");
				if( sb_dup_chk.length() > 10 ) {
					throw new DAOException((new ErrorHandler("TRS00099",new String[]{err_msg})).getMessage()+"\n"+sb_dup_chk);
				}
			}else{ //Planed 대상일 경우
				SingleTransportationSOManageDBDAOMultiSingleTrsSoRSQL template = new SingleTransportationSOManageDBDAOMultiSingleTrsSoRSQL();
				dbRowset3 = sqlExe.executeQuery(template, param, param);
				StringBuffer sb_dup_chk = new StringBuffer();
				sb_dup_chk.append("(   ");
				while( dbRowset3.next() ) {
					sb_dup_chk.append(dbRowset3.getString("CHK_UNIT"));
				}
				sb_dup_chk.append(")");
				if( sb_dup_chk.length() > 10 ) {
					throw new DAOException(new ErrorHandler("TRS00100").getMessage()+sb_dup_chk.toString());
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @param sRow
	 * @return
	 * @throws DAOException
	 */
	public String multiSINGLE_TRANSPORTATION_VO(EsdTrs0002Event event, int sRow) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String,Object> param = new HashMap<String,Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			DBRowSet dbRowset1 = null;
			DBRowSet dbRowset4 = null;

			String cbstatus      = event.getCbstatus();
			String form_usr_ofc_cd  = event.getForm_usr_ofc_cd(); //Session office
			String form_cre_usr_id  = event.getForm_cre_usr_id(); //Session user
			String cmbSeq = "";
			String sdy_sep 	= "";
			String cost_act_grp_cd           = "";
			String sUnplannedShuttleFlag = event.getSUnplannedShuttleFlag();
			String trspSeq = "";
			String sCostActGrpSeq = "";

			SingleTransportationSOManageDBDAOCyDoorSeqRSQL template1 = new SingleTransportationSOManageDBDAOCyDoorSeqRSQL();
			dbRowset1 = sqlExe.executeQuery(template1, param, param);
			if(dbRowset1.next()){
				trspSeq = dbRowset1.getString("TRSP_SEQ");
			}

			if (sUnplannedShuttleFlag.equals("US")) {  //UnPlaned 대상일 경우
				//COST_ACT_GRP_SEQ이 600일 경우 COST_ACT_GRP_SEQ를 새로 생성해야 한다.
				//새로 생성하는 기준은 SEQ 600바로 다음번호의 SO의 발행내역이 있는지 조회하여
				//(600 + 바로 다음번 SEQ) / 2  로 새로운 번호를 구한다음 반올림한다.
				sCostActGrpSeq = singleTransportationVOS[sRow].getCostActGrpSeq();
				if (Integer.parseInt(sCostActGrpSeq)==600){
					String sNewCostActSeq = "";
					param.put("cop_no", singleTransportationVOS[sRow].getCopNo());
					SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedNewSeqRSQL template = new SingleTransportationSOManageDBDAOMultiSingleTrsSoUnplanedNewSeqRSQL();
					dbRowset4 = sqlExe.executeQuery(template, param, param);
					if (dbRowset4.next()) sNewCostActSeq = dbRowset4.getString("NEW_COST_ACT_GRP_SEQ");
					singleTransportationVOS[sRow].setCostActGrpSeq(sNewCostActSeq);
				}
				singleTransportationVOS[sRow].setUplnSoFlg("Y");
			}

			//'':SINGLE, CF:COMBINED ONE, FF/FM:COMBINED TWO
			if( cbstatus.equals("CS") ) {
				singleTransportationVOS[sRow].setTrspSoCmbTpCd(singleTransportationVOS[sRow].getTrspSoCmbTpCd());
			} else {
				singleTransportationVOS[sRow].setTrspSoCmbTpCd(cbstatus);
			}
			// JSP 화면에서는 trsp_so_cmb_seq를 trsp_so_cmb_srt_no로 사용하고 있다.
			if( cbstatus.equals("CF") || cbstatus.equals("CS") ) { //COMBINED에 대한 처리구문.
				String cmbSrtNo = String.valueOf(singleTransportationVOS[sRow].getTrspSoCmbSeq());
				singleTransportationVOS[sRow].setTrspSoCmbSrtNo(cmbSrtNo);
				if( cmbSrtNo.substring(2).equals("1") && cmbSrtNo.length() > 2 ) {
					SingleTransportationSOManageDBDAOCyDoorCombineSeqRSQL template2 = new SingleTransportationSOManageDBDAOCyDoorCombineSeqRSQL();
					dbRowset1 = sqlExe.executeQuery(template2, param, param); //Combind_SEQ
					if( dbRowset1.next() ) {
						cmbSeq = dbRowset1.getString("CMB_SEQ");
					}
				}else{
					cmbSeq = singleTransportationVOS[sRow-1].getTrspSoCmbSeq();
				}
				singleTransportationVOS[sRow].setTrspSoCmbSeq(cmbSeq);
				if( cbstatus.equals("CF") ) {
					singleTransportationVOS[sRow].setCmbSoRltStsFlg("F");
				}else if( cbstatus.equals("CS") ) {
					singleTransportationVOS[sRow].setCmbSoRltStsFlg("S");
				}
			}else{
				singleTransportationVOS[sRow].setTrspSoCmbSrtNo("");
				singleTransportationVOS[sRow].setTrspSoCmbSeq("");
				singleTransportationVOS[sRow].setCmbSoRltStsFlg("");
			}

			//Trans Mode를 변경할 경우  cost_act_grp_cd 도 새로 생성되어야 하기 때문에 새로 조합한다.
			//cost_act_grp_cd  = singleTransportationVOS[i].getCostActGrpCd();
			if( String.valueOf(singleTransportationVOS[sRow].getTrspCostDtlModCd()).equals("DOOR") ) {
				sdy_sep 	= "D";
			} else {
				sdy_sep 	= "Y";
			}
			cost_act_grp_cd  = singleTransportationVOS[sRow].getTrspBndCd() + sdy_sep + singleTransportationVOS[sRow].getTrspCrrModCd();
			singleTransportationVOS[sRow].setCostActGrpCd(cost_act_grp_cd);

			if( String.valueOf(singleTransportationVOS[sRow].getTrspCostDtlModCd()).equals("DOOR") ) {
				singleTransportationVOS[sRow].setTrspCostDtlModCd("DR");
				//dor_de_addr은 변경없이 입력
			}else{
				if(singleTransportationVOS[sRow].getFmNodCd().equals(singleTransportationVOS[sRow].getToNodCd())){
					if( singleTransportationVOS[sRow].getTrspBndCd().equals("T") ) {
						singleTransportationVOS[sRow].setTrspCostDtlModCd("TS");
					} else {
						singleTransportationVOS[sRow].setTrspCostDtlModCd("LS");
					}
				} else {
					singleTransportationVOS[sRow].setTrspCostDtlModCd("CY");
				}
				singleTransportationVOS[sRow].setDorDeAddr("");
			}

			if(String.valueOf(singleTransportationVOS[sRow].getDorSvcTpCd()).equals("ALL")) {
				singleTransportationVOS[sRow].setDorSvcTpCd("");
			}else{
				//All이 아닐 경우 변경없이 입력
			}

			String sFeederVVD = "";
			if( singleTransportationVOS[sRow].getTrspBndCd().equals("I") ) {
				sFeederVVD = singleTransportationVOS[sRow].getIbVvdCd();
			} else {
				sFeederVVD = singleTransportationVOS[sRow].getObVvdCd();
			}
			if( sFeederVVD.length() > 8 ) {
				singleTransportationVOS[sRow].setFdrVslCd(sFeederVVD.substring(0, 4));
				singleTransportationVOS[sRow].setFdrSkdVoyNo(sFeederVVD.substring(4, 8));
				singleTransportationVOS[sRow].setFdrSkdDirCd(sFeederVVD.substring(8));
			}

			singleTransportationVOS[sRow].setTrspSoSeq(trspSeq);
			singleTransportationVOS[sRow].setCreOfcCd(form_usr_ofc_cd);
			singleTransportationVOS[sRow].setCreUsrId(form_cre_usr_id);
			singleTransportationVOS[sRow].setUpdUsrId(form_cre_usr_id);
			singleTransportationVOS[sRow].setCbstatus(cbstatus);

			mSTVoList.add(singleTransportationVOS[sRow]);

			insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOMultiSingleTrsCSQL(), mSTVoList, param, null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

			return trspSeq;

		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void modifyOfficeSINGLE_TRANSPORTATION_VO(EsdTrs0930Event event) throws DAOException {
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String,Object> param = new HashMap<String,Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			String login_usr_id = event.getSignOnUserAccount().getUsr_id();
			String cre_ofc_cd   = event.getSignOnUserAccount().getOfc_cd();
			param.put("new_trns_rqst_ofc_cd", event.getNew_trns_rqst_ofc_cd());
			param.put("new_trns_rqst_rsn", event.getNew_trns_rqst_rsn());

			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				singleTransportationVOS[i].setUpdUsrId(login_usr_id);
				singleTransportationVOS[i].setCreOfcCd(cre_ofc_cd);
				mSTVoList.add(singleTransportationVOS[i]);
			}

			insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOModifyOfficeSingleTransportationVoSceUSQL(), mSTVoList, param, param);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOModifyOfficeSingleTransportationVoPrdUSQL(), mSTVoList, param, param);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void modifyOfficeMT_TRANSPORTATION_VO(EsdTrs0930Event event) throws DAOException {
		try {

			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();
			List<SingleTransportationVO> mSTVoList = new ArrayList<SingleTransportationVO>();
			Map<String,Object> param = new HashMap<String,Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			String login_usr_id = event.getSignOnUserAccount().getUsr_id();
			String cre_ofc_cd   = event.getSignOnUserAccount().getOfc_cd();
			param.put("new_trns_rqst_ofc_cd", event.getNew_trns_rqst_ofc_cd());
			param.put("new_trns_rqst_rsn", event.getNew_trns_rqst_rsn());
			for ( int i=0; i<singleTransportationVOS.length; i++ ) {
				singleTransportationVOS[i].setUpdUsrId(login_usr_id);
				singleTransportationVOS[i].setCreOfcCd(cre_ofc_cd);
				mSTVoList.add(singleTransportationVOS[i]);
			}

			insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOModifyOfficeMTTransportationVoUSQL(), mSTVoList, param, param);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}

		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search10TransportationSOManage(EsdTrs0930Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("new_trns_rqst_ofc_cd", event.getNew_trns_rqst_ofc_cd());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearch10TransportationSOManageRSQL template = new SingleTransportationSOManageDBDAOSearch10TransportationSOManageRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * Office의 Sub Office 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSubOfficeSOManageList(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
//			String ui_conti_cd = event.getUi_conti_cd();
			String so_office = event.getCtrl_so_office();
			List<String> arr_so_office = new ArrayList();
			arr_so_office = this.seperationParameter(so_office, ","); 
//			String conti_cd  = "";
//			String err_msg = "";
			param.put("arr_so_office", arr_so_office);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchSubOfficeSOManageListRSQL template = new SingleTransportationSOManageDBDAOSearchSubOfficeSOManageListRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Actual Customer Info Change cause from Door Location/Zone Modification <br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public GeneralEventResponse searchActualCustomerInfoSet(EsdTrs0002Event event) throws DAOException {
//		String ui_conti_cd = event.getUi_conti_cd();

		String sFmLocContiCd   = event.getSFmLocContiCd();
		String sBoundCd        = event.getSBoundCd();
		String sCneeCustCntCd  = event.getSCneeCustCntCd();
		String sCneeCustSeq    = event.getSCneeCustSeq();
		String sShprCustCntCd  = event.getSShprCustCntCd();
		String sShprCustSeq    = event.getSShprCustSeq();
		String sDoorNodCd      = event.getSDoorNodCd();

		Map<String, Object> param = new HashMap<String, Object>();
//		DBRowSet 			dRs = null;
		Map outProc = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SoProcVO custVo = new SoProcVO();

//		System.out.println(":::::::::::::::::::::::::::::sFmLocContiCd 	== ["+sFmLocContiCd+"]:::::::::::::::::::::::::::::::");
//		System.out.println(":::::::::::::::::::::::::::::sBoundCd 		== ["+sBoundCd+"]:::::::::::::::::::::::::::::::");
//		System.out.println(":::::::::::::::::::::::::::::sCneeCustCntCd 	== ["+sCneeCustCntCd+"]:::::::::::::::::::::::::::::::");
//		System.out.println(":::::::::::::::::::::::::::::sCneeCustSeq 	== ["+sCneeCustSeq+"]:::::::::::::::::::::::::::::::");
//		System.out.println(":::::::::::::::::::::::::::::sShprCustCntCd 	== ["+sShprCustCntCd+"]:::::::::::::::::::::::::::::::");
//		System.out.println(":::::::::::::::::::::::::::::sShprCustSeq 	== ["+sCneeCustSeq+"]:::::::::::::::::::::::::::::::");
//		System.out.println(":::::::::::::::::::::::::::::sDoorNodCd 		== ["+sDoorNodCd+"]:::::::::::::::::::::::::::::::");
		
		try {

			if ( (!"".equals(sFmLocContiCd) 	&& sFmLocContiCd 	!= null)	&&
				(!"".equals(sBoundCd) 	&& sBoundCd 	!= null)	&&
				(("I".equals(sBoundCd)	&& !"".equals(sCneeCustCntCd) && sCneeCustCntCd 	!= null)	||
				("O".equals(sBoundCd)	&& !"".equals(sShprCustCntCd) && sShprCustCntCd 	!= null)) 	&&
				(!"".equals(sDoorNodCd) && sDoorNodCd 	!= null)
			)
			{
//				HashMap resultH = new HashMap();
				sCneeCustSeq		= "".equals(sCneeCustSeq)	|| sCneeCustSeq == null ? "0" : sCneeCustSeq;
				sShprCustSeq		= "".equals(sShprCustSeq)	|| sShprCustSeq == null ? "0" : sShprCustSeq;
				param.put("pi_conti_cd", sFmLocContiCd);
				param.put("pi_bound_cd", sBoundCd);
				param.put("pi_cnee_cnt_cd", sCneeCustCntCd);
				param.put("pi_cnee_seq", sCneeCustSeq);
				param.put("pi_shpr_cnt_cd", sShprCustCntCd);
				param.put("pi_shpr_seq", sShprCustSeq);
				param.put("pi_door_nod_cd", sDoorNodCd);

				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new SingleTransportationSOManageDBDAOActualCustomerInfoProcRSQL(), param, param);
				custVo.setRtnValue((String) outProc.get("po_rtn_value")); 
				custVo.setActCustCntCd((String) outProc.get("po_act_cust_cnt_cd")); 
				custVo.setActCustSeq((String) outProc.get("po_act_cust_seq")); 
				custVo.setActCustAddrSeq((String) outProc.get("po_act_cust_addr_seq")); 
				custVo.setActCustFctryPstCd((String) outProc.get("po_act_cust_fctry_pst_cd")); 
				custVo.setActCustFctryNm((String) outProc.get("po_act_cust_fctry_nm")); 
				custVo.setActCustFctryAddr((String) outProc.get("po_act_cust_fctry_addr")); 
				custVo.setActCustFctryPhnNo((String) outProc.get("po_act_cust_fctry_phn_no")); 
				custVo.setActCustFctryFaxNo((String) outProc.get("po_act_cust_fctry_fax_no")); 
				custVo.setActCustFctryPicNo((String) outProc.get("po_act_cust_fctry_pic_no")); 
				custVo.setActCustEml((String) outProc.get("po_act_cust_eml")); 
				custVo.setActCustRmk((String) outProc.get("po_act_cust_rmk")); 
				eventResponse.setRsVo(custVo);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * SO Candidate 삭제 이벤트 처리<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<SingleTransportationVO> removeSOCandidate(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		List<SingleTransportationVO> sub_models = new ArrayList<SingleTransportationVO>();
		try {
			SingleTransportationVO[] singleTransportationVOS = event.getSingleTransportationVOs();

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt[] = null;

			String form_cre_usr_id  = event.getForm_cre_usr_id();

			for ( int k=0; k<singleTransportationVOS.length; k++ ) {
				SingleTransportationVO model = (SingleTransportationVO) singleTransportationVOS[k];
				sub_models.add(model);
				
				//Dummy Container는 Slave를 찾을 수 없기 때문에 UI에서 지정한 것만 삭제하면 된다.
				if (!model.getEqNo().equals("")) {
					param.put("eq_no", model.getEqNo());
					param.put("pol_cd", model.getPolCd());
					param.put("trunkvvd", model.getTrunkvvd());
					param.put("ctrl_ofc_cd", model.getCtrlOfcCd());
					param.put("fm_nod_cd", model.getFmNodCd());
					param.put("fm_nod_yard", model.getFmNodYard());
					//candidate된 S/O 의 Slave를 조회한다.
					SingleTransportationSOManageDBDAORemoveSOCandidateRSQL template = new SingleTransportationSOManageDBDAORemoveSOCandidateRSQL();
					dbRowset = sqlExe.executeQuery(template, param, param);
					//조회된 Slave를 VO에 담는다.
					for(; dbRowset.next(); ) {
						SingleTransportationVO sub_model = new SingleTransportationVO();
						sub_model.setCopNo(dbRowset.getObject("COP_NO").toString());
						sub_model.setCostActGrpSeq(dbRowset.getObject("COST_ACT_GRP_SEQ").toString());
						sub_model.setBkgNo(dbRowset.getObject("BKG_NO").toString());
						sub_model.setUpdUsrId(form_cre_usr_id);
						sub_models.add(sub_model);
					}
				}
			}
			
			//Candidate된 S/O 대상의 Master/Slave를 모두 삭제한다.
			insCnt = sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAORemoveSOCandidateUSQL(), sub_models, null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update No"+ i + " SQL");
			}

		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sub_models;
	}
	
	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * CNTR 직반납을 위해 OffHireVerify check
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchOffHireVerify(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList arr_cntrno	= event.getSel_cntr_noList();
		try{
			param.put("arr_cntrno", arr_cntrno);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchOffHireVerifyRSQL template = new SingleTransportationSOManageDBDAOSearchOffHireVerifyRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * CY / Door 변경에 따른 Cost Mode 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCostMode(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("cydoordiv", event.getCydoor_div());
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchCostModeRSQL template = new SingleTransportationSOManageDBDAOSearchCostModeRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * S/O 발행 변경사항을 History 테이블에 관리
	 *  TRS_TRSP_SVC_ORD_TMP 테이블에 데이터를 INSERT한다.
	 * 
	 * @param model
	 * @param replanSts
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiSoIssueBeforeHis(SingleTransportationVO model, String replanSts) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			param.put("replanSts",replanSts);
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new SingleTransportationSOManageDBDAOMultiSoIssueBeforeHisCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}

	/**
	 * S/O 발행 변경사항을 History 테이블에 관리
	 *  TRS_TRSP_SVC_ORD_TMP 테이블에 데이터를 INSERT한다.
	 * 
	 * @param model
	 * @param replanSts
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiSoIssueAfterHis(SingleTransportationVO model, String replanSts) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			param.put("replanSts",replanSts);
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new SingleTransportationSOManageDBDAOMultiSoIssueAfterHisCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}

	/**
	 * BkgVvd 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchBkgVvd(EsdTrs0002Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOSearchBkgVvdRSQL template = new SingleTransportationSOManageDBDAOSearchBkgVvdRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public String seperationParameterq(String sparameter, String sSeperate) {
		String slist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
					if(j != 0){
						slist = slist + ",'"+ st.nextToken() + "'";
					}else{
						slist = slist + "'" + st.nextToken() + "'";
					}
				}
		}
		return slist;
	}
	
	/**
	 *  S/O Correction 시 Delete flag 체크로직<br>
	 * 
	 * @param singleTransportationVO 
	 * @return String
	 * @throws DAOException
	 */
	public String verifySingleTransportationDeltChk(SingleTransportationVO singleTransportationVO) throws DAOException {
		DBRowSet dbRowset = null;
		String delt_flg = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{						
			param.put("trsp_so_ofc_cty_cd", singleTransportationVO.getTrspSoOfcCtyCd());
			param.put("trsp_so_seq", singleTransportationVO.getTrspSoSeq());
												
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchVerifySingleTransportationDeltChkRSQL(), param, param);

			while(dbRowset.next()){
				delt_flg = dbRowset.getString("DELT_FLG")+","+dbRowset.getString("SO_STS_CD");
			}								
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delt_flg;
	}
	
	/**
	 * SO Creation 시 SCE_TRO_MAPG 테이블에 있는지 확인 로직 
	 * 
	 * @param singleTransportationVO
	 * @param uiContiCd 
	 * @return String
	 * @throws DAOException
	 */
	public String searchSceTroMapg (SingleTransportationVO singleTransportationVO, String uiContiCd) throws DAOException {
		DBRowSet dbRowset = null;
		String confirm_flg = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{						
			param.put("bkg_no", singleTransportationVO.getBkgNo());
			param.put("trs_bnd_cd", singleTransportationVO.getTrspBndCd());
			param.put("tro_seq", singleTransportationVO.getTroSeq());
			param.put("tro_sub_seq", singleTransportationVO.getTroSubSeq());
			param.put("bkg_rcvde_term_cd", singleTransportationVO.getBkgRcvdeTermCd());
			param.put("trs_cost_dtl_mod_cd", singleTransportationVO.getTrspCostDtlModCd());
			param.put("ui_conti_cd", uiContiCd);
			
															
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSceTroMapgRSQL(), param, param);

			while(dbRowset.next()){
				confirm_flg = dbRowset.getString("CONFIRM_FLG");
			}								
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return confirm_flg;
	}	
	
	/**
	 * @param obj
	 * @return
	 */
	public static Object getNull(Object obj) {
	    if (obj == null) {
	      return "";
	    }
	    return obj; 
	}

	/**
	 * 2012.01.10 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
	 * Trans mode 와 Route 가 동일한 내용으로 생성된 건 중복 체크 로직<br>
	 * 
	 * @param singleTransportationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSODupCheck(SingleTransportationVO singleTransportationVO) throws DAOException {

		String retVal = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("cop_no", singleTransportationVO.getCopNo());
			param.put("trsp_cost_dtl_mod_cd", singleTransportationVO.getTrspCostDtlModCd());
			param.put("trsp_crr_mod_cd", singleTransportationVO.getTrspCrrModCd());
			param.put("fm_nod_cd", singleTransportationVO.getFmNodCd());
			param.put("fm_nod_yard", singleTransportationVO.getFmNodYard());
			param.put("to_nod_cd", singleTransportationVO.getToNodCd());
			param.put("to_nod_yard", singleTransportationVO.getToNodYard());
			param.put("via_nod_cd", singleTransportationVO.getViaNodCd());     
			param.put("via_nod_yard", singleTransportationVO.getViaNodYard());  

			velParam.putAll(param);		
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchSODupCheckRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			} 
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	
	/**
	 * 2012.06.18 신동일 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project
	 * Node가 변경됐을 경우 Distance를 계산한다.
	 * @param singleTransportationVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDistanceCalculation(SingleTransportationVO singleTransportationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{

			param.put("fm_nod_cd", singleTransportationVO.getFmNodCd());
			param.put("fm_nod_yard", singleTransportationVO.getFmNodYard());
			param.put("to_nod_cd",  singleTransportationVO.getToNodCd());
			param.put("to_nod_yard",  singleTransportationVO.getToNodYard());
			param.put("dor_nod_cd",  singleTransportationVO.getDorNodCd());
			param.put("dor_nod_yard",  singleTransportationVO.getDorNodYard());
			param.put("via_nod_cd",  singleTransportationVO.getViaNodCd());
			param.put("via_nod_yard",  singleTransportationVO.getViaNodYard());
			param.put("trsp_bnd_cd", singleTransportationVO.getTrspBndCd());
			param.put("trsp_crr_mod_cd",singleTransportationVO.getTrspCrrModCd());
			param.put("trsp_cost_dtl_mod_cd", singleTransportationVO.getTrspCostDtlModCd());
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOsearchDistanceCalculationRSQL(), param, param);
            
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 2012.06.18 신동일 [CHM-201217633] [TRS] 구주 Hinterland T/F 및 시스템 개발 Project
	 * Node가 변경됐을 경우 Distance를 계산한다.
	 * @param dorYdNm
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDoorYardName(String dorYdNm) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{

			param.put("zn_cd", dorYdNm);
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchDoorYardNameRSQL(), param, param);
            
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}
