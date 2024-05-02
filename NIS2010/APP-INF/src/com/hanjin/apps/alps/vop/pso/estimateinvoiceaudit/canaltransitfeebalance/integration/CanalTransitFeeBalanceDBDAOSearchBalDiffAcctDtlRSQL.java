/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CanalTransitFeeBalanceDBDAOSearchBalDiffAcctDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.21 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeBalanceDBDAOSearchBalDiffAcctDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Balance Diff. Account : Detail
	  * </pre>
	  */
	public CanalTransitFeeBalanceDBDAOSearchBalDiffAcctDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yyyymm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeBalanceDBDAOSearchBalDiffAcctDtlRSQL").append("\n"); 
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
		query.append("SELECT S.TTL_USD_AMT" ).append("\n"); 
		query.append(",I1.CSR_NO" ).append("\n"); 
		query.append(",S.INV_NO" ).append("\n"); 
		query.append("FROM   PSO_CNL_TZ_FEE C" ).append("\n"); 
		query.append(",PSO_CHARGE     S" ).append("\n"); 
		query.append(",AP_PAY_INV     I1" ).append("\n"); 
		query.append(",AP_INV_HDR     I2" ).append("\n"); 
		query.append("WHERE  C.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND    C.NTC_YRMON = REPLACE(@[yyyymm], '-', '')" ).append("\n"); 
		query.append("AND    C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    C.CNL_TZ_BZTP_CD IN ('E', 'I')" ).append("\n"); 
		query.append("AND    CNL_TZ_PROC_STS_CD IN ('A', 'P')" ).append("\n"); 
		query.append("AND    C.SO_SEQ = S.SO_SEQ" ).append("\n"); 
		query.append("AND    C.ISS_CTY_CD = S.ISS_CTY_CD" ).append("\n"); 
		query.append("AND    S.INV_RGST_NO = I1.INV_RGST_NO" ).append("\n"); 
		query.append("AND    I1.CSR_NO = I2.CSR_NO" ).append("\n"); 
		query.append("AND    EXISTS  (SELECT 'X'" ).append("\n"); 
		query.append("FROM   PSO_MSA" ).append("\n"); 
		query.append("WHERE  REV_YRMON = REPLACE(@[yyyymm], '-', '')" ).append("\n"); 
		query.append("AND    VNDR_SEQ = @[vndr_seq])" ).append("\n"); 
		query.append("AND    (I2.RCV_ERR_FLG IS NOT NULL" ).append("\n"); 
		query.append("OR NVL(I2.IF_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append("OR C.NTC_YRMON <> SUBSTR(I2.GL_DT, 1, 6))" ).append("\n"); 

	}
}