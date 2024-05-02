/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingMasterMgtDBDAOsearchBdrAccessAuthorityRSQL.java
*@FileTitle : BDR Access Setting
*Open Issues :
*Change history : 
*@LastModifyDate : 2014.03.31
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2014.03.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOsearchBdrAccessAuthorityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDR 권한 조회
	  * </pre>
	  */
	public BookingMasterMgtDBDAOsearchBdrAccessAuthorityRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_box",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOsearchBdrAccessAuthorityRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("         A.ATTR_CTNT3 AS CLOSE_AUTH" ).append("\n"); 
		query.append("        ,A.ATTR_CTNT2 AS OPEN_AUTH" ).append("\n"); 
		query.append("        ,A.ATTR_CTNT1 AS USR_ID" ).append("\n"); 
		query.append("        ,B.USR_NM " ).append("\n"); 
		query.append("        ,B.OFC_CD " ).append("\n"); 
		query.append("        ,A.UPD_DT" ).append("\n"); 
		query.append("        ,''SEARCH_BOX" ).append("\n"); 
		query.append("        ,''SEARCH_OPTION " ).append("\n"); 
		query.append("        ,A.HRD_CDG_ID_SEQ" ).append("\n"); 
		query.append("        ,''CRE_USR_ID" ).append("\n"); 
		query.append("        ,''UPD_USR_ID" ).append("\n"); 
		query.append("        ,''SHEET_USR_ID" ).append("\n"); 
		query.append("    FROM BKG_HRD_CDG_CTNT A, COM_USER B" ).append("\n"); 
		query.append("    WHERE A.HRD_CDG_ID='BDR_MAN_USER'" ).append("\n"); 
		query.append("    AND A.ATTR_CTNT1 = B.USR_ID(+)" ).append("\n"); 
		query.append("    AND A.ATTR_CTNT4 ='N'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sheet_usr_id} != '') " ).append("\n"); 
		query.append("		AND A.ATTR_CTNT1 = @[sheet_usr_id]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${search_box} != '')    " ).append("\n"); 
		query.append("    	#if (${search_option} == 'N') " ).append("\n"); 
		query.append("    		AND UPPER(B.USR_NM) LIKE UPPER(@[search_box])|| '%'" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("    		" ).append("\n"); 
		query.append("    	#else " ).append("\n"); 
		query.append("    		AND UPPER(A.ATTR_CTNT1) LIKE UPPER(@[search_box])|| '%'" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}