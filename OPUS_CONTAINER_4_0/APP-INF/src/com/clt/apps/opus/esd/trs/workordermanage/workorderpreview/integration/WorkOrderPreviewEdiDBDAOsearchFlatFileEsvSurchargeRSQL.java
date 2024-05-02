/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvSurchargeRSQL.java
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvSurchargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {SURCHARGE
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvSurchargeRSQL(){
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
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvSurchargeRSQL").append("\n"); 
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
		query.append("		SELECT D.LGS_COST_CD AS SURCHARGE_TYPE" ).append("\n"); 
		query.append("			  ,D.SCG_AMT AS AMOUNT" ).append("\n"); 
		query.append("			  ,SO.CURR_CD AS CURRENCY" ).append("\n"); 
		query.append("			  ,'true' AS BILLABLE" ).append("\n"); 
		query.append("			  ,'' AS SURCHARGE_REF" ).append("\n"); 
		query.append("			  ,'' AS SURCHARGE_COMMENT" ).append("\n"); 
		query.append("			  ,D.LGS_COST_CD || '-' || C.INTG_CD_VAL_DP_DESC AS DESCRIPTION" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("			  ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("			  ,COM_INTG_CD_DTL  C" ).append("\n"); 
		query.append("		 WHERE D.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND D.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("		   AND D.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		   AND D.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("		   AND SUBSTR(D.LGS_COST_CD, 3, 2) <> 'FU'" ).append("\n"); 
		query.append("		   AND D.LGS_COST_CD = C.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("		   AND C.INTG_CD_ID(+) = 'CD30002'" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}