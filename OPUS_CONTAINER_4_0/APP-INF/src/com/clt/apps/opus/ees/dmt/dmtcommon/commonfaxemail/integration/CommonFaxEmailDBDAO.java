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

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.basic.CommonFaxEmailBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueDBDAOSearchRdApplCdFtpRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS DMTCommonFaxEmailDBDAO <br>
 * - OPUS-InvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Mun Jung Cheol
 * @param <DmtComFaxSndInfoVO>
 * @see CommonFaxEmailBCImpl 참조
 * @since J2EE 1.6
 */

public class CommonFaxEmailDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * [Fax Email Send] 정보를 [INSERT] 합니다.<br>
	 * 
	 * @param String returnKey
	 * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
	 * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void insertDmtFaxEmlSndHistory(String returnKey, DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO, DmtComFaxSndInfoVO dmtComFaxSndInfoVO, SignOnUserAccount account) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		String tVal18 = "";
		try {

			String tempINVNO = (String) dmtComRDFaxEmailSendInfoVO.getInvno();
			String tempPAYER = (String) dmtComRDFaxEmailSendInfoVO.getPayc();
			log.debug("\n ####### insertDmtFaxEmlSndHistory tempINVNO [" + tempINVNO + "]");
			log.debug("\n ####### insertDmtFaxEmlSndHistory tempPAYER [" + tempPAYER + "]");
			StringTokenizer st = new StringTokenizer(tempINVNO, ",");
			int seqplus = 1;
			while (st.hasMoreTokens()) {
				tVal18 = st.nextToken();
				if (!tVal18.equals("") && tVal18 != null && !tVal18.equals("null")) {
					log.debug("\n ####### insertDmtFaxEmlSndHistory fesndtp ["+ dmtComFaxSndInfoVO.getBatFlg() + "] \n"
							  + " ####### insertDmtFaxEmlSndHistory fesndno [" + returnKey + "] \n"
							  + " ####### insertDmtFaxEmlSndHistory sndoctp [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlDocTp() + "] \n"
							  + " ####### insertDmtFaxEmlSndHistory invoice [" + tVal18 + "] \n"
							  + " ####### insertDmtFaxEmlSndHistory payercd [" + tempPAYER + "] \n"
							  + " ####### insertDmtFaxEmlSndHistory payreml [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() + "] \n"
							  + " ####### insertDmtFaxEmlSndHistory payrfax [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo() + "] \n"
							  + " ####### insertDmtFaxEmlSndHistory sndrslt [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle() + "]");

					param.put("fesndtp", dmtComFaxSndInfoVO.getBatFlg());
					param.put("fesndno", returnKey);
					param.put("sndoctp", dmtComRDFaxEmailSendInfoVO.getRdFxemlDocTp());
					param.put("invoice", tVal18);
					param.put("payercd", tempPAYER);
					param.put("payreml", dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd());
					param.put("payrfax", dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo());
					param.put("sndrslt", dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle());
					param.put("usid", account.getUsr_id());
					param.put("usof", account.getOfc_cd());
					param.put("seqplus", seqplus++);

					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate) new DMTCommonFaxEmailDBDAODmtFaxEmlSndHisCSQL(), param, velParam);
					if (result == Statement.EXECUTE_FAILED) {
						throw new DAOException("FAIL TO INSERT DMT_FAX_EML_SND_HIS");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			log.debug("\n ####### Exception invoice [" + tVal18 + "]");
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
		DBRowSet dbRowset = null;
		String result = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("user_id", account.getUsr_id());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DMTCommonFaxEmailDBDAOSearchSenderEmailByUserRSQL(), param, null);

			if (dbRowset.next()) {
				result = JSPUtil.getNull(dbRowset.getString("dflt_eml"));
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * FAX 발송할 수신자(Payer)의  이름을 조회 합니다.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception DAOException
	 */
	public String[] searchPayerName(String custCd) throws DAOException {
		String payerInfo[] = new String[2];
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			mapVO.put("cust_cd", custCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DMTCommonFaxEmailDBDAOSearchPayerNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				payerInfo[0] = dbRowset.getString("PAYER_NM");
				payerInfo[1] = dbRowset.getString("OFC_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return payerInfo;
	}
	

	
	/**
	 * Digital Signing FTP 처리 위한 MRD 정보 Search <br>
	 * 2016.03.24 Add
	 * @author CLT
	 * @param String mrdNm
	 * @return String[]
	 * @throws DAOException
	 */ 
	public String[] searchRdApplCdFtp(String mrdNm) throws DAOException {
		DBRowSet dbRowset = null;
		String rdApplInfo[] = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("mrd_nm", mrdNm);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchRdApplCdFtpRSQL(), param, velParam);
			if (dbRowset.next()) {
				rdApplInfo[0] = dbRowset.getString("RD_APPL_CD");
				rdApplInfo[1] = dbRowset.getString("RD_SUB_SYS_CD");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rdApplInfo;
	}
	
	/**
	 * Office Code의 Country Code 를 조회한다.<br>
	 * 2016.03.24 Add
	 * @author CLT
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */ 
	public String searchCountryCodeByOfcCd(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnCntCd = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonFaxEmailDBDAOSearchCountryCodeByOfcCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnCntCd = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnCntCd;
	}
	
	/**
	 * Default Mail Address 를 조회한다.<br>
	 * 2016.03.24 Add
	 * @author CLT
	 * @return String
	 * @throws DAOException
	 */ 
	public String searchDefaultMailAddress() throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCommonFaxEmailDBDAOSearchDefaultMailAddressRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnStr;
	}

}
