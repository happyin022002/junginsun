/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeManageDBDAO.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-07 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.codemanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.basic.CodeManageBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.TesLgsCostVO;


/**
 * ENIS-ESD에 대한 DB 처리를 담당<br>
 * - ENIS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author jongbaemoon
 * @see CodeManageBCImpl 참조
 * @since J2EE 1.4
 */
public class CodeManageDBDAO extends DBDAOSupport {

//	/// Signoned User Account Info
//	private SignOnUserAccount account = null;
//	public void setSignOnUserAccount(SignOnUserAccount account) {
//		this.account = account;
//	}

	/**
	 * searchAcctCodeList 값을 불러온다.<br>
	 *
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAcctCodeList() throws DAOException {
		DBRowSet	dbRowset		= null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchAcctCodeListRSQL(), null, null);
		
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
	 * checkCostCode Cost code 해당되는 값을 불러온다.<br>
	 *
	 * @param String lgsCostCd
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet checkCostCode(String lgsCostCd) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( lgsCostCd == null ) {
				lgsCostCd = "";
			}
			
			param.put( "lgs_cost_cd", lgsCostCd );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOCheckCostCodeRSQL(), param, velParam);

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
	 * CodeManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostCode(TesLgsCostVO model) throws DAOException {
		DBRowSet	dbRowset		= null;
		
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchCostCodeRSQL(), param, velParam);
		
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
	 * Cost Code subj code 해당되는 값을 불러온다.<br>
	 *
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCodescListSubj() throws DAOException {
		
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchCodescListSubjRSQL(), null, null);
		
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
	 * CodeManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param lgsCostSubjCd
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCodescListDtl( String lgsCostSubjCd ) throws DAOException {
		
		log.debug("\n==========CodeManageDBDAO   searchCodescListDtl()  "+lgsCostSubjCd+"============");
		
		DBRowSet			dbRowset	= null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			//query parameter
			param.put("lgs_cost_subj_cd", lgsCostSubjCd);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchCodescListDtlRSQL(), param, null);
		
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
	 * CodeManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param lgsCostSubjCd
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostcdDetail( String lgsCostSubjCd ) throws DAOException {
		
		log.debug("\n==========CodeManageDBDAO   searchCodescListDtl()  "+lgsCostSubjCd+"============");
		
		DBRowSet			dbRowset	= null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			//query parameter
			param.put("lgs_cost_subj_cd", lgsCostSubjCd);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchCostcdDetailRSQL(), param, null);
			
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
	 * searchCostCodeInfo 해당되는 값을 불러온다.<br>
	 *
	 * @param model TesLgsCostVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostCodeInfo(TesLgsCostVO model) throws DAOException {
		
		DBRowSet dbRowset = null;
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchCostCodeInfoRSQL(), param, velParam);
		
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

	/** checkCostCodeOPTNO
	 * 
	 * @param lgsCostOptNo
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet checkCostCodeOPTNO(String lgsCostOptNo) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( lgsCostOptNo == null ) {
				lgsCostOptNo = "";
			}
			
			param.put( "lgs_cost_opt_no", lgsCostOptNo );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOCheckCostCodeOPTNORSQL(), param, velParam);

            if (dbRowset != null && dbRowset.next() ) {
//            	throw new DAOException(new ErrorHandler("USR", "E:동일한 Output Seq.가 존재합니다.").getMessage());
            	throw new DAOException(new ErrorHandler("TES00074").getMessage());
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

		return dbRowset;
	}


	/**
	 * user id/pw  값을 체크 불러온다.<br>
	 *
	 * @param  ComUserVO comUserVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet checkMandatory(ComUserVO comUserVO) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( !"".equals( comUserVO.getUsrId() ) ) {
				param.put( "usr_id", comUserVO.getUsrId() );
			}

			if ( !"".equals( comUserVO.getUsrPwd() ) ) {
				param.put( "usr_pwd", comUserVO.getUsrPwd() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOCheckMandatoryRSQL(), param, velParam);

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
	 * user id/pw  값을 체크 불러온다.<br>
	 *
	 * @param  ComUserVO comUserVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet checkAgreementPassWord(ComUserVO comUserVO) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( !"".equals( comUserVO.getUsrId() ) ) {
				param.put( "usr_id", comUserVO.getUsrId() );
			}

			if ( !"".equals( comUserVO.getUsrPwd() ) ) {
				param.put( "usr_pwd", comUserVO.getUsrPwd() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOCheckAgreementPassWordRSQL(), param, velParam);

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
	 * CodeManage의 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제<br>
	 *
	 * @param model 데이타 모델
	 * @exception DAOException
	 */
	
