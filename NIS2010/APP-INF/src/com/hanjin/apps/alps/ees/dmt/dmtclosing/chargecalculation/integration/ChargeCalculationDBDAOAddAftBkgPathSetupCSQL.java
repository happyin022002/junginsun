/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOAddAftBkgPathSetupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOAddAftBkgPathSetupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOAddAftBkgPathSetupCSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOAddAftBkgPathSetupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ho_pic_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_mgr_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ho_mgr_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brnc_ofc_op_mgr_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brnc_ofc_pic_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brnc_ofc_mgr_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_path_stup_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_pic_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOAddAftBkgPathSetupCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_AFT_BKG_PATH_OFC_STUP(" ).append("\n"); 
		query.append("	 RHQ_CD " ).append("\n"); 
		query.append("	,EFF_DT" ).append("\n"); 
		query.append("	,FM_DC_AMT" ).append("\n"); 
		query.append("    ,AFT_BKG_PATH_STUP_SEQ" ).append("\n"); 
		query.append("	,EXP_DT" ).append("\n"); 
		query.append("    ,TO_DC_AMT" ).append("\n"); 
		query.append("	,OFC_CD" ).append("\n"); 
		query.append("	,BRNC_OFC_PIC_CHK_FLG" ).append("\n"); 
		query.append("	,BRNC_OFC_OP_MGR_APRO_FLG" ).append("\n"); 
		query.append("	,BRNC_OFC_MGR_APRO_FLG" ).append("\n"); 
		query.append("	,RHQ_PIC_CHK_FLG" ).append("\n"); 
		query.append("	,RHQ_MGR_APRO_FLG" ).append("\n"); 
		query.append("	,HO_PIC_CHK_FLG" ).append("\n"); 
		query.append("	,HO_MGR_APRO_FLG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("	 @[rhq_cd]" ).append("\n"); 
		query.append("	,TO_DATE(@[eff_dt], 'YYYYMMDD') + .0" ).append("\n"); 
		query.append("    ,@[fm_dc_amt]" ).append("\n"); 
		query.append("    ,TO_NUMBER(@[aft_bkg_path_stup_seq])" ).append("\n"); 
		query.append("	,TO_DATE(@[exp_dt], 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("    ,@[to_dc_amt]" ).append("\n"); 
		query.append("	,@[ofc_cd]" ).append("\n"); 
		query.append("	,DECODE(@[brnc_ofc_pic_chk_flg],     '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("	,DECODE(@[brnc_ofc_op_mgr_apro_flg], '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("	,DECODE(@[brnc_ofc_mgr_apro_flg],    '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("	,DECODE(@[rhq_pic_chk_flg],          '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("    ,DECODE(@[rhq_mgr_apro_flg],         '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("    ,DECODE(@[ho_pic_chk_flg],           '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("    ,DECODE(@[ho_mgr_apro_flg],          '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}