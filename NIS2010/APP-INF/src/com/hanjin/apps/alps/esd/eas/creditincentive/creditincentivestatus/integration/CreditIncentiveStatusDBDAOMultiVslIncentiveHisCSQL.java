/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOMultiVslIncentiveHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.15 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOMultiVslIncentiveHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL Incentive History Save
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOMultiVslIncentiveHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jun_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mar_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rcv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jan_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rmn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("may_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apr_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dec_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oct_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sep_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_n2nd_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mar_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oct_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apr_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feb_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("may_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jul_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jan_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aug_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sep_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jul_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nov_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aug_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("feb_estm_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jun_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incnt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dec_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nov_rcv_incnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incnt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOMultiVslIncentiveHisCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_VSL_YRY_CR_HIS(" ).append("\n"); 
		query.append("	   BSE_YR" ).append("\n"); 
		query.append("	  ,INCNT_NO" ).append("\n"); 
		query.append("	  ,INCNT_HIS_SEQ" ).append("\n"); 
		query.append("	  ,RHQ_CD" ).append("\n"); 
		query.append("	  ,OFC_CD" ).append("\n"); 
		query.append("	  ,PORT_CD" ).append("\n"); 
		query.append("	  ,ITM_CD" ).append("\n"); 
		query.append("	  ,VNDR_SEQ" ).append("\n"); 
		query.append("	  ,CURR_CD" ).append("\n"); 
		query.append("	  ,JAN_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,JAN_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,FEB_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,FEB_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,MAR_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,MAR_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,APR_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,APR_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,MAY_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,MAY_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,JUN_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,JUN_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,JUL_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,JUL_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,AUG_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,AUG_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,SEP_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,SEP_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,OCT_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,OCT_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NOV_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,NOV_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,DEC_ESTM_INCNT_AMT" ).append("\n"); 
		query.append("	  ,DEC_RCV_INCNT_AMT" ).append("\n"); 
		query.append("	  ,TTL_INCNT_AMT" ).append("\n"); 
		query.append("	  ,TTL_RCV_AMT" ).append("\n"); 
		query.append("	  ,TTL_RMN_AMT" ).append("\n"); 
		query.append("	  ,INSTR_RMK" ).append("\n"); 
		query.append("	  ,STL_RMK" ).append("\n"); 
		query.append("	  ,INCNT_RMK" ).append("\n"); 
		query.append("	  ,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,ATCH_N2ND_FILE_LNK_ID" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("	   @[bse_yr]" ).append("\n"); 
		query.append("	  ,@[incnt_no]" ).append("\n"); 
		query.append("	  ,(SELECT CASE WHEN MAX(INCNT_HIS_SEQ) IS NULL THEN 1" ).append("\n"); 
		query.append("                    ELSE MAX(INCNT_HIS_SEQ)+1" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("          FROM EAS_VSL_YRY_CR_HIS" ).append("\n"); 
		query.append("         WHERE BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("           AND INCNT_NO = @[incnt_no])" ).append("\n"); 
		query.append("	  ,@[rhq_cd]" ).append("\n"); 
		query.append("	  ,@[ofc_cd]" ).append("\n"); 
		query.append("	  ,@[port_cd]" ).append("\n"); 
		query.append("	  ,@[itm_cd]" ).append("\n"); 
		query.append("	  ,@[vndr_seq]" ).append("\n"); 
		query.append("	  ,@[curr_cd]" ).append("\n"); 
		query.append("	  ,@[jan_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[jan_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[feb_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[feb_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[mar_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[mar_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[apr_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[apr_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[may_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[may_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[jun_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[jun_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[jul_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[jul_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[aug_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[aug_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[sep_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[sep_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[oct_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[oct_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[nov_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[nov_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[dec_estm_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[dec_rcv_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_incnt_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_rcv_amt]" ).append("\n"); 
		query.append("	  ,@[ttl_rmn_amt]" ).append("\n"); 
		query.append("	  ,@[instr_rmk]" ).append("\n"); 
		query.append("	  ,@[stl_rmk]" ).append("\n"); 
		query.append("	  ,@[incnt_rmk]" ).append("\n"); 
		query.append("	  ,@[atch_file_lnk_id]" ).append("\n"); 
		query.append("      ,@[atch_n2nd_file_lnk_id]" ).append("\n"); 
		query.append("	  ,@[usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	  ,@[usr_id]" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}