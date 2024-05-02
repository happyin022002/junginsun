/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractNoticeMailSendDBDAO.java
*@FileTitle : ContractNoticeMailSendDBDAO.java
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-24
*@LastModifier : 
*@LastVersion : 1.0
* 2014-01-24
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.agreementnoticemail.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.agreementnotice.basic.AgreementNoticeBCImpl;
import com.hanjin.bizcommon.agreementnoticemail.vo.ComCtrtUsrMgmtInfoVO;
import com.hanjin.bizcommon.agreementnoticemail.vo.CtntInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - ALPS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see AgreementNoticeBCImpl 참조
 * @since J2EE 1.4
 */
public class ContractNoticeMailSendDBDAO extends DBDAOSupport {
	
	/**
	 * Contract Notice mail Receiver 조회<br>
	 * 
	 * @return  List<ComCtrtUsrMgmtVO>
	 * @exception DAOException
	 */
	public List<ComCtrtUsrMgmtInfoVO> searchNoticeMailReceiver() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<ComCtrtUsrMgmtInfoVO> rtnVoList = new ArrayList<ComCtrtUsrMgmtInfoVO> ();
//		java.util.ArrayList<String> arr_usr_id_list = new java.util.ArrayList<String>();
//		String svr_usr_max_knt = null;
		
		try{
//    		svr_usr_max_knt = JSPUtil.getNull(new AgreementNoticeUtil().searchUsrMaxKnt());
//    		log.error("\n ContractNoticeMailSendDBDAO -searchNoticeMailReceiver svr_usr_max_knt => svr : " + svr_usr_max_knt + "<<<<<<<<");
//    		if (svr_usr_max_knt==null || svr_usr_max_knt.trim().equals("")){
//    			throw new Exception("[err] usr_max_knt exception!");
//    		}
//    		int usr_max_knt = Integer.parseInt(svr_usr_max_knt);
//			for (int i=1; i<=usr_max_knt; i++){
//				arr_usr_id_list.add(",A.NTC_USR_ID"+Integer.toString(i)+", (SELECT USR_EML FROM COM_USER WHERE USR_ID = A.NTC_USR_ID"+Integer.toString(i)+" AND USE_FLG = 'Y') NTC_USR_EML"+Integer.toString(i)+"");
//			}
//			velParam.put("arr_usr_id_list", arr_usr_id_list);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContractNoticeMailSendDBDAOSearchNoticeMailReceiverRSQL(), param, velParam);
			rtnVoList = (List) RowSetUtil.rowSetToVOs(dbRowset, ComCtrtUsrMgmtInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnVoList;
	}
   
	/**
	 * Mail Contents 조회<br>
	 * @param emlRcvUsr
	 * @return List<CtntInfoVO>
	 * @exception DAOException
	 */
	public List<CtntInfoVO> searchMailContents(ComCtrtUsrMgmtInfoVO emlRcvUsr) throws DAOException {
		DBRowSet dbRowset = null;
		List<CtntInfoVO> rtnVoList = new ArrayList<CtntInfoVO> ();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("sys_cd", emlRcvUsr.getSysCd());
		param.put("ctrt_ofc_cd", emlRcvUsr.getCtrtOfcCd());
		param.put("ofc_tp_cd", emlRcvUsr.getOfcTpCd());
		param.put("agmt_no", emlRcvUsr.getAgmtNo());
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContractNoticeMailSendDBDAOSearchMailContentsInfoRSQL(), param, param);
			rtnVoList = (List) RowSetUtil.rowSetToVOs(dbRowset, CtntInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnVoList;
	}

	/**
	 * Contract Notice CC User e-maill address조회<br>
	 * @param emlRcvUsr
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCCReceiverInfo(ComCtrtUsrMgmtInfoVO emlRcvUsr) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("sys_cd", emlRcvUsr.getSysCd());
		param.put("ctrt_ofc_cd", emlRcvUsr.getCtrtOfcCd());
		param.put("ofc_tp_cd", emlRcvUsr.getOfcTpCd());
		param.put("agmt_no", emlRcvUsr.getAgmtNo());
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContractNoticeMailSendDBDAOSearchCCReceiverInfoRSQL(), param, param);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return dbRowset;
	}
	
	/**
	 * Contract Notice 건수 조회<br>
	 * @param emlRcvUsr
	 * @return int
	 * @exception DAOException
	 */
	public int searchContractCount(ComCtrtUsrMgmtInfoVO emlRcvUsr) throws DAOException {
		DBRowSet dbRowset = null;
		int ctrt_cnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("sys_cd", emlRcvUsr.getSysCd());
		param.put("ctrt_ofc_cd", emlRcvUsr.getCtrtOfcCd());
		param.put("ofc_tp_cd", emlRcvUsr.getOfcTpCd());
		param.put("agmt_no", emlRcvUsr.getAgmtNo());
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContractNoticeMailSendDBDAOSearchContractCountRSQL(), param, param);
			while(dbRowset.next()){
				ctrt_cnt = dbRowset.getInt("CTRT_CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ctrt_cnt;
	}
	

}