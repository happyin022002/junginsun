/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SettlementProcessDBDAOStlTgtOusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOStlTgtOusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Taget OUS 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOStlTgtOusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOStlTgtOusRSQL").append("\n"); 
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
		query.append("WITH OUS_TGT AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         J.REV_YRMON" ).append("\n"); 
		query.append("        ,J.REV_YRMON_SEQ" ).append("\n"); 
		query.append("        ,J.TRD_CD" ).append("\n"); 
		query.append("        ,J.CRR_CD" ).append("\n"); 
		query.append("        ,J.RLANE_CD" ).append("\n"); 
		query.append("        ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("        ,J.VSL_CD" ).append("\n"); 
		query.append("        ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,J.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,J.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,J.YD_CD" ).append("\n"); 
		query.append("        ,J.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,J.RDR_FLG" ).append("\n"); 
		query.append("        ,J.VPS_ETD_DT" ).append("\n"); 
		query.append("        ,J.JO_STL_JB_CD" ).append("\n"); 
		query.append("        ,DECODE(L.LEV,'1','OUS','2','R/F','3','OTH') AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("        ,J.RF_SCG_STL_TP_CD     --T(TDR), R(RDR), I(User INPUT)" ).append("\n"); 
		query.append("        ,L.LEV" ).append("\n"); 
		query.append("        ,MIN(J.VSL_CD || J.SKD_VOY_NO || J.SKD_DIR_CD || J.REV_YRMON) OVER (PARTITION BY J.VSL_CD || J.SKD_VOY_NO || J.SKD_DIR_CD) AS VVD_ETD_GROUP        " ).append("\n"); 
		query.append("        ,J.REV_DIR_CD" ).append("\n"); 
		query.append("        ,SUBSTR(J.YD_CD,6,2) AS TML		" ).append("\n"); 
		query.append("        ,DECODE(L.LEV,'1',J.FNL_OVR_USD_SLT_KNT,'0')                 AS OUS_KNT" ).append("\n"); 
		query.append("		,DECODE(L.LEV,'2',J.RF_CNTR_20FT_KNT+J.RF_CNTR_40FT_KNT,'0') AS RF_KNT        " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT LEVEL AS LEV" ).append("\n"); 
		query.append("        FROM DUAL CONNECT BY LEVEL <= 3" ).append("\n"); 
		query.append("    ) L" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("                 J.REV_YRMON" ).append("\n"); 
		query.append("                ,J.REV_YRMON_SEQ" ).append("\n"); 
		query.append("                ,J.TRD_CD" ).append("\n"); 
		query.append("                ,J.CRR_CD" ).append("\n"); 
		query.append("                ,J.RLANE_CD" ).append("\n"); 
		query.append("                ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("                ,J.VSL_CD" ).append("\n"); 
		query.append("                ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,J.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,J.VPS_PORT_CD" ).append("\n"); 
		query.append("                ,J.YD_CD" ).append("\n"); 
		query.append("                ,J.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                ,J.RDR_FLG" ).append("\n"); 
		query.append("                ,J.VPS_ETD_DT" ).append("\n"); 
		query.append("                ,J.JO_STL_JB_CD" ).append("\n"); 
		query.append("                ,J.RF_SCG_STL_TP_CD     --T(TDR), R(RDR), I(User INPUT)" ).append("\n"); 
		query.append("                ,J.REV_DIR_CD" ).append("\n"); 
		query.append("                ,J.FNL_OVR_USD_SLT_KNT" ).append("\n"); 
		query.append("                ,J.RF_CNTR_20FT_KNT" ).append("\n"); 
		query.append("                ,J.RF_CNTR_40FT_KNT" ).append("\n"); 
		query.append("            FROM JOO_LODG_TGT J" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("		    AND J.STL_TGT_FLG = '1'" ).append("\n"); 
		query.append("		    AND J.STL_CLZ_FLG = '0'" ).append("\n"); 
		query.append("            AND J.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		    #if (${re_divr_cd} != '')			" ).append("\n"); 
		query.append("		    AND J.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("		    AND J.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		    AND J.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("		    #if (${vvd} != '')" ).append("\n"); 
		query.append("		    AND J.VSL_CD || J.SKD_VOY_NO || J.SKD_DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("		    #end" ).append("\n"); 
		query.append("	  ) J" ).append("\n"); 
		query.append("), OUS_TGT2 AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("     O.REV_YRMON" ).append("\n"); 
		query.append("    ,O.REV_YRMON_SEQ" ).append("\n"); 
		query.append("    ,O.TRD_CD" ).append("\n"); 
		query.append("    ,@[jo_crr_cd] CRR_CD" ).append("\n"); 
		query.append("    ,O.RLANE_CD" ).append("\n"); 
		query.append("    ,O.RE_DIVR_CD" ).append("\n"); 
		query.append("    ,O.VSL_CD" ).append("\n"); 
		query.append("    ,O.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,O.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,O.VPS_PORT_CD" ).append("\n"); 
		query.append("    ,O.YD_CD" ).append("\n"); 
		query.append("    ,O.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,O.RDR_FLG" ).append("\n"); 
		query.append("    ,O.VPS_ETD_DT" ).append("\n"); 
		query.append("    ,O.JO_STL_JB_CD" ).append("\n"); 
		query.append("    ,O.JO_STL_ITM_CD" ).append("\n"); 
		query.append("    ,O.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("    ,O.LEV" ).append("\n"); 
		query.append("    ,O.VVD_ETD_GROUP" ).append("\n"); 
		query.append("    ,O.REV_DIR_CD" ).append("\n"); 
		query.append("    ,O.TML" ).append("\n"); 
		query.append("    ,O.OUS_KNT" ).append("\n"); 
		query.append("    ,O.RF_KNT" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            MAX(B.JO_ESTM_ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("        FROM  JOO_STL_ITM A, JOO_STL_ITM_ACCT B" ).append("\n"); 
		query.append("        WHERE A.JO_STL_ITM_CD = B.JO_STL_ITM_CD" ).append("\n"); 
		query.append("        AND A.JO_STL_ITM_CD = O.JO_STL_ITM_CD" ).append("\n"); 
		query.append("        AND B.RE_DIVR_CD = O.RE_DIVR_CD" ).append("\n"); 
		query.append("        GROUP BY" ).append("\n"); 
		query.append("                 A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("                ,A.JO_STL_ITM_NM" ).append("\n"); 
		query.append("                ,A.JO_AUTO_CRE_FLG" ).append("\n"); 
		query.append("                ,A.JO_MNL_CRE_FLG			" ).append("\n"); 
		query.append("     ) AS ACCT_CD" ).append("\n"); 
		query.append("        ,S.REV_SEQ" ).append("\n"); 
		query.append("        ,S.ACCT_YRMON" ).append("\n"); 
		query.append("        ,S.STL_VVD_SEQ" ).append("\n"); 
		query.append("        ,S.STL_SEQ" ).append("\n"); 
		query.append("        -----------------" ).append("\n"); 
		query.append("        ,S.JO_STL_STS_CD" ).append("\n"); 
		query.append("        ,S.BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.FNL_BSA_QTY " ).append("\n"); 
		query.append("        ,S.FNL_BSA_SLT_PRC " ).append("\n"); 
		query.append("        ,NVL(S.LOCL_CURR_CD,'USD') AS LOCL_CURR_CD" ).append("\n"); 
		query.append("        ,S.STL_LOCL_AMT" ).append("\n"); 
		query.append("        ,S.STL_RMK" ).append("\n"); 
		query.append("        ,S.JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("        ,S.REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.REV_ENBL_FLG " ).append("\n"); 
		query.append("        ,S.REV_SHW_FLG" ).append("\n"); 
		query.append("        ,S.REV_CRR_CD" ).append("\n"); 
		query.append("        ,S.N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,S.N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("        ,S.N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,S.N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,S.N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,S.N3RD_REV_CRR_CD    " ).append("\n"); 
		query.append("        ,S.REV_ENBL_FLG AS REV_CHK" ).append("\n"); 
		query.append("        ,S.N2ND_REV_ENBL_FLG AS N2ND_REV_CHK" ).append("\n"); 
		query.append("        ,S.N3RD_REV_ENBL_FLG AS N3RD_REV_CHK" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG" ).append("\n"); 
		query.append("        ,S.STL_TGT_FLG AS STL_TGT_FLG2" ).append("\n"); 
		query.append("        ,S.STL_CLZ_FLG        " ).append("\n"); 
		query.append("        ,DECODE(O.JO_STL_ITM_CD,'OUS',O.OUS_KNT,'R/F',O.RF_KNT,S.BSA_QTY) AS BSA_QTY        " ).append("\n"); 
		query.append("     -----------------" ).append("\n"); 
		query.append("    FROM OUS_TGT O, (SELECT S.* " ).append("\n"); 
		query.append("						 FROM JOO_STL_TGT S " ).append("\n"); 
		query.append("						 WHERE 1=1" ).append("\n"); 
		query.append("			             AND S.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("					     #if (${re_divr_cd} != '')			" ).append("\n"); 
		query.append("			  		     AND S.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("			 		     #end" ).append("\n"); 
		query.append("		    			 #if (${trd_cd} != '')" ).append("\n"); 
		query.append("		    			 AND S.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("		    			 #end" ).append("\n"); 
		query.append("		      			 #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		    			 AND S.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("					     #end" ).append("\n"); 
		query.append("		    			 #if (${vvd} != '')" ).append("\n"); 
		query.append("		      			 AND S.VSL_CD || S.SKD_VOY_NO || S.SKD_DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("		    			 #end" ).append("\n"); 
		query.append("						 #if (${ous_yn} == '' && ${rf_yn} == ''&& ${dg_yn} == '' )" ).append("\n"); 
		query.append("							AND S.JO_STL_ITM_CD IN ('OUS','R/F','OTH')" ).append("\n"); 
		query.append("						 #else" ).append("\n"); 
		query.append("						    AND (" ).append("\n"); 
		query.append("							    1!=1" ).append("\n"); 
		query.append("								#if (${ous_yn} == 'Y')" ).append("\n"); 
		query.append("								    OR S.JO_STL_ITM_CD = 'OUS'" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${rf_yn} == 'Y')" ).append("\n"); 
		query.append("								    OR S.JO_STL_ITM_CD = 'R/F'" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${dg_yn} == 'Y')" ).append("\n"); 
		query.append("								    OR S.JO_STL_ITM_CD = 'OTH'" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							    )" ).append("\n"); 
		query.append("							#if (${ous_yn} == 'N' && ${rf_yn} == 'N'&& ${dg_yn} == 'N' )" ).append("\n"); 
		query.append("								AND S.JO_STL_ITM_CD IN ('OUS','R/F','OTH')" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						 #end						  	" ).append("\n"); 
		query.append("						 ) S" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND O.REV_YRMON = S.REV_YRMON(+)" ).append("\n"); 
		query.append("    AND O.REV_YRMON_SEQ = S.REV_YRMON_SEQ(+)" ).append("\n"); 
		query.append("    AND O.JO_STL_ITM_CD = S.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("	#if (${ous_yn} == '' && ${rf_yn} == ''&& ${dg_yn} == '' )" ).append("\n"); 
		query.append("		AND O.JO_STL_ITM_CD IN ('OUS','R/F','OTH')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	    AND (" ).append("\n"); 
		query.append("	    1!=1" ).append("\n"); 
		query.append("		#if (${ous_yn} == 'Y')" ).append("\n"); 
		query.append("	    OR O.JO_STL_ITM_CD = 'OUS'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${rf_yn} == 'Y')" ).append("\n"); 
		query.append("	    OR O.JO_STL_ITM_CD = 'R/F'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${dg_yn} == 'Y')" ).append("\n"); 
		query.append("	    OR O.JO_STL_ITM_CD = 'OTH'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("		#if (${ous_yn} == 'N' && ${rf_yn} == 'N'&& ${dg_yn} == 'N' )" ).append("\n"); 
		query.append("		AND O.JO_STL_ITM_CD IN ('OUS','R/F','OTH')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("),OUS_TGT3 AS (" ).append("\n"); 
		query.append(" SELECT " ).append("\n"); 
		query.append("     O.REV_YRMON" ).append("\n"); 
		query.append("    ,O.REV_YRMON_SEQ" ).append("\n"); 
		query.append("    ,O.TRD_CD" ).append("\n"); 
		query.append("    ,O.CRR_CD" ).append("\n"); 
		query.append("    ,O.RLANE_CD" ).append("\n"); 
		query.append("    ,O.RE_DIVR_CD" ).append("\n"); 
		query.append("    ,O.VSL_CD" ).append("\n"); 
		query.append("    ,O.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,O.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,O.VPS_PORT_CD" ).append("\n"); 
		query.append("    ,O.YD_CD" ).append("\n"); 
		query.append("    ,O.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,O.RDR_FLG" ).append("\n"); 
		query.append("    ,O.VPS_ETD_DT" ).append("\n"); 
		query.append("    ,O.JO_STL_JB_CD" ).append("\n"); 
		query.append("    ,O.JO_STL_ITM_CD" ).append("\n"); 
		query.append("    ,O.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("    ,O.LEV" ).append("\n"); 
		query.append("    ,O.VVD_ETD_GROUP" ).append("\n"); 
		query.append("    ,O.REV_DIR_CD" ).append("\n"); 
		query.append("    ,O.TML" ).append("\n"); 
		query.append("    ,O.OUS_KNT" ).append("\n"); 
		query.append("    ,O.RF_KNT" ).append("\n"); 
		query.append("    ,O.ACCT_CD" ).append("\n"); 
		query.append("    ,O.REV_SEQ" ).append("\n"); 
		query.append("    ,O.ACCT_YRMON" ).append("\n"); 
		query.append("    ,O.STL_VVD_SEQ" ).append("\n"); 
		query.append("    ,O.STL_SEQ" ).append("\n"); 
		query.append("    -----------------" ).append("\n"); 
		query.append("    ,O.JO_STL_STS_CD" ).append("\n"); 
		query.append("    ,O.BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,O.FNL_BSA_QTY " ).append("\n"); 
		query.append("    ,O.FNL_BSA_SLT_PRC " ).append("\n"); 
		query.append("    ,O.LOCL_CURR_CD" ).append("\n"); 
		query.append("    ,O.STL_LOCL_AMT" ).append("\n"); 
		query.append("    ,O.STL_RMK" ).append("\n"); 
		query.append("    ,O.JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("    ,O.REV_BSA_QTY" ).append("\n"); 
		query.append("    ,O.REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,O.REV_ENBL_FLG " ).append("\n"); 
		query.append("    ,O.REV_SHW_FLG" ).append("\n"); 
		query.append("    ,O.REV_CRR_CD" ).append("\n"); 
		query.append("    ,O.N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("    ,O.N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,O.N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,O.N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("    ,O.N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("    ,O.N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,O.N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,O.N3RD_REV_CRR_CD    " ).append("\n"); 
		query.append("    ,O.REV_CHK" ).append("\n"); 
		query.append("    ,O.N2ND_REV_CHK" ).append("\n"); 
		query.append("    ,O.N3RD_REV_CHK" ).append("\n"); 
		query.append("    ,O.STL_TGT_FLG" ).append("\n"); 
		query.append("    ,O.STL_TGT_FLG2" ).append("\n"); 
		query.append("    ,O.STL_CLZ_FLG        " ).append("\n"); 
		query.append("    ,O.BSA_QTY        " ).append("\n"); 
		query.append("FROM OUS_TGT2 O" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("     S.REV_YRMON" ).append("\n"); 
		query.append("    ,S.REV_YRMON_SEQ" ).append("\n"); 
		query.append("    ,S.TRD_CD" ).append("\n"); 
		query.append("    ,S.CRR_CD" ).append("\n"); 
		query.append("    ,S.RLANE_CD" ).append("\n"); 
		query.append("    ,S.RE_DIVR_CD" ).append("\n"); 
		query.append("    ,S.VSL_CD" ).append("\n"); 
		query.append("    ,S.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,S.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,S.VPS_PORT_CD" ).append("\n"); 
		query.append("    ,S.YD_CD" ).append("\n"); 
		query.append("    ,S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,S.RDR_FLG" ).append("\n"); 
		query.append("    ,S.VPS_ETD_DT" ).append("\n"); 
		query.append("    ,S.JO_STL_JB_CD" ).append("\n"); 
		query.append("    ,S.JO_STL_ITM_CD" ).append("\n"); 
		query.append("    ,S.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("    ,DECODE(S.JO_STL_ITM_CD,'OUS',1,'R/F',2,'OTH',3) AS LEV" ).append("\n"); 
		query.append("    ,S.VSL_CD || S.SKD_VOY_NO || S.SKD_DIR_CD || S.REV_YRMON AS VVD_ETD_GROUP        " ).append("\n"); 
		query.append("    ,S.REV_DIR_CD" ).append("\n"); 
		query.append("    ,SUBSTR(S.YD_CD,6,2) AS TML" ).append("\n"); 
		query.append("    ,DECODE(S.JO_STL_ITM_CD,'OUS',BSA_QTY,'0') AS OUS_KNT " ).append("\n"); 
		query.append("    ,DECODE(S.JO_STL_ITM_CD,'R/F',BSA_QTY,'0') AS RF_KNT" ).append("\n"); 
		query.append("    ,S.ACCT_CD" ).append("\n"); 
		query.append("    ,S.REV_SEQ" ).append("\n"); 
		query.append("    ,S.ACCT_YRMON" ).append("\n"); 
		query.append("    ,S.STL_VVD_SEQ" ).append("\n"); 
		query.append("    ,S.STL_SEQ" ).append("\n"); 
		query.append("    -----------------" ).append("\n"); 
		query.append("    ,S.JO_STL_STS_CD" ).append("\n"); 
		query.append("    ,S.BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,S.FNL_BSA_QTY " ).append("\n"); 
		query.append("    ,S.FNL_BSA_SLT_PRC " ).append("\n"); 
		query.append("    ,NVL(S.LOCL_CURR_CD,'USD') AS LOCL_CURR_CD" ).append("\n"); 
		query.append("    ,S.STL_LOCL_AMT" ).append("\n"); 
		query.append("    ,S.STL_RMK" ).append("\n"); 
		query.append("    ,S.JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("    ,S.REV_BSA_QTY" ).append("\n"); 
		query.append("    ,S.REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,S.REV_ENBL_FLG " ).append("\n"); 
		query.append("    ,S.REV_SHW_FLG" ).append("\n"); 
		query.append("    ,S.REV_CRR_CD" ).append("\n"); 
		query.append("    ,S.N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("    ,S.N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,S.N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,S.N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("    ,S.N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("    ,S.N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,S.N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,S.N3RD_REV_CRR_CD    " ).append("\n"); 
		query.append("    ,S.REV_ENBL_FLG AS REV_CHK" ).append("\n"); 
		query.append("    ,S.N2ND_REV_ENBL_FLG AS N2ND_REV_CHK" ).append("\n"); 
		query.append("    ,S.N3RD_REV_ENBL_FLG AS N3RD_REV_CHK" ).append("\n"); 
		query.append("    ,S.STL_TGT_FLG" ).append("\n"); 
		query.append("    ,S.STL_TGT_FLG AS STL_TGT_FLG2" ).append("\n"); 
		query.append("    ,S.STL_CLZ_FLG        " ).append("\n"); 
		query.append("    ,S.BSA_QTY       " ).append("\n"); 
		query.append("FROM JOO_STL_TGT S " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND S.REV_SHW_FLG IN ('A','C','S')" ).append("\n"); 
		query.append("			             AND S.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("					     #if (${re_divr_cd} != '')			" ).append("\n"); 
		query.append("			  		     AND S.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("			 		     #end" ).append("\n"); 
		query.append("		    			 #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("		    			 AND S.CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("		    			 #end" ).append("\n"); 
		query.append("		    			 #if (${trd_cd} != '')" ).append("\n"); 
		query.append("		    			 AND S.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("		    			 #end" ).append("\n"); 
		query.append("		      			 #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		    			 AND S.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("					     #end" ).append("\n"); 
		query.append("		    			 #if (${vvd} != '')" ).append("\n"); 
		query.append("		      			 AND S.VSL_CD || S.SKD_VOY_NO || S.SKD_DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("		    			 #end" ).append("\n"); 
		query.append("						 #if (${ous_yn} == '' && ${rf_yn} == ''&& ${dg_yn} == '' )" ).append("\n"); 
		query.append("							AND S.JO_STL_ITM_CD IN ('OUS','R/F','OTH')" ).append("\n"); 
		query.append("						 #else" ).append("\n"); 
		query.append("						    AND (" ).append("\n"); 
		query.append("							    1!=1" ).append("\n"); 
		query.append("								#if (${ous_yn} == 'Y')" ).append("\n"); 
		query.append("								    OR S.JO_STL_ITM_CD = 'OUS'" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${rf_yn} == 'Y')" ).append("\n"); 
		query.append("								    OR S.JO_STL_ITM_CD = 'R/F'" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${dg_yn} == 'Y')" ).append("\n"); 
		query.append("								    OR S.JO_STL_ITM_CD = 'OTH'" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							    )" ).append("\n"); 
		query.append("							#if (${ous_yn} == 'N' && ${rf_yn} == 'N'&& ${dg_yn} == 'N' )" ).append("\n"); 
		query.append("								AND S.JO_STL_ITM_CD IN ('OUS','R/F','OTH')" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						 #end						  	" ).append("\n"); 
		query.append("), OUS_TGT4 AS (" ).append("\n"); 
		query.append("    SELECT   " ).append("\n"); 
		query.append("         REV_YRMON" ).append("\n"); 
		query.append("        ,REV_YRMON_SEQ" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,CRR_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,RE_DIVR_CD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,VPS_PORT_CD" ).append("\n"); 
		query.append("        ,YD_CD" ).append("\n"); 
		query.append("        ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,RDR_FLG" ).append("\n"); 
		query.append("        ,VPS_ETD_DT" ).append("\n"); 
		query.append("        ,JO_STL_JB_CD" ).append("\n"); 
		query.append("        ,JO_STL_ITM_CD" ).append("\n"); 
		query.append("        ,RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("        ,LEV" ).append("\n"); 
		query.append("        ,VVD_ETD_GROUP" ).append("\n"); 
		query.append("        ,REV_DIR_CD" ).append("\n"); 
		query.append("        ,TML" ).append("\n"); 
		query.append("        ,OUS_KNT " ).append("\n"); 
		query.append("        ,RF_KNT" ).append("\n"); 
		query.append("        ,ACCT_CD" ).append("\n"); 
		query.append("        ,REV_SEQ" ).append("\n"); 
		query.append("        ,ACCT_YRMON" ).append("\n"); 
		query.append("        ,STL_VVD_SEQ" ).append("\n"); 
		query.append("        ,STL_SEQ" ).append("\n"); 
		query.append("        ,JO_STL_STS_CD" ).append("\n"); 
		query.append("        ,BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,FNL_BSA_QTY " ).append("\n"); 
		query.append("        ,FNL_BSA_SLT_PRC " ).append("\n"); 
		query.append("        ,LOCL_CURR_CD" ).append("\n"); 
		query.append("        ,STL_LOCL_AMT" ).append("\n"); 
		query.append("        ,STL_RMK" ).append("\n"); 
		query.append("        ,JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("        ,REV_BSA_QTY" ).append("\n"); 
		query.append("        ,REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,REV_ENBL_FLG " ).append("\n"); 
		query.append("        ,REV_SHW_FLG" ).append("\n"); 
		query.append("        ,REV_CRR_CD" ).append("\n"); 
		query.append("        ,N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("        ,N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("        ,N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("        ,N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("        ,N3RD_REV_CRR_CD    " ).append("\n"); 
		query.append("        ,REV_CHK" ).append("\n"); 
		query.append("        ,N2ND_REV_CHK" ).append("\n"); 
		query.append("        ,N3RD_REV_CHK" ).append("\n"); 
		query.append("        ,STL_TGT_FLG" ).append("\n"); 
		query.append("        ,STL_TGT_FLG2" ).append("\n"); 
		query.append("        ,STL_CLZ_FLG        " ).append("\n"); 
		query.append("        ,BSA_QTY  " ).append("\n"); 
		query.append("    FROM OUS_TGT3" ).append("\n"); 
		query.append("    ORDER BY VVD_ETD_GROUP, VPS_ETD_DT, LEV, REV_YRMON_SEQ, REV_SEQ ASC        " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     ROWNUM AS SEQ_NO" ).append("\n"); 
		query.append("    ,REV_YRMON" ).append("\n"); 
		query.append("    ,REV_YRMON_SEQ" ).append("\n"); 
		query.append("    ,REV_SEQ" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,CRR_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,RE_DIVR_CD" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,SKD_VOY_NO" ).append("\n"); 
		query.append("    ,SKD_DIR_CD" ).append("\n"); 
		query.append("    ,VPS_PORT_CD" ).append("\n"); 
		query.append("    ,YD_CD" ).append("\n"); 
		query.append("    ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,RDR_FLG" ).append("\n"); 
		query.append("    ,VPS_ETD_DT" ).append("\n"); 
		query.append("    ,ACCT_CD" ).append("\n"); 
		query.append("    ,JO_STL_JB_CD" ).append("\n"); 
		query.append("    ,JO_STL_STS_CD" ).append("\n"); 
		query.append("    ,JO_STL_ITM_CD" ).append("\n"); 
		query.append("    ,BSA_QTY" ).append("\n"); 
		query.append("    ,BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,FNL_BSA_QTY" ).append("\n"); 
		query.append("    ,FNL_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,LOCL_CURR_CD" ).append("\n"); 
		query.append("    ,STL_LOCL_AMT" ).append("\n"); 
		query.append("    ,STL_RMK" ).append("\n"); 
		query.append("    ,JO_STL_TGT_ITM_CD" ).append("\n"); 
		query.append("    ,NULL AS ESTM_STL_AMT" ).append("\n"); 
		query.append("    ,NULL AS ACT_STL_AMT" ).append("\n"); 
		query.append("    ,RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("    ,LEV" ).append("\n"); 
		query.append("    ,VVD_ETD_GROUP" ).append("\n"); 
		query.append("    ,NVL(ACCT_YRMON,'999912') AS ACCT_YRMON" ).append("\n"); 
		query.append("    ,STL_VVD_SEQ" ).append("\n"); 
		query.append("    ,STL_SEQ" ).append("\n"); 
		query.append("    ,STL_TGT_FLG" ).append("\n"); 
		query.append("    ,STL_TGT_FLG2" ).append("\n"); 
		query.append("    ,STL_CLZ_FLG" ).append("\n"); 
		query.append("    ,REV_DIR_CD" ).append("\n"); 
		query.append("    ,TML" ).append("\n"); 
		query.append("    ,REV_BSA_QTY" ).append("\n"); 
		query.append("    ,REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,NVL(REV_SHW_FLG,'Y') AS REV_SHW_FLG" ).append("\n"); 
		query.append("    ,REV_CRR_CD" ).append("\n"); 
		query.append("    ,N2ND_REV_BSA_QTY" ).append("\n"); 
		query.append("    ,N2ND_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,N2ND_REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,N2ND_REV_CRR_CD" ).append("\n"); 
		query.append("    ,N3RD_REV_BSA_QTY" ).append("\n"); 
		query.append("    ,N3RD_REV_BSA_SLT_PRC" ).append("\n"); 
		query.append("    ,N3RD_REV_ENBL_FLG" ).append("\n"); 
		query.append("    ,N3RD_REV_CRR_CD" ).append("\n"); 
		query.append("    ,NVL(REV_CHK, 0) REV_CHK" ).append("\n"); 
		query.append("    ,NVL(N2ND_REV_CHK, 0) N2ND_REV_CHK" ).append("\n"); 
		query.append("    ,NVL(N3RD_REV_CHK, 0) N3RD_REV_CHK" ).append("\n"); 
		query.append("FROM OUS_TGT4" ).append("\n"); 

	}
}