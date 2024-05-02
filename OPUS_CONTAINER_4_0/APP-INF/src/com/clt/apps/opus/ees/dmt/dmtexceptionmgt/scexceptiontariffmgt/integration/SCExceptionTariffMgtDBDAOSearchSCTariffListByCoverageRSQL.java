/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchSCTariffListByCoverageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchSCTariffListByCoverageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC & RFA Exception Inquiry (SC, COVERAGE) 조회쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchSCTariffListByCoverageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchSCTariffListByCoverageRSQL").append("\n"); 
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
		query.append("SELECT  HDR.SC_NO" ).append("\n"); 
		query.append(",   LPAD(VER.SC_EXPT_VER_SEQ, 3, '0') VER_SEQ" ).append("\n"); 
		query.append(",   COM_DTL.INTG_CD_VAL_DP_DESC STATUS" ).append("\n"); 
		query.append(",   GRP.DMDT_TRF_CD TARIFF" ).append("\n"); 
		query.append(",	GRP.SC_EXPT_GRP_SEQ GRP_SEQ" ).append("\n"); 
		query.append(",	CVRG.CVRG_SEQ" ).append("\n"); 
		query.append(",	TO_CHAR(GRP.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",	TO_CHAR(GRP.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append(",	COM_DTL2.INTG_CD_VAL_DP_DESC CNTRCGO" ).append("\n"); 
		query.append(",	CVRG.CNT_CD" ).append("\n"); 
		query.append(",	CASE WHEN CVRG.CNT_CD IN ('CA', 'US') THEN CVRG.STE_CD ELSE CVRG.RGN_CD END RGN_CD" ).append("\n"); 
		query.append(",	CVRG.LOC_CD" ).append("\n"); 
		query.append(",	DECODE(GRP.FT_ADJ_FLG, 'Y', 'Multi', DECODE(GRP.FT_FLG, 'Y', 'Single', '')) AS FT_TIR" ).append("\n"); 
		query.append(",	CASE WHEN GRP.FT_FLG = 'Y' AND GRP.FT_ADD_FLG = 'Y' THEN GRP.FT_ADD_DYS END AS FT_ADD_DYS" ).append("\n"); 
		query.append(",	CASE WHEN GRP.FT_FLG = 'Y' AND GRP.FT_ADD_FLG = 'N' THEN GRP.FT_ADD_DYS END AS FT_TOT_DYS" ).append("\n"); 
		query.append(",	GRP.XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	GRP.XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	GRP.XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	GRP.SC_EXPT_FM_CONTI_CD ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",	GRP.SC_EXPT_FM_CNT_CD ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",	CASE WHEN GRP.SC_EXPT_FM_CNT_CD IN ('CA', 'US') THEN GRP.SC_EXPT_FM_STE_CD ELSE GRP.SC_EXPT_FM_RGN_CD END ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",	GRP.SC_EXPT_FM_LOC_CD ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",	GRP.FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",   CASE WHEN GRP.FNL_DEST_CNT_CD IN ('CA', 'US') THEN GRP.FNL_DEST_STE_CD ELSE GRP.FNL_DEST_RGN_CD END FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",	GRP.FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",	GRP.RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",	GRP.RT_ADJ_FLG RT_FLG" ).append("\n"); 
		query.append(",	GRP.CURR_CD" ).append("\n"); 
		query.append(",	GRP.CMDT_FLG REP_CMDT_FLG" ).append("\n"); 
		query.append(",	GRP.ACT_CUST_FLG" ).append("\n"); 
		query.append(",   VER.PROP_NO" ).append("\n"); 
		query.append(",   PTY.CUST_CNT_CD || LPAD(PTY.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append(",   CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    PRI_SP_HDR HDR" ).append("\n"); 
		query.append(",   PRI_SP_MN MN" ).append("\n"); 
		query.append(",   PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append(",   MDM_CUSTOMER CUST" ).append("\n"); 
		query.append(",   DMT_SC_EXPT_VER VER" ).append("\n"); 
		query.append(",   DMT_SC_EXPT_GRP GRP" ).append("\n"); 
		query.append(",   DMT_SC_EXPT_CVRG CVRG" ).append("\n"); 
		query.append("#if(${act_cust_cd} != '')" ).append("\n"); 
		query.append(",	DMT_SC_EXPT_ACT_CUST ACT_CUST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",   COM_INTG_CD_DTL COM_DTL" ).append("\n"); 
		query.append(",	COM_INTG_CD_DTL COM_DTL2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = (" ).append("\n"); 
		query.append("SELECT	/*+ INDEX_DESC(PRI_SP_MN XPKPRI_SP_MN) */ AMDT_SEQ" ).append("\n"); 
		query.append("FROM	PRI_SP_MN" ).append("\n"); 
		query.append("WHERE	PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("AND PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("#if(${cust_cd} != '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("AND PTY.CUST_CNT_CD = CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND PTY.CUST_SEQ = CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND PTY.CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND PTY.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND HDR.PROP_NO = VER.PROP_NO" ).append("\n"); 
		query.append("AND VER.DMDT_EXPT_VER_STS_CD IN (" ).append("\n"); 
		query.append("#foreach( $sts_cd in ${sts_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $sts_cd_list.size()) '$sts_cd', #else '$sts_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND VER.PROP_NO = GRP.PROP_NO" ).append("\n"); 
		query.append("AND VER.SC_EXPT_VER_SEQ = GRP.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND VER.DMDT_EXPT_VER_STS_CD = COM_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND COM_DTL.INTG_CD_ID = 'CD01972'" ).append("\n"); 
		query.append("AND GRP.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(GRP.EFF_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND GRP.EFF_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(GRP.EXP_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND GRP.EXP_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(GRP.EFF_DT <= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND GRP.EXP_DT >= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(GRP.EFF_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND GRP.EXP_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND GRP.PROP_NO = CVRG.PROP_NO" ).append("\n"); 
		query.append("AND GRP.SC_EXPT_VER_SEQ = CVRG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND GRP.SC_EXPT_GRP_SEQ = CVRG.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("AND CVRG.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#if(${rgn_cd} != '')" ).append("\n"); 
		query.append("AND CVRG.RGN_CD = @[rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ste_cd} != '')" ).append("\n"); 
		query.append("AND CVRG.STE_CD = @[ste_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("AND CVRG.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND GRP.DMDT_CNTR_CGO_TP_CD = COM_DTL2.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND COM_DTL2.INTG_CD_ID = 'CD01969'" ).append("\n"); 
		query.append("#if(${cust_cd} == '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("AND GRP.PROP_NO = ACT_CUST.PROP_NO" ).append("\n"); 
		query.append("AND GRP.SC_EXPT_VER_SEQ = ACT_CUST.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND GRP.SC_EXPT_GRP_SEQ = ACT_CUST.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("#elseif(${cust_cd} != '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("AND GRP.PROP_NO = ACT_CUST.PROP_NO(+)" ).append("\n"); 
		query.append("AND GRP.SC_EXPT_VER_SEQ = ACT_CUST.SC_EXPT_VER_SEQ(+)" ).append("\n"); 
		query.append("AND GRP.SC_EXPT_GRP_SEQ = ACT_CUST.SC_EXPT_GRP_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cd} != '' && ${act_cust_cd} == '')" ).append("\n"); 
		query.append("AND PTY.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PTY.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("#elseif(${cust_cd} == '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("AND ACT_CUST.CUST_CNT_CD = SUBSTR(@[act_cust_cd], 0, 2) AND ACT_CUST.CUST_SEQ = SUBSTR(@[act_cust_cd], 3)" ).append("\n"); 
		query.append("#elseif(${cust_cd} != '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(PTY.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PTY.CUST_SEQ = SUBSTR(@[cust_cd], 3))" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(ACT_CUST.CUST_CNT_CD = SUBSTR(@[act_cust_cd], 0, 2) AND ACT_CUST.CUST_SEQ = SUBSTR(@[act_cust_cd], 3))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SC_NO, PROP_NO, VER_SEQ, GRP_SEQ, CVRG_SEQ" ).append("\n"); 

	}
}