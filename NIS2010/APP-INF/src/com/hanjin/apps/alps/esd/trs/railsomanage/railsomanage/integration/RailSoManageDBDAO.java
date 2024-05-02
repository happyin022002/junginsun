/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailSoManageDBDAO.java
*@FileTitle : USA Rail Billing S/O를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.15
*@LastModifier : 최 선
*@LastVersion : 1.9
* 2006.11.23 kim_sang_geun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.02.19 조풍연    1.1 [R200902180005] RAIL SO CANCEL시 LOG_UPD_DT 갱신 로직 추가
* 2009.03.24 조풍연    1.2 [N200903160150] [SCEM] RTR 생성 로직 보완 요청
* 2009.06.09 조풍연    1.3 [N200906020130] [TRS-Rail EDI] DG 정보 오전송에 따른 보완
* 2009.06.10 조풍연    1.4 [] Rail Export Cargo Available Return Time 개발
* 2009.07.03 조풍연    1.5 [] TRS Railbilling Correction 수정
* 2009.07.31 조풍연    1.6 [] TRS Railbilling Correction 화면 변경
* 2010.11.23 이재위    1.7 [] [TRS] OPMS Design/Development Verification 을 위한 소스 점검
* 2010.12.14   최 선	1.8 [CHM-201007629-01] C2T, C3T Inv pattern 에 대한 AGMT attach logic 추가요청
* 2011.03.15   최 선	1.9 [CHM-201109513] [TRS] S/O 상의 W/O amount (USD) 일부 누락 오류 정정요청
* 2012.01.16 금병주 	1.10[CHM-201215713] [TRS] S/O 다중작업에 의한 COP status 오류 방지로직 추가요청 (US rail)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.basic.RailSoManageBCImpl;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.vo.SearchRailSoManageHdrVO;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.vo.EqrRepoExeSoIfVO;
import com.hanjin.apps.alps.esd.trs.servicesio.common.vo.CommonVo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kim_sang_geun
 * @see RailSoManageBCImpl 참조
 * @since J2EE 1.4
 */
public class RailSoManageDBDAO extends DBDAOSupport {

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP In Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<TrsTrspRailBilOrdVO> search01RailSoManageSel(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();
		
		ArrayList st    = null;
		
		List<String> vvd = new ArrayList();
		List<String> bkg = new ArrayList();
		List<String> bl = new ArrayList();
		List<String> cntr = new ArrayList();
		List<String> scNo = new ArrayList();
		
		try{			
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(event != null && !"".equals(event.getStrunkVvd())){				
				st = CommonUtil.seperationParameter(event.getStrunkVvd(), ",");
				vvd.addAll(st);
			}
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			
			if(event != null && !"".equals(event.getSbkgNo())){				
				st = CommonUtil.seperationParameter(event.getSbkgNo(), ",");
				bkg.addAll(st);
			}
			param.put("bkg", bkg);
			velParam.put("bkg", bkg);
			
			if(event != null && !"".equals(event.getSbilNo())){				
				st = CommonUtil.seperationParameter(event.getSbilNo(), ",");
				bl.addAll(st);
			}
			param.put("bl", bl);
			velParam.put("bl", bl);
			
			if(event != null && !"".equals(event.getScntrNo())){				
				st = CommonUtil.seperationParameter(event.getScntrNo(), ",");
				cntr.addAll(st);
			}
			param.put("cntr", cntr);
			velParam.put("cntr", cntr);
			
			if(event != null && !"".equals(event.getScNo())){				
				st = CommonUtil.seperationParameter(event.getScNo(), ",");
				scNo.addAll(st);
			}
			param.put("scNo", scNo);
			velParam.put("scNo", scNo);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch01RailSoManageSelRSQL(), param, velParam);
			
			trsTrspRailBilOrdVO = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsTrspRailBilOrdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return trsTrspRailBilOrdVO;
	}
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP In Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @return
	 * @throws DAOException
	 */
	public String search01RailSoManageSeq() throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		
		String lSeq = "";
		
		try{
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch01RailSoManageSeqRSQL(), null, null);
			
