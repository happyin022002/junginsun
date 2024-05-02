/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyQueueDetailReturnUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifyQueueDetailReturnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOModifyQueueDetailReturnUSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyQueueDetailReturnUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyQueueDetailReturnUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_CRNT_RQST X" ).append("\n"); 
		query.append(" SET   SR_CRNT_STS_CD   = DECODE(@[grp_cd], 'I', 'ID', 'R', 'RD', 'A', 'AD', '  ')" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("       #if (${ui_grp_cd} == 'I') " ).append("\n"); 
		query.append("     , BL_DOC_INP_FLG    = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #elseif (${ui_grp_cd} == 'R') " ).append("\n"); 
		query.append("     , BL_RT_FLG    = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #elseif (${ui_grp_cd} == 'S') " ).append("\n"); 
		query.append("     , BL_DOC_INP_FLG    = 'N'" ).append("\n"); 
		query.append("     , BL_RT_FLG    = 'N'" ).append("\n"); 
		query.append("     , BL_AUD_FLG    = 'N'              " ).append("\n"); 
		query.append("     , BL_DRFT_FAX_OUT_FLG    = 'N'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , SR_CRNT_INFO_CD   ='R' /*상수*/" ).append("\n"); 
		query.append("     , MAX_HIS_SEQ = ( SELECT MAX(SR_HIS_SEQ)" ).append("\n"); 
		query.append("						FROM  BKG_SR_HIS" ).append("\n"); 
		query.append("						WHERE BKG_NO   = X.BKG_NO" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("     , CRNT_DT          =  GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC( (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                                                         FROM   COM_USER" ).append("\n"); 
		query.append("                                                                                                         WHERE  USR_ID = @[usr_id]) )" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("     , CRNT_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , RTN_FM_STS_CD    = @[grp_cd]" ).append("\n"); 
		query.append("     , RTN_FM_USR_ID    = @[usr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , SR_RTN_TO_STS_CD = DECODE(@[ui_grp_cd], 'I', 'I', 'R', 'R', 'S', 'S', ' ')/* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("     , UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("     #if (${ui_grp_cd} == 'I') " ).append("\n"); 
		query.append("	 , RTN_TO_USR_ID    = BL_DOC_INP_USR_ID" ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'R') " ).append("\n"); 
		query.append("	 , RTN_TO_USR_ID    = BL_RT_USR_ID" ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'S') " ).append("\n"); 
		query.append("     , RTN_TO_USR_ID    = FNT_OFC_CD " ).append("\n"); 
		query.append("	 #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , RTN_DT           = GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC( (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                                                         FROM   COM_USER" ).append("\n"); 
		query.append("                                                                                                         WHERE  USR_ID = @[usr_id]) )" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("WHERE SR_KND_CD = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("  AND  SR_NO    = @[sr_no]" ).append("\n"); 
		query.append("  AND  BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("  AND SR_AMD_TP_CD = @[sr_knd_cd]/* 0421의 SR_KND_CD*/" ).append("\n"); 
		query.append("  AND SR_AMD_SEQ = (SELECT MAX(SR_AMD_SEQ) " ).append("\n"); 
		query.append("                      FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                     WHERE SR_KND_CD = X.SR_KND_CD" ).append("\n"); 
		query.append("                       AND SR_NO = X.SR_NO" ).append("\n"); 
		query.append("                       AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                       AND SR_AMD_TP_CD = X.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 

	}
}