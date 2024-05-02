/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOAddInvoiceRateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.10.07 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOAddInvoiceRateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addInvoiceRate
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOAddInvoiceRateCSQL(){
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
		params.put("bzc_dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_und_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_ovr_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bzc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_trf_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ft_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOAddInvoiceRateCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_INV_RT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  DMDT_INV_NO" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", INV_DTL_SEQ" ).append("\n"); 
		query.append(", INV_RT_SEQ" ).append("\n"); 
		query.append(", SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(", BZC_DMDT_TRF_CD" ).append("\n"); 
		query.append(", BZC_TRF_SEQ" ).append("\n"); 
		query.append(", BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append(", BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(", BZC_TRF_RT_SEQ" ).append("\n"); 
		query.append(", FT_OVR_DYS" ).append("\n"); 
		query.append(", FT_UND_DYS" ).append("\n"); 
		query.append(", INV_RT_AMT" ).append("\n"); 
		query.append(", RT_OVR_DYS" ).append("\n"); 
		query.append(", RT_OVR_CHG_AMT" ).append("\n"); 
		query.append(", BZC_CURR_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", UPD_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[dmdt_inv_no]" ).append("\n"); 
		query.append(", @[cre_ofc_cd]" ).append("\n"); 
		query.append(", @[inv_dtl_seq]" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("  SELECT NVL(MAX(INV_RT_SEQ), 0) + 1" ).append("\n"); 
		query.append("  FROM   DMT_INV_RT" ).append("\n"); 
		query.append("  WHERE  DMDT_INV_NO     = @[dmdt_inv_no]" ).append("\n"); 
		query.append("  AND    CRE_OFC_CD      = @[cre_ofc_cd]" ).append("\n"); 
		query.append("  AND    INV_DTL_SEQ     = @[inv_dtl_seq]" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append(", @[svr_id]" ).append("\n"); 
		query.append(", @[bzc_dmdt_trf_cd]" ).append("\n"); 
		query.append(", @[bzc_trf_seq]" ).append("\n"); 
		query.append(", NVL(@[bzc_dmdt_de_term_cd], 'N')" ).append("\n"); 
		query.append(", @[bzc_trf_grp_seq]" ).append("\n"); 
		query.append(", @[bzc_trf_rt_seq]" ).append("\n"); 
		query.append(", @[ft_ovr_dys]" ).append("\n"); 
		query.append(", @[ft_und_dys]" ).append("\n"); 
		query.append(", @[inv_rt_amt]" ).append("\n"); 
		query.append(", @[rt_ovr_dys]" ).append("\n"); 
		query.append(", @[rt_ovr_chg_amt]" ).append("\n"); 
		query.append(", @[bzc_curr_cd]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append(", @[upd_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}