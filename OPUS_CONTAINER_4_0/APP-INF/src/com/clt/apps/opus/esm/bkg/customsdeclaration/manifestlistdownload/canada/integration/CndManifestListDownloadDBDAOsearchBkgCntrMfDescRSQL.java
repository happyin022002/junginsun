/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchBkgCntrMfDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchBkgCntrMfDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCntrMfDesc
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchBkgCntrMfDescRSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchBkgCntrMfDescRSQL").append("\n"); 
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
		query.append("SELECT  'CA' 				AS CNT_CD" ).append("\n"); 
		query.append("       ,@[bl_no] AS BL_NO" ).append("\n"); 
		query.append("       ,M.CNTR_MF_SEQ			AS CMDT_GDS_SEQ" ).append("\n"); 
		query.append("       ,M.CNTR_NO" ).append("\n"); 
		query.append("       ,M.PCK_QTY" ).append("\n"); 
		query.append("       ,NVL(P.PCK_CD,'PKG') AS AMS_PCK_TP_CD" ).append("\n"); 
		query.append("       ,M.CNTR_MF_WGT			AS GRS_WGT" ).append("\n"); 
		query.append("       ,NVL(M.WGT_UT_CD,'KGS') AS WGT_UT_CD" ).append("\n"); 
		query.append("       ,M.HAMO_TRF_CD			AS HAMO_CMDT_CD" ).append("\n"); 
		query.append("       ,M.CNTR_MF_MK_DESC		AS MK_DESC" ).append("\n"); 
		query.append("       ,M.CNTR_MF_GDS_DESC	AS CGO_DESC" ).append("\n"); 
		query.append("       ,@[upd_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM  BKG_CNTR_MF_DESC M" ).append("\n"); 
		query.append("       ,BKG_BL_DOC D" ).append("\n"); 
		query.append("       ,MDM_PCK_TP P" ).append("\n"); 
		query.append(" WHERE  M.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND  D.PCK_TP_CD = P.PCK_CD(+)" ).append("\n"); 
		query.append("   AND  D.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${mf_no} != '') " ).append("\n"); 
		query.append("   AND  M.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}