/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchSeaInvtTotalByCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchSeaInvtTotalByCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sea CNTR list 갯수
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchSeaInvtTotalByCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("plst_flr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdt_ext_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stay_days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("route_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2_payld_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_cntr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_tp_cd_h",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration ").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchSeaInvtTotalByCntrRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("    COUNT(*) AS TOTAL_CNT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  /*+ ORDERED USE_NL(A B C) */" ).append("\n"); 
		query.append("         A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,DECODE(@[route_tp_cd],'B',B.POL_NOD_CD,A.CRNT_YD_CD) POL_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("        ,NVL(DECODE(@[route_tp_cd],'B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX') POD_CD" ).append("\n"); 
		query.append("        ,B.DEL_CD" ).append("\n"); 
		query.append("        ,(TRUNC(SYSDATE) - TRUNC(CNMV_DT) + 1) STAY_DAYS" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,B.BL_NO" ).append("\n"); 
		query.append("        ,A.DMG_FLG" ).append("\n"); 
		query.append("		--,MST_COMMON_PKG.MST_RU_LBL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("		,MST_COMMON_PKG.MST_RU_TP_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("        ,MST_COMMON_PKG.MST_RU_VAL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_DESC" ).append("\n"); 
		query.append("		,A.CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("		,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("        ,NVL(A.CNTR_HNGR_BAR_ATCH_KNT,0) CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("        ,A.DISP_FLG" ).append("\n"); 
		query.append("        ,A.IMDT_EXT_FLG" ).append("\n"); 
		query.append("		,B.CMDT_CD" ).append("\n"); 
		query.append("		,(SELECT NVL(VNDR_ABBR_NM, VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("         FROM MDM_VENDOR " ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.RF_MKR_SEQ ELSE D.RF_MKR_SEQ END" ).append("\n"); 
		query.append("        )AS RF_MKR_SEQ" ).append("\n"); 
		query.append("        ,CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.RF_MDL_NM ELSE D.RF_MDL_NM END AS RF_MDL_NM" ).append("\n"); 
		query.append("        ,A.RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("        ,(SELECT CID.INTG_CD_VAL_DP_DESC ||' (' ||CID.INTG_CD_VAL_DESC || ')' AS RF_TP_CD " ).append("\n"); 
		query.append("            FROM COM_INTG_CD_DTL CID " ).append("\n"); 
		query.append("           WHERE 1=1 " ).append("\n"); 
		query.append("             AND CID.INTG_CD_VAL_CTNT = A.RF_TP_CD " ).append("\n"); 
		query.append("             AND CID.INTG_CD_ID = 'CD01085') AS RF_TP_CD" ).append("\n"); 
		query.append("		,MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("        ,MST_COMMON_PKG.MST_VNDR_SEQ_CONV_FNC(A.VNDR_SEQ) AS LESSOR_CD" ).append("\n"); 
		query.append("        ,TRS_COMMON_PKG.GET_VNDR_ABBR_NM_FNC(A.VNDR_SEQ) AS LESSOR" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A" ).append("\n"); 
		query.append("        ,BKG_BOOKING B" ).append("\n"); 
		query.append("        ,BKG_VVD C" ).append("\n"); 
		query.append("		,MST_CNTR_LOT D" ).append("\n"); 
		query.append("    WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("	--AND   SUBSTR(A.CNTR_NO,0,10) BETWEEN C.LOT_CNTR_PFX_CD(+)||C.FM_SER_NO(+) AND C.LOT_CNTR_PFX_CD(+)||C.TO_SER_NO(+)" ).append("\n"); 
		query.append("	AND	A.LOT_PLN_YR    = D.LOT_CNTR_PFX_CD(+)" ).append("\n"); 
		query.append("  	AND A.LOT_LOC_CD    = D.FM_SER_NO(+)" ).append("\n"); 
		query.append("  	AND A.CNTR_TPSZ_CD  = D.LOT_CNTR_PFX_CD(+)" ).append("\n"); 
		query.append("  	AND A.LOT_SEQ       = D.TO_SER_NO(+)" ).append("\n"); 
		query.append("    AND A.CNMV_STS_CD='VL'" ).append("\n"); 
		query.append("    AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("    AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("    AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND 'Y'			 = D.OWN_CNTR_FLG(+)" ).append("\n"); 
		query.append("    #if (${slan_cd} != '' && ${slan_cd} != 'XXX')" ).append("\n"); 
		query.append("    	AND C.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${imdt_ext_flg} != '')" ).append("\n"); 
		query.append("        AND A.IMDT_EXT_FLG =@[imdt_ext_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${plst_flr_flg} != '')" ).append("\n"); 
		query.append("        AND A.PLST_FLR_FLG =@[plst_flr_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if ( ${slan_cd} =='XXX' ) --vvd정보가 없을시 " ).append("\n"); 
		query.append("        AND UPPER(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x')) ='XXXX0000X'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${vvd1} != '' || ${vvd2} != '' || ${vvd3} != '') " ).append("\n"); 
		query.append("        #if (${vvd1} == 'XXXX0000' || ${vvd2} != 'XXXX0000' || ${vvd3} != 'XXXX0000') " ).append("\n"); 
		query.append("            AND UPPER(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||A.SKD_DIR_CD) IN ( @[vvd1],@[vvd2],@[vvd3])" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND (A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD) IN ( (SUBSTR(@[vvd1],1,4),SUBSTR(@[vvd1],5,4),SUBSTR(@[vvd1],9,1)), (SUBSTR(@[vvd2],1,4),SUBSTR(@[vvd2],5,4),SUBSTR(@[vvd2],9,1)), (SUBSTR(@[vvd3],1,4),SUBSTR(@[vvd3],5,4),SUBSTR(@[vvd3],9,1)) )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${cntr_no} != '')" ).append("\n"); 
		query.append("    	AND SUBSTR(A.CNTR_NO,0,4) = @[cntr_no]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("        AND DECODE(@[route_tp_cd],'B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)) LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    #if (${pod_cd} != '')" ).append("\n"); 
		query.append("        AND NVL(DECODE(@[route_tp_cd],'B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX') LIKE DECODE(@[pod_cd], 'CHECK', 'XXXXX',@[pod_cd] )||'%'" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    #if (${del_cd} != '')" ).append("\n"); 
		query.append("        AND B.DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	#if (${stay_days} != '')" ).append("\n"); 
		query.append("		AND TRUNC(SYSDATE) - TRUNC(CNMV_DT) + 1 > = @[stay_days]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${full_flg} != '')" ).append("\n"); 
		query.append("    	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("    	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_cntr} != '' || ${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("        AND A.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '')" ).append("\n"); 
		query.append("        AND A.RF_TP_CD IN(@[rf_tp_cd_c],@[rf_tp_cd_h])" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${rd_cgo_flg} != '' || ${rf_cntr} != '')" ).append("\n"); 
		query.append("        AND B.RD_CGO_FLG IN(@[rf_cntr],@[rd_cgo_flg])" ).append("\n"); 
		query.append("    #end      " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${cntr_hngr_rck_cd} != '')" ).append("\n"); 
		query.append("    	AND (A.CNTR_HNGR_RCK_CD IS NOT NULL OR  A.CNTR_HNGR_BAR_ATCH_KNT > 0)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${disp_flg} != '')" ).append("\n"); 
		query.append("    	AND A.DISP_FLG = @[disp_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${d2_payld_flg} != '')" ).append("\n"); 
		query.append("		AND A.CNTR_TPSZ_CD ='D2'" ).append("\n"); 
		query.append("    	AND A.D2_PAYLD_FLG = @[d2_payld_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${soc_cd} != '')" ).append("\n"); 
		query.append("    	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("    		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("    	#else" ).append("\n"); 
		query.append("    		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append("		AND	" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM1 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM2 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM3 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM4 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM5 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM6 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM7 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM8 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM9 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM10 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("		A.RSTR_USG_TP_LBL_NM11 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${ru_lable_type} == 'FLOW')" ).append("\n"); 
		query.append("		#if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM1 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM1 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'OWFU')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM2 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM2 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'OFHR')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM3 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM3 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'DOME')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM4 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM4 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'SALE')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM5 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM5 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'GOHH')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM6 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM6 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'REFR')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM7 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM7 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'ASST')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM8 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM8 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'OTR1')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM9 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM9 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'OTR2')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM10 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM10 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #elseif (${ru_lable_type} == 'OTR3')" ).append("\n"); 
		query.append("        #if (${rstr_usg_lbl} == '')" ).append("\n"); 
		query.append("			AND A.RSTR_USG_TP_LBL_NM11 IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND	A.RSTR_USG_TP_LBL_NM11 IN (" ).append("\n"); 
		query.append("				#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("                    	'$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end			  " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}