/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301TroMainInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301TroMainInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301TroMainInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301TroMainInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301TroMainInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("	   TRO_SEQ," ).append("\n"); 
		query.append("'{TRO_OUT'																								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_SEQ:'				|| LPAD(TRO_SEQ, 2, '0')	        									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_TEL:'				|| NVL(ACT_SHPR_PHN_NO, ' ')			  	    						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_FAX:'				|| NVL(CNTC_FAX_NO, ' ')									            || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_MOBILE:'			|| NVL(CNTC_MPHN_NO, ' ')				            					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_ACUST_NM:'  		|| SUBSTR(NVL(ACT_SHPR_NM, ' '), 1, 50)			 						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_PERSON:'			|| SUBSTR(NVL(CNTC_PSON_NM, ' '), 1, 20)	  	                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_OWN_TRK:'   		|| OWNR_TRK_FLG															|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_REMARK:'    		|| NVL(TRANSLATE(DIFF_RMK, CHR(10)||CHR(13), ' '), ' ')					|| CHR(10)" ).append("\n"); 
		query.append("|| '}TRO_OUT'		    		|| CHR(10) TRO_MAIN_INFO" ).append("\n"); 
		query.append("  FROM BKG_TRO" ).append("\n"); 
		query.append(" WHERE BKG_NO 				= @[bkg_no]" ).append("\n"); 
		query.append("   AND TRO_SEQ				= @[tro_seq]" ).append("\n"); 
		query.append("   AND IO_BND_CD      		= 'O'" ).append("\n"); 

	}
}