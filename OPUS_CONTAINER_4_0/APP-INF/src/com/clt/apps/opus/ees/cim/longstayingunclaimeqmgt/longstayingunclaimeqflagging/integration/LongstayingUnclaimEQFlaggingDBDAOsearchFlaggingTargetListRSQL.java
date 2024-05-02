/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingTargetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingTargetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 제반 정보를 조회한다.
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingTargetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_bl_type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingTargetListRSQL").append("\n"); 
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
		query.append("	 A.UPD_DT" ).append("\n"); 
		query.append("    ,A.UPD_USR_ID" ).append("\n"); 
		query.append("    ,A.CNTR_NO" ).append("\n"); 
		query.append("    ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("    ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("    ,A.BKG_NO" ).append("\n"); 
		query.append("    ,A.BL_NO" ).append("\n"); 
		query.append("    ,CASE WHEN STAY_DAYS >99999 THEN" ).append("\n"); 
		query.append("		99999" ).append("\n"); 
		query.append("	 ELSE " ).append("\n"); 
		query.append(" 	    STAY_DAYS" ).append("\n"); 
		query.append("	 END  STAY_DAYS" ).append("\n"); 
		query.append("    ,A.UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("    ,DECODE(A.LS_FLG,'Y','1','0') LS_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.LS_FLG,'Y','1','0') ORG_LS_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.UC_FLG,'Y','1','0') UC_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.UC_FLG,'Y','1','0') ORG_UC_FLG" ).append("\n"); 
		query.append("    ,A.UCLM_DT" ).append("\n"); 
		query.append("    ,NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0) FT_DYS" ).append("\n"); 
		query.append("    ,SUBSTR(A.FT_END_DYS,1,10) FT_END_DT" ).append("\n"); 
		query.append("    ,CASE WHEN A.STAY_DAYS-NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0) >99999 THEN" ).append("\n"); 
		query.append("		99999" ).append("\n"); 
		query.append("	 ELSE" ).append("\n"); 
		query.append(" 	    A.STAY_DAYS-NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0)" ).append("\n"); 
		query.append("	 END  ACT_DYS" ).append("\n"); 
		query.append("    ,NVL(A.UCLM_RSN,'') UCLM_RSN" ).append("\n"); 
		query.append("    ,A.UCLM_PLN_RMK" ).append("\n"); 
		query.append("    ,A.UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append("    ,REPLACE(REPLACE(SUBSTR(B.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ')  SHPR" ).append("\n"); 
		query.append("    ,REPLACE(REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ')  CNEE" ).append("\n"); 
		query.append("    ,REPLACE(REPLACE(SUBSTR(D.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ')  NTFY" ).append("\n"); 
		query.append("    ,A.REP_CMDT_NM" ).append("\n"); 
		query.append("	,A.MK_DESC MK_DESC" ).append("\n"); 
		query.append("    ,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,DECODE(A.DMG_FLG,'Y',A.DMG_FLG,'') DMG_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.DISP_FLG,'Y',A.DISP_FLG,'') DISP_FLG" ).append("\n"); 
		query.append("    ,A.CNMV_YR" ).append("\n"); 
		query.append("	,A.CNMV_ID_NO" ).append("\n"); 
		query.append("	,A.CNMV_GMT_DT" ).append("\n"); 
		query.append("	,A.CNMV_DT" ).append("\n"); 
		query.append("    ,A.UCLM_FREE_DYS" ).append("\n"); 
		query.append("    ,A.UCLM_END_DT" ).append("\n"); 
		query.append("    ,A.FULL_FLG" ).append("\n"); 
		query.append("    ,A.CRE_USR_ID" ).append("\n"); 
		query.append("	,A.UCLM_RSN TEMP_UCLM_RSN" ).append("\n"); 
		query.append("	,A.DMG_FLG_DT" ).append("\n"); 
		query.append("	,A.DMG_UNFLG_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("			(SELECT TO_CHAR(MAX(CIM.UPD_DT), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("               FROM CIM_UCLM_LONG_STAY_HIS CIM" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND A.CRNT_YD_CD = CIM.YD_CD" ).append("\n"); 
		query.append("                AND A.CNTR_NO = CIM.CNTR_NO" ).append("\n"); 
		query.append("                AND A.CNMV_YR = CIM.CNMV_YR" ).append("\n"); 
		query.append("                AND A.CNMV_ID_NO = CIM.CNMV_ID_NO" ).append("\n"); 
		query.append("                AND A.CNMV_STS_CD = CIM.CNMV_STS_CD) UPD_DT " ).append("\n"); 
		query.append("           ,(SELECT /*+ INDEX_DESC(CIM XPKCIM_UCLM_LONG_STAY_HIS) */CIM.UPD_USR_ID" ).append("\n"); 
		query.append("               FROM CIM_UCLM_LONG_STAY_HIS CIM" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND A.CRNT_YD_CD = CIM.YD_CD" ).append("\n"); 
		query.append("                AND A.CNTR_NO = CIM.CNTR_NO" ).append("\n"); 
		query.append("                AND A.CNMV_YR = CIM.CNMV_YR" ).append("\n"); 
		query.append("                AND A.CNMV_ID_NO = CIM.CNMV_ID_NO" ).append("\n"); 
		query.append("                AND A.CNMV_STS_CD = CIM.CNMV_STS_CD" ).append("\n"); 
		query.append("                AND ROWNUM = 1) UPD_USR_ID" ).append("\n"); 
		query.append("           ,A.CNTR_NO" ).append("\n"); 
		query.append("           ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("           ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("           ,A.BKG_NO" ).append("\n"); 
		query.append("           ,B.BL_NO" ).append("\n"); 
		query.append("           ,A.UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("           ,DECODE(A.UCLM_LS_DIV_CD,'L','Y','N') LS_FLG" ).append("\n"); 
		query.append("           ,DECODE(A.UCLM_LS_DIV_CD,'U','Y','N') UC_FLG" ).append("\n"); 
		query.append("		   ,DECODE(A.UCLM_LS_DIV_CD,NULL,'',TO_CHAR(A.UCLM_DT,'YYYY-MM-DD')) UCLM_DT" ).append("\n"); 
		query.append("           ,(SELECT  MAX(NVL(TO_CHAR(FT_END_DT,'YYYY-MM-DD'),'1111-11-11')||LTRIM(TO_CHAR(FT_DYS,'0000')))" ).append("\n"); 
		query.append("        FROM DMT_CHG_CALC E,DMT_CHG_BKG_CNTR F" ).append("\n"); 
		query.append("        WHERE E.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("        AND E.SYS_AREA_GRP_ID  =  A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND E.CNTR_CYC_NO = A. CNMV_CYC_NO" ).append("\n"); 
		query.append("        AND E.CHG_SEQ = 1" ).append("\n"); 
		query.append("		AND E.FM_MVMT_YD_CD = A.CRNT_YD_CD" ).append("\n"); 
		query.append("        AND E.DMDT_CHG_STS_CD <> 'E'" ).append("\n"); 
		query.append("        AND F.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("        AND F.SYS_AREA_GRP_ID  = E.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND F.CNTR_CYC_NO = E.CNTR_CYC_NO" ).append("\n"); 
		query.append("        AND F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		AND A.CNMV_STS_CD NOT IN ('TS','MT')" ).append("\n"); 
		query.append("		) FT_END_DYS        " ).append("\n"); 
		query.append("        ,DECODE(A.UCLM_LS_DIV_CD,NULL,'',A.UCLM_RSN) UCLM_RSN" ).append("\n"); 
		query.append("        ,DECODE(A.UCLM_LS_DIV_CD,NULL,'',A.UCLM_PLN_RMK) UCLM_PLN_RMK" ).append("\n"); 
		query.append("        ,DECODE(A.UCLM_LS_DIV_CD,NULL,'',A.UCLM_CNTC_PNT_NM) UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append("        ,CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - A.CNMV_DT) STAY_DAYS" ).append("\n"); 
		query.append("    	,(SELECT D.CMDT_NM FROM MDM_COMMODITY D" ).append("\n"); 
		query.append("    	  WHERE   B.CMDT_CD = D.CMDT_CD" ).append("\n"); 
		query.append("    	 ) REP_CMDT_NM       " ).append("\n"); 
		query.append("    	,(SELECT REPLACE(REPLACE(SUBSTR(X.CNTR_MF_GDS_DESC,1,100),CHR(13)||chr(10),' '), CHR(10), ' ') MK_DESC" ).append("\n"); 
		query.append("    		FROM BKG_CNTR_MF_DESC X" ).append("\n"); 
		query.append("    	   WHERE A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("    	   AND A.CNTR_NO=X.CNTR_NO" ).append("\n"); 
		query.append("           AND ROWNUM=1" ).append("\n"); 
		query.append("         ) MK_DESC" ).append("\n"); 
		query.append("		,B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("        ,A.DMG_FLG" ).append("\n"); 
		query.append("        ,A.DISP_FLG" ).append("\n"); 
		query.append("		,A.CNMV_YR" ).append("\n"); 
		query.append("		,A.CNMV_ID_NO" ).append("\n"); 
		query.append("		,TO_CHAR(A.CNMV_GDT,'YYYY-MM-DD HH24:MI:SS') CNMV_GMT_DT" ).append("\n"); 
		query.append("		,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD HH24:MI:SS') CNMV_DT" ).append("\n"); 
		query.append("        ,A.UCLM_FREE_DYS" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UCLM_END_DT,'YYYY-MM-DD HH24:MI:SS') UCLM_END_DT" ).append("\n"); 
		query.append("        ,A.FULL_FLG" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("       -- ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        ,A.CNMV_CYC_NO		" ).append("\n"); 
		query.append("		,MST_COMMON_PKG.MST_DMG_DT_GET_FNC(A.CNTR_NO, 'FLG') AS DMG_FLG_DT " ).append("\n"); 
		query.append("		,MST_COMMON_PKG.MST_DMG_DT_GET_FNC(A.CNTR_NO, 'UNFLG') AS DMG_UNFLG_DT" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND   A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("    AND   A.CNTR_USE_CO_CD = 'O'" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${loc_type_code} == '1')       --LCC" ).append("\n"); 
		query.append("	    AND   A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '2')   --ECC" ).append("\n"); 
		query.append("	    AND   A.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '3')   --SCC" ).append("\n"); 
		query.append("	    AND   A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cust_cd} != '')" ).append("\n"); 
		query.append("        AND   A.BKG_NO = (SELECT W.BKG_NO     --Shipper 값이 있을시" ).append("\n"); 
		query.append("                          FROM   BKG_CUSTOMER W" ).append("\n"); 
		query.append("                          WHERE  B.BKG_NO = W.BKG_NO" ).append("\n"); 
		query.append("                          AND    W.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("                          AND   W.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("                          AND    W.CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${full_flg} != '')" ).append("\n"); 
		query.append("        AND   A.FULL_FLG=@[full_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType )" ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${uclm_ls_div_cd} != '')" ).append("\n"); 
		query.append("        #if (${uclm_ls_div_cd} == 'P')" ).append("\n"); 
		query.append("		  #if (${full_flg} == 'N')" ).append("\n"); 
		query.append("             AND NVL(A.UCLM_LS_DIV_CD,'Z') <>'U'		 " ).append("\n"); 
		query.append("		  #end			 " ).append("\n"); 
		query.append("			 AND   A.UCLM_LS_DIV_CD IS NULL     --Flag Status completed=>not null ,Pending(default =>null		" ).append("\n"); 
		query.append("        #elseif (${uclm_ls_div_cd} == 'C')" ).append("\n"); 
		query.append("            AND   A.UCLM_LS_DIV_CD IN('L','U')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${over_stay_days} != '')" ).append("\n"); 
		query.append("        AND   CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - A.CNMV_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND   A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_bl_type_cd} != '')" ).append("\n"); 
		query.append("	    #if (${bkg_bl_type_code} == 'BKG')" ).append("\n"); 
		query.append("    	    AND A.BKG_NO = @[bkg_bl_type_cd]" ).append("\n"); 
		query.append("	    #elseif (${bkg_bl_type_code} == 'BL')" ).append("\n"); 
		query.append("    	    AND B.BL_NO = @[bkg_bl_type_cd]" ).append("\n"); 
		query.append("	    #elseif (${bkg_bl_type_code} == 'CNTR')" ).append("\n"); 
		query.append("        	AND A.CNTR_NO = @[bkg_bl_type_cd]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    	AND A.CNMV_STS_CD BETWEEN 'CA' AND 'VD'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    --    	AND A.CNMV_STS_CD IN(SELECT MVMT_STS_CD FROM MDM_MVMT_STS WHERE MVMT_STS_CD NOT IN('VL','XX'))" ).append("\n"); 
		query.append("        AND A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("             'CD'" ).append("\n"); 
		query.append("            ,'CE'" ).append("\n"); 
		query.append("            ,'CI'" ).append("\n"); 
		query.append("            ,'CM'" ).append("\n"); 
		query.append("            ,'CO'" ).append("\n"); 
		query.append("            ,'CP'" ).append("\n"); 
		query.append("            ,'CT'" ).append("\n"); 
		query.append("            ,'CX'" ).append("\n"); 
		query.append("            ,'EN'" ).append("\n"); 
		query.append("            ,'IC'" ).append("\n"); 
		query.append("            ,'ID'" ).append("\n"); 
		query.append("            ,'MT'" ).append("\n"); 
		query.append("            ,'OC'" ).append("\n"); 
		query.append("            ,'OP'" ).append("\n"); 
		query.append("            ,'TN'" ).append("\n"); 
		query.append("            ,'TS'" ).append("\n"); 
		query.append("            ,'VD'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end	  " ).append("\n"); 
		query.append("    AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("    #if (${rep_cmdt_cd} != '')" ).append("\n"); 
		query.append("       	AND   B.CMDT_CD = @[rep_cmdt_cd]" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append(") A, BKG_CUSTOMER B, BKG_CUSTOMER C, BKG_CUSTOMER D" ).append("\n"); 
		query.append("WHERE A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${upd_usr_id} != '')" ).append("\n"); 
		query.append("AND UPPER(A.UPD_USR_ID) = UPPER(@[upd_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  A.BKG_NO =C.BKG_NO(+)" ).append("\n"); 
		query.append("AND  A.BKG_NO =D.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD(+) ='S'" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("AND D.BKG_CUST_TP_CD(+) ='N'" ).append("\n"); 

	}
}