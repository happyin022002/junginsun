/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchBKGRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.07.30 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchBKGRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBKGRefNo
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchBKGRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchBKGRefNoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT A.CUST_REF_NO_CTNT CUST_REF_NO1, B.CUST_REF_NO_CTNT CUST_REF_NO2, C.CUST_REF_NO_CTNT CUST_REF_NO3" ).append("\n"); 
		query.append("FROM BKG_REFERENCE A, BKG_REFERENCE B, BKG_REFERENCE C" ).append("\n"); 
		query.append("WHERE   A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND     A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND     A.BKG_REF_TP_CD = 'INVR'" ).append("\n"); 
		query.append("AND     B.BKG_REF_TP_CD = 'BKGR'" ).append("\n"); 
		query.append("AND     C.BKG_REF_TP_CD = 'S/IR'" ).append("\n"); 

	}
}