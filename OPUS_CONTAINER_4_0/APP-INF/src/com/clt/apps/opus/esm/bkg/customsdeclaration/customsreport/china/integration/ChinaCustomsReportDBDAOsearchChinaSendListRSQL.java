/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaCustomsReportDBDAOsearchChinaSendListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsReportDBDAOsearchChinaSendListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHINA 세관 전송 LIST
	  * </pre>
	  */
	public ChinaCustomsReportDBDAOsearchChinaSendListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("send_indicator",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsReportDBDAOsearchChinaSendListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (SELECT S1.*," ).append("\n"); 
		query.append("               ROWNUM RN," ).append("\n"); 
		query.append("               COUNT(*) OVER() AS TOTAL," ).append("\n"); 
		query.append("               (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                 WHERE OFC_CD = S1.SND_OFC_CD" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N' ) RHQ" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT DECODE(BKG_CSTMS_CHN_SND_LOG.CHN_MF_SND_IND_CD, 'O', 'O1', 'D', 'O2', 'P', 'P1') SEND_INDICATOR," ).append("\n"); 
		query.append("                       DECODE(BKG_CSTMS_CHN_SND_LOG.TRSM_MSG_TP_ID, '9', 'Original', '0', 'Secondly', '5', 'Change', '3', 'Delete') SEND_INDICATOR_NM," ).append("\n"); 
		query.append("                       TO_CHAR(BKG_CSTMS_CHN_SND_LOG.MF_SND_DT, 'YYYY-MM-DD HH24:MI:SS') SND_DT," ).append("\n"); 
		query.append("                       BKG_CSTMS_CHN_SND_LOG.MF_SND_OFC_CD SND_OFC_CD," ).append("\n"); 
		query.append("                       BKG_CSTMS_CHN_SND_LOG.MF_SND_USR_ID SND_USR_ID," ).append("\n"); 
		query.append("                       BKG_CSTMS_CHN_SND_LOG.VSL_CD||BKG_CSTMS_CHN_SND_LOG.SKD_VOY_NO||BKG_CSTMS_CHN_SND_LOG.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("                       BKG_CSTMS_CHN_SND_LOG.BKG_POL_CD POL_CD," ).append("\n"); 
		query.append("                       TO_CHAR(BKG_CSTMS_CHN_SND_LOG.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') UP_DT," ).append("\n"); 
		query.append("                       COM_INTG_CD_DTL.INTG_CD_VAL_DP_DESC ACK_TP," ).append("\n"); 
		query.append("                       BKG_CSTMS_CHN_SND_LOG.ACK_CTNT ACK_CONT," ).append("\n"); 
		query.append("                       TO_CHAR(BKG_CSTMS_CHN_SND_LOG.ACK_RCV_DT, 'YYYY-MM-DD HH24:MI:SS') ACK_DT," ).append("\n"); 
		query.append("                       BKG_CSTMS_CHN_SND_LOG.EDI_REF_ID," ).append("\n"); 
		query.append("                       S_POD.POD_CD" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_CHN_SND_LOG," ).append("\n"); 
		query.append("                       BKG_CSTMS_CHN_SND_LOG_BL," ).append("\n"); 
		query.append("                       COM_INTG_CD_DTL," ).append("\n"); 
		query.append("                       (SELECT EDI_REF_ID," ).append("\n"); 
		query.append("                               LTRIM(SYS_CONNECT_BY_PATH(BKG_POD_CD, ','), ',') POD_CD" ).append("\n"); 
		query.append("                          FROM (SELECT B.EDI_REF_ID," ).append("\n"); 
		query.append("                                       B.BKG_POD_CD," ).append("\n"); 
		query.append("                                       ROW_NUMBER() OVER(PARTITION BY B.EDI_REF_ID" ).append("\n"); 
		query.append("                                         ORDER BY B.BKG_POD_CD ) RNUM," ).append("\n"); 
		query.append("                                       COUNT(*) OVER( PARTITION BY B.EDI_REF_ID ) CNT" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_CHN_SND_LOG A," ).append("\n"); 
		query.append("                                       BKG_CSTMS_CHN_SND_LOG_BL B" ).append("\n"); 
		query.append("                                 WHERE A.EDI_REF_ID = B.EDI_REF_ID " ).append("\n"); 
		query.append("#if (${date_check} != '')" ).append("\n"); 
		query.append("                                   AND A.MF_SND_DT BETWEEN TO_DATE(@[start_snd_dt], 'YYYY-MM-DD HH24:MI') AND TO_DATE(@[end_snd_dt], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND A.CHN_MF_SND_IND_CD LIKE SUBSTR(@[send_indicator], 1, 1)||'%'" ).append("\n"); 
		query.append("                                   AND A.TRSM_MSG_TP_ID LIKE SUBSTR(@[send_indicator], 2, 1)||'%'" ).append("\n"); 
		query.append("                                   AND NVL(A.VSL_CD, '%') LIKE NVL(SUBSTR(@[vvd_cd], 1, 4), '%')||'%'" ).append("\n"); 
		query.append("                                   AND NVL(A.SKD_VOY_NO, '%') LIKE NVL(SUBSTR(@[vvd_cd], 5, 4), '%')||'%'" ).append("\n"); 
		query.append("                                   AND NVL(A.SKD_DIR_CD, '%') LIKE NVL(SUBSTR(@[vvd_cd], 9, 1), '%')||'%'" ).append("\n"); 
		query.append("                                   AND NVL(A.BKG_POL_CD, '%') LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("                                   AND NVL(A.MF_SND_OFC_CD, '%') LIKE @[ofc_cd]||'%'" ).append("\n"); 
		query.append("                                   AND NVL(A.MF_SND_USR_ID, '%') LIKE @[usr_id]||'%'" ).append("\n"); 
		query.append("                                   AND NVL(B.BKG_POD_CD, '%') LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("                                 GROUP BY B.EDI_REF_ID," ).append("\n"); 
		query.append("                                       B.BKG_POD_CD )" ).append("\n"); 
		query.append("                         WHERE LEVEL = CNT CONNECT BY RNUM = PRIOR RNUM + 1" ).append("\n"); 
		query.append("                           AND EDI_REF_ID = PRIOR EDI_REF_ID) S_POD" ).append("\n"); 
		query.append("                 WHERE BKG_CSTMS_CHN_SND_LOG.EDI_REF_ID = BKG_CSTMS_CHN_SND_LOG_BL.EDI_REF_ID" ).append("\n"); 
		query.append("                   AND BKG_CSTMS_CHN_SND_LOG.EDI_REF_ID = S_POD.EDI_REF_ID" ).append("\n"); 
		query.append("                   AND BKG_CSTMS_CHN_SND_LOG.CHN_CSTMS_ACK_TP_CD = COM_INTG_CD_DTL.INTG_CD_VAL_CTNT(+) " ).append("\n"); 
		query.append("#if (${date_check} != '')" ).append("\n"); 
		query.append("                   AND MF_SND_DT BETWEEN TO_DATE(@[start_snd_dt], 'YYYY-MM-DD HH24:MI') AND TO_DATE(@[end_snd_dt], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND BKG_CSTMS_CHN_SND_LOG.CHN_MF_SND_IND_CD LIKE SUBSTR(@[send_indicator], 1, 1)||'%'" ).append("\n"); 
		query.append("                   AND BKG_CSTMS_CHN_SND_LOG.TRSM_MSG_TP_ID LIKE SUBSTR(@[send_indicator], 2, 1)||'%'" ).append("\n"); 
		query.append("                   AND NVL(BKG_CSTMS_CHN_SND_LOG.VSL_CD, '%') LIKE NVL(SUBSTR(@[vvd_cd], 1, 4), '%')||'%'" ).append("\n"); 
		query.append("                   AND NVL(BKG_CSTMS_CHN_SND_LOG.SKD_VOY_NO, '%') LIKE NVL(SUBSTR(@[vvd_cd], 5, 4), '%')||'%'" ).append("\n"); 
		query.append("                   AND NVL(BKG_CSTMS_CHN_SND_LOG.SKD_DIR_CD, '%') LIKE NVL(SUBSTR(@[vvd_cd], 9, 1), '%')||'%'" ).append("\n"); 
		query.append("                   AND NVL(BKG_CSTMS_CHN_SND_LOG.BKG_POL_CD, '%') LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("                   AND NVL(BKG_CSTMS_CHN_SND_LOG.MF_SND_OFC_CD, '%') LIKE @[ofc_cd]||'%'" ).append("\n"); 
		query.append("                   AND NVL(BKG_CSTMS_CHN_SND_LOG.MF_SND_USR_ID, '%') LIKE @[usr_id]||'%'" ).append("\n"); 
		query.append("                   AND NVL(BKG_CSTMS_CHN_SND_LOG_BL.BKG_POD_CD, '%') LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("                   AND INTG_CD_ID(+) = 'CD02300' ) S1 )" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("#if (${rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND RHQ = @[rhq_ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND RN BETWEEN @[startno] AND @[endno]" ).append("\n"); 

	}
}