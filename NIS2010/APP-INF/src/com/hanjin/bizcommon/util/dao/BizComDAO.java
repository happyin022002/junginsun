/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BizComDAO.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.util.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.bizcommon.util.code.BizCodeInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * 업무공통에서 사용하는 공통 코드 등을 구현<br>
 * @author Hyung Choon_Roh
 * @see 
 * @since J2EE 1.4
 */
public class BizComDAO extends DBDAOSupport {
 
    /**
     * 1. 기능 :CODE Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException 
     */
    public Collection getCurrencyList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetCurrencyListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 :CODE Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getSubSysList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetSubSysListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 :CODE Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getCntrTpList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetCntrTpListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 :CODE Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getCntrSzList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetCntrSzListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 :CODE Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getCntrTpSzList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetCntrTpSzListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 : Chassis Type Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getChassisList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetChassisListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 : Genset Type Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getGensetList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetGensetListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 : Continent Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getContiList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetContiListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 : Service Scope Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getSvcScopeList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetSvcScopeListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 : Continent Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getSContiList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetSContiListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 : State Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public Collection getSteList(String where, int sortKey) throws DAOException {
    	DBRowSet dbRowset = null;
        Collection codeList = new ArrayList();
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("where", where);
    	mapParam.put("sortKey", sortKey);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetSteListRSQL(), null, mapParam);

            while(dbRowset.next()) {
                codeList.add(new BizCodeInfo(dbRowset.getString("sortkey"),
                		dbRowset.getString("code"),
                		dbRowset.getString("name")));
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
		return codeList;
    }
    
    /**
     * 1. 기능 : State Table 의 정보를 가져온다.  <p>
     * @param String where
     * @param int sortKey
     * @return Collection
     * @throws DAOException
     */
    public String getCodeVal(String jobCode, String code) throws DAOException {
    	DBRowSet dbRowset = null;
    	String codeVal = "";
        
		Map<String,Object> mapParam = new HashMap<String,Object>();
    	mapParam.put("jobCode", jobCode);
    	mapParam.put("code", code);

        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new BizComDAOGetCodeValRSQL(), mapParam, mapParam);
			if (dbRowset.next()) {
				codeVal = dbRowset.getString("CODEVAL");
			}

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return codeVal;
    }
}
