/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
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

public class GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBkgCreTabByUserRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN USR.OFC_CD = 'PKGSA' THEN" ).append("\n"); 
		query.append("				CASE WHEN GRP.DPCS_WRK_PRT_CD IN ('NL', 'DE') THEN 'EUR'" ).append("\n"); 
		query.append("					 WHEN GRP.DPCS_WRK_PRT_CD = 'KR'		  THEN 'KOR'" ).append("\n"); 
		query.append("					 ELSE 'GEN' END" ).append("\n"); 
		query.append("			WHEN LOC_INFO.CNT_CD 	  = 'KR'    THEN 'KOR'" ).append("\n"); 
		query.append("           	WHEN LOC_INFO.CONTI_CD    = 'E'     THEN 'EUR'" ).append("\n"); 
		query.append("            WHEN OFC_INFO.PRNT_OFC_CD = 'HAMRU' THEN 'EUR'" ).append("\n"); 
		query.append("            ELSE 'GEN' END TROTAB" ).append("\n"); 
		query.append("            , OFC_INFO.OFC_CD" ).append("\n"); 
		query.append("            , OFC_INFO.PRNT_OFC_CD" ).append("\n"); 
		query.append("  FROM MDM_LOCATION LOC_INFO, BKG_DPCS_USR_GRP GRP, COM_USER USR" ).append("\n"); 
		query.append("        , (SELECT LOC_CD, PRNT_OFC_CD, OFC_CD" ).append("\n"); 
		query.append("             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("            WHERE OFC_CD = @[ofc_cd]) OFC_INFO" ).append("\n"); 
		query.append(" WHERE LOC_INFO.LOC_CD = OFC_INFO.LOC_CD" ).append("\n"); 
		query.append("   AND USR.USR_ID = GRP.USR_ID(+)" ).append("\n"); 
		query.append("   AND USR.USE_FLG = 'Y'" ).append("\n"); 
		query.append("   AND USR.USR_ID = @[usr_id]" ).append("\n"); 

	}
}