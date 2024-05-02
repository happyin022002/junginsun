/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnCommTrspCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnCommTrspCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmAgnCommTrsp
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnCommTrspCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdrg_ddct_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdrg_ddct_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_ddct_dest_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_ddct_org_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnCommTrspCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_TRSP" ).append("\n"); 
		query.append("(BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD, AC_SEQ, AC_TRSP_SEQ, TRSP_MOD_CD, TRSP_DDCT_CD, FM_LOC_CD, TO_LOC_CD, TRSP_DDCT_AMT, TRSP_LVL, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      A.BKG_NO    AS BKG_NO " ).append("\n"); 
		query.append("    , @[agn_cd]    AS AGN_CD " ).append("\n"); 
		query.append("    , @[io_bnd_cd] AS IO_BND_CD " ).append("\n"); 
		query.append("    , @[ac_tp_cd]  AS AC_TP_CD " ).append("\n"); 
		query.append("    , @[max_ac_seq]  AS AC_SEQ " ).append("\n"); 
		query.append("    , ROW_NUMBER() OVER ( PARTITION BY A.BKG_NO ORDER BY SUBSTR (A.NOD_CD, 1, 5),SUBSTR (A.TO_NOD_CD, 1, 5) ) AS AC_TRSP_SEQ" ).append("\n"); 
		query.append("    , DECODE (A.ROUT_TZ_MOD_CD, 'WD', 'F', 'H')  AS TRSP_MOD_CD" ).append("\n"); 
		query.append("    , A.COA_COST_SRC_CD AS TRSP_DDCT_CD " ).append("\n"); 
		query.append("    , SUBSTR (A.NOD_CD, 1, 5) FM_LOC_CD " ).append("\n"); 
		query.append("    , SUBSTR (A.TO_NOD_CD, 1, 5) TO_LOC_CD " ).append("\n"); 
		query.append("--                        , ROUND(NVL(SUM (A.CNTR_QTY * A.ESTM_USD_UC_AMT) ,0),2) AS TRSP_DDCT_AMT  --> 이거 바꾼 샘플 : AAR200100200, GOA104274500" ).append("\n"); 
		query.append("    , NVL(A.CNTR_QTY,0) * NVL(A.ESTM_USD_UC_AMT ,0) AS TRSP_DDCT_AMT" ).append("\n"); 
		query.append("    , DECODE(A.N3RD_NOD_CD,'','N','Y') AS TRSP_LVL" ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , SYSDATE UPD_DT " ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , SYSDATE CRE_DT  " ).append("\n"); 
		query.append("FROM COA_BKG_COST_SRC_DTL A, " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT BND, LOC" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT 'O' BND, SUBSTR(FULL_PKUP_YD_CD,1,5) AS LOC FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]  UNION ALL " ).append("\n"); 
		query.append("        SELECT 'O',     SUBSTR(POR_CD,1,5)                 FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]  UNION ALL " ).append("\n"); 
		query.append("        SELECT 'O',     SUBSTR(POL_CD,1,5)                 FROM BKG_VVD     WHERE BKG_NO = @[bkg_no]  AND VSL_PRE_PST_CD IN ('S','T') UNION ALL " ).append("\n"); 
		query.append("        SELECT 'I',     SUBSTR(DEL_CD,1,5)                 FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]  UNION ALL " ).append("\n"); 
		query.append("        SELECT 'I',     SUBSTR(MTY_RTN_YD_CD,1,5)          FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]  UNION ALL " ).append("\n"); 
		query.append("        SELECT 'I',     SUBSTR(POD_CD,1,5)                 FROM BKG_VVD     WHERE BKG_NO = @[bkg_no]  AND VSL_PRE_PST_CD IN ('T','U') " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY BND, LOC" ).append("\n"); 
		query.append(")B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("AND A.STND_COST_CD IN (SELECT STND_COST_CD FROM COA_STND_ACCT_V WHERE SGRP_COST_CD = 'CVTR' AND COA_COST_SRC_PRT_CD = 'CO'  ) --AND A.stnd_cost_cd in('51301011','51301021','51301031','51301041','51301051','51301061','51301081') " ).append("\n"); 
		query.append("AND B.LOC IN (SUBSTR (NOD_CD, 1, 5) , SUBSTR (TO_NOD_CD, 1, 5), SUBSTR (N2ND_NOD_CD, 1, 5), SUBSTR (N3RD_NOD_CD, 1, 5) ) " ).append("\n"); 
		query.append("AND A.ESTM_USD_UC_AMT <> 0" ).append("\n"); 
		query.append("AND B.BND IN (" ).append("\n"); 
		query.append("              DECODE( @[hlg_ddct_org_flg]  ,'Y','O','X')" ).append("\n"); 
		query.append("             ,DECODE( @[hlg_ddct_dest_flg] ,'Y','I','X')" ).append("\n"); 
		query.append("             ,DECODE( @[fdrg_ddct_org_flg] ,'Y','O','X')" ).append("\n"); 
		query.append("             ,DECODE( @[fdrg_ddct_dest_flg],'Y','I','X')" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("AND DECODE (A.ROUT_TZ_MOD_CD, 'WD', 'F', 'H') IN " ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("              DECODE( @[hlg_ddct_org_flg]  ,'Y','H','X')" ).append("\n"); 
		query.append("             ,DECODE( @[hlg_ddct_dest_flg] ,'Y','H','X')" ).append("\n"); 
		query.append("             ,DECODE( @[fdrg_ddct_org_flg] ,'Y','F','X')" ).append("\n"); 
		query.append("             ,DECODE( @[fdrg_ddct_dest_flg],'Y','F','X')" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("GROUP BY A.BKG_NO, A.COA_COST_SRC_CD  , DECODE (A.ROUT_TZ_MOD_CD, 'WD', 'F', 'H'), SUBSTR (A.NOD_CD, 1, 5)  , SUBSTR (A.TO_NOD_CD, 1, 5)  , NVL(A.CNTR_QTY,0) , NVL(A.ESTM_USD_UC_AMT,0), DECODE(A.N3RD_NOD_CD,'','N','Y'), DECODE(A.N3RD_NOD_CD,'','N','Y')" ).append("\n"); 

	}
}