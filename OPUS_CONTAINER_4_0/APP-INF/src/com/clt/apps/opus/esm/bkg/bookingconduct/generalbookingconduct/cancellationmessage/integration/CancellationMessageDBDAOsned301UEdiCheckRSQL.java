/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CancellationMessageDBDAOsned301UEdiCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.19 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CancellationMessageDBDAOsned301UEdiCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sned301UEdiCheck
	  * </pre>
	  */
	public CancellationMessageDBDAOsned301UEdiCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.integration").append("\n"); 
		query.append("FileName : CancellationMessageDBDAOsned301UEdiCheckRSQL").append("\n"); 
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
		query.append("SELECT CNT FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  COUNT(BB.BKG_NO) AS CNT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($bkg_no IN ${bkg_nos})        " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_nos.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND XTER_BKG_RQST_CD NOT IN ('OFF', 'WEB', 'COM') " ).append("\n"); 
		query.append("AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  COUNT(BB.BKG_NO) AS CNT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB, BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND BB.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($bkg_no IN ${bkg_nos})        " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_nos.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BHCC.HRD_CDG_ID = 'CUSTOMER_301U'" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = BB.BKG_NO AND BC.CUST_CNT_CD || BC.CUST_SEQ = BHCC.ATTR_CTNT2)" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE CNT > 0" ).append("\n"); 

	}
}