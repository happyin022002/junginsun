/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOaddMSNInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOaddMSNInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddMSNInfo
	  * </pre>
	  */
	public KorManifestListDBDAOaddMSNInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("local_ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icd_cstm_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icd_cstm_wh",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mrn_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icd_cstm_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voyage_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_crr_in_loc_wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOaddMSNInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_KR_MF_SEQ_NO " ).append("\n"); 
		query.append("            ( BKG_NO" ).append("\n"); 
		query.append("            , MF_REF_NO" ).append("\n"); 
		query.append("			, MRN_CHK_NO" ).append("\n"); 
		query.append("            , MRN_BL_TS_CD" ).append("\n"); 
		query.append("            , KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("            , CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("            , CSTMS_DCHG_LOC_WH_CD" ).append("\n"); 
		query.append("            , CSTMS_CRR_IN_LOC_WH_CD" ).append("\n"); 
		query.append("            , CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append("            , CSTMS_CLR_WH_CD" ).append("\n"); 
		query.append("            , VSL_CD" ).append("\n"); 
		query.append("            , SKD_VOY_NO" ).append("\n"); 
		query.append("            , SKD_DIR_CD" ).append("\n"); 
		query.append("            , UPD_DT" ).append("\n"); 
		query.append("		    , CRE_USR_ID" ).append("\n"); 
		query.append("			, UPD_USR_ID )" ).append("\n"); 
		query.append("    VALUES (  @[bkg_no]" ).append("\n"); 
		query.append("            , @[mrn_nbr]" ).append("\n"); 
		query.append("            , @[mrn_chk]" ).append("\n"); 
		query.append("            , @[local_ts]" ).append("\n"); 
		query.append("            , @[bl_tp]" ).append("\n"); 
		query.append("            , @[icd_cstm_tp]" ).append("\n"); 
		query.append("            , @[disc_cd]" ).append("\n"); 
		query.append("            , @[cstms_crr_in_loc_wh_cd]" ).append("\n"); 
		query.append("            , @[icd_cstm_loc]" ).append("\n"); 
		query.append("            , @[icd_cstm_wh]" ).append("\n"); 
		query.append("            , @[vsl_cd]" ).append("\n"); 
		query.append("            , @[skd_voyage_no]" ).append("\n"); 
		query.append("            , @[skd_dir_cd]" ).append("\n"); 
		query.append("            , sysdate" ).append("\n"); 
		query.append("            , @[userid]" ).append("\n"); 
		query.append("			, @[userid] )" ).append("\n"); 

	}
}