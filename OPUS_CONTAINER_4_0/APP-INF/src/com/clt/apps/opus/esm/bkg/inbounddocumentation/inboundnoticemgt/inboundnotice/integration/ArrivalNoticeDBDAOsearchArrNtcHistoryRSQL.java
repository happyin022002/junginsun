/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_via_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcHistoryRSQL").append("\n"); 
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
		query.append("SELECT ANTC.BKG_NO                                        AS BKG_NO" ).append("\n"); 
		query.append("      ,NULL                                               AS HIS_SEQ" ).append("\n"); 
		query.append("      ,@[ntc_via_cd]                                      AS NTC_VIA_CD     -- 'F': Fax.,'E':Email" ).append("\n"); 
		query.append("      ,'AN'                                               AS NTC_KND_CD" ).append("\n"); 
		query.append("      ,NULL                                               AS CNTR_NO" ).append("\n"); 
		query.append("      ,NULL                                               AS AGN_CD" ).append("\n"); 
		query.append("      ,ANTC.AN_FOM_CD                                     AS NTC_FOM_CD" ).append("\n"); 
		query.append("      ,NULL                                               AS NTC_SEQ" ).append("\n"); 
		query.append("      ,ADTL.BKG_CUST_TP_CD                                AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,ADTL.CUST_CNTC_TP_CD                               AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(@[ntc_via_cd],'F',ADTL.FAX_NO,NULL)         AS NTC_FAX_NO" ).append("\n"); 
		query.append("      ,DECODE(@[ntc_via_cd],'M',ADTL.NTC_EML,NULL)        AS NTC_EML" ).append("\n"); 
		query.append("      ,@[snd_id]                                     AS SND_ID" ).append("\n"); 
		query.append("      ,NULL                                               AS EDI_ID   -- 수신 ID" ).append("\n"); 
		query.append("      ,NULL                                               AS DO_EDI_TP_CD   -- 수신 ID" ).append("\n"); 
		query.append("      ,NULL                                               AS ESVC_GRP_CD" ).append("\n"); 
		query.append("      ,NULL                                               AS BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("      ,NULL                                               AS TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append("      ,NULL                                               AS CGOR_RCVR_TP_CD" ).append("\n"); 
		query.append("      ,NULL                                               AS CGOR_STS_CD" ).append("\n"); 
		query.append("      ,'N'                                                AS FRT_HDN_FLG" ).append("\n"); 
		query.append("      ,'N'                                                AS FRT_ALL_FLG" ).append("\n"); 
		query.append("      ,'N'                                                AS FRT_CLT_FLG" ).append("\n"); 
		query.append("      ,'N'                                                AS FRT_PPD_FLG" ).append("\n"); 
		query.append("      ,'N'                                                AS FRT_CHG_FLG" ).append("\n"); 
		query.append("      ,'N'                                                AS FRT_ARR_FLG" ).append("\n"); 
		query.append("      ,@[snd_ofc_cd]                                      AS SND_OFC_CD" ).append("\n"); 
		query.append("      ,@[snd_usr_id]                                      AS SND_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[snd_ofc_cd]),'YYYYMMDD HH24MISS')                                                  AS SND_RQST_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC, SYSDATE, 'GMT' ),'YYYYMMDD HH24MISS') AS SND_RQST_GDT" ).append("\n"); 
		query.append("      ,NULL                                               AS SND_RTY_KNT" ).append("\n"); 
		query.append("      ,NULL                                               AS SND_DT " ).append("\n"); 
		query.append("      ,NULL                                               AS SND_GDT " ).append("\n"); 
		query.append("      ,ANTC.DIFF_RMK                                      AS DIFF_RMK" ).append("\n"); 
		query.append("      ,NULL                                               AS CUST_CNTC_AMD_FLG" ).append("\n"); 
		query.append("      ,NULL                                               AS DP_HDN_FLG" ).append("\n"); 
		query.append("      ,@[cre_usr_id]                                      AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE                                            AS CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id]                                      AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE                                            AS UPD_DT   " ).append("\n"); 
		query.append("FROM BKG_ARR_NTC     ANTC" ).append("\n"); 
		query.append("     ,BKG_ARR_NTC_DTL ADTL" ).append("\n"); 
		query.append("WHERE ANTC.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("  AND ADTL.BKG_NO          = ANTC.BKG_NO " ).append("\n"); 
		query.append("  AND ADTL.BKG_CUST_TP_CD  = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("  AND ADTL.CUST_CNTC_TP_CD = @[cust_cntc_tp_cd]" ).append("\n"); 

	}
}