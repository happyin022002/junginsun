/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KorManifestListDBDAOSearchManifestCrsChkInfoKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.04
*@LastModifier :
*@LastVersion : 1.0
* 2013.11.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchManifestCrsChkInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchManifestCrsChkInfoKor
	  * </pre>
	  */
	public KorManifestListDBDAOSearchManifestCrsChkInfoKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_blno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_tmnl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchManifestCrsChkInfoKorRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("    A.BKG_NO BKG_NO," ).append("\n");
		query.append("    B.BKG_NO DN_BKG_NO," ).append("\n");
		query.append("	C.BKG_NO RMK_BKG_NO," ).append("\n");
		query.append("	A.BL_NO," ).append("\n");
		query.append("	A.POL_CD," ).append("\n");
		query.append("	A.POD_CD," ).append("\n");
		query.append("	A.PCK_QTY," ).append("\n");
		query.append("	A.PCK_TP_CD," ).append("\n");
		query.append("	A.ACT_WGT," ).append("\n");
		query.append("	A.WGT_UT_CD," ).append("\n");
		query.append("	A.MEAS_QTY," ).append("\n");
		query.append("	A.MEAS_UT_CD," ).append("\n");
		query.append("	A.XPT_LIC_NO," ).append("\n");
		query.append("    A.TP TP," ).append("\n");
		query.append("	B.PCK_QTY        DN_PCK_QTY," ).append("\n");
		query.append("	B.PCK_TP_CD      DN_PCK_TP_CD," ).append("\n");
		query.append("	B.CNTR_TTL_WGT   CNTR_TTL_WGT," ).append("\n");
		query.append("	B.WGT_UT_CD      DN_WGT_UT_CD," ).append("\n");
		query.append("	B.MEAS_QTY       DN_MEAS_QTY," ).append("\n");
		query.append("	B.BL_MEAS_UT_CD  BL_MEAS_UT_CD," ).append("\n");
		query.append("	B.DN_XPT_LIC_NO  DN_XPT_LIC_NO," ).append("\n");
		query.append("    C.CSTMS_RMK1, " ).append("\n");
		query.append("    A.VSL_CD," ).append("\n");
		query.append("    A.SKD_VOY_NO," ).append("\n");
		query.append("    A.SKD_DIR_CD," ).append("\n");
		query.append("    DECODE(@[in_bound], 'O', DECODE( A.SC,'N', " ).append("\n");
		query.append("                                        DECODE(( SELECT MDM.RVIS_CNTR_CUST_TP_CD" ).append("\n");
		query.append("                                                   FROM BKG_CUSTOMER CUST, MDM_CUSTOMER MDM" ).append("\n");
		query.append("                                                  WHERE CUST.CUST_CNT_CD  = MDM.CUST_CNT_CD(+)" ).append("\n");
		query.append("                                                    AND CUST.CUST_SEQ       = MDM.CUST_SEQ(+)" ).append("\n");
		query.append("                                                    AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n");
		query.append("                                                    AND CUST.BKG_NO = A.BKG_NO ), 'N', 'C', 'B', 'S', A.SC )," ).append("\n");
		query.append("                                      A.SC )," ).append("\n");
		query.append("                      A.SC ) SC," ).append("\n");
		query.append("	" ).append("\n");
		query.append("    A.FE,   " ).append("\n");
		query.append("    ( SELECT COUNT(*) FROM BKG_CONTAINER WHERE BKG_NO = A.BKG_NO ) CNTR_CNT," ).append("\n");
		query.append("	@[kt_port] PORT_CD" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("     (" ).append("\n");
		query.append("		SELECT NVL(B.BL_NO,' ') BL_NO" ).append("\n");
		query.append("			 , NVL(B.BKG_NO,' ') BKG_NO" ).append("\n");
		query.append("			 , NVL(B.BKG_NO,' ') A_BKG_NO" ).append("\n");
		query.append("			 , NVL(C.MF_SEQ_NO,' ') MSN" ).append("\n");
		query.append("			 , '' CORRECTION" ).append("\n");
		query.append("			  --, DECODE(A.POL_CD,B.POL_CD,'E','R') TP" ).append("\n");
		query.append("			 , CASE WHEN @[in_bound] = 'O'" ).append("\n");
		query.append("       				THEN CASE WHEN A.POL_CD = B.POL_CD THEN 'E'" ).append("\n");
		query.append("       				ELSE 'R' END" ).append("\n");
		query.append("      			    WHEN @[in_bound] = 'I' THEN " ).append("\n");
		query.append("							CASE WHEN @[in_pod] = B.POD_CD AND B.BKG_CGO_TP_CD = 'P' THEN 'M'" ).append("\n");
		query.append("								 WHEN A.POD_CD = B.POD_CD THEN 'I'" ).append("\n");
		query.append("                                 ELSE 'T' END " ).append("\n");
		query.append("       			ELSE ' ' END TP" ).append("\n");
		query.append("       " ).append("\n");
		query.append("			, NVL(B.BKG_CGO_TP_CD,' ') FE" ).append("\n");
		query.append("			, NVL(A.POL_CD,' ') HIDDEN1" ).append("\n");
		query.append("			, NVL(A.POD_CD,' ') HIDDEN2" ).append("\n");
		query.append("			, NVL(B.POL_CD,' ') POL_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("       #if( ${in_bound} == 'I')" ).append("\n");
		query.append("	        , NVL(B.POD_CD,' ') POD_CD " ).append("\n");
		query.append("       #else" ).append("\n");
		query.append("          #if (${sel_type} !='A')" ).append("\n");
		query.append("            , NVL(A.POD_CD,' ') POD_CD" ).append("\n");
		query.append("          #else" ).append("\n");
		query.append("		    , NVL(B.POD_CD,' ') POD_CD " ).append("\n");
		query.append("          #end  " ).append("\n");
		query.append("       #end" ).append("\n");
		query.append("" ).append("\n");
		query.append("			, NVL(D.PCK_QTY ,0) PCK_QTY" ).append("\n");
		query.append("			, D.PCK_TP_CD PCK_TP_CD" ).append("\n");
		query.append("			, TRUNC(NVL(D.ACT_WGT,0),1) ACT_WGT" ).append("\n");
		query.append("			, D.WGT_UT_CD WGT_UT_CD" ).append("\n");
		query.append("			, NVL(D.MEAS_QTY,0) MEAS_QTY" ).append("\n");
		query.append("			, D.MEAS_UT_CD MEAS_UT_CD" ).append("\n");
		query.append("		 	, A.VSL_CD" ).append("\n");
		query.append("			,A.SKD_VOY_NO" ).append("\n");
		query.append("			,A.SKD_DIR_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("			, CASE WHEN @[in_bound] = 'O'" ).append("\n");
		query.append("       			   THEN CASE WHEN A.POL_CD <> B.POL_CD THEN 'C'" ).append("\n");
		query.append("                 			 WHEN SUBSTR(B.POD_CD,1,2) IN ('US','CA','MX','GT') AND B.BKG_CGO_TP_CD <> 'P' THEN 'A'" ).append("\n");
		query.append("                 			 WHEN B.BKG_CGO_TP_CD = 'P' THEN 'M'" ).append("\n");
		query.append("                 			ELSE 'B' END " ).append("\n");
		query.append("       			   WHEN @[in_bound] = 'I'" ).append("\n");
		query.append("       				THEN CASE WHEN @[in_pod] = B.POD_CD AND B.BKG_CGO_TP_CD = 'P' THEN 'M'" ).append("\n");
		query.append("                              WHEN @[sel_type] = 'A' AND B.BKG_CGO_TP_CD <> 'P' THEN 'A'" ).append("\n");
		query.append("                 			ELSE 'N' END" ).append("\n");
		query.append("       		       END CREATEDTYPE" ).append("\n");
		query.append("              , XPT_LIC_NO" ).append("\n");
		query.append("              , ( SELECT DECODE(COUNT(*),0,'N','Y') FROM BKG_XPT_IMP_LIC BB" ).append("\n");
		query.append("			       WHERE BKG_NO = A.BKG_NO" ).append("\n");
		query.append("			         AND IO_BND_CD = @[in_bound]     " ).append("\n");
		query.append("                     AND XPT_LIC_NO IS NOT NULL" ).append("\n");
		query.append("                     AND 0 = ( SELECT COUNT(*) FROM BKG_CSTMS_KR_XPT_LIC AA" ).append("\n");
		query.append("                                WHERE AA.BKG_NO = BB.BKG_NO" ).append("\n");
		query.append("                                  AND AA.XPT_LIC_NO = BB.XPT_LIC_NO ) " ).append("\n");
		query.append("                   ) LIC_FLG" ).append("\n");
		query.append("               , DECODE(@[in_bound], 'O', NVL(B.KR_CSTMS_CUST_TP_CD,'N'), NVL(C.KR_CSTMS_BL_TP_CD,'N')) SC" ).append("\n");
		query.append("      FROM BKG_VVD A, BKG_BOOKING B, BKG_CSTMS_KR_MF_SEQ_NO C, BKG_BL_DOC D, BKG_CSTMS_CD_CONV_CTNT F, BKG_XPT_IMP_LIC LIC" ).append("\n");
		query.append("	  WHERE A.VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n");
		query.append("		AND A.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n");
		query.append("		AND A.SKD_DIR_CD    = SUBSTR(@[in_vvd],9,1)" ).append("\n");
		query.append("" ).append("\n");
		query.append("	#if (${in_bound} == 'O') " ).append("\n");
		query.append("		AND A.POL_CD LIKE @[in_pol]||'%'" ).append("\n");
		query.append("	#else " ).append("\n");
		query.append("		AND A.POD_CD LIKE @[in_pod]||'%'" ).append("\n");
		query.append("	#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("		AND DECODE(@[in_bound],'I',DECODE(LENGTH(NULL),7,A.POD_YD_CD,' '),' ')" ).append("\n");
		query.append("		= DECODE(@[in_bound],'I',DECODE(LENGTH(NULL),7,NULL,' '),' ')" ).append("\n");
		query.append("		AND A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("		AND B.BKG_NO = D.BKG_NO" ).append("\n");
		query.append("		AND B.BL_NO  > ' '" ).append("\n");
		query.append("		AND B.BKG_STS_CD != 'X'" ).append("\n");
		query.append("		AND B.BKG_STS_CD != 'S'" ).append("\n");
		query.append("		AND B.BL_NO = NVL(@[in_blno],B.BL_NO)" ).append("\n");
		query.append("		AND B.BKG_NO = C.BKG_NO(+)" ).append("\n");
		query.append("        AND LIC.BKG_NO(+) = A.BKG_NO " ).append("\n");
		query.append("        AND LIC.IO_BND_CD(+) = @[in_bound]" ).append("\n");
		query.append("	#if(${mrn_no}!='')" ).append("\n");
		query.append("		AND C.MF_REF_NO(+) = @[mrn_no] 		" ).append("\n");
		query.append("	#end" ).append("\n");
		query.append("		AND F.CNT_CD(+) = 'KR'" ).append("\n");
		query.append("		AND F.CSTMS_DIV_ID(+) = 'KOR_CSTM_CMDT'" ).append("\n");
		query.append("		AND B.REP_CMDT_CD = F.ATTR_CTNT1(+)" ).append("\n");
		query.append("" ).append("\n");
		query.append("	#if( ${sel_type} == 'A'||${sel_type} == 'B'||${sel_type} == 'C')" ).append("\n");
		query.append("		AND B.BKG_CGO_TP_CD !='P'" ).append("\n");
		query.append("	#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("	#if( ${sel_type} == 'M')" ).append("\n");
		query.append("	   	AND B.BKG_CGO_TP_CD ='P'    " ).append("\n");
		query.append("	#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("		ORDER BY NVL(B.BL_NO,' '), NVL(A.POL_CD,' '), NVL(A.POD_CD,' ') " ).append("\n");
		query.append("" ).append("\n");
		query.append("	) A, --A BKG_BOOKING TABLE 에서 구하는 부분 " ).append("\n");
		query.append("" ).append("\n");
		query.append("    (" ).append("\n");
		query.append("      SELECT A.BKG_NO," ).append("\n");
		query.append("			 A.BL_NO," ).append("\n");
		query.append("			 A.POL_CD," ).append("\n");
		query.append("			 A.PCK_QTY," ).append("\n");
		query.append("			 A.PCK_TP_CD      ," ).append("\n");
		query.append("			 TRUNC(A.CNTR_TTL_WGT, 1) CNTR_TTL_WGT ," ).append("\n");
		query.append("			 A.WGT_UT_CD      ," ).append("\n");
		query.append("			 A.MEAS_QTY       ," ).append("\n");
		query.append("			 A.BL_MEAS_UT_CD  ," ).append("\n");
		query.append("			 A.CSTMS_BL_NO," ).append("\n");
		query.append("	         LIC.XPT_LIC_NO DN_XPT_LIC_NO," ).append("\n");
		query.append("			 A.CSTMS_DECL_TP_CD," ).append("\n");
		query.append("			 A.TRNS_SEQ A_TRNS_SEQ" ).append("\n");
		query.append("        FROM BKG_CSTMS_KR_BL A, BKG_CSTMS_KR_XPT_LIC LIC" ).append("\n");
		query.append("        WHERE VSL_CD = SUBSTR(@[in_vvd], 1, 4)" ).append("\n");
		query.append("  		  AND SKD_VOY_NO = SUBSTR(@[in_vvd], 5, 4)" ).append("\n");
		query.append("  		  AND SKD_DIR_CD = SUBSTR(@[in_vvd], 9, 1)" ).append("\n");
		query.append("  		  AND ((@[in_bound] = 'O'  AND TS_POL_CD = @[in_pol])" ).append("\n");
		query.append("           OR  (@[in_bound] = 'I'  AND TS_POD_CD = @[in_pod]))" ).append("\n");
		query.append("          AND ((@[in_bound] = 'O'  AND NVL(PORT_TML_CD, ' ') LIKE '%')" ).append("\n");
		query.append("           OR DECODE(LENGTH(@[in_pod_tmnl]), 7, PORT_TML_CD, ' ') = DECODE(LENGTH(@[in_pod_tmnl]), 7, @[in_pod_tmnl], ' '))" ).append("\n");
		query.append("          AND ((@[in_bound] = 'O'  AND A.CSTMS_DECL_TP_CD IN ('E','R'))" ).append("\n");
		query.append("           OR (@[in_bound] = 'I'  AND " ).append("\n");
		query.append("                #if (${sel_type} == 'A')" ).append("\n");
		query.append("                    A.CSTMS_DECL_TP_CD = 'I'))" ).append("\n");
		query.append("				#else" ).append("\n");
		query.append("					A.CSTMS_DECL_TP_CD IN ('I','T'))) " ).append("\n");
		query.append("				#end" ).append("\n");
		query.append("        #if (${sel_type} == 'M')" ).append("\n");
		query.append("          AND KR_CSTMS_BND_CD='M'" ).append("\n");
		query.append("         #end" ).append("\n");
		query.append("" ).append("\n");
		query.append("          AND A.DMST_PORT_CD = @[kt_port] " ).append("\n");
		query.append(" 		  AND A.CSTMS_BL_NO = NVL(@[in_blno], A.CSTMS_BL_NO)" ).append("\n");
		query.append("  		  AND A.BKG_NO = NVL(@[in_bkg_no], A.BKG_NO)" ).append("\n");
		query.append("  		  AND A.TRNS_SEQ = (" ).append("\n");
		query.append("                          SELECT MAX(TRNS_SEQ)" ).append("\n");
		query.append("    						FROM BKG_CSTMS_KR_BL BB" ).append("\n");
		query.append("   						   WHERE BB.BKG_NO = A.BKG_NO" ).append("\n");
		query.append("     						 AND BB.DMST_PORT_CD = A.DMST_PORT_CD" ).append("\n");
		query.append("     						 AND BB.VSL_CD = A.VSL_CD" ).append("\n");
		query.append("     						 AND BB.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n");
		query.append("     						 AND BB.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n");
		query.append("							 AND CRE_DT <= ( SELECT V.VPS_ETD_DT FROM VSK_VSL_PORT_SKD V, BKG_VVD BV" ).append("\n");
		query.append("                                             WHERE 1=1" ).append("\n");
		query.append("                     						 AND V.VSL_CD = BB.VSL_CD" ).append("\n");
		query.append("                     						 AND V.SKD_VOY_NO = BB.SKD_VOY_NO" ).append("\n");
		query.append("                     						 AND V.SKD_DIR_CD = BB.SKD_DIR_CD" ).append("\n");
		query.append("                     						 AND V.VPS_PORT_CD = BB.DMST_PORT_CD" ).append("\n");
		query.append("											 AND BV.BKG_NO = BB.BKG_NO" ).append("\n");
		query.append("										     AND V.VSL_CD = BV.VSL_CD" ).append("\n");
		query.append("                                             AND V.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n");
		query.append("                                             AND V.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n");
		query.append("                                             AND V.VPS_PORT_CD = DECODE(@[in_bound],'O',BV.POL_CD, BV.POD_CD)" ).append("\n");
		query.append("                                             AND V.CLPT_IND_SEQ = DECODE(@[in_bound],'O',BV.POL_CLPT_IND_SEQ,BV.POD_CLPT_IND_SEQ)   )" ).append("\n");
		query.append("                             )" ).append("\n");
		query.append("-- 		 AND NVL(DELT_FLG, ' ') <> 'Y'  " ).append("\n");
		query.append("         AND LIC.BKG_NO(+) = A.BKG_NO " ).append("\n");
		query.append("         AND LIC.CSTMS_DECL_TP_CD(+) = A.CSTMS_DECL_TP_CD" ).append("\n");
		query.append("         AND LIC.DMST_PORT_CD(+) = A.DMST_PORT_CD" ).append("\n");
		query.append("         AND LIC.TRNS_SEQ(+) = A.TRNS_SEQ" ).append("\n");
		query.append("         AND LIC.CSTMS_BL_NO(+) = A.CSTMS_BL_NO" ).append("\n");
		query.append("      ) B, --B D/L 에서 구하는 부분" ).append("\n");
		query.append("     BKG_CSTMS_KR_RMK C --C remark 테이블 " ).append("\n");
		query.append("" ).append("\n");
		query.append("WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n");
		query.append("  AND A.TP = B.CSTMS_DECL_TP_CD(+)" ).append("\n");
		query.append("  AND A.BKG_NO = C.BKG_NO(+)" ).append("\n");
		query.append("  AND A.CREATEDTYPE LIKE DECODE( @[sel_type],'D','%','N','%',@[sel_type] )" ).append("\n");
		query.append("  AND ( NVL(A.PCK_QTY,0) <> NVL(B.PCK_QTY,1) " ).append("\n");
		query.append("--OR NVL(A.PCK_TP_CD,' ') <> NVL(B.PCK_TP_CD,'A')  " ).append("\n");
		query.append("    OR Trunc(NVL(A.ACT_WGT,0), -1) <> Trunc(NVL(B.CNTR_TTL_WGT,0), -1) " ).append("\n");
		query.append("--  OR  NVL(A.ACT_WGT,0) <> NVL(B.CNTR_TTL_WGT,1) " ).append("\n");
		query.append("--OR NVL(A.WGT_UT_CD,' ') <> NVL(B.WGT_UT_CD,'A')" ).append("\n");
		query.append("--OR NVL(A.MEAS_QTY,0) <> NVL(B.MEAS_QTY,1) OR NVL(A.MEAS_UT_CD,' ') <> NVL(B.BL_MEAS_UT_CD,'A')" ).append("\n");
		query.append("    OR  'Y' = ( SELECT MAX(CASE WHEN AA.XPT_LIC_NO IS NULL THEN 'Y'" ).append("\n");
		query.append("                                ELSE 'N'" ).append("\n");
		query.append("                                 END)" ).append("\n");
		query.append("                  FROM BKG_XPT_IMP_LIC BB, BKG_CSTMS_KR_XPT_LIC AA" ).append("\n");
		query.append("                 WHERE BB.BKG_NO = A.BKG_NO" ).append("\n");
		query.append("                   AND BB.IO_BND_CD = @[in_bound]" ).append("\n");
		query.append("                   AND BB.XPT_LIC_NO IS NOT NULL" ).append("\n");
		query.append("                   AND AA.BKG_NO(+) = BB.BKG_NO" ).append("\n");
		query.append("                   AND AA.XPT_LIC_NO(+) = BB.XPT_LIC_NO" ).append("\n");
		query.append("                   AND AA.TRNS_SEQ(+) = B.A_TRNS_SEQ ))" ).append("\n");

	}
}