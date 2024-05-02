/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationReportDBDAOSearchLatestSentDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DoNotificationReportDBDAOSearchLatestSentDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLatestSentDate
	  * </pre>
	  */
	public DoNotificationReportDBDAOSearchLatestSentDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trnk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_door",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.integration").append("\n"); 
		query.append("FileName : DoNotificationReportDBDAOSearchLatestSentDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(MAX(DECODE(DO_SENT,'Both',EML_SND_DT,'Email',EML_SND_DT,'Fax',FAX_SND_DT)),'YYYYMMDD') MAX_SENT_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  FAX_SND_DT, EML_SND_DT," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("             WHEN ( NVL(FAX_SND_FLG1, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG2, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG3, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG4, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG5, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG6, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG7, ' ') = 'Y' )" ).append("\n"); 
		query.append("       AND ( NVL(EML_SND_FLG1, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG2, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG3, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG4, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG5, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG6, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG7, ' ') = 'Y' ) THEN 'Both'" ).append("\n"); 
		query.append("             WHEN (  NVL(FAX_SND_FLG1, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG2, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG3, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG4, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG5, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG6, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG7, ' ') = 'Y' )" ).append("\n"); 
		query.append("       AND ( NVL(EML_SND_FLG1, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG2, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG3, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG4, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG5, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG6, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG7, ' ') <> 'Y' ) THEN 'Fax'" ).append("\n"); 
		query.append("             WHEN ( NVL(FAX_SND_FLG1, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG2, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG3, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG4, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG5, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG6, ' ') <> 'Y'" ).append("\n"); 
		query.append("                OR NVL(FAX_SND_FLG7, ' ') <> 'Y' )" ).append("\n"); 
		query.append("       AND ( NVL(EML_SND_FLG1, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG2, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG3, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG4, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG5, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG6, ' ') = 'Y'" ).append("\n"); 
		query.append("                OR NVL(EML_SND_FLG7, ' ') = 'Y' ) THEN 'Email'" ).append("\n"); 
		query.append("             ELSE 'NO'" ).append("\n"); 
		query.append("           END AS DO_SENT        " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT DNSR.BL_NO, DNSR.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'C1', DNSD.FAX_SND_FLG , NULL)) AS FAX_SND_FLG1 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'C2', DNSD.FAX_SND_FLG , NULL)) AS FAX_SND_FLG2 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'B1', DNSD.FAX_SND_FLG , NULL)) AS FAX_SND_FLG3 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'B2', DNSD.FAX_SND_FLG , NULL)) AS FAX_SND_FLG4 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'A1', DNSD.FAX_SND_FLG , NULL)) AS FAX_SND_FLG5 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'A2', DNSD.FAX_SND_FLG , NULL)) AS FAX_SND_FLG6 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'AN', DNSD.FAX_SND_FLG , NULL)) AS FAX_SND_FLG7 ," ).append("\n"); 
		query.append("       MAX(NVL(DNSD.FAX_SND_DT, FXSD.FAX_SND_LOCL_DT)) AS FAX_SND_DT ," ).append("\n"); 
		query.append("       MAX(NVL(DNSD.EML_SND_DT, EMSD.EML_DT)) AS EML_SND_DT," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'C1', DNSD.EML_SND_FLG , NULL)) AS EML_SND_FLG1 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'C2', DNSD.EML_SND_FLG , NULL)) AS EML_SND_FLG2 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'B1', DNSD.EML_SND_FLG , NULL)) AS EML_SND_FLG3 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'B2', DNSD.EML_SND_FLG , NULL)) AS EML_SND_FLG4 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'A1', DNSD.EML_SND_FLG , NULL)) AS EML_SND_FLG5 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'A2', DNSD.EML_SND_FLG , NULL)) AS EML_SND_FLG6 ," ).append("\n"); 
		query.append("       MAX(DECODE(DNSD.CUST_CNTC_TP_CD, 'AN', DNSD.EML_SND_FLG , NULL)) AS EML_SND_FLG7 " ).append("\n"); 
		query.append("    FROM TRS_DO_NTFC_SNT_RPT DNSR," ).append("\n"); 
		query.append("       TRS_DO_NTFC_SNT_RPT_DTL DNSD ," ).append("\n"); 
		query.append("       COM_FAX_SND_INFO FXSD ," ).append("\n"); 
		query.append("       COM_EML_SND_INFO EMSD" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND DNSR.DO_NTFC_SNT_RPT_SEQ = DNSD.DO_NTFC_SNT_RPT_SEQ(+)" ).append("\n"); 
		query.append("    AND DNSR.BKG_CUST_TP_CD = DNSD.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("    AND DNSD.FAX_NTC_SND_ID = FXSD.FAX_SND_NO(+)" ).append("\n"); 
		query.append("    AND DNSD.EML_NTC_SND_ID = EMSD.EML_SND_NO(+)" ).append("\n"); 
		query.append("#if(${f_bkg_no} != '')" ).append("\n"); 
		query.append("    AND DNSR.BKG_NO LIKE '%'||@[f_bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trnk_vvd} != '')" ).append("\n"); 
		query.append("    AND DNSR.TRNK_VVD_CD = @[f_trnk_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_cntr_no} != '')             " ).append("\n"); 
		query.append("               AND DNSR.CNTR_NO LIKE '%'||@[f_cntr_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_sc_no} != '')              " ).append("\n"); 
		query.append("               AND DNSR.SC_NO = @[f_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($f_ctrl_ofc_cd.size() > 0)" ).append("\n"); 
		query.append("      AND DNSR.CTRL_OFC_CD IN (" ).append("\n"); 
		query.append("	#foreach($key in ${f_ctrl_ofc_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $f_ctrl_ofc_cd.size()) " ).append("\n"); 
		query.append("			'$key', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$key' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_fm_node} != '') " ).append("\n"); 
		query.append("               AND DNSR.FM_NOD_CD = @[f_fm_node]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_to_node} != '') " ).append("\n"); 
		query.append("               AND DNSR.TO_NOD_CD = @[f_to_node]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_door} != '') " ).append("\n"); 
		query.append("               AND DNSR.DOR_NOD_CD = @[f_door]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY DNSR.BL_NO, DNSR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}