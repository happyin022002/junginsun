/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOAddCreditNoteDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOAddCreditNoteDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCreditNoteDetail
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOAddCreditNoteDetailCSQL(){
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
		query.append("FileName : DODInvoiceMgtDBDAOAddCreditNoteDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_DOD_INV_DTL (" ).append("\n"); 
		query.append(" DOD_INV_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",DOD_LOC_CD" ).append("\n"); 
		query.append(",BIL_CURR_CD" ).append("\n"); 
		query.append(",BIL_AMT" ).append("\n"); 
		query.append(",ADD_AMT" ).append("\n"); 
		query.append(",TAX_AMT" ).append("\n"); 
		query.append(",INV_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  @[new_inv_no]  AS DOD_INV_NO" ).append("\n"); 
		query.append("  ,CNTR_NO" ).append("\n"); 
		query.append("  ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  ,DOD_LOC_CD" ).append("\n"); 
		query.append("  ,BIL_CURR_CD" ).append("\n"); 
		query.append("  ,(BIL_AMT * -1) AS BIL_AMT" ).append("\n"); 
		query.append("  ,(NVL(ADD_AMT,0) * -1) AS ADD_AMT" ).append("\n"); 
		query.append("  ,(TAX_AMT * -1) AS TAX_AMT" ).append("\n"); 
		query.append("  ,(INV_AMT * -1) AS INV_AMT" ).append("\n"); 
		query.append("  ,@[cre_usr_id]  AS CRE_USR_ID" ).append("\n"); 
		query.append("  ,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),SYSDATE) AS CRE_DT" ).append("\n"); 
		query.append("  ,@[cre_usr_id]  AS UPD_USR_ID" ).append("\n"); 
		query.append("  ,NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),SYSDATE) AS UPD_DT" ).append("\n"); 
		query.append("FROM EAS_DOD_INV_DTL" ).append("\n"); 
		query.append("WHERE DOD_INV_NO = @[old_inv_no]" ).append("\n"); 

	}
}