	public void createCostCode(TesLgsCostVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CodeManageDBDAOCreateCostCodeCSQL(), param, null);
			
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
	 * CodeManage 수정
	 * 
	 * @param TesLgsCostVO model
	 * @exception DAOException
	 */
	public void modifyCostCode(TesLgsCostVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
//			int insCnt = 
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CodeManageDBDAOModifyCostCodeUSQL(), param, param);
			
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
	 * CodeManage의 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제<br>
	 *
	 * @param model 데이타 모델
	 * @exception DAOException
	 */
	public void modifyCostCodeDelete(TesLgsCostVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
//			int insCnt = 
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CodeManageDBDAOModifyCostCodeDeleteUSQL(), param, null);
			
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
	
	
//	// 이건 어디서 쓰는거야..?? 찾아보고 지워버려.
//	/**
//	 * @param model
//	 * @throws DAOException
//	 */
//	public void modifyCostCodeDelete(TES_LGS_COST model) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement deletePs  = null;
//		StringBuffer deleteQuery = new StringBuffer();
//		// UPDATE, DELETE 결과가 정상인지를 판별하기 위한 변수
//		long resultCount = 0;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//
//		deleteQuery.append(" UPDATE TES_LGS_COST SET                                               \n");
//		deleteQuery.append("    delt_flg            ='Y'                                           \n");
//		deleteQuery.append(" WHERE lgs_cost_cd = ?                                                 \n") ;
//
//		try {
//			con = getConnection();
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				deletePs = new LoggableStatement(con, deleteQuery.toString());
//			} else {
//				deletePs = con.prepareStatement(deleteQuery.toString());
//			}
//
//			// 쿼리에 변수 세팅.
//
//			deletePs.setString(i++, model.getLgs_cost_cd());                //lgs_cost_cd
//
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :" + deleteQuery );
//			}
//
//			resultCount = deletePs.executeUpdate();
//			if (resultCount < 1) {
//				// 데이터 삭제에 실패하였습니다.
//				throw new DAOException(new ErrorHandler("TES00063").getMessage());
//			}
//
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
//		} finally {
//			closeStatement(deletePs);
//			closeConnection(con);
//		}
//	}

