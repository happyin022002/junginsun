/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOCreatePortTariffFromPSOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreatePortTariffFromPSOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreatePortTariffFromPSO
	  * </pre>
	  */
	public NetworkCostDBDAOCreatePortTariffFromPSOCSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration ").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreatePortTariffFromPSOCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PORT_TRF A1 " ).append("\n"); 
		query.append("USING (SELECT 'PSO' SLAN_CD" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , TML_CD" ).append("\n"); 
		query.append("             , PORT_USD_AMT" ).append("\n"); 
		query.append("             , CRE_USR_ID" ).append("\n"); 
		query.append("             , CRE_DT" ).append("\n"); 
		query.append("             , UPD_USR_ID" ).append("\n"); 
		query.append("             , UPD_DT" ).append("\n"); 
		query.append("          FROM (SELECT --PSO_BZTP_CD" ).append("\n"); 
		query.append("                       VSL_CD" ).append("\n"); 
		query.append("                     , SKD_VOY_NO" ).append("\n"); 
		query.append("                     , SKD_DIR_CD" ).append("\n"); 
		query.append("                     , YD_CD TML_CD" ).append("\n"); 
		query.append("                     , WRK_DT" ).append("\n"); 
		query.append("                     , WRK_SEQ" ).append("\n"); 
		query.append("                     , LAST_VALUE (WRK_DT IGNORE NULLS) OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                         ORDER BY WRK_DT, WRK_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) LST_WRK_DT" ).append("\n"); 
		query.append("                     , LAST_VALUE (WRK_SEQ IGNORE NULLS) OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                         ORDER BY WRK_DT, WRK_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) LST_WRK_SEQ" ).append("\n"); 
		query.append("                     --, SRC_PSO_BZTP_CD" ).append("\n"); 
		query.append("                     , INV_USD_AMT PORT_USD_AMT" ).append("\n"); 
		query.append("                     , CRE_USR_ID" ).append("\n"); 
		query.append("                     , CRE_DT" ).append("\n"); 
		query.append("                     , UPD_USR_ID" ).append("\n"); 
		query.append("                     , UPD_DT" ).append("\n"); 
		query.append("                  FROM PSO_TGT_VVD_EXPN" ).append("\n"); 
		query.append("                 WHERE PSO_BZTP_CD = '7'" ).append("\n"); 
		query.append("                   AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = @[skd_dir_cd])" ).append("\n"); 
		query.append("         WHERE WRK_DT=LST_WRK_DT" ).append("\n"); 
		query.append("           AND WRK_SEQ=LST_WRK_SEQ) A2 " ).append("\n"); 
		query.append("ON (A1.SLAN_CD = A2.SLAN_CD" ).append("\n"); 
		query.append("       AND A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("       AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A1.SKD_DIR_CD = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A1.TML_CD = A2.TML_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("       SET A1.PORT_USD_AMT = A2.PORT_USD_AMT" ).append("\n"); 
		query.append("         , A1.UPD_USR_ID = A2.UPD_USR_ID" ).append("\n"); 
		query.append("         , A1.UPD_DT = A2.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (A1.SLAN_CD" ).append("\n"); 
		query.append("             , A1.VSL_CD" ).append("\n"); 
		query.append("             , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A1.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A1.TML_CD" ).append("\n"); 
		query.append("             , A1.PORT_USD_AMT" ).append("\n"); 
		query.append("             , A1.CRE_USR_ID" ).append("\n"); 
		query.append("             , A1.CRE_DT" ).append("\n"); 
		query.append("             , A1.UPD_USR_ID" ).append("\n"); 
		query.append("             , A1.UPD_DT)" ).append("\n"); 
		query.append("    VALUES (A2.SLAN_CD" ).append("\n"); 
		query.append("             , A2.VSL_CD" ).append("\n"); 
		query.append("             , A2.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A2.SKD_DIR_CD" ).append("\n"); 
		query.append("             , A2.TML_CD" ).append("\n"); 
		query.append("             , A2.PORT_USD_AMT" ).append("\n"); 
		query.append("             , A2.CRE_USR_ID" ).append("\n"); 
		query.append("             , A2.CRE_DT" ).append("\n"); 
		query.append("             , A2.UPD_USR_ID" ).append("\n"); 
		query.append("             , A2.UPD_DT)" ).append("\n"); 

	}
}