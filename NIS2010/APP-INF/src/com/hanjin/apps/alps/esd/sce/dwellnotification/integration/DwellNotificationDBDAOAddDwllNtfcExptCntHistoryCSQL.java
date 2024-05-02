/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DwellNotificationDBDAOAddDwllNtfcExptCntHistoryCSQL.java
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

public class DwellNotificationDBDAOAddDwllNtfcExptCntHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_DWLL_CNTR_EXPT_HIS 에 데이터를 남긴다.
	  * </pre>
	  */
	public DwellNotificationDBDAOAddDwllNtfcExptCntHistoryCSQL(){
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
		query.append("FileName : DwellNotificationDBDAOAddDwllNtfcExptCntHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_DWLL_CNTR_EXPT_HIS (CNTR_NO" ).append("\n"); 
		query.append(",DWLL_NTFC_CNTR_EXPT_SEQ" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",CNMV_CYC_NO" ).append("\n"); 
		query.append(",MST_BKG_NO" ).append("\n"); 
		query.append(",CNTR_TML_DWLL_FLG" ).append("\n"); 
		query.append(",CNTR_ENR_DWLL_FLG" ).append("\n"); 
		query.append(",CNTR_DEST_DWLL_FLG" ).append("\n"); 
		query.append(",CNTR_VSL_DLAY_FLG" ).append("\n"); 
		query.append(",EXPT_SET_OFC_CD" ).append("\n"); 
		query.append(",EXPT_SET_USR_ID" ).append("\n"); 
		query.append(",EXPT_SET_DT" ).append("\n"); 
		query.append(",DWLL_EXPT_RMK" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CNTR_DWLL_EXPT_FLG)" ).append("\n"); 
		query.append("VALUES ( @[cntr_no]" ).append("\n"); 
		query.append(",SCE_DWLL_EXPT_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(",@[cnmv_yr]" ).append("\n"); 
		query.append(",@[cnmv_id_no]" ).append("\n"); 
		query.append(",@[cnmv_cyc_no]" ).append("\n"); 
		query.append(",@[mst_bkg_no]" ).append("\n"); 
		query.append(",DECODE(@[cntr_tml_dwll_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DECODE(@[cntr_enr_dwll_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DECODE(@[cntr_dest_dwll_flg],'1','Y','N')" ).append("\n"); 
		query.append(",DECODE(@[cntr_vsl_dlay_flg],'1','Y','N')" ).append("\n"); 
		query.append(",@[expt_set_ofc_cd]" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[dwll_expt_rmk]" ).append("\n"); 
		query.append("#if (${ibflag} != 'D')" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",DECODE(@[cntr_dwll_expt_flg],'1','Y','N')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}