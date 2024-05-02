/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchExpenseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.21 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchExpenseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용코드 기준 정보
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExpenseInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select A.GEN_EXPN_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_AGRE_FLG" ).append("\n"); 
		query.append(",A.ENG_ABBR_NM" ).append("\n"); 
		query.append(",A.ENG_FULL_NM" ).append("\n"); 
		query.append(",A.KRN_ABBR_NM" ).append("\n"); 
		query.append(",A.KRN_FULL_NM" ).append("\n"); 
		query.append(",A.GEN_EXPN_ACCT_EXPT_FLG" ).append("\n"); 
		query.append(",A.SALY_FLG" ).append("\n"); 
		query.append(",A.GEN_EXPN_SLS_DIV_CD" ).append("\n"); 
		query.append(",A.GEN_EXPN_GRP_LVL" ).append("\n"); 
		query.append(",A.PRNT_GEN_EXPN_CD" ).append("\n"); 
		query.append(",A.TIC_CD" ).append("\n"); 
		query.append(",A.DELT_FLG" ).append("\n"); 
		query.append(",B.KRN_ABBR_NM  PRNT_KRN_ABBR_NM" ).append("\n"); 
		query.append(",B.ENG_ABBR_NM PRNT_ENG_ABBR_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT ,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("from GEM_EXPENSE A" ).append("\n"); 
		query.append(",GEM_EXPENSE B" ).append("\n"); 
		query.append("where A.GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("and A.PRNT_GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("and A.DELT_FLG =@[delt_flg]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExpenseInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}