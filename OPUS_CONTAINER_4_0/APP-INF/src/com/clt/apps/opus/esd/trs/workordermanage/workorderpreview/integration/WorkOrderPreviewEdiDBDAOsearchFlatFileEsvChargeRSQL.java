/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {CHARGE
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvChargeRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvChargeRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT NVL(SO.BZC_AMT, 0) + NVL(SO.NEGO_AMT, 0) AS FREIGHT" ).append("\n"); 
		query.append("			  ,SO.CURR_CD AS CURRENCY" ).append("\n"); 
		query.append("			  ,TO_CHAR(D.FUEL_RTO) AS FSC_PERCENT" ).append("\n"); 
		query.append("			  ,'true' AS BILLABLE" ).append("\n"); 
		query.append("			  ,'' AS CHARGE_REF" ).append("\n"); 
		query.append("			  ,'' AS CHARGE_COMMENT" ).append("\n"); 
		query.append("			  ,NVL(SO.BZC_AMT, 0) + NVL(SO.FUEL_SCG_AMT, 0) + NVL(SO.NEGO_AMT, 0) AS TOTAL_CHARGE" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("			  ,TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("		 WHERE SO.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = D.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("		   AND SUBSTR(D.LGS_COST_CD(+), 3, 2) = 'FU'" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}