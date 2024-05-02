/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOsearchFinancialVVDForOtherOffcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOsearchFinancialVVDForOtherOffcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PUSMOV를 제외한 Office를 위한 재무항차 및 ETD 조회
	  * </pre>
	  */
	public OwnersAccountDBDAOsearchFinancialVVDForOtherOffcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oa_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOsearchFinancialVVDForOtherOffcRSQL").append("\n"); 
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
		query.append("SELECT V.VSL_CD," ).append("\n"); 
		query.append("       V.SKD_VOY_NO," ).append("\n"); 
		query.append("       V.SKD_DIR_CD," ).append("\n"); 
		query.append("       L.RLANE_DIR_CD," ).append("\n"); 
		query.append("       TO_CHAR(V.VPS_ETD_DT,'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("    AR_MST_REV_VVD L" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND V.VSL_CD                 = L.VSL_CD" ).append("\n"); 
		query.append("  AND V.SKD_VOY_NO             = L.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND V.SKD_DIR_CD             = L.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND V.SLAN_CD                = L.SLAN_CD" ).append("\n"); 
		query.append("  AND V.VSL_CD                 = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("  AND V.SKD_VOY_NO             = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("  AND V.SKD_DIR_CD             = substr(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("  AND V.VPS_PORT_CD            = @[oa_loc_cd]" ).append("\n"); 
		query.append("  AND NVL(V.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("  AND NVL(L.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("              FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("              WHERE  1 = 1" ).append("\n"); 
		query.append("                AND  C.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                AND  C.FLET_CTRT_TP_CD = 'TI')" ).append("\n"); 

	}
}