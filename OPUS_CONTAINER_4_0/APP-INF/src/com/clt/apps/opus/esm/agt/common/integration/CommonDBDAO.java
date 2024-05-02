/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonDBDAO.java
*@FileTitle : 공틍업무 관리 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-20
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-11-20 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.common.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.common.integration.CommonDBDAOGetCodeSelectRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS-Agent Commission에 대한 공통업무 DB 처리를 담당<br>
 * - OPUS-Agent Commission에 대한 공콩업무를 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author junghyung kim
 * @see CommonBCImpl 참조
 * @since J2EE 1.4
 */
public class CommonDBDAO extends DBDAOSupport {

    /**
     * (단건)Vendor 코드를 리턴한다.<br>
     *
     * @param  seq String
     * @return HashMap<String, String> 
     * @throws DAOException
     */
	public HashMap<String, String> searchVendorCode(String seq) throws DAOException {
		log.debug("\n AGT Common searchVendorCode \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		HashMap<String, String> rtnHashMap = new HashMap<String, String>();
		 
        String vndrCd = "";				
        String vndrNm = "";
		try {
			
			param.put("seq", seq );
			velParam.put("seq", seq );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchVendorCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				vndrCd = dbRowset.getString("vndr_cd");
				vndrNm = dbRowset.getString("vndr_lgl_eng_nm");
			} else {
				vndrCd = "";
				vndrNm = "";
			}
			rtnHashMap.put("vndr_cd", vndrCd);
            rtnHashMap.put("vndr_nm", vndrNm);

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

		return rtnHashMap;
	}


    /**
     * (배열)Vendor 코드를 리턴한다.<br>
     *
     * @param  seq String[]
     * @return HashMap<String, Object>
     * @throws DAOException
     */
    public HashMap<String, Object> searchVendorCode(String[] seq) throws DAOException{
    	log.debug("\n AGT Common searchVendorCode \n");

        DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] vndrCd = new String[seq.length];
	    String[] vndrNm = new String[seq.length];
	    HashMap<String, Object> rtnHashMap = new HashMap<String, Object>();


	    try {
	    	//배열의 갯수만큼 반복 실행
            for(int j=0; j<seq.length; j++){

            	//Vendor 코드에서 숫자만 뽑기
            	String stmp = "";
            	char[] ctmp = seq[j].toCharArray();
            	for(int k=0; k<ctmp.length; k++){
            		if(Character.isDigit(ctmp[k])){
            			stmp = stmp + Character.toString(ctmp[k]);
            		}
            	}
            	seq[j] = stmp;

	            param.put("seq", Integer.parseInt(seq[j]) );
				velParam.put("seq", Integer.parseInt(seq[j]) );
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchVendorCodeRSQL(), param, velParam);

	            if(dbRowset != null){
	            	while(dbRowset.next()){
	            		vndrCd[j] = dbRowset.getString("vndr_cd");
	            		vndrNm[j] = dbRowset.getString("vndr_lgl_eng_nm");
	            	}
	            }else{
	            	throw new DAOException(new ErrorHandler("AGT00003", new String[]{vndrCd[j]}).getMessage());
	            }
            }
            
            rtnHashMap.put("vndr_cd", vndrCd);
            rtnHashMap.put("vndr_nm", vndrNm);
            
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
            
        return rtnHashMap;
    }
    
