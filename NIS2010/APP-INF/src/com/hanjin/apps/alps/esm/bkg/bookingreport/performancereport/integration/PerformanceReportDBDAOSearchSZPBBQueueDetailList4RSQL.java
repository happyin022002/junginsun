/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchSZPBBQueueDetailList4RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchSZPBBQueueDetailList4RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0437 Queue Detail List Complete Flag를 조회합니다.
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchSZPBBQueueDetailList4RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchSZPBBQueueDetailList4RSQL").append("\n"); 
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
		query.append("SELECT SUM(RATE_FLG) AS RATE" ).append("\n"); 
		query.append("      ,SUM(INPUT_FLG) AS INPUT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT DECODE(RT_BL_TP_CD,'B',1,'C',1," ).append("\n"); 
		query.append("             DECODE((SELECT COUNT(*) " ).append("\n"); 
		query.append("                       FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                      WHERE BKG_NO = @[bkg_no]),0,0,1)) RATE_FLG" ).append("\n"); 
		query.append("      ,0 AS INPUT_FLG            " ).append("\n"); 
		query.append("  FROM BKG_RATE" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 0 AS RATE_FLG" ).append("\n"); 
		query.append("      ,(SELECT NVL((SELECT DISTINCT DECODE(NVL(CUST_NM,'N'),'N',0,1)" ).append("\n"); 
		query.append("                      FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("                     WHERE BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("                       AND BKG_NO = @[bkg_no]),0) +" ).append("\n"); 
		query.append("               NVL((SELECT DISTINCT 1 " ).append("\n"); 
		query.append("                      FROM BKG_BL_MK_DESC" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]),0) +" ).append("\n"); 
		query.append("               NVL((SELECT DISTINCT 1 " ).append("\n"); 
		query.append("                      FROM BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]),0) +" ).append("\n"); 
		query.append("               NVL((SELECT DISTINCT 1 " ).append("\n"); 
		query.append("                      FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                       AND MF_CFM_FLG = 'Y'),0) +" ).append("\n"); 
		query.append("               NVL((SELECT DISTINCT 1 " ).append("\n"); 
		query.append("                      FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                       AND BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("                       AND DOC_PERF_DELT_FLG = 'N'),0)" ).append("\n"); 
		query.append("                      FROM DUAL) INPUT_FLG " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}