			dbRowset.next();
			lSeq = dbRowset.getString("seq");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return lSeq;
	}
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP In Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @throws DAOException
	 */
	public void search01RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int insCnt[] = null;
		
		try{
			param.put("trsp_rail_tmp_seq", lSeq);
			param.put("sCtrlUserId", sCtrlUserId);
			
			if(vo.size() > 0){				
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOSearch01RailSoManageCSQL(), vo, param, param);
				for(int h = 0; h < insCnt.length; h++){
					if(insCnt[h]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ h + " SQL");
				}
			}						
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP In Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param lSeq
	 * @throws DAOException
	 */
	public void search01RailSoManageUpd(String lSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("trsp_rail_tmp_seq", lSeq);
			
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOSearch01RailSoManageUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP In Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param lSeq
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search01RailSoManage(String lSeq) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("trsp_rail_tmp_seq", lSeq);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch01RailSoManageRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP In Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param lSeq
	 * @throws DAOException
	 */
	public void search01RailSoManageDel(String lSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("trsp_rail_tmp_seq", lSeq);
			
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOSearch01RailSoManageDSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Detail Inquity Popup<br>
	 * 
	 * @param soffice_cd
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search02RailSoManage(String soffice_cd, EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList st    = null;
		
//		ArrayList arrSize = new ArrayList();
		List<String> eqNoVerify = new ArrayList();
//		List<String> frmNodeVerify = new ArrayList();
		
		try {			
			if(event != null && !"".equals(event.getEqNoVerify())){				
				st = CommonUtil.seperationParameter(event.getEqNoVerify(), ",");
				eqNoVerify.addAll(st);
			}
			
			param.put("eqNoVerify", eqNoVerify);
			velParam.put("eqNoVerify", eqNoVerify); 
			
			param.put("sofficeCd", soffice_cd);
			velParam.put("sofficeCd", soffice_cd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch02RailSoManageRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * USA Rail Billing Correction 대상 조회<br>
	 * N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRailSoCorrectionTargetList(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList st    = null;
		
		List<String> vvd = new ArrayList();
		List<String> bkg = new ArrayList();
		List<String> bl = new ArrayList();
		List<String> cntr = new ArrayList();
		
//		int j = 0;
		
		try {
						
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(event != null && !"".equals(event.getStrunkVvd())){				
				st = CommonUtil.seperationParameter(event.getStrunkVvd(), ",");
				vvd.addAll(st);
			}
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			
			if(event != null && !"".equals(event.getSbkgNo())){
				st = CommonUtil.seperationParameter(event.getSbkgNo(), ",");
				bkg.addAll(st);
			}
			param.put("bkg", bkg);
			velParam.put("bkg", bkg);
			
			if(event != null && !"".equals(event.getSbilNo())){
				st = CommonUtil.seperationParameter(event.getSbilNo(), ",");
				bl.addAll(st);
			}
			param.put("bl", bl);
			velParam.put("bl", bl);
			
			if(event != null && !"".equals(event.getScntrNo())){
				st = CommonUtil.seperationParameter(event.getScntrNo(), ",");
				cntr.addAll(st);
			}
			param.put("cntr", cntr);
			velParam.put("cntr", cntr);
			
			if("BU".equals(event.getSdateSep())){
				if(!"".equals(event.getSplanFromDate())){
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchRailSoCorrectionTargetListBkgUpdByDateRSQL(), param, velParam);
				}else{
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchRailSoCorrectionTargetListBkgUpdRSQL(), param, velParam);					
				}
			}else{
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchRailSoCorrectionTargetListRSQL(), param, velParam);				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ESD-TRS-928 IRG Adjust Pop up Search
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search04RailSoManage(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String sParameter = JSPUtil.getNull(event.getHid_parameter());
		String sempty_yn  = JSPUtil.getNull(event.getEmpty_yn());
		// 1차 sParameter seperate --------------------------------------
		log.debug("sParameter  >>>>>>>:"+sParameter);
		ArrayList arrParaList = null;
		          arrParaList = CommonUtil.seperationParameter(sParameter, "|");
		int       arrParasize = arrParaList.size();
		log.debug("arrParaList  >>>>>>>:"+arrParaList);
		log.debug("arrParasize  >>>>>>>:"+arrParasize);
		ArrayList arr_size         = new ArrayList();
		ArrayList lnk_org_nod_cd   = new ArrayList();
		ArrayList lnk_dest_nod_cd  = new ArrayList();
		ArrayList cgo_tp_cd        = new ArrayList();
		ArrayList rout_org_nod_cd  = new ArrayList();
		ArrayList rout_dest_nod_cd = new ArrayList();
		ArrayList rout_seq         = new ArrayList();
		ArrayList trsp_bnd_cd      = new ArrayList();
		ArrayList bkg_rcvde_term_cd= new ArrayList();
		ArrayList key_org          = new ArrayList();
		ArrayList key_dest         = new ArrayList();
		
		String sTrspBndCd      = "";
		String sBkgRcvdeTermCd = "";
		String sLnkOrgNodCd    = "";
		String sLnkDestNodCd   = "";
		String sRoutOrgNodCd   = "";
		String sRoutDestNodCd  = "";
		String sRoutSeq        = "";
		String sCgoTpCd        = "";
		String sKeyOrg         = "";
		String sKeyDest        = "";
		
		try{
			if( arrParaList != null && arrParasize > 0 ){
				ArrayList arrSubList = new ArrayList();
				for(int idx = 0; idx < arrParasize; idx++){
					//2차 arrParaList seperate-------------------------------
					String subParam = String.valueOf(arrParaList.get(idx));
					arrSubList = CommonUtil.seperationParameter(subParam, ",");
					log.debug("arrSubList  >>>>>>>:"+arrSubList);
					sTrspBndCd      = "'"+arrSubList.get(0)+"'";
					sBkgRcvdeTermCd = "'"+arrSubList.get(1)+"'";
					sLnkOrgNodCd    = "'"+arrSubList.get(2)+"'";
					sLnkDestNodCd   = "'"+arrSubList.get(3)+"'";
					sRoutOrgNodCd   = "'"+arrSubList.get(4)+"'";
					sRoutDestNodCd  = "'"+arrSubList.get(5)+"'";
					sRoutSeq        = "'"+arrSubList.get(6)+"'";
					sCgoTpCd        = "'"+arrSubList.get(7)+"'";
					sKeyOrg         = "'"+arrSubList.get(8)+"'";
					sKeyDest        = "'"+arrSubList.get(9)+"'";
					
					arr_size.add(idx);
					trsp_bnd_cd.add(sTrspBndCd);
					bkg_rcvde_term_cd.add(sBkgRcvdeTermCd);
					lnk_org_nod_cd.add(sLnkOrgNodCd);
					lnk_dest_nod_cd.add(sLnkDestNodCd);
					rout_org_nod_cd.add(sRoutOrgNodCd);
					rout_dest_nod_cd.add(sRoutDestNodCd);
					rout_seq.add(sRoutSeq);
					cgo_tp_cd.add(sCgoTpCd);
					key_org.add(sKeyOrg);
					key_dest.add(sKeyDest);
				}// for Statement End ----------------------------
				// Velocity SQL PARAMS Setting -------------------
				param.put("empty_yn"           , sempty_yn        );
				param.put("arr_size"           , arr_size         );
				param.put("lnk_org_nod_cd"     , lnk_org_nod_cd   );
				param.put("lnk_dest_nod_cd"    , lnk_dest_nod_cd  );
				param.put("cgo_tp_cd"          , cgo_tp_cd        );
				param.put("rout_org_nod_cd"    , rout_org_nod_cd  );
				param.put("rout_dest_nod_cd"   , rout_dest_nod_cd );
				param.put("rout_seq"           , rout_seq         );
				param.put("trsp_bnd_cd"        , trsp_bnd_cd      );
				param.put("bkg_rcvde_term_cd"  , bkg_rcvde_term_cd);
				param.put("key_org"            , key_org          );
				param.put("key_dest"           , key_dest         );
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch04RailSoManageRSQL(), param, param);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
		
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ESD-TRS-928  IRG Candidate 리스트 가져옴.  dropdownlist 에 뿌릴 데이터 set.
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchIrgCandidate(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		ArrayList arr_size         = new ArrayList();
		ArrayList arr_seq          = new ArrayList();
		ArrayList bkg_rcvde_term_cd= new ArrayList();
		ArrayList trsp_bnd_cd      = new ArrayList();
		ArrayList cgo_tp_cd        = new ArrayList();
		ArrayList key_org          = new ArrayList();
		ArrayList key_dest         = new ArrayList();
		
		String sempty_yn  = JSPUtil.getNull(event.getEmpty_yn());
		
		try{
			
			String[] arrSeq            = event.getArrSeq();
			String[] arrBkgRcvdeTermCd = event.getArrBkgRcvdeTermCd();
			String[] arrTrspBndCd      = event.getArrTrspBndCd();
			String[] arrCgoTpCd        = event.getArrCgoTpCd();
			String[] arrKeyOrg         = event.getArrKeyOrg();
			String[] arrKeyDest        = event.getArrKeyDest();
			
			if(arrSeq != null){
				int irg_adjust_rows = arrSeq.length;
				for(int idx = 0; idx < irg_adjust_rows; idx++){
					arr_size.add(idx);
					arr_seq.add("'"+arrSeq[idx]+"'");
					bkg_rcvde_term_cd.add("'"+arrBkgRcvdeTermCd[idx]+"'");
					trsp_bnd_cd.add("'"+arrTrspBndCd[idx]+"'");
					cgo_tp_cd.add("'"+arrCgoTpCd[idx]+"'");
					key_org.add("'"+arrKeyOrg[idx]+"'");
					key_dest.add("'"+arrKeyDest[idx]+"'");
				}// for Statement End ----------------------------
				// Velocity SQL PARAMS Setting -------------------
				param.put("arr_size"           , arr_size         );
				param.put("cgo_tp_cd"          , cgo_tp_cd        );
				param.put("rout_seq"           , arr_seq          );
				param.put("trsp_bnd_cd"        , trsp_bnd_cd      );
				param.put("bkg_rcvde_term_cd"  , bkg_rcvde_term_cd);
				param.put("key_org"            , key_org          );
				param.put("key_dest"           , key_dest         );
				param.put("empty_yn"           , sempty_yn        );
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchIrgCandidateRSQL(), param, param);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP Out Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<TrsTrspRailBilOrdVO> search06RailSoManageSel(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();
		
		ArrayList st    = null;

		List<String> vvd = new ArrayList();
		List<String> bkg = new ArrayList();
		List<String> cntr = new ArrayList();
		
		try{			
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(event != null && !"".equals(event.getStrunkVvd())){
				st = CommonUtil.seperationParameter(event.getStrunkVvd(), ",");
				vvd.addAll(st);
			}
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			
			if(event != null && !"".equals(event.getSbkgNo())){				
				st = CommonUtil.seperationParameter(event.getSbkgNo(), ",");
				bkg.addAll(st);
			}
			param.put("bkg", bkg);
			velParam.put("bkg", bkg);
			
			if(event != null && !"".equals(event.getScntrNo())){				
				st = CommonUtil.seperationParameter(event.getScntrNo(), ",");
				cntr.addAll(st);
			}
			param.put("cntr", cntr);
			velParam.put("cntr", cntr);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch06RailSoManageSelRSQL(), param, velParam);
			
			trsTrspRailBilOrdVO = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsTrspRailBilOrdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return trsTrspRailBilOrdVO;
	}
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP Out Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @throws DAOException
	 */
	public void search06RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int insCnt[] = null;
		
		try{
			param.put("trsp_rail_tmp_seq", lSeq);
			param.put("sCtrlUserId", sCtrlUserId);
			
			if(vo.size() > 0){				
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOSearch06RailSoManageCSQL(), vo, param, param);
				for(int h = 0; h < insCnt.length; h++){
					if(insCnt[h]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ h + " SQL");
				}
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP Out Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param lSeq
	 * @throws DAOException
	 */
	public void search06RailSoManageUpd(String lSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
//		int insCnt[] = null;
		
		try{
			param.put("trsp_rail_tmp_seq", lSeq);
			
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOSearch06RailSoManageUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}	
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP Out Bound Retrieve 쿼리<br>
	 * S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	 * 
	 * @param lSeq
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search06RailSoManage(String lSeq) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("trsp_rail_tmp_seq", lSeq);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch06RailSoManageRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP Out Bound Retrieve 쿼리<br>
	 * 
	 * @param lSeq
	 * @throws DAOException
	 */
	public void search06RailSoManageDel(String lSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
//		int insCnt[] = null;
		
		try{
			param.put("trsp_rail_tmp_seq", lSeq);
			
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOSearch06RailSoManageDSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * COP Out Bound<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRailsoBybkgcntr(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList st    = null;
		
//		ArrayList arrSize = new ArrayList();
		List<String> bkgNo = new ArrayList();
		List<String> cntrNo = new ArrayList();
		
		try {			
			if(event != null && !"".equals(event.getSbkgNo())){				
				st = CommonUtil.seperationParameterPlusQuotation(event.getSbkgNo(), ",");
				bkgNo.addAll(st);
			}
			
			if(event != null && !"".equals(event.getScntrNo())){				
				st = CommonUtil.seperationParameterPlusQuotation(event.getScntrNo(), ",");
				cntrNo.addAll(st);
			}
			
			param.put("bkgNo", bkgNo);
			velParam.put("bkgNo", bkgNo); 
			
			param.put("cntrNo", cntrNo);
			velParam.put("cntrNo", cntrNo);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchRailSoByBkgCntrRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}





	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Detail Inquity Popup<br>
	 * 
	 * @param soffice_cd
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search07RailSoManage(String soffice_cd, EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList st    = null;
		ArrayList st1   = null;
		ArrayList st2   = null;
		ArrayList stMulti = new ArrayList();
		
		// ArrayList arrSize = new ArrayList();
		List<String> eqNoVerify = new ArrayList();
		List<String> bkgNoVerify = new ArrayList();
		List<String> eqToNodVerify = new ArrayList();
		
		try {			
			if(event != null && !"".equals(event.getEqNoVerify())){				
				st = CommonUtil.seperationParameter(event.getEqNoVerify(), ",");
				st1 = CommonUtil.seperationParameter(event.getToNodVerify(), ",");
				st2 = CommonUtil.seperationParameter(event.getBkgNoVerify(), ",");
				eqNoVerify.addAll(st);
				bkgNoVerify.addAll(st2);
				
				for( int i = 0; i < st.size(); i++){
					if( ((String)st1.get(i)).equals("USORF") ){
						stMulti.add(i, "USSEA" + (String)st.get(i));
					}else{
						stMulti.add(i, (String)st1.get(i) + (String)st.get(i));						
					}
					
				}
				eqToNodVerify.addAll(stMulti);
			}
			
			param.put("eqNoVerify", eqNoVerify);
			velParam.put("eqNoVerify", eqNoVerify); 
			
			param.put("eqToNodVerify", eqToNodVerify);
			velParam.put("eqToNodVerify", eqToNodVerify);
			
			param.put("bkgNoVerify", bkgNoVerify);
			velParam.put("bkgNoVerify", bkgNoVerify);
			
			param.put("sofficeCd", soffice_cd);
			velParam.put("sofficeCd", soffice_cd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch07RailSoManageRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Empty Repo<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search08RailSoManage(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList st    = null;
		
		List<String> cntr = new ArrayList();
		List<String> refId = new ArrayList();
		
//		int j = 0;
		
		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(event != null && !"".equals(event.getScntrNo())){				
				st = CommonUtil.seperationParameter(event.getScntrNo(), ",");
				cntr.addAll(st);
			}
			param.put("cntr", cntr);
			velParam.put("cntr", cntr);
			
			if(event != null && !"".equals(event.getReferNo())){				
				st = CommonUtil.seperationParameter(event.getReferNo(), ",");
				refId.addAll(st);
			}
			param.put("refId", refId);
			velParam.put("refId", refId);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch08RailSoManageRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Empty Repo<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search09RailSoManage(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList st    = null;
		
		ArrayList arrSize = new ArrayList();
		List<String> refId = new ArrayList();
		List<String> eqTpSzCd = new ArrayList();
		
		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(event != null && !"".equals(event.getHidRefId())){				
				st = CommonUtil.seperationParameterPlusQuotation(event.getHidRefId(), ",");
				refId.addAll(st);
				for(int i = 0; i < st.size(); i++){
					arrSize.add(i);
				}
			}
			param.put("arrNo", arrSize);
			velParam.put("arrNo", arrSize); 
			
			param.put("refId", refId);
			velParam.put("refId", refId); 
			
			if(event != null && !"".equals(event.getHidEqTpszCd())){				
				st = CommonUtil.seperationParameterPlusQuotation(event.getHidEqTpszCd(), ",");
				eqTpSzCd.addAll(st);
			}
			param.put("eqTpSzCd", eqTpSzCd);
			velParam.put("eqTpSzCd", eqTpSzCd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch09RailSoManageRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Request Service Provider Inquity Popup<br>
	 * 
	 * @param soffice_cd
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search11RailSoManage(String soffice_cd, EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList st    = null;
		ArrayList st1   = null;
		ArrayList st2   = null;
		ArrayList stMulti = new ArrayList();
		
		ArrayList arrSize = new ArrayList();
		List<String> eqNoVerify = new ArrayList();
		List<String> frmNodeVerify = new ArrayList();
//		List<String> toNodVerify = new ArrayList();
		List<String> eqToNodVerify = new ArrayList();
		
		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(event != null && !"".equals(event.getEqNoVerify())){				
				st = CommonUtil.seperationParameterPlusQuotation(event.getEqNoVerify(), ",");
				st1 = CommonUtil.seperationParameter(event.getEqNoVerify(), ",");
				st2 = CommonUtil.seperationParameter(event.getToNodVerify(), ",");
				eqNoVerify.addAll(st);
				for(int i = 0; i < st.size(); i++){
					if( ((String)st2.get(i)).equals("USORF") ){
						stMulti.add(i, "'" + "USSEA" + (String)st1.get(i) + "'");
					}else{
						stMulti.add(i, "'" + (String)st2.get(i) + (String)st1.get(i) + "'");						
					}
					arrSize.add(i);
				}
				eqToNodVerify.addAll(stMulti);
			}
			
			param.put("arrNo", arrSize);
			velParam.put("arrNo", arrSize); 
			
			param.put("eqNoVerify", eqNoVerify);
			velParam.put("eqNoVerify", eqNoVerify); 
			
			param.put("eqToNodVerify", eqToNodVerify);
			velParam.put("eqToNodVerify", eqToNodVerify);
			
			if(event != null && !"".equals(event.getFrmNodeVerify())){				
				st = CommonUtil.seperationParameterPlusQuotation(event.getFrmNodeVerify(), ",");
				frmNodeVerify.addAll(st);
			}
			param.put("frmNodeVerify", frmNodeVerify);
			velParam.put("frmNodeVerify", frmNodeVerify);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch11RailSoManageRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Request Service Provider Inquiry Popup<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search13RailSoManage(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			Map<String, String> condiParams = event.getColumnValues();
			param.put("f_trsp_so_ofc_cty_cd", condiParams.get("f_trsp_so_ofc_cd"));
			param.put("f_trsp_so_seq"       , condiParams.get("f_trsp_so_seq"));
			param.put("f_prov_vndr_seq"     , condiParams.get("f_prov_vndr_seq"));
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch13RailSoManageRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}		
		return dbRowset;
	}

	/**
	 * RailSoManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Request Empty Container Check<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search14RailSoManage(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearch14RailSoManageRSQL(), param, velParam);
			
			if( dbRowset.getRowCount() < 1 ) {
				throw new DAOException(new ErrorHandler("TRS00345").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * RailSoManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 *
	 * @param event
	 * @param h
	 * @return
	 * @throws DAOException
	 */
	public ArrayList modifyTrsTrspRailBillingVos(EsdTrs0201Event event, int h) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspRailBilOrdVO> updateVoListFull = new ArrayList<TrsTrspRailBilOrdVO>();
		List<TrsTrspRailBilOrdVO> updateVoListEmpty = new ArrayList<TrsTrspRailBilOrdVO>();
		
		TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
	  	
		ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		
		int insCnt[] = null;	

		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
								
			if ( "I".equals(model[h].getIbflag()) || "U".equals(model[h].getIbflag()) ){
				arrSeq.add(model[h].getTrspSoSeq());
				if( "F".equals(model[h].getCgoTpCd()) ){
					updateVoListFull.add(model[h]);
				}else{
					updateVoListEmpty.add(model[h]);
				}
			}
			
			if(updateVoListFull.size() > 0){				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailConvAmtDSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailConvAmtDSQL(), updateVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetDSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetDSQL(), updateVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilOrdUSQL(), updateVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetCSQL(), updateVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspEdiRailTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			
			if(updateVoListEmpty.size() > 0){				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailConvAmtDSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailConvAmtDSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetDSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetDSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilOrdUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilOrdUSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspRailBilVndrSetCSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoEqrRepoExeSoIfUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoEqrRepoExeSoIfUSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAOModifyUsaRailBillVoTrsTrspEdiRailTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOModifyUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arrSeq;
	}

	/**
	 * RailSoManage의 데이타 모델을 DB에서 삭제한다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList removeTrsTrspRailBillingVos(EsdTrs0201Event event) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspRailBilOrdVO> updateVoListFullRequestBkg = new ArrayList<TrsTrspRailBilOrdVO>();
		List<TrsTrspRailBilOrdVO> updateVoListFull = new ArrayList<TrsTrspRailBilOrdVO>();
		List<TrsTrspRailBilOrdVO> updateVoListEmpty = new ArrayList<TrsTrspRailBilOrdVO>();
		
		TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
	  	
		ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		
		int insCnt[] = null;		

		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			for(int i = 0; i < model.length; i++){							
				if ( "I".equals(model[i].getIbflag()) || "U".equals(model[i].getIbflag()) ){
					arrSeq.add(model[i].getTrspSoSeq());
					if( "F".equals(model[i].getCgoTpCd()) && "Y".equals(model[i].getTrspRqstBkgFlg()) ){
						updateVoListFullRequestBkg.add(model[i]);
					}else if( "F".equals(model[i].getCgoTpCd()) && !"Y".equals(model[i].getTrspRqstBkgFlg()) ){
						updateVoListFull.add(model[i]);
					}else{
						updateVoListEmpty.add(model[i]);
					}
				}				
			}
			
			if(updateVoListFullRequestBkg.size() > 0){
				param.put("trspRqstBkgFlg", "Y");
				velParam.put("trspRqstBkgFlg", "Y");
				
				// RailSoManageDBDAORemoveUsaRailBillVoUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoUSQL(), updateVoListFullRequestBkg, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoListFullRequestBkg, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			
			if(updateVoListFull.size() > 0){
				param.put("trspRqstBkgFlg", "");
				velParam.put("trspRqstBkgFlg", "");
				
				// RailSoManageDBDAORemoveUsaRailBillVoUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoUSQL(), updateVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoListFull, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			
			if(updateVoListEmpty.size() > 0){
				// RailSoManageDBDAORemoveUsaRailBillVoUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoUSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoEqrRepoExeSoIfUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoEqrRepoExeSoIfUSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arrSeq;
	}
	
	/**
	 * ESD_TRS_0203: Row Delete
	 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
	 * Check된 복수개의 Row Delete
	 * 2013.11.27 by SHIN DONG IL
	 * @param hdrVO SearchRailSoManageHdrVO
	 * @throws DAOException
	 */
	public void removeEmptyRepoPlanForRail(SearchRailSoManageHdrVO hdrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();


		try {
			Map<String, String> mapVO = hdrVO.getColumnValues();
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new RailSoManageDBDAODeleteEmptyRepoPlanForRailDSQL(), param, param);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * RailSoManage의 데이타 모델을 DB에서 삭제한다.<br>
	 *
	 * @param soffice_cd
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList removeTrsTrspRailBillingVosForSpp(String soffice_cd, EsdTrs0201Event event) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspRailBilOrdVO> updateVoListEmptyRequestBkg = new ArrayList<TrsTrspRailBilOrdVO>();
		List<TrsTrspRailBilOrdVO> updateVoListEmpty = new ArrayList<TrsTrspRailBilOrdVO>();
		
		TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
	  	
		ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		
		int insCnt[] = null;		

		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			for(int i = 0; i < model.length; i++){
				if("M".equals(model[i].getCgoTpCd())){
					if ( "I".equals(model[i].getIbflag()) || "U".equals(model[i].getIbflag()) ){
						arrSeq.add(model[i].getTrspSoSeq());
						if("Y".equals(model[i].getTrspRqstBkgFlg()) ){
							updateVoListEmptyRequestBkg.add(model[i]);
						}else{
							updateVoListEmpty.add(model[i]);
						}
					}						
				}			
			}
			
			if(updateVoListEmptyRequestBkg.size() > 0){
				param.put("trspRqstBkgFlg", "Y");
				velParam.put("trspRqstBkgFlg", "Y");
				
				// RailSoManageDBDAORemoveUsaRailBillVoUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoUSQL(), updateVoListEmptyRequestBkg, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoEqrRepoExeSoIfUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoEqrRepoExeSoIfUSQL(), updateVoListEmptyRequestBkg, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoListEmptyRequestBkg, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
			
			if(updateVoListEmpty.size() > 0){
				// RailSoManageDBDAORemoveUsaRailBillVoUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoUSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoEqrRepoExeSoIfUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoEqrRepoExeSoIfUSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
				
				// RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAORemoveUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoListEmpty, param, velParam);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ j + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arrSeq;
	}	

	/**
	 * RailSoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param soffice_cd
	 * @throws DAOException
	 */
	public void multiProcTrsTrspRailBillingVos(String soffice_cd) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map outProc = null;
		
		boolean isUpdate = false;
		
		int insCnt = 0;

		String railCmbThruTpCd = null;
		int subRailSeq = 0;
		
		try{		
			param.put("soffice_cd", soffice_cd);
			velParam.put("soffice_cd", soffice_cd); 
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailBilOrdRSQL(), null, null);
										
			while(dbRowset.next()) {
				isUpdate = true;
				
				if( dbRowset.getString("trsp_agmt_ofc_cty_cd") == null || "".equals(dbRowset.getString("trsp_agmt_ofc_cty_cd")) || dbRowset.getInt("trsp_agmt_seq") == 0 ) {
					throw new DAOException(new ErrorHandler("TRS00103").getMessage());
				}
				
				railCmbThruTpCd = dbRowset.getString("rail_cmb_thru_tp_cd");
			    subRailSeq = dbRowset.getInt("sub_rail_seq");
			    
			    if (railCmbThruTpCd.equals("C2T") || railCmbThruTpCd.equals("C3T")) {
			    	if (subRailSeq == 1) {
						param.put("to_nod_cd", dbRowset.getString("al_to_nod_cd"));
						velParam.put("to_nod_cd", dbRowset.getString("al_to_nod_cd"));	
			    	}else {
			    		break;
			    	}
			    } else {
					param.put("to_nod_cd", dbRowset.getString("to_nod_cd"));
					velParam.put("to_nod_cd", dbRowset.getString("to_nod_cd"));
			    }
			    
				param.put("trsp_agmt_ofc_cty_cd", dbRowset.getString("trsp_agmt_ofc_cty_cd"));
				velParam.put("trsp_agmt_ofc_cty_cd", dbRowset.getString("trsp_agmt_ofc_cty_cd"));
				
				param.put("trsp_agmt_seq", dbRowset.getInt("trsp_agmt_seq"));
				velParam.put("trsp_agmt_seq", dbRowset.getInt("trsp_agmt_seq"));
				
				param.put("trsp_so_seq", dbRowset.getInt("trsp_so_seq"));
				velParam.put("trsp_so_seq", dbRowset.getInt("trsp_so_seq"));
				
				param.put("trsp_so_ofc_cty_cd", dbRowset.getString("trsp_so_ofc_cty_cd"));
				velParam.put("trsp_so_ofc_cty_cd", dbRowset.getString("trsp_so_ofc_cty_cd"));
				
				param.put("sub_rail_seq", dbRowset.getInt("sub_rail_seq"));
				velParam.put("sub_rail_seq", dbRowset.getInt("sub_rail_seq"));
				
				param.put("cre_ofc_cd", dbRowset.getString("cre_ofc_cd"));
				velParam.put("cre_ofc_cd", dbRowset.getString("cre_ofc_cd"));
				
				param.put("cre_usr_id", dbRowset.getString("cre_usr_id"));
				velParam.put("cre_usr_id", dbRowset.getString("cre_usr_id"));
				
				param.put("upd_usr_id", dbRowset.getString("upd_usr_id"));
				velParam.put("upd_usr_id", dbRowset.getString("upd_usr_id"));
				
				param.put("vndr_seq", dbRowset.getString("vndr_seq"));
				velParam.put("vndr_seq", dbRowset.getString("vndr_seq"));
								
				param.put("locl_cre_dt", dbRowset.getDate("locl_cre_dt"));
				velParam.put("locl_cre_dt", dbRowset.getDate("locl_cre_dt"));
				
				param.put("eq_knd_cd", dbRowset.getString("eq_knd_cd"));
				velParam.put("eq_knd_cd", dbRowset.getString("eq_knd_cd"));
				
				param.put("eq_tpsz_cd", dbRowset.getString("eq_tpsz_cd"));
				velParam.put("eq_tpsz_cd", dbRowset.getString("eq_tpsz_cd"));
				
				param.put("cgo_tp_cd", dbRowset.getString("cgo_tp_cd"));
				velParam.put("cgo_tp_cd", dbRowset.getString("cgo_tp_cd"));
				
				param.put("trsp_bnd_cd", dbRowset.getString("trsp_bnd_cd"));
				velParam.put("trsp_bnd_cd", dbRowset.getString("trsp_bnd_cd"));
				
				param.put("trsp_cost_dtl_mod_cd", dbRowset.getString("trsp_cost_dtl_mod_cd"));
				velParam.put("trsp_cost_dtl_mod_cd", dbRowset.getString("trsp_cost_dtl_mod_cd"));
				
				param.put("cust_cnt_cd", dbRowset.getString("cust_cnt_cd"));
				velParam.put("cust_cnt_cd", dbRowset.getString("cust_cnt_cd"));
				
				param.put("cust_seq", dbRowset.getInt("cust_seq"));
				velParam.put("cust_seq", dbRowset.getInt("cust_seq"));
				
				param.put("rail_crr_tp_cd", dbRowset.getString("rail_crr_tp_cd"));
				velParam.put("rail_crr_tp_cd", dbRowset.getString("rail_crr_tp_cd"));
				
				param.put("cmdt_cd", dbRowset.getString("cmdt_cd"));
				velParam.put("cmdt_cd", dbRowset.getString("cmdt_cd"));
				
				param.put("fm_nod_cd", dbRowset.getString("fm_nod_cd"));
				velParam.put("fm_nod_cd", dbRowset.getString("fm_nod_cd"));
				
				param.put("bundel_cnt", dbRowset.getInt("bundle_cnt"));
				velParam.put("bundel_cnt", dbRowset.getInt("bundle_cnt"));
				
				param.put("wgt_meas_ut_cd", dbRowset.getString("wgt_meas_ut_cd"));
				velParam.put("wgt_meas_ut_cd", dbRowset.getString("wgt_meas_ut_cd"));
				
				param.put("cntr_wgt", dbRowset.getFloat("cntr_wgt"));
				velParam.put("cntr_wgt", dbRowset.getFloat("cntr_wgt"));
				
				param.put("spcl_cgo_cntr_tp_cd", dbRowset.getString("spcl_cgo_cntr_tp_cd"));
				velParam.put("spcl_cgo_cntr_tp_cd", dbRowset.getString("spcl_cgo_cntr_tp_cd"));
				
				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new RailSoManageDBDAOMultiProcRSQL(), param, velParam);
				
				param.put("po_local_curr_cd", (String) outProc.get("po_local_curr_cd"));
				velParam.put("po_local_curr_cd", (String) outProc.get("po_local_curr_cd"));
				
				param.put("po_basic_rt", (String) outProc.get("po_basic_rt"));
				velParam.put("po_basic_rt", (String) outProc.get("po_basic_rt"));
				
				param.put("po_fuel_scg_rt", (String) outProc.get("po_fuel_scg_rt"));
				velParam.put("po_fuel_scg_rt", (String) outProc.get("po_fuel_scg_rt"));
				
				param.put("po_over_wgt_scg_rt", (String) outProc.get("po_over_wgt_scg_rt"));
				velParam.put("po_over_wgt_scg_rt", (String) outProc.get("po_over_wgt_scg_rt"));
				
				param.put("po_way_type", (String) outProc.get("po_way_type"));
				velParam.put("po_way_type", (String) outProc.get("po_way_type"));
				
				param.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				velParam.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				
				param.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				velParam.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd")); 
				
				//20100802 add
				param.put("po_hzs_scg_rt", (String) outProc.get("po_hzs_scg_rt"));
				velParam.put("po_hzs_scg_rt", (String) outProc.get("po_hzs_scg_rt"));	
				
				param.put("po_ttl_scg_rt", (String) outProc.get("po_ttl_scg_rt"));
				velParam.put("po_ttl_scg_rt", (String) outProc.get("po_ttl_scg_rt"));	
				velParam.put("po_ttl_scg_rt", (String) outProc.get("po_ttl_scg_rt")); 
				
				if((String) outProc.get("po_trsp_agmt_rt_tp_cd") != null && !"".equals((String) outProc.get("po_trsp_agmt_rt_tp_cd"))){
					// RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}	
					
					// RailSoManageDBDAOMultiProcTrsTrspRailConvAmtEurCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailConvAmtEurCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}
				}
				
				// RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update No" + " SQL");
				}				
			}			
			if( !isUpdate ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * RailSoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param customData
	 * @param soffice_cd
	 * @throws DAOException
	 */
	public void multiProcTrsTrspRailBillingVosForNoTranjection(Map<String, Object> customData, String soffice_cd) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map outProc = null;
		
		boolean isUpdate = false;
		
		int insCnt = 0;
		
		String railCmbThruTpCd = null;
		int subRailSeq = 0;
		
		try{		
			param.put("soffice_cd", soffice_cd);
			velParam.put("soffice_cd", soffice_cd);
			
			param.put("in_trsp_so_ofc_cty_cd", soffice_cd.substring(0, 3));
			velParam.put("in_trsp_so_ofc_cty_cd", soffice_cd.substring(0, 3));
			
			customData.get("arrTrspSoSeq");
			
			ArrayList soSeqArr = (ArrayList)customData.get("arrTrspSoSeq");
			String soSeq [] = (String []) soSeqArr.toArray (new String [soSeqArr.size ()]);
			
			param.put("in_trsp_so_seq", soSeq[0]);
			velParam.put("in_trsp_so_seq", soSeq[0]);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailBilOrdNoTranactionRSQL(), param, velParam);
			
			while(dbRowset.next()) {
				isUpdate = true;
				
				if( dbRowset.getString("trsp_agmt_ofc_cty_cd") == null || "".equals(dbRowset.getString("trsp_agmt_ofc_cty_cd")) || dbRowset.getInt("trsp_agmt_seq") == 0 ) {
					throw new DAOException(new ErrorHandler("TRS00103").getMessage());
				}
				
				railCmbThruTpCd = dbRowset.getString("rail_cmb_thru_tp_cd");
			    subRailSeq = dbRowset.getInt("sub_rail_seq");
			    
			    if (railCmbThruTpCd.equals("C2T") || railCmbThruTpCd.equals("C3T")) {
			    	if (subRailSeq == 1) {
						param.put("to_nod_cd", dbRowset.getString("al_to_nod_cd"));
						velParam.put("to_nod_cd", dbRowset.getString("al_to_nod_cd"));	
			    	}else {
			    		break;
			    	}
			    } else {
					param.put("to_nod_cd", dbRowset.getString("to_nod_cd"));
					velParam.put("to_nod_cd", dbRowset.getString("to_nod_cd"));
			    }
//			    log.debug("railCmbThruTpCd>>>>>>>>>>>>>>>>>>>>>>>>"+railCmbThruTpCd);
//			    log.debug("subRailSeq>>>>>>>>>>>>>>>>>>>>>>>>"+subRailSeq);
				param.put("trsp_agmt_ofc_cty_cd", dbRowset.getString("trsp_agmt_ofc_cty_cd"));
				velParam.put("trsp_agmt_ofc_cty_cd", dbRowset.getString("trsp_agmt_ofc_cty_cd"));
				
				param.put("trsp_agmt_seq", dbRowset.getInt("trsp_agmt_seq"));
				velParam.put("trsp_agmt_seq", dbRowset.getInt("trsp_agmt_seq"));
				
				param.put("trsp_so_seq", dbRowset.getInt("trsp_so_seq"));
				velParam.put("trsp_so_seq", dbRowset.getInt("trsp_so_seq"));
				
				param.put("trsp_so_ofc_cty_cd", dbRowset.getString("trsp_so_ofc_cty_cd"));
				velParam.put("trsp_so_ofc_cty_cd", dbRowset.getString("trsp_so_ofc_cty_cd"));
				
				param.put("sub_rail_seq", dbRowset.getInt("sub_rail_seq"));
				velParam.put("sub_rail_seq", dbRowset.getInt("sub_rail_seq"));
				
				param.put("cre_ofc_cd", dbRowset.getString("cre_ofc_cd"));
				velParam.put("cre_ofc_cd", dbRowset.getString("cre_ofc_cd"));
				
				param.put("cre_usr_id", dbRowset.getString("cre_usr_id"));
				velParam.put("cre_usr_id", dbRowset.getString("cre_usr_id"));
				
				param.put("upd_usr_id", dbRowset.getString("upd_usr_id"));
				velParam.put("upd_usr_id", dbRowset.getString("upd_usr_id"));
				
				param.put("vndr_seq", dbRowset.getString("vndr_seq"));
				velParam.put("vndr_seq", dbRowset.getString("vndr_seq"));
								
				param.put("locl_cre_dt", dbRowset.getDate("locl_cre_dt"));
				velParam.put("locl_cre_dt", dbRowset.getDate("locl_cre_dt"));
				
				param.put("eq_knd_cd", dbRowset.getString("eq_knd_cd"));
				velParam.put("eq_knd_cd", dbRowset.getString("eq_knd_cd"));
				
				param.put("eq_tpsz_cd", dbRowset.getString("eq_tpsz_cd"));
				velParam.put("eq_tpsz_cd", dbRowset.getString("eq_tpsz_cd"));
				
				param.put("cgo_tp_cd", dbRowset.getString("cgo_tp_cd"));
				velParam.put("cgo_tp_cd", dbRowset.getString("cgo_tp_cd"));
				
				param.put("trsp_bnd_cd", dbRowset.getString("trsp_bnd_cd"));
				velParam.put("trsp_bnd_cd", dbRowset.getString("trsp_bnd_cd"));
				
				param.put("trsp_cost_dtl_mod_cd", dbRowset.getString("trsp_cost_dtl_mod_cd"));
				velParam.put("trsp_cost_dtl_mod_cd", dbRowset.getString("trsp_cost_dtl_mod_cd"));
				
				param.put("cust_cnt_cd", dbRowset.getString("cust_cnt_cd"));
				velParam.put("cust_cnt_cd", dbRowset.getString("cust_cnt_cd"));
				
				param.put("cust_seq", dbRowset.getInt("cust_seq"));
				velParam.put("cust_seq", dbRowset.getInt("cust_seq"));
				
				param.put("rail_crr_tp_cd", dbRowset.getString("rail_crr_tp_cd"));
				velParam.put("rail_crr_tp_cd", dbRowset.getString("rail_crr_tp_cd"));
				
				param.put("cmdt_cd", dbRowset.getString("cmdt_cd"));
				velParam.put("cmdt_cd", dbRowset.getString("cmdt_cd"));
				
				param.put("fm_nod_cd", dbRowset.getString("fm_nod_cd"));
				velParam.put("fm_nod_cd", dbRowset.getString("fm_nod_cd"));
				
				param.put("bundel_cnt", dbRowset.getInt("bundle_cnt"));
				velParam.put("bundel_cnt", dbRowset.getInt("bundle_cnt"));
				
				param.put("wgt_meas_ut_cd", dbRowset.getString("wgt_meas_ut_cd"));
				velParam.put("wgt_meas_ut_cd", dbRowset.getString("wgt_meas_ut_cd"));
				
				param.put("cntr_wgt", dbRowset.getFloat("cntr_wgt"));
				velParam.put("cntr_wgt", dbRowset.getFloat("cntr_wgt"));
				
				param.put("spcl_cgo_cntr_tp_cd", dbRowset.getString("spcl_cgo_cntr_tp_cd"));
				velParam.put("spcl_cgo_cntr_tp_cd", dbRowset.getString("spcl_cgo_cntr_tp_cd"));
				
				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new RailSoManageDBDAOMultiProcRSQL(), param, velParam);
				
				param.put("po_local_curr_cd", (String) outProc.get("po_local_curr_cd"));
				velParam.put("po_local_curr_cd", (String) outProc.get("po_local_curr_cd"));
				
				param.put("po_basic_rt", (String) outProc.get("po_basic_rt"));
				velParam.put("po_basic_rt", (String) outProc.get("po_basic_rt"));
				
				param.put("po_fuel_scg_rt", (String) outProc.get("po_fuel_scg_rt"));
				velParam.put("po_fuel_scg_rt", (String) outProc.get("po_fuel_scg_rt"));
				
				param.put("po_over_wgt_scg_rt", (String) outProc.get("po_over_wgt_scg_rt"));
				velParam.put("po_over_wgt_scg_rt", (String) outProc.get("po_over_wgt_scg_rt"));
				
				param.put("po_way_type", (String) outProc.get("po_way_type"));
				velParam.put("po_way_type", (String) outProc.get("po_way_type"));
				
				param.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				velParam.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				
				param.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				velParam.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				
				param.put("po_hzs_scg_rt", (String) outProc.get("po_hzs_scg_rt"));
				velParam.put("po_hzs_scg_rt", (String) outProc.get("po_hzs_scg_rt"));
				
				log.debug("outProc.get(po_hzs_scg_rt):::"+outProc.get("po_hzs_scg_rt"));
				
				param.put("po_ttl_scg_rt", (String) outProc.get("po_ttl_scg_rt"));
				velParam.put("po_ttl_scg_rt", (String) outProc.get("po_ttl_scg_rt"));	
				
				if((String) outProc.get("po_trsp_agmt_rt_tp_cd") != null && !"".equals((String) outProc.get("po_trsp_agmt_rt_tp_cd"))){
					// RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}
					
					// RailSoManageDBDAOMultiProcTrsTrspRailConvAmtEurCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailConvAmtEurCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}
				}
				
				// RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update No" + " SQL");
				}				
			}			
			if( !isUpdate ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * RailSoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @param h
	 * @param customData
	 * @param soffice_cd
	 * @throws DAOException
	 */
	public void multiProcRailSoManageForWRS(EsdTrs0201Event event, int h, Map<String, Object> customData, String soffice_cd) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map outProc = null;
		
		boolean isUpdate = false; 
		
		int insCnt = 0;
		
		TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
		
		String railCmbThruTpCd = null;
		int subRailSeq = 0;
		
		try{		
			param.put("soffice_cd", soffice_cd);
			velParam.put("soffice_cd", soffice_cd);
			
			param.put("in_trsp_so_ofc_cty_cd", model[h].getTrspSoOfcCtyCd());
			velParam.put("in_trsp_so_ofc_cty_cd", model[h].getTrspSoOfcCtyCd());
			
			customData.get("arrTrspSoSeq");
			
			ArrayList soSeqArr = (ArrayList)customData.get("arrTrspSoSeq");
			String soSeq [] = (String []) soSeqArr.toArray (new String [soSeqArr.size ()]);
			
			param.put("in_trsp_so_seq", soSeq[0]);
			velParam.put("in_trsp_so_seq", soSeq[0]);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailBilOrdNoTranactionRSQL(), param, velParam);
										
			while(dbRowset.next()) {
				isUpdate = true;
				
				if( dbRowset.getString("trsp_agmt_ofc_cty_cd") == null || "".equals(dbRowset.getString("trsp_agmt_ofc_cty_cd")) || dbRowset.getInt("trsp_agmt_seq") == 0 ) {
					throw new DAOException(new ErrorHandler("TRS00103").getMessage());
				}
				
				railCmbThruTpCd = dbRowset.getString("rail_cmb_thru_tp_cd");
			    subRailSeq = dbRowset.getInt("sub_rail_seq");
			    
			    if (railCmbThruTpCd.equals("C2T") || railCmbThruTpCd.equals("C3T")) {
			    	if (subRailSeq == 1) {
						param.put("to_nod_cd", dbRowset.getString("al_to_nod_cd"));
						velParam.put("to_nod_cd", dbRowset.getString("al_to_nod_cd"));	
			    	}else {
			    		break;
			    	}
			    } else {
					param.put("to_nod_cd", dbRowset.getString("to_nod_cd"));
					velParam.put("to_nod_cd", dbRowset.getString("to_nod_cd"));
			    }
			    
				param.put("trsp_agmt_ofc_cty_cd", dbRowset.getString("trsp_agmt_ofc_cty_cd"));
				velParam.put("trsp_agmt_ofc_cty_cd", dbRowset.getString("trsp_agmt_ofc_cty_cd"));
				
				param.put("trsp_agmt_seq", dbRowset.getInt("trsp_agmt_seq"));
				velParam.put("trsp_agmt_seq", dbRowset.getInt("trsp_agmt_seq"));
				
				param.put("trsp_so_seq", dbRowset.getInt("trsp_so_seq"));
				velParam.put("trsp_so_seq", dbRowset.getInt("trsp_so_seq"));
				
				param.put("trsp_so_ofc_cty_cd", dbRowset.getString("trsp_so_ofc_cty_cd"));
				velParam.put("trsp_so_ofc_cty_cd", dbRowset.getString("trsp_so_ofc_cty_cd"));
				
				param.put("sub_rail_seq", dbRowset.getInt("sub_rail_seq"));
				velParam.put("sub_rail_seq", dbRowset.getInt("sub_rail_seq"));
				
				param.put("cre_ofc_cd", dbRowset.getString("cre_ofc_cd"));
				velParam.put("cre_ofc_cd", dbRowset.getString("cre_ofc_cd"));
				
				param.put("cre_usr_id", dbRowset.getString("cre_usr_id"));
				velParam.put("cre_usr_id", dbRowset.getString("cre_usr_id"));
				
				param.put("upd_usr_id", dbRowset.getString("upd_usr_id"));
				velParam.put("upd_usr_id", dbRowset.getString("upd_usr_id"));
				
				param.put("vndr_seq", dbRowset.getString("vndr_seq"));
				velParam.put("vndr_seq", dbRowset.getString("vndr_seq"));
								
				param.put("locl_cre_dt", dbRowset.getDate("locl_cre_dt"));
				velParam.put("locl_cre_dt", dbRowset.getDate("locl_cre_dt"));
				
				param.put("eq_knd_cd", dbRowset.getString("eq_knd_cd"));
				velParam.put("eq_knd_cd", dbRowset.getString("eq_knd_cd"));
				
				param.put("eq_tpsz_cd", dbRowset.getString("eq_tpsz_cd"));
				velParam.put("eq_tpsz_cd", dbRowset.getString("eq_tpsz_cd"));
				
				param.put("cgo_tp_cd", dbRowset.getString("cgo_tp_cd"));
				velParam.put("cgo_tp_cd", dbRowset.getString("cgo_tp_cd"));
				
				param.put("trsp_bnd_cd", dbRowset.getString("trsp_bnd_cd"));
				velParam.put("trsp_bnd_cd", dbRowset.getString("trsp_bnd_cd"));
				
				param.put("trsp_cost_dtl_mod_cd", dbRowset.getString("trsp_cost_dtl_mod_cd"));
				velParam.put("trsp_cost_dtl_mod_cd", dbRowset.getString("trsp_cost_dtl_mod_cd"));
				
				param.put("cust_cnt_cd", dbRowset.getString("cust_cnt_cd"));
				velParam.put("cust_cnt_cd", dbRowset.getString("cust_cnt_cd"));
				
				param.put("cust_seq", dbRowset.getInt("cust_seq"));
				velParam.put("cust_seq", dbRowset.getInt("cust_seq"));
				
				param.put("rail_crr_tp_cd", dbRowset.getString("rail_crr_tp_cd"));
				velParam.put("rail_crr_tp_cd", dbRowset.getString("rail_crr_tp_cd"));
				
				param.put("cmdt_cd", dbRowset.getString("cmdt_cd"));
				velParam.put("cmdt_cd", dbRowset.getString("cmdt_cd"));
				
				param.put("fm_nod_cd", dbRowset.getString("fm_nod_cd"));
				velParam.put("fm_nod_cd", dbRowset.getString("fm_nod_cd"));
				
				param.put("bundel_cnt", dbRowset.getInt("bundle_cnt"));
				velParam.put("bundel_cnt", dbRowset.getInt("bundle_cnt"));
				
				param.put("wgt_meas_ut_cd", dbRowset.getString("wgt_meas_ut_cd"));
				velParam.put("wgt_meas_ut_cd", dbRowset.getString("wgt_meas_ut_cd"));
				
				param.put("cntr_wgt", dbRowset.getFloat("cntr_wgt"));
				velParam.put("cntr_wgt", dbRowset.getFloat("cntr_wgt"));
				
				param.put("spcl_cgo_cntr_tp_cd", dbRowset.getString("spcl_cgo_cntr_tp_cd"));
				velParam.put("spcl_cgo_cntr_tp_cd", dbRowset.getString("spcl_cgo_cntr_tp_cd"));
				
				outProc = new SQLExecuter("DEFAULT").executeSP((ISQLTemplate)new RailSoManageDBDAOMultiProcRSQL(), param, velParam);
				
				param.put("po_local_curr_cd", (String) outProc.get("po_local_curr_cd"));
				velParam.put("po_local_curr_cd", (String) outProc.get("po_local_curr_cd"));
				
				param.put("po_basic_rt", (String) outProc.get("po_basic_rt"));
				velParam.put("po_basic_rt", (String) outProc.get("po_basic_rt"));
				
				param.put("po_fuel_scg_rt", (String) outProc.get("po_fuel_scg_rt"));
				velParam.put("po_fuel_scg_rt", (String) outProc.get("po_fuel_scg_rt"));
				
				param.put("po_over_wgt_scg_rt", (String) outProc.get("po_over_wgt_scg_rt"));
				velParam.put("po_over_wgt_scg_rt", (String) outProc.get("po_over_wgt_scg_rt"));
				
				param.put("po_way_type", (String) outProc.get("po_way_type"));
				velParam.put("po_way_type", (String) outProc.get("po_way_type"));
				
				param.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				velParam.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				
				param.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				velParam.put("po_trsp_agmt_rt_tp_cd", (String) outProc.get("po_trsp_agmt_rt_tp_cd"));
				
				//20100803 add
				param.put("po_hzs_scg_rt", (String) outProc.get("po_hzs_scg_rt"));
				velParam.put("po_hzs_scg_rt", (String) outProc.get("po_hzs_scg_rt"));	
				
				param.put("po_ttl_scg_rt", (String) outProc.get("po_ttl_scg_rt"));
				velParam.put("po_ttl_scg_rt", (String) outProc.get("po_ttl_scg_rt"));	
				
				if((String) outProc.get("po_trsp_agmt_rt_tp_cd") != null && !"".equals((String) outProc.get("po_trsp_agmt_rt_tp_cd"))){
					// RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}
					
					// RailSoManageDBDAOMultiProcTrsTrspRailConvAmtEurCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailConvAmtEurCSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}
				}
				
				// RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update No" + " SQL");
				}				
			}			
			if( !isUpdate ) {
				throw new DAOException(new ErrorHandler("TRS00015").getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
	
	/**
	 * RailSoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * S/O CREATION 모듈
	 * 
	 * @param event
	 * @param h
	 * @return
	 * @throws DAOException
	 */
	public ArrayList multiTrsTrspRailBillingVos(EsdTrs0201Event event, int h) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<TrsTrspRailBilOrdVO> updateVoList = new ArrayList<TrsTrspRailBilOrdVO>();
		List<String> verifyCopNo = new ArrayList();
		List<String> verifyCostActGrpSeq = new ArrayList();
		List<String> verifyRoutOrgNodCd = new ArrayList();
		List<String> verifyRoutDestNodCd = new ArrayList();
		List<String> verifyRoutSeq = new ArrayList();
		
		ArrayList arrSize = new ArrayList();
		
		TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
		TrsTrspRailBilOrdVO[] modelResult = new TrsTrspRailBilOrdVO[model.length];
	  	
		ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		
		int insCnt[] = null;		
		int trs_seq = 0;
		int z = 0;

		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			verifyCopNo.add("'" + model[h].getCopNo() + "'");
			verifyCostActGrpSeq.add("'" + model[h].getCostActGrpSeq() + "'");
			verifyRoutOrgNodCd.add("'" + model[h].getRoutOrgNodCd() + "'");
			verifyRoutDestNodCd.add("'" + model[h].getRoutDestNodCd() + "'");	
			verifyRoutSeq.add("'" + model[h].getRoutSeq() + "'");
			arrSize.add(0);
			
			param.put("verifyCopNo", verifyCopNo);
			velParam.put("verifyCopNo", verifyCopNo);
			
			param.put("verifyCostActGrpSeq", verifyCostActGrpSeq);
			velParam.put("verifyCostActGrpSeq", verifyCostActGrpSeq);
			
			param.put("verifyRoutOrgNodCd", verifyRoutOrgNodCd);
			velParam.put("verifyRoutOrgNodCd", verifyRoutOrgNodCd);
			
			param.put("verifyRoutDestNodCd", verifyRoutDestNodCd);
			velParam.put("verifyRoutDestNodCd", verifyRoutDestNodCd);
			
			param.put("verifyRoutSeq", verifyRoutSeq);
			velParam.put("verifyRoutSeq", verifyRoutSeq);
			
			param.put("arrNo", arrSize);
			velParam.put("arrNo", arrSize); 
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOMultiTrsTrspRailBilOrdChkRSQL(), param, velParam);
			
			if( dbRowset.next() ) {
				dbRowset.getString(1);
				throw new DAOException(new ErrorHandler("TRS00100").getMessage());
			}
			
			if (model[h].getIbflag().length() > 0) {
				if (model[h].getIbflag().equals("I") || model[h].getIbflag().equals("U")) {
					String strOfc = "";							
					
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOMultiTrsTrspRailBilOrdSeqRSQL(), param, velParam);
					if(dbRowset.next()) {
						trs_seq = dbRowset.getInt(1);
					}
					arrSeq.add(z++, String.valueOf(trs_seq)); //TRSP_SO_SEQ : 객체를 넘긴다.
					
					if( String.valueOf(event.getSctrlOfcCd()).length() > 2 ) {
						strOfc = String.valueOf(event.getSctrlOfcCd()).substring(0,3);
					}
					
					// SCE에 S/O No 넘겨주기위해 세팅
					model[h].setTrspSoOfcCtyCd(strOfc);
					model[h].setTrspSoSeq(Integer.toString(trs_seq));	
					
					modelResult[0] = new TrsTrspRailBilOrdVO();
					modelResult[0].setStrOfc(strOfc);
					modelResult[0].setTrspSoSeq(Integer.toString(trs_seq));
					modelResult[0].setRailCmbThruTpCd(model[h].getRailCmbThruTpCd());
					modelResult[0].setIbdIpiLoclIndCd(model[h].getIbdIpiLoclIndCd());
					modelResult[0].setFmNodCd(model[h].getFmNodCd() + model[h].getFmNodYard());
					modelResult[0].setToNodCd(model[h].getToNodCd() + model[h].getToNodYard());
					String sTrunkVVD = String.valueOf(model[h].getTrunkvvd());
					if( sTrunkVVD.length() > 8 ){
						modelResult[0].setVslCd(sTrunkVVD.substring(0, 4));
						modelResult[0].setSkdVoyNo(sTrunkVVD.substring(4, 8));
						modelResult[0].setSkdDirCd(sTrunkVVD.substring(8));							
					}else{
						modelResult[0].setVslCd(model[h].getVslCd());
						modelResult[0].setSkdVoyNo(model[h].getSkdVoyNo());
						modelResult[0].setSkdDirCd(model[h].getSkdDirCd());						
					}	
					modelResult[0].setSlanCd(model[h].getSlanCd());
					modelResult[0].setEqNo(model[h].getEqNo());
					modelResult[0].setEqTpszCd(model[h].getEqTpszCd());
					String strActGrpCd = model[h].getActGrpCd();
					if( strActGrpCd.length() > 1 ) {
						strActGrpCd = strActGrpCd.substring(0, 1);
					}
					modelResult[0].setActGrpCd(strActGrpCd);
					modelResult[0].setBkgNo(model[h].getBkgNo());
					modelResult[0].setBlNo(model[h].getBlNo());
					modelResult[0].setCntrWgt(model[h].getCntrWgt());
					modelResult[0].setPckTpCd(model[h].getPckTpCd());
					modelResult[0].setPckQty(model[h].getPckQty());
					modelResult[0].setCmdtCd(model[h].getCmdtCd());
					modelResult[0].setStndCmdtNo(model[h].getStndCmdtNo());
					modelResult[0].setAutoXptSysCd(model[h].getAutoXptSysCd());
					modelResult[0].setAutoXptSysNo(model[h].getAutoXptSysNo());
					modelResult[0].setCopNo(model[h].getCopNo());
					modelResult[0].setCostActGrpSeq(model[h].getCostActGrpSeq());
					modelResult[0].setSpclCgoCntrTpCd(model[h].getSpclCgoCntrTpCd());
					modelResult[0].setIbdCstmsClrLocCd(model[h].getIbdCstmsClrLocCd());
					modelResult[0].setPodCd(model[h].getPodCd());
					modelResult[0].setPodCdYard(model[h].getPodCd() + model[h].getPodCdYard());
					modelResult[0].setPorCd(model[h].getPorCd());
					modelResult[0].setPolCd(model[h].getPolCd());
					modelResult[0].setPolCdYard(model[h].getPolCd() + model[h].getPolCdYard());
					modelResult[0].setDelCd(model[h].getDelCd());
					modelResult[0].setPorNodCdYard(model[h].getPorNodCd() + model[h].getPorNodCdYard());
					modelResult[0].setDelNodCdYard(model[h].getDelNodCd() + model[h].getDelNodCdYard());
					modelResult[0].setDelSccCd(model[h].getDelSccCd());
					modelResult[0].setBkgRcvdeTermCd(model[h].getBkgRcvdeTermCd());
					modelResult[0].setNvoccFileNo(model[h].getNvoccFileNo());
					modelResult[0].setCntrSealNo(model[h].getCntrSealNo());
					modelResult[0].setCostActGrpCd(model[h].getActGrpCd());
					modelResult[0].setN1stNodPlnDt(model[h].getN1stNodPlnDt() + model[h].getN1stNodPlnDtHms());
					modelResult[0].setLstNodPlnDt(model[h].getLstNodPlnDt() + model[h].getLstNodPlnDtHms());
					modelResult[0].setBkgCgoTpCd(model[h].getBkgCgoTpCd());
					modelResult[0].setRoutOrgNodCd(model[h].getRoutOrgNodCd());
					modelResult[0].setRoutDestNodCd(model[h].getRoutDestNodCd());
					modelResult[0].setRoutSeq(model[h].getRoutSeq());
					modelResult[0].setRoutPlnCd(model[h].getRoutPlnCd());
					modelResult[0].setInlndRoutRmk(model[h].getInlndRoutRmk());
					modelResult[0].setTrspSoOfcCtyCd(event.getSctrlOfcCd());
					modelResult[0].setCreUsrId(model[h].getCreUsrId());
					modelResult[0].setUpdUsrId(model[h].getCreUsrId());
					modelResult[0].setInterRmk(model[h].getInterRmk());
					modelResult[0].setSpclInstrRmk(model[h].getSpclInstrRmk());
					modelResult[0].setCustCntCd(model[h].getCustCntCd());
					modelResult[0].setCustSeq(model[h].getCustSeq());
					modelResult[0].setScNo(model[h].getScNo());
					modelResult[0].setShprCustNm(model[h].getShprCustNm());
					modelResult[0].setCneeCustNm(model[h].getCneeCustNm());
					modelResult[0].setIbdNo(model[h].getIbdNo());
					modelResult[0].setInvBilPattDivFlg(model[h].getInvBilPattDivFlg());
					modelResult[0].setVdDt(model[h].getVdDt());
					modelResult[0].setTmlNodCd(model[h].getTmlNodCd());
					modelResult[0].setHighValCgoTpCd(model[h].getHighValCgoTpCd());		
					modelResult[0].setCtrlOfcCd(event.getSctrlOfcCd());
					updateVoList.add(0, modelResult[0]);
					
					// RailSoManageDBDAOMultiTrsTrspRailBilOrdCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOMultiTrsTrspRailBilOrdCSQL(), updateVoList, param, null);				
					if(insCnt[0]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
					
					// RailSoManageDBDAOMultiTrsTrspRailBilVndrSetCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOMultiTrsTrspRailBilVndrSetCSQL(), updateVoList, param, null);
					if(insCnt[0]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
					
					// RailSoManageDBDAOMultiTrsTrspRailTmpCSQL 함수 호출
					insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOMultiTrsTrspRailTmpCSQL(), updateVoList, param, null);
					if(insCnt[0]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arrSeq;
	}

	/**
	 * RailSoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param soffice_cd
	 * @param suer_ctl_id
	 * @param event
	 * @throws DAOException
	 */
	public void multi01TrsTrspRailBillingVos(String soffice_cd, String suer_ctl_id, EsdTrs0201Event event) throws DAOException {
		Collection<TrsTrspRailBilOrdVO> updModels = new ArrayList<TrsTrspRailBilOrdVO>();
		
		try{
			TrsTrspRailBilOrdVO[] multiVos  = event.getTrsTrspRailBilOrdVos();
			if( multiVos != null ){
				for( int i=0; i<multiVos.length; i++ ){
					updModels.add(multiVos[i]);
				}
			}
			Map<String,Object> param_wrk = new HashMap<String,Object>();
			param_wrk.put("soffice_cd" , soffice_cd  );
			param_wrk.put("suer_ctl_id", suer_ctl_id );
			
			int[] updCnt  = null;
			if( updModels.size() > 0 ){
				updCnt = new SQLExecuter("DEFAULT").executeBatch(new RailSoManageDBDAOMulti01RailsomanageUSQL(), updModels, param_wrk, param_wrk);
			}
			if(updCnt != null){
				for(int i=0;i<updCnt.length;i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to UPDATE No"+ i + " SQL");
					}
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * RailSoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList multi02TrsTrspRailBillingVos(EsdTrs0201Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<TrsTrspRailBilOrdVO> updateVoList = new ArrayList<TrsTrspRailBilOrdVO>();
		
		List<String> verifyRepoPlnId = new ArrayList();
		List<String> verifyPlnYrwk = new ArrayList();
		List<String> verifyRefId = new ArrayList();
		List<String> verifyRefSeq = new ArrayList();
		
		ArrayList arrSize = new ArrayList();
		
		TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
		TrsTrspRailBilOrdVO[] modelResult = new TrsTrspRailBilOrdVO[model.length];
	  	
		ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		
		int insCnt[] = null;		
		int trs_seq = 0;
		int j = 0;
		int z = 0;

		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			for(int i = 0; i < model.length; i++){				
				verifyRepoPlnId.add("'" + model[i].getRepoPlnId() + "'");
				verifyPlnYrwk.add("'" + model[i].getPlnYrwk() + "'");
				verifyRefId.add("'" + model[i].getRefId() + "'");
				verifyRefSeq.add("'" + model[i].getRefSeq() + "'");	
				arrSize.add(i);
			}
			param.put("verifyRepoPlnId", verifyRepoPlnId);
			velParam.put("verifyRepoPlnId", verifyRepoPlnId);
			
			param.put("verifyPlnYrwk", verifyPlnYrwk);
			velParam.put("verifyPlnYrwk", verifyPlnYrwk);
			
			param.put("verifyRefId", verifyRefId);
			velParam.put("verifyRefId", verifyRefId);
			
			param.put("verifyRefSeq", verifyRefSeq);
			velParam.put("verifyRefSeq", verifyRefSeq);
			
			param.put("arrNo", arrSize);
			velParam.put("arrNo", arrSize); 
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOUsaRailBillVerifyRSQL(), param, velParam);
			
			if( dbRowset.next() ) {
				throw new DAOException(new ErrorHandler("TRS00100").getMessage());
			}
			
			for(int i = 0; i < model.length; i++){
				if (model[i].getIbflag().length() > 0) {
					if (model[i].getIbflag().equals("I") || model[i].getIbflag().equals("U")) {
						String strOfc = "";							
						
						dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOMultiTrsTrspRailBilOrdSeqRSQL(), param, velParam);
						if(dbRowset.next()) {
							trs_seq = dbRowset.getInt(1);
						}
						arrSeq.add(z++, String.valueOf(trs_seq)); //TRSP_SO_SEQ : 객체를 넘긴다.
						
						if( String.valueOf(event.getSctrlOfcCd()).length() > 2 ) {
							strOfc = String.valueOf(event.getSctrlOfcCd()).substring(0,3);
						}
						
						modelResult[j] = new TrsTrspRailBilOrdVO();
						modelResult[j].setStrOfc(strOfc);
						modelResult[j].setTrspSoSeq(Integer.toString(trs_seq));
						modelResult[j].setRailCmbThruTpCd(model[i].getRailCmbThruTpCd());
						modelResult[j].setFmNodCd(model[i].getFmNodCd() + model[i].getFmNodYard());
						modelResult[j].setToNodCd(model[i].getToNodCd() + model[i].getToNodYard());
						modelResult[j].setVslCd(model[i].getVslCd());
						modelResult[j].setSkdVoyNo(model[i].getSkdVoyNo());
						modelResult[j].setSkdDirCd(model[i].getSkdDirCd());
						modelResult[j].setSlanCd(model[i].getSlanCd());
						modelResult[j].setEqNo(model[i].getEqNo());
						modelResult[j].setEqTpszCd(model[i].getEqTpszCd());
						modelResult[j].setRoutOrgNodCd(model[i].getRoutOrgNodCd());
						modelResult[j].setRoutDestNodCd(model[i].getRoutDestNodCd());
						modelResult[j].setRoutSeq(model[i].getRoutSeq());
						modelResult[j].setRoutPlnCd(model[i].getRoutPlnCd());
						modelResult[j].setInlndRoutRmk(model[i].getInlndRoutRmk());
						modelResult[j].setTrspSoOfcCtyCd(model[i].getTrspSoOfcCtyCd());
						modelResult[j].setCreUsrId(model[i].getCreUsrId());
						modelResult[j].setInterRmk(model[i].getInterRmk());
						modelResult[j].setSpclInstrRmk(model[i].getSpclInstrRmk());
						modelResult[j].setTrspModTpCd(model[i].getTrspModTpCd());
						modelResult[j].setRepoPlnId(model[i].getRepoPlnId());
						modelResult[j].setPlnYrwk(model[i].getPlnYrwk());
						modelResult[j].setRefSeq(model[i].getRefSeq());
						modelResult[j].setRefId(model[i].getRefId());
						modelResult[j].setTrspMtyRqstDt(model[i].getTrspMtyRqstDt());
						modelResult[j].setCtrlOfcCd(event.getSctrlOfcCd());
						updateVoList.add(modelResult[j]);
						j++;											
					}
				}
			}
			
			if(updateVoList.size() > 0){				
				// RailSoManageDBDAOMultiUsaRailBillVoCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOMultiUsaRailBillVoCSQL(), updateVoList, param, null);
				for(int h = 0; h < insCnt.length; h++){
					if(insCnt[h]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ h + " SQL");
				}
				
				// RailSoManageDBDAOMultiUsaRailBillVoSeqCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOMultiUsaRailBillVoSeqCSQL(), updateVoList, param, null);
				for(int h = 0; h < insCnt.length; h++){
					if(insCnt[h]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ h + " SQL");
				}
				
				// RailSoManageDBDAOUpdateEqrRepoIfUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOUpdateEqrRepoIfUSQL(), updateVoList, param, null);
				for(int h = 0; h < insCnt.length; h++){
					if(insCnt[h]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ h + " SQL");
				}
				
				// RailSoManageDBDAOUpdateEqrRepoIfUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoList, param, null);
				for(int h = 0; h < insCnt.length; h++){
					if(insCnt[h]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ h + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arrSeq;
	}
	
	/**
	 * RailSoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @param h
	 * @return
	 * @throws DAOException
	 */
	public ArrayList multi02TrsTrspRailBillingVosForNoTranjection(EsdTrs0201Event event, int h) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<TrsTrspRailBilOrdVO> updateVoList = new ArrayList<TrsTrspRailBilOrdVO>();
		List<String> verifyRepoPlnId = new ArrayList();
		List<String> verifyPlnYrwk = new ArrayList();
		List<String> verifyRefId = new ArrayList();
		List<String> verifyRefSeq = new ArrayList();
		
		ArrayList arrSize = new ArrayList();
		
		TrsTrspRailBilOrdVO[] model = event.getTrsTrspRailBilOrdVos();
		TrsTrspRailBilOrdVO[] modelResult = new TrsTrspRailBilOrdVO[model.length];
	  	
		ArrayList arrSeq = new ArrayList(); //TRSP SO SEQ를 넘기기 위한 객체
		
		int insCnt[] = null;		
		int trs_seq = 0;
		int z = 0;

		try {
			Map<String, String> mapVO = event.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			verifyRepoPlnId.add("'" + model[h].getRepoPlnId() + "'");
			verifyPlnYrwk.add("'" + model[h].getPlnYrwk() + "'");
			verifyRefId.add("'" + model[h].getRefId() + "'");
			verifyRefSeq.add("'" + model[h].getRefSeq() + "'");
			arrSize.add(0);
			
			param.put("verifyRepoPlnId", verifyRepoPlnId);
			velParam.put("verifyRepoPlnId", verifyRepoPlnId);
			
			param.put("verifyPlnYrwk", verifyPlnYrwk);
			velParam.put("verifyPlnYrwk", verifyPlnYrwk);
			
			param.put("verifyRefId", verifyRefId);
			velParam.put("verifyRefId", verifyRefId);
			
			param.put("verifyRefSeq", verifyRefSeq);
			velParam.put("verifyRefSeq", verifyRefSeq);
			
			param.put("arrNo", arrSize);
			velParam.put("arrNo", arrSize); 
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOUsaRailBillVerifyRSQL(), param, velParam);
			
			if( dbRowset.next() ) {
				throw new DAOException(new ErrorHandler("TRS00100").getMessage());
			}
			
			if (model[h].getIbflag().length() > 0) {
				if (model[h].getIbflag().equals("I") || model[h].getIbflag().equals("U")) {
					String strOfc = "";							
					
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOMultiTrsTrspRailBilOrdSeqRSQL(), param, velParam);
					if(dbRowset.next()) {
						trs_seq = dbRowset.getInt(1);
					}
					arrSeq.add(z++, String.valueOf(trs_seq)); //TRSP_SO_SEQ : 객체를 넘긴다.
					
					if( String.valueOf(event.getSctrlOfcCd()).length() > 2 ) {
						strOfc = String.valueOf(event.getSctrlOfcCd()).substring(0,3);
					}
					
					modelResult[0] = new TrsTrspRailBilOrdVO();
					modelResult[0].setStrOfc(strOfc);
					modelResult[0].setTrspSoSeq(Integer.toString(trs_seq));
					modelResult[0].setRailCmbThruTpCd(model[h].getRailCmbThruTpCd());
					modelResult[0].setFmNodCd(model[h].getFmNodCd() + model[h].getFmNodYard());
					modelResult[0].setToNodCd(model[h].getToNodCd() + model[h].getToNodYard());
					modelResult[0].setVslCd(model[h].getVslCd());
					modelResult[0].setSkdVoyNo(model[h].getSkdVoyNo());
					modelResult[0].setSkdDirCd(model[h].getSkdDirCd());
					modelResult[0].setSlanCd(model[h].getSlanCd());
					modelResult[0].setEqNo(model[h].getEqNo());
					modelResult[0].setEqTpszCd(model[h].getEqTpszCd());
					modelResult[0].setRoutOrgNodCd(model[h].getRoutOrgNodCd());
					modelResult[0].setRoutDestNodCd(model[h].getRoutDestNodCd());
					modelResult[0].setRoutSeq(model[h].getRoutSeq());
					modelResult[0].setRoutPlnCd(model[h].getRoutPlnCd());
					modelResult[0].setInlndRoutRmk(model[h].getInlndRoutRmk());
					modelResult[0].setTrspSoOfcCtyCd(model[h].getTrspSoOfcCtyCd());
					modelResult[0].setCreUsrId(model[h].getCreUsrId());
					modelResult[0].setInterRmk(model[h].getInterRmk());
					modelResult[0].setSpclInstrRmk(model[h].getSpclInstrRmk());
					modelResult[0].setTrspModTpCd(model[h].getTrspModTpCd());
					modelResult[0].setRepoPlnId(model[h].getRepoPlnId());
					modelResult[0].setPlnYrwk(model[h].getPlnYrwk());
					modelResult[0].setRefSeq(model[h].getRefSeq());
					modelResult[0].setRefId(model[h].getRefId());
					modelResult[0].setTrspMtyRqstDt(model[h].getTrspMtyRqstDt());
					modelResult[0].setCtrlOfcCd(event.getSctrlOfcCd());
					
					updateVoList.add(0, modelResult[0]);
					
					insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOMultiUsaRailBillVoCSQL(), updateVoList, param, null);
					if(insCnt[0] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}
					
					insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOMultiUsaRailBillVoSeqCSQL(), updateVoList, param, null);
					if(insCnt[0] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}
					
					insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOUpdateEqrRepoIfUSQL(), updateVoList, param, null);
					if(insCnt[0] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}
					
					insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new RailSoManageDBDAOUsaRailBillVoTrsTrspEdiRailTmpCSQL(), updateVoList, param, null);
					if(insCnt[0] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + " SQL");
					}						
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return arrSeq;
	}
	
	/**
	 * S/O correction 시 S/O가 delete 됬는지 여부 체크
	 * @param sofficeCd
	 * @param event
	 * @return so_no
	 * @throws DAOException
	 */
	public String verifyRailSoManageDeltChk(String sofficeCd, EsdTrs0201Event event) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		
		String so_no = "";
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			Map<String, String> mapVO = event.getColumnValues();
			String[] arr1 = mapVO.get("f_trsp_so_ofc_cd").split(",");
			String[] arr2 = mapVO.get("f_trsp_so_seq").split(",");
			
			List<CommonVo> velParamArr 	= new ArrayList<CommonVo>(); 
			for(int i = 0; i < arr1.length; i++) {
				CommonVo paramVO 			= new CommonVo();
				paramVO.setVelParamField1(arr1[i]); 
				paramVO.setVelParamField2(arr2[i]); 
				velParamArr.add(paramVO); 				
			}
	       	
        	velParam.put("soGrpKey", velParamArr); 
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new RailSoManageDBDAOVerifyRailSoManageDeltChkRSQLRSQL(), velParam, velParam);
			
			if(dbRowset.next()) {
				so_no = dbRowset.getString("so_no");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return so_no;
	}
	
	/**
     * 입력한 From Location이 US Rail인지 체크<br>
     * ESD_TRS_0012.do
     * @param hdrVO SingleTransportationSOManageHdrVO
     * @return String
     * @exception DAOException
    */
	public String checkUsRail(SearchRailSoManageHdrVO hdrVO) throws DAOException {
	    String chk_us_rail  = "";
		
	    try {
			DBRowSet dbRowset = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = hdrVO.getColumnValues();
			param.putAll(mapVO);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchEmptyRepoCheckUsRailRSQL(), param, param);
	        
	        if(dbRowset.next()){
	        	chk_us_rail = dbRowset.getString("CHK_US_RAIL");
	        }
	        
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    
	    return chk_us_rail;
	}
	
	/**
	 * EQR_REPO_EXE_SO_IF 데이타 모델을 DB에서 저장한다.<br>
	 *
	 * @param hdrVO   SearchRailSoManageHdrVO
	 * @param account SignOnUserAccount
	 * @return String 
	 * @throws DAOException
	 */
	public String multiRailSoCandidate(SearchRailSoManageHdrVO hdrVO,SignOnUserAccount account) throws DAOException {
		String ref_id = "";
		try{
			
			DBRowSet dbRowset = null;
			
			String repo_pln_id = "";
			String pln_yrwk = "";
			
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();		
			Map<String, String> mapVO = hdrVO.getColumnValues();
			
			
			param.putAll(mapVO);
			
			int loop_cnt = Integer.parseInt(hdrVO.getAllocated());
			
			//PK인 REPO_PLN_ID, PLN_YRWK 생성한다.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchEmptyRepoPlanSeqRSQL(), param, param);
			
	        if(dbRowset.next()){
	        	repo_pln_id = dbRowset.getString("REPO_PLN_ID");
	        	pln_yrwk = dbRowset.getString("PLN_YRWK");
	        }
	        
			param.put("repo_pln_id",repo_pln_id);
			param.put("pln_yrwk",pln_yrwk);
			
			//PK인 REF_ID를 생성한다.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchEmptyRepoRefSeqRSQL(), param, param);
			
	        if(dbRowset.next()){
	        	ref_id = dbRowset.getString("REF_ID");
	        }
	        
	        param.put("ref_id",ref_id);
			param.put("ofc_cd",account.getOfc_cd());
			param.put("usr_id",account.getUsr_id());
	        
			//Allocated수 만큼 데이터를 생성한다.
			for(int i = 0; i<loop_cnt; i++){
				param.put("ref_seq", i+1);
			
				new SQLExecuter("").executeUpdate((ISQLTemplate)new RailSoManageDBDAOMultiRailSoCandidateCSQL(), param, param);
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
		return ref_id;
	}
	
	
	/**
	 * EQR_REPO_EXE_SO_IF 데이타 모델을 DB에서 저장한다.<br>
	 *
	 * @param fm_loc_cd String
	 * @param pln_yrwk String
	 * @param trsp_mod_cd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchGetRefId(String fm_loc_cd,String pln_yrwk,String trsp_mod_cd) throws DAOException {
		String ref_id = "";
		
		try{
			
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();		
			
			param.put("fm_loc_cd",fm_loc_cd);
			param.put("pln_yrwk",pln_yrwk);
			param.put("so_if_div_cd",trsp_mod_cd);
			
			
			//PK인 REF_ID를 생성한다.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchEmptyRepoRefSeqRSQL(), param, param);
			
	        if(dbRowset.next()){
	        	ref_id = dbRowset.getString("REF_ID");
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
		
		 return ref_id;
	}
		
		
    /**
     * WRS-->TRS--> EQR 로 전해진 SO IF 정보 입력 
     * 대상테이블 : EQR_REPO_EXE_SO_IF
     * 
	 * @param eqrRepoExeSoIfVO EqrRepoExeSoIfVO
	 * @param user_id String
	 * @exception DAOException
	 */
    public void insertInlandWrsTrsSOIF(EqrRepoExeSoIfVO eqrRepoExeSoIfVO , String user_id)throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.putAll(eqrRepoExeSoIfVO.getColumnValues());
			
			param.put("past_repo_pln_flg", "N");
			param.put("user_id", user_id);
			param.put("co_cd", "H");
			param.put("wo_rqst_flg", "Y");
			param.put("trsp_so_sts_cd", "P");
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new RailSoManageDBDAOInsertInlandWrsTrsSOIFCSQL(), param, null);
			
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
    }
    
    /**
     * SO IF 정보 조회 
     * 대상테이블 : EQR_REPO_EXE_SO_IF
     * 
	 * @param repo_pln_id
	 * @param pln_yrwk
	 * @param pln_seq
	 * @param ref_id
	 * @return DBRowSet
	 * @exception DAOException
	 */
    public DBRowSet searchInlandWrsTrsSOIF(String repo_pln_id, String pln_yrwk , String pln_seq , String ref_id) throws DAOException {
   	
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("repo_pln_id",repo_pln_id);
			param.put("pln_yrwk",pln_yrwk);
			param.put("pln_seq",pln_seq);
			param.put("ref_id",ref_id);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchInlandWrsTrsSOIFRSQL(), param, null);

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
		return dbRowset;
    }	    
    
    
	/**
     * Guideline SEQ 생성<br>
     * EES_EQR_1008.do
     * @param current_date String
     * @return String
     * @exception DAOException
    */
	public String searchPlnWeek(String current_date) throws DAOException {
	    String pln_wk  = "";
		
	    try {
			DBRowSet dbRowset = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("pln_wk", current_date);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchPlnWeekRSQL(), param, param);
	        
	        if(dbRowset.next()){
	        	pln_wk = dbRowset.getString("PLN_YRWK");
	        }
	        
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    
	    return pln_wk;
	}
    
	/**
	 * search eta date 검색
	 * INLAND(080), ON-OFF HIRE(081) 에서 사용함 
	 * item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우는 다른 조회쿼리를 사용함. 
	 * 
	 * @param etd
	 * @param fryard
	 * @param toyard
	 * @param item
	 * @return String
	 * @exception DAOException
	 */
	public String searchEtaDate(String etd, String fryard, String toyard, String item) throws DAOException {
		DBRowSet dbRowset = null;
//		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		String etaDate = null;  //return value		
		String railMode   = "N";                              // Y : item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우 
		                                                      // N : 나머지
		String fryard_cnt = "";                               // FROM YARD COUNTRY CODE
		String toyard_cnt = "";                               // TO   YARD COUNTRY CODE
		
		// item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우는 다른 조회쿼리를 사용함. 
		if(item.equals("R")) {
			fryard_cnt = getYardCNTCode(fryard);
			toyard_cnt = getYardCNTCode(toyard);
			
			if((fryard_cnt.equals("US") || fryard_cnt.equals("CA")) && (toyard_cnt.equals("US") || toyard_cnt.equals("CA"))) {
				railMode   = "Y";  // RAIL-US 쿼리로 ETA 조회함
			}
		}
		
//		log.debug("-- item 			 : " + item);
//		log.debug("-- fryard_cnt 	 : " + fryard_cnt);
//		log.debug("-- itemtoyard_cnt : " + toyard_cnt);
//		log.debug("-- railMode 		 : " + railMode);
		
		
		try {
			param.put("etd", etd);
			param.put("fryard", fryard);
			param.put("toyard", toyard);
			param.put("item", item);
			velParam.put("railMode", railMode);
			velParam.put("item", item);
			
			
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchEtaDateRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				etaDate = dbRowset.getString("ETA");
			} 
			
			if(etaDate==null || etaDate.equals("")) {
				etaDate = "";
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
		return etaDate;
	}

	
	/**
	 * Yard Code의 Country code 를 검색해 옵니다. 
	 * 
	 * @param  yard_code
	 * @return String
	 * @exception DAOException
	 */	
	public String getYardCNTCode(String yard_code) throws DAOException {
		
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String eta_date  = "";
//		int j = 0;
		
		try {
			param.put("yard_code", yard_code);
			
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new RailSoManageDBDAOGetYardCNTCodeRSQL(), param, null);
			while(dbRowset.next()) {
				eta_date = dbRowset.getString("CNT_CD");
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
		
		return eta_date;
	}
	
	/**
     * 입력한 Ref Id의 Ref Seq채번<br>
     * ESD_TRS_0201.do
     * @param repo_pln_id 	String
     * @param pln_yrwk 		String
     * @param pln_seq 		String
     * @param ref_id 		String
     * @return String
     * @exception DAOException
    */
	public String searchGetRefSeq(String repo_pln_id,String pln_yrwk,String pln_seq, String ref_id) throws DAOException {
	    String ref_seq  = "";
		
	    try {
			DBRowSet dbRowset = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("repo_pln_id",repo_pln_id);
			param.put("pln_yrwk",pln_yrwk);
			param.put("pln_seq",pln_seq);
			param.put("ref_id",ref_id);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RailSoManageDBDAOSearchGetRefSeqRSQL(), param, param);
	        
	        if(dbRowset.next()){
	        	ref_seq = dbRowset.getString("REF_SEQ");
	        }
	        
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    
	    return ref_seq;
	}	
}