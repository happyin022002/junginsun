/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchMovementListByBkgInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.02.17 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchMovementListByBkgInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0409
	  * -- Booking Infomation (HTML INPUT)
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchMovementListByBkgInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchMovementListByBkgInfoVORSQL").append("\n"); 
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
		query.append("SELECT BB.BKG_NO," ).append("\n"); 
		query.append("BB.BL_NO," ).append("\n"); 
		query.append("NVL (BB.BKG_STS_CD, '') AS BKG_STS_CD," ).append("\n"); 
		query.append("NVL (BB.BKG_CGO_TP_CD, '') AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("NVL (BB.DEL_CD, '') AS DEL_CD," ).append("\n"); 
		query.append("NVL (BB.DE_TERM_CD, '') AS DE_TERM_CD," ).append("\n"); 
		query.append("NVL (BB.POD_CD, '') AS POD_CD," ).append("\n"); 
		query.append("NVL (BB.POL_CD, '') AS BKG_POL_CD," ).append("\n"); 
		query.append("NVL (BB.POR_CD, '') AS POR_CD," ).append("\n"); 
		query.append("NVL (BB.RCV_TERM_CD, '') AS RCV_TERM_CD," ).append("\n"); 
		query.append("NVL (DECODE (FM_BKG_NO, NULL, SPLIT_RSN_CD, FM_BKG_NO), '') AS SPLIT_CD," ).append("\n"); 
		query.append("NVL (BB_S2.SPLIT_COUNT, '') AS SPLIT_COUNT," ).append("\n"); 
		query.append("NVL (BB_S3.BKG_NO, '') AS SPLIT_BKG_NO," ).append("\n"); 
		query.append("NVL (BB_S3.BKG_NO_SPLIT, '') AS SPLIT_BKG_NO_SPLIT," ).append("\n"); 
		query.append("BC.SHPR," ).append("\n"); 
		query.append("BC.CNEE," ).append("\n"); 
		query.append("BC.NTFY," ).append("\n"); 
		query.append("BV.PRE_POL_CD," ).append("\n"); 
		query.append("BV.T_VVD," ).append("\n"); 
		query.append("BV.POL_CD AS T_POL_CD," ).append("\n"); 
		query.append("BV.POST_POL_CD," ).append("\n"); 
		query.append("MC.REP_CMDT_NM" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB," ).append("\n"); 
		query.append("MDM_REP_CMDT MC," ).append("\n"); 
		query.append("(SELECT   BKG_NO," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN COUNT (BKG_NO) > 1" ).append("\n"); 
		query.append("THEN COUNT (BKG_NO)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS SPLIT_COUNT" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY BKG_NO) BB_S2," ).append("\n"); 
		query.append("(SELECT BKG_NO," ).append("\n"); 
		query.append("BKG_NO_SPLIT" ).append("\n"); 
		query.append("FROM (SELECT BKG_NO," ).append("\n"); 
		query.append("SUBSTR(BKG_NO, 12, 2) AS BKG_NO_SPLIT" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY SUBSTR(BKG_NO, 12, 2) )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1) BB_S3," ).append("\n"); 
		query.append("(SELECT BKG_NO," ).append("\n"); 
		query.append("PRE_POL_CD," ).append("\n"); 
		query.append("T_VVD," ).append("\n"); 
		query.append("POL_CD," ).append("\n"); 
		query.append("POST_POL_CD" ).append("\n"); 
		query.append("FROM DUAL," ).append("\n"); 
		query.append("(SELECT BKG_NO," ).append("\n"); 
		query.append("LAG (POL_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD) AS PRE_POL_CD," ).append("\n"); 
		query.append("LEAD (POL_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD) AS POST_POL_CD," ).append("\n"); 
		query.append("VSL_PRE_PST_CD," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS T_VVD," ).append("\n"); 
		query.append("POL_CD" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("WHERE VSL_PRE_PST_CD = 'T') BV," ).append("\n"); 
		query.append("(SELECT BKG_NO," ).append("\n"); 
		query.append("MAX (DECODE (BKG_CUST_TP_CD, 'S', REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (CUST_NM, CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' '), '')) AS SHPR," ).append("\n"); 
		query.append("MAX (DECODE (BKG_CUST_TP_CD, 'C', REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (CUST_NM, CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' '), '')) AS CNEE," ).append("\n"); 
		query.append("MAX (DECODE (BKG_CUST_TP_CD, 'N', REPLACE (REPLACE (REPLACE (REPLACE (REPLACE (CUST_NM, CHR(92)||'r'||CHR(92)||'n', ' '), CHR(13)||CHR(10), ' '), CHR(34), ' '), CHR(9), ' '),  CHR(13),  ' '), '')) AS NTFY" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE BKG_CUST_TP_CD IN ('S', 'C', 'N')" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY BKG_NO) BC" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BB.REP_CMDT_CD = MC.REP_CMDT_CD" ).append("\n"); 
		query.append("AND BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("AND BC.BKG_NO = BV.BKG_NO" ).append("\n"); 

	}
}