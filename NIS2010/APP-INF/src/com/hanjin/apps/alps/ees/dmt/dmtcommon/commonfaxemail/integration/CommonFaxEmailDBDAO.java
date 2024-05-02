/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonFaxEmailDBDAO.java
*@FileTitle : Fax Email Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.11.04 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS DMTCommonFaxEmailDBDAO <br>
 * - ALPS-InvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Mun Jung Cheol
 * @param <DmtComFaxSndInfoVO>
 * @see CommonFaxEmailBCImpl 참조
 * @since J2EE 1.6
 */

public class CommonFaxEmailDBDAO extends DBDAOSupport {

    /**
    * [Fax Email Send] 정보를 [INSERT] 합니다.<br>
    * 
    * @param String returnKey
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @throws DAOException
    */
    public void insertDmtFaxEmlSndHistory( String returnKey , DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;

        String tVal18 = "";
        try{
            
            String tempINVNO = (String)dmtComRDFaxEmailSendInfoVO.getInvno();
            String tempPAYER = (String)dmtComRDFaxEmailSendInfoVO.getPayc();
            log.debug("\n ####### insertDmtFaxEmlSndHistory tempINVNO [" + tempINVNO +"]");
            log.debug("\n ####### insertDmtFaxEmlSndHistory tempPAYER [" + tempPAYER +"]");
            StringTokenizer st = new StringTokenizer(tempINVNO, ",");
            int seqplus = 1;
            while (st.hasMoreTokens()) {
                tVal18 = st.nextToken();
                if ( !tVal18.equals("") && tVal18 != null && !tVal18.equals("null") ) {
	
	                log.debug("\n ####### insertDmtFaxEmlSndHistory fesndtp [" + dmtComFaxSndInfoVO.getBatFlg()                    + "] \n"
	                          + " ####### insertDmtFaxEmlSndHistory fesndno [" + returnKey                                         + "] \n"
	                          + " ####### insertDmtFaxEmlSndHistory sndoctp [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlDocTp()      + "] \n"
	                          + " ####### insertDmtFaxEmlSndHistory invoice [" + tVal18                                            + "] \n"
	                          + " ####### insertDmtFaxEmlSndHistory payercd [" + tempPAYER                                         + "] \n"
	                          + " ####### insertDmtFaxEmlSndHistory payreml [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() + "] \n"
	                          + " ####### insertDmtFaxEmlSndHistory payrfax [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo()      + "] \n"
	                          + " ####### insertDmtFaxEmlSndHistory sndrslt [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle()      + "]");
	
	                param.put( "fesndtp" , dmtComFaxSndInfoVO.getBatFlg()                    );
	                param.put( "fesndno" , returnKey                                         );
	                param.put( "sndoctp" , dmtComRDFaxEmailSendInfoVO.getRdFxemlDocTp()      );
	                param.put( "invoice" , tVal18                                            );
	                param.put( "payercd" , tempPAYER                                         );
	                param.put( "payreml" , dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() );
	                param.put( "payrfax" , dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo()      );
	                param.put( "sndrslt" , dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle()      );
	                if( account != null){
	                    param.put( "usid"    , account.getUsr_id()                               );
	                    param.put( "usof"    , account.getOfc_cd()                               );
	                } else {
	                    param.put( "usid"    , "AUTO BATCH"                               	  );
	                    log.debug("\n ####### dmtComRDFaxEmailSendInfoVO Creof [" + dmtComRDFaxEmailSendInfoVO.getCreof()      + "]");
	                    param.put( "usof"    , dmtComRDFaxEmailSendInfoVO.getCreof()          );
	                }
	
	                log.debug("\n ####### insertDmtFaxEmlSndHistory DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL 11111");
	                param.put( "seqplus" , seqplus++ );
	
	                log.debug("\n ####### insertDmtFaxEmlSndHistory DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL 22222");
	                SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
	                result = sqlExe.executeUpdate((ISQLTemplate)new DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL(), param, velParam);
	
	                log.debug("\n ####### insertDmtFaxEmlSndHistory DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL 333333");
                    if(result == Statement.EXECUTE_FAILED) {
                        throw new DAOException("FAIL TO INSERT DMT_FAX_EML_SND_HIS");
                    }
                }
            }
        }catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		} catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.debug("\n ####### Exception invoice [" + tVal18 +"]");
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
 	/**
 	 * Session User의 Email 를 조회 합니다.
 	 * 
	 * @param SignOnUserAccount account
	 * @return String
 	 * @throws DAOException
 	 */
 	public String searchSenderEmailByUser(SignOnUserAccount account) throws DAOException {
 		DBRowSet 	dbRowset 	= null;
 		String		result		= "";

 		//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		
 		try {
 			param.put("usr_id", account.getUsr_id());
 			param.put("usr_ofc", account.getOfc_cd());
    
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCommonFaxEmailDBDAOSearchSenderEmailByUserRSQL(), param, null);

 			if (dbRowset.next()) {
 				result = JSPUtil.getNull(dbRowset.getString("dflt_eml"));
 			}
 			
 		} catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		} catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return result;
 	}


 	/**
 	 * Session User의 Email 를 조회 합니다.
 	 * 
	 * @param FAXEmailByPayerVO faxEmailByPayerVO
	 * @return String
 	 * @throws DAOException
 	 */
 	public String searchEmailByPayer( FAXEmailByPayerVO faxEmailByPayerVO ) throws DAOException {
 		DBRowSet 	dbRowset 	= null;
 		String		result		= "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
 		
 		try {
			Map<String, String> mapVO = faxEmailByPayerVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
    
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCommonFaxEmailDBDAOSearchEmailByPayerRSQL(), param, velParam);

 			if (dbRowset.next()) {
 				result = JSPUtil.getNull(dbRowset.getString("CUST_EML"));
 			}
 			
 		} catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		} catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return result;
 	}

}