    /**
     * CodeManage의 모든 목록을 가져온다.<br>
     *
     * @return DBRowSet DB 처리 결과
     * @exception DAOException
     */
    public DBRowSet searchCarrierCode() throws DAOException {
    	
		DBRowSet dbRowset = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeManageDBDAOSearchCarrierCodeRSQL(), null, null);
		
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

//    /**
//     * CodeManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
//     *
//     * @param models 여러 데이타 모델
//     * @see ESD_TES_031Event
//     * @exception DAOException
//     */
//    public void multiCarrierCode(Collection models, String ofc_cd) throws DAOException {
//        // Connection Interface
//        Connection con = null;
//        // INSERT를 수행하기 위한 SQL Statement
//        PreparedStatement insertPs  = null;
//        // UPDATE를 수행하기 위한 SQL Statement
//        //PreparedStatement updatePs = null;
//        // DELETE를 수행하기 위한 SQL Statement
//        PreparedStatement deletePs = null;
//
//		StringBuffer insertQuery = new StringBuffer();
//		//StringBuffer updateQuery = new StringBuffer();
//		StringBuffer deleteQuery = new StringBuffer();
//        // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//        int i = 1;
//
//        boolean isInsert = false ;
//        //boolean isUpdate = false ;
//        boolean isDelete = false ;
//
//		//입력
//        insertQuery.append("/* " + this.getClass().getName() + " - multiCarrierCode() */ \n");
//        insertQuery.append("insert into TES_TML_SO_CRR (tml_crr_cd, crr_desc, cre_usr_id, cre_dt, upd_usr_id, upd_dt, delt_flg) \n");
//        insertQuery.append("values (?, ?, ?, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?), ?, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?), ?) \n");
//
//
//		//수정
//        //updateQuery.append("/* " + this.getClass().getName() + " - multiCarrierCode() */\n");
//		//updateQuery.append("update TES_TML_SO_CRR \n");
//		//updateQuery.append("set crr_desc=?, upd_usr_id=?, upd_dt=sysdate \n");
//		//updateQuery.append("where tml_crr_cd = ? \n");
//
//		//삭제
//		deleteQuery.append("/* " + this.getClass().getName() + " - multiCarrierCode() */ \n");
//		deleteQuery.append("update TES_TML_SO_CRR \n");
//		deleteQuery.append("set delt_flg=?, upd_usr_id=?, upd_dt=GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?) \n");
//		deleteQuery.append("where tml_crr_cd = ? \n");
//
//
//        try {
//            con = getConnection();
//
//            // Loggable Statement 사용에 의해 추가
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                insertPs = new LoggableStatement(con, insertQuery.toString());
//                //updatePs = new LoggableStatement(con, updateQuery.toString());
//                deletePs = new LoggableStatement(con, deleteQuery.toString());
//            } else {
//                insertPs = con.prepareStatement(insertQuery.toString());
//                //updatePs = con.prepareStatement(updateQuery.toString());
//                deletePs = con.prepareStatement(deleteQuery.toString());
//            }
//
//            Iterator itr = models.iterator();
//
//            TES_TML_SO_CRR model = null;
//
//            while (itr.hasNext()) {
//                model = (TES_TML_SO_CRR)itr.next();
//                i = 1;
//                if (model.getIbflag().length() > 0) {
//					if (model.getIbflag().equals("I")) {
//						isInsert = true;
//						insertPs.setString(i++, model.getTml_crr_cd());
//						insertPs.setString(i++, model.getCrr_desc());
//						insertPs.setString(i++, account.getUsr_id()); /// model.getCre_usr_id());
//						insertPs.setString(i++, ofc_cd);
//						insertPs.setString(i++, account.getUsr_id()); /// model.getUpd_usr_id());
//						insertPs.setString(i++, ofc_cd);
//						insertPs.setString(i++, "N"); /// model.getDelt_flg()
//						insertPs.addBatch();
////					} else if (model.getIbflag().equals("U")) {
////						isUpdate = true ;
////						updatePs.setString(i++, model.getCrr_desc());
////						updatePs.setString(i++, model.getUpd_usr_id());
////						updatePs.setString(i++, model.getTml_crr_cd());
////						updatePs.addBatch();
//					} else if (model.getIbflag().equals("D")) {
//						isDelete = true ;
//						deletePs.setString(i++, "Y"); /// model.getDelt_flg()
//						deletePs.setString(i++, account.getUsr_id()); /// model.getUpd_usr_id());
//						deletePs.setString(i++, ofc_cd);
//						deletePs.setString(i++, model.getTml_crr_cd());
//						deletePs.addBatch();
//					}
//                    i = 1;
//                }
//            }
//
//            // Loggable Statement 사용에 의해 추가
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                log.info("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
//                //log.info("\n SQL :" + ((LoggableStatement)updatePs).getQueryString());
//                log.info("\n SQL :" + ((LoggableStatement)deletePs).getQueryString());
//            } else {
//                log.info("\n SQL :" + insertQuery );
//                //log.info("\n SQL :" + updateQuery );
//                log.info("\n SQL :" + deleteQuery );
//            }
//
//            if( isInsert ) insertPs.executeBatch();
//            //if( isUpdate ) updatePs.executeBatch();
//            if( isDelete ) deletePs.executeBatch();
//
//        } catch (SQLException se) {
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//            log.error(de.getMessage(),de);
//            throw de;
//        } catch (Exception e) {
//            log.error(e.getMessage(),e);
//            throw new DAOException(e.getMessage());
//        } finally {
//            closeStatement(insertPs);
//            //closeStatement(updatePs);
//            closeStatement(deletePs);
//            closeConnection(con);
//        }
//    }

}
