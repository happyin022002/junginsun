/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultContainerTPSZListRSQL.java
*@FileTitle : Accrual Result by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultContainerTPSZListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accrual Result by CNTR    
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultContainerTPSZListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frm_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultContainerTPSZListRSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_NO" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--,B.COST_ACT_GRP_NM" ).append("\n"); 
		query.append(",'AAAA'" ).append("\n"); 
		query.append(",A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",A.N1ST_NOD_CD" ).append("\n"); 
		query.append(",A.N2ND_NOD_CD" ).append("\n"); 
		query.append(",A.ACCT_CD" ).append("\n"); 
		query.append(",A.COA_COST_SRC_CD LGS_COST_CD" ).append("\n"); 
		query.append(",A.ACCL_LGC_TP_CD" ).append("\n"); 
		query.append(",A.COST_ASS_BSE_CD" ).append("\n"); 
		query.append(",A.CTRT_RTN_FLG" ).append("\n"); 
		query.append(",A.ESTM_COST_AMT        ESTM_COST_AMT" ).append("\n"); 
		query.append(",A.ACT_CNTR_COST_AMT    ACT_CNTR_COST_AMT" ).append("\n"); 
		query.append(",A.ACT_BKG_COST_AMT     ACT_BKG_COST_AMT" ).append("\n"); 
		query.append(",A.ACT_REV_VVD_COST_AMT ACT_REV_VVD_COST_AMT" ).append("\n"); 
		query.append(",A.ACT_COM_VVD_COST_AMT ACT_COM_VVD_COST_AMT" ).append("\n"); 
		query.append(",A.ACT_ETC_COST_AMT     ACT_ETC_COST_AMT" ).append("\n"); 
		query.append(",A.ACT_COST_AMT         ACT_COST_AMT" ).append("\n"); 
		query.append(",A.ACCL_COST_AMT        ACCL_COST_AMT" ).append("\n"); 
		query.append(",A.ACT_INV_KNT          ACT_INV_KNT" ).append("\n"); 
		query.append(",A.TTL_INV_KNT          TTL_INV_KNT" ).append("\n"); 
		query.append(",(NVL(A.ACT_COST_AMT,0)+NVL(A.ACCL_COST_AMT,0))  CONFIRMED_COST_AMT" ).append("\n"); 
		query.append(",(NVL(A.ACT_COST_AMT,0)+NVL(A.ACCL_COST_AMT,0)-NVL(A.ESTM_COST_AMT,0)) COST_DIFF_AMT" ).append("\n"); 
		query.append("FROM    LEA_ACCL_DTL A" ).append("\n"); 
		query.append("WHERE	A.REV_YRMON  = REPLACE(@[frm_rev_yrmon],'-')" ).append("\n"); 
		query.append("AND		A.DELT_FLG   = 'N' --Not Delete" ).append("\n"); 
		query.append("AND		A.BKG_STS_CD = 'F' --Firm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${frm_acct_cd} != '') && (${frm_acct_cd} != 'ALL'))" ).append("\n"); 
		query.append("AND    A.ACCT_CD = @[frm_acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${frm_vvd_no} != '') && (${frm_vvd_no} != 'ALL'))" ).append("\n"); 
		query.append("AND    (A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD) = @[frm_vvd_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_bkg_no} != '')" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[frm_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",A.ACCT_CD" ).append("\n"); 
		query.append(",A.COA_COST_SRC_CD" ).append("\n"); 
		query.append(",A.ACCL_LGC_TP_CD" ).append("\n"); 
		query.append(",A.COST_ASS_BSE_CD" ).append("\n"); 
		query.append(",A.CTRT_RTN_FLG" ).append("\n"); 

	}
}