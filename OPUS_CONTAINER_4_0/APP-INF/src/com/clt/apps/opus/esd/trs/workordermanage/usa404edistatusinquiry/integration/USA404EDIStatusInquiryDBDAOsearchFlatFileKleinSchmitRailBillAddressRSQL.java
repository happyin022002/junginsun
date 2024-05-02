/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillAddressRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.06.24 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillAddressRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFlatFileKleinSchmitRailBillAddress
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillAddressRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillAddressRSQL").append("\n"); 
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
		query.append("SELECT  PARTY_TP, PARTY_NM, PARTY_ADD1, PARTY_ADD2, PARTY_CITY, PARTY_STATE, PARTY_POSTAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT  DISTINCT PARTY_TP, PARTY_NM, PARTY_ADD1, PARTY_ADD2, PARTY_CITY, PARTY_STATE, PARTY_POSTAL, RANK() OVER(PARTITION BY PARTY_TP ORDER BY BKG_CUST_TP_SEQ) RK" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			  DECODE(J.BKG_CUST_TP_CD, 'S', 1, 'F', 2, 'C', 3, 'N', 4) BKG_CUST_TP_SEQ" ).append("\n"); 
		query.append("			 ,CASE WHEN A.TRSP_BND_CD = 'O' THEN " ).append("\n"); 
		query.append("					 CASE WHEN NVL(M.RAIL_ROAD_PRIO_FLG, 'N') = 'Y' AND J.BKG_CUST_TP_CD IN ('S', 'F') THEN 'SF'" ).append("\n"); 
		query.append("						  WHEN NVL(M.RAIL_ROAD_PRIO_FLG, 'N') = 'N' AND J.BKG_CUST_TP_CD IN ('S', 'F') THEN ''" ).append("\n"); 
		query.append("						  ELSE '' " ).append("\n"); 
		query.append("					 END" ).append("\n"); 
		query.append("				   WHEN A.TRSP_BND_CD = 'I' THEN " ).append("\n"); 
		query.append("					 CASE WHEN NVL(M.RAIL_ROAD_PRIO_FLG, 'N') = 'Y' AND J.BKG_CUST_TP_CD = 'C' THEN CASE WHEN B.CUST_TO_ORD_FLG = 'Y' THEN 'N1' ELSE 'UC' END" ).append("\n"); 
		query.append("						  WHEN NVL(M.RAIL_ROAD_PRIO_FLG, 'N') = 'N' AND J.BKG_CUST_TP_CD = 'C' THEN ''" ).append("\n"); 
		query.append("						  ELSE '' " ).append("\n"); 
		query.append("					 END" ).append("\n"); 
		query.append("				   ELSE ''" ).append("\n"); 
		query.append("			  END PARTY_TP" ).append("\n"); 
		query.append("			 ,CASE WHEN A.TRSP_BND_CD = 'O' THEN  CASE WHEN NVL(M.RAIL_ROAD_PRIO_FLG, 'N') = 'Y' AND J.BKG_CUST_TP_CD IN ('S', 'F') THEN NVL(M.CUST_ABBR_NM, J.CUST_NM)	ELSE J.CUST_NM END" ).append("\n"); 
		query.append("				   WHEN A.TRSP_BND_CD = 'I' THEN  CASE WHEN NVL(M.RAIL_ROAD_PRIO_FLG, 'N') = 'Y' AND J.BKG_CUST_TP_CD = 'C' THEN NVL(M.CUST_ABBR_NM, J.CUST_NM) ELSE J.CUST_NM END" ).append("\n"); 
		query.append("				   ELSE J.CUST_NM" ).append("\n"); 
		query.append("			  END PARTY_NM" ).append("\n"); 
		query.append("			 ,TRIM(REPLACE(REPLACE(REPLACE(J.CUST_ADDR, CHR(13), ' '), CHR(10), ' '), CHR(43), ' ')) AS PARTY_ADD1" ).append("\n"); 
		query.append("			 ,'' AS PARTY_ADD2" ).append("\n"); 
		query.append("			 ,J.CUST_CTY_NM AS PARTY_CITY" ).append("\n"); 
		query.append("			 ,NVL(L.STE_CD, J.CUST_STE_CD) AS PARTY_STATE" ).append("\n"); 
		query.append("			 ,J.CUST_ZIP_ID AS PARTY_POSTAL" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("			  ,BKG_CUSTOMER          J" ).append("\n"); 
		query.append("			  ,MDM_CUSTOMER          M" ).append("\n"); 
		query.append("			  ,BKG_BOOKING           B" ).append("\n"); 
		query.append("              ,MDM_LOCATION          L" ).append("\n"); 
		query.append("		 WHERE A.BKG_NO = J.BKG_NO" ).append("\n"); 
		query.append("		   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		   AND J.BKG_CUST_TP_CD IN ('S', 'F', 'N', 'C')" ).append("\n"); 
		query.append("		   AND J.CUST_CNT_CD    = M.CUST_CNT_CD" ).append("\n"); 
		query.append("		   AND J.CUST_SEQ       = M.CUST_SEQ" ).append("\n"); 
		query.append("           AND M.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("           AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND L.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		   AND A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHERE PARTY_TP IS NOT NULL AND PARTY_NM IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RK = 1" ).append("\n"); 

	}
}