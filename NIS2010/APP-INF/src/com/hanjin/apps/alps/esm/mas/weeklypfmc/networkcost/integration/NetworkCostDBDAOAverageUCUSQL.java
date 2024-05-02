/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.10.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average U/C(OP fixed/variable cost, SPC CHT Rev/Charterage)  Update
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_09",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_10",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amt_08",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_07",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_06",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_05",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_04",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_03",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("amt_12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_02",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_01",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_14",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_OP_AVG_UT_COST A USING (" ).append("\n"); 
		query.append("	SELECT @[cost_yrmon] AS COST_YRMON" ).append("\n"); 
		query.append("	      , @[trd_cd]     AS TRD_CD" ).append("\n"); 
		query.append("	      , @[rlane_cd]   AS RLANE_CD" ).append("\n"); 
		query.append("	      , @[dir_cd]     AS DIR_CD" ).append("\n"); 
		query.append("	      , STND_COST_CD" ).append("\n"); 
		query.append("	      , 'A'           AS COST_USE_TP_CD" ).append("\n"); 
		query.append("	      , OP_UC_AMT" ).append("\n"); 
		query.append("	      , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("	      , SYSDATE       AS CRE_DT" ).append("\n"); 
		query.append("	      , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("	      , SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append("	   FROM (" ).append("\n"); 
		query.append("		SELECT '43102011' STND_COST_CD, @[amt_01] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '53101000' STND_COST_CD, @[amt_02] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '53102000' STND_COST_CD, @[amt_03] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '53200000' STND_COST_CD, @[amt_04] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54100000' STND_COST_CD, @[amt_05] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54250000' STND_COST_CD, @[amt_06] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54300000' STND_COST_CD, @[amt_07] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54200000' STND_COST_CD, @[amt_08] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54150000' STND_COST_CD, @[amt_09] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54450000' STND_COST_CD, @[amt_10] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54180000' STND_COST_CD, @[amt_11] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54550000' STND_COST_CD, @[amt_12] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54350000' STND_COST_CD, @[amt_13] OP_UC_AMT FROM DUAL UNION ALL" ).append("\n"); 
		query.append("		SELECT '54400000' STND_COST_CD, @[amt_14] OP_UC_AMT FROM DUAL " ).append("\n"); 
		query.append("	)     " ).append("\n"); 
		query.append(") B " ).append("\n"); 
		query.append("ON (	A.COST_YRMON = B.COST_YRMON " ).append("\n"); 
		query.append("  	AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("  	AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("    AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("    AND A.COST_USE_TP_CD = B.COST_USE_TP_CD" ).append("\n"); 
		query.append("    AND A.DIR_CD = B.DIR_CD )  " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("      SET A.OP_UC_AMT = B.OP_UC_AMT" ).append("\n"); 
		query.append("        , A.UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append("        , A.UPD_DT = B.UPD_DT" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}