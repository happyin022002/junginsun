/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container List by Location
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL(){
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
		params.put("rcc_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("froms",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tos",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_tp_cd_m",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchCntrListEqWiseByLocRSQL").append("\n"); 
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
		query.append("SELECT      ROW_SEQ" ).append("\n"); 
		query.append("            ,SUB_LOC_CD" ).append("\n"); 
		query.append("            ,CRNT_YD_CD" ).append("\n"); 
		query.append("            ,CNTR_NO" ).append("\n"); 
		query.append("            ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,LSTM_CD" ).append("\n"); 
		query.append("            ,CNMV_STS_CD" ).append("\n"); 
		query.append("            ,FULL_FLG" ).append("\n"); 
		query.append("			,CGO_TP_CD    " ).append("\n"); 
		query.append("            ,CNMV_DT  " ).append("\n"); 
		query.append("            ,STAY_DAYS" ).append("\n"); 
		query.append("			,CNTR_GRS_WGT" ).append("\n"); 
		query.append("       		,TARE_WGT" ).append("\n"); 
		query.append("       		,PAY_LOAD" ).append("\n"); 
		query.append("            ,BKG_NO" ).append("\n"); 
		query.append("            ,BL_NO  " ).append("\n"); 
		query.append("			,REF_ID  " ).append("\n"); 
		query.append("            ,VVD    " ).append("\n"); 
		query.append("            ,DMG_FLG" ).append("\n"); 
		query.append("            ,CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("            ,MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("            ,CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("            ,DISP_FLG" ).append("\n"); 
		query.append("            ,IMDT_EXT_FLG" ).append("\n"); 
		query.append("            ,UCLM_LS_FLG" ).append("\n"); 
		query.append("            ,PLST_FLR_FLG" ).append("\n"); 
		query.append("            ,DE_TERM_CD" ).append("\n"); 
		query.append("            ,RF_TP_CD 		" ).append("\n"); 
		query.append("            ,OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	      	,AGMT_NO" ).append("\n"); 
		query.append("            ,LESSOR_CD" ).append("\n"); 
		query.append("            ,LESSOR" ).append("\n"); 
		query.append("            ,MFT_DT " ).append("\n"); 
		query.append("            ,RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("            ,RSTR_USG_LBL_DESC" ).append("\n"); 
		query.append("			,RF_MKR_SEQ" ).append("\n"); 
		query.append("            ,RF_MDL_NM" ).append("\n"); 
		query.append("            ,RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("			,APNT_BKG_NO  " ).append("\n"); 
		query.append("			,DMG_FLG_DT" ).append("\n"); 
		query.append("			,DMG_UNFLG_DT 	" ).append("\n"); 
		query.append("FROM       (  " ).append("\n"); 
		query.append("SELECT      ROW_NUMBER() OVER (ORDER BY A.CNTR_NO) AS ROW_SEQ" ).append("\n"); 
		query.append("            ,A.SUB_LOC_CD" ).append("\n"); 
		query.append("            ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("            ,A.CNTR_NO" ).append("\n"); 
		query.append("            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,A.LSTM_CD" ).append("\n"); 
		query.append("            ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("            ,A.FULL_FLG" ).append("\n"); 
		query.append("			,A.CGO_TP_CD    " ).append("\n"); 
		query.append("            ,A.CNMV_DT  " ).append("\n"); 
		query.append("            ,LTRIM(TO_CHAR(A.STAY_DAYS,'9,999')) STAY_DAYS" ).append("\n"); 
		query.append("			,RTRIM(TO_CHAR(ROUND(TO_NUMBER(A.TARE_WGT), 3), 'FM9999999999999990D000'), '.') TARE_WGT" ).append("\n"); 
		query.append("			,RTRIM(TO_CHAR(ROUND(TO_NUMBER(A.CNTR_GRS_WGT), 3), 'FM9999999999999990D000'), '.') CNTR_GRS_WGT" ).append("\n"); 
		query.append("			,RTRIM(TO_CHAR(ROUND(TO_NUMBER(A.PAY_LOAD), 3), 'FM9999999999999990D000'), '.') PAY_LOAD" ).append("\n"); 
		query.append("            ,A.BKG_NO" ).append("\n"); 
		query.append("            ,A.BL_NO  " ).append("\n"); 
		query.append("			,A.REF_ID" ).append("\n"); 
		query.append("            ,A.VVD    " ).append("\n"); 
		query.append("            ,DECODE(A.DMG_FLG,'Y',A.DMG_FLG,'') DMG_FLG" ).append("\n"); 
		query.append("            ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID='CD02012' AND INTG_CD_VAL_CTNT=A.CNTR_HNGR_RCK_CD) CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("            ,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("            ,A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("            ,DECODE(A.DISP_FLG,'Y',A.DISP_FLG,'') DISP_FLG" ).append("\n"); 
		query.append("            ,DECODE(A.IMDT_EXT_FLG,'Y',A.IMDT_EXT_FLG,'') IMDT_EXT_FLG" ).append("\n"); 
		query.append("            ,DECODE(A.UCLM_LS_FLG,'Y',A.UCLM_LS_FLG,'') UCLM_LS_FLG" ).append("\n"); 
		query.append("            ,DECODE(A.PLST_FLR_FLG,'Y',A.PLST_FLR_FLG,'') PLST_FLR_FLG" ).append("\n"); 
		query.append("            ,A.DE_TERM_CD" ).append("\n"); 
		query.append("            ,A.RF_TP_CD 						          " ).append("\n"); 
		query.append("            #if (${view_customer} == 'Y')" ).append("\n"); 
		query.append("                ,REPLACE(REPLACE(SUBSTR(B.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ') SHPR" ).append("\n"); 
		query.append("                ,REPLACE(REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ')  CNEE" ).append("\n"); 
		query.append("                ,REPLACE(REPLACE(SUBSTR(D.CUST_NM,1,50),CHR(13)||chr(10),' '), CHR(10), ' ')  NTFY" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${view_commodity} == 'Y')" ).append("\n"); 
		query.append("                ,(SELECT D.CMDT_NM FROM MDM_COMMODITY D" ).append("\n"); 
		query.append("                  WHERE   A.CMDT_CD = D.CMDT_CD" ).append("\n"); 
		query.append("                 ) REP_CMDT_NM" ).append("\n"); 
		query.append("                ,(SELECT REPLACE(REPLACE(SUBSTR(X.CNTR_MF_GDS_DESC,1,100),CHR(13)||chr(10),' '), CHR(10), ' ') MK_DESC" ).append("\n"); 
		query.append("                    FROM BKG_CNTR_MF_DESC X" ).append("\n"); 
		query.append("                   WHERE A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                   AND A.CNTR_NO=X.CNTR_NO" ).append("\n"); 
		query.append("                   AND ROWNUM=1" ).append("\n"); 
		query.append("                 ) MK_DESC" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            ,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("			,A.AGMT_NO" ).append("\n"); 
		query.append("            ,A.LESSOR_CD" ).append("\n"); 
		query.append("            ,(SELECT X.VNDR_ABBR_NM" ).append("\n"); 
		query.append("              FROM MDM_VENDOR X" ).append("\n"); 
		query.append("              WHERE A.VNDR_SEQ = X.VNDR_SEQ) LESSOR" ).append("\n"); 
		query.append("            ,A.MFT_DT " ).append("\n"); 
		query.append("            #if (${over_stay_days} != '' &&  ${over_stay_days} != '0')" ).append("\n"); 
		query.append("                ,NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0) FT_DYS" ).append("\n"); 
		query.append("                ,SUBSTR(A.FT_END_DYS,1,10) FT_END_DT" ).append("\n"); 
		query.append("                ,CASE WHEN A.STAY_DAYS-NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0) >99999 THEN" ).append("\n"); 
		query.append("                    99999" ).append("\n"); 
		query.append("                 ELSE" ).append("\n"); 
		query.append("                    A.STAY_DAYS-NVL(TO_NUMBER(SUBSTR(A.FT_END_DYS,11,4)),0)" ).append("\n"); 
		query.append("                 END  ACT_DYS " ).append("\n"); 
		query.append("            #end  " ).append("\n"); 
		query.append("            --,A.RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("			,A.RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("            ,A.RSTR_USG_LBL_DESC" ).append("\n"); 
		query.append("			,RF_MKR_SEQ" ).append("\n"); 
		query.append("            ,RF_MDL_NM" ).append("\n"); 
		query.append("            ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID   = 'CD30023' AND INTG_CD_VAL_CTNT = RF_HUMID_CTRL_VAL_CD) AS RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("			,(SELECT BB.BKG_NO AS APNT_BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_CONTAINER BC, BKG_BOOKING BB" ).append("\n"); 
		query.append("               WHERE BB.BKG_NO      = BC.BKG_NO" ).append("\n"); 
		query.append("                 AND BC.CNMV_CYC_NO = 9999" ).append("\n"); 
		query.append("                 AND BB.BKG_STS_CD  NOT IN ('W', 'X')" ).append("\n"); 
		query.append("                 AND BC.CNTR_NO     = A.CNTR_NO" ).append("\n"); 
		query.append("                 AND ROWNUM         = 1" ).append("\n"); 
		query.append("             ) AS APNT_BKG_NO" ).append("\n"); 
		query.append("			,A.DMG_FLG_DT" ).append("\n"); 
		query.append("			,A.DMG_UNFLG_DT" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (    " ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                DECODE(@[loc_type_code],'1',LCC_CD,'2',SCC_CD,'3',SCC_CD,'4',SCC_CD,'5',SCC_CD,'6',SCC_CD,'7',SCC_CD,'8',SCC_CD,'9',SCC_CD) SUB_LOC_CD" ).append("\n"); 
		query.append("                ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("                ,A.CNTR_NO" ).append("\n"); 
		query.append("                ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ,A.LSTM_CD" ).append("\n"); 
		query.append("                ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("                ,DECODE(A.FULL_FLG,'Y','F','M') FULL_FLG" ).append("\n"); 
		query.append("				,B.BKG_CGO_TP_CD AS CGO_TP_CD" ).append("\n"); 
		query.append("                ,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("                ,CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - A.CNMV_DT) STAY_DAYS" ).append("\n"); 
		query.append("				,MST_SPEC_FNC('TARE', A.CNTR_NO) TARE_WGT " ).append("\n"); 
		query.append("                ,MST_SPEC_FNC('GRSS', A.CNTR_NO) CNTR_GRS_WGT" ).append("\n"); 
		query.append("                ,MST_SPEC_FNC('PAYL', A.CNTR_NO) PAY_LOAD" ).append("\n"); 
		query.append("                ,A.BKG_NO" ).append("\n"); 
		query.append("                ,B.BL_NO" ).append("\n"); 
		query.append("				,NVL(D.MTY_PLN_NO, D.MTY_REPO_NO)  AS REF_ID" ).append("\n"); 
		query.append("                ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                ,A.DMG_FLG" ).append("\n"); 
		query.append("                ,A.CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("                ,A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("                ,A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("                ,A.DISP_FLG" ).append("\n"); 
		query.append("                ,A.IMDT_EXT_FLG" ).append("\n"); 
		query.append("                ,DECODE(A.UCLM_LS_DIV_CD,'U','Y','N') UCLM_LS_FLG" ).append("\n"); 
		query.append("                ,A.PLST_FLR_FLG" ).append("\n"); 
		query.append("                ,B.RCV_TERM_CD||'/'||B.DE_TERM_CD DE_TERM_CD" ).append("\n"); 
		query.append("                ,(SELECT CID.INTG_CD_VAL_DP_DESC ||' (' ||CID.INTG_CD_VAL_DESC || ')' AS RF_TP_CD " ).append("\n"); 
		query.append("                   FROM COM_INTG_CD_DTL CID " ).append("\n"); 
		query.append("                  WHERE 1=1 " ).append("\n"); 
		query.append("                    AND CID.INTG_CD_VAL_CTNT = A.RF_TP_CD " ).append("\n"); 
		query.append("                    AND CID.INTG_CD_ID   = 'CD01085') AS RF_TP_CD" ).append("\n"); 
		query.append("                ,B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("				,TO_CHAR(A.MFT_DT,'YYYY-MM-DD') MFT_DT" ).append("\n"); 
		query.append("                ,A.VNDR_SEQ" ).append("\n"); 
		query.append("                ,B.CMDT_CD" ).append("\n"); 
		query.append("                #if (${over_stay_days} != '' &&  ${over_stay_days} != '0')" ).append("\n"); 
		query.append("                    ,(SELECT  MAX(NVL(TO_CHAR(FT_END_DT,'YYYY-MM-DD'),'1111-11-11')||LTRIM(TO_CHAR(FT_DYS,'0000')))" ).append("\n"); 
		query.append("                    FROM DMT_CHG_CALC E,DMT_CHG_BKG_CNTR F" ).append("\n"); 
		query.append("                    WHERE E.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                    AND E.SYS_AREA_GRP_ID  =  A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                    AND E.CNTR_CYC_NO = A. CNMV_CYC_NO" ).append("\n"); 
		query.append("                    AND E.CHG_SEQ = 1" ).append("\n"); 
		query.append("                    AND E.FM_MVMT_YD_CD = A.CRNT_YD_CD" ).append("\n"); 
		query.append("                    AND E.DMDT_CHG_STS_CD <> 'E'" ).append("\n"); 
		query.append("                    AND F.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("                    AND F.SYS_AREA_GRP_ID  = E.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                    AND F.CNTR_CYC_NO = E.CNTR_CYC_NO" ).append("\n"); 
		query.append("                    AND F.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                    AND A.CNMV_STS_CD NOT IN ('TS','MT')" ).append("\n"); 
		query.append("                    ) FT_END_DYS  " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("				--,MST_COMMON_PKG.MST_RU_LBL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("				,MST_COMMON_PKG.MST_RU_TP_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("                ,MST_COMMON_PKG.MST_RU_VAL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_DESC " ).append("\n"); 
		query.append("				,(SELECT NVL(VNDR_ABBR_NM, VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("                    FROM MDM_VENDOR " ).append("\n"); 
		query.append("                   WHERE VNDR_SEQ = CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.RF_MKR_SEQ ELSE C.RF_MKR_SEQ END" ).append("\n"); 
		query.append("                  )AS RF_MKR_SEQ" ).append("\n"); 
		query.append("                ,CASE WHEN A.LSTM_CD='LT' OR A.LSTM_CD = 'ST' THEN A.RF_MDL_NM ELSE C.RF_MDL_NM END AS RF_MDL_NM" ).append("\n"); 
		query.append("                ,A.RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("				,MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("        		,MST_COMMON_PKG.MST_VNDR_SEQ_CONV_FNC(A.VNDR_SEQ) AS LESSOR_CD	" ).append("\n"); 
		query.append("				,MST_COMMON_PKG.MST_DMG_DT_GET_FNC(A.CNTR_NO, 'FLG') AS DMG_FLG_DT " ).append("\n"); 
		query.append("				,MST_COMMON_PKG.MST_DMG_DT_GET_FNC(A.CNTR_NO, 'UNFLG') AS DMG_UNFLG_DT" ).append("\n"); 
		query.append("            FROM MST_CONTAINER A,BKG_BOOKING B,MST_CNTR_LOT C, CTM_MOVEMENT D, MST_CNTR_SPEC E" ).append("\n"); 
		query.append("            WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("			AND   A.CNTR_SPEC_NO = E.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("			AND   A.LOT_PLN_YR   = C.LOT_PLN_YR(+)" ).append("\n"); 
		query.append("            AND   A.LOT_LOC_CD   = C.LOT_LOC_CD(+)" ).append("\n"); 
		query.append("            AND   A.LOT_SEQ      = C.LOT_SEQ(+)" ).append("\n"); 
		query.append("            AND   A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("            AND   A.BKG_NO       = B.BKG_NO(+)" ).append("\n"); 
		query.append("			AND   'Y'			 = C.OWN_CNTR_FLG(+)" ).append("\n"); 
		query.append("			AND   A.CNTR_NO    = D.CNTR_NO(+)" ).append("\n"); 
		query.append("            AND   A.CNMV_YR    = D.CNMV_YR(+)" ).append("\n"); 
		query.append("            AND   A.CNMV_ID_NO = D.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("            #if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("                AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("            #elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("                AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("            #elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("                AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("            #elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("                AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("            #elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("                AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("			#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("				AND A.BKG_NO IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${loccd_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $loccd_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("			#elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("				 AND NVL(D.MTY_PLN_NO, D.MTY_REPO_NO) IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${loccd_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $loccd_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("			#elseif (${loc_type_code} == '9')" ).append("\n"); 
		query.append("				AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${loccd_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $loccd_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${full_flg} != '')" ).append("\n"); 
		query.append("                AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("                                     SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                     FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                     FROM dual )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${imdt_ext_flg} != '')" ).append("\n"); 
		query.append("                AND A.IMDT_EXT_FLG =@[imdt_ext_flg]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${plst_flr_flg} != '')" ).append("\n"); 
		query.append("                AND A.PLST_FLR_FLG =@[plst_flr_flg]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("                AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("            #end      " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${cntr_no} != '')" ).append("\n"); 
		query.append("                AND SUBSTR(A.CNTR_NO,0,4) = @[cntr_no]" ).append("\n"); 
		query.append("            #end  " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_cntr} != '' || ${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("                AND A.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("            #end  " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_tp_cd_m} != '')" ).append("\n"); 
		query.append("                AND A.RF_TP_CD IN(@[rf_tp_cd_c],@[rf_tp_cd_h],@[rf_tp_cd_m])" ).append("\n"); 
		query.append("            #end  " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${rd_cgo_flg} != '' || ${rf_cntr} != '')" ).append("\n"); 
		query.append("                AND B.RD_CGO_FLG IN(@[rf_cntr],@[rd_cgo_flg])" ).append("\n"); 
		query.append("            #end          " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${soc_cd} != '')" ).append("\n"); 
		query.append("                #if (${soc_cd} == '1')" ).append("\n"); 
		query.append("                    AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${uclm_ls_div_cd} == 'E')" ).append("\n"); 
		query.append("                AND NVL(A.UCLM_LS_DIV_CD,'X') <> 'U'" ).append("\n"); 
		query.append("            #elseif(${uclm_ls_div_cd} == 'O')" ).append("\n"); 
		query.append("                AND A.UCLM_LS_DIV_CD = 'U'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("                AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("                                     SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                     FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                     FROM dual )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                AND A.CNMV_STS_CD NOT IN('VL','XX','VD')" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                AND A.CNMV_STS_CD NOT IN('VL','XX','VD')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${over_stay_days} != '')" ).append("\n"); 
		query.append("                AND  CEIL(TO_DATE(@[rcc_date],'yyyy-MM-dd HH24:mi:SS') - CNMV_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("                AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("                                     SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                     FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                                     FROM dual )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${cntr_hngr_rck_cd} != '')" ).append("\n"); 
		query.append("                AND (A.CNTR_HNGR_RCK_CD IS NOT NULL  OR  A.CNTR_HNGR_BAR_ATCH_KNT > 0)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${disp_flg} != '')" ).append("\n"); 
		query.append("                AND A.DISP_FLG = @[disp_flg]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${d2_payld_flg} != '')" ).append("\n"); 
		query.append("                AND A.CNTR_TPSZ_CD='D2'" ).append("\n"); 
		query.append("                AND A.D2_PAYLD_FLG = @[d2_payld_flg]" ).append("\n"); 
		query.append("            #end	" ).append("\n"); 
		query.append("            #if (${view_flg} == 'eq') " ).append("\n"); 
		query.append("                #if (${froms} != '') " ).append("\n"); 
		query.append("                    AND TO_CHAR(A.MFT_DT,'YYYY') BETWEEN @[froms] AND @[tos]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${cgo_tp_cd} != 'A')" ).append("\n"); 
		query.append("				AND B.BKG_CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append("				AND	" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM1 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM2 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM3 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM4 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM5 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM6 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM7 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM8 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM9 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM10 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				A.RSTR_USG_TP_LBL_NM11 IN (" ).append("\n"); 
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
		query.append("            " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("        #if (${view_customer} == 'Y')" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER B, BKG_CUSTOMER C, BKG_CUSTOMER D" ).append("\n"); 
		query.append("        WHERE A.BKG_NO =B.BKG_NO(+)" ).append("\n"); 
		query.append("        AND  A.BKG_NO =C.BKG_NO(+)" ).append("\n"); 
		query.append("        AND  A.BKG_NO =D.BKG_NO(+)" ).append("\n"); 
		query.append("        AND B.BKG_CUST_TP_CD(+) ='S'" ).append("\n"); 
		query.append("        AND C.BKG_CUST_TP_CD(+) ='C'" ).append("\n"); 
		query.append("        AND D.BKG_CUST_TP_CD(+) ='N'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("  WHERE 	ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}