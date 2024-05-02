/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOCheckInvChgIfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOCheckInvChgIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inv로 운임이 interface되었는지 확인
	  * </pre>
	  */
	public TransferOrderIssueDBDAOCheckInvChgIfRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOCheckInvChgIfRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N','Y') IF_FLG" ).append("\n"); 
		query.append("FROM DOD_DRP_OFF_CHG G, BKG_EUR_TRO T" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND G.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND G.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND G.DRP_OFF_CHG_SEQ = (SELECT MAX(C.DRP_OFF_CHG_SEQ)" ).append("\n"); 
		query.append("                           FROM  DOD_DRP_OFF_CHG C" ).append("\n"); 
		query.append("                           WHERE 1 = 1" ).append("\n"); 
		query.append("                             AND C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                             AND C.CNTR_NO = G.CNTR_NO)" ).append("\n"); 
		query.append("  AND G.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("  AND G.CNTR_NO = T.CNTR_NO" ).append("\n"); 
		query.append("  AND T.IO_BND_CD = 'I'" ).append("\n"); 

	}
}