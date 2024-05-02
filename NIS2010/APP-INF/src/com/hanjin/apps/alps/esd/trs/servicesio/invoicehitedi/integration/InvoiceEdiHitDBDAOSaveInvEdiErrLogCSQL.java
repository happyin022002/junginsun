/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSaveInvEdiErrLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.15 신동일
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

public class InvoiceEdiHitDBDAOSaveInvEdiErrLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice EDI Error Log 저장
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSaveInvEdiErrLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSaveInvEdiErrLogCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_INV_EDI_ERR_LOG(" ).append("\n"); 
		query.append("	   INV_EDI_ERR_LOG_SEQ" ).append("\n"); 
		query.append("	   ,INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("	   ,INV_EDI_STS_CD" ).append("\n"); 
		query.append("	   ,ERR_MSG" ).append("\n"); 
		query.append("	   ,CRE_USR_ID" ).append("\n"); 
		query.append("	   ,CRE_DT" ).append("\n"); 
		query.append("	   ,UPD_USR_ID" ).append("\n"); 
		query.append("	   ,UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("	  (SELECT CASE WHEN MAX(INV_EDI_ERR_LOG_SEQ) IS NULL THEN 1" ).append("\n"); 
		query.append("	               ELSE MAX(INV_EDI_ERR_LOG_SEQ)+1 " ).append("\n"); 
		query.append("			   END" ).append("\n"); 
		query.append("	     FROM TRS_INV_EDI_ERR_LOG)" ).append("\n"); 
		query.append("     ,@[inv_edi_rcv_seq]" ).append("\n"); 
		query.append("	 ,@[inv_edi_sts_cd]" ).append("\n"); 
		query.append("	 ,SUBSTR(@[err_msg],1,4000)" ).append("\n"); 
		query.append("	 ,'HIT_INV_EDI_ERR'" ).append("\n"); 
		query.append("	 ,SYSDATE" ).append("\n"); 
		query.append("	 ,'HIT_INV_EDI_ERR'" ).append("\n"); 
		query.append("	 ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}