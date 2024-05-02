/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnStwgCargoApprovalDBDAOSearchSSApprovalStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnStwgCargoApprovalDBDAOSearchSSApprovalStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG Stwg의 신청 및 승인에 대한 Status를 조회한다.
	  * </pre>
	  */
	public OwnStwgCargoApprovalDBDAOSearchSSApprovalStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("booking_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnStwgCargoApprovalDBDAOSearchSSApprovalStatusListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	DECODE(A.VSL_PRE_PST_CD,'S','Pre'||A.VSL_SEQ,'T','Trunk','U','Post'||A.VSL_SEQ) AS VSL_PRE_PST_NM," ).append("\n"); 
		query.append("	A.SPCL_CGO_APRO_RQST_SEQ," ).append("\n"); 
		query.append("	A.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("	A.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("	C.SPCL_CGO_AUTH_SEQ," ).append("\n"); 
		query.append("	A.VSL_SEQ,	" ).append("\n"); 
		query.append("	A.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("	A.SLAN_CD," ).append("\n"); 
		query.append("	A.VSL_CD," ).append("\n"); 
		query.append("	A.SKD_VOY_NO," ).append("\n"); 
		query.append("	A.SKD_DIR_CD," ).append("\n"); 
		query.append("	A.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("	A.BKG_NO," ).append("\n"); 
		query.append("	A.BKG_STS_CD," ).append("\n"); 
		query.append("	A.DG_CNTR_SEQ," ).append("\n"); 
		query.append("	A.CNTR_CGO_SEQ,	" ).append("\n"); 
		query.append("	DECODE(A.SPCL_RQST_FLG, 'Y','S','')||'R'||A.SPCL_CGO_RQST_SEQ AS RQST_AUTH_CD," ).append("\n"); 
		query.append("	A.RQST_OFC_CD," ).append("\n"); 
		query.append("	TO_CHAR(A.RQST_DT,'YYYY-MM-DD') AS RQST_DT,	" ).append("\n"); 
		query.append("	TO_CHAR(A.RQST_GDT,'YYYY-MM-DD') AS RQST_GDT,	" ).append("\n"); 
		query.append("	A.RQST_USR_ID," ).append("\n"); 
		query.append("	DECODE(A.SPCL_CGO_APRO_CD,'D','D','C','C',DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'','C',C.SPCL_CGO_AUTH_CD),C.SPCL_CGO_AUTH_CD)) AS SPCL_CGO_AUTH_CD," ).append("\n"); 
		query.append("	DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'',(SELECT TO_CHAR(A.RQST_DT,'YYYY-MM-DD') FROM SCG_APRO_RQST H WHERE H.BKG_NO = A.BKG_NO AND H.SPCL_CGO_CATE_CD = A.SPCL_CGO_CATE_CD AND H.SPCL_CGO_RQST_SEQ = A.SPCL_CGO_RQST_SEQ),TO_CHAR(C.AUTH_DT,'YYYY-MM-DD')),TO_CHAR(C.AUTH_DT,'YYYY-MM-DD')) AS AUTH_DT," ).append("\n"); 
		query.append("	DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'',(SELECT TO_CHAR(A.RQST_GDT,'YYYY-MM-DD') FROM SCG_APRO_RQST H WHERE H.BKG_NO = A.BKG_NO AND H.SPCL_CGO_CATE_CD = A.SPCL_CGO_CATE_CD AND H.SPCL_CGO_RQST_SEQ = A.SPCL_CGO_RQST_SEQ),TO_CHAR(C.AUTH_GDT,'YYYY-MM-DD')),TO_CHAR(C.AUTH_GDT,'YYYY-MM-DD')) AS AUTH_GDT," ).append("\n"); 
		query.append("	DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'','SYSTEM',C.AUTH_USR_ID),C.AUTH_USR_ID) AS AUTH_USR_ID," ).append("\n"); 
		query.append("	DECODE(A.SPCL_CGO_APRO_CD,'D',C.SPCL_CGO_AUTH_RJCT_CD,'C',C.SPCL_CGO_AUTH_RJCT_CD,DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'','SYS',C.SPCL_CGO_AUTH_RJCT_CD),C.SPCL_CGO_AUTH_RJCT_CD)) AS SPCL_CGO_AUTH_RJCT_CD," ).append("\n"); 
		query.append("	DECODE(A.SPCL_CGO_APRO_CD,'D',C.SPCL_CGO_AUTH_RMK,'C',C.SPCL_CGO_AUTH_RMK,DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'','Reapplication',C.SPCL_CGO_AUTH_RMK),C.SPCL_CGO_AUTH_RMK)) AS SPCL_CGO_AUTH_RMK," ).append("\n"); 
		query.append("	A.POL_CD," ).append("\n"); 
		query.append("	A.POD_CD," ).append("\n"); 
		query.append("    C.APRO_REF_NO," ).append("\n"); 
		query.append("	A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	'SS' AS SCG_FLG," ).append("\n"); 
		query.append("	A.IMDG_UN_NO," ).append("\n"); 
		query.append("	A.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("	A.IMDG_CLSS_CD,	" ).append("\n"); 
		query.append("    A.IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("    A.MRN_POLUT_FLG," ).append("\n"); 
		query.append("	A.IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("	A.IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("	A.IMDG_EXPT_QTY_FLG," ).append("\n"); 
		query.append("	A.FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("    A.OP_CNTR_QTY ," ).append("\n"); 
		query.append("    (SELECT CASE WHEN (SELECT COUNT(BKG_NO) FROM BKG_QUANTITY WHERE BKG_NO = A.BKG_NO ) > 1 THEN (CASE WHEN A.OP_CNTR_QTY = COUNT(C.BKG_NO) THEN SUM(NVL2(C.WGT_UT_CD, TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(C.WGT_UT_CD, C.CNTR_WGT), 0))||''" ).append("\n"); 
		query.append("                                                                                                       ELSE ''" ).append("\n"); 
		query.append("                                                                                                  END)       " ).append("\n"); 
		query.append("                 ELSE (CASE WHEN A.OP_CNTR_QTY = COUNT(C.BKG_NO) THEN SUM(NVL2(C.WGT_UT_CD, TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(C.WGT_UT_CD, C.CNTR_WGT), 0))||''" ).append("\n"); 
		query.append("                            ELSE MAX(NVL2(D.WGT_UT_CD, TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(D.WGT_UT_CD, D.ACT_WGT), 0))||''" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("            END GRS_WGT" ).append("\n"); 
		query.append("       FROM BKG_CONTAINER C,  BKG_BL_DOC D" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("        AND D.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND C.BKG_NO(+) = D.BKG_NO" ).append("\n"); 
		query.append("        AND C.CNTR_TPSZ_CD(+) = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      GROUP BY A.BKG_NO, A.CNTR_TPSZ_CD       " ).append("\n"); 
		query.append("    ) GRS_WGT," ).append("\n"); 
		query.append("	A.NET_WGT," ).append("\n"); 
		query.append("	A.IN_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("	A.OUT_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("	A.INTMD_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("	A.PSA_NO," ).append("\n"); 
		query.append("	A.HCDG_FLG," ).append("\n"); 
		query.append("	A.SPCL_RQST_DESC," ).append("\n"); 
		query.append("    A.DCGO_FLG,           --@@" ).append("\n"); 
		query.append("    A.RC_FLG,                --@@" ).append("\n"); 
		query.append("    A.AWK_CGO_FLG,     --@@" ).append("\n"); 
		query.append("    A.BB_CGO_FLG,         --@@  " ).append("\n"); 
		query.append("	A.STWG_CD," ).append("\n"); 
		query.append("    A.CMDT_NM" ).append("\n"); 
		query.append("FROM (    " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, C.VSL_SEQ ORDER BY A.BKG_NO) SEQ," ).append("\n"); 
		query.append("    	A.BKG_NO," ).append("\n"); 
		query.append("		A.BKG_STS_CD," ).append("\n"); 
		query.append("    	C.SLAN_CD," ).append("\n"); 
		query.append("    	B.SPCL_CGO_APRO_RQST_SEQ,     " ).append("\n"); 
		query.append("    	B.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("		B.SPCL_BKG_RQST_FLG," ).append("\n"); 
		query.append("        B.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("    	B.RQST_OFC_CD," ).append("\n"); 
		query.append("    	B.RQST_DT," ).append("\n"); 
		query.append("    	B.RQST_GDT," ).append("\n"); 
		query.append("    	B.RQST_USR_ID," ).append("\n"); 
		query.append("		B.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("    	C.VSL_CD," ).append("\n"); 
		query.append("    	C.SKD_VOY_NO," ).append("\n"); 
		query.append("    	C.SKD_DIR_CD," ).append("\n"); 
		query.append("        C.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("        C.VSL_SEQ," ).append("\n"); 
		query.append("    	C.POL_CD," ).append("\n"); 
		query.append("    	C.POD_CD," ).append("\n"); 
		query.append("		'' DCGO_SEQ," ).append("\n"); 
		query.append("		'' DG_CNTR_SEQ," ).append("\n"); 
		query.append("		'' CNTR_CGO_SEQ,	" ).append("\n"); 
		query.append("		'' IMDG_UN_NO," ).append("\n"); 
		query.append("		'' IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("		'' IMDG_CLSS_CD,	" ).append("\n"); 
		query.append("    	'' IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("	    '' MRN_POLUT_FLG," ).append("\n"); 
		query.append("		'' IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("		'' IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("		'' IMDG_EXPT_QTY_FLG," ).append("\n"); 
		query.append("		'' FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("		'' GRS_WGT," ).append("\n"); 
		query.append("		'' NET_WGT," ).append("\n"); 
		query.append("		'' IN_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("		'' OUT_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("		'' INTMD_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("		'' PSA_NO," ).append("\n"); 
		query.append("		'' HCDG_FLG," ).append("\n"); 
		query.append("		'' SPCL_RQST_FLG," ).append("\n"); 
		query.append("		'' SPCL_RQST_DESC," ).append("\n"); 
		query.append("        A.DCGO_FLG,           --@@" ).append("\n"); 
		query.append("        A.RC_FLG,                --@@" ).append("\n"); 
		query.append("        A.AWK_CGO_FLG,     --@@" ).append("\n"); 
		query.append("        A.BB_CGO_FLG,        --@@   " ).append("\n"); 
		query.append("		S.STWG_CD," ).append("\n"); 
		query.append("        S.SPCL_CGO_APRO_CD," ).append("\n"); 
		query.append("        Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        Q.OP_CNTR_QTY," ).append("\n"); 
		query.append("        M.CMDT_NM" ).append("\n"); 
		query.append("	FROM BKG_BOOKING A, " ).append("\n"); 
		query.append("         SCG_APRO_RQST B, " ).append("\n"); 
		query.append("         SCG_VVD_APRO_RQST C," ).append("\n"); 
		query.append("         SCG_STWG_CGO S," ).append("\n"); 
		query.append("         BKG_QUANTITY Q," ).append("\n"); 
		query.append("         MDM_COMMODITY M" ).append("\n"); 
		query.append("	WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_CATE_CD = 'SS'" ).append("\n"); 
		query.append("	AND B.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("    AND B.SPCL_CGO_APRO_RQST_SEQ = S.SPCL_CGO_APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_APRO_RQST_SEQ = C.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("	AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("	AND B.LST_RQST_DAT_FLG = 'N'" ).append("\n"); 
		query.append("    AND Q.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("    AND M.CMDT_CD(+) = A.CMDT_CD " ).append("\n"); 
		query.append("	AND A.BKG_NO = @[booking_no]" ).append("\n"); 
		query.append("	#if (${vsl_cd} != '' && ${vsl_cd} != 'null')" ).append("\n"); 
		query.append("	AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, C.VSL_SEQ ORDER BY A.BKG_NO) SEQ," ).append("\n"); 
		query.append("    	A.BKG_NO," ).append("\n"); 
		query.append("		A.BKG_STS_CD," ).append("\n"); 
		query.append("    	C.SLAN_CD," ).append("\n"); 
		query.append("    	B.SPCL_CGO_APRO_RQST_SEQ,     " ).append("\n"); 
		query.append("    	B.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("		B.SPCL_BKG_RQST_FLG," ).append("\n"); 
		query.append("        B.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("    	B.RQST_OFC_CD," ).append("\n"); 
		query.append("    	B.RQST_DT," ).append("\n"); 
		query.append("    	B.RQST_GDT," ).append("\n"); 
		query.append("    	B.RQST_USR_ID," ).append("\n"); 
		query.append("		B.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("    	C.VSL_CD," ).append("\n"); 
		query.append("    	C.SKD_VOY_NO," ).append("\n"); 
		query.append("    	C.SKD_DIR_CD," ).append("\n"); 
		query.append("        C.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("        C.VSL_SEQ," ).append("\n"); 
		query.append("    	C.POL_CD," ).append("\n"); 
		query.append("    	C.POD_CD," ).append("\n"); 
		query.append("		'' DCGO_SEQ," ).append("\n"); 
		query.append("		'' DG_CNTR_SEQ," ).append("\n"); 
		query.append("		'' CNTR_CGO_SEQ,	" ).append("\n"); 
		query.append("		'' IMDG_UN_NO," ).append("\n"); 
		query.append("		'' IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("		'' IMDG_CLSS_CD,	" ).append("\n"); 
		query.append("    	'' IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("	    '' MRN_POLUT_FLG," ).append("\n"); 
		query.append("		'' IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("		'' IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("		'' IMDG_EXPT_QTY_FLG," ).append("\n"); 
		query.append("		'' FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("		'' GRS_WGT," ).append("\n"); 
		query.append("		'' NET_WGT," ).append("\n"); 
		query.append("		'' IN_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("		'' OUT_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("		'' INTMD_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("		'' PSA_NO," ).append("\n"); 
		query.append("		'' HCDG_FLG," ).append("\n"); 
		query.append("		'' SPCL_RQST_FLG," ).append("\n"); 
		query.append("		'' SPCL_RQST_DESC," ).append("\n"); 
		query.append("        A.DCGO_FLG,           --@@" ).append("\n"); 
		query.append("        A.RC_FLG,                --@@" ).append("\n"); 
		query.append("        A.AWK_CGO_FLG,     --@@" ).append("\n"); 
		query.append("        A.BB_CGO_FLG,        --@@   " ).append("\n"); 
		query.append("		S.STWG_CD," ).append("\n"); 
		query.append("        S.SPCL_CGO_APRO_CD," ).append("\n"); 
		query.append("        Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        Q.OP_CNTR_QTY," ).append("\n"); 
		query.append("        M.CMDT_NM" ).append("\n"); 
		query.append("	FROM BKG_BOOKING A, " ).append("\n"); 
		query.append("         SCG_APRO_RQST B, " ).append("\n"); 
		query.append("         SCG_VVD_APRO_RQST C," ).append("\n"); 
		query.append("         BKG_STWG_CGO S," ).append("\n"); 
		query.append("         BKG_QUANTITY Q," ).append("\n"); 
		query.append("         MDM_COMMODITY M" ).append("\n"); 
		query.append("	WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_CATE_CD = 'SS'" ).append("\n"); 
		query.append("	AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_APRO_RQST_SEQ = C.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("	AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("	AND B.LST_RQST_DAT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--::2015-07-06::--AND S.SPCL_CGO_APRO_CD is not null" ).append("\n"); 
		query.append("	--::2015-07-06::--AND D.SPCL_CGO_APRO_CD not in ('C','D')		" ).append("\n"); 
		query.append("	AND S.SPCL_CGO_APRO_CD <> 'D'" ).append("\n"); 
		query.append("    AND Q.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("    AND M.CMDT_CD(+) = A.CMDT_CD " ).append("\n"); 
		query.append("	AND A.BKG_NO = @[booking_no]" ).append("\n"); 
		query.append("	#if (${vsl_cd} != '' && ${vsl_cd} != 'null')" ).append("\n"); 
		query.append("	AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("	, 	SCG_AUTHORIZATION 			C" ).append("\n"); 
		query.append("WHERE 	A.BKG_NO 					= C.BKG_NO(+)" ).append("\n"); 
		query.append("AND 	A.SPCL_CGO_APRO_RQST_SEQ 	= C.SPCL_CGO_APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 	A.VSL_PRE_PST_CD 			= C.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("AND 	A.VSL_SEQ 					= C.VSL_SEQ(+)" ).append("\n"); 
		query.append("AND     A.SEQ                       = C.SPCL_CGO_AUTH_SEQ(+)" ).append("\n"); 
		query.append("/* 2015-08-14 by TOP */" ).append("\n"); 
		query.append("----AND 	A.DCGO_SEQ 				= C.DCGO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.SPCL_CGO_RQST_SEQ		ASC" ).append("\n"); 
		query.append("	, 	A.VSL_PRE_PST_CD			ASC" ).append("\n"); 
		query.append("	, 	A.VSL_SEQ					ASC" ).append("\n"); 
		query.append("	, 	A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD	ASC" ).append("\n"); 
		query.append("	,	A.BKG_NO					ASC" ).append("\n"); 
		query.append("	,	A.DG_CNTR_SEQ				ASC" ).append("\n"); 
		query.append("	,	A.CNTR_CGO_SEQ 				ASC" ).append("\n"); 

	}
}