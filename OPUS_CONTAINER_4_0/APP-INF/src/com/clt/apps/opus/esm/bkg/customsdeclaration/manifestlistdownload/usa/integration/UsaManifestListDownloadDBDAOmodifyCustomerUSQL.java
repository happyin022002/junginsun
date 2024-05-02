/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyCustomerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.02 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyCustomerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCustomer
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyCustomerUSQL(){
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
		params.put("cust_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eur_cstms_st_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyCustomerUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_ADV_CUST CT" ).append("\n"); 
		query.append("USING ( " ).append("\n"); 
		query.append("    SELECT @[cnt_cd] AS CNT_CD, @[bl_no] AS BL_NO, @[bkg_cust_tp_cd] AS BKG_CUST_TP_CD FROM DUAL ) TM" ).append("\n"); 
		query.append("ON ( CT.CNT_CD = TM.CNT_CD AND CT.BL_NO = TM.BL_NO AND CT.BKG_CUST_TP_CD = TM.BKG_CUST_TP_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE   " ).append("\n"); 
		query.append("        SET	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("        ,	CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("        ,	CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("        ,	CUST_NM = @[cust_nm]" ).append("\n"); 
		query.append("        ,	CUST_ADDR = @[cust_addr]" ).append("\n"); 
		query.append("        ,	PHN_NO = @[phn_no]" ).append("\n"); 
		query.append("        ,	FAX_NO = @[fax_no]" ).append("\n"); 
		query.append("        ,	CUST_CTY_NM       = @[cust_cty_nm]" ).append("\n"); 
		query.append("        ,	CUST_STE_CD       = @[cust_ste_cd]" ).append("\n"); 
		query.append("        ,	CSTMS_DECL_CNT_CD = @[cstms_decl_cnt_cd]" ).append("\n"); 
		query.append("        ,	CUST_ZIP_ID       = @[cust_zip_id]" ).append("\n"); 
		query.append("        ,	EUR_CSTMS_ST_NM   = @[eur_cstms_st_nm]" ).append("\n"); 
		query.append("        WHERE	CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("        AND	    BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        AND	    BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT ( CNT_CD" ).append("\n"); 
		query.append("                ,BL_NO" ).append("\n"); 
		query.append("                ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                ,CUST_CNT_CD" ).append("\n"); 
		query.append("                ,CUST_SEQ" ).append("\n"); 
		query.append("                ,CUST_NM" ).append("\n"); 
		query.append("                ,CUST_ADDR" ).append("\n"); 
		query.append("                ,PHN_NO" ).append("\n"); 
		query.append("                ,FAX_NO" ).append("\n"); 
		query.append("                ,CUST_CTY_NM" ).append("\n"); 
		query.append("                ,CUST_STE_CD" ).append("\n"); 
		query.append("                ,CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append("                ,CUST_ZIP_ID" ).append("\n"); 
		query.append("                ,EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append("                ,CRE_USR_ID" ).append("\n"); 
		query.append("                ,CRE_DT" ).append("\n"); 
		query.append("                ,UPD_USR_ID" ).append("\n"); 
		query.append("                ,UPD_DT )" ).append("\n"); 
		query.append("        VALUES ( @[cnt_cd]" ).append("\n"); 
		query.append("                ,@[bl_no]" ).append("\n"); 
		query.append("                ,@[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("                ,@[cust_cnt_cd]" ).append("\n"); 
		query.append("                ,@[cust_seq]" ).append("\n"); 
		query.append("                ,@[cust_nm]" ).append("\n"); 
		query.append("                ,@[cust_addr]" ).append("\n"); 
		query.append("                ,@[phn_no]" ).append("\n"); 
		query.append("                ,@[fax_no]" ).append("\n"); 
		query.append("                ,@[cust_cty_nm]" ).append("\n"); 
		query.append("                ,@[cust_ste_cd]" ).append("\n"); 
		query.append("                ,@[cstms_decl_cnt_cd]" ).append("\n"); 
		query.append("                ,@[cust_zip_id]" ).append("\n"); 
		query.append("                ,@[eur_cstms_st_nm]" ).append("\n"); 
		query.append("                ,@[cre_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE" ).append("\n"); 
		query.append("                ,@[upd_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE )" ).append("\n"); 

	}
}