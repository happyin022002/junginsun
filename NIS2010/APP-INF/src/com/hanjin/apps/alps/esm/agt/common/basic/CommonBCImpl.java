/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonBCImpl.java
*@FileTitle : 공통업무 관리 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-20
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-11-20 junghyung kim
* 1.0 최초 생성
*2009-09-08 : Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.basic;

//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.HashMap;

import com.hanjin.apps.alps.esm.agt.common.event.CommonEvent;
import com.hanjin.apps.alps.esm.agt.common.event.CommonEventResponse;
import com.hanjin.apps.alps.esm.agt.common.integration.CommonDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ENIS-Agent Commission에 대한 공통업무 처리를 담당<br>
 * - ENIS-Agent Commission에 대한 공통업무 비지니스 로직을 처리한다.<br>
 * 
 * @author junghyung kim
 * @see CommonBC 참조
 * @since J2EE 1.4
 */
public class CommonBCImpl   extends BasicCommandSupport implements CommonBC {

    // Database Access Object
    private transient CommonDBDAO dbDao=null;
    
    /**
     * CommonDBDAO를 생성한다.<br>
     */
    public CommonBCImpl(){
        dbDao = new CommonDBDAO();
    }
    
    
    /**
     * (단건)Vendor 코드를 리턴한다.<br>
     *
     * @param  String seq
     * @return HashMap<String, String>
     * @exception EventException
     */
    public HashMap<String, String> searchVendorCode(String seq) throws EventException {
    	HashMap<String, String> rtnHashMap = null;
        
        try {
        	rtnHashMap = dbDao.searchVendorCode(seq);                        
            return rtnHashMap;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch(Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * (배열)Vendor 코드를 리턴한다.<br>
     *
     * @param  String[] seq
     * @return HashMap<String, Object>
     * @exception EventException
     */
    public HashMap<String, Object> searchVendorCode(String[] seq) throws EventException {
    	HashMap<String, Object> rtnHashMap = null;
        
        try {
        	rtnHashMap = dbDao.searchVendorCode(seq);
            return rtnHashMap;
           
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
        	throw new EventException(de.getMessage());
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        	throw new EventException(e.getMessage());
        }
    }
    
    /**
     * Customer/Vendor의 Code/Name을 리턴한다.<br>
     *
     * @param  String codeGubun
     * @param  String codeType
     * @param  String param
     * @return String 
     * @throws EventException
     */
    public String searchCode(String codeGubun, String codeType, String param) throws EventException{
    	String rtnValue = "";
    	
    	try{
    		rtnValue = dbDao.searchCode(codeGubun, codeType, param);
    		return rtnValue;
    		
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
        	throw new EventException(de.getMessage());
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        	throw new EventException(e.getMessage());
        }
    }
   
    /**
     * Customer/Vendor 배열의 Code/Name을 배열로 리턴한다.<br>
     *
     * @param  String codeGubun
     * @param  String codeType
     * @param  String[] param
     * @return String[] 
     * @throws EventException
     */
    public String[] searchCodeList(String codeGubun, String codeType, String[] param) throws EventException{
    	String[] rtnValue = new String[param.length];
    	
    	try{
    		rtnValue = dbDao.searchCodeList(codeGubun, codeType, param);
    		
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
        	throw new EventException(de.getMessage());
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        	throw new EventException(e.getMessage());
        }
        return rtnValue;
    }
   
    /**
     * 사용자가 입력한 Customer의 Name을 가져온다.<br>
     * 
     * @param  Event et
     * @return EventResponse 
     * @throws EventException
     */
    public EventResponse searchCustomerName( Event et ) throws EventException{
    	
    	CommonEvent event = (CommonEvent)et;
    	HashMap<String, String> rtnMap = null;
    	String cust_cd = "";

    	try{

    		cust_cd = event.getString("cust_cd");
    		rtnMap = dbDao.searchCustomerName( cust_cd );
    		return new CommonEventResponse(rtnMap);

    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
        	throw new EventException(de.getMessage());
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        	throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 연동에러 및 Commission 배치 에러 저장 및 삭제 처리<br>
     * 
     * @param  HashMap<String, String> logMap
     * @throws DAOException
     */
    public void processAgtErrLog(HashMap<String, String> logMap) throws EventException{
    	
    	try{

    		logMap = dbDao.processAgtErrLog( logMap );

    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
        	throw new EventException(de.getMessage());
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        	throw new EventException(e.getMessage());
        }
    }
    
    /**
     * (단건)Office 코드(Name)를 리턴한다.<br>
     *
     * @param  String ofc_cd
     * @return HashMap<String, String>
     * @exception EventException
     */
    public HashMap<String, String> searchOfficeCode(String ofc_cd) throws EventException {
    	HashMap<String, String> rtnHashMap = null;
        
        try {
        	rtnHashMap = dbDao.searchOfficeCode(ofc_cd);                        
            return rtnHashMap;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch(Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
    }
    
    /**
     * AGT 업무 시나리오 마감작업<br>
     * 공통업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        dbDao = null;
    }



}