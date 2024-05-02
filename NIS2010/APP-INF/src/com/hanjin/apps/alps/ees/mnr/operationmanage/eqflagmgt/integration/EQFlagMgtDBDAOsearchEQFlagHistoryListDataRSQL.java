/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchEQFlagHistoryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.06
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.03.06 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jonghee HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchEQFlagHistoryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 히스토리 데이타 조회
	  * --------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * * History
	  * 2013.11.08 이혜민 CHM-201327243-01 TYPE (Installation,Removal) 조건, Regional HQ, Office  조회 조건 추가
	  * 2014-03-06 Jonghee HAN [CHM-201429228] Hanger Rack/Bar History Module Error건 점검 요청 Hanger Installation/Removal History 실제 Data가 모두 조회되도록 SQL 수정 (DECODE문 제거후 A TABLE로 변경 및 NVL처리)
	  * --------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchEQFlagHistoryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("mnr_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_flg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cur_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchEQFlagHistoryListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   A.EQ_NO" ).append("\n"); 
		query.append(",  A.MNR_FLG_SEQ" ).append("\n"); 
		query.append(",  A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",  B.LSTM_CD" ).append("\n"); 
		query.append(",  A.MNR_FLG_TP_CD" ).append("\n"); 
		query.append(",  A.EQ_KND_CD" ).append("\n"); 
		query.append(",  DECODE(@[mnr_flg_tp_cd],'HGR',DECODE(A.MNR_STS_FLG,'Y','Install','Removal'),A.MNR_STS_FLG) MNR_STS_FLG" ).append("\n"); 
		query.append(",  A.MNR_FLG_YD_CD" ).append("\n"); 
		query.append(",  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),A.MNR_FLG_INP_DT,@[cur_ofc_cd]),'YYYY-MM-DD') AS MNR_FLG_INP_DT" ).append("\n"); 
		query.append(",  A.MNR_FLG_INP_TP_CD" ).append("\n"); 
		query.append(",  A.MNR_FLG_RMK" ).append("\n"); 
		query.append(",  A.MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_TRF_OTR_DESC" ).append("\n"); 
		query.append(",  NVL(A.HNGR_BAR_TTL_QTY, 0) HNGR_BAR_TTL_QTY -- DECODE문 제거후 NVL처리" ).append("\n"); 
		query.append(",  NVL(A.HNGR_BAR_AMD_QTY, 0) HNGR_BAR_AMD_QTY -- DECODE문 제거후 NVL처리" ).append("\n"); 
		query.append(",  A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",  A.MNR_ORD_SEQ" ).append("\n"); 
		query.append(",  A.MNR_FLG_CMPL_DT" ).append("\n"); 
		query.append(",  B.MVMT_CD" ).append("\n"); 
		query.append(",  A.EQ_MVMT_YR" ).append("\n"); 
		query.append(",  A.EQ_MVMT_ID_NO" ).append("\n"); 
		query.append(",  A.CRE_OFC_CD OFC_CD" ).append("\n"); 
		query.append(",  A.CRE_USR_ID" ).append("\n"); 
		query.append(",  A.CRE_DT" ).append("\n"); 
		query.append(",  B.BAR_ATCH_KNT" ).append("\n"); 
		query.append(",  NVL(A.ACT_INVT_QTY, 0) 	  ACT_INVT_QTY -- DECODE문 제거후 A TABLE로 변경 및 NVL처리" ).append("\n"); 
		query.append(",  NVL(A.MNR_HNGR_DMG_QTY, 0) MNR_HNGR_DMG_QTY -- 상동" ).append("\n"); 
		query.append(",  NVL(A.MNR_LOST_HNGR_QTY, 0)MNR_LOST_HNGR_QTY -- 상동" ).append("\n"); 
		query.append(",  NVL(A.MNR_DISP_HNGR_QTY, 0)MNR_DISP_HNGR_QTY -- 상동" ).append("\n"); 
		query.append(",  A.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",  A.MNR_ORD_SEQ" ).append("\n"); 
		query.append(",  NVL(A.MNR_ORD_OFC_CTY_CD || RTRIM(A.MNR_ORD_SEQ), '') WO_NO -- DECODE문 제거후 NVL처리" ).append("\n"); 
		query.append(",  B.CRNT_YD_CD" ).append("\n"); 
		query.append("#if (${bound_tp_cd} != '' && ${bound_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   ,CM.OB_CNTR_FLG	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM MNR_FLG_HIS A , MNR_EQ_STS_V B" ).append("\n"); 
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
		query.append("WHERE A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.MNR_FLG_TP_CD = @[mnr_flg_tp_cd] " ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("	AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${from_date} != '' && ${to_date} != '')" ).append("\n"); 
		query.append("    AND A.MNR_FLG_INP_DT BETWEEN" ).append("\n"); 
		query.append("       GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(@[from_date], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[cur_ofc_cd],TO_DATE(@[to_date], 'YYYY-MM-DD') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_hngr_trf_cd} != '' && ${mnr_hngr_trf_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND A.MNR_HNGR_TRF_CD = @[mnr_hngr_trf_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_hngr_bar_tp_cd} != '' && ${mnr_hngr_bar_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND A.MNR_HNGR_BAR_TP_CD = @[mnr_hngr_bar_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_hngr_rck_cd} != '' && ${mnr_hngr_rck_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND A.MNR_HNGR_RCK_CD = @[mnr_hngr_rck_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND	A.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("				'$user_tpszCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tpszCds'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_list} != '')" ).append("\n"); 
		query.append("	AND	A.EQ_NO IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqNos IN ${eqNos})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("				'$user_eqNos'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqNos'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("#if (${bound_tp_cd} != '' && ${bound_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("	AND MST.CNTR_NO    = CM.CNTR_NO" ).append("\n"); 
		query.append("	AND MST.CNMV_YR    = CM.CNMV_YR" ).append("\n"); 
		query.append("	AND MST.CNMV_ID_NO = CM.CNMV_ID_NO" ).append("\n"); 
		query.append("	AND A.EQ_NO        = MST.CNTR_NO " ).append("\n"); 
		query.append("	AND CM.OB_CNTR_FLG = DECODE(@[bound_tp_cd],'OB','Y','N')			" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_sts_flg} != '' && ${mnr_sts_flg} != 'A')" ).append("\n"); 
		query.append("    AND A.MNR_STS_FLG = @[mnr_sts_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_cd} != '')" ).append("\n"); 
		query.append("AND   A.CRE_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                    FROM  MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE AR_HD_QTR_OFC_CD = @[ar_hd_qtr_cd]" ).append("\n"); 
		query.append("                         AND ofc_cd LIKE @[ofc_cd]||'%%'" ).append("\n"); 
		query.append("                         AND delt_flg = 'N'" ).append("\n"); 
		query.append("                  )   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND   A.CRE_OFC_CD IN ( SELECT D.OFC_CD" ).append("\n"); 
		query.append("                    FROM   MNR_OFC_GEN_INFO D" ).append("\n"); 
		query.append("                    WHERE  D.UPPR_OFC_CD  =  @[ofc_cd]" ).append("\n"); 
		query.append("                         AND    D.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("                         AND    D.COST_CD       = 'MR'" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT @[ofc_cd]" ).append("\n"); 
		query.append("                    FROM DUAL" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.EQ_NO,A.MNR_FLG_SEQ ASC" ).append("\n"); 

	}
}