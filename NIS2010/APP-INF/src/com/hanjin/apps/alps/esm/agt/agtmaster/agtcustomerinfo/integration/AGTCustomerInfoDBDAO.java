/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerInfoDBDAO.java
*@FileTitle : Agent Commission Customer Information Managemnet 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-11-22 Junghyung_kim
* 1.0 최초 생성
* 2009-10-14 : Ho-Jin Lee Alps 전환
* 1.1 2011.04.22 박성진 [CHM-201109104-01] Customer Vs Vendor for S. America 추가
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.basic.AGTSecurityBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.AgtBrogCustIntVO;
import com.hanjin.syscommon.common.table.AgtBrogCustMtchVO;
import com.hanjin.syscommon.common.table.AgtCmpnCustMtchVO;
import com.hanjin.syscommon.common.table.AgtFacCustRltVO;


/**
 * eNIS-AGT에 대한 DB 처리를 담당<br>
 * - eNIS-AGT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Junghyung_kim
 * @see AGTSecurityBCImpl 참조
 * @since J2EE 1.4
 */
public class AGTCustomerInfoDBDAO extends DBDAOSupport {

    /**
     * (ESM_AGT_0025) Freight Forwarder VS Vendor Matching Info for Brokerage 의 정보를 가져온다.<br>
     * 
     * @param  AgtBrogCustMtchVO agtBrogCustMtchVO
     * @return List<AgtBrogCustMtchVO>
     * @throws DAOException
     */
    public List<AgtBrogCustMtchVO> searchFForwarderVendorMatchingInfoForBrokerage(AgtBrogCustMtchVO agtBrogCustMtchVO) throws DAOException {
    	DBRowSet dbRowset = null;
		List<AgtBrogCustMtchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            if(agtBrogCustMtchVO != null){
            	Map<String, String> mapVO = agtBrogCustMtchVO.getColumnValues();
            	param.putAll(mapVO);
            	velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCustomerInfoDBDAOFForwarderVendorMatchingInfoForBrokerageRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtBrogCustMtchVO.class);
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
        
        return list;
    }
    /**
     * (ESM_AGT_0025) Freight Forwarder VS Vendor Matching Info for Brokerage 의 정보 저장<br>
     * @param List<AgtBrogCustMtchVO> insModels
     * @return int[]
     * @throws DAOException
     */
    public int[] addFForwarderVendorMatchingInfoForBrokerage(List<AgtBrogCustMtchVO> insModels) throws DAOException{
    	int insCnt[] = null;
    	try{
    		SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerinfoDBDAOFForwarderVendorMatchingInfoForBrokerageCSQL(), insModels,null);
				for(int i=0; i<insCnt.length;i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
    	}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	return insCnt;
    }
    /**
     * (ESM_AGT_0025) Freight Forwarder VS Vendor Matching Info for Brokerage 의 정보 수정<br>
     * @param List<AgtBrogCustMtchVO> updModels
     * @return int[]
     * @throws DAOException
     */
    public int[] modifyFForwarderVendorMatchingInfoForBrokerage(List<AgtBrogCustMtchVO> updModels) throws DAOException{
	    int updCnt[] = null;
	    try{
	    	SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOFForwarderVendorMatchingInfoForBrokerageUSQL(), updModels,null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
	    }catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return updCnt;
    }
    /**
     * (ESM_AGT_0025) Freight Forwarder VS Vendor Matching Info for Brokerage 의 정보 삭제<br>
     * @param delModels
     * @return
     * @throws DAOException
     */
    public int[] deleteFForwarderVendorMatchingInfoForBrokerage(List<AgtBrogCustMtchVO> delModels) throws DAOException{
	    int delCnt[] = null;
	    try{
	    	SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOFForwarderVendorMatchingInfoForBrokerageDSQL(), delModels,null);
				for(int i=0; i<delCnt.length;i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
	    }catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return delCnt;
    }

    /**
     * (ESM_AGT_026) Freight Forwarder VS Shipper Interest Info for Brokerage 의 정보를 가져온다.<br>
     * 
     * @param  AgtBrogCustIntVO agtBrogCustIntVO
     * @return List<AgtBrogCustIntVO>
     * @throws DAOException
     * @throws EventException
     */
    public List<AgtBrogCustIntVO> searchBRKGCustomerToShipperInterestList(AgtBrogCustIntVO agtBrogCustIntVO) throws DAOException, EventException {
    	DBRowSet dbRowset = null;
		List<AgtBrogCustIntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
        	if(agtBrogCustIntVO != null){
	            Map<String, String> mapVO = agtBrogCustIntVO.getColumnValues();
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCustomerInfoDBDAOBRKGCustomerToShipperInterestListRSQL(), param, velParam);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtBrogCustIntVO.class);
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
        
