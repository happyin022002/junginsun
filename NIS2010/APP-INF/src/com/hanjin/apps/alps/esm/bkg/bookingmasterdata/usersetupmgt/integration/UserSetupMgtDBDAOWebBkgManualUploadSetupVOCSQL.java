/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UserSetupMgtDBDAOWebBkgManualUploadSetupVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOWebBkgManualUploadSetupVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WebBkgManualUploadSetupVO
	  * </pre>
	  */
	public UserSetupMgtDBDAOWebBkgManualUploadSetupVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOWebBkgManualUploadSetupVOCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_SYS_UPLD_BLCK_STUP " ).append("\n"); 
		query.append("            (BKG_OFC_CD" ).append("\n"); 
		query.append("            , BLCK_SEQ" ).append("\n"); 
		query.append("            , VSL_SLAN_CD" ).append("\n"); 
		query.append("            , VSL_CD" ).append("\n"); 
		query.append("            , SKD_VOY_NO" ).append("\n"); 
		query.append("            , DIR_CD" ).append("\n"); 
		query.append("            , CUST_CNT_CD" ).append("\n"); 
		query.append("            , CUST_SEQ" ).append("\n"); 
		query.append("            , POL_CNT_CD" ).append("\n"); 
		query.append("            , POL_CD" ).append("\n"); 
		query.append("            , POD_CNT_CD" ).append("\n"); 
		query.append("            , POD_CD" ).append("\n"); 
		query.append("            , DELT_FLG" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT" ).append("\n"); 
		query.append("			, XTER_RMK" ).append("\n"); 
		query.append("			, LODG_DIR_CD)" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("        @[bkg_ofc_cd]" ).append("\n"); 
		query.append("        , (SELECT NVL(MAX(BLCK_SEQ), 0)+1 FROM BKG_SYS_UPLD_BLCK_STUP WHERE BKG_OFC_CD = @[bkg_ofc_cd])" ).append("\n"); 
		query.append("        , @[vsl_slan_cd]" ).append("\n"); 
		query.append("        , substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("        , substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("        , substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("        , SUBSTR(@[cust_cnt_cd],1,2)" ).append("\n"); 
		query.append("        , SUBSTR(@[cust_cnt_cd],3)" ).append("\n"); 
		query.append("        , @[pol_cnt_cd]" ).append("\n"); 
		query.append("        , @[pol_cd]" ).append("\n"); 
		query.append("        , @[pod_cnt_cd]" ).append("\n"); 
		query.append("        , @[pod_cd]" ).append("\n"); 
		query.append("        , 'N'" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("		, @[xter_rmk]" ).append("\n"); 
		query.append("		, @[lodg_dir_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}