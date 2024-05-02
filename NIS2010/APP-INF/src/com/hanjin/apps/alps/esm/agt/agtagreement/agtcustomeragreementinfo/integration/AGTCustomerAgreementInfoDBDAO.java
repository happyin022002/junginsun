/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerAgreementInfoDBDAO.java
*@FileTitle : Agent Commission Customer Agreement Information Managemnet 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-30 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.basic.AGTCustomerAgreementInfoBCImpl;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.vo.SendMailLocalDateVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtBrogAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtFacAgmtGrpLocListVO;
import com.hanjin.syscommon.common.table.AgtFacAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtScsAgmtRtVO;


/**
 * eNIS-AGT에 대한 DB 처리를 담당<br>
 * - eNIS-AGT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang GyeongNam
 * @see AGTCustomerAgreementInfoBCImpl 참조
 * @since J2EE 1.4
 */
public class AGTCustomerAgreementInfoDBDAO extends DBDAOSupport {

	/**
	 * (ESM_AGT_007) 미주 Brokerage 계약 요율 목록을 가져온다.<br>
	 * 
	 * @param AgtBrogAgmtRtVO agtBrogAgmtRtVO
	 * @return List<AgtBrogAgmtRtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtBrogAgmtRtVO> searchUSABrokerageRateInfoList(AgtBrogAgmtRtVO agtBrogAgmtRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtBrogAgmtRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtBrogAgmtRtVO != null){
				Map<String, String> mapVO = agtBrogAgmtRtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtBrogAgmtRtVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * (ESM_AGT_007) 미주 Brokerage 계약 요율 정보를 등록한다.<br>
	 * 
	 * @param AgtBrogAgmtRtVO agtBrogAgmtRtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiUSABrokerageRateInfo(AgtBrogAgmtRtVO agtBrogAgmtRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = agtBrogAgmtRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * (ESM_AGT_007) 미주 Brokerage 계약 요율 정보를 수정한다.<br>
	 * 
	 * @param AgtBrogAgmtRtVO agtBrogAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiUSABrokerageRateInfo(AgtBrogAgmtRtVO agtBrogAgmtRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = agtBrogAgmtRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * (ESM_AGT_007) 미주 Brokerage 계약 요율 정보를 삭제한다.<br>
	 * 
	 * @param AgtBrogAgmtRtVO agtBrogAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiUSABrokerageRateInfo(AgtBrogAgmtRtVO agtBrogAgmtRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = agtBrogAgmtRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * (ESM_AGT_007) 미주 Brokerage 계약 요율 정보를 등록한다.<br>
	 * 
	 * @param List<AgtBrogAgmtRtVO> agtBrogAgmtRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiUSABrokerageRateInfoS(List<AgtBrogAgmtRtVO> agtBrogAgmtRtVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtBrogAgmtRtVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVOCSQL(), agtBrogAgmtRtVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * (ESM_AGT_007) 미주 Brokerage 계약 요율 정보를 수정한다.<br>
	 * 
	 * @param List<AgtBrogAgmtRtVO> agtBrogAgmtRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiUSABrokerageRateInfoS(List<AgtBrogAgmtRtVO> agtBrogAgmtRtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtBrogAgmtRtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVOUSQL(), agtBrogAgmtRtVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * (ESM_AGT_007) 미주 Brokerage 계약 요율 정보를 삭제한다.<br>
	 * 
	 * @param List<AgtBrogAgmtRtVO> agtBrogAgmtRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiUSABrokerageRateInfoS(List<AgtBrogAgmtRtVO> agtBrogAgmtRtVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtBrogAgmtRtVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtBrogAgmtRtVODSQL(), agtBrogAgmtRtVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * (ESM_AGT_008) 구주 FAC 계약 요율 목록을 가져온다.<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return List<AgtFacAgmtRtVO>
	 * @throws DAOException
	 */
	public List<AgtFacAgmtRtVO> searchFACRateInfoLIst(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dbRowSet = null;
		List<AgtFacAgmtRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			log.info("\n agtFacAgmtRtVO="+agtFacAgmtRtVO);
			if(agtFacAgmtRtVO != null){
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
			}
			log.info("\n param="+param);
			log.info("\n param="+velParam);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AgtFacAgmtRtVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * (ESM_AGT_008) 구주 FAC 계약 요율 목록을 가져온다.<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return AgtFacAgmtRtVO
	 * @throws DAOException
	 */
	public AgtFacAgmtRtVO searchFACRateInfoSeqLIst(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException{
	    // TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtFacAgmtRtVO> list = null;
		AgtFacAgmtRtVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			log.info("\n agtFacAgmtRtVO="+agtFacAgmtRtVO);
			if(agtFacAgmtRtVO != null){
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
			}
			log.info("\n param="+param);
			log.info("\n param="+velParam);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtSeqVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AgtFacAgmtRtVO.class);
			if(list.size() > 0){
				result = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
    }
	/**
	 * (ESM_AGT_008) 구주 FAC 계약 요율 저장한다..<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiFACRateInfo(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException, Exception{
		// TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			log.info("\n >>>>>>>>>start 1");
			SQLExecuter sqlExe = new SQLExecuter("");
			log.info("\n >>>>>>>>>start 2 = "+agtFacAgmtRtVO);
			if(agtFacAgmtRtVO != null ){
				log.info("\n >>>>>>>>>start 3");
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
	
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return insCnt;
    }
	/**
	 * (ESM_AGT_008) 구주 FAC 계약 요율 저장한다..<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiFACRateInfo(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException, Exception{
		int upsCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtFacAgmtRtVO != null ){
				log.info("\n >>>>>>>>>start 3");
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			upsCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVO1USQL(),param, null);
			if (upsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return upsCnt;
    }
	/**
	 * (ESM_AGT_008) 구주 FAC 계약 요율 저장한다..<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiFACRateInfo2(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException, Exception{
		int upsCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtFacAgmtRtVO != null ){
				log.info("\n >>>>>>>>>start 3");
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			upsCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVO2USQL(),param, null);
			if (upsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return upsCnt;
    }
	/**
	 * (ESM_AGT_008) 구주 FAC 계약 요율 저장한다..<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deletemultiFACRateInfo(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int delCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtFacAgmtRtVO != null ){
				log.info("\n >>>>>>>>>start 3");
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtVODSQL(),param, null);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;	    
    }
	/**
	 * (ESM_AGT_0008) POR,POL,POD,DEL Type이 '*'가 아닌경우 POR,POL,POD,DEL이 코드테이블에 등록되어 있는지 체크.<br>
	 * 
	 * @param String grp_tp_cd 
	 * @param String cd
	 * @param String fac_ofc_cd
	 * @return int 
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchGroupTypeCd(String grp_tp_cd, String cd, String fac_ofc_cd) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//MdmContinentVO cntContinentVO = new MdmContinentVO();
		//MdmSubcontinentVO mdmSubcontinentVO = new MdmSubcontinentVO();
		//MdmCountryVO mdmCountryVO = new MdmCountryVO();
		//MdmRegionVO mdmRegionVO = new MdmRegionVO();
		//MdmLocationVO mdmLocationVO = new MdmLocationVO();
		
		int result = 0;
		try {
			if(grp_tp_cd.equals("1")){
				//Map<String, String> mapVO1 = cntContinentVO .getColumnValues();
//				param.putAll(mapVO1);
//				velParam.putAll(mapVO1);
				param.put("conti_cd", cd);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOMdmContinentCountVORSQL(), param, velParam);
			}else if(grp_tp_cd.equals("2")){
				//Map<String, String> mapVO2 = mdmSubcontinentVO .getColumnValues();
//				param.putAll(mapVO2);
//				velParam.putAll(mapVO2);
				param.put("sconti_cd", cd);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOMdmSubcontinentCountVORSQL(), param, velParam);
			}else if(grp_tp_cd.equals("3")){
				//Map<String, String> mapVO3 = mdmCountryVO .getColumnValues();
//				param.putAll(mapVO3);
//				velParam.putAll(mapVO3);				
				param.put("cnt_cd", cd);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOMdmCountryCountVORSQL(), param, velParam);
			}else if(grp_tp_cd.equals("4")){			
				//Map<String, String> mapVO4 = mdmRegionVO .getColumnValues();
//				param.putAll(mapVO4);
//				velParam.putAll(mapVO4);
				param.put("rgn_cd", cd);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOMdmRegionCountVORSQL(), param, velParam);
			}else if(grp_tp_cd.equals("6")){
				//Map<String, String> mapVO6 = mdmLocationVO .getColumnValues();
//				param.putAll(mapVO6);
//				velParam.putAll(mapVO6);
				param.put("loc_cd", cd);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOMdmLocationCountVORSQL(), param, velParam);
			}
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
    }
	/**
	 * (ESM_AGT_0008) Requset
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return int 
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyFACRateRequest(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException, Exception{
		int upsCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtFacAgmtRtVO != null ){
				log.info("\n >>>>>>>>>start 3");
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			upsCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtRequestUSQL(),param, null);
			if (upsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return upsCnt;
	    
    }
	/**
	 * (ESM_AGT_0008) Approval
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @param SignOnUserAccount account 
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyFACRateApproval(AgtFacAgmtRtVO agtFacAgmtRtVO, SignOnUserAccount account) throws DAOException, Exception{
		int upsCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtFacAgmtRtVO != null ){
				log.info("\n >>>>>>>>>start 3");
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			upsCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtApprovalUSQL(),param, null);
			if (upsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return upsCnt;
    }
	/**
	 * ESM_AGT_0008 FAC Customer 조회
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return List<AgtFacAgmtRtVO>
	 */
	public List<AgtFacAgmtRtVO> searchFACCustomerInfo(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException, Exception{
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dbRowSet = null;
		List<AgtFacAgmtRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			log.info("\n agtFacAgmtRtVO="+agtFacAgmtRtVO);
			if(agtFacAgmtRtVO != null){
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
			}
			log.info("\n param="+param);
			log.info("\n param="+velParam);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOSearchFACCustomerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AgtFacAgmtRtVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	
	/**
	 * ESM_AGT_0008 Request 수행 후 메일을 보낼때 날짜 조회
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return SendMailLocalDateVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public SendMailLocalDateVO sendAGTTemplateMailLocalDate(AgtFacAgmtRtVO agtFacAgmtRtVO) throws DAOException, Exception{
		SendMailLocalDateVO locDat = null;
	    DBRowSet dbRowSet = null;
		List<SendMailLocalDateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {

			if(agtFacAgmtRtVO != null){
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
			}
			log.info("\n param="+param);
			log.info("\n param="+velParam);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtSendMailLocalDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, SendMailLocalDateVO.class);
			if(list.size() > 0){
				locDat = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return locDat;
    }
    /**
	 * (ESM_AGT_035)FAC Location 목록을 가져온다.<br>
	 * 
	 * @param AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocListVO
	 * @return List<AgtFacAgmtGrpLocListVO>
	 * @throws DAOException
	 * @throws EventException
	 */
	public List<AgtFacAgmtGrpLocListVO> searchFACGrpLocList(AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocListVO) throws DAOException, EventException {
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dbRowSet = null;
		List<AgtFacAgmtGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
//		queryStr.append("SELECT rout_info_cd \n");
//		queryStr.append(" FROM agt_fac_agmt_grp_loc \n");
//		queryStr.append("WHERE fac_ofc_cd = ? \n");
//		queryStr.append("	AND rout_ref_div_cd = ? \n");
//		queryStr.append("	AND frt_fwrd_cnt_cd = ? \n");
//		queryStr.append("	AND frt_fwrd_cust_seq = ? \n");
//		queryStr.append("	AND fac_rt_seq = ? \n");

		try {
			if(agtFacAgmtGrpLocListVO != null){
				Map<String, String> mapVO = agtFacAgmtGrpLocListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOSearchFACGrpLocListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AgtFacAgmtGrpLocListVO.class);
			
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return list;
	}
	/**
	 * Reject 이벤트 처리<br>
	 * ESM_AGT_008 화면에 대한 멀티 이벤트 처리<br>
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws DAOException
	 * @throws EventException
	 */

	public int modifyFACRateReject(AgtFacAgmtRtVO agtFacAgmtRtVO,
			SignOnUserAccount account) throws DAOException, EventException{
		
		int upsCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtFacAgmtRtVO != null){
				Map<String, String> mapVO = agtFacAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			upsCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTCustomerAgreementInfoDBDAOAgtFacAgmtRtRejectUSQL(),param, null);
			if (upsCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return upsCnt;
	}


	/**
	 * (ESM_AGT_0057) Special Compensation 계약 요율 목록을 가져온다.<br>
	 * 
	 * @param AgtScsAgmtRtVO agtScsAgmtRtVO
	 * @return List<AgtScsAgmtRtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtScsAgmtRtVO> searchScsRateInfoList(AgtScsAgmtRtVO agtScsAgmtRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtScsAgmtRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtScsAgmtRtVO != null){
				Map<String, String> mapVO = agtScsAgmtRtVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtScsAgmtRtVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * (ESM_AGT_0057) Special Compensation 계약 요율 정보를 등록한다.<br>
	 * 
	 * @param AgtScsAgmtRtVO agtScsAgmtRtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmultiScsRateInfo(AgtScsAgmtRtVO agtScsAgmtRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = agtScsAgmtRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * (ESM_AGT_0057) Special Compensation 계약 요율 정보를 수정한다.<br>
	 * 
	 * @param AgtScsAgmtRtVO agtScsAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiScsRateInfo(AgtScsAgmtRtVO agtScsAgmtRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = agtScsAgmtRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * (ESM_AGT_0057) Special Compensation 계약 요율 정보를 삭제한다.<br>
	 * 
	 * @param AgtScsAgmtRtVO agtScsAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiScsRateInfo(AgtScsAgmtRtVO agtScsAgmtRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = agtScsAgmtRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * (ESM_AGT_0057) Special Compensation 계약 요율 정보를 등록한다.<br>
	 * 
	 * @param List<AgtScsAgmtRtVO> agtScsAgmtRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiScsRateInfoS(List<AgtScsAgmtRtVO> agtScsAgmtRtVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtScsAgmtRtVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVOCSQL(), agtScsAgmtRtVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * (ESM_AGT_0057) Special Compensation 계약 요율 정보를 수정한다.<br>
	 * 
	 * @param List<AgtScsAgmtRtVO> agtScsAgmtRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiScsRateInfoS(List<AgtScsAgmtRtVO> agtScsAgmtRtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtScsAgmtRtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVOUSQL(), agtScsAgmtRtVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * (ESM_AGT_0057) Special Compensation 계약 요율 정보를 삭제한다.<br>
	 * 
	 * @param List<AgtScsAgmtRtVO> agtScsAgmtRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiScsRateInfoS(List<AgtScsAgmtRtVO> agtScsAgmtRtVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(agtScsAgmtRtVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerAgreementInfoDBDAOAgtScsAgmtRtVODSQL(), agtScsAgmtRtVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}


}
