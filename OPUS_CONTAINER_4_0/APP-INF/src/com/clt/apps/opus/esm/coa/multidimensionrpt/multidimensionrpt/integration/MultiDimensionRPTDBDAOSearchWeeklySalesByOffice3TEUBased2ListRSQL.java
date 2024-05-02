/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P&L by Lane
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2ListRSQL(){
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
		params.put("f_pro_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ofc_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_display",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chtbiz",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchWeeklySalesByOffice3TEUBased2ListRSQL").append("\n"); 
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
		query.append("SELECT A.SLS_YRMON " ).append("\n"); 
		query.append("	,A.TRD_CD " ).append("\n"); 
		query.append("	,A.SUB_TRD_CD " ).append("\n"); 
		query.append("	,A.RLANE_CD " ).append("\n"); 
		query.append("	,A.IOC_CD " ).append("\n"); 
		query.append("	,A.DIR_CD " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	#foreach($key in ${allcols})" ).append("\n"); 
		query.append("		,SUM(DECODE(A.STND_COST_CD, '$key', NVL(A.AMT,0), 0)) AS COST_AMT$velocityCount" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	,SUM(NVL(A.AMT,0)) AS TTL_AMT " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("     /*-- 계정별 비용집계 ---*/ " ).append("\n"); 
		query.append("	SELECT   /*+ ORDERED */ " ).append("\n"); 
		query.append("		 B1.SLS_YRMON " ).append("\n"); 
		query.append("		,B1.TRD_CD " ).append("\n"); 
		query.append("		,B1.SUB_TRD_CD " ).append("\n"); 
		query.append("		,B1.RLANE_CD " ).append("\n"); 
		query.append("		,B1.IOC_CD " ).append("\n"); 
		query.append("		,B1.DIR_CD " ).append("\n"); 
		query.append("		,B2.STND_COST_CD " ).append("\n"); 
		query.append("		,SUM (DECODE (B2.STND_COST_CD " ).append("\n"); 
		query.append("		                       ,'LOAD0000', DECODE(SUBSTR (B2.CNTR_TPSZ_CD, -1),'2', B2.ESTM_PL_AMT, B2.ESTM_PL_AMT * 2) " ).append("\n"); 
		query.append("		                       ,'BSA00000', B2.ESTM_PL_AMT " ).append("\n"); 
		query.append("		                       ,DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', B2.CO_AMT,'O|BIZ', B2.CO_SLS_AMT,B2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("		              ) " ).append("\n"); 
		query.append("		  ) AS AMT " ).append("\n"); 
		query.append("	FROM COA_MON_VVD B1 " ).append("\n"); 
		query.append("		,COA_PFIT_LSS_SMRY B2 " ).append("\n"); 
		query.append("		,COA_PFIT_LSS_RPT_ITM B3 " ).append("\n"); 
		query.append("		,COA_OFC_LVL B4 " ).append("\n"); 
		query.append("	WHERE B1.VSL_CD        = B2.VSL_CD " ).append("\n"); 
		query.append("		AND B1.SKD_VOY_NO    = B2.SKD_VOY_NO " ).append("\n"); 
		query.append("		AND B1.DIR_CD        = B2.SKD_DIR_CD " ).append("\n"); 
		query.append("		AND B1.TRD_CD        = B2.TRD_CD " ).append("\n"); 
		query.append("		AND B1.RLANE_CD      = B2.RLANE_CD " ).append("\n"); 
		query.append("		AND B1.IOC_CD        = B2.IOC_CD " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("			AND B1.COST_YRMON    BETWEEN B4.OFC_APLY_FM_YRMON AND B4.OFC_APLY_TO_YRMON   " ).append("\n"); 
		query.append("		#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("			AND B1.SLS_YRMON     BETWEEN B4.OFC_APLY_FM_YRMON AND B4.OFC_APLY_TO_YRMON  " ).append("\n"); 
		query.append("		#end /*ofc_월별 관리*/" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND B2.STND_COST_CD  NOT IN ('91401011') /* STP REV 제외 */" ).append("\n"); 
		query.append("		AND B2.STND_COST_CD  = B3.STND_COST_CD " ).append("\n"); 
		query.append("		AND B1.DELT_FLG      <> 'Y' " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("			AND B1.COST_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]   " ).append("\n"); 
		query.append("		#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("			AND B1.SLS_YRMON     LIKE @[f_year]||@[f_sls_mon]||'%'    " ).append("\n"); 
		query.append("			AND B1.COST_WK       BETWEEN @[f_fm_wk] AND @[f_to_wk]   " ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if(${f_trd_cd} !='') " ).append("\n"); 
		query.append("			AND B1.TRD_CD    = @[f_trd_cd]  " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${f_rlane_cd} !='') " ).append("\n"); 
		query.append("			AND B1.RLANE_CD  = @[f_rlane_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${f_dir_cd} !='')   " ).append("\n"); 
		query.append("			AND B1.DIR_CD    = @[f_dir_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${f_vsl_cd} !='') " ).append("\n"); 
		query.append("			AND B1.VSL_CD    = @[f_vsl_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${f_skd_voy_no} !='')  " ).append("\n"); 
		query.append("			AND B1.SKD_VOY_NO    = @[f_skd_voy_no] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${f_skd_dir_cd} !='') " ).append("\n"); 
		query.append("			AND B1.DIR_CD     = @[f_skd_dir_cd] " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("		                          " ).append("\n"); 
		query.append("		AND B3.RPT_VW_CD     = @[f_pro_vw]" ).append("\n"); 
		query.append("		AND DECODE (@[f_ofc_vw], 'C', B2.AGMT_SGN_OFC_CD, 'L', B2.SLS_OFC_CD) = B4.OFC_CD " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("			#if(${f_excl_sts} =='')				" ).append("\n"); 
		query.append("				AND DECODE (@[f_ofc_lvl] ,'1', B4.OFC_N1ST_LVL_CD,'2', B4.OFC_N2ND_LVL_CD,'3', B4.OFC_N3RD_LVL_CD,'4', B4.OFC_N4TH_LVL_CD,'5', B4.OFC_N5TH_LVL_CD,'6', B4.OFC_N6TH_LVL_CD,'7', B4.OFC_N7TH_LVL_CD) = @[f_ofc_cd]  " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND B4.OFC_CD = @[f_ofc_cd]  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND DECODE (@[f_ofc_lvl],'1', B4.OFC_N1ST_LVL_CD,'2', B4.OFC_N2ND_LVL_CD,'3', B4.OFC_N3RD_LVL_CD,'4', B4.OFC_N4TH_LVL_CD,'5', B4.OFC_N5TH_LVL_CD,'6', B4.OFC_N6TH_LVL_CD,'7', B4.OFC_N7TH_LVL_CD) IS NOT NULL  " ).append("\n"); 
		query.append("			AND DECODE (@[f_ofc_lvl],'1', B4.OFC_N1ST_LVL_CD,'2', B4.OFC_N2ND_LVL_TP_CD,'3', B4.OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("			           ,'4', B4.OFC_N4TH_LVL_TP_CD,'5', B4.OFC_N5TH_LVL_TP_CD,'6', B4.OFC_N6TH_LVL_TP_CD,'7', B4.OFC_N7TH_LVL_TP_CD) IS NOT NULL  " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		#if(${f_pro_vw} =='P' && ${f_pro_lvl} =='O')" ).append("\n"); 
		query.append("			AND (B3.STND_COST_TP_CD IN ('S','C','O',@[str_display])  /* strDisplay( f_pro_obj P->O,A,B) */" ).append("\n"); 
		query.append("				OR B3.STND_COST_CD IN ('OPCTOTAL','OPB00000','BOPTOTAL','BOPB0000')) " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if( ${f_pro_lvl} =='C')" ).append("\n"); 
		query.append("				AND B3.STND_COST_TP_CD IN ('S','C') " ).append("\n"); 
		query.append("			#elseif (${f_pro_lvl} =='O')" ).append("\n"); 
		query.append("				AND B3.STND_COST_TP_CD IN ('S','C','O') " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	GROUP BY " ).append("\n"); 
		query.append("		B1.SLS_YRMON " ).append("\n"); 
		query.append("		,B1.TRD_CD " ).append("\n"); 
		query.append("		,B1.SUB_TRD_CD " ).append("\n"); 
		query.append("		,B1.RLANE_CD " ).append("\n"); 
		query.append("		,B1.IOC_CD " ).append("\n"); 
		query.append("		,B1.DIR_CD " ).append("\n"); 
		query.append("		,B2.STND_COST_CD " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	/*-- SUMMRY 비용집계 ---------------*/ " ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		 SLS_YRMON " ).append("\n"); 
		query.append("		,TRD_CD " ).append("\n"); 
		query.append("		,SUB_TRD_CD " ).append("\n"); 
		query.append("		,RLANE_CD " ).append("\n"); 
		query.append("		,IOC_CD " ).append("\n"); 
		query.append("		,DIR_CD " ).append("\n"); 
		query.append("		,DECODE (B2.RNUM " ).append("\n"); 
		query.append("		       ,1, 'VOYAGE00' " ).append("\n"); 
		query.append("		       ,2, 'LOADFACT' " ).append("\n"); 
		query.append("		       ,3, 'REVENUE0' " ).append("\n"); 
		query.append("		       ,4, 'RPB00000' " ).append("\n"); 
		query.append("		       ,5, 'OTHINCOM' " ).append("\n"); 
		query.append("		       ,6, 'INCOMTTL' " ).append("\n"); 
		query.append("		       ,7, 'CMCOST00' " ).append("\n"); 
		query.append("		       ,8, 'CMCB0000' " ).append("\n"); 
		query.append("		       ,9, 'CMCTOTAL' " ).append("\n"); 
		query.append("		       ,10, 'CMB00000' " ).append("\n"); 
		query.append("		       ,11, 'OPCOST00' " ).append("\n"); 
		query.append("		       ,12, 'OPCB0000' " ).append("\n"); 
		query.append("		       ,13, 'OPCTOTAL' " ).append("\n"); 
		query.append("		       ,14, 'OPB00000' " ).append("\n"); 
		query.append("		       ,15, 'TSCTRB01' " ).append("\n"); 
		query.append("		       ,16, 'CMMT0001' " ).append("\n"); 
		query.append("		       ,17, 'BCMTOTAL' " ).append("\n"); 
		query.append("		       ,18, 'BCMB0000' " ).append("\n"); 
		query.append("		       ,19, '65901023'    " ).append("\n"); 
		query.append("		       ,20, 'BLN00001'    " ).append("\n"); 
		query.append("		       ,21, 'BLN00002'    " ).append("\n"); 
		query.append("		       ,22, 'BLNTOTAL'   " ).append("\n"); 
		query.append("		       ,23, 'BOPTOTAL' " ).append("\n"); 
		query.append("		       ,24, 'BOPB0000' " ).append("\n"); 
		query.append("		       ,25, 'EQCOST00' " ).append("\n"); 
		query.append("		       ) STND_COST_CD " ).append("\n"); 
		query.append("		,DECODE " ).append("\n"); 
		query.append("		   (B2.RNUM " ).append("\n"); 
		query.append("		   ,1, VOYAGE                                            /* VOYAGE00 */ " ).append("\n"); 
		query.append("		   ,2, DECODE (SUPPLY, 0, 0, LOAD_TEU / SUPPLY) * 100    /* LOADFACT */" ).append("\n"); 
		query.append("		   ,3, REVENUE                                           /* REVENUE0 */" ).append("\n"); 
		query.append("		   ,4, DECODE (LOAD_TEU, 0, 0, REVENUE / LOAD_TEU)       /* RPB00000 (REV / TEU) */" ).append("\n"); 
		query.append("		   ,5, OTHER_INCOME                                      /* OTHINCOM */" ).append("\n"); 
		query.append("		   ,6, INCOME_TOTAL                                      /* INCOMTTL */" ).append("\n"); 
		query.append("		   ,7,  CM_COST /* CMCOST00 (Cost1 Total) */" ).append("\n"); 
		query.append("		   ,8, DECODE (LOAD_TEU ,0, 0, CM_COST	/ LOAD_TEU)      /* CMCB0000 (Cost1/TEU) */" ).append("\n"); 
		query.append("		   ,9, (INCOME_TOTAL - DEM_DET) - (CM_COST + SPC_CHTR)   /* CMCTOTAL (CM(Contribution Margin) Total) */" ).append("\n"); 
		query.append("		   ,10, DECODE (LOAD_TEU,0, 0 , ((INCOME_TOTAL - DEM_DET) - (CM_COST + SPC_CHTR))/ LOAD_TEU )  /* CMB00000 (CM(Contribution Margin)/TEU) */" ).append("\n"); 
		query.append("		   ,11, OP_COST " ).append("\n"); 
		query.append("		   ,12, DECODE (LOAD_TEU, 0, 0, OP_COST / LOAD_TEU) " ).append("\n"); 
		query.append("		   ,13, 0  /* OPCTOTAL (Branch CM-cost2) */" ).append("\n"); 
		query.append("		   ,14, 0  /* OPB00000(OPCTOTAL/load) */" ).append("\n"); 
		query.append("		   ,15, (INCOME_TOTAL + TS_COST) - (CM_COST + OP_COST)   /* TSCTRB01 */" ).append("\n"); 
		query.append("		   ,16, ((INCOME_TOTAL - CM_COST) - CO_SLS_AMT - CO_AMT - CMMT_COST - INTER_TS)   /* CMMT0001 */" ).append("\n"); 
		query.append("		   ,17, 0   /* BCMTOTAL (Branch CM)  */" ).append("\n"); 
		query.append("		   ,18, 0 " ).append("\n"); 
		query.append("		   ,19, 0                /* 65901023 */" ).append("\n"); 
		query.append("		   ,20, 0   /* BLN00001 */" ).append("\n"); 
		query.append("		   ,21, 0     /* BLN00002 */" ).append("\n"); 
		query.append("		   ,22, 0  /* BLNTOTAL */" ).append("\n"); 
		query.append("		   ,23, INCOME_TOTAL - (CM_COST + OP_COST) /* BOPTOTAL */" ).append("\n"); 
		query.append("		   ,24, DECODE (LOAD_TEU,0, 0 , (INCOME_TOTAL - (CM_COST + OP_COST))/ LOAD_TEU )  /* BOPB0000 ((BOPTOTAL)/TEU) */" ).append("\n"); 
		query.append("		   ,25, 0 /*EQ_COST*/" ).append("\n"); 
		query.append("		   ) AS AMT 		                       " ).append("\n"); 
		query.append("	FROM ( " ).append("\n"); 
		query.append("		/*-- SUMMRY : 계정별비용집계 --------*/" ).append("\n"); 
		query.append("		SELECT    " ).append("\n"); 
		query.append("			 SLS_YRMON " ).append("\n"); 
		query.append("			,TRD_CD " ).append("\n"); 
		query.append("			,SUB_TRD_CD " ).append("\n"); 
		query.append("			,RLANE_CD " ).append("\n"); 
		query.append("			,IOC_CD " ).append("\n"); 
		query.append("			,DIR_CD " ).append("\n"); 
		query.append("			,SUM (VOYAGE) VOYAGE " ).append("\n"); 
		query.append("			,SUM (SUPPLY) SUPPLY " ).append("\n"); 
		query.append("			,SUM (LOAD_TEU) LOAD_TEU " ).append("\n"); 
		query.append("			,SUM (REVENUE) REVENUE " ).append("\n"); 
		query.append("			,SUM (OTHER_INCOME) OTHER_INCOME " ).append("\n"); 
		query.append("			,SUM (SPC_CHTR) SPC_CHTR " ).append("\n"); 
		query.append("			,SUM (INCOME_TOTAL) INCOME_TOTAL " ).append("\n"); 
		query.append("			,SUM (CM_COST) CM_COST " ).append("\n"); 
		query.append("			,SUM (OP_COST) OP_COST " ).append("\n"); 
		query.append("			,SUM (TS_COST) TS_COST " ).append("\n"); 
		query.append("			,SUM (CMMT_COST) CMMT_COST " ).append("\n"); 
		query.append("			,SUM (CO_SLS_AMT) CO_SLS_AMT " ).append("\n"); 
		query.append("			,SUM (CO_AMT) CO_AMT " ).append("\n"); 
		query.append("			,SUM (INTER_TS) INTER_TS " ).append("\n"); 
		query.append("			,SUM (DEM_DET) DEM_DET " ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("		FROM ( " ).append("\n"); 
		query.append("			SELECT  /*+ ORDERED */ " ).append("\n"); 
		query.append("				 A1.SLS_YRMON " ).append("\n"); 
		query.append("				,A1.TRD_CD " ).append("\n"); 
		query.append("				,A1.SUB_TRD_CD " ).append("\n"); 
		query.append("				,A1.RLANE_CD " ).append("\n"); 
		query.append("				,A1.IOC_CD " ).append("\n"); 
		query.append("				,A1.DIR_CD 		" ).append("\n"); 
		query.append("				,COUNT(DISTINCT A2.TRD_CD|| A2.RLANE_CD || A2.IOC_CD || A2.VSL_CD || A2.SKD_VOY_NO || A2.SKD_DIR_CD)  AS VOYAGE " ).append("\n"); 
		query.append("				,NVL(SUM(DECODE(A3.STND_COST_CD,'BSA00000', DECODE (@[f_pro_vw],'P', A2.ESTM_PL_AMT,'R', A2.RA_PL_AMT),0)),0) AS SUPPLY " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_CD " ).append("\n"); 
		query.append("				                 ,'LOAD0000', DECODE(SUBSTR(A2.CNTR_TPSZ_CD,-1),'2', A2.ESTM_PL_AMT, A2.ESTM_PL_AMT * 2) " ).append("\n"); 
		query.append("				                 ,0 " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS LOAD_TEU " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_CD " ).append("\n"); 
		query.append("				                 ,'41101011', DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT, A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				                 ,0 " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS REVENUE " ).append("\n"); 
		query.append("				,NVL(SUM(CASE " ).append("\n"); 
		query.append("				           WHEN A3.STND_COST_CD IN ('43102011', '43102021', '43201011', '43207011') THEN " ).append("\n"); 
		query.append("				           			DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT, A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				           ELSE 0 " ).append("\n"); 
		query.append("				        END " ).append("\n"); 
		query.append("				       ) " ).append("\n"); 
		query.append("				   ,0 " ).append("\n"); 
		query.append("				   ) AS OTHER_INCOME " ).append("\n"); 
		query.append("				,NVL(SUM(CASE " ).append("\n"); 
		query.append("					           WHEN A3.STND_COST_CD IN ('43102011', '43102021') THEN " ).append("\n"); 
		query.append("					           		DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("					           ELSE 0 " ).append("\n"); 
		query.append("					        END " ).append("\n"); 
		query.append("					       ) " ).append("\n"); 
		query.append("					   ,0 " ).append("\n"); 
		query.append("					   ) AS SPC_CHTR " ).append("\n"); 
		query.append("					,NVL (SUM (DECODE (A3.STND_COST_TP_CD " ).append("\n"); 
		query.append("					                 ,'S', DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT, A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("					                 ,0 " ).append("\n"); 
		query.append("					                 ) " ).append("\n"); 
		query.append("					         ) " ).append("\n"); 
		query.append("					    ,0 " ).append("\n"); 
		query.append("					    ) AS INCOME_TOTAL " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_TP_CD " ).append("\n"); 
		query.append("				                 ,'C', DECODE (A3.STND_COST_CD " ).append("\n"); 
		query.append("				                              ,'BSA00000', 0 /* 공급량 */" ).append("\n"); 
		query.append("				                              ,'LOAD0000', 0 /* 수송량 */" ).append("\n"); 
		query.append("				                              ,DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				                              ) " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS CM_COST " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_TP_CD " ).append("\n"); 
		query.append("				                 ,'O', DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				                 ,0 " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS OP_COST " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_CD " ).append("\n"); 
		query.append("				                 ,'TSCTRB00', DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				                 ,0 " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS TS_COST " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_CD " ).append("\n"); 
		query.append("				                 ,'CMMT0000',DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				                 ,0 " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS CMMT_COST " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_CD " ).append("\n"); 
		query.append("				                 ,'COMAMT00', DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				                 ,0 " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS CO_SLS_AMT " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_CD " ).append("\n"); 
		query.append("				                 ,'CHTOUT00',DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				                 ,0 " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS CO_AMT " ).append("\n"); 
		query.append("				,NVL (SUM (DECODE (A3.STND_COST_CD " ).append("\n"); 
		query.append("				                 ,'INTTRDTS', DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				                 ,0 " ).append("\n"); 
		query.append("				                 ) " ).append("\n"); 
		query.append("				         ) " ).append("\n"); 
		query.append("				    ,0 " ).append("\n"); 
		query.append("				    ) AS INTER_TS " ).append("\n"); 
		query.append("				,NVL " ).append("\n"); 
		query.append("				   (SUM " ).append("\n"); 
		query.append("				       (CASE " ).append("\n"); 
		query.append("				           WHEN A3.STND_COST_CD IN ('43201011') " ).append("\n"); 
		query.append("				           		THEN DECODE(@[f_pro_lvl]||'|'||@[f_chtbiz],'O|CHT', A2.CO_AMT,'O|BIZ', A2.CO_SLS_AMT,A2.ESTM_PL_AMT) " ).append("\n"); 
		query.append("				           ELSE 0 " ).append("\n"); 
		query.append("				        END " ).append("\n"); 
		query.append("				       ) " ).append("\n"); 
		query.append("				   ,0 " ).append("\n"); 
		query.append("				   ) AS DEM_DET " ).append("\n"); 
		query.append("			FROM COA_MON_VVD A1 " ).append("\n"); 
		query.append("				,COA_PFIT_LSS_SMRY A2 " ).append("\n"); 
		query.append("				,COA_PFIT_LSS_RPT_ITM A3 " ).append("\n"); 
		query.append("				,COA_OFC_LVL A4 " ).append("\n"); 
		query.append("			WHERE A1.VSL_CD       = A2.VSL_CD " ).append("\n"); 
		query.append("				AND A1.SKD_VOY_NO   = A2.SKD_VOY_NO " ).append("\n"); 
		query.append("				AND A1.DIR_CD       = A2.SKD_DIR_CD " ).append("\n"); 
		query.append("				AND A1.TRD_CD       = A2.TRD_CD " ).append("\n"); 
		query.append("				AND A1.RLANE_CD     = A2.RLANE_CD " ).append("\n"); 
		query.append("				AND A1.IOC_CD       = A2.IOC_CD " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("				#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("					AND A1.COST_YRMON    BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("				#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("					AND A1.SLS_YRMON     BETWEEN A4.OFC_APLY_FM_YRMON AND A4.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("				AND A2.STND_COST_CD NOT IN ('91401011')   /*, '65901021' STP REV, ABC OTH 제외 */ " ).append("\n"); 
		query.append("				AND A2.STND_COST_CD = A3.STND_COST_CD " ).append("\n"); 
		query.append("				AND A1.DELT_FLG     <> 'Y' " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("					AND A1.COST_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon] " ).append("\n"); 
		query.append("				#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("					AND A1.SLS_YRMON     LIKE @[f_year]||@[f_sls_mon]||'%' " ).append("\n"); 
		query.append("					AND A1.COST_WK       BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if(${f_trd_cd} !='') " ).append("\n"); 
		query.append("					AND A1.TRD_CD    = @[f_trd_cd]  " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${f_rlane_cd} !='') " ).append("\n"); 
		query.append("					AND A1.RLANE_CD  = @[f_rlane_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${f_dir_cd} !='')   " ).append("\n"); 
		query.append("					AND A1.DIR_CD    = @[f_dir_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${f_vsl_cd} !='') " ).append("\n"); 
		query.append("					AND A1.VSL_CD    = @[f_vsl_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${f_skd_voy_no} !='')  " ).append("\n"); 
		query.append("					AND A1.SKD_VOY_NO    = @[f_skd_voy_no] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${f_skd_dir_cd} !='') " ).append("\n"); 
		query.append("					AND A1.DIR_CD     = @[f_skd_dir_cd] " ).append("\n"); 
		query.append("			    #end     	" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("				AND A3.RPT_VW_CD     = @[f_pro_vw]  " ).append("\n"); 
		query.append("				AND DECODE (@[f_ofc_vw], 'C', A2.AGMT_SGN_OFC_CD, 'L', A2.SLS_OFC_CD) = A4.OFC_CD " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if(${f_ofc_cd} !='')" ).append("\n"); 
		query.append("					#if(${f_excl_sts} =='')" ).append("\n"); 
		query.append("						AND DECODE (@[f_ofc_lvl] ,'1', A4.OFC_N1ST_LVL_CD,'2', A4.OFC_N2ND_LVL_CD,'3', A4.OFC_N3RD_LVL_CD,'4', A4.OFC_N4TH_LVL_CD,'5', A4.OFC_N5TH_LVL_CD,'6', A4.OFC_N6TH_LVL_CD,'7', A4.OFC_N7TH_LVL_CD) = @[f_ofc_cd]  " ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("						AND A4.OFC_CD        = @[f_ofc_cd]  " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND DECODE (@[f_ofc_lvl],'1', A4.OFC_N1ST_LVL_CD,'2', A4.OFC_N2ND_LVL_CD,'3', A4.OFC_N3RD_LVL_CD,'4', A4.OFC_N4TH_LVL_CD,'5', A4.OFC_N5TH_LVL_CD,'6', A4.OFC_N6TH_LVL_CD,'7', A4.OFC_N7TH_LVL_CD) IS NOT NULL  " ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					AND DECODE (@[f_ofc_lvl],'1', A4.OFC_N1ST_LVL_CD,'2', A4.OFC_N2ND_LVL_TP_CD,'3', A4.OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("					           ,'4', A4.OFC_N4TH_LVL_TP_CD,'5', A4.OFC_N5TH_LVL_TP_CD,'6', A4.OFC_N6TH_LVL_TP_CD,'7', A4.OFC_N7TH_LVL_TP_CD) IS NOT NULL  " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if(${f_pro_vw} =='P' && ${f_pro_lvl} =='O')" ).append("\n"); 
		query.append("					AND (A3.STND_COST_TP_CD IN ('S','C','O',@[str_display])  /* f_pro_obj P->O,A,B */" ).append("\n"); 
		query.append("						OR A3.STND_COST_CD IN ('OPCTOTAL','OPB00000','BOPTOTAL','BOPB0000')) " ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND A3.STND_COST_TP_CD IN ('S','C','O') " ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("			GROUP BY  " ).append("\n"); 
		query.append("				 A1.SLS_YRMON " ).append("\n"); 
		query.append("				,A1.TRD_CD " ).append("\n"); 
		query.append("				,A1.SUB_TRD_CD " ).append("\n"); 
		query.append("				,A1.RLANE_CD " ).append("\n"); 
		query.append("				,A1.IOC_CD " ).append("\n"); 
		query.append("				,A1.DIR_CD " ).append("\n"); 
		query.append("			) " ).append("\n"); 
		query.append("		GROUP BY  " ).append("\n"); 
		query.append("			 SLS_YRMON " ).append("\n"); 
		query.append("			,TRD_CD " ).append("\n"); 
		query.append("			,SUB_TRD_CD " ).append("\n"); 
		query.append("			,RLANE_CD " ).append("\n"); 
		query.append("			,IOC_CD " ).append("\n"); 
		query.append("			,DIR_CD 			" ).append("\n"); 
		query.append("		) B1 " ).append("\n"); 
		query.append("		,(SELECT CPY_NO AS RNUM " ).append("\n"); 
		query.append("			FROM COM_CPY_NO " ).append("\n"); 
		query.append("			WHERE CPY_NO BETWEEN 1 AND 25 " ).append("\n"); 
		query.append("		) B2 " ).append("\n"); 
		query.append("	) A " ).append("\n"); 
		query.append("GROUP BY A.SLS_YRMON" ).append("\n"); 
		query.append("	,A.TRD_CD" ).append("\n"); 
		query.append("	,A.SUB_TRD_CD" ).append("\n"); 
		query.append("	, A.RLANE_CD" ).append("\n"); 
		query.append("	,A.IOC_CD" ).append("\n"); 
		query.append("	,A.DIR_CD" ).append("\n"); 

	}
}