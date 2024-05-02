/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetRoundTruncAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.21
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.02.21 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
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
	  * getRoundTruncAmt
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
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
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
		query.append("--AND [curr_cd] in (select curr_cd from mdm_currency where dp_prcs_knt = 0)" ).append("\n"); 
		query.append("AND @[curr_cd] in (SELECT CURR_CD FROM MDM_CURRENCY" ).append("\n"); 
		query.append("                   WHERE DP_PRCS_KNT=0" ).append("\n"); 
		query.append("                   AND DELT_FLG='N')" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT  ROUND( @[locl_amt]*@[ratio]/100, 2 ), ROUND( @[calc_amt]*@[ratio]/100, 2 ) , ROUND( @[adj_amt]*@[ratio]/100, 2 )" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("WHERE  @[io_bnd_cd] = 'O'" ).append("\n"); 
		query.append("AND @[curr_cd] not in (SELECT CURR_CD FROM MDM_CURRENCY" ).append("\n"); 
		query.append("                       WHERE DP_PRCS_KNT=0" ).append("\n"); 
		query.append("                       AND DELT_FLG='N')" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("/*In-Bound 인 경우 ; 내림*/" ).append("\n"); 
		query.append("SELECT  TRUNC( @[locl_amt]*@[ratio]/100 ), TRUNC( @[calc_amt]*@[ratio]/100 ) , TRUNC( @[adj_amt]*@[ratio]/100 )" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("where @[io_bnd_cd] = 'I'" ).append("\n"); 
		query.append("AND @[curr_cd] in (SELECT CURR_CD FROM MDM_CURRENCY" ).append("\n"); 
		query.append("                   WHERE DP_PRCS_KNT=0" ).append("\n"); 
		query.append("                   AND DELT_FLG='N')" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT  TRUNC( @[locl_amt]*@[ratio]/100, 2 ), TRUNC( @[calc_amt]*@[ratio]/100, 2 ) , TRUNC( @[adj_amt]*@[ratio]/100, 2 )" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("where @[io_bnd_cd] = 'I'" ).append("\n"); 
		query.append("AND @[curr_cd] not in (SELECT CURR_CD FROM MDM_CURRENCY" ).append("\n"); 
		query.append("                       WHERE DP_PRCS_KNT=0" ).append("\n"); 
		query.append("                       AND DELT_FLG='N')" ).append("\n"); 

	}
}