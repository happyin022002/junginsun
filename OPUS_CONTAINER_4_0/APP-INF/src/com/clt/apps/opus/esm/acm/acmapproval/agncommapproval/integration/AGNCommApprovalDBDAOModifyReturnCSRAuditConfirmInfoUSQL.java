/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfoUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier :
*@LastVersion : 1.0
* 2012.07.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ACM_AGN_COMM에 aud_no 를 업데이트 한다.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfoUSQL(){
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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOModifyReturnCSRAuditConfirmInfoUSQL").append("\n");
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
		query.append(" AC_STS_CD       = 'AS'" ).append("\n");
		query.append(",AUD_NO          = @[aud_no]" ).append("\n");
		query.append(",AUD_DT          = SYSDATE" ).append("\n");
		query.append(",AUD_GDT         = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'GMT')" ).append("\n");
		query.append(",ACCL_FLG        = 'N'" ).append("\n");
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
		query.append("" ).append("\n");
		query.append("WHERE CSR_NO     = @[csr_no]" ).append("\n");
		query.append("AND BKG_NO NOT IN " ).append("\n");
		query.append("(" ).append("\n");
		query.append("    SELECT DISTINCT A.BKG_NO FROM BKG_BOOKING B , ACM_AGN_COMM A" ).append("\n");
		query.append("    WHERE 1=1" ).append("\n");
		query.append("    AND A.CSR_NO = @[csr_no]" ).append("\n");
		query.append("    AND A.AGN_CD = SUBSTR(@[csr_no],4,5)" ).append("\n");
		query.append("    AND A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("    AND B.BKG_STS_CD IN ('X','A')" ).append("\n");
		query.append(")" ).append("\n");
		query.append("AND BKG_NO NOT IN (" ).append("\n");
		query.append("    SELECT DISTINCT A.BKG_NO FROM BKG_VVD V , ACM_AGN_COMM A" ).append("\n");
		query.append("    WHERE 1=1" ).append("\n");
		query.append("    AND A.CSR_NO = @[csr_no]" ).append("\n");
		query.append("    AND A.AGN_CD = SUBSTR(@[csr_no],4,5)" ).append("\n");
		query.append("    AND A.BKG_NO = V.BKG_NO" ).append("\n");
		query.append("    AND V.VSL_CD IN ('HJXX','HJYY','HJZZ')" ).append("\n");
		query.append(")" ).append("\n");

	}
}