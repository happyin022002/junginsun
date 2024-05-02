/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : DOFChgColPermanageDBDAO.java
 *@FileTitle : Drop Off Charge Collection Performance List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-01-30
 *@LastModifier : ho-sam lee
 *@LastVersion : 1.0
 * 2008-01-30 ho-sam lee
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0007Event;
//import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0011Event;
//import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0012Event;
//import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0013Event;
//import com.hanjin.apps.alps.esd.eas.transportmanage.vo.CommEasDrffChgTrfVO;
//import com.hanjin.apps.alps.esd.eas.transportmanage.vo.DOFChgColInqmanageListVO;
import com.hanjin.apps.alps.esd.eas.transportmanage.vo.DofChgTrfListVO;
//import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
//import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.EasDrffChgTrfDtlVO;
//import com.hanjin.syscommon.common.table.EasDrffChgTrfHdrVO;

/**
 * DOFChgTrfmanageDBDAO ???? PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class DOFChgTrfmanageDBDAO extends DBDAOSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Drop Off Charge Tariff List 조회.<br>
	 * 
	 * @param EsdEas0007Event event           
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDofChgTrfList(EsdEas0007Event event)
			throws DAOException {
		DBRowSet dRs = new DBRowSet();
		try {
			String strcnt_cd = JSPUtil.getNull(event.getSelCntCd());
			String cust_info = JSPUtil.getNull(event.getCustCntSeq());
			String streffdt = event.getSType();

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("strcnt_cd", strcnt_cd);
			param.put("cust_info", cust_info);
			param.put("streffdt", streffdt);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL template = new DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL();
			dRs = sqlExe.executeQuery(template, param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		}
		return dRs;
	}

//	/**
//	 * Drop Off Charge Tariff Hdr List 조회.<br>
//	 * 
//	 * @param EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchEasDrffChgTrfHdrRSQL(EsdEas0011Event event)
//			throws DAOException {
//		DBRowSet dRs = null;
//		try {
//			String cnt_cd = JSPUtil.getNull(event.getCntCd());
//			String rfa_no = JSPUtil.getNull(event.getRfaNo());
//			log.debug("\n dao. cnt_cd:" + cnt_cd + "\n");
//			log.debug("\n dao. rfa_no:" + rfa_no + "\n");
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("cnt_cd", cnt_cd);
//			param.put("rfa_no", rfa_no);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchEasDrffChgTrfHdrRSQL template = new DOFChgTrfmanageDBDAOsearchEasDrffChgTrfHdrRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		}
//		return dRs;
//	}
//
//	/**
//	 * Drop Off Charge Tariff Dtl List 조회.<br>
//	 * 
//	 * @param EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchEasDrffChgTrfDtlRSQL(EsdEas0011Event event)
//			throws DAOException {
//		DBRowSet dRs = null;
//		try {
//
//			String drff_chg_trf_seq = JSPUtil.getNull(event.getDrffChgTrfSeq());
//			String drff_chg_trf_ver_no = JSPUtil.getNull(event
//					.getDrffChgTrfVerNo());
//			String cnt_cd = JSPUtil.getNull(event.getCntCd());
//
//			log.debug("testcc   drff_chg_trf_seq:::" + drff_chg_trf_seq);
//			log.debug("testcc   drff_chg_trf_ver_no:::" + drff_chg_trf_ver_no);
//			if (cnt_cd == null || cnt_cd.trim().equals("")) {
//				cnt_cd = "";
//			}
//			Map<String, Object> param = new HashMap<String, Object>();
//
////			param.put("cnt_cd", cnt_cd);
//			param.put("drff_chg_trf_seq", drff_chg_trf_seq);
//			param.put("drff_chg_trf_ver_no", drff_chg_trf_ver_no);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlRSQL template = new DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		}
//		return dRs;
//	}
//
//	/**
//	 * Drop Off Charge Tariff DtlScc List 조회.<br>
//	 * 
//	 * @param EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchEasDrffChgTrfDtlSccRSQL(EsdEas0011Event event)
//			throws DAOException {
//		DBRowSet dRs = null;
//		try {
//
//			String cnt_cd = JSPUtil.getNull(event.getCntCd());
//			String drff_chg_trf_seq = JSPUtil.getNull(event.getDrffChgTrfSeq());
//			String drff_chg_trf_ver_no = JSPUtil.getNull(event
//					.getDrffChgTrfVerNo());
//
//			log.debug("testcc   cnt_cd:::" + cnt_cd);
//			log.debug("testcc   drff_chg_trf_seq:::" + drff_chg_trf_seq);
//			log.debug("testcc   drff_chg_trf_ver_no:::" + drff_chg_trf_ver_no);
//
//			Map<String, Object> param = new HashMap<String, Object>();
//			if (cnt_cd == null || cnt_cd.trim().equals("")) {
//				cnt_cd = "";
//			}
//
//			param.put("cnt_cd", cnt_cd);
//			param.put("drff_chg_trf_seq", drff_chg_trf_seq);
//			param.put("drff_chg_trf_ver_no", drff_chg_trf_ver_no);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSccRSQL template = new DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSccRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		}
//		return dRs;
//	}

	/**
	 * Drop Off Charge Tariff 중복 갯수 조회.<br>
	 * 
	 * @param EsdEas0007Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDofChgDupCnt(EsdEas0007Event event) throws DAOException {
		DBRowSet dRs = new DBRowSet();
		try {

			String strcnt_cd = null;
			String conti_cd = null;
			String cust_info = null;
			String streffdt = null;
			String s_cntr_tp_cd = null;

			strcnt_cd = JSPUtil.getNull(event.getSLocCd());
			cust_info = JSPUtil.getNull(event.getSCustInfo());
			streffdt = event.getSType();
			s_cntr_tp_cd = event.getSCntrTpCd();

			conti_cd = event.getSContiCd();
			if (conti_cd == null || conti_cd.trim().equals("")) {
				conti_cd = " ";// null 허용안됨.
			}

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("streffdt", streffdt);
			param.put("strcnt_cd", strcnt_cd);
			param.put("cust_info", cust_info);
			param.put("streffdt", streffdt);
			param.put("s_cntr_tp_cd", s_cntr_tp_cd);
			param.put("conti_cd", conti_cd);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			DOFChgTrfmanageDBDAOsearchDofChgDupCntRSQL template = new DOFChgTrfmanageDBDAOsearchDofChgDupCntRSQL();
			dRs = sqlExe.executeQuery(template, param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		}
		return dRs;
	}

	/**
	 * User가 선택한 정보를 기준으로 Effect Date를 찾아온다.
	 * 
	 * @param EsdEas0007Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchEffDT(EsdEas0007Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = new DBRowSet();
		try {
			String strcnt_cd = null;
			strcnt_cd = JSPUtil.getNull(event.getSelCntCd());

			String cust_info = null;
			cust_info = JSPUtil.getNull(event.getCustCntSeq());

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("strcnt_cd", strcnt_cd);
			param.put("cust_info", cust_info);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			DOFChgTrfmanageDBDAOsearchEffDTRSQL template = new DOFChgTrfmanageDBDAOsearchEffDTRSQL();
			dRs = sqlExe.executeQuery(template, param, param);
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
		return dRs;
	}

//	/**
//	 * RfaNo를 체크한다.
//	 * 
//	 * @param EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet checkRfaNo(EsdEas0011Event event) throws DAOException {
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		try {
//			String rfa_no = null;
//
//			log.debug("event.getRfaNo()::" + event.getRfaNo());
//
//			rfa_no = JSPUtil.getNull(event.getRfaNo());
//
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("rfa_no", rfa_no);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchRfaNoRSQL template = new DOFChgTrfmanageDBDAOsearchRfaNoRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return dRs;
//	}
//
//	/**
//	 * RfaNo를 체크한다.
//	 * 
//	 * @param EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet checkInputRfaNo(EsdEas0011Event event) throws DAOException {
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		try {
//			String scc_cd = null;
//
//			log.debug("event.getSccCd()::" + event.getSccCd());
//
//			scc_cd = JSPUtil.getNull(event.getSccCd());
//
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("scc_cd", scc_cd);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlRfaRSQL template = new DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlRfaRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return dRs;
//	}
//
//	/**
//	 * Country Search한다.
//	 * 
//	 * @param EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchCountryCombo(EsdEas0011Event event)
//			throws DAOException {
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		try {
//
//			String strcnt_cd = null;
//			strcnt_cd = JSPUtil.getNull(event.getSelCntCd());
//
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("cnt_cd", strcnt_cd);
//
//			log.debug("param:::" + param);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchCountryComboRSQL template = new DOFChgTrfmanageDBDAOsearchCountryComboRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return dRs;
//	}
//
//	/**
//	 * Curr Cd 조회한다.
//	 * 
//	 * @param  EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchCurrCd(EsdEas0011Event event) throws DAOException {
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		try {
//
//			String scc_cd2 = null;
//			scc_cd2 = JSPUtil.getNull(event.getSccCd2());
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("scc_cd2", scc_cd2);
//
//			log.debug("param:::" + param);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchCurrCdRSQL template = new DOFChgTrfmanageDBDAOsearchCurrCdRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return dRs;
//	}	
//	
//	
//	/**
//	 * Curr Cd 리스트 목록 조회한다.
//	 * 
//	 * @param  EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchCurrList(EsdEas0011Event event) throws DAOException {		
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		ArrayList<String> arrSccCd = null;
//		String scc_cd = "";
//		
//		try {
//			CommEasDrffChgTrfVO[] commEasDrffChgTrfVOs = event.getCommEasDrffChgTrfVOs();
//			
//			log.debug("commEasDrffChgTrfVOs.length = "+commEasDrffChgTrfVOs.length);
//			for(int i=0; i<commEasDrffChgTrfVOs.length; i++){
////				scc_cd = scc_cd+"SELECT '"+JSPUtil.getNull(commEasDrffChgTrfVOs[i].getSccCd())+"' SCC_CD FROM DUAL UNION ALL \n";
//				if(i == commEasDrffChgTrfVOs.length-1){
//					scc_cd = scc_cd + JSPUtil.getNull(commEasDrffChgTrfVOs[i].getSccCd());					
//				}else{
//					scc_cd = scc_cd + JSPUtil.getNull(commEasDrffChgTrfVOs[i].getSccCd())+",";
//				}
//			}
//			
//			log.debug("\nscc_cd = "+scc_cd);
//						
//			if(event != null && !"".equals(scc_cd)){
//				arrSccCd = CommonUtil.seperationParameter(scc_cd, ",");
//			}			
//			log.debug("\narrSccCd.size = "+arrSccCd.size());
//			
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("arrSccCd", arrSccCd);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchCurrListRSQL template = new DOFChgTrfmanageDBDAOsearchCurrListRSQL();			
//			dRs = sqlExe.executeQuery(template, param, param);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return dRs;
//	}		
	
	/**
	 * 등록/수정/삭제 처리.
	 * 
	 * @param EsdEas0007Event event
	 * @throws DAOException
	 */
	public void multiDofChgTrf(EsdEas0007Event event) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			DofChgTrfListVO[] model = event.getDofChgTrfListVOs();
			Collection<DofChgTrfListVO> insertVoList = new ArrayList<DofChgTrfListVO>();
			Collection<DofChgTrfListVO> updateVoList = new ArrayList<DofChgTrfListVO>();
			Collection<DofChgTrfListVO> deleteVoList = new ArrayList<DofChgTrfListVO>();

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("ctrl_user_id", event.getCtrlUserId());
			param.put("ctrl_ofc_cd", event.getCtrlOfcCd());
			String newEffDate = event.getNewEffDate();

			if (newEffDate.equals("")) {
				newEffDate = event.getSType();
			}
			// newEffDate 가 없으면  S_TYPE 으로 MERGE 
			// newEffDate 가 있으면  newEffDate 으로 MERGE
			newEffDate = JSPUtil.replace(newEffDate, "/", "");
			param.put("newEffDate", newEffDate);

			for (int i = 0; i < model.length; i++) {
				String conti_cd = model[i].getContiCd();
				String conti_cd_old = model[i].getContiCdOld();

				if (conti_cd == null || conti_cd.trim().equals("")) {
					conti_cd = " ";// null 허용안됨.
				}
				model[i].setContiCd(conti_cd);

				if (conti_cd_old == null || conti_cd_old.trim().equals("")) {
					conti_cd_old = " ";// null 허용안됨.
				}
				model[i].setContiCdOld(conti_cd_old);

				String selcustcd = model[i].getCustInfo();
				if (selcustcd.equals("") || selcustcd == null) {
					selcustcd = "CO0";
				}
				model[i].setCustInfo(selcustcd);
				if (model[i].getIbflag().equals("I")) {
					insertVoList.add(model[i]);
				} else if (model[i].getIbflag().equals("U")) {
					updateVoList.add(model[i]);
				} else if (model[i].getIbflag().equals("D")) {
					deleteVoList.add(model[i]);
				}
			}

			// 1.Insert
			if (insertVoList.size() > 0) {
				sqlExe
						.executeBatch(
								(ISQLTemplate) new DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL(),
								insertVoList, null, param);
			}

			// 2.Update
			if (updateVoList.size() > 0) {
//				sqlExe
//						.executeBatch(
//								(ISQLTemplate) new DOFChgTrfmanageDBDAOmultiDofChgTrfUSQL(),
//								updateVoList, null, param);
				sqlExe
				.executeBatch(
						(ISQLTemplate) new DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL(),
						updateVoList, null, param);				
			}
			// 2.Delete
			if (deleteVoList.size() > 0) {
				sqlExe
						.executeBatch(
								(ISQLTemplate) new DOFChgTrfmanageDBDAOmultiDofChgTrfDSQL(),
								deleteVoList, null, param);
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
	}
	
