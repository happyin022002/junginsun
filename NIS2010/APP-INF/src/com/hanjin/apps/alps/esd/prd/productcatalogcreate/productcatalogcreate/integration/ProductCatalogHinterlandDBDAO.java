/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAO.java
*@FileTitle : ProductCatalogHinterland
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
* 1.0 Creation
* history
* 2012.07.18 정선용 [CHM-201217633] 구주 Hinterland, RF 추가,990번 act grp 살림
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdHinterlandInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ProductCatalogHinterlandDBDAO <br>
 * - ALPS-ProductCatalogCreate system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Man-geon
 * @see ProductCatalogCreateBCImpl 참조
 * @since J2EE 1.6
 */
public class ProductCatalogHinterlandDBDAO extends DBDAOSupport {

	/**
	 * Hinterland 처리를 위한 기초데이터를 조회한다.
	 * @param String ioBndCd
	 * @param String fmNodCd
	 * @param String toNodCd
	 * @return PrdHinterlandInfoVO
	 * @throws DAOException
	 */
	public PrdHinterlandInfoVO searchHinterlandInfo(String ioBndCd, String fmNodCd, String toNodCd) throws DAOException {
		PrdHinterlandInfoVO rtnVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("io_bnd_cd", ioBndCd);
			param.put("fm_nod_cd", fmNodCd);
			param.put("to_nod_cd", toNodCd);
			List<PrdHinterlandInfoVO> prdHinterlandInfoList = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogHinterlandDBDAOSearchHinterlandInfoRSQL(), param, null, PrdHinterlandInfoVO.class);
			if (prdHinterlandInfoList.size() > 0) {
				rtnVo  = prdHinterlandInfoList.get(0);
			}
			
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVo;
	}



	/**
	 * PC를 복제한다. (40F용)
	 * @param String hdPctlNo
	 * @param String newSeq
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean copyPrdCatalogMaster(String hdPctlNo, String newSeq) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			param.put("new_seq", newSeq);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOCopyPrdProdCtlMstCSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;

	}

	/**
	 * PC를 복제한다. (40F용)
	 * @param String hdPctlNo
	 * @param String newSeq
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean copyPrdCatalogRouteDetail(String hdPctlNo, String newSeq) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			param.put("new_seq", newSeq);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOCopyPrdProdCtlRoutDtlCSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;

	}

	/**
	 * Hinterland Feeder Catalog를 생성한다.
	 * @param String hdPctlNo
	 * @param String lnkOrgLocCd
	 * @param String lnkDestLocCd
	 * @param String creUsrId
	 * @return int 성공 코드
	 * @throws DAOException
	 */
	public int createFeederCatalog(String hdPctlNo, String lnkOrgLocCd, String lnkDestLocCd, String creUsrId) throws DAOException {
		// TODO Auto-generated method stub
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			param.put("lnk_org_loc_cd", lnkOrgLocCd);
			param.put("lnk_dest_loc_cd", lnkDestLocCd);
			param.put("rcv_t", "Y");
			param.put("del_t", "Y");
			param.put("cre_usr_id", creUsrId);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOcreateFeederCatalogCSQL(), param, null);

			log.debug("\n pc create (successFlag:"+result);

			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;

	}

	/**
	 * Hinterland용으로 최적화된 Container Qty데이터를 생성한다.
	 * @param String hdPctlNo
	 * @param String creUsrId
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean createContainerQty(String hdPctlNo, String creUsrId) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			param.put("cre_usr_id", creUsrId);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOCreateContainerQtyCSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;
	}

	/**
	 * FEEDER의 경우 FEEDER 앞 뒤의 ACTIVITY를 제외하고는 삭제한다.
	 * @param String hdPctlNo
	 * @return boolean 성공 실패 여부
	 * @throws DAOException	 */
	public boolean removeNonFeederActivity(String hdPctlNo) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDAOremoveNonFeederActivityDSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;

	}

	
	/**
	 * Inland Cost가 생성되었는지 검사한다.
	 * @param String hdPctlNo
	 * @return String
	 * @throws DAOException
	 */
	public String checkInlandCostActivity(String hdPctlNo)  throws DAOException {
		String costErrFlg = null;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			DBRowSet dbR  = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogHinterlandDBDAOCheckInlandCostActivityRSQL(), param, null);
			if(dbR.next()){
				costErrFlg = dbR.getString("ERR_MSG");
			} else {
				costErrFlg = "N";
			}
			log.debug("\n\n cost Error Flag:"+costErrFlg);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return costErrFlg;
	}



	/**
	 * Rf 용 pc를 copy 한다.
	 * @param String hdPctlNo
	 * @param String maxPctlNo
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean copyRfPrdCatalogMaster(String hdPctlNo, String maxPctlNo) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			param.put("max_pctl_no"   , maxPctlNo);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOCopyRfPrdProdCtlMstCSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;
		
	}



	/**
	 * @param String hdPctlNo
	 * @param String maxPctlNo
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean copyRfPrdCatalogRouteDetail(String hdPctlNo, String maxPctlNo) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			param.put("max_pctl_no"   , maxPctlNo);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOCopyRfPrdProdCtlRoutDtlCSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;
		
	}



	/**
	 * @param String hdPctlNo
	 * @param String maxPctlNo
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean copyRfContainerQty(String hdPctlNo, String maxPctlNo) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			param.put("max_pctl_no"   , maxPctlNo);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOCopyRfContainerQtyCSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;
		
	}



	/**
	 * @param String hdPctlNo
	 * @param String maxPctlNo
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean copyRfActivityGroup(String hdPctlNo, String maxPctlNo) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			param.put("max_pctl_no"   , maxPctlNo);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOCopyRfActivityGroupCSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;
		
	}



	/**
	 * @param String hdPctlNo
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
	 */
	public boolean updatePrdMst(String hdPctlNo) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no"   , hdPctlNo);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogHinterlandDBDAOUpdatePrdMstUSQL(), param, null);

			log.debug("\n pc create (successFlag:"+successFlag);

			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return true;

	}

}
