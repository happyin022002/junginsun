/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetTotalQuantityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.03.19 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderSheetDBDAOsearchWorkOrderSheetTotalQuantityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Work Order Shee Total Quantity
	  * </pre>
	  */
	public WorkOrderSheetDBDAOsearchWorkOrderSheetTotalQuantityRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetTotalQuantityRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  SUM(CASE WHEN SO.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("           AND SUBSTR(SO.EQ_TPSZ_CD,2,1) = '2'" ).append("\n"); 
		query.append("        THEN 1" ).append("\n"); 
		query.append("      ELSE 0" ).append("\n"); 
		query.append("   END)                                           AS TOTAL_20," ).append("\n"); 
		query.append("  SUM(CASE WHEN SO.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("           AND SUBSTR(SO.EQ_TPSZ_CD,2,1) = '2'" ).append("\n"); 
		query.append("        THEN 0" ).append("\n"); 
		query.append("      ELSE 1" ).append("\n"); 
		query.append("   END)                                           AS TOTAL_40," ).append("\n"); 
		query.append("  SUM(CASE WHEN SO.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("        THEN 1" ).append("\n"); 
		query.append("      ELSE 0" ).append("\n"); 
		query.append("   END)                                           AS TOTAL_QNT," ).append("\n"); 
		query.append("  SUM(	NVL(SO.BZC_AMT, 0)  	+" ).append("\n"); 
		query.append("      	NVL(SO.NEGO_AMT, 0) 	+" ).append("\n"); 
		query.append("   		NVL(SO.ETC_ADD_AMT, 0) 	+" ).append("\n"); 
		query.append("   		NVL(SO.FUEL_SCG_AMT, 0)	+" ).append("\n"); 
		query.append("		NVL(SO.TOLL_FEE_AMT, 0))                 AS TOTAL_AMT," ).append("\n"); 
		query.append("   MAX(SO.CURR_CD)                               AS CURR_CD," ).append("\n"); 
		query.append("  ROUND(SUM(NVL((SELECT PSO_CONV_CURR_USD_FNC(MAX(SO.CURR_CD)," ).append("\n"); 
		query.append("                        SUM(NVL(SO.BZC_AMT, 0) +" ).append("\n"); 
		query.append("                        NVL(SO.NEGO_AMT, 0)    +" ).append("\n"); 
		query.append("                        NVL(SO.ETC_ADD_AMT, 0) +" ).append("\n"); 
		query.append("                        NVL(SO.FUEL_SCG_AMT, 0)+" ).append("\n"); 
		query.append("						NVL(SO.TOLL_FEE_AMT, 0))," ).append("\n"); 
		query.append("                        TO_CHAR(WO.LOCL_CRE_DT,'YYYYMM'),1) " ).append("\n"); 
		query.append("                 FROM DUAL),0)),2)               AS TOTAL_AMT_USD                     " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("      TRS_TRSP_WRK_ORD                            WO," ).append("\n"); 
		query.append("      TRS_TRSP_SVC_ORD                            SO" ).append("\n"); 
		query.append("WHERE WO.TRSP_WO_OFC_CTY_CD                   = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND WO.TRSP_WO_SEQ                          = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("  AND (WO.TRSP_WO_OFC_CTY_CD,WO.TRSP_WO_SEQ)  = ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append("#if (${wo_vndr_seq} != '')" ).append("\n"); 
		query.append("	AND   WO.wo_vndr_seq  =  @[wo_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}