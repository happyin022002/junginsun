/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentReferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.31 
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

public class WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentReferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentReference
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentReferenceRSQL(){
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
		query.append("FileName : WorkOrderPreviewEdiDBDAOSearchFlatFileEsvEquipmentReferenceRSQL").append("\n"); 
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
		query.append("       SELECT '' AS VENDOR_REF" ).append("\n"); 
		query.append("              ,'' AS RAIL_BILL_NO" ).append("\n"); 
		query.append("              ,'' AS SND_REF" ).append("\n"); 
		query.append("              ,SO.BKG_NO AS MTREL_NO" ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC(A XPKBKG_CSTMS_EUR_DG_RCV) */ A.MSG_ACPT_REF_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_DG_RCV A" ).append("\n"); 
		query.append("                 WHERE EUR_EDI_MSG_TP_ID = 'CTA'" ).append("\n"); 
		query.append("                   AND A.MSG_ACPT_REF_NO LIKE 'ATB%'" ).append("\n"); 
		query.append("                   AND A.BL_NO = SO.BL_NO" ).append("\n"); 
		query.append("                   AND A.CNTR_NO = SO.EQ_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) ATB_NO" ).append("\n"); 
		query.append("              ,SO.CNTR_SLT_NO AS PKG_REF" ).append("\n"); 
		query.append("              ,SO.REF_ID AS MTPLAN_NO" ).append("\n"); 
		query.append("              ,SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("              ,SO.BL_NO" ).append("\n"); 
		query.append("              ,SO.BKG_NO" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("         WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}