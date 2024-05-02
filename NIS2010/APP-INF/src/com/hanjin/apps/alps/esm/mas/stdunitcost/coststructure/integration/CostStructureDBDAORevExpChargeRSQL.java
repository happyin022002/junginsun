/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostStructureDBDAORevExpChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.02.06 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAORevExpChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Exception Charge 를 조회한다.
	  * </pre>
	  */
	public CostStructureDBDAORevExpChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rdodelflg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAORevExpChargeRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD" ).append("\n"); 
		query.append("     , CNT_CD     " ).append("\n"); 
		query.append("     , TO_CHAR(CRE_DT,'YYYY-MM-DD') as CRE_DT" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT,'YYYY-MM-DD') as UPD_DT" ).append("\n"); 
		query.append("     , DECODE(DELT_FLG, 'N', 'No', 'Y', 'Yes') as DELT_FLG" ).append("\n"); 
		query.append("     , CHG_CD as CHG_CD_ORG" ).append("\n"); 
		query.append("     , CNT_CD as CNT_CD_ORG" ).append("\n"); 
		query.append("     , DELT_FLG as DELT_FLG_ORG" ).append("\n"); 
		query.append("FROM MAS_CHG_EXPT_LIST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_chg_cd} != '')" ).append("\n"); 
		query.append("WHERE CHG_CD = @[f_chg_cd]" ).append("\n"); 
		query.append("	#if (${f_rdodelflg} != '')" ).append("\n"); 
		query.append("		AND   DELT_FLG = @[f_rdodelflg]" ).append("\n"); 
		query.append("	#elseif (${f_rdodelflg} == '')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${f_chg_cd} == '')" ).append("\n"); 
		query.append("	#if (${f_rdodelflg} != '')" ).append("\n"); 
		query.append("		WHERE DELT_FLG = @[f_rdodelflg]" ).append("\n"); 
		query.append("	#elseif (${f_rdodelflg} == '')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CHG_CD" ).append("\n"); 

	}
}