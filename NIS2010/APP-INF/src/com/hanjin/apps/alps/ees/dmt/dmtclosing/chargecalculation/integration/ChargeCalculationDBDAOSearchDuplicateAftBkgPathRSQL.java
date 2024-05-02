/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchDuplicateAftBkgPathRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.11.03 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchDuplicateAftBkgPathRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchDuplicateAftBkgPathRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchDuplicateAftBkgPathRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ho_mgr_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("@to_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brnc_ofc_mgr_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq_pic_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brnc_ofc_pic_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_path_stup_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchDuplicateAftBkgPathRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END DUPL_FLG" ).append("\n"); 
		query.append("FROM DMT_AFT_BKG_PATH_OFC_STUP" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("    AND EFF_DT = TO_DATE(@[eff_dt], 'YYYYMMDD') + .0" ).append("\n"); 
		query.append("	AND FM_DC_AMT = TO_NUMBER(@[fm_dc_amt])" ).append("\n"); 
		query.append("#if (${exp_dt} != '')" ).append("\n"); 
		query.append("	AND EXP_DT = TO_DATE(@[exp_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_dc_amt} != '')" ).append("\n"); 
		query.append("    AND TO_DC_AMT = TO_NUMBER(@[@to_dc_amt])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("    AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND BRNC_OFC_PIC_CHK_FLG = DECODE(@[brnc_ofc_pic_chk_flg], '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("    AND BRNC_OFC_MGR_APRO_FLG = DECODE(@[brnc_ofc_mgr_apro_flg],  '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("    AND RHQ_PIC_CHK_FLG = DECODE(@[rhq_pic_chk_flg],   '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("    AND RHQ_MGR_APRO_FLG = DECODE(@[rhq_mgr_apro_flg],   '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("    AND HO_PIC_CHK_FLG = DECODE(@[ho_pic_chk_flg],   '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("    AND HO_MGR_APRO_FLG = DECODE(@[ho_mgr_apro_flg],   '0', 'N', '1', 'Y')" ).append("\n"); 
		query.append("#if(${ibflag}=='U')" ).append("\n"); 
		query.append("	AND AFT_BKG_PATH_STUP_SEQ <> @[aft_bkg_path_stup_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}