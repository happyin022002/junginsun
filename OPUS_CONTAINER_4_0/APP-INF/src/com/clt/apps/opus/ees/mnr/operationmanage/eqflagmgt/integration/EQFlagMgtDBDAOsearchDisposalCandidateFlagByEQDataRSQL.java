/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchDisposalCandidateFlagByEQDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchDisposalCandidateFlagByEQDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalCandidateFlagByEQData
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchDisposalCandidateFlagByEQDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tocal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromcal",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchDisposalCandidateFlagByEQDataRSQL").append("\n"); 
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
		query.append("   B.EQ_NO" ).append("\n"); 
		query.append(",  B.EQ_TYPE EQ_KND_CD" ).append("\n"); 
		query.append(",  B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",  A.MNR_DMG_FLG" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG" ).append("\n"); 
		query.append(",   DECODE(A.MNR_DISP_SEL_FLG,'Y','1','0') AS MNR_DISP_SEL_FLG" ).append("\n"); 
		query.append(",  A.DISP_RSN_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",  A.HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append(",  A.MNR_DMG_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG_DT" ).append("\n"); 
		query.append(",  DECODE(A.MNR_DISP_SEL_FLG,'Y',TO_CHAR(A.MNR_DISP_SEL_FLG_DT,'YYYY-MM-DD')) AS MNR_DISP_SEL_FLG_DT" ).append("\n"); 
		query.append(",  B.CRNT_YD_CD MNR_DMG_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_STS_RMK" ).append("\n"); 
		query.append(",  A.CRE_USR_ID" ).append("\n"); 
		query.append(",  TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",  A.UPD_USR_ID" ).append("\n"); 
		query.append(",  TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append(",  TRUNC(SYSDATE - A.MNR_DMG_FLG_DT) AS MNR_DMG_FLG_DT_OVER_DAY" ).append("\n"); 
		query.append(",  B.LSTM_CD" ).append("\n"); 
		query.append(",(SELECT C.DISP_NO" ).append("\n"); 
		query.append("    FROM MNR_DISP_DTL C" ).append("\n"); 
		query.append("   WHERE  C.EQ_NO=A.EQ_NO" ).append("\n"); 
		query.append("     AND C.EQ_TPSZ_CD=A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     AND C.DISP_YD_CD=A.MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append("     AND ROWNUM=1) AS DISP_NO" ).append("\n"); 
		query.append(",(SELECT F.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("    FROM MNR_DISP_DTL C ,MNR_DISP_HDR D,MNR_GEN_CD F" ).append("\n"); 
		query.append("   WHERE C.DISP_NO=D.DISP_NO" ).append("\n"); 
		query.append("     AND C.EQ_NO=A.EQ_NO" ).append("\n"); 
		query.append("     AND C.EQ_TPSZ_CD=A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     AND C.DISP_YD_CD=A.MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append("     AND F.PRNT_CD_ID='CD00029'" ).append("\n"); 
		query.append("     AND D.DISP_STS_CD=F.MNR_CD_ID" ).append("\n"); 
		query.append("     AND ROWNUM=1) AS DISP_STS_NM" ).append("\n"); 
		query.append("#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("--,MST_COMMON_PKG.MST_RU_LBL_GET_FNC(C.CNTR_NO) AS RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("	,MST_COMMON_PKG.MST_RU_TP_GET_FNC(C.CNTR_NO) AS RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("    ,MST_COMMON_PKG.MST_RU_VAL_GET_FNC(C.CNTR_NO) AS RSTR_USG_LBL_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM MNR_EQ_STS A, MNR_EQ_STS_V B" ).append("\n"); 
		query.append("#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append(", MST_CONTAINER C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	B.EQ_NO = A.EQ_NO(+)" ).append("\n"); 
		query.append("AND     A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND     A.MNR_DISP_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("AND     A.MNR_DISP_SEL_TP_CD = 'N'" ).append("\n"); 
		query.append("#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("AND     B.EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_eq_no} != '')" ).append("\n"); 
		query.append("	AND B.EQ_NO IN ('${rqst_eq_no}')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND	B.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("			#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("				'$user_tpszCds'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_tpszCds'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("            #if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append("				AND	" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM1 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM2 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM3 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM4 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM5 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM6 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM7 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM8 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM9 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM10 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				C.RSTR_USG_TP_LBL_NM11 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fromcal} != '' && ${tocal} != '' )" ).append("\n"); 
		query.append("    AND A.MNR_DISP_SEL_FLG_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[fromcal], 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[tocal] , 'YYYY-MM-DD'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}