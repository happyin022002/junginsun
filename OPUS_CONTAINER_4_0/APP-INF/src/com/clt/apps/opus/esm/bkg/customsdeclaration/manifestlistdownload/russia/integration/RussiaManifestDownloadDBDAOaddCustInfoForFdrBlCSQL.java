/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RussiaManifestDownloadDBDAOaddCustInfoForFdrBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.24
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.01.24 김보배
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

public class RussiaManifestDownloadDBDAOaddCustInfoForFdrBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addCustInfoForFdrBl
	  * </pre>
	  */
	public RussiaManifestDownloadDBDAOaddCustInfoForFdrBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration").append("\n"); 
		query.append("FileName : RussiaManifestDownloadDBDAOaddCustInfoForFdrBlCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_RU_CUST A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         SELECT  LPAD(@[bl_no],12)   AS BL_NO" ).append("\n"); 
		query.append("               , @[bkg_cust_tp_cd]   AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("               , NVL(@[cust_nm], '')          AS CUST_NM" ).append("\n"); 
		query.append("               , NVL(@[cust_addr], '')        AS CUST_ADDR" ).append("\n"); 
		query.append("               , @[cre_usr_id]       AS CRE_USR_ID" ).append("\n"); 
		query.append("               , SYSDATE             AS CRE_DT" ).append("\n"); 
		query.append("               , @[upd_usr_id]       AS UPD_USR_ID" ).append("\n"); 
		query.append("               , SYSDATE             AS UPD_DT" ).append("\n"); 
		query.append("         FROM    DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("	AND A.BKG_CUST_TP_CD = B.BKG_CUST_TP_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  UPDATE" ).append("\n"); 
		query.append("  SET    CUST_NM  = B.CUST_NM" ).append("\n"); 
		query.append("	    ,CUST_ADDR = B.CUST_ADDR" ).append("\n"); 
		query.append("        ,UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT = B.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT VALUES(   B.BL_NO" ).append("\n"); 
		query.append("                 , B.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                 , B.CUST_NM" ).append("\n"); 
		query.append("                 , B.CUST_ADDR" ).append("\n"); 
		query.append("                 , B.CRE_USR_ID" ).append("\n"); 
		query.append("                 , B.CRE_DT" ).append("\n"); 
		query.append("                 , B.UPD_USR_ID" ).append("\n"); 
		query.append("                 , B.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}