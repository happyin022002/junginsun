/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetRoundTruncAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetRoundTruncAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IN/OUT 에 따라서 AMOUNT를 반으로 나누어 준다.
	  * 
	  * *History
	  * 2011.01.18 진마리아 [CHM-201007407-01] Turning indicator로 인한 Invocie amount 생성 로직 변경 요청건
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetRoundTruncAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ratio",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetRoundTruncAmtRSQL").append("\n"); 
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
		query.append("SELECT  ROUND( @[locl_amt]*@[ratio]/100 ) locl_amt, ROUND( @[calc_amt]*@[ratio]/100 ) calc_amt, ROUND( @[adj_amt]*@[ratio]/100 ) adj_amt" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("WHERE  @[io_bnd_cd] = 'O'" ).append("\n"); 
		query.append("--CHM-201007407-01 진마리아 'KRW', 'JPY', 'TWD' 에서 'CLP' 를 포함하기 위해, 소수점 자리수가 0인 모든 CURRENCY로 수정하였음" ).append("\n"); 
		query.append("AND @[curr_cd] IN (SELECT CURR_CD " ).append("\n"); 
		query.append("				  FROM MDM_CURRENCY " ).append("\n"); 
		query.append("				  WHERE DP_PRCS_KNT = 0 " ).append("\n"); 
		query.append("				  AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("--AND [curr_cd] in ('KRW','JPY','TWD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT  ROUND( @[locl_amt]*@[ratio]/100, 2 ), ROUND( @[calc_amt]*@[ratio]/100, 2 ) , ROUND( @[adj_amt]*@[ratio]/100, 2 )" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("WHERE  @[io_bnd_cd] = 'O'" ).append("\n"); 
		query.append("--CHM-201007407-01" ).append("\n"); 
		query.append("AND @[curr_cd] NOT IN (SELECT CURR_CD " ).append("\n"); 
		query.append("				  FROM MDM_CURRENCY " ).append("\n"); 
		query.append("				  WHERE DP_PRCS_KNT = 0 " ).append("\n"); 
		query.append("				  AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("--AND [curr_cd] not in ('KRW','JPY','TWD')" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("/*In-Bound 인 경우 ; 내림*/" ).append("\n"); 
		query.append("SELECT  TRUNC( @[locl_amt]*@[ratio]/100 ), TRUNC( @[calc_amt]*@[ratio]/100 ) , TRUNC( @[adj_amt]*@[ratio]/100 )" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("where @[io_bnd_cd] = 'I'" ).append("\n"); 
		query.append("--CHM-201007407-01" ).append("\n"); 
		query.append("AND @[curr_cd] IN (SELECT CURR_CD " ).append("\n"); 
		query.append("				  FROM MDM_CURRENCY " ).append("\n"); 
		query.append("				  WHERE DP_PRCS_KNT = 0 " ).append("\n"); 
		query.append("				  AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("--AND [curr_cd] in ('KRW','JPY','TWD')" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT  TRUNC( @[locl_amt]*@[ratio]/100, 2 ), TRUNC( @[calc_amt]*@[ratio]/100, 2 ) , TRUNC( @[adj_amt]*@[ratio]/100, 2 )" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("where @[io_bnd_cd] = 'I'" ).append("\n"); 
		query.append("--CHM-201007407-01" ).append("\n"); 
		query.append("AND @[curr_cd] NOT IN (SELECT CURR_CD " ).append("\n"); 
		query.append("				  FROM MDM_CURRENCY " ).append("\n"); 
		query.append("				  WHERE DP_PRCS_KNT = 0 " ).append("\n"); 
		query.append("				  AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("--AND [curr_cd] not in ('KRW','JPY','TWD')" ).append("\n"); 

	}
}