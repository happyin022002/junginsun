/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingUtilDBDAOSearchSoStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchSoStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSoStatus
	  * 2011.02.23 이일민 [CHM-201108682-01] BKG Cancel시(CNTR NO가 없는 경우) S/O에 대한 Validation 설정 요청.
	  * 2011.04.25 이일민 [CHM-201110326] TRO/O와 BKG Main상 Validation Logic 추가 요청.
	  * 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
	  * </pre>
	  */
	public BookingUtilDBDAOSearchSoStatusRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchSoStatusRSQL").append("\n"); 
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
		query.append("SELECT MAX(RSLT) AS RSLT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT case when COUNT(1) > 0 then 'Y' else 'N' end AS RSLT" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("           AND EQ_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND NVL(TRSP_FRST_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append("#if (${bound_cd} == 'O')" ).append("\n"); 
		query.append("           AND TRSP_BND_CD  = @[bound_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND COST_ACT_GRP_CD NOT LIKE 'OD%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	       AND TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT case when COUNT(1) > 0 then 'Y' else 'N' end AS RSLT" ).append("\n"); 
		query.append("        FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("           AND EQ_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND NVL(TRSP_FRST_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT CASE WHEN NVL(A1.TRSP_SO_QTY, 0) - NVL(A2.CNTR_QTY, 0) >= 0 AND NVL(A1.TRSP_SO_QTY, 0) > 0 THEN 'Y' ELSE 'N' END AS RSLT_CNTR" ).append("\n"); 
		query.append("          FROM (SELECT BKG_NO" ).append("\n"); 
		query.append("                      ,COUNT(BKG_NO) AS TRSP_SO_QTY" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND NVL(TRSP_FRST_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append("		   		   AND COST_ACT_GRP_CD LIKE 'OD%'" ).append("\n"); 
		query.append("			       AND TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                   AND EQ_NO IS NULL" ).append("\n"); 
		query.append("                 GROUP BY BKG_NO) A1" ).append("\n"); 
		query.append("              ,(SELECT BKG_NO" ).append("\n"); 
		query.append("                      ,COUNT(CNTR_NO) AS CNTR_QTY" ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 GROUP BY BKG_NO) A2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A1.BKG_NO = A2.BKG_NO (+) " ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}