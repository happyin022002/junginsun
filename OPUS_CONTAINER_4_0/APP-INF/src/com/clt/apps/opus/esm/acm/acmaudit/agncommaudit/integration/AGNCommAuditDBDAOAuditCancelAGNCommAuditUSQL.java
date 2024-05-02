/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditDBDAOAuditCancelAGNCommAuditUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.11 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAuditDBDAOAuditCancelAGNCommAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * AuditCancelAGNCommAudit
	  * </pre>
	  */
	public AGNCommAuditDBDAOAuditCancelAGNCommAuditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration ").append("\n");
		query.append("FileName : AGNCommAuditDBDAOAuditCancelAGNCommAuditUSQL").append("\n");
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
		query.append("	U.AC_STS_CD     = 'AR'," ).append("\n");
		query.append("	U.RQST_USR_ID   = NULL," ).append("\n");
		query.append("	U.RQST_DT       = NULL," ).append("\n");
		query.append("	U.RQST_GDT      = NULL," ).append("\n");
		query.append("	U.AUD_NO        = NULL," ).append("\n");
		query.append("	U.AUD_USR_ID    = NULL," ).append("\n");
		query.append("	U.AUD_DT        = NULL," ).append("\n");
		query.append("	U.AUD_GDT       = NULL," ).append("\n");
		query.append("	U.UPD_USR_ID    = @[usr_id]," ).append("\n");
		query.append("	U.UPD_DT        = SYSDATE" ).append("\n");
		query.append("WHERE U.BKG_NO      = @[bkg_no]" ).append("\n");
		query.append("  AND U.AGN_CD      = @[agn_cd]" ).append("\n");
		query.append("  AND U.IO_BND_CD   = @[io_bnd_cd]" ).append("\n");
		query.append("  AND U.AC_SEQ      = @[ac_seq]" ).append("\n");
		query.append("  AND U.AC_STS_CD   = 'AS'" ).append("\n");

	}
}