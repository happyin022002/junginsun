/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOSearchRPTbyOfc0071ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.08.05 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchRPTbyOfc0071ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Report-Graph
	  * 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public SalesRPTDBDAOSearchRPTbyOfc0071ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chkprd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cob_trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cob_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cob_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cob_subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchRPTbyOfc0071ListRSQL").append("\n"); 
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
		query.append("SELECT Y.COST_WK" ).append("\n"); 
		query.append("	, NVL(X.REV,0) REV" ).append("\n"); 
		query.append("	, NVL(X.BKG_REV,0) BKG_REV" ).append("\n"); 
		query.append("	, NVL(X.LOAD,0) LOAD" ).append("\n"); 
		query.append("	, NVL(X.CM_COST,0) CM_COST 		 " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("	SELECT  " ).append("\n"); 
		query.append("		 A.COST_WK " ).append("\n"); 
		query.append("		,SUM(DECODE(SUBSTR(H.CNTR_TPSZ_CD,-1,1),'2',NVL(H.BKG_QTY,0),'3',NVL(H.BKG_QTY,0),NVL(H.BKG_QTY,0)*2)) LOAD" ).append("\n"); 
		query.append("		,SUM(NVL(H.BKG_REV,0)+NVL(H.BKG_OFT_REV,0)) REV" ).append("\n"); 
		query.append("		,SUM(NVL(H.BKG_REV,0)+NVL(H.BKG_OFT_REV,0)+NVL(H.BKG_MISC_REV,0)+NVL(H.SCR_CHG_REV,0)) BKG_REV" ).append("\n"); 
		query.append("		,NVL(SUM(DECODE(@[f_pro_vw],'P', NVL(PA_CM_COST_TTL_AMT, 0), 'R', NVL(RA_CM_COST_TTL_AMT, 0)) ),0) CM_COST " ).append("\n"); 
		query.append("	FROM COA_MON_VVD A" ).append("\n"); 
		query.append("		#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("			,COA_BKG_EXPN_DTL H " ).append("\n"); 
		query.append("		#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("			,COA_BKG_EXPN_DTL_WK H " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	WHERE 1=1 " ).append("\n"); 
		query.append("		AND A.DELT_FLG <> 'Y' " ).append("\n"); 
		query.append("		AND H.BL_NO_TP IN ('M','0')  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if(${f_bkg_sts} !='')" ).append("\n"); 
		query.append("			AND H.BKG_STS_CD    IN ('F','S','W')  " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND H.BKG_STS_CD    IN ('F','S')  			         " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		         " ).append("\n"); 
		query.append("		AND H.BKG_CGO_TP_CD <> 'P'  " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("		#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("			AND A.COST_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]   " ).append("\n"); 
		query.append("			AND A.COST_YRMON = H.COST_YRMON " ).append("\n"); 
		query.append("		#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("			AND SUBSTR(A.SLS_YRMON,1,4) || A.COST_WK BETWEEN  @[f_year]||@[f_fm_wk] AND  @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("			AND SUBSTR(A.SLS_YRMON,1,4) || A.COST_WK = SUBSTR(H.SLS_YRMON,1,4) || H.COST_WK" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND A.TRD_CD       = H.TRD_CD " ).append("\n"); 
		query.append("		AND A.RLANE_CD     = H.RLANE_CD " ).append("\n"); 
		query.append("		AND A.IOC_CD       = H.IOC_CD " ).append("\n"); 
		query.append("		AND A.VSL_CD       = H.VSL_CD " ).append("\n"); 
		query.append("		AND A.SKD_VOY_NO   = H.SKD_VOY_NO " ).append("\n"); 
		query.append("		AND A.DIR_CD       = H.DIR_CD " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("		#if(${f_ofc_cd} =='')" ).append("\n"); 
		query.append("			AND DECODE(@[f_ofc_vw], 'C', H.AGMT_SGN_OFC_CD, 'L', H.SLS_OFC_CD)  " ).append("\n"); 
		query.append("					IN (SELECT DISTINCT OFC_CD  " ).append("\n"); 
		query.append("						FROM COA_OFC_LVL  " ).append("\n"); 
		query.append("						WHERE 1=1" ).append("\n"); 
		query.append("						#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("							AND A.COST_YRMON    BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("						#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("							AND A.SLS_YRMON     BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							AND DECODE(@[f_ofc_lvl], '1', OFC_N1ST_LVL_CD, '2', OFC_N2ND_LVL_CD, '3', OFC_N3RD_LVL_CD, '4', OFC_N4TH_LVL_CD, '5', OFC_N5TH_LVL_CD, '6', OFC_N6TH_LVL_CD, '7', OFC_N7TH_LVL_CD) IS NOT NULL " ).append("\n"); 
		query.append("							AND DECODE(@[f_ofc_lvl], '1', OFC_N1ST_LVL_CD, '2', OFC_N2ND_LVL_TP_CD, '3', OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("										, '4', DECODE(SUBSTR( DECODE(@[f_chkprd], 'M', A.COST_YRMON, A.SLS_YRMON), 1, 4), '2008', DECODE(OFC_N4TH_LVL_CD, 'NYCRA', OFC_N4TH_LVL_CD, OFC_N4TH_LVL_TP_CD) " ).append("\n"); 
		query.append("																			, '2007', DECODE(OFC_N4TH_LVL_CD, 'NYCRA', OFC_N4TH_LVL_CD, OFC_N4TH_LVL_TP_CD) " ).append("\n"); 
		query.append("																			, DECODE(OFC_N4TH_LVL_CD, 'SZPDC', OFC_N4TH_LVL_TP_CD, OFC_N4TH_LVL_CD)) /* SHADSC만 AREA */" ).append("\n"); 
		query.append("										, '5', OFC_N5TH_LVL_TP_CD, '6', OFC_N6TH_LVL_TP_CD,'7', OFC_N7TH_LVL_TP_CD) IS NOT NULL " ).append("\n"); 
		query.append("			            )" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("				AND DECODE(@[f_ofc_vw], 'C', H.AGMT_SGN_OFC_CD, 'L', H.SLS_OFC_CD)  " ).append("\n"); 
		query.append("					IN (SELECT OFC_CD  " ).append("\n"); 
		query.append("						FROM COA_OFC_LVL  " ).append("\n"); 
		query.append("						WHERE DECODE(@[f_ofc_lvl], '1', OFC_N1ST_LVL_CD, '2', OFC_N2ND_LVL_CD, '3', OFC_N3RD_LVL_CD, '4', OFC_N4TH_LVL_CD, '5', OFC_N5TH_LVL_CD, '6', OFC_N6TH_LVL_CD, '7', OFC_N7TH_LVL_CD) = @[f_ofc_cd] " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("						#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("							AND A.COST_YRMON   BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON  " ).append("\n"); 
		query.append("						#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("							AND A.SLS_YRMON     BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON  " ).append("\n"); 
		query.append("						#end			" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND DECODE(@[f_ofc_vw], 'C', H.AGMT_SGN_OFC_CD, 'L', H.SLS_OFC_CD) = @[f_ofc_cd] " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND A.TRD_CD = NVL(@[f_cob_trade], A.TRD_CD) 			" ).append("\n"); 
		query.append("		AND A.SUB_TRD_CD = NVL(@[f_cob_subtrade], A.SUB_TRD_CD) " ).append("\n"); 
		query.append("		AND A.RLANE_CD = NVL(@[f_cob_lane], A.RLANE_CD) " ).append("\n"); 
		query.append("		AND A.DIR_CD = NVL(@[f_cob_bound], A.DIR_CD) 			" ).append("\n"); 
		query.append("	GROUP BY A.COST_WK " ).append("\n"); 
		query.append("	) X" ).append("\n"); 
		query.append("	, COA_WK_PRD Y " ).append("\n"); 
		query.append("WHERE Y.COST_WK = X.COST_WK(+) " ).append("\n"); 
		query.append("	#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("		AND Y.SLS_FM_DT BETWEEN @[f_year]||@[f_fm_mon]||'01' AND @[f_year]||@[f_to_mon]||'31' " ).append("\n"); 
		query.append("	#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("		AND Y.COST_YR = @[f_year] " ).append("\n"); 
		query.append("		AND Y.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk] " ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("ORDER BY Y.COST_WK" ).append("\n"); 

	}
}