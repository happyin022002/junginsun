/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeBalDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.19 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeBalDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzFeeBalDtl
	  * </pre>
	  */
	public CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeBalDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnl_tz_bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeBalDtlRSQL").append("\n"); 
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
		query.append("select TO_CHAR(VPS_ETB_DT,'YYYY-MM-DD') rev_yrmon" ).append("\n"); 
		query.append(",A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD vvd" ).append("\n"); 
		query.append(",SUM(B.RQST_AMT) amount" ).append("\n"); 
		query.append(",'' vndr_seq" ).append("\n"); 
		query.append(",'' pso_bztp_cd" ).append("\n"); 
		query.append(",'' cnl_tz_bztp_cd" ).append("\n"); 
		query.append(",'' yd_cd" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE  A, PSO_CNL_TZ_FEE_DTL  B, VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.NTC_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD   = '5'" ).append("\n"); 
		query.append("AND A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND A.CNL_TZ_BZTP_CD = @[cnl_tz_bztp_cd]" ).append("\n"); 
		query.append("AND A.CNL_TZ_PROC_STS_CD in ( 'A','Q' )" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD   = B.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.YD_CD         = B.YD_CD" ).append("\n"); 
		query.append("AND A.CALL_SEQ      = B.CALL_SEQ" ).append("\n"); 
		query.append("AND C.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.YD_CD         = B.YD_CD" ).append("\n"); 
		query.append("GROUP BY  VPS_ETB_DT, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 

	}
}