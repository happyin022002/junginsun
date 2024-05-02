/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.04.28 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Optimum Route Summary에서 선택한 세부사항을 조회한다.
	  * </pre>
	  */
	public OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("door_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("optm_rout_pass_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dscr_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sel_so_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.integration").append("\n"); 
		query.append("FileName : OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL").append("\n"); 
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
		query.append("------ OptmRoutPassDtlVO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		OPTM_ROUT_PASS_FLG,PASS_TYPE,WO_CRE_OFC_CD,TRO_OFC_CD,TRSP_MOD_CD,DSCR_RSN_DESC,BKG_FM_NOD_CD,BKG_DOR_NOD_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- 20120730 Added By SBKIM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT N.NOD_NM" ).append("\n"); 
		query.append("			FROM PRD_NODE N" ).append("\n"); 
		query.append("			WHERE N.NOD_CD = BKG_DOR_NOD_CD " ).append("\n"); 
		query.append("		)   BKG_DOR_NOD_NAME," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- 20120730 Added  By SBKIM" ).append("\n"); 
		query.append("		EQ_NO,EQ_TPSZ_CD,TRSP_BND_CD,TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("		BKG_NO,SC_NO,RFA_NO,TAA_NO,TRO_SEQ,SO_NO, WO_NO,WO_ISS_DT,INV_CFM_DT,WO_ISS_USR_ID," ).append("\n"); 
		query.append("		TRSP_CRR_MOD_CD,WO_VNDR_SEQ,VNDR_NAME,FM_NOD_CD,VIA_NOD_CD,TO_NOD_CD,DOR_NOD_CD," ).append("\n"); 
		query.append("		DOOR_FCTRY_NM,DOOR_ZIP," ).append("\n"); 
		query.append("		OPTM_TRSP_MOD_CD,OPTM_SP_CODE,OPTM_SP_NAME,OPTM_FROM_NODE,OPTM_VIA_NODE,OPTM_TO_NODE,OPTM_DOOR_NODE," ).append("\n"); 
		query.append("		POR_CD,POL_CD,POD_CD,DEL_CD," ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		-- 20121011 Added  By SBKIM (Remark)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		NOT_OPTM_RSN," ).append("\n"); 
		query.append("		CNG_RSN_DESC," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- 20121011 Added  By SBKIM" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		SHPR_CUST_NM,CNEE_CUST_NM," ).append("\n"); 
		query.append("		TOT_KNT," ).append("\n"); 
		query.append("		MOD_COLR_FLG,FM_COLR_FLG,VIA_COLR_FLG,TO_COLR_FLG,DOR_COLR_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT	/*+ ORDERED */" ).append("\n"); 
		query.append("					DECODE(SO_DSCR_RSN_CD, 'M', 'YES','NO') OPTM_ROUT_PASS_FLG,  -- 신규" ).append("\n"); 
		query.append("					DECODE(PASS_TP_CD, 'A', 'Alternative', '') PASS_TYPE," ).append("\n"); 
		query.append("					A.CRE_OFC_CD                      WO_CRE_OFC_CD, -- wo create office" ).append("\n"); 
		query.append("					ETRO.CFM_OFC_CD TRO_OFC_CD," ).append("\n"); 
		query.append("                    B.TRSP_CRR_MOD_CD TRSP_MOD_CD," ).append("\n"); 
		query.append("					DECODE(DSCR_RSN_CD, 'M', NULL, DRCD.DSCR_RSN_DESC) DSCR_RSN_DESC," ).append("\n"); 
		query.append("					DECODE(B.TRSP_BND_CD, 'O', BKGM.POL_NOD_CD, BKGM.POD_NOD_CD) BKG_FM_NOD_CD,  -- bkg나 trs의 from / to" ).append("\n"); 
		query.append("					DECODE((SELECT  MAX(OFC_CD)" ).append("\n"); 
		query.append("                            FROM    MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                            WHERE   DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND OFC_KND_CD = '2'" ).append("\n"); 
		query.append("                            AND LENGTH(OFC_CD)=5" ).append("\n"); 
		query.append("                            CONNECT BY PRIOR PRNT_OFC_CD =  OFC_CD" ).append("\n"); 
		query.append("                            START WITH OFC_CD IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(REPLACE(@[input_office],'#',','), ','))))" ).append("\n"); 
		query.append("                            ,'HAMUR'" ).append("\n"); 
		query.append("        					,NVL((SELECT  ZN_CD" ).append("\n"); 
		query.append("                                 FROM BKG_EUR_TRO_DTL TD" ).append("\n"); 
		query.append("                                    , SCE_TRO_MAPG M" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                 AND B.COP_NO = M.COP_NO" ).append("\n"); 
		query.append("                                 AND TD.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                                 AND TD.IO_BND_CD = M.IO_BND_CD" ).append("\n"); 
		query.append("                                 AND TD.TRO_SEQ = M.TRO_SEQ" ).append("\n"); 
		query.append("                                 AND TD.ZN_CD IS NOT NULL" ).append("\n"); 
		query.append("                                 AND TD.DOR_ADDR_TP_CD = 'D'" ).append("\n"); 
		query.append("                                 AND ROWNUM=1)" ).append("\n"); 
		query.append("					           , DECODE(B.TRSP_BND_CD, 'O', BKGM.POR_NOD_CD, BKGM.DEL_NOD_CD))" ).append("\n"); 
		query.append("                            ,'SHAAS',DECODE(B.TRSP_BND_CD, 'O', BKGM.POR_NOD_CD, BKGM.DEL_NOD_CD)" ).append("\n"); 
		query.append("                            ,'SINWA',DECODE(B.TRSP_BND_CD, 'O', BKGM.POR_NOD_CD, BKGM.DEL_NOD_CD))" ).append("\n"); 
		query.append("						BKG_DOR_NOD_CD,   -- bkg나 trs의 from / to" ).append("\n"); 
		query.append("					NVL(COPM.CNTR_NO, B.EQ_NO) EQ_NO," ).append("\n"); 
		query.append("					B.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("					B.TRSP_BND_CD," ).append("\n"); 
		query.append("					B.TRSP_COST_DTL_MOD_CD ," ).append("\n"); 
		query.append("					B.BKG_NO," ).append("\n"); 
		query.append("					BKGM.SC_NO," ).append("\n"); 
		query.append("					BKGM.RFA_NO," ).append("\n"); 
		query.append("					BKGM.TAA_NO," ).append("\n"); 
		query.append("					B.TRO_SEQ," ).append("\n"); 
		query.append("					B.TRSP_SO_OFC_CTY_CD || B.TRSP_SO_SEQ SO_NO," ).append("\n"); 
		query.append("					A.TRSP_WO_OFC_CTY_CD || A.TRSP_WO_SEQ WO_NO," ).append("\n"); 
		query.append("					TO_CHAR(A.LOCL_UPD_DT, 'YYYY-MM-DD') AS WO_ISS_DT ," ).append("\n"); 
		query.append("                    TO_CHAR(I.INV_CFM_DT, 'YYYY-MM-DD') AS INV_CFM_DT ," ).append("\n"); 
		query.append("					A.CRE_USR_ID WO_ISS_USR_ID, --" ).append("\n"); 
		query.append("					B.TRSP_CRR_MOD_CD ," ).append("\n"); 
		query.append("					DECODE( A.HJL_NO, NULL, B.VNDR_SEQ, J.HJL_VNDR_SEQ ) WO_VNDR_SEQ ," ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("					   SELECT  VNDR.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("					   FROM    MDM_VENDOR   VNDR" ).append("\n"); 
		query.append("					   WHERE   VNDR.VNDR_SEQ   =   DECODE( A.HJL_NO, NULL, B.VNDR_SEQ, J.HJL_VNDR_SEQ )" ).append("\n"); 
		query.append("					)  VNDR_NAME," ).append("\n"); 
		query.append("					B.FM_NOD_CD," ).append("\n"); 
		query.append("					B.VIA_NOD_CD," ).append("\n"); 
		query.append("					B.TO_NOD_CD," ).append("\n"); 
		query.append("					B.DOR_NOD_CD," ).append("\n"); 
		query.append("					REPLACE(REPLACE(REPLACE(B.FCTRY_NM, CHR(13), ' '), CHR(10), ' '), CHR(34), '') AS DOOR_FCTRY_NM," ).append("\n"); 
		query.append("					B.DOR_PST_CD DOOR_ZIP," ).append("\n"); 
		query.append("					DECODE(B.PASS_TP_CD, 'A', OPTM.IRG_TRSP_CRR_MOD_CD, OPTM.TRSP_CRR_MOD_CD) OPTM_TRSP_MOD_CD," ).append("\n"); 
		query.append("					DECODE(B.PASS_TP_CD, 'A', OPTM.IRG_N1ST_VNDR_SEQ, OPTM.VNDR_SEQ) OPTM_SP_CODE," ).append("\n"); 
		query.append("					DECODE(B.PASS_TP_CD, 'A'," ).append("\n"); 
		query.append("					                         CASE WHEN OPTM.IRG_N1ST_VNDR_SEQ IS NOT NULL THEN OPVN2.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("						                     WHEN OPTM.IRG_N1ST_VNDR_SEQ IS NULL AND B.SO_DSCR_RSN_CD = 'R' THEN 'Multi S/P' END," ).append("\n"); 
		query.append("						                     CASE WHEN OPTM.VNDR_SEQ IS NOT NULL THEN OPVN.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("						                     WHEN OPTM.VNDR_SEQ IS NULL AND B.SO_DSCR_RSN_CD = 'R' THEN 'Multi S/P' END) OPTM_SP_NAME," ).append("\n"); 
		query.append("					DECODE(B.PASS_TP_CD, 'A', OPTM.IRG_FM_NOD_CD, OPTM.FM_NOD_CD) OPTM_FROM_NODE," ).append("\n"); 
		query.append("					DECODE(B.PASS_TP_CD, 'A', OPTM.IRG_VIA_NOD_CD, OPTM.VIA_NOD_CD) OPTM_VIA_NODE," ).append("\n"); 
		query.append("					DECODE(B.PASS_TP_CD, 'A', OPTM.IRG_TO_NOD_CD, OPTM.TO_NOD_CD) OPTM_TO_NODE," ).append("\n"); 
		query.append("					DECODE(B.PASS_TP_CD, 'A', OPTM.IRG_DOR_NOD_CD, OPTM.DOR_NOD_CD) OPTM_DOOR_NODE," ).append("\n"); 
		query.append("					B.POR_CD," ).append("\n"); 
		query.append("					B.POL_CD," ).append("\n"); 
		query.append("					B.POD_CD," ).append("\n"); 
		query.append("					B.DEL_CD," ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("					-- 20121011 Added  By SBKIM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					REPLACE (ETRO.NOT_OPTM_RSN, CHR (13) || CHR (10),' ') AS NOT_OPTM_RSN," ).append("\n"); 
		query.append("					REPLACE (B.CNG_RSN_DESC,	CHR (13) || CHR (10),' ') AS CNG_RSN_DESC," ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					-- 20121011 Added  By SBKIM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					REPLACE (SHPR.CUST_NM, CHR (13) || CHR (10),' ') AS SHPR_CUST_NM," ).append("\n"); 
		query.append("					REPLACE (CNEE.CUST_NM, CHR (13) || CHR (10),' ') AS CNEE_CUST_NM," ).append("\n"); 
		query.append("					CASE WHEN SO_DSCR_RSN_CD = 'M' THEN NULL" ).append("\n"); 
		query.append("						 WHEN B.TRSP_CRR_MOD_CD <> OPTM.TRSP_CRR_MOD_CD THEN 'Y' " ).append("\n"); 
		query.append("					END AS MOD_COLR_FLG," ).append("\n"); 
		query.append("					CASE WHEN SO_DSCR_RSN_CD IN('M','N','I') THEN NULL" ).append("\n"); 
		query.append("						 WHEN B.TRSP_BND_CD = 'O' AND B.TRSP_COST_DTL_MOD_CD = 'DR' THEN NULL" ).append("\n"); 
		query.append("						 WHEN B.TRSP_BND_CD = 'O' AND OPTM.DOR_NOD_CD IS NOT NULL THEN NULL" ).append("\n"); 
		query.append("						 WHEN SO_DSCR_RSN_CD = 'P' AND B.TRSP_BND_CD = 'I' THEN 'Y'" ).append("\n"); 
		query.append("						 WHEN SO_DSCR_RSN_CD = 'O' AND B.TRSP_BND_CD = 'O' AND B.TRSP_COST_DTL_MOD_CD = 'CY' THEN 'Y'" ).append("\n"); 
		query.append("						 WHEN (NOT(B.TRSP_BND_CD = 'O' AND B.TRSP_COST_DTL_MOD_CD = 'DR')) AND B.FM_NOD_CD <> OPTM.FM_NOD_CD THEN 'Y' " ).append("\n"); 
		query.append("					END AS FM_COLR_FLG," ).append("\n"); 
		query.append("					CASE WHEN SO_DSCR_RSN_CD IN('M','N','I', 'P') THEN NULL" ).append("\n"); 
		query.append("						 WHEN NVL(B.VIA_NOD_CD, 'X') <> NVL(OPTM.VIA_NOD_CD, 'X') THEN 'Y' " ).append("\n"); 
		query.append("					END AS VIA_COLR_FLG," ).append("\n"); 
		query.append("					CASE WHEN SO_DSCR_RSN_CD IN('M','N','I') THEN NULL" ).append("\n"); 
		query.append("						 WHEN B.TRSP_BND_CD = 'I' AND B.TRSP_COST_DTL_MOD_CD = 'DR' THEN NULL" ).append("\n"); 
		query.append("						 WHEN B.TRSP_BND_CD = 'I' AND OPTM.DOR_NOD_CD IS NOT NULL THEN NULL" ).append("\n"); 
		query.append("						 WHEN SO_DSCR_RSN_CD = 'P' AND B.TRSP_BND_CD = 'O' THEN 'Y'" ).append("\n"); 
		query.append("						 WHEN SO_DSCR_RSN_CD = 'D' AND B.TRSP_BND_CD = 'I' AND B.TRSP_COST_DTL_MOD_CD = 'CY' THEN 'Y'" ).append("\n"); 
		query.append("						 WHEN (NOT(B.TRSP_BND_CD = 'I' AND B.TRSP_COST_DTL_MOD_CD = 'DR')) AND B.TO_NOD_CD <> OPTM.TO_NOD_CD THEN 'Y' " ).append("\n"); 
		query.append("					END AS TO_COLR_FLG," ).append("\n"); 
		query.append("					CASE WHEN SO_DSCR_RSN_CD IN('M','N','I') THEN NULL" ).append("\n"); 
		query.append("						 WHEN B.TRSP_COST_DTL_MOD_CD = 'DR' AND NVL(B.DOR_NOD_CD, 'X') <> NVL(OPTM.DOR_NOD_CD, 'X') THEN 'Y' " ).append("\n"); 
		query.append("						 WHEN B.TRSP_BND_CD = 'I' AND B.TRSP_COST_DTL_MOD_CD = 'CY' AND OPTM.DOR_NOD_CD IS NOT NULL THEN 'Y' " ).append("\n"); 
		query.append("						 WHEN B.TRSP_BND_CD = 'O' AND B.TRSP_COST_DTL_MOD_CD = 'CY' AND OPTM.DOR_NOD_CD IS NOT NULL AND NVL(B.DOR_NOD_CD, 'X') <> NVL(OPTM.DOR_NOD_CD, 'X') THEN 'Y' " ).append("\n"); 
		query.append("					END AS DOR_COLR_FLG," ).append("\n"); 
		query.append("					COUNT(1) OVER() TOT_KNT," ).append("\n"); 
		query.append("					ROW_NUMBER() OVER (ORDER BY DECODE(DSCR_RSN_CD, 'M', 'Y','N'), A.CRE_OFC_CD, B.TRSP_CRR_MOD_CD, DP_ODR ) ODR_NO" ).append("\n"); 
		query.append("			FROM	" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                       SELECT INV_NO, INV_VNDR_SEQ, INV_CFM_DT FROM TRS_TRSP_INV_WRK C" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("                          AND C.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),	'YYYYMMDD')" ).append("\n"); 
		query.append("											AND		TO_DATE(REPLACE(@[to_date],'-',''),		'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					 ) I," ).append("\n"); 
		query.append("					TRS_TRSP_SVC_ORD			B ," ).append("\n"); 
		query.append("					TRS_TRSP_WRK_ORD			A ," ).append("\n"); 
		query.append("					TRS_TRSP_HJL_SVC_ORD        J ,   -- /* 20121113 ETS Vendor 반영 By  S.B.Kim */" ).append("\n"); 
		query.append("					BKG_CUSTOMER				SHPR ," ).append("\n"); 
		query.append("					BKG_CUSTOMER				CNEE ," ).append("\n"); 
		query.append("					BKG_EUR_TRO				ETRO ," ).append("\n"); 
		query.append("					(	" ).append("\n"); 
		query.append("							SELECT	INTG_CD_VAL_CTNT DSCR_RSN_CD, INTG_CD_VAL_DP_DESC DSCR_RSN_DESC, INTG_CD_VAL_DP_SEQ DP_ODR" ).append("\n"); 
		query.append("							FROM	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("							WHERE	INTG_CD_ID = 'CD03059'" ).append("\n"); 
		query.append("					) DRCD ," ).append("\n"); 
		query.append("					TRS_TRSP_OPTM_INLND_ROUT	OPTM ," ).append("\n"); 
		query.append("					MDM_VENDOR				OPVN ," ).append("\n"); 
		query.append("					MDM_VENDOR              OPVN2," ).append("\n"); 
		query.append("					BKG_BOOKING				BKGM ," ).append("\n"); 
		query.append("					SCE_COP_HDR				COPM" ).append("\n"); 
		query.append("			WHERE	1=1" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("			AND     B.INV_NO = I.INV_NO(+)" ).append("\n"); 
		query.append("			AND     B.INV_VNDR_SEQ = I.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sel_date} == 'inv')" ).append("\n"); 
		query.append("			AND     B.INV_NO = I.INV_NO" ).append("\n"); 
		query.append("			AND     B.INV_VNDR_SEQ = I.INV_VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND     B.BKG_NO		IS NOT NULL" ).append("\n"); 
		query.append("			AND		B.TRSP_BND_CD	IN ('I','O')" ).append("\n"); 
		query.append("			AND		B.DELT_FLG            	= 'N'" ).append("\n"); 
		query.append("			AND		B.SO_DSCR_RSN_CD		IS NOT NULL			" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			AND		B.TRSP_SO_OFC_CTY_CD	= J.TRSP_SO_OFC_CTY_CD	(+)    -- /* 20121113 ETS Vendor 반영 By  S.B.Kim */" ).append("\n"); 
		query.append("			AND		B.TRSP_SO_SEQ	        = J.TRSP_SO_SEQ	        (+)    -- /* 20121113 ETS Vendor 반영 By  S.B.Kim */" ).append("\n"); 
		query.append("			AND		B.LOCL_CRE_DT			>= TO_DATE('20120701', 'YYYYMMDD')  -- System Open시 처리" ).append("\n"); 
		query.append("#if(${sel_date} == 'wo')" ).append("\n"); 
		query.append("			AND		A.LOCL_UPD_DT			BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),	'YYYYMMDD')" ).append("\n"); 
		query.append("											AND		TO_DATE(REPLACE(@[to_date],'-',''),		'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_node} != '') " ).append("\n"); 
		query.append("            AND DECODE(B.TRSP_BND_CD, 'O', BKGM.POL_NOD_CD, BKGM.POD_NOD_CD) LIKE @[from_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${door_node} != '') " ).append("\n"); 
		query.append("            AND NVL((SELECT  ZN_CD" ).append("\n"); 
		query.append("                         FROM BKG_EUR_TRO_DTL TD" ).append("\n"); 
		query.append("                            , SCE_TRO_MAPG M" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                         AND B.COP_NO = M.COP_NO" ).append("\n"); 
		query.append("                         AND TD.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                         AND TD.IO_BND_CD = M.IO_BND_CD" ).append("\n"); 
		query.append("                         AND TD.TRO_SEQ = M.TRO_SEQ" ).append("\n"); 
		query.append("                         AND TD.ZN_CD IS NOT NULL" ).append("\n"); 
		query.append("                         AND TD.DOR_ADDR_TP_CD = 'D'" ).append("\n"); 
		query.append("                         AND ROWNUM=1)" ).append("\n"); 
		query.append("					   , DECODE(B.TRSP_BND_CD, 'O', BKGM.POR_NOD_CD, BKGM.DEL_NOD_CD)) LIKE @[door_node]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			AND		B.TRSP_WO_OFC_CTY_CD	= A.TRSP_WO_OFC_CTY_CD	" ).append("\n"); 
		query.append("			AND		B.TRSP_WO_SEQ			= A.TRSP_WO_SEQ	" ).append("\n"); 
		query.append("			AND		SHPR.BKG_NO(+)			= B.BKG_NO" ).append("\n"); 
		query.append("			AND		SHPR.BKG_CUST_TP_CD(+)	= 'S'" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND		CNEE.BKG_NO(+)			= B.BKG_NO" ).append("\n"); 
		query.append("			AND		CNEE.BKG_CUST_TP_CD(+)	= 'C'" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			AND		ETRO.BKG_NO		(+)		= B.BKG_NO" ).append("\n"); 
		query.append("			AND		ETRO.IO_BND_CD	(+)		= B.TRSP_BND_CD" ).append("\n"); 
		query.append("			AND		ETRO.TRO_SEQ	(+)		= B.TRO_SEQ" ).append("\n"); 
		query.append("			AND		ETRO.HLG_TP_CD(+)		= 'C'" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND		DRCD.DSCR_RSN_CD		= B.SO_DSCR_RSN_CD" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			AND		OPTM.TRSP_SO_OFC_CTY_CD(+)	= B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			AND		OPTM.TRSP_SO_SEQ(+)			= B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND		OPVN.VNDR_SEQ(+)			= OPTM.VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND		OPVN2.VNDR_SEQ(+)			= OPTM.IRG_N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND		B.BKG_NO				=	BKGM.BKG_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			AND		B.COP_NO				=	COPM.COP_NO" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			AND		B.SO_DSCR_RSN_CD IN (" ).append("\n"); 
		query.append("											SELECT	INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("											FROM	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("											WHERE	INTG_CD_ID = 'CD03059'" ).append("\n"); 
		query.append("											AND		(  " ).append("\n"); 
		query.append("															(@[optm_rout_pass_flg] = 'A' AND (@[dscr_rsn_cd] = 'A' OR INSTR(@[dscr_rsn_cd], INTG_CD_VAL_CTNT) > 0)) -- ALL/ALL" ).append("\n"); 
		query.append("														OR	(@[optm_rout_pass_flg] = 'Y' AND INTG_CD_VAL_CTNT = 'M') -- Optimum Route일 경우 세부는 무시" ).append("\n"); 
		query.append("														OR	(@[optm_rout_pass_flg] = 'N' AND INTG_CD_VAL_CTNT <> 'M' AND (@[dscr_rsn_cd] = 'A' OR INSTR(@[dscr_rsn_cd], INTG_CD_VAL_CTNT) > 0))" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("		#if (${sel_op_tp} == 'SINGLE')" ).append("\n"); 
		query.append("			AND A.CRE_OFC_CD IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(@[input_office], ',')))" ).append("\n"); 
		query.append("			AND B.TRSP_BND_CD = @[bnd_cd]" ).append("\n"); 
		query.append("			and B.TRSP_CRR_MOD_CD IN	(" ).append("\n"); 
		query.append("											SELECT	INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("											FROM	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("											WHERE	INTG_CD_ID = 'CD00283'" ).append("\n"); 
		query.append("											AND		(" ).append("\n"); 
		query.append("														INSTR(@[trsp_mod_cd], INTG_CD_VAL_CTNT) > 0" ).append("\n"); 
		query.append("														OR " ).append("\n"); 
		query.append("														@[trsp_mod_cd] = 'ALL'" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("										 )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${sel_op_tp} != 'SINGLE')" ).append("\n"); 
		query.append("			AND	(A.CRE_OFC_CD, b.TRSP_BND_CD, b.TRSP_CRR_MOD_CD )" ).append("\n"); 
		query.append("				IN (" ).append("\n"); 
		query.append("			  #foreach ($user_condtions IN ${condtions})" ).append("\n"); 
		query.append("				#if($velocityCount < $condtions.size())" ).append("\n"); 
		query.append("				  $user_condtions," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				  $user_condtions" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${sel_so_no} != '') " ).append("\n"); 
		query.append("            AND (B.TRSP_SO_OFC_CTY_CD, B.TRSP_SO_SEQ) IN (  (SUBSTR(@[sel_so_no],1,3),SUBSTR(@[sel_so_no],4))  )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) SUBQ" ).append("\n"); 
		query.append("WHERE ODR_NO <= DECODE(@[exl_flg], 'N', 2000, TOT_KNT)" ).append("\n"); 
		query.append("ORDER BY ODR_NO" ).append("\n"); 

	}
}