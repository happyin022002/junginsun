/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMChinaOfficeInfoDBDAOSearchIBChinaInfoForLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.15 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMChinaOfficeInfoDBDAOSearchIBChinaInfoForLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ACMChinaOfficeInfoDBDAOSearchIBChinaInfoForLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.integration").append("\n"); 
		query.append("FileName : ACMChinaOfficeInfoDBDAOSearchIBChinaInfoForLaneListRSQL").append("\n"); 
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
		query.append("SELECT ACLA.POD_CD," ).append("\n"); 
		query.append("       ACLA.SLAN_CD," ).append("\n"); 
		query.append("       ACLA.AGN_CD," ).append("\n"); 
		query.append("       TO_CHAR(ACLA.VNDR_SEQ,'FM000000') AS VNDR_SEQ," ).append("\n"); 
		query.append("       ACLA.AGN_AR_OFC_CD AS AGN_AR_OFC_CD," ).append("\n"); 
		query.append("       MV.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       NVL(ACLA.DELT_FLG, 'N') AS DELT_FLG," ).append("\n"); 
		query.append("       NVL(MV.DELT_FLG, 'N') AS VNDR_DELT_FLG," ).append("\n"); 
		query.append("       ACLA.POD_CD AS ORG_POD_CD," ).append("\n"); 
		query.append("       ACLA.SLAN_CD AS ORG_SLAN_CD," ).append("\n"); 
		query.append("       ACLA.AGN_CD AS ORG_AGN_CD," ).append("\n"); 
		query.append("       TO_CHAR(ACLA.VNDR_SEQ,'FM000000') AS ORG_VNDR_SEQ" ).append("\n"); 
		query.append("  FROM ACM_AGN_SET_NRTH_CHN_LANE ACLA," ).append("\n"); 
		query.append("       MDM_VENDOR MV" ).append("\n"); 
		query.append(" WHERE ACLA.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${agn_ar_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND ACLA.AGN_AR_OFC_CD = @[agn_ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != 'Y')" ).append("\n"); 
		query.append("   AND NVL(ACLA.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY ACLA.POD_CD," ).append("\n"); 
		query.append("          ACLA.SLAN_CD" ).append("\n"); 

	}
}