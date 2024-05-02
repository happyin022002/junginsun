/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAODualTypeCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAODualTypeCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지역 Calculation Type과 무관하게 Combined Tariff 적용이 필요한 등록된 화주정보 조회용 쿼리
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAODualTypeCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ctrt_expt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAODualTypeCustomerRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(A.DUL_EXPT_DELT_FLG, 'N', 'Live', 'Deleted') AS DUL_EXPT_DELT_DESC" ).append("\n"); 
		query.append("	   ,A.CUST_CNT_CD || LPAD(A.CUST_SEQ, 6, '0') 			AS CUST_CD" ).append("\n"); 
		query.append("	   ,B.CUST_LGL_ENG_NM 									AS CUST_NM" ).append("\n"); 
		query.append("       ,DMDT_CTRT_EXPT_TP_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.DUL_EXPT_EFF_DT, 'YYYY-MM-DD') 			AS DUL_EXPT_EFF_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.DUL_EXPT_EXP_DT, 'YYYY-MM-DD') 			AS DUL_EXPT_EXP_DT" ).append("\n"); 
		query.append("       ,A.IO_BND_CD" ).append("\n"); 
		query.append("       ,A.CVRG_CNT_CD" ).append("\n"); 
		query.append("       ,A.CVRG_RGN_STE_CD" ).append("\n"); 
		query.append("       ,A.CVRG_LOC_CD" ).append("\n"); 
		query.append("	   ,CASE " ).append("\n"); 
		query.append("			WHEN DMDT_CTRT_EXPT_TP_CD = 'B' THEN" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("					WHEN DMDT_CNTR_TP_CD IS NOT NULL AND DMDT_CGO_TP_CD IS NOT NULL THEN" ).append("\n"); 
		query.append("						DMDT_CNTR_TP_CD || ':' || DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("					ELSE " ).append("\n"); 
		query.append("						''" ).append("\n"); 
		query.append("			    END						" ).append("\n"); 
		query.append("			WHEN DMDT_CTRT_EXPT_TP_CD = 'S' THEN " ).append("\n"); 
		query.append("				DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("		END DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("       ,A.DUL_EXPT_RMK" ).append("\n"); 
		query.append("	   ,CUST_EXPT_SEQ" ).append("\n"); 
		query.append("	   ,C.USR_NM UPD_USR_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("       ,A.UPD_OFC_CD " ).append("\n"); 
		query.append("       ,A.PROP_NO" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  DMT_DUL_TP_EXPT A" ).append("\n"); 
		query.append("       ,MDM_CUSTOMER 	B" ).append("\n"); 
		query.append("       ,COM_USER 		C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE  A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND  A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND  A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${cust_seq} != '')" ).append("\n"); 
		query.append("   AND  A.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${dul_expt_eff_dt} != '')" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("		(A.DUL_EXPT_EFF_DT >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND A.DUL_EXPT_EFF_DT <= TO_DATE(@[dul_expt_exp_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		(A.DUL_EXPT_EFF_DT <= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND NVL(A.DUL_EXPT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${dul_expt_delt_flg} != '')" ).append("\n"); 
		query.append("   AND  A.DUL_EXPT_DELT_FLG = @[dul_expt_delt_flg]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${io_bnd_cd} != '' && ${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("   AND  A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${prop_no} != '')" ).append("\n"); 
		query.append("   AND  A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${dmdt_ctrt_expt_tp_cd} != '' && ${dmdt_ctrt_expt_tp_cd} != 'A')" ).append("\n"); 
		query.append("   AND  A.DMDT_CTRT_EXPT_TP_CD = @[dmdt_ctrt_expt_tp_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${cvrg_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND  A.CVRG_CNT_CD = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${cvrg_rgn_ste_cd} != '')" ).append("\n"); 
		query.append("   AND  A.CVRG_RGN_STE_CD = @[cvrg_rgn_ste_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${cvrg_loc_cd} != '')" ).append("\n"); 
		query.append("   AND A.CVRG_LOC_CD = @[cvrg_loc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND A.UPD_USR_ID = C.USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${dmdt_sc_cntr_cgo_cd_in} == 'Y' && ${dmdt_cntr_cgo_cd_in} == 'N')" ).append("\n"); 
		query.append("   AND  A.DMDT_CNTR_CGO_TP_CD IN (		" ).append("\n"); 
		query.append("		#foreach( $cntr_cgo_tp in ${dmdt_sc_cntr_cgo_tp_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $dmdt_sc_cntr_cgo_tp_list.size()) '$cntr_cgo_tp', #else '$cntr_cgo_tp' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #elseif (${dmdt_sc_cntr_cgo_cd_in} == 'N' && ${dmdt_cntr_cgo_cd_in} == 'Y')" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("			#if(${dmdt_cntr_cgo_cd_size} == '1')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '2')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '3')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '4')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '5')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '6')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '7')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '8')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '9')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd9] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd9])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '10')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd9] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd9])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd10] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd10])" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #elseif (${dmdt_sc_cntr_cgo_cd_in} == 'Y' && ${dmdt_cntr_cgo_cd_in} == 'Y')" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("		(A.DMDT_CNTR_CGO_TP_CD IN (		" ).append("\n"); 
		query.append("		#foreach( $cntr_cgo_tp in ${dmdt_sc_cntr_cgo_tp_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $dmdt_sc_cntr_cgo_tp_list.size()) '$cntr_cgo_tp', #else '$cntr_cgo_tp' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		))" ).append("\n"); 
		query.append("		OR (" ).append("\n"); 
		query.append("			#if(${dmdt_cntr_cgo_cd_size} == '1')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '2')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '3')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '4')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '5')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '6')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '7')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '8')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '9')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd9] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd9])" ).append("\n"); 
		query.append("        	#elseif(${dmdt_cntr_cgo_cd_size} == '10')" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd1] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd1])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd2] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd2])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd3] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd3])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd4] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd4])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd5] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd5])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd6] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd6])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd7] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd7])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd8] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd8])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd9] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd9])" ).append("\n"); 
		query.append("        		OR" ).append("\n"); 
		query.append("        		(A.DMDT_CNTR_TP_CD = @[dmdt_cntr_tp_cd10] AND A.DMDT_CGO_TP_CD = @[dmdt_cgo_tp_cd10])" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CUST_CD ASC" ).append("\n"); 

	}
}