/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommAuditDBDAORejectAGNCommAuditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAuditDBDAORejectAGNCommAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RejectAGNCommAudit
	  * </pre>
	  */
	public AGNCommAuditDBDAORejectAGNCommAuditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.integration").append("\n"); 
		query.append("FileName : AGNCommAuditDBDAORejectAGNCommAuditUSQL").append("\n"); 
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
		query.append("UPDATE ACM_AGN_COMM U" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	U.AC_STS_CD     = 'RR'," ).append("\n"); 
		query.append("	U.RQST_USR_ID   = NULL," ).append("\n"); 
		query.append("	U.RQST_DT       = NULL," ).append("\n"); 
		query.append("	U.RQST_GDT      = NULL," ).append("\n"); 
		query.append("	U.UPD_USR_ID    = @[usr_id]," ).append("\n"); 
		query.append("	U.UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHERE U.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("  AND U.AGN_CD      = @[agn_cd]" ).append("\n"); 
		query.append("  AND U.IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("  AND U.AC_SEQ      = @[ac_seq]" ).append("\n"); 
		query.append("  AND U.AC_STS_CD   = 'RS'" ).append("\n"); 
		query.append("#if (${ac_tp_cd} != '')" ).append("\n"); 
		query.append("  AND U.AC_TP_CD    = @[ac_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}