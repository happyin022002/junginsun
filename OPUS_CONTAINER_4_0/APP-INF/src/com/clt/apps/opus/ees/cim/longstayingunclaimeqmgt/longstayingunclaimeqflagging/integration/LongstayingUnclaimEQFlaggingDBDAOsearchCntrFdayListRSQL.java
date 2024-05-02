/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchCntrFdayListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.10 
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

public class LongstayingUnclaimEQFlaggingDBDAOsearchCntrFdayListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location 조건에 따라 현재 기준의 container정보를 조회
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchCntrFdayListRSQL(){
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
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_free_days",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchCntrFdayListRSQL").append("\n"); 
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
		query.append("SELECT SUB_LOC_CD" ).append("\n"); 
		query.append("      ,CRNT_YD_CD" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	  ,LSTM_CD" ).append("\n"); 
		query.append("      ,CNMV_STS_CD" ).append("\n"); 
		query.append("	  ,FULL_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("      ,LTRIM(TO_CHAR(STAY_DAYS,'9,999')) STAY_DAYS" ).append("\n"); 
		query.append("      ,FREE_DAYS" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,POR_CD" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,LOAD_VVD" ).append("\n"); 
		query.append("      ,DISC_VVD" ).append("\n"); 
		query.append("	  #if (${ts_cntr_behind} != '')" ).append("\n"); 
		query.append("      ,POL_ATD" ).append("\n"); 
		query.append("	  #else" ).append("\n"); 
		query.append("      ,POL_ATD1" ).append("\n"); 
		query.append("      #end POL_ETD" ).append("\n"); 
		query.append("	  ,SC_RFA_NO" ).append("\n"); 
		query.append("      #if (${view_customer} == 'Y')" ).append("\n"); 
		query.append("      ,SHPR" ).append("\n"); 
		query.append("      ,CNEE" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${view_commodity} == 'Y')" ).append("\n"); 
		query.append("      ,REP_CMDT_NM" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      ,DMG_FLG" ).append("\n"); 
		query.append("      ,OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	  ,OB_SREP_CD" ).append("\n"); 
		query.append("      ,UCLM_LS_FLG" ).append("\n"); 
		query.append("      ,DE_TERM_CD" ).append("\n"); 
		query.append("	  ,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	  ,DMG_FLG_DT" ).append("\n"); 
		query.append("	  ,DMG_UNFLG_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT  A.SUB_LOC_CD" ).append("\n"); 
		query.append("			,A.CRNT_YD_CD" ).append("\n"); 
		query.append("            ,A.CNTR_NO" ).append("\n"); 
		query.append("            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("            ,A.CNMV_DT" ).append("\n"); 
		query.append("            ,B.POR_CD" ).append("\n"); 
		query.append("            ,B.DEL_CD" ).append("\n"); 
		query.append("            ,A.DISC_VVD" ).append("\n"); 
		query.append("			,A.LSTM_CD" ).append("\n"); 
		query.append("            ,SUBSTR(A.LOAD_VVD,1,9) LOAD_VVD" ).append("\n"); 
		query.append("            ,(SELECT /*+ INDEX_DESC( D XPKVSK_VSL_PORT_SKD ) */" ).append("\n"); 
		query.append("                     TO_CHAR(E.ACT_DEP_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("             FROM VSK_VSL_PORT_SKD D,VSK_ACT_PORT_SKD E" ).append("\n"); 
		query.append("             WHERE SUBSTR(A.LOAD_VVD,1,4) = D.VSL_CD" ).append("\n"); 
		query.append("             AND SUBSTR(A.LOAD_VVD,5,4) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND SUBSTR(A.LOAD_VVD,9,1) = D.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND SUBSTR(A.CRNT_YD_CD,1,5) = D.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND D.YD_CD = SUBSTR(A.LOAD_VVD,10,7)" ).append("\n"); 
		query.append("             AND D.VSL_CD=E.VSL_CD" ).append("\n"); 
		query.append("             AND D.SKD_VOY_NO=E.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND D.SKD_DIR_CD=E.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND D.VPS_PORT_CD=E.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND D.CLPT_IND_SEQ=E.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM =1)  POL_ATD" ).append("\n"); 
		query.append("            ,DECODE(A.LOAD_VVD,NULL,'',(SELECT /*+ INDEX_DESC(D XPKVSK_VSL_PORT_SKD ) */" ).append("\n"); 
		query.append("                                          TO_CHAR(MAX(D.VPS_ETD_DT),'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                   FROM VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append("                                   WHERE D.VSL_CD = SUBSTR(A.LOAD_VVD,1,4)" ).append("\n"); 
		query.append("                                   AND D.SKD_VOY_NO = SUBSTR(A.LOAD_VVD,5,4)" ).append("\n"); 
		query.append("                                   AND D.SKD_DIR_CD = SUBSTR(A.LOAD_VVD,9,1)" ).append("\n"); 
		query.append("                                   AND D.YD_CD = SUBSTR(A.LOAD_VVD,10,7))) POL_ATD1" ).append("\n"); 
		query.append("            ,B.SC_NO||B.RFA_NO SC_RFA_NO" ).append("\n"); 
		query.append("            ,CEIL(TO_DATE(@[rcc_date],'YYYY-MM-DD HH24:MI:SS') - A.CNMV_DT) STAY_DAYS" ).append("\n"); 
		query.append("            ,A.FREE_DAYS" ).append("\n"); 
		query.append("            ,A.BKG_NO" ).append("\n"); 
		query.append("            ,B.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,(SELECT REPLACE(REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||CHR(10),' '), CHR(10), ' ')  SHPR" ).append("\n"); 
		query.append("               FROM   BKG_CUSTOMER C" ).append("\n"); 
		query.append("               WHERE  A.BKG_NO         = C.BKG_NO" ).append("\n"); 
		query.append("               AND    C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("            ) SHPR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,(SELECT REPLACE(REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||CHR(10),' '), CHR(10), ' ')  CNEE" ).append("\n"); 
		query.append("               FROM   BKG_CUSTOMER C" ).append("\n"); 
		query.append("               WHERE  A.BKG_NO         = C.BKG_NO" ).append("\n"); 
		query.append("               AND    C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("            ) CNEE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,(SELECT D.CMDT_NM" ).append("\n"); 
		query.append("               FROM   MDM_COMMODITY D" ).append("\n"); 
		query.append("               WHERE  B.CMDT_CD = D.CMDT_CD" ).append("\n"); 
		query.append("            ) REP_CMDT_NM" ).append("\n"); 
		query.append("            ,B.OB_SLS_OFC_CD OB_SLS_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,B.OB_SREP_CD OB_SREP_CD" ).append("\n"); 
		query.append("			,A.FULL_FLG" ).append("\n"); 
		query.append("			,B.RCV_TERM_CD||'/'||B.DE_TERM_CD DE_TERM_CD" ).append("\n"); 
		query.append("			,A.DMG_FLG" ).append("\n"); 
		query.append("			,A.UCLM_LS_FLG" ).append("\n"); 
		query.append("			,B.BKG_CGO_TP_CD BKG_CGO_TP_CD" ).append("\n"); 
		query.append("			,A.DMG_FLG_DT DMG_FLG_DT" ).append("\n"); 
		query.append("			,A.DMG_UNFLG_DT DMG_UNFLG_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT  DECODE('2','1',LCC_CD,'2',SCC_CD,'3',SCC_CD,'4',SCC_CD,'5',SCC_CD) SUB_LOC_CD" ).append("\n"); 
		query.append("			,A.CRNT_YD_CD" ).append("\n"); 
		query.append("            ,A.CNTR_NO" ).append("\n"); 
		query.append("            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("            ,A.CNMV_DT" ).append("\n"); 
		query.append("            ,A.LSTM_CD        " ).append("\n"); 
		query.append("            ,DECODE(A.CNMV_STS_CD,'MT',(SELECT M.CRNT_VSL_CD||M.CRNT_SKD_VOY_NO||M.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("										FROM  CTM_MOVEMENT M" ).append("\n"); 
		query.append("										WHERE A.CNTR_NO=M.CNTR_NO" ).append("\n"); 
		query.append("										AND   A.BKG_NO=M.BKG_NO" ).append("\n"); 
		query.append("										AND   M.MVMT_STS_CD='VD'" ).append("\n"); 
		query.append("										AND   M.BKG_CGO_TP_CD='P'" ).append("\n"); 
		query.append("										AND   A.CRNT_YD_CD = M.ORG_YD_CD" ).append("\n"); 
		query.append("										AND   ROWNUM = 1" ).append("\n"); 
		query.append("										)," ).append("\n"); 
		query.append("										(SELECT B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("										FROM BKG_VVD B" ).append("\n"); 
		query.append("										WHERE  A.BKG_NO=B.BKG_NO" ).append("\n"); 
		query.append("										AND    SUBSTR(A.CRNT_YD_CD,1,5) = B.POD_CD" ).append("\n"); 
		query.append("										AND    A.CNMV_STS_CD IN('TS','IC','ID')" ).append("\n"); 
		query.append("										AND ROWNUM = 1" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("                    ) DISC_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,(SELECT /*+ INDEX(B XPKBKG_VVD) */ B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD||B.POL_YD_CD" ).append("\n"); 
		query.append("                FROM BKG_VVD B" ).append("\n"); 
		query.append("                WHERE  A.BKG_NO=B.BKG_NO" ).append("\n"); 
		query.append("                AND    A.CNMV_STS_CD IN('TS','OP','OC')" ).append("\n"); 
		query.append("                AND    DECODE(A.CNMV_STS_CD,'TS',SUBSTR(A.CRNT_YD_CD,1,5),'1') = DECODE(A.CNMV_STS_CD,'TS',B.POL_CD,'1')" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("             ) LOAD_VVD" ).append("\n"); 
		query.append("            ,(SELECT  TO_NUMBER(SUBSTR(MAX(NVL(TO_CHAR(FT_END_DT,'YYYY-MM-DD'),'1111-11-11')||LTRIM(TO_CHAR(FT_DYS,'0000'))),11))" ).append("\n"); 
		query.append("				FROM DMT_CHG_CALC E,DMT_CHG_BKG_CNTR F" ).append("\n"); 
		query.append("                WHERE E.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                AND E.SYS_AREA_GRP_ID  =  A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND E.CNTR_CYC_NO = A. CNMV_CYC_NO" ).append("\n"); 
		query.append("                AND E.CHG_SEQ = 1" ).append("\n"); 
		query.append("                AND E.FM_MVMT_YD_CD = A.CRNT_YD_CD" ).append("\n"); 
		query.append("                AND E.DMDT_CHG_STS_CD <> 'E'" ).append("\n"); 
		query.append("                AND F.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                AND F.SYS_AREA_GRP_ID  = E.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                AND F.CNTR_CYC_NO = E.CNTR_CYC_NO" ).append("\n"); 
		query.append("                AND F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                AND A.CNMV_STS_CD NOT IN ('TS','MT')" ).append("\n"); 
		query.append("            ) FREE_DAYS" ).append("\n"); 
		query.append("            ,A.BKG_NO" ).append("\n"); 
		query.append("			,DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG" ).append("\n"); 
		query.append("			,A.DMG_FLG" ).append("\n"); 
		query.append("			,DECODE(A.UCLM_LS_DIV_CD,'U','Y','N') UCLM_LS_FLG" ).append("\n"); 
		query.append("			,MST_COMMON_PKG.MST_DMG_DT_GET_FNC(A.CNTR_NO, 'FLG' ) AS DMG_FLG_DT" ).append("\n"); 
		query.append("			,MST_COMMON_PKG.MST_DMG_DT_GET_FNC(A.CNTR_NO, 'UNFLG' ) AS DMG_UNFLG_DT" ).append("\n"); 
		query.append("        FROM MST_CONTAINER A" ).append("\n"); 
		query.append("        WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("        AND A.CNTR_USE_CO_CD = 'O'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("			AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("            AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("            AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("            AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("            AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("		-- tp/sz option" ).append("\n"); 
		query.append("    	#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("			AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("    		  	SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	    FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	    FROM dual )" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		-- MVMT Status option" ).append("\n"); 
		query.append("		#if (${ts_cntr_behind} != '')" ).append("\n"); 
		query.append("			AND A.CNMV_STS_CD='TS'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("				AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("					SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("					FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("						FROM dual )" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				AND A.CNMV_STS_CD NOT IN('VL','XX','VD')" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("				'CD'" ).append("\n"); 
		query.append("				,'CE'" ).append("\n"); 
		query.append("				,'CI'" ).append("\n"); 
		query.append("				,'CM'" ).append("\n"); 
		query.append("				,'CO'" ).append("\n"); 
		query.append("				,'CP'" ).append("\n"); 
		query.append("				,'CT'" ).append("\n"); 
		query.append("				,'CX'" ).append("\n"); 
		query.append("				,'EN'" ).append("\n"); 
		query.append("				,'IC'" ).append("\n"); 
		query.append("				,'ID'" ).append("\n"); 
		query.append("				,'MT'" ).append("\n"); 
		query.append("				,'OC'" ).append("\n"); 
		query.append("				,'OP'" ).append("\n"); 
		query.append("				,'TN'" ).append("\n"); 
		query.append("				,'TS'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		-- Lease Term option" ).append("\n"); 
		query.append("    	#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    		AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("    			SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        		FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            		FROM dual )" ).append("\n"); 
		query.append("    		)" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("		-- Cargo Type option" ).append("\n"); 
		query.append("    	#if (${full_flg} != '')" ).append("\n"); 
		query.append("    		AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("		-- S.O.C option" ).append("\n"); 
		query.append("    	#if (${soc_cd} != '')" ).append("\n"); 
		query.append("    		#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("    			AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("    		#else" ).append("\n"); 
		query.append("    			AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("        -- Staying Day option" ).append("\n"); 
		query.append("        #if (${over_stay_days} != '')" ).append("\n"); 
		query.append("            AND CEIL(TO_DATE(@[rcc_date],'YYYY-MM-dd HH24:MI:SS') - A.CNMV_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		-- DMG option" ).append("\n"); 
		query.append("    	#if (${dmg_flg} != '')" ).append("\n"); 
		query.append("    		AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("    	#end   " ).append("\n"); 
		query.append("		-- DMG option" ).append("\n"); 
		query.append("    	#if (${dmg_flg} != '')" ).append("\n"); 
		query.append("    		AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("    	#end  " ).append("\n"); 
		query.append("		-- Unclaim option" ).append("\n"); 
		query.append("   		#if (${uclm_ls_div_cd} == 'E')" ).append("\n"); 
		query.append("       		AND NVL(A.UCLM_LS_DIV_CD,'X') <> 'U'" ).append("\n"); 
		query.append("		#elseif(${uclm_ls_div_cd} == 'O')" ).append("\n"); 
		query.append("       		AND A.UCLM_LS_DIV_CD = 'U'" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("		-- Prefix option" ).append("\n"); 
		query.append("    	#if (${cntr_no} != '')" ).append("\n"); 
		query.append("    		AND substr(A.CNTR_NO, 0, 4) = @[cntr_no]" ).append("\n"); 
		query.append("    	#end  " ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("    ) A , BKG_BOOKING B" ).append("\n"); 
		query.append("	WHERE A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("	#if (${next_vvd} != '')" ).append("\n"); 
		query.append("		AND SUBSTR(A.LOAD_VVD,1,9) = @[next_vvd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- Free-Days option " ).append("\n"); 
		query.append("	#if (${over_free_days} != '')" ).append("\n"); 
		query.append("		AND FREE_DAYS >= @[over_free_days]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ts_cntr_behind} != '')" ).append("\n"); 
		query.append("	 AND SUBSTR(@[rcc_date],1,4)||'-'||SUBSTR(@[rcc_date],5,2)||'-'||SUBSTR(@[rcc_date],7,2) > POL_ATD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}