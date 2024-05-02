/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchMultiDimension069List2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.11.18 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchMultiDimension069List2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Detail Inquiry
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchMultiDimension069List2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_usa_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_r_cmdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchMultiDimension069List2RSQL").append("\n"); 
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
		query.append("SELECT ITEM" ).append("\n"); 
		query.append(",ITEM_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($allcols.size() > 0)" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND( 0" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("+ ESTM_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",2)" ).append("\n"); 
		query.append(") ESTM_TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND( 0" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("+ REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 2)" ).append("\n"); 
		query.append(") REPO_TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND(ESTM_$key, 2)) ESTM_$key" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND(REPO_$key, 2)) REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND(ESTM_D2, 2)) ESTM_TOTAL" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND(REPO_D2, 2)) REPO_TOTAL" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND(ESTM_D2, 2)) ESTM_D2" ).append("\n"); 
		query.append(",DECODE(ITEM, 'CVES', 0, 'CVET', 0, ROUND(REPO_D2, 2) REPO_D2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (SELECT B.ITEM" ).append("\n"); 
		query.append(",B.ITEM_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($allcols.size() > 0)" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",SUM(NVL(A.ESTM_$key, 0)) ESTM_$key" ).append("\n"); 
		query.append(",SUM(NVL(A.REPO_$key, 0)) REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",SUM(NVL(A.ESTM_D2, 0)) ESTM_D2" ).append("\n"); 
		query.append(",SUM(NVL(A.REPO_D2, 0)) REPO_D2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 'ITM1' ITEM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($allcols.size() > 0)" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",DECODE(CNTR_TPSZ_CD, '$key', NVL(BKG_QTY,0), 0) ESTM_$key" ).append("\n"); 
		query.append(",DECODE(CNTR_TPSZ_CD, '$key', NVL(BKG_QTY,0), 0) REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(E.CNTR_TPSZ_CD, 'D2', NVL(E.BKG_QTY,0), 0) ESTM_D2" ).append("\n"); 
		query.append(",DECODE(E.CNTR_TPSZ_CD, 'D2', NVL(E.BKG_QTY,0), 0) REPO_D2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM COA_BKG_REV_DTL E" ).append("\n"); 
		query.append(",COA_RGST_BKG C" ).append("\n"); 
		query.append(",COA_MON_VVD D" ).append("\n"); 
		query.append("WHERE C.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("AND C.TRD_CD = D.TRD_CD" ).append("\n"); 
		query.append("AND C.RLANE_CD = D.RLANE_CD" ).append("\n"); 
		query.append("AND C.IOC_CD = D.IOC_CD" ).append("\n"); 
		query.append("AND C.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.DIR_CD = D.DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Booking Info에 적용 (kevin.kim) */" ).append("\n"); 
		query.append("AND C.BL_NO_TP IN ('M','0')" ).append("\n"); 
		query.append("AND C.BKG_STS_CD IN ('F','S')" ).append("\n"); 
		query.append("AND C.BKG_CGO_TP_CD NOT IN ('P')" ).append("\n"); 
		query.append("AND D.DELT_FLG NOT IN ('Y')" ).append("\n"); 
		query.append("AND E.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#if($allcols.size() > 0)" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("#if($velocityCount < $allcols.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'D2'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_cost_yrmon} !='')" ).append("\n"); 
		query.append("AND  D.COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_cntr_tpsz_cd} !='')" ).append("\n"); 
		query.append("AND  E.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_r_cmdt} !='')" ).append("\n"); 
		query.append("AND  C.REP_CMDT_CD = @[f_r_cmdt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_usa_mode} !='')" ).append("\n"); 
		query.append("AND  C.USA_BKG_MOD_CD = @[f_usa_mode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_por} !='')" ).append("\n"); 
		query.append("AND  C.BKG_POR_CD = @[f_por]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_del} !='')" ).append("\n"); 
		query.append("AND  C.BKG_DEL_CD = @[f_del]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pol} !='')" ).append("\n"); 
		query.append("AND  C.REV_POL_CD = @[f_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pod} !='')" ).append("\n"); 
		query.append("AND  C.REV_POD_CD = @[f_pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("AND  C.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("AND  C.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ITM2' ITEM" ).append("\n"); 
		query.append("#if($allcols.size() > 0)" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",DECODE(CNTR_TPSZ_CD, '$key', NVL(BKG_REV,0) + NVL(BKG_OFT_REV,0) + NVL(BKG_MISC_REV, 0), 0) ESTM_$key" ).append("\n"); 
		query.append(",0 REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(E.CNTR_TPSZ_CD, 'D2', NVL(E.BKG_REV,0) + NVL(E.BKG_OFT_REV,0) + NVL(E.BKG_MISC_REV, 0), 0) ESTM_D2" ).append("\n"); 
		query.append(",0 REPO_D2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM COA_BKG_REV_DTL E" ).append("\n"); 
		query.append(",COA_RGST_BKG C" ).append("\n"); 
		query.append(",COA_MON_VVD D" ).append("\n"); 
		query.append("WHERE C.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("AND C.TRD_CD = D.TRD_CD" ).append("\n"); 
		query.append("AND C.RLANE_CD = D.RLANE_CD" ).append("\n"); 
		query.append("AND C.IOC_CD = D.IOC_CD" ).append("\n"); 
		query.append("AND C.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.DIR_CD = D.DIR_CD" ).append("\n"); 
		query.append("/* Booking Info에 적용 (kevin.kim) */" ).append("\n"); 
		query.append("AND C.BL_NO_TP IN ('M','0')" ).append("\n"); 
		query.append("AND C.BKG_STS_CD IN ('F','S')" ).append("\n"); 
		query.append("AND C.BKG_CGO_TP_CD NOT IN ( 'P')" ).append("\n"); 
		query.append("AND D.DELT_FLG NOT IN ( 'Y')" ).append("\n"); 
		query.append("AND E.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#if($allcols.size() > 0)" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("#if($velocityCount < $allcols.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'D2'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_cost_yrmon} !='')" ).append("\n"); 
		query.append("AND  D.COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_cntr_tpsz_cd} !='')" ).append("\n"); 
		query.append("AND  E.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_r_cmdt} !='')" ).append("\n"); 
		query.append("AND  C.REP_CMDT_CD = @[f_r_cmdt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_usa_mode} !='')" ).append("\n"); 
		query.append("AND  C.USA_BKG_MOD_CD = @[f_usa_mode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_por} !='')" ).append("\n"); 
		query.append("AND  C.BKG_POR_CD = @[f_por]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_del} !='')" ).append("\n"); 
		query.append("AND  C.BKG_DEL_CD = @[f_del]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pol} !='')" ).append("\n"); 
		query.append("AND  C.REV_POL_CD = @[f_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pod} !='')" ).append("\n"); 
		query.append("AND  C.REV_POD_CD = @[f_pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("AND  C.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("AND  C.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT M.SGRP_COST_CD ITEM" ).append("\n"); 
		query.append("#if($allcols.size() > 0)" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append(",DECODE(G.CNTR_TPSZ_CD, '$key', SUM(NVL(G.ESTM_USD_TTL_AMT, 0))) ESTM_$key" ).append("\n"); 
		query.append(",DECODE(G.CNTR_TPSZ_CD, '$key', SUM(NVL(H.REPO_COST_AMT, 0))) REPO_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",DECODE(H.CNTR_TPSZ_CD, 'D2', SUM(NVL(H.ESTM_USD_TTL_AMT, 0))) ESTM_D2" ).append("\n"); 
		query.append(",DECODE(H.CNTR_TPSZ_CD, 'D2', SUM(NVL(H.REPO_COST_AMT, 0))) REPO_D2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM COA_BKG_COST_SMRY G" ).append("\n"); 
		query.append(",COA_CNTR_REPO_IDX_ITM H" ).append("\n"); 
		query.append(",COA_STND_ACCT_V K" ).append("\n"); 
		query.append(",COA_SUB_GRP_COST M" ).append("\n"); 
		query.append(",COA_RGST_BKG C" ).append("\n"); 
		query.append(",COA_MON_VVD D" ).append("\n"); 
		query.append("WHERE G.BKG_NO(+) = H.BKG_NO" ).append("\n"); 
		query.append("AND G.CNTR_TPSZ_CD(+) = H.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND G.STND_COST_CD(+) = H.STND_COST_CD" ).append("\n"); 
		query.append("AND G.COST_ROUT_NO(+) = H.COST_ROUT_NO" ).append("\n"); 
		query.append("AND H.STND_COST_CD = K.STND_COST_CD" ).append("\n"); 
		query.append("AND K.COA_COST_SRC_PRT_CD IN('PA','CO')" ).append("\n"); 
		query.append("AND K.STND_COST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND NVL(G.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND K.SGRP_COST_CD = M.SGRP_COST_CD(+)" ).append("\n"); 
		query.append("AND C.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("AND C.TRD_CD = D.TRD_CD" ).append("\n"); 
		query.append("AND C.RLANE_CD = D.RLANE_CD" ).append("\n"); 
		query.append("AND C.IOC_CD = D.IOC_CD" ).append("\n"); 
		query.append("AND C.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.DIR_CD = D.DIR_CD" ).append("\n"); 
		query.append("/* Booking Info에 적용 (kevin.kim) */" ).append("\n"); 
		query.append("AND C.BL_NO_TP IN ('M','0')" ).append("\n"); 
		query.append("AND C.BKG_STS_CD IN ('F','S')" ).append("\n"); 
		query.append("AND C.BKG_CGO_TP_CD NOT IN ('P')" ).append("\n"); 
		query.append("AND D.DELT_FLG NOT IN ('Y')" ).append("\n"); 
		query.append("AND D.WKY_TGT_FLG='Y' /* 임시 */" ).append("\n"); 
		query.append("AND H.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#if($allcols.size() > 0)" ).append("\n"); 
		query.append("#foreach($key in ${allcols})" ).append("\n"); 
		query.append("#if($velocityCount < $allcols.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'D2'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_cost_yrmon} !='')" ).append("\n"); 
		query.append("AND  D.COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_cntr_tpsz_cd} !='')" ).append("\n"); 
		query.append("AND  H.CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_r_cmdt} !='')" ).append("\n"); 
		query.append("AND  C.REP_CMDT_CD = @[f_r_cmdt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_usa_mode} !='')" ).append("\n"); 
		query.append("AND  C.USA_BKG_MOD_CD = @[f_usa_mode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_por} !='')" ).append("\n"); 
		query.append("AND  C.BKG_POR_CD = @[f_por]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_del} !='')" ).append("\n"); 
		query.append("AND  C.BKG_DEL_CD = @[f_del]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pol} !='')" ).append("\n"); 
		query.append("AND  C.REV_POL_CD = @[f_pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_pod} !='')" ).append("\n"); 
		query.append("AND  C.REV_POD_CD = @[f_pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} !='')" ).append("\n"); 
		query.append("AND  C.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} !='')" ).append("\n"); 
		query.append("AND  C.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY M.SGRP_COST_CD, G.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("( SELECT 1 NO,'ITM1' ITEM, 'Load(TEU or BOX)' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2 NO,'ITM2' ITEM, 'Gross Revenue' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 3 NO,'CVFS' ITEM, 'Full Stevedorage' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 4 NO,'CVIP' ITEM, 'Full_Internal Pricing' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 5 NO,'CVTR' ITEM, 'Full Trans' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 6 NO,'CVES' ITEM, 'Empty Stevedorage' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 7 NO,'CVET' ITEM, 'Empty Trans' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 8 NO,'CVAC' ITEM, 'Agency Commission' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 9 NO,'EQCF' ITEM, 'CNTR Fixed Cost' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 10 NO,'EQSF' ITEM, 'CHSS Fixed Cost' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 11 NO,'BUAC' ITEM, 'Business Activity Cost' ITEM_NM FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.ITEM(+) = B.ITEM" ).append("\n"); 
		query.append("GROUP BY B.NO, B.ITEM, B.ITEM_NM" ).append("\n"); 
		query.append("ORDER BY B.NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}