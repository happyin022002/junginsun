/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOSearchStpInOut0135ListRSQL.java
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

public class SalesRPTDBDAOSearchStpInOut0135ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STP Income/Cost Inquiry
	  * 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * </pre>
	  */
	public SalesRPTDBDAOSearchStpInOut0135ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchStpInOut0135ListRSQL").append("\n"); 
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
		query.append("SELECT   /*+ ORDERED INDEX(A XAK1COA_MON_VVD) */" ).append("\n"); 
		query.append("   C.BKG_NO BKG_NO" ).append("\n"); 
		query.append("  ,NVL(C.AGMT_SGN_OFC_CD, C.SLS_OFC_CD) AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("  ,C.SLS_ACT_DESC" ).append("\n"); 
		query.append("  ,C.COND_OFC_CD" ).append("\n"); 
		query.append("  ,NVL(SUM(SVC_TRNS_PRC_AMT), 0) STP_REV" ).append("\n"); 
		query.append("  ,NVL(SUM(SVC_TRNS_PRC_AMT), 0) - NVL(SUM(OTR_PRC_AMT), 0) STP_INCOME" ).append("\n"); 
		query.append("  ,NVL(SUM(OTR_PRC_AMT), 0) OTH_COST" ).append("\n"); 
		query.append("FROM COA_MON_VVD A, COA_BKG_SVC_TRNS_SMRY C, COA_OFC_LVL D" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("  AND C.BL_NO_TP       IN('M', '0')" ).append("\n"); 
		query.append("  AND C.BKG_STS_CD     IN('F', 'S')" ).append("\n"); 
		query.append("  AND C.BKG_CGO_TP_CD  NOT IN('P')" ).append("\n"); 
		query.append("  AND A.VSL_CD         = C.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO     = C.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.DIR_CD         = C.DIR_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD       = C.RLANE_CD" ).append("\n"); 
		query.append("  AND A.TRD_CD         = C.TRD_CD" ).append("\n"); 
		query.append("  AND A.IOC_CD         = C.IOC_CD " ).append("\n"); 
		query.append("  AND A.SLS_YRMON     BETWEEN D.OFC_APLY_FM_YRMON AND D.OFC_APLY_TO_YRMON " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_vsl_cd} !='')" ).append("\n"); 
		query.append("  AND A.VSL_CD         = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_skd_voy_no} !='')" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO         = @[f_skd_voy_no]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("  AND A.DIR_CD         = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_bkg_no} !='')" ).append("\n"); 
		query.append("  AND C.BKG_NO         = @[f_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_stp_flg} =='Y')  /* Income */" ).append("\n"); 
		query.append("  AND C.COND_OFC_CD   = D.OFC_CD" ).append("\n"); 
		query.append("#else			" ).append("\n"); 
		query.append("  AND C.COND_OFC_CD   NOT IN D.OFC_CD" ).append("\n"); 
		query.append("  AND NVL(C.AGMT_SGN_OFC_CD, C.SLS_OFC_CD) = D.OFC_CD" ).append("\n"); 
		query.append("#end			      " ).append("\n"); 
		query.append("				      " ).append("\n"); 
		query.append("#if(${f_sls_ofc_cd} !='')" ).append("\n"); 
		query.append("  /* N200902110080   COA_SINWA 실적 조회 권한 관련 DECODE(SUBSTR(?, 1, 4), 'SHAR', 'SINRS', '') */" ).append("\n"); 
		query.append("  AND DECODE(@[f_rhq_cd], '1', D.OFC_N1ST_LVL_CD, '2', D.OFC_N2ND_LVL_CD, '3', D.OFC_N3RD_LVL_CD, '4', D.OFC_N4TH_LVL_CD, '5', D.OFC_N5TH_LVL_CD, '6', D.OFC_N6TH_LVL_CD, '7', D.OFC_N7TH_LVL_CD) = @[f_sls_ofc_cd] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  /* N200902110080   COA_SINWA 실적 조회 권한 관련 DECODE(SUBSTR(?, 1, 4), 'SHAR', 'SINRS', '') */" ).append("\n"); 
		query.append("  AND DECODE(@[f_ofc_lvl], '1', D.OFC_N1ST_LVL_CD, '2', D.OFC_N2ND_LVL_CD, '3', D.OFC_N3RD_LVL_CD, '4', D.OFC_N4TH_LVL_CD, '5',D.OFC_N5TH_LVL_CD, '6',D.OFC_N6TH_LVL_CD, '7', D.OFC_N7TH_LVL_CD) IN (@[f_ofc_cd], DECODE(SUBSTR(@[f_ofc_cd], 1, 4), 'SHAR', 'SINRS', '')) " ).append("\n"); 
		query.append("  AND DECODE(@[f_ofc_lvl], '1', D.OFC_N1ST_LVL_CD, '2', D.OFC_N2ND_LVL_CD, '3', D.OFC_N3RD_LVL_CD, '4', D.OFC_N4TH_LVL_CD, '5', D.OFC_N5TH_LVL_CD, '6', D.OFC_N6TH_LVL_CD, '7', D.OFC_N7TH_LVL_CD) IS NOT NULL  " ).append("\n"); 
		query.append("  AND DECODE(@[f_ofc_lvl], '1', D.OFC_N1ST_LVL_CD, '2', D.OFC_N2ND_LVL_TP_CD,'3',D.OFC_N3RD_LVL_TP_CD, '4', DECODE(D.OFC_N4TH_LVL_CD,'NYCRA',D.OFC_N4TH_LVL_CD, D.OFC_N4TH_LVL_TP_CD),'5',D.OFC_N5TH_LVL_TP_CD,'6',D.OFC_N6TH_LVL_TP_CD,'7',D.OFC_N7TH_LVL_TP_CD) IS NOT NULL " ).append("\n"); 
		query.append("  /* 월관리 */" ).append("\n"); 
		query.append("  AND DECODE(@[f_ofc_lvl], '1', D.OFC_N1ST_LVL_CD, '2', D.OFC_N2ND_LVL_TP_CD, '3', D.OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("            , '4', DECODE(SUBSTR(A.SLS_YRMON, 1, 4), '2008', DECODE(D.OFC_N4TH_LVL_CD, 'NYCRA', D.OFC_N4TH_LVL_CD, D.OFC_N4TH_LVL_TP_CD) " ).append("\n"); 
		query.append("                                                     , '2007', DECODE(D.OFC_N4TH_LVL_CD, 'NYCRA', D.OFC_N4TH_LVL_CD, D.OFC_N4TH_LVL_TP_CD) " ).append("\n"); 
		query.append("                                                     , DECODE(D.OFC_N4TH_LVL_CD, 'SZPDC', D.OFC_N4TH_LVL_TP_CD, D.OFC_N4TH_LVL_CD)) /* SHADSC만 AREA */" ).append("\n"); 
		query.append("            , '5', D.OFC_N5TH_LVL_TP_CD, '6', D.OFC_N6TH_LVL_TP_CD,'7', D.OFC_N7TH_LVL_TP_CD) IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND SUBSTR(A.SLS_YRMON,0,4)||A.COST_WK = @[f_year]||@[f_wk]" ).append("\n"); 
		query.append("GROUP BY C.COND_OFC_CD, NVL(C.AGMT_SGN_OFC_CD, C.SLS_OFC_CD), C.BKG_NO, C.SLS_ACT_DESC" ).append("\n"); 
		query.append("ORDER BY C.COND_OFC_CD, NVL(C.AGMT_SGN_OFC_CD, C.SLS_OFC_CD), C.BKG_NO, C.SLS_ACT_DESC" ).append("\n"); 

	}
}