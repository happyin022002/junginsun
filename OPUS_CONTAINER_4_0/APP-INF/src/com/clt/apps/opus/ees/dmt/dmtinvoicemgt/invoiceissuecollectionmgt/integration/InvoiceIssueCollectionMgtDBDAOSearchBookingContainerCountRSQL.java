/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingContainerCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.07 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchBookingContainerCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation - Group
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchBookingContainerCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingContainerCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(A.CNTR_NO) 	AS CNTR_CNT" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR A, DMT_CHG_CALC B" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID    = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.CNTR_NO     = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.OFC_CD	  = @[s_ofc_cd]" ).append("\n"); 
		query.append("AND A.BKG_NO      = @[s_bkg_no]" ).append("\n"); 
		query.append("AND B.DMDT_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD 	  = @[s_dmdt_trf_cd]" ).append("\n"); 

	}
}