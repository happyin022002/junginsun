/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAR_MST_REV_VVDDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ArMstRevVvdVO;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see
 * @since J2EE 1.4
 */
public class ReceiveQueueArMstRevVvdDBDAO extends DBDAOSupport{

	/**
	 * insert
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void addArMstRevVvd(Object o) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ArMstRevVvdVO model = (ArMstRevVvdVO)o; 
			
			String revYrmon = model.getRevYrmon();
			String revOoDt = null;
			String revImDt = null;
			String revIeDt = null;
			String revIaDt = null;
			
			int idx = 0;
			StringTokenizer st = new StringTokenizer(revYrmon, "|");
			
			while(st.hasMoreTokens()){
				if(idx==0) revOoDt = (String)st.nextToken();
				if(idx==1) revImDt = (String)st.nextToken();
				if(idx==2) revIeDt = (String)st.nextToken();
				if(idx==3) revIaDt = (String)st.nextToken();
				idx++;
			}
			
			param.put("vsl_cd"		, model.getVslCd());
			param.put("skd_voy_no"	, model.getSkdVoyNo());
			param.put("skd_dir_cd"	, model.getSkdDirCd());
			param.put("rlane_dir_cd", model.getRlaneDirCd());
			param.put("voy_tp_cd"	, model.getVoyTpCd());
			param.put("slan_cd"		, model.getSlanCd());
			param.put("rlane_cd"	, model.getRlaneCd());
			param.put("port_chk_flg", model.getPortChkFlg());
			param.put("lod_qty"		, model.getLodQty());
			param.put("com_vvd_flg"	, model.getComVvdFlg());
			param.put("vvd_com_lvl"	, model.getVvdComLvl());
			param.put("rev_port_cd"	, model.getRevPortCd());
			param.put("delt_flg"	, model.getDeltFlg());	
			
			param.put("rev_oo_dt"	, revOoDt);
			param.put("rev_im_dt"	, revImDt);
			param.put("rev_ie_dt"	, revIeDt);
			param.put("rev_ia_dt"	, revIaDt);
			param.put("cre_usr_id"	, model.getCreUsrId());
			param.put("cre_dt"		, model.getCreDt());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			
			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueArMstRevVvdDBDAOAddArMstRevVvdCSQL(), param, param);
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
	 * update
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void modifyArMstRevVvd(Object o) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ArMstRevVvdVO model = (ArMstRevVvdVO)o; 
			
			String revYrmon = model.getRevYrmon();
			String revOoDt = "";
			String revImDt = "";
			String revIeDt = "";
			String revIaDt = "";
			
			int idx = 0;
			StringTokenizer st = new StringTokenizer(revYrmon, "|");
			
			while(st.hasMoreTokens()){
				if(idx==0) revOoDt = (String)st.nextToken();
				if(idx==1) revImDt = (String)st.nextToken();
				if(idx==2) revIeDt = (String)st.nextToken();
				if(idx==3) revIaDt = (String)st.nextToken();
				idx++;
			}
			
			param.put("voy_tp_cd"	, model.getVoyTpCd());
			param.put("slan_cd"		, model.getSlanCd());
			param.put("rlane_cd"	, model.getRlaneCd());
			param.put("port_chk_flg", model.getPortChkFlg());
			param.put("lod_qty"		, model.getLodQty());
			param.put("com_vvd_flg"	, model.getComVvdFlg());
			param.put("vvd_com_lvl"	, model.getVvdComLvl());
			param.put("rev_port_cd"	, model.getRevPortCd());
			param.put("delt_flg"	, model.getDeltFlg());	
			param.put("rev_oo_dt"	, revOoDt);
			param.put("rev_im_dt"	, revImDt);
			param.put("rev_ie_dt"	, revIeDt);
			param.put("rev_ia_dt"	, revIaDt);
			param.put("cre_usr_id"	, model.getCreUsrId());
			param.put("cre_dt"		, model.getCreDt());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			param.put("vsl_cd"		, model.getVslCd());
			param.put("skd_voy_no"	, model.getSkdVoyNo());
			param.put("skd_dir_cd"	, model.getSkdDirCd());
			param.put("rlane_dir_cd", model.getRlaneDirCd());
			
			int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueArMstRevVvdDBDAOModifyArMstRevVvdUSQL(), param, param);
			if(updCnt == Statement.EXECUTE_FAILED){
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
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @param pk1, pk2, pk3, pk4
	 * @return
	 * @throws DAOException
	 */
	public boolean searchArMstRevVvdList(String pk1, String pk2, String pk3, String pk4) throws DAOException{
		
		boolean isSuccessful = false; 
		DBRowSet dRs = null;
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("vsl_cd"		, pk1);
			param.put("skd_voy_no"	, pk2);
			param.put("skd_dir_cd"	, pk3);
			param.put("rlane_dir_cd", pk4);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueArMstRevVvdDBDAOSearchArMstRevVvdListRSQL(), param, param);
			
			if(dRs.getRowCount() <= 0){
				isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
			
		return isSuccessful;	
	}

	/**
	 * delete
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void removeArMstRevVvd(Object o) throws DAOException{
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ArMstRevVvdVO model = (ArMstRevVvdVO)o; 
			
			param.put("vsl_cd"		, model.getVslCd());
			param.put("skd_voy_no"	, model.getSkdVoyNo());
			param.put("skd_dir_cd"	, model.getSkdDirCd());
			param.put("rlane_dir_cd", model.getRlaneDirCd());
//			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			
			int delCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueArMstRevVvdDBDAORemoveArMstRevVvdUSQL(), param, param);
			if(delCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to delete SQL");
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

}