/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchMultiNtcHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.07 
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

public class BLIssuanceDBDAOsearchMultiNtcHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMultiNtcHis
	  * 2010.09.07 김영철 [CHM-201005693-01] ACK_RCV_STS_CD가 null이면 SELECT 하지 않음.
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchMultiNtcHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntc_via_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchMultiNtcHisRSQL").append("\n"); 
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
		query.append("#if ('PS'==${ntc_knd_cd})" ).append("\n"); 
		query.append("SELECT  BKG.BKG_NO" ).append("\n"); 
		query.append("       ,BKG.BL_NO" ).append("\n"); 
		query.append("       ,HIS.BKG_SEQ" ).append("\n"); 
		query.append("       ,'PS' AS NTC_KND_CD" ).append("\n"); 
		query.append("       ,'' AS NTC_VIA_CD" ).append("\n"); 
		query.append("       ,'PSACBI' AS FAX_EML" ).append("\n"); 
		query.append("       ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("         FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE  'CD01636' = INTG_CD_ID" ).append("\n"); 
		query.append("         AND    INTG_CD_VAL_CTNT = HIS.ACK_RCV_STS_CD) AS SND_RESULT" ).append("\n"); 
		query.append("       ,TO_CHAR(HIS.SND_DT,'RRRR-MM-DD HH24:MI') AS SND_DATE" ).append("\n"); 
		query.append("       ,'' AS SND_REASON" ).append("\n"); 
		query.append("       ,NVL (HIS.SND_USR_ID, HIS.UPD_USR_ID) AS SND_USR_ID" ).append("\n"); 
		query.append("       ,'' AS SND_OFC_CD" ).append("\n"); 
		query.append("       ,'' AS FRT_ALL_FLG" ).append("\n"); 
		query.append("       ,'' AS FRT_CLT_FLG" ).append("\n"); 
		query.append("       ,'' AS FRT_PPD_FLG" ).append("\n"); 
		query.append("       ,'' AS FRT_CHG_FLG" ).append("\n"); 
		query.append("       ,'' AS FRT_ARR_FLG" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BKG" ).append("\n"); 
		query.append("       ,BKG_CSTMS_PSA_BKG HIS" ).append("\n"); 
		query.append("WHERE   BKG.BKG_NO = HIS.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     NVL(HIS.ACK_RCV_STS_CD,'N') != 'N'" ).append("\n"); 
		query.append("ORDER   BY BKG_SEQ DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("      ,BKG.BL_NO" ).append("\n"); 
		query.append("      ,HIS.HIS_SEQ" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE 'CD01552' = INTG_CD_ID AND INTG_CD_VAL_CTNT = HIS.NTC_KND_CD) AS NTC_KND_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE 'CD02021' = INTG_CD_ID AND INTG_CD_VAL_CTNT = HIS.NTC_VIA_CD) AS NTC_VIA_CD" ).append("\n"); 
		query.append("       #if ('F'==${ntc_via_cd})" ).append("\n"); 
		query.append("      ,NVL(HIS.NTC_FAX_NO,(SELECT CNTC_PSON_FAX_NO FROM BKG_CNTC_PSON WHERE BKG_NO = BKG.BKG_NO AND BKG_CNTC_PSON_TP_CD = 'SI')) AS FAX_EML" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("        AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("               NVL2(SND.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(SND.FAX_PROC_STS_CD,1,2,2,2,3,2,4,4,5,3,6,4,1)," ).append("\n"); 
		query.append("               NVL2(HIS.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(HIS.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) ) AS SND_RESULT" ).append("\n"); 
		query.append("      ,TO_CHAR(NVL(SND.XPT_DT,NVL(SND.UPD_DT,HIS.SND_RQST_DT)),'RRRR-MM-DD HH24:MI') AS SND_DATE" ).append("\n"); 
		query.append("      ,NVL (SND.XPT_ERR_MSG, SND.XPT_ERR_DTL_MSG) AS SND_REASON" ).append("\n"); 
		query.append("       #elseif ('M'==${ntc_via_cd})" ).append("\n"); 
		query.append("      ,NVL(NVL(HIS.NTC_EML,SND.TO_EML_CTNT),(SELECT CNTC_PSON_EML FROM BKG_CNTC_PSON WHERE BKG_NO = BKG.BKG_NO AND BKG_CNTC_PSON_TP_CD = 'SI')) AS FAX_EML" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("        AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("               NVL2(SND.EML_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(SND.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("               NVL2(HIS.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(HIS.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) ) AS SND_RESULT" ).append("\n"); 
		query.append("      ,TO_CHAR(NVL(SND.EML_DT,HIS.SND_RQST_DT),'RRRR-MM-DD HH24:MI') AS SND_DATE" ).append("\n"); 
		query.append("      ,SND.EML_ERR_MSG AS SND_REASON" ).append("\n"); 
		query.append("       #elseif ('E'==${ntc_via_cd})" ).append("\n"); 
		query.append("      ,HIS.EDI_ID AS FAX_EML" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE  'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("        AND    INTG_CD_VAL_CTNT =" ).append("\n"); 
		query.append("               DECODE(HIS.BKG_NTC_SND_RSLT_CD,'A',3,'F',4,'N',4,NULL)) AS SND_RESULT" ).append("\n"); 
		query.append("      ,TO_CHAR(HIS.SND_RQST_DT,'RRRR-MM-DD HH24:MI') AS SND_DATE" ).append("\n"); 
		query.append("      ,'' AS SND_REASON" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("      ,NVL (HIS.SND_USR_ID, HIS.UPD_USR_ID) AS SND_USR_ID" ).append("\n"); 
		query.append("      ,HIS.SND_OFC_CD" ).append("\n"); 
		query.append("      ,HIS.FRT_ALL_FLG" ).append("\n"); 
		query.append("      ,HIS.FRT_CLT_FLG" ).append("\n"); 
		query.append("      ,HIS.FRT_PPD_FLG" ).append("\n"); 
		query.append("      ,HIS.FRT_CHG_FLG" ).append("\n"); 
		query.append("      ,HIS.FRT_ARR_FLG" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BKG" ).append("\n"); 
		query.append("      ,BKG_NTC_HIS HIS" ).append("\n"); 
		query.append("       #if ('F'==${ntc_via_cd})" ).append("\n"); 
		query.append("      ,COM_FAX_SND_INFO SND" ).append("\n"); 
		query.append("       #elseif ('M'==${ntc_via_cd})" ).append("\n"); 
		query.append("      ,COM_EML_SND_INFO SND" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("WHERE  BKG.BKG_NO = HIS.BKG_NO(+)" ).append("\n"); 
		query.append("#if ('F'==${ntc_via_cd})" ).append("\n"); 
		query.append("AND    HIS.SND_ID = SND.FAX_SND_NO(+)" ).append("\n"); 
		query.append("#elseif ('M'==${ntc_via_cd})" ).append("\n"); 
		query.append("AND    HIS.SND_ID = SND.EML_SND_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    @[ntc_via_cd] = HIS.NTC_VIA_CD(+)  /*MODE(F : FAX, M : EMAIL, E : EDI)*/" ).append("\n"); 
		query.append("AND    @[ntc_knd_cd] = HIS.NTC_KND_CD(+)  /*KIND(BL : Draft B/L(Outbound), ID : Draft B/L(Inbound), WB : Waybill, BK : BookingReceiptNotice*/" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = @[bkg_no]             /*BKG_NO*/" ).append("\n"); 
		query.append("ORDER  BY HIS_SEQ DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}