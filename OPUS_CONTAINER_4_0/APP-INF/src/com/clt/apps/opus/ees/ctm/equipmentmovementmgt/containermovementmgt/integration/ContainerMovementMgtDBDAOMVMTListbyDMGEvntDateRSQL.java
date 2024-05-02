/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOMVMTListbyDMGEvntDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOMVMTListbyDMGEvntDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMG Flagging/Unflagging Date 보다 같거나 나중인 MVMT List
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOMVMTListbyDMGEvntDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOMVMTListbyDMGEvntDateRSQL").append("\n"); 
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
		query.append("SELECT CNMV_YR," ).append("\n"); 
		query.append("	   CNMV_ID_NO, " ).append("\n"); 
		query.append("	   ORG_YD_CD," ).append("\n"); 
		query.append("	   CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       TO_CHAR (CNMV_EVNT_DT, 'YYYYMMDDHH24MI') AS CNTR_EVNT_DT," ).append("\n"); 
		query.append("	MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("	MVMT_STS_CD," ).append("\n"); 
		query.append("	#if (${last_flg} == 'N')" ).append("\n"); 
		query.append("	#if (${cntr_dmg_flg} == 'N')" ).append("\n"); 
		query.append("	CASE WHEN DMG_FLG_DT IS NOT NULL AND (SELECT CNMV_EVNT_DT" ).append("\n"); 
		query.append("                                        FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                                        WHERE 1=1" ).append("\n"); 
		query.append("                                        AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                        AND CNTR_DMG_FLG = 'Y'" ).append("\n"); 
		query.append("                                        AND CNMV_EVNT_DT > TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                        AND ROWNUM=1) > CNMV_EVNT_DT THEN ''" ).append("\n"); 
		query.append("         ELSE (SELECT TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("              FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("              AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              AND CNTR_DMG_FLG = 'Y'" ).append("\n"); 
		query.append("              AND CNMV_EVNT_DT > TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("              AND ROWNUM=1)" ).append("\n"); 
		query.append("       END AS NEXT_EVNT_DT," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	CASE WHEN DMG_FLG_DT IS NOT NULL " ).append("\n"); 
		query.append("              AND CNTR_DMG_FLG = 'Y' " ).append("\n"); 
		query.append("              AND DMG_FLG_DT > TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("             THEN TO_CHAR(DMG_FLG_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("             WHEN DMG_UNFLG_DT IS NOT NULL " ).append("\n"); 
		query.append("              AND CNTR_DMG_FLG = 'N' " ).append("\n"); 
		query.append("              AND DMG_UNFLG_DT > TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("             THEN TO_CHAR(DMG_UNFLG_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("         ELSE ''" ).append("\n"); 
		query.append("       END AS NEXT_EVNT_DT," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	CNTR_DMG_FLG," ).append("\n"); 
		query.append("	   TO_CHAR (DMG_FLG_DT, 'YYYYMMDDHH24MI') AS DMG_FLG_DT," ).append("\n"); 
		query.append("	   TO_CHAR (DMG_UNFLG_DT, 'YYYYMMDDHH24MI') AS DMG_UNFLG_DT," ).append("\n"); 
		query.append("	CASE WHEN CNTR_DMG_FLG = 'Y' AND DMG_FLG_DT < TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS') THEN 1" ).append("\n"); 
		query.append("        WHEN CNTR_DMG_FLG = 'Y' AND DMG_FLG_DT >= TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS') THEN 0" ).append("\n"); 
		query.append("        WHEN CNTR_DMG_FLG = 'N' THEN 2" ).append("\n"); 
		query.append("    END DMG" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CNMV_YR||TO_CHAR(CNMV_SEQ,'0000')||CNMV_SPLIT_NO >= (SELECT MAX(CNMV_YR||TO_CHAR(CNMV_SEQ,'0000')||CNMV_SPLIT_NO)" ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND ORG_YD_CD = @[evnt_yard]" ).append("\n"); 
		query.append("        AND CNMV_EVNT_DT <= TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        AND NVL(MVMT_CRE_TP_CD, 'Z') != 'C')" ).append("\n"); 
		query.append("#if (${last_flg} == 'N')" ).append("\n"); 
		query.append("AND CNMV_EVNT_DT <= (SELECT MAX(CNMV_EVNT_DT)" ).append("\n"); 
		query.append("                    FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                    AND CNMV_EVNT_DT > TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("					#if (${cntr_dmg_flg} == 'N')" ).append("\n"); 
		query.append("                    AND NVL(DMG_FLG_DT, CNMV_EVNT_DT) <= TO_DATE (@[evnt_dt], 'YYYYMMDDHH24MISS'))" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					AND CNTR_DMG_FLG = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM=1)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO" ).append("\n"); 

	}
}