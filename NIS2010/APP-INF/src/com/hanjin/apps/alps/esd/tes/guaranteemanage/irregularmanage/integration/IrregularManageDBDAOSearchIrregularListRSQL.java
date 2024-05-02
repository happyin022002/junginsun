/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IrregularManageDBDAOSearchIrregularListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IrregularManageDBDAOSearchIrregularListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Irregular 목록 조회
	  * </pre>
	  */
	public IrregularManageDBDAOSearchIrregularListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration").append("\n"); 
		query.append("FileName : IrregularManageDBDAOSearchIrregularListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		  IH.IRR_NO" ).append("\n"); 
		query.append("		,IH.IRR_TP_CD" ).append("\n"); 
		query.append("		,IH.IRR_RSN_RMK" ).append("\n"); 
		query.append("		, GH.GNTE_NO" ).append("\n"); 
		query.append("		, GH.DMY_FLG" ).append("\n"); 
		query.append("		, GL.TML_GNTE_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("        , CASE	WHEN GL.TML_IF_OFC_CD IS NOT NULL " ).append("\n"); 
		query.append("					AND GL.TML_IF_SEQ IS NOT NULL " ).append("\n"); 
		query.append("					AND	NVL(GL.IRR_NO_IF_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("				THEN 'I/F'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("		END CHK_TPB_IF" ).append("\n"); 
		query.append("		, GL.CNTR_NO" ).append("\n"); 
		query.append("		, GL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, CASE	WHEN GH.GNTE_TP_CD = 'ST'	THEN 'Storage'" ).append("\n"); 
		query.append("				WHEN GH.GNTE_TP_CD = 'FL'	THEN 'Flip'" ).append("\n"); 
		query.append("				WHEN GH.GNTE_TP_CD = 'CY'	THEN 'Other'" ).append("\n"); 
		query.append("		END GNTE_TP_CD" ).append("\n"); 
		query.append("		, GL.BKG_NO" ).append("\n"); 
		query.append("		, GL.BL_NO" ).append("\n"); 
		query.append("		, GL.SC_NO" ).append("\n"); 
		query.append("		, TO_CHAR(GL.FM_DT, 'YYYY-MM-DD' ) FM_DT" ).append("\n"); 
		query.append("		, TO_CHAR(GL.TO_DT, 'YYYY-MM-DD' ) TO_DT" ).append("\n"); 
		query.append("		, GL.GNTE_AMT" ).append("\n"); 
		query.append("		, CASE	WHEN NVL(IH.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("				THEN IH.CRE_USR_ID" ).append("\n"); 
		query.append("				ELSE IH.UPD_USR_ID" ).append("\n"); 
		query.append("		END CRE_USR_ID" ).append("\n"); 
		query.append("		, CASE	WHEN NVL(IH.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("				THEN (SELECT USR_NM FROM COM_USER WHERE USR_ID = IH.CRE_USR_ID)" ).append("\n"); 
		query.append("				ELSE (SELECT USR_NM FROM COM_USER WHERE USR_ID = IH.UPD_USR_ID)" ).append("\n"); 
		query.append("		END USR_NM" ).append("\n"); 
		query.append("		, CASE	WHEN NVL(IH.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("				THEN TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELOPA', IH.CRE_DT, IH.OFC_CD), 'YYYY-MM-DD') -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)" ).append("\n"); 
		query.append("				ELSE TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELOPA', IH.UPD_DT, IH.OFC_CD), 'YYYY-MM-DD') -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)" ).append("\n"); 
		query.append("		END CRE_DT" ).append("\n"); 
		query.append("		, DECODE(IH.IRR_STF_ERR_FLG				, 'Y', 1, 0) IRR_STF_ERR_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.IRR_SYS_ERR_FLG				, 'Y', 1, 0) IRR_SYS_ERR_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.IRR_CHSS_SHTG_FLG			, 'Y', 1, 0) IRR_CHSS_SHTG_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.IRR_OTR_FLG					, 'Y', 1, 0) IRR_OTR_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.IRR_LATE_DIS_FLG			, 'Y', 1, 0) IRR_LATE_DIS_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.IRR_LACK_OF_FLW_FLG			, 'Y', 1, 0) IRR_LACK_OF_FLW_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.IRR_CXL_WO_FLG				, 'Y', 1, 0) IRR_CXL_WO_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.IRR_EQ_SHTG_FLG				, 'Y', 1, 0) IRR_EQ_SHTG_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.OP_COST_OCP_FLG				, 'Y', 1, 0) OP_COST_OCP_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.OP_COST_TNK_ORD_FLG			, 'Y', 1, 0) OP_COST_TNK_ORD_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.OP_COST_TEAM_TRKG_FLG		, 'Y', 1, 0) OP_COST_TEAM_TRKG_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.OP_COST_XTRA_FT_FLG			, 'Y', 1, 0) OP_COST_XTRA_FT_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.OP_COST_SPTG_ICRZ_FLG		, 'Y', 1, 0) OP_COST_SPTG_ICRZ_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.OP_COST_OTR_TML_CHSS_FLG	, 'Y', 1, 0) OP_COST_OTR_TML_CHSS_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.OP_COST_MNR_FLG				, 'Y', 1, 0) OP_COST_MNR_FLG" ).append("\n"); 
		query.append("		, DECODE(IH.OP_COST_TRI_AXL_FLG			, 'Y', 1, 0) OP_COST_TRI_AXL_FLG" ).append("\n"); 
		query.append("FROM	TES_IRR_HDR IH" ).append("\n"); 
		query.append("		, TES_GNTE_HDR GH" ).append("\n"); 
		query.append("		, TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		IH.GNTE_NO	= GH.GNTE_NO" ).append("\n"); 
		query.append("AND		GH.GNTE_NO	= GL.GNTE_NO(+)" ).append("\n"); 
		query.append("--AND		NVL(GH.DMY_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#if (${irr_no} != '') " ).append("\n"); 
		query.append("AND		IH.IRR_NO	= @[irr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("AND		IH.OFC_CD	= @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("AND		IH.CRE_USR_ID	= @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gnte_tp_cd} != '') " ).append("\n"); 
		query.append("AND		IH.GNTE_TP_CD	= @[gnte_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} == '')" ).append("\n"); 
		query.append("AND GH.CRE_DT BETWEEN TO_DATE(@[fm_cre_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_cre_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND		IH.CRE_DT BETWEEN TO_DATE(@[fm_cre_dt], 'YYYY-MM-DD') + (540/24/60 - GLOBALDATE_PKG.GET_GMTHRS_FNC(@[ofc_cd])/24/60) AND TO_DATE(@[to_cre_dt], 'YYYY-MM-DD') + (540/24/60 - GLOBALDATE_PKG.GET_GMTHRS_FNC(@[ofc_cd])/24/60) + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     GL.GNTE_PROC_TP_CD = 'I'" ).append("\n"); 
		query.append("ORDER BY IH.GNTE_NO" ).append("\n"); 

	}
}