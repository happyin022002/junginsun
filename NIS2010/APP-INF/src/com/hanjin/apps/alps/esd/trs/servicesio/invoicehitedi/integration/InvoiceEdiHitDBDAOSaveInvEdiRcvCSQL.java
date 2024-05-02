/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSaveInvEdiRcvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.08 신동일
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

public class InvoiceEdiHitDBDAOSaveInvEdiRcvCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_INV_EDI_RCV 테이블에 데이터 insert
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSaveInvEdiRcvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_atch_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_whld_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSaveInvEdiRcvCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_INV_EDI_RCV(" ).append("\n"); 
		query.append("	   INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("	  ,INV_NO" ).append("\n"); 
		query.append("	  ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("	  ,INV_STS_CD" ).append("\n"); 
		query.append("	  ,INV_EDI_STS_CD" ).append("\n"); 
		query.append("	  ,INV_CURR_CD" ).append("\n"); 
		query.append("	  ,INV_TTL_AMT" ).append("\n"); 
		query.append("      ,INV_BZC_AMT" ).append("\n"); 
		query.append("	  ,INV_VAT_AMT" ).append("\n"); 
		query.append("	  ,INV_WHLD_TAX_AMT" ).append("\n"); 
		query.append("	  ,INV_ISS_DT" ).append("\n"); 
		query.append("	  ,INV_ATCH_TP_ID" ).append("\n"); 
		query.append("	  ,SNDR_ID" ).append("\n"); 
		query.append("	  ,RCVR_ID" ).append("\n"); 
		query.append("	  ,VAL_CHK_FLG" ).append("\n"); 
		query.append("	  ,VAL_RMK" ).append("\n"); 
		query.append("	  ,EDI_MSG" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("       TO_NUMBER(@[inv_edi_rcv_seq])" ).append("\n"); 
		query.append("	  ,@[inv_no]" ).append("\n"); 
		query.append("	  ,@[inv_vndr_seq]" ).append("\n"); 
		query.append("	  ,'S' -- INVOICE SAVE" ).append("\n"); 
		query.append("	  ,'R' -- RECEIVE" ).append("\n"); 
		query.append("	  ,@[inv_curr_cd]" ).append("\n"); 
		query.append("	  ,NVL((TO_NUMBER(SUBSTR(@[inv_ttl_amt],1,11))+TO_NUMBER(SUBSTR(@[inv_ttl_amt],12))/100),0)" ).append("\n"); 
		query.append("      ,NVL((TO_NUMBER(SUBSTR(@[inv_bzc_amt],1,11))+TO_NUMBER(SUBSTR(@[inv_bzc_amt],12))/100),0)" ).append("\n"); 
		query.append("	  ,NVL((TO_NUMBER(SUBSTR(@[inv_vat_amt],1,11))+TO_NUMBER(SUBSTR(@[inv_vat_amt],12))/100),0)" ).append("\n"); 
		query.append("	  ,NVL((TO_NUMBER(SUBSTR(@[inv_whld_tax_amt],1,11))+TO_NUMBER(SUBSTR(@[inv_whld_tax_amt],12))/100),0)" ).append("\n"); 
		query.append("	  ,TO_DATE(@[inv_iss_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	  ,@[inv_atch_tp_id]" ).append("\n"); 
		query.append("	  ,@[sndr_id]" ).append("\n"); 
		query.append("	  ,@[rcvr_id]" ).append("\n"); 
		query.append("	  ,'N'" ).append("\n"); 
		query.append("	  ,NULL" ).append("\n"); 
		query.append("	  ,SUBSTR(@[edi_msg],1,1000)" ).append("\n"); 
		query.append("	  ,'HIT_INV_EDI'" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	  ,'HIT_INV_EDI'" ).append("\n"); 
		query.append("	  ,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}