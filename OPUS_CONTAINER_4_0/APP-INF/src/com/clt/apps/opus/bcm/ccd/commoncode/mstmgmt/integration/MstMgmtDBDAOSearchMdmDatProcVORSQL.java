/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MstMgmtDBDAOSearchMdmDatProcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchMdmDatProcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_DAT_PROC 정보 조회
	  * </pre>
	  */
	public MstMgmtDBDAOSearchMdmDatProcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchMdmDatProcVORSQL").append("\n"); 
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
		query.append("SELECT RQST_NO," ).append("\n"); 
		query.append("MST_DAT_SUBJ_CD," ).append("\n"); 
		query.append("RQST_USR_ID," ).append("\n"); 
		query.append("RQST_OFC_CD," ).append("\n"); 
		query.append("APRO_USR_ID," ).append("\n"); 
		query.append("PROC_TP_CD," ).append("\n"); 
		query.append("RJCT_RMK," ).append("\n"); 
		query.append("APRO_RMK," ).append("\n"); 
		query.append("RQST_CRE_DT," ).append("\n"); 
		query.append("RQST_UPD_DT," ).append("\n"); 
		query.append("PROC_CRE_DT," ).append("\n"); 
		query.append("PROC_UPD_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("'' RQST_DTL_PGM_NO," ).append("\n"); 
		query.append("'' PROC_TP_NM," ).append("\n"); 
		query.append("'' RQST_NM," ).append("\n"); 
		query.append("'' FM_RQST_DT," ).append("\n"); 
		query.append("'' TO_RQST_DT," ).append("\n"); 
		query.append("'' OFC_KND_CD," ).append("\n"); 
		query.append("'' RMK," ).append("\n"); 
		query.append("'' RQST_CD," ).append("\n"); 
		query.append("'' RQST_NM," ).append("\n"); 
		query.append("'' MST_DAT_SUBJ_DESC," ).append("\n"); 
		query.append("'' AUTH_TP_CD," ).append("\n"); 
		query.append("'' MDAA_CHK" ).append("\n"); 
		query.append("FROM MDM_DAT_PROC" ).append("\n"); 
		query.append("WHERE RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}