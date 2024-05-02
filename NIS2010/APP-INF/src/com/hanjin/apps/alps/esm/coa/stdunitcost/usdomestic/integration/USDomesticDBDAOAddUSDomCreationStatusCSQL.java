/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOAddUSDomCreationStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.30
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.10.30 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOAddUSDomCreationStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddUSDomCreationStatus
	  * </pre>
	  */
	public USDomesticDBDAOAddUSDomCreationStatusCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cre_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cre_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOAddUSDomCreationStatusCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_UT_COST_CRE_STS A1" ).append("\n"); 
		query.append("USING ( SELECT REPLACE(@[f_cost_yrmon], '-', '') COST_YRMON" ).append("\n"); 
		query.append("             , (SELECT MIN(COST_WK) FROM COA_WK_PRD WHERE SLS_FM_DT LIKE REPLACE(@[f_cost_yrmon], '-', '')||'%' ) COST_WK" ).append("\n"); 
		query.append("             , 'USDM' CM_UC_CD" ).append("\n"); 
		query.append("             , 'C' COST_CRE_STS_CD " ).append("\n"); 
		query.append("          FROM DUAL " ).append("\n"); 
		query.append("      ) A2" ).append("\n"); 
		query.append("ON ( A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append(" AND A1.COST_WK = A2.COST_WK" ).append("\n"); 
		query.append(" AND A1.CM_UC_CD = A2.CM_UC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( A1.COST_YRMON, A1.COST_WK, A1.CM_UC_CD, A1.COST_CRE_STS_CD, A1.COST_IF_STS_CD" ).append("\n"); 
		query.append("        ,A1.COST_SRC_FM_YRMON, A1.COST_SRC_TO_YRMON, A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID, A1.UPD_DT)" ).append("\n"); 
		query.append("VALUES ( A2.COST_YRMON, A2.COST_WK, A2.CM_UC_CD, A2.COST_CRE_STS_CD, ''" ).append("\n"); 
		query.append("        ,REPLACE(@[f_cre_start_dt],'-', '') , REPLACE(@[f_cre_end_dt], '-', '') ,@[upd_usr_id] , SYSDATE,@[cre_usr_id] , SYSDATE ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A1.COST_CRE_STS_CD = A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("		  ,A1.COST_SRC_FM_YRMON = REPLACE(@[f_cre_start_dt],'-', '')" ).append("\n"); 
		query.append("		  ,A1.COST_SRC_TO_YRMON = REPLACE(@[f_cre_end_dt], '-', '')" ).append("\n"); 
		query.append("          ,A1.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("          ,A1.UPD_DT = SYSDATE" ).append("\n"); 

	}
}