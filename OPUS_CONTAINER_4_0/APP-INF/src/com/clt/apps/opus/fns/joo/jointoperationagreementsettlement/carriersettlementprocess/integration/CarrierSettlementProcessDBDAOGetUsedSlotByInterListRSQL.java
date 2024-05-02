/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetUsedSlotByInterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOGetUsedSlotByInterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inter Used Slot Search
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetUsedSlotByInterListRSQL(){
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
		params.put("uc_bss_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetUsedSlotByInterListRSQL").append("\n"); 
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
		query.append("WITH CRR_MST AS (" ).append("\n"); 
		query.append("  SELECT B.JO_CRR_CD" ).append("\n"); 
		query.append("    FROM JOO_STL_VVD A," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("  		   SELECT DECODE(@[re_divr_cd], 'E', COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC, @[jo_crr_cd]) AS JO_CRR_CD, TO_DATE('99991231','YYYYMMDD') AS EFF_ETA_DT" ).append("\n"); 
		query.append("  		     FROM DUAL" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  		   UNION  ALL" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  		   SELECT JO_N2ND_CRR_CD AS JO_CRR_CD, EFF_ETA_DT" ).append("\n"); 
		query.append("  		     FROM JOO_CRR_MRG A" ).append("\n"); 
		query.append("  		    WHERE A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("  		      AND A.ACCTG_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("  		      AND A.JO_N1ST_CRR_CD = DECODE(@[re_divr_cd], 'E', COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC, @[jo_crr_cd])" ).append("\n"); 
		query.append("  		      AND A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("  		      AND A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("   WHERE A.BZC_PORT_ETA_DT <= B.EFF_ETA_DT" ).append("\n"); 
		query.append("     AND A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("     AND A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("     AND A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("     AND A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("     AND A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("     AND A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("     AND A.JO_MNU_NM    IN ('RDR','TDR')" ).append("\n"); 
		query.append("     AND A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("     AND A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("     AND A.REV_DIR_CD    = @[rev_dir_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SM.VSL_CD" ).append("\n"); 
		query.append("     , SM.SKD_VOY_NO" ).append("\n"); 
		query.append("     , SM.SKD_DIR_CD" ).append("\n"); 
		query.append("     , SM.IOC_CD" ).append("\n"); 
		query.append("     , SM.DEP_PORT_CD" ).append("\n"); 
		query.append("     , SM.FM_PORT_CD" ).append("\n"); 
		query.append("     , SM.TO_PORT_CD" ).append("\n"); 
		query.append("     , SM.FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("     , SM.FNL_BSA_WGT" ).append("\n"); 
		query.append("     , SM.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("     , SM.USD_SLT_WGT" ).append("\n"); 
		query.append("     , SM.TEU_WGT" ).append("\n"); 
		query.append("     , CASE WHEN SM.BSA_SLT_PRC1 > 0 THEN SM.BSA_SLT_PRC1" ).append("\n"); 
		query.append("            ELSE SM.BSA_SLT_PRC2" ).append("\n"); 
		query.append("       END AS BSA_SLT_PRC" ).append("\n"); 
		query.append("  FROM (SELECT SM.VSL_CD" ).append("\n"); 
		query.append("             , SM.VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , SM.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , SM.REGION AS IOC_CD" ).append("\n"); 
		query.append("             , NULL AS DEP_PORT_CD" ).append("\n"); 
		query.append("             , SM.PORT_CD AS FM_PORT_CD" ).append("\n"); 
		query.append("             , SM.TO_PORT AS TO_PORT_CD" ).append("\n"); 
		query.append("             , SM.BSA_SLT AS FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("             , SM.BSA_WGT AS FNL_BSA_WGT" ).append("\n"); 
		query.append("             , (SM.USD_SLT_FULL + SM.USD_SLT_MTY + SM.ADD_SLT_VOID + SM.ADD_SLT_45 + SM.ADD_SLT_HC) AS USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("             , (SM.USD_WGT_FULL + SM.USD_WGT_MTY) AS USD_SLT_WGT" ).append("\n"); 
		query.append("             , SM.TEU_WGT" ).append("\n"); 
		query.append("             , NVL((SELECT MAX(CD.UC_AMT) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("                          FROM BSA_OVR_USD_MST CM" ).append("\n"); 
		query.append("                             , BSA_OVR_USD_SLT_PRC CD" ).append("\n"); 
		query.append("                         WHERE CM.OVR_USD_SLT_PRC_SEQ = CD.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append("                           AND CD.UC_AMT <> 0" ).append("\n"); 
		query.append("                           AND CM.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND CM.TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("                           AND CM.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("						   #if (${re_divr_cd} == 'R')" ).append("\n"); 
		query.append("                           AND CD.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("						   AND CM.DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                           AND SUBSTR(REPLACE(@[uc_bss_port_etd_dt],'-'),1,8) BETWEEN CM.BSA_SLT_PRC_FM_DT AND CM.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("                           AND CM.FM_PORT_CD = SM.PORT_CD" ).append("\n"); 
		query.append("                           AND CM.TO_PORT_CD = SM.TO_PORT), 0) AS BSA_SLT_PRC1" ).append("\n"); 
		query.append("             , NVL((SELECT SUM(CP.UC_AMT) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("                          FROM BSA_OCN_OVR_SLT_PRC CP" ).append("\n"); 
		query.append("                             , BSA_OCN_OVR_MST CM" ).append("\n"); 
		query.append("                         WHERE CM.BSA_SLT_COST_TP_CD = CP.BSA_SLT_COST_TP_CD" ).append("\n"); 
		query.append("                           AND CM.OVR_USD_SLT_PRC_SEQ = CP.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append("                           AND CM.TRD_CD = CP.TRD_CD" ).append("\n"); 
		query.append("                           AND CM.RLANE_CD = CP.RLANE_CD" ).append("\n"); 
		query.append("                           AND CM.DIR_CD = CP.DIR_CD" ).append("\n"); 
		query.append("                           AND CM.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND CP.TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("                           AND CP.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("						   AND CP.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("                           AND CP.DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                           AND CP.BSA_SLT_COST_TP_CD = '021' /*Shot Leg 코드값.*/" ).append("\n"); 
		query.append("                           AND SUBSTR(REPLACE(@[uc_bss_port_etd_dt],'-'),1,8) BETWEEN CM.BSA_SLT_PRC_FM_DT AND CM.BSA_SLT_PRC_TO_DT ), 0) AS BSA_SLT_PRC2" ).append("\n"); 
		query.append("          FROM RDR_IPC_SMRY SM" ).append("\n"); 
		query.append("         WHERE SM.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SM.VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SM.DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND SM.REGION = @[sconti_cd]" ).append("\n"); 
		query.append("           AND SM.OPR_CD IN (SELECT JO_CRR_CD FROM CRR_MST) " ).append("\n"); 
		query.append("        ) SM" ).append("\n"); 

	}
}