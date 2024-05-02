/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IMDGCodeMgtDBDAO.java
*@FileTitle : UN Number
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.18 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBCImpl;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.AutoCreationVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgUnNoSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationInputVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationOutputVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.common.ScgUtil;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ScgImdgClssSegrVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpSegrVO;
import com.clt.syscommon.common.table.ScgImdgExptQtyVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrSymVO;
import com.clt.syscommon.common.table.ScgImdgSubsRskLblVO;
import com.clt.syscommon.common.table.ScgImdgUnNoClssCdVO;
import com.clt.syscommon.common.table.ScgImdgUnNoOrgRactVO;
import com.clt.syscommon.common.table.ScgImdgUnNoSegrGrpVO;
import com.clt.syscommon.common.table.ScgImdgUnNoSpclProviVO;


/**
 * OPUS IMDGCodeMgtDBDAO <br>
 * - OPUS-DangerousCargoInformationMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dohyoung Lee
 * @see IMDGCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class IMDGCodeMgtDBDAO extends DBDAOSupport {

	/**
	 * UN Number 의 Detail을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO UNNumberListOptionVO
	 * @return List<UNNumberListOptionVO>
	 * @throws DAOException
	 */
	public List<UNNumberListOptionVO> searchUNNumberList(UNNumberListOptionVO unNumberListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UNNumberListOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(unNumberListOptionVO != null){
				Map<String, String> mapVO = unNumberListOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOUNNumberListOptionVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UNNumberListOptionVO .class);
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
	 * Segregation을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return List<ScgImdgUnNoSegrListVO>
	 * @throws DAOException
	 */
	public List<ScgImdgUnNoSegrListVO> searchSegrList(UNNumberListOptionVO unNumberListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgUnNoSegrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(unNumberListOptionVO != null){
		    	param.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());			 
		    	param.put("imdg_un_no_seq", unNumberListOptionVO.getImdgUnNoSeq());			 

		    	velParam.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());
				velParam.put("imdg_un_no_seq", unNumberListOptionVO.getImdgUnNoSeq());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoSegrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgUnNoSegrListVO.class);
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
	 * Subsidiary risk(s)을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @throws DAOException
	 */
	 public String[] searchSubsRskLblList(UNNumberListOptionVO unNumberListOptionVO) throws DAOException {
		 DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
	    	param.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());			 
	    	param.put("imdg_un_no_seq", unNumberListOptionVO.getImdgUnNoSeq());			 

	    	velParam.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());
			velParam.put("imdg_un_no_seq", unNumberListOptionVO.getImdgUnNoSeq());

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new IMDGCodeMgtDBDAOScgImdgSubsRskLblVORSQL(),
							param, velParam);
			
			return ScgUtil.getArrayString(dbRowset, 3);
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }         
	}

	/**
	 * Special Provisions을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @throws DAOException
	 */
	 public String[] searchSpclProviList(UNNumberListOptionVO unNumberListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
	    	param.put("IMDG_UN_NO", unNumberListOptionVO.getImdgUnNo());			 
	    	param.put("IMDG_UN_NO_SEQ", unNumberListOptionVO.getImdgUnNoSeq());			 

	    	velParam.put("IMDG_UN_NO", unNumberListOptionVO.getImdgUnNo());
			velParam.put("IMDG_UN_NO_SEQ", unNumberListOptionVO.getImdgUnNoSeq());

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new IMDGCodeMgtDBDAOScgImdgSpclProviVORSQL(),
							param, velParam);
			
			return ScgUtil.getArrayString(dbRowset, 3);
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }         
	 }

	 /**
	  * Segregation Group Detail을 조회 합니다. <br>
	  * 
	  * @param unNumberListOptionVO
	  * @return String[]
	  * @throws DAOException
	  */
	 public String[] searchSegrGrpDtlList(UNNumberListOptionVO unNumberListOptionVO) throws DAOException {
		 DBRowSet dbRowset = null;
        
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
        
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{    
			 param.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());

			 velParam.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());

			 dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new IMDGCodeMgtDBDAOScgImdgSegrGrpDtlVORSQL(),
							param, velParam);
			
			 return ScgUtil.getArrayString(dbRowset, 1);
           
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }         
	 }

	/**
	 * Segregation Group을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @throws DAOException
	 */
	 public String[] searchSegrGrpList(UNNumberListOptionVO unNumberListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
	    	param.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());			 
	    	param.put("imdg_un_no_seq", unNumberListOptionVO.getImdgUnNoSeq());			 

	    	velParam.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());
			velParam.put("imdg_un_no_seq", unNumberListOptionVO.getImdgUnNoSeq());

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new IMDGCodeMgtDBDAOScgImdgUnNoSegrGrpVORSQL(),
							param, velParam);
			
			return ScgUtil.getArrayString(dbRowset, 3);
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }         
	}

	/**
	 * Clss Cd을 조회 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return String[]
	 * @throws DAOException
	 */
	 public String[] searchClssCdList(UNNumberListOptionVO unNumberListOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
	    	param.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());			 
	    	param.put("imdg_un_no_seq", unNumberListOptionVO.getImdgUnNoSeq());			 

	    	velParam.put("imdg_un_no", unNumberListOptionVO.getImdgUnNo());
			velParam.put("imdg_un_no_seq", unNumberListOptionVO.getImdgUnNoSeq());

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new IMDGCodeMgtDBDAOScgImdgUnNoClssCdVORSQL(),
							param, velParam);
			
			return ScgUtil.getArrayString(dbRowset, 5);
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }         
	}

	/**
	 * Excepted Q'ty을 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgExptQtyVO>
	 * @throws DAOException
	 */
	public List<ScgImdgExptQtyVO> searchExceptedQtyList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgExptQtyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgExptQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgExptQtyVO.class);
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
	 * Segregation Group의 List를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgSegrGrpVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSegrGrpVO> searchSegregationGroupList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSegrGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgSegrGrpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSegrGrpVO.class);
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
	 * AutoCreation의 Segregation을 조회 합니다. <br>
	 * 
	 * @param autoCreationVO
	 * @return List<ScgImdgUnNoSegrListVO>
	 * @throws DAOException
	 */
	 public List<ScgImdgUnNoSegrListVO> searchAutoCreation(AutoCreationVO autoCreationVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<ScgImdgUnNoSegrListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if (autoCreationVO.getFrmSegrAsForImdgClssCd() != "") {
		    	param.put("imdg_clss_cd", autoCreationVO.getFrmSegrAsForImdgClssCd());			 
		    	velParam.put("imdg_clss_cd", autoCreationVO.getFrmSegrAsForImdgClssCd());			 		
		    	param.put("imdg_subs_rsk_lbl_cd1", "");
		    	param.put("imdg_subs_rsk_lbl_cd2", "");
		    	param.put("imdg_subs_rsk_lbl_cd3", "");
		    	param.put("imdg_subs_rsk_lbl_cd4", "");
		 	}else{
		    	param.put("imdg_clss_cd", autoCreationVO.getFrmImdgClssCd());
		    	velParam.put("imdg_clss_cd", autoCreationVO.getFrmImdgClssCd());
		    	param.put("imdg_subs_rsk_lbl_cd1", autoCreationVO.getFrmImdgSubsRskLblCd1());
		    	param.put("imdg_subs_rsk_lbl_cd2", autoCreationVO.getFrmImdgSubsRskLblCd2());
		    	param.put("imdg_subs_rsk_lbl_cd3", autoCreationVO.getFrmImdgSubsRskLblCd3());
		    	param.put("imdg_subs_rsk_lbl_cd4", autoCreationVO.getFrmImdgSubsRskLblCd4());
		 	}
		 	
//	    	param.put("imdg_subs_rsk_lbl_cd1", autoCreationVO.getFrmImdgSubsRskLblCd1());
//	    	param.put("imdg_subs_rsk_lbl_cd2", autoCreationVO.getFrmImdgSubsRskLblCd2());
//	    	param.put("imdg_subs_rsk_lbl_cd3", autoCreationVO.getFrmImdgSubsRskLblCd3());
//	    	param.put("imdg_subs_rsk_lbl_cd4", autoCreationVO.getFrmImdgSubsRskLblCd4());
//
//	    	velParam.put("imdg_subs_rsk_lbl_cd1", autoCreationVO.getFrmImdgSubsRskLblCd1());
//			velParam.put("imdg_subs_rsk_lbl_cd2", autoCreationVO.getFrmImdgSubsRskLblCd2());
//			velParam.put("imdg_subs_rsk_lbl_cd3", autoCreationVO.getFrmImdgSubsRskLblCd3());
//			velParam.put("imdg_subs_rsk_lbl_cd4", autoCreationVO.getFrmImdgSubsRskLblCd4());

			String[] arrAwayFmImdgClssCd = autoCreationVO.getFrmAwayFmImdgClssCd().split("\\/");
			String[] arrSprtFmImdgClssCd = autoCreationVO.getFrmSprtFmImdgClssCd().split("\\/");
			String[] arrCompFmImdgClssCd = autoCreationVO.getFrmSprtHldFmImdgClssCd().split("\\/");
			String[] arrLongFmImdgClssCd = autoCreationVO.getFrmSprtLonFmImdgClssCd().split("\\/");

			for (int i=0; i < arrAwayFmImdgClssCd.length; i++) {
				if (arrAwayFmImdgClssCd[i] != null && !arrAwayFmImdgClssCd[i].equals("")) {
			    	param.put("away_fm_"+arrAwayFmImdgClssCd[i].replace(".", ""), "A");
			    	velParam.put("away_fm_"+arrAwayFmImdgClssCd[i].replace(".", ""), "A");			 		
				}
			}
			for (int i=0; i < arrSprtFmImdgClssCd.length; i++) {
				if (arrSprtFmImdgClssCd[i] != null && !arrSprtFmImdgClssCd[i].equals("")) {
			    	param.put("seq_fm_"+arrSprtFmImdgClssCd[i].replace(".", ""), "S");
			    	velParam.put("seq_fm_"+arrSprtFmImdgClssCd[i].replace(".", ""), "S");			 		
				}
			}
			for (int i=0; i < arrCompFmImdgClssCd.length; i++) {
				if (arrCompFmImdgClssCd[i] != null && !arrCompFmImdgClssCd[i].equals("")) {
			    	param.put("com_fm_"+arrCompFmImdgClssCd[i].replace(".", ""), "C");
			    	velParam.put("com_fm_"+arrCompFmImdgClssCd[i].replace(".", ""), "C");			 		
				}
			}
			for (int i=0; i < arrLongFmImdgClssCd.length; i++) {
				if (arrLongFmImdgClssCd[i] != null && !arrLongFmImdgClssCd[i].equals("")) {
			    	param.put("lon_fm_"+arrLongFmImdgClssCd[i].replace(".", ""), "L");
			    	velParam.put("lon_fm_"+arrLongFmImdgClssCd[i].replace(".", ""), "L");
				}
			}
			 
		 	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOAutoCreationRSQL(), param, velParam);
		 	list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgUnNoSegrListVO.class);
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
	 * UN Number을 생성 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @throws DAOException
	 */
	public void addUNNumber(UNNumberListOptionVO unNumberListOptionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = unNumberListOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * UN Number을 수정 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyUNNumber(UNNumberListOptionVO unNumberListOptionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = unNumberListOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * UN Number을 삭제 합니다. <br>
	 * 
	 * @param unNumberListOptionVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeUNNumber(UNNumberListOptionVO unNumberListOptionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = unNumberListOptionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * Subsidiary risk(s)을 생성 합니다. <br>
	 * 
	 * @param scgImdgSubsRskLblVOs
	 * @throws DAOException
	 */
	public void addSubsidiaryS(List<ScgImdgSubsRskLblVO> scgImdgSubsRskLblVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgSubsRskLblVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgSubsRskLblCSQL(), scgImdgSubsRskLblVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Subsidiary risk(s)을 삭제 합니다. <br>
	 * 
	 * @param scgImdgSubsRskLblVOs
	 * @throws DAOException
	 */
	public void removeSubsidiaryS(List<ScgImdgSubsRskLblVO> scgImdgSubsRskLblVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgSubsRskLblVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgSubsRskLblDSQL(), scgImdgSubsRskLblVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Special Provisions을 생성 합니다. <br>
	 * 
	 * @param scgImdgUnNoSpclProviVOs
	 * @throws DAOException
	 */
	public void addSpecialProvisionS(List<ScgImdgUnNoSpclProviVO> scgImdgUnNoSpclProviVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgUnNoSpclProviVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoSpclProviCSQL(), scgImdgUnNoSpclProviVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Special Provisions을 삭제 합니다. <br>
	 * 
	 * @param scgImdgUnNoSpclProviVOs
	 * @throws DAOException
	 */
	public void removeSpecialProvisionS(List<ScgImdgUnNoSpclProviVO> scgImdgUnNoSpclProviVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgUnNoSpclProviVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoSpclProviDSQL(), scgImdgUnNoSpclProviVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Segregation을 생성 합니다. <br>
	 * 
	 * @param scgImdgUnNoSegrListVOs
	 * @throws DAOException
	 */
	public void addSegrListS(List<ScgImdgUnNoSegrListVO> scgImdgUnNoSegrListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgUnNoSegrListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoSegrCSQL(), scgImdgUnNoSegrListVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Segregation을 수정 합니다. <br>
	 * 
	 * @param scgImdgUnNoSegrListVOs
	 * @throws DAOException
	 */
	public void modifySegrListS(List<ScgImdgUnNoSegrListVO> scgImdgUnNoSegrListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgUnNoSegrListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoSegrUSQL(), scgImdgUnNoSegrListVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Segregation을 삭제 합니다. <br>
	 * 
	 * @param scgImdgUnNoSegrListVOs
	 * @throws DAOException
	 */
	public void removeSegrListS(List<ScgImdgUnNoSegrListVO> scgImdgUnNoSegrListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgUnNoSegrListVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgimdgUnNoSegrDSQL(), scgImdgUnNoSegrListVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Clss Cd을 생성 합니다. <br>
	 * 
	 * @param scgImdgUnNoClssCdVOs
	 * @throws DAOException
	 */
	public void addClssCdListS(List<ScgImdgUnNoClssCdVO> scgImdgUnNoClssCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgUnNoClssCdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoClssCdVOCSQL(), scgImdgUnNoClssCdVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Clss Cd을 삭제 합니다. <br>
	 * 
	 * @param scgImdgUnNoClssCdVOs
	 * @throws DAOException
	 */
	public void removeClssCdListS(List<ScgImdgUnNoClssCdVO> scgImdgUnNoClssCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgUnNoClssCdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoClssCdVODSQL(), scgImdgUnNoClssCdVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Segregation Group을 생성 합니다. <br>
	 * 
	 * @param scgImdgUnNoSegrGrpVOs
	 * @throws DAOException
	 */
	public void addSegrGrpListS(List<ScgImdgUnNoSegrGrpVO> scgImdgUnNoSegrGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgUnNoSegrGrpVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoSegrGrpCSQL(), scgImdgUnNoSegrGrpVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Segregation Group을 삭제 합니다. <br>
	 * 
	 * @param scgImdgUnNoSegrGrpVOs
	 * @throws DAOException
	 */
	public void removeSegrGrpListS(List<ScgImdgUnNoSegrGrpVO> scgImdgUnNoSegrGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgUnNoSegrGrpVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoSegrGrpDSQL(), scgImdgUnNoSegrGrpVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	 /**
	 * Organic Peroxides을 생성 합니다. <br>
	 * 
	 * @param scgImdgUnNoOrgRactVO
	 * @throws DAOException
	 */
	public void addOrgRact(ScgImdgUnNoOrgRactVO scgImdgUnNoOrgRactVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = scgImdgUnNoOrgRactVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoOrgRactCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Organic Peroxides을 수정 합니다. <br>
	 * 
	 * @param scgImdgUnNoOrgRactVO
	 * @return int
	 * @throws DAOException
	 * 현재 사용하지 않으므로 향후 삭제 예정
	public int modifyOrgRact(ScgImdgUnNoOrgRactVO scgImdgUnNoOrgRactVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = scgImdgUnNoOrgRactVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoOrgRactUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	**/
	/**
	 * Organic Peroxides을 삭제 합니다. <br>
	 * 
	 * @param scgImdgUnNoOrgRactVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeOrgRact(ScgImdgUnNoOrgRactVO scgImdgUnNoOrgRactVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = scgImdgUnNoOrgRactVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgUnNoOrgRactDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * Numbers & symbols in segregation table between various Classes의 내용을 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgClssSegrListVO>
	 * @throws DAOException
	 */	
	public List<ScgImdgClssSegrListVO> searchSegregationClssList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgClssSegrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgClssSegrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgClssSegrListVO.class);
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
	 * Permitted mixed stowage for goods of class 1의 내용을 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgCompGrpSegrListVO>
	 * @throws DAOException
	 */
	public List<ScgImdgCompGrpSegrListVO> searchSegregationCompList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgCompGrpSegrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgCompGrpSegrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgCompGrpSegrListVO .class);
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
	 * Numbers & symbols in segregation table between various Classes의 내용을 생성 합니다. <br>
	 * 
	 * @param scgImdgClssSegrVOs
	 * @throws DAOException
	 */
	public void addClssSegregationS(List<ScgImdgClssSegrVO> scgImdgClssSegrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgClssSegrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgClssSegrVOCSQL(), scgImdgClssSegrVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Numbers & symbols in segregation table between various Classes의 내용을 수정 합니다. <br>
	 * 
	 * @param scgImdgClssSegrVOs
	 * @throws DAOException
	 */
	public void modifyClssSegregationS(List<ScgImdgClssSegrVO> scgImdgClssSegrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgClssSegrVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgClssSegrVOUSQL(), scgImdgClssSegrVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Numbers & symbols in segregation table between various Classes의 내용을 삭제 합니다. <br>
	 * 
	 * @param List<ScgImdgClssSegrVO> scgImdgClssSegrVOs
	 * @throws DAOException
	 */
	public void removeClssSegregationS(List<ScgImdgClssSegrVO> scgImdgClssSegrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgClssSegrVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgClssSegrVODSQL(), scgImdgClssSegrVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * Permitted mixed stowage for goods of class 1의 내용을 생성 합니다. <br>
	 * 
	 * @param scgImdgCompGrpSegrVOs
	 * @throws DAOException
	 */
	public void addCompSegregationS(List<ScgImdgCompGrpSegrVO> scgImdgCompGrpSegrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgCompGrpSegrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgCompGrpSegrVOCSQL(), scgImdgCompGrpSegrVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Permitted mixed stowage for goods of class 1의 내용을 수정 합니다. <br>
	 * 
	 * @param scgImdgCompGrpSegrVOs
	 * @throws DAOException
	 */
	public void modifyCompSegregationS(List<ScgImdgCompGrpSegrVO> scgImdgCompGrpSegrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgCompGrpSegrVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgCompGrpSegrVOUSQL(), scgImdgCompGrpSegrVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Permitted mixed stowage for goods of class 1의 내용을 삭제 합니다. <br>
	 * 
	 * @param scgImdgCompGrpSegrVOs
	 * @throws DAOException
	 */
	public void removeCompSegregationS(List<ScgImdgCompGrpSegrVO> scgImdgCompGrpSegrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgCompGrpSegrVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgCompGrpSegrVODSQL(), scgImdgCompGrpSegrVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Numbers & symbols in segregation table between various Classes의 내용을 조회 합니다. <br>
	 * 
	 * @param imdgSegrTpCd
	 * @return List<ScgImdgSegrSymVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSegrSymVO> searchSymbolList(String imdgSegrTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSegrSymVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	    	param.put("imdg_segr_tp_cd", imdgSegrTpCd);

	    	velParam.put("imdg_segr_tp_cd", imdgSegrTpCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgSegrSymVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSegrSymVO .class);
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
	 * Permitted mixed stowage for goods of class 1의 내용을 조회 합니다. <br>
	 * 
	 * @param imdgSegrTpCd
	 * @return List<ScgImdgSegrSymVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSegrSymVO> searchPermitMixedList(String imdgSegrTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSegrSymVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	    	param.put("imdg_segr_tp_cd", imdgSegrTpCd);

	    	velParam.put("imdg_segr_tp_cd", imdgSegrTpCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOScgImdgSegrSymVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSegrSymVO .class);
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
     * [Special Provisions for Segregation (Creation)] 정보를 [수정 ] 합니다.<br>
     * 
     * @param   List<ScgImdgSpclProvisVO> scgImdgSpclProvisVOs
     * @throws DAOException
     */
    public void modifySpecialProvisionSegregation(List<ScgImdgSpclProvisVO> scgImdgSpclProvisVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(scgImdgSpclProvisVOs.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new IMDGCodeMgtDBDAOmodifyImdgTblNoUSQL(), scgImdgSpclProvisVOs,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
	 * Segregation Simulation in a CNTR 의 Segregation Validation 을 조회 합니다. <br>
	 * 
	 * @param segregationSimulationInputVOs
	 * @return List<SegregationSimulationInputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SegregationSimulationOutputVO> checkSegregation(SegregationSimulationInputVO[] segregationSimulationInputVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<SegregationSimulationOutputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(segregationSimulationInputVOs != null){
				velParam.put("opt_obj",  segregationSimulationInputVOs);
				velParam.put("obj_size", segregationSimulationInputVOs.length);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IMDGCodeMgtDBDAOSegregationSimulationOutputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SegregationSimulationOutputVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
