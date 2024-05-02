/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileUsvChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHARGE
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileUsvChargeRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvChargeRSQL").append("\n"); 
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
		query.append("SELECT T1.* " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT STOP_NO" ).append("\n"); 
		query.append("		  ,SVC_CD" ).append("\n"); 
		query.append("		  ,AMOUNT" ).append("\n"); 
		query.append("		  ,CURRENCY" ).append("\n"); 
		query.append("		  ,TRIM(TO_CHAR(CASE WHEN FUEL_RTO = 0 THEN ROUND(SCG_AMT * 100 / NULLIF(AMOUNT, 0), 2) ELSE FUEL_RTO END, '999999990.90')) FSC_PERCENT" ).append("\n"); 
		query.append("		  ,'true' AS BILLABLE" ).append("\n"); 
		query.append("		  ,'' AS CHARGE_REF" ).append("\n"); 
		query.append("		  ,'' AS BILLTO" ).append("\n"); 
		query.append("		  ,'' AS CHG_COMMENT" ).append("\n"); 
		query.append("	  FROM (SELECT '' STOP_NO" ).append("\n"); 
		query.append("				  ,'TRCOST' AS SVC_CD" ).append("\n"); 
		query.append("				  ,DECODE((NVL(SO.BZC_AMT, 0) + NVL(SO.NEGO_AMT, 0)), 0, 0.01, NVL(SO.BZC_AMT, 0) + NVL(SO.NEGO_AMT, 0)) AS AMOUNT" ).append("\n"); 
		query.append("				  ,SO.CURR_CD AS CURRENCY" ).append("\n"); 
		query.append("				  ,NVL(D.SCG_AMT, 0) SCG_AMT" ).append("\n"); 
		query.append("				  ,NVL(D.FUEL_RTO, 0) FUEL_RTO" ).append("\n"); 
		query.append("			  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("				  ,TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("			 WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("			   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("			   AND NVL2(@[cntr_no], SO.EQ_NO, 'XX') = NVL2(@[cntr_no], @[cntr_no], 'XX')" ).append("\n"); 
		query.append("			   AND NVL2(@[cntr_tpsz], SO.EQ_TPSZ_CD, 'XX') = NVL2(@[cntr_tpsz], @[cntr_tpsz], 'XX')              " ).append("\n"); 
		query.append("			   AND SO.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("			   AND SO.TRSP_SO_SEQ = D.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("			   AND SUBSTR(D.LGS_COST_CD(+), 3, 2) = 'FU')" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT '' STOP_NO" ).append("\n"); 
		query.append("		  ,DECODE(SUBSTR(DTL.LGS_COST_CD, 3, 2), 'FU', 'SCFAAL', DTL.LGS_COST_CD)  AS SVC_CD" ).append("\n"); 
		query.append("		  ,DTL.SCG_AMT AS AMOUNT" ).append("\n"); 
		query.append("		  ,SO.CURR_CD AS CURRENCY" ).append("\n"); 
		query.append("		  ,DECODE(SUBSTR(DTL.LGS_COST_CD, 3, 2), 'FU', TO_CHAR(DTL.FUEL_RTO), '') AS FSC_PERCENT" ).append("\n"); 
		query.append("		  ,'true' AS BILLABLE" ).append("\n"); 
		query.append("		  ,'' AS CHARGE_REF" ).append("\n"); 
		query.append("		  ,'' AS BILLTO" ).append("\n"); 
		query.append("		  ,'' AS CHG_COMMENT" ).append("\n"); 
		query.append("	  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("		  ,TRS_TRSP_SCG_DTL DTL" ).append("\n"); 
		query.append("	 WHERE SO.TRSP_SO_OFC_CTY_CD = DTL.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	   AND SO.TRSP_SO_SEQ = DTL.TRSP_SO_SEQ" ).append("\n"); 
		query.append("	   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("	   AND NVL2(@[cntr_no], SO.EQ_NO, 'XX') = NVL2(@[cntr_no], @[cntr_no], 'XX')" ).append("\n"); 
		query.append("	   AND NVL2(@[cntr_tpsz], SO.EQ_TPSZ_CD, 'XX') = NVL2(@[cntr_tpsz], @[cntr_tpsz], 'XX')" ).append("\n"); 
		query.append("	   AND SUBSTR(DTL.LGS_COST_CD(+), 3, 2) <> 'FU'" ).append("\n"); 
		query.append(") T1 RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("  ON 1 = 1" ).append("\n"); 

	}
}