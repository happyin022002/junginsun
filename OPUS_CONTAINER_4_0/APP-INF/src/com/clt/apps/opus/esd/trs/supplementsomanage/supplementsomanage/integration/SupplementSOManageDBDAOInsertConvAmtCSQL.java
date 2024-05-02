/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SupplementSOManageDBDAOInsertConvAmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.17
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.09.17 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SupplementSOManageDBDAOInsertConvAmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CONVERSION AMOUNT 정보 인서트
	  * </pre>
	  */
	public SupplementSOManageDBDAOInsertConvAmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("local_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nego_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wgt_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration").append("\n"); 
		query.append("FileName : SupplementSOManageDBDAOInsertConvAmtCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO TRS_TRSP_EXPN_CONV_AMT " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("	TRSP_SO_OFC_CTY_CD,  " ).append("\n"); 
		query.append("    TRSP_SO_SEQ, " ).append("\n"); 
		query.append("    CURR_CD, " ).append("\n"); 
		query.append("    BZC_AMT, " ).append("\n"); 
		query.append("    NEGO_AMT," ).append("\n"); 
		query.append("    FUEL_SCG_AMT, " ).append("\n"); 
		query.append("    OVR_WGT_SCG_AMT, " ).append("\n"); 
		query.append("    ETC_ADD_AMT, " ).append("\n"); 
		query.append("    CRE_OFC_CD, " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT, " ).append("\n"); 
		query.append("	LOCL_CRE_DT, " ).append("\n"); 
		query.append("	LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    @[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append("    @[trsp_so_seq]," ).append("\n"); 
		query.append("    @[curr_cd]," ).append("\n"); 
		query.append("	TRS_COMMON_PKG.GET_CONVERSION_TO_CURR_AMT_FNC(@[local_curr_cd],@[target_curr_cd],TO_CHAR(SYSDATE,'YYYYMM'), @[bzc_amt]), 	" ).append("\n"); 
		query.append("	TRS_COMMON_PKG.GET_CONVERSION_TO_CURR_AMT_FNC(@[local_curr_cd],@[target_curr_cd],TO_CHAR(SYSDATE,'YYYYMM'), @[nego_amt]), " ).append("\n"); 
		query.append("	TRS_COMMON_PKG.GET_CONVERSION_TO_CURR_AMT_FNC(@[local_curr_cd],@[target_curr_cd],TO_CHAR(SYSDATE,'YYYYMM'), @[fuel_scg_amt]), 		" ).append("\n"); 
		query.append("	TRS_COMMON_PKG.GET_CONVERSION_TO_CURR_AMT_FNC(@[local_curr_cd],@[target_curr_cd],TO_CHAR(SYSDATE,'YYYYMM'), @[ovr_wgt_scg_amt]), 	" ).append("\n"); 
		query.append("	TRS_COMMON_PKG.GET_CONVERSION_TO_CURR_AMT_FNC(@[local_curr_cd],@[target_curr_cd],TO_CHAR(SYSDATE,'YYYYMM'), @[etc_add_amt]), 	" ).append("\n"); 
		query.append("    @[cre_ofc_cd]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE, " ).append("\n"); 
		query.append("	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])," ).append("\n"); 
		query.append("	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}