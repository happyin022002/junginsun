/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiCmdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiCmdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchDblEdiCmdt
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiCmdtRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiCmdtRSQL").append("\n"); 
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
		query.append("    ROWNUM CMDT_SEQ," ).append("\n"); 
		query.append("    PCK_TP_CD," ).append("\n"); 
		query.append("    PCK_QTY," ).append("\n"); 
		query.append("    PCK_DES," ).append("\n"); 
		query.append("    CNTR_MF_WGT," ).append("\n"); 
		query.append("    WGT_UT_CD," ).append("\n"); 
		query.append("    NET_CNTR_MF_WGT," ).append("\n"); 
		query.append("    NET_WGT_UT_CD," ).append("\n"); 
		query.append("    MEAS_QTY," ).append("\n"); 
		query.append("    MEAS_UT_CD," ).append("\n"); 
		query.append("    HAMO_TRF_CD," ).append("\n"); 
		query.append("    CMDT_HS_CD," ).append("\n"); 
		query.append("    NCM_NO," ).append("\n"); 
		query.append("    CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("    CNTR_MF_MK_DESC," ).append("\n"); 
		query.append("    BKG_NO" ).append("\n"); 
		query.append("FROM (    " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	SUM(PCK_QTY) AS PCK_QTY," ).append("\n"); 
		query.append("	PCK_TP_CD," ).append("\n"); 
		query.append("	(SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = CM.PCK_TP_CD) PCK_DES," ).append("\n"); 
		query.append("	SUM(CNTR_MF_WGT) AS CNTR_MF_WGT," ).append("\n"); 
		query.append("	WGT_UT_CD WGT_UT_CD," ).append("\n"); 
		query.append("	SUM(CNTR_MF_WGT) NET_CNTR_MF_WGT," ).append("\n"); 
		query.append("	WGT_UT_CD NET_WGT_UT_CD," ).append("\n"); 
		query.append("	SUM(MEAS_QTY) AS MEAS_QTY," ).append("\n"); 
		query.append("	MEAS_UT_CD," ).append("\n"); 
		query.append("	HAMO_TRF_CD," ).append("\n"); 
		query.append("	CMDT_HS_CD," ).append("\n"); 
		query.append("	NCM_NO," ).append("\n"); 
		query.append("	REPLACE(CNTR_MF_GDS_DESC,CHR(10),' ') CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("	REPLACE(CNTR_MF_MK_DESC,CHR(10), ' ') CNTR_MF_MK_DESC," ).append("\n"); 
		query.append("    BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY PCK_TP_CD, " ).append("\n"); 
		query.append("		 WGT_UT_CD," ).append("\n"); 
		query.append("		 MEAS_UT_CD," ).append("\n"); 
		query.append("		 HAMO_TRF_CD," ).append("\n"); 
		query.append("		 CMDT_HS_CD,		" ).append("\n"); 
		query.append("		 NCM_NO," ).append("\n"); 
		query.append("		 CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("		 CNTR_MF_MK_DESC," ).append("\n"); 
		query.append("		 BKG_NO" ).append("\n"); 
		query.append(")		 " ).append("\n"); 

	}
}