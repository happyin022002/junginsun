/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionDBDAO.java
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.09 장강철
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.04.20 서석진 [CHM-201216960-01] Vessl Operator내 파일첨부 기능 추가
* 처리내역 :첨부파일 팝업화면과 팝업화면에서 파일등록,삭제 기능 추가
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.basic.CarrierRestrictionBCImpl;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.ScgImdgCrrRstrVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.VopScg0009ConditionVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVOCSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVODSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVORSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVOUSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ALPS CarrierRestrictionDBDAO <br>
 * - ALPS-DangerousCargoRestriction system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jang kang cheol
 * @see CarrierRestrictionBCImpl 참조
 * @since J2EE 1.6
 */
public class CarrierRestrictionDBDAO extends DBDAOSupport {
 
    /**
     * Carrier Restriction    데이터를 생성한다.<br>
     * 
     * @param  CarrierRestrictionVO carrierRestrictionVO
     * @throws DAOException
     * @throws Exception
     */
	public void addCarrierRestriction(CarrierRestrictionVO carrierRestrictionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carrierRestrictionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CarrierRestrictionDBDAOScgImdgCrrRstrVOCSQL(), param, velParam);
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
     * Carrier Restriction 수정 처리한다.
     * 
     * @param List<CarrierRestrictionVO> carrierRestrictionVOs
     * @throws SQLException
     * @throws Exception
     */
	public void modifyCarrierRestriction(List<CarrierRestrictionVO> carrierRestrictionVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(carrierRestrictionVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CarrierRestrictionDBDAOScgImdgCrrRstrVOUSQL(), carrierRestrictionVOs,null);
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
     * Carrier Restriction  삭제 처리한다.
     * 
     * 
     * @param  List<CarrierRestrictionVO> carrierRestrictionVOs
     * @param  String optclass
     * @throws DAOException
     * @throws Exception
     */
	public void removeCarrierRestriction(List<CarrierRestrictionVO> carrierRestrictionVOs, String optclass) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(carrierRestrictionVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CarrierRestrictionDBDAOScgImdgCrrRstrVODSQL(), carrierRestrictionVOs,null);
 
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
     * Carrier Restirction  조회 <br>
     * 
     * @param  VopScg0009ConditionVO vopScg0009ConditionVO
     * @return List<CarrierRestrictionVO>
     * @throws DAOException
     * @throws Exception
     */
	public List<CarrierRestrictionVO> searchCarrierRestriction(VopScg0009ConditionVO vopScg0009ConditionVO) throws DAOException  {
		DBRowSet dbRowset = null;
		List<CarrierRestrictionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
 
		try{
			if(vopScg0009ConditionVO != null){
				Map<String, String> mapVO = vopScg0009ConditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOSearchCarrierRestrictionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierRestrictionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }
  
	 
    /**
     * Carrier Restirction 기 등록 확인한다. <br>
     * 
     * @param  CarrierRestrictionVO carrierRestrictionVO
     * @return List<CarrierRestrictionVO> carrierRestrictionVO
     * @throws DAOException
     * @throws Exception
     */
	public List<CarrierRestrictionVO> getImdgCrrRstrVO(CarrierRestrictionVO carrierRestrictionVO) throws DAOException  {
		DBRowSet dbRowset = null;
		List<CarrierRestrictionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
		    Map<String, String> mapVO = carrierRestrictionVO.getColumnValues();
			param.putAll(mapVO);
		    velParam.putAll(mapVO);
 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOGetImdgCrrRstrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierRestrictionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }	  
 
    /**
     * Carrier Restirction IMDG_CRR_RSTR_SEQ Seq 조회 <br>
     * 
     * @param  String vslOprTpCd
     * @return String
     * @throws DAOException
     * @throws Exception
     */
	public String getImdgCrrRstrSeq(String vslOprTpCd ) throws DAOException  {
		DBRowSet dbRowset = null;
 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String sKey = "";
		try{
 
			Map<String, String> mapVO = new HashMap<String, String >();
			mapVO.put("vsl_opr_tp_cd", vslOprTpCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOGetImdgCrrRstrSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				sKey = dbRowset.getString("IMDG_CRR_RSTR_SEQ");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sKey;
	}	 

	/**
	 * Port & VSL OPR’s Restriction En-route 메인 조회 <br>
	 * 
	 * @param  PortRestrictionOptionVO portRestrictionOptionVO
	 * @return List<ScgImdgCrrRstrVO> 
	 * @throws DAOException
	 */
	public List<ScgImdgCrrRstrVO> searchCarrierEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws DAOException  {
		DBRowSet dbRowset = null;
		List<ScgImdgCrrRstrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portRestrictionOptionVO != null){
				Map<String, String> mapVO = portRestrictionOptionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOScgImdgCrrRstrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgCrrRstrVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }

	/**
	 * Port & VSL OPR’s Restriction En-route Port  조회 <br>
	 * 
	 * @param  PortRestrictionOptionVO portRestrictionOptionVO
	 * @return List<PortRestrictionOptionVO>
	 * @throws DAOException
	 */
	public List<PortRestrictionOptionVO> searchPortEnRouteList(PortRestrictionOptionVO portRestrictionOptionVO) throws DAOException  {
		DBRowSet dbRowset = null;
		List<PortRestrictionOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portRestrictionOptionVO != null){
				Map<String, String> mapVO = portRestrictionOptionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOPortRestrictionOptionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestrictionOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }	

	/**
	 * Port & VSL OPR’s Restriction En-route Port  조회 <br>
	 * 
	 * @param  PortRestrictionOptionVO portRestrictionOptionVO
	 * @return List<PortRestrictionOptionVO>
	 * @throws DAOException
	 */
	public List<PortRestrictionOptionVO> searchPortRotnSeq(PortRestrictionOptionVO portRestrictionOptionVO) throws DAOException  {
		DBRowSet dbRowset = null;
		List<PortRestrictionOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portRestrictionOptionVO != null){
				Map<String, String> mapVO = portRestrictionOptionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOPortRotnSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortRestrictionOptionVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }	
	
	/**
	 * Vessel Operator's Restriction on DG file 을 조회 합니다. <br>
	 * 
	 * @param vslOprTpCd
	 * @return List<FileVO>
	 * @throws DAOException
	 */
	public List<FileVO> searchFileList(String vslOprTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<FileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
				
			mapVO.put("vsl_opr_tp_cd", vslOprTpCd);		
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOFileVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FileVO.class);
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
	 * Vessel Operator's Restriction on DG file 을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param  List<FileVO> FileVOs
	 * @throws DAOException
	 */
	public void addFile(List<FileVO> fileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(fileVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CarrierRestrictionDBDAOFileVOCSQL(), fileVOs,null);
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
	 * Vessel Operator's Restriction on DG file 을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param    List<FileVO> fileVOs
	 * @throws DAOException
	 */
	public void removeFile(List<FileVO> fileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(fileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CarrierRestrictionDBDAOFileVODSQL(), fileVOs,null);

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
	 * 첨부파일 이름 검색<br>

	 * @param String crrCd
     * @return String
     * @throws EventException
     */
    public String searchFileName(String crrCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	
        	param.put("crr_cd", crrCd);   
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOSearchFileNameRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	return dbRowset.getString(1);
            }else{
            	return "";
            }
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
	/**
	 * 첨부파일 이름 검색<br>

	 * @param String vslOprTpCd
     * @return String
     * @throws EventException
     */
    public String searchFileSeq(String vslOprTpCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	
            param.put("vsl_opr_tp_cd", vslOprTpCd);	
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CarrierRestrictionDBDAOFileMaxSeqRSQL(), param, velParam);
            
            if (dbRowset.next()) {
            	return dbRowset.getString(1);
            }else{
            	return "";
            }
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
    
	
}