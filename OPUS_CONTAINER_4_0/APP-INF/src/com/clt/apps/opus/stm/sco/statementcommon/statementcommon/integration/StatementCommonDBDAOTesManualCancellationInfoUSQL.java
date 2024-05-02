/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOTesManualCancellationInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOTesManualCancellationInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update TesManualCancellation agingst sac_cost_accl_info
	  * </pre>
	  */
	public StatementCommonDBDAOTesManualCancellationInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vendor_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cancel_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yard_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOTesManualCancellationInfoUSQL").append("\n"); 
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
		query.append("UPDATE SAC_COST_ACCL_INFO " ).append("\n"); 
		query.append("SET    ACCL_FLG = DECODE(@[cancel_flag], 'Y','Y', 'X')" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE (EXE_YRMON, SYS_SRC_ID, REV_YRMON, ACCT_CD, ACCL_SEQ) IN (" ).append("\n"); 
		query.append("       SELECT EXE_YRMON, SYS_SRC_ID, REV_YRMON, ACCT_CD, ACCL_SEQ" ).append("\n"); 
		query.append("       FROM   SAC_TML_ACCL_COST_IF" ).append("\n"); 
		query.append("       WHERE  EXE_YRMON = @[exe_month]" ).append("\n"); 
		query.append("       AND    SYS_SRC_ID = 'TES'" ).append("\n"); 
		query.append("       AND    VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("       AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND    SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("       AND    NVL(REV_DIR_CD,'NULL') = DECODE(@[rev_dir_cd], '', 'NULL', @[rev_dir_cd])" ).append("\n"); 
		query.append("       AND    TO_CHAR(ACT_DT, 'YYYY-MM') = @[act_dt]" ).append("\n"); 
		query.append("       AND    NOD_CD = @[yard_code]" ).append("\n"); 
		query.append("       AND    VNDR_NO = @[vendor_code]" ).append("\n"); 
		query.append("       AND    COA_COST_SRC_CD = @[cost_code]" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}