/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseInfoManageDBDAOUpdateSTOnHireInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.05 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseInfoManageDBDAOUpdateSTOnHireInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI ID - EES_EQR_0017
	  * Title - S/T On Hire
	  * EQR_SCNR_SHRT_TERM_ONH_COND  수정
	  * </pre>
	  */
	public LeaseInfoManageDBDAOUpdateSTOnHireInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dryg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_chg_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pd_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lft_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration").append("\n"); 
		query.append("FileName : LeaseInfoManageDBDAOUpdateSTOnHireInfoUSQL").append("\n"); 
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
		query.append("UPDATE EQR_SCNR_SHRT_TERM_ONH_COND SET" ).append("\n"); 
		query.append("AVAL_CNTR_QTY	= @[aval_cntr_qty]" ).append("\n"); 
		query.append(",	LFT_CHG_AMT		= @[lft_chg_amt]" ).append("\n"); 
		query.append(",	DRYG_AMT		= @[dryg_amt]" ).append("\n"); 
		query.append(",	PKUP_CHG_CR_AMT = @[pkup_chg_cr_amt]" ).append("\n"); 
		query.append(",	PD_COST_AMT		= @[pd_cost_amt]" ).append("\n"); 
		query.append(",	DFLT_USD_DYS	= @[dflt_usd_dys]" ).append("\n"); 
		query.append(",	UPD_USR_ID		= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT			= SYSDATE" ).append("\n"); 
		query.append("WHERE	SCNR_ID		= @[scnr_id]" ).append("\n"); 
		query.append("AND	ECC_CD		= @[ecc_cd]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD= @[cntr_tpsz_cd]" ).append("\n"); 

	}
}