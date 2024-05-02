/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBkgListForIbDrblWblRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBkgListForIbDrblWblRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgListForIbDrblWbl
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBkgListForIbDrblWblRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eta_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_obrd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBkgListForIbDrblWblRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO, " ).append("\n"); 
		query.append("       BKG.BKG_STS_CD," ).append("\n"); 
		query.append("       BKG.BL_NO || BKG.BL_TP_CD AS BL_NO," ).append("\n"); 
		query.append("       CST.CUST_CNT_CD || LPAD (CST.CUST_SEQ, 6, 0) AS SHPR_CD," ).append("\n"); 
		query.append("       CST.CUST_NM AS SHPR_NM," ).append("\n"); 
		query.append("       SUBSTRB (TRANSLATE (CST.CUST_NM, CHR (13) || CHR (10), ' '), 1, 20) AS SHORT_SHPR_NM," ).append("\n"); 
		query.append("       NVL2(FFC.CUST_CNT_CD,FFC.CUST_CNT_CD||LPAD(FFC.CUST_SEQ,6,0),NULL) AS FF_CD," ).append("\n"); 
		query.append("       BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       BKG.POL_CD," ).append("\n"); 
		query.append("       BKG.POD_CD," ).append("\n"); 
		query.append("       BKG.POR_CD," ).append("\n"); 
		query.append("       FAX.NTC_FAX_NO AS FAX_NO," ).append("\n"); 
		query.append("       EML.NTC_EML AS EML," ).append("\n"); 
		query.append("       NULL AS CNTC_PSON_NM," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("        AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("               NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("               NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) ) AS FAX_RESULT," ).append("\n"); 
		query.append("       TO_CHAR(NVL (FSI.XPT_DT,NVL(FSI.UPD_DT,FAX.SND_RQST_DT)),'YYYY-MM-DD HH24:MI') AS FAX_DATE," ).append("\n"); 
		query.append("       NVL (FSI.XPT_ERR_MSG, FSI.XPT_ERR_DTL_MSG) AS FAX_REASON," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("        AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("               NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("               NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) ) AS EML_RESULT," ).append("\n"); 
		query.append("       TO_CHAR(NVL (ESI.EML_DT,EML.SND_RQST_DT),'YYYY-MM-DD HH24:MI') AS EML_DATE," ).append("\n"); 
		query.append("       ESI.EML_ERR_MSG AS EML_REASON," ).append("\n"); 
		query.append("       NVL (FAX.FRT_ALL_FLG, EML.FRT_ALL_FLG) AS FRT_ALL_FLG," ).append("\n"); 
		query.append("       NVL (FAX.FRT_CLT_FLG, EML.FRT_CLT_FLG) AS FRT_CLT_FLG," ).append("\n"); 
		query.append("       NVL (FAX.FRT_PPD_FLG, EML.FRT_PPD_FLG) AS FRT_PPD_FLG," ).append("\n"); 
		query.append("       NVL (FAX.FRT_CHG_FLG, EML.FRT_CHG_FLG) AS FRT_CHG_FLG," ).append("\n"); 
		query.append("       NVL (FAX.FRT_ARR_FLG, EML.FRT_ARR_FLG) AS FRT_ARR_FLG," ).append("\n"); 
		query.append("       BKG_DRAFT_REMARK_FNC (BKG.BKG_NO, '6', 'N', NULL) AS REMARK," ).append("\n"); 
		query.append("       RMK.DIFF_RMK," ).append("\n"); 
		query.append("#if ('W'==${bl_tp_cd})" ).append("\n"); 
		query.append("       NVL (NVL (FAX.NTC_KND_CD, EML.NTC_KND_CD),'WB') AS NTC_KND_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       NVL(NVL(FAX.NTC_KND_CD, EML.NTC_KND_CD), 'NN') AS NTC_KND_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM (SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("               MAX(BKG.BKG_STS_CD)      AS BKG_STS_CD," ).append("\n"); 
		query.append("               MAX(BKG.BL_NO)           AS BL_NO," ).append("\n"); 
		query.append("               MAX(BKG.BL_TP_CD)        AS BL_TP_CD," ).append("\n"); 
		query.append("               MAX(BKG.VSL_CD)          AS VSL_CD," ).append("\n"); 
		query.append("               MAX(BKG.SKD_VOY_NO)      AS SKD_VOY_NO," ).append("\n"); 
		query.append("               MAX(BKG.SKD_DIR_CD)      AS SKD_DIR_CD," ).append("\n"); 
		query.append("               MAX(BKG.POL_CD)          AS POL_CD," ).append("\n"); 
		query.append("               MAX(BKG.POD_CD)          AS POD_CD," ).append("\n"); 
		query.append("               MAX(BKG.POR_CD)          AS POR_CD," ).append("\n"); 
		query.append("               MAX(BKG.CUST_TO_ORD_FLG) AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("               BKG_BOOKING      BKG," ).append("\n"); 
		query.append("               BKG_VVD          VVD" ).append("\n"); 
		query.append("         WHERE BKG.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("           AND BKG.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BKG.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND NVL(BKG.PST_RLY_PORT_CD, VVD.POD_CD) = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD NOT IN ('A', 'X')" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("           AND VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ =" ).append("\n"); 
		query.append("               (SELECT MAX (VSL_PRE_PST_CD || VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = BKG.BKG_NO)" ).append("\n"); 
		query.append("           #if (''!=${eta_dt_from} && ''!=${eta_dt_to})" ).append("\n"); 
		query.append("           AND SKD.VPS_ETA_DT BETWEEN TO_DATE(@[eta_dt_from],'RRRRMMDD') AND TO_DATE(@[eta_dt_to],'RRRRMMDD')  /*ETA_DT*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('W'==${bl_tp_cd})" ).append("\n"); 
		query.append("           AND @[bl_tp_cd] = BKG.BL_TP_CD  /*BL_TP_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${pod_cd})" ).append("\n"); 
		query.append("           AND BKG.POD_CD LIKE @[pod_cd]||'%'  /*POD_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${pol_cd})" ).append("\n"); 
		query.append("           AND BKG.POL_CD LIKE @[pol_cd]||'%'  /*POL_CD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${sc_no})" ).append("\n"); 
		query.append("           AND @[sc_no] = BKG.SC_NO  /*SC_NO*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bl_no})" ).append("\n"); 
		query.append("           AND @[bl_no] = BKG.BL_NO  /*BL_NO*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${vsl_cd})" ).append("\n"); 
		query.append("           AND @[vsl_cd] = VVD.VSL_CD  /*VVD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${skd_voy_no})" ).append("\n"); 
		query.append("           AND @[skd_voy_no] = VVD.SKD_VOY_NO  /*VVD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${skd_dir_cd})" ).append("\n"); 
		query.append("           AND @[skd_dir_cd] = VVD.SKD_DIR_CD  /*VVD*/" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           GROUP BY BKG.BKG_NO" ).append("\n"); 
		query.append("       ) BKG" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER CST" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER FFC" ).append("\n"); 
		query.append("       ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("       ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("       #if ('All'!=${bkg_cust_tp_cd} || ''!=${cust_cnt_cd} || ''!=${cust_seq} || ''!=${cust_nm})" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER CST2" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       ,BKG_NTC_HIS FAX" ).append("\n"); 
		query.append("       ,BKG_NTC_HIS EML" ).append("\n"); 
		query.append("       ,COM_FAX_SND_INFO FSI" ).append("\n"); 
		query.append("       ,COM_EML_SND_INFO ESI" ).append("\n"); 
		query.append("#if ('W'!=${bl_tp_cd})" ).append("\n"); 
		query.append("       ,BKG_NTC_HIS FAX2" ).append("\n"); 
		query.append("       ,BKG_NTC_HIS EML2" ).append("\n"); 
		query.append("       ,COM_FAX_SND_INFO FSI2" ).append("\n"); 
		query.append("       ,COM_EML_SND_INFO ESI2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("            SELECT BKG_NO,DIFF_RMK" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT B1.BKG_NO" ).append("\n"); 
		query.append("                      ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                      ,B2.DIFF_RMK" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER (PARTITION BY B1.BKG_NO ORDER BY B1.BKG_NO, B3.BKG_CUST_TP_CD DESC) RMK_NO" ).append("\n"); 
		query.append("                FROM BKG_BOOKING B1" ).append("\n"); 
		query.append("                     ,BKG_RPT_ITM_STUP B2" ).append("\n"); 
		query.append("                     ,BKG_CUSTOMER B3" ).append("\n"); 
		query.append("                WHERE B1.BKG_NO = B3.BKG_NO" ).append("\n"); 
		query.append("                AND B2.CUST_CNT_CD = B3.CUST_CNT_CD" ).append("\n"); 
		query.append("                AND B2.CUST_SEQ = B3.CUST_SEQ" ).append("\n"); 
		query.append("                AND B1.BKG_OFC_CD = B2.BKG_OFC_CD" ).append("\n"); 
		query.append("                AND BKG_CUST_TP_CD IN ('S', 'F')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            WHERE RMK_NO=1" ).append("\n"); 
		query.append("       ) RMK" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = CST.BKG_NO(+)" ).append("\n"); 
		query.append("   AND DECODE (BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C') = CST.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = FFC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'F' = FFC.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("   #if ('All'!=${bkg_cust_tp_cd} || ''!=${cust_cnt_cd} || ''!=${cust_seq} || ''!=${cust_nm})" ).append("\n"); 
		query.append("       AND CST2.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("       #if ('All'!=${bkg_cust_tp_cd})" ).append("\n"); 
		query.append("       AND @[bkg_cust_tp_cd] = CST2.BKG_CUST_TP_CD  /*BKG_CUST_TP_CD*/" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (''!=${cust_cnt_cd})" ).append("\n"); 
		query.append("       AND @[cust_cnt_cd] = CST2.CUST_CNT_CD  /*CUST_CNT_CD*/" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (''!=${cust_seq})" ).append("\n"); 
		query.append("       AND CST2.CUST_SEQ = TO_NUMBER(@[cust_seq])  /*CUST_SEQ*/" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (''!=${cust_nm})" ).append("\n"); 
		query.append("       AND UPPER(CST2.CUST_NM) LIKE UPPER(@[cust_nm])||'%'  /*CUST_NM*/" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = FAX.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'F' = FAX.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("   AND FAX.SND_ID = FSI.FAX_SND_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = EML.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'M' = EML.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("   AND EML.SND_ID = ESI.EML_SND_NO(+)" ).append("\n"); 
		query.append("   #if ('W'==${bl_tp_cd})" ).append("\n"); 
		query.append("   AND 'WB' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("   AND NVL(FAX.HIS_SEQ,1) =" ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = FAX.BKG_NO" ).append("\n"); 
		query.append("        AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("   AND 'WB' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("   AND NVL(EML.HIS_SEQ,1) =" ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = EML.BKG_NO" ).append("\n"); 
		query.append("        AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = FAX2.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'F' = FAX2.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("   AND FAX2.SND_ID = FSI2.FAX_SND_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = EML2.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'M' = EML2.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("   AND EML2.SND_ID = ESI2.EML_SND_NO(+)" ).append("\n"); 
		query.append("   AND 'NN' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("   AND NVL(FAX.HIS_SEQ,1) =" ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = FAX.BKG_NO" ).append("\n"); 
		query.append("        AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'NN' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("   AND 'NN' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("   AND NVL(EML.HIS_SEQ,1) =" ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = EML.BKG_NO" ).append("\n"); 
		query.append("        AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'NN' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("   AND 'WB' = FAX2.NTC_KND_CD(+)" ).append("\n"); 
		query.append("   AND NVL(FAX2.HIS_SEQ,1) =" ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = FAX2.BKG_NO" ).append("\n"); 
		query.append("        AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("   AND 'WB' = EML2.NTC_KND_CD(+)" ).append("\n"); 
		query.append("   AND NVL(EML2.HIS_SEQ,1) =" ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = EML2.BKG_NO" ).append("\n"); 
		query.append("        AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${bl_obrd_dt_from} && ''!=${bl_obrd_dt_to})" ).append("\n"); 
		query.append("   AND DOC.BL_OBRD_DT BETWEEN TO_DATE(@[bl_obrd_dt_from],'RRRRMMDD') AND TO_DATE(@[bl_obrd_dt_to],'RRRRMMDD')  /*BL_OBRD_DT*/" ).append("\n"); 
		query.append("   #elseif (''!=${obl_iss_dt_from} && ''!=${obl_iss_dt_to})" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_DT BETWEEN TO_DATE(@[obl_iss_dt_from],'RRRRMMDD') AND TO_DATE(@[obl_iss_dt_to],'RRRRMMDD')  /*OBL_ISS_DT*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ('All'!=${fax_proc_sts_cd})" ).append("\n"); 
		query.append("   AND NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("       DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("       NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("       DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) = @[fax_proc_sts_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ('All'!=${eml_proc_sts_cd})" ).append("\n"); 
		query.append("   AND NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("       DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("       NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("       DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) = @[eml_proc_sts_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = RMK.BKG_NO(+)" ).append("\n"); 
		query.append("ORDER BY BKG.BKG_NO" ).append("\n"); 

	}
}