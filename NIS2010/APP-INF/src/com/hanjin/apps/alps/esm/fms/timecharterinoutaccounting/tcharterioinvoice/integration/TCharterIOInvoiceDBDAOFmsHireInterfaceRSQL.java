/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsHireInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.10 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOFmsHireInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VMS에서 용선선박 용선료 Select
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsHireInterfaceRSQL(){
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsHireInterfaceRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(HIR_RT_N1ST_AMT) HIRE_AMT" ).append("\n"); 
		query.append("FROM (SELECT B.HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("FROM FMS_CONTRACT A," ).append("\n"); 
		query.append("FMS_HIRE B" ).append("\n"); 
		query.append("WHERE A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND @[eff_dt] BETWEEN TO_CHAR(B.EFF_DT,'YYYYMMDD') AND TO_CHAR(B.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("ORDER BY B.EFF_DT DESC)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}