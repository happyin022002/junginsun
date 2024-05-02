/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchOPCreditRtPortPairRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchOPCreditRtPortPairRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WeeklyCMDBDAOSearchOPCreditRtPortPairRSQL
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchOPCreditRtPortPairRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchOPCreditRtPortPairRSQL").append("\n"); 
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
		query.append("        	SELECT B.CNT_CD" ).append("\n"); 
		query.append("		      , B.CNT_NM" ).append("\n"); 
		query.append("		      , A.POR_ECC_CD" ).append("\n"); 
		query.append("		      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D2', 'O')) TPSZ_D2" ).append("\n"); 
		query.append("		      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D4', 'O')) TPSZ_D4" ).append("\n"); 
		query.append("		      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D5', 'O')) TPSZ_D5" ).append("\n"); 
		query.append("		   FROM COA_CNTR_REPO_SPLS_DEL_RTO A" ).append("\n"); 
		query.append("		      , (SELECT b.ecc_cd" ).append("\n"); 
		query.append("		              , A.cnt_cd" ).append("\n"); 
		query.append("		              , c.cnt_nm" ).append("\n"); 
		query.append("		           FROM mdm_location a" ).append("\n"); 
		query.append("		              , mdm_eq_orz_cht b" ).append("\n"); 
		query.append("		              , mdm_country c" ).append("\n"); 
		query.append("		          WHERE a.scc_cd   = b.scc_cd" ).append("\n"); 
		query.append("		            AND a.cnt_cd   = c.cnt_cd" ).append("\n"); 
		query.append("                    AND b.ecc_cd like c.cnt_cd || '%'" ).append("\n"); 
		query.append("		            AND b.delt_flg ='N'" ).append("\n"); 
		query.append("		        ) B" ).append("\n"); 
		query.append("		  WHERE A.COST_YRMON =  @[cost_yrmon]" ).append("\n"); 
		query.append("		    AND A.POR_ECC_CD     = B.ECC_CD" ).append("\n"); 
		query.append("		GROUP BY B.CNT_CD, B.CNT_NM, A.POR_ECC_CD" ).append("\n"); 
		query.append("		ORDER BY B.CNT_NM, A.POR_ECC_CD" ).append("\n"); 

	}
}