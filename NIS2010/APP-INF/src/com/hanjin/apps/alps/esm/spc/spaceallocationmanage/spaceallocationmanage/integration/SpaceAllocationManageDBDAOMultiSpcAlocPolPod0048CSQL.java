/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod0048CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.10 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod0048CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History----------------------------------
	  * 20110.08.16 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - SLS_OFC_CD가 HAMRU,NYCRA로 Allocation 될때 삽입하는 쿼리
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod0048CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("account_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_40ft_dry_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_20ft_dry_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("us_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod0048CSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_POL_POD (" ).append("\n"); 
		query.append("	RLANE_CD" ).append("\n"); 
		query.append(",	DIR_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	SLS_OFC_CD" ).append("\n"); 
		query.append(",	POL_YD_CD" ).append("\n"); 
		query.append(",	POD_YD_CD" ).append("\n"); 
		query.append(",	TS_FLG" ).append("\n"); 
		query.append(",	MNL_FLG" ).append("\n"); 
		query.append(",	REP_TRD_CD" ).append("\n"); 
		query.append(",	REP_SUB_TRD_CD" ).append("\n"); 
		query.append(",	TRD_CD" ).append("\n"); 
		query.append(",	SUB_TRD_CD" ).append("\n"); 
		query.append(",	IOC_CD" ).append("\n"); 
		query.append(",	SLS_RHQ_CD" ).append("\n"); 
		query.append(",	SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(",	ASGN_TTL_QTY" ).append("\n"); 
		query.append(",	ASGN_20FT_QTY" ).append("\n"); 
		query.append(",	ASGN_40FT_QTY" ).append("\n"); 
		query.append(",	ASGN_40FT_HC_QTY" ).append("\n"); 
		query.append(",	ASGN_45FT_HC_QTY" ).append("\n"); 
		query.append(",	ASGN_RF_QTY" ).append("\n"); 
		query.append(",	ASGN_TTL_WGT" ).append("\n"); 
		query.append(",	MNL_ALOC_RMK" ).append("\n"); 
		query.append(",	ALOC_USR_ID" ).append("\n"); 
		query.append(",	ALOC_GDT" ).append("\n"); 
		query.append(",	ASGN_53FT_QTY" ).append("\n"); 
		query.append(", 	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	ASGN_20FT_DRY_QTY" ).append("\n"); 
		query.append(",	ASGN_40FT_DRY_QTY" ).append("\n"); 
		query.append(",	ASGN_RD_QTY" ).append("\n"); 
		query.append(",   CUST_CNT_CD" ).append("\n"); 
		query.append(",   CUST_SEQ" ).append("\n"); 
		query.append(",   CTRT_NO " ).append("\n"); 
		query.append(",   USA_BKG_MOD_CD" ).append("\n"); 
		query.append(",   DEST_LOC_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[rlane_cd]" ).append("\n"); 
		query.append(",	@[dir_cd]" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[sls_ofc_cd]" ).append("\n"); 
		query.append(",	@[pol_cd]" ).append("\n"); 
		query.append(",	@[pod_cd]" ).append("\n"); 
		query.append(",	DECODE(@[ioc_cd],'T','Y','N')  -- ts_flg" ).append("\n"); 
		query.append(",	'N' --[mnl_flg]" ).append("\n"); 
		query.append(",	SPC_GET_REP_TRD_FNC(@[rlane_cd])" ).append("\n"); 
		query.append(",	SPC_GET_REP_SUB_TRD_FNC(@[rlane_cd])" ).append("\n"); 
		query.append(",	@[trd_cd]" ).append("\n"); 
		query.append(",	@[sub_trd_cd]" ).append("\n"); 
		query.append(",	DECODE(SUBSTR(@[trd_cd],1,1),'I','I','O')" ).append("\n"); 
		query.append(",	@[sls_ofc_cd] --sls_rhq_cd" ).append("\n"); 
		query.append(",	NULL --sls_rgn_ofc_cd" ).append("\n"); 
		query.append(",	NVL(@[asgn_ttl_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[asgn_20ft_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[asgn_40ft_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[asgn_40ft_hc_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[asgn_45ft_hc_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[asgn_rf_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[asgn_ttl_wgt],0)" ).append("\n"); 
		query.append(",	'3' -- mnl_aloc_rmk" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	CAST(SYS_EXTRACT_UTC(SYSTIMESTAMP) AS DATE)" ).append("\n"); 
		query.append(",	@[asgn_53ft_qty]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	NVL(@[asgn_20ft_dry_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[asgn_40ft_dry_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[asgn_rd_qty],0)" ).append("\n"); 
		query.append(",   NVL(SUBSTR(@[account_cd], 1, 2), 'XX')" ).append("\n"); 
		query.append(",   NVL(SUBSTR(@[account_cd], 3, 6), '999999')" ).append("\n"); 
		query.append(",   NVL(@[ctrt_no], 'X')" ).append("\n"); 
		query.append(",   NVL(@[us_mod], 'OTH')" ).append("\n"); 
		query.append(",   NVL(@[del_cd], 'XXXXX')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
