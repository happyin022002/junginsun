/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAO.java
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.09 최도순 [CHM-201006977] Work with Bookings의 조회 옵션에 E/Q Type 추가
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * 
 * @author c9014850
 * @see CancellationMessageDBDAO 참조
 * @since J2EE 1.6
 */
public class CancellationMessageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -967552364859477192L;
	
	/**
	 * 
	 * @param bkgNo
	 * @param type
	 * @return
	 * @throws DAOException
	 */
	public int sned301UEdiCheck(String bkgNo, String type) throws DAOException {
		DBRowSet dbRowset = null;
		int count = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			List<String> bkgNos = new ArrayList<String>();
			if(bkgNo != null){
				StringTokenizer bkg_no = new StringTokenizer(bkgNo.trim(), " ");
				while(bkg_no.hasMoreTokens()){
					bkgNos.add(bkg_no.nextToken().trim());
				}
			}
			param.put("bkg_nos", bkgNos);
			param.put("type", type);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CancellationMessageDBDAOsned301UEdiCheckRSQL(), param, velParam);
			while (dbRowset.next()) {
				count = dbRowset.getInt("CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return count;
	}

}