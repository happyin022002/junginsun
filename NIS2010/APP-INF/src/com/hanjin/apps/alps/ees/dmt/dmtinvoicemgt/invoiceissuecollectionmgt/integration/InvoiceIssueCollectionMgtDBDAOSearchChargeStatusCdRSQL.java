/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchChargeStatusCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23 
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

public class InvoiceIssueCollectionMgtDBDAOSearchChargeStatusCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMT_CHG_CALC의 DMDT_CHG_STS_CD를 조회한다.
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchChargeStatusCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchChargeStatusCdRSQL").append("\n"); 
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
		query.append("SELECT  DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        , FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        , TO_CHAR(BZC_TRF_APLY_DT    , 'YYYY-MM-DD')    AS BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("        , TO_CHAR(SC_RFA_EXPT_APLY_DT, 'YYYY-MM-DD')    AS SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("        , FT_DYS" ).append("\n"); 
		query.append("		, ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("		, SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append("FROM    DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID 	= @[svr_id]" ).append("\n"); 
		query.append("AND     CNTR_NO 			= @[cntr_no]" ).append("\n"); 
		query.append("AND     CNTR_CYC_NO 		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD 		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     CHG_SEQ 			= @[chg_seq]" ).append("\n"); 

	}
}