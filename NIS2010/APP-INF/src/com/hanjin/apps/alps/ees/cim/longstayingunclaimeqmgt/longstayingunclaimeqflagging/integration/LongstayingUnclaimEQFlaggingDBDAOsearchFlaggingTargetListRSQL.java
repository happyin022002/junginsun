/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingTargetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 2011.01.12 [CHM-201108185-01] 남궁진호 - MTY Container에 대해 U/C Flagging을 제거할수 있도록 수정
	  * 2011.01.17 [CHM-201108386-01]  남궁진호 - L/S & U/C Creation의 Cargo Type  FULL 인 경우 기능 보완
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
		params.put("sales_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_del_term",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
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
		query.append("WITH MST_BKG_T AS" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("        A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,B.BL_NO" ).append("\n"); 
		query.append("        ,A.UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("        ,DECODE(A.UCLM_LS_DIV_CD,'L','Y','N') LS_FLG" ).append("\n"); 
		query.append("        ,DECODE(A.UCLM_LS_DIV_CD,'U','Y','N') UC_FLG" ).append("\n"); 
		query.append("		,DECODE(A.UCLM_LS_DIV_CD,NULL,'',TO_CHAR(A.UCLM_DT,'YYYY-MM-DD')) UCLM_DT" ).append("\n"); 
		query.append("        ,(SELECT  MAX(NVL(TO_CHAR(FT_END_DT,'YYYY-MM-DD'),'1111-11-11')||LTRIM(TO_CHAR(FT_DYS,'0000')))" ).append("\n"); 
		query.append("        FROM DMT_CHG_CALC E,DMT_CHG_BKG_CNTR F" ).append("\n"); 
		query.append("        WHERE E.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("        AND E.SYS_AREA_GRP_ID  =  A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        AND E.CNTR_CYC_NO = A. CNMV_CYC_NO" ).append("\n"); 
		query.append("        AND E.CHG_SEQ = 1" ).append("\n"); 
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
		query.append("    	,(SELECT REPLACE(SUBSTR(X.CNTR_MF_GDS_DESC,1,100),CHR(13)||chr(10),' ') MK_DESC" ).append("\n"); 
		query.append("    		FROM BKG_CNTR_MF_DESC X" ).append("\n"); 
		query.append("    	   WHERE A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("    	   AND A.CNTR_NO=X.CNTR_NO" ).append("\n"); 
		query.append("           AND ROWNUM=1" ).append("\n"); 
		query.append("         ) MK_DESC" ).append("\n"); 
		query.append("        ,B.OB_SLS_OFC_CD" ).append("\n"); 
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
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,C.USR_NM" ).append("\n"); 
		query.append("        ,A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        ,A.CNMV_CYC_NO" ).append("\n"); 
		query.append("        ,(SELECT DBMS_LOB.SUBSTR (D.FACT_FND_ACT_DESC, 3900, 1) FACT_FND_ACT_DESC" ).append("\n"); 
		query.append("          FROM CIM_UC_CGO_CNTR C, CIM_UC_CGO_DTL D, CIM_UC_CGO E" ).append("\n"); 
		query.append("          WHERE C.UC_CS_NO = D.UC_CS_NO" ).append("\n"); 
		query.append("           AND C.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("           AND C.UC_CS_NO = E.UC_CS_NO" ).append("\n"); 
		query.append("           AND E.UC_STS_CD IN ('OS', 'CA')" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("         ) FACT_FND_ACT_DESC" ).append("\n"); 
		query.append("         ,B.POR_CD " ).append("\n"); 
		query.append("         ,B.POL_CD " ).append("\n"); 
		query.append("         ,B.POD_CD " ).append("\n"); 
		query.append("         ,B.DEL_CD " ).append("\n"); 
		query.append("         ,B.RCV_TERM_CD   " ).append("\n"); 
		query.append("         ,B.DE_TERM_CD   " ).append("\n"); 
		query.append("         ,DECODE(B.RFA_NO,NULL,(DECODE(B.SC_NO,NULL,B.TAA_NO,B.SC_NO)),B.RFA_NO) CTRT_NO" ).append("\n"); 
		query.append("         ,DECODE(A.UPD_DT,NULL,'',TO_CHAR(A.UPD_DT,'YYYY-MM-DD')) UPD_DT " ).append("\n"); 
		query.append("    FROM MST_CONTAINER A, BKG_BOOKING B, COM_USER C" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND   A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("    AND   A.CNTR_USE_CO_CD = 'H'" ).append("\n"); 
		query.append("    AND   A.UPD_USR_ID = C.USR_ID(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("	#if (${loc_type_code} == '4')   --RCC" ).append("\n"); 
		query.append("	    AND   A.RCC_CD = @[loc_cd]	" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '1')   --LCC" ).append("\n"); 
		query.append("	    AND   A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '2')   --ECC" ).append("\n"); 
		query.append("	    AND   A.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '3')   --SCC" ).append("\n"); 
		query.append("	    AND   A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cust_cd} != '' && ${bkg_cust_tp_cd} != 'T' )" ).append("\n"); 
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
		query.append("#if (${loc_cd} == '')" ).append("\n"); 
		query.append("        AND   CEIL(TO_DATE(TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(A.RCC_CD),'YYYYMMDD HH24:mi:SS'), 'yyyy-MM-dd HH24:mi:SS') - A.CNMV_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${over_stay_days} != '')" ).append("\n"); 
		query.append("        AND   CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - A.CNMV_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("    #end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("    #if (${rep_cmdt_cd} != '')" ).append("\n"); 
		query.append("       	AND   B.CMDT_CD = @[rep_cmdt_cd]" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("    #if (${sales_ofc_cd} != '') " ).append("\n"); 
		query.append("       	AND   B.OB_SLS_OFC_CD = @[sales_ofc_cd]" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("MVMT_T AS" ).append("\n"); 
		query.append("(SELECT /*+ INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("        A.VNDR_SEQ VNDR_SEQ2" ).append("\n"); 
		query.append("       ,A.CNTR_NO" ).append("\n"); 
		query.append("       ,A.CNMV_YR" ).append("\n"); 
		query.append("       ,A.CNMV_ID_NO" ).append("\n"); 
		query.append("   FROM CTM_MOVEMENT A, MST_BKG_T B" ).append("\n"); 
		query.append("  WHERE A.CNTR_NO = B.CNTR_NO " ).append("\n"); 
		query.append("    AND A.CNMV_YR = B.CNMV_YR" ).append("\n"); 
		query.append("    AND A.CNMV_ID_NO = B.CNMV_ID_NO  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT AA.*" ).append("\n"); 
		query.append("      ,DECODE(AA.VNDR_EML2, '', AA.VNDR_EML1, AA.VNDR_EML1  ||';'|| AA.VNDR_EML2) VNDR_EML" ).append("\n"); 
		query.append("      ,BB.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("    A.CNTR_NO" ).append("\n"); 
		query.append("    ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,A.LSTM_CD" ).append("\n"); 
		query.append("    ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("    ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("    ,A.BKG_NO" ).append("\n"); 
		query.append("    ,A.BL_NO" ).append("\n"); 
		query.append("    ,CASE WHEN STAY_DAYS >99999 THEN" ).append("\n"); 
		query.append("		99999" ).append("\n"); 
		query.append("	 ELSE" ).append("\n"); 
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
		query.append("   " ).append("\n"); 
		query.append("    ,DECODE(A.UC_FLG,'Y', A.FACT_FND_ACT_DESC, A.UCLM_PLN_RMK) UCLM_PLN_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append("    ,REPLACE(SUBSTR(B.CUST_NM,1,50),CHR(13)||chr(10),' ')  SHPR" ).append("\n"); 
		query.append("    ,REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||chr(10),' ')  CNEE" ).append("\n"); 
		query.append("    ,REPLACE(SUBSTR(D.CUST_NM,1,50),CHR(13)||chr(10),' ')  NTFY" ).append("\n"); 
		query.append("    ,A.REP_CMDT_NM" ).append("\n"); 
		query.append("	,A.MK_DESC MK_DESC" ).append("\n"); 
		query.append("    ,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,DECODE(A.DMG_FLG,'Y',A.DMG_FLG,'') DMG_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.DISP_FLG,'Y',A.DISP_FLG,'') DISP_FLG" ).append("\n"); 
		query.append("    ,A.CNMV_YR" ).append("\n"); 
		query.append("	,A.CNMV_ID_NO" ).append("\n"); 
		query.append("	,A.CNMV_GMT_DT" ).append("\n"); 
		query.append("	,A.CNMV_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.UCLM_FREE_DYS" ).append("\n"); 
		query.append("    ,A.UCLM_END_DT" ).append("\n"); 
		query.append("    ,A.FULL_FLG" ).append("\n"); 
		query.append("    ,A.CRE_USR_ID" ).append("\n"); 
		query.append("	,A.UCLM_RSN TEMP_UCLM_RSN" ).append("\n"); 
		query.append("    ,A.FACT_FND_ACT_DESC" ).append("\n"); 
		query.append("    ,A.POR_CD " ).append("\n"); 
		query.append("    ,A.POL_CD " ).append("\n"); 
		query.append("    ,A.POD_CD " ).append("\n"); 
		query.append("    ,A.DEL_CD " ).append("\n"); 
		query.append("    ,A.RCV_TERM_CD " ).append("\n"); 
		query.append("    ,A.DE_TERM_CD  " ).append("\n"); 
		query.append("    ,A.CTRT_NO          " ).append("\n"); 
		query.append("    ,A.UPD_DT" ).append("\n"); 
		query.append("    ,DECODE(A.USR_NM,NULL,A.UPD_USR_ID,A.USR_NM ) UPD_USR_ID " ).append("\n"); 
		query.append("    ,LPAD(NVL(C.CUST_SEQ, '999999'), 6, '0') AS CUST_SEQ " ).append("\n"); 
		query.append("    ,NVL(C.CUST_CNT_CD, 'XX') AS CUST_CNT_CD " ).append("\n"); 
		query.append("    ,A.VNDR_SEQ2" ).append("\n"); 
		query.append("    ,(SELECT X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("        FROM MDM_VENDOR X " ).append("\n"); 
		query.append("       WHERE X.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("         AND X.DELT_FLG = 'N') VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("    ,(SELECT B.PHN_NO " ).append("\n"); 
		query.append("        FROM MDM_VNDR_CNTC_PNT  B " ).append("\n"); 
		query.append("       WHERE B.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("         AND B.DELT_FLG ='N' " ).append("\n"); 
		query.append("         AND B.PHN_NO IS NOT NULL " ).append("\n"); 
		query.append("         AND ROWNUM = 1) PHN_NO " ).append("\n"); 
		query.append("    ,(SELECT B.VNDR_EML          " ).append("\n"); 
		query.append("        FROM MDM_VNDR_CNTC_PNT  B" ).append("\n"); 
		query.append("       WHERE B.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("         AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("         AND B.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("         AND ROWNUM = 1) VNDR_EML1" ).append("\n"); 
		query.append("    ,(SELECT B.VNDR_EML" ).append("\n"); 
		query.append("        FROM MDM_VNDR_CNTC_PNT  B" ).append("\n"); 
		query.append("       WHERE B.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("         AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("         AND B.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("         AND B.VNDR_EML <> (SELECT B.VNDR_EML" ).append("\n"); 
		query.append("                              FROM MDM_VNDR_CNTC_PNT  B" ).append("\n"); 
		query.append("                             WHERE B.VNDR_SEQ = A.VNDR_SEQ2" ).append("\n"); 
		query.append("                               AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("                               AND B.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("        AND ROWNUM = 1) VNDR_EML2     " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  C.*" ).append("\n"); 
		query.append("           ,D.VNDR_SEQ2" ).append("\n"); 
		query.append("      FROM    " ).append("\n"); 
		query.append("      MST_BKG_T C, MVMT_T D" ).append("\n"); 
		query.append("   WHERE C.CNTR_NO = D.CNTR_NO(+) " ).append("\n"); 
		query.append("     AND C.CNMV_YR = D.CNMV_YR(+)" ).append("\n"); 
		query.append("     AND C.CNMV_ID_NO = D.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("#if (${code_flg} == 'CD00764' && ${rcv_del_term} != '')  " ).append("\n"); 
		query.append("	 AND C.RCV_TERM_CD = @[rcv_del_term]	" ).append("\n"); 
		query.append("#elseif (${code_flg} == 'CD00765' && ${rcv_del_term} != '')   " ).append("\n"); 
		query.append("	 AND C.DE_TERM_CD = @[rcv_del_term]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A, BKG_CUSTOMER B, BKG_CUSTOMER C, BKG_CUSTOMER D" ).append("\n"); 
		query.append("WHERE A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("AND  A.BKG_NO =C.BKG_NO(+)" ).append("\n"); 
		query.append("AND  A.BKG_NO =D.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD(+) ='S'" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("AND D.BKG_CUST_TP_CD(+) ='N') AA, MDM_CUSTOMER BB" ).append("\n"); 
		query.append("WHERE AA.CUST_SEQ = BB.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND AA.CUST_CNT_CD = BB.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND BB.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  AND BB.CNTR_DIV_FLG(+) = 'Y'" ).append("\n"); 
		query.append("#if (${cust_cd} != '' && ${bkg_cust_tp_cd} == 'T')" ).append("\n"); 
		query.append("  AND AA.CTRT_NO = @[cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}