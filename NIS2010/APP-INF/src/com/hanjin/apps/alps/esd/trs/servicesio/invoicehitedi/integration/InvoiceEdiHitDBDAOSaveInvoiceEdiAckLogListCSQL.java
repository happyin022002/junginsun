/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSaveInvoiceEdiAckLogListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.30 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSaveInvoiceEdiAckLogListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE EDI ACK LOG LIST 저장
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSaveInvoiceEdiAckLogListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_snd_log_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration ").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSaveInvoiceEdiAckLogListCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_INV_EDI_ACK_LOG_LIST(" ).append("\n"); 
		query.append("	   INV_EDI_SND_DT" ).append("\n"); 
		query.append("	  ,INV_EDI_SND_LOG_SEQ" ).append("\n"); 
		query.append("	  ,INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("	  ,INV_NO" ).append("\n"); 
		query.append("	  ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("	   @[inv_edi_snd_dt]" ).append("\n"); 
		query.append("	  ,@[inv_edi_snd_log_seq]" ).append("\n"); 
		query.append("	  ,@[inv_edi_rcv_seq]" ).append("\n"); 
		query.append("	  ,@[inv_no]" ).append("\n"); 
		query.append("	  ,@[inv_vndr_seq]" ).append("\n"); 
		query.append("	  ,'HIT_INV_EDI' --cre_usr_id" ).append("\n"); 
		query.append("	  ,SYSDATE       --cre_dt" ).append("\n"); 
		query.append("	  ,'HIT_INV_EDI' --upd_usr_id" ).append("\n"); 
		query.append("	  ,SYSDATE       --upd_dt" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}