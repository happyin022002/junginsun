/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOSltHirCarrierRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.04 민정호
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

public class SettlementProcessDBDAOSltHirCarrierRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Carrier 코드 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOSltHirCarrierRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOSltHirCarrierRSQL").append("\n"); 
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
		query.append("       A.CRR_CD AS JO_CRR_CD" ).append("\n"); 
		query.append("FROM   JOO_SLT_LIST		 A," ).append("\n"); 
		query.append("       JOO_CARRIER       B" ).append("\n"); 
		query.append("WHERE  A.CRR_CD  = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("#if (${rev_yrmon_fr} != '')" ).append("\n"); 
		query.append("AND    A.REV_YRMON >= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_yrmon_to} != '')" ).append("\n"); 
		query.append("AND    A.REV_YRMON <= REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND    A.ACCT_CD   LIKE DECODE(@[re_divr_cd],'R','4','5')||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trd_cd} != '')" ).append("\n"); 
		query.append("AND    B.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rlane_cd} != '')" ).append("\n"); 
		query.append("AND    A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP  BY A.CRR_CD" ).append("\n"); 
		query.append("ORDER  BY A.CRR_CD" ).append("\n"); 

	}
}