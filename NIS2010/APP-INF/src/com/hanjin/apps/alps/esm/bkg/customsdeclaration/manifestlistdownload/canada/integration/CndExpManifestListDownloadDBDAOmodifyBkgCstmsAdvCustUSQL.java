/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvCustUSQL.java
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

public class CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvCustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_zip_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOmodifyBkgCstmsAdvCustUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_AMER_CUST" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("        ON (" ).append("\n"); 
		query.append("           BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND CNT_CD = 'CA'" ).append("\n"); 
		query.append("       AND BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE" ).append("\n"); 
		query.append("	   SET UPD_DT = SYSDATE" ).append("\n"); 
		query.append("          ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("          ,CUST_CNT_CD        = @[cust_cnt_cd]" ).append("\n"); 
		query.append("          ,CUST_SEQ           = @[cust_seq]" ).append("\n"); 
		query.append("          ,CUST_NM            = @[cust_nm]" ).append("\n"); 
		query.append("          ,CUST_ADDR          = @[cust_addr]" ).append("\n"); 
		query.append("          ,CUST_CTY_NM        = @[cust_cty_nm]" ).append("\n"); 
		query.append("          ,CUST_STE_CD        = @[cust_ste_cd]" ).append("\n"); 
		query.append("          ,CSTMS_DECL_CNT_CD  = @[cstms_decl_cnt_cd]" ).append("\n"); 
		query.append("          ,CUST_ZIP_ID        = @[cust_zip_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (" ).append("\n"); 
		query.append("	       CNT_CD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append("	      ,BL_NO" ).append("\n"); 
		query.append("	      ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("	      ,CUST_CNT_CD" ).append("\n"); 
		query.append("	      ,CUST_SEQ" ).append("\n"); 
		query.append("	      ,CUST_NM" ).append("\n"); 
		query.append("	      ,CUST_ADDR" ).append("\n"); 
		query.append("	      ,CUST_CTY_NM" ).append("\n"); 
		query.append("	      ,CUST_STE_CD" ).append("\n"); 
		query.append("	      ,CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("	      ,CUST_ZIP_ID" ).append("\n"); 
		query.append("	      ,CRE_USR_ID" ).append("\n"); 
		query.append("	      ,CRE_DT" ).append("\n"); 
		query.append("	      ,UPD_USR_ID" ).append("\n"); 
		query.append("	      ,UPD_DT" ).append("\n"); 
		query.append("	) VALUES(" ).append("\n"); 
		query.append("	       'CA'" ).append("\n"); 
		query.append(",'O'" ).append("\n"); 
		query.append("	      ,@[bl_no]" ).append("\n"); 
		query.append("	      ,@[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("	      ,@[cust_cnt_cd]" ).append("\n"); 
		query.append("	      ,@[cust_seq]" ).append("\n"); 
		query.append("	      ,@[cust_nm]" ).append("\n"); 
		query.append("	      ,@[cust_addr]" ).append("\n"); 
		query.append("	      ,@[cust_cty_nm]" ).append("\n"); 
		query.append("	      ,@[cust_ste_cd]" ).append("\n"); 
		query.append("	      ,@[cstms_decl_cnt_cd]" ).append("\n"); 
		query.append("	      ,@[cust_zip_id]" ).append("\n"); 
		query.append("	      ,@[upd_usr_id]" ).append("\n"); 
		query.append("	      ,SYSDATE" ).append("\n"); 
		query.append("	      ,@[upd_usr_id]" ).append("\n"); 
		query.append("	      ,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}