/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonBCImpl.java
*@FileTitle : Sales Activity Item
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.bcm.ccd.ccdcommon.ccdcommon.vo.ComboListVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration.SalesAdminCommonDBDAO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SamActTpMstVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SearchActItemMstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SamSlsActTpDtlVO;
import com.clt.syscommon.common.table.SamSlsActVO;

/**
 * ALPS-SalesAdminCommon Business Logic Command Interface<br>
 * - ALPS-SalesAdminCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NAMKOONGJINHO
 * @see SalesAdminCommonBCImpl
 * @since J2EE 1.6
 */
public class SalesAdminCommonBCImpl extends BasicCommandSupport implements SalesAdminCommonBC {

	// Database Access Object
	private transient SalesAdminCommonDBDAO dbDao = null;

	/**
	 * SalesAdminCommonBCImpl 객체 생성<br>
	 * SalesAdminCommonDBDAO를 생성한다.<br>
	 */
	public SalesAdminCommonBCImpl() {
		dbDao = new SalesAdminCommonDBDAO();
	}
	/**
	 * [Sheet1]을 [조회] 합니다.<br>
	 * 
	 * @param SearchActItemMstVO searchActItemMstVO
	 * @return List<SearchActItemMstVO>
	 * @exception EventException
	 */
	public List<SearchActItemMstVO> searchActItemMstList(SearchActItemMstVO searchActItemMstVO) throws EventException {
		try {
			return dbDao.searchActItemMstList(searchActItemMstVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * [Sheet2]을 [조회] 합니다.<br>
	 * 
	 * @param SearchActItemMstVO searchActItemMstVO
	 * @return List<SearchActItemMstVO>
	 * @exception EventException
	 */
	public List<SearchActItemMstVO> searchActItemDtlList(SearchActItemMstVO searchActItemMstVO) throws EventException {
		try {
			return dbDao.searchActItemDtlList(searchActItemMstVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [Sheet1]을 [저장] 합니다.<br>
	 * 
	 * 
	 * @param SamActTpMstVO[] samActTpMstVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageActItemMstList(SamActTpMstVO[] samActTpMstVOs, SignOnUserAccount account) throws EventException, DAOException{
		try {
			List<SamActTpMstVO> insertVoList = new ArrayList<SamActTpMstVO>();
			List<SamActTpMstVO> updateVoList = new ArrayList<SamActTpMstVO>();
			List<SamActTpMstVO> deleteVoList = new ArrayList<SamActTpMstVO>();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			for ( int i=0; i<samActTpMstVOs.length; i++ ) {
				if ( samActTpMstVOs[i].getIbflag().equals("I")){
					insertVoList.add(samActTpMstVOs[i]);
				} else if ( samActTpMstVOs[i].getIbflag().equals("U")){
					updateVoList.add(samActTpMstVOs[i]);
				} else if ( samActTpMstVOs[i].getIbflag().equals("D")){
					deleteVoList.add(samActTpMstVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addActItemMstList(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyActItemMstList(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeActItemMstDtlList(deleteVoList);
				dbDao.removeActItemMstList(deleteVoList);
			}
			
			return eventResponse;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [Sheet2]를 [저장] 합니다.<br>
	 * 
	 * @param SamSlsActTpDtlVO[] samSlsActTpDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageActDtlList(SamSlsActTpDtlVO[] samSlsActTpDtlVOs, SignOnUserAccount account) throws EventException, DAOException{
		try {
			List<SamSlsActTpDtlVO> insertVoList = new ArrayList<SamSlsActTpDtlVO>();
			List<SamSlsActTpDtlVO> updateVoList = new ArrayList<SamSlsActTpDtlVO>();
			List<SamSlsActTpDtlVO> deleteVoList = new ArrayList<SamSlsActTpDtlVO>();
			
			for ( int i=0; i<samSlsActTpDtlVOs.length; i++ ) {
				if ( samSlsActTpDtlVOs[i].getIbflag().equals("I")){
					insertVoList.add(samSlsActTpDtlVOs[i]);
				} else if ( samSlsActTpDtlVOs[i].getIbflag().equals("U")){
					updateVoList.add(samSlsActTpDtlVOs[i]);
				} else if ( samSlsActTpDtlVOs[i].getIbflag().equals("D")){
					deleteVoList.add(samSlsActTpDtlVOs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeActItemMstListS(deleteVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addActItemMstListS(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyActItemMstListS(updateVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String retVal = CUST_CNT_CD||CUST_SEQ CUST_CD + "@@@" + CUST_LGL_ENG_NM
	 * @exception EventException
	 */
	public String checkCustomerCode(String custCd) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String retVal = "";
        
        try {
            rowSet=dbDao.checkCustomerCode(custCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;            
	}
	
	/**
	 * CR Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String retVal = CUST_CNT_CD||CUST_SEQ CUST_CD + "@@@" + CUST_LGL_ENG_NM
	 * @exception EventException
	 */
	public String checkCrCustomerCode(String custCd) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String retVal = "";
        
        try {
            rowSet=dbDao.checkCrCustomerCode(custCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;            
	}
	
	/**
	 * Customer Code와 Name 을 체크합니다.<br>
	 * 
	 * @param String custCdNm
	 * @return String retVal = CUST_CNT_CD||CUST_SEQ CUST_CD + "@@@" + CUST_LGL_ENG_NM
	 * @exception EventException
	 */
	public String checkCustCodeName(String custCdNm) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String retVal = "";
        
        try {
        	rowSet = dbDao.checkCustCodeName(custCdNm);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;            
	}
	
	/**
	 * Cntc Customer Code 를 체크합니다.<br>
	 * 
	 * @param String custCd
	 * @return String retVal = CUST_CNT_CD||CUST_SEQ CUST_CD + "@@@" + CUST_LGL_ENG_NM
	 * @exception EventException
	 */
	public String checkCntcCustomerCode(String custCd) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String retVal = "";
        
        try {
            rowSet=dbDao.checkCntcCustomerCode(custCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;            
	}
	
	/**
	 * Group Customer Name 을 가져옵니다.<br>
	 * 
	 * @param String grpCustCd
	 * @return String
	 * @exception EventException
	 */
	public String getGroupCustName(String grpCustCd) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.getGroupCustName(grpCustCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	
	/**
	 * Office Code 를 체크합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkOfficeCd(String ofcCd) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.checkOfficeCd(ofcCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * Sales Repository Code 를 체크합니다.<br>
	 * 
	 * @param String sRepCd
	 * @return String
	 * @exception EventException
	 */
	public String checkSalesRepCode(String sRepCd) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.checkSalesRepCode(sRepCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * User Authority 를 가져옵니다.<br>
	 * 
	 * @param String usrAuth
	 * @return String
	 * @exception EventException
	 */
	public String getUserAuth(SignOnUserAccount account) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.getUserAuth(account);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * Location Code 를 가져옵니다.<br>
	 * 
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCode(String locCd) throws EventException {
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.checkLocCode(locCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	
	/**
	 * Office Team Code 를 가져옵니다.<br>
	 * 
	 * @param String ofcTeamCd
	 * @return String
	 * @exception EventException
	 */
	public String checkOfcTeamCode(String ofcTeamCd) throws EventException {
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.checkOfcTeamCode(ofcTeamCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	
	 /**
	 * 1. 기능 : default combo,ibsheet codelist를 return <p>
	 * 2. 처리개요 : <p>
	 * 3. 주의사항 : <p>
	 * 
	 * @param String codeItem      	Where절에 들어갈 코드그룹
	 * @return List<ComboListVO>
	 * @throws EventException
	 */
	public List<ComboListVO> searchCodeList(String codeItem) throws EventException {
		List<ComboListVO> list = new ArrayList<ComboListVO>();
    	DBRowSet dRs = null;
	        try {
	        	if(codeItem.equalsIgnoreCase("SamActType")){	     	 	 
	        		dRs = dbDao.searchSamActType();
	        	}else if(codeItem.equalsIgnoreCase("SamActSubType")){	     	 	 
	        		dRs = dbDao.searchSamActSubType();
	        	}else if(codeItem.equalsIgnoreCase("MajorTrade")){	     	 	 
	        		dRs = dbDao.searchMajorTrade();
	        	}else{
        	    //공통코드	
    	    	Collection codeList2 = null; 
    	    	codeList2 = com.clt.framework.component.util.code.CodeUtil.getInstance().getCodeSelect(codeItem,0);
    	    	Iterator iterator = codeList2.iterator();	        		
                 
        		com.clt.framework.component.util.code.CodeInfo codeModel2 = null;
    			while (iterator.hasNext()) {
    				codeModel2 = (com.clt.framework.component.util.code.CodeInfo) iterator.next();
    				if (codeModel2 != null){
    					ComboListVO vo = new ComboListVO();
	    				vo.setCd(codeModel2.getCode());
	    				vo.setCdDesc(codeModel2.getName());
	    				vo.setCdEtc("");
	    				list.add(vo);
    				}
    			}
	        	}
	        	if (dRs != null){
	        		list = (List) RowSetUtil.rowSetToVOs(dRs, ComboListVO.class);
	        	}
	        } catch(SQLException se){
	            log.error("SQLException : " +se.getMessage());
	            throw new EventException("SQLException : " + se.getMessage());
	        } 
	        catch(Exception ex){
	        	log.error("Exception : " +ex.getMessage());
	        	throw new EventException("Exception : " + ex.getMessage());
	        }
	        return list;  
   }
	
	
	/**
     * 기능 : default combo,ibsheet codelist를 return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * <br><b>Example : </b>
	 * <pre>
	 *     String array[][] = {{"trade","",""}};
	 *     eventResponse = CodeUtil.getMakeCodeSelectList(eventResponse,array);
	 * </pre>
     * @throws EventException
     */
    public GeneralEventResponse searchCommonCodeList(GeneralEventResponse eventResponse,String[][] array) throws EventException {
    	List<ComboListVO> list = new ArrayList<ComboListVO>();
    	ComboListVO combovo = new ComboListVO();
 	    
 	    try {
	    	for(int i=0 ; i< array.length ; i++) {
	    		list = searchCodeList((array[i][0]).toString());
	    		if ("All".equals(array[i][2])){
	    			combovo.setCd("ALL");
	    	 	    combovo.setCdDesc("ALL");
	    	 	    combovo.setCdEtc("ALL");
	    			list.add(0,combovo);
	    		}else if ("Blank".equals(array[i][2])){
	    			combovo.setCd(" ");
	    	 	    combovo.setCdDesc(" ");
	    	 	    combovo.setCdEtc(" ");
	    			list.add(0,combovo);
	    		}
	    		eventResponse.setRsVoList(list);   
	    	}
 	   } catch(Exception ex){
 		   log.error("Exception : " +ex.getMessage());
 		   throw new EventException("Exception : " + ex.getMessage());
       }
 	   return eventResponse;
	}
    
	/**
	 * Customer의 Activity를 실행한 Sales Rep을 조회합니다.<br>
	 * 
	 * @param SamSlsActVO samSlsActVO
	 * @return String
	 * @exception EventException
	 */
	public String checkSrepByActivity(SamSlsActVO samSlsActVO) throws EventException{
		DBRowSet rowSet = null;							// 데이터전송을 위한 DB ResultSet
        String check = "";
        
        try {
            rowSet=dbDao.checkSrepByActivity(samSlsActVO);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
}