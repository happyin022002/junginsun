/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditDBDAOModifyAGNCommAuditConfirmUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.23
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.23 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAuditDBDAOModifyAGNCommAuditConfirmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ModifyAGNCommAuditConfirm
	  * </pre>
	  */
	public AGNCommAuditDBDAOModifyAGNCommAuditConfirmUSQL(){
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
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration").append("\n");
		query.append("FileName : AGNCommAuditDBDAOModifyAGNCommAuditConfirmUSQL").append("\n");
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
		query.append("UPDATE ACM_AGN_COMM" ).append("\n");
		query.append("   SET AC_STS_CD   = 'AS'," ).append("\n");
		query.append("       AUD_NO      = @[aud_no]," ).append("\n");
		query.append("       AUD_USR_ID  = @[usr_id]," ).append("\n");
		query.append("       AUD_GDT     = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,'GMT')," ).append("\n");
		query.append("       AUD_DT      = SYSDATE," ).append("\n");
		query.append("       UPD_USR_ID  = @[usr_id]," ).append("\n");
		query.append("       UPD_DT      = SYSDATE" ).append("\n");
		query.append(" WHERE AGN_CD     = @[agn_cd]" ).append("\n");
		query.append("   AND RQST_DT     IS NOT NULL" ).append("\n");
		query.append("   AND AUD_DT      IS NULL" ).append("\n");
		query.append("   AND APRO_DT     IS NULL" ).append("\n");
		query.append("   AND AC_STS_CD IN('RS','RM')" ).append("\n");
		query.append("   AND BKG_NO||AGN_CD||IO_BND_CD||AC_SEQ IN " ).append("\n");
		query.append("   (SELECT COLUMN_VALUE" ).append("\n");
		query.append("    FROM TABLE(BKG_SPLIT_CLOB_FNC(${bkg_no}" ).append("\n");
		query.append("    )))" ).append("\n");

	}
}