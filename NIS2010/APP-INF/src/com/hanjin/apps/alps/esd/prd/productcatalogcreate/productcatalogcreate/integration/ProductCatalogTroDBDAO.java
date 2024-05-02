/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogTroDBDAO.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : Kim kwijin
*@LastVersion : 1.0
* 2009.10.21 Kim kwijin
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ProductCatalogTroDBDAO <br>
 * - ALPS-ProductCatalogCreate system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see ProductCatalogCreateBCImpl 참조
 * @since J2EE 1.6
 */
public class ProductCatalogTroDBDAO extends DBDAOSupport {
	
	/**
	 * COP_GET_PARAM.txt
	 * @param copNo
	 * @param ioBndCd
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet troGetParam(String copNo ,String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
		
			param.put("cop_no", copNo);
			param.put("io_bnd_cd", ioBndCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogTroDBDAOTroGetParamRSQL(), param, null);
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
	 * COP_INLAND_SUB_ROUT.txt
	 * @param copNo
	 * @param ioBndCd
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet troInlandSubRout(String copNo ,String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
		
			param.put("cop_no", copNo);
			param.put("io_bnd_cd", ioBndCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogTroDBDAOTroInlandSubRoutRSQL(), param, null);
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
	 * GET_PARAM_NOT_CNTR_NO.TXT
	 * @param pcMode
	 * @param bkgNo
	 * @param ioBndCd
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet troGetParamNotCntrNo(String pcMode,String bkgNo,String ioBndCd) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String,Object> param = new HashMap<String,Object>();
		try{
			param.put("pc_mode", pcMode);
			param.put("bkg_no", bkgNo);
			param.put("io_bnd_cd", ioBndCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOTroGetParamNotCntrNoRSQL(), param, null);
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
	 * COP_AUTO_CHANGE.txt
	 * @param ioBndCd
	 * @param srTerm
	 * @param sdTerm
	 * @param creUsrId
	 * @param newPrdCtlNo
	 * @param cct
	 * @param pmF
	 * @param podT
	 * @param polT
	 * @param spmFlg
	 * @param srfCntr
	 * @param smtPu
	 * @param smtRtn
	 * @param inlndRoutOrg
	 * @param inlndRoutDest
	 * @param sinclShtlSoFlg
	 * @param subRout
	 * @param fullCy
	 * @param trspModCd
	 * @param stermNode
	 * @param prdCtlNo
	 * @return
	 * @throws DAOException
	 */
	public int troAutoChange(
			String ioBndCd
			,String srTerm
			,String sdTerm
			,String creUsrId
			,String newPrdCtlNo
			,String cct
			,String pmF
			,String podT
			,String polT
			,String spmFlg
			,String srfCntr
			,String smtPu
			,String smtRtn
			,String inlndRoutOrg
			,String inlndRoutDest
			,String sinclShtlSoFlg
			,String subRout
			,String fullCy
			,String trspModCd
			,String stermNode
			,String prdCtlNo
			) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		
		int result = 0;
		try {
			
			param.put("io_bnd_cd",ioBndCd);
			param.put("sr_term",srTerm);
			param.put("sd_term",sdTerm);
			param.put("cre_usr_id",creUsrId);
			param.put("new_prd_ctl_no",newPrdCtlNo);
			param.put("cct",cct);
			param.put("pm_f",pmF);
			param.put("pod_t",podT);
			param.put("pol_t",polT);
			param.put("spm_flg",spmFlg);
			param.put("srf_cntr",srfCntr);
			param.put("smt_pu",smtPu);
			param.put("smt_rtn",smtRtn);
			param.put("inlnd_rout_org",inlndRoutOrg);
			param.put("inlnd_rout_dest",inlndRoutDest);
			param.put("sinclshtlso_flg",sinclShtlSoFlg);
			param.put("sub_rout",subRout);
			param.put("full_cy",fullCy);
			param.put("trsp_mod_cd",trspModCd);
			param.put("sterm_node",stermNode);
			param.put("prd_ctl_no",prdCtlNo);
			
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ProductCatalogTroDBDAOTroAutoChangeCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
		
	}

	/**
	 * @param ioBndCd
	 * @param area_conti_cd
	 * @param bkgNo
	 * @param troSeq
	 * @param troSubSeq
	 * @return
	 * @throws DAOException
	 */
	public int checkSceTroMapping(String ioBndCd, String area_conti_cd,
			String bkgNo, String troSeq, String troSubSeq) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		
		
		int result = 0;
		try {
			
			param.put("io_bnd_cd",ioBndCd);
			param.put("area_conti_cd",area_conti_cd);
			param.put("bkg_no",bkgNo);
			param.put("tro_seq",troSeq);
			param.put("tro_sub_seq",troSubSeq);
 
			
			
//			SQLExecuter sqlExe = new SQLExecuter("");
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOCheckSceTroMappingRSQL(), param, null);
			if(dbRowset.next()){
				result = dbRowset.getInt("cnt");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	    return result;
		
	}


}
