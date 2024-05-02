/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOAddCopDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.09 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOAddCopDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP Detail 정보를 insert 한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOAddCopDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOAddCopDtlCSQL").append("\n"); 
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
		query.append("--=================SCE_COP_DTL 생성 관련 ===========================" ).append("\n"); 
		query.append("INSERT INTO SCE_COP_DTL (" ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COP_DTL_SEQ," ).append("\n"); 
		query.append("ACT_CD," ).append("\n"); 
		query.append("PLN_DT," ).append("\n"); 
		query.append("ESTM_DT," ).append("\n"); 
		query.append("ACT_DT," ).append("\n"); 
		query.append("NOD_CD," ).append("\n"); 
		query.append("ACT_STS_CD," ).append("\n"); 
		query.append("ACT_RCV_TP_CD," ).append("\n"); 
		query.append("EDI_SND_TP_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("ESTM_GDT," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("STND_EDI_STS_CD," ).append("\n"); 
		query.append("EDI_ACT_SND_DT," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("COP_EXPT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[cop_no]," ).append("\n"); 
		query.append("CASE WHEN TEMP.BND_CD = 'O' AND LENGTH(ORD_SEQ) = 1 THEN '10'" ).append("\n"); 
		query.append("WHEN TEMP.BND_CD = 'O' AND LENGTH(ORD_SEQ) = 2 THEN '1'" ).append("\n"); 
		query.append("WHEN TEMP.BND_CD = 'T' AND LENGTH(ORD_SEQ) = 1 THEN '40'" ).append("\n"); 
		query.append("WHEN TEMP.BND_CD = 'T' AND LENGTH(ORD_SEQ) = 2 THEN '4'" ).append("\n"); 
		query.append("WHEN TEMP.BND_CD = 'I' AND LENGTH(ORD_SEQ) = 1 THEN '60'" ).append("\n"); 
		query.append("WHEN TEMP.BND_CD = 'I' AND LENGTH(ORD_SEQ) = 2 THEN '6'" ).append("\n"); 
		query.append("END || ord_seq || act_grp_seq AS COP_DTL_SEQ" ).append("\n"); 
		query.append(",ACT_CD" ).append("\n"); 
		query.append(",CASE WHEN TEMP.BND_CD ='T' THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='A' AND SKD.VPS_ETA_DT IS NOT NULL THEN SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='B' AND SKD.VPS_ETB_DT IS NOT NULL THEN SKD.VPS_ETB_DT" ).append("\n"); 
		query.append("WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='D' AND SKD.VPS_ETD_DT IS NOT NULL THEN SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("ELSE TEMP.PLNTIME" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE TEMP.PLNTIME" ).append("\n"); 
		query.append("END           PLN_DT" ).append("\n"); 
		query.append(",CASE WHEN TEMP.BND_CD ='T' THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='A' AND SKD.VPS_ETA_DT IS NOT NULL THEN SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='B' AND SKD.VPS_ETB_DT IS NOT NULL THEN SKD.VPS_ETB_DT" ).append("\n"); 
		query.append("WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='D' AND SKD.VPS_ETD_DT IS NOT NULL THEN SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("ELSE TEMP.PLNTIME" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE TEMP.PLNTIME" ).append("\n"); 
		query.append("END           ESTM_DT" ).append("\n"); 
		query.append(", '' AS ACT_DT" ).append("\n"); 
		query.append(", NOD_CD" ).append("\n"); 
		query.append(", CASE WHEN lag(act_cd) over (order by  ORD_SEQ, TEMP.ACT_GRP_SEQ) is null THEN 'C' ELSE 'N' END AS ACT_STS_CD" ).append("\n"); 
		query.append(", '' ACT_RCV_TP_CD" ).append("\n"); 
		query.append(",'' EDI_SND_TP_CD" ).append("\n"); 
		query.append(", TEMP.VSL_CD" ).append("\n"); 
		query.append(", TEMP.SKD_VOY_NO" ).append("\n"); 
		query.append(", TEMP.SKD_DIR_CD" ).append("\n"); 
		query.append(", TEMP.CLPT_IND_SEQ" ).append("\n"); 
		query.append(", TEMP.VPS_PORT_CD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(TEMP.NOD_CD,1,5)," ).append("\n"); 
		query.append("CASE WHEN TEMP.BND_CD ='T' THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='A' AND SKD.VPS_ETA_DT IS NOT NULL THEN SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='B' AND SKD.VPS_ETB_DT IS NOT NULL THEN SKD.VPS_ETB_DT" ).append("\n"); 
		query.append("WHEN SUBSTR ( TEMP.ACT_CD, 5, 1) ='D' AND SKD.VPS_ETD_DT IS NOT NULL THEN SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("ELSE TEMP.PLNTIME" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE TEMP.PLNTIME" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(", 'GMT') AS ESTM_GDT" ).append("\n"); 
		query.append(",'' VNDR_SEQ" ).append("\n"); 
		query.append(",'' EDI_MSG_TP_CD" ).append("\n"); 
		query.append(", '' ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(", ACT_STND_EDI_STS_CD AS STND_EDI_STS_CD" ).append("\n"); 
		query.append(", '' EDI_ACT_SND_DT" ).append("\n"); 
		query.append(", '' ACT_DAT_RCV_DT" ).append("\n"); 
		query.append(",'N' COP_EXPT_FLG" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TMP.ORD_SEQ,  MAPG.COP_DTL_GRP_CD," ).append("\n"); 
		query.append("CASE WHEN MDM.COP_SKD_LGC_NO IS NOT NULL THEN sce_cop_skd_lgc_cal_fnc(SKDLGC.cop_foml_cd,TMP.tz_dwll_tm_hrs,TMP.ARR_ST_DT,TMP.DEP_FSH_DT,SKDLGC.foml_pct_no,SKDLGC.foml_tm_hrs)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'D' THEN ARR_ST_dT" ).append("\n"); 
		query.append("WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'O' THEN DEP_FSH_DT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END PLNTIME" ).append("\n"); 
		query.append(", MAPG.ACT_CD" ).append("\n"); 
		query.append(", ARR_ST_dT,DEP_FSH_DT, TMP.TZ_DWLL_TM_HRS" ).append("\n"); 
		query.append(", TMP.PCTL_IO_BND_CD" ).append("\n"); 
		query.append(", CASE WHEN SUBSTR( MAPG.ACT_CD, 6, 1) = 'D' AND SUBSTR(MAPG.ACT_CD, 2, 1) || SUBSTR(MAPG.ACT_CD, 5, 1) NOT IN ('UU') THEN BEF_BND_CD" ).append("\n"); 
		query.append("WHEN SUBSTR( MAPG.ACT_CD, 6, 1) = 'D' AND SUBSTR(MAPG.ACT_CD, 2, 1) || SUBSTR(MAPG.ACT_CD, 5, 1) IN ('UU') THEN AFT_BND_CD" ).append("\n"); 
		query.append("WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'O' AND SUBSTR(MAPG.ACT_CD, 2, 1) || SUBSTR(MAPG.ACT_CD, 5, 1) IN ('LL') THEN BEF_BND_CD" ).append("\n"); 
		query.append("WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'O' AND SUBSTR(MAPG.ACT_CD, 2, 1) || SUBSTR(MAPG.ACT_CD, 5, 1) NOT IN ('LL') THEN AFT_BND_CD" ).append("\n"); 
		query.append("END BND_CD" ).append("\n"); 
		query.append(", MDM.ACT_STND_EDI_STS_CD" ).append("\n"); 
		query.append(", CASE WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'D' THEN BEF_VSL_CD" ).append("\n"); 
		query.append("WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'O' THEN AFT_VSL_CD" ).append("\n"); 
		query.append("END VSL_CD" ).append("\n"); 
		query.append(", CASE WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'D' THEN BEF_SKD_VOY_NO" ).append("\n"); 
		query.append("WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'O' THEN AFT_SKD_VOY_NO" ).append("\n"); 
		query.append("END SKD_VOY_NO" ).append("\n"); 
		query.append(", CASE WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'D' THEN BEF_SKD_DIR_CD" ).append("\n"); 
		query.append("WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'O' THEN AFT_SKD_DIR_CD" ).append("\n"); 
		query.append("END SKD_DIR_CD" ).append("\n"); 
		query.append(", CASE WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'D' THEN DEST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("WHEN SUBSTR( MAPG.ACT_CD, 6,1) = 'O' THEN ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("END CLPT_IND_SEQ" ).append("\n"); 
		query.append(", SUBSTR(TMP.NOD_CD,1,5) VPS_PORT_CD" ).append("\n"); 
		query.append(", MAPG.ACT_GRP_SEQ" ).append("\n"); 
		query.append(", TMP.NOD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DTL.ORG_NOD_TP_CD, PCTL_SEQ AS ORD_SEQ" ).append("\n"); 
		query.append(",CASE WHEN DTL.PCTL_IO_BND_CD ='O' AND MST.BKG_RCV_TERM_CD ='S'THEN MST.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("WHEN DTL.PCTL_IO_BND_CD ='I' AND  MST.BKG_DE_TERM_CD ='S'THEN MST.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("ELSE '*'" ).append("\n"); 
		query.append("END BKG_TERM_CD ,CASE WHEN DTL.PCTL_IO_BND_CD ='O' AND MST.BKG_RCV_TERM_CD ='S' AND LAG( DTL.TRSP_MOD_CD, 3, 'X' ) OVER (PARTITION BY DTL.PCTL_NO ORDER  BY DTL.PCTL_SEQ) ='X' THEN 'X' WHEN DTL.PCTL_IO_BND_CD ='I' AND MST.BKG_DE_TERM_CD ='S' AND LEAD( DTL.TRSP_MOD_CD, 1, 'X' ) OVER (PARTITION BY DTL.PCTL_NO ORDER  BY DTL.PCTL_SEQ) ='X' THEN 'X' ELSE    LAG( DTL.TRSP_MOD_CD, 1, 'X' ) OVER (PARTITION BY DTL.PCTL_NO ORDER  BY DTL.PCTL_SEQ)" ).append("\n"); 
		query.append("END BEF_TRNS_MOD" ).append("\n"); 
		query.append(",CASE WHEN DTL.PCTL_IO_BND_CD ='O' AND MST.BKG_RCV_TERM_CD ='S' AND LAG( DTL.TRSP_MOD_CD, 1, 'X' ) OVER (PARTITION BY DTL.PCTL_NO ORDER  BY DTL.PCTL_SEQ) ='X' THEN 'X' WHEN DTL.PCTL_IO_BND_CD ='I' AND MST.BKG_DE_TERM_CD ='S' AND LEAD( DTL.TRSP_MOD_CD, 3, 'X' ) OVER (PARTITION BY DTL.PCTL_NO ORDER  BY DTL.PCTL_SEQ) ='X' THEN 'X' ELSE   LEAD( DTL.TRSP_MOD_CD, 1, 'X' ) OVER (PARTITION BY DTL.PCTL_NO ORDER  BY DTL.PCTL_SEQ)" ).append("\n"); 
		query.append("END AFT_TRNS_MOD" ).append("\n"); 
		query.append(",CASE WHEN MST.pol_cd = substr( DTL.ORG_NOD_CD,1,5) AND ( LEAD( DTL.PCTL_IO_BND_CD, 1, 'O' ) OVER (PARTITION BY DTL.PCTL_NO ORDER  BY DTL.PCTL_SEQ)) = 'T' THEN 'POL'" ).append("\n"); 
		query.append("WHEN MST.pod_cd = substr( DTL.ORG_NOD_CD,1,5)  AND ( LAG( DTL.PCTL_IO_BND_CD, 1, 'O' ) OVER (PARTITION BY DTL.PCTL_NO ORDER  BY DTL.PCTL_SEQ)) = 'T' THEN 'POD'" ).append("\n"); 
		query.append("ELSE 'NOD'" ).append("\n"); 
		query.append("END SPCL_NOD_TP_CD ,DTL.PCTL_SEQ" ).append("\n"); 
		query.append(",DTL.NOD_LNK_DIV_CD" ).append("\n"); 
		query.append(",LAG( DTL.PCTL_IO_BND_CD, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) BEF_BND_CD" ).append("\n"); 
		query.append(",LEAD( DTL.PCTL_IO_BND_CD, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) AFT_BND_CD" ).append("\n"); 
		query.append(",DTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append(",DTL.ARR_ST_dT" ).append("\n"); 
		query.append(",DTL.DEP_FSH_DT" ).append("\n"); 
		query.append(",DTL.TZ_DWLL_TM_HRS" ).append("\n"); 
		query.append(",LAG( DTL.VSL_CD, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) BEF_VSL_CD" ).append("\n"); 
		query.append(",LEAD( DTL.VSL_CD, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) AFT_VSL_CD" ).append("\n"); 
		query.append(",LAG( DTL.SKD_VOY_NO, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) BEF_SKD_VOY_NO" ).append("\n"); 
		query.append(",LEAD( DTL.SKD_VOY_NO, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) AFT_SKD_VOY_NO" ).append("\n"); 
		query.append(",LAG( DTL.SKD_DIR_CD, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) BEF_SKD_DIR_CD" ).append("\n"); 
		query.append(",LEAD( DTL.SKD_DIR_CD, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) AFT_SKD_DIR_CD" ).append("\n"); 
		query.append(",LAG( DTL.DEST_CLPT_IND_SEQ, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) DEST_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",LEAD( DTL.ORG_CLPT_IND_SEQ, 1) OVER ( PARTITION BY DTL.PCTL_NO ORDER BY DTL.PCTL_SEQ) ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",DTL.ORG_NOD_CD NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST MST, PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("WHERE MST.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND MST.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append(") TMP, SCE_ACT_GRP GRP, SCE_ACT_GRP_MAPG MAPG, MDM_ACTIVITY MDM , SCE_COP_SKD_LGC SKDLGC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TMP.ORG_NOD_TP_CD = DECODE(GRP.NOD_TP_CD ,'*',TMP.ORG_NOD_TP_CD,GRP.NOD_TP_CD )" ).append("\n"); 
		query.append("AND TMP.BKG_TERM_CD = DECODE(GRP.BFR_TRSP_MOD_CD||TRSP_BND_CD ,'XO',GRP.BKG_TERM_CD, DECODE(GRP.AFT_TRSP_MOD_CD||TRSP_BND_CD ,'XI',GRP.BKG_TERM_CD,TMP.BKG_TERM_CD ) )" ).append("\n"); 
		query.append("AND TMP.BEF_TRNS_MOD = GRP.BFR_TRSP_MOD_CD" ).append("\n"); 
		query.append("AND TMP.AFT_TRNS_MOD = GRP.AFT_TRSP_MOD_CD" ).append("\n"); 
		query.append("AND TMP.PCTL_IO_BND_CD = GRP.TRSP_BND_CD" ).append("\n"); 
		query.append("AND TMP.SPCL_NOD_TP_CD = GRP.SPCL_NOD_TP_CD" ).append("\n"); 
		query.append("AND GRP.COP_DTL_GRP_CD = MAPG.COP_DTL_GRP_CD" ).append("\n"); 
		query.append("AND SKDLGC.COP_SKD_LGC_NO (+) = MDM.COP_SKD_LGC_NO" ).append("\n"); 
		query.append("AND MAPG.ACT_CD = MDM.ACT_CD" ).append("\n"); 
		query.append(") TEMP , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SKD.VSL_CD (+)= TEMP.VSL_CD" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO (+)= TEMP.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD (+)= TEMP.SKD_DIR_CD" ).append("\n"); 
		query.append("AND SKD.CLPT_IND_SEQ (+)= TEMP.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND SKD.VPS_PORT_CD (+)= TEMP.VPS_PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY ORD_SEQ, TEMP.ACT_GRP_SEQ" ).append("\n"); 

	}
}