/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOsearchRestrictCmdtDupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOsearchRestrictCmdtDupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRestrictCmdtDupList
	  * </pre>
	  */
	public BookingMasterMgtDBDAOsearchRestrictCmdtDupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prohi_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOsearchRestrictCmdtDupListRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CHK_CNT_KNT, " ).append("\n"); 
		query.append("	(SELECT DECODE(LOC_CD,'*****','ALL',LOC_CD) " ).append("\n"); 
		query.append("            FROM BKG_IMP_RSTR_CMDT CMDT" ).append("\n"); 
		query.append("            WHERE RGN_OFC_CD = @[rgn_ofc_cd]  " ).append("\n"); 
		query.append("            AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("			AND LOC_CD IN(DECODE(@[loc_cd],'ALL',LOC_CD, @[loc_cd]),'*****')" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${rstr_cmdt_nm} != '' && ${prohi_cmdt_nm} != '') " ).append("\n"); 
		query.append("				AND	(((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%')) " ).append("\n"); 
		query.append("				OR  ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%')))" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			#elseif (${rstr_cmdt_nm} != '' && ${prohi_cmdt_nm} == '') " ).append("\n"); 
		query.append("				AND	((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%')) " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			#elseif (${prohi_cmdt_nm} != '' && ${rstr_cmdt_nm} == '') " ).append("\n"); 
		query.append("				AND  ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%'))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND TO_DATE(@[eff_dt],'YYYY/MM/DD') BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('9999/12/31','YYYY/MM/DD'))" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("	) CHK_LOC_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(SELECT COUNT(*) " ).append("\n"); 
		query.append("            FROM BKG_IMP_RSTR_CMDT CMDT" ).append("\n"); 
		query.append("            WHERE RGN_OFC_CD = @[rgn_ofc_cd]  " ).append("\n"); 
		query.append("            AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("			AND LOC_CD IN(DECODE(@[loc_cd],'ALL',LOC_CD, @[loc_cd]),'*****')" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${rstr_cmdt_nm} != '' && ${prohi_cmdt_nm} != '') " ).append("\n"); 
		query.append("				AND	(((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%')) " ).append("\n"); 
		query.append("				OR  ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%')))" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			#elseif (${rstr_cmdt_nm} != '' && ${prohi_cmdt_nm} == '') " ).append("\n"); 
		query.append("				AND	((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%')) " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			#elseif (${prohi_cmdt_nm} != '' && ${rstr_cmdt_nm} == '') " ).append("\n"); 
		query.append("				AND  ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%'))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND TO_DATE(@[eff_dt],'YYYY/MM/DD') BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('9999/12/31','YYYY/MM/DD'))" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("	) DUP_FLG," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    (SELECT DISTINCT CNT_CD AS CHK_CD" ).append("\n"); 
		query.append("            FROM BKG_IMP_RSTR_CMDT CMDT" ).append("\n"); 
		query.append("            WHERE RGN_OFC_CD = @[rgn_ofc_cd]  " ).append("\n"); 
		query.append("            AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${rstr_cmdt_nm} != '' && ${prohi_cmdt_nm} != '') " ).append("\n"); 
		query.append("				AND	(((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%')) " ).append("\n"); 
		query.append("				OR  ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%')))" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			#elseif (${rstr_cmdt_nm} != '' && ${prohi_cmdt_nm} == '') " ).append("\n"); 
		query.append("				AND	((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%')) " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			#elseif (${prohi_cmdt_nm} != '' && ${rstr_cmdt_nm} == '') " ).append("\n"); 
		query.append("				AND  ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%'))" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			AND TO_DATE(@[eff_dt],'YYYY/MM/DD') BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('9999/12/31','YYYY/MM/DD'))" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("    ) AS CHK_CNT_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM BKG_IMP_RSTR_CMDT CMDT" ).append("\n"); 
		query.append("WHERE RGN_OFC_CD = @[rgn_ofc_cd] " ).append("\n"); 
		query.append("AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rstr_cmdt_nm} != '' && ${prohi_cmdt_nm} != '') " ).append("\n"); 
		query.append("AND	(((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%')) " ).append("\n"); 
		query.append("OR  ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%')))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${rstr_cmdt_nm} != '' && ${prohi_cmdt_nm} == '') " ).append("\n"); 
		query.append("AND	((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[rstr_cmdt_nm]) || '%')) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${prohi_cmdt_nm} != '' && ${rstr_cmdt_nm} == '') " ).append("\n"); 
		query.append("AND  ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[prohi_cmdt_nm]) || '%'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt],'YYYY/MM/DD') BETWEEN EFF_DT AND NVL(EXP_DT, TO_DATE('9999/12/31','YYYY/MM/DD'))" ).append("\n"); 
		query.append("GROUP BY CNT_CD" ).append("\n"); 

	}
}