        return list;
    }
    /**
     * (ESM_AGT_026) Freight Forwarder VS Shipper Interest Info for Brokerage 의 정보를 저장.<br>
     * @param insModels
     * @return int[]
     * @throws DAOException
     * @throws EventException
     */
    public int[] addBRKGCustomerToShipperInterestInfo(List<AgtBrogCustIntVO> insModels) throws DAOException, EventException{
    	int insCnt[] = null;
    	try{
    		SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOBRKGCustomerToShipperInterestInfoCSQL(), insModels,null);
				for(int i=0; i<insCnt.length;i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
    	}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	return insCnt;
	    
    }
    /**
     * (ESM_AGT_026) Freight Forwarder VS Shipper Interest Info for Brokerage 의 정보를 수정.<br>
     * @param updModels
     * @return int[]
     * @throws DAOException
     * @throws EventException
     */
    public int[] modifyBRKGCustomerToShipperInterestInfo(List<AgtBrogCustIntVO> updModels) throws DAOException, EventException{
    	int updCnt[] = null;
    	try{
    		SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOBRKGCustomerToShipperInterestInfoUSQL(), updModels,null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
    	}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	return updCnt;
	    
    }
    /**
     * (ESM_AGT_026) Freight Forwarder VS Shipper Interest Info for Brokerage 의 정보를 삭제.<br>
     * @param delModels
     * @return
     * @throws DAOException
     * @throws EventException
     */
	public int[] deleteBRKGCustomerToShipperInterestInfo(List<AgtBrogCustIntVO> delModels) throws DAOException, EventException{
		int delCnt[] = null;
    	try{
    		SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOBRKGCustomerToShipperInterestInfoDSQL(), delModels,null);
				for(int i=0; i<delCnt.length;i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
    	}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	return delCnt;
	    
    }
    
	/**
	 * (ESM_AGT_030) FAC Shipper 관계 관리의 모든 목록을 가져온다.<br>
	 * 
	 * @param AgtFacCustRltVO agtFacCustRltVO
	 * @return List<AgtFacCustRltVO>
	 * @throws DAOException
	 */
	public List<AgtFacCustRltVO> searchFACCustomerToShipperInterestList(AgtFacCustRltVO agtFacCustRltVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AgtFacCustRltVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
        	if(agtFacCustRltVO != null){
	            Map<String, String> mapVO = agtFacCustRltVO.getColumnValues();
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCustomerInfoDBDAOFACCustomerToShipperInterestListRSQL(), param, velParam);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtFacCustRltVO.class);
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
        
        return list;
	}
	/**
	 * ESM_AGT_030) FAC Shipper 관계 관리의 모든 목록을 저장.<br>
	 * @param insModels
	 * @return
	 * @throws DAOException
	 */
	public int[] addFACCustomerToShipperInterestList(List<AgtFacCustRltVO> insModels) throws DAOException{
		int insCnt[] = null;
    	try{
    		SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOFACCustomerToShipperInterestListCSQL(), insModels,null);
				for(int i=0; i<insCnt.length;i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
    	}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	return insCnt;
	}
	/**
	 * ESM_AGT_030) FAC Shipper 관계 관리의 모든 목록을 수정.<br>
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws EventException
	 */
	public int[] updateFACCustomerToShipperInterestList(List<AgtFacCustRltVO> updModels) throws DAOException, EventException{
		int updCnt[] = null;
    	try{
    		SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOFACCustomerToShipperInterestListUSQL(), updModels,null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
    	}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	return updCnt;
	}
	/**
	 * ESM_AGT_030) FAC Shipper 관계 관리의 모든 목록을 삭제.<br>
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws EventException
	 */
	public int[] deleteFACCustomerToShipperInterestList(List<AgtFacCustRltVO> delModels) throws DAOException, EventException{
		int delCnt[] = null;
    	try{
    		SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOFACCustomerToShipperInterestListDSQL(), delModels,null);
				for(int i=0; i<delCnt.length;i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
    	}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	return delCnt;
	}
    /**
     * (ESM_AGT_0058) Customer VS Vendor Matching Info for S. America 의 정보를 가져온다.<br>
     * 
     * @param  AgtCmpnCustMtchVO agtCmpnCustMtchVO
     * @return List<AgtCmpnCustMtchVO>
     * @throws DAOException
     */
    public List<AgtCmpnCustMtchVO> searchShipperVendorMatchingInfo(AgtCmpnCustMtchVO agtCmpnCustMtchVO) throws DAOException {
    	DBRowSet dbRowset = null;
		List<AgtCmpnCustMtchVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            if(agtCmpnCustMtchVO != null){
            	Map<String, String> mapVO = agtCmpnCustMtchVO.getColumnValues();
            	param.putAll(mapVO);
            	velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTCustomerInfoDBDAOShipperVendorMatchingInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCmpnCustMtchVO.class);
        } catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
        
        return list;
    }
    /**
     * (ESM_AGT_0025) Freight Forwarder VS Vendor Matching Info for Brokerage 의 정보 저장<br>
     * @param List<AgtCmpnCustMtchVO> insModels
     * @return int[]
     * @throws DAOException
     */
    public int[] addShipperVendorMatchingInfo(List<AgtCmpnCustMtchVO> insModels) throws DAOException{
    	int insCnt[] = null;
    	try{
    		SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerinfoDBDAOShipperVendorMatchingInfoCSQL(), insModels,null);
				for(int i=0; i<insCnt.length;i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
    	}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	return insCnt;
    }
    /**
     * (ESM_AGT_0025) Freight Forwarder VS Vendor Matching Info for Brokerage 의 정보 수정<br>
     * @param List<AgtCmpnCustMtchVO> updModels
     * @return int[]
     * @throws DAOException
     */
    public int[] modifyShipperVendorMatchingInfo(List<AgtCmpnCustMtchVO> updModels) throws DAOException{
	    int updCnt[] = null;
	    try{
	    	SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOShipperVendorMatchingInfoUSQL(), updModels,null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
	    }catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return updCnt;
    }
    /**
     * (ESM_AGT_0025) Freight Forwarder VS Vendor Matching Info for Brokerage 의 정보 삭제<br>
     * @param delModels
     * @return
     * @throws DAOException
     */
    public int[] deleteShipperVendorMatchingInfo(List<AgtCmpnCustMtchVO> delModels) throws DAOException{
	    int delCnt[] = null;
	    try{
	    	SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGTCustomerInfoDBDAOShipperVendorMatchingInfoDSQL(), delModels,null);
				for(int i=0; i<delCnt.length;i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
	    }catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return delCnt;
    }
}