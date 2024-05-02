/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilDAO.java
*@FileTitle : 코드 성격의 데이터를 가져오는 Util DAO 클래스
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초 생성
* 수정 내역
* [1] : 2008.12.01 - 한정우 : COA 분배치를 위한 업데이트 시, IC 가 성공한 ( bkg_if_sts_cd =99 ) 경우에만 업데이트 하도록 수정 - IF 꼬임 방
* 2009-04-06 Jeong-seon An [N200903200140]   [SCEM] COP Header 로직 보완:작업메소드:;OB_ITCHG_CTNT,IB_ITCHG_CTNT 컬럼 UPDATE
* 2011-07-04 채창호 [CHM-201111830]:Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2011-07-07 채창호 [CHM-201111381-01]: Dwell Notification Management 신규개발 요청.
=========================================================*/

package com.hanjin.apps.alps.esd.sce.common.util.integration;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl;
import com.hanjin.apps.alps.esd.sce.common.util.vo.CodeUtilVO;
import com.hanjin.apps.alps.esd.sce.common.util.vo.RsltCdListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * 코드 성격의 데이터를 가져오는 DAO
 *
 * @author Seong-mun Kang
 * @see CodeUtilBCImpl.java
 * @since J2EE 1.4
 */
public class CodeUtilDBDAO extends DBDAOSupport {
	/**
	 *
	 * @param table 테이블명
	 * @param valueField value 필드명
	 * @param textField text 필드명
	 * @param orderByField 정렬 필드명
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCodeCombo(String table, String valueField, String textField, String orderByField) throws DAOException{
        DBRowSet   dRs  = null;
         //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
 	   //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
        	param.put("valuefield", valueField);
        	param.put("textfield" , textField);
        	param.put("tablefield", table);
        	
         	if(orderByField != null && !orderByField.equals("")){
        		param.put	("orderbyfield",orderByField);
        	}
        	velParam.putAll(param);
         dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDAOSearchCodeComboRSQL(), param, velParam);

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
        return dRs ;
	}


	/**
	 *
	 * @param table 테이블명
	 * @param codeField value 코드필드명
	 * @param nameField text 이름필드명
	 * @param code 코드
	 *
	 * @return dRs DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCodeName(String table, String codeField, String nameField, String code) throws DAOException{
        DBRowSet   dRs  = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
 	   //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
    	param.put("valuefield", nameField);
    	param.put("tablefield", table);
    	param.put("wherefield", codeField);
    	param.put("codevalue", JSPUtil.replace(code,"'" ,"''"));
	   
    	velParam.putAll(param);
   
    	dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDBDAOSearchCodeNameRSQL(), param, velParam);
    
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

        return dRs ;
	}

//	/**
//	 *
//	 * @param table 테이블명
//	 * @param codeField value 코드필드명
//	 * @param nameField text 이름필드명
//	 *
//	 * @return dRs DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchCodeNameList(String table, String codeField, String nameField) throws DAOException{
//        DBRowSet   dRs  = null;
//        
//        //query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
// 	   //velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        try{
//        	
//        StringBuffer queryStr = new StringBuffer() ;
//        queryStr.append("SELECT  " + codeField + ",\n") ;
//        queryStr.append("        " + nameField + "\n") ;
//        queryStr.append("FROM    " + table + "\n") ;
//
//        param.put("valuefield", codeField);
//    	param.put("textfield" , nameField);
//    	param.put("tablefield", table);
//    	
//     	velParam.putAll(param);
//     
//        dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDBDAOSearchCodeNameRSQL(), param, velParam);
//  
//		} catch (SQLException se) {
//	        log.error(se.getMessage(), se);
//	        throw new DAOException(new ErrorHandler(se).getMessage());
//	    } catch (DAOException de) {
//	        log.error(de.getMessage(), de);
//	        throw de;
//	    } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw new DAOException(e.getMessage());
//        } 
//        return dRs ;
//	}



    /**
    *
    * @param String table
    * @param String valueField
    * @param String textField
    * @param String whereField
    * @param String orderByField
    * @return DBRowSet
    * @throws DAOException
    */
	
   public DBRowSet searchCodeCombo(String table, String valueField, String textField, String whereField, String orderByField) throws DAOException{
       DBRowSet   dRs  = null;

       //query parameter
	   Map<String, Object> param = new HashMap<String, Object>();
	   //velocity parameter
	   Map<String, Object> velParam = new HashMap<String, Object>();

       log.debug("\n DBDAO::searchCodeCombo ");
       try{
    	   param.put("valuefield", valueField);
    	   param.put("textfield" , textField);
       	   param.put("tablefield", table);
       	   
    	   velParam.putAll(param);
    	   
    	   if(whereField != null && !whereField.equals("")){
				param.put	("wherefield",whereField);
				velParam.put("wherefield",whereField);
		   }
    	   
    	   if(orderByField != null && !orderByField.equals("")){
				param.put	("orderbyfield",orderByField);
				velParam.put("orderbyfield",orderByField);
		   }
//    	   log.debug(param);
//    	   log.debug(velParam);
    	   dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDAOSearchCodeComboRSQL(), param, velParam);

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
       return dRs ;
   }
   
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param CodeUtilVO codeUtilVO 
	 * @return List<CodeUtilVO>
	 * @throws DAOException
	 */
	 /*
	public List<CodeUtilVO> searchCodeCombo(CodeUtilVO codeUtilVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodeUtilVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(codeUtilVO != null){
				Map<String, String> mapVO = codeUtilVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDAOGetCodeComboRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeUtilVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 */
	 /**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param CodeUtilVO codeUtilVO
		 * @return DBRowSet
		 * @throws DAOException
		 */
		public DBRowSet searchCodeComboActual(CodeUtilVO codeUtilVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(codeUtilVO != null){
					Map<String, String> mapVO = codeUtilVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeUtilDAOSearchCodeComboRSQL(), param, velParam);
				
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
		}
	 

    /**
     * GenS/O 가 cre_usr_id 인 부분은 조회 되지않는다.
     * COP History Setting;<br>
     * @param String cop_no
     * @param String event_cd
     * @param String ofc_cd
     * @param String usr_id
     * @param String scs_flg
     * @return String
     * @throws DAOException
     */
    public String  addSceCopHistory(String cop_no, String event_cd, String ofc_cd, String usr_id, String scs_flg) throws DAOException {

    	//Parameter Verification
    	if(cop_no.equals("") || event_cd.equals("") || event_cd.length() != 2) {
        	return "000001";
        }
    	
    	String result = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int rowCnt = 0;
		try{
			param.put("cop_no", cop_no);
			param.put("event_cd", event_cd);
			param.put("usr_id", usr_id);
			param.put("scs_flg", scs_flg);
			
			rowCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodeUtilDAOAddSceCopHistoryCSQL(), param, velParam);
			if(rowCnt>0) result="000000";

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
	 * S/C No prefix 리스트를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchScPrefixList(RsltCdListVO rsltCdlistVo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CodeUtilDBDAOSearchScPrefixListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
    /**
     * @param ofc_cd
     * @return
     * @throws DAOException
     */
    public int searchOfcInfo(String ofc_cd) throws DAOException {

    	int result = 0;
    	DBRowSet dbRowset = null;
    	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofc_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CodeUtilDBDAOSearchOfcInfoRSQL(), param, velParam);
			if (dbRowset.next()){
				result = dbRowset.getInt("CNT");
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
}
