/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOFmsBunkerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOFmsBunkerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOFmsBunkerCSQL
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOFmsBunkerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_prc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bnk_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOFmsBunkerCSQL").append("\n"); 
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
		query.append("INSERT INTO FMS_BUNKER (" ).append("\n"); 
		query.append("	FLET_CTRT_NO," ).append("\n"); 
		query.append("	BNK_SEQ," ).append("\n"); 
		query.append("	BNK_YRMON," ).append("\n"); 
		query.append("	BNK_TP_CD," ).append("\n"); 
		query.append("	ACCT_CD," ).append("\n"); 
		query.append("	ACCT_ITM_SEQ," ).append("\n"); 
		query.append("	BNK_DT," ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	SKD_VOY_NO," ).append("\n"); 
		query.append("	SKD_DIR_CD," ).append("\n"); 
		query.append("	REV_DIR_CD," ).append("\n"); 
		query.append("	PORT_CD," ).append("\n"); 
		query.append("	FLET_MEAS_UT_CD," ).append("\n"); 
		query.append("	BNK_QTY," ).append("\n"); 
		query.append("	BNK_PRC_AMT," ).append("\n"); 
		query.append("	BNK_AMT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[flet_ctrt_no]," ).append("\n"); 
		query.append("	FMS_BNK_SEQ.NEXTVAL," ).append("\n"); 
		query.append("    TO_CHAR(TO_DATE(@[bnk_dt], 'YYYY-MM-DD HH24MI'),'YYYYMM')," ).append("\n"); 
		query.append("	@[bnk_tp_cd]," ).append("\n"); 
		query.append("	@[acct_cd]," ).append("\n"); 
		query.append("	@[acct_itm_seq]," ).append("\n"); 
		query.append("	TO_DATE(@[bnk_dt], 'YYYY-MM-DD HH24MI')," ).append("\n"); 
		query.append("	@[vsl_cd]," ).append("\n"); 
		query.append("	SUBSTR(@[bunker_vvd], 5, 4)," ).append("\n"); 
		query.append("	SUBSTR(@[bunker_vvd], 9, 1)," ).append("\n"); 
		query.append("	SUBSTR(@[bunker_vvd], 10,1)," ).append("\n"); 
		query.append("	@[port_cd]," ).append("\n"); 
		query.append("	@[flet_meas_ut_cd]," ).append("\n"); 
		query.append("	@[bnk_qty]," ).append("\n"); 
		query.append("	@[bnk_prc_amt]," ).append("\n"); 
		query.append("	@[bnk_amt]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}