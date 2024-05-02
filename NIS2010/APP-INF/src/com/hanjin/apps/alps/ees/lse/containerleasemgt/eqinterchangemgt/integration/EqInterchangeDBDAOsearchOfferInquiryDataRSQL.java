/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOsearchOfferInquiryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
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

public class EqInterchangeDBDAOsearchOfferInquiryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Offer Inquiry 에 대한 조회
	  * </pre>
	  */
	public EqInterchangeDBDAOsearchOfferInquiryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : EqInterchangeDBDAOsearchOfferInquiryDataRSQL").append("\n"); 
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
		query.append(" LSE_ITCHG_RQST_NO" ).append("\n"); 
		query.append(",LSTM_CD" ).append("\n"); 
		query.append(",LR_VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT VNDR_LGL_ENG_NM  FROM MDM_VENDOR WHERE VNDR_SEQ = A.LR_VNDR_SEQ) vndr_abbr_nm" ).append("\n"); 
		query.append(",FM_LOC_CD " ).append("\n"); 
		query.append(",(select bB.conti_cd" ).append("\n"); 
		query.append("  from MDM_EQ_ORZ_CHT aa, MDM_LOCATION bb" ).append("\n"); 
		query.append("  where  aa.sCC_CD = bb.loc_cd" ).append("\n"); 
		query.append("  AND   aa.ECC_CD = A.FM_LOC_CD" ).append("\n"); 
		query.append("  GROUP by CONTI_CD)" ).append("\n"); 
		query.append("  ||'-'||(select BB.CONTI_CD" ).append("\n"); 
		query.append("  from MDM_EQ_ORZ_CHT aa, MDM_LOCATION bb" ).append("\n"); 
		query.append("  where  aa.sCC_CD = bb.loc_cd" ).append("\n"); 
		query.append("  AND  DECODE ( A.LSE_LOC_GRP_CD ,'RCC' , AA.RCC_CD , 'LCC' , AA.LCC_CD , 'ECC', AA.ECC_CD ,'SCC', AA.SCC_CD ,'') = A.TO_LOC_CD" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 
		query.append("  GROUP by CONTI_CD ) Fm_TO_CONTI " ).append("\n"); 
		query.append(",LSE_LOC_GRP_CD" ).append("\n"); 
		query.append(",TO_LOC_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",LSE_ITCHG_RQST_QTY" ).append("\n"); 
		query.append(",DECODE(NVL(LSE_ITCHG_AUTH_NO,'N'),'N','Y') auth_flg" ).append("\n"); 
		query.append(",NVL((SELECT LSE_ITCHG_AUTH_QTY FROM LSE_EQ_ITCHG WHERE LSE_ITCHG_AUTH_NO = A.LSE_ITCHG_AUTH_NO AND LSE_ITCHG_AUTH_SEQ =A.LSE_ITCHG_AUTH_SEQ),0) lse_itchg_auth_qty" ).append("\n"); 
		query.append(",TTL_SAV_AMT por_save" ).append("\n"); 
		query.append(",PKUP_UT_AMT puc_cost" ).append("\n"); 
		query.append(",TTL_SAV_AMT - (FM_COST_AMT + TO_COST_AMT + PKUP_UT_AMT + ADD_TTL_COST_AMT) save_uc" ).append("\n"); 
		query.append(",LSE_FREE_DYS" ).append("\n"); 
		query.append("FROM LSE_EQ_ITCHG_RQST A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("AND A.CRE_DT BETWEEN TO_DATE(@[period_stdt],'YYYYMMDD') AND TO_DATE(@[period_eddt],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#if(${vndr_seq} !='' )" ).append("\n"); 
		query.append("AND A.LR_VNDR_SEQ =  @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_fm} !='' )" ).append("\n"); 
		query.append("	#if (${loc_fm_tp} == 'RCC' )" ).append("\n"); 
		query.append("	AND A.RCC_CD = @[loc_fm]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${loc_fm_tp}  == 'LCC' )" ).append("\n"); 
		query.append("	AND A.LCC_CD = @[loc_fm]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_to} != '' )" ).append("\n"); 
		query.append("AND A.LSE_LOC_GRP_CD = @[loc_tp]" ).append("\n"); 
		query.append("AND A.TO_LOC_CD =  @[loc_to]" ).append("\n"); 
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