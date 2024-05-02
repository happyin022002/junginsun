/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslResidualSpaceManageDBDAO.java
*@FileTitle : Vessel R.Capa.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.06 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.basic.VslResidualSpaceManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0014ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0060ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSPortInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchVslRsdlSpaceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrVslRsdlCapaVO;


/**
 * ALPS VslResidualSpaceManageDBDAO <br>
 * - ALPS-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see VslResidualSpaceManageBCImpl 참조
 * @since J2EE 1.6
 */
public class VslResidualSpaceManageDBDAO extends DBDAOSupport {
  /**
	 * OnhireDomesticNewvanScheduleInput의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param condiVO EesEqr0014ConditionVO
	 * @return List<SearchBSInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBSInfoVO> searchBSInfo(EesEqr0014ConditionVO condiVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchBSInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String fmEccCd = condiVO.getFmEccCd();
		List arrFmEccCd = Utils.replaceStrToList(fmEccCd);//fmEccCd.split(",");
		String fmPlnYr = condiVO.getFmPlnYr();
		String fmPlnWk = condiVO.getFmPlnWk();
		String toPlnYr = condiVO.getToPlnYr();
		String toPlnWk = condiVO.getToPlnWk();
		//String toType = condiVO.getToType();
		String fmToPlnWk = condiVO.getFmToPlnWk();
		String fmToPlnYr = condiVO.getFmToPlnYr();
		String toToPlnWk = condiVO.getToToPlnWk();
		String toToPlnYr = condiVO.getToToPlnYr();
		String toEccCd = condiVO.getToEccCd();
		List arrToEccCd = Utils.replaceStrToList(toEccCd);//toEccCd.split(",");
		//String toTypeBy = condiVO.getToTypeBy();
		//String company = condiVO.getCompany();
		
		// lane
		String lane = condiVO.getLane();
		List arrlane = Utils.replaceStrToList(lane);//.split(",");
		
		// VVD
		String vvd = condiVO.getVvd();
		List arrvvd = Utils.replaceStrToList(vvd);//.split(",");
		
		// TP / SZ
		String cntrTpszCd = condiVO.getCntrTpszCd();
		List arrCntrTpszCd =  Utils.replaceStrToList(cntrTpszCd);//.split(",");

		// SCNR_ID
		String scnrId = Constants.SCNR_WORD + condiVO.getYyyyww() + Constants.SCNR_WEEK + condiVO.getSeq();


		try {
			param.put("scnrId", scnrId);
			param.put("fmPln", fmPlnYr + fmPlnWk);
			param.put("toPln", toPlnYr + toPlnWk);
			param.put("fmToPln", fmToPlnYr + fmToPlnWk);
			param.put("toToPln", toToPlnYr + toToPlnWk);
			velParam.put("fmEccCd", fmEccCd);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("vvd", vvd);
			velParam.put("arrvvd", arrvvd);
			velParam.put("cntrTpszCd", cntrTpszCd);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("toEccCd", toEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("lane", lane);
			velParam.put("arrlane", arrlane);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VslResidualSpaceManageDBDAOSearchBSInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBSInfoVO .class);
			
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
		return list;
	}

	/**
	 * OnhireDomesticNewvanScheduleInput의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param condiVO EesEqr0014ConditionVO
	 * @return List<SearchBSPortInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBSPortInfoVO> searchBSPortInfo(EesEqr0014ConditionVO condiVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchBSPortInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String st_key = condiVO.getSt_key();
		String company_code = condiVO.getCompany_code();
		String company_code1  ="";
		
		// 두개의 코드를 변경을 해가면서 값을 셋팅 한다. 
		if (company_code.equals("H")){
			company_code1 ="S";
		}else {
			company_code1 ="H";
		}
		
		try {
			param.put("company_code", company_code);
			param.put("company_code1", company_code1);
			param.put("scnr_id", condiVO.getScnr_id());
			param.put("fm_yrwk", condiVO.getFm_yrwk());
			param.put("to_yrwk", condiVO.getTo_yrwk());
			param.put("vsl_cd", condiVO.getVsl_cd());
			param.put("skd_voy_no", condiVO.getSkd_voy_no());
			param.put("skd_dir_cd", condiVO.getSkd_dir_cd());
			param.put("trade_code", condiVO.getTrade_code());
			param.put("co_cd", company_code);
			velParam.put("st_key", st_key);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VslResidualSpaceManageDBDAOSearchBSPortInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBSPortInfoVO .class);
			
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
		return list;

	}

	/**
	 * OnhireDomesticNewvanScheduleInput의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param updModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyBSAInfo(List updModels) throws DAOException {
	    
	    int updCnt[] = null;
	    
	    try {
	    	SQLExecuter sqlExe = new SQLExecuter("");
			
        	updCnt = sqlExe.executeBatch((ISQLTemplate)new VslResidualSpaceManageDBDAOUpdateBSAInfoUSQL(), updModels,null);
			for(int i = 0; i < updCnt.length; i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}
	
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(),de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
	 * OnhireDomesticNewvanScheduleInput의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param delvvdModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteBSAInfoVvd(List delvvdModels) throws DAOException {
	   
	    int delvvdCnt[] = null;
	    
	    try {
	    	SQLExecuter sqlExe = new SQLExecuter("");
        	delvvdCnt = sqlExe.executeBatch((ISQLTemplate)new VslResidualSpaceManageDBDAODeleteBSAInfoDSQL(), delvvdModels,null);
			for(int i = 0; i < delvvdCnt.length; i++){
				if(delvvdCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to vvd delete No"+ i + " SQL");
			}
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(),de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
	 * OnhireDomesticNewvanScheduleInput의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param delportModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteBSAInfoPort(List delportModels) throws DAOException {
	   
	    int delportCnt[] = null;
	    
	    try {
	    	SQLExecuter sqlExe = new SQLExecuter("");
			
			delportCnt = sqlExe.executeBatch((ISQLTemplate)new VslResidualSpaceManageDBDAODeleteBSAPortInfoDSQL(), delportModels,null);
			for(int i = 0; i < delportCnt.length; i++){
				if(delportCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to port delete No"+ i + " SQL");
			}
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch (DAOException de) {
	        log.error(de.getMessage(),de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	}
	/**
	 * OnhireDomesticNewvanScheduleInput의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param insModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void insertBSAPortInfo(List insModels) throws DAOException {
		 
	    int insCnt[] = null;
        
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
        	insCnt = sqlExe.executeBatch((ISQLTemplate)new VslResidualSpaceManageDBDAOInsertBSAPortInfoCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
    }
	/**
	 * OnhireDomesticNewvanScheduleInput의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param delModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteBSAPortInfo(List delModels) throws DAOException {
		 
	    int delCnt[] = null;
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
			
        	delCnt = sqlExe.executeBatch((ISQLTemplate)new VslResidualSpaceManageDBDAODeleteBSAPortInfoDSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
			}

        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
    }
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Search ]<br>
	 * 
	 * @param eesEqr0060ConditionVO EesEqr0060ConditionVO
	 * @return List<SearchVslRsdlSpaceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchVslRsdlSpaceVO> searchVslResidualSpaceManage(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVslRsdlSpaceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0060ConditionVO != null){
				Map<String, String> mapVO = eesEqr0060ConditionVO .getColumnValues();
				
				ArrayList arrlocation	= (ArrayList) Utils.replaceStrToList(eesEqr0060ConditionVO.getLocation());
				ArrayList arrlane		= (ArrayList) Utils.replaceStrToList(eesEqr0060ConditionVO.getLane());
				ArrayList arrvvd		= (ArrayList) Utils.replaceStrToList(eesEqr0060ConditionVO.getVvd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrlocation", arrlocation);
				velParam.put("arrvvd", arrvvd);
				velParam.put("arrlane", arrlane);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VslResidualSpaceManageDBDAOSearchVslRsdlSpaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVslRsdlSpaceVO .class);
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
	 * [ EES_EQR_0060 : Vessel R.Capa. - Lane 체크해서 VVD 가져오기]<br>
	 * 
	 * @param eesEqr0060ConditionVO EesEqr0060ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchVslResidualSpaceLaneInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			try{
			if(eesEqr0060ConditionVO != null){
				Map<String, String> mapVO = eesEqr0060ConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VslResidualSpaceManageDBDAOSearchVslRsdlSpaceLaneRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - 해당 VVD Click시 VVD SPC 값 체크해서 보여주기.]<br>
	 * 
	 * @param eesEqr0060ConditionVO EesEqr0060ConditionVO 
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchVslResidualSpaceVvdInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0060ConditionVO != null ){
				Map<String, String> mapVO = eesEqr0060ConditionVO .getColumnValues();
				
				String vsl_cd		= new String();
				String skd_voy_no	= new String();
				String skd_dir_cd	= new String();
				
				String vvd			= eesEqr0060ConditionVO.getVvd();
				if ( vvd != null && vvd.length() == 9 ){
					vsl_cd		= vvd.substring(0,4);
					skd_voy_no	= vvd.substring(4,8);
					skd_dir_cd	= vvd.substring(8,9);
				}
				String vsl_lane_cd	= eesEqr0060ConditionVO.getVslLaneCd();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("vsl_lane_cd", vsl_lane_cd);
				param.put("vsl_cd", vsl_cd);
				param.put("skd_voy_no", skd_voy_no);
				param.put("skd_dir_cd", skd_dir_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VslResidualSpaceManageDBDAOSearchVslRsdlSpaceVvdRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Ecc 체크.]<br>
	 * 
	 * @param eesEqr0060ConditionVO EesEqr0060ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchVslResidualSpaceEccInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0060ConditionVO != null){
				Map<String, String> mapVO = eesEqr0060ConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new VslResidualSpaceManageDBDAOSearchVslRsdlSpaceEccRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}

	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Insert ]<br>
	 * 
	 * @param insModels List<EqrScnrVslRsdlCapaVO>
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] addmodifyVslResidualSpaceManage(List<EqrScnrVslRsdlCapaVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new VslResidualSpaceManageDBDAOInsertVslRsdlSpaceCSQL(), insModels,null);
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
	 * [ EES_EQR_0060 : Vessel R.Capa. - Update ]<br>
	 * 
	 * @param updModels List<EqrScnrVslRsdlCapaVO>
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] modifymodifyVslResidualSpaceManage(List<EqrScnrVslRsdlCapaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new VslResidualSpaceManageDBDAOUpdateVslRsdlSpaceUSQL(), updModels,null);
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
	 * [ EES_EQR_0060 : Vessel R.Capa. - Delete ]<br>
	 * 
	 * @param delModels List<EqrScnrVslRsdlCapaVO> 
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] removemodifyVslResidualSpaceManage(List<EqrScnrVslRsdlCapaVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new VslResidualSpaceManageDBDAODeleteVslRsdlSpaceDSQL(), delModels,null);
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