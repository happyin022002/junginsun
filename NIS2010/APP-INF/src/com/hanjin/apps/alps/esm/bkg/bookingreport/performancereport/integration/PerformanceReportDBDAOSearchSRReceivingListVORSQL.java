/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchSRReceivingListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.06
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.04.06 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchSRReceivingListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchSRReceivingListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_mtch_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchSRReceivingListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	FAX.SR_NO" ).append("\n"); 
		query.append(",	FAX.FAX_LOG_REF_NO" ).append("\n"); 
		query.append(",	FAX.SR_KND_CD" ).append("\n"); 
		query.append(",	TRIM(FAX.SNDR_FAX_NO_CTNT) AS SNDR_FAX_NO_CTNT " ).append("\n"); 
		query.append(",	TO_CHAR(FAX.RCV_DT,'YYYY-MM-DD HH24:MI')  RCV_DT" ).append("\n"); 
		query.append(",	FAX.RCV_OFC_CD" ).append("\n"); 
		query.append(",	DECODE(NVL(FAX_SVR_OFC_CD,' '),' ',FAX.RCV_OFC_CD,FAX_SVR_OFC_CD) AS FAX_SVR_OFC_CD" ).append("\n"); 
		query.append(",	FAX.RCV_NM" ).append("\n"); 
		query.append(",	FAX.RCV_RMK" ).append("\n"); 
		query.append(",	FAX.IMG_FILE_IP" ).append("\n"); 
		query.append(",	FAX.IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append(",	FAX.IMG_FILE_NM" ).append("\n"); 
		query.append(",	'//a_dpcs' || '/' || DECODE(NVL(FAX.FAX_SVR_OFC_CD,' '),' ',FAX.RCV_OFC_CD,FAX.FAX_SVR_OFC_CD) || '/' || FAX.IMG_FILE_PATH_CTNT || FAX.IMG_FILE_NM AS IMG_FILE_REAL_PATH" ).append("\n"); 
		query.append(",	FAX.TTL_PG_KNT" ).append("\n"); 
		query.append(",	DECODE(FAX.SR_FAX_RSLT_CD,'10','Received Done','Received Error') AS SR_FAX_RSLT_CD" ).append("\n"); 
		query.append(",	FAX.SR_MTCH_STS_CD" ).append("\n"); 
		query.append(",	DECODE(FAX.SR_MTCH_STS_CD,'A','Wt + Prc','W','Waiting','P','Processing','T','Transferred') AS SR_MTCH_STS_NM" ).append("\n"); 
		query.append(",   BKG_JOIN_FNC(CURSOR(SELECT BKG_NO FROM BKG_SR_CRNT_RQST WHERE SR_KND_CD = FAX.SR_KND_CD AND SR_NO = FAX.SR_NO)) BKG_NO" ).append("\n"); 
		query.append(",	FAX.MTCH_USR_ID" ).append("\n"); 
		query.append(",   (SELECT USR_NM FROM COM_USER WHERE USR_ID = FAX.MTCH_USR_ID) MTCH_USR_NM" ).append("\n"); 
		query.append(",	FAX.WRK_TM_NO" ).append("\n"); 
		query.append(",	FAX.CRE_USR_ID" ).append("\n"); 
		query.append(",	FAX.CRE_DT" ).append("\n"); 
		query.append(",	FAX.UPD_USR_ID" ).append("\n"); 
		query.append(",	FAX.UPD_DT" ).append("\n"); 
		query.append("--,	DECODE(FAX.SR_MTCH_STS_CD,'T',TO_CHAR(FAX.UPD_DT,'YYYY-MM-DD HH:MM'),'') UPD_DT" ).append("\n"); 
		query.append("--,   MAX(TO_CHAR(RQST.FNT_OFC_TRNS_DT,'YYYY-MM-DD HH24:MI')) UPD_DT" ).append("\n"); 
		query.append(",   TO_CHAR(FAX.SR_TRNS_DT,'YYYY-MM-DD HH24:MI') SR_TRNS_DT" ).append("\n"); 
		query.append(",	FAX.SR_TRNS_USR_ID" ).append("\n"); 
		query.append(",   (SELECT USR_NM FROM COM_USER WHERE USR_ID = FAX.SR_TRNS_USR_ID) SR_TRNS_USR_NM" ).append("\n"); 
		query.append(",	'' FROM_DT" ).append("\n"); 
		query.append(",	'' TO_DT" ).append("\n"); 
		query.append(",	'' OFC_INC_SUB" ).append("\n"); 
		query.append("FROM BKG_SR_FAX 		FAX" ).append("\n"); 
		query.append("    ,BKG_SR_CRNT_RQST 	RQST" ).append("\n"); 
		query.append("WHERE 0 = 0" ).append("\n"); 
		query.append("AND	NVL(SR_MTCH_STS_CD,' ') != 'D'" ).append("\n"); 
		query.append("#if (${sr_mtch_sts_cd} != '' && ${sr_mtch_sts_cd} == 'A')" ).append("\n"); 
		query.append("AND (SR_MTCH_STS_CD = 'W' OR SR_MTCH_STS_CD = 'P')" ).append("\n"); 
		query.append("#elseif (${sr_mtch_sts_cd} != '' && ${sr_mtch_sts_cd} != 'A')" ).append("\n"); 
		query.append("AND SR_MTCH_STS_CD = @[sr_mtch_sts_cd]" ).append("\n"); 
		query.append("#end 	" ).append("\n"); 
		query.append("AND FAX.SR_NO = RQST.SR_NO(+)" ).append("\n"); 
		query.append("AND FAX.SR_KND_CD = RQST.SR_KND_CD(+)" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	AND EXISTS (SELECT 1 FROM BKG_SR_CRNT_RQST R  WHERE R.SR_KND_CD = FAX.SR_KND_CD AND R.SR_NO = FAX.SR_NO AND  R.BKG_NO= @[bkg_no])" ).append("\n"); 
		query.append("#elseif (${from_dt} != '') " ).append("\n"); 
		query.append("	AND	TO_CHAR(RCV_DT,'YYYY-MM-DD') between @[from_dt] and @[to_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_inc_sub} == 'Y' && ${rcv_ofc_cd} != '') " ).append("\n"); 
		query.append("	AND FAX.RCV_OFC_CD IN (" ).append("\n"); 
		query.append("		SELECT 	OFC_CD  " ).append("\n"); 
		query.append("		FROM   	MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("		START 	WITH MO.OFC_CD = @[rcv_ofc_cd]" ).append("\n"); 
		query.append("				CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	#if (${rcv_ofc_cd} != '') " ).append("\n"); 
		query.append("	AND   FAX.RCV_OFC_CD = @[rcv_ofc_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sr_no} != '') " ).append("\n"); 
		query.append("AND FAX.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fax_log_ref_no} != '') " ).append("\n"); 
		query.append("AND	FAX.FAX_LOG_REF_NO  = @[fax_log_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND FAX.SR_KND_CD = 'F'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("FAX.SR_NO" ).append("\n"); 
		query.append(",	FAX.FAX_LOG_REF_NO" ).append("\n"); 
		query.append(",	FAX.SR_KND_CD" ).append("\n"); 
		query.append(",	FAX.SNDR_FAX_NO_CTNT" ).append("\n"); 
		query.append(",	FAX.RCV_DT" ).append("\n"); 
		query.append(",	FAX.RCV_OFC_CD" ).append("\n"); 
		query.append(",   FAX.FAX_SVR_OFC_CD" ).append("\n"); 
		query.append(",	FAX.RCV_NM" ).append("\n"); 
		query.append(",	FAX.RCV_RMK" ).append("\n"); 
		query.append(",	FAX.IMG_FILE_IP" ).append("\n"); 
		query.append(",	FAX.IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append(",	FAX.IMG_FILE_NM" ).append("\n"); 
		query.append(",	FAX.TTL_PG_KNT" ).append("\n"); 
		query.append(",	DECODE(FAX.SR_FAX_RSLT_CD,'10','Received Done','Received Error') " ).append("\n"); 
		query.append(",	FAX.SR_MTCH_STS_CD" ).append("\n"); 
		query.append(",	DECODE(FAX.SR_MTCH_STS_CD,'A','Wt + Prc','W','Waiting','P','Processing','T','Transferred') " ).append("\n"); 
		query.append(",   BKG_JOIN_FNC(CURSOR(SELECT BKG_NO FROM BKG_SR_CRNT_RQST WHERE SR_KND_CD = FAX.SR_KND_CD AND SR_NO = FAX.SR_NO)) " ).append("\n"); 
		query.append(",	FAX.MTCH_USR_ID" ).append("\n"); 
		query.append(",	FAX.WRK_TM_NO" ).append("\n"); 
		query.append(",	FAX.CRE_USR_ID" ).append("\n"); 
		query.append(",	FAX.CRE_DT" ).append("\n"); 
		query.append(",	FAX.UPD_USR_ID" ).append("\n"); 
		query.append(",	FAX.UPD_DT" ).append("\n"); 
		query.append(",   FAX.SR_TRNS_DT" ).append("\n"); 
		query.append(",	FAX.SR_TRNS_USR_ID" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("FAX.SR_NO" ).append("\n"); 

	}
}