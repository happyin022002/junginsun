/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtil.java
*@FileTitle : AGT CodeList Utility
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-08-25 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.clt.apps.opus.esm.agt.common.event.CodeInfo;
import com.clt.apps.opus.esm.agt.common.integration.CommonDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * OPUS-AGT Code List Utility<br>
 * - OPUS-AGT에 대한 코드 리스트 조회 유틸리티<br>
 *
 * @author junghyung kim
 * @see ComboUtil 참조
 * @since J2EE 1.4
 */
public class CodeUtil extends BasicCommandSupport {

	//log 객체
    //protected transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());

    //CodeDAO 객체
    private transient CommonDBDAO codedao = null;

    //CodeUtil 객체
    private static CodeUtil instance = new CodeUtil();

    /**
     * 1. 기능 : CodeInfo getInstance()<p>
     * 2. 처리개요 :  <p>
     *    - 객체생성시에 instance를 만들고 공유한다. <p>
     * 3. 주의사항 : <p>
     *@return CodeUtil
     **/    
    public static CodeUtil getInstance() {
        return instance;
    }

    /**
     * 1. 기능 : CodeUtil 생성자<p>
     *
     **/
    private CodeUtil() {
        codedao = new CommonDBDAO();
    }

    /**
     * 1. 기능 : default combo,ibsheet codelist를 return <p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * 
     * @param codeItem  	업무 구분
	 *  					01.A/R Office List	: arOfcCd (Office Code로 A/R Office List 찾기)
	 *                         A/R Ofiice Code  : arOfcCd2 (Office Code로 A/R Office Code 찾기)
	 *  					02.Subject Office Code	: sbOfcCd (A/R Office COde로 하위 Office List 찾기)
	 *                      
     * @param code      	Where절에 들어갈 코드
     * @return Collection
     * @throws EventException
     */
    public Collection getCodeSelect(String codeItem, String code) throws EventException {
    	DBRowSet dRs = null;
    	ArrayList arrList = null;
		Collection codeList = null;
		
        try {
        	if(codeItem.equals("arOfcCd")){		 			// 1. A/R Office List
        		dRs = codedao.searchAROfficeList(code);
        	}else if(codeItem.equals("arOfcCd2")){			//    A/R Office Code	No Search
        		dRs = codedao.searchAROfficeCode(code);
        	}else if(codeItem.equals("facArOfcCd")){		//    FAC A/R Office Code	No Search
        		dRs = codedao.searchFACAROfficeList(code);        		
        	}else if(codeItem.equals("sbOfcCd")){			// 2. Subejct Office List	
        		dRs = codedao.searchSubOfficeList(code);
        	}else if(codeItem.equals("facSubOfcCd")){		//    FAC Subejct Office List	NO search
        		dRs = codedao.searchFACSubOfficeList(code);        		
        	}else if(codeItem.equals("asaNo")){				// 3. ASA No	
        		dRs = codedao.searchAsaNoListBySbOfcCd(code);
        	}else if(codeItem.equals("facOfcCd")){			// 4. FAC Office List No Use	
        		dRs = codedao.searchFACOfficeList();
        	//여기에 else if 를 추가하세요.
        	}else if(codeItem.equals("codeList")){			// codeList No Use
        		dRs = codedao.searchCommonCodeList(code);
        	}else if(codeItem.equals("rptGroup")){			// rptGroup
        		dRs = codedao.searchRptGroup(code);
        	}else if(codeItem.equals("arOfcListFac")){		//    A/R Office Code For FAC	
        		dRs = codedao.searchAROfficeListForFAC(code);
        	}else if(codeItem.equals("OfcVndrMachList")){		//    Office 대 Vendor Mach Office List	No Use Table(agt_ofc_vndr_mtch)
        		dRs = codedao.searchOfcVndrMachOfficeList();
        	}else if(codeItem.equals("mdmAccountList")){		//    Other Commission 용 계정 List
        		dRs = codedao.searchMdmAccountList();
        	}else if(codeItem.equals("trade")){		//    Other Commission 용 계정 List
        		dRs = codedao.searchTradeList();
        	}else if(codeItem.equalsIgnoreCase("rLane")){				// 4. Revenue lane List
        		dRs = codedao.searchRevLaneList(code);
        	}
        	
        	if(dRs != null){
        		arrList = new ArrayList();

        		while(dRs.next()){
					arrList.add(new CodeInfo(dRs.getString("code"), dRs.getString("name")));
				}
				
				codeList = arrList;
        	}
			
            return codeList;

        } catch(SQLException se){
            log.error(se.getMessage());
            throw new EventException("Code Exception : " + se.getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        	throw new EventException(e.getMessage());
        }
    }
    
    /**
     * 1. 기능 : default combo,ibsheet codelist를 return <p>
     * 2. 처리개요 : <p>
     * 3. 주의사항 : <p>
     * 
     * @param codeItem  	업무 구분
	 *  					01.A/R Ofiice Code  : arOfcCd (User Office로 A/R Office Code 찾기)
	 *                      02.Vendor Info      : vendor  (Subject Office에 속한 Vendor 찾기)
	 *                      03.Country Code     : country (A/R Office로 Country Code 찾기)
	 *                      
     * @param code      	Where절에 들어갈 코드
     * @return
     * @throws EventException
     */
    public String getCodeInfo(String codeItem, String code) throws EventException {
    	String rtnCode = "";
    	DBRowSet dRs = null;
    	
        try {
        	if(codeItem.equals("arOfcCd")){						// 1. A/R Office Code by User Office
        		dRs = codedao.searchAROfficeCode(code);
        	}else if(codeItem.equals("vendor")){				// 2. Vendor Info by Subject Office
        		dRs = codedao.searchVendorInfoBySbOfcCd(code);
        	}else if(codeItem.equals("country")){				//3. Country Code by A/R Office
        		dRs = codedao.searchCountryCodeByArOfcCd(code);	
        	}else{
        		throw new EventException("codeItem Exception");
        	}
        	
        	if(dRs != null){
        		while(dRs.next()){
        			if(codeItem.equals("vendor")){
        				rtnCode = dRs.getString("code") + " : " + dRs.getString("name");
        			}else{
        				rtnCode = dRs.getString("code");
        			}
				}
        	}
            
            return rtnCode;
			
        } catch(SQLException se){
            log.error(se.getMessage());
            throw new EventException("Code Exception : " + se.getMessage());
            //throw new EventException(se.getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
            //throw new EventException(de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }
    
    /**
     * (ESM_AGT_016) 선택한 Office의 Vendor, Name, Office, City, Ceneter, Curr 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @param  curr	 Currency
     * @param  aplyDt apply Date
     * @return HashMap
     * @throws EventException
     */
    public HashMap<String, String> getOfficeInfo(String ofcCd) throws EventException {
    	HashMap<String, String> rtnHash = new HashMap<String, String>();
    	
        try {
        	rtnHash = codedao.searchOfficeInfo(ofcCd);
        	
        	return rtnHash;
        	
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }
    
    /**
     * (ESM_AGT_047) Other Commission용 선택한 Office의 Vendor, Name, Office, City, Ceneter, Curr 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @param  curr	 Currency
     * @param  aplyDt apply Date
     * @return HashMap
     * @throws EventException
     */
    public HashMap<String, String> getOtherOfficeInfo(String ofcCd) throws EventException {
    	HashMap<String, String> rtnHash = null;
    	
        try {
        	rtnHash = codedao.searchOtherOfficeInfo(ofcCd);
        	
        	return rtnHash;
			
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }
    
    /**
     * (ESM_AGT_016) 선택한 Office, Apply Date의 xchRt 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @param  aplyDt apply Date
     * @return HashMap
     * @throws EventException
     */
    public String getXchRt(String ofcCd, String aplyDt) throws EventException {
        String rtnStr = "";
    	
        try {
        	rtnStr = codedao.searchXchRt(ofcCd, aplyDt);
        	
        	return rtnStr;
			
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }
    
    /**
     * (ESM_AGT_042) 선택한 Curr 의 xchRt 정보를 가져온다.<br>
     * 
     * @param  curr Curr Code
     * @param  aplyDt apply Date
     * @return HashMap
     * @throws EventException
     */
    public String getCurrXchRt(String curr, String aplyDt) throws EventException {
    	String rtnStr = "";
    	
        try {
        	rtnStr = codedao.searchCurrXchRt(curr, aplyDt);
        	
        	return rtnStr;
			
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }
    
    /**
     * (ESM_AGT_038) 로그인한 유저가 속한 H/Q Office 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @return String H/Q Office Code
     * @throws EventException
     */
    public String getHQOfficeInfo(String param1) throws EventException {
    	String rtnStr = "";
    	
        try {
        	rtnStr = codedao.searchHQOfficeInfo(param1);
        	
        	return rtnStr;
			
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }
    
    /**
     * (ESM_AGT_038) 입력한 Office의 A/R Office 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @return String A/R Office Code
     * @throws EventException
     */
    public String getAROfficeInfo(String param1) throws EventException {
    	String rtnStr = "";
    	DBRowSet dRs = null;
    	
        try {
        	dRs = codedao.searchAROfficeCode(param1);
        	
        	if(dRs != null){
        		while(dRs.next()){
					rtnStr = dRs.getString("code");
				}
        	}

        	return rtnStr;
			
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }
    
    /**
     * (ESM_AGT_017) 입력한 Office의 A/R Office 정보를 가져온다.<br>
     * 
     * @param  ofcCd Office Code
     * @return String A/R Office Code
     * @throws EventException
     */
    public String getOffsetFlag(String param1) throws EventException {
    	String rtnStr = "";
    	
        try {
        	rtnStr = codedao.searchOffsetFlag(param1);
        	return rtnStr;
			
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }    
    
    /**
     * (ESM_AGT_040) Agent Commission Report의 Default Column 정보를 조회한다.<br>
     * 
     * @param  userId User ID
     * @return String[] Default Column 정보
     * @throws EventException
     */
    public String[] getAGTCommRptDefaultItem(String userId, int seq) throws EventException {
    	
    	DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	
    	int i = 0;
		String[] strItem = new String[2];   
		strItem[0] = "";
		strItem[1] = "";
		
        try {
        	
        	rowSet = codedao.searchAGTCommRptDefaultItem(userId, seq);
        	
			while (rowSet.next()) {
				strItem[0] = strItem[0] + rowSet.getString("rpt_itm_desc");    //rpt_itm_desc,
				strItem[1] = strItem[1] + rowSet.getString("rpt_itm_col_nm");  //rpt_itm_desc,
				if (rowSet.getRowCount() - 1 != i) {
					strItem[0] = strItem[0] + "|";
					strItem[1] = strItem[1] + "|";
				    i++;
				}
			}
			
			return strItem;
			
        } catch (DAOException de) {
            log.error(de.getMessage());
            throw new EventException("Code Exception : " + de.getMessage());
        } catch(Exception e){
	    	log.error(e.getMessage());
	    	throw new EventException(e.getMessage());
	    }
    }
}
