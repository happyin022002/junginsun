/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOSltHirCarrierStlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.05.25 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOSltHirCarrierStlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SltHirCarrierStl
	  * </pre>
	  */
	public SettlementProcessDBDAOSltHirCarrierStlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOSltHirCarrierStlRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("A.CRR_CD AS JO_CRR_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.REV_YRMON, A.ACCT_CD, A.TRD_CD, A.RLANE_CD, A.CRR_CD FROM JOO_LODG_TGT A" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("    #if (${rev_yrmon_fr} != '')" ).append("\n"); 
		query.append("    AND    A.REV_YRMON >= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rev_yrmon_to} != '')" ).append("\n"); 
		query.append("    AND    A.REV_YRMON <= REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if(${re_divr_cd} != '')" ).append("\n"); 
		query.append("	AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${jo_stl_itm_cd} =='OUS')" ).append("\n"); 
		query.append("	AND 1=1" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND 1!=1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    UNION" ).append("\n"); 
		query.append("    SELECT A.REV_YRMON, A.ACCT_CD, A.TRD_CD, A.RLANE_CD, A.CRR_CD FROM JOO_SLT_TGT A" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("    #if (${rev_yrmon_fr} != '')" ).append("\n"); 
		query.append("    AND    A.REV_YRMON >= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rev_yrmon_to} != '')" ).append("\n"); 
		query.append("    AND    A.REV_YRMON <= REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${re_divr_cd} != '')" ).append("\n"); 
		query.append("	AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if(${jo_stl_itm_cd} =='S/H')" ).append("\n"); 
		query.append("	AND 1=1" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND 1!=1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    UNION		-- Jo Settlement Target에서 Sublet한 값을 Jo Settlement Target Revenue항목에서도 보이게" ).append("\n"); 
		query.append("    SELECT A.REV_YRMON, A.ACCT_CD, A.TRD_CD, A.RLANE_CD, A.CRR_CD FROM JOO_STL_TGT A" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("    #if (${rev_yrmon_fr} != '')" ).append("\n"); 
		query.append("    AND    A.REV_YRMON >= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rev_yrmon_to} != '')" ).append("\n"); 
		query.append("    AND    A.REV_YRMON <= REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${re_divr_cd} != '')" ).append("\n"); 
		query.append("	AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND    A.REV_SHW_FLG = 'S'" ).append("\n"); 
		query.append(") A, JOO_CARRIER B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if(${re_divr_cd} == 'E')" ).append("\n"); 
		query.append("AND    A.CRR_CD     = B.JO_CRR_CD(+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD   = B.RLANE_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    A.CRR_CD     = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP  BY A.CRR_CD" ).append("\n"); 
		query.append("ORDER  BY A.CRR_CD" ).append("\n"); 

	}
}