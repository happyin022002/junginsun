/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOsearchRFsparePartCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.18 이용태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOsearchRFsparePartCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOsearchRFsparePartCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_spl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_ut_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOsearchRFsparePartCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT   A.SPR_PRT_NO" ).append("\n"); 
		query.append("        ,A.SPR_PRT_SPL_TP_CD " ).append("\n"); 
		query.append("        ,DECODE(A.SPR_PRT_TP_FLG1,'N','0','1') AS SPR_PRT_TP_FLG1" ).append("\n"); 
		query.append("        ,DECODE(A.SPR_PRT_TP_FLG2,'N','0','1') AS SPR_PRT_TP_FLG2  " ).append("\n"); 
		query.append("        ,DECODE(A.SPR_PRT_TP_FLG3,'N','0','1') AS SPR_PRT_TP_FLG3  " ).append("\n"); 
		query.append("        ,A.SPR_UT_TP_NM" ).append("\n"); 
		query.append("        ,A.SPR_PRT_NM" ).append("\n"); 
		query.append("        ,A.SPR_PRT_QTY" ).append("\n"); 
		query.append("        ,A.SPR_PRT_RMK" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append(" FROM MNR_RF_SPR_PRT_CD A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${spr_prt_no} != '') " ).append("\n"); 
		query.append("    AND A.SPR_PRT_NO = @[spr_prt_no]" ).append("\n"); 
		query.append("	#if (${spr_work_type} != 'check') " ).append("\n"); 
		query.append("    AND A.SPR_PRT_SPL_TP_CD = @[spr_prt_spl_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spr_ut_tp_nm} != '') " ).append("\n"); 
		query.append("   AND A.SPR_UT_TP_NM = @[spr_ut_tp_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spr_prt_spl_tp_cd} != '') " ).append("\n"); 
		query.append("   AND A.SPR_PRT_SPL_TP_CD = @[spr_prt_spl_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spr_tp_cd} == 'TA') " ).append("\n"); 
		query.append("   AND A.SPR_PRT_TP_FLG1 = 'Y'" ).append("\n"); 
		query.append("#elseif (${spr_tp_cd} == 'TB') " ).append("\n"); 
		query.append("   AND A.SPR_PRT_TP_FLG2 = 'Y'" ).append("\n"); 
		query.append("#elseif (${spr_tp_cd} == 'TC') " ).append("\n"); 
		query.append("   AND A.SPR_PRT_TP_FLG3 = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.SPR_PRT_NO" ).append("\n"); 

	}
}