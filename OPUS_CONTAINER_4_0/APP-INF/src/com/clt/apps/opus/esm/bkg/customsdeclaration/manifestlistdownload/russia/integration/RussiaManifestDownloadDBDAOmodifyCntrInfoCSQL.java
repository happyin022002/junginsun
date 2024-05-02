/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RussiaManifestDownloadDBDAOmodifyCntrInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.09
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.09 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaManifestDownloadDBDAOmodifyCntrInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCntrInfo
	  * </pre>
	  */
	public RussiaManifestDownloadDBDAOmodifyCntrInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tare_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration").append("\n"); 
		query.append("FileName : RussiaManifestDownloadDBDAOmodifyCntrInfoCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_RU_CNTR RC" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         SELECT  LPAD(@[bkg_no],12)     AS BKG_NO" ).append("\n"); 
		query.append("               , @[cntr_no]             AS CNTR_NO" ).append("\n"); 
		query.append("               , NVL(@[wgt1], 0)        AS WGT1" ).append("\n"); 
		query.append("               , NVL(@[tare_wgt], 0)    AS TARE_WGT" ).append("\n"); 
		query.append("               , NVL(@[total_wgt], 0)   AS TOTAL_WGT" ).append("\n"); 
		query.append("               , @[cre_usr_id]          AS CRE_USR_ID" ).append("\n"); 
		query.append("               , SYSDATE                AS CRE_DT" ).append("\n"); 
		query.append("               , @[upd_usr_id]          AS UPD_USR_ID" ).append("\n"); 
		query.append("               , SYSDATE                AS UPD_DT" ).append("\n"); 
		query.append("         FROM    DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (RC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	AND RC.CNTR_NO = B.CNTR_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  UPDATE" ).append("\n"); 
		query.append("  SET   CGO_WGT     = B.WGT1" ).append("\n"); 
		query.append("      , TARE_WGT    = B.TARE_WGT" ).append("\n"); 
		query.append("      , CNTR_WGT    = B.TOTAL_WGT" ).append("\n"); 
		query.append("      , UPD_USR_ID  = B.UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT      = B.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT ( BKG_NO" ).append("\n"); 
		query.append("         , CNTR_NO" ).append("\n"); 
		query.append("         , CGO_WGT" ).append("\n"); 
		query.append("         , TARE_WGT" ).append("\n"); 
		query.append("         , CNTR_WGT" ).append("\n"); 
		query.append("         , CRE_USR_ID" ).append("\n"); 
		query.append("         , CRE_DT" ).append("\n"); 
		query.append("         , UPD_USR_ID" ).append("\n"); 
		query.append("         , UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  VALUES ( B.BKG_NO" ).append("\n"); 
		query.append("         , B.CNTR_NO" ).append("\n"); 
		query.append("         , B.WGT1" ).append("\n"); 
		query.append("         , B.TARE_WGT" ).append("\n"); 
		query.append("         , B.TOTAL_WGT" ).append("\n"); 
		query.append("         , B.CRE_USR_ID" ).append("\n"); 
		query.append("         , B.CRE_DT" ).append("\n"); 
		query.append("         , B.UPD_USR_ID" ).append("\n"); 
		query.append("         , B.UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}