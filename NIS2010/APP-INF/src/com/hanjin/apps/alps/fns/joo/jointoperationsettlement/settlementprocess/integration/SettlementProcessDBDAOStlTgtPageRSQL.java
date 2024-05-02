/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOStlTgtPageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.09.07 민정호
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

public class SettlementProcessDBDAOStlTgtPageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Target Page 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOStlTgtPageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOStlTgtPageRSQL").append("\n"); 
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
		query.append("WITH STL_TGT AS ( " ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         J.REV_YRMON" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("			SELECT * FROM JOO_SLT_TGT J" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("		    AND J.JO_FSH_FLG = '1'" ).append("\n"); 
		query.append("		    AND J.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		    #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("		    AND J.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("		    AND J.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("		    AND J.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		    AND J.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${vvd} != '')" ).append("\n"); 
		query.append("		    AND J.VSL_CD 	= substr(@[vvd],1,4) " ).append("\n"); 
		query.append("		    AND J.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("		    AND J.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${acct_cd} != '')" ).append("\n"); 
		query.append("		    AND J.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		 ) J" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         J.REV_YRMON" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT LEVEL AS LEV" ).append("\n"); 
		query.append("        FROM DUAL CONNECT BY LEVEL <= 3" ).append("\n"); 
		query.append("    ) L, " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("			SELECT * FROM JOO_LODG_TGT J" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("		    AND J.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		    #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("		    AND J.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("		    AND J.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("		    AND J.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		    AND J.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${vvd} != '')" ).append("\n"); 
		query.append("		    AND J.VSL_CD 	= substr(@[vvd],1,4) " ).append("\n"); 
		query.append("		    AND J.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("		    AND J.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${acct_cd} != '')" ).append("\n"); 
		query.append("		    AND J.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("		    #end	" ).append("\n"); 
		query.append("	) J" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT CEIL(COUNT(1)/TO_NUMBER(@[pagerows])) AS TOT_PAGE_CNT" ).append("\n"); 
		query.append("FROM STL_TGT" ).append("\n"); 

	}
}