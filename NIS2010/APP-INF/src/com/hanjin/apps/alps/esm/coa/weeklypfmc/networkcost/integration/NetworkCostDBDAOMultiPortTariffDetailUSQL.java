/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkCostDBDAOMultiPortTariffDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.04.24 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiPortTariffDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.07.06 이석준 CHM-201111498-01
	  *                  터미널별 PSO 및 COA Data 수정 
	  * </pre>
	  */
	public NetworkCostDBDAOMultiPortTariffDetailUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiPortTariffDetailUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PORT_TRF A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("	SELECT @[slan_cd] AS SLAN_CD " ).append("\n"); 
		query.append("		 , @[vsl_cd] AS VSL_CD" ).append("\n"); 
		query.append("		 , @[skd_voy_no] AS SKD_VOY_NO" ).append("\n"); 
		query.append("		 , @[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append("		 , @[port_cd]||@[cy_cd] AS TML_CD" ).append("\n"); 
		query.append("		 , @[port_usd_amt] AS PORT_USD_AMT" ).append("\n"); 
		query.append("		 , @[cnl_usd_amt] AS CNL_USD_AMT" ).append("\n"); 
		query.append("		 , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("		 , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("	  FROM DUAL" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("   ON ( A.VSL_CD   = B.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.TML_CD     = B.TML_CD" ).append("\n"); 
		query.append("  AND A.SLAN_CD    = B.SLAN_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("	  UPDATE SET " ).append("\n"); 
		query.append("      		 A.PORT_USD_AMT = B.PORT_USD_AMT" ).append("\n"); 
		query.append("    	   , A.CNL_USD_AMT  = B.CNL_USD_AMT" ).append("\n"); 
		query.append("    	   , A.UPD_USR_ID   = B.UPD_USR_ID" ).append("\n"); 
		query.append("    	   , A.UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" 	  INSERT (A.SLAN_CD" ).append("\n"); 
		query.append("			, A.VSL_CD" ).append("\n"); 
		query.append("			, A.SKD_VOY_NO" ).append("\n"); 
		query.append("			, A.SKD_DIR_CD" ).append("\n"); 
		query.append("			, A.TML_CD" ).append("\n"); 
		query.append("			, A.PORT_USD_AMT" ).append("\n"); 
		query.append("			, A.CNL_USD_AMT" ).append("\n"); 
		query.append("			, A.CRE_USR_ID" ).append("\n"); 
		query.append("			, A.CRE_DT" ).append("\n"); 
		query.append("			, A.UPD_USR_ID" ).append("\n"); 
		query.append("			, A.UPD_DT) " ).append("\n"); 
		query.append(" 	  VALUES (B.SLAN_CD" ).append("\n"); 
		query.append("			, B.VSL_CD" ).append("\n"); 
		query.append("			, B.SKD_VOY_NO" ).append("\n"); 
		query.append("			, B.SKD_DIR_CD" ).append("\n"); 
		query.append("			, B.TML_CD" ).append("\n"); 
		query.append("			, B.PORT_USD_AMT" ).append("\n"); 
		query.append("			, B.CNL_USD_AMT" ).append("\n"); 
		query.append("			, B.CRE_USR_ID" ).append("\n"); 
		query.append("			, SYSDATE" ).append("\n"); 
		query.append("			, B.UPD_USR_ID" ).append("\n"); 
		query.append("			, SYSDATE)                                             " ).append("\n"); 

	}
}