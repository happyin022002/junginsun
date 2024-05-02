/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
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

public class BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrFlgByRfCgo
	  * </pre>
	  */
	public BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL(){
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
		query.append("FileName : BLDocumentationCMDBDAOModifyCntrFlgByRfCgoUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("MERGE INTO BKG_CNTR_HIS A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT B.BKG_NO, B.CNTR_NO," ).append("\n"); 
		query.append("           B.RC_FLG, B.RD_CGO_FLG," ).append("\n"); 
		query.append("           CASE WHEN R.CNTR_NO IS NOT NULL THEN 'Y' ELSE 'N' END T_RC_FLG," ).append("\n"); 
		query.append("           CASE WHEN R.CNTR_NO IS NOT NULL THEN 'N' ELSE 'Y' END T_RD_CGO_FLG" ).append("\n"); 
		query.append("    FROM BKG_CNTR_HIS B, BKG_RF_CGO_HIS R" ).append("\n"); 
		query.append("    WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("    AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("    AND B.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("  ON (A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	    AND A.CNTR_NO = B.CNTR_NO " ).append("\n"); 
		query.append("      AND A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.RC_FLG = B.T_RC_FLG," ).append("\n"); 
		query.append("           A.RD_CGO_FLG = B.T_RD_CGO_FLG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MERGE INTO BKG_CONTAINER A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT B.BKG_NO, B.CNTR_NO," ).append("\n"); 
		query.append("           B.RC_FLG, B.RD_CGO_FLG," ).append("\n"); 
		query.append("           CASE WHEN R.CNTR_NO IS NOT NULL THEN 'Y' ELSE 'N' END T_RC_FLG," ).append("\n"); 
		query.append("           CASE WHEN R.CNTR_NO IS NOT NULL THEN 'N' ELSE 'Y' END T_RD_CGO_FLG" ).append("\n"); 
		query.append("    FROM BKG_CONTAINER B, BKG_RF_CGO R" ).append("\n"); 
		query.append("    WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("    AND B.CNTR_NO = R.CNTR_NO" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("  ON (A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	    AND A.CNTR_NO = B.CNTR_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET A.RC_FLG = B.T_RC_FLG," ).append("\n"); 
		query.append("           A.RD_CGO_FLG = B.T_RD_CGO_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}