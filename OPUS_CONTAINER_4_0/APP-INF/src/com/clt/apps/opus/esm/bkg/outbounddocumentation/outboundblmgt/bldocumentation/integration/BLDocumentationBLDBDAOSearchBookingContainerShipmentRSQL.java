/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchBookingContainerShipmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchBookingContainerShipmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Shipment Detail 팝업 화면을 조회한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchBookingContainerShipmentRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchBookingContainerShipmentRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("    ,CNTR_MF_SEQ " ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,CNTR_VOL_QTY" ).append("\n"); 
		query.append("	,PCK_QTY" ).append("\n"); 
		query.append("	,PCK_TP_CD" ).append("\n"); 
		query.append("	,CNTR_MF_WGT" ).append("\n"); 
		query.append("	,WGT_UT_CD" ).append("\n"); 
		query.append("	,MEAS_QTY" ).append("\n"); 
		query.append("	,MEAS_UT_CD" ).append("\n"); 
		query.append("	,MK_DESC" ).append("\n"); 
		query.append("	,CMDT_DESC" ).append("\n"); 
		query.append("	,PRN_FLG" ).append("\n"); 
		query.append("	,CNTR_SEAL_NO1" ).append("\n"); 
		query.append("	,CNTR_SEAL_NO2" ).append("\n"); 
		query.append("	,CMDT_HS_CD" ).append("\n"); 
		query.append("	,HAMO_TRF_CD" ).append("\n"); 
		query.append("	,NCM_NO" ).append("\n"); 
		query.append("	,PO_NO" ).append("\n"); 
		query.append("FROM BKG_CNTR_SHP" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY BKG_NO, CNTR_SEQ,CNTR_MF_SEQ" ).append("\n"); 

	}
}