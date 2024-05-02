/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrStatusHistoryByUpdateDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.25
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.11.25 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrStatusHistoryByUpdateDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrStatusHistoryByUpdateData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrStatusHistoryByUpdateDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lft_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_drff_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_sts_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_drff_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_old_van_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_cr_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_sts_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rntl_chg_free_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_min_onh_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrStatusHistoryByUpdateDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CNTR_STS_HIS" ).append("\n"); 
		query.append("SET CNTR_STS_EVNT_DT = TO_DATE(@[cntr_sts_evnt_dt],'YYYY-MM-DD')," ).append("\n"); 
		query.append("    YD_CD = @[yd_cd]," ).append("\n"); 
		query.append("    AGMT_CTY_CD = @[agmt_cty_cd]," ).append("\n"); 
		query.append("    AGMT_SEQ = @[agmt_seq]," ).append("\n"); 
		query.append("    CNTR_OLD_VAN_FLG = @[cntr_old_van_flg]," ).append("\n"); 
		query.append("    #if (${cntr_pkup_chg_amt} != '' && ${cntr_pkup_chg_amt} != '0' && ${cntr_pkup_chg_amt} != '0.00') " ).append("\n"); 
		query.append("        CNTR_PKUP_CHG_AMT = @[cntr_pkup_chg_amt]," ).append("\n"); 
		query.append("    #elseif (${cntr_pkup_cr_chg_amt} != ''  && ${cntr_pkup_cr_chg_amt} != '0' && ${cntr_pkup_cr_chg_amt} != '0.00')" ).append("\n"); 
		query.append("        CNTR_PKUP_CHG_AMT =	@[cntr_pkup_cr_chg_amt] * -1," ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    CNTR_MIN_ONH_DYS  = @[cntr_min_onh_dys]," ).append("\n"); 
		query.append("    RNTL_CHG_FREE_DYS = @[rntl_chg_free_dys]," ).append("\n"); 
		query.append("    CNTR_LFT_CHG_AMT = @[cntr_lft_chg_amt]," ).append("\n"); 
		query.append("    CNTR_STS_RMK = @[cntr_sts_rmk]," ).append("\n"); 
		query.append("	#if (${cntr_drff_amt} != '' && ${cntr_drff_amt} != '0' && ${cntr_drff_amt} != '0.00') " ).append("\n"); 
		query.append("	    CNTR_DRFF_CR_AMT = @[cntr_drff_amt]," ).append("\n"); 
		query.append("	#elseif (${cntr_drff_cr_amt} != ''  && ${cntr_drff_cr_amt} != '0' && ${cntr_drff_cr_amt} != '0.00')" ).append("\n"); 
		query.append("	    CNTR_DRFF_CR_AMT =	TO_NUMBER(@[cntr_drff_cr_amt]) * -1," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    CNMV_YR    = @[cnmv_yr]," ).append("\n"); 
		query.append("    CNMV_ID_NO = @[cnmv_id_no],  " ).append("\n"); 
		query.append("    OFC_CD = @[ofc_cd]," ).append("\n"); 
		query.append("    CURR_CD = @[curr_cd]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE," ).append("\n"); 
		query.append("    UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND CNTR_NO      = (SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("                 CNTR_NO " ).append("\n"); 
		query.append("                 FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("                 #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                 AND   A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 AND CNMV_DT = (" ).append("\n"); 
		query.append("                               SELECT MAX(CNMV_DT) " ).append("\n"); 
		query.append("                               FROM MST_CONTAINER " ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() == 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                               #if ($cntr_no.length() != 10) " ).append("\n"); 
		query.append("                               AND   CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                               #end " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                 AND ROWNUM = 1 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CNTR_STS_SEQ = @[cntr_sts_seq]" ).append("\n"); 

	}
}