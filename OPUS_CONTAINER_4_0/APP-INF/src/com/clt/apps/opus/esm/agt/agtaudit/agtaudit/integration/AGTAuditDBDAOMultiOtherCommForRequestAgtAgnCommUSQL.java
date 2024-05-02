/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiOtherCommForRequestAgtAgnComm
	  * </pre>
	  */
	public AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mon_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_locl_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_comm_acct_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOMultiOtherCommForRequestAgtAgnCommUSQL").append("\n"); 
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
		query.append("UPDATE AGT_AGN_COMM" ).append("\n"); 
		query.append("SET COMM_PROC_STS_CD = 'CS'," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN    = 'OTHER COMMISSION MANUAL INPUT!'," ).append("\n"); 
		query.append("VNDR_CNT_CD          = @[vndr_cnt_cd]," ).append("\n"); 
		query.append("VNDR_SEQ             = TO_NUMBER(@[vndr_seq])," ).append("\n"); 
		query.append("COMM_STND_COST_CD    = @[comm_stnd_cost_cd]," ).append("\n"); 
		query.append("OTR_COMM_ACCT_CTNT   = @[otr_comm_acct_ctnt]," ).append("\n"); 
		query.append("COMM_VSL_CD          = SUBSTR(@[vvd],1,4)," ).append("\n"); 
		query.append("COMM_SKD_VOY_NO      = SUBSTR(@[vvd],5,4)," ).append("\n"); 
		query.append("COMM_SKD_DIR_CD      = SUBSTR(@[vvd],9,1)," ).append("\n"); 
		query.append("COMM_REV_DIR_CD      = SUBSTR(@[vvd],10,1)," ).append("\n"); 
		query.append("ACT_COMM_AMT         = ROUND (@[act_comm_amt], 2)," ).append("\n"); 
		query.append("ACT_IF_COMM_AMT      = ROUND (@[act_comm_amt], 2)," ).append("\n"); 
		query.append("ACT_LOCL_COMM_AMT    = ROUND (@[act_locl_comm_amt], 2)," ).append("\n"); 
		query.append("ACT_IF_LOCL_COMM_AMT = ROUND (@[act_locl_comm_amt], 2)," ).append("\n"); 
		query.append("CURR_CD              = @[curr_cd]," ).append("\n"); 
		query.append("MON_XCH_RT           = @[mon_xch_rt]," ).append("\n"); 
		query.append("APLY_DT              = @[aply_dt]," ).append("\n"); 
		query.append("UPD_USR_ID           = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("AND AGN_CD           = @[agn_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD        = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND AC_TP_CD         = @[ac_tp_cd]" ).append("\n"); 
		query.append("AND AC_SEQ           = @[ac_seq]" ).append("\n"); 
		query.append("AND COMM_YRMON       = REPLACE(@[comm_yrmon], '-', '')" ).append("\n"); 
		query.append("AND AC_APRO_DT      IS NULL" ).append("\n"); 

	}
}