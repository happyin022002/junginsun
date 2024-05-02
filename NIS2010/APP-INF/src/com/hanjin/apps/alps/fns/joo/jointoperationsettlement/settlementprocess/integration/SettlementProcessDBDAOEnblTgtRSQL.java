/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOEnblTgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.11.27 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOEnblTgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Acount Month를 조회하여 Target을 해제 할 수 있는지 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOEnblTgtRSQL(){
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
		params.put("rev_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOEnblTgtRSQL").append("\n"); 
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
		query.append("SELECT DECODE(ACCT_YRMON,'999912','Y','N') AS ENBL_TGT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("			SELECT NVL(MAX(J3.ACCT_YRMON),'999912') AS ACCT_YRMON " ).append("\n"); 
		query.append("            FROM JOO_STL_TGT J2, JOO_SETTLEMENT J3" ).append("\n"); 
		query.append("			WHERE J2.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("			AND J2.REV_YRMON_SEQ = @[rev_yrmon_seq]" ).append("\n"); 
		query.append("#if (${rev_seq} != '') " ).append("\n"); 
		query.append("	        AND J2.REV_SEQ = @[rev_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			AND J2.ACCT_YRMON = J3.ACCT_YRMON(+)" ).append("\n"); 
		query.append("			AND J2.STL_VVD_SEQ = J3.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("			AND J2.STL_SEQ = J3.STL_SEQ(+)" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}