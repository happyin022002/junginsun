/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlPprMgmtTtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
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

public class BLIssuanceDBDAOSearchBlPprMgmtTtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OBL PAPER MANAGEMENT화면의 SUMMARY값을 구한다.
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlPprMgmtTtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlPprMgmtTtlRSQL").append("\n"); 
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
		query.append("SELECT TTL.DTRB_YR" ).append("\n"); 
		query.append("      ,TTL.RHQ_CD" ).append("\n"); 
		query.append("      ,TTL.OFC_CD" ).append("\n"); 
		query.append("      ,TTL.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,TTL.CUST_SEQ" ).append("\n"); 
		query.append("      ,TTL.CUST_NM" ).append("\n"); 
		query.append("      ,NVL((SELECT /*+ INDEX(AUTH XAK01BKG_INET_BL_PRN_AUTH) */ count(*) * 3" ).append("\n"); 
		query.append("             FROM BKG_INET_BL_PRN_AUTH AUTH" ).append("\n"); 
		query.append("            WHERE AUTH.AUTH_DT IS NOT NULL" ).append("\n"); 
		query.append("              AND AUTH.N1ST_PRN_DT IS NOT NULL" ).append("\n"); 
		query.append("              AND AUTH.DELT_FLG = 'N'" ).append("\n"); 
		query.append("              AND AUTH.PRN_CUST_CNT_CD = TTL.CUST_CNT_CD" ).append("\n"); 
		query.append("              AND AUTH.PRN_CUST_SEQ = TTL.CUST_SEQ" ).append("\n"); 
		query.append("#if (${dtrb_yr} != 'ALL') " ).append("\n"); 
		query.append("              AND AUTH.N1ST_PRN_DT >= DECODE(@[dtrb_yr],'2015',TO_DATE('20150401','YYYYMMDD'),TO_DATE(@[dtrb_yr]||'0101','YYYYMMDD'))" ).append("\n"); 
		query.append("              AND AUTH.N1ST_PRN_DT < TO_DATE(@[dtrb_yr] + 1||'0101','YYYYMMDD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND AUTH.N1ST_PRN_DT >= TO_DATE('20150401','YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ),0) AS CUST_WDR_KNT" ).append("\n"); 
		query.append("       ,TTL.CUST_DTRB_KNT" ).append("\n"); 
		query.append("       ,TO_CHAR(TTL.UPD_DT,'YYYY.MM.DD') AS UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT PPR.DTRB_YR" ).append("\n"); 
		query.append("          ,PPR.RHQ_CD" ).append("\n"); 
		query.append("          ,PPR.OFC_CD" ).append("\n"); 
		query.append("          ,PPR.CUST_CNT_CD" ).append("\n"); 
		query.append("          ,PPR.CUST_SEQ" ).append("\n"); 
		query.append("          ,MDM.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("          ,SUM(PPR.CUST_DTRB_KNT) AS CUST_DTRB_KNT" ).append("\n"); 
		query.append("          ,MAX(PPR.UPD_DT) AS UPD_DT" ).append("\n"); 
		query.append("      FROM BKG_CUST_BL_PPR_MGMT PPR" ).append("\n"); 
		query.append("          ,MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("    #if (${dtrb_yr} != 'ALL') " ).append("\n"); 
		query.append("       AND PPR.DTRB_YR = @[dtrb_yr]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if (${rhq_cd} != '') " ).append("\n"); 
		query.append("       AND PPR.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("    #end   " ).append("\n"); 
		query.append("    #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("       AND PPR.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("    #end   " ).append("\n"); 
		query.append("    #if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("       AND PPR.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    #if (${cust_seq} != '') " ).append("\n"); 
		query.append("       AND PPR.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("       AND PPR.CUST_CNT_CD = MDM.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND PPR.CUST_SEQ = MDM.CUST_SEQ" ).append("\n"); 
		query.append("    #if (${cust_nm} != '') " ).append("\n"); 
		query.append("       AND MDM.CUST_LGL_ENG_NM LIKE '%'||@[cust_nm]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    GROUP BY PPR.DTRB_YR" ).append("\n"); 
		query.append("            ,PPR.RHQ_CD" ).append("\n"); 
		query.append("            ,PPR.OFC_CD" ).append("\n"); 
		query.append("            ,PPR.CUST_CNT_CD" ).append("\n"); 
		query.append("            ,PPR.CUST_SEQ" ).append("\n"); 
		query.append("            ,MDM.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        ) TTL" ).append("\n"); 
		query.append("ORDER BY TTL.DTRB_YR" ).append("\n"); 
		query.append("        ,TTL.RHQ_CD" ).append("\n"); 
		query.append("        ,TTL.OFC_CD" ).append("\n"); 
		query.append("        ,TTL.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,TTL.CUST_SEQ" ).append("\n"); 

	}
}