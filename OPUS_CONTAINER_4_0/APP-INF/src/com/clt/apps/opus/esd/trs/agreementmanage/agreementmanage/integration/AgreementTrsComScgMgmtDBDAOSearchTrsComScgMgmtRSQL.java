/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementTrsComScgMgmtDBDAOSearchTrsComScgMgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.05.09 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsComScgMgmtDBDAOSearchTrsComScgMgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Searching Common Surcharge Management
	  * </pre>
	  */
	public AgreementTrsComScgMgmtDBDAOSearchTrsComScgMgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_scg_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementTrsComScgMgmtDBDAOSearchTrsComScgMgmtRSQL").append("\n"); 
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
		query.append("SELECT TCSM.COM_SCG_KND_CD" ).append("\n"); 
		query.append("     , CODE1.INTG_CD_VAL_DP_DESC AS COM_SCG_KND_NM" ).append("\n"); 
		query.append("     , TCSM.COM_SCG_SEQ" ).append("\n"); 
		query.append("     , TCSM.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("     , CODE8.INTG_CD_VAL_DP_DESC AS TRSP_COST_MOD_NM" ).append("\n"); 
		query.append("     , CODE8.INTG_CD_VAL_DESC AS TRSP_COST_MOD_DESC" ).append("\n"); 
		query.append("     , TCSM.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("     , CODE9.INTG_CD_VAL_DP_DESC AS AGMT_TRSP_TP_NM" ).append("\n"); 
		query.append("     , CODE9.INTG_CD_VAL_DESC AS AGMT_TRSP_TP_DESC" ).append("\n"); 
		query.append("     , TCSM.RCC_CD" ).append("\n"); 
		query.append("     , TCSM.LCC_CD" ).append("\n"); 
		query.append("     , TCSM.SCC_CD" ).append("\n"); 
		query.append("     , TCSM.EQ_KND_CD" ).append("\n"); 
		query.append("     , CODE2.INTG_CD_VAL_DP_DESC AS EQ_KND_NM" ).append("\n"); 
		query.append("     , TCSM.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , CASE" ).append("\n"); 
		query.append("         WHEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'AL'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SF'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SL'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'TA'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'GN'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'EG'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'ZT'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CB'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CG'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'UG' THEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2)" ).append("\n"); 
		query.append("         ELSE SUBSTR(TCSM.EQ_TPSZ_CD, 1, 1)" ).append("\n"); 
		query.append("       END AS EQ_TP_CD" ).append("\n"); 
		query.append("     , CODE3.INTG_CD_VAL_DP_DESC AS EQ_TP_NM" ).append("\n"); 
		query.append("     , CODE3.INTG_CD_VAL_DESC AS EQ_TP_DESC" ).append("\n"); 
		query.append("     , CASE" ).append("\n"); 
		query.append("         WHEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'AL'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SF'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SL'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'TA'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'GN'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'EG'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'ZT'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CB'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CG'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'UG' THEN SUBSTR(TCSM.EQ_TPSZ_CD, 3, 2)" ).append("\n"); 
		query.append("         ELSE SUBSTR(TCSM.EQ_TPSZ_CD, 2, 2)" ).append("\n"); 
		query.append("       END AS EQ_SZ_CD" ).append("\n"); 
		query.append("     , CODE4.INTG_CD_VAL_DP_DESC AS EQ_SZ_NM" ).append("\n"); 
		query.append("     , CODE4.INTG_CD_VAL_DESC AS EQ_SZ_DESC" ).append("\n"); 
		query.append("     , TCSM.CGO_TP_CD" ).append("\n"); 
		query.append("     , CODE5.INTG_CD_VAL_DP_DESC AS CGO_TP_NM" ).append("\n"); 
		query.append("     , TCSM.BND_CD" ).append("\n"); 
		query.append("     , CODE6.INTG_CD_VAL_DP_DESC AS BND_NM" ).append("\n"); 
		query.append("     , TCSM.RT_TP_CD" ).append("\n"); 
		query.append("     , CODE7.INTG_CD_VAL_DP_DESC AS RT_TP_NM" ).append("\n"); 
		query.append("     , TCSM.CURR_CD" ).append("\n"); 
		query.append("     , CURR.CURR_NM" ).append("\n"); 
		query.append("     , CURR.CURR_DESC" ).append("\n"); 
		query.append("     , TCSM.ONE_WY_RT" ).append("\n"); 
		query.append("     , TCSM.RND_RT" ).append("\n"); 
		query.append("     , TO_CHAR(TCSM.EFF_FM_DT, 'YYYYMMDD') AS EFF_FM_DT" ).append("\n"); 
		query.append("     , TO_CHAR(TCSM.EFF_TO_DT, 'YYYYMMDD') AS EFF_TO_DT" ).append("\n"); 
		query.append("     , TCSM.WO_APLY_FLG" ).append("\n"); 
		query.append("     , TCSM.CRE_USR_ID" ).append("\n"); 
		query.append("     , CMC.USR_NM AS CRE_USR_NM" ).append("\n"); 
		query.append("     , TO_CHAR(TCSM.CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("     , TCSM.UPD_USR_ID" ).append("\n"); 
		query.append("     , CMU.USR_NM AS UPD_USR_NM" ).append("\n"); 
		query.append("     , TO_CHAR(TCSM.CRE_DT, 'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append("  FROM TRS_COM_SCG_MGMT TCSM" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD30002') CODE1" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01132') CODE2" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02544') CODE3" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD00129') CODE4" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD00748') CODE5" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02362') CODE6" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01937') CODE7" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02177') CODE8" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD00283') CODE9" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM MDM_CURRENCY" ).append("\n"); 
		query.append("         WHERE NVL(DELT_FLG, 'N') <> 'Y') CURR" ).append("\n"); 
		query.append("     , COM_USER CMC" ).append("\n"); 
		query.append("     , COM_USER CMU" ).append("\n"); 
		query.append(" WHERE TCSM.COM_SCG_KND_CD = CODE1.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TCSM.EQ_KND_CD = CODE2.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND CASE" ).append("\n"); 
		query.append("         WHEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'AL'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SF'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SL'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'TA'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'GN'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'EG'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'ZT'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CB'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CG'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'UG' THEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2)" ).append("\n"); 
		query.append("         ELSE SUBSTR(TCSM.EQ_TPSZ_CD, 1, 1)" ).append("\n"); 
		query.append("       END = CODE3.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND CASE" ).append("\n"); 
		query.append("         WHEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'AL'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SF'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SL'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'TA'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'GN'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'EG'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'ZT'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CB'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CG'" ).append("\n"); 
		query.append("           OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'UG' THEN SUBSTR(TCSM.EQ_TPSZ_CD, 3, 2)" ).append("\n"); 
		query.append("         ELSE SUBSTR(TCSM.EQ_TPSZ_CD, 2, 2)" ).append("\n"); 
		query.append("       END = CODE4.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TCSM.CGO_TP_CD = CODE5.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TCSM.BND_CD = CODE6.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TCSM.RT_TP_CD = CODE7.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TCSM.TRSP_COST_MOD_CD = CODE8.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TCSM.AGMT_TRSP_TP_CD = CODE9.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND TCSM.CURR_CD = CURR.CURR_CD(+)" ).append("\n"); 
		query.append("   AND TCSM.CRE_USR_ID = CMC.USR_ID(+)" ).append("\n"); 
		query.append("   AND TCSM.UPD_USR_ID = CMU.USR_ID(+)" ).append("\n"); 
		query.append("#if (${dt_cond} != 'ALL')" ).append("\n"); 
		query.append("   AND TO_DATE(@[eff_dt], 'YYYY-MM-DD') BETWEEN TCSM.EFF_FM_DT AND TCSM.EFF_TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${com_scg_knd_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND TCSM.COM_SCG_KND_CD = @[com_scg_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trsp_cost_mod_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND TCSM.TRSP_COST_MOD_CD = @[trsp_cost_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_trsp_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND TCSM.AGMT_TRSP_TP_CD = @[agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND TCSM.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lcc_cd} != '')" ).append("\n"); 
		query.append("   AND TCSM.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scc_cd} != '')" ).append("\n"); 
		query.append("   AND TCSM.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != '')" ).append("\n"); 
		query.append("   AND TCSM.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tp_cd} != 'AL')" ).append("\n"); 
		query.append("  #if (${eq_sz_cd} != 'AL')" ).append("\n"); 
		query.append("   AND TCSM.EQ_TPSZ_CD = @[eq_tp_cd] || @[eq_sz_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tp_cd} != 'AL')" ).append("\n"); 
		query.append("  #if (${eq_sz_cd} == 'AL')" ).append("\n"); 
		query.append("   AND" ).append("\n"); 
		query.append("     CASE" ).append("\n"); 
		query.append("       WHEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SF'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SL'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'TA'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'GN'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'EG'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'ZT'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CB'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CG'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'UG' THEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2)" ).append("\n"); 
		query.append("       ELSE SUBSTR(TCSM.EQ_TPSZ_CD, 1, 1)" ).append("\n"); 
		query.append("     END = @[eq_tp_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tp_cd} == 'AL')" ).append("\n"); 
		query.append("  #if (${eq_sz_cd} != 'AL')" ).append("\n"); 
		query.append("   AND" ).append("\n"); 
		query.append("     CASE" ).append("\n"); 
		query.append("       WHEN SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'AL'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SF'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'SL'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'TA'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'GN'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'EG'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'ZT'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CB'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'CG'" ).append("\n"); 
		query.append("         OR SUBSTR(TCSM.EQ_TPSZ_CD, 1, 2) = 'UG' THEN SUBSTR(TCSM.EQ_TPSZ_CD, 3, 2)" ).append("\n"); 
		query.append("       ELSE SUBSTR(TCSM.EQ_TPSZ_CD, 2, 2)" ).append("\n"); 
		query.append("     END = @[eq_sz_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND TCSM.CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bnd_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND TCSM.BND_CD = @[bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY CODE1.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        , CODE2.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        , CODE3.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        , CODE4.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        , CODE5.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        , CODE6.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        , CODE7.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}