    /**
     * Custoer/Vendor의 Code/Name을 리턴한다.<br>
     *
     * @param  codeGubun String
     * @param  codeType String
     * @param  paramIn String
     * @return String 
     * @throws DAOException
     */
    public String searchCode(String codeGubun, String codeType, String paramIn) throws DAOException{
    	//codeGubun(C:Customer, V:Vendor)
    	//codeType (C:코드, N:이름) 
    	//param    (조회하려는 code 또는 seq)
    	
    	log.debug("\n AGT Common searchCode \n");

		DBRowSet dbRowset = null;
		String paramCd = "";
        String paramNm = "";
		String rtnValue = "";
		String tmpStr = "";
    	String tmpCnt = "";
    	int tmpSeq = 0;
        char[] tmpArr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        //조회 조건 체크
        if(!codeGubun.equals("C") && !codeGubun.equals("V")){
        	//Error Message : 코드리스트를 조회하기 위한 정보가 틀립니다. codeGubun은 [C, V]만 가능합니다.
        	throw new DAOException(new ErrorHandler("AGT00026", new String[]{"codeGubun은 [C, V]만 가능합니다."}).getMessage());
        }
        
        if(!codeType.equals("C") && !codeType.equals("N")){
        	//Error Message : 코드리스트를 조회하기 위한 정보가 틀립니다. codeType은 [C, N]만 가능합니다.
        	throw new DAOException(new ErrorHandler("AGT00026", new String[]{"codeType은 [C, N]만 가능합니다."}).getMessage());
        }
        
        if(paramIn.length() < 1){
        	//Error Message : 코드리스트를 조회하기 위한 정보가 틀립니다. param에 값이 들어있지 않습니다.
        	throw new DAOException(new ErrorHandler("AGT00026", new String[]{"param에 값이 들어있지 않습니다."}).getMessage());
        }
        
        if(codeGubun.equals("C")){
    		//Customer 코드에서 0 제거하기
    		//String stmp = param[i].substring(0,2) + Integer.toString(Integer.parseInt(param[i].substring(2))); 
    		//param[i] = stmp;
    		tmpCnt = paramIn.substring(0,2);
    		tmpSeq = Integer.parseInt(paramIn.substring(2));
    	}else{	
    		//Vendor 코드에서 숫자만 뽑기
    		tmpStr = "";
        	tmpArr = paramIn.toCharArray();
        	for(int j=0; j<tmpArr.length; j++){
        		if(Character.isDigit(tmpArr[j])){
        			tmpStr = tmpStr + Character.toString(tmpArr[j]);
        		}
        	}
        	tmpSeq = Integer.parseInt(tmpStr);
    	}

		try {
				param.put("codeGubun", codeGubun );
				velParam.put("codeGubun", codeGubun );
				param.put("tmpCnt", tmpCnt );
				velParam.put("tmpCnt", tmpCnt );
				param.put("tmpSeq", tmpSeq );
				velParam.put("tmpSeq", tmpSeq );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				paramCd = dbRowset.getString("code");
				paramNm = dbRowset.getString("name");
			} else {
				paramCd = "";
				paramNm = "";
			}
			// CUST_SEQ가 '999999'이면 '**999999'로 강제세팅한다.
            if(codeGubun.equals("C") && tmpSeq == 999999){
            	paramCd = tmpCnt + "999999";
        		paramNm = "REP. CUSTOMER";
            }
            
            //DB에서 일치하는 코드정보를 찾지못했을때 에러메시지 출력
            if( dbRowset == null || paramCd == null || paramCd.length() < 1) {
            	// Error Message : [Customer,Vendor] does not exist in MDM Vendor.
            	String temp = "";
            	temp = codeGubun.equals("C")?"Customer:":"vendor:";
    			//log.error(new ErrorHandler("AGT00027", new String[]{temp + param}).getMessage());
        		throw new DAOException(new ErrorHandler("AGT00027", new String[]{temp + tmpSeq}).getMessage());
            }//if(paramCd[i] == null) {

            if(codeType.equals("C")){
            	rtnValue = paramCd;
            }else{
            	rtnValue = paramNm;            	
            }
            
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

		return rtnValue;
    }
    
