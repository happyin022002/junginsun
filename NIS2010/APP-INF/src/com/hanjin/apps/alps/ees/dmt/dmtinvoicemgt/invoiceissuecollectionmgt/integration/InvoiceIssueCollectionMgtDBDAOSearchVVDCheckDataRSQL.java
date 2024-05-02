/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchVVDCheckDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.04 
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

public class InvoiceIssueCollectionMgtDBDAOSearchVVDCheckDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchVVDCheckDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchVVDCheckDataRSQL").append("\n"); 
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
		query.append("#if (${check_flag} == '1')" ).append("\n"); 
		query.append("SELECT POL_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", TRIM(SUBSTR(@[s_dmdt_trf_cd], 3, 1)) AS IO_BND" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[s_bkg_no]" ).append("\n"); 
		query.append("AND SYS_AREA_GRP_ID = (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1,2) FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[s_ofc_cd])" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append("AND VSL_CD IS NULL" ).append("\n"); 
		query.append("#elseif (${check_flag} == '2')" ).append("\n"); 
		query.append("SELECT POL_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", TRIM(SUBSTR(@[s_dmdt_trf_cd], 3, 1)) AS IO_BND" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[s_bkg_no]" ).append("\n"); 
		query.append("AND SYS_AREA_GRP_ID = (SELECT SYS_AREA_GRP_ID FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1,2) FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[s_ofc_cd])" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H')" ).append("\n"); 
		query.append("AND (POL_CD IS NOT NULL  AND POD_CD IS NOT NULL)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}