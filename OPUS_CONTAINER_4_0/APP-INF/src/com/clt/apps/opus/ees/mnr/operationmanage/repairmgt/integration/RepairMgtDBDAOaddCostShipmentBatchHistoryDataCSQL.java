/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RepairMgtDBDAOaddCostShipmentBatchHistoryDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOaddCostShipmentBatchHistoryDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RepairMgtDBDAOaddCostShipmentBatchHistoryDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ord_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration ").append("\n"); 
		query.append("FileName : RepairMgtDBDAOaddCostShipmentBatchHistoryDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ORD_DTL_TRC" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BAT_HIS_DT," ).append("\n"); 
		query.append("    MNR_ORD_OFC_CTY_CD," ).append("\n"); 
		query.append("    MNR_ORD_SEQ," ).append("\n"); 
		query.append("    ORD_DTL_SEQ," ).append("\n"); 
		query.append("    COST_CD," ).append("\n"); 
		query.append("    COST_DTL_CD," ).append("\n"); 
		query.append("    EQ_NO," ).append("\n"); 
		query.append("    RPR_RSLT_DT," ).append("\n"); 
		query.append("    MNR_INP_TP_CD," ).append("\n"); 
		query.append("    TRD_CD," ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    VSL_CD," ).append("\n"); 
		query.append("    SKD_VOY_NO," ).append("\n"); 
		query.append("    SKD_DIR_CD," ).append("\n"); 
		query.append("    REV_DIR_CD," ).append("\n"); 
		query.append("    SLAN_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[mnr_ord_ofc_cty_cd]," ).append("\n"); 
		query.append("    @[mnr_ord_seq]," ).append("\n"); 
		query.append("    @[ord_dtl_seq]," ).append("\n"); 
		query.append("    @[cost_cd]," ).append("\n"); 
		query.append("    @[cost_dtl_cd]," ).append("\n"); 
		query.append("    @[eq_no]," ).append("\n"); 
		query.append("    TO_DATE(@[rpr_rslt_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("    @[mnr_inp_tp_cd]," ).append("\n"); 
		query.append("    @[trd_cd]," ).append("\n"); 
		query.append("    @[bkg_no]," ).append("\n"); 
		query.append("    @[vsl_cd]," ).append("\n"); 
		query.append("    @[skd_voy_no]," ).append("\n"); 
		query.append("    @[skd_dir_cd]," ).append("\n"); 
		query.append("    @[rev_dir_cd]," ).append("\n"); 
		query.append("    @[slan_cd]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}