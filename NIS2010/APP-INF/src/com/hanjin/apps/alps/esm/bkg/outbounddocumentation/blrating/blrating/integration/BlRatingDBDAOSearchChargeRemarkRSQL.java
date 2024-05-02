/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOSearchChargeRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchChargeRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchChargeRemark
	  * </pre>
	  */
	public BlRatingDBDAOSearchChargeRemarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchChargeRemarkRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    BL.BKG_NO" ).append("\n"); 
		query.append("    ,RT.RT_BL_TP_CD" ).append("\n"); 
		query.append("    ,(SELECT RT_INTER_RMK FROM BKG_RT_HIS WHERE BKG_NO = BL.BKG_NO AND CORR_NO = 'TMP0000001') INTER_RMK" ).append("\n"); 
		query.append("    ,(SELECT DIFF_RMK FROM BKG_RT_HIS WHERE BKG_NO =BL.BKG_NO AND CORR_NO = 'TMP0000001') DIFF_RMK" ).append("\n"); 
		query.append("    ,(SELECT DOC_INTER_RMK FROM BKG_RT_HIS WHERE BKG_NO =BL.BKG_NO AND CORR_NO = 'TMP0000001') DOC_INTER_RMK" ).append("\n"); 
		query.append("    ,CASE" ).append("\n"); 
		query.append("    WHEN RT_BL_TP_CD ='M' THEN (" ).append("\n"); 
		query.append("    'O/FRT COVERS B/L : '|| BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("    SELECT B.BL_NO" ).append("\n"); 
		query.append("    FROM BKG_BL_DOC_HIS A," ).append("\n"); 
		query.append("        BKG_BKG_HIS B," ).append("\n"); 
		query.append("        BKG_BKG_HIS C" ).append("\n"); 
		query.append("    WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    AND A.MST_CVRD_BL_NO = C.BL_NO" ).append("\n"); 
		query.append("    AND C.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("    AND A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("    AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("    AND C.CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("    ))" ).append("\n"); 
		query.append("    WHEN RT_BL_TP_CD ='C' THEN " ).append("\n"); 
		query.append("	'O/FRT IS COVERED BY MASTER B/L : '||MST_CVRD_BL_NO" ).append("\n"); 
		query.append("    END  AS MST_CVRD_BL_NO" ).append("\n"); 
		query.append("    ,BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        ' FREIGHT '" ).append("\n"); 
		query.append("        ||DECODE(FRT_TERM_CD,'P','PREPAID','COLLECT')" ).append("\n"); 
		query.append("        ||' OF '" ).append("\n"); 
		query.append("        ||CHG_CD" ).append("\n"); 
		query.append("        ||' - '" ).append("\n"); 
		query.append("        ||CURR_CD" ).append("\n"); 
		query.append("        ||' '" ).append("\n"); 
		query.append("        ||CHG_AMT" ).append("\n"); 
		query.append("        ||' PAYABLE AT '" ).append("\n"); 
		query.append("        ||LOC_NM" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                BKG_NO" ).append("\n"); 
		query.append("                ,FRT_TERM_CD" ).append("\n"); 
		query.append("                ,CHG_CD" ).append("\n"); 
		query.append("                ,CURR_CD" ).append("\n"); 
		query.append("                ,CHG_AMT" ).append("\n"); 
		query.append("                ,UPPER(NVL( LOC.LOC_NM,ORG.LOC_CD)) as LOC_NM" ).append("\n"); 
		query.append("            FROM BKG_CHG_RT_HIS RT" ).append("\n"); 
		query.append("                ,MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("            WHERE RT.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("            AND RT.CORR_NO          = 'TMP0000001'" ).append("\n"); 
		query.append("            AND RT.N3PTY_RCV_OFC_CD = ORG.OFC_CD" ).append("\n"); 
		query.append("            AND ORG.LOC_CD          = LOC.LOC_CD" ).append("\n"); 
		query.append("            ORDER BY DP_SEQ" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )) AS THIRD_PARTY_FREIGHT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    BKG_BL_DOC_HIS BL, BKG_RT_HIS RT" ).append("\n"); 
		query.append("    WHERE BL.BKG_NO = RT.BKG_NO(+)" ).append("\n"); 
		query.append("    AND BL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND RT.CORR_NO(+) = 'TMP0000001'" ).append("\n"); 
		query.append("    AND BL.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    BL.BKG_NO" ).append("\n"); 
		query.append("    ,RT.RT_BL_TP_CD" ).append("\n"); 
		query.append("    ,(SELECT RT_INTER_RMK FROM BKG_RATE WHERE BKG_NO = BL.BKG_NO ) INTER_RMK" ).append("\n"); 
		query.append("    ,(SELECT DIFF_RMK FROM BKG_RATE WHERE BKG_NO =BL.BKG_NO ) DIFF_RMK" ).append("\n"); 
		query.append("    ,(SELECT DOC_INTER_RMK FROM BKG_RATE WHERE BKG_NO =BL.BKG_NO ) DOC_INTER_RMK" ).append("\n"); 
		query.append("    ,CASE" ).append("\n"); 
		query.append("    WHEN RT_BL_TP_CD ='M' THEN (" ).append("\n"); 
		query.append("    'O/FRT COVERS B/L : '|| BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("    SELECT B.BL_NO" ).append("\n"); 
		query.append("    FROM BKG_BL_DOC A," ).append("\n"); 
		query.append("        BKG_BOOKING B," ).append("\n"); 
		query.append("        BKG_BOOKING C" ).append("\n"); 
		query.append("    WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    AND A.MST_CVRD_BL_NO = C.BL_NO" ).append("\n"); 
		query.append("    AND C.BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("    ))" ).append("\n"); 
		query.append("    WHEN RT_BL_TP_CD ='C' THEN " ).append("\n"); 
		query.append("	'O/FRT IS COVERED BY MASTER B/L : '||MST_CVRD_BL_NO" ).append("\n"); 
		query.append("    END  AS MST_CVRD_BL_NO" ).append("\n"); 
		query.append("    ,BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        ' FREIGHT '" ).append("\n"); 
		query.append("        ||DECODE(FRT_TERM_CD,'P','PREPAID','COLLECT')" ).append("\n"); 
		query.append("        ||' OF '" ).append("\n"); 
		query.append("        ||CHG_CD" ).append("\n"); 
		query.append("        ||' - '" ).append("\n"); 
		query.append("        ||CURR_CD" ).append("\n"); 
		query.append("        ||' '" ).append("\n"); 
		query.append("        ||CHG_AMT" ).append("\n"); 
		query.append("        ||' PAYABLE AT '" ).append("\n"); 
		query.append("        ||LOC_NM" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                BKG_NO" ).append("\n"); 
		query.append("                ,FRT_TERM_CD" ).append("\n"); 
		query.append("                ,CHG_CD" ).append("\n"); 
		query.append("                ,CURR_CD" ).append("\n"); 
		query.append("                ,CHG_AMT" ).append("\n"); 
		query.append("                ,UPPER(NVL( LOC.LOC_NM,ORG.LOC_CD)) as LOC_NM" ).append("\n"); 
		query.append("            FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("                ,MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("            WHERE RT.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("            AND RT.N3PTY_RCV_OFC_CD = ORG.OFC_CD" ).append("\n"); 
		query.append("            AND ORG.LOC_CD          = LOC.LOC_CD" ).append("\n"); 
		query.append("            ORDER BY DP_SEQ" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )) AS THIRD_PARTY_FREIGHT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    BKG_BL_DOC BL, BKG_RATE RT" ).append("\n"); 
		query.append("    WHERE BL.BKG_NO = RT.BKG_NO(+)" ).append("\n"); 
		query.append("    AND BL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}