/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOaddBkgDocProcSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.18
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.03.18 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOaddBkgDocProcSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOaddBkgDocProcSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOaddBkgDocProcSkdCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DOC_PROC_SKD(" ).append("\n"); 
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
		query.append("	(SELECT (NVL(MAX(DOC_PROC_SEQ),0)+1) AS DOC_PROC_SEQ FROM BKG_DOC_PROC_SKD WHERE BKG_NO = @[bkg_no] AND BKG_DOC_PROC_TP_CD = @[bkg_doc_proc_tp_cd])," ).append("\n"); 
		query.append("	'N'," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[diff_rmk]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}