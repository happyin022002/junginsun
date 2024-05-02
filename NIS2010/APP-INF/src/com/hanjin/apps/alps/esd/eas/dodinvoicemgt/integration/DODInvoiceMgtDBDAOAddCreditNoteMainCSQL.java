/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOAddCreditNoteMainCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.16
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.10.16 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOAddCreditNoteMainCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCreditNoteMain
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOAddCreditNoteMainCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOAddCreditNoteMainCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_DOD_INV_MN (" ).append("\n"); 
		query.append(" DOD_INV_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",CNTC_PNT_NM" ).append("\n"); 
		query.append(",CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",CNTC_PNT_EML" ).append("\n"); 
		query.append(",CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",INV_CURR_CD" ).append("\n"); 
		query.append(",TTL_INV_AMT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",DOD_INV_STS_CD" ).append("\n"); 
		query.append(",CN_REF_INV_NO" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT @[new_inv_no] AS DOD_INV_NO" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ" ).append("\n"); 
		query.append("      ,CNTC_PNT_NM" ).append("\n"); 
		query.append("      ,CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("      ,CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("      ,CNTC_PNT_EML" ).append("\n"); 
		query.append("      ,CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,BKG_DE_TERM_CD" ).append("\n"); 
		query.append("      ,INV_CURR_CD" ).append("\n"); 
		query.append("      ,(TTL_INV_AMT * -1) AS TTL_INV_AMT" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,'C'  AS DOD_INV_STS_CD" ).append("\n"); 
		query.append("      ,DOD_INV_NO AS CN_REF_INV_NO" ).append("\n"); 
		query.append("      ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),SYSDATE) AS CRE_DT" ).append("\n"); 
		query.append("      ,@[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),SYSDATE) AS UPD_DT" ).append("\n"); 
		query.append("FROM EAS_DOD_INV_MN" ).append("\n"); 
		query.append("WHERE DOD_INV_NO = @[old_inv_no]" ).append("\n"); 

	}
}