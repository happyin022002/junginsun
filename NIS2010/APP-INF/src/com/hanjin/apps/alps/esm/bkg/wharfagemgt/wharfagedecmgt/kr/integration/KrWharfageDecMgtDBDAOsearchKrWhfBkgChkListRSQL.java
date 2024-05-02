/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfBkgChkListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfBkgChkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * a
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfBkgChkListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("diff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfBkgChkListRSQL").append("\n"); 
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
		query.append("SELECT  BL_NO , DIFF, CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SELECT  DISTINCT DECODE(A.BL_NO, NULL, B.BL_NO, A.BL_NO) BL_NO,  " ).append("\n"); 
		query.append("         DECODE(A.BL_NO,NULL,'B',DECODE(B.BL_NO,NULL,'W','M')) DIFF," ).append("\n"); 
		query.append("		 NVL(A.BND_CD,B.BND_CD) AS CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT  BL_NO, 'W' diff, BKW.WHF_BND_CD AS BND_CD" ).append("\n"); 
		query.append("    FROM BKG_KR_WHF_BL BKW" ).append("\n"); 
		query.append("	WHERE BKW.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND BKW.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND BKW.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND BKW.WHF_POL_CD = 'KRPUS'" ).append("\n"); 
		query.append("	AND BKW.WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II','ON', 'OO', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT','ON', 'OT', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IM','ON', 'OM', @[whf_bnd_cd]))" ).append("\n"); 
		query.append("	AND BKW.WHF_BL_STS_CD <> 'D') A " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FULL OUTER JOIN " ).append("\n"); 
		query.append("  ( " ).append("\n"); 
		query.append("	SELECT VB.BL_NO, 'B' diff, DECODE(VB.BKG_CGO_TP_CD,'P',SUBSTR(@[whf_bnd_cd], 1, 1)||'M',DECODE(VB.KEY_POL_CD,VB.POL_CD,SUBSTR(@[whf_bnd_cd], 1, 1)||'O',SUBSTR(@[whf_bnd_cd], 1, 1)||'T')) BND_CD" ).append("\n"); 
		query.append("    FROM   BKG_CNTR_MANIFEST_V VB," ).append("\n"); 
		query.append("           BKG_BOOKING BKG" ).append("\n"); 
		query.append("    WHERE  NVL(VB.BKG_STS_CD, 'Z') <> 'X'" ).append("\n"); 
		query.append("    AND BKG.BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("    AND VB.KEY_VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("    AND VB.KEY_SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("    AND VB.KEY_SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                  	              " ).append("\n"); 
		query.append("#if (${whf_bnd_cd} == 'OO') " ).append("\n"); 
		query.append("        AND VB.KEY_POL_CD LIKE '%'||@[port_cd]||'%'" ).append("\n"); 
		query.append("        AND VB.KEY_POL_CD = VB.POL_CD " ).append("\n"); 
		query.append("        AND VB.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("#elseif (${whf_bnd_cd} == 'OT') " ).append("\n"); 
		query.append("        AND VB.KEY_POL_CD LIKE '%'||@[port_cd]||'%' " ).append("\n"); 
		query.append("        AND VB.KEY_POL_CD  != VB.POL_CD" ).append("\n"); 
		query.append("        AND VB.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("#elseif (${whf_bnd_cd} == 'OM')" ).append("\n"); 
		query.append("        AND VB.BKG_CGO_TP_CD = 'P' " ).append("\n"); 
		query.append("        AND VB.KEY_POL_CD LIKE '%'||@[port_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${whf_bnd_cd} == 'ON')" ).append("\n"); 
		query.append("		AND VB.KEY_POL_CD LIKE '%'||@[port_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${whf_bnd_cd} == 'II')" ).append("\n"); 
		query.append("		AND VB.KEY_POD_CD = VB.POD_CD " ).append("\n"); 
		query.append("        AND VB.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("        AND VB.KEY_POD_CD LIKE '%'||@[port_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${whf_bnd_cd} == 'IT')" ).append("\n"); 
		query.append("		AND VB.KEY_POD_CD != VB.POD_CD " ).append("\n"); 
		query.append("        AND VB.BKG_CGO_TP_CD <> 'P' " ).append("\n"); 
		query.append("        AND VB.KEY_POD_CD LIKE '%'||@[port_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${whf_bnd_cd} == 'IM')" ).append("\n"); 
		query.append("        AND VB.BKG_CGO_TP_CD = 'P' " ).append("\n"); 
		query.append("        AND VB.KEY_POD_CD LIKE '%'||@[port_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${whf_bnd_cd} == 'IN')" ).append("\n"); 
		query.append("		AND VB.KEY_POD_CD LIKE '%'||@[port_cd]||'%' " ).append("\n"); 
		query.append("#end                 " ).append("\n"); 
		query.append("        AND EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER Z" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND Z.BKG_NO = VB.BKG_NO )) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ON ( A.Bl_NO = B.Bl_NO AND A.BND_CD = B.BND_CD)" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${diff} != 'A') " ).append("\n"); 
		query.append("AND DIFF = @[diff]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND DIFF in ('W', 'B')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DIFF, CSTMS_DECL_TP_CD, BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}