    /**
     * Customer/Vendor 배열의 Code/Name 배열을 리턴한다.<br>
     *
     * @param  String codeGubun
     * @param  String codeType
     * @param  String[] paramIn
     * @return 
     * @throws DAOException
     */
    public String[] searchCodeList(String codeGubun, String codeType, String[] paramIn) throws DAOException{
    	//codeGubun(C:Customer, V:Vendor)
    	//codeType (C:코드, N:이름) 
    	//param    (조회하려는 code 또는 seq)
    	
    	log.debug("\n AGT Common searchCodeList \n");

    	DBRowSet dbRowset = null;
		String[] paramCd = new String[paramIn.length];
        String[] paramNm = new String[paramIn.length];
        String[] rtnValue = new String[paramIn.length];
		String tmpStr = "";
    	String tmpCnt = "";
    	int tmpSeq = 0;
        char[] tmpArr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        //조회 조건 체크
        if(!codeGubun.equals("C") && !codeGubun.equals("V")){
        	//Error Message : 코드리스트를 조회하기 위한 정보가 틀립니다. codeGubun은 [C, V]만 가능합니다.
        	throw new DAOException(new ErrorHandler("AGT00026", new String[]{"codeGubun은 [C, V]만 가능합니다."}).getMessage());
        }
        
        if(!codeType.equals("C") && !codeType.equals("N")){
        	//Error Message : 코드리스트를 조회하기 위한 정보가 틀립니다. codeType은 [C, N]만 가능합니다.
        	throw new DAOException(new ErrorHandler("AGT00026", new String[]{"codeType은 [C, N]만 가능합니다."}).getMessage());
        }
        
        if(paramIn.length < 1){
        	//Error Message : 코드리스트를 조회하기 위한 정보가 틀립니다. param에 값이 들어있지 않습니다.
        	throw new DAOException(new ErrorHandler("AGT00026", new String[]{"param에 값이 들어있지 않습니다."}).getMessage());
        }
        try {
        //배열의 갯수만큼 반복 실행
	        for(int i=0; i<paramIn.length; i++){
		        if(codeGubun.equals("C")){
		    		//Customer 코드에서 0 제거하기
		    		//String stmp = param[i].substring(0,2) + Integer.toString(Integer.parseInt(param[i].substring(2))); 
		    		//param[i] = stmp;
		    		tmpCnt = paramIn[i].substring(0,2);
		    		tmpSeq = Integer.parseInt(paramIn[i].substring(2));
		    	}else{	
		    		//Vendor 코드에서 숫자만 뽑기
		    		tmpStr = "";
		        	tmpArr = paramIn[i].toCharArray();
		        	for(int j=0; j<tmpArr.length; j++){
		        		if(Character.isDigit(tmpArr[j])){
		        			tmpStr = tmpStr + Character.toString(tmpArr[j]);
		        		}
		        	}
		        	tmpSeq = Integer.parseInt(tmpStr);
		    	}
	
					param.put("codeGubun", codeGubun );
					velParam.put("codeGubun", codeGubun );
					param.put("tmpCnt", tmpCnt );
					velParam.put("tmpCnt", tmpCnt );
					param.put("tmpSeq", tmpSeq );
					velParam.put("tmpSeq", tmpSeq );
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchCodeRSQL(), param, velParam);
				if (dbRowset.next()) {
					paramCd[i] = dbRowset.getString("code");
					paramNm[i] = dbRowset.getString("name");
				} else {
					paramCd[i] = "";
					paramNm[i] = "";
				}
				// CUST_SEQ가 '999999'이면 '**999999'로 강제세팅한다.
	            if(codeGubun.equals("C") && tmpSeq == 999999){
	            	paramCd[i] = tmpCnt + "999999";
	        		paramNm[i] = "REP. CUSTOMER";
	            }
	            
	            //DB에서 일치하는 코드정보를 찾지못했을때 에러메시지 출력
	            if(paramCd[i] == null || paramCd[i].length() < 1) {
	            	// Error Message : [Customer,Vendor] does not exist in MDM Vendor.
	            	String temp = "";
	            	temp = codeGubun.equals("C")?"Customer:":"vendor:";
	    			//log.error(new ErrorHandler("AGT00027", new String[]{temp + param}).getMessage());
	        		throw new DAOException(new ErrorHandler("AGT00027", new String[]{temp + tmpSeq}).getMessage());
	            }//if(paramCd[i] == null) {
	
	            if(codeType.equals("C")){
	            	rtnValue[i] = paramCd[i];
	            }else{
	            	rtnValue[i] = paramNm[i];            	
	            }
	            log.debug("rtnValue["+i+"]==>"+rtnValue[i]);
	            log.debug("rtnValue["+i+"]==>"+rtnValue[i]);
			}
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

		return rtnValue;
    }
    
