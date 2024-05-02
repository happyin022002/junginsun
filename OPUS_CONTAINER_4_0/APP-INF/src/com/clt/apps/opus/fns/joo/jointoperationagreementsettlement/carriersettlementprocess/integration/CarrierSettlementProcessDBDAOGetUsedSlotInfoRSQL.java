/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetUsedSlotInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25 
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

public class CarrierSettlementProcessDBDAOGetUsedSlotInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OUS RDR Rgeion 정보변경시 Used Slot 정보를 가져온다.
	  * [20150304] IO가 I 일때 기존 로직 AND H.PORT_CD = S.POL   (+) 주석처리함.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetUsedSlotInfoRSQL(){
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
		query.append("FileName : CarrierSettlementProcessDBDAOGetUsedSlotInfoRSQL").append("\n"); 
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
		query.append("#if (${ioc_cd} == 'O')" ).append("\n"); 
		query.append("SELECT PORT_CD AS FM_PORT_CD, " ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'1',TEU,0)) AS USD_SLT_BSA_QTY," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'1',WGT,0)) AS USD_SLT_WGT," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'2',TEU,0)) AS FNL_OWN_BSA_QTY," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'2',WGT,0)) AS FNL_BSA_WGT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT '1' AS FLG, H.PORT_CD, U.SLOT_QTY AS TEU, U.WEIGHT AS WGT" ).append("\n"); 
		query.append("         FROM  RDR_HEADER H, " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT VSL_CD, VOY_NO, DIR_CD, REGION, SLOT_QTY, WEIGHT" ).append("\n"); 
		query.append("                 FROM RDR_UTILIZE " ).append("\n"); 
		query.append("                WHERE OPR_CD IN (SELECT JO_CRR_CD FROM CRR_MST) " ).append("\n"); 
		query.append("                  AND TYPE <> 'R' /*2015.11.25 Reefer 제외.*/" ).append("\n"); 
		query.append("               ) U" ).append("\n"); 
		query.append("        WHERE  H.VSL_CD  = U.VSL_CD(+)" ).append("\n"); 
		query.append("          AND  H.VOY_NO  = U.VOY_NO(+)" ).append("\n"); 
		query.append("          AND  H.DIR_CD  = U.DIR_CD(+)" ).append("\n"); 
		query.append("          AND  H.REGION  = U.REGION(+)" ).append("\n"); 
		query.append("          AND  H.VSL_CD  = @[vsl_cd] " ).append("\n"); 
		query.append("          AND  H.VOY_NO  = @[skd_voy_no] " ).append("\n"); 
		query.append("          AND  H.DIR_CD  = @[skd_dir_cd] " ).append("\n"); 
		query.append("          AND  H.REGION  = @[sconti_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION  ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       SELECT '2' AS FLG, H.PORT_CD, A.BSA_SLOT AS TEU, A.BSA_WGT AS WGT" ).append("\n"); 
		query.append("         FROM  RDR_HEADER H, " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT VSL_CD, VOY_NO, DIR_CD, REGION, NVL(BSA_SLOT,0)+NVL(RELEASE_SLOT,0)+NVL(SWAP_SLOT,0) AS BSA_SLOT" ).append("\n"); 
		query.append("                    , NVL(BSA_WGT,0)+NVL(RELEASE_WGT,0)+NVL(SWAP_WGT,0) AS BSA_WGT" ).append("\n"); 
		query.append("                 FROM RDR_ALLOCATION" ).append("\n"); 
		query.append("                WHERE OPR_CD IN (SELECT JO_CRR_CD FROM CRR_MST) " ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("        WHERE  H.VSL_CD  = A.VSL_CD(+)" ).append("\n"); 
		query.append("          AND  H.VOY_NO  = A.VOY_NO(+)" ).append("\n"); 
		query.append("          AND  H.DIR_CD  = A.DIR_CD(+)" ).append("\n"); 
		query.append("          AND  H.REGION  = A.REGION(+)" ).append("\n"); 
		query.append("          AND  H.VSL_CD  = @[vsl_cd] " ).append("\n"); 
		query.append("          AND  H.VOY_NO  = @[skd_voy_no] " ).append("\n"); 
		query.append("          AND  H.DIR_CD  = @[skd_dir_cd] " ).append("\n"); 
		query.append("          AND  H.REGION  = @[sconti_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("GROUP BY PORT_CD" ).append("\n"); 
		query.append("#elseif (${ioc_cd} == 'I')" ).append("\n"); 
		query.append("SELECT PORT_CD AS FM_PORT_CD, " ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'1',TEU,0)) AS USD_SLT_BSA_QTY," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'1',WGT,0)) AS USD_SLT_WGT," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'2',TEU,0)) AS FNL_OWN_BSA_QTY," ).append("\n"); 
		query.append("       SUM(DECODE(FLG,'2',WGT,0)) AS FNL_BSA_WGT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT '1' AS FLG, H.PORT_CD, S.QTY AS TEU, S.WEIGHT AS WGT" ).append("\n"); 
		query.append("         FROM  RDR_HEADER  H," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT VSL_CD, VOY_NO, DIR_CD, REGION, POL, QTY, WEIGHT" ).append("\n"); 
		query.append("                 FROM RDR_SUMMARY" ).append("\n"); 
		query.append("                WHERE OPR_CD IN (SELECT JO_CRR_CD FROM CRR_MST) " ).append("\n"); 
		query.append("                  AND STATUS = 'IP'" ).append("\n"); 
		query.append("               ) S" ).append("\n"); 
		query.append("        WHERE H.VSL_CD  = S.VSL_CD(+)" ).append("\n"); 
		query.append("          AND H.VOY_NO  = S.VOY_NO(+)" ).append("\n"); 
		query.append("          AND H.DIR_CD  = S.DIR_CD(+)" ).append("\n"); 
		query.append("          AND H.REGION  = S.REGION(+)" ).append("\n"); 
		query.append("          AND H.VSL_CD  = @[vsl_cd] " ).append("\n"); 
		query.append("          AND H.VOY_NO  = @[skd_voy_no] " ).append("\n"); 
		query.append("          AND H.DIR_CD  = @[skd_dir_cd] " ).append("\n"); 
		query.append("          AND H.REGION  = @[sconti_cd]" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("        UNION  ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       SELECT '2' AS FLG, H.PORT_CD, A.BSA_SLOT AS TEU, A.BSA_WGT AS WGT" ).append("\n"); 
		query.append("         FROM RDR_HEADER     H, " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT VSL_CD, VOY_NO, DIR_CD, REGION, NVL(BSA_SLOT,0)+NVL(RELEASE_SLOT,0)+NVL(SWAP_SLOT,0) AS BSA_SLOT" ).append("\n"); 
		query.append("                    , NVL(BSA_WGT,0)+NVL(RELEASE_WGT,0)+NVL(SWAP_WGT,0) AS BSA_WGT" ).append("\n"); 
		query.append("                 FROM RDR_ALLOCATION" ).append("\n"); 
		query.append("                WHERE OPR_CD IN (SELECT JO_CRR_CD FROM CRR_MST) " ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("        WHERE H.VSL_CD  = A.VSL_CD(+)" ).append("\n"); 
		query.append("          AND H.VOY_NO  = A.VOY_NO(+)" ).append("\n"); 
		query.append("          AND H.DIR_CD  = A.DIR_CD(+)" ).append("\n"); 
		query.append("          AND H.REGION  = A.REGION(+)" ).append("\n"); 
		query.append("          AND H.VSL_CD  = @[vsl_cd] " ).append("\n"); 
		query.append("          AND H.VOY_NO  = @[skd_voy_no] " ).append("\n"); 
		query.append("          AND H.DIR_CD  = @[skd_dir_cd] " ).append("\n"); 
		query.append("          AND H.REGION  = @[sconti_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("GROUP BY PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}