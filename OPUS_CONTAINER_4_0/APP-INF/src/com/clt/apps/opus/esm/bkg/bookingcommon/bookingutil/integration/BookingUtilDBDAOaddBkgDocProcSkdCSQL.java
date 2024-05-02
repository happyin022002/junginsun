/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOaddBkgDocProcSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOaddBkgDocProcSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingUtilDBDAOaddBkgDocProcSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_proc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_doc_proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_perf_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOaddBkgDocProcSkdCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_DOC_PROC_SKD A USING(" ).append("\n"); 
		query.append("    SELECT @[bkg_no] BKG_NO, @[bkg_doc_proc_tp_cd] BKG_DOC_PROC_TP_CD FROM DUAL" ).append("\n"); 
		query.append(") B     " ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO AND A.BKG_DOC_PROC_TP_CD = B.BKG_DOC_PROC_TP_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET DOC_PERF_DELT_FLG = @[doc_perf_delt_flg]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("	BKG_DOC_PROC_TP_CD," ).append("\n"); 
		query.append("	DOC_PROC_SEQ," ).append("\n"); 
		query.append("	DOC_PERF_DELT_FLG," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	EVNT_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("	DIFF_RMK" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	@[bkg_no]," ).append("\n"); 
		query.append("	@[bkg_doc_proc_tp_cd]," ).append("\n"); 
		query.append("	@[doc_proc_seq]," ).append("\n"); 
		query.append("	@[doc_perf_delt_flg]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	'E-BOOKING'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}