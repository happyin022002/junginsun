/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchBlCertiRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchBlCertiRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchBlCertiRqstRSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchBlCertiRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_certi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchBlCertiRqstRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("          ,BL.BL_NO" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_SEQ" ).append("\n"); 
		query.append("          ,BL.CO_NM" ).append("\n"); 
		query.append("          ,BL.POL_CD" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_STS_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(BL.RQST_DT, 'YYYY-MM-DD HH24:MI') AS RQST_DT" ).append("\n"); 
		query.append("          ,'' AS ACT_DT " ).append("\n"); 
		query.append("          ,DTL.INTG_CD_VAL_DESC AS BL_CERTI_STS" ).append("\n"); 
		query.append("          ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("          ,BL.BL_NO || '_' || BL.BL_CERTI_SEQ AS FILE_NM" ).append("\n"); 
		query.append("          ,NVL(BL.BL_CERTI_PRN_FLG,'N') AS BL_CERTI_PRN_FLG" ).append("\n"); 
		query.append("      FROM BKG_BL_CERTI BL" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,COM_INTG_CD_DTL DTL" ).append("\n"); 
		query.append("     WHERE BKG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("       AND DTL.INTG_CD_ID = 'CD03408'" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = 'R'" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("       AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND BL.TMPLT_FLG = 'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ob_srep_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.OB_SREP_CD LIKE UPPER(@[ob_srep_cd])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("       AND BL.VSL_NM LIKE '%'||UPPER(@[vsl_eng_nm])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND BL.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${co_nm} != '') " ).append("\n"); 
		query.append("       AND BL.CO_NM LIKE '%'||@[co_nm]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_no} == '') " ).append("\n"); 
		query.append("        #if (${rqst_from_dt} != '' && ${rqst_to_dt} != '') " ).append("\n"); 
		query.append("                AND BL.RQST_DT >= TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                AND BL.RQST_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      AND 1 = DECODE(@[bl_certi_sts_cd],'All',1,'R',1,2)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("          ,BL.BL_NO" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_SEQ" ).append("\n"); 
		query.append("          ,BL.CO_NM" ).append("\n"); 
		query.append("          ,BL.POL_CD" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_STS_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(BL.RQST_DT, 'YYYY-MM-DD HH24:MI') AS RQST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(BL.APRO_DT, 'YYYY-MM-DD HH24:MI') AS ACT_DT " ).append("\n"); 
		query.append("          ,DTL.INTG_CD_VAL_DESC AS BL_CERTI_STS" ).append("\n"); 
		query.append("          ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("          ,BL.BL_NO || '_' || BL.BL_CERTI_SEQ AS FILE_NM" ).append("\n"); 
		query.append("          ,NVL(BL.BL_CERTI_PRN_FLG,'N') AS BL_CERTI_PRN_FLG" ).append("\n"); 
		query.append("      FROM BKG_BL_CERTI BL" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,COM_INTG_CD_DTL DTL" ).append("\n"); 
		query.append("     WHERE BKG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("       AND DTL.INTG_CD_ID = 'CD03408'" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = 'A'" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("       AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND BL.TMPLT_FLG = 'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ob_srep_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.OB_SREP_CD LIKE UPPER(@[ob_srep_cd])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("       AND BL.VSL_NM LIKE '%'||UPPER(@[vsl_eng_nm])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND BL.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${co_nm} != '') " ).append("\n"); 
		query.append("       AND BL.CO_NM LIKE '%'||@[co_nm]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_no} == '') " ).append("\n"); 
		query.append("        #if (${rqst_from_dt} != '' && ${rqst_to_dt} != '') " ).append("\n"); 
		query.append("                AND BL.RQST_DT >= TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                AND BL.RQST_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      AND 1 = DECODE(@[bl_certi_sts_cd],'All',1,'A',1,2)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("          ,BL.BL_NO" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_SEQ" ).append("\n"); 
		query.append("          ,BL.CO_NM" ).append("\n"); 
		query.append("          ,BL.POL_CD" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_STS_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(BL.RQST_DT, 'YYYY-MM-DD HH24:MI') AS RQST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(BL.RJCT_DT, 'YYYY-MM-DD HH24:MI') AS ACT_DT " ).append("\n"); 
		query.append("          ,DTL.INTG_CD_VAL_DESC AS BL_CERTI_STS" ).append("\n"); 
		query.append("          ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("          ,BL.BL_NO || '_' || BL.BL_CERTI_SEQ AS FILE_NM" ).append("\n"); 
		query.append("          ,NVL(BL.BL_CERTI_PRN_FLG,'N') AS BL_CERTI_PRN_FLG" ).append("\n"); 
		query.append("      FROM BKG_BL_CERTI BL" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,COM_INTG_CD_DTL DTL" ).append("\n"); 
		query.append("     WHERE BKG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("       AND DTL.INTG_CD_ID = 'CD03408'" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = 'X'" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("       AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND BL.TMPLT_FLG = 'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ob_srep_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.OB_SREP_CD LIKE UPPER(@[ob_srep_cd])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("       AND BL.VSL_NM LIKE '%'||UPPER(@[vsl_eng_nm])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND BL.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${co_nm} != '') " ).append("\n"); 
		query.append("       AND BL.CO_NM LIKE '%'||@[co_nm]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_no} == '') " ).append("\n"); 
		query.append("        #if (${rqst_from_dt} != '' && ${rqst_to_dt} != '') " ).append("\n"); 
		query.append("                AND BL.RQST_DT >= TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                AND BL.RQST_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      AND 1 = DECODE(@[bl_certi_sts_cd],'All',1,'X',1,2)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("          ,BL.BL_NO" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_SEQ" ).append("\n"); 
		query.append("          ,BL.CO_NM" ).append("\n"); 
		query.append("          ,BL.POL_CD" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_STS_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(BL.ISS_RQST_DT, 'YYYY-MM-DD HH24:MI') AS RQST_DT" ).append("\n"); 
		query.append("          ,'' AS ACT_DT " ).append("\n"); 
		query.append("          ,DTL.INTG_CD_VAL_DESC AS BL_CERTI_STS" ).append("\n"); 
		query.append("          ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("          ,BL.BL_NO || '_' || BL.BL_CERTI_SEQ AS FILE_NM" ).append("\n"); 
		query.append("          ,NVL(BL.BL_CERTI_PRN_FLG,'N') AS BL_CERTI_PRN_FLG" ).append("\n"); 
		query.append("      FROM BKG_BL_CERTI BL" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,COM_INTG_CD_DTL DTL" ).append("\n"); 
		query.append("     WHERE BKG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("       AND DTL.INTG_CD_ID = 'CD03408'" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = 'I'" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("       AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND BL.TMPLT_FLG = 'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ob_srep_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.OB_SREP_CD LIKE UPPER(@[ob_srep_cd])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("       AND BL.VSL_NM LIKE '%'||UPPER(@[vsl_eng_nm])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND BL.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${co_nm} != '') " ).append("\n"); 
		query.append("       AND BL.CO_NM LIKE '%'||@[co_nm]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_no} == '') " ).append("\n"); 
		query.append("        #if (${rqst_from_dt} != '' && ${rqst_to_dt} != '') " ).append("\n"); 
		query.append("                AND BL.ISS_RQST_DT >= TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                AND BL.ISS_RQST_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      AND 1 = DECODE(@[bl_certi_sts_cd],'All',1,'I',1,'BL',1,2)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("          ,BL.BL_NO" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_SEQ" ).append("\n"); 
		query.append("          ,BL.CO_NM" ).append("\n"); 
		query.append("          ,BL.POL_CD" ).append("\n"); 
		query.append("          ,BL.BL_CERTI_STS_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(BL.ISS_RQST_DT, 'YYYY-MM-DD HH24:MI') AS RQST_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(BL.CMPL_DT, 'YYYY-MM-DD HH24:MI') AS ACT_DT " ).append("\n"); 
		query.append("          ,DTL.INTG_CD_VAL_DESC AS BL_CERTI_STS" ).append("\n"); 
		query.append("          ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("          ,BL.BL_NO || '_' || BL.BL_CERTI_SEQ AS FILE_NM" ).append("\n"); 
		query.append("          ,NVL(BL.BL_CERTI_PRN_FLG,'N') AS BL_CERTI_PRN_FLG" ).append("\n"); 
		query.append("      FROM BKG_BL_CERTI BL" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,COM_INTG_CD_DTL DTL" ).append("\n"); 
		query.append("     WHERE BKG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("       AND DTL.INTG_CD_ID = 'CD03408'" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("       AND BL.BL_CERTI_STS_CD = 'C'" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("       AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND BL.TMPLT_FLG = 'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${ob_srep_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.OB_SREP_CD LIKE UPPER(@[ob_srep_cd])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("       AND BL.VSL_NM LIKE '%'||UPPER(@[vsl_eng_nm])||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("       AND BL.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${co_nm} != '') " ).append("\n"); 
		query.append("       AND BL.CO_NM LIKE '%'||@[co_nm]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_no} == '') " ).append("\n"); 
		query.append("        #if (${rqst_from_dt} != '' && ${rqst_to_dt} != '') " ).append("\n"); 
		query.append("                AND BL.ISS_RQST_DT >= TO_DATE(@[rqst_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                AND BL.ISS_RQST_DT < TO_DATE(@[rqst_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      AND 1 = DECODE(@[bl_certi_sts_cd],'All',1,'C',1,'BL',1,2)" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  ORDER BY BL_NO, BL_CERTI_SEQ" ).append("\n"); 

	}
}