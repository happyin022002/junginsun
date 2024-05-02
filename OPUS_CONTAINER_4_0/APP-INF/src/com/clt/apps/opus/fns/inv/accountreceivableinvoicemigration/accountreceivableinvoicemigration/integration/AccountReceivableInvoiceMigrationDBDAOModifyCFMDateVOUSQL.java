/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOModifyCFMDateVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOModifyCFMDateVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify CFM Date
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOModifyCFMDateVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOModifyCFMDateVOUSQL").append("\n"); 
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
		query.append("UPDATE OPUSADM_TMP.INV_AR_MN SET " ).append("\n"); 
		query.append("#if (${flag} == 'good') " ).append("\n"); 
		query.append("BL_INV_CFM_DT = TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ar_ofc_cd]),'YYYYMMDD')" ).append("\n"); 
		query.append(", IF_SEQ = (SELECT NVL((SELECT MAX(IF_SEQ) FROM OPUSADM_TMP.INV_AR_MN WHERE BL_SRC_NO = @[bl_src_no] ), 0) + 1 FROM DUAL)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("BL_INV_CFM_DT = null" ).append("\n"); 
		query.append(", IF_SEQ = null" ).append("\n"); 
		query.append(", GL_EFF_DT = null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("#if (${flag} == 'good')" ).append("\n"); 
		query.append("  AND BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}