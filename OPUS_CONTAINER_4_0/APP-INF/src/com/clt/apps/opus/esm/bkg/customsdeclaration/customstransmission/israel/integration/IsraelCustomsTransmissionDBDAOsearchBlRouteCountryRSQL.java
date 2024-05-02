/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchBlRouteCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOsearchBlRouteCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlRouteCountry
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchBlRouteCountryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchBlRouteCountryRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(VPS_PORT_CD,1,2)  AS ROUTE_CNT" ).append("\n"); 
		query.append("     , MIN(CLPT_SEQ)            AS CLPT_SEQ" ).append("\n"); 
		query.append("  FROM ( SELECT MIN(DECODE(A.POL_CD, B.VPS_PORT_CD, CLPT_SEQ)) POL_SEQ" ).append("\n"); 
		query.append("              , MAX(DECODE(A.POD_CD, B.VPS_PORT_CD, CLPT_SEQ)) POD_SEQ" ).append("\n"); 
		query.append("           FROM BKG_VVD A" ).append("\n"); 
		query.append("              , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("              , BKG_BOOKING BKG" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND A.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            AND A.VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("            AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND A.SKD_DIR_cD = B.SKD_dIR_CD " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append(" WHERE B.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND B.CLPT_SEQ BETWEEN A. POL_SEQ AND A.POD_SEQ" ).append("\n"); 
		query.append(" GROUP BY SUBSTR(VPS_PORT_CD,1,2) " ).append("\n"); 
		query.append(" ORDER BY 2" ).append("\n"); 

	}
}