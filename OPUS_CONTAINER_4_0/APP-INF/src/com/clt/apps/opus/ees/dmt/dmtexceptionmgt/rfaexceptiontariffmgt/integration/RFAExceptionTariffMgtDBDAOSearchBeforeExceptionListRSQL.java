/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request - Before Booking Request 에 등록된 정보를 조회하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_rqst_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchBeforeExceptionListRSQL").append("\n"); 
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
		query.append("		DECODE(A.DMDT_EXPT_RQST_STS_CD, 'A', LPAD(A.RFA_EXPT_VER_SEQ, 3, '0'), '') VIEW_VER_SEQ" ).append("\n"); 
		query.append("	,	B.DMDT_TRF_CD" ).append("\n"); 
		query.append("	,	TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	,	TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("	,	B.DMDT_CNTR_TP_CD || ':' || B.DMDT_CGO_TP_CD DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("	,	E.INTG_CD_VAL_DP_DESC || ' - ' || F.INTG_CD_VAL_DP_DESC DMDT_CNTR_CGO_TP_TXT" ).append("\n"); 
		query.append("	, 	C.CVRG_CMB_SEQ" ).append("\n"); 
		query.append("	, 	C.CVRG_CMB_SEQ VIEW_CVRG_CMB_SEQ" ).append("\n"); 
		query.append("	, 	C.CVRG_CONTI_CD" ).append("\n"); 
		query.append("	,	C.CVRG_CNT_CD" ).append("\n"); 
		query.append("	, 	C.CVRG_RGN_CD" ).append("\n"); 
		query.append("	, 	C.CVRG_STE_CD" ).append("\n"); 
		query.append("	, 	C.CVRG_LOC_CD" ).append("\n"); 
		query.append("	,	DECODE(B.FT_USE_FLG,'Y','1','0') FT_USE_FLG" ).append("\n"); 
		query.append("    ,   DECODE(B.FT_ADJ_FLG, 'Y', 'M', DECODE(B.FT_USE_FLG, 'Y', 'S', '')) AS FT_TIR" ).append("\n"); 
		query.append("	,	B.ADD_DYS" ).append("\n"); 
		query.append("	,	B.TTL_DYS" ).append("\n"); 
		query.append("	,   DECODE(B.XCLD_SAT_FLG,'Y','1','0') XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,   DECODE(B.XCLD_SUN_FLG,'Y','1','0') XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,   DECODE(B.XCLD_HOL_FLG,'Y','1','0') XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,	C.ORG_DEST_MULTI" ).append("\n"); 
		query.append("	,	C.ORG_DEST_MULTI CURR_ORG_DEST_MULTI" ).append("\n"); 
		query.append("	,	C.ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append("	,	C.ORG_DEST_CNT_CD" ).append("\n"); 
		query.append("	,	C.ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("	,	C.ORG_DEST_STE_CD" ).append("\n"); 
		query.append("	,	C.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("	,	B.RT_USE_FLG" ).append("\n"); 
		query.append("	,	B.FNL_DEST_FLG" ).append("\n"); 
		query.append("	,	B.FNL_DEST_CONTI_CD" ).append("\n"); 
		query.append("	,	B.FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("	,	B.FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("	,	B.FNL_DEST_STE_CD" ).append("\n"); 
		query.append("	,	B.FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("	,	B.ACT_CUST_CNT_CD || LPAD(B.ACT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("	,	D.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("	,	B.REP_CMDT_CD" ).append("\n"); 
		query.append("	,	SUBSTR(B.EXPT_TRF_RMK, 0, 20) EXPT_TRF_RMK" ).append("\n"); 
		query.append("	,	B.EXPT_TRF_RMK FULL_EXPT_TRF_RMK" ).append("\n"); 
		query.append("	,	B.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,	B.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	,	B.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,	B.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	,	B.CURR_CD" ).append("\n"); 
		query.append("	,	B.RT_CHK_FLG" ).append("\n"); 
		query.append("	,	B.RT_CHK" ).append("\n"); 
		query.append("	,	A.DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("	,	A.RQST_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_RFA_EXPT_TRF A" ).append("\n"); 
		query.append("	,	(" ).append("\n"); 
		query.append("			SELECT  *" ).append("\n"); 
		query.append("			FROM    (" ).append("\n"); 
		query.append("            			SELECT  ROW_NUMBER() OVER " ).append("\n"); 
		query.append("									(	PARTITION BY " ).append("\n"); 
		query.append("											RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("										, 	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("										, 	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("										, 	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("										,	FNL_DEST_CONTI_CD" ).append("\n"); 
		query.append("										,	FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("										,	FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("										,	FNL_DEST_STE_CD" ).append("\n"); 
		query.append("										,	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("										ORDER BY " ).append("\n"); 
		query.append("											RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("										, 	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("										, 	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("										, 	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("										, 	CVRG_CMB_SEQ" ).append("\n"); 
		query.append("									) AS IDX" ).append("\n"); 
		query.append("							,	RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("							,	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("							,	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("							,	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("							,	CVRG_CMB_SEQ" ).append("\n"); 
		query.append("							,	DMDT_TRF_CD" ).append("\n"); 
		query.append("							,	N1ST_CMNC_VER_SEQ" ).append("\n"); 
		query.append("							,	EFF_DT" ).append("\n"); 
		query.append("							,	EXP_DT" ).append("\n"); 
		query.append("							,	DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("							,	DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("							,	REP_CMDT_CD" ).append("\n"); 
		query.append("							,	FT_USE_FLG" ).append("\n"); 
		query.append("							,	ADD_DYS" ).append("\n"); 
		query.append("							,	TTL_DYS" ).append("\n"); 
		query.append("							,	XCLD_SAT_FLG" ).append("\n"); 
		query.append("							,	XCLD_SUN_FLG" ).append("\n"); 
		query.append("							,	XCLD_HOL_FLG" ).append("\n"); 
		query.append("							,	RT_USE_FLG" ).append("\n"); 
		query.append("							,	CURR_CD" ).append("\n"); 
		query.append("							,	EXPT_TRF_RMK" ).append("\n"); 
		query.append("							,	ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("							,	ACT_CUST_SEQ" ).append("\n"); 
		query.append("							,	FNL_DEST_FLG" ).append("\n"); 
		query.append("							,	FNL_DEST_CONTI_CD" ).append("\n"); 
		query.append("							,	FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("							,	FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("							,	FNL_DEST_STE_CD" ).append("\n"); 
		query.append("							,	FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("							,	CRE_USR_ID" ).append("\n"); 
		query.append("							,	CRE_DT" ).append("\n"); 
		query.append("							,	CRE_OFC_CD" ).append("\n"); 
		query.append("							,	UPD_USR_ID" ).append("\n"); 
		query.append("							,	UPD_DT" ).append("\n"); 
		query.append("							,	UPD_OFC_CD" ).append("\n"); 
		query.append("							,	RT_CHK_FLG" ).append("\n"); 
		query.append("							,	CASE" ).append("\n"); 
		query.append("									WHEN RT_CHK_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("									WHEN CURR_CD IS NOT NULL OR CURR_CD <> '' THEN 'Y'" ).append("\n"); 
		query.append("									WHEN (" ).append("\n"); 
		query.append("											SELECT	COUNT(*)" ).append("\n"); 
		query.append("											FROM	DMT_RFA_EXPT_RT" ).append("\n"); 
		query.append("											WHERE	RFA_EXPT_DAR_NO 	= A.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("												AND	RFA_EXPT_MAPG_SEQ	= A.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("												AND RFA_EXPT_VER_SEQ	= A.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("												AND RFA_RQST_DTL_SEQ	= A.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("										) > 0 THEN 'Y' ELSE 'N'" ).append("\n"); 
		query.append("								END AS RT_CHK" ).append("\n"); 
		query.append("                           ,    FT_ADJ_FLG" ).append("\n"); 
		query.append("                           ,    CMDT_FLG " ).append("\n"); 
		query.append("						FROM    DMT_RFA_EXPT_TRF_DTL A" ).append("\n"); 
		query.append("                        WHERE   RFA_EXPT_DAR_NO 	= @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("							AND	RFA_EXPT_MAPG_SEQ 	= @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("							AND RFA_EXPT_VER_SEQ 	= @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if(${rfa_rqst_dtl_seq} != '')" ).append("\n"); 
		query.append("							AND RFA_RQST_DTL_SEQ 	= @[rfa_rqst_dtl_seq]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			WHERE IDX = 1" ).append("\n"); 
		query.append("		) B" ).append("\n"); 
		query.append("	,	(" ).append("\n"); 
		query.append("			SELECT	" ).append("\n"); 
		query.append("					RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("				, 	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("				, 	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("				, 	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("				, 	CVRG_CMB_SEQ" ).append("\n"); 
		query.append("				, 	CVRG_CONTI_CD" ).append("\n"); 
		query.append("				, 	CVRG_CNT_CD" ).append("\n"); 
		query.append("				, 	CVRG_RGN_CD" ).append("\n"); 
		query.append("				, 	CVRG_STE_CD" ).append("\n"); 
		query.append("				, 	CVRG_LOC_CD" ).append("\n"); 
		query.append("				, 	CASE WHEN ORG_DEST_MULTI < 2 THEN 'S' ELSE 'M' END ORG_DEST_MULTI" ).append("\n"); 
		query.append("        		, 	CASE WHEN ORG_DEST_MULTI < 2 THEN ORG_DEST_CONTI_CD ELSE '' END ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append("        		, 	CASE WHEN ORG_DEST_MULTI < 2 THEN ORG_DEST_CNT_CD ELSE '' END ORG_DEST_CNT_CD" ).append("\n"); 
		query.append("        		, 	CASE WHEN ORG_DEST_MULTI < 2 THEN ORG_DEST_RGN_CD ELSE '' END ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("        		, 	CASE WHEN ORG_DEST_MULTI < 2 THEN ORG_DEST_STE_CD ELSE '' END ORG_DEST_STE_CD" ).append("\n"); 
		query.append("        		, 	CASE WHEN ORG_DEST_MULTI < 2 THEN ORG_DEST_LOC_CD ELSE '' END ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				FROM	(" ).append("\n"); 
		query.append("							SELECT	COUNT(CVRG_CMB_SEQ) OVER " ).append("\n"); 
		query.append("											(	PARTITION BY " ).append("\n"); 
		query.append("													RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("												,	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("												,	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("												,	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("											) ORG_DEST_MULTI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									, ROW_NUMBER () OVER " ).append("\n"); 
		query.append("											(	PARTITION BY " ).append("\n"); 
		query.append("													RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("												,	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("												,	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("												,	RFA_RQST_DTL_SEQ " ).append("\n"); 
		query.append("												ORDER BY " ).append("\n"); 
		query.append("													RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("												,	CVRG_CMB_SEQ" ).append("\n"); 
		query.append("											) SEQ" ).append("\n"); 
		query.append("            								, RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("									, RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("									, RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("									, RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("									, CVRG_CMB_SEQ" ).append("\n"); 
		query.append("									, CVRG_CONTI_CD" ).append("\n"); 
		query.append("									, CVRG_CNT_CD" ).append("\n"); 
		query.append("									, CVRG_RGN_CD" ).append("\n"); 
		query.append("									, CVRG_STE_CD" ).append("\n"); 
		query.append("									, CVRG_LOC_CD" ).append("\n"); 
		query.append("									, ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append("									, ORG_DEST_CNT_CD" ).append("\n"); 
		query.append("									, ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("									, ORG_DEST_STE_CD" ).append("\n"); 
		query.append("									, ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    							FROM	DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("    							WHERE	RFA_EXPT_DAR_NO 	= @[rfa_expt_dar_no] " ).append("\n"); 
		query.append("									AND RFA_EXPT_MAPG_SEQ 	= @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("									AND RFA_EXPT_VER_SEQ 	= @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									#if(${rfa_rqst_dtl_seq} != '')" ).append("\n"); 
		query.append("									AND RFA_RQST_DTL_SEQ 	= @[rfa_rqst_dtl_seq]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("    					)" ).append("\n"); 
		query.append("				WHERE SEQ < 2" ).append("\n"); 
		query.append("		) C" ).append("\n"); 
		query.append("	,	MDM_CUSTOMER D" ).append("\n"); 
		query.append("	,	COM_INTG_CD_DTL E" ).append("\n"); 
		query.append("	,	COM_INTG_CD_DTL F" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.RFA_EXPT_DAR_NO 	= @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("	AND	A.RFA_EXPT_MAPG_SEQ = @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("	AND	A.RFA_EXPT_VER_SEQ 	= @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${is_temp} == 'N')" ).append("\n"); 
		query.append("	AND A.DMDT_EXPT_RQST_STS_CD <> 'T'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.RFA_EXPT_DAR_NO 	= B.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	AND A.RFA_EXPT_MAPG_SEQ = B.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	AND A.RFA_EXPT_VER_SEQ 	= B.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	AND B.RFA_EXPT_DAR_NO 	= C.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	AND B.RFA_EXPT_MAPG_SEQ = C.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	AND B.RFA_EXPT_VER_SEQ 	= C.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	AND B.RFA_RQST_DTL_SEQ 	= C.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	AND B.ACT_CUST_CNT_CD 	= D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("	AND B.ACT_CUST_SEQ 		= D.CUST_SEQ(+)" ).append("\n"); 
		query.append("	AND B.DMDT_CNTR_TP_CD 	= E.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("	AND E.INTG_CD_ID 		= 'CD02053'" ).append("\n"); 
		query.append("	AND B.DMDT_CGO_TP_CD 	= F.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("	AND F.INTG_CD_ID 		= 'CD01963'" ).append("\n"); 

	}
}