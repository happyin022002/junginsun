/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOSltHirTgtPageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.11.18 민정호
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

public class SettlementProcessDBDAOSltHirTgtPageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 정산 대상 페이지 개수 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOSltHirTgtPageRSQL(){
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
		query.append("FileName : SettlementProcessDBDAOSltHirTgtPageRSQL").append("\n"); 
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
		query.append("CEIL(COUNT(1)/TO_NUMBER(@[pagerows])) AS TOT_PAGE_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("				SELECT" ).append("\n"); 
		query.append("			    	 A.REV_YRMON  " ).append("\n"); 
		query.append("					,A.BSA_QTY" ).append("\n"); 
		query.append("					,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("					,A.ACT_BSA_QTY" ).append("\n"); 
		query.append("					,A.ACT_SLT_PRC" ).append("\n"); 
		query.append("				FROM" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				SELECT J.REV_YRMON" ).append("\n"); 
		query.append("					  ,J.BSA_QTY" ).append("\n"); 
		query.append("					  ,J.BSA_SLT_PRC" ).append("\n"); 
		query.append("					  ,J2.ACT_BSA_QTY" ).append("\n"); 
		query.append("					  ,J2.ACT_SLT_PRC" ).append("\n"); 
		query.append("				FROM ( SELECT J.*" ).append("\n"); 
		query.append("					   FROM JOO_SLT_LIST J" ).append("\n"); 
		query.append("					   WHERE 1=1" ).append("\n"); 
		query.append("					   AND J.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("					   #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("					   AND J.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("					   AND J.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${trd_cd} != '')" ).append("\n"); 
		query.append("					   AND J.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("					   AND J.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${vvd} != '')" ).append("\n"); 
		query.append("					   AND J.VSL_CD 	= substr(@[vvd],1,4) " ).append("\n"); 
		query.append("					   AND J.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("					   AND J.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${acct_cd} != '')" ).append("\n"); 
		query.append("					   AND J.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					 ) J    " ).append("\n"); 
		query.append("					 FULL OUTER JOIN " ).append("\n"); 
		query.append("					 ( SELECT J2.*, S.STL_LOCL_AMT" ).append("\n"); 
		query.append("					   FROM JOO_SLT_TGT J2, JOO_STL_TGT S	--변경" ).append("\n"); 
		query.append("					   WHERE 1=1" ).append("\n"); 
		query.append("					   AND J2.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')					" ).append("\n"); 
		query.append("					   #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("					   AND J2.ACCT_CD LIKE DECODE(@[re_divr_cd],'R','4','E','5')||'%'" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("					   AND J2.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${trd_cd} != '')" ).append("\n"); 
		query.append("					   AND J2.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("					   AND J2.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${vvd} != '')" ).append("\n"); 
		query.append("					   AND J2.VSL_CD 	= substr(@[vvd],1,4) " ).append("\n"); 
		query.append("					   AND J2.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("					   AND J2.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   #if (${acct_cd} != '')" ).append("\n"); 
		query.append("					   AND J2.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("					   AND J2.REV_YRMON = S.REV_YRMON(+)" ).append("\n"); 
		query.append("					   AND J2.REV_YRMON_SEQ = S.REV_YRMON_SEQ(+)	                   	" ).append("\n"); 
		query.append("					 ) J2" ).append("\n"); 
		query.append("				ON ( J.TRD_CD    = J2.TRD_CD" ).append("\n"); 
		query.append("				AND J.CRR_CD    = J2.CRR_CD" ).append("\n"); 
		query.append("				AND J.RLANE_CD  = J2.RLANE_CD" ).append("\n"); 
		query.append("				AND J.RE_DIVR_CD = J2.RE_DIVR_CD " ).append("\n"); 
		query.append("				AND J.VSL_CD     = J2.VSL_CD" ).append("\n"); 
		query.append("				AND J.SKD_VOY_NO = J2.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND J.SKD_DIR_CD = J2.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND J.JO_STL_JB_CD = J2.JO_STL_JB_CD " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			) A" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			#if (${diff} != '')" ).append("\n"); 
		query.append("			AND (NVL(A.BSA_QTY,0) != A.ACT_BSA_QTY OR NVL(A.BSA_SLT_PRC,0) != A.ACT_SLT_PRC)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}