/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgCntrSealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgCntrSealNoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgCntrSealNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgCntrSealNoRSQL").append("\n"); 
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
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("	  , @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append("	  , @[cntr_seal_no] CNTR_SEAL_NO" ).append("\n"); 
		query.append(" FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("      (SELECT 'SEAL No.' HIS_CATE_NM" ).append("\n"); 
		query.append("            , OLD.CNTR_SEAL_NO PRE_CTNT" ).append("\n"); 
		query.append("            , NOW.CNTR_NO||'/'||" ).append("\n"); 
		query.append("	   		   BKG_JOIN_FNC( CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("                    		  FROM BKG_CNTR_SEAL_NO_HIS SEAL" ).append("\n"); 
		query.append("		                     WHERE SEAL.BKG_NO  = NOW.BKG_NO" ).append("\n"); 
		query.append("   							   AND SEAL.CORR_NO = NOW.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    		  FROM BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("		                     WHERE SEAL.BKG_NO  = NOW.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("							   AND SEAL.CNTR_NO = NOW.CNTR_NO" ).append("\n"); 
		query.append(" 							)) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM BKG_CNTR_HIS NOW, OLD" ).append("\n"); 
		query.append(" WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("   AND NOW.CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER NOW, OLD" ).append("\n"); 
		query.append(" WHERE NOW.BKG_NO (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND NOW.CNTR_NO(+) = OLD.CNTR_NO" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 
		query.append("   AND LENGTH(PRE_CTNT) > ( CASE WHEN   LENGTH(CRNT_CTNT) > 1 AND @[cntr_seal_no] IS NOT NULL THEN  11" ).append("\n"); 
		query.append("                                 ELSE 12 END )" ).append("\n"); 

	}
}