/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOSearchBKGStatusCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.15
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.07.15 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */
 
public class AGTAuditDBDAOSearchBKGStatusCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBKGStatusCd
	  * </pre>
	  */
	public AGTAuditDBDAOSearchBKGStatusCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOSearchBKGStatusCdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.BKG_STS_CD   BKG_STS_CD" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM A," ).append("\n"); 
		query.append("BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE A.COMM_APRO_NO = @[comm_apro_no]" ).append("\n"); 
		query.append("AND A.COMM_PROC_STS_CD = @[if_option]" ).append("\n"); 
		query.append("AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if(${exp_type} == 'G')" ).append("\n"); 
		query.append("AND A.COMM_STND_COST_CD NOT IN('512692','512693')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.COMM_STND_COST_CD IN('512692','512693')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}