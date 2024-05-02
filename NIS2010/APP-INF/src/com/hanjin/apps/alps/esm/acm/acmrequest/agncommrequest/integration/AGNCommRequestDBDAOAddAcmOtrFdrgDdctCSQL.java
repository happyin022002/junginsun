/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmOtrFdrgDdctCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmOtrFdrgDdctCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AcmOtrFdrgDdct
	  * 2016.08.05 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA No. 추가 요청
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmOtrFdrgDdctCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmOtrFdrgDdctCSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (SELECT @[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("        @[agn_cd] AS AGN_CD," ).append("\n"); 
		query.append("        @[io_bnd_cd] AS IO_BND_CD," ).append("\n"); 
		query.append("        @[ac_tp_cd] AS AC_TP_CD," ).append("\n"); 
		query.append("        @[max_ac_seq] AS AC_SEQ," ).append("\n"); 
		query.append("        ((SELECT NVL(MAX(AC_TRSP_SEQ), 0)" ).append("\n"); 
		query.append("          FROM ACM_AGN_COMM_TRSP" ).append("\n"); 
		query.append("          WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("            AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("            AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("            AND AC_SEQ = @[max_ac_seq]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         +" ).append("\n"); 
		query.append("         ROW_NUMBER() OVER(ORDER BY LOC.POL_CD)" ).append("\n"); 
		query.append("        ) AS AC_TRSP_SEQ," ).append("\n"); 
		query.append("        'E' AS TRSP_MOD_CD," ).append("\n"); 
		query.append("        'Own' || '-' || QTY.CNTR_TPSZ_CD AS TRSP_DDCT_CD," ).append("\n"); 
		query.append("        LOC.POL_CD FM_LOC_CD," ).append("\n"); 
		query.append("        LOC.POD_CD TO_LOC_CD," ).append("\n"); 
		query.append("        (QTY.OP_CNTR_QTY * NVL((SELECT DDCT_AMT" ).append("\n"); 
		query.append("                                FROM ACM_OTR_FDRG_DDCT DDCT," ).append("\n"); 
		query.append("                                  ACM_AGN_SET_CNTR_GRP GRP" ).append("\n"); 
		query.append("                                WHERE DDCT.POL_CD = LOC.POL_CD" ).append("\n"); 
		query.append("                                  AND DDCT.POD_CD = LOC.POD_CD" ).append("\n"); 
		query.append("                                  AND GRP.CNTR_TPSZ_GRP_NM IN ('20', '40')" ).append("\n"); 
		query.append("                                  AND GRP.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                  AND GRP.CNTR_TPSZ_GRP_NM = DDCT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                  AND @[sa_dt] BETWEEN DDCT.FM_EFF_DT AND DDCT.TO_EFF_DT" ).append("\n"); 
		query.append("                                  AND NVL(DDCT.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                               )," ).append("\n"); 
		query.append("                               (SELECT DDCT_AMT" ).append("\n"); 
		query.append("                                FROM ACM_OTR_FDRG_DDCT DDCT," ).append("\n"); 
		query.append("                                  ACM_AGN_SET_CNTR_GRP GRP" ).append("\n"); 
		query.append("                                WHERE UPPER(DDCT.POL_CD) = 'OTHER'" ).append("\n"); 
		query.append("                                  AND UPPER(DDCT.POD_CD) = 'OTHER'" ).append("\n"); 
		query.append("                                  AND GRP.CNTR_TPSZ_GRP_NM IN ('20', '40')" ).append("\n"); 
		query.append("                                  AND GRP.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                  AND GRP.CNTR_TPSZ_GRP_NM = DDCT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                  AND @[sa_dt] BETWEEN DDCT.FM_EFF_DT AND DDCT.TO_EFF_DT" ).append("\n"); 
		query.append("                                  AND NVL(DDCT.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("        ) AS TRSP_DDCT_AMT," ).append("\n"); 
		query.append("        '1' AS TRSP_LVL," ).append("\n"); 
		query.append("        @[usr_id] AS UPD_ID," ).append("\n"); 
		query.append("        SYSDATE UPD_DT," ).append("\n"); 
		query.append("        @[usr_id] AS CRE_ID," ).append("\n"); 
		query.append("        SYSDATE CRE_DT" ).append("\n"); 
		query.append("      FROM BKG_QUANTITY QTY," ).append("\n"); 
		query.append("        (SELECT BND, POL_CD, POD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, SLAN_CD" ).append("\n"); 
		query.append("         FROM (SELECT 'O' BND, SUBSTR(POL_CD, 1, 5) POL_CD, SUBSTR(POD_CD, 1, 5) POD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, SLAN_CD" ).append("\n"); 
		query.append("               FROM BKG_VVD" ).append("\n"); 
		query.append("               WHERE BKG_NO = @[bkg_no] AND VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("               UNION ALL" ).append("\n"); 
		query.append("               SELECT 'I' BND, SUBSTR(POL_CD, 1, 5) POL_CD, SUBSTR(POD_CD, 1, 5) POD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, SLAN_CD" ).append("\n"); 
		query.append("               FROM BKG_VVD" ).append("\n"); 
		query.append("               WHERE BKG_NO = @[bkg_no] AND VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("         GROUP BY BND, POL_CD, POD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, SLAN_CD" ).append("\n"); 
		query.append("        ) LOC" ).append("\n"); 
		query.append("      WHERE QTY.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND LOC.BND IN (DECODE(@[fdrg_ddct_org_flg], 'Y', 'O', 'X'), DECODE(@[fdrg_ddct_dest_flg], 'Y', 'I', 'X'))" ).append("\n"); 
		query.append("        AND (SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("             FROM MAS_LANE_RGST" ).append("\n"); 
		query.append("             WHERE DIR_CD = LOC.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND SLAN_CD = LOC.SLAN_CD" ).append("\n"); 
		query.append("               AND LOD_SPL_CNG_FLG = 'Y'" ).append("\n"); 
		query.append("               AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("            ) > 0" ).append("\n"); 
		query.append("        AND QTY.CNTR_TPSZ_CD IN (SELECT CNTR_TPSZ_CD FROM ACM_AGN_SET_CNTR_GRP WHERE CNTR_TPSZ_GRP_NM IN ('20', '40'))" ).append("\n"); 
		query.append("        AND (SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("             FROM ACM_AGN_COMM_TRSP" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("               AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("               AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("               AND AC_SEQ = @[max_ac_seq]" ).append("\n"); 
		query.append("               AND TRSP_MOD_CD = 'F'" ).append("\n"); 
		query.append("               AND FM_LOC_CD = LOC.POL_CD" ).append("\n"); 
		query.append("               AND TO_LOC_CD = LOC.POD_CD" ).append("\n"); 
		query.append("          ) = 0" ).append("\n"); 
		query.append("        AND EXISTS(SELECT 1" ).append("\n"); 
		query.append("                   FROM ACM_OTR_FDRG_DDCT DDCT," ).append("\n"); 
		query.append("                     ACM_AGN_SET_CNTR_GRP GRP" ).append("\n"); 
		query.append("                   WHERE (DDCT.POL_CD = LOC.POL_CD OR UPPER(DDCT.POL_CD) = 'OTHER')" ).append("\n"); 
		query.append("                     AND (DDCT.POD_CD = LOC.POD_CD OR UPPER(DDCT.POD_CD) = 'OTHER')" ).append("\n"); 
		query.append("                     AND GRP.CNTR_TPSZ_GRP_NM IN ('20', '40')" ).append("\n"); 
		query.append("                     AND GRP.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     AND GRP.CNTR_TPSZ_GRP_NM = DDCT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     AND @[sa_dt] BETWEEN DDCT.FM_EFF_DT AND DDCT.TO_EFF_DT" ).append("\n"); 
		query.append("					 AND NVL(DDCT.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("WHERE TRSP_DDCT_AMT IS NOT NULL" ).append("\n"); 

	}
}