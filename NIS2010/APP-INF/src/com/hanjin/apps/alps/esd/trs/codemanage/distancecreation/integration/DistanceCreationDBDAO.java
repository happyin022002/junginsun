/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DistanceCreationDBDAO.java
*@FileTitle : Distance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.31 juhyun
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.17 최 선  1.1 [] SAVE시, Distance 중복 등록  현상 처리
* 2011.12.09 민정호 1.2 [CLT-111121293] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.basic.DistanceCreationBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.event.EsdTrs0080Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsAgmtDistVO;


/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author juhyun
 * @see DistanceCreationBCImpl 참조
 * @since J2EE 1.4
 */
public class DistanceCreationDBDAO extends DBDAOSupport {

	/**
	 * DistanceCreation의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchDistanceCreation(EsdTrs0080Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();


		String frm_node = event.getHidFrmNode();
		String to_node = event.getHidToNode();
		String frm_zip = event.getFrmZip();
		String to_zip = event.getToZip();

		
		param.put("hid_frm_node", frm_node);
		param.put("hid_to_node", to_node);
		param.put("frm_node", frm_node);
		param.put("to_node", to_node);
		param.put("frm_zip", frm_zip);
		param.put("to_zip", to_zip);
		//param.put("strAr", strAr);
		
		try {
			dRs = new SQLExecuter().executeQuery(new DistanceCreationDBDAOsearchDistanceCreationRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	   }

	
	/**
	 * DistanceCreation의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchDistanceHistory(EsdTrs0080Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		String frm_node = event.getOpnerFromNode();
		String to_node 	= event.getOpnerToNode();
		String frm_zip 	= event.getOpnerFromZipCode();
		String to_zip 	= event.getOpnerToZipCode();
		
		param.put("frm_node", frm_node);
		param.put("to_node", to_node);
		param.put("frm_zip", frm_zip);
		param.put("to_zip", to_zip);
		try {
			dRs = new SQLExecuter().executeQuery(new DistanceCreationDBDAOsearchDistanceHistoryRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	   }		
		
	
	
	/**
	 * DistanceCreation의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchDistanceCreationDuple(EsdTrs0080Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String fm_nod_cd = "";
		String to_nod_cd = "";
		
		TrsAgmtDistVO[] trsAgmtDistVOs = event.getTrsAgmtDistVOs();
		if(trsAgmtDistVOs == null || trsAgmtDistVOs.length == 0){
			return null;
		}
		
		// 실제로는 하나의 데이터만 들어옴. 
		for(int i=0; i<trsAgmtDistVOs.length; i++){
			fm_nod_cd = trsAgmtDistVOs[i].getFmNodCd() + trsAgmtDistVOs[i].getFmNodCdSub();
			to_nod_cd = trsAgmtDistVOs[i].getToNodCd() + trsAgmtDistVOs[i].getToNodCdSub();
		
			param.put("fm_nod_cd", fm_nod_cd);
			param.put("to_nod_cd", to_nod_cd);
		}
			
		try {
			dRs = new SQLExecuter().executeQuery(new DistanceCreationDBDAOsearchDistanceCreationDupleRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	   }		
	

	/**
	 * USALastCityManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param event 
	 * @see EsdTrs076Event
	 * @throws DAOException
	 */
	public void multiTRS_AGMT_DIST(EsdTrs0080Event event) throws DAOException {

//		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		TrsAgmtDistVO [] trsAgmtDistVOs = event.getTrsAgmtDistVOs();
//		TrsAgmtDistHisVO [] trsAgmtDistHisVOs = event.getTrsAgmtDistHisVOs();
		
		
		String ofc_cd = event.getOfcCd();
		String hid_cre_usr_id = event.getHidCreUsrId();
		String hid_cre_date = event.getHidCreDate();
		String hid_upd_usr_id = event.getHidUpdUsrId();
		String hid_upd_date = event.getHidUpdDate();	
		
//		boolean isInsert = false ;
//		boolean isInsert2 = false ;
//		boolean isUpdate = false ;
//		boolean isDelete = false ;

		
//		int returnInsertInt = 0;
//		int returnInsert2Int = 0;
		try {
			for(int f=0; trsAgmtDistVOs != null && f < trsAgmtDistVOs.length; f++){
				if (trsAgmtDistVOs[f].getIbflag().length() > 0) {

					if (trsAgmtDistVOs[f].getIbflag().equals("I")) {
			
						param.put("fm_nod_cd", trsAgmtDistVOs[f].getFmNodCd()+ trsAgmtDistVOs[f].getFmNodCdSub());//+model2.getFm_nod_cd_sub());                 //fm_nod_cd    
						param.put("to_nod_cd", trsAgmtDistVOs[f].getToNodCd()+ trsAgmtDistVOs[f].getToNodCdSub());
						param.put("dist_meas_ut_cd", trsAgmtDistVOs[f].getDistMeasUtCd());            //dist_meas_ut_cd
						param.put("bzc_dist", trsAgmtDistVOs[f].getBzcDist());                   //bzc_dist
						param.put("conv_meas_ut_cd", trsAgmtDistVOs[f].getConvMeasUtCd());            //conv_meas_ut_cd
						param.put("conv_dist", trsAgmtDistVOs[f].getConvDist());                  //conv_dist
						param.put("fm_nod_zip_cd_ctnt", trsAgmtDistVOs[f].getFmNodZipCdCtnt());         //fm_nod_zip_cd_ctnt
						param.put("to_nod_zip_cd_ctnt", trsAgmtDistVOs[f].getToNodZipCdCtnt());         //to_nod_zip_cd_ctnt
						param.put("cre_ofc_cd", ofc_cd);                 //cre_ofc_cd
						param.put("cre_usr_id", hid_cre_usr_id);                     //cre_usr_id
						param.put("cre_dt", hid_cre_date);                 // cre_dt
						
						new SQLExecuter().executeUpdate(new DistanceCreationDBDAOmultiTrsAgmtDistCSQL(), param, param);
						new SQLExecuter().executeUpdate(new DistanceCreationDBDAOmultiTrsAgmtDistHisInsertCSQL(), param, param);				
					
					} else if (trsAgmtDistVOs[f].getIbflag().equals("U")) {
						param.put("dist_meas_ut_cd", trsAgmtDistVOs[f].getDistMeasUtCd());            //dist_meas_ut_cd
						param.put("bzc_dist", trsAgmtDistVOs[f].getBzcDist());                   //bzc_dist
						param.put("conv_meas_ut_cd", trsAgmtDistVOs[f].getConvMeasUtCd());            //conv_meas_ut_cd
						param.put("conv_dist", trsAgmtDistVOs[f].getConvDist());                  //conv_dist
						param.put("fm_nod_zip_cd_ctnt", trsAgmtDistVOs[f].getFmNodZipCdCtnt());         //fm_nod_zip_cd_ctnt
						param.put("to_nod_zip_cd_ctnt", trsAgmtDistVOs[f].getToNodZipCdCtnt());         //to_nod_zip_cd_ctnt
						param.put("upd_dt", hid_upd_date );                     //upd_dt
						param.put("upd_usr_id",hid_upd_usr_id);                 //upd_usr_id
						param.put("fm_nod_cd", trsAgmtDistVOs[f].getFmNodCd()+ trsAgmtDistVOs[f].getFmNodCdSub());//+model2.getFm_nod_cd_sub());                 //fm_nod_cd    
						param.put("to_nod_cd", trsAgmtDistVOs[f].getToNodCd()+ trsAgmtDistVOs[f].getToNodCdSub());
								
						new SQLExecuter().executeUpdate(new DistanceCreationDBDAOmultiTrsAgmtDistUSQL(), param, param);
					
					} else	if (trsAgmtDistVOs[f].getIbflag().equals("D")) {
						param.put("fm_nod_cd", trsAgmtDistVOs[f].getFmNodCd()+ trsAgmtDistVOs[f].getFmNodCdSub());//+model2.getFm_nod_cd_sub());                 //fm_nod_cd    
						param.put("to_nod_cd", trsAgmtDistVOs[f].getToNodCd()+ trsAgmtDistVOs[f].getToNodCdSub());
	
						new SQLExecuter().executeUpdate(new DistanceCreationDBDAOmultiTrsAgmtDistDeleteUSQL(), param, param);
					}				
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}	
	}
	
	
	/**
	 * USALastCityManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param event 
	 * @see EsdTrs076Event
	 * @throws DAOException
	 */
	public void multiTRS_AGMT_DIST_HIS(EsdTrs0080Event event) throws DAOException {

//		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		TrsAgmtDistVO [] trsAgmtDistVOs = event.getTrsAgmtDistVOs();
//		TrsAgmtDistHisVO [] trsAgmtDistHisVOs = event.getTrsAgmtDistHisVOs();
		
		
		String ofc_cd = event.getOfcCd();
		String hid_cre_usr_id = event.getHidCreUsrId();
		String hid_cre_date = event.getHidCreDate();
//		String hid_upd_usr_id = event.getHidUpdUsrId();
//		String hid_upd_date = event.getHidUpdDate();		
		
		try {
		
			for(int f=0; trsAgmtDistVOs != null && f < trsAgmtDistVOs.length; f++){
			
//				int i = 1;
//				int j = 1;
				if (trsAgmtDistVOs[f].getIbflag().length() > 0) {
					
					param.put("fm_nod_cd", trsAgmtDistVOs[f].getFmNodCd()+ trsAgmtDistVOs[f].getFmNodCdSub());//+model2.getFm_nod_cd_sub());                 //fm_nod_cd    
					param.put("to_nod_cd", trsAgmtDistVOs[f].getToNodCd()+ trsAgmtDistVOs[f].getToNodCdSub());
					param.put("dist_meas_ut_cd", trsAgmtDistVOs[f].getDistMeasUtCd());            //dist_meas_ut_cd
					param.put("bzc_dist", trsAgmtDistVOs[f].getBzcDist());                   //bzc_dist
					param.put("conv_meas_ut_cd", trsAgmtDistVOs[f].getConvMeasUtCd());            //conv_meas_ut_cd
					param.put("conv_dist", trsAgmtDistVOs[f].getConvDist());                  //conv_dist
					param.put("fm_nod_zip_cd_ctnt", trsAgmtDistVOs[f].getFmNodZipCdCtnt());         //fm_nod_zip_cd_ctnt
					param.put("to_nod_zip_cd_ctnt", trsAgmtDistVOs[f].getToNodZipCdCtnt());         //to_nod_zip_cd_ctnt
					param.put("cre_ofc_cd", ofc_cd);                 //cre_ofc_cd
					param.put("cre_usr_id", hid_cre_usr_id);                     //cre_usr_id
					param.put("cre_dt", hid_cre_date);                 // cre_dt
	
					new SQLExecuter().executeUpdate(new DistanceCreationDBDAOmultiTrsAgmtDistHisCSQL(), param,param);
					}

				}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}		
		
	/**
	 * USALastCityManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param event 
	 * @see EsdTrs076Event
	 * @throws DAOException
	 */
	public void multiDistanceDelete(EsdTrs0080Event event) throws DAOException {

//		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		TrsAgmtDistVO [] trsAgmtDistVOs = event.getTrsAgmtDistVOs();
//		TrsAgmtDistHisVO [] trsAgmtDistHisVOs = event.getTrsAgmtDistHisVOs();
		
		
		String ofc_cd = event.getOfcCd();
		String hid_cre_usr_id = event.getHidCreUsrId();
		String hid_cre_date = event.getHidCreDate();
//		String hid_upd_usr_id = event.getHidUpdUsrId();
//		String hid_upd_date = event.getHidUpdDate();
		String del_gubun = event.getDelGubun();
		
		
		
		// 수행 결과가 정상인지를 판별하기 위한 변수

		try {
			for(int f=0; trsAgmtDistVOs != null && f < trsAgmtDistVOs.length; f++){

//				int i = 1;
//				int j = 1;
				if (trsAgmtDistVOs[f].getIbflag().length() > 0) {				
				
				param.put("fm_nod_cd", trsAgmtDistVOs[f].getFmNodCd()+ trsAgmtDistVOs[f].getFmNodCdSub());//+model2.getFm_nod_cd_sub());                 //fm_nod_cd    
				param.put("to_nod_cd", trsAgmtDistVOs[f].getToNodCd()+ trsAgmtDistVOs[f].getToNodCdSub());
				param.put("dist_meas_ut_cd", trsAgmtDistVOs[f].getDistMeasUtCd());            //dist_meas_ut_cd
				param.put("bzc_dist", trsAgmtDistVOs[f].getBzcDist());                   //bzc_dist
				param.put("conv_meas_ut_cd", trsAgmtDistVOs[f].getConvMeasUtCd());            //conv_meas_ut_cd
				param.put("conv_dist", trsAgmtDistVOs[f].getConvDist());                  //conv_dist
				param.put("fm_nod_zip_cd_ctnt", trsAgmtDistVOs[f].getFmNodZipCdCtnt());         //fm_nod_zip_cd_ctnt
				param.put("to_nod_zip_cd_ctnt", trsAgmtDistVOs[f].getToNodZipCdCtnt());         //to_nod_zip_cd_ctnt
				param.put("cre_ofc_cd", ofc_cd);                 //cre_ofc_cd
				param.put("cre_usr_id",hid_cre_usr_id);                     //cre_usr_id
				param.put("cre_dt",hid_cre_date);                 // cre_dt
				param.put("del_gubun",del_gubun);                 // cre_dt
				}
			
			
			}

			new SQLExecuter().executeUpdate(new DistanceCreationDBDAOmultiDistanceDeleteUSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	   }
}