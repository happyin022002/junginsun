/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOSearchVgmAuto301EdiSupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchVgmAuto301EdiSupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VGM Auto 301 EDI SUP
	  * </pre>
	  */
	public StatusReportDBDAOSearchVgmAuto301EdiSupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchVgmAuto301EdiSupRSQL").append("\n"); 
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
		query.append("SELECT EDI_RECEIVE_ID," ).append("\n"); 
		query.append("       REF_CODE," ).append("\n"); 
		query.append("       EDI_SND_ID," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       NTC_KND_CD" ).append("\n"); 
		query.append("  FROM ( SELECT EDI_RECEIVE_ID," ).append("\n"); 
		query.append("                REF_CODE," ).append("\n"); 
		query.append("                EDI_SND_ID," ).append("\n"); 
		query.append("                BKG_NO," ).append("\n"); 
		query.append("                NTC_KND_CD," ).append("\n"); 
		query.append("                ROW_NUMBER() OVER (PARTITION BY EDI_RECEIVE_ID, REF_CODE, EDI_SND_ID ORDER BY DECODE(NTC_KND_CD,'3C','1','3P','2')) DUP_CHK" ).append("\n"); 
		query.append("           FROM ( SELECT DISTINCT EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                                  EY.PRNR_SUB_LNK_CD AS REF_CODE ," ).append("\n"); 
		query.append("                                  EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                  BB.BKG_NO," ).append("\n"); 
		query.append("                                  '3C' NTC_KND_CD" ).append("\n"); 
		query.append("                    FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                         BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                         BKG_BOOKING BB" ).append("\n"); 
		query.append("                   WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                     AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                     AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                     AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("                     AND EDI_MSG_IND_CD = 35" ).append("\n"); 
		query.append("                     AND (EY.PRNR_SUB_LNK_CD = BB.POR_NOD_CD" ).append("\n"); 
		query.append("                         OR EY.PRNR_SUB_LNK_CD = BB.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                         OR EY.PRNR_SUB_LNK_CD = BB.MTY_RTN_YD_CD )" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("                  SELECT DISTINCT EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                                  EY.PRNR_SUB_LNK_CD AS REF_CODE ," ).append("\n"); 
		query.append("                                  EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                  BB.BKG_NO," ).append("\n"); 
		query.append("                                  '3P' NTC_KND_CD" ).append("\n"); 
		query.append("                    FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                         BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                         BKG_BOOKING BB" ).append("\n"); 
		query.append("                   WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                     AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                     AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                     AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("                     AND EDI_MSG_IND_CD = 36" ).append("\n"); 
		query.append("                     AND EY.PRNR_SUB_LNK_CD = BB.POL_NOD_CD )" ).append("\n"); 
		query.append("         GROUP BY EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                  REF_CODE," ).append("\n"); 
		query.append("                  EDI_SND_ID," ).append("\n"); 
		query.append("                  BKG_NO," ).append("\n"); 
		query.append("                  NTC_KND_CD" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(" WHERE DUP_CHK = 1" ).append("\n"); 

	}
}