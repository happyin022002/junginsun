/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchAwkCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchAwkCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAwkCgo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchAwkCgoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchAwkCgoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    LTRIM(DECODE(OVR_VOID_SLT_QTY, 0 , DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'A', 'INGU', 'F', 'INGU', 'S', 'INGU', 'O', 'INGU', ' '), " ).append("\n"); 
		query.append("    SUBSTR(RTRIM(REPLACE(FF, 'F:0')||REPLACE(BB, 'B:0')||REPLACE(HH, 'H:0')||REPLACE(LL, 'L:0')||REPLACE(RR, 'R:0')||REPLACE(PS, 'PS:0')||REPLACE(EH, 'EH:0')), 1, 50))) AWK_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT 'F:'||TO_CHAR(ROUND(OVR_FWRD_LEN))||' ' FF," ).append("\n"); 
		query.append("      'B:'||TO_CHAR(ROUND(OVR_BKWD_LEN))||' ' BB," ).append("\n"); 
		query.append("      'H:'||TO_CHAR(ROUND(OVR_HGT))||' ' HH," ).append("\n"); 
		query.append("      'L:'||TO_CHAR(ROUND(OVR_LF_LEN))||' ' LL," ).append("\n"); 
		query.append("      'R:'||TO_CHAR(ROUND(OVR_RT_LEN))||' ' RR," ).append("\n"); 
		query.append("      'PS:'||TO_CHAR(DECODE(NVL(TRIM(CRN_PST_STS_CD), 0), 'F', 0, 'E', 0, NVL(TRIM(CRN_PST_STS_CD), 0)))||' ' PS," ).append("\n"); 
		query.append("      DECODE(NVL(XTD_OVR_QTY, 0), 0, '', DECODE(CNTR_TPSZ_CD, 'A4', 'EH:'||XTD_OVR_QTY||'  ', '')) EH," ).append("\n"); 
		query.append("      CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("    FROM BKG_AWK_CGO" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND CNTR_NO = @[cntr_no] )" ).append("\n"); 

	}
}