/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOFreightChargeSummaryReportInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.01
*@LastModifier : jklim
*@LastVersion : 1.0
* 2013.10.01 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOFreightChargeSummaryReportInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Freight & Charge 요약 리포트 조회한다
	  * </pre>
	  */
	public PerformanceReportDBDAOFreightChargeSummaryReportInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOFreightChargeSummaryReportInVORSQL").append("\n"); 
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
		query.append("SELECT /*+ RULE */  " ).append("\n"); 
		query.append("#if (${sorting_priority} != '')  " ).append("\n"); 
		query.append("		--DECODE(CHARGE.FRT_CHG_TP_CD,'TF','Trunk FRT','IH','Inland CHRG','CY','CY/CFS CHRG', 'OP','Outport CHRG', 'SA','Sales CHRG','OT','Others',' ') || '|' ||  ${sorting_priority} FRT_CHG_TP_CD" ).append("\n"); 
		query.append("		CHARGE.FRT_CHG_TP_CD  || '|' ||  ${sorting_priority} FRT_CHG_TP_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		CHARGE.FRT_CHG_TP_CD" ).append("\n"); 
		query.append("		--DECODE(CHARGE.FRT_CHG_TP_CD,'TF','Trunk FRT','IH','Inland CHRG','CY','CY/CFS CHRG', 'OP','Outport CHRG', 'SA','Sales CHRG','OT','Others',' ') FRT_CHG_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	   'Freight Charge : '  || DECODE(CHARGE.FRT_CHG_TP_CD,'TF','Trunk FRT','IH','Inland CHRG','CY','CY/CFS CHRG', 'OP','Outport CHRG', 'SA','Sales CHRG','OT','Others',' ') PER_GROUP" ).append("\n"); 
		query.append(",      BKG_RATE.RAT_UT_CD  PER" ).append("\n"); 
		query.append(",      NVL(BKG_RATE.CHG_CD,' ')    CHG_CD                   " ).append("\n"); 
		query.append(",       SUM((NVL(BKG_RATE.CHG_AMT,0))/NVL(GL_MON_XCH_RT.USD_LOCL_XCH_RT,1)) BRATE_PREPAID " ).append("\n"); 
		query.append(",      NVL(CHARGE.CHG_NM,' ')   CHG_NM" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sorting_priority} != '')  " ).append("\n"); 
		query.append(",	    ${sorting_priority} SORTING_PRIORITY" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	   '' SORTING_PRIORITY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",      '' BKG_NO" ).append("\n"); 
		query.append(",      '' BL_NO" ).append("\n"); 
		query.append(",      '' SLAN_CD" ).append("\n"); 
		query.append(",      '' POR_CD" ).append("\n"); 
		query.append(",      '' DEL_CD" ).append("\n"); 
		query.append(",      '' VVD_CD" ).append("\n"); 
		query.append(",      '' POL_CD" ).append("\n"); 
		query.append(",      '' POD_CD" ).append("\n"); 
		query.append(",      '' BKG_OFC_CD" ).append("\n"); 
		query.append(",      '' OB_SLS_OFC_CD" ).append("\n"); 
		query.append(",      '' CUST_TP_CD" ).append("\n"); 
		query.append(",      '' CUST_CNT_CD" ).append("\n"); 
		query.append(",      '' CUST_SEQ" ).append("\n"); 
		query.append(",      '' DCGO_FLG" ).append("\n"); 
		query.append(",      '' RD_CGO_FLG" ).append("\n"); 
		query.append(",      '' AWK_CGO_FLG" ).append("\n"); 
		query.append(",      '' BB_CGO_FLG" ).append("\n"); 
		query.append(",      '' RC_FLG" ).append("\n"); 
		query.append(",      '' RAT_UT_CD" ).append("\n"); 
		query.append(",      '' REP_CMDT_CD" ).append("\n"); 
		query.append(",	   '' CMDT_CD" ).append("\n"); 
		query.append("--,      '' FRT_CHG_TP_CD" ).append("\n"); 
		query.append(",	   '' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      '' CHG_REV_TP_CD" ).append("\n"); 
		query.append(",	   '' PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",	   '' PST_RLY_PORT_CD" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("FROM  BKG_CHG_RT BKG_RATE" ).append("\n"); 
		query.append(",     MDM_CHARGE CHARGE" ).append("\n"); 
		query.append(",     GL_MON_XCH_RT" ).append("\n"); 
		query.append(",     BKG_BL_OUTBOUND_V VB" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("WHERE BKG_RATE.CHG_CD = CHARGE.CHG_CD " ).append("\n"); 
		query.append("AND   BKG_RATE.BKG_NO(+) = VB.BKG_NO " ).append("\n"); 
		query.append("AND   TO_CHAR(BKG_RATE.CRE_DT,'YYYYMM') = GL_MON_XCH_RT.ACCT_XCH_RT_YRMON(+)" ).append("\n"); 
		query.append("AND   BKG_RATE.CURR_CD = GL_MON_XCH_RT.CURR_CD(+)" ).append("\n"); 
		query.append("AND   GL_MON_XCH_RT.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND   VB.Split_Flg  = 'N'  --VB.SPLIT_RSN_CD  IS NULL " ).append("\n"); 
		query.append("AND   VB.BKG_STS_CD != 'X'  " ).append("\n"); 
		query.append("AND   BKG_RATE.FRT_INCL_XCLD_DIV_CD   = 'N'" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND   VB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("AND   VB.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("AND   VB.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("AND   VB.POR_CD     = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("AND   VB.DEL_CD  =   @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND   VB.KEY_VSL_CD =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND   VB.KEY_SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND   VB.KEY_SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND   VB.KEY_POL_LOC     = @[pol_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_rly_port_cd} != '') " ).append("\n"); 
		query.append("AND   VB.KEY_POL_LOC     = VB.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND   VB.KEY_POD_LOC     = @[pod_cd]" ).append("\n"); 
		query.append("#if (${pst_rly_port_cd} != '') " ).append("\n"); 
		query.append("AND   VB.KEY_POD_LOC   = VB.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("AND   VB.BKG_OFC_CD   = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("AND   VB.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.'SHPR'" ).append("\n"); 
		query.append("#if (${cust_tp_cd} == 'S') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd] " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.SHIPPER LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--2.'CNEE'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'C') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.CONSIGNEE,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.CONSIGNEE LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--3.'NTFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'N') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.NTFY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--4.'ANFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'A') " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.ANTY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("--5.'FWDR'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND	  VB.FFDR LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--6.'�좏깮�섏� �딆븯�꾨븣..'" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} == '') " ).append("\n"); 
		query.append("AND	  	(SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd] OR	" ).append("\n"); 
		query.append("		SUBSTR(VB.CONSIGNEE,1,2)= @[cust_cnt_cd] OR" ).append("\n"); 
		query.append("		SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd] OR" ).append("\n"); 
		query.append("		SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd] OR " ).append("\n"); 
		query.append("		SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd])" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '' && ${cust_seq} != '') " ).append("\n"); 
		query.append("AND		(VB.SHIPPER = @[cust_cnt_cd] || @[cust_seq] OR	" ).append("\n"); 
		query.append("		VB.CONSIGNEE = @[cust_cnt_cd] || @[cust_seq] OR" ).append("\n"); 
		query.append("		VB.NTFY = @[cust_cnt_cd]|| @[cust_seq] OR" ).append("\n"); 
		query.append("		VB.ANTY = @[cust_cnt_cd]|| @[cust_seq] OR " ).append("\n"); 
		query.append("		VB.FFDR = @[cust_cnt_cd]|| @[cust_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("#if(${dcgo_flg} != '' || ${rd_cgo_flg} != ''|| ${rc_flg} != ''|| ${awk_cgo_flg} != '' || ${bb_cgo_flg} != '')" ).append("\n"); 
		query.append("AND ( 1=2" ).append("\n"); 
		query.append("#if (${dcgo_flg} != '') " ).append("\n"); 
		query.append("OR VB.DCGO_FLG = @[dcgo_flg]	--Special DG   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rd_cgo_flg} != '') " ).append("\n"); 
		query.append("OR VB.RD_CGO_FLG = @[rd_cgo_flg]	--Special RD    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rc_flg} != '') " ).append("\n"); 
		query.append("OR VB.RC_FLG = @[rc_flg]		--Special RF       " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} != '') " ).append("\n"); 
		query.append("OR VB.AWK_CGO_FLG = @[awk_cgo_flg]	--Special AK          " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bb_cgo_flg} != '') " ).append("\n"); 
		query.append("OR VB.BB_CGO_FLG = @[bb_cgo_flg]	--Special BB             " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_cmdt_cd} != '') " ).append("\n"); 
		query.append("AND VB.REP_CMDT_CD  LIKE @[rep_cmdt_cd] || '%' 	--Commodity REP" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("AND VB.CMDT_CD LIKE @[cmdt_cd] || '%' 	--Commodity" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("AND BKG_RATE.RAT_UT_CD  = @[cntr_tpsz_cd]   --E/Q Type/Size(cntr_tpsz_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frt_chg_tp_cd} != '') " ).append("\n"); 
		query.append("AND CHARGE.FRT_CHG_TP_CD  = @[frt_chg_tp_cd]	--Freight Charge Type" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chg_rev_tp_cd} != '') " ).append("\n"); 
		query.append("AND CHARGE.CHG_REV_TP_CD = @[chg_rev_tp_cd]	--Revenue Class" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("--DECODE(CHARGE.FRT_CHG_TP_CD,'TF','Trunk FRT','IH','Inland CHRG','CY','CY/CFS CHRG', 'OP','Outport CHRG', 'SA','Sales CHRG','OT','Others',' ')" ).append("\n"); 
		query.append("		CHARGE.FRT_CHG_TP_CD" ).append("\n"); 
		query.append(",     BKG_RATE.RAT_UT_CD " ).append("\n"); 
		query.append(",     BKG_RATE.CHG_CD" ).append("\n"); 
		query.append(",     CHARGE.CHG_NM " ).append("\n"); 
		query.append("#if (${sorting_priority} != '') " ).append("\n"); 
		query.append(",  ${sorting_priority}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("--DECODE(CHARGE.FRT_CHG_TP_CD,'TF','Trunk FRT','IH','Inland CHRG','CY','CY/CFS CHRG', 'OP','Outport CHRG', 'SA','Sales CHRG','OT','Others',' ')" ).append("\n"); 
		query.append("	CHARGE.FRT_CHG_TP_CD" ).append("\n"); 
		query.append("#if (${sorting_priority} != '') " ).append("\n"); 
		query.append(",  ${sorting_priority}" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(",      BKG_RATE.RAT_UT_CD" ).append("\n"); 
		query.append(",     BKG_RATE.CHG_CD" ).append("\n"); 

	}
}