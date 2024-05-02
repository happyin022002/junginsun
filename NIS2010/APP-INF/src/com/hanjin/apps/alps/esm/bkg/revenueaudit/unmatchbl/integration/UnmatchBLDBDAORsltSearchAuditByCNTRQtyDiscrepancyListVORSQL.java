/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchAuditByCNTRQtyDiscrepancyListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAORsltSearchAuditByCNTRQtyDiscrepancyListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAuditByCNTRQtyDiscrepancyListVO
	  * </pre>
	  */
	public UnmatchBLDBDAORsltSearchAuditByCNTRQtyDiscrepancyListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_gso_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bill_type_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bill_type_m",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_subst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bill_type_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bill_type_b",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltSearchAuditByCNTRQtyDiscrepancyListVORSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("BK AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT DECODE(BK.SPLIT_FLG, NULL, 'N', 'Y', 'S', BK.SPLIT_FLG) SPLIT_FLG   ," ).append("\n"); 
		query.append("           ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02376' AND INTG_CD_VAL_CTNT = DECODE(BK.SPLIT_FLG, NULL, 'N', 'Y', 'S', BK.SPLIT_FLG) ) SPLIT_NM, " ).append("\n"); 
		query.append("           ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE OFC_TP_CD = 'HQ' CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD START WITH OFC_CD = BK.BKG_OFC_CD ) AS BKG_RHQ_CD  ," ).append("\n"); 
		query.append("            (SELECT DECODE(BL.BDR_FLG, 'Y', 'Yes', 'No') FROM BKG_BL_DOC BL WHERE BK.BKG_NO=BL.BKG_NO)  BDR_FLG ," ).append("\n"); 
		query.append("			BR.RT_BL_TP_CD    ," ).append("\n"); 
		query.append("            ( SELECT TRIM(REPLACE(INTG_CD_VAL_DP_DESC, 'B/L', '')) FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01639' AND INTG_CD_VAL_CTNT = BR.RT_BL_TP_CD )  RT_BL_TP_NM," ).append("\n"); 
		query.append("           NVL((SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	          FROM COM_INTG_CD_DTL, BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("		      WHERE 1=1" ).append("\n"); 
		query.append("		      AND INTG_CD_ID = 'CD01568'" ).append("\n"); 
		query.append("		      AND INTG_CD_VAL_CTNT = A.RDN_STS_CD" ).append("\n"); 
		query.append("		      AND A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		      AND (A.RDN_NO, RVIS_SEQ ) IN  (SELECT RDN_NO, RVIS_SEQ FROM BKG_REV_DR_NOTE K" ).append("\n"); 
		query.append("                                                  WHERE K.BKG_NO =BK.BKG_NO" ).append("\n"); 
		query.append("                                                        AND K.CRE_DT = (SELECT MAX(CRE_DT) FROM BKG_REV_DR_NOTE P" ).append("\n"); 
		query.append("                                                                        WHERE 1=1" ).append("\n"); 
		query.append("                                                                          AND P.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("                                                                          AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                         )),' ') RDN_STS_NM," ).append("\n"); 
		query.append("                 NVL(( SELECT 'Charged' FROM BKG_CHG_RT RT WHERE BK.BKG_NO=RT.BKG_NO AND ROWNUM=1 ),'Non-Charged') CHARGE_FLG," ).append("\n"); 
		query.append("		    BK.BKG_OFC_CD  ," ).append("\n"); 
		query.append("            BK.BKG_NO      ," ).append("\n"); 
		query.append("            BK.BL_NO       ," ).append("\n"); 
		query.append("            BK.BKG_CRE_DT  ," ).append("\n"); 
		query.append("            BR.RT_APLY_DT  ," ).append("\n"); 
		query.append("            BK.SVC_SCP_CD  ," ).append("\n"); 
		query.append("            BK.FLEX_HGT_FLG," ).append("\n"); 
		query.append("            BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD VVD ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT  TO_DATE(PS.VPS_ETD_DT)" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  *" ).append("\n"); 
		query.append("                        FROM    (" ).append("\n"); 
		query.append("                                SELECT  BV.*  ," ).append("\n"); 
		query.append("                                        ROW_NUMBER() OVER ( PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ ) ROW_NUMBER" ).append("\n"); 
		query.append("                                FROM    BKG_VVD BV" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                        WHERE   ROW_NUMBER  = 1" ).append("\n"); 
		query.append("                        ) BV  ," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD  PS" ).append("\n"); 
		query.append("                WHERE   PS.VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("                AND     PS.SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     PS.SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     PS.VPS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("                AND     PS.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND     BV.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                ) POL_ETD      ," ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN    BK.TAA_NO IS NOT NULL THEN  'T'" ).append("\n"); 
		query.append("            WHEN    BK.RFA_NO IS NOT NULL THEN  'R'" ).append("\n"); 
		query.append("            ELSE    'S'" ).append("\n"); 
		query.append("            END BKG_CTRT_TP_CD  ," ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN    BK.TAA_NO IS NOT NULL THEN  BK.TAA_NO" ).append("\n"); 
		query.append("            WHEN    BK.RFA_NO IS NOT NULL THEN  BK.RFA_NO" ).append("\n"); 
		query.append("            ELSE    BK.SC_NO" ).append("\n"); 
		query.append("            END CTRT_NO" ).append("\n"); 
		query.append("    FROM    " ).append("\n"); 
		query.append("		#if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("            VSK_VSL_PORT_SKD VSK," ).append("\n"); 
		query.append("            BKG_VVD VVD," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            BKG_BOOKING  BK  ," ).append("\n"); 
		query.append("            BKG_RATE     BR	 ," ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bdr_flg} != '')" ).append("\n"); 
		query.append("            BKG_BL_DOC BL    ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("      	 	SELECT	OFC_CD " ).append("\n"); 
		query.append("      	 	FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("		 	WHERE	OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_gso_cd} != '') " ).append("\n"); 
		query.append("      	 	START WITH	A.OFC_CD		= @[bkg_gso_cd]" ).append("\n"); 
		query.append("      	 	CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      	 	START WITH	A.OFC_CD		= @[bkg_rhq_cd]" ).append("\n"); 
		query.append("      	 	CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		 	) OG" ).append("\n"); 
		query.append("    WHERE   1=1" ).append("\n"); 
		query.append("	#if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${from_dt} != '')" ).append("\n"); 
		query.append("			AND      VSK.VPS_ETD_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("  		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  		#if (${to_dt} != '')" ).append("\n"); 
		query.append("  			AND      VSK.VPS_ETD_DT <= TO_DATE (@[to_dt], 'YYYY-MM-DD') + 0.99999      /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		AND VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("		AND VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("		AND VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("		--AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("		AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		AND VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    AND     BK.BKG_NO	=   BR.BKG_NO" ).append("\n"); 
		query.append("	AND		BK.BKG_OFC_CD	= OG.OFC_CD" ).append("\n"); 
		query.append("	AND		BK.BKG_STS_CD	NOT IN ( 'X', 'A' )" ).append("\n"); 
		query.append("	AND		BK.BKG_CGO_TP_CD	<> 'P'" ).append("\n"); 
		query.append("	AND		NVL(BK.BL_NO_TP, 'N') <> '9'" ).append("\n"); 
		query.append("	AND		NVL(BR.RT_BL_TP_CD, 'N') NOT IN ( 'C', 'B' )" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   /* 조회조건 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${search_date} == 'BOOKING')" ).append("\n"); 
		query.append("		#if (${from_dt} != '')" ).append("\n"); 
		query.append("		AND BK.BKG_CRE_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${to_dt} != '')" ).append("\n"); 
		query.append("		AND BK.BKG_CRE_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#elseif (${search_date} == 'APPL')" ).append("\n"); 
		query.append("		#if (${from_dt} != '')" ).append("\n"); 
		query.append("		AND BR.RT_APLY_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${to_dt} != '')" ).append("\n"); 
		query.append("		AND BR.RT_APLY_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("    AND     BK.SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vvd} != '') " ).append("\n"); 
		query.append("    AND     BK.VSL_CD       LIKE SUBSTR(@[vvd], 1, 4) || '%'" ).append("\n"); 
		query.append("    AND     BK.SKD_VOY_NO   LIKE SUBSTR(@[vvd], 5, 4) || '%'" ).append("\n"); 
		query.append("    AND     BK.SKD_DIR_CD   LIKE SUBSTR(@[vvd], 9, 1) || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_ctrt_tp_cd} != '') " ).append("\n"); 
		query.append("    AND     CASE" ).append("\n"); 
		query.append("                 WHEN    BK.TAA_NO IS NOT NULL THEN  'T'" ).append("\n"); 
		query.append("                 WHEN    BK.RFA_NO IS NOT NULL THEN  'R'" ).append("\n"); 
		query.append("                 ELSE    'S'" ).append("\n"); 
		query.append("            END                     = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${ctrt_no} != '') " ).append("\n"); 
		query.append("    AND     CASE" ).append("\n"); 
		query.append("                 WHEN    BK.TAA_NO IS NOT NULL THEN  BK.TAA_NO" ).append("\n"); 
		query.append("                 WHEN    BK.RFA_NO IS NOT NULL THEN  BK.RFA_NO" ).append("\n"); 
		query.append("                 ELSE    BK.SC_NO" ).append("\n"); 
		query.append("            END                     LIKE @[ctrt_no] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${split_flg} == 'S')" ).append("\n"); 
		query.append("        AND     BK.SPLIT_FLG = 'Y'" ).append("\n"); 
		query.append("        #elseif (${split_flg} == 'N')" ).append("\n"); 
		query.append("        AND     (BK.SPLIT_FLG IS NULL OR BK.SPLIT_FLG = 'N')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("     #if (${bdr_flg} != '')" ).append("\n"); 
		query.append("        AND     BK.BKG_NO=BL.BKG_NO" ).append("\n"); 
		query.append("        AND     BL.BDR_FLG  = @[bdr_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bill_type_n} != '' || ${bill_type_m} != '' || ${bill_type_c} != '' || ${bill_type_b} != '')" ).append("\n"); 
		query.append("        AND     BR.RT_BL_TP_CD IN (@[bill_type_n], @[bill_type_m], @[bill_type_c], @[bill_type_b])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("BQ AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  BQ.BKG_NO   ," ).append("\n"); 
		query.append("		    CASE" ).append("\n"); 
		query.append("   			WHEN BQ.EQ_SUBST_CNTR_TPSZ_CD IS NOT NULL AND BQ.CNTR_TPSZ_CD NOT LIKE 'R%'" ).append("\n"); 
		query.append("   				THEN	BQ.EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   			ELSE	BQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   			END																											AS CTRT_CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("    		SUM(BQ.OP_CNTR_QTY)       			                    		AS OP_CNTR_QTY       ," ).append("\n"); 
		query.append("    		MAX(DECODE(BQ.EQ_SUBST_CNTR_TPSZ_CD, NULL, 'N', 'Y')) 	AS EQ_SUBST_FLG      ," ).append("\n"); 
		query.append("    		MAX(BQ.AWK_CGO_FLG)											              	AS AWK_CGO_FLG       ," ).append("\n"); 
		query.append("    		MAX(BQ.BB_CGO_FLG)   											            	AS BB_CGO_FLG        ," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER ( PARTITION BY BQ.BKG_NO" ).append("\n"); 
		query.append("							ORDER BY" ).append("\n"); 
		query.append("		   						CASE" ).append("\n"); 
		query.append("	   							WHEN BQ.EQ_SUBST_CNTR_TPSZ_CD IS NOT NULL AND BQ.CNTR_TPSZ_CD NOT LIKE 'R%'" ).append("\n"); 
		query.append("   									THEN	BQ.EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   								ELSE	BQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   								END" ).append("\n"); 
		query.append("						   ) AS DP_SEQ" ).append("\n"); 
		query.append("FROM    BK  ," ).append("\n"); 
		query.append("		    BKG_QTY_DTL BQ" ).append("\n"); 
		query.append("WHERE   BQ.BKG_NO    = BK.BKG_NO" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("				BQ.BKG_NO   ," ).append("\n"); 
		query.append("   			CASE" ).append("\n"); 
		query.append("   			WHEN BQ.EQ_SUBST_CNTR_TPSZ_CD IS NOT NULL AND BQ.CNTR_TPSZ_CD NOT LIKE 'R%'" ).append("\n"); 
		query.append("   				THEN	BQ.EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   			ELSE	BQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   			END" ).append("\n"); 
		query.append(")   ," ).append("\n"); 
		query.append("BR AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT  BR.BKG_NO     ," ).append("\n"); 
		query.append("            BR.CHG_CD     ," ).append("\n"); 
		query.append("            BR.RAT_UT_CD  ," ).append("\n"); 
		query.append("            BR.RAT_AS_QTY ," ).append("\n"); 
		query.append("            ROW_NUMBER() OVER ( PARTITION BY BR.BKG_NO ORDER BY BR.RAT_UT_CD ) DP_SEQ" ).append("\n"); 
		query.append("    FROM    BK  ," ).append("\n"); 
		query.append("            BKG_CHG_RT  BR" ).append("\n"); 
		query.append("    WHERE   BR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("    AND     BR.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   " ).append("\n"); 
		query.append("         DENSE_RANK() OVER( ORDER BY 		BK.BKG_RHQ_CD        ," ).append("\n"); 
		query.append("                                            BK.BKG_OFC_CD        ," ).append("\n"); 
		query.append("                                    		BK.CTRT_NO           ," ).append("\n"); 
		query.append("                                            BK.POL_ETD              ," ).append("\n"); 
		query.append("                                            BK.BL_NO			 " ).append("\n"); 
		query.append("        ) ROW_CNT," ).append("\n"); 
		query.append("        COUNT(DISTINCT BK.BKG_NO) OVER () AS BL_CNT," ).append("\n"); 
		query.append("        ( SELECT  UMCH_RSN_RMK  " ).append("\n"); 
		query.append("          FROM BKG_REV_AUD_RSLT UB " ).append("\n"); 
		query.append("          WHERE BK.BKG_NO=UB.BKG_NO " ).append("\n"); 
		query.append("          AND UB.BKG_REV_AUD_TP_CD='Q' " ).append("\n"); 
		query.append("          AND UB.CNTR_TPSZ_CD= BQ.CTRT_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ) UMCH_RSN_RMK ," ).append("\n"); 
		query.append("       ( SELECT RGN_GRP_AVC_RMK " ).append("\n"); 
		query.append("         FROM BKG_REV_AUD_RSLT UB " ).append("\n"); 
		query.append("           WHERE BK.BKG_NO=UB.BKG_NO " ).append("\n"); 
		query.append("             AND UB.BKG_REV_AUD_TP_CD='Q' " ).append("\n"); 
		query.append("             AND UB.CNTR_TPSZ_CD= BQ.CTRT_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             ) RGN_GRP_AVC_RMK,        " ).append("\n"); 
		query.append("        BK.BKG_RHQ_CD        , -- param" ).append("\n"); 
		query.append("        BK.BKG_OFC_CD        , -- param" ).append("\n"); 
		query.append("        BK.BKG_NO            ," ).append("\n"); 
		query.append("        BK.BL_NO             ," ).append("\n"); 
		query.append("        TO_CHAR(BK.BKG_CRE_DT, 'YYYY-MM-DD') AS BKG_CRE_DT ," ).append("\n"); 
		query.append("        TO_CHAR(BK.RT_APLY_DT, 'YYYY-MM-DD') AS RT_APLY_DT ," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD        , -- param" ).append("\n"); 
		query.append("        BK.VVD               , -- param" ).append("\n"); 
		query.append("        (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01716'" ).append("\n"); 
		query.append("         AND INTG_CD_VAL_CTNT = BK.BKG_CTRT_TP_CD) BKG_CTRT_TP_CD , -- param" ).append("\n"); 
		query.append("        BK.CTRT_NO           , -- param" ).append("\n"); 
		query.append("        BK.FLEX_HGT_FLG      ," ).append("\n"); 
		query.append("        BQ.CTRT_CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("        BQ.OP_CNTR_QTY       ," ).append("\n"); 
		query.append("        BR.CHG_CD            ," ).append("\n"); 
		query.append("        BR.RAT_UT_CD         ," ).append("\n"); 
		query.append("        BR.RAT_AS_QTY        ," ).append("\n"); 
		query.append("        BQ.EQ_SUBST_FLG      , -- param" ).append("\n"); 
		query.append("        BQ.AWK_CGO_FLG       , -- param" ).append("\n"); 
		query.append("        BQ.BB_CGO_FLG        , -- param" ).append("\n"); 
		query.append("        NVL((SELECT  MAX(RDN_NO) RDN_NO" ).append("\n"); 
		query.append("		 FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("		 WHERE   BKG_NO = BQ.BKG_NO), ' ') AS RDN_NO ," ).append("\n"); 
		query.append("        NULL AS FROM_DT      , -- param" ).append("\n"); 
		query.append("        NULL AS TO_DT        , -- param" ).append("\n"); 
		query.append("        NULL AS SEARCH_DATE  ,  -- param" ).append("\n"); 
		query.append("        SPLIT_FLG   ," ).append("\n"); 
		query.append("        SPLIT_NM ," ).append("\n"); 
		query.append("		BK.BDR_FLG ," ).append("\n"); 
		query.append("        RT_BL_TP_CD    ," ).append("\n"); 
		query.append("        RT_BL_TP_NM," ).append("\n"); 
		query.append("        RDN_STS_NM  ," ).append("\n"); 
		query.append("         CHARGE_FLG  , " ).append("\n"); 
		query.append("         TO_CHAR(BK.POL_ETD,'YYYY-MM-DD') POL_ETD ," ).append("\n"); 
		query.append("		DOC.MEAS_QTY   " ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("         SELECT  BK.*    ," ).append("\n"); 
		query.append("                 CP.DP_SEQ" ).append("\n"); 
		query.append("         FROM    BK  ," ).append("\n"); 
		query.append("                 ( SELECT ROWNUM DP_SEQ FROM DUAL CONNECT BY LEVEL <= 10 ) CP" ).append("\n"); 
		query.append("         WHERE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         /*******************************************************************************************" ).append("\n"); 
		query.append("         	불일치가 발생하는 BKG_NO 를 SELECT 한다." ).append("\n"); 
		query.append("         *******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         		 BK.BKG_NO IN" ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                         SELECT  NVL(BQ.BKG_NO, BR.BKG_NO)" ).append("\n"); 
		query.append("                         FROM    BQ" ).append("\n"); 
		query.append("                                 FULL OUTER JOIN BR" ).append("\n"); 
		query.append("                                 ON  BR.BKG_NO     = BQ.BKG_NO" ).append("\n"); 
		query.append("                                 AND BR.DP_SEQ     = BQ.DP_SEQ" ).append("\n"); 
		query.append("                                 AND BR.RAT_UT_CD  = BQ.CTRT_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 AND BR.RAT_AS_QTY = BQ.OP_CNTR_QTY" ).append("\n"); 
		query.append("                         GROUP BY" ).append("\n"); 
		query.append("                                 NVL(BQ.BKG_NO, BR.BKG_NO)" ).append("\n"); 
		query.append("                         HAVING  SUM(DECODE(BQ.DP_SEQ, NULL, 1, 0))  <> 0" ).append("\n"); 
		query.append("                         OR      SUM(DECODE(BR.DP_SEQ, NULL, 1, 0))  <> 0" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("        )   BK  ," ).append("\n"); 
		query.append("        BQ      ," ).append("\n"); 
		query.append("        BR		," ).append("\n"); 
		query.append("		BKG_BL_DOC DOC" ).append("\n"); 
		query.append("WHERE   BQ.BKG_NO(+) = BK.BKG_NO" ).append("\n"); 
		query.append("AND     BQ.DP_SEQ(+) = BK.DP_SEQ" ).append("\n"); 
		query.append("AND     BR.BKG_NO(+) = BK.BKG_NO" ).append("\n"); 
		query.append("AND     BR.DP_SEQ(+) = BK.DP_SEQ" ).append("\n"); 
		query.append("AND     DOC.BKG_NO(+) = BK.BKG_NO" ).append("\n"); 
		query.append("AND     (" ).append("\n"); 
		query.append("         BQ.DP_SEQ   IS NOT NULL" ).append("\n"); 
		query.append("         OR  BR.DP_SEQ   IS NOT NULL" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	( @[eq_subst_flg]	= 'N' OR BQ.EQ_SUBST_FLG	= 'N' OR BQ.EQ_SUBST_FLG IS NULL)" ).append("\n"); 
		query.append("AND	( @[awk_cgo_flg]	= 'N' OR BQ.AWK_CGO_FLG		= 'N' OR BQ.AWK_CGO_FLG	IS NULL )" ).append("\n"); 
		query.append("AND ( @[bb_cgo_flg]		= 'N' OR BQ.BB_CGO_FLG		= 'N' OR BQ.BB_CGO_FLG IS NULL)" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${charge_flg} == 'C')" ).append("\n"); 
		query.append("        AND    CHARGE_FLG='Charged'" ).append("\n"); 
		query.append("        #elseif(${charge_flg} == 'N')" ).append("\n"); 
		query.append("        AND     CHARGE_FLG='Non-Charged'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("		BK.BKG_RHQ_CD        ," ).append("\n"); 
		query.append("        BK.BKG_OFC_CD        ," ).append("\n"); 
		query.append("		BK.CTRT_NO           ," ).append("\n"); 
		query.append("        POL_ETD              ," ).append("\n"); 
		query.append("        BK.BL_NO			 ," ).append("\n"); 
		query.append("		BQ.CTRT_CNTR_TPSZ_CD" ).append("\n"); 

	}
}