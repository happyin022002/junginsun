/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBkgListForObDrblWblRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBkgListForObDrblWblRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgListForObDrblWbl
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBkgListForObDrblWblRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_dt_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_obrd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBkgListForObDrblWblRSQL").append("\n"); 
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
		query.append("SELECT   BKG_NO" ).append("\n"); 
		query.append("        ,BKG_STS_CD" ).append("\n"); 
		query.append("        ,BL_NO" ).append("\n"); 
		query.append("        ,SHPR_CD" ).append("\n"); 
		query.append("        ,SHPR_NM" ).append("\n"); 
		query.append("        ,SHORT_SHPR_NM" ).append("\n"); 
		query.append("        ,FF_CD" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,POD_CD" ).append("\n"); 
		query.append("        ,POR_CD" ).append("\n"); 
		query.append("        ,FAX_NO" ).append("\n"); 
		query.append("        ,EML" ).append("\n"); 
		query.append("        ,CNTC_PSON_NM" ).append("\n"); 
		query.append("        ,FAX_RESULT" ).append("\n"); 
		query.append("        ,FAX_DATE" ).append("\n"); 
		query.append("        ,FAX_REASON" ).append("\n"); 
		query.append("        ,EML_RESULT" ).append("\n"); 
		query.append("        ,EML_DATE" ).append("\n"); 
		query.append("        ,EML_REASON" ).append("\n"); 
		query.append("        ,FRT_ALL_FLG" ).append("\n"); 
		query.append("        ,FRT_CLT_FLG" ).append("\n"); 
		query.append("        ,FRT_PPD_FLG" ).append("\n"); 
		query.append("        ,FRT_CHG_FLG" ).append("\n"); 
		query.append("        ,FRT_ARR_FLG" ).append("\n"); 
		query.append("        ,REMARK" ).append("\n"); 
		query.append("        ,QTY_BKG" ).append("\n"); 
		query.append("        ,QTY_CNTR" ).append("\n"); 
		query.append("        ,CASE WHEN QTY_BKG = QTY_CNTR THEN 'Y' ELSE 'N' END QTY_FLG" ).append("\n"); 
		query.append("        ,NTC_KND_CD " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        #if ((''==${vsl_cd} || ''==${skd_voy_no} || ''==${skd_dir_cd}) && (${bkg_no} == '' && ${bl_no} == '') && ('' !=${bl_obrd_dt_from} && '' !=${bl_obrd_dt_to}))" ).append("\n"); 
		query.append("               /*+ INDEX(DOC XAK2BKG_BL_DOC) */" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("               BKG.BKG_NO," ).append("\n"); 
		query.append("               BKG.BKG_STS_CD," ).append("\n"); 
		query.append("               BKG.BL_NO || BKG.BL_TP_CD AS BL_NO," ).append("\n"); 
		query.append("               CST.CUST_CNT_CD || LPAD (CST.CUST_SEQ, 6, 0) AS SHPR_CD," ).append("\n"); 
		query.append("               CST.CUST_NM AS SHPR_NM," ).append("\n"); 
		query.append("               SUBSTRB (TRANSLATE (CST.CUST_NM, CHR (13) || CHR (10), ' '), 1, 20) AS SHORT_SHPR_NM," ).append("\n"); 
		query.append("               NVL2(FFC.CUST_CNT_CD,FFC.CUST_CNT_CD||LPAD(FFC.CUST_SEQ,6,0),NULL) AS FF_CD," ).append("\n"); 
		query.append("               BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               BKG.POL_CD," ).append("\n"); 
		query.append("               BKG.POD_CD," ).append("\n"); 
		query.append("               BKG.POR_CD," ).append("\n"); 
		query.append("               NVL(FAX.NTC_FAX_NO, CTT.CNTC_PSON_FAX_NO) AS FAX_NO," ).append("\n"); 
		query.append("               NVL(NVL(EML.NTC_EML, CTT.CNTC_PSON_EML),(SELECT CNTC_PSON_EML FROM BKG_CNTC_PSON WHERE BKG_NO = BKG.BKG_NO AND 'BK' = BKG_CNTC_PSON_TP_CD AND ROWNUM = 1)) AS EML," ).append("\n"); 
		query.append("               CTT.CNTC_PSON_NM," ).append("\n"); 
		query.append("               (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                 WHERE 'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("                   AND INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("                       NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("                       DECODE(FSI.FAX_PROC_STS_CD, 1, 2, 2, 2, 3, 2, 4, 2, 5, 3, 6, 4, 1)," ).append("\n"); 
		query.append("                       NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("                       DECODE(FAX.BKG_NTC_SND_RSLT_CD, 4, 2, 5, 3, 6, 4, 1), 1))) AS FAX_RESULT," ).append("\n"); 
		query.append("               NVL(FSI.XPT_DT, NVL(FSI.UPD_DT, FAX.SND_RQST_DT)) AS FAX_DATE," ).append("\n"); 
		query.append("               NVL(FSI.XPT_ERR_MSG, FSI.XPT_ERR_DTL_MSG) AS FAX_REASON," ).append("\n"); 
		query.append("               (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                 WHERE 'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("                   AND INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("                       NVL2(ESI.EML_PROC_STS_CD, DECODE(ESI.EML_PROC_STS_CD, 1, 2, 2, 2, 3, 3, 4, 4, 1)," ).append("\n"); 
		query.append("                       NVL2(EML.BKG_NTC_SND_RSLT_CD, DECODE(EML.BKG_NTC_SND_RSLT_CD, 3, 3, 4, 4, 1), 1))) AS EML_RESULT," ).append("\n"); 
		query.append("               NVL(ESI.EML_DT, EML.SND_RQST_DT) AS EML_DATE," ).append("\n"); 
		query.append("               ESI.EML_ERR_MSG AS EML_REASON," ).append("\n"); 
		query.append("               NVL(FAX.FRT_ALL_FLG, EML.FRT_ALL_FLG) AS FRT_ALL_FLG," ).append("\n"); 
		query.append("               NVL(FAX.FRT_CLT_FLG, EML.FRT_CLT_FLG) AS FRT_CLT_FLG," ).append("\n"); 
		query.append("               NVL(FAX.FRT_PPD_FLG, EML.FRT_PPD_FLG) AS FRT_PPD_FLG," ).append("\n"); 
		query.append("               NVL(FAX.FRT_CHG_FLG, EML.FRT_CHG_FLG) AS FRT_CHG_FLG," ).append("\n"); 
		query.append("               NVL(FAX.FRT_ARR_FLG, EML.FRT_ARR_FLG) AS FRT_ARR_FLG," ).append("\n"); 
		query.append("               BKG_DRAFT_REMARK_FNC(BKG.BKG_NO, '6', 'N', NULL) AS REMARK," ).append("\n"); 
		query.append("               BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(OP_CNTR_QTY, 0),'99990.99'))" ).append("\n"); 
		query.append("                                                                                                     FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                                                                                     WHERE BKG_NO = BKG.BKG_NO                                                     " ).append("\n"); 
		query.append("                                                                                                     AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                                                     ORDER BY CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                   ) QTY_BKG," ).append("\n"); 
		query.append("               BKG_JOIN_FNC( CURSOR(SELECT  CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(sum(CNTR_VOL_QTY), 0),'99990.99'))" ).append("\n"); 
		query.append("                                                                                                     FROM    BKG_CONTAINER" ).append("\n"); 
		query.append("                                                                                                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                                                                                     AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                                                     GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                                                     ORDER BY CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                   ) QTY_CNTR," ).append("\n"); 
		query.append("        #if ('W'==${bl_tp_cd})" ).append("\n"); 
		query.append("               NVL (NVL (FAX.NTC_KND_CD, EML.NTC_KND_CD),'WB') AS NTC_KND_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("               NVL(NVL(FAX.NTC_KND_CD, EML.NTC_KND_CD), 'BL') AS NTC_KND_CD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("               #if (''!=${vsl_cd} || ''!=${skd_voy_no} || ''!=${skd_dir_cd})" ).append("\n"); 
		query.append("               ,BKG_VVD VVD" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER FFC" ).append("\n"); 
		query.append("               ,BKG_CNTC_PSON CTT" ).append("\n"); 
		query.append("               ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("               #if ('All'!=${bkg_cust_tp_cd} || ''!=${cust_cnt_cd} || ''!=${cust_seq} || ''!=${cust_nm})" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST2" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               ,BKG_NTC_HIS FAX" ).append("\n"); 
		query.append("               ,BKG_NTC_HIS EML" ).append("\n"); 
		query.append("               ,COM_FAX_SND_INFO FSI" ).append("\n"); 
		query.append("               ,COM_EML_SND_INFO ESI" ).append("\n"); 
		query.append("        #if ('W'!=${bl_tp_cd})" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("         WHERE BKG.BKG_NO = CST.BKG_NO" ).append("\n"); 
		query.append("           AND 'S' = CST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = FFC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'F' = FFC.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = CTT.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'SI' = CTT.BKG_CNTC_PSON_TP_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD NOT IN ('A', 'X')" ).append("\n"); 
		query.append("           AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("        #if (''!=${vsl_cd} || ''!=${skd_voy_no} || ''!=${skd_dir_cd})" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("           #if (''!=${vsl_cd})" ).append("\n"); 
		query.append("           AND @[vsl_cd] = VVD.VSL_CD  /*VVD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${skd_voy_no})" ).append("\n"); 
		query.append("           AND @[skd_voy_no] = VVD.SKD_VOY_NO  /*VVD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${skd_dir_cd})" ).append("\n"); 
		query.append("           AND @[skd_dir_cd] = VVD.SKD_DIR_CD  /*VVD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if ('All'!=${bkg_cust_tp_cd} || ''!=${cust_cnt_cd} || ''!=${cust_seq} || ''!=${cust_nm})" ).append("\n"); 
		query.append("           AND CST2.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           #if ('All'!=${bkg_cust_tp_cd})" ).append("\n"); 
		query.append("           AND @[bkg_cust_tp_cd] = CST2.BKG_CUST_TP_CD  /*BKG_CUST_TP_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${cust_cnt_cd})" ).append("\n"); 
		query.append("           AND @[cust_cnt_cd] = CST2.CUST_CNT_CD  /*CUST_CNT_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${cust_seq})" ).append("\n"); 
		query.append("           AND CST2.CUST_SEQ = TO_NUMBER(@[cust_seq])  /*CUST_SEQ*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${cust_nm})" ).append("\n"); 
		query.append("           AND UPPER(CST2.CUST_NM) LIKE UPPER(@[cust_nm])||'%'  /*CUST_NM*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = FAX.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'F' = FAX.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("           AND FAX.SND_ID = FSI.FAX_SND_NO(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = EML.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'M' = EML.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("           AND EML.SND_ID = ESI.EML_SND_NO(+)" ).append("\n"); 
		query.append("        #if ('W'==${bl_tp_cd})" ).append("\n"); 
		query.append("           AND @[bl_tp_cd] = BKG.BL_TP_CD  /*BL_TP_CD*/" ).append("\n"); 
		query.append("           AND 'WB' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(FAX.HIS_SEQ,1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                     WHERE BKG_NO = FAX.BKG_NO" ).append("\n"); 
		query.append("                       AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("                       AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("           AND 'WB' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(EML.HIS_SEQ,1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                     WHERE BKG_NO = EML.BKG_NO" ).append("\n"); 
		query.append("                       AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("                       AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND 'BL' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(FAX.HIS_SEQ, 1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                     WHERE BKG_NO = FAX.BKG_NO" ).append("\n"); 
		query.append("                       AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("                       AND 'BL' = NTC_KND_CD), 1)" ).append("\n"); 
		query.append("           AND 'BL' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(EML.HIS_SEQ, 1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                     WHERE BKG_NO = EML.BKG_NO" ).append("\n"); 
		query.append("                       AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("                       AND 'BL' = NTC_KND_CD), 1)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           #if (''!=${pol_cd})" ).append("\n"); 
		query.append("           AND BKG.POL_CD LIKE @[pol_cd]||'%'  /*POL_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${pol_yd_cd})" ).append("\n"); 
		query.append("           AND SUBSTR(BKG.POL_NOD_CD,-2) LIKE @[pol_yd_cd]||'%'  /*pol_yd_cd*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${pod_cd})" ).append("\n"); 
		query.append("           AND BKG.POD_CD LIKE @[pod_cd]||'%'  /*POD_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bkg_ofc_cd})" ).append("\n"); 
		query.append("           AND UPPER(BKG.BKG_OFC_CD) LIKE UPPER(@[bkg_ofc_cd])||'%'  /*BKG_OFC_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${doc_usr_id})" ).append("\n"); 
		query.append("           AND UPPER(BKG.DOC_USR_ID) LIKE UPPER(@[doc_usr_id])||'%'  /*DOC_USR_ID*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('All'!=${bkg_sts_cd})" ).append("\n"); 
		query.append("           AND @[bkg_sts_cd] = BKG.BKG_STS_CD  /*BKG_STS_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${obl_iss_ofc_cd})" ).append("\n"); 
		query.append("           AND UPPER(ISS.OBL_ISS_OFC_CD) LIKE UPPER(@[obl_iss_ofc_cd])||'%'  /*OBL_ISS_OFC_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${obl_iss_usr_id})" ).append("\n"); 
		query.append("           AND UPPER(ISS.OBL_ISS_USR_ID) LIKE UPPER(@[obl_iss_usr_id])||'%'  /*OBL_ISS_USR_ID*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${ob_sls_ofc_cd})" ).append("\n"); 
		query.append("           AND UPPER(BKG.OB_SLS_OFC_CD) LIKE UPPER(@[ob_sls_ofc_cd])||'%'  /*OB_SLS_OFC_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${ob_srep_cd})" ).append("\n"); 
		query.append("           AND UPPER(BKG.OB_SREP_CD) LIKE UPPER(@[ob_srep_cd])||'%'  /*OB_SREP_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bkg_no})" ).append("\n"); 
		query.append("           AND BKG.BKG_NO IN ( ${bkg_no} )  /*BKG_NO*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bl_no})" ).append("\n"); 
		query.append("           AND BKG.BL_NO IN ( ${bl_no} )  /*BL_NO*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${sc_no})" ).append("\n"); 
		query.append("           AND @[sc_no] = BKG.SC_NO  /*SC_NO*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${rfa_no})" ).append("\n"); 
		query.append("           AND @[rfa_no] = BKG.RFA_NO  /*RFA_NO*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bl_obrd_dt_from} && ''!=${bl_obrd_dt_to})" ).append("\n"); 
		query.append("           AND DOC.BL_OBRD_DT BETWEEN TO_DATE(@[bl_obrd_dt_from],'RRRRMMDD') AND TO_DATE(@[bl_obrd_dt_to],'RRRRMMDD')  /*BL_OBRD_DT*/" ).append("\n"); 
		query.append("           #elseif (''!=${obl_iss_dt_from} && ''!=${obl_iss_dt_to})" ).append("\n"); 
		query.append("           AND ISS.OBL_ISS_DT BETWEEN TO_DATE(@[obl_iss_dt_from],'RRRRMMDD') AND TO_DATE(@[obl_iss_dt_to],'RRRRMMDD')  /*OBL_ISS_DT*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('All'!=${fax_proc_sts_cd})" ).append("\n"); 
		query.append("           AND NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("               NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) = @[fax_proc_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('All'!=${eml_proc_sts_cd})" ).append("\n"); 
		query.append("           AND NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("               NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) = @[eml_proc_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if('Y' == ${no_sr_flg})" ).append("\n"); 
		query.append("           AND BKG.XTER_SI_CD IS NULL" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if('Y' == ${un_pickup_flg})" ).append("\n"); 
		query.append("AND (CASE WHEN QTY_BKG = QTY_CNTR THEN 'Y' ELSE 'N' END) = 'N'           " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}