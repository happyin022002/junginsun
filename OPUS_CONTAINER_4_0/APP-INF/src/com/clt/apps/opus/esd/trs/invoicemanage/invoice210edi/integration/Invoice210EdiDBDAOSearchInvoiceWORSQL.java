/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Invoice210EdiDBDAOSearchInvoiceWORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOSearchInvoiceWORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceWO SELECT
	  * </pre>
	  */
	public Invoice210EdiDBDAOSearchInvoiceWORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOSearchInvoiceWORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      A.TRSP_SO_OFC_CTY_CD      ," ).append("\n"); 
		query.append("      A.TRSP_SO_SEQ             ," ).append("\n"); 
		query.append("      A.TRSP_WO_OFC_CTY_CD      ," ).append("\n"); 
		query.append("      A.TRSP_WO_SEQ             ," ).append("\n"); 
		query.append("      A.EQ_NO                   ," ).append("\n"); 
		query.append("      A.EQ_TPSZ_CD              ," ).append("\n"); 
		query.append("      A.TRSP_SO_TP_CD           ," ).append("\n"); 
		query.append("      A.TRSP_SO_STS_CD          ," ).append("\n"); 
		query.append("      A.TRSP_INV_ACT_STS_CD     ," ).append("\n"); 
		query.append("      A.CURR_CD                 ," ).append("\n"); 
		query.append("      ( NVL(A.BZC_AMT , 0)" ).append("\n"); 
		query.append("      + NVL(A.NEGO_AMT, 0)" ).append("\n"); 
		query.append("      + NVL(A.FUEL_SCG_AMT, 0)" ).append("\n"); 
		query.append("      + NVL(A.ETC_ADD_AMT , 0)" ).append("\n"); 
		query.append("      )  AS INV_BZC_AMT         ," ).append("\n"); 
		query.append("      A.INV_NO                  ," ).append("\n"); 
		query.append("      A.INV_VNDR_SEQ            ," ).append("\n"); 
		query.append("      A.VNDR_SEQ                ," ).append("\n"); 
		query.append("      A.BZC_AMT                 ," ).append("\n"); 
		query.append("      A.NEGO_AMT                ," ).append("\n"); 
		query.append("      A.FUEL_SCG_AMT            ," ).append("\n"); 
		query.append("      A.ETC_ADD_AMT             ," ).append("\n"); 
		query.append("      A.BKG_NO                  ," ).append("\n"); 
		query.append("      A.ORG_BKG_NO              ," ).append("\n"); 
		query.append("      A.TRSP_BND_CD             ," ).append("\n"); 
		query.append("      A.TRSP_COST_DTL_MOD_CD    ," ).append("\n"); 
		query.append("      TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT," ).append("\n"); 
		query.append("      A.FM_NOD_CD" ).append("\n"); 
		query.append("FROM  TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("WHERE A.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.TRSP_WO_SEQ        = @[trsp_wo_seq]" ).append("\n"); 
		query.append("AND   A.EQ_NO              = @[eq_no]" ).append("\n"); 
		query.append("AND   A.EQ_TPSZ_CD         = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("AND   A.DELT_FLG           = 'N'" ).append("\n"); 

	}
}