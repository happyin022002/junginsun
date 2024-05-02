/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchHldNtcHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.04.07 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park, Mi-Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchHldNtcHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchHldNtcHistoryRSQL(){
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
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchHldNtcHistoryRSQL").append("\n"); 
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
		query.append("SELECT HNTC.BKG_NO                                        AS BKG_NO" ).append("\n"); 
		query.append("      ,NULL                                               AS HIS_SEQ" ).append("\n"); 
		query.append("      ,@[ntc_via_cd]                                      AS NTC_VIA_CD     -- 'F': Fax.,'E':Email" ).append("\n"); 
		query.append("      ,HNTC.HLD_NTC_TP_CD                                 AS NTC_KND_CD" ).append("\n"); 
		query.append("      ,''                                                 AS CNTR_NO" ).append("\n"); 
		query.append("      ,NULL                                               AS AGN_CD" ).append("\n"); 
		query.append("      ,HNTC.CSTMS_HLD_NTC_FOM_CD                          AS NTC_FOM_CD" ).append("\n"); 
		query.append("      ,HNDTL.NTC_SEQ                                      AS NTC_SEQ" ).append("\n"); 
		query.append("      ,HNTC.BKG_CUST_TP_CD                                AS BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,HNDTL.CUST_CNTC_TP_CD                              AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(@[ntc_via_cd],'F',HNDTL.FAX_NO,NULL)        AS NTC_FAX_NO" ).append("\n"); 
		query.append("      ,DECODE(@[ntc_via_cd],'M',HNDTL.NTC_EML,NULL)       AS NTC_EML" ).append("\n"); 
		query.append("      ,@[snd_id]                                          AS SND_ID" ).append("\n"); 
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
		query.append("      ,@[snd_usr_id]                                      AS SND_USR_ID    " ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[snd_ofc_cd]),'YYYYMMDD HH24MISS') AS SND_RQST_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, 'GMT'),'YYYYMMDD HH24MISS') AS SND_RQST_GDT" ).append("\n"); 
		query.append("      ,NULL                                               AS SND_RTY_KNT" ).append("\n"); 
		query.append("      ,NULL                                               AS SND_DT " ).append("\n"); 
		query.append("      ,NULL                                               AS SND_GDT " ).append("\n"); 
		query.append("      ,HNTC.HLD_DIFF_RMK                                  AS DIFF_RMK" ).append("\n"); 
		query.append("      ,NULL                                               AS CUST_CNTC_AMD_FLG" ).append("\n"); 
		query.append("      ,NULL                                               AS DP_HDN_FLG" ).append("\n"); 
		query.append("      ,@[cre_usr_id]                                      AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE                                            AS CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id]                                      AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE                                            AS UPD_DT   " ).append("\n"); 
		query.append("FROM BKG_HLD_NTC     HNTC" ).append("\n"); 
		query.append("    ,BKG_HLD_NTC_DTL HNDTL" ).append("\n"); 
		query.append("WHERE HNTC.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("  AND HNTC.NTC_SEQ          = @[ntc_seq]" ).append("\n"); 
		query.append("  AND HNDTL.BKG_NO          = HNTC.BKG_NO " ).append("\n"); 
		query.append("  AND HNDTL.NTC_SEQ         = HNTC.NTC_SEQ " ).append("\n"); 
		query.append("  AND HNDTL.CUST_CNTC_TP_CD = @[cust_cntc_tp_cd]" ).append("\n"); 

	}
}