/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ProductCatalogCreateDBDAO.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.22 정선용
* 1.0 Creation
* history
* 2010.08.31 채창호 [CHM-201005548-01]:[SCEM / PRD] F.H. 기능 연계한 개발요청
* 2011.02.07 채창호  CHM-201108715  [PRD & BKG] BKG에서 user가 지정한 POL/POD Yard 값 인식요청.
* 2012.07.03 정선용 [CHM-201217726-01] Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
* 2012.08.17 정선용 [CHM-201219664] [PRD] Canada 향 D7 CNTR BKG block 을 위한 Hard-coding 설정요
* 2015.04.10 RAIL CUT OFF TIME 로직 수정
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCnstRemarkVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdConstraintInfoVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdOcnRoutDoubleCallingVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchEurDrRePatternVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.ProductCatalogInternalDetailVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.SearchEmptyPuYdVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.SearchPrdFullRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PrdBkgCopMapVO;
import com.hanjin.syscommon.common.table.PrdProdCtlMstVO;


/**
 * ALPS ProductCatalogCreateDBDAO <br>
 * - ALPS-ProductCatalogCreate system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author sun yong Jung
 * @see ProductCatalogCreateBCImpl 참조
 * @since J2EE 1.6
 */
public class ProductCatalogCreateDBDAO extends DBDAOSupport { 

	/**
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectPrdOcnRout(String hdPctlNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("hd_pctl_no", hdPctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSelectPrdOcnRoutRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param hdPctlNo
	 * @param skd_date
	 * @param skd_type
	 * @return
	 * @throws DAOException
	 */
	public List<PrdOcnRoutDoubleCallingVO> searchPrdCtlOcnRoutDoubleCalling(String hdPctlNo,String skd_date,String skd_type) throws DAOException {
//	public DBRowSet searchPrdCtlOcnRoutDoubleCalling(String hdPctlNo,String skd_date,String skd_type) throws DAOException {
		// TODO Auto-generated method stub
		List<PrdOcnRoutDoubleCallingVO> list = null;
//		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("hd_pctl_no", hdPctlNo);
			param.put("skd_date", skd_date);
			param.put("skd_type", skd_type);
			
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdOcnRoutDoubleCallingRSQL(), param, param, PrdOcnRoutDoubleCallingVO.class);
//			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdOcnRoutDoubleCallingRSQL(), param, param);
			log.debug("\n\n searchPrdCtlOcnRoutDoubleCalling list size:"+list.size());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
//		return dbR;
	}
	
	/**
	 * @param PctlNo
	 * @param mPu
	 * @param mPuDt
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectPrdEmpty(String PctlNo, String mPu, String mPuDt) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", PctlNo);
			param.put("m_pu", mPu);
			param.put("m_pu_dt", mPuDt);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogcreateDBDAOSelectEmptyPuYdRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param PctlNo
	 * @param mPu
	 * @param mPuDt
	 * @return
	 * @throws DAOException
	 */
	public List searchPrdEmpty(String PctlNo, String mPu, String mPuDt) throws DAOException {
		// TODO Auto-generated method stub
//		DBRowSet dbR = null;
		List<SearchEmptyPuYdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", PctlNo);
			param.put("m_pu", mPu);
			param.put("m_pu_dt", mPuDt);
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogcreateDBDAOSelectEmptyPuYdRSQL(), param, null,SearchEmptyPuYdVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * @param prdCnstRemarkVO
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCnstRemark(PrdCnstRemarkVO prdCnstRemarkVO) throws DAOException {
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("prdCtlNo", prdCnstRemarkVO.getPrdCtlNo());
			param.put("trnkLane", prdCnstRemarkVO.getTrnkLane()); 
			param.put("pol", prdCnstRemarkVO.getPol()); 
			param.put("pod", prdCnstRemarkVO.getPod()); 
			param.put("del", prdCnstRemarkVO.getDel()); 
			param.put("cnst_seq", prdCnstRemarkVO.getCnst_seq()); 
			param.put("cnstFlg", prdCnstRemarkVO.getCnstFlg()); 
			param.put("nod_cd", prdCnstRemarkVO.getNod_cd()); 
			param.put("org_nod_cd", prdCnstRemarkVO.getOrg_nod_cd()); 
			param.put("dest_nod_cd", prdCnstRemarkVO.getDest_nod_cd()); 

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;

	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPortCct(String pctlNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{

			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPortCctRSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;

	}

	/**
	 * @param pctlNo
	 * @param por
	 * @param from
	 * @param to
	 * @param port
	 * @param cct
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchFullRtnYdCct(String pctlNo, String por, String from, String to, String port, String cct) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{

			param.put("pctl_no", pctlNo);
			param.put("por", por);
			param.put("from_time", from);
			param.put("to_time", to);
			param.put("port", port);
			param.put("cct", cct);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchFullRtnYdCctRSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;

	}

	/**
	 * @param pctlNo
	 * @param por
	 * @param rtnTime
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectPrdFullRtn(String pctlNo, String por, String rtnTime) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", pctlNo);
			param.put("por", por);
			param.put("rail_cargo_rtn_tm", rtnTime);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSelectFullRtnYdCctRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRouteInfoByPctlNo(String pctlNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet selectReturnStrToBkg(String pctlNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSelectReturnStrToBkgRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param bkgPctlNo
	 * @param hdPctlNo
	 * @param scOfc
	 * @param rfaOfc
	 * @param usrId
	 * @param copyCnt
	 * @param scNo
	 * @param rfaNo
	 * @throws DAOException
	 */
	public void createBkgCopyPrdMstVvdUnchange(String bkgPctlNo,
			String hdPctlNo, String scOfc, String rfaOfc, String usrId, int copyCnt, String scNo, String rfaNo) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("bkg_pctl_no", bkgPctlNo);
			param.put("hd_pctl_no", hdPctlNo);
			param.put("sc_ofc", scOfc);
			param.put("rfa_ofc", rfaOfc);
			param.put("copy_cnt", copyCnt);
			param.put("cre_usr_id", usrId);
			param.put("sc_no", scNo);
			param.put("rfa_no", rfaNo);
			
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateBkgCopyPrdMstVvdUnchangeCSQL(), param, null);
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
		
	}

	/**
	 * @param bkgPctlNo
	 * @param hdPctlNo
	 * @param usrId
	 * @param copyCnt
	 * @throws DAOException
	 */
	public void createBkgCopyPrdDtlVvdUnchange(String bkgPctlNo,
			String hdPctlNo,  String usrId, int copyCnt) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("bkg_pctl_no", bkgPctlNo);
			param.put("hd_pctl_no", hdPctlNo);
			param.put("copy_cnt", copyCnt);
			param.put("cre_usr_id", usrId);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateBkgCopyPrdDtlVvdUnchangeCSQL(), param, null);
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
	}

	/**
	 * @param bkgPctlNo
	 * @param hdPctlNo
	 * @param scOfc
	 * @param rfaOfc
	 * @param usr_id
	 * @param copyCnt
	 * @throws DAOException
	 */
	public void createBkgCopyPrdActGrpDtlVvdUnchange(String bkgPctlNo,
			String hdPctlNo, String scOfc, String rfaOfc, String usr_id, int copyCnt) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("bkg_pctl_no", bkgPctlNo);
			param.put("hd_pctl_no", hdPctlNo);
			param.put("sc_ofc", scOfc);
			param.put("rfa_ofc", rfaOfc);
			param.put("copy_cnt", copyCnt);
			param.put("cre_usr_id", usr_id);
			param.put("upd_usr_id", usr_id);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateBkgCopyPrdActGrpDtlVvdUnchangeCSQL(), param, null);
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
	}

	/**
	 * 
	 * @param bkgNo
	 * @param vvd
	 * @return
	 * @throws DAOException
	 * @deprecated 오픈할 때 관련된 소스 지워주세요.
	 */
	public int updateAssignVvdMaster(String bkgNo, String vvd)  throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("vvd",    vvd);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdateAssignVvdMasterUSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param bkgNo
	 * @param vvd
	 * @param pol
	 * @param pod
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public int updateAssignVvdDetail(String bkgNo, String vvd, String pol, String pod, String userId) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("vvd",    vvd);
			param.put("pol",   pol);
			param.put("pod",   pod);
			param.put("user_id",userId);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdateAssignVvdDetailUSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param hdPctlNo
	 * @param copyCnt
	 * @throws DAOException
	 */
	public void updateBkgCopyVndr(String hdPctlNo, int copyCnt) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("hd_pctl_no", hdPctlNo);
			param.put("copy_cnt", copyCnt);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdateBkgCopyVndrUSQL(), param, null);
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
	}

	/**
	 * @param String bkgNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkBkgCopy(String bkgNo)throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("bkg_no", bkgNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOCheckBkgCopyRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param String parentBkgNo
	 * @param String mapgSeq
	 * @return boolean
	 * @throws DAOException
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 박만건 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청
	 */
	public boolean createBkgSplitMapBase(String parentBkgNo ,String mapgSeq) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("parent_bkg_no", parentBkgNo);
			param.put("mapg_seq"     , mapgSeq);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateBkgSplitMapBaseCSQL(), param, param);
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
	 * @param PrdMainInfoVO prdMainInfoVO
	 * @param String mapgSeq
	 * @param String cntrLstStr
	 * @param String bkgNoLstStr
	 * @return boolean
	 * @throws DAOException
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 박만건 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청
	 */
	public boolean createBkgSplitMapCntr(PrdMainInfoVO prdMainInfoVO, String mapgSeq, String cntrLstStr, String bkgNoLstStr) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no"       , prdMainInfoVO.getBkgNo());
			param.put("bkg_ofc"      , prdMainInfoVO.getBkgOfc());
			param.put("mapg_seq"     , mapgSeq);
			param.put("cntr_lst"     , cntrLstStr);
			param.put("bkg_no_list"  , bkgNoLstStr);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateBkgSplitMapCntrCSQL(), param, param);
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
	 * @param String parentBkgNo
	 * @param String bkgNo
	 * @param String mapSeq
	 * @param String flexHgtFlg
	 * @param String cntrTpszQty
	 * @return DBRowSet
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 박만건 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청
	 * @throws DAOException
	 */
	public DBRowSet searchBkgSplitQtyCount(String parentBkgNo, String bkgNo, String mapSeq, String flexHgtFlg, String cntrTpszQty) throws DAOException {
		
		// TODO Auto-generated method stub
		DBRowSet rowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("parent_bkg_no", parentBkgNo);
			param.put("bkg_no", bkgNo);
			param.put("mapg_seq", mapSeq);
			param.put("flex_hgt_flg", flexHgtFlg);
			param.put("cntr_tpsz_qty", cntrTpszQty);
 
			rowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchBkgSplitQtyCountRSQL(), param,  null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rowset;
	}


	/**
	 * @param String por
	 * @param String pol
	 * @param String pod
	 * @param String del
	 * @param String tVvd
	 * @param String rcvT
	 * @param String delT
	 * @param String bkgNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkReplane(String por,String pol,String pod, String del,String tVvd, String rcvT, String delT,String bkgNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("por", por);
			param.put("pol", pol);
			param.put("pod", pod);
			param.put("del", del);
			param.put("t_vvd", tVvd);
			param.put("rcv_t", rcvT);
			param.put("del_t", delT);
			param.put("bkg_no", bkgNo);
			
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOcheckReplaneRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPrdCtlgFullRout(String pctlNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param String pctlNo
	 * @return List<SearchPrdFullRouteVO>
	 * @throws DAOException
	 */
	public List<SearchPrdFullRouteVO> searchPrdCtlgFullRoutByPctlNo(String pctlNo) throws DAOException {
		// TODO Auto-generated method stub
		List<SearchPrdFullRouteVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", pctlNo);
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdFullRouteRSQL(), param, null,SearchPrdFullRouteVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
//	public List searchCurrentPatternOrd(String mapSeq) throws DAOException {
//		// TODO Auto-generated method stub
//		DBRowSet dbR = null;
//		List<PrdPatternVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		try{
//			param.put("cop_mapg_seq", mapSeq);
//			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL(), param, null, PrdPatternVO.class);
//
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}
	
//	/**
//	 * @param pctlNo
//	 * @return
//	 * @throws DAOException
//	 */
//	public DBRowSet searchPrdConstraint(String pctlNo) throws DAOException {
//		DBRowSet dbR = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//	
//		try{
//			
//			param.put("pctl_no", pctlNo);
//			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdConstraintRSQL(), param, null);
//			
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return dbR;
//	}
	
	/**
	 * @param pctlNo
	 * @param valChkcd
	 * @param etcRmk
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public int addValCheck(String pctlNo, String valChkcd, String etcRmk, String userId) throws DAOException {
		//query parameter
		int exeFlag = 0;
		
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			param.put("pctl_no", pctlNo);
			param.put("rout_val_chk_cd", valChkcd);
			param.put("etc_rmk", etcRmk);
			param.put("user_id", userId);
			exeFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreatePrdValCheckCSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exeFlag;
	}	
	
	/**
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet getSoSubRout(String bkgNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("bkg_no", bkgNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchSoSubRoutRSQL(), param, null);
			
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}
	
	/**
	 * PRS > COA > PRD 호출 용
	 * @param prdCreateParamVO
	 * @param prdPcCreateVo
	 * @param usr_id
	 * @return
	 * @throws DAOException
	 */
	public int createProductCatalogIncludeReplanePRS(PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVo, String usr_id) throws DAOException {
		//DBRowSet dbR = null;
		int exeFlag = 0;
		//query parameter

		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("por", prdCreateParamVO.getPor());
			param.put("pol", prdCreateParamVO.getPol());
			param.put("pod", prdCreateParamVO.getPod());
			param.put("del", prdCreateParamVO.getDel());
			param.put("ld_dt", prdCreateParamVO.getLdDt());
			param.put("rcv_t", prdCreateParamVO.getRcvT());
			param.put("del_t", prdCreateParamVO.getDelT());
			param.put("com", prdCreateParamVO.getCom());
			param.put("bkg_ofc", prdCreateParamVO.getBkgOfc());
			param.put("sc_ofc", prdCreateParamVO.getScOfc());
			param.put("cre_usr_id", usr_id);
			param.put("hd_pctl_no", prdPcCreateVo.getHdPctlNo());
			param.put("pm_f", prdCreateParamVO.getPmF());
			param.put("m_pu", prdCreateParamVO.getMPu());
			param.put("f_rt", prdCreateParamVO.getFRt());
			param.put("por_n", prdCreateParamVO.getPorN());
			param.put("del_n", prdCreateParamVO.getDelN());
			param.put("skd_date", prdPcCreateVo.getSkdDate());
			param.put("skd_type", prdPcCreateVo.getSkdType());
			param.put("vvd1", prdCreateParamVO.getVvd1());
			param.put("vvd2", prdCreateParamVO.getVvd2());
			param.put("vvd3", prdCreateParamVO.getVvd3());
			param.put("vvd4", prdCreateParamVO.getVvd4());
			param.put("pol1", prdCreateParamVO.getPol1());
			param.put("pod1", prdCreateParamVO.getPod1());
			param.put("lane1", prdCreateParamVO.getLane1());
			param.put("pol2", prdCreateParamVO.getPol2());
			param.put("pod2", prdCreateParamVO.getPod2());
			param.put("lane2", prdCreateParamVO.getLane2());
			param.put("pol3", prdCreateParamVO.getPol3());
			param.put("pod3", prdCreateParamVO.getPod3());
			param.put("lane3", prdCreateParamVO.getLane3());
			param.put("pol4", prdCreateParamVO.getPol4());
			param.put("pod4", prdCreateParamVO.getPod4());
			param.put("lane4", prdCreateParamVO.getLane4());
			param.put("vvd", prdCreateParamVO.getTVvd());
			param.put("so_seq", "0"); 
			param.put("cgo_tp", prdCreateParamVO.getCgoTp());
			param.put("ob_trsp_mode", prdCreateParamVO.getObTrspMode());
			param.put("ib_trsp_mode", prdCreateParamVO.getIbTrspMode());
			param.put("ag_seq", "");
			param.put("ib_str", "");
			param.put("ocn_str","");
			param.put("ob_str","");
			param.put("pod_n","");
			

			param.put("dg_spcl_flg", prdCreateParamVO.getDgF());  
			param.put("rf_spcl_flg", prdCreateParamVO.getRfF());  
			param.put("spcl_awk_cgo_flg", prdCreateParamVO.getAkF());  
			param.put("bb_spcl_flg", prdCreateParamVO.getBbF());  
			
			exeFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateProductCatalogInCludeReplanePRSCSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exeFlag;


	}
	
	/**
	 * @param prdCreateParamVo
	 * @param prdPcCreateVo
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public int createProductCatalogInternalTemp(PrdCreateParamVO prdCreateParamVo , PrdPcCreateVO prdPcCreateVo, String userId) throws DAOException{
		// TODO Auto-generated method stub

		//DBRowSet dbR = null;
		int exeFlag = 0;
		//query parameter

		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("por"           ,  prdCreateParamVo.getPor()           );
			param.put("por_n"         ,  prdCreateParamVo.getPorN()          );
			param.put("pol"           ,  prdCreateParamVo.getPol()           );
			param.put("pod"           ,  prdCreateParamVo.getPod()           );
			param.put("pod_n"         ,  prdCreateParamVo.getPodN()          );
			param.put("del"           ,  prdCreateParamVo.getDel()           );
			param.put("del_n"         ,  prdCreateParamVo.getDelN()          );
			param.put("skd_date"      ,  prdCreateParamVo.getLdDt()          );
			param.put("rTerm"         ,  prdCreateParamVo.getRcvT()          );
			param.put("dTerm"         ,  prdCreateParamVo.getDelT()          );
			param.put("com"           ,  prdCreateParamVo.getCom()           );
			param.put("bkgOffCd"      ,  prdCreateParamVo.getBkgOfc()        );
			param.put("sc_ofc"        ,  prdCreateParamVo.getScOfc()         );
			param.put("user_id"       ,  userId                              );
			param.put("prdCtlNo"      ,  prdPcCreateVo.getHdPctlNo()         );
			param.put("pm_f"          ,  prdCreateParamVo.getPmF()           );
			param.put("ag_seq"        ,  ""                                  ); // COST_ACT_GRP_SEQ
			param.put("update_id"     ,  userId                              );
			param.put("emt_pk_yd"     ,  prdCreateParamVo.getMPu()           );
			param.put("emt_rtn_yd"    ,  ""                                  );
			param.put("full_rtn_yd"   ,  prdCreateParamVo.getFRt()           );
			param.put("ob_trsp_mode"  ,  prdCreateParamVo.getObTrspMode()    );
			param.put("ib_trsp_mode"  ,  prdCreateParamVo.getIbTrspMode()    );
			param.put("lane1"         ,  prdCreateParamVo.getLane1()         );
			param.put("lane2"         ,  prdCreateParamVo.getLane2()         );
			param.put("lane3"         ,  prdCreateParamVo.getLane3()         );
			param.put("lane4"         ,  prdCreateParamVo.getLane4()         );
			param.put("pol1"          ,  prdCreateParamVo.getPol1()          );
			param.put("pol2"          ,  prdCreateParamVo.getPol2()          );
			param.put("pol3"          ,  prdCreateParamVo.getPol3()          );
			param.put("pol4"          ,  prdCreateParamVo.getPol4()          );
			param.put("pod1"          ,  prdCreateParamVo.getPod1()          );
			param.put("pod2"          ,  prdCreateParamVo.getPod2()          );
			param.put("pod3"          ,  prdCreateParamVo.getPod3()          );
			param.put("pod4"          ,  prdCreateParamVo.getPod4()          );
			param.put("s_date"        ,  prdPcCreateVo.getSkdDate()          );
			param.put("s_type"        ,  prdPcCreateVo.getSkdType()          );
			param.put("vvd"           ,  prdCreateParamVo.getTVvd()          );
			param.put("vvd1"          ,  prdCreateParamVo.getVvd1()          );
			param.put("vvd2"          ,  prdCreateParamVo.getVvd2()          );
			param.put("vvd3"          ,  prdCreateParamVo.getVvd3()          );
			param.put("vvd4"          ,  prdCreateParamVo.getVvd4()          );
			param.put("cgo_tp"        ,  prdCreateParamVo.getCgoTp()         );
			param.put("so_seq"        ,  "0"                                 );
			
			param.put("dg_spcl_flg", prdCreateParamVo.getDgF());  
			param.put("rf_spcl_flg", prdCreateParamVo.getRfF());  
			param.put("spcl_awk_cgo_flg", prdCreateParamVo.getAkF());  
			param.put("bb_spcl_flg", prdCreateParamVo.getBbF());  				
			param.put("soc_flg", prdCreateParamVo.getSocF());  				

			

			exeFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateProductCatalogInternalTempCSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exeFlag;


	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchProductCatalogInternalMst_1(String pctlNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_1RSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}
	
	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchProductCatalogInternalMst_2(String pctlNo) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchProductCatalogInternalMst_2RSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}


	
	/**
	 * @param String bkgRcvT
	 * @param String bkgDelT
	 * @param String chgRterm
	 * @param String chgDterm
	 * @param String bkgNo
	 * @param String mapSeq
	 * @param String currentFlag
	 * @param String flxHgtFlg
	 * @param String cntrTpszQty
	 * @param String bkgOfc
	 * @return List<PrdBkgCopMapVO>
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 채창호 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청
	 * @throws DAOException
	 */
	public List<PrdBkgCopMapVO> getReplanePattern(String bkgRcvT, String bkgDelT, String chgRterm, String chgDterm, String bkgNo, String mapSeq, String currentFlag
			                     ,String flxHgtFlg , String cntrTpszQty , String bkgOfc) throws DAOException {
//		DBRowSet dbR = null;
		//query parameter
		DBRowSet dbRowset = null;
		List<PrdBkgCopMapVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//int exeFlag = 0;
		try{
			param.put("rcv_t", chgRterm);
			param.put("bkg_rcv_t", bkgRcvT);
			param.put("del_t", chgDterm);
			param.put("bkg_del_t", bkgDelT);
			param.put("bkg_no", bkgNo);
			param.put("mapg_seq", mapSeq);
			param.put("current_flag", currentFlag);
			param.put("flex_hgt_flg", flxHgtFlg);
			param.put("cntr_tpsz_qty", cntrTpszQty);
			param.put("bkg_ofc", bkgOfc);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOGetReplanePatternRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrdBkgCopMapVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
            return list;
	}

	/**
	 * @return
	 * @throws DAOException
	 */
	public String getPrdBkgCopMapSeq() throws DAOException{
		// TODO Auto-generated method stub
 
		DBRowSet dbR = null;
		String mapSeq = "";
		//query parameter

		Map<String, Object> param = new HashMap<String, Object>();

		try{
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOGetPrdBkgCopMapSeqRSQL(), param, null);
			if(dbR.next()){
				mapSeq = dbR.getString("map_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mapSeq;
	}

	/**
	 * @param bkgNo
	 * @param bkgNoList
	 * @throws DAOException
	 */
	public void updatePrdMapInit(String bkgNo, String bkgNoList) throws DAOException{
		// TODO Auto-generated method stub
 
//		DBRowSet dbR = null;
		//query parameter
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		log.debug("\n\n===============bkgNo:"+bkgNo);
		if(bkgNo.equals("")){
			throw new DAOException((new ErrorHandler("PRD00071")).getMessage());
		}
		try{
			param.put("bkg_no", bkgNo);
			param.put("bkg_no_list", bkgNoList);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdMapInitUSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
 
	}

	/**
	 * @param bkgNo
	 * @param tpsz
	 * @param cop_map_seq
	 * @return
	 * @throws DAOException
	 */
	public double getCntrTypeQty(String bkgNo, String tpsz, String cop_map_seq) throws DAOException{
		// TODO Auto-generated method stub
 
		DBRowSet dbR = null;
		double qty = 0;
		//query parameter

		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_tpsz_cd", tpsz);
			param.put("cop_map_seq", cop_map_seq);
			
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOGetCntrTypeQtyRSQL(), param, null);
			if(dbR.next()){
				qty = Double.parseDouble(dbR.getString("qty"));
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return qty;
	}

	/**
	 * @param String mapSeq
	 * @return List<PrdPatternVO>
	 * @throws DAOException
	 */
	public List<PrdPatternVO> searchCurrentPatternOrd(String mapSeq) throws DAOException {
		// TODO Auto-generated method stub
//		DBRowSet dbR = null;
		List<PrdPatternVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("cop_mapg_seq", mapSeq);
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL(), param, null, PrdPatternVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param prdCreateParamVO
	 * @param prdPcCreateVo
	 * @param prdPatternVO
	 * @param usr_id
	 * @return
	 * @throws DAOException
	 */
	public int createProductCatalogIncludeReplane(PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVo, PrdPatternVO prdPatternVO, String usr_id) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	    log.debug("\n\n createProductCatalogIncludeReplane==> "+prdPcCreateVo.getSkdType());
		try{
//			@[pctl_no], @[cntr_tpsz_cd], @[pctl_qty], @[rev_cntr_tpsz_cd], @[rev_pctl_qty], @[cre_usr_id],@[upd_usr_id]
			param.put("por", prdCreateParamVO.getPor());
			param.put("pol", prdCreateParamVO.getPol());
			param.put("pod", prdCreateParamVO.getPod());
			param.put("del", prdCreateParamVO.getDel());
			param.put("ld_dt", prdCreateParamVO.getLdDt());
			param.put("rcv_t", prdCreateParamVO.getRcvT());
			param.put("del_t", prdCreateParamVO.getDelT());
			param.put("com", prdCreateParamVO.getCom());
			param.put("bkg_ofc", prdCreateParamVO.getBkgOfc());
//			param.put("sc", prdCreateParamVO.getSc());
			param.put("sc_ofc", prdCreateParamVO.getScOfc());
			param.put("cre_usr_id", usr_id);
			param.put("hd_pctl_no", prdPcCreateVo.getHdPctlNo());
			param.put("pm_f", prdCreateParamVO.getPmF());
			param.put("m_pu", prdCreateParamVO.getMPu());
			param.put("f_rt", prdCreateParamVO.getFRt());
			param.put("por_n", prdCreateParamVO.getPorN());
			param.put("del_n", prdCreateParamVO.getDelN());
			param.put("skd_date", prdPcCreateVo.getSkdDate());
			param.put("skd_type", prdPcCreateVo.getSkdType());
			log.debug("\n\n prdPcCreateVo.getSkdType()==> "+prdPcCreateVo.getSkdType());
			log.debug("\n\n prdPcCreateVo.getSkdDate()==> "+prdPcCreateVo.getSkdDate());
			param.put("vvd1", prdCreateParamVO.getVvd1());
			param.put("vvd2", prdCreateParamVO.getVvd2());
			param.put("vvd3", prdCreateParamVO.getVvd3());
			param.put("vvd4", prdCreateParamVO.getVvd4());
			param.put("pol1", prdCreateParamVO.getPol1());
			param.put("pod1", prdCreateParamVO.getPod1());
			param.put("lane1", prdCreateParamVO.getLane1());
			param.put("pol2", prdCreateParamVO.getPol2());
			param.put("pod2", prdCreateParamVO.getPod2());
			param.put("lane2", prdCreateParamVO.getLane2());
			param.put("pol3", prdCreateParamVO.getPol3());
			param.put("pod3", prdCreateParamVO.getPod3());
			param.put("lane3", prdCreateParamVO.getLane3());
			param.put("pol4", prdCreateParamVO.getPol4());
			param.put("pod4", prdCreateParamVO.getPod4());
			param.put("lane4", prdCreateParamVO.getLane4());			
			param.put("vvd", prdCreateParamVO.getTVvd());
			param.put("so_seq", "0"); //replane 용 
			param.put("cgo_tp", prdCreateParamVO.getCgoTp());
			// Trans Mode는  S/O가 없을 때에만 Parameter로 전달된 Trans Mode를 반영한다. 2011.10.19. mgpark
			// 첫생성때, patternVO들어오지 않음, Replan시 Pattern VO들어옴 이때 Null이거나 값이 %이면 적용 2011.12.22
			// 2014.07.01 HICHIMENT COMBINE시 패턴1 에 TRANS MODE 가 적용된다면 패턴2에는 적용되면 안되는 경우가 있음.
			// 즉 서로 다른 TERM 에 대해 같은 TRANS MODE 가 적용 되면 안됨.
			if(prdPatternVO == null || prdPatternVO.getObItchgCtnt() == null || prdPatternVO.getObItchgCtnt().replaceAll("%", "").equals("")){
				param.put("ob_trsp_mode", prdCreateParamVO.getObTrspMode());
			}
			if(prdPatternVO == null || prdPatternVO.getIbItchgCtnt() == null || prdPatternVO.getIbItchgCtnt().replaceAll("%", "").equals("")){
				param.put("ib_trsp_mode", prdCreateParamVO.getIbTrspMode());
			}
			param.put("pol_n", prdCreateParamVO.getPolN());
			param.put("pod_n",prdCreateParamVO.getPodN());
			
			if(prdPatternVO != null){
				log.debug("\n\n prdPatternVO is not null----------------" +
						"\n ob_str:"+prdPatternVO.getObItchgCtnt()+
						"\n ocn_str:"+prdPatternVO.getOcnItchgCtnt()+ 
						"\n ib_str:"+prdPatternVO.getIbItchgCtnt()+
						"\n pod_n:"+prdCreateParamVO.getPodN()+
						"\n--------------------------------------------");
				/*
				-- HICHMENT COMBINE( D TERM[CNTR 1개] + Y TERM[CNTR 4개] )  에 대해 MASTER를 Y TERM 으로 잡았을때 
				-- HICHMENT 로 MIXED 로 되고, BKG 은 YARD TERM 에 대한 정보만을 가지고 있는 상태이다.
				-- 이때 REPLAN 시 패턴이 많은 Y TERM 에 대한 정보로 대표PC 를 만든다.
				-- 부패턴을 만들때도 BKG MAIN정보를 가지고 오므로 이때 문제가 발생할수 있다.
				-- 부패턴은 D TERM 에 대한 IRG를 사용해야 하고,해당 IRG의  TRANS MODE 가 TR 이더라도, MAIN 정보에서 들어온 RD 모드로 인해 
				-- PC가 생성되니 않을수 있거나 IRG가 변경될수 있다.
				-- 이 부분을 보완 해야 할듯.
				-- 보완: 패턴에서 해당 IRG의 TRANS MODE 를 가져와서 , MAIN PARAM 의 모드와 비교 , 다르면 패턴의것을 사용 
				 */
				/*
				 * S/O와 TRO 모두 frustrate 처리 되었는데 BKG의 Transmode가 변경되지 않는 case 발생.
				 * S/O와 TRO 모두 frustrate 처리 되었을때는 해당 pc를 참조하면 안된다.
				 * S/O와 TRO 모두 frustrate 처리 되었을때 : prdPatternVO.getObItchgCtnt() == null || prdPatternVO.getObItchgCtnt().replaceAll("%", "").equals("")
				 */
				if(!prdPatternVO.getObItchgCtnt().replaceAll("%", "").equals("")){ // s/o 정보가 있으면  
					
					if(!"AL".equals(prdCreateParamVO.getObTrspMode()) && !"".equals(prdPatternVO.getCopPcObTrspModCd()) && !"".equals(prdCreateParamVO.getObTrspMode()) 
							&& !prdPatternVO.getCopPcObTrspModCd().equals(prdCreateParamVO.getObTrspMode())) {
						param.put("ob_trsp_mode", prdPatternVO.getCopPcObTrspModCd());
						log.debug("\n prdPatternVO.getCopPcObTrspModCd():"+prdPatternVO.getCopPcObTrspModCd());
					}
				}
				
				param.put("ag_seq", "");       
				param.put("ib_str", prdPatternVO.getIbItchgCtnt()); 
				param.put("ocn_str",prdPatternVO.getOcnItchgCtnt());      
				param.put("ob_str",prdPatternVO.getObItchgCtnt());    
				
				// hitchment case 처리 bkg_container에서 pattern을 산출하여 적용
				log.debug("\n prdCreateParamVO.getPorN():"+prdCreateParamVO.getPorN());
				if (!prdPatternVO.getPorNodCd().equals("")) {
				    log.debug("\n prdPatternVO.getPorNodCd() not space :"+prdPatternVO.getPorNodCd());
					param.put("por", prdPatternVO.getPorNodCd().substring(0, 5));
					param.put("por_n", prdPatternVO.getPorNodCd());
				}
				if (!prdPatternVO.getPolNodCd().equals("")){
					param.put("pol", prdPatternVO.getPolNodCd().substring(0, 5));
					param.put("pol1", 	"");
					param.put("pod1", 	"");
					param.put("lane1", 	"");
					param.put("pol2", 	"");
					param.put("pod2", 	"");
					param.put("lane2", 	"");
					param.put("pol3",	"");
					param.put("pod3", 	"");
					param.put("lane3", 	"");
					param.put("pol4",	"");
					param.put("pod4", 	"");
					param.put("lane4", 	"");			
					
				}
				if (!prdPatternVO.getBkgRcvTermCd().equals("")) {
					log.debug("\n\n prdPatternVO.getBkgRcvTermCd():"+prdPatternVO.getBkgRcvTermCd());
					if(null!=prdCreateParamVO.getBkgRcvT() && !prdCreateParamVO.getBkgRcvT().equals("M")){  // MIXED TERM 로직으로 가져온 R TERM 과 패턴의 TERM이 다를수 있음, 패턴 우선  
						param.put("rcv_t", prdPatternVO.getBkgRcvTermCd());	
					} 
					else { //bkg main term이 Mixed 일떄,   RcvT(M 을 변경한) 와 패턴의 rcvTermCd 가 다르고, 패턴의 rcvTermCd가 Mixed가 아닐때
						if((!prdCreateParamVO.getRcvT().equals(prdPatternVO.getBkgRcvTermCd())) && (!prdPatternVO.getBkgRcvTermCd().equals("M")) ){
							param.put("rcv_t", prdPatternVO.getBkgRcvTermCd());	
						}
					}
				}
				if (!prdPatternVO.getBkgDeTermCd().equals("")) {
					log.debug("\n\n prdPatternVO.getBkgDeTermCd():"+prdPatternVO.getBkgDeTermCd());
					if(null!=prdCreateParamVO.getBkgDelT() && !prdCreateParamVO.getBkgDelT().equals("M")){
						param.put("del_t", prdPatternVO.getBkgDeTermCd());	
					}
				}
//				if(prdPatternVO.getMtyPkupYdCd() != null && !"".equals(prdPatternVO.getMtyPkupYdCd())) {
//					param.put("m_pu", prdPatternVO.getMtyPkupYdCd());
//				}
				if(prdPatternVO.getMtyRtnYdCd() != null && !"".equals(prdPatternVO.getMtyRtnYdCd())) {
					param.put("m_rt", prdPatternVO.getMtyRtnYdCd());
				}
				
			} else {
				param.put("ag_seq", "");       
				param.put("ib_str", ""); 
				param.put("ocn_str","");      
				param.put("ob_str","");        
			}
//		    BKG_CGO_TP_CD, SHPR_CNT_CD, SHPR_SEQ, 
//		    CNEE_CNT_CD, CNEE_SEQ, SC_NO, RFA_NO, DG_CLSS_CD, DG_SPCL_FLG, RF_SPCL_FLG, 
//		    SPCL_AWK_CGO_FLG, BB_SPCL_FLG, RD_SPCL_FLG, HNGR_SPCL_FLG, SOC_FLG, EQ_SUBST_FLG, 
//		    BKG_WGT, BKG_WGT_UT_CD, SLS_OFC_CD, RFA_OFC_CD, PRM_CUST_FLG, 
//		    REP_CMDT_CD		
//			 * P/C Call : ESD_PRD_0080.do?f_cmd=3&pc_mode=B&por=USCHI&pol=USLGB&pod=KRPUS&del=KRPUS
//					 * &t_vvd=&rcv_t=Y&del_t=Y&shpr=US000003&cngn=&com=000004&rep_com=0000&wgt=11.000
//					 * &wgt_un=KGS&bkg_ofc=SELSC&org_sal_ofc=CLTBS&m_pu=&f_rt=&m_rt=&ld_dt=20091104
//					 * &dr_dt=&org_trns_mode=AL&dest_trns_mode=AL&sc=DUM000001&c_tpsz=D4&c_qty=1
//					 * &cgo_tp=F&dg_f=N&rf_f=N&ak_f=N&bb_f=N&rd_f=N&hg_f=&soc_f=N&sub_f=N&pm_f=
			param.put("cgo_tp", prdCreateParamVO.getCgoTp());  
			param.put("shpr_cnt_cd", prdCreateParamVO.getShprCntCd());  
			param.put("shpr_seq", prdCreateParamVO.getShprSeq());  
			param.put("cnee_cnt_cd", prdCreateParamVO.getCneeCntCd());  
			param.put("cnee_seq", prdCreateParamVO.getCneeSeq());  
			param.put("sc_no", prdCreateParamVO.getSc());  
			param.put("rfa_no", prdCreateParamVO.getRfa());  
			param.put("dg_spcl_flg", prdCreateParamVO.getDgF());  
			param.put("rf_spcl_flg", prdCreateParamVO.getRfF());  
			param.put("spcl_awk_cgo_flg", prdCreateParamVO.getAkF());  
			param.put("bb_spcl_flg", prdCreateParamVO.getBbF());  
			param.put("rd_spcl_flg", prdCreateParamVO.getRdF());  
			param.put("hngr_spcl_flg", prdCreateParamVO.getHgF());  
			param.put("soc_flg", prdCreateParamVO.getSocF());  
			param.put("eq_subst_flg", prdCreateParamVO.getSubF());  
			param.put("bkg_wgt", prdCreateParamVO.getWgt());  
			param.put("bkg_wgt_ut_cd", prdCreateParamVO.getWgtUn());  
			param.put("sls_ofc_cd", prdCreateParamVO.getOrgSalOfc());  
			param.put("rfa_ofc_cd", prdCreateParamVO.getRfaOfc());  
			param.put("prm_cust_flg", prdCreateParamVO.getPmF());  
			param.put("rep_cmdt_cd", prdCreateParamVO.getRepCom()); 
			 
			//replane 때에만 들어옴.
			param.put("dg_clss_cd", prdCreateParamVO.getDgF());  
			
			//double calling 관련 seq
			param.put("n1st_pol_dc_seq", prdCreateParamVO.getN1stPolDcSeq());																
			param.put("n1st_pod_dc_seq", prdCreateParamVO.getN1stPodDcSeq());																
			param.put("n2nd_pol_dc_seq", prdCreateParamVO.getN2ndPolDcSeq());																
			param.put("n2nd_pod_dc_seq", prdCreateParamVO.getN2ndPodDcSeq());																
			param.put("n3rd_pol_dc_seq", prdCreateParamVO.getN3rdPolDcSeq());																
			param.put("n3rd_pod_dc_seq", prdCreateParamVO.getN3rdPodDcSeq());																
			param.put("n4th_pol_dc_seq", prdCreateParamVO.getN4thPolDcSeq());																
			param.put("n4th_pod_dc_seq", prdCreateParamVO.getN4thPodDcSeq());																

			// CA Issue 관련
			param.put("ocn_seq", prdCreateParamVO.getOcnSeq());																
			
			param.put("pc_mode", prdCreateParamVO.getPcMode());			
			param.put("bkg_no", prdCreateParamVO.getBkgNo());			
			
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateProductCatalogInCludeReplaneCSQL(), param, param);
			log.debug("\n pc create successFlag:"+successFlag);
			
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
		return successFlag;
	}

	/**
	 * @param copPattOrdNo
	 * @param copMapgSeq
	 * @param minPctlNo
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdMapByPcCreate(String copPattOrdNo, String copMapgSeq,
			String minPctlNo, String bkgNo) throws DAOException{
		// TODO Auto-generated method stub
 
		//query parameter
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		if(minPctlNo.equals("") ){
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		} else if(copMapgSeq.equals("")){
			throw new DAOException((new ErrorHandler("PRD00072")).getMessage());
		}
		try{
 		
			param.put("cop_patt_ord_no", copPattOrdNo);
			param.put("cop_mapg_seq", copMapgSeq);
			param.put("pctl_no", minPctlNo);
			param.put("bkg_no", bkgNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdMapByPcCreateUSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param copPattOrdNo
	 * @param copMapgSeq
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdMapByPcCreateFail(String copPattOrdNo,
			String copMapgSeq) throws DAOException{
		// TODO Auto-generated method stub
 
		//query parameter
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		if(copMapgSeq.equals("")){
			throw new DAOException((new ErrorHandler("PRD00072")).getMessage());
		}
		try{
 		
			param.put("cop_patt_ord_no", copPattOrdNo);
			param.put("cop_mapg_seq", copMapgSeq);
			param.put("cop_op_tp_cd", "F");
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdMapByPcCreateFailUSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param mapSeq
	 * @param bkgNo
	 * @param mainPatternPctlNo
	 * @param copPattOrdNo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdMapByPcNo(String mapSeq, String bkgNo,
			String mainPatternPctlNo, String copPattOrdNo) throws DAOException{
		// TODO Auto-generated method stub

		//query parameter
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		log.debug("\n\n===============mapSeq:"+mapSeq);
		if(mapSeq.equals("")){
			throw new DAOException((new ErrorHandler("PRD00072")).getMessage());
		}
		
		try{
			param.put("bkg_no", bkgNo);
			param.put("pctl_no", mainPatternPctlNo);
			param.put("cop_patt_ord_no", copPattOrdNo);
			param.put("cop_mapg_seq", mapSeq);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdMapByPcNoUSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param pctl_no
	 * @return
	 * @throws DAOException
	 */
	public List searchProductCatalogInternalDetail(String pctl_no) throws DAOException {
		// TODO Auto-generated method stub
		List list = null;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("pctl_no", pctl_no);

			list = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchProductCatalogInternalDetailRSQL(), param, null, ProductCatalogInternalDetailVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param viewPctlNo
	 * @return
	 * @throws DAOException
	 */
	public List getPrdMst(String viewPctlNo) throws DAOException {
		// TODO Auto-generated method stub
		List list = null;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("pctl_no", viewPctlNo);

			list = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchProductCatalogMstRSQL(), param, null, PrdProdCtlMstVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param mstVo
	 * @param sumBkgQty
	 * @param sumCTpSz
	 * @return
	 * @throws DAOException
	 */
	public Map getFreeTime(PrdProdCtlMstVO mstVo, String sumBkgQty, String sumCTpSz) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> resultMap  = new HashMap<String, Object>();


		try {
			

			param.put("i_z_bkg_no        ".trim(), "");
			param.put("i_z_vsl_cd        ".trim(), mstVo.getTrnkVslCd());
			param.put("i_z_voyage_no     ".trim(), mstVo.getTrnkSkdVoyNo());
			param.put("i_z_dir_cd        ".trim(), mstVo.getTrnkSkdDirCd());
			param.put("i_z_por_loc       ".trim(), mstVo.getPorCd());
			param.put("i_z_pol_loc       ".trim(), mstVo.getPolNodCd()); //(YARD CODE까지 포함한  7자리)
			param.put("i_z_pod_loc       ".trim(), mstVo.getPodCd());
			param.put("i_z_del_loc       ".trim(), mstVo.getDelCd());
			param.put("i_z_cust_cnt_cd   ".trim(), "");
			param.put("i_z_cust_cd       ".trim(), "");
			param.put("i_z_cmdt_cd       ".trim(), mstVo.getCmdtCd());
			param.put("i_z_rep_cmdt_cd   ".trim(), mstVo.getRepCmdtCd());
			param.put("i_dcs_cntr_tp     ".trim(), sumCTpSz);
			param.put("i_brh_sc_no       ".trim(), mstVo.getScNo());
			param.put("i_brh_rfa_no      ".trim(), mstVo.getRfaNo());
			param.put("i_z_bcntr_spe_dg  ".trim(), mstVo.getDgSpclFlg());
			param.put("i_z_bcntr_spe_rf  ".trim(), mstVo.getRfSpclFlg());
			param.put("i_z_bcntr_spe_ak  ".trim(), mstVo.getSpclAwkCgoFlg());
			param.put("i_z_bcntr_spe_rd  ".trim(), mstVo.getRdSpclFlg());
			param.put("i_z_bcntr_spe_bb  ".trim(), mstVo.getBbSpclFlg());
			param.put("i_z_bcntr_soc_ind ".trim(), mstVo.getSocFlg());
			param.put("i_z_dbc_bkg_qty   ".trim(), sumBkgQty);
			param.put("i_load_due_date   ".trim(), mstVo.getN1stVslLodgDueDt());
//			param.put("o_dcc_ft_cmnc     ".trim(), "");
//			param.put("o_ft_total_day    ".trim(), "");
//			param.put("o_msg_cd          ".trim(), "");
//			param.put("o_msg_desc		 ".trim(), "");
			
			resultMap = new SQLExecuter("PRD_HJSBAT").executeSP((ISQLTemplate)new ProductCatalogCreateDBDAOgetPrdProdCtlMstRSQL(), param, null);
			String o_dcc_ft_cmnc = (String) resultMap.get("o_dcc_ft_cmnc");
			String o_ft_total_day = (String) resultMap.get("o_ft_total_day");
			String o_msg_cd = (String) resultMap.get("o_msg_cd");
			String o_msg_desc = (String) resultMap.get("o_msg_desc");
			
			log.debug("\n ======================================================="
			+"\n  getFreeTime procedure Call       "
			+"\n  param:"+param.toString()
			
			+"\n  o_dcc_ft_cmnc: ["+o_dcc_ft_cmnc+"]"
			+"\n  o_ft_total_day:["+o_ft_total_day+"]"
			+"\n  o_msg_cd:      ["+o_msg_cd+"]"
			+"\n  o_msg_desc:    ["+o_msg_desc+"]"
			+"\n  resultMap:    ["+resultMap.toString()+"]"
			+"\n =======================================================");
 
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultMap;
	}

	/**
	 * @param viewPctlNo
	 * @return
	 * @throws DAOException
	 */
	public Map getCargoReturnTime(String viewPctlNo) throws DAOException {
		// CHM-201005416 : Rail Receiving Date 산출 로직 변경 요청.
		// 변수 인자 String viewPctlNo, String freeTm,	String freeDay 에서 String freeTm 제거 (2010.08.17)
		Map cargoRtnTmMap =   new HashMap();
		DBRowSet dbR = null;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("pctl_no", viewPctlNo);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOGetCargoReturnTimeRSQL(), param, null);
			
			if(dbR.next()){
				cargoRtnTmMap.put("RTN_TIME", dbR.getString("RTN_TIME"));
				cargoRtnTmMap.put("CUT_OFF", dbR.getString("CUT_OFF"));
				cargoRtnTmMap.put("ERD", dbR.getString("ERD"));
				log.debug("\n-------------------------------------" +
						"\n getCargoReturnTime" +
						"\n RTN_TIME:"+dbR.getString("RTN_TIME")+
						"\n CUT_OFF:"+dbR.getString("CUT_OFF")+
						"\n ERD:"+dbR.getString("ERD")+
						"\n-------------------------------------" );
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cargoRtnTmMap;
	}

	/**
	 * @param bkgPctlNo
	 * @param hdPctlNo
	 * @param i
	 * @throws DAOException
	 */
	public void createBkgCopyPrdQtyVvdUnchange(String bkgPctlNo,
			String hdPctlNo,  int i)  throws DAOException {
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("bkg_pctl_no", bkgPctlNo);
			param.put("hd_pctl_no", hdPctlNo);
			param.put("idx", i);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateBkgCopyPrdQtyVvdUnchangeCSQL(), param, null);
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
		
	}


	/**
	 * @param String cntrTpszQty
	 * @param String bkgNo
	 * @param String flexHgtFlg
	 * @return DBRowSet
	 * @throws DAOException 
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 채창호 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청
	 */
	public DBRowSet checkQtyReplan( String cntrTpszQty, String bkgNo ,String flexHgtFlg) throws DAOException {
		DBRowSet dbR = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("cntr_tpsz_qty", cntrTpszQty);
			param.put("flex_hgt_flg", flexHgtFlg);
			
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOCheckQtyReplanRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param pctlNo
	 * @param mtPkupDt
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkMtPkupDt(String pctlNo, String mtPkupDt) throws DAOException {
		DBRowSet dbR = null;
		//query parameter

		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("pctl_no", pctlNo);
			param.put("mt_pu_dt", mtPkupDt);
			
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOCheckMtPuDtRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public List selectPrdMstByHdPctlNO(String hdPctlNo) throws DAOException {
		List list = null;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			DBRowSet dbR  = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSelectPrdMstByHdPctlNoRSQL(), param, null);
			
			list = (List)RowSetUtil.rowSetToVOs(dbR, PrdProdCtlMstVO .class);	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * @param pctlNo
	 * @param mtPuDt
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdDtlByMtPuDtValidate(String pctlNo, String mtPuDt) throws DAOException {

		//query parameter
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		log.debug("\n\n===============pctlNo:"+pctlNo);
		if(pctlNo.equals("") || pctlNo ==null){
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		}
		
		try{
			param.put("pctl_no", pctlNo);
			param.put("mt_pu_dt", mtPuDt);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdDtlByMtPuDtValidateUSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public int deletePrdQtyByMtPuDtValidate(String pctlNo)  throws DAOException {
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		log.debug("\n\n===============pctlNo:"+pctlNo);
		if(pctlNo.equals("") || pctlNo ==null){
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		}
		
		try{
			param.put("pctl_no", pctlNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAODeletePrdQtyByMtPuDtValidateDSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public int deletePrdActGrpByMtPuDtValidate(String pctlNo) throws DAOException {
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		log.debug("\n\n===============pctlNo:"+pctlNo);
		if(pctlNo.equals("") || pctlNo ==null){
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		}
		
		try{
			param.put("pctl_no", pctlNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdActGrpByPcNoDSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param pctlNo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdMstByMtPuDtValidate(String pctlNo) throws DAOException {
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		log.debug("\n\n===============pctlNo:"+pctlNo);
		if(pctlNo.equals("") || pctlNo ==null){
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		}
		
		try{
			param.put("pctl_no", pctlNo);
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdMstByMtPuDtCalidateUSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}


	/**
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public String searchDirectOcn(String hdPctlNo) throws DAOException {
		String pctlNo = null;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("hd_pctl_no", hdPctlNo);

			DBRowSet dbR  = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchDirectOcnRSQL(), param, null);
			if(dbR.next()){
				pctlNo = dbR.getString("pctl_no");
			} else {
				pctlNo = "FAIL";
			}
			log.debug("\n\n searchDirectOcn pc no:"+pctlNo);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return pctlNo;
	}

	/**
	 * @param pctlNo
	 * @param pseudoVvd
	 * @throws DAOException
	 */
	public void updatePrdDtlByPseudoVvd(String pctlNo, String pseudoVvd) throws DAOException {
		 
		// TODO Auto-generated method stub
 
		//query parameter
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		if(pctlNo.equals("") ){
			throw new DAOException("Pctl No not found!");
		}  
		try{
 		
			param.put("pctl_no", pctlNo );
			param.put("pseudo_vvd", pseudoVvd);
 
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdDtlByPseudoVvdUSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * @param pctlNo
	 * @param pseudoVvd
	 * @throws DAOException
	 */
	public void updatePrdMstByPseudoVvd(String pctlNo, String pseudoVvd) throws DAOException {
		 
		// TODO Auto-generated method stub
 
		//query parameter
		int successFlag = 0;

		Map<String, Object> param = new HashMap<String, Object>();
		if(pctlNo.equals("") ){
			throw new DAOException((new ErrorHandler("PRD00073")).getMessage());
		}  
		try{
 		
			param.put("pctl_no", pctlNo );
			param.put("pseudo_vvd", pseudoVvd);
 
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdMstByPseudoVvdUSQL(), param, null);
 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * @param pctlNo
	 * @param mtPkupDt
	 * @return
	 * @throws DAOException
	 */
	public int setMtPkupDt(String pctlNo, String mtPkupDt)  throws DAOException {
		
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("pctl_no", pctlNo);
			param.put("mt_pu_dt", mtPkupDt);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOSetMtPuDtUSQL(), param, null);
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
	}

	/**
	 * @param prdPatternVO
	 * @param hdPctlNo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdBkgCopMapBySubPatternOrdNo(PrdPatternVO prdPatternVO,
			String hdPctlNo)  throws DAOException {
		int successFlag = 0;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hd_pctl_no", hdPctlNo);
			param.put("cop_mapg_seq", prdPatternVO.getCopMapgSeq());
			param.put("bkg_no", prdPatternVO.getBkgNo());
			param.put("cop_patt_ord_no", prdPatternVO.getCopPattOrdNo());
			log.debug("\n updatePrdBkgCopMapBySubPatternOrdNo cop_patt_ord_no:"+ prdPatternVO.getCopPattOrdNo());
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdBkgCopMapBySubPatternOrdNoUSQL(), param, null);
			log.debug("\n updatePrdBkgCopMapBySubPatternOrdNo successFlag:"+successFlag);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return successFlag;
		
	}
	
	/**
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String chkEurDr(String bkgNo)  throws DAOException {
		String eurDrFlg = null;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("bkg_no", bkgNo);

			DBRowSet dbR  = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchEurDoorChkRSQL(), param, null);
			if(dbR.next()){
				eurDrFlg = dbR.getString("EUR_DR_CHK");
			} else {
				eurDrFlg = "N";
			}
			log.debug("\n\n EUR Door Chk:"+eurDrFlg);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eurDrFlg;
	}

	/**
	 * @param bkgNo
	 * @param mapSeq
	 * @throws DAOException
	 */
	public void updatePrdMapReInit(String bkgNo, String mapSeq)  throws DAOException {
		int successFlag = 0;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("bkg_no", bkgNo);
			param.put("mapSeq", mapSeq);

			successFlag  = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOUpdatePrdMapReInitUSQLUSQL(), param, null);
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param bkgNo
	 * @param mapSeq
	 * @return List<PrdSearchEurDrRePatternVO>
	 * @throws DAOException
	 */
	public List<PrdSearchEurDrRePatternVO> getEurDr(String bkgNo, String mapSeq)  throws DAOException {
		List<PrdSearchEurDrRePatternVO> list = null;
		//query parameter
		Map<String, String> param = new HashMap();

		try{
			param.put("bkg_no", bkgNo);
			param.put("mapSeq", mapSeq);

			DBRowSet dbR  = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchEurDrRePatternRSQL(), param, null);
			
			list = (List)RowSetUtil.rowSetToVOs(dbR, PrdSearchEurDrRePatternVO.class);	

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * @param obPctlNo
	 * @param ibPctlNo
	 * @param ocnPctlNo
	 * @param newPctlNo
	 * @return
	 * @throws DAOException
	 */
	public int reCreatePrdForEurDoor(String obPctlNo, String ibPctlNo, String ocnPctlNo, String newPctlNo)  throws DAOException {
		//query parameter
		Map<String, String> param = new HashMap();
		int exeFlag = 0;

		try{
			param.put("obPctlNo", obPctlNo);
			param.put("ibPctlNo", ibPctlNo);
			param.put("ocnPctlNo",ocnPctlNo);
			param.put("newPctlNo",newPctlNo);

			exeFlag  = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateProductCatalogForEurDrCSQL(), param, null);
			
			log.debug("\n pc create (successFlag:"+exeFlag);
			
			if(exeFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return exeFlag;
	}

	/**
	 * @param pgmNo
	 * @return
	 * @throws DAOException
	 */
	public String getPrdLogOnOff(String pgmNo)  throws DAOException {
		// TODO Auto-generated method stub
		int exeFlag = 0;
		String logOnOffStr = "N";
		Map<String, String> param = new HashMap();
		
		try{
			param.put("pgm_no", pgmNo);
			DBRowSet dbR  = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOPrdLogOnOffRSQL(), param, null);
			
			if(dbR!= null && dbR.next() ){
				logOnOffStr = dbR.getString("PCTL_PGM_ROLE_CD");
			}
			
			if(exeFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
		return logOnOffStr;
	}

	/**
	 * @param logDesc
	 * @param applInfo
	 * @param usrId
	 * @throws DAOException
	 */
	public void createPrdExecEnisLog(String logDesc, String applInfo, String usrId)  throws DAOException {
		// TODO Auto-generated method stub
//		List list = null;
		//query parameter
		Map<String, String> param = new HashMap();
		int exeFlag = 0;

		try{
			param.put("mod_name", "PRD id:"+usrId);
			param.put("log_desc", logDesc);
			param.put("appl_info",applInfo.length()>30 ? applInfo.substring(0, 29):applInfo);

			exeFlag  = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOPrdExecEnisLogCSQL(), param, null);
			
			log.debug("\n pc create (successFlag:"+exeFlag);
			
			if(exeFlag == Statement.EXECUTE_FAILED){
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
		
	}

	/**
	 * PrdBkgCopMapVO 배열을 한번에 Insert함 
	 * 
	 * @param List<PrdBkgCopMapVO> prdBkgCopMapVOs 데이터객체 배열
	 * @throws DAOException
	 */
	public void addReplanPatterns(List<PrdBkgCopMapVO> prdBkgCopMapVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prdBkgCopMapVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new ProductCatalogCreateDBDAOAddReplanPatternsCSQL(), prdBkgCopMapVOs, null);
				for (int i = 0; insCnt != null && i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * @param String bkgNo
	 * @return DBRowSet
	 * @throws DAOException
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 채창호 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청
	 */
	public DBRowSet checkBkgQty(String bkgNo)  throws DAOException {
		DBRowSet dbR = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOCheckBkgQtyRSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbR;
	}

	/**
	 * @param PrdMainInfoVO prdMainInfoVO
	 * @param String adjTpszQty D4@1,D5@2 형식의 container size type 및 quantity (조정을 위한 qty만 들어온다)
	 * @param String mapgSeq
	 * @param String bkgNoLstStr
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 박만건 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청
	 */
	public boolean createBkgSplitMapAdj(PrdMainInfoVO prdMainInfoVO, String adjTpszQty, String mapgSeq, String bkgNoLstStr) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no"       , prdMainInfoVO.getBkgNo());
			param.put("parent_bkg_no", prdMainInfoVO.getParentBkgNo());
			param.put("bkg_ofc"      , prdMainInfoVO.getBkgOfc());
			param.put("adj_tpsz_qty" , adjTpszQty);
			param.put("flex_hgt_flg" , ""); // 제거 DB에 있는 값 사용하면 됨
			param.put("mapg_seq"     , mapgSeq);
			param.put("bkg_no_list"  , bkgNoLstStr);

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateBkgSplitMapAdjCSQL(), param, null);

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
	 * @param String parentBkgNo
	 * @param String bkgNo
	 * @param String mapgSeq
	 * @return boolean 성공 실패 여부
	 * @throws DAOException
     * ----------------------------------------------------------------------
     * HISTORY
     * 2010.09.17 박만건 [CHM-201005548] [SCEM / PRD] F.H. 기능 연계한 개발요청
	 */
	public boolean createBkgSplitMapCopAdj(String parentBkgNo, String bkgNo, String mapgSeq) throws DAOException {
		// TODO Auto-generated method stub
		int successFlag = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no"       , bkgNo);
			param.put("parent_bkg_no", parentBkgNo);
			param.put("mapg_seq"     , mapgSeq);
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new ProductCatalogCreateDBDAOCreateBkgSplitMapCopAdjUSQL(), param, null);

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
	 * @param parentBkgNo Mother Booking 번호
	 * @param bkgNoList   Split Booking 번호들
	 * @return boolean  성공실패 여부
	 * @throws DAOException
	 */
	public boolean checkBeforeBkgSplit(String parentBkgNo, String bkgNoList) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dbR = null;
		boolean rtnChk = true;
		try{
			param.put("bkg_no"       , parentBkgNo);
			param.put("bkg_no_list"  , bkgNoList);
			
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOCheckBeforeBkgSplitRSQL(), param, null);
			if(dbR.next()){
				String rtnStr = dbR.getString("CHK_EXISTS");
				if (rtnStr.equals("1")) {
					rtnChk = false;
				}
			}
		}catch(SQLException se){
			// lock에 실패할 경우 에러를 발생한다.
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnChk;
	}
	
	
	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws DAOException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoNode(String pctlNo) throws DAOException {
		List<PrdConstraintInfoVO> prdConstraintInfoList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", pctlNo);
			prdConstraintInfoList = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdCnstInfoNodeRSQL(), param, param, PrdConstraintInfoVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return prdConstraintInfoList;
	}

	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws DAOException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoLink(String pctlNo) throws DAOException {
		List<PrdConstraintInfoVO> prdConstraintInfoList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", pctlNo);
			prdConstraintInfoList = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdCnstInfoLinkRSQL(), param, param, PrdConstraintInfoVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return prdConstraintInfoList;
	}
	
	/**
	 * @param String pctlNo
	 * @return List<PrdConstraintInfoVO>
	 * @throws DAOException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoRoute(String pctlNo) throws DAOException {
		List<PrdConstraintInfoVO> prdConstraintInfoList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("pctl_no", pctlNo);
			prdConstraintInfoList = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdCnstInfoRouteRSQL(), param, null, PrdConstraintInfoVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return prdConstraintInfoList;
	}
	
	/**
	 * @param PrdSearchParamVO prdSearchParamVO
	 * @return List<PrdConstraintInfoVO>
	 * @throws DAOException
	 */
	public List<PrdConstraintInfoVO> searchPrdCnstInfoIrgPolPod(PrdSearchParamVO prdSearchParamVO) throws DAOException {
		List<PrdConstraintInfoVO> prdConstraintInfoList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = prdSearchParamVO .getColumnValues();
//			param.put("pctl_no", prdSearchParamVO);
			param.putAll(mapVO);
			prdConstraintInfoList = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdCnstInfoIrgPolPodRSQL(), param, null, PrdConstraintInfoVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return prdConstraintInfoList;
	}

	/**
	 * @param String pctlNo
	 * @return Map getCanadaCargoReturnTimeIncludeHolyday
	 * @throws DAOException
	 */
	public String getCanadaCargoReturnTimeIncludeHolyday(String pctlNo) throws DAOException {
		// CHM-201005416 : Rail Receiving Date 산출 로직 변경 요청.
		// 변수 인자 String viewPctlNo, String freeTm,	String freeDay 에서 String freeTm 제거 (2010.08.17)
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String inchldy = "0";
		try{
			param.put("pctl_no", pctlNo);

			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeIncludeHolydayRSQL(), param, null);
			
			if(dbR.next()){
				inchldy = dbR.getString("INC_HLYDY");
				log.info("\n-------------------------------------" +
						"\n INC_HLYDY:"+dbR.getString("INC_HLYDY")+
						"\n-------------------------------------" );
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return inchldy;
	}
	
	/**
	 * @param String pctlNo
	 * @return Map cargoRtnTmMap
	 * @throws DAOException
	 */
	public Map getCanadaCargoReturnTime(String pctlNo, String holyday, String bkgNo) throws DAOException {
		// CHM-201005416 : Rail Receiving Date 산출 로직 변경 요청.
		// 변수 인자 String viewPctlNo, String freeTm,	String freeDay 에서 String freeTm 제거 (2010.08.17)
		Map<String, Object> cargoRtnTmMap =   new HashMap<String, Object>();
		DBRowSet dbR = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("pctl_no", pctlNo);
			param.put("holyday", holyday);
			param.put("bkg_no", bkgNo);
			
			
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOGetCanadaCargoReturnTimeRSQL(), param, param);
			
			if(dbR.next()){
				cargoRtnTmMap.put("RTN_TIME", dbR.getString("RTN_TIME"));
				cargoRtnTmMap.put("CUT_OFF", dbR.getString("CUT_OFF"));
				log.debug("\n-------------------------------------" +
						"\n getCargoReturnTime" +
						"\n RTN_TIME:"+dbR.getString("RTN_TIME")+
						"\n CUT_OFF:"+dbR.getString("CUT_OFF")+
						"\n-------------------------------------" );
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cargoRtnTmMap;
	}

	/**
	 * @param String pctlNo
	 * @return String cnCnst
	 * @throws DAOException
	 */
	public String searchPrdCnstInfoCanadaException(String pctlNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String cnCnst = "";
		DBRowSet dbR = null;
		try{
			
			param.put("pctl_no", pctlNo);
			dbR = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOSearchPrdCnstInfoCanadaExceptionRSQL(), param, null);
			if(dbR.next()){
				log.debug("\n-------------------------------------" +
						"\n searchPrdCnstInfoCanadaException" +
						"\n CA_CNST:"+dbR.getString("CA_CNST")+
						"\n-------------------------------------" );
				cnCnst = dbR.getString("CA_CNST");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnCnst;
	}

	/**
	 * @param bkgRcvT
	 * @param bkgDelT
	 * @param chgRterm
	 * @param chgDterm
	 * @param bkgNo
	 * @param mapSeq
	 * @param currentFlag
	 * @param flxHgtFlg
	 * @param cntrTpszQty
	 * @param bkgOfc
	 * @return
	 * @throws DAOException
	 */
	public List<PrdBkgCopMapVO> getReplanePatternOld(String bkgRcvT, String bkgDelT, String chgRterm, String chgDterm, String bkgNo, String mapSeq, String currentFlag
            ,String flxHgtFlg , String cntrTpszQty , String bkgOfc) throws DAOException {
//				DBRowSet dbR = null;
				//query parameter
				DBRowSet dbRowset = null;
				List<PrdBkgCopMapVO> list = null;
				
				Map<String, Object> param = new HashMap<String, Object>();
				//int exeFlag = 0;
				try{
					param.put("rcv_t", chgRterm);
					param.put("bkg_rcv_t", bkgRcvT);
					param.put("del_t", chgDterm);
					param.put("bkg_del_t", bkgDelT);
					param.put("bkg_no", bkgNo);
					param.put("mapg_seq", mapSeq);
					param.put("current_flag", currentFlag);
					param.put("flex_hgt_flg", flxHgtFlg);
					param.put("cntr_tpsz_qty", cntrTpszQty);
					param.put("bkg_ofc", bkgOfc);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ProductCatalogCreateDBDAOGetReplanePatternOldRSQL(), param, null);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrdBkgCopMapVO.class);
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage(), se);
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
				}
		            return list;
	}
}