//	/**
//	 * EffDt Update 처리.
//	 * 
//	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
//	 * @throws DAOException
//	 */	
//	public void modifyDrffChgTrfEffdt(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO) throws DAOException {									  
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();			
//		
//		try{
//			if(easDrffChgTrfHdrVO != null){
//				Map<String, String> mapVO = easDrffChgTrfHdrVO.getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//				
//				param.put("fm_eff_dt", easDrffChgTrfHdrVO.getFmEffDt());
//				param.put("cnt_cd", easDrffChgTrfHdrVO.getCntCd());
//				param.put("rfa_no", easDrffChgTrfHdrVO.getRfaNo());				
//				param.put("drff_chg_trf_seq", easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//				param.put("drff_chg_trf_ver_no", easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//				
//			}
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDrffChgTrfEffdtUSQL(), param,velParam);			
//			if(updCnt == Statement.EXECUTE_FAILED)
//						throw new DAOException(new ErrorHandler("COM12240").getMessage());												
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}			
//	}
		
//	/**
//	 * VERSION을 Check 한다.
//	 * 
//	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
//	 * @return String
//	 * @throws DAOException
//	 */
//
//	public String searchEasDrffChgTrfVerChk(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		EasDrffChgTrfHdrVO vo = easDrffChgTrfHdrVO;
//		String rtnData = "";
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try {
//			Map<String, String> mapVO = new HashMap<String, String>();
//
//			mapVO.put("cnt_cd", vo.getCntCd());
//			mapVO.put("rfa_no", vo.getRfaNo());
//			mapVO.put("drff_chg_trf_seq", vo.getDrffChgTrfSeq());
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			dbRowset = new SQLExecuter("DEFAULT")
//					.executeQuery(
//							(ISQLTemplate) new DOFChgTrfmanageDBDAOsearchEasDrffChgTrfVerChkRSQL(),
//							param, velParam);
//
//			while (dbRowset.next()) {
//				rtnData = dbRowset.getString("VER_CHK") + ","
//						+ dbRowset.getString("DRFF_CHG_TRF_VER_NO") + ","
//						+ dbRowset.getString("DRFF_CHG_TRF_SEQ");
//			}
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ee) {
//			log.error(ee.getMessage(), ee);
//			throw new DAOException(ee.getMessage());
//		}
//		return rtnData;
//	}
//
//	/**
//	 * FM_EFF_DT 유효성 확인을 한다.
//	 * 
//	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
//	 * @return String
//	 * @throws DAOException
//	 */
//
//	public String searchEasDrffChgTrfEffdtChk(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		String effChk = "";
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try {
//			Map<String, String> mapVO = new HashMap<String, String>();
//
//			mapVO.put("cnt_cd", easDrffChgTrfHdrVO.getCntCd());
//			mapVO.put("rfa_no", easDrffChgTrfHdrVO.getRfaNo());			
//			mapVO.put("drff_chg_trf_seq", easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//			mapVO.put("drff_chg_trf_ver_no", easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new DOFChgTrfmanageDBDAOsearchEasDrffChgTrfEffdtChkRSQL(),param, velParam);
//
//			while (dbRowset.next()) {
//				effChk = dbRowset.getString("FM_EFF_DT_CHK");
//			}
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (Exception ee) {
//			log.error(ee.getMessage(), ee);
//			throw new DAOException(ee.getMessage());
//		}
//		return effChk;
//	}
//
//	/**
//	 * SEQ를 가져온다
//	 * 
//	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int searchEasDrffChgTrfDtlSeq(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO)
//			throws DAOException {
//
//		DBRowSet dbRowset = null;
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		int maxSeq = 0;
//
//		try {
//
//			param.put("drff_chg_trf_seq", easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//			param.put("drff_chg_ver_no", easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSeqRSQL(),param, velParam);
//
//			if (dbRowset != null && dbRowset.next()) {
//				maxSeq = dbRowset.getInt("MAX_SEQ");
//			}
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return maxSeq;
//	}

	/**
	 * 유럽지역의 모든 Offcie를 찾아온다.
	 * 
	 * @param EsdEas0007Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchEUROffcd(EsdEas0007Event event) throws DAOException {

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = new DBRowSet();
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			DOFChgTrfmanageDBDAOsearchEUROffcdRSQL template = new DOFChgTrfmanageDBDAOsearchEUROffcdRSQL();
			dRs = sqlExe.executeQuery(template, null, null);

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

		return dRs;
	}

	/**
	 * 입력된 Location Code의 MDM내 존재여부 확인.<br>
	 * 
	 * @param EsdEas0007Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyLocCd(EsdEas0007Event event) throws DAOException {
		DBRowSet dRs = new DBRowSet();

		try {

			String loc_cd = event.getSLocCd();
			StringTokenizer locCdToken = new StringTokenizer(loc_cd, ",");
			Map<String, Object> param = new HashMap<String, Object>();
			String firstLoc = ""; 
            while(locCdToken.hasMoreTokens()){
            	String locCd = locCdToken.nextToken();
            	if(!locCd.equals(firstLoc) ){
            		
            		firstLoc = locCd;
            		param.put("loc_cd", locCd);
            		
            		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            		DOFChgTrfmanageDBDAOverifyLocCdRSQL template = new DOFChgTrfmanageDBDAOverifyLocCdRSQL();
            		dRs = sqlExe.executeQuery(template, param, null);
            		if(dRs.next()){
            			int chkCnt = dRs.getInt("LOC_CNT");
            			if(chkCnt == 0){
            				dRs.beforeFirst();
            				return dRs;
            			}
            		}
            	}
          	
            	param.clear();
            }
            dRs.beforeFirst();

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		}
		return dRs;
	}

	/**
	 * verifyCustCd 입력된 cust_cd의 MDM내 존재여부 확인.<br>
	 * 
	 * @param EsdEas0007Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyCustCd(EsdEas0007Event event) throws DAOException {

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = new DBRowSet();
		try {
			String cust_info = null;
			cust_info = event.getSCustInfo();
//			if (cust_info.equals("") || cust_info == null) {
//				cust_info = "CO0";
//			}
			Map<String, Object> param = new HashMap<String, Object>();
			
			StringTokenizer custCdToken = new StringTokenizer(cust_info, ",");
			String firstCd = ""; 
            while(custCdToken.hasMoreTokens()){
            	String custCd = custCdToken.nextToken();
            	
            	if (custCd.equals("") || custCd == null) {
            		custCd = "CO0";
    			}
            	if(!custCd.equals(firstCd) ){
            		
            		firstCd = custCd;
            		param.put("cust_info", custCd);
            		
            		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            		DOFChgTrfmanageDBDAOverifyCustCdRSQL template = new DOFChgTrfmanageDBDAOverifyCustCdRSQL();
            		dRs = sqlExe.executeQuery(template, param, param);
            		if(dRs.next()){
            			int chkCnt = dRs.getInt("CUST_CNT");
            			String info = dRs.getString("CUST_INFO");
            			if(chkCnt == 0 && !info.equals("CO0")){
            				dRs.beforeFirst();
            				return dRs;
            			}
            		}
            	}
          	
            	param.clear();
            }
            dRs.beforeFirst();
            
            
			
//			param.put("cust_info", cust_info);
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOverifyCustCdRSQL template = new DOFChgTrfmanageDBDAOverifyCustCdRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		}
		return dRs;
	}

	/**
	 * verifyTpSz-verifyTpSz 입력된 tpsz_cd의 MDM내 존재여부 확인<br>
	 * 
	 * @param EsdEas0007Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyTpSz(EsdEas0007Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = new DBRowSet();

		try {
			String s_cntr_tp_cd = event.getSCntrTpCd();
			
			
			StringTokenizer tpCdToken = new StringTokenizer(s_cntr_tp_cd, ",");
			Map<String, Object> param = new HashMap<String, Object>();
			String firstTp = ""; 
            while(tpCdToken.hasMoreTokens()){
            	String tpCd = tpCdToken.nextToken();
            	if(!tpCd.equals(firstTp) ){
            		
            		firstTp = tpCd;
            		param.put("s_cntr_tp_cd", tpCd);
            		
            		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            		DOFChgTrfmanageDBDAOverifyTpSzRSQL template = new DOFChgTrfmanageDBDAOverifyTpSzRSQL();
            		dRs = sqlExe.executeQuery(template, param, param);
            		if(dRs.next()){
            			int chkCnt = dRs.getInt("TPSZ_CNT");
            			if(chkCnt == 0){
            				dRs.beforeFirst();
            				return dRs;
            			}
            		}
            	}
          	
            	param.clear();
            }
            dRs.beforeFirst();
            
			
			
			
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("s_cntr_tp_cd", s_cntr_tp_cd);
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOverifyTpSzRSQL template = new DOFChgTrfmanageDBDAOverifyTpSzRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		}
		return dRs;
	}

	/**
	 * verifyCurr 입력된 curr_cd의 MDM내 존재여부 확인.<br>
	 * 
	 * @param EsdEas0007Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyCurr(EsdEas0007Event event) throws DAOException {
		DBRowSet dRs = new DBRowSet();

		try {
			String curr_cd = event.getSCurrCd();
			
			//--------------------
			StringTokenizer tpCdToken = new StringTokenizer(curr_cd, ",");
			Map<String, Object> param = new HashMap<String, Object>();
			String firstTp = ""; 
            while(tpCdToken.hasMoreTokens()){
            	String tpCd = tpCdToken.nextToken();
            	if(!tpCd.equals(firstTp) ){
            		
            		firstTp = tpCd;
            		param.put("curr_cd", tpCd);
            		
            		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            		DOFChgTrfmanageDBDAOverifyCurrRSQL template = new DOFChgTrfmanageDBDAOverifyCurrRSQL();
            		dRs = sqlExe.executeQuery(template, param, param);
            		if(dRs.next()){
            			int chkCnt = dRs.getInt("CURR_CNT");
            			if(chkCnt == 0){
            				dRs.beforeFirst();
            				return dRs;
            			}
            		}
            	}
          	
            	param.clear();
            }
            dRs.beforeFirst();			
			
			
			
			//--------------------
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("curr_cd", curr_cd);
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOverifyCurrRSQL template = new DOFChgTrfmanageDBDAOverifyCurrRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		}
		return dRs;
	}

//	/**
//	 * New Drop Off Charge Tariff List 조회.<br>
//	 * 
//	 * @param EsdEas0011Event event
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchDofChgTrfNewList(EsdEas0011Event event)
//			throws DAOException {
//		DBRowSet dRs = null;
//		try {
//			String cust_info = JSPUtil.getNull(event.getCustCntSeq());
//			String streffdt = event.getSType();
//
//			Map<String, Object> param = new HashMap<String, Object>();
//			param.put("cust_info", cust_info);
//			param.put("streffdt", streffdt);
//
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL template = new DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL();
//			dRs = sqlExe.executeQuery(template, param, param);
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(new ErrorHandler("").getMessage());
//		}
//		return dRs;
//	}
	
//	/**
//	 * Drop_off Charge Tariff Header 등록한다.<br>
//	 * 
//	 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
//	 * @param SignOnUserAccount account
//	 * @throws DAOException
//	 */
//	public void addDrffChgTrf(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, SignOnUserAccount account) throws DAOException {
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();			
//		
//		try{
//			if(easDrffChgTrfHdrVO != null){
//				Map<String, String> mapVO = easDrffChgTrfHdrVO.getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//				
//				param.put("drff_chg_trf_ver_no", easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//				param.put("drff_chg_trf_seq", easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//				param.put("fm_eff_dt", easDrffChgTrfHdrVO.getFmEffDt());
//				param.put("to_eff_dt", easDrffChgTrfHdrVO.getToEffDt());
//				param.put("cre_ofc_cd", easDrffChgTrfHdrVO.getCreOfcCd());
//				param.put("cnt_cd", easDrffChgTrfHdrVO.getCntCd());
//				param.put("rfa_no", easDrffChgTrfHdrVO.getRfaNo());				
//				param.put("cre_usr_id", account.getUsr_id());	
//				param.put("upd_usr_id", account.getUsr_id());				
//			}
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDrffChgTrfCSQL(), param,velParam);			
//			if(insCnt == Statement.EXECUTE_FAILED)
//						throw new DAOException(new ErrorHandler("COM12240").getMessage());												
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}	
//	}
//	
//	 /**
//	  * Drop_off Charge Tariff Header 수정한다.<br>
//	  * 
//	  * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
//	  * @param SignOnUserAccount account
//	  * @throws DAOException
//	  */
//	 public void modifyDrffChgTrf(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, SignOnUserAccount account) throws DAOException {
//		Map<String, Object> param = new HashMap<String, Object>();
//		Map<String, Object> velParam = new HashMap<String, Object>();			
//		
//		try{
//			if(easDrffChgTrfHdrVO != null){
//				Map<String, String> mapVO = easDrffChgTrfHdrVO.getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//				
//				param.put("drff_chg_trf_seq", easDrffChgTrfHdrVO.getDrffChgTrfSeq());
//				param.put("drff_chg_trf_ver_no", easDrffChgTrfHdrVO.getDrffChgTrfVerNo());
//				param.put("fm_eff_dt", easDrffChgTrfHdrVO.getFmEffDt());
//				param.put("to_eff_dt", easDrffChgTrfHdrVO.getToEffDt());	
//				param.put("upd_usr_id", account.getUsr_id());
//			}							
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDrffChgTrfUSQL(), param,velParam);
//				
//			if(insCnt == Statement.EXECUTE_FAILED)
//						throw new DAOException(new ErrorHandler("COM12240").getMessage());
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//
//	 }	
//	 
//		/**
//		 * Drop_off Charge Tariff Detail 등록한다.<br>
//		 * 
//		 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
//		 * @param Collection<EasDrffChgTrfDtlVO> easDrffChgTrfDtlVOs
//		 * @param SignOnUserAccount account
//		 * @throws DAOException
//		 */
//		public void addDrffChgTrfDtl(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, Collection<EasDrffChgTrfDtlVO> easDrffChgTrfDtlVOs, SignOnUserAccount account) throws DAOException {
//			Map<String, Object> param = new HashMap<String, Object>();			
//			try {
//				param.put("cre_usr_id", account.getUsr_id());
//				param.put("upd_usr_id", account.getUsr_id());
//				param.put("cnt_cd", easDrffChgTrfHdrVO.getCntCd());
//				param.put("rfa_no", easDrffChgTrfHdrVO.getRfaNo());
//				
//				SQLExecuter sqlExe = new SQLExecuter("");
//				int intCnt[] = null;
//				if(easDrffChgTrfDtlVOs.size() > 0){
//					intCnt = sqlExe.executeBatch((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDrffChgTrfDtlCSQL(), easDrffChgTrfDtlVOs, null, param);
//					for(int i = 0; i < intCnt.length; i++){
//						if(intCnt[i]== Statement.EXECUTE_FAILED)
//							throw new DAOException("Fail to insert No"+ i + " SQL");
//					}
//				}
//			} catch (SQLException se) {
//				throw new DAOException(new ErrorHandler(se).getMessage());
//			}catch(Exception ex){
//				throw new DAOException(new ErrorHandler(ex).getMessage());
//			}				
//		}	 
//	 
//		/**
//		 * Drop_off Charge Tariff Detail 수정한다.<br>
//		 * 
//		 * @param EasDrffChgTrfHdrVO easDrffChgTrfHdrVO
//		 * @param Collection<EasDrffChgTrfDtlVO> easDrffChgTrfDtlVOs
//		 * @param SignOnUserAccount account
//		 * @throws DAOException
//		 */
//		public void modifyDrffChgTrfDtl(EasDrffChgTrfHdrVO easDrffChgTrfHdrVO, Collection<EasDrffChgTrfDtlVO> easDrffChgTrfDtlVOs, SignOnUserAccount account) throws DAOException {
//			Map<String, Object> param = new HashMap<String, Object>();			
//			try {				 
//				param.put("cre_usr_id", account.getUsr_id());
//				param.put("upd_usr_id", account.getUsr_id());
//				param.put("cnt_cd", easDrffChgTrfHdrVO.getCntCd());
//				param.put("rfa_no", easDrffChgTrfHdrVO.getRfaNo());
//				
//				SQLExecuter sqlExe = new SQLExecuter("");
//				int updCnt[] = null;
//				if(easDrffChgTrfDtlVOs.size() > 0){
//					updCnt = sqlExe.executeBatch((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDrffChgTrfDtlUSQL(), easDrffChgTrfDtlVOs, null, param);
//					for(int i = 0; i < updCnt.length; i++){
//						if(updCnt[i]== Statement.EXECUTE_FAILED)
//							throw new DAOException("Fail to update No"+ i + " SQL");
//					}
//				}
//			} catch (SQLException se) {
//				throw new DAOException(new ErrorHandler(se).getMessage());
//			}catch(Exception ex){
//				throw new DAOException(new ErrorHandler(ex).getMessage());
//			}				
//		}		
//		
//		/**
//		 * Drop_off Charge Tariff Detail 삭제한다.<br>
//		 * 
//		 * @param String isUpload
//		 * @param Collection<EasDrffChgTrfDtlVO> easDrffChgTrfDtlVOs
//		 * @throws DAOException
//		 */
//		public void removeDrffChgTrfDtl(String isUpload, Collection<EasDrffChgTrfDtlVO> easDrffChgTrfDtlVOs) throws DAOException {
//			Map<String, Object> param = new HashMap<String, Object>();
//			try {				
//				param.put("isUpload", isUpload);
//				SQLExecuter sqlExe = new SQLExecuter("");
//				int delCnt[] = null;
//				if(easDrffChgTrfDtlVOs.size() > 0){
//					delCnt = sqlExe.executeBatch((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDrffChgTrfDtlDSQL(), easDrffChgTrfDtlVOs, param, param);
//					for(int i = 0; i < delCnt.length; i++){
//						if(delCnt[i]== Statement.EXECUTE_FAILED)
//							throw new DAOException("Fail to delete No"+ i + " SQL");
//					}
//				}
//			} catch (SQLException se) {
//				throw new DAOException(new ErrorHandler(se).getMessage());
//			}catch(Exception ex){
//				throw new DAOException(new ErrorHandler(ex).getMessage());
//			}				
//		}			
				