    /**
     * 입력받은 Office Code가 속해있는 지역의 A/R Office 의 목록을 가져온다.<br>
     * 
     * @param  code 로그인한 User의 소속 Country Code + Office Code
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchAROfficeList(String code) throws DAOException{
    	log.debug("\n AGT Common searchAROfficeList \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("code", code );
			velParam.put("code", code );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchAROfficeListRSQL(), param, velParam);

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

		return dbRowset;		

    }
    
    /**
     * 입력한 A/R Office Code에 속한 Office Code의 목록을 가져온다.<br>
     * 
     * @param  String code
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchSubOfficeList(String code) throws DAOException{
    	log.debug("\n AGT Common searchSubOfficeList \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("code", code );
			velParam.put("code", code );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchSubOfficeListRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * 입력한 Office Code가 속한 A/R Office 코드를 가져온다.<br>
     * 
     * @param  code 
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchAROfficeCode(String code) throws DAOException{
    	log.debug("\n AGT Common searchAROfficeCode \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("code", code );
			velParam.put("code", code );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchAROfficeCodeRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * 입력한 Subject Office Code의 오픈된 ASA No를 가져온다.<br>
     * 
     * @param  code 
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchAsaNoListBySbOfcCd(String code) throws DAOException{
    	log.debug("\n AGT Common searchAsaNoListBySbOfcCd \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("code", code );
			velParam.put("code", code );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchAsaNoListBySbOfcCdRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * 입력한 Subject Office Code의 Vendor Info를 가져온다.<br>
     * 
     * @param  code 
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchVendorInfoBySbOfcCd(String code) throws DAOException{
    	log.debug("\n AGT Common searchVendorInfoBySbOfcCd \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("code", code );
			velParam.put("code", code );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchVendorInfoBySbOfcCdRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * 입력한 A/R Office Code의 Country Code를 가져온다.<br>
     * 
     * @param  code 
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchCountryCodeByArOfcCd(String code) throws DAOException{
    	log.debug("\n AGT Common searchCountryCodeByArOfcCd \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("code", code );
			velParam.put("code", code );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchCountryCodeByArOfcCdRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * FAC Office LIST 를 가져온다.<br>
     * 
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchFACOfficeList() throws DAOException{
    	log.debug("\n AGT Common searchFACOfficeList \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchFACOfficeListRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * (ESM_AGT_016) 선택한 Office의 Vendor, Name, Office, City, Ceneter, Curr 정보를 가져온다.<br>
     * 
     * @param  String ofcCd
     * @return HashMap<String, String> 
     * @throws DAOException
     */
    public HashMap<String, String> searchOfficeInfo(String ofcCd) throws DAOException {
    	log.debug("\n AGT Common searchOfficeInfo \n");

		DBRowSet dbRowset = null;
		HashMap<String, String> rtnHash = new HashMap<String, String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofcCd", ofcCd );
			velParam.put("ofcCd", ofcCd );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchOfficeInfoRSQL(), param, velParam);
			
			if (dbRowset.next()) {
            	rtnHash.put("vendor", dbRowset.getString("vendor"));
            	rtnHash.put("name", dbRowset.getString("name"));
            	rtnHash.put("office", dbRowset.getString("office"));
            	rtnHash.put("city", dbRowset.getString("city"));
            	rtnHash.put("center", dbRowset.getString("center"));
            	rtnHash.put("curr", dbRowset.getString("curr"));
			} else {
            	rtnHash.put("vendor", "");
            	rtnHash.put("name", "");
            	rtnHash.put("office", "");
            	rtnHash.put("city", "");
            	rtnHash.put("center", "");
            	rtnHash.put("curr", "");
			}
			
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

