/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOSearchFlatFileEsvHazardodusMeasurementRSQL.java
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

public class WorkOrderPreviewEdiDBDAOSearchFlatFileEsvHazardodusMeasurementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewEdiDBDAOSearchFlatFileEsvHazardodusMeasurement
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOSearchFlatFileEsvHazardodusMeasurementRSQL(){
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
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOSearchFlatFileEsvHazardodusMeasurementRSQL").append("\n"); 
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
		query.append("		SELECT 'Net weight' AS MEAS_TYPE" ).append("\n"); 
		query.append("			  ,ROUND(D.NET_WGT, 0) AS MEAS_QTY" ).append("\n"); 
		query.append("			  ,'KG' AS MEAS_UNIT" ).append("\n"); 
		query.append("		  FROM BKG_DG_CGO D" ).append("\n"); 
		query.append("		 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		   AND DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 'Gross weight' AS MEAS_TYPE" ).append("\n"); 
		query.append("			  ,ROUND(D.GRS_WGT, 0) AS MEAS_QTY" ).append("\n"); 
		query.append("			  ,'KG' AS MEAS_UNIT" ).append("\n"); 
		query.append("		  FROM BKG_DG_CGO D" ).append("\n"); 
		query.append("		 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		   AND DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}