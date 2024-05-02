/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQBalanceDBDAOSearchEQBalance0161ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.31
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2010.05.31 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOSearchEQBalance0161ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * To(DEL) ECC 조회   
	  * </pre>
	  */
	public EQBalanceDBDAOSearchEQBalance0161ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOSearchEQBalance0161ListVORSQL").append("\n"); 
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
		query.append("SELECT NVL(A2.COST_YRMON,@[f_cost_yrmon]) COST_YRMON" ).append("\n"); 
		query.append("      ,A1.RCC_CD" ).append("\n"); 
		query.append("      ,A1.ECC_CD ECC" ).append("\n"); 
		query.append("      ,DECODE(A1.ECC_CD,'',A1.RCC_CD,A1.ECC_CD) ECC_CD" ).append("\n"); 
		query.append("      ,DECODE(A2.DEL_REPO_FLG,'',MIN(NVL(A2.DEL_REPO_FLG, 'N')),A2.DEL_REPO_FLG) DEL_REPO_FLG" ).append("\n"); 
		query.append("      ,DECODE(A1.ECC_CD,'',0,1) SLEVEL		" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT RCC_CD, ECC_CD" ).append("\n"); 
		query.append("          FROM MDM_EQ_ORZ_CHT) A1" ).append("\n"); 
		query.append("       ,(SELECT COST_YRMON" ).append("\n"); 
		query.append("               ,RCC_CD" ).append("\n"); 
		query.append("               ,ECC_CD" ).append("\n"); 
		query.append("               ,DEL_REPO_FLG" ).append("\n"); 
		query.append("          FROM COA_CNTR_REPO_ROUT_ECC" ).append("\n"); 
		query.append("         WHERE CNTR_TPSZ_CD = DECODE(SUBSTR(@[f_cntr_tpsz_cd], 1, 1), 'D', 'D', REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R'))) A2" ).append("\n"); 
		query.append("  WHERE A2.COST_YRMON(+) = @[f_cost_yrmon]" ).append("\n"); 
		query.append("    AND A1.RCC_CD = A2.RCC_CD(+)" ).append("\n"); 
		query.append("    AND A1.ECC_CD = A2.ECC_CD(+)		" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS(" ).append("\n"); 
		query.append("         (A2.COST_YRMON,A1.RCC_CD,A1.ECC_CD,A2.DEL_REPO_FLG)" ).append("\n"); 
		query.append("        ,(A1.RCC_CD))" ).append("\n"); 
		query.append("ORDER BY RCC_CD,SLEVEL,ECC_CD" ).append("\n"); 

	}
}