        return rtnHash;
    }    
    
    /**
     * (ESM_AGT_047) Other Commission용 선택한 Office의 Vendor, Name, Office, City, Ceneter, Curr 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @return HashMap<String, String>
     * @throws DAOException
     */
    public HashMap<String, String> searchOtherOfficeInfo(String ofcCd) throws DAOException {

        log.debug("\n AGT Common searchOtherOfficeInfo \n");

		DBRowSet dbRowset = null;
		HashMap<String, String> rtnHash = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofcCd", ofcCd );
			velParam.put("ofcCd", ofcCd );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchOtherOfficeInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnHash = new HashMap<String, String>();
            	rtnHash.put("vendor", dbRowset.getString("vendor"));
            	rtnHash.put("name", dbRowset.getString("name"));
            	rtnHash.put("office", dbRowset.getString("office"));
            	rtnHash.put("city", dbRowset.getString("city"));
            	rtnHash.put("center", dbRowset.getString("center"));
            	rtnHash.put("curr", dbRowset.getString("curr"));
			} else {
				rtnHash = new HashMap<String, String>();
            	rtnHash.put("vendor", "");
            	rtnHash.put("name", "");
            	rtnHash.put("office", "");
            	rtnHash.put("city", "");
            	rtnHash.put("center", "");
            	rtnHash.put("curr", "");
			}
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

        return rtnHash;
    }
    
    /**
     * (ESM_AGT_016) 선택한 Office/ApplyDate의 xchRt 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @param  aplyDt apply Date
     * @return String
     * @throws DAOException
     */
    public String searchXchRt(String ofcCd, String aplyDt) throws DAOException {
    	
    	log.debug("\n AGT Common searchXchRt \n");

		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofcCd", ofcCd );
			velParam.put("ofcCd", ofcCd );
			param.put("aplyDt", aplyDt );
			velParam.put("aplyDt", aplyDt );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchXchRtRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("xchRt");
			} else {
				rtnValue = "";
			}
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

		return rtnValue.toString();

    }    
    /**
     * (ESM_AGT_016) 선택한 Curr_cd/ApplyDate의 xchRt 정보를 가져온다.<br>
     * 
     * @param  currCd Office Code
     * @param  aplyDt apply Date
     * @return String
     * @throws DAOException
     */
    public String searchCurrXchRt(String currCd, String aplyDt) throws DAOException {
    	
    	log.debug("\n AGT Common searchXchRt \n");

		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("currCd", currCd );
			velParam.put("currCd", currCd );
			param.put("aplyDt", aplyDt );
			velParam.put("aplyDt", aplyDt );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchCurrXchRtRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("xchRt");
			} else {
				rtnValue = "";
			}
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

		return rtnValue.toString();

    }    
    
    /**
     * (ESM_AGT_038) 로그인한 유저가 속한 H/Q Office 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @return String H/Q Office Code
     * @throws DAOException
     */
    public String searchHQOfficeInfo(String ofcCd) throws DAOException {
    	log.debug("\n AGT Common searchHQOfficeInfo \n");

		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofcCd", ofcCd );
			velParam.put("ofcCd", ofcCd );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchHQOfficeInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("ar_hd_qtr_ofc_cd");
			} else {
				rtnValue = "";
			}
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

		return rtnValue.toString();
    }
    
    /**
     * (ESM_AGT_017) 입력한 A/R Office가 상계/분리대리점 구분 정보를 가져온다.<br>
     * 
     * @param  arOfcCd A/R Office Code
     * @return String offset_agn_flg
     * @throws DAOException
     */
    public String searchOffsetFlag(String arOfcCd) throws DAOException {
    	log.debug("\n AGT Common searchOffsetFlag \n");

		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("arOfcCd", arOfcCd );
			velParam.put("arOfcCd", arOfcCd );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchOffsetFlagRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("code");
			} else {
				rtnValue = "";
			}
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

		return rtnValue.toString();
    }
    
    
    /**
	 * 공통코드에서 목록을 조회한다..<br>
	 * COM_INTG_CD_DTL
	 * 
	 * @param  code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCommonCodeList(String code) throws DAOException {
		log.debug("\n AGT Common searchCommonCodeList \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("code", code );
			velParam.put("code", code );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchCommonCodeListRSQL(), param, velParam);

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

		return dbRowset;
	}
	
    /**
     * 사용자가 입력한 Customer의 Name을 가져온다.<br>
     * 
     * @param  cust_cd Customer의 cnt_cd + cust_seq
     * @return HashMap
     * @throws DAOException
     */
    public HashMap<String, String> searchCustomerName(String cust_cd ) throws DAOException {

		DBRowSet dbRowset = null;
		HashMap<String, String> rtnHash = new HashMap<String, String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        String cust_cnt_cd = "";
        String cust_seq = "";
        int iCust_seq = 0;
        cust_cd = cust_cd==null?"":cust_cd;

        try {
        	
        	if( cust_cd.length() > 2) {
        		cust_cnt_cd = cust_cd.substring(0, 2);
        		cust_seq = cust_cd.substring(2);
        	} else {
        		cust_cnt_cd = cust_cd;
        	}
        	
        	if( cust_seq.length() > 0 ) {
        		iCust_seq = Integer.parseInt(cust_seq);
        	}
        	
        	param.put("cust_cnt_cd", cust_cnt_cd );
			param.put("iCust_seq", iCust_seq );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchCustomerNameRSQL(), param, velParam);
			
			if (dbRowset.next()) {
            	rtnHash.put("cust_cd", dbRowset.getString("cust_cd"));
            	rtnHash.put("cust_nm", dbRowset.getString("cust_nm"));
			} else {
            	rtnHash.put("cust_cd", "");
            	rtnHash.put("cust_nm", "");
			}

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
        
        return rtnHash;
    }    
    
    /**
	 * 사용자가 등록한 리포트 폼을 조회한다.<br>
	 * AGT_RPT_ITM_INFO_MST
	 * 
	 * @param  userId 사용자 ID
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRptGroup(String userId) throws DAOException {
		log.debug("\n AGT Common searchRptGroup \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("userId", userId );
			velParam.put("userId", userId );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchRptGroupRSQL(), param, velParam);

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

		return dbRowset;
	}

    /**
	 * (ESM_AGT_040) Agent Commission Report의 Default Column 정보를 조회한다.<br>
	 * AGT_RPT_ITM_INFO_MST
	 * 
	 * @param  userId 사용자 ID
	 * @param  seq Rpt seq
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAGTCommRptDefaultItem(String userId, int seq) throws DAOException {
		log.debug("\n AGT Common searchAGTCommRptDefaultItem \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("userId", userId );
			velParam.put("userId", userId );
			param.put("seq", seq );
			velParam.put("seq", seq );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchAGTCommRptDefaultItemRSQL(), param, velParam);

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

		return dbRowset;
	}
    
    /**
     * User의 Office Code가 속해있는 지역의 A/R Office 의 목록을 가져온다.<br>
     * 
     * @param  code 로그인한 User의 소속 Office Code
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchFACAROfficeList(String code) throws DAOException{
    	log.debug("\n AGT Common searchFACAROfficeList \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals(code) ) {
				param.put("code", code );
				velParam.put("code", code );
				param.put("bind", 1 );
				velParam.put("bind", 1 );
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchFACAROfficeListRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * User의 Office Code가 속해있는 지역의 Subject Office 의 목록을 가져온다.<br>
     * 
     * @param  code 로그인한 User의 소속 Office Code
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchFACSubOfficeList(String code) throws DAOException{
    	log.debug("\n AGT Common searchFACSubOfficeList \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals(code) ) {
				param.put("code", code );
				velParam.put("code", code );
				param.put("bind", 1 );
				velParam.put("bind", 1 );
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchFACSubOfficeListRSQL(), param, velParam);

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

		return dbRowset;
    }  
    
    /**
     * (FAC RATE, FAC Maintenance)User의 Office Code가 속해있는 지역의 A/R Office 의 목록을 가져온다.<br>
     * 
     * @param  code 로그인한 User의 소속 Office Code
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchAROfficeListForFAC(String code) throws DAOException{
    	log.debug("\n AGT Common searchAROfficeListForFAC \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("code", code );
			velParam.put("code", code );
			param.put("bind", 1 );
			velParam.put("bind", 1 );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchAROfficeListForFACRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * 연동에러 및 Commission 배치 에러 저장 및 삭제 처리<br>
     * 
     * @param  HashMap<String, String> logMap  
     * @return HashMap
     * @throws DAOException
     */
    public HashMap<String, String> processAgtErrLog(HashMap<String, String> logMap ) throws DAOException {
    	log.debug("\n AGT Common processAgtErrLog \n");
    	
    	DBRowSet dbRowset = null;
		HashMap<String, String> rtnHash = new HashMap<String, String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        int errLogSeq = 0;
        
        String bkg_no = "";
        String err_log_flg = "";
        String err_log_rmk = "";
        String del_flg = "";
        
        try {
        	
        	bkg_no 			= (String)logMap.get("BKG_NO");
        	err_log_flg 	= checkNull((String)logMap.get("ERR_LOG_FLG"));
        	err_log_rmk		= checkNull((String)logMap.get("ERR_LOG_RMK"));
        	del_flg			= checkNull((String)logMap.get("DEL_FLG"));
        	
        	if(err_log_flg.equals("")){
        		return logMap;
        	}
        	
        	if(err_log_rmk.length() > 1000){
        		err_log_rmk = err_log_rmk.substring(1,1000);
        	}

            param.put("bkg_no", bkg_no );
			velParam.put("bkg_no", bkg_no );
			param.put("err_log_flg", err_log_flg );
			velParam.put("err_log_flg", err_log_flg );
			param.put("err_log_rmk", err_log_rmk );
			velParam.put("err_log_rmk", err_log_rmk );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOProcessAgtErrLogSelectRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				errLogSeq = Integer.parseInt(dbRowset.getString("err_log_seq"));
			}   
			int result = 0;
            if(del_flg.equals("N")){
            	
            	errLogSeq++;
            	param.put("errLogSeq", errLogSeq );
    			velParam.put("errLogSeq", errLogSeq );
            	
            	SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			result = sqlExe.executeUpdate((ISQLTemplate)new AGTCommonDBDAOProcessAgtErrLogInsertUSQL(), param,velParam);
    			
    			if(result == Statement.EXECUTE_FAILED)
    						throw new DAOException("Fail to insert SQL");
            }else{
            	if(errLogSeq >= 1){
                	// Delete agt_err_log
            		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        			result = sqlExe.executeUpdate((ISQLTemplate)new AGTCommonDBDAOProcessAgtErrLogDeleteDSQL(), param,velParam);
        			
        			if(result == Statement.EXECUTE_FAILED)
        						throw new DAOException("Fail to Delete SQL");
            	}
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
        
        return rtnHash;
    }
    
    /**
     * (단건)Vendor 코드를 리턴한다.<br>
     *
     * @param  ofc_cd String
     * @return HashMap<String, String>
     * @throws DAOException
     */
    public HashMap<String, String> searchOfficeCode(String ofc_cd) throws DAOException{
    	log.debug("\n AGT Common searchOfficeCode \n");
        
    	DBRowSet dbRowset = null;
		HashMap<String, String> rtnHashMap = new HashMap<String, String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	param.put("ofc_cd", ofc_cd );
			velParam.put("ofc_cd", ofc_cd );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchOfficeCodeRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnHashMap.put("OFC_CD", dbRowset.getString("ofc_cd"));
				rtnHashMap.put("OFC_ENG_NM", dbRowset.getString("ofc_eng_nm"));
				rtnHashMap.put("OFC_KRN_NM", dbRowset.getString("ofc_krn_nm"));
			} else {
				rtnHashMap.put("OFC_CD", "");
	            rtnHashMap.put("OFC_ENG_NM", "");
	            rtnHashMap.put("OFC_KRN_NM", "");
				//Error Message : Office Code가 MDM_ORGANIZATION 에 없습니다.
            	throw new DAOException(new ErrorHandler("AGT00027", new String[]{ofc_cd}).getMessage());
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
            
        return rtnHashMap;
    }
    
    /**
     * Office 대 Vendor 매핑의 Office LIST 를 가져온다.<br>
     * 
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchOfcVndrMachOfficeList() throws DAOException{
    	log.debug("\n AGT Common searchOfcVndrMachOfficeList \n");

		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchOfcVndrMachOfficeListRSQL(), param, velParam);
			
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
		return dbRowset;
    }
    
    /**
     * MDM ACCOUNT Other Commission 용 계정  LIST 를 가져온다.<br>
     * 
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
    public DBRowSet searchMdmAccountList() throws DAOException{
    	log.debug("\n AGT Common searchMdmAccountList \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchMdmAccountListRSQL(), param, velParam);

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

		return dbRowset;
    }
    
    /**
     * (ESM_AGT_050) Cntr. Type 의 정보를 가져온다.<br>
     * 
     * @param  String sSpclCntrType
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchCntrList(String sSpclCntrType) throws DAOException {
    	
    	log.debug("\n AGT Common searchCntrList \n");

		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("sSpclCntrType", sSpclCntrType );
			velParam.put("sSpclCntrType", sSpclCntrType );

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOSearchCntrListRSQL(), param, velParam);

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

        return dbRowset;
    }
    
    /**
	 * Trade콤보의 목록을 가져온다.<br>
	 * MDM_TRADE
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTradeList() throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchTradeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;		
	}
	/**
	 * revenue lane의 정보를 가져온다.<br>
	 * COA_LANE_RGST
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRevLaneList(String trd_cd) throws DAOException {
		
		String[] sTrd = null;		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체

		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		String strTrdCd = "";
		String strSubTrdCd = "";		
		sTrd = trd_cd.split(":", -1);
		
		strTrdCd = sTrd[0];
		
		if (sTrd.length > 1) {
			strSubTrdCd = sTrd[1];
		} else {
			strSubTrdCd = "";
		}		
		try {
			if(trd_cd != null){
				param.put("str_trd_cd"    ,strTrdCd);
				param.put("str_sub_trd_cd",strSubTrdCd);
				velParam.put("methodname", "searchRevLaneList");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTCommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}
    
	/**
	 * 해당 데이타가 null인 경우 공백을 리턴한다.<br>
	 * 
	 * @param str String
	 * @return String 결과값
	 * @throws SQLException, Exception
	 */
	public String checkNull( String str ) {

		if(str == null) {
			str = "";
		}

		return str.trim();
	}
	
}