/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchCustomerListBySCDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchCustomerListBySCDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchCustomerListBySCDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchCustomerListBySCDataRSQL").append("\n"); 
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
		query.append("SELECT	A.CUST_CNT_CD || LPAD(A.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("	,	B.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT	DISTINCT CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("			FROM	PRI_SP_SCP_RT_ACT_CUST SP_ACT_CUST" ).append("\n"); 
		query.append("			WHERE	1=1" ).append("\n"); 
		query.append("			#if(${prop_no} == '')" ).append("\n"); 
		query.append("			AND SP_ACT_CUST.PROP_NO = (SELECT DISTINCT PROP_NO" ).append("\n"); 
		query.append("						 				FROM PRI_SP_HDR" ).append("\n"); 
		query.append("										WHERE SC_NO = @[sc_no])" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			AND SP_ACT_CUST.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			MINUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT	CUST_CNT_CD, CUST_SEQ" ).append("\n"); 
		query.append("			FROM	PRI_SP_CTRT_PTY	SP_PTY" ).append("\n"); 
		query.append("			WHERE	1=1" ).append("\n"); 
		query.append("			#if(${prop_no} == '')" ).append("\n"); 
		query.append("				AND SP_PTY.PROP_NO = (SELECT DISTINCT PROP_NO" ).append("\n"); 
		query.append("						 				FROM PRI_SP_HDR" ).append("\n"); 
		query.append("										WHERE SC_NO = @[sc_no])" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND SP_PTY.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				AND SP_PTY.AMDT_SEQ =" ).append("\n"); 
		query.append("			    	(" ).append("\n"); 
		query.append("			        	SELECT  /*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */ AMDT_SEQ" ).append("\n"); 
		query.append("			        	FROM    PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("			        	WHERE   PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("			            	AND ROWNUM 	= 1" ).append("\n"); 
		query.append("			    	)" ).append("\n"); 
		query.append("				AND SP_PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("	, 	MDM_CUSTOMER B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.CUST_CNT_CD 	= B.CUST_CNT_CD" ).append("\n"); 
		query.append("	AND	A.CUST_SEQ		= B.CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CUST_CD" ).append("\n"); 

	}
}