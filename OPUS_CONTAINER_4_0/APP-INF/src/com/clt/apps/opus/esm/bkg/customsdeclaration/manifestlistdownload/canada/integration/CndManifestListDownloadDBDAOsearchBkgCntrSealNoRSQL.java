/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.05 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCntrSealNo
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL(){
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
		query.append("FileName : CndManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL").append("\n"); 
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
		query.append("#if (${mf_no} == '') " ).append("\n"); 
		query.append("	SELECT  'CA' AS CNT_CD" ).append("\n"); 
		query.append("	       ,@[bl_no] AS BL_NO" ).append("\n"); 
		query.append("	       ,'CTM' AS CSTMS_DIV_ID" ).append("\n"); 
		query.append("	       ,CNTR_NO" ).append("\n"); 
		query.append("	       ,CNTR_SEAL_SEQ AS SEAL_NO_SEQ" ).append("\n"); 
		query.append("	       ,CNTR_SEAL_NO AS SEAL_NO" ).append("\n"); 
		query.append("	       ,@[upd_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("	  FROM  BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("	 WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	SELECT DISTINCT 'CA' AS CNT_CD" ).append("\n"); 
		query.append("	       ,@[bl_no] AS BL_NO" ).append("\n"); 
		query.append("	       ,'CTM' AS CSTMS_DIV_ID" ).append("\n"); 
		query.append("	       ,S.CNTR_NO" ).append("\n"); 
		query.append("	       ,S.CNTR_SEAL_SEQ AS SEAL_NO_SEQ" ).append("\n"); 
		query.append("	       ,S.CNTR_SEAL_NO AS SEAL_NO" ).append("\n"); 
		query.append("	       ,@[upd_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("	  FROM  BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append("	       ,BKG_CNTR_MF_DESC D" ).append("\n"); 
		query.append("	 WHERE  S.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND  S.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("	   AND  S.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("	   AND  D.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}