/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommAuditDBDAOModifyOTRCommAuditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OTRCommAuditDBDAOModifyOTRCommAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyOTRCommAudit
	  * </pre>
	  */
	public OTRCommAuditDBDAOModifyOTRCommAuditUSQL(){
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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.integration").append("\n"); 
		query.append("FileName : OTRCommAuditDBDAOModifyOTRCommAuditUSQL").append("\n"); 
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
		query.append("UPDATE ACM_AGN_OTR_COMM" ).append("\n"); 
		query.append("   SET AC_STS_CD   = 'AS'," ).append("\n"); 
		query.append("       AUD_NO      = @[aud_no]," ).append("\n"); 
		query.append("       AUD_USR_ID  = @[usr_id]," ).append("\n"); 
		query.append("       AUD_GDT     = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,'GMT')," ).append("\n"); 
		query.append("       AUD_DT      = SYSDATE," ).append("\n"); 
		query.append("       UPD_USR_ID  = @[usr_id]," ).append("\n"); 
		query.append("       UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(" WHERE RQST_DT     IS NOT NULL" ).append("\n"); 
		query.append("   AND AUD_DT      IS NULL" ).append("\n"); 
		query.append("   AND APRO_DT     IS NULL" ).append("\n"); 
		query.append("   AND AC_STS_CD" ).append("\n"); 
		query.append("    IN" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       'RS','RM'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("AND OTR_COMM_NO||AGN_CD||IO_BND_CD||AC_SEQ IN (${bkg_no})" ).append("\n"); 

	}
}