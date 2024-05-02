/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOsearchEqInterchangeUpdateDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOsearchEqInterchangeUpdateDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ InegerChage Update & Cancel 화면에 대한 조회를 합니다.
	  * </pre>
	  */
	public EqInterchangeDBDAOsearchEqInterchangeUpdateDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOsearchEqInterchangeUpdateDataRSQL").append("\n"); 
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
		query.append("SELECT A.LSE_ITCHG_RQST_NO " ).append("\n"); 
		query.append("      ,A.LSTM_CD" ).append("\n"); 
		query.append("      ,B.AGMT_SEQ" ).append("\n"); 
		query.append("      ,A.LR_VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT VNDR_LGL_ENG_NM  FROM MDM_VENDOR WHERE VNDR_SEQ = A.LR_VNDR_SEQ) vndr_abbr_nm" ).append("\n"); 
		query.append("      ,A.FM_LOC_CD" ).append("\n"); 
		query.append("      ,A.TO_LOC_CD " ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      ,B.LSE_ITCHG_AUTH_QTY" ).append("\n"); 
		query.append("      ,B.LSE_FREE_DYS" ).append("\n"); 
		query.append("      ,B.PKUP_UT_AMT" ).append("\n"); 
		query.append("      ,B.PKUP_CR_AMT" ).append("\n"); 
		query.append("      ,B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("      ,B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("      ,A.LSE_ITCHG_RQST_SEQ" ).append("\n"); 
		query.append("FROM LSE_EQ_ITCHG_RQST A, LSE_EQ_ITCHG B" ).append("\n"); 
		query.append("WHERE A.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("AND A.LSE_ITCHG_AUTH_SEQ  = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("AND B.LSE_ITCHG_AUTH_NO = @[auth_no]" ).append("\n"); 
		query.append("AND A.LCC_CD  = @[loc_fm]" ).append("\n"); 
		query.append("AND A.LR_VNDR_SEQ =  @[vndr_seq]" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${loc_to} != '' )" ).append("\n"); 
		query.append("AND A.LSE_LOC_GRP_CD =@[loc_tp]" ).append("\n"); 
		query.append("AND A.TO_LOC_CD = @[loc_to]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_seq} != '')" ).append("\n"); 
		query.append("        AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}