/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.05.27 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reefer Unit Info Retrieve Query
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL(){
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
		params.put("sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL").append("\n"); 
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
		query.append("        A.CNTR_NO " ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("        ,AGMT_CTY_CD||TO_CHAR(AGMT_SEQ,'000000') AS AGMT_NO" ).append("\n"); 
		query.append("		,MST_COMMON_PKG.MST_RU_LBL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("        ,MST_COMMON_PKG.MST_RU_TP_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("        ,MST_COMMON_PKG.MST_RU_VAL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_DESC" ).append("\n"); 
		query.append("        ,A.VNDR_SEQ" ).append("\n"); 
		query.append("        ,DECODE(A.RF_MKR_SEQ, 0, '', A.RF_MKR_SEQ)AS RF_MKR_SEQ" ).append("\n"); 
		query.append("        ,NVL(B.VNDR_ABBR_NM, B.VNDR_LGL_ENG_NM) AS  RF_MKR_NM" ).append("\n"); 
		query.append("		,A.RF_TP_CD" ).append("\n"); 
		query.append("        ,A.RF_MDL_NM" ).append("\n"); 
		query.append("        ,A.RF_RFR_NO" ).append("\n"); 
		query.append("        ,A.MIN_TEMP" ).append("\n"); 
		query.append("        ,A.MAX_TEMP        " ).append("\n"); 
		query.append("        ,'' AS AEFlG" ).append("\n"); 
		query.append("        ,'' AS BEFlG" ).append("\n"); 
		query.append("        ,'' AS CEFlG" ).append("\n"); 
		query.append("        ,'' AS DEFlG" ).append("\n"); 
		query.append("        ,'' AS EEFlG" ).append("\n"); 
		query.append("		,A.RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("		,A.RF_CMPR_CTNT  " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        MST_CONTAINER A, " ).append("\n"); 
		query.append("        MDM_VENDOR B" ).append("\n"); 
		query.append("    WHERE  A.RF_MKR_SEQ  = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append(" 	AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(" #if (${lstm_cd} != '' && ${lstm_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND   A.LSTM_CD  IN ( #foreach($key IN ${arr_lstm_cd})" ).append("\n"); 
		query.append("                                     #if($velocityCount < $arr_lstm_cd.size())" ).append("\n"); 
		query.append("                                        '$key'," ).append("\n"); 
		query.append("                                     #else" ).append("\n"); 
		query.append("                                        '$key'" ).append("\n"); 
		query.append("                                     #end" ).append("\n"); 
		query.append("                                #end )" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("    AND A.LSTM_CD NOT IN ('OW', 'LP', 'OL', 'MO', 'SO')" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("  #if (${agmt_cty_cd} != '' && ${agmt_seq} != '')" ).append("\n"); 
		query.append("    AND A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("    AND A.AGMT_SEQ    = @[agmt_seq]			" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sts_flg} != '')" ).append("\n"); 
		query.append("    AND A.ACIAC_DIV_CD = @[sts_flg]" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if (${mi_flg} == 'Y')" ).append("\n"); 
		query.append("    AND NVL(A.RF_MKR_SEQ, 0) <> 0" ).append("\n"); 
		query.append(" #elseif(${mi_flg} == 'N')" ).append("\n"); 
		query.append("    AND NVL(A.RF_MKR_SEQ, 0) = 0" ).append("\n"); 
		query.append(" #end  " ).append("\n"); 
		query.append(" #if (${cntr_tpsz_cd} != '' && ${cntr_tpsz_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND   A.CNTR_TPSZ_CD  IN ( #foreach($key IN ${arr_cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                     #if($velocityCount < $arr_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                        '$key'," ).append("\n"); 
		query.append("                                     #else" ).append("\n"); 
		query.append("                                        '$key'" ).append("\n"); 
		query.append("                                     #end" ).append("\n"); 
		query.append("                                #end )" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${rstr_usg_lbl} != '')" ).append("\n"); 
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
		query.append("	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${ru_lable_type} == 'FLOW')" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append(" ORDER BY A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${a} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${a} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}