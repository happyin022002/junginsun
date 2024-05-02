/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOAddMstEqMftPlnListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOAddMstEqMftPlnListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddMstEqMftPlnList
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOAddMstEqMftPlnListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_hngr_rck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_flr_mtrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_cntr_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOAddMstEqMftPlnListCSQL").append("\n"); 
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
		query.append("INSERT INTO MST_EQ_MFT_PLN (" ).append("\n"); 
		query.append("	PLN_YR" ).append("\n"); 
		query.append(",	EQ_TP_CD" ).append("\n"); 
		query.append(",	EQ_TPSZ_CD" ).append("\n"); 
		query.append(",   PLN_SEQ" ).append("\n"); 
		query.append(",	CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",	CNTR_FLR_MTRL_CD" ).append("\n"); 
		query.append(",	RF_TP_CD" ).append("\n"); 
		query.append(",	LOT_CNTR_PFX_CD" ).append("\n"); 
		query.append(",	FM_SER_NO" ).append("\n"); 
		query.append(",	TO_SER_NO" ).append("\n"); 
		query.append(",	CNTR_QTY" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	@[pln_yr]" ).append("\n"); 
		query.append(",	@[eq_tp_cd]" ).append("\n"); 
		query.append(",	@[eq_tpsz_cd]" ).append("\n"); 
		query.append(",   NVL(MAX(PLN_SEQ),0)+1" ).append("\n"); 
		query.append(",	DECODE(@[cntr_hngr_rck_cd],'1','O',null)" ).append("\n"); 
		query.append(",   @[cntr_flr_mtrl_cd]" ).append("\n"); 
		query.append(",	@[rf_tp_cd]" ).append("\n"); 
		query.append(",	@[lot_cntr_pfx_cd]" ).append("\n"); 
		query.append(",	@[fm_ser_no]" ).append("\n"); 
		query.append(",	@[to_ser_no]" ).append("\n"); 
		query.append(",	@[cntr_qty]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM MST_EQ_MFT_PLN" ).append("\n"); 
		query.append("WHERE PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("AND EQ_TP_CD =@[eq_tp_cd]" ).append("\n"); 
		query.append("AND EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 

	}
}