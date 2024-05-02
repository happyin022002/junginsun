/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchIndiaTaxInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchIndiaTaxInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIndiaTaxInfo
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchIndiaTaxInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchIndiaTaxInfoRSQL").append("\n"); 
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
		query.append("SELECT IDA_TAX_SEQ" ).append("\n"); 
		query.append("	  ,OFC_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(TPB_GET_LCL_DATE_FNC(EFF_DT,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') EFF_DT" ).append("\n"); 
		query.append("	  ,EXPN_TAX" ).append("\n"); 
		query.append("	  ,EDU_TAX" ).append("\n"); 
		query.append("	  ,HIGH_EDU_TAX" ).append("\n"); 
		query.append("	  ,TAX_RGST_NO" ).append("\n"); 
		query.append("	  ,SVC_CATE_RMK" ).append("\n"); 
		query.append("      ,PMNT_ACCT_NO" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,TO_CHAR(TPB_GET_LCL_DATE_FNC(CRE_DT,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,TO_CHAR(TPB_GET_LCL_DATE_FNC(UPD_DT,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("	  ,(SELECT COUNT(0) FROM TPB_INV_RVIS WHERE IDA_TAX_SEQ=A.IDA_TAX_SEQ) EDITABLE " ).append("\n"); 
		query.append("      ,NVL(LOCL_TAX_RT, 0) LOCL_TAX_RT" ).append("\n"); 
		query.append("      ,NVL(N2ND_LOCL_TAX_RT,0) N2ND_LOCL_TAX_RT" ).append("\n"); 
		query.append("  FROM TPB_IDA_TAX A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_eff_dt} != '') " ).append("\n"); 
		query.append("   AND EFF_DT = TO_DATE(@[s_eff_dt]) + (3.5/24)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (DELT_FLG != 'Y' OR DELT_FLG IS NULL)" ).append("\n"); 
		query.append(" ORDER BY OFC_CD, EFF_DT DESC" ).append("\n"); 

	}
}