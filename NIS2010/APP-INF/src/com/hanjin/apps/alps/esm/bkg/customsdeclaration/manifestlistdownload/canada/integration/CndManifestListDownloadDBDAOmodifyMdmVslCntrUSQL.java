/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOmodifyMdmVslCntrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.13 
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

public class CndManifestListDownloadDBDAOmodifyMdmVslCntrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyMdmVslCntr
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOmodifyMdmVslCntrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lod_line_certi_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_derat_certi_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_sft_cstru_certi_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_sft_eq_certi_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_sft_rdo_certi_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOmodifyMdmVslCntrUSQL").append("\n"); 
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
		query.append("UPDATE  MDM_VSL_CNTR SET " ).append("\n"); 
		query.append("    UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	VSL_SFT_CSTRU_CERTI_EXP_DT = NVL( TO_DATE(REPLACE(@[vsl_sft_cstru_certi_exp_dt],'-',''),'YYYYMMDD'), VSL_SFT_CSTRU_CERTI_EXP_DT)" ).append("\n"); 
		query.append(",	VSL_SFT_RDO_CERTI_EXP_DT = NVL( TO_DATE(REPLACE(@[vsl_sft_rdo_certi_exp_dt],'-',''),'YYYYMMDD'),     VSL_SFT_RDO_CERTI_EXP_DT )" ).append("\n"); 
		query.append(",	VSL_SFT_EQ_CERTI_EXP_DT = NVL( TO_DATE(REPLACE(@[vsl_sft_eq_certi_exp_dt],'-',''),'YYYYMMDD'),       VSL_SFT_EQ_CERTI_EXP_DT)" ).append("\n"); 
		query.append(",	VSL_LOD_LINE_CERTI_EXP_DT = NVL( TO_DATE(REPLACE(@[vsl_lod_line_certi_exp_dt],'-',''),'YYYYMMDD'),   VSL_LOD_LINE_CERTI_EXP_DT)" ).append("\n"); 
		query.append(",	VSL_DERAT_CERTI_EXP_DT = NVL( TO_DATE(REPLACE(@[vsl_derat_certi_exp_dt],'-',''),'YYYYMMDD'),         VSL_DERAT_CERTI_EXP_DT)" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd] " ).append("\n"); 

	}
}