/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyQueueRtnToRtnUSQL.java
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

public class PerformanceReportDBDAOModifyQueueRtnToRtnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOModifyQueueRtnToRtnUSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyQueueRtnToRtnUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyQueueRtnToRtnUSQL").append("\n"); 
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
		query.append("        SET SR_CRNT_INFO_CD    ='T', /*상수*/" ).append("\n"); 
		query.append("            RTN_TO_RTN_STS_CD  =  RTN_FM_STS_CD," ).append("\n"); 
		query.append("            RTN_TO_RTN_USR_ID  = RTN_FM_USR_ID," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            BL_DOC_INP_FLG = Decode(RTN_FM_STS_CD,'I','Y',BL_DOC_INP_FLG)," ).append("\n"); 
		query.append("            BL_RT_FLG      = Decode(RTN_FM_STS_CD,'R','Y', BL_RT_FLG)," ).append("\n"); 
		query.append("            BL_AUD_FLG     = Decode(RTN_FM_STS_CD,'A','Y', BL_AUD_FLG)," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            CRNT_DT     =   GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC( (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                                                          FROM   COM_USER" ).append("\n"); 
		query.append("                                                                                                          WHERE  USR_ID = @[usr_id]) )" ).append("\n"); 
		query.append("                                    )," ).append("\n"); 
		query.append("            CRNT_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("            UPD_DT      = SYSDATE," ).append("\n"); 
		query.append("            UPD_USR_ID  = @[usr_id]" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("    WHERE SR_KND_CD   = @[src_cd] /*0421의 SRC_CD*/" ).append("\n"); 
		query.append("     AND SR_NO        = @[sr_no]    " ).append("\n"); 
		query.append("     AND BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("     AND SR_AMD_TP_CD = @[sr_knd_cd]/* 0421의 SR_KND_CD*/ " ).append("\n"); 
		query.append("     AND SR_AMD_SEQ = (SELECT NVL(MAX(SR_AMD_SEQ),0)" ).append("\n"); 
		query.append("                        FROM   BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                        WHERE SR_KND_CD = X.SR_KND_CD" ).append("\n"); 
		query.append("                        AND SR_AMD_TP_CD = X.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                        AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                        AND SR_NO = X.SR_NO" ).append("\n"); 
		query.append("                     )" ).append("\n"); 

	}
}