//		/**
//		 * Drop_off Charge Tariff Type Size 등록한다.<br>
//		 * 
//		 * @param CommEasDrffChgTrfVO commEasTrfVO
//		 * @param SignOnUserAccount account
//		 * @throws DAOException
//		 */
//		public void addDrffChgTrfTpSz(CommEasDrffChgTrfVO commEasTrfVO, SignOnUserAccount account) throws DAOException {
//			Map<String, Object> param = new HashMap<String, Object>();
//			Map<String, Object> velParam = new HashMap<String, Object>();			
//
//			try {
//				if(commEasTrfVO != null){
//					Map<String, String> mapVO = commEasTrfVO.getColumnValues();
//					
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);					
//					
//					param.put("cre_usr_id", account.getUsr_id());					
//					param.put("upd_usr_id", account.getUsr_id());					
//				}
//				SQLExecuter sqlExe = new SQLExecuter("");
//				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDrffChgTrfTpSzCSQL(), param, velParam);				
//				if(insCnt == Statement.EXECUTE_FAILED)
//					throw new DAOException(new ErrorHandler("COM12240").getMessage());
//			} catch (SQLException se) {
//				throw new DAOException(new ErrorHandler(se).getMessage());
//			}catch(Exception ex){
//				throw new DAOException(new ErrorHandler(ex).getMessage());
//			}				
//		}	 
//	 		
//		/**
//		 * Drop_off Charge Tariff Type Size 삭제한다.<br>
//		 * 
//		 * @param String isUpload
//		 * @param CommEasDrffChgTrfVO commEasTrfVO
//		 * @throws DAOException
//		 */
//		public void removeDrffChgTrfTpSz(String isUpload, CommEasDrffChgTrfVO commEasTrfVO) throws DAOException {
//			Map<String, Object> param = new HashMap<String, Object>();
//			Map<String, Object> velParam = new HashMap<String, Object>();	
//			
//			try {
//				if(commEasTrfVO != null){
//					Map<String, String> mapVO = commEasTrfVO.getColumnValues();
//					
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);
//					
//					param.put("isUpload", isUpload);
//					velParam.put("isUpload", isUpload);
//				}
//				SQLExecuter sqlExe = new SQLExecuter("");
//				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new DOFChgTrfmanageDBDAOmultiDrffChgTrfTpSzDSQL(), param, velParam);				
//				if(insCnt == Statement.EXECUTE_FAILED)
//					throw new DAOException(new ErrorHandler("COM12240").getMessage());
//			} catch (SQLException se) {
//				throw new DAOException(new ErrorHandler(se).getMessage());
//			}catch(Exception ex){
//				throw new DAOException(new ErrorHandler(ex).getMessage());
//			}				
//		}		 	 
		
