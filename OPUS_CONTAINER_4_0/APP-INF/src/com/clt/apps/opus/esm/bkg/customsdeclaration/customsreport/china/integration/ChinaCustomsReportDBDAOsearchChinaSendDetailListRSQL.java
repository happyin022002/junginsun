/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaCustomsReportDBDAOsearchChinaSendDetailListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier :
*@LastVersion : 1.0
* 2014.05.12
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

public class ChinaCustomsReportDBDAOsearchChinaSendDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 중국세관 send list result view(detail)
	  * </pre>
	  */
	public ChinaCustomsReportDBDAOsearchChinaSendDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration").append("\n");
		query.append("FileName : ChinaCustomsReportDBDAOsearchChinaSendDetailListRSQL").append("\n");
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
		query.append("SELECT  SUM(SLOG.SEQ) OVER (ORDER BY SLOG.BL_NO," ).append("\n");
		query.append("        SLOG.POL_CD," ).append("\n");
		query.append("        SLOG.POD_CD," ).append("\n");
		query.append("        SLOG.BL_ACK_TP_CD," ).append("\n");
		query.append("        SLOG.CNTR_NO," ).append("\n");
		query.append("        SLOG.CNTR_ACK_TP_CD) SEQ ," ).append("\n");
		query.append("        SLOG.BL_NO," ).append("\n");
		query.append("        SLOG.POL_CD," ).append("\n");
		query.append("        SLOG.POD_CD," ).append("\n");
		query.append("        SLOG.SENT_DT," ).append("\n");
		query.append("        SLOG.BL_ACK_TYPE," ).append("\n");
		query.append("        SLOG.BL_ACK_TEXT," ).append("\n");
		query.append("        SLOG.CNTR_NO," ).append("\n");
		query.append("        SLOG.CNTR_ACK_TYPE," ).append("\n");
		query.append("        SLOG.CNTR_ACK_TEXT," ).append("\n");
		query.append("        SLOG.ACK_RCV_DT," ).append("\n");
		query.append("		--SLOG.BL_ACK_TP_CD || ' - ' || SLOG.AGN_ACK_MSG AS AGN_ACK_MSG," ).append("\n");
		query.append("        --SLOG.BL_ACK_TP_CD || ' - ' || SLOG.CUST_ACK_MSG AS CUST_ACK_MSG," ).append("\n");
		query.append("		SLOG.AGN_ACK_MSG," ).append("\n");
		query.append("        SLOG.CUST_ACK_MSG," ).append("\n");
		query.append("        SLOG.AGN_ACK_DT," ).append("\n");
		query.append("        SLOG.CUST_ACK_DT," ).append("\n");
		query.append("		NVL(SLOG.RHQ,SLOG.MDM_RHQ) RHQ," ).append("\n");
		query.append("		1 CNT" ).append("\n");
		query.append("FROM " ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT  DECODE(LAG(BL.BL_NO) OVER ( ORDER BY BL.BL_NO," ).append("\n");
		query.append("        BL.BKG_POL_CD," ).append("\n");
		query.append("        BL.BKG_POD_CD," ).append("\n");
		query.append("        BL.CHN_CSTMS_ACK_TP_CD," ).append("\n");
		query.append("        CNTR.CNTR_NO," ).append("\n");
		query.append("        CNTR.CHN_CSTMS_ACK_TP_CD) , BL.BL_NO, 0, 1) SEQ," ).append("\n");
		query.append("        BL.BL_NO," ).append("\n");
		query.append("        BL.BKG_POL_CD POL_CD," ).append("\n");
		query.append("        BL.BKG_POD_CD POD_CD," ).append("\n");
		query.append("        TO_CHAR(VVD.MF_SND_DT,'YYYY-MM-DD HH24:MI:SS') SENT_DT," ).append("\n");
		query.append("        CODE1.INTG_CD_VAL_DP_DESC BL_ACK_TYPE," ).append("\n");
		query.append("        BL.ACK_CTNT BL_ACK_TEXT," ).append("\n");
		query.append("        CNTR.CNTR_NO," ).append("\n");
		query.append("        CODE2.INTG_CD_VAL_DP_DESC CNTR_ACK_TYPE," ).append("\n");
		query.append("        BL.CHN_CSTMS_ACK_TP_CD BL_ACK_TP_CD," ).append("\n");
		query.append("        CNTR.ACK_CTNT CNTR_ACK_TEXT," ).append("\n");
		query.append("        TO_CHAR(VVD.ACK_RCV_DT,'YYYY-MM-DD HH24:MI:SS') ACK_RCV_DT," ).append("\n");
		query.append("        CNTR.CHN_CSTMS_ACK_TP_CD CNTR_ACK_TP_CD," ).append("\n");
		query.append("		" ).append("\n");
		query.append("        BL.ACK_CTNT AGN_ACK_MSG,             " ).append("\n");
		query.append("        BL.AGN_ACK_CTNT CUST_ACK_MSG," ).append("\n");
		query.append("        TO_CHAR(BL.ACK_UPD_DT,'YYYY-MM-DD HH24:MI:SS') AGN_ACK_DT," ).append("\n");
		query.append("        TO_CHAR(BL.AGN_ACK_UPD_DT,'YYYY-MM-DD HH24:MI:SS') CUST_ACK_DT, " ).append("\n");
		query.append("" ).append("\n");
		query.append("		(SELECT SLS_RHQ_CD" ).append("\n");
		query.append("		FROM BKG_BOOKING" ).append("\n");
		query.append("		WHERE BL_NO = BL.BL_NO) RHQ," ).append("\n");
		query.append("		(SELECT AR_HD_QTR_OFC_CD" ).append("\n");
		query.append("		FROM MDM_ORGANIZATION" ).append("\n");
		query.append("		WHERE OFC_CD = VVD.MF_SND_OFC_CD" ).append("\n");
		query.append("		AND DELT_FLG = 'N'" ).append("\n");
		query.append("		) MDM_RHQ " ).append("\n");
		query.append("FROM    BKG_CSTMS_CHN_SND_LOG VVD," ).append("\n");
		query.append("        BKG_CSTMS_CHN_SND_LOG_BL BL," ).append("\n");
		query.append("        BKG_CSTMS_CHN_SND_LOG_CNTR CNTR," ).append("\n");
		query.append("		COM_INTG_CD_DTL CODE1," ).append("\n");
		query.append("		COM_INTG_CD_DTL CODE2" ).append("\n");
		query.append("WHERE   VVD.EDI_REF_ID  			= BL.EDI_REF_ID " ).append("\n");
		query.append("AND     BL.EDI_REF_ID   			= CNTR.EDI_REF_ID" ).append("\n");
		query.append("AND     BL.BL_NO        			= CNTR.BL_NO" ).append("\n");
		query.append("AND		BL.CHN_CSTMS_ACK_TP_CD 		= CODE1.INTG_CD_VAL_CTNT(+)" ).append("\n");
		query.append("AND		CNTR.CHN_CSTMS_ACK_TP_CD 	= CODE2.INTG_CD_VAL_CTNT(+)" ).append("\n");
		query.append("AND     VVD.EDI_REF_ID  			= @[edi_ref_id]" ).append("\n");
		query.append("AND		BL.BKG_POD_CD				IN (SUBSTR(@[pod_cd],1,5)," ).append("\n");
		query.append("										SUBSTR(@[pod_cd],7,5)," ).append("\n");
		query.append("										SUBSTR(@[pod_cd],13,5)," ).append("\n");
		query.append("										SUBSTR(@[pod_cd],19,5)," ).append("\n");
		query.append("										SUBSTR(@[pod_cd],25,5)," ).append("\n");
		query.append("										SUBSTR(@[pod_cd],31,5)," ).append("\n");
		query.append("										SUBSTR(@[pod_cd],37,5))" ).append("\n");
		query.append("AND		CODE1.INTG_CD_ID(+) 		= 'CD02300'" ).append("\n");
		query.append("AND     CODE2.INTG_CD_ID(+) 		= 'CD02300') SLOG" ).append("\n");

	}
}