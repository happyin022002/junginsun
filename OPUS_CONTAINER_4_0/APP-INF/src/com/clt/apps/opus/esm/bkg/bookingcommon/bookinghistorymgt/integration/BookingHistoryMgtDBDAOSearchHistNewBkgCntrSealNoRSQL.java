/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistNewBkgCntrSealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistNewBkgCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDASearchHistNewBkgCntrSealNoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistNewBkgCntrSealNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistNewBkgCntrSealNoRSQL").append("\n"); 
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
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("      (SELECT 'SEAL No.' HIS_CATE_NM " ).append("\n"); 
		query.append("             , '' PRE_CTNT" ).append("\n"); 
		query.append("            , CNTR_NO||'/'||" ).append("\n"); 
		query.append("	   		   BKG_JOIN_FNC( CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("                    		  FROM BKG_CNTR_SEAL_NO_HIS B" ).append("\n"); 
		query.append("		                     WHERE BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("   							   AND CORR_NO(+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    		  FROM BKG_CNTR_SEAL_NO B" ).append("\n"); 
		query.append("		                     WHERE BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("							   AND B.CNTR_NO = NOW.CNTR_NO" ).append("\n"); 
		query.append("							 ORDER BY CNTR_SEAL_SEQ" ).append("\n"); 
		query.append(" 							)) CRNT_CTNT" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_CNTR_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO  = @[bkg_no] " ).append("\n"); 
		query.append("	       AND NOW.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("		   AND NOW.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($field_list.size() > 0)" ).append("\n"); 
		query.append("           AND (BKG_NO, CNTR_NO) NOT IN (" ).append("\n"); 
		query.append("           #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("               #if($velocityCount < $field_list.size()) $field_id,  #else $field_id  #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE CRNT_CTNT IS NOT NULL" ).append("\n"); 
		query.append("   AND LENGTH(CRNT_CTNT) > 12" ).append("\n"); 

	}
}