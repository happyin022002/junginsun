/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OfficeMappingDBDAOAddNewLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOAddNewLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * "NEW Lane & Office CMCB"의 마스터 테이블에 정보 입력
	  * 
	  * 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public OfficeMappingDBDAOAddNewLaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOAddNewLaneCSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_QTA_NEW_LANE T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         SELECT @[bse_tp_cd]  AS BSE_TP_CD" ).append("\n"); 
		query.append("               ,@[bse_yr]     AS BSE_YR" ).append("\n"); 
		query.append("               ,DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd]) AS BSE_QTR_CD" ).append("\n"); 
		query.append("               ,@[trd_cd]     AS TRD_CD" ).append("\n"); 
		query.append("               ,@[rlane_cd]   AS RLANE_CD" ).append("\n"); 
		query.append("               ,@[dir_cd]     AS DIR_CD" ).append("\n"); 
		query.append("               ,@[cre_usr_id] AS USR_ID" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                          FROM SQM_QTA_LANE_MGMT" ).append("\n"); 
		query.append("                         WHERE SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("                           --AND IAS_SCTR_FLG IS NULL" ).append("\n"); 
		query.append("                           AND TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("                           AND RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("      ) I" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("                T.BSE_TP_CD  = I.BSE_TP_CD" ).append("\n"); 
		query.append("            AND T.BSE_YR     = I.BSE_YR" ).append("\n"); 
		query.append("            AND T.BSE_QTR_CD = I.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND T.TRD_CD     = I.TRD_CD" ).append("\n"); 
		query.append("            AND T.RLANE_CD   = I.RLANE_CD" ).append("\n"); 
		query.append("            AND T.DIR_CD     = I.DIR_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("                BSE_TP_CD" ).append("\n"); 
		query.append("               ,BSE_YR" ).append("\n"); 
		query.append("               ,BSE_QTR_CD" ).append("\n"); 
		query.append("               ,TRD_CD" ).append("\n"); 
		query.append("               ,RLANE_CD" ).append("\n"); 
		query.append("               ,DIR_CD" ).append("\n"); 
		query.append("               ,CRE_USR_ID" ).append("\n"); 
		query.append("               ,CRE_DT" ).append("\n"); 
		query.append("               ,UPD_USR_ID" ).append("\n"); 
		query.append("               ,UPD_DT" ).append("\n"); 
		query.append("    ) VALUES (" ).append("\n"); 
		query.append("                I.BSE_TP_CD" ).append("\n"); 
		query.append("               ,I.BSE_YR" ).append("\n"); 
		query.append("               ,I.BSE_QTR_CD" ).append("\n"); 
		query.append("               ,I.TRD_CD" ).append("\n"); 
		query.append("               ,I.RLANE_CD" ).append("\n"); 
		query.append("               ,I.DIR_CD" ).append("\n"); 
		query.append("               ,I.USR_ID" ).append("\n"); 
		query.append("               ,SYSDATE" ).append("\n"); 
		query.append("               ,I.USR_ID" ).append("\n"); 
		query.append("               ,SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}