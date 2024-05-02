/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DwellNotificationDBDAOAddDwllNtfcExptCntCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.22
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.11.22 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOAddDwllNtfcExptCntCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 데이터 저장,update
	  * </pre>
	  */
	public DwellNotificationDBDAOAddDwllNtfcExptCntCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dest_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vsl_dlay_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tml_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_enr_dwll_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dwll_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_set_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwll_expt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOAddDwllNtfcExptCntCSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_DWLL_CNTR_EXPT T" ).append("\n"); 
		query.append("USING ( SELECT  @[cntr_no]            CNTR_NO" ).append("\n"); 
		query.append(",@[cnmv_yr]            CNMV_YR" ).append("\n"); 
		query.append(",@[cnmv_id_no]         CNMV_ID_NO" ).append("\n"); 
		query.append(",@[cnmv_cyc_no]        CNMV_CYC_NO" ).append("\n"); 
		query.append(",@[mst_bkg_no]         MST_BKG_NO" ).append("\n"); 
		query.append(",DECODE(@[cntr_tml_dwll_flg],'1','Y','N')  CNTR_TML_DWLL_FLG" ).append("\n"); 
		query.append(",DECODE(@[cntr_enr_dwll_flg],'1','Y','N')  CNTR_ENR_DWLL_FLG" ).append("\n"); 
		query.append(",DECODE(@[cntr_dest_dwll_flg],'1','Y','N') CNTR_DEST_DWLL_FLG" ).append("\n"); 
		query.append(",DECODE(@[cntr_vsl_dlay_flg],'1','Y','N')  CNTR_VSL_DLAY_FLG" ).append("\n"); 
		query.append(",@[expt_set_ofc_cd]    EXPT_SET_OFC_CD" ).append("\n"); 
		query.append(",@[dwll_expt_rmk]      DWLL_EXPT_RMK" ).append("\n"); 
		query.append(",DECODE(@[cntr_dwll_expt_flg],'1','Y','N') CNTR_DWLL_EXPT_FLG" ).append("\n"); 
		query.append("FROM DUAL )S" ).append("\n"); 
		query.append("ON (  T.CNTR_NO     =  S.CNTR_NO" ).append("\n"); 
		query.append("AND T.CNMV_YR     =  S.CNMV_YR" ).append("\n"); 
		query.append("AND T.CNMV_ID_NO  =  S.CNMV_ID_NO" ).append("\n"); 
		query.append("AND T.CNMV_CYC_NO =  S.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND T.MST_BKG_NO  =  S.MST_BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET T.CNTR_TML_DWLL_FLG  = S.CNTR_TML_DWLL_FLG" ).append("\n"); 
		query.append(", T.CNTR_ENR_DWLL_FLG  = S.CNTR_ENR_DWLL_FLG" ).append("\n"); 
		query.append(", T.CNTR_DEST_DWLL_FLG = S.CNTR_DEST_DWLL_FLG" ).append("\n"); 
		query.append(", T.CNTR_VSL_DLAY_FLG  = S.CNTR_VSL_DLAY_FLG" ).append("\n"); 
		query.append(", T.EXPT_SET_OFC_CD    = S.EXPT_SET_OFC_CD" ).append("\n"); 
		query.append(", T.EXPT_SET_USR_ID    = @[user_id]" ).append("\n"); 
		query.append(", T.EXPT_SET_DT        = SYSDATE" ).append("\n"); 
		query.append(", T.DWLL_EXPT_RMK      = @[dwll_expt_rmk]" ).append("\n"); 
		query.append(", T.CRE_USR_ID         = @[user_id]" ).append("\n"); 
		query.append(", T.CRE_DT             = SYSDATE" ).append("\n"); 
		query.append(", T.UPD_USR_ID         = @[user_id]" ).append("\n"); 
		query.append(", T.UPD_DT             = SYSDATE" ).append("\n"); 
		query.append(", T.CNTR_DWLL_EXPT_FLG = S.CNTR_DWLL_EXPT_FLG" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (T.CNTR_NO" ).append("\n"); 
		query.append(",T.CNMV_YR" ).append("\n"); 
		query.append(",T.CNMV_ID_NO" ).append("\n"); 
		query.append(",T.CNMV_CYC_NO" ).append("\n"); 
		query.append(",T.MST_BKG_NO" ).append("\n"); 
		query.append(",T.CNTR_TML_DWLL_FLG" ).append("\n"); 
		query.append(",T.CNTR_ENR_DWLL_FLG" ).append("\n"); 
		query.append(",T.CNTR_DEST_DWLL_FLG" ).append("\n"); 
		query.append(",T.CNTR_VSL_DLAY_FLG" ).append("\n"); 
		query.append(",T.EXPT_SET_OFC_CD" ).append("\n"); 
		query.append(",T.EXPT_SET_USR_ID" ).append("\n"); 
		query.append(",T.EXPT_SET_DT" ).append("\n"); 
		query.append(",T.DWLL_EXPT_RMK" ).append("\n"); 
		query.append(",T.DELT_FLG" ).append("\n"); 
		query.append(",T.CRE_USR_ID" ).append("\n"); 
		query.append(",T.CRE_DT" ).append("\n"); 
		query.append(",T.UPD_USR_ID" ).append("\n"); 
		query.append(",T.UPD_DT" ).append("\n"); 
		query.append(",T.CNTR_DWLL_EXPT_FLG)" ).append("\n"); 
		query.append("VALUES (S.CNTR_NO" ).append("\n"); 
		query.append(",S.CNMV_YR" ).append("\n"); 
		query.append(",S.CNMV_ID_NO" ).append("\n"); 
		query.append(",S.CNMV_CYC_NO" ).append("\n"); 
		query.append(",S.MST_BKG_NO" ).append("\n"); 
		query.append(",S.CNTR_TML_DWLL_FLG" ).append("\n"); 
		query.append(",S.CNTR_ENR_DWLL_FLG" ).append("\n"); 
		query.append(",S.CNTR_DEST_DWLL_FLG" ).append("\n"); 
		query.append(",S.CNTR_VSL_DLAY_FLG" ).append("\n"); 
		query.append(",S.EXPT_SET_OFC_CD" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",S.DWLL_EXPT_RMK" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",S.CNTR_DWLL_EXPT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}