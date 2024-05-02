/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DoNotificationSettingDBDAO.java
*@FileTitle : D/O notification Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-20
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-07-20 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.event.EsdTrs0290Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.vo.DoNotificationSettingListVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see DoNotificationSettingBCImpl 참조
 * @since J2EE 1.6
 */
public class DoNotificationSettingDBDAO extends DBDAOSupport {

	/**
	 * D/O Notification Setting List 조회
	 * @param event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchDoNotificationSetting(EsdTrs0290Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ctrt_tp_cd", event.getF_ctrt_tp_cd());
		param.put("sc_no", event.getF_sc_no());
		param.put("eff_dt",event.getF_eff_dt());
		param.put("dor_nod_cd",event.getF_dor_nod_cd());
		param.put("dor_nod_yd",event.getF_dor_nod_yd());
		param.put("act_flg", event.getF_act_flg());
		
		try{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DoNotificationSettingDBDAOSearchDoNotificationSettingListRSQL(), param, param);
			
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
	 * S/C No 정보 조회 - Grid Change Event
	 * @param event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchDoScNo(EsdTrs0290Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sc_no", event.getSc_no());

		try{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DoNotificationSettingDBDAOSearchDoScNoRSQL(), param, param);
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
	 *  D/O Notification Setting  데이터 저장<br>
	 * @param event
	 * @param account
	 * @throws DAOException
	 */
	public void multiDoScNo(EsdTrs0290Event event,SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;
		DoNotificationSettingListVO[] doNotificationSettingListVOs = event.getDoNotificationSettingListVOs();

		// GRID ROWS DATA
		String dup_flg = "N";
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			for(int i=0;doNotificationSettingListVOs!=null && i<doNotificationSettingListVOs.length;i++){
				if(doNotificationSettingListVOs[i].getChk().equals("1")){
					
					String do_ntfc_set_seq 	= doNotificationSettingListVOs[i].getDoNtfcSetSeq();
					String sc_no   			= doNotificationSettingListVOs[i].getScNo();
					String ctrt_tp_cd 		= doNotificationSettingListVOs[i].getCtrtTpCd();
					String act_flg 			= doNotificationSettingListVOs[i].getNtfcActFlg();
					String ctrt_cust_cd 	= doNotificationSettingListVOs[i].getCtrtCustCd();
					String ctrt_eff_dt 		= doNotificationSettingListVOs[i].getCtrtEffDt();
					String ctrt_exp_dt 		= doNotificationSettingListVOs[i].getCtrtExpDt();
					String dest_nod_cd 		= doNotificationSettingListVOs[i].getDestNodCd();
					String dest_nod_yd 		= doNotificationSettingListVOs[i].getDestNodYd();
					String do_ntfc_seq 		= "";
				
					param.put("sc_no", sc_no);
					param.put("ctrt_tp_cd",ctrt_tp_cd);
					param.put("act_flg",act_flg);
					param.put("ctrt_cust_cd",ctrt_cust_cd);
					param.put("ctrt_eff_dt",ctrt_eff_dt);
					param.put("ctrt_exp_dt",ctrt_exp_dt);
					param.put("dest_nod_cd",dest_nod_cd);
					param.put("dest_nod_yd",dest_nod_yd);
					param.put("usr_id",account.getUsr_id());
					param.put("ofc_cd",account.getOfc_cd());
					
					
					if(doNotificationSettingListVOs[i].getIbflag().equals("I")){
						dbRowset1 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DoNotificationSettingDBDAOSearchDoNoticeSetDupChkRSQL(), param, param);
						while(dbRowset1.next()){
							dup_flg =  dbRowset1.getString("DUP_FLG");
						}
						if(dup_flg.equals("N")){
							dbRowset2 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DoNotificationSettingDBDAOSearchDoNoticeSetPkRSQL(), param, param);
							while(dbRowset2.next()){
								do_ntfc_seq = dbRowset2.getString("DO_NTFC_SEQ");
							}
							param.put("do_ntfc_set_seq", do_ntfc_seq);
							new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new DoNotificationSettingDBDAOMultiDoNoticeSettingCSQL(), param, param);
							new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new DoNotificationSettingDBDAOMultiDoNoticeSettingHisCSQL(), param, param);
							
						}else{
							new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new DoNotificationSettingDBDAOMultiDoNoticeSetDupUSQL(), param, param);
//							throw new DAOException((new ErrorHandler("TRS00099",new String[]{"Same data is not allowed." })).getMessage());
						}
						
					}else if(doNotificationSettingListVOs[i].getIbflag().equals("U")){
						param.put("do_ntfc_set_seq", do_ntfc_set_seq);
						new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new DoNotificationSettingDBDAOModifyDoNoticeSettingUSQL(), param, param);
						new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new DoNotificationSettingDBDAOMultiDoNoticeSettingHisCSQL(), param, param);
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 *  D/O Notification Setting  데이터 삭제<br>
	 * @param event
	 * @param account
	 * @throws DAOException
	 */
	public void removeDoNotificationSetting(EsdTrs0290Event event,SignOnUserAccount account) throws DAOException {
		
		DoNotificationSettingListVO[] doNotificationSettingListVOs = event.getDoNotificationSettingListVOs();
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			for(int i=0;doNotificationSettingListVOs!=null && i<doNotificationSettingListVOs.length;i++){
				if((doNotificationSettingListVOs[i].getChk()).equals("1") && !(doNotificationSettingListVOs[i].getDoNtfcSetSeq()).equals("")){
					String do_ntfc_set_seq 	= doNotificationSettingListVOs[i].getDoNtfcSetSeq();
					String sc_no   			= doNotificationSettingListVOs[i].getScNo();
					String ctrt_tp_cd 		= doNotificationSettingListVOs[i].getCtrtTpCd();
					String act_flg 			= doNotificationSettingListVOs[i].getNtfcActFlg();
					String ctrt_cust_cd 	= doNotificationSettingListVOs[i].getCtrtCustCd();
					String ctrt_eff_dt 		= doNotificationSettingListVOs[i].getCtrtEffDt();
					String ctrt_exp_dt 		= doNotificationSettingListVOs[i].getCtrtExpDt();
					String dest_nod_cd 		= doNotificationSettingListVOs[i].getDestNodCd();
					String dest_nod_yd 		= doNotificationSettingListVOs[i].getDestNodYd();
					
					param.put("do_ntfc_set_seq", do_ntfc_set_seq);
					param.put("sc_no", sc_no);
					param.put("ctrt_tp_cd",ctrt_tp_cd);
					param.put("act_flg",act_flg);
					param.put("ctrt_cust_cd",ctrt_cust_cd);
					param.put("ctrt_eff_dt",ctrt_eff_dt);
					param.put("ctrt_exp_dt",ctrt_exp_dt);
					param.put("dest_nod_cd",dest_nod_cd);
					param.put("dest_nod_yd",dest_nod_yd);
					param.put("usr_id",account.getUsr_id());
					param.put("ofc_cd",account.getOfc_cd());
					param.put("delt_flg","Y");
					
					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new DoNotificationSettingDBDAOModifyDoNoticeSettingUSQL(), param, param);
					new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new DoNotificationSettingDBDAOMultiDoNoticeSettingHisCSQL(), param, param);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Grid Door Yard 변경시 Yard name 조회<br>
	 * @param event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchDorYdNm(EsdTrs0290Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dest_nod_cd", event.getDest_nod_cd());

		try{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DoNotificationSettingDBDAOSearchDorYdNmRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
	
	
}