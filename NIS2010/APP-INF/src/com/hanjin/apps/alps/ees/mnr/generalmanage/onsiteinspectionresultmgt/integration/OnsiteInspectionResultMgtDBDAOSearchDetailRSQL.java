/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnsiteInspectionResultMgtDBDAOSearchDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnsiteInspectionResultMgtDBDAOSearchDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 지정한 Yard Code, Vendor, Inspection Date에 해당하는 M&R Onsite Inspection Result Detail 정보를 조회
	  * </pre>
	  */
	public OnsiteInspectionResultMgtDBDAOSearchDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fld_insp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration").append("\n"); 
		query.append("FileName : OnsiteInspectionResultMgtDBDAOSearchDetailRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ," ).append("\n"); 
		query.append("	  (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("         FROM MDM_VENDOR" ).append("\n"); 
		query.append("        WHERE VNDR_SEQ = A.VNDR_SEQ) VNDR_NM," ).append("\n"); 
		query.append("       A.YD_CD," ).append("\n"); 
		query.append("       A.FLD_INSP_DT," ).append("\n"); 
		query.append("       A.ONSITE_INSP_RSLT_DTL_SEQ," ).append("\n"); 
		query.append("       A.EV_ITM_NM," ).append("\n"); 
		query.append("       A.EV_ITM_ORD_NO," ).append("\n"); 
		query.append("       DECODE(A.RSLT_GD_FLG,'Y','O','') RSLT_GD_FLG," ).append("\n"); 
		query.append("       DECODE(A.RSLT_NORM_FLG,'Y','O','') RSLT_NORM_FLG," ).append("\n"); 
		query.append("       DECODE(A.RSLT_BAD_FLG,'Y','O','') RSLT_BAD_FLG," ).append("\n"); 
		query.append("       A.FLD_AUD_RMK," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       A.CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.UPD_DT," ).append("\n"); 
		query.append("       B.BRNC_INSP_FLG AS SHEET_BRNC_INSP_FLG," ).append("\n"); 
		query.append("       B.HDBRN_INSP_FLG AS SHEET_HDBRN_INSP_FLG" ).append("\n"); 
		query.append("  FROM MNR_ONSITE_INSP_RSLT_DTL A," ).append("\n"); 
		query.append("       MNR_ONSITE_INSP_RSLT B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("   AND A.FLD_INSP_DT = B.FLD_INSP_DT" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   AND A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("   AND TO_CHAR(A.FLD_INSP_DT, 'YYYY-MM-DD') = @[fld_insp_dt]" ).append("\n"); 
		query.append("ORDER BY LPAD(A.EV_ITM_ORD_NO, 4, '0')" ).append("\n"); 

	}
}