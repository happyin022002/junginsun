/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnComm2InfoUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.05 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnComm2InfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ACM_AGN_COMM에 데이터를 업데이트한다.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnComm2InfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnComm2InfoUSQL").append("\n");
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
		query.append("   SET A.AC_STS_CD = 'PS'," ).append("\n");
		query.append("       A.APRO_USR_ID = @[upd_usr_id]," ).append("\n");
		query.append("       A.APRO_DT = SYSDATE," ).append("\n");
		query.append("       A.APRO_GDT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'GDT')," ).append("\n");
		query.append("       A.AC_PROC_DESC = 'Approval Success!'," ).append("\n");
		query.append("       A.IF_DT = SYSDATE," ).append("\n");
		query.append("       A.IF_GDT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'GDT')," ).append("\n");
		query.append("       A.GL_DT = (SELECT DISTINCT B.GL_DT" ).append("\n");
		query.append("                    FROM AP_INV_HDR B" ).append("\n");
		query.append("                   WHERE B.CSR_NO = A.CSR_NO)" ).append("\n");
		query.append("    WHERE A.CSR_NO =  @[csr_no]" ).append("\n");

	}
}