/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOsearchEqInterchangeRequestDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOsearchEqInterchangeRequestDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  Eq Interchange Request Data 조회
	  * </pre>
	  */
	public EqInterchangeDBDAOsearchEqInterchangeRequestDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_req_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOsearchEqInterchangeRequestDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  LSE_ITCHG_RQST_NO  AS REQ_NO," ).append("\n"); 
		query.append("  LSE_ITCHG_RQST_SEQ AS REQ_SEQ," ).append("\n"); 
		query.append("  LSTM_CD            ," ).append("\n"); 
		query.append("  LR_VNDR_SEQ        AS VNDR_SEQ," ).append("\n"); 
		query.append("  FM_LOC_CD          AS LOC_FM," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD       AS TPSZ_CD," ).append("\n"); 
		query.append("  LSE_LOC_GRP_CD     AS LOC_GRP," ).append("\n"); 
		query.append("  TO_LOC_CD          AS LOC_TO," ).append("\n"); 
		query.append("  FM_COST_AMT        AS POR_COST," ).append("\n"); 
		query.append("  FM_COST_AMT        AS SBO_COST," ).append("\n"); 
		query.append("  TO_COST_AMT        AS DEL_COST," ).append("\n"); 
		query.append("  TO_COST_AMT        AS SBI_COST," ).append("\n"); 
		query.append("  LSE_ITCHG_RQST_QTY AS RQST_QTY," ).append("\n"); 
		query.append("  LSE_FREE_DYS       AS FREE_DAY," ).append("\n"); 
		query.append("  PKUP_UT_AMT        AS PUC_AMT," ).append("\n"); 
		query.append("  PKUP_UT_AMT        AS GTO_AMT," ).append("\n"); 
		query.append("  ADD_TTL_COST_AMT   AS ADD_COST," ).append("\n"); 
		query.append("  PKUP_CR_AMT        AS PCR_CREDIT," ).append("\n"); 
		query.append("  TTL_SAV_AMT        AS TTL_SAV," ).append("\n"); 
		query.append("  LSE_ITCHG_AUTH_NO  AS AUTH_NO," ).append("\n"); 
		query.append("  LSE_ITCHG_AUTH_SEQ AS AUTH_SEQ" ).append("\n"); 
		query.append("FROM LSE_EQ_ITCHG_RQST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND LSE_ITCHG_AUTH_NO IS NULL" ).append("\n"); 
		query.append("#if (${combo_req_no} != '' )" ).append("\n"); 
		query.append("AND LSE_ITCHG_RQST_NO = @[combo_req_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("AND LR_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND FM_LOC_CD = @[loc_fm]" ).append("\n"); 
		query.append("#if (${loc_to} != '' )" ).append("\n"); 
		query.append("AND TO_LOC_CD = @[loc_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tpsz_cd} != '')" ).append("\n"); 
		query.append("        AND     CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}