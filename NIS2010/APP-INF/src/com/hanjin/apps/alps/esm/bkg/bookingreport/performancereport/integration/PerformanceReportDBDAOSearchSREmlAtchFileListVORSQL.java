/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchSREmlAtchFileListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.01 
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

public class PerformanceReportDBDAOSearchSREmlAtchFileListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchSREmlAtchFileListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchSREmlAtchFileListVORSQL").append("\n"); 
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
		query.append("	ATCH.SR_NO" ).append("\n"); 
		query.append(",	ATCH.FAX_LOG_REF_NO" ).append("\n"); 
		query.append(",	ATCH.SR_KND_CD" ).append("\n"); 
		query.append(",	ATCH.EML_ATCH_FILE_SEQ" ).append("\n"); 
		query.append("#if (${conv_pdf_flg} == 'Y')" ).append("\n"); 
		query.append(",   '/a_dpcs/mail/module/BKG/' || DECODE(NVL(EML.FAX_SVR_OFC_CD,' '),' ',EML.RCV_OFC_CD,EML.FAX_SVR_OFC_CD) || '/' || ATCH.CONV_ATCH_FILE_PATH_CTNT AS ATCH_FILE_PATH_CTNT" ).append("\n"); 
		query.append(",	ATCH.CONV_EML_ATCH_FILE_NM AS EML_ATCH_FILE_NM" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	'/a_dpcs/mail/module/BKG/' || DECODE(NVL(EML.FAX_SVR_OFC_CD,' '),' ',EML.RCV_OFC_CD,EML.FAX_SVR_OFC_CD) || '/' || ATCH.ATCH_FILE_PATH_CTNT AS ATCH_FILE_PATH_CTNT" ).append("\n"); 
		query.append(",	ATCH.EML_ATCH_FILE_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	ATCH.CRE_USR_ID" ).append("\n"); 
		query.append(",	ATCH.CRE_DT" ).append("\n"); 
		query.append(",	ATCH.UPD_USR_ID" ).append("\n"); 
		query.append(",	ATCH.UPD_DT" ).append("\n"); 
		query.append(",	ATCH.EML_ATCH_FILE_SZ_CAPA" ).append("\n"); 
		query.append(",	EML.EML_SUBJ_CTNT" ).append("\n"); 
		query.append(",	EML.EML_ORG_SUBJ_CTNT" ).append("\n"); 
		query.append("FROM BKG_SR_EML_ATCH_FILE ATCH" ).append("\n"); 
		query.append(",	BKG_SR_FAX EML" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND	ATCH.SR_NO(+)	= EML.SR_NO" ).append("\n"); 
		query.append("AND	ATCH.FAX_LOG_REF_NO(+) = EML.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("AND	ATCH.SR_KND_CD(+) = EML.SR_KND_CD" ).append("\n"); 
		query.append("AND	EML.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND	EML.FAX_LOG_REF_NO = @[fax_log_ref_no]" ).append("\n"); 
		query.append("AND	EML.SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 

	}
}