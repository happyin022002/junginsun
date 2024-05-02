/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOBkgSrFax3VOUSQL.java
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

public class PerformanceReportDBDAOBkgSrFax3VOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public PerformanceReportDBDAOBkgSrFax3VOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtch_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnt_ofc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBkgSrFax3VOUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_FAX SET " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sr_mtch_sts_cd} == 'DEL') " ).append("\n"); 
		query.append("	SR_MTCH_STS_CD = DECODE((SELECT COUNT(1) FROM BKG_SR_CRNT_RQST RQ WHERE RQ.SR_KND_CD = 'F' AND RQ.SR_NO = @[sr_no]),0,'W','P')" ).append("\n"); 
		query.append(",   SR_TRNS_USR_ID = CASE WHEN (SELECT COUNT(1) FROM BKG_SR_CRNT_RQST RQ WHERE RQ.SR_KND_CD = 'F' AND RQ.SR_NO = @[sr_no]) > 0 THEN @[mtch_usr_id] ELSE '' END" ).append("\n"); 
		query.append(",   SR_TRNS_DT =  GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append(",   FNT_OFC_EML =''" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	SR_MTCH_STS_CD = @[sr_mtch_sts_cd]" ).append("\n"); 
		query.append(",	SR_TRNS_USR_ID  = @[mtch_usr_id]" ).append("\n"); 
		query.append(",	SR_TRNS_DT = GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append(",   FNT_OFC_EML = @[fnt_ofc_eml]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append(",    UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",    UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND	SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append("AND	FAX_LOG_REF_NO = @[fax_log_ref_no]" ).append("\n"); 
		query.append("#if (${sr_mtch_sts_cd} == 'W') " ).append("\n"); 
		query.append("--AND	SR_MTCH_STS_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}