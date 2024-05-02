/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOUpdateInvStsToVtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOUpdateInvStsToVtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOUpdateInvStsToVtUSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOUpdateInvStsToVtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOUpdateInvStsToVtUSQL").append("\n"); 
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
		query.append("UPDATE  DMT_INV_MN T1" ).append("\n"); 
		query.append("   SET  T1.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("       ,T1.VT_INV_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,T1.VT_INV_UPD_DT      = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), SYSDATE)   " ).append("\n"); 
		query.append(" WHERE  T1.DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("   AND  EXISTS(" ).append("\n"); 
		query.append("			SELECT  1" ).append("\n"); 
		query.append("			  FROM  DMT_INV_MN		A1   " ).append("\n"); 
		query.append("				   ,DMT_INV_DTL   	A2" ).append("\n"); 
		query.append("				   ,DMT_CHG_CALC  	A3" ).append("\n"); 
		query.append("			 WHERE  A1.DMDT_INV_NO         = T1.DMDT_INV_NO" ).append("\n"); 
		query.append("			   AND  A1.CRE_OFC_CD          = T1.CRE_OFC_CD" ).append("\n"); 
		query.append("			   AND  A1.DMDT_INV_NO         = A2.DMDT_INV_NO" ).append("\n"); 
		query.append("			   AND  A1.CRE_OFC_CD          = A2.CRE_OFC_CD" ).append("\n"); 
		query.append("			   AND  A2.SYS_AREA_GRP_ID     = A3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   AND  A2.CNTR_NO             = A3.CNTR_NO" ).append("\n"); 
		query.append("			   AND  A2.CNTR_CYC_NO		   = A3.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   AND  A2.DMDT_TRF_CD		   = A3.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   AND  A2.DMDT_CHG_LOC_DIV_CD = A3.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   AND  A2.CHG_SEQ 			   = A3.CHG_SEQ" ).append("\n"); 
		query.append("			   AND  A3.DMDT_CHG_STS_CD    IN ('C', 'F')  " ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}