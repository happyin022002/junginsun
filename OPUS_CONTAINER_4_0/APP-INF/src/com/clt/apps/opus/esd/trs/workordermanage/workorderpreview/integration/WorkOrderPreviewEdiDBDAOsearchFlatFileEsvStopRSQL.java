/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvStopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvStopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {STOP_LIST
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvStopRSQL(){
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
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvStopRSQL").append("\n"); 
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
		query.append("SELECT COUNT(MULTI.MLT_STOP_SEQ) AS TOTAL_APPT" ).append("\n"); 
		query.append("  FROM (SELECT SO.BKG_NO" ).append("\n"); 
		query.append("              ,TRO.TRO_SEQ TRSP_RQST_ORD_SEQ" ).append("\n"); 
		query.append("              ,SO.TRSP_BND_CD" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("              ,BKG_EUR_TRO      TRO" ).append("\n"); 
		query.append("         WHERE SO.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("           AND SO.TRSP_BND_CD = TRO.IO_BND_CD(+)" ).append("\n"); 
		query.append("           AND SO.TRO_SEQ = TRO.TRO_SEQ(+)" ).append("\n"); 
		query.append("           AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("           AND SO.TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("		) CNTR" ).append("\n"); 
		query.append("      ,BKG_EUR_TRO_DTL MULTI" ).append("\n"); 
		query.append(" WHERE CNTR.BKG_NO = MULTI.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CNTR.TRSP_RQST_ORD_SEQ = MULTI.TRO_SEQ(+)" ).append("\n"); 
		query.append("   AND CNTR.TRSP_BND_CD = MULTI.IO_BND_CD(+)" ).append("\n"); 

	}
}