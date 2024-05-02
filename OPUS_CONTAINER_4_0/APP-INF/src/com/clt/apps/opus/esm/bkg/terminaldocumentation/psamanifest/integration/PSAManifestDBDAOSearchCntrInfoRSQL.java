/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PSAManifestDBDAOSearchCntrInfoRSQL.java
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

public class PSAManifestDBDAOSearchCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOSearchCntrInfoRSQL(){
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
		query.append("FileName : PSAManifestDBDAOSearchCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT BC.CNTR_NO," ).append("\n"); 
		query.append("       BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       BC.PCK_QTY," ).append("\n"); 
		query.append("       BC.CNTR_WGT," ).append("\n"); 
		query.append("       BC.WGT_UT_CD," ).append("\n"); 
		query.append("       BC.MEAS_QTY," ).append("\n"); 
		query.append("       BC.MEAS_UT_CD," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN BK.BKG_CGO_TP_CD = 'P' THEN 'E'" ).append("\n"); 
		query.append("          WHEN BC.BB_CGO_FLG = 'Y' THEN 'B'" ).append("\n"); 
		query.append("          WHEN BC.CNTR_PRT_FLG = 'Y' THEN 'L'" ).append("\n"); 
		query.append("          ELSE 'F'" ).append("\n"); 
		query.append("       END CGO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("       BKG_CONTAINER BC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BC.BKG_NO = BK.BKG_NO" ).append("\n"); 

	}
}