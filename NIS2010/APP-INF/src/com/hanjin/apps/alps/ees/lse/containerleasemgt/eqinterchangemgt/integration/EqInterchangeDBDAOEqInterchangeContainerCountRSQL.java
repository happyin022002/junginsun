/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOEqInterchangeContainerCountRSQL.java
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

public class EqInterchangeDBDAOEqInterchangeContainerCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ interchange pick-up/off-hire 전체건수를 조회합니다.
	  * </pre>
	  */
	public EqInterchangeDBDAOEqInterchangeContainerCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_free_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOEqInterchangeContainerCountRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) AS TOTAL_CNT" ).append("\n"); 
		query.append("FROM    MST_CONTAINER A ," ).append("\n"); 
		query.append("        MST_CNTR_STS_HIS B ," ).append("\n"); 
		query.append("        LSE_AGREEMENT C ," ).append("\n"); 
		query.append("        MDM_VENDOR D ," ).append("\n"); 
		query.append("        MST_CNTR_STS_HIS E" ).append("\n"); 
		query.append("WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND     B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     B.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND     C.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("--		AND     A.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("AND     A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '(SB|MU)O' || ${cntr_sts_cd} == 'SBO' || ${cntr_sts_cd} == 'MUO')" ).append("\n"); 
		query.append("AND     B.CNTR_NO = E.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     B.CNTR_STS_SEQ = E.PRNR_STS_SEQ(+)" ).append("\n"); 
		query.append("	#if (${lst_sts_flg} == '01')" ).append("\n"); 
		query.append("AND     A.LST_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_sts_cd} == '(SB|MU)O' )" ).append("\n"); 
		query.append("AND		B.CNTR_STS_CD IN('SBO','MUO')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("AND		B.CNTR_STS_CD = @[cntr_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${loc_tp} == '0' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND     B.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '1' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND     SUBSTR(B.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '2' && ${loc_cd} != '')" ).append("\n"); 
		query.append("           #if (${ttl_flag} == 'G.Total')" ).append("\n"); 
		query.append("	        AND     B.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("	        AND     B.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '3' && ${loc_cd} != '')" ).append("\n"); 
		query.append("           #if (${ttl_flag} == 'G.Total')" ).append("\n"); 
		query.append("	        AND     B.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("	        AND     B.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '4' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND     B.YD_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '5' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND     SUBSTR(B.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${str_evnt_dt} != '')" ).append("\n"); 
		query.append("AND     B.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[str_evnt_dt],'YYYYMMDD')  " ).append("\n"); 
		query.append("AND 	TO_DATE(@[end_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("AND     B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     B.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_full_flg} != '')" ).append("\n"); 
		query.append("AND     B.CNTR_FULL_FLG = @[cntr_full_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     B.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("AND     B.CNTR_STS_SEQ = E.PRNR_STS_SEQ" ).append("\n"); 
		query.append("	#if (${lst_sts_flg} == '01')" ).append("\n"); 
		query.append("AND     A.LST_STS_SEQ = E.CNTR_STS_SEQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_sts_cd} == '(SB|MU)I' )" ).append("\n"); 
		query.append("AND		E.CNTR_STS_CD IN('SBI','MUI')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("AND		E.CNTR_STS_CD = @[cntr_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${loc_tp} == '0' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND     E.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '1' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND     SUBSTR(E.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '2' && ${loc_cd} != '')" ).append("\n"); 
		query.append("      #if (${ttl_flag} == 'G.Total')" ).append("\n"); 
		query.append("        AND     E.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        AND     E.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '3' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND     E.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '4' && ${loc_cd} != '')" ).append("\n"); 
		query.append("      #if (${ttl_flag} == 'G.Total')" ).append("\n"); 
		query.append("        AND     E.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        AND     E.YD_CD = @[loc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '5' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND     SUBSTR(E.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${str_evnt_dt} != '')" ).append("\n"); 
		query.append("AND     E.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[str_evnt_dt],'YYYYMMDD')  " ).append("\n"); 
		query.append("AND 	TO_DATE(@[end_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("AND     E.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     E.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_full_flg} != '')" ).append("\n"); 
		query.append("AND     E.CNTR_FULL_FLG = @[cntr_full_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if (${lstm_soc_tp} == '03')" ).append("\n"); 
		query.append("AND     A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("#elseif (${lstm_soc_tp} == '02')" ).append("\n"); 
		query.append("AND     A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND     C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${onh_free_dys} != '')" ).append("\n"); 
		query.append("        AND ROUND(NVL(E.CNTR_STS_EVNT_DT, SYSDATE) - B.CNTR_STS_EVNT_DT) >= @[onh_free_dys]" ).append("\n"); 
		query.append("#elseif (${use_day} == '1')" ).append("\n"); 
		query.append("        AND ROUND(NVL(E.CNTR_STS_EVNT_DT, SYSDATE) - B.CNTR_STS_EVNT_DT) > B.RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("AND     A.LSTM_CD IN (" ).append("\n"); 
		query.append("   	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("   		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("   			'$key'," ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			'$key'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("   	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("   		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("   			'$key'," ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			'$key'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}