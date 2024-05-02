/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAODpcsAmendReasonBkgListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODpcsAmendReasonBkgListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAODpcsAmendReasonBkgListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODpcsAmendReasonBkgListVORSQL").append("\n"); 
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
		query.append("SELECT BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,BK.POL_CD" ).append("\n"); 
		query.append("      ,BK.POD_CD" ).append("\n"); 
		query.append("      ,SR.BKG_NO" ).append("\n"); 
		query.append("      ,SR.SR_URG_CD" ).append("\n"); 
		query.append("	  ,DECODE(SR.SR_URG_CD,'N','Normal','U','Urgent','V','VIP') AS SR_URG_NM" ).append("\n"); 
		query.append("      ,SR.SR_KND_CD" ).append("\n"); 
		query.append("      ,SR.SR_AMD_TP_CD" ).append("\n"); 
		query.append("	  ,(SELECT C.INTG_CD_VAL_DESC FROM  COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01577' AND C.INTG_CD_VAL_CTNT = SR.SR_AMD_TP_CD) AS SR_AMD_TP_NM" ).append("\n"); 
		query.append("	  ,SR.SR_AMD_SEQ" ).append("\n"); 
		query.append("      ,SR.IMG_PG_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(SR.FNT_OFC_TRNS_DT,'YYYY-MM-DD HH24:MI') AS FNT_OFC_TRNS_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(SR.SR_WRK_STS_DT,'YYYY-MM-DD HH24:MI') AS SR_WRK_STS_DT" ).append("\n"); 
		query.append("	  ,SR_WRK_STS_CD" ).append("\n"); 
		query.append("	  ,SR_WRK_STS_USR_ID" ).append("\n"); 
		query.append("	  ,(SELECT U.OFC_CD || '/' || U.USR_NM FROM COM_USER U WHERE U.USR_ID = SR_WRK_STS_USR_ID) SR_WRK_STS_USR_NM" ).append("\n"); 
		query.append("	  ,(SELECT FAX.SR_MTCH_STS_CD FROM BKG_SR_FAX FAX WHERE FAX.SR_NO = SR.SR_NO  " ).append("\n"); 
		query.append("                                                AND   FAX.SR_KND_CD = 'F'" ).append("\n"); 
		query.append("												AND   FAX.FAX_LOG_REF_NO = @[fax_log_ref_no]" ).append("\n"); 
		query.append("												AND   FAX.RCV_DT = (SELECT MAX(SF2.RCV_DT) FROM  BKG_SR_FAX SF2  " ).append("\n"); 
		query.append("                                                                                         WHERE SF2.SR_KND_CD=FAX.SR_KND_CD" ).append("\n"); 
		query.append("                                                                                         AND  SF2.SR_NO = FAX.SR_NO)" ).append("\n"); 
		query.append("                                                ) SR_MTCH_STS_CD" ).append("\n"); 
		query.append("      ,SR.DIFF_RMK" ).append("\n"); 
		query.append("      ,SR.SR_NO  " ).append("\n"); 
		query.append("	  ,BKG_JOIN_FNC(CURSOR(SELECT SR_AMD_RSN_TP_CD " ).append("\n"); 
		query.append("                       FROM BKG_SR_AMD_RSN" ).append("\n"); 
		query.append("                      WHERE SR_KND_CD = SR.SR_KND_CD" ).append("\n"); 
		query.append("                        AND SR_NO = SR.SR_NO" ).append("\n"); 
		query.append("                        AND BKG_NO = SR.BKG_NO" ).append("\n"); 
		query.append("                        AND SR_AMD_TP_CD = SR.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                        AND SR_AMD_SEQ = SR.SR_AMD_SEQ)) AS SR_AMD_RSN_TP_CD" ).append("\n"); 
		query.append("      ,BKG_JOIN_FNC(CURSOR(SELECT SR_AMD_RSN_CD " ).append("\n"); 
		query.append("                       FROM BKG_SR_AMD_RSN" ).append("\n"); 
		query.append("                      WHERE SR_KND_CD = SR.SR_KND_CD" ).append("\n"); 
		query.append("                        AND SR_NO = SR.SR_NO" ).append("\n"); 
		query.append("                        AND BKG_NO = SR.BKG_NO" ).append("\n"); 
		query.append("                        AND SR_AMD_TP_CD = SR.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                        AND SR_AMD_SEQ = SR.SR_AMD_SEQ)) AS SR_AMD_RSN_CD " ).append("\n"); 
		query.append("	  ,SR.IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append("      ,SR.IMG_FILE_NM" ).append("\n"); 
		query.append("      ,'//a_dpcs/module/BKG' || '/' || SR.RCV_OFC_CD || '/' || SR.IMG_FILE_PATH_CTNT  || SR.IMG_FILE_NM AS IMG_FILE_REAL_PATH" ).append("\n"); 
		query.append("	  ,SR.RCV_OFC_CD" ).append("\n"); 
		query.append("	  ,DECODE(DECODE(SR.SR_CRNT_INFO_CD,'R',DECODE(NVL(SR.RTN_TO_USR_ID,''), @[user_id],'RT'),'T',DECODE(NVL(SR.RTN_TO_USR_ID,''), @[user_id],'TF')) ,'RT','<<-','TF','->',NULL) AS RETURN_CD" ).append("\n"); 
		query.append("	  ,DECODE(DECODE(SR.SR_CRNT_INFO_CD,'R',DECODE(NVL(SR.RTN_FM_USR_ID,''),@[user_id],'RF'),'T',DECODE(NVL(SR.RTN_TO_USR_ID,''),@[user_id],'TT')),'RF',SR.RTN_FM_USR_ID,'TT',SR.RTN_TO_USR_ID,NULL) AS RETURN_TO" ).append("\n"); 
		query.append("	  ,DECODE(SR_CRNT_INFO_CD,'T',DECODE(@[user_id],NVL(SR.RTN_TO_RTN_USR_ID,''),'TT',NVL(SR.RTN_FM_USR_ID,''),'TF','EE'),'R',DECODE(@[user_id],NVL(SR.RTN_TO_USR_ID,''),'RT',NVL(SR.RTN_FM_USR_ID,''),'RF','EE'),'EE') AS RETURN_SRC" ).append("\n"); 
		query.append("	  ,SR.RTN_FM_USR_ID AS RTN_FM_USR_ID" ).append("\n"); 
		query.append("	  ,SR.RTN_TO_USR_ID AS RTN_TO_USR_ID  " ).append("\n"); 
		query.append("	  ,SR.RTN_TO_RTN_USR_ID AS RTN_TO_RTN_USR_ID" ).append("\n"); 
		query.append("	  ,SR.BL_SPLIT_NO" ).append("\n"); 
		query.append("      ,SR.BL_SPLIT_TTL_KNT" ).append("\n"); 
		query.append("      ,to_char(SR.SR_DUE_DT,'YYYY-MM-DD') AS SR_DUE_DT" ).append("\n"); 
		query.append("      ,SR.BL_SPLIT_NO||'/'|| SR.BL_SPLIT_TTL_KNT AS SPLIT" ).append("\n"); 
		query.append("      ,SR.SPLIT_STS_CD AS SPLIT_FLG" ).append("\n"); 
		query.append("      ,FAX_LOG_REF_NO" ).append("\n"); 
		query.append("      ,sr.FNT_OFC_EML" ).append("\n"); 
		query.append("  FROM BKG_SR_CRNT_RQST SR" ).append("\n"); 
		query.append("      ,BKG_BOOKING BK" ).append("\n"); 
		query.append(" WHERE SR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("   AND SR.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("   AND SR.SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append(" ORDER BY SR.SR_AMD_SEQ DESC,SR.IMG_PG_NO" ).append("\n"); 

	}
}