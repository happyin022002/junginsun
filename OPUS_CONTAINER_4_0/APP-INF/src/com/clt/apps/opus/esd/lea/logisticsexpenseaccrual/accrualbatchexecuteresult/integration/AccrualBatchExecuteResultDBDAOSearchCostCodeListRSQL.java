/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchCostCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2010.01.25 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 물류비용코드 조회   
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_cost_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_cost_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchCostCodeListRSQL").append("\n"); 
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
		query.append("SELECT 	B.MN_COST_TP_CD" ).append("\n"); 
		query.append(",B.SUB_COST_TP_CD" ).append("\n"); 
		query.append(",B.SUB_COST_TP_NM" ).append("\n"); 
		query.append(",A.COA_COST_SRC_CD lgs_cost_cd" ).append("\n"); 
		query.append(",A.LGS_COST_FULL_NM" ).append("\n"); 
		query.append(",A.ACCT_CD" ).append("\n"); 
		query.append(",A.ACCT_NM	ACCT_CD_NM" ).append("\n"); 
		query.append(",A.REP_ACCT_CD" ).append("\n"); 
		query.append(",A.OTR_CRR_ACCT_CD" ).append("\n"); 
		query.append(",A.ACCL_AUTO_CD" ).append("\n"); 
		query.append(",DECODE(A.ACCL_AUTO_CD,'A','Auto','M','Manual','T','Transfer')	ACCL_AUTO_NM" ).append("\n"); 
		query.append(",A.ACCL_LGC_TP_CD" ).append("\n"); 
		query.append(",DECODE(A.ESTM_COST_FLG,'Y','COA')	ESTM_COST_FLG" ).append("\n"); 
		query.append(",A.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	DISTINCT SUB_COST_TP_CD" ).append("\n"); 
		query.append(",ACCT_CD ACCT_CD" ).append("\n"); 
		query.append(",ACCT_NM" ).append("\n"); 
		query.append(",REP_ACCT_CD" ).append("\n"); 
		query.append(",COA_COST_SRC_CD" ).append("\n"); 
		query.append(",LGS_COST_FULL_NM" ).append("\n"); 
		query.append(",OTR_CRR_ACCT_CD" ).append("\n"); 
		query.append(",ACCL_AUTO_CD" ).append("\n"); 
		query.append(",ACCL_LGC_TP_CD" ).append("\n"); 
		query.append(",ESTM_COST_FLG" ).append("\n"); 
		query.append(",COST_SRC_SYS_CD" ).append("\n"); 
		query.append(",OPUT_SEQ" ).append("\n"); 
		query.append("FROM	LEA_LGS_COST" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	DISTINCT 'TMOC' SUB_COST_TP_CD" ).append("\n"); 
		query.append(",OTR_CRR_ACCT_CD ACCT_CD" ).append("\n"); 
		query.append(",OTR_CRR_ACCT_NM ACCT_NM" ).append("\n"); 
		query.append(",OTR_CRR_REP_ACCT_CD  REP_ACCT_CD" ).append("\n"); 
		query.append(",COA_COST_SRC_CD" ).append("\n"); 
		query.append(",LGS_COST_FULL_NM" ).append("\n"); 
		query.append(",OTR_CRR_ACCT_CD" ).append("\n"); 
		query.append(",ACCL_AUTO_CD" ).append("\n"); 
		query.append(",ACCL_LGC_TP_CD" ).append("\n"); 
		query.append(",ESTM_COST_FLG" ).append("\n"); 
		query.append(",COST_SRC_SYS_CD" ).append("\n"); 
		query.append(",OPUT_SEQ" ).append("\n"); 
		query.append("FROM	LEA_LGS_COST    --Terminal Handling - Other Carrier" ).append("\n"); 
		query.append("WHERE	OTR_CRR_ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append(")	A" ).append("\n"); 
		query.append(",LEA_SUB_COST_TP B" ).append("\n"); 
		query.append("WHERE	A.SUB_COST_TP_CD = B.SUB_COST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${frm_cost_cd} !='')" ).append("\n"); 
		query.append("AND   A.COA_COST_SRC_CD    = @[frm_cost_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${frm_acct_cd} !='')" ).append("\n"); 
		query.append("AND   A.ACCT_CD        = @[frm_acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${mn_cost_tp_cd} !='' && ${mn_cost_tp_cd} !='All')" ).append("\n"); 
		query.append("AND   B.MN_COST_TP_CD  = @[mn_cost_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sub_cost_tp_cd} !='' && ${sub_cost_tp_cd} !='All')" ).append("\n"); 
		query.append("AND   B.SUB_COST_TP_CD = @[sub_cost_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${frm_accl_type_cd} !='' && ${frm_accl_type_cd} !='All')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_accl_type_cd} == 'Auto')" ).append("\n"); 
		query.append("AND   A.ACCL_AUTO_CD = 'A'" ).append("\n"); 
		query.append("#elseif (${frm_accl_type_cd} == 'Manual')" ).append("\n"); 
		query.append("AND   A.ACCL_AUTO_CD = 'M'" ).append("\n"); 
		query.append("#elseif (${frm_accl_type_cd} == 'Transfer')" ).append("\n"); 
		query.append("AND   A.ACCL_AUTO_CD = 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY	B.MN_COST_TP_CD	DESC" ).append("\n"); 
		query.append(",B.SUB_COST_TP_CD" ).append("\n"); 
		query.append(",A.OPUT_SEQ" ).append("\n"); 
		query.append(",A.COA_COST_SRC_CD" ).append("\n"); 

	}
}