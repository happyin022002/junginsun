/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOMtyRlseOrdDetailOutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.04.02 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOMtyRlseOrdDetailOutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOMtyRlseOrdDetailOutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOMtyRlseOrdDetailOutRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT   " ).append("\n"); 
		query.append("	#if (${from_dt} != '')" ).append("\n"); 
		query.append("		#if (${datetype} == 'BKG')" ).append("\n"); 
		query.append("		   /*+ ORDERED */" ).append("\n"); 
		query.append("		#elseif(${datetype} == 'PUP')" ).append("\n"); 
		query.append("		   /*+ ORDERED */" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		 BKG.BKG_NO" ).append("\n"); 
		query.append("        ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("        ,BKG.RCV_TERM_CD" ).append("\n"); 
		query.append("        ,BKG.DE_TERM_CD" ).append("\n"); 
		query.append("        ,BKG.POR_CD" ).append("\n"); 
		query.append("        ,BKG.POL_CD" ).append("\n"); 
		query.append("        ,LOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("        ,LOC.SCC_CD" ).append("\n"); 
		query.append("        ,BKG.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(BKG.MTY_PKUP_DT, 'YYYY-MM-DD') AS MTY_PKUP_DT" ).append("\n"); 
		query.append("        , VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        ,BKG.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("        ,EDI.EDI_ID" ).append("\n"); 
		query.append("        ,NVL(EDI.SND_RQST_DT, EDI.SND_DT) AS EDI_SND_DT" ).append("\n"); 
		query.append("        ,NVL(FAX.NTC_FAX_NO, YAR.FAX_NO) AS NTC_FAX_NO" ).append("\n"); 
		query.append("        ,NVL(FSI.XPT_DT,NVL(FSI.UPD_DT,FAX.SND_RQST_DT)) AS FAX_SND_DT" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("          AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("                 NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("                 DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("                 NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("                 DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) ) AS FAX_SND_RSLT_CD" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("          AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("                 NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("                 DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("                 NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("                 DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) ) AS FAX_SND_RSLT_NM" ).append("\n"); 
		query.append("        ,NVL(EML.NTC_EML, YAR.YD_EML) NTC_EML" ).append("\n"); 
		query.append("        ,NVL(ESI.EML_DT,EML.SND_RQST_DT) AS EML_SND_DT" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("          AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("                 NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("                 DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("                 NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("                 DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) ) AS EML_SND_RSLT_CD" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("          WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("          AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("                 NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("                 DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("                 NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("                 DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) ) AS EML_SND_RSLT_NM" ).append("\n"); 
		query.append("        ,CST.CUST_NM" ).append("\n"); 
		query.append("        ,BKG.CMDT_CD" ).append("\n"); 
		query.append("        ,COM.CMDT_NM" ).append("\n"); 
		query.append("        ,'' DIFF_RMK" ).append("\n"); 
		query.append("        ,BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("             SELECT (SELECT CNTR_TPSZ_RMK" ).append("\n"); 
		query.append("                     FROM   MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                     WHERE  CNTR_TPSZ_CD = A.CNTR_TPSZ_CD) ||'-'|| OP_CNTR_QTY" ).append("\n"); 
		query.append("             FROM   BKG_QUANTITY A" ).append("\n"); 
		query.append("             WHERE  BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("             AND    CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("         ), ', ') AS CNTR_QTY" ).append("\n"); 
		query.append("        ,BKG.XTER_RMK" ).append("\n"); 
		query.append("        ,DECODE(BKG.FLEX_HGT_FLG,'Y','Y',NULL) AS FLEX_HGT_FLG" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BKG" ).append("\n"); 
		query.append("      ,BKG_VVD VVD" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER CST" ).append("\n"); 
		query.append("      ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("      ,MDM_COMMODITY COM" ).append("\n"); 
		query.append("      ,MDM_YARD YAR" ).append("\n"); 
		query.append("      ,BKG_NTC_HIS FAX" ).append("\n"); 
		query.append("      ,BKG_NTC_HIS EML" ).append("\n"); 
		query.append("      ,BKG_NTC_HIS EDI" ).append("\n"); 
		query.append("      ,COM_FAX_SND_INFO FSI" ).append("\n"); 
		query.append("      ,COM_EML_SND_INFO ESI" ).append("\n"); 
		query.append("WHERE  BKG.POR_CD   = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("AND    BKG.BKG_NO   = VVD.BKG_NO" ).append("\n"); 
		query.append("AND    VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("AND    BKG.POL_CD	= VVD.POL_CD" ).append("\n"); 
		query.append("AND    BKG.BKG_NO   = CST.BKG_NO(+)" ).append("\n"); 
		query.append("AND    'S' = CST.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND    BKG.CMDT_CD  = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("AND    BKG.MTY_PKUP_YD_CD = YAR.YD_CD(+)" ).append("\n"); 
		query.append("AND    'X' <> BKG.BKG_STS_CD" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = FAX.BKG_NO(+)" ).append("\n"); 
		query.append("AND    NVL(FAX.HIS_SEQ,1) = " ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = FAX.BKG_NO" ).append("\n"); 
		query.append("        AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'CN' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("AND    'F' = FAX.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("AND    'CN' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = EML.BKG_NO(+)" ).append("\n"); 
		query.append("AND    NVL(EML.HIS_SEQ,1) = " ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = EML.BKG_NO" ).append("\n"); 
		query.append("        AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'CN' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("AND    'M' = EML.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("AND    'CN' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = EDI.BKG_NO(+)" ).append("\n"); 
		query.append("AND    NVL(EDI.HIS_SEQ,1) = " ).append("\n"); 
		query.append("       NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = EDI.BKG_NO" ).append("\n"); 
		query.append("        AND 'E' = NTC_VIA_CD" ).append("\n"); 
		query.append("        AND 'CN' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("AND    'E' = EDI.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("AND    'CN' = EDI.NTC_KND_CD(+)" ).append("\n"); 
		query.append("AND    FAX.SND_ID = FSI.FAX_SND_NO(+)" ).append("\n"); 
		query.append("AND    EML.SND_ID = ESI.EML_SND_NO(+)" ).append("\n"); 
		query.append("#if (${from_dt} != '')" ).append("\n"); 
		query.append("#if (${datetype} == 'BKG')" ).append("\n"); 
		query.append("   AND BKG.BKG_CRE_DT  BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("#elseif(${datetype} == 'PUP')" ).append("\n"); 
		query.append("   AND BKG.MTY_PKUP_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("   AND BKG.BKG_OFC_CD = UPPER(@[bkg_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${doc_usr_id}!='')" ).append("\n"); 
		query.append("   AND UPPER(BKG.DOC_USR_ID)  = UPPER(@[doc_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_ctrl_ofc_cd}!='')" ).append("\n"); 
		query.append("   AND BKG.EQ_CTRL_OFC_CD = UPPER(@[eq_ctrl_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = UPPER(substr(@[vvd],0,4))" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = UPPER(substr(@[vvd],5,4))" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = UPPER(substr(@[vvd],9,1))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} !='')" ).append("\n"); 
		query.append("   AND BKG.POR_CD   = UPPER(@[por_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} !='')" ).append("\n"); 
		query.append("   AND BKG.POL_CD   = UPPER(@[pol_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!='')" ).append("\n"); 
		query.append("   AND BKG.POD_CD   = UPPER(@[pod_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mty_pkup_yd_cd}!='')" ).append("\n"); 
		query.append("   AND BKG.MTY_PKUP_YD_CD = UPPER(@[mty_pkup_yd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${full_rtn_yd_cd}!='')" ).append("\n"); 
		query.append("   AND BKG.FULL_RTN_YD_CD = UPPER(@[full_rtn_yd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no}!='')" ).append("\n"); 
		query.append("   AND BKG.BKG_NO   = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_confirm}=='Y')" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BKG.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_confirm}=='N')" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BKG.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY BKG.BKG_NO" ).append("\n"); 

	}
}