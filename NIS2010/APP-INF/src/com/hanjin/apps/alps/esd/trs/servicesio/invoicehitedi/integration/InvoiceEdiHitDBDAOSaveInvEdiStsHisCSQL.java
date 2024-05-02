/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSaveInvEdiStsHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.30 신동일
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

public class InvoiceEdiHitDBDAOSaveInvEdiStsHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice EDI Status History 저장
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSaveInvEdiStsHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("inv_edi_rcv_sts_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSaveInvEdiStsHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_INV_EDI_STS_HIS(" ).append("\n"); 
		query.append("       INV_EDI_RCV_SEQ" ).append("\n"); 
		query.append("   	  ,INV_EDI_STS_HIS_SEQ" ).append("\n"); 
		query.append("      ,INV_NO" ).append("\n"); 
		query.append("      ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,INV_EDI_RCV_STS_ID" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("	   @[inv_edi_rcv_seq]" ).append("\n"); 
		query.append("	  ,(SELECT CASE WHEN MAX(INV_EDI_STS_HIS_SEQ) IS NULL THEN 1" ).append("\n"); 
		query.append("                    ELSE MAX(INV_EDI_STS_HIS_SEQ) +1" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM TRS_INV_EDI_STS_HIS" ).append("\n"); 
		query.append("         WHERE INV_EDI_RCV_SEQ = @[inv_edi_rcv_seq])        " ).append("\n"); 
		query.append("	  ,@[inv_no]" ).append("\n"); 
		query.append("	  ,@[inv_vndr_seq]" ).append("\n"); 
		query.append("	  ,@[inv_edi_rcv_sts_id]" ).append("\n"); 
		query.append("	  ,'HIT_INV_EDI' --CRE_USR_ID" ).append("\n"); 
		query.append("	  ,SYSDATE  --CRE_DT" ).append("\n"); 
		query.append("	  ,'HIT_INV_EDI' --UPD_USR_ID" ).append("\n"); 
		query.append("	  ,SYSDATE  -- UPD_DT" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}