/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetOusTdrUsedSlotRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.03.18 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOGetOusTdrUsedSlotRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OUS TDR에서 VVD, FM_PORT선택시 USED SLOT 정보를 가져온다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetOusTdrUsedSlotRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetOusTdrUsedSlotRSQL").append("\n"); 
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
		query.append("WITH JO_CRR AS (" ).append("\n"); 
		query.append("  SELECT B.JO_CRR_CD" ).append("\n"); 
		query.append("  FROM   JOO_STL_VVD A," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("         SELECT DECODE(@[re_divr_cd], 'E', COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC, @[jo_crr_cd]) AS JO_CRR_CD, TO_DATE('99991231','YYYYMMDD') AS EFF_ETA_DT" ).append("\n"); 
		query.append("         FROM   DUAL" ).append("\n"); 
		query.append("         UNION  ALL" ).append("\n"); 
		query.append("         SELECT JO_N2ND_CRR_CD AS JO_CRR_CD, EFF_ETA_DT" ).append("\n"); 
		query.append("         FROM   JOO_CRR_MRG A" ).append("\n"); 
		query.append("         WHERE  A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("         AND    A.ACCTG_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("         AND    A.JO_N1ST_CRR_CD = DECODE(@[re_divr_cd], 'E',COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC, @[jo_crr_cd])" ).append("\n"); 
		query.append("         AND    A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("         AND    A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("  WHERE  A.BZC_PORT_ETA_DT <= B.EFF_ETA_DT" ).append("\n"); 
		query.append("  AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("  AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("  AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("  AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("  AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("  AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("  AND    A.JO_MNU_NM    IN ('RDR','TDR')" ).append("\n"); 
		query.append("  AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("  AND    A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("  AND    A.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND    A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND    A.REV_DIR_CD    = @[rev_dir_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUM(DECODE(FLG,'1', TEU, 0)) AS USD_SLT_BSA_QTY," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'1', WGT, 0)) AS USD_SLT_WGT," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'2', TEU, 0)) AS FNL_OWN_BSA_QTY," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'2', WGT, 0)) AS FNL_BSA_WGT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT  '1' AS FLG," ).append("\n"); 
		query.append("               SUM(DECODE(C.STATUS,'SM',DECODE(C.CNTR_TYPE,'F',C.QTY,'E',C.QTY,'A',C.QTY,0),0))" ).append("\n"); 
		query.append("               +  SUM(DECODE(C.STATUS,'SI',DECODE(C.CNTR_TYPE,'F',C.QTY,'E',C.QTY,'A',C.QTY,0),0)) AS TEU" ).append("\n"); 
		query.append("             , SUM(DECODE(C.STATUS,'SM',DECODE(C.CNTR_TYPE,'F',C.WEIGHT,'E',C.WEIGHT,'A',C.WEIGHT,0),0))" ).append("\n"); 
		query.append("               +  SUM(DECODE(C.STATUS,'SI',DECODE(C.CNTR_TYPE,'F',C.WEIGHT,'E',C.WEIGHT,'A',C.WEIGHT,0),0)) AS WGT" ).append("\n"); 
		query.append("         FROM TDR_HEADER H, TDR_UTILIZE C" ).append("\n"); 
		query.append("        WHERE H.VSL_CD   = C.VSL_CD" ).append("\n"); 
		query.append("          AND H.VOY_NO   = C.VOY_NO" ).append("\n"); 
		query.append("          AND H.DIR_CD   = C.DIR_CD" ).append("\n"); 
		query.append("          AND H.PORT_CD  = C.PORT_CD" ).append("\n"); 
		query.append("          AND H.CALL_IND = C.CALL_IND  " ).append("\n"); 
		query.append("          AND C.STATUS  IN ('SI','SM')        " ).append("\n"); 
		query.append("          AND C.OPR_CD  IN (SELECT JO_CRR_CD FROM JO_CRR)" ).append("\n"); 
		query.append("          AND H.VSL_CD    = @[vsl_cd]" ).append("\n"); 
		query.append("          AND H.VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND H.DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND H.PORT_CD   = @[fm_port_cd]" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        UNION ALL  " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       SELECT                                                                                                                 " ).append("\n"); 
		query.append("              '2' AS FLG, " ).append("\n"); 
		query.append("              NVL(SUM(A.BSA_SLOT),0) + NVL(SUM(A.SWAP_SLOT),0) AS FNL_OWN_BSA_QTY,                                     " ).append("\n"); 
		query.append("              NVL(SUM(A.BSA_WGT),0)  + NVL(SUM(A.SWAP_WGT),0)  AS FNL_BSA_WGT                                          " ).append("\n"); 
		query.append("         FROM TDR_HEADER H, TDR_ALLOCATION A                                                                           " ).append("\n"); 
		query.append("       WHERE  H.VSL_CD    = A.VSL_CD                                                                                   " ).append("\n"); 
		query.append("          AND H.VOY_NO    = A.VOY_NO                                                                                   " ).append("\n"); 
		query.append("          AND H.DIR_CD    = A.DIR_CD                                                                                   " ).append("\n"); 
		query.append("          AND H.PORT_CD   = A.PORT_CD                                                                                  " ).append("\n"); 
		query.append("          AND H.CALL_IND  = A.CALL_IND                                                                                 " ).append("\n"); 
		query.append("          AND A.OPR_CD IN (SELECT JO_CRR_CD FROM JO_CRR)" ).append("\n"); 
		query.append("          AND H.VSL_CD    = @[vsl_cd]" ).append("\n"); 
		query.append("          AND H.VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND H.DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND H.PORT_CD   = @[fm_port_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}