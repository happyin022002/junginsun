/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSOCodeFinderDBDAO.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon.psocodefinder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic.PSOCodeFinderBCImpl;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS PSOCodeFinderDBDAO <br>
 * - ALPS-PSOCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jin Ihl
 * @see PSOCodeFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class PSOCodeFinderDBDAO extends DBDAOSupport {

	/**
	 * PSOCodeFinderDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
//	 @SuppressWarnings("unchecked")
//	public List<PsoMsaVO> PsoMsaVO(PsoMsaVO psoMsaVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<PsoMsaVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(psoMsaVO != null){
//				Map<String, String> mapVO = psoMsaVO .getColumnValues();
//			
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//            PSOCodeFinderDBDAOPsoMsaVORSQL template = new PSOCodeFinderDBDAOPsoMsaVORSQL();
//			dbRowset = sqlExe.executeQuery(template, param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoMsaVO .class);
//		}catch(SQLException ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}
//		return list;
//	}
///**
//	 * 단건의 데이터를 생성한다.<br>
//	 * 
//	 * @param ownerVO 데이터객체
//	 * @throws DAOException
//	 */
//	public void addPsoMsaDtlVO(PsoMsaDtlVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			PSOCodeFinderDBDAOPsoMsaDtlVOCSQL template = new PSOCodeFinderDBDAOPsoMsaDtlVOCSQL();
//			int result = sqlExe.executeUpdate(template, param, velParam);
//			if(result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//		} catch (SQLException ex) {
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}
//	}
//	
//	/**
//	 * 단건의 데이터를 갱신한다.<br>
//	 * 
//	 * @param ownerVO 데이터객체
//	 * @throws DAOException
//	 */
//	public int modifyPsoMsaDtlVO(PsoMsaDtlVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			PSOCodeFinderDBDAOPsoMsaDtlVOUSQL template = new PSOCodeFinderDBDAOPsoMsaDtlVOUSQL();
//			result = sqlExe.executeUpdate(template, param, velParam);
//			if(result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//		} catch (SQLException ex) {
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}
//		return result;
//	}
//	
//	/**
//	 * 단건의 데이터를 삭제한다.<br>
//	 * 
//	 * @param ownerVO 데이터객체
//	 * @throws DAOException
//	 */
//	public int removePsoMsaDtlVO(PsoMsaDtlVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			PSOCodeFinderDBDAOPsoMsaDtlVODSQL template = new PSOCodeFinderDBDAOPsoMsaDtlVODSQL();
//			result = sqlExe.executeUpdate(template, param, velParam);
//			if(result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//		} catch (SQLException ex) {
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}
//		return result;
//	}
//
//	/**
//	 * 다건의 데이터를 일괄적으로 생성한다.<br>
//	 * 
//	 * @param fmsOwnerVos 데이터객체 배열
//	 * @throws DAOException
//	 */
//	public void addPsoMsaDtlVOS(List<PsoMsaDtlVO> insModels) throws DAOException,Exception {
//		try {
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			PSOCodeFinderDBDAOPsoMsaDtlVOCSQL template = new PSOCodeFinderDBDAOPsoMsaDtlVOCSQL();
//			int insCnt[] = null;
//			if(insModels.size() > 0){
//				insCnt = sqlExe.executeBatch(template, insModels, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException ex) {
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}
//	}
//	/**
//	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
//	 * 
//	 * @param fmsOwnerVos 데이터객체 배열
//	 * @throws DAOException
//	 */
//	public void modifyPsoMsaDtlVOS(List<PsoMsaDtlVO> updModels) throws DAOException,Exception {
//		try {
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			PSOCodeFinderDBDAOPsoMsaDtlVOUSQL template = new PSOCodeFinderDBDAOPsoMsaDtlVOUSQL();
//			int updCnt[] = null;
//			if(updModels.size() > 0){
//				updCnt = sqlExe.executeBatch(template, updModels, null);
//				for(int i = 0; i < updCnt.length; i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException ex) {
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}
//	}
//	
//	/**
//	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
//	 * 
//	 * @param delModels 데이터객체 배열
//	 * @throws DAOException
//	 */
//	public void removePsoMsaDtlVOS(List<PsoMsaDtlVO> delModels) throws DAOException,Exception {
//		try {
//            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			PSOCodeFinderDBDAOPsoMsaDtlVODSQL template = new PSOCodeFinderDBDAOPsoMsaDtlVODSQL();
//			int delCnt[] = null;
//			if(delModels.size() > 0){
//				delCnt = sqlExe.executeBatch(template, delModels, null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException ex) {
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			//log.error(ex.getMessage(),ex);
//			throw new DAOException(ex.getMessage(), ex);
//		}
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * vessel class를 조회한다.<br>
	 * @return List<MdmVslCntrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmVslCntrVO> searchVesselClassList() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOsearchVslClassListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * Account를 조회한다.<br>
	 * @return List<CostListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CostListVO> searchAccountList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CostListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOsearchAccountListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CostListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		
		
	/**
	 * Account를 조회한다.<br>
	 * @param String ofcCd
	 * @return List<CostListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CostListVO> searchAccountList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CostListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOsearchAccountListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CostListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 

	 
	/**
	 *  vndrSeq를 기준으로 해당 Vendor의 이름을 조회한다.
	 * @param String vndrSeq
	 * @return String 
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public String searchVendorName(String vndrSeq) throws DAOException {
		// TODO Auto-generated method stub
		String strRet = "";
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vndrSeq != null ){
				HashMap hMap = new HashMap<String, Integer>();
				hMap.put("vndr_seq", vndrSeq);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOsearchVendorsRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString("VNDR_LGL_ENG_NM");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		//return list.toString();
		return strRet;
	}


	/**
	 * Vendor List정보를 조회한다.
	 * @param  VendorListVO vendorListVO
	 * @return List<VendorListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VendorListVO> searchVendorList(VendorListVO vendorListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vendorListVO != null){
				Map<String, String> mapVO = vendorListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOsearchVendorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorListVO.class);
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * VVD가 존재하는지 체크  
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String ydCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkVslPortSkdVvd(String vslCd, String skdVoyNo,
			String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean bRet = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vslCd != null){
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				velParam.put("vsl_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOcheckVslPortSkdVvdRSQL(), param, velParam);
			if(dbRowset.next()){
				String strRet = dbRowset.getString(1);
				bRet = strRet.equals("0") ? false : true;
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return bRet;
	}

	/**
	 * Turn Port 구하기 
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String getTurnPortIndCd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vslCd != null){
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				velParam.put("vsl_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOgetTurnPortIndCdRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return strRet;
	}
	
	/**
	 * 존재하는 Lane인지 체크
	 * @param  String rlaneCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String checkRevLane(String rlaneCd) throws DAOException {
		DBRowSet dbRowset = null;
		String isLane = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("rlane_cd", rlaneCd);
		velParam.put("rlane_cd", rlaneCd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOCheckRevLaneRSQL(), param, velParam);
			dbRowset.next();
			isLane = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isLane;
	}
	


	/**
	 * Turn Port IO 구분 구하기 
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param ydCd
	 * @return String
	 * @throws DAOException
	 */
	public String getDefaultTurnPortIndIoData(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vslCd != null){
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				param.put("yd_cd", ydCd);
				velParam.put("vsl_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
				velParam.put("yd_cd", ydCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOCheckTurnPortIndCdRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return strRet;
	}
	


	/**
	 * AR_MST_REV_VVD Check 구분 구하기 
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return String
	 * @throws DAOException
	 */
	public String checkArMasterRevenueByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strRet = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vslCd != null){
				param.put("vsl_cd", vslCd);
				param.put("skd_voy_no", skdVoyNo);
				param.put("skd_dir_cd", skdDirCd);
				velParam.put("vsl_cd", vslCd);
				velParam.put("skd_voy_no", skdVoyNo);
				velParam.put("skd_dir_cd", skdDirCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOCheckArMasterRevenueByVvdRSQL(), param, velParam);
			if(dbRowset.next()){
				strRet = dbRowset.getString(1);
			}
			
			strRet = StringUtils.isNotEmpty(strRet) ? "Y" : "N";
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return strRet;
	}	 

	 
	/**
	 *  clpt_ind_seq를 조회한다.
	 * @param String vvd
	 * @param String ydCd
	 * @return String 
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public String searchClptIndSeq(String vvd, String ydCd) throws DAOException {
		String strRet = "";
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vvd != null ){
				HashMap hMap = new HashMap<String, Integer>();
				hMap.put("vvd", vvd);
				hMap.put("yd_cd", ydCd);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PSOCodeFinderDBDAOSearchClptIndSeqRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString("CLPA_IND_SEQS");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRet;
	}
			 
}
