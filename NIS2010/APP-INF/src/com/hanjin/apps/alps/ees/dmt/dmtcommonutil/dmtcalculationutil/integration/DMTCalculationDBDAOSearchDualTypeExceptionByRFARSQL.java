/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchDualTypeExceptionByRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchDualTypeExceptionByRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDualTypeExceptionByRFA
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchDualTypeExceptionByRFARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("efft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchDualTypeExceptionByRFARSQL").append("\n"); 
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
		query.append("SELECT     'Y'    DUALFLAG" ).append("\n"); 
		query.append("          FROM    DMT_DUL_TP_EXPT" ).append("\n"); 
		query.append("         WHERE    CUST_CNT_CD     =   @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("           AND    CUST_SEQ        =   @[act_cust_seq]" ).append("\n"); 
		query.append("           AND    DUL_EXPT_DELT_FLG   =   'N'" ).append("\n"); 
		query.append("		   AND    TO_DATE(@[efft_dt],'YYYYMMDD') BETWEEN DUL_EXPT_EFF_DT AND NVL(DUL_EXPT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD'))" ).append("\n"); 
		query.append("           AND    NVL(DMDT_CNTR_TP_CD, @[cntr_tp] ) =   @[cntr_tp]" ).append("\n"); 
		query.append("           AND    NVL(DMDT_CGO_TP_CD,  @[cgo_tp])   =   @[cgo_tp]" ).append("\n"); 
		query.append("           AND    IO_BND_CD       =   @[io_bnd_cd]" ).append("\n"); 
		query.append("           AND    DMDT_CTRT_EXPT_TP_CD    =   'B'" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("	#if (${dmdt_trf_cd} == 'DMIF') " ).append("\n"); 
		query.append("		   AND (   CVRG_CNT_CD 		= @[yrd_cnt_cd]         	OR CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("		#if (${yrd_cnt_cd} == 'US' || ${yrd_cnt_cd} == 'CA') 		   " ).append("\n"); 
		query.append("		   AND (   CVRG_RGN_STE_CD 	= @[yrd_ste_cd]         	OR CVRG_RGN_STE_CD = ' ')" ).append("\n"); 
		query.append("		#else   " ).append("\n"); 
		query.append("		   AND (   CVRG_RGN_STE_CD 	= @[yrd_rgn_cd]         	OR CVRG_RGN_STE_CD = ' ')" ).append("\n"); 
		query.append("		#end   " ).append("\n"); 
		query.append("		   AND (   CVRG_LOC_CD 		= @[yrd_loc_cd]         	OR CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("	#elseif (${dmdt_trf_cd} == 'DTIC' || ${dmdt_trf_cd} == 'CTIC') " ).append("\n"); 
		query.append("		   AND (   CVRG_CNT_CD 		= @[del_cnt_cd]         	OR CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("		#if (${del_cnt_cd} == 'US' || ${del_cnt_cd} == 'CA') 	   " ).append("\n"); 
		query.append("		   AND (   CVRG_RGN_STE_CD 	= @[del_ste_cd]         	OR CVRG_RGN_STE_CD = ' ')" ).append("\n"); 
		query.append("		#else     " ).append("\n"); 
		query.append("		   AND (   CVRG_RGN_STE_CD 	= @[del_rgn_cd]         	OR CVRG_RGN_STE_CD = ' ')" ).append("\n"); 
		query.append("		#end     		   " ).append("\n"); 
		query.append("		   AND (   CVRG_LOC_CD 		= @[del_loc_cd]         	OR CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append(" 	#if (${dmdt_trf_cd} == 'DMOF') " ).append("\n"); 
		query.append("		   AND (   CVRG_CNT_CD 		= @[yrd_cnt_cd]         	OR CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("		#if (${yrd_cnt_cd} == 'US' || ${yrd_cnt_cd} == 'CA') " ).append("\n"); 
		query.append("		   AND (   CVRG_RGN_STE_CD 	= @[yrd_ste_cd]         	OR CVRG_RGN_STE_CD = ' ')" ).append("\n"); 
		query.append("		#else     " ).append("\n"); 
		query.append("		   AND (   CVRG_RGN_STE_CD 	= @[yrd_rgn_cd]         	OR CVRG_RGN_STE_CD = ' ')" ).append("\n"); 
		query.append("		#end    " ).append("\n"); 
		query.append("		   AND (   CVRG_LOC_CD 		= @[yrd_loc_cd]         	OR CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("	#elseif (${dmdt_trf_cd} == 'DTOC' || ${dmdt_trf_cd} == 'CTOC') " ).append("\n"); 
		query.append("		   AND (   CVRG_CNT_CD = @[por_cnt_cd]         			OR CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("		#if (${por_cnt_cd} == 'US' || ${por_cnt_cd} == 'CA') 		   " ).append("\n"); 
		query.append("		   AND (   CVRG_RGN_STE_CD 	= @[por_ste_cd]         	OR CVRG_RGN_STE_CD = ' ')" ).append("\n"); 
		query.append("		#else		   " ).append("\n"); 
		query.append("		   AND (   CVRG_RGN_STE_CD 	= @[por_rgn_cd]         	OR CVRG_RGN_STE_CD = ' ')" ).append("\n"); 
		query.append("		#end  		   " ).append("\n"); 
		query.append("		   AND (   CVRG_LOC_CD 		= @[por_loc_cd]         	OR CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   AND ( PROP_NO = ( SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = @[rfa_no] ) OR PROP_NO IS NULL )" ).append("\n"); 

	}
}