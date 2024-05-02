/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOMultiPortTrfByPortUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiPortTrfByPortUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추가된 비용을 Port 별로 배부
	  * </pre>
	  */
	public NetworkCostDBDAOMultiPortTrfByPortUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiPortTrfByPortUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_PORT_TRF A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT SLAN_CD," ).append("\n"); 
		query.append("               VSL_CD," ).append("\n"); 
		query.append("               SKD_VOY_NO," ).append("\n"); 
		query.append("               SKD_DIR_CD," ).append("\n"); 
		query.append("               TML_CD," ).append("\n"); 
		query.append("               PORT_ORG_AMT," ).append("\n"); 
		query.append("               CHN_PORT_ADD_AMT," ).append("\n"); 
		query.append("               ITA_PORT_ADD_AMT," ).append("\n"); 
		query.append("               CASE WHEN SUBSTR(TML_CD, 1, 5) NOT IN ('EGSUZ', 'PAPAC') THEN" ).append("\n"); 
		query.append("                         PORT_USD_AMT + CHN_PORT_ADD_AMT + ITA_PORT_ADD_AMT" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                         0" ).append("\n"); 
		query.append("               END PORT_USD_AMT," ).append("\n"); 
		query.append("               CASE WHEN SUBSTR(TML_CD, 1, 5) IN ('EGSUZ', 'PAPAC') THEN" ).append("\n"); 
		query.append("                         CNL_USD_AMT + CHN_PORT_ADD_AMT + ITA_PORT_ADD_AMT" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                         0" ).append("\n"); 
		query.append("               END CNL_USD_AMT," ).append("\n"); 
		query.append("               USR_ID" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT SLAN_CD," ).append("\n"); 
		query.append("                       VSL_CD," ).append("\n"); 
		query.append("                       SKD_VOY_NO," ).append("\n"); 
		query.append("                       SKD_DIR_CD," ).append("\n"); 
		query.append("                       TML_CD," ).append("\n"); 
		query.append("                       PORT_USD_AMT," ).append("\n"); 
		query.append("                       CNL_USD_AMT," ).append("\n"); 
		query.append("                       PORT_ORG_AMT," ).append("\n"); 
		query.append("                       CHN_ADD_AMT," ).append("\n"); 
		query.append("                       ITA_ADD_AMT," ).append("\n"); 
		query.append("                       CHN_ADD_AMT * (PORT_ORG_AMT / TTL_AMT) CHN_PORT_ADD_AMT," ).append("\n"); 
		query.append("                       ITA_ADD_AMT * (PORT_ORG_AMT / TTL_AMT) ITA_PORT_ADD_AMT," ).append("\n"); 
		query.append("                       USR_ID" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.SLAN_CD," ).append("\n"); 
		query.append("                               A.VSL_CD," ).append("\n"); 
		query.append("                               A.SKD_VOY_NO," ).append("\n"); 
		query.append("                               A.SKD_DIR_CD," ).append("\n"); 
		query.append("                               A.TML_CD," ).append("\n"); 
		query.append("                               A.PORT_USD_AMT," ).append("\n"); 
		query.append("                               A.CNL_USD_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(B.CNT_CD, 'CN', B.WK_VSL_DTRB_AMT, 0)) CHN_ADD_AMT," ).append("\n"); 
		query.append("                               SUM(DECODE(B.CNT_CD, 'IT', B.WK_VSL_DTRB_AMT, 0)) ITA_ADD_AMT," ).append("\n"); 
		query.append("                               A.PORT_ORG_AMT," ).append("\n"); 
		query.append("                               SUM(A.PORT_ORG_AMT) OVER (PARTITION BY A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) TTL_AMT," ).append("\n"); 
		query.append("                               @[user_id] USR_ID       " ).append("\n"); 
		query.append("                          FROM MAS_PORT_TRF     A," ).append("\n"); 
		query.append("                               MAS_PORT_ADD_TRF B" ).append("\n"); 
		query.append("                         WHERE A.SLAN_CD    = B.SLAN_CD" ).append("\n"); 
		query.append("                           AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND A.SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append("                           AND A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                         GROUP BY A.SLAN_CD," ).append("\n"); 
		query.append("                               A.VSL_CD," ).append("\n"); 
		query.append("                               A.SKD_VOY_NO," ).append("\n"); 
		query.append("                               A.SKD_DIR_CD," ).append("\n"); 
		query.append("                               A.TML_CD," ).append("\n"); 
		query.append("                               A.PORT_USD_AMT," ).append("\n"); 
		query.append("                               A.CNL_USD_AMT," ).append("\n"); 
		query.append("                               A.PORT_ORG_AMT" ).append("\n"); 
		query.append("                   )       " ).append("\n"); 
		query.append("            )       " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("  ON (    A.SLAN_CD = B.SLAN_CD   " ).append("\n"); 
		query.append("      AND A.VSL_CD  = B.VSL_CD" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND A.TML_CD     = B.TML_CD)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET A.CHN_PORT_ADD_AMT = B.CHN_PORT_ADD_AMT," ).append("\n"); 
		query.append("             A.ITA_PORT_ADD_AMT = B.ITA_PORT_ADD_AMT," ).append("\n"); 
		query.append("             A.PORT_USD_AMT     = B.PORT_USD_AMT," ).append("\n"); 
		query.append("             A.CNL_USD_AMT      = B.CNL_USD_AMT," ).append("\n"); 
		query.append("             A.UPD_USR_ID       = B.USR_ID," ).append("\n"); 
		query.append("             A.UPD_DT           = SYSDATE" ).append("\n"); 

	}
}