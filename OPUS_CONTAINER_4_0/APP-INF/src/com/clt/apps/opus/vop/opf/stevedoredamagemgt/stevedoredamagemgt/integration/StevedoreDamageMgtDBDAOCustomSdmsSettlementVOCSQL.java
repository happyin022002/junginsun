/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOCustomSdmsSettlementVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOCustomSdmsSettlementVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CustomSdmsSettlementVO Insert Query
	  * [20140821]Merge 쿼리로 변경함.
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOCustomSdmsSettlementVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_stl_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_ownr_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bil_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOCustomSdmsSettlementVOCSQL").append("\n"); 
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
		query.append("MERGE INTO OPF_STV_DMG_STL A" ).append("\n"); 
		query.append("USING DUAL ON (A.STV_DMG_NO = @[stv_dmg_no])" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET " ).append("\n"); 
		query.append(" A.STV_DMG_STL_PROC_STS_CD = @[stv_dmg_stl_proc_sts_cd]" ).append("\n"); 
		query.append(",A.SHP_OWNR_CO_NM          = @[shp_ownr_co_nm]" ).append("\n"); 
		query.append(",A.BIL_INV_NO              = @[bil_inv_no]" ).append("\n"); 
		query.append(",A.PAY_DT                  = TO_DATE(@[pay_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",A.PAY_CURR_CD             = @[pay_curr_cd]" ).append("\n"); 
		query.append(",A.PAY_LOCL_AMT            = @[pay_locl_amt]" ).append("\n"); 
		query.append(",A.PAY_USD_AMT             = (SELECT ROUND(@[pay_locl_amt]/USD_LOCL_XCH_RT,2)" ).append("\n"); 
		query.append("                                FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("                               WHERE ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("                                 AND CURR_CD           = @[pay_curr_cd]" ).append("\n"); 
		query.append("                                 AND ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM'))" ).append("\n"); 
		query.append(",A.PAY_ACCT_NO             = @[pay_acct_no]" ).append("\n"); 
		query.append(",A.STL_RMK                 = @[stv_dmg_rmk]" ).append("\n"); 
		query.append(",A.UPD_USR_ID              = @[cre_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE A.STV_DMG_NO         = @[stv_dmg_no]" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (" ).append("\n"); 
		query.append(" A.STV_DMG_NO" ).append("\n"); 
		query.append(",A.STV_DMG_STL_PROC_STS_CD" ).append("\n"); 
		query.append(",A.SHP_OWNR_CO_NM" ).append("\n"); 
		query.append(",A.BIL_INV_NO" ).append("\n"); 
		query.append(",A.PAY_DT" ).append("\n"); 
		query.append(",A.PAY_CURR_CD" ).append("\n"); 
		query.append(",A.PAY_LOCL_AMT" ).append("\n"); 
		query.append(",A.PAY_USD_AMT" ).append("\n"); 
		query.append(",A.PAY_ACCT_NO" ).append("\n"); 
		query.append(",A.STL_RMK" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" @[stv_dmg_no]" ).append("\n"); 
		query.append(",@[stv_dmg_stl_proc_sts_cd]" ).append("\n"); 
		query.append(",@[shp_ownr_co_nm]" ).append("\n"); 
		query.append(",@[bil_inv_no]" ).append("\n"); 
		query.append(",TO_DATE(@[pay_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",@[pay_curr_cd]" ).append("\n"); 
		query.append(",@[pay_locl_amt]" ).append("\n"); 
		query.append(",(SELECT ROUND(@[pay_locl_amt]/USD_LOCL_XCH_RT,2)" ).append("\n"); 
		query.append("    FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("   WHERE ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("     AND CURR_CD           = @[pay_curr_cd]" ).append("\n"); 
		query.append("     AND ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM'))" ).append("\n"); 
		query.append(",@[pay_acct_no]" ).append("\n"); 
		query.append(",@[stv_dmg_rmk]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}