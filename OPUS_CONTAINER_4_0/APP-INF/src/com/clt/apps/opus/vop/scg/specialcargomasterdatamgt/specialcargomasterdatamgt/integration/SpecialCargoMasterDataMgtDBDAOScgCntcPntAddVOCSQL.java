/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgCntcPntAddVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgCntcPntAddVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner’s Contact Point for TDR/RDR, BAPLE (Creation) 입력   
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgCntcPntAddVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_eml_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_opr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgCntcPntAddVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_CNTC_PNT_ADD (" ).append("\n"); 
		query.append("	CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(",	CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(",	CRR_CD" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	CNTC_CATE_CD" ).append("\n"); 
		query.append(",	CNTC_CATE_SEQ" ).append("\n"); 
		query.append(",   EFF_FM_DT" ).append("\n"); 
		query.append(",   EFF_TO_DT" ).append("\n"); 
		query.append(",   PORT_CD" ).append("\n"); 
		query.append(",   SKD_DIR_CD" ).append("\n"); 
		query.append(",	VSL_OPR_NM" ).append("\n"); 
		query.append(",	CNTC_PSON_EML_CTNT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cntc_pson_phn_no]" ).append("\n"); 
		query.append(",	@[cntc_pson_fax_no]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[rgn_shp_opr_cd]" ).append("\n"); 
		query.append(",	@[crr_cd]" ).append("\n"); 
		query.append(",	@[slan_cd]" ).append("\n"); 
		query.append(",	@[cntc_cate_cd]" ).append("\n"); 
		query.append(",	(SELECT NVL(MAX(CNTC_CATE_SEQ),0) + 1 " ).append("\n"); 
		query.append("       FROM SCG_CNTC_PNT_ADD" ).append("\n"); 
		query.append("      WHERE RGN_SHP_OPR_CD    = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("        AND CNTC_CATE_CD        = @[cntc_cate_cd])" ).append("\n"); 
		query.append(",	TO_DATE(@[eff_fm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",	TO_DATE(@[eff_to_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[port_cd]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[vsl_opr_nm]" ).append("\n"); 
		query.append(",	@[cntc_pson_eml_ctnt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}