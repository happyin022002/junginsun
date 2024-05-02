/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingMigrationDBDAOModifyOutstandingDetailUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingMigrationDBDAOModifyOutstandingDetailUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_OTS_DTL 테이블에 update
	  * </pre>
	  */
	public AccountReceivableOutstandingMigrationDBDAOModifyOutstandingDetailUSQL(){
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
		params.put("wrtf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingMigrationDBDAOModifyOutstandingDetailUSQL").append("\n"); 
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
		query.append("UPDATE  OPUSADM_TMP.SAR_OTS_DTL SET" ).append("\n"); 
		query.append("        INV_AMT = NVL(INV_AMT, 0) + NVL(@[inv_amt], 0)" ).append("\n"); 
		query.append("      , INV_UPD_DT = DECODE(NVL(@[inv_amt], 0), 0, INV_UPD_DT, SYSDATE)" ).append("\n"); 
		query.append("      , RCT_AMT = NVL(RCT_AMT, 0) + NVL(@[rct_amt], 0)" ).append("\n"); 
		query.append("      , RCT_UPD_DT = DECODE(NVL(@[rct_amt], 0), 0, RCT_UPD_DT, SYSDATE)" ).append("\n"); 
		query.append("      , ADJ_AMT = NVL(ADJ_AMT, 0) + NVL(@[adj_amt], 0)" ).append("\n"); 
		query.append("      , ADJ_UPD_DT = DECODE(NVL(@[adj_amt], 0), 0, ADJ_UPD_DT, SYSDATE)" ).append("\n"); 
		query.append("      , BAL_AMT = NVL(BAL_AMT, 0) + (NVL(@[inv_amt], 0) - NVL(@[rct_amt], 0) + NVL(@[adj_amt], 0))" ).append("\n"); 
		query.append("      , BAL_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      , WRTF_AMT = NVL(WRTF_AMT, 0) + NVL(@[wrtf_amt], 0)" ).append("\n"); 
		query.append("      , WRTF_UPD_DT = DECODE(NVL(@[wrtf_amt], 0), 0, WRTF_UPD_DT, SYSDATE)" ).append("\n"); 
		query.append("      , LOCL_XCH_RT = NVL(@[locl_xch_rt], NVL(LOCL_XCH_RT, 0))" ).append("\n"); 
		query.append("      , USD_XCH_RT = NVL(@[usd_xch_rt], NVL(USD_XCH_RT, 0))" ).append("\n"); 
		query.append("      , BAL_LOCL_AMT = (SELECT  ROUND((NVL(BAL_AMT, 0) + NVL(@[inv_amt], 0) - NVL(@[rct_amt], 0) + NVL(@[adj_amt], 0)) * NVL(@[locl_xch_rt], NVL(LOCL_XCH_RT, 0)), A.DP_PRCS_KNT)" ).append("\n"); 
		query.append("                        FROM    MDM_CURRENCY A" ).append("\n"); 
		query.append("                              , OPUSADM_TMP.SAR_OTS_HDR B" ).append("\n"); 
		query.append("                        WHERE   A.CURR_CD = B.OFC_CURR_CD" ).append("\n"); 
		query.append("                        AND     B.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("                        AND     B.OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("                        AND     B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                        AND     B.INV_NO = @[inv_no])" ).append("\n"); 
		query.append("      , BAL_USD_AMT = ROUND((NVL(BAL_AMT, 0) + NVL(@[inv_amt], 0) - NVL(@[rct_amt], 0) + NVL(@[adj_amt], 0)) * NVL(@[usd_xch_rt], NVL(USD_XCH_RT, 0)), 2)" ).append("\n"); 
		query.append("      , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE   RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("AND     OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("AND     BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND     INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND     BL_CURR_CD = @[bl_curr_cd]" ).append("\n"); 
		query.append("AND     CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 

	}
}