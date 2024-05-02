/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementHisDBDAOSearchRateHisAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.05.28 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementHisDBDAOSearchRateHisAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Rate History 조회
	  * </pre>
	  */
	public AgreementHisDBDAOSearchRateHisAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_dist_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delete_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_via_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_fm_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_agmt_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmtno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_to_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cmdt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dist_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("effective_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dor_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementHisDBDAOSearchRateHisAgmtRSQL").append("\n"); 
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
		query.append("SELECT  B.VNDR_SEQ" ).append("\n"); 
		query.append("       ,DECODE(D.FM_NOD_CD, '0000000', NULL, D.FM_NOD_CD) FM_NOD_CD" ).append("\n"); 
		query.append("       ,DECODE(D.VIA_NOD_CD,'0000000', NULL, D.VIA_NOD_CD) VIA_NOD_CD" ).append("\n"); 
		query.append("       ,DECODE(D.DOR_NOD_CD,'0000000', NULL, D.DOR_NOD_CD) DOR_NOD_CD" ).append("\n"); 
		query.append("       ,DECODE(D.TO_NOD_CD,'0000000',NULL, D.TO_NOD_CD) TO_NOD_CD" ).append("\n"); 
		query.append("       ,DECODE(D.TRSP_AGMT_DIST, '0', NULL, D.TRSP_AGMT_DIST) TRSP_AGMT_DIST" ).append("\n"); 
		query.append("       ,DECODE(D.DIST_MEAS_UT_CD, 'XX', NULL, D.DIST_MEAS_UT_CD) DIST_MEAS_UT_CD" ).append("\n"); 
		query.append("       ,DECODE(D.TRSP_DIST_TP_CD, 'X', NULL, D.TRSP_DIST_TP_CD) TRSP_DIST_TP_CD" ).append("\n"); 
		query.append("       ,E.EQ_KND_CD" ).append("\n"); 
		query.append("       ,E.TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append("       ,DECODE(E.WTR_RCV_TERM_CD, '0', NULL, E.WTR_RCV_TERM_CD) WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("       ,DECODE(E.WTR_DE_TERM_CD, '0', NULL, E.WTR_DE_TERM_CD) WTR_DE_TERM_CD" ).append("\n"); 
		query.append("       ,DECODE(E.TRSP_AGMT_BDL_QTY, '0', NULL, E.TRSP_AGMT_BDL_QTY) TRSP_AGMT_BDL_QTY " ).append("\n"); 
		query.append("       ,DECODE(E.TO_WGT, '0', NULL, '999999.99', 'MAX', E.TO_WGT) TO_WGT" ).append("\n"); 
		query.append("       ,DECODE(E.WGT_MEAS_UT_CD, 'XXX', NULL, E.WGT_MEAS_UT_CD) WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("       ,E.TRSP_RVS_APLY_FLG" ).append("\n"); 
		query.append("       ,TO_CHAR(E.EFF_FM_DT,'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(E.EFF_TO_DT,'YYYY-MM-DD') EFF_TO_DT" ).append("\n"); 
		query.append("       ,DECODE(E.CURR_CD, 'XXX', NULL, E.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("       ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("       ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("	   ,TO_CHAR(E.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("       ,NVL((SELECT MAX(A.USR_NM) FROM COM_USER A WHERE A.USR_ID = E.UPD_USR_ID),E.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("       ,RANK() OVER (PARTITION BY E.TRSP_AGMT_NOD_SEQ, E.TRSP_AGMT_RT_SEQ ORDER BY E.TRSP_AGMT_NOD_SEQ, E.TRSP_AGMT_RT_SEQ, E.TRSP_AGMT_RT_HIS_SEQ ASC ) AS RK" ).append("\n"); 
		query.append("       ,DECODE(E.DELT_FLG, 'Y', 'Y', 'N') DELT_FLG" ).append("\n"); 
		query.append("       ,E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       ,E.TRSP_AGMT_SEQ	" ).append("\n"); 
		query.append("       ,E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("       ,E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("       ,E.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("       ,E.TRSP_AGMT_RT_HIS_SEQ" ).append("\n"); 
		query.append("       ,TO_CHAR(E.AGMT_APRO_DT,'YYYY-MM-DD') AGMT_APRO_DT" ).append("\n"); 
		query.append("       ,C.CFM_FLG" ).append("\n"); 
		query.append("       ,NVL((SELECT MAX(A.USR_NM) FROM COM_USER A WHERE A.USR_ID = C.CFM_USR_ID),C.CFM_USR_ID) CFM_USR_NM" ).append("\n"); 
		query.append("  FROM TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("      ,TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("      ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("      ,TRS_AGMT_NOD   D" ).append("\n"); 
		query.append("      ,TRS_AGMT_EQ_RT_HIS E" ).append("\n"); 
		query.append("WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  AND A.TRSP_AGMT_OFC_CTY_CD = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND A.TRSP_AGMT_SEQ   = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_OFC_CTY_CD = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_SEQ = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_OFC_CTY_CD = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_SEQ = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_NOD_SEQ = E.TRSP_AGMT_NOD_SEQ" ).append("\n"); 
		query.append("  AND B.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("  AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN ((SUBSTR(@[fm_agmtno], 0, 3), SUBSTR(@[fm_agmtno], 4, 6)))" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_RT_TP_CD = @[fm_trsp_agmt_rt_tp_cd]" ).append("\n"); 
		query.append("#if(${fm_eq_knd_cd} != '' )" ).append("\n"); 
		query.append("  AND E.EQ_KND_CD = @[fm_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND C.TRSP_COST_MOD_CD = @[fm_trsp_cost_mod_cd]" ).append("\n"); 
		query.append("  AND C.AGMT_TRSP_TP_CD = @[fm_agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("  AND C.CGO_TP_CD = @[fm_cgo_tp_cd]" ).append("\n"); 
		query.append("  AND (C.CUST_CNT_CD, C.CUST_SEQ) IN ((NVL(SUBSTR(@[fm_cust_cd], 0, 2),'XX'), NVL(SUBSTR(@[fm_cust_cd], 3, 6),0)))" ).append("\n"); 
		query.append("  AND C.CMDT_GRP_CD = NVL(@[fm_cmdt_grp_cd],'XXXX')" ).append("\n"); 
		query.append("  AND C.RAIL_SVC_TP_CD = NVL(@[fm_rail_svc_tp_cd],'00')" ).append("\n"); 
		query.append("#if(${fm_fm_nod_cd} != '')" ).append("\n"); 
		query.append("  AND D.FM_NOD_CD LIKE @[fm_fm_nod_cd]||@[fm_fm_nod_yd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_via_nod_cd} != '')" ).append("\n"); 
		query.append("  AND D.VIA_NOD_CD LIKE @[fm_via_nod_cd]||@[fm_via_nod_yd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_dor_nod_cd} != '')" ).append("\n"); 
		query.append("  AND D.DOR_NOD_CD LIKE @[fm_dor_nod_cd]||@[fm_dor_nod_yd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_to_nod_cd} != '')" ).append("\n"); 
		query.append("  AND D.TO_NOD_CD LIKE @[fm_to_nod_cd]||@[fm_to_nod_yd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_trsp_dist_tp_cd} != '')" ).append("\n"); 
		query.append("  AND D.TRSP_DIST_TP_CD = @[fm_trsp_dist_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_trsp_agmt_dist} != '')" ).append("\n"); 
		query.append("  AND D.TRSP_AGMT_DIST = @[fm_trsp_agmt_dist]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_dist_meas_ut_cd} != '')" ).append("\n"); 
		query.append("  AND D.DIST_MEAS_UT_CD = @[fm_dist_meas_ut_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${fm_eq_knd_cd} != '')" ).append("\n"); 
		query.append("AND E.EQ_KND_CD = @[fm_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($fm_eqtpsz.size() > 0)" ).append("\n"); 
		query.append("      AND E.TRSP_AGMT_EQ_TP_SZ_CD IN (" ).append("\n"); 
		query.append("    #foreach($key in ${fm_eqtpsz}) " ).append("\n"); 
		query.append("        #if($velocityCount < $fm_eqtpsz.size()) " ).append("\n"); 
		query.append("            '$key', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${effective_date} != '')" ).append("\n"); 
		query.append("	AND TO_DATE(@[effective_date], 'YYYY-MM-DD') BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${delete_yn} != '')" ).append("\n"); 
		query.append("	AND E.DELT_FLG = @[delete_yn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}