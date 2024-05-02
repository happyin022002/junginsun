/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAORFAActualCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.01.15 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORFAActualCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Actual Customer List
	  * </pre>
	  */
	public PRICommonDBDAORFAActualCustomerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORFAActualCustomerListRSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0) CD" ).append("\n"); 
		query.append(", B.CUST_LGL_ENG_NM NM" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append(", MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND B.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${etc1} != '' && ${etc2} != '')" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = @[etc1]" ).append("\n"); 
		query.append("AND A.CUST_SEQ = @[etc2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CD" ).append("\n"); 

	}
}