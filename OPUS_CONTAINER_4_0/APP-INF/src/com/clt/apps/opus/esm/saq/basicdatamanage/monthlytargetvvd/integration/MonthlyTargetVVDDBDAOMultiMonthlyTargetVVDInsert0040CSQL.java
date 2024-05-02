/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyTargetVVDDBDAOMultiMonthlyTargetVVDInsert0040CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.28 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyTargetVVDDBDAOMultiMonthlyTargetVVDInsert0040CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public MonthlyTargetVVDDBDAOMultiMonthlyTargetVVDInsert0040CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sprt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_lodg_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bsa_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_lodg_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration").append("\n"); 
		query.append("FileName : MonthlyTargetVVDDBDAOMultiMonthlyTargetVVDInsert0040CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_TGT_VVD(" ).append("\n"); 
		query.append("    BSE_YR, " ).append("\n"); 
		query.append("    BSE_QTR_CD, " ).append("\n"); 
		query.append("    TRD_CD, " ).append("\n"); 
		query.append("    RLANE_CD, " ).append("\n"); 
		query.append("    DIR_CD, " ).append("\n"); 
		query.append("    VSL_CD, " ).append("\n"); 
		query.append("    SKD_VOY_NO, " ).append("\n"); 
		query.append("    SKD_DIR_CD, " ).append("\n"); 
		query.append("    SPRT_GRP_CD, " ).append("\n"); 
		query.append("    BSA_GRP_CD, " ).append("\n"); 
		query.append("    BSE_MON, " ).append("\n"); 
		query.append("    BSE_WK, " ).append("\n"); 
		query.append("    SUB_TRD_CD, " ).append("\n"); 
		query.append("    IOC_CD, " ).append("\n"); 
		query.append("    VVD_SEQ, " ).append("\n"); 
		query.append("    FNL_BSA_CAPA, " ).append("\n"); 
		query.append("    LST_LODG_PORT_ETD_DT, " ).append("\n"); 
		query.append("    LST_LODG_PORT_CD, " ).append("\n"); 
		query.append("    UPD_RMK, " ).append("\n"); 
		query.append("    DELT_FLG, " ).append("\n"); 
		query.append("    CRE_USR_ID,     CRE_DT,     UPD_USR_ID,     UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("    @[bse_yr], " ).append("\n"); 
		query.append("    @[bse_qtr_cd], " ).append("\n"); 
		query.append("    @[trd_cd], " ).append("\n"); 
		query.append("    @[rlane_cd], " ).append("\n"); 
		query.append("    @[dir_cd], " ).append("\n"); 
		query.append("    @[vsl_cd], " ).append("\n"); 
		query.append("    @[skd_voy_no], " ).append("\n"); 
		query.append("    @[skd_dir_cd], " ).append("\n"); 
		query.append("    @[sprt_grp_cd], " ).append("\n"); 
		query.append("    @[bsa_grp_cd], " ).append("\n"); 
		query.append("    @[bse_mon], " ).append("\n"); 
		query.append("    @[bse_wk], " ).append("\n"); 
		query.append("    @[sub_trd_cd], " ).append("\n"); 
		query.append("    @[ioc_cd], " ).append("\n"); 
		query.append("    @[vvd_seq], " ).append("\n"); 
		query.append("    @[fnl_bsa_capa], " ).append("\n"); 
		query.append("    TO_DATE(@[lst_lodg_port_etd_dt], 'YYYY/MM/DD HH24:MI:SS'), " ).append("\n"); 
		query.append("    @[lst_lodg_port_cd], " ).append("\n"); 
		query.append("    @[upd_rmk], " ).append("\n"); 
		query.append("    @[delt_flg], " ).append("\n"); 
		query.append("    @[cre_usr_id],  SYSDATE,  @[upd_usr_id],   SYSDATE)			" ).append("\n"); 

	}
}