//		/**
//		 * searchDODCollectionInquiry 기본 조회 기능<br>
//		 * @param EsdEas0012Event event
//		 * @return DBRowSet
//		 * @throws DAOException
//		 */
//		public DBRowSet searchDODCollectionInquiry(EsdEas0012Event event) throws DAOException {
//			DBRowSet dRs = null;
//		
//			try {
//				
//				DOFChgColInqmanageListVO dOFChgColInqmanageListVO = event.getDOFChgColInqmanageListVo();
//				
//				Map<String, Object> param = new HashMap<String, Object>();
//				Map<String, Object> velParam = new HashMap<String, Object>();
//
//				String bkgNo = dOFChgColInqmanageListVO.getBkgNo();
//				String returnCy = dOFChgColInqmanageListVO.getReturnCy();
//				String selTpCd = dOFChgColInqmanageListVO.getSelTpCd();
//				String mtRtnMth = dOFChgColInqmanageListVO.getMtRtnMth();
//				String fmMtRtnPrd = dOFChgColInqmanageListVO.getFmMtRtnPrd();
//				String toMtRtnPrd = dOFChgColInqmanageListVO.getToMtRtnPrd();
//				String ctrlOfcCd = dOFChgColInqmanageListVO.getCtrlOfcCd();
//				String strRevOfcCd = "'"+ctrlOfcCd+"'";
//				strRevOfcCd = strRevOfcCd.replaceAll(",", "','");				
//				String haulCd = dOFChgColInqmanageListVO.getHaulCd();
//				String tromonth = dOFChgColInqmanageListVO.getTromonth();
//				String fromtrodate = dOFChgColInqmanageListVO.getFromtrodate();
//				String totrodate = dOFChgColInqmanageListVO.getTotrodate();
//				String rfaNo = dOFChgColInqmanageListVO.getRfaNo();
//				String custCd = dOFChgColInqmanageListVO.getCustCd();
//						
//				param.put("bkg_no", bkgNo);				
//				param.put("return_cy", returnCy);				
//				param.put("sel_tp_cd", selTpCd);				
//				param.put("mt_rtn_mth", mtRtnMth);				
//				param.put("fm_mt_rtn_prd", fmMtRtnPrd);				
//				param.put("to_mt_rtn_prd", toMtRtnPrd);				
//				//param.put("ctrl_ofc_cd", ctrlOfcCd);				
//				param.put("ctrl_ofc_cd", strRevOfcCd);				
//				param.put("haul_cd", haulCd);				
//				param.put("tromonth", tromonth);				
//				param.put("fromtrodate", fromtrodate);				
//				param.put("totrodate", totrodate);				
//				param.put("rfa_no", rfaNo);	
//				param.put("cust_cd", custCd);	
//				
//				velParam.put("bkg_no", bkgNo);				
//				velParam.put("return_cy", returnCy);				
//				velParam.put("sel_tp_cd", selTpCd);				
//				velParam.put("mt_rtn_mth", mtRtnMth);				
//				velParam.put("fm_mt_rtn_prd", fmMtRtnPrd);				
//				velParam.put("to_mt_rtn_prd", toMtRtnPrd);				
//				//velParam.put("ctrl_ofc_cd", ctrlOfcCd);				
//				velParam.put("ctrl_ofc_cd", strRevOfcCd);				
//				velParam.put("haul_cd", haulCd);				
//				velParam.put("tromonth", tromonth);				
//				velParam.put("fromtrodate", fromtrodate);				
//				velParam.put("totrodate", totrodate);				
//				velParam.put("rfa_no", rfaNo);	
//				velParam.put("cust_cd", custCd);
//				
//				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//				DOFChgColInqmanageDBDAOSearchDODCollectionInquiryRSQL template = new DOFChgColInqmanageDBDAOSearchDODCollectionInquiryRSQL();
//				dRs = sqlExe.executeQuery(template, param, param);
//			} catch (SQLException se) {
//				log.error(se.getMessage(), se);
//				throw new DAOException(new ErrorHandler(se).getMessage());
//			} catch (DAOException de) {
//				log.error(de.getMessage(), de);
//				throw de;
//			} catch (Exception e) {
//				log.error(e.getMessage(), e);
//				throw new DAOException(e.getMessage());
//			}
//			return dRs;
//		}
//		
//		/**
//		 * searchDODCollectionPerformance 기본 조회 기능<br>
//		 * @param EsdEas0013Event event
//		 * @return DBRowSet
//		 * @throws DAOException
//		 */
//		public DBRowSet searchDODCollectionPerformance(EsdEas0013Event event) throws DAOException {
//			
//			DBRowSet dRs = null;
//			
//			try {
//				
//				DOFChgColInqmanageListVO dOFChgColInqmanageListVO = event.getDOFChgColInqmanageListVo();
//				
//				Map<String, Object> param = new HashMap<String, Object>();
//				Map<String, Object> velParam = new HashMap<String, Object>();
//				
//				String returnCy = dOFChgColInqmanageListVO.getReturnCy();
//				String selTpCd = dOFChgColInqmanageListVO.getSelTpCd();
//				String mtRtnMth = dOFChgColInqmanageListVO.getMtRtnMth();
//				String fmMtRtnPrd = dOFChgColInqmanageListVO.getFmMtRtnPrd();
//				String toMtRtnPrd = dOFChgColInqmanageListVO.getToMtRtnPrd();
//				String ctrlOfcCd = dOFChgColInqmanageListVO.getCtrlOfcCd();
//				String strRevOfcCd = "'"+ctrlOfcCd+"'";
//				strRevOfcCd = strRevOfcCd.replaceAll(",", "','");				
//				String haulCd = dOFChgColInqmanageListVO.getHaulCd();
//				String tromonth = dOFChgColInqmanageListVO.getTromonth();
//				String fromtrodate = dOFChgColInqmanageListVO.getFromtrodate();
//				String totrodate = dOFChgColInqmanageListVO.getTotrodate();
//				String rfaNo = dOFChgColInqmanageListVO.getRfaNo();
//				String custCd = dOFChgColInqmanageListVO.getCustCd();
//					
//				param.put("return_cy", returnCy);				
//				param.put("sel_tp_cd", selTpCd);				
//				param.put("mt_rtn_mth", mtRtnMth);				
//				param.put("fm_mt_rtn_prd", fmMtRtnPrd);				
//				param.put("to_mt_rtn_prd", toMtRtnPrd);				
//				//param.put("ctrl_ofc_cd", ctrlOfcCd);			
//				param.put("ctrl_ofc_cd", strRevOfcCd);		
//				param.put("haul_cd", haulCd);				
//				param.put("tromonth", tromonth);				
//				param.put("fromtrodate", fromtrodate);				
//				param.put("totrodate", totrodate);				
//				param.put("rfa_no", rfaNo);	
//				param.put("cust_cd", custCd);	
//				
//				velParam.put("return_cy", returnCy);				
//				velParam.put("sel_tp_cd", selTpCd);				
//				velParam.put("mt_rtn_mth", mtRtnMth);				
//				velParam.put("fm_mt_rtn_prd", fmMtRtnPrd);				
//				velParam.put("to_mt_rtn_prd", toMtRtnPrd);				
//				//velParam.put("ctrl_ofc_cd", ctrlOfcCd);				
//				velParam.put("ctrl_ofc_cd", strRevOfcCd);				
//				velParam.put("haul_cd", haulCd);				
//				velParam.put("tromonth", tromonth);				
//				velParam.put("fromtrodate", fromtrodate);				
//				velParam.put("totrodate", totrodate);				
//				velParam.put("rfa_no", rfaNo);	
//				velParam.put("cust_cd", custCd);
//				
//				
//				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//				DOFChgColInqmanageDBDAOSearchDODCollectionPerformanceRSQL template = new DOFChgColInqmanageDBDAOSearchDODCollectionPerformanceRSQL();
//				dRs = sqlExe.executeQuery(template, param, param);
//			} catch (SQLException se) {
//				log.error(se.getMessage(), se);
//				throw new DAOException(new ErrorHandler(se).getMessage());
//			} catch (DAOException de) {
//				log.error(de.getMessage(), de);
//				throw de;
//			} catch (Exception e) {
//				log.error(e.getMessage(), e);
//				throw new DAOException(e.getMessage());
//			}
//			return dRs;
//		}
//######################################################################################################################################	
}