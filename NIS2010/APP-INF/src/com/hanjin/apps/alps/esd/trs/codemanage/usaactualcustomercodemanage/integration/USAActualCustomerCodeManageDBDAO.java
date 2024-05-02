/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USAActualCustomerCodeManageDBDAO.java
*@FileTitle : USA Actual Customer Code Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-16
*@LastModifier : Kim Jun Ho
*@LastVersion : 1.0
* 2007-10-16 Kim Jun Ho
* 1.0 최초 생성
* N200905110238 2009-05-29 : Customer Named BIZ Customer Flag 생성 및 Logic 적용
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage.event.EsdTrs0082Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspUsaActCustDtlVO;
import com.hanjin.syscommon.common.table.TrsTrspUsaActCustVO;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jun Ho
 * @see usaactualcustomercodemanageBCImpl 참조
 * @since J2EE 1.4
 * History
 * 2010.09.03 최종혁 [CHM-201005753] Actual customer 'Status flag' 변경시 표기사항 일부 변경 요청
 */
public class USAActualCustomerCodeManageDBDAO extends DBDAOSupport {
	
//	private SQLExecuter sqlExe1;

	/**
	 * usaactualcustome number 조회<br>
	 * 입력될 Master key값 Select
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSAActualCustomerNo(EsdTrs0082Event event) throws DAOException {
		DBRowSet dbRowset1 = null;
//		DBRowSet dbRowset2 = null;
		DBRowSet dbRowset3 = null;
//		int insCnt[] = null;
//		List<TrsTrspUsaActCustVO> updateVoList = new ArrayList<TrsTrspUsaActCustVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("act_cust_cnt_cd", event.getAct_cust_cnt_cd());
			param.put("act_cust_bnd_cd", event.getAct_cust_bnd_cd());
			param.put("dor_nod_cd", event.getDor_nod_cd());

			//Actual Customer 등록여부 체크
			SQLExecuter sqlExe1 = new SQLExecuter("DEFAULT");
			USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCheckRSQL template1 = new USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCheckRSQL();
			dbRowset1 = sqlExe1.executeQuery(template1, param, param);
			if(dbRowset1.next()){
				throw new DAOException(new ErrorHandler("TRS50102").getMessage());
			}
			
			//Actual Customer 채번 레코드 update
			SQLExecuter sqlExe2 = new SQLExecuter("DEFAULT");
			sqlExe2.executeUpdate((ISQLTemplate)new USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoUSQL(), null, null);
			
			//Actual Customer 채번
			SQLExecuter sqlExe3 = new SQLExecuter("DEFAULT");
			USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoRSQL template3 = new USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoRSQL();
			dbRowset3 = sqlExe3.executeQuery(template3, null, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset3;
	}
	
	/**
	 * 기존 생성된 Actual Customer 여부 검사.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSAActualCustomerCheck(EsdTrs0082Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String creOfcCd = "";
		try{

			param.put("act_cust_cnt_cd", event.getAct_cust_cnt_cd());
			param.put("act_cust_bnd_cd", event.getAct_cust_bnd_cd());
			param.put("dor_nod_cd", event.getDor_nod_cd());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCheckRSQL template = new USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCheckRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

			if(dbRowset.next()){
				creOfcCd = dbRowset.getString("CRE_OFC_CD");
				throw new DAOException((new ErrorHandler("TRS00099",new String[]{"Duplication Master Data!(Duplication Office: "+creOfcCd+")"})).getMessage());
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
	 * Actual Customer Name 조회.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSAActualCustomerName(EsdTrs0082Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("act_cust_cnt_cd", event.getAct_cust_cnt_cd());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNameRSQL template = new USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNameRSQL();
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
	 * usaactualcustomercodemanage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSAActualCustomerCodeExcel(EsdTrs0082Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			String cre_ofc_cd = event.getInput_cre_ofc_cd();

			List<String> ofcCd = new ArrayList();
			ofcCd  = this.seperationParameter(cre_ofc_cd, ","); 

			param.put("status", event.getStatus().toString());
			param.put("bound", event.getBound().toString());
			param.put("dor_nod", event.getDor_loc().toString() + event.getDor_nod().toString());
			param.put("input_cust_cd", event.getInput_cust_cd().toString());
			param.put("input_cust_nm", event.getInput_cust_nm().toString());
			param.put("input_cre_ofc_cd", event.getInput_cre_ofc_cd().toString());

			param.put("OfcCd", ofcCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCodeExcelRSQL template = new USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCodeExcelRSQL();
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
	 * usaactualcustomercodemanage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSAActualCustomerCodeManageList(EsdTrs0082Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			String cre_ofc_cd = event.getInput_cre_ofc_cd();

			List<String> ofcCd = new ArrayList();
			ofcCd  = this.seperationParameter(cre_ofc_cd, ","); 

			param.put("status", event.getStatus().toString());
			param.put("bound", event.getBound().toString());
			param.put("dor_nod", event.getDor_loc().toString() + event.getDor_nod().toString());
			param.put("input_cust_cd", event.getInput_cust_cd().toString());
			param.put("input_cust_nm", event.getInput_cust_nm().toString());
			param.put("input_cre_ofc_cd", event.getInput_cre_ofc_cd().toString());

			param.put("OfcCd", ofcCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCodeManageListRSQL template = new USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCodeManageListRSQL();
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
	 * usaactualcustomercodemanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchUSAActualCustomerCodeManage(EsdTrs0082Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("trsp_act_cust_no", event.getSel_trsp_act_cust_no());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			USAActualCustomerCodeManageDBDAOSearchActualCustomerCodeManageRSQL template = new USAActualCustomerCodeManageDBDAOSearchActualCustomerCodeManageRSQL();
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
	 * usaactualcustomercodemanage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiUSAActualCustomerCodeManageList(EsdTrs0082Event event) throws DAOException {
		try {
			TrsTrspUsaActCustVO[] trsTrspUsaActCustVOS = event.getTrsTrspUsaActCustVOs();
			List<TrsTrspUsaActCustVO> mSTVoList = new ArrayList<TrsTrspUsaActCustVO>();
			TrsTrspUsaActCustDtlVO[] trsTrspUsaActCustDtlVOS = event.getTrsTrspUsaActCustDtlVOs();
			List<TrsTrspUsaActCustDtlVO> mSTDtlVoList = new ArrayList<TrsTrspUsaActCustDtlVO>();

			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			String mstDtlIndicator = event.getMST_DTL_INDICATOR();
			String login_usr_id = event.getLogin_usr_id();
//			String cre_ofc_cd   = event.getLogin_ofc_cd();

			if("MST".equals(mstDtlIndicator)){
				for ( int i=0; i<trsTrspUsaActCustVOS.length; i++ ) {
					trsTrspUsaActCustVOS[i].setCreUsrId(login_usr_id);
					trsTrspUsaActCustVOS[i].setUpdUsrId(login_usr_id);
					
					mSTVoList.add(trsTrspUsaActCustVOS[i]);
				}

				insCnt = sqlExe.executeBatch((ISQLTemplate)new USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListMasterCSQL(), mSTVoList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}else if("DTL".equals(mstDtlIndicator)){
				for ( int i=0; i<trsTrspUsaActCustDtlVOS.length; i++ ) {
//					trsTrspUsaActCustDtlVOS[i].setCreUsrId(login_usr_id);
					trsTrspUsaActCustDtlVOS[i].setUpdUsrId(login_usr_id);
//					trsTrspUsaActCustDtlVOS[i].setDeltUsrId(login_usr_id);
//					trsTrspUsaActCustDtlVOS[i].setCreOfcCd(cre_ofc_cd);
//					trsTrspUsaActCustDtlVOS[i].setDeltOfcCd(cre_ofc_cd);

					mSTDtlVoList.add(trsTrspUsaActCustDtlVOS[i]);
				}

				insCnt = sqlExe.executeBatch((ISQLTemplate)new USAActualCustomerCodeManageDBDAOActualCustomerCodeManageListDetailCSQL(), mSTDtlVoList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

}
