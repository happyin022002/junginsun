/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOsearchBkgHblCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpManifestListDownloadDBDAOsearchBkgHblCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOsearchBkgHblCustRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOsearchBkgHblCustRSQL").append("\n"); 
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
		query.append("SELECT  'CA' AS CNT_CD" ).append("\n"); 
		query.append("       ,B.CNTR_MF_NO      AS BL_NO" ).append("\n"); 
		query.append("       ,BKG_CUST_TP_CD    AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("       ,CUST_CNT_CD       AS CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("       ,CUST_SEQ          AS CUST_SEQ" ).append("\n"); 
		query.append("       ,CUST_NM           AS CUST_NM" ).append("\n"); 
		query.append("       ,CUST_ADDR         AS CUST_ADDR" ).append("\n"); 
		query.append("       ,CTY_NM            AS CUST_CTY_NM" ).append("\n"); 
		query.append("       ,STE_CD            AS CUST_STE_CD" ).append("\n"); 
		query.append("       ,''                AS CUST_CNT_CD " ).append("\n"); 
		query.append("       ,CUST_ZIP_ID       AS CUST_ZIP_ID" ).append("\n"); 
		query.append("       ,''                AS FAX_NO" ).append("\n"); 
		query.append("       ,''                AS PHN_NO" ).append("\n"); 
		query.append("       ,''                AS CUST_FAX_SND_DT" ).append("\n"); 
		query.append("       ,''                AS EML_SND_DT" ).append("\n"); 
		query.append("       ,''                AS DIFF_RMK" ).append("\n"); 
		query.append("       ,DECODE(C.BKG_CUST_TP_CD, 'C', NVL(A.CUST_TO_ORD_FLG,'N'), 'N') AS TO_ORD_FLG" ).append("\n"); 
		query.append("       ,@[upd_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM  BKG_BOOKING A" ).append("\n"); 
		query.append("       ,BKG_HBL B" ).append("\n"); 
		query.append("       ,BKG_HBL_CUST C" ).append("\n"); 
		query.append(" WHERE  B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND  B.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND  B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND  B.HBL_SEQ = C.HBL_SEQ " ).append("\n"); 

	}
}