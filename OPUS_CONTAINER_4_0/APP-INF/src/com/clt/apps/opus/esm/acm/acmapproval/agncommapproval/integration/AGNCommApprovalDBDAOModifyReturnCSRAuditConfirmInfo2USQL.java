/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfo2USQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.12
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.12 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfo2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ACM_AGN_COMM 에 데이터를 업데이트.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfo2USQL(){
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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration ").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfo2USQL").append("\n");
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
		query.append("UPDATE ACM_AGN_COMM A" ).append("\n");
		query.append("SET" ).append("\n");
		query.append(" AC_STS_CD       = 'IC'" ).append("\n");
		query.append(",RQST_USR_ID     = NULL" ).append("\n");
		query.append(",RQST_DT         = NULL" ).append("\n");
		query.append(",RQST_GDT        = NULL" ).append("\n");
		query.append(",AUD_NO          = NULL" ).append("\n");
		query.append(",AUD_DT          = NULL" ).append("\n");
		query.append(",AUD_GDT         = NULL" ).append("\n");
		query.append(",ACCL_FLG        = NULL" ).append("\n");
		query.append(",CSR_NO          = NULL" ).append("\n");
		query.append(",APRO_USR_ID     = NULL" ).append("\n");
		query.append(",APRO_DT         = NULL" ).append("\n");
		query.append(",APRO_GDT        = NULL" ).append("\n");
		query.append(",GL_DT           = NULL" ).append("\n");
		query.append(",ASA_NO          = NULL" ).append("\n");
		query.append(",INV_TAX_RT      = NULL" ).append("\n");
		query.append(",IF_USR_ID       = NULL" ).append("\n");
		query.append(",IF_DT           = NULL" ).append("\n");
		query.append(",IF_GDT          = NULL" ).append("\n");
		query.append(",AC_PROC_DESC    = NULL" ).append("\n");
		query.append(",UPD_USR_ID      = @[usr_id]" ).append("\n");
		query.append(",UPD_DT          = SYSDATE" ).append("\n");
		query.append("WHERE CSR_NO     = @[csr_no]" ).append("\n");

	}
}