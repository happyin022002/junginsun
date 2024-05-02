/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesMvmtAudDBDAOSearchMvmtLegListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.25
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2015.08.25 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesMvmtAudDBDAOSearchMvmtLegListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesMvmtAudDBDAOSearchMvmtLegListRSQL DESC 
	  * </pre>
	  */
	public TesMvmtAudDBDAOSearchMvmtLegListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.integration").append("\n"); 
		query.append("FileName : TesMvmtAudDBDAOSearchMvmtLegListRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,ORG_YD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(FM_MVMT_STS_CD,1,1) BND_CD" ).append("\n"); 
		query.append("      ,FM_MVMT_STS_CD||'-'||BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^') AS MVMT_STS_CD " ).append("\n"); 
		query.append("      ,TO_CHAR(FM_CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI:SS') AS FM_CNMV_EVNT_DT" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,2,'^') AS TO_CNMV_EVNT_DT" ).append("\n"); 
		query.append("      ,CASE WHEN @[days] = 'D' THEN TO_DATE(TO_CHAR(TO_DATE(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,2,'^'), 'YYYY-MM-DD HH24:MI:SS'),'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(FM_CNMV_EVNT_DT, 'YYYYMMDD'), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("            WHEN @[days] = 'H' THEN ROUND(TO_DATE(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,2,'^'), 'YYYY-MM-DD HH24:MI:SS') - FM_CNMV_EVNT_DT,1)" ).append("\n"); 
		query.append("       END DAYS" ).append("\n"); 
		query.append("      ,CASE WHEN FM_MVMT_STS_CD IN ('IC', 'TS') THEN PRE_VVD" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END IN_VVD" ).append("\n"); 
		query.append("      ,CASE WHEN FM_MVMT_STS_CD IN ('OC', 'TS') THEN BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,3,'^')" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END OUT_VVD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,RD_CGO_FLG" ).append("\n"); 
		query.append("		, (SELECT TO_CHAR(MFT_DT, 'YYYYMMDD') FROM MST_CONTAINER WHERE CNTR_NO = AA.CNTR_NO) AS MFT_DT" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("        SELECT #if ( ${bkg_no} != '' )" ).append("\n"); 
		query.append("                 /*+ INDEX (M XAK13CTM_MOVEMENT) */" ).append("\n"); 
		query.append("               #elseif ( ${cntr_no} != '' )" ).append("\n"); 
		query.append("                 /*+ INDEX (M XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("               #elseif ( ${fm_dt} != '' || ${to_dt} != '')" ).append("\n"); 
		query.append("                 /*+ INDEX (M XAK6CTM_MOVEMENT) */" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               M.CNTR_NO" ).append("\n"); 
		query.append("              ,M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,M.ORG_YD_CD        " ).append("\n"); 
		query.append("              ,M.MVMT_STS_CD  AS FM_MVMT_STS_CD" ).append("\n"); 
		query.append("              ,M.CNMV_EVNT_DT AS FM_CNMV_EVNT_DT" ).append("\n"); 
		query.append("              ,M.CRNT_VSL_CD||M.CRNT_SKD_VOY_NO||M.CRNT_SKD_DIR_CD AS CRNT_VVD" ).append("\n"); 
		query.append("              ,M.BKG_NO" ).append("\n"); 
		query.append("              ,M.BL_NO" ).append("\n"); 
		query.append("              ,M.CNMV_YR" ).append("\n"); 
		query.append("              ,M.CNMV_CYC_NO" ).append("\n"); 
		query.append("              ,M.CNMV_ID_NO" ).append("\n"); 
		query.append("              ,M.BKG_CGO_TP_CD             " ).append("\n"); 
		query.append("              ,N.RD_CGO_FLG" ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC (X XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       X.CRNT_VSL_CD||X.CRNT_SKD_VOY_NO||X.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("                 WHERE X.CNTR_NO  = M.CNTR_NO" ).append("\n"); 
		query.append("                   AND X.CNMV_YR  <= M.CNMV_YR" ).append("\n"); 
		query.append("                   AND X.CNMV_YR||LPAD(X.CNMV_ID_NO, 3, '0') < M.CNMV_YR||LPAD(M.CNMV_ID_NO, 3, '0')" ).append("\n"); 
		query.append("                   AND X.MVMT_STS_CD IN ('EN', 'TN', 'VD')" ).append("\n"); 
		query.append("--                   AND X.CNMV_CYC_NO = M.CNMV_CYC_NO" ).append("\n"); 
		query.append("                   AND X.CRNT_VSL_CD IS NOT NULL" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) PRE_VVD" ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX (X XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       X.MVMT_STS_CD||'^'||TO_CHAR(X.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI:SS')||'^'||X.CRNT_VSL_CD||X.CRNT_SKD_VOY_NO||X.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("                 WHERE X.CNTR_NO  = M.CNTR_NO" ).append("\n"); 
		query.append("                   AND X.CNMV_YR  >= M.CNMV_YR" ).append("\n"); 
		query.append("                   AND X.CNMV_YR||LPAD(X.CNMV_ID_NO, 3, '0') > M.CNMV_YR||LPAD(M.CNMV_ID_NO, 3, '0')" ).append("\n"); 
		query.append("--                   AND X.CNMV_CYC_NO = M.CNMV_CYC_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) TO_MVMT_STS_INFO" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("              ,BKG_CONTAINER N" ).append("\n"); 
		query.append("         WHERE 1=1 " ).append("\n"); 
		query.append("           AND M.BKG_NO  = N.BKG_NO(+)" ).append("\n"); 
		query.append("           AND M.CNTR_NO = N.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND M.CNTR_TPSZ_CD IN ('R2', 'R4', 'R5', 'R7', 'R8', 'R9')" ).append("\n"); 
		query.append("           AND M.ORG_YD_CD = @[org_yd_cd]" ).append("\n"); 
		query.append("           #if ( ${fm_dt} != '' || ${to_dt} != '')" ).append("\n"); 
		query.append("             AND M.CNMV_EVNT_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') - 30 AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${mvmt_leg} == 'ICID' || ${mvmt_leg} == 'ICTN' || ${mvmt_leg} == 'ICEN')" ).append("\n"); 
		query.append("             AND M.MVMT_STS_CD IN ('IC')" ).append("\n"); 
		query.append("           #elseif ( ${mvmt_leg} == 'OCVL' || ${mvmt_leg} == 'OCTN' || ${mvmt_leg} == 'OCEN')" ).append("\n"); 
		query.append("             AND M.MVMT_STS_CD IN ('OC')" ).append("\n"); 
		query.append("           #elseif ( ${mvmt_leg} == 'TSVL' || ${mvmt_leg} == 'TSTN' || ${mvmt_leg} == 'TSEN')" ).append("\n"); 
		query.append("             AND M.MVMT_STS_CD IN ('TS')" ).append("\n"); 
		query.append("           #elseif ( ${mvmt_leg} == 'MTOP')" ).append("\n"); 
		query.append("             AND M.MVMT_STS_CD IN ('MT')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if($bkg_no.size() > 0) " ).append("\n"); 
		query.append("            AND M.BKG_NO IN (" ).append("\n"); 
		query.append("                #foreach( ${key} in ${bkg_no})" ).append("\n"); 
		query.append("                    #if($velocityCount == 1)" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        ,'$key'" ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if($cntr_no.size() > 0) " ).append("\n"); 
		query.append("            AND M.CNTR_NO IN (" ).append("\n"); 
		query.append("                #foreach( ${key} in ${cntr_no}) " ).append("\n"); 
		query.append("                    #if($velocityCount == 1)" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        ,'$key'" ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${eq_tp_sz_cd} != '' ) " ).append("\n"); 
		query.append("             AND M.CNTR_TPSZ_CD = @[eq_tp_sz_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ( ${bnd_cd} != '' ) " ).append("\n"); 
		query.append("             AND CASE WHEN M.OB_CNTR_FLG = 'Y' THEN 'O'" ).append("\n"); 
		query.append("                 ELSE 'I'" ).append("\n"); 
		query.append("                 END = @[bnd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           ) AA" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      #if ( ${fm_dt} != '' || ${to_dt} != '')" ).append("\n"); 
		query.append("        AND (  (TO_DATE(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,2,'^'), 'YYYY-MM-DD HH24:MI:SS')  BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999) OR TO_MVMT_STS_INFO IS NULL) " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if ( ${mvmt_leg} == 'ICID' ) " ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('IC', 'ID'), ('IC', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'ICTN' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('IC', 'TN'), ('IC', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'ICEN' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('IC', 'EN'), ('IC', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'OCVL' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('OC', 'VL'), ('OC', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'OCTN' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('OC', 'TN'), ('OC', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'OCEN' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('OC', 'EN'), ('OC', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'TSVL' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('TS', 'VL'), ('TS', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'TSTN' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('TS', 'TN'), ('TS', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'TSEN' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('TS', 'EN'), ('TS', ' '))" ).append("\n"); 
		query.append("      #elseif ( ${mvmt_leg} == 'MTOP' )" ).append("\n"); 
		query.append("        AND (AA.FM_MVMT_STS_CD, NVL(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,1,'^'), ' ')) IN (('MT', 'OP'), ('MT', ' '))" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if ( ${vvd_cd} != '' )" ).append("\n"); 
		query.append("        AND (CASE WHEN FM_MVMT_STS_CD IN ('IC', 'TS') THEN PRE_VVD" ).append("\n"); 
		query.append("                  ELSE ''" ).append("\n"); 
		query.append("             END = @[vvd_cd] " ).append("\n"); 
		query.append("          OR CASE WHEN FM_MVMT_STS_CD IN ('OC', 'TS') THEN BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,3,'^')" ).append("\n"); 
		query.append("                  ELSE ''" ).append("\n"); 
		query.append("             END = @[vvd_cd])" ).append("\n"); 
		query.append("      #end" ).append("\n"); 

	}
}