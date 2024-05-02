/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOBatchStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.08.12 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOBatchStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 배치 상태를 저장한다.
	  * </pre>
	  */
	public CommonDBDAOBatchStatusCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bat_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bat_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOBatchStatusCSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_BAT_MNTR A1 USING" ).append("\n"); 
		query.append("	  (" ).append("\n"); 
		query.append("        SELECT @[f_bat_id]     AS BAT_ID" ).append("\n"); 
		query.append("             , @[f_bse_tp_cd]  AS BSE_TP_CD" ).append("\n"); 
		query.append("             , @[f_bse_yr]     AS BSE_YR" ).append("\n"); 
		query.append("             , @[f_bse_qtr_cd] AS BSE_QTR_CD" ).append("\n"); 
		query.append("             , @[f_ofc_vw_cd]  AS OFC_VW_CD" ).append("\n"); 
		query.append("             , @[f_usr_id]     AS USR_ID" ).append("\n"); 
		query.append("             , @[f_bat_sts_cd] AS BAT_STS_CD" ).append("\n"); 
		query.append("          FROM DUAL " ).append("\n"); 
		query.append("	  ) A2" ).append("\n"); 
		query.append("ON (  A1.BAT_ID     = A2.BAT_ID" ).append("\n"); 
		query.append("  AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("  AND A1.BSE_YR     = A2.BSE_YR" ).append("\n"); 
		query.append("  AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("  AND A1.OFC_VW_CD  = A2.OFC_VW_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    WHEN MATCHED THEN" ).append("\n"); 
		query.append("	  	   UPDATE " ).append("\n"); 
		query.append("	  	      SET A1.BAT_STS_CD  = A2.BAT_STS_CD" ).append("\n"); 
		query.append("	  	        , A1.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("	  	        , A1.UPD_USR_ID  = A2.USR_ID" ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	       INSERT (" ).append("\n"); 
		query.append("	       		  A1.BAT_ID" ).append("\n"); 
		query.append("	       		, A1.BSE_TP_CD" ).append("\n"); 
		query.append("	       		, A1.BSE_YR" ).append("\n"); 
		query.append("	       		, A1.BSE_QTR_CD" ).append("\n"); 
		query.append("	       		, A1.OFC_VW_CD" ).append("\n"); 
		query.append("	       		, A1.BAT_STS_CD" ).append("\n"); 
		query.append("	       		, A1.CRE_USR_ID" ).append("\n"); 
		query.append("	       		, A1.CRE_DT" ).append("\n"); 
		query.append("	       		, A1.UPD_USR_ID" ).append("\n"); 
		query.append("	       		, A1.UPD_DT" ).append("\n"); 
		query.append("	       	 	       " ).append("\n"); 
		query.append("	       ) VALUES (	       " ).append("\n"); 
		query.append("	       		  A2.BAT_ID" ).append("\n"); 
		query.append("	       		, A2.BSE_TP_CD" ).append("\n"); 
		query.append("	       		, A2.BSE_YR" ).append("\n"); 
		query.append("	       		, A2.BSE_QTR_CD" ).append("\n"); 
		query.append("	       		, A2.OFC_VW_CD" ).append("\n"); 
		query.append("	       		, A2.BAT_STS_CD" ).append("\n"); 
		query.append("	       		, A2.USR_ID" ).append("\n"); 
		query.append("	       		, SYSDATE" ).append("\n"); 
		query.append("	       		, A2.USR_ID" ).append("\n"); 
		query.append("	       		, SYSDATE" ).append("\n"); 
		query.append("	       )" ).append("\n"); 

	}
}