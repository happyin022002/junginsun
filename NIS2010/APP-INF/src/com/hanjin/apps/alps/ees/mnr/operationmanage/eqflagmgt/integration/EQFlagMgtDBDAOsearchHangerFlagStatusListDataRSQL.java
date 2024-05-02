/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchHangerFlagStatusListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchHangerFlagStatusListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FlagUnflagMgtDBDAOsearchHangerFlagStatusListDataRSQL
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchHangerFlagStatusListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_dmg_flg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchHangerFlagStatusListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" B.EQ_NO" ).append("\n"); 
		query.append(",B.EQ_TYPE EQ_KND_CD" ).append("\n"); 
		query.append(",B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",NVL(A.MNR_HNGR_FLG,'N') MNR_HNGR_FLG" ).append("\n"); 
		query.append(",B.MVMT_CD" ).append("\n"); 
		query.append(",B.CRNT_YD_CD MNR_HNGR_FLG_YD_CD" ).append("\n"); 
		query.append(",NVL(B.HNGR_RCK_CD,'R') AS MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",DECODE(NVL(B.HNGR_RCK_CD,'R'),'O','S', NVL(B.BAR_TP_CD,'S')) AS MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",NVL(A.MNR_HNGR_TRF_CD,'CB') AS MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append(",DECODE(A.MNR_HNGR_TRF_CD, 'OT', A.MNR_HNGR_TRF_OTR_DESC, '') AS MNR_HNGR_TRF_OTR_DESC" ).append("\n"); 
		query.append(",DECODE(NVL(A.MNR_HNGR_FLG, 'N')" ).append("\n"); 
		query.append("	,'Y'" ).append("\n"); 
		query.append("	,NVL(A.HNGR_BAR_ATCH_KNT,0)" ).append("\n"); 
		query.append("	,NVL(A.ACT_INVT_QTY,0) + NVL(A.MNR_HNGR_DMG_QTY,0) + NVL(A.MNR_LOST_HNGR_QTY,0) + NVL(A.MNR_DISP_HNGR_QTY,0)" ).append("\n"); 
		query.append(")   AS HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append(",NVL(A.ACT_INVT_QTY,0)  	AS ACT_INVT_QTY" ).append("\n"); 
		query.append(",NVL(A.MNR_HNGR_DMG_QTY,0)	AS MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append(",NVL(A.MNR_LOST_HNGR_QTY,0) AS MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append(",NVL(A.MNR_DISP_HNGR_QTY,0) AS MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append(",A.MNR_STS_RMK" ).append("\n"); 
		query.append("-- CHM-201536839, Auto Removal 추가, 신용찬, 2015-07-13" ).append("\n"); 
		query.append("--,DECODE(FH.MNR_FLG_INP_TP_CD,'W',MOT.WO,'M','Manual','') 					AS WO_NO" ).append("\n"); 
		query.append("--,DECODE(FH.MNR_FLG_INP_TP_CD,'W',MOT.OFC_CD,'M',FH.CRE_OFC_CD,[ofc_cd]) 	AS OFC_CD" ).append("\n"); 
		query.append(",DECODE(FH.MNR_FLG_INP_TP_CD,'W',MOT.WO, 'M','Manual', 'A', 'Auto Removal', '') AS WO_NO" ).append("\n"); 
		query.append(",DECODE(FH.MNR_FLG_INP_TP_CD,'W',MOT.OFC_CD,'M',FH.CRE_OFC_CD, 'A',FH.CRE_OFC_CD,@[ofc_cd]) 	AS OFC_CD" ).append("\n"); 
		query.append(",@[ofc_cd]                 													AS CRE_OFC_CD" ).append("\n"); 
		query.append("-- 2015.06.18 CHM-201536279 MANUAL INSTALL/REMOVAL은 입력될  W/O 정보가 필요없음" ).append("\n"); 
		query.append("--,DECODE(FH.MNR_FLG_INP_TP_CD,'W',MOT.MNR_ORD_OFC_CTY_CD,'') 				AS MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("--,DECODE(FH.MNR_FLG_INP_TP_CD,'W',MOT.MNR_ORD_SEQ,'') 						AS MNR_ORD_SEQ" ).append("\n"); 
		query.append(",'' 				AS MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",''					AS MNR_ORD_SEQ" ).append("\n"); 
		query.append(",NVL(A.MNR_HNGR_FLG,'N') MNR_STS_FLG" ).append("\n"); 
		query.append("#if (${bound_tp_cd} != '' && ${bound_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   ,CM.OB_CNTR_FLG	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",A.MNR_STS_RMK AS TMP_MNR_STS_RMK " ).append("\n"); 
		query.append("FROM MNR_EQ_STS A, MNR_EQ_STS_V B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	EQ_NO," ).append("\n"); 
		query.append("	WO," ).append("\n"); 
		query.append("	OFC_CD," ).append("\n"); 
		query.append("	MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("	MNR_ORD_SEQ" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			 MRD.EQ_NO" ).append("\n"); 
		query.append("			,MOH.MNR_ORD_OFC_CTY_CD || MOH.MNR_ORD_SEQ AS WO" ).append("\n"); 
		query.append("			,MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("			,MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("			,MOH.COST_OFC_CD OFC_CD" ).append("\n"); 
		query.append("			,ROW_NUMBER() OVER (PARTITION BY MRD.EQ_NO ORDER BY MRD.MNR_ORD_SEQ DESC) RANK" ).append("\n"); 
		query.append("			,MRD.COST_CD" ).append("\n"); 
		query.append("		FROM MNR_ORD_HDR MOH,MNR_ORD_DTL MRD,MNR_EQ_STS MXX" ).append("\n"); 
		query.append("		WHERE MOH.MNR_ORD_OFC_CTY_CD = MRD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND MOH.MNR_ORD_SEQ = MRD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("		AND MRD.EQ_NO = MXX.EQ_NO" ).append("\n"); 
		query.append("		AND MOH.MNR_WO_TP_CD = 'EXT'" ).append("\n"); 
		query.append("		AND MRD.COST_CD IN ('MRDRHA','MRDRHD')" ).append("\n"); 
		query.append("		AND MRD.COST_CD = DECODE(MXX.MNR_HNGR_FLG,'Y','MRDRHA','MRDRHD')" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHERE RANK = 1" ).append("\n"); 
		query.append(") MOT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	EQ_NO," ).append("\n"); 
		query.append("	MNR_STS_FLG," ).append("\n"); 
		query.append("	MNR_FLG_INP_TP_CD," ).append("\n"); 
		query.append("    CRE_OFC_CD" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("		MLH.EQ_NO," ).append("\n"); 
		query.append("		MLH.MNR_STS_FLG," ).append("\n"); 
		query.append("		MLH.MNR_FLG_INP_TP_CD," ).append("\n"); 
		query.append("		CRE_OFC_CD," ).append("\n"); 
		query.append("		ROW_NUMBER() OVER (PARTITION BY MLH.EQ_NO ORDER BY MLH.MNR_FLG_SEQ DESC) RANK" ).append("\n"); 
		query.append("		FROM MNR_FLG_HIS MLH" ).append("\n"); 
		query.append("		WHERE MLH.MNR_FLG_TP_CD = 'HGR'" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("	WHERE RANK = 1" ).append("\n"); 
		query.append(") FH" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '' && ${p_loc_tp} != 'YARD')" ).append("\n"); 
		query.append("	,(SELECT  A.LOC_CD, A.RGN_CD, A.SCC_CD, A.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("                    C.LCC_CD, C.ECC_CD, C.RCC_CD" ).append("\n"); 
		query.append("            FROM    MDM_LOCATION A," ).append("\n"); 
		query.append("                    MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("            WHERE   A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append(" 	 ) C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_tp_cd} != '' && ${bound_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("	,CTM_MOVEMENT CM,MST_CONTAINER MST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.EQ_NO = A.EQ_NO(+)" ).append("\n"); 
		query.append("AND B.EQ_NO = MOT.EQ_NO(+)" ).append("\n"); 
		query.append("AND B.EQ_NO = FH.EQ_NO(+)" ).append("\n"); 
		query.append("AND B.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '')" ).append("\n"); 
		query.append("	#if (${p_loc_tp} == 'RCC')" ).append("\n"); 
		query.append("	AND SUBSTR(B.CRNT_YD_CD,1,5) = C.LOC_CD" ).append("\n"); 
		query.append("    AND    	C.RCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("	#elseif (${p_loc_tp} == 'LCC')" ).append("\n"); 
		query.append("	AND SUBSTR(B.CRNT_YD_CD,1,5) = C.LOC_CD" ).append("\n"); 
		query.append("    AND    	C.LCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("	#elseif (${p_loc_tp} == 'SCC')" ).append("\n"); 
		query.append("	AND SUBSTR(B.CRNT_YD_CD,1,5) = C.LOC_CD" ).append("\n"); 
		query.append("    AND    	C.SCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND SUBSTR(B.CRNT_YD_CD,1,5) = @[p_loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != '')" ).append("\n"); 
		query.append("AND A.EQ_KND_CD(+) = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_dmg_flg_yd_cd} != '')" ).append("\n"); 
		query.append("AND B.CRNT_YD_CD = @[mnr_dmg_flg_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_list} != '')" ).append("\n"); 
		query.append("	AND B.EQ_NO IN (" ).append("\n"); 
		query.append("        #foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("				'$user_eq_no'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eq_no'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND A.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("        #foreach ($user_tp_sz IN ${tpszNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszNos.size())" ).append("\n"); 
		query.append("				'$user_tp_sz'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tp_sz'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_hngr_rck_cd} != '' && ${mnr_hngr_rck_cd} != 'ALL')" ).append("\n"); 
		query.append("	#if (${mnr_hngr_rck_cd} == 'A')" ).append("\n"); 
		query.append("		AND A.MNR_HNGR_RCK_CD in ('O','R','D')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.MNR_HNGR_RCK_CD = @[mnr_hngr_rck_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_hngr_trf_cd} != '' && ${mnr_hngr_trf_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND B.MNR_HNGR_TRF_CD = @[mnr_hngr_trf_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_hngr_bar_tp_cd} != '' && ${mnr_hngr_bar_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND MNR_HNGR_BAR_TP_CD = @[mnr_hngr_bar_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound_tp_cd} != '' && ${bound_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND MST.CNTR_NO    = CM.CNTR_NO" ).append("\n"); 
		query.append("	AND MST.CNMV_YR    = CM.CNMV_YR" ).append("\n"); 
		query.append("	AND MST.CNMV_ID_NO = CM.CNMV_ID_NO" ).append("\n"); 
		query.append("	AND A.EQ_NO        = MST.CNTR_NO " ).append("\n"); 
		query.append("	AND CM.OB_CNTR_FLG = DECODE(@[bound_tp_cd],'OB','Y','N')			" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}