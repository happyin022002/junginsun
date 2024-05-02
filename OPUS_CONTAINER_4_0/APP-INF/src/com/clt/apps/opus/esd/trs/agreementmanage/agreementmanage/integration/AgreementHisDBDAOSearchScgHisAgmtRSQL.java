/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementHisDBDAOSearchScgHisAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.28 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementHisDBDAOSearchScgHisAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Surcharge History Inquiry
	  * </pre>
	  */
	public AgreementHisDBDAOSearchScgHisAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fm_via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmt_rout_all_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_trsp_scg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_agmtno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dor_nod_yd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementHisDBDAOSearchScgHisAgmtRSQL").append("\n"); 
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
		query.append("       ,DECODE(D.TRSP_SCG_CD, '0', NULL, D.TRSP_SCG_CD) TRSP_SCG_CD" ).append("\n"); 
		query.append("       ,D.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("       ,E.EQ_KND_CD" ).append("\n"); 
		query.append("       ,E.TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append("       ,DECODE(E.TO_WGT, '0', NULL, E.TO_WGT) TO_WGT" ).append("\n"); 
		query.append("       ,DECODE(E.WGT_MEAS_UT_CD, 'XXX', NULL, E.WGT_MEAS_UT_CD) WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(E.EFF_FM_DT,'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(E.EFF_TO_DT,'YYYY-MM-DD') EFF_TO_DT" ).append("\n"); 
		query.append("       ,DECODE(E.CURR_CD, 'XXX', NULL, E.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("       ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("       ,E.TRSP_RND_RT " ).append("\n"); 
		query.append("       ,RANK() OVER (PARTITION BY E.TRSP_AGMT_SCG_NOD_SEQ, E.TRSP_AGMT_SCG_RT_SEQ ORDER BY E.TRSP_AGMT_SCG_NOD_SEQ, E.TRSP_AGMT_SCG_RT_SEQ, E.TRSP_AGMT_RT_HIS_SEQ ASC ) AS RK" ).append("\n"); 
		query.append("	   ,TO_CHAR(E.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("	   ,E.UPD_USR_ID" ).append("\n"); 
		query.append("       ,DECODE(E.DELT_FLG, 'Y', 'Y', '') DELT_FLG" ).append("\n"); 
		query.append("       ,E.AGMT_COST_FLG" ).append("\n"); 
		query.append("  FROM TRS_AGMT_HDR    A" ).append("\n"); 
		query.append("      ,TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("      ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("      ,TRS_AGMT_SCG_NOD   D" ).append("\n"); 
		query.append("      ,TRS_AGMT_SCG_RT_HIS E" ).append("\n"); 
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
		query.append("  AND D.TRSP_AGMT_SCG_NOD_SEQ = E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("  AND B.AGMT_VNDR_PRMRY_FLG = 'Y'" ).append("\n"); 
		query.append("  AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN ((SUBSTR(@[fm_agmtno], 0, 3), SUBSTR(@[fm_agmtno], 4, 6)))" ).append("\n"); 
		query.append("  AND C.TRSP_AGMT_RT_TP_CD = @[fm_trsp_agmt_rt_tp_cd]" ).append("\n"); 
		query.append("#if(${fm_eq_knd_cd} != '')" ).append("\n"); 
		query.append("  AND E.EQ_KND_CD = @[fm_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND C.TRSP_COST_MOD_CD = @[fm_trsp_cost_mod_cd]" ).append("\n"); 
		query.append("  AND C.AGMT_TRSP_TP_CD = @[fm_agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("  AND C.CGO_TP_CD = @[fm_cgo_tp_cd]" ).append("\n"); 
		query.append("  AND (C.CUST_CNT_CD, C.CUST_SEQ) IN ((NVL(SUBSTR(@[fm_cust_cd], 0, 2),'XX'), NVL(SUBSTR(@[fm_cust_cd], 3, 6),0)))" ).append("\n"); 
		query.append("  AND C.CMDT_GRP_CD = NVL(@[fm_cmdt_grp_cd],'XXXX')" ).append("\n"); 
		query.append("  AND C.RAIL_SVC_TP_CD = NVL(@[fm_rail_svc_tp_cd],'00')" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("#if(${fm_agmt_rout_all_flg} != '')" ).append("\n"); 
		query.append("  AND D.AGMT_ROUT_ALL_FLG = @[fm_agmt_rout_all_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_trsp_scg_cd} != '')" ).append("\n"); 
		query.append("  AND D.TRSP_SCG_CD = @[fm_trsp_scg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}