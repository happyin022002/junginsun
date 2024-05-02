/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOMultiConfirmCSRUpdate01USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOMultiConfirmCSRUpdate01USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiConfirmCSRUpdate01
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOMultiConfirmCSRUpdate01USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOMultiConfirmCSRUpdate01USQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_HDR T   " ).append("\n"); 
		query.append("SET		T.TML_INV_STS_CD = 'C', T.TML_INV_RJCT_STS_CD = 'RJ', T.INV_RJCT_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), T.UPD_USR_ID = @[upd_usr_id],  " ).append("\n"); 
		query.append("		T.UPD_DT = SYSDATE , T.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("#if(${inv_no} != '')  " ).append("\n"); 
		query.append("    ,INV_NO = @[inv_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE T.CSR_NO = @[csr_no] AND NVL(T.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

	}
}