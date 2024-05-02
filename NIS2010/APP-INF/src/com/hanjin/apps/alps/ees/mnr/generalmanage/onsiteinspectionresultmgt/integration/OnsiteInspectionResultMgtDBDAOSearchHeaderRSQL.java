/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnsiteInspectionResultMgtDBDAOSearchHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
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

public class OnsiteInspectionResultMgtDBDAOSearchHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R Onsite Inspection Result Inquiry 화면에 출력될 Header 결과값들을 조회
	  * </pre>
	  */
	public OnsiteInspectionResultMgtDBDAOSearchHeaderRSQL(){
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
		params.put("insp_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration").append("\n"); 
		query.append("FileName : OnsiteInspectionResultMgtDBDAOSearchHeaderRSQL").append("\n"); 
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
		query.append("       (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR" ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = A.VNDR_SEQ) VNDR_NM," ).append("\n"); 
		query.append("       A.YD_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.FLD_INSP_DT, 'YYYY-MM-DD') FLD_INSP_DT," ).append("\n"); 
		query.append("       A.INSP_OFC_CD," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.BRNC_INSP_FLG," ).append("\n"); 
		query.append("       A.HDBRN_INSP_FLG" ).append("\n"); 
		query.append("  FROM MNR_ONSITE_INSP_RSLT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND (A.BRNC_INSP_FLG = 'Y' OR A.HDBRN_INSP_FLG = 'Y')" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if(${rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("#if(${insp_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND A.INSP_OFC_CD IN" ).append("\n"); 
		query.append("						(SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("    		              FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("            		     WHERE A.DELT_FLG != 'Y' START WITH A.OFC_CD = @[insp_ofc_cd] CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.INSP_OFC_CD IN (SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD IN (SUBSTR(@[rhq_ofc_cd],1, 5)))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${insp_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND A.INSP_OFC_CD IN" ).append("\n"); 
		query.append("						(SELECT DISTINCT OFC_CD" ).append("\n"); 
		query.append("    		              FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("            		     WHERE A.DELT_FLG != 'Y' START WITH A.OFC_CD = @[insp_ofc_cd] CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${insp_yr} != '')" ).append("\n"); 
		query.append("   AND TO_CHAR(A.FLD_INSP_DT, 'YYYY') IN (@[insp_yr])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY FLD_INSP_DT, INSP_OFC_CD" ).append("\n"); 

	}
}