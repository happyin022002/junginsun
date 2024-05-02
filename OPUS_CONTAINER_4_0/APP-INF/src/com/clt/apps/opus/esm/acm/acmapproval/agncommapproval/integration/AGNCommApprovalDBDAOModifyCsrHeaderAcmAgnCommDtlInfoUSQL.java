/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnCommDtlInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.03 
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

public class AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnCommDtlInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACM_AGN_COMM_DTL에 데이터를 업데이트한다.
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnCommDtlInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOModifyCsrHeaderAcmAgnCommDtlInfoUSQL").append("\n"); 
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
		query.append("MERGE INTO ACM_AGN_COMM_DTL k using(     " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("                 A.BKG_NO," ).append("\n"); 
		query.append("                 A.AGN_CD," ).append("\n"); 
		query.append("                 A.IO_BND_CD," ).append("\n"); 
		query.append("                 A.AC_TP_CD," ).append("\n"); 
		query.append("                 A.AC_SEQ," ).append("\n"); 
		query.append("                 A.IF_AMT      - SUM (B.IF_DTRB_AMT)  AS IF_DTRB_AMT," ).append("\n"); 
		query.append("                 A.PAY_IF_AMT  - SUM (B.PAY_IF_DTRB_AMT) AS PAY_IF_DTRB_AMT," ).append("\n"); 
		query.append("               (     SELECT" ).append("\n"); 
		query.append("                            X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       FROM BKG_QUANTITY X" ).append("\n"); 
		query.append("                      WHERE X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                        AND ROWNUM   = 1" ).append("\n"); 
		query.append("               ) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM ACM_AGN_COMM        A," ).append("\n"); 
		query.append("                 ACM_AGN_COMM_DTL    B" ).append("\n"); 
		query.append("           WHERE A.BKG_NO            = B.BKG_NO" ).append("\n"); 
		query.append("             AND A.AGN_CD            = B.AGN_CD" ).append("\n"); 
		query.append("             AND A.IO_BND_CD         = B.IO_BND_CD" ).append("\n"); 
		query.append("             AND A.AC_TP_CD          = B.AC_TP_CD" ).append("\n"); 
		query.append("--             AND A.AC_SEQ            = B.AC_SEQ" ).append("\n"); 
		query.append("             AND B.AC_SEQ			 IN (A.AC_SEQ, A.AC_SEQ+1000) --MH 추가로 인해 AC_SEQ 로직 변경" ).append("\n"); 
		query.append("             AND A.AR_OFC_CD         = @[ar_ofc_cd]" ).append("\n"); 
		query.append("             AND A.AGN_CD            = @[agn_cd]" ).append("\n"); 
		query.append("             AND A.CRE_USR_ID       != 'COST'" ).append("\n"); 
		query.append("             AND A.IF_DT         IS NULL" ).append("\n"); 
		query.append("             AND A.AC_STS_CD  		 = 'AS'" ).append("\n"); 
		query.append("        	#if(${aud_no} != '')" ).append("\n"); 
		query.append("             AND AUD_NO              = @[aud_no]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        GROUP BY A.BKG_NO," ).append("\n"); 
		query.append("                 A.AGN_CD," ).append("\n"); 
		query.append("                 A.IO_BND_CD," ).append("\n"); 
		query.append("                 A.AC_TP_CD," ).append("\n"); 
		query.append("                 A.AC_SEQ," ).append("\n"); 
		query.append("                 A.IF_AMT," ).append("\n"); 
		query.append("                 A.PAY_IF_AMT" ).append("\n"); 
		query.append("          HAVING A.IF_AMT - SUM (B.IF_DTRB_AMT)+1 <> 0" ).append("\n"); 
		query.append("              OR A.PAY_IF_AMT - SUM (B.PAY_IF_DTRB_AMT) <> 0" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append(") b2 on( k.bkg_no = b2.bkg_no" ).append("\n"); 
		query.append("AND K.AGN_CD = B2.AGN_CD" ).append("\n"); 
		query.append("AND K.IO_BND_CD = B2.IO_BND_CD" ).append("\n"); 
		query.append("AND K.AC_TP_CD = B2.AC_TP_CD" ).append("\n"); 
		query.append("AND K.AC_SEQ IN (B2.AC_SEQ, B2.AC_SEQ+1000)" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET K.IF_DTRB_AMT  = K.IF_DTRB_AMT+B2.IF_DTRB_AMT," ).append("\n"); 
		query.append("    K.PAY_IF_DTRB_AMT = K.PAY_IF_DTRB_AMT+B2.PAY_IF_DTRB_AMT," ).append("\n"); 
		query.append("    K.UPD_USR_ID        = @[upd_usr_id]," ).append("\n"); 
		query.append("    K.UPD_DT            = SYSDATE" ).append("\n"); 

	}
}