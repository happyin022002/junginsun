/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSAManifestDBDAOSearchCmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOSearchCmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOSearchCmInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOSearchCmInfoRSQL").append("\n"); 
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
		query.append("SELECT DSC.CNTR_NO," ).append("\n"); 
		query.append("       DSC.CNTR_MF_SEQ," ).append("\n"); 
		query.append("       DSC.PCK_QTY ," ).append("\n"); 
		query.append("       NVL2(CNV.CSTMS_PCK_TP_CD, CNV.CSTMS_PCK_TP_CD, DSC.PCK_TP_CD) AS CSTMS_PCK_TP_CD," ).append("\n"); 
		query.append("       DSC.CNTR_MF_WGT," ).append("\n"); 
		query.append("       DSC.WGT_UT_CD," ).append("\n"); 
		query.append("       DSC.MEAS_QTY," ).append("\n"); 
		query.append("       DSC.MEAS_UT_CD," ).append("\n"); 
		query.append("       DSC.CMDT_HS_CD," ).append("\n"); 
		query.append("       NVL(SUBSTR(DSC.CMDT_HS_CD, 1, 2), '98') AS COMMODITY_CD," ).append("\n"); 
		query.append("       DSC.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC DSC," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE DSC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND DSC.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'SG'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY DSC.CNTR_NO," ).append("\n"); 
		query.append("          DSC.CNTR_MF_SEQ" ).append("\n"); 

	}
}