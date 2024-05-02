/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RestuffingContainerRegistrationDBDAOCtmMvmtXchVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RestuffingContainerRegistrationDBDAOCtmMvmtXchVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RestuffingContainerRegistrationDBDAOCtmMvmtXchVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_split",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration").append("\n"); 
		query.append("FileName : RestuffingContainerRegistrationDBDAOCtmMvmtXchVORSQL").append("\n"); 
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
		query.append("SELECT   XCH.CNTR_NO," ).append("\n"); 
		query.append("         XCH.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         XCH.CNMV_STS_CD," ).append("\n"); 
		query.append("         XCH.CNMV_CYC_NO," ).append("\n"); 
		query.append("         MOV.BKG_NO," ).append("\n"); 
		query.append("         '' AS BKG_NO_SPLIT," ).append("\n"); 
		query.append("         XCH.XCH_CNTR_NO," ).append("\n"); 
		query.append("         XCH.XCH_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         XCH.PRE_CNMV_STS_CD," ).append("\n"); 
		query.append("         XCH.XCH_CNTR_CYC_NO," ).append("\n"); 
		query.append("         TO_CHAR (XCH.UPD_DT, 'YYYY-MM-DD') AS DT," ).append("\n"); 
		query.append("         XCH.ORG_YD_CD||' '||YD_NM AS ORG_YD_CD," ).append("\n"); 
		query.append("         XCH_OFC_CD," ).append("\n"); 
		query.append("         XCH_RMK," ).append("\n"); 
		query.append("         XCH.CNMV_ID_NO," ).append("\n"); 
		query.append("         XCH.CNTR_XCH_REF_SEQ," ).append("\n"); 
		query.append("         XCH.CNTR_XCH_SEQ," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'BE', 'Y', '')) AS BE," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'CM', 'Y', '')) AS CM," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'CN', 'Y', '')) AS CN," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'DM', 'Y', '')) AS DM," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'DP', 'Y', '')) AS DP," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'ET', 'Y', '')) AS ET," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'OD', 'Y', '')) AS OD," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'OT', 'Y', '')) AS OT," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'OW', 'Y', '')) AS OW," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'OZ', 'Y', '')) AS OZ," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'RC', 'Y', '')) AS RC," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'RP', 'Y', '')) AS RP," ).append("\n"); 
		query.append("         MAX (DECODE (XCH_RSN_CD, 'SM', 'Y', '')) AS SM" ).append("\n"); 
		query.append("    FROM CTM_MVMT_XCH XCH," ).append("\n"); 
		query.append("         CTM_MVMT_XCH_DTL DTL1," ).append("\n"); 
		query.append("         CTM_MOVEMENT MOV," ).append("\n"); 
		query.append("         MDM_YARD YARD" ).append("\n"); 
		query.append("   WHERE 1 = 1" ).append("\n"); 
		query.append("     AND XCH.CNTR_NO = DTL1.CNTR_NO" ).append("\n"); 
		query.append("     AND XCH.CNMV_YR = DTL1.CNMV_YR" ).append("\n"); 
		query.append("     AND XCH.CNMV_ID_NO = DTL1.CNMV_ID_NO" ).append("\n"); 
		query.append("     AND XCH.CNTR_XCH_REF_SEQ = DTL1.CNTR_XCH_REF_SEQ" ).append("\n"); 
		query.append("     AND XCH.CNTR_XCH_SEQ = DTL1.CNTR_XCH_SEQ" ).append("\n"); 
		query.append("     AND XCH.CNTR_NO = MOV.CNTR_NO(+)" ).append("\n"); 
		query.append("     AND XCH.CNMV_YR = MOV.CNMV_YR(+)" ).append("\n"); 
		query.append("     AND XCH.CNMV_ID_NO = MOV.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("     AND XCH.ORG_YD_CD = YARD.YD_CD" ).append("\n"); 
		query.append("#if (${p_office} != '')" ).append("\n"); 
		query.append("     AND UPPER (XCH.XCH_OFC_CD) LIKE '%'||UPPER (@[p_office])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard1} != '')" ).append("\n"); 
		query.append("     AND SUBSTR (UPPER (XCH.ORG_YD_CD), 0, 5) LIKE '%'||UPPER (@[p_yard1])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("     AND SUBSTR (UPPER (XCH.ORG_YD_CD), 6, 2) = UPPER (@[p_yard2])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_date1} != '')" ).append("\n"); 
		query.append("     AND XCH.UPD_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_cntrno} != '')" ).append("\n"); 
		query.append("     AND UPPER (XCH.CNTR_NO) = @[p_cntrno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_split} != '')" ).append("\n"); 
		query.append("     AND XCH.CNMV_YR = @[p_split]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND EXISTS (" ).append("\n"); 
		query.append("            SELECT 'a'" ).append("\n"); 
		query.append("              FROM CTM_MVMT_XCH_DTL DTL2" ).append("\n"); 
		query.append("             WHERE DTL1.CNMV_ID_NO = DTL2.CNMV_ID_NO" ).append("\n"); 
		query.append("               AND DTL1.CNTR_XCH_REF_SEQ = DTL2.CNTR_XCH_REF_SEQ" ).append("\n"); 
		query.append("               AND DTL1.CNTR_XCH_SEQ = DTL2.CNTR_XCH_SEQ" ).append("\n"); 
		query.append("               AND DTL1.CNTR_NO = DTL2.CNTR_NO" ).append("\n"); 
		query.append("#if (${p_reson} != '')" ).append("\n"); 
		query.append("               AND DTL2.XCH_RSN_CD IN ($p_reson)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("GROUP BY XCH.CNTR_NO," ).append("\n"); 
		query.append("         XCH.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         XCH.CNMV_STS_CD," ).append("\n"); 
		query.append("         XCH.CNMV_CYC_NO," ).append("\n"); 
		query.append("         MOV.BKG_NO," ).append("\n"); 
		query.append("         XCH.XCH_CNTR_NO," ).append("\n"); 
		query.append("         XCH.XCH_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         XCH.PRE_CNMV_STS_CD," ).append("\n"); 
		query.append("         XCH.XCH_CNTR_CYC_NO," ).append("\n"); 
		query.append("         XCH.UPD_DT," ).append("\n"); 
		query.append("         XCH.ORG_YD_CD||' '||YD_NM," ).append("\n"); 
		query.append("         XCH_OFC_CD," ).append("\n"); 
		query.append("         XCH_RMK," ).append("\n"); 
		query.append("         XCH.CNMV_ID_NO," ).append("\n"); 
		query.append("         XCH.CNTR_XCH_REF_SEQ," ).append("\n"); 
		query.append("         XCH.CNTR_XCH_SEQ" ).append("\n"); 
		query.append("ORDER BY XCH.CNTR_NO," ).append("\n"); 
		query.append("         XCH.CNMV_ID_NO," ).append("\n"); 
		query.append("         XCH.CNTR_XCH_REF_SEQ," ).append("\n"); 
		query.append("         XCH.CNTR_XCH_SEQ" ).append("\n"); 

	}
}