/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentCaegoDetailMeasureRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.04 
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

public class WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentCaegoDetailMeasureRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentCaegoDetailMeasure
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentCaegoDetailMeasureRSQL(){
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
		query.append("FileName : WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentCaegoDetailMeasureRSQL").append("\n"); 
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
		query.append("		WITH A AS" ).append("\n"); 
		query.append("		 (SELECT LEVEL L" ).append("\n"); 
		query.append("				,DECODE(LEVEL, 1, 'Height', 2, 'Width', 3, 'Depth', 4, 'Volume', 5, 'Net weight', 6, 'Tare weight', 7, 'Gross weight') COL" ).append("\n"); 
		query.append("			FROM DUAL" ).append("\n"); 
		query.append("		  CONNECT BY LEVEL < 8)" ).append("\n"); 
		query.append("		SELECT A.COL AS MEAS_TYPE" ).append("\n"); 
		query.append("			  ,DECODE(A.L, 1, Height, 2, Width, 3, Depth, 4, MEAS_QTY, 5, CNTR_WGT, 6, TARE_WGT, 7, GROSS_WGT) AS MEAS_QTY" ).append("\n"); 
		query.append("			  ,DECODE(A.L, 1, 'M', 2, 'M', 3, 'M', 4, 'CBM', 5, UNIT_CD, 6, UNIT_CD, 7, UNIT_CD) AS MEAS_UNIT" ).append("\n"); 
		query.append("		  FROM (SELECT Height" ).append("\n"); 
		query.append("					  ,Width" ).append("\n"); 
		query.append("					  ,Depth" ).append("\n"); 
		query.append("					  ,MEAS_QTY" ).append("\n"); 
		query.append("					  ,ROUND(TRIM(REGEXP_SUBSTR(WGT_STR, '[^|]+', 1, 1)), 0) AS CNTR_WGT" ).append("\n"); 
		query.append("					  ,ROUND(TRIM(REGEXP_SUBSTR(WGT_STR, '[^|]+', 1, 2)), 0) AS TARE_WGT" ).append("\n"); 
		query.append("					  ,ROUND(TRIM(REGEXP_SUBSTR(WGT_STR, '[^|]+', 1, 3)), 0) AS GROSS_WGT" ).append("\n"); 
		query.append("					  ,WGT_UT_CD" ).append("\n"); 
		query.append("					  ,UNIT_CD" ).append("\n"); 
		query.append("					  ,BKG_NO" ).append("\n"); 
		query.append("				  FROM (SELECT ROUND((NVL(B.INTER_HGT + B.XTER_HGT, 0)) / 1000, 3) Height" ).append("\n"); 
		query.append("							  ,ROUND((NVL(B.INTER_WDT + B.XTER_WDT, 0)) / 1000, 3) Width" ).append("\n"); 
		query.append("							  ,ROUND((NVL(B.INTER_LEN + B.XTER_LEN, 0)) / 1000, 3) Depth" ).append("\n"); 
		query.append("							  ,NVL(D.MEAS_QTY, 0) MEAS_QTY" ).append("\n"); 
		query.append("							  ,TRS_GET_COM_SO_RAIL_WGT_FNC('S', SO.TRSP_SO_OFC_CTY_CD, SO.TRSP_SO_SEQ, NULL, SO.BKG_NO, SO.EQ_NO, SO.EQ_TPSZ_CD, NVL(NVL(D.WGT_UT_CD, SO.WGT_MEAS_UT_CD), 'KGS'), SO.COP_NO, 'Y') WGT_STR" ).append("\n"); 
		query.append("							  ,NVL(NVL(D.WGT_UT_CD, SO.WGT_MEAS_UT_CD), 'KGS') WGT_UT_CD" ).append("\n"); 
		query.append("							  ,DECODE(NVL(NVL(D.WGT_UT_CD, SO.WGT_MEAS_UT_CD), 'KGS'), 'KGS', 'KG', 'LBS', 'LB') UNIT_CD" ).append("\n"); 
		query.append("							  ,D.BKG_NO" ).append("\n"); 
		query.append("						  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("							  ,MDM_CNTR_TP_SZ   A" ).append("\n"); 
		query.append("							  ,MST_CNTR_SPEC    B" ).append("\n"); 
		query.append("							  ,MST_CONTAINER    C" ).append("\n"); 
		query.append("							  ,BKG_CONTAINER    D" ).append("\n"); 
		query.append("						 WHERE SO.EQ_TPSZ_CD = A.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("						   AND SO.EQ_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("						   AND C.CNTR_SPEC_NO = B.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("						   AND SO.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("						   AND SO.EQ_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("						   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("						   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("						   )) T1" ).append("\n"); 
		query.append("			  ,A" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}