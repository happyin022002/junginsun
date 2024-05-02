/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD Tariff Registration 팝업 Main Sheet 조회 쿼리
	  * 
	  * History
	  * 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeViewVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        decode(a.CONTI_CD, 'A', 'Asia', 'E', 'Europe', 'M', 'USA', '') CONTI_NM" ).append("\n"); 
		query.append("        ,a.CONTI_CD" ).append("\n"); 
		query.append("        ,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, '2', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'E', decode(a.DVS_FEE_TP_CD, '2', a.DVS_FEE_AMT, ''),               " ).append("\n"); 
		query.append("				                'M', decode(a.DVS_FEE_TP_CD, '2', a.DVS_FEE_AMT, ''),'')) T20FT" ).append("\n"); 
		query.append("        ,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, '4', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'E', decode(a.DVS_FEE_TP_CD, '4', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'M', decode(a.DVS_FEE_TP_CD, '4', a.DVS_FEE_AMT, ''),'')) T40FT" ).append("\n"); 
		query.append("        ,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, 'I', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'E', decode(a.DVS_FEE_TP_CD, 'I', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'M', decode(a.DVS_FEE_TP_CD, 'I', a.DVS_FEE_AMT, ''),'')) TPORT" ).append("\n"); 
		query.append("        ,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, 'B', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'E', decode(a.DVS_FEE_TP_CD, 'B', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'M', decode(a.DVS_FEE_TP_CD, 'B', a.DVS_FEE_AMT, ''),'')) TBOX    -- PER BOX (B)" ).append("\n"); 
		query.append("    	,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, 'B', decode(a.DIR_CD, 'E', a.DVS_FEE_AMT, ''), '')," ).append("\n"); 
		query.append("                            	'E', decode(a.DVS_FEE_TP_CD, 'B', decode(a.DIR_CD, 'E', a.DVS_FEE_AMT, ''), '')," ).append("\n"); 
		query.append("                            	'M', decode(a.DVS_FEE_TP_CD, 'B', decode(a.DIR_CD, 'E', a.DVS_FEE_AMT, ''), ''),'')) TBOX_E" ).append("\n"); 
		query.append("    	,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, 'B', decode(a.DIR_CD, 'W', a.DVS_FEE_AMT, ''), '')," ).append("\n"); 
		query.append("                            	'E', decode(a.DVS_FEE_TP_CD, 'B', decode(a.DIR_CD, 'W', a.DVS_FEE_AMT, ''), '')," ).append("\n"); 
		query.append("                            	'M', decode(a.DVS_FEE_TP_CD, 'B', decode(a.DIR_CD, 'W', a.DVS_FEE_AMT, ''), ''),'')) TBOX_W" ).append("\n"); 
		query.append("        ,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, 'P', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'E', decode(a.DVS_FEE_TP_CD, 'P', a.DVS_FEE_AMT, '')," ).append("\n"); 
		query.append("                                'M', decode(a.DVS_FEE_TP_CD, 'P', a.DVS_FEE_AMT, ''),'')) TBL                        " ).append("\n"); 
		query.append("    	,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, 'P', decode(a.DIR_CD, 'E', a.DVS_FEE_AMT, ''), '')," ).append("\n"); 
		query.append("                            	'E', decode(a.DVS_FEE_TP_CD, 'P', decode(a.DIR_CD, 'E', a.DVS_FEE_AMT, ''), '')," ).append("\n"); 
		query.append("                            	'M', decode(a.DVS_FEE_TP_CD, 'P', decode(a.DIR_CD, 'E', a.DVS_FEE_AMT, ''), ''),'')) TBL_E" ).append("\n"); 
		query.append("    	,max(decode(a.CONTI_CD, 'A', decode(a.DVS_FEE_TP_CD, 'P', decode(a.DIR_CD, 'W', a.DVS_FEE_AMT, ''), '')," ).append("\n"); 
		query.append("                            	'E', decode(a.DVS_FEE_TP_CD, 'P', decode(a.DIR_CD, 'W', a.DVS_FEE_AMT, ''), '')," ).append("\n"); 
		query.append("                            	'M', decode(a.DVS_FEE_TP_CD, 'P', decode(a.DIR_CD, 'W', a.DVS_FEE_AMT, ''), ''),'')) TBL_W" ).append("\n"); 
		query.append("  FROM OPF_COD_DVS_FEE a" ).append("\n"); 
		query.append("GROUP BY a.CONTI_CD" ).append("\n"); 
		query.append("ORDER BY CONTI_CD" ).append("\n"); 

	}
}