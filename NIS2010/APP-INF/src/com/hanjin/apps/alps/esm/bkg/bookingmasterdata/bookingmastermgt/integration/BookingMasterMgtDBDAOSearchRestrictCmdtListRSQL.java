/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchRestrictCmdtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.18 
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

public class BookingMasterMgtDBDAOSearchRestrictCmdtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_IMP_RSTR_CMDT 조회
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchRestrictCmdtListRSQL(){
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
		params.put("commodities",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchRestrictCmdtListRSQL").append("\n"); 
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
		query.append("	CMDT.RGN_OFC_CD," ).append("\n"); 
		query.append("	CMDT.CNT_CD," ).append("\n"); 
		query.append("	DECODE(CMDT.LOC_CD,'*****','ALL',CMDT.LOC_CD) LOC_CD," ).append("\n"); 
		query.append("	CMDT.DP_SEQ," ).append("\n"); 
		query.append("	RSTR_CMDT_NM," ).append("\n"); 
		query.append("	PROHI_CMDT_NM," ).append("\n"); 
		query.append("	TO_CHAR(EFF_DT,'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("	TO_CHAR(EXP_DT,'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("	WEB_SITE_URL," ).append("\n"); 
		query.append("	INTER_RMK," ).append("\n"); 
		query.append("	BKG_JOIN_FNC(CURSOR(SELECT FILE_NM FROM BKG_IMP_IMG_STO WHERE RGN_OFC_CD = CMDT.RGN_OFC_CD and LOC_CD = CMDT.LOC_CD and DP_SEQ = CMDT.DP_SEQ and CNT_CD = CMDT.CNT_CD)) FILE_UPLD_NM," ).append("\n"); 
		query.append("    FILE_SAV.FILE_SAV_ID," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("	RSTR_CMDT_GRP_NM," ).append("\n"); 
		query.append("	DECODE(NVL(TS_FLG, 'N'), 'N', 0,  1) TS_FLG," ).append("\n"); 
		query.append("	DECODE(NVL(FROB_FLG, 'N'), 'N', 0,  1) FROB_FLG" ).append("\n"); 
		query.append("FROM BKG_IMP_RSTR_CMDT CMDT," ).append("\n"); 
		query.append("	(SELECT" ).append("\n"); 
		query.append("		RGN_OFC_CD," ).append("\n"); 
		query.append("		CNT_CD," ).append("\n"); 
		query.append("		LOC_CD," ).append("\n"); 
		query.append("		DP_SEQ," ).append("\n"); 
		query.append("		IMG.FILE_SAV_ID" ).append("\n"); 
		query.append("	 FROM " ).append("\n"); 
		query.append("		BKG_IMP_IMG_STO IMG," ).append("\n"); 
		query.append("		COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("	 WHERE " ).append("\n"); 
		query.append("		IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("	 ) FILE_SAV" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	CMDT.RGN_OFC_CD = FILE_SAV.RGN_OFC_CD(+) " ).append("\n"); 
		query.append("AND CMDT.LOC_CD     = FILE_SAV.LOC_CD(+) " ).append("\n"); 
		query.append("AND CMDT.DP_SEQ     = FILE_SAV.DP_SEQ(+) " ).append("\n"); 
		query.append("AND CMDT.CNT_CD     = FILE_SAV.CNT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rgn_ofc_cd} != 'ALL') " ).append("\n"); 
		query.append("  AND CMDT.RGN_OFC_CD = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append(" AND CMDT.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("	AND ((CMDT.LOC_CD LIKE DECODE(@[loc_cd],'ALL','*****',@[loc_cd]) || '%' ) OR (CMDT.CNT_CD = SUBSTR(DECODE(@[loc_cd],'ALL','*****',@[loc_cd]),1,2) AND CMDT.LOC_CD = '*****'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append(" AND TO_DATE(@[eff_dt],'YYYY-MM-DD') BETWEEN EFF_DT AND NVL(EXP_DT,TO_DATE('9999-12-31','YYYY-MM-DD'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${commodities} != '')" ).append("\n"); 
		query.append(" AND ((UPPER(RSTR_CMDT_NM) LIKE UPPER(@[commodities])||'%') OR (UPPER(PROHI_CMDT_NM) LIKE UPPER(@[commodities])||'%'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RGN_OFC_CD, CNT_CD, LOC_CD, RSTR_CMDT_NM, PROHI_CMDT_NM" ).append("\n"); 

	}
}