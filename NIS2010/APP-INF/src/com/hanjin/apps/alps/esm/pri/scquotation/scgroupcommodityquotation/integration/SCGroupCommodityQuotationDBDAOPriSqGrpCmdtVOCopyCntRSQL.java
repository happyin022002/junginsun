/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityQuotationDBDAOPriSqGrpCmdtVOCopyCntRSQL.java
*@FileTitle : RFA Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.07 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityQuotationDBDAOPriSqGrpCmdtVOCopyCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * gline copy 전 저장 건수 조회
	  * </pre>
	  */
	public SCGroupCommodityQuotationDBDAOPriSqGrpCmdtVOCopyCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityQuotationDBDAOPriSqGrpCmdtVOCopyCntRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) AS COPY_CNT" ).append("\n"); 
		query.append("FROM    PRI_SG_GRP_CMDT" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND    (SVC_SCP_CD, GLINE_SEQ) =  ( SELECT SVC_SCP_CD, GLINE_SEQ" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD, GLINE_SEQ, MAX(EFF_DT)" ).append("\n"); 
		query.append("FROM   PRI_SG_MN" ).append("\n"); 
		query.append("WHERE  SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND    TO_CHAR(EFF_DT,'YYYY-MM-DD') <= @[eff_dt]" ).append("\n"); 
		query.append("AND    TO_CHAR(EFF_DT,'YYYY-MM-DD') >= @[eff_dt]" ).append("\n"); 
		query.append("AND    CFM_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY SVC_SCP_CD, GLINE_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     PRC_CUST_TP_CD = @[prc_cust_tp_cd]" ).append("\n"); 

	}
}