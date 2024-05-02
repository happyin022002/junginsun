/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSaveInvoicePdfFileCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.13 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSaveInvoicePdfFileCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE EDI PDF File 정보 저장
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSaveInvoicePdfFileCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSaveInvoicePdfFileCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_INV_EDI_RCV_FILE(" ).append("\n"); 
		query.append("	   INV_EDI_RCV_FILE_SEQ" ).append("\n"); 
		query.append("	  ,FILE_NM" ).append("\n"); 
		query.append("	  ,FILE_SAV_ID" ).append("\n"); 
		query.append("	  ,INV_NO" ).append("\n"); 
		query.append("	  ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("	  ,SAV_CFM_FLG" ).append("\n"); 
		query.append("	  ,FILE_RMK" ).append("\n"); 
		query.append("	  ,DELT_FLG" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("	  TO_NUMBER(TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD(TRS_INV_EDI_RCV_FILE_SEQ.NEXTVAL,4,'0'))" ).append("\n"); 
		query.append("	 ,@[file_nm]" ).append("\n"); 
		query.append("	 ,@[file_sav_id]" ).append("\n"); 
		query.append("	 ,@[inv_no]" ).append("\n"); 
		query.append("	 ,@[inv_vndr_seq]" ).append("\n"); 
		query.append(" 	 ,@[sav_cfm_flg]" ).append("\n"); 
		query.append("	 ,@[file_rmk]" ).append("\n"); 
		query.append("	 ,'N' -- DELT_FLG" ).append("\n"); 
		query.append("	 ,'HIT_INV_PDF' --cre_usr_id" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("     ,'HIT_INV_PDF' --upd_usr_id" ).append("\n"); 
		query.append("     ,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}