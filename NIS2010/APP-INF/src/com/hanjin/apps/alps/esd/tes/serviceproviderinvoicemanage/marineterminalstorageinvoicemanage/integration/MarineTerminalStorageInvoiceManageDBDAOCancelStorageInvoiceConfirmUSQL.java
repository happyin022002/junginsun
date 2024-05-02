/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOCancelStorageInvoiceConfirmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.23 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOCancelStorageInvoiceConfirmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CancelStorageInvoiceConfirm
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOCancelStorageInvoiceConfirmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOCancelStorageInvoiceConfirmUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_HDR" ).append("\n"); 
		query.append("SET TML_INV_STS_CD = 'R'" ).append("\n"); 
		query.append(", INV_CFM_DT = NULL" ).append("\n"); 
		query.append(", TML_INV_RJCT_STS_CD = DECODE(TML_INV_RJCT_STS_CD,'RJ','RL',TML_INV_RJCT_STS_CD)" ).append("\n"); 
		query.append(", UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append(", LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append(", AP_IF_DT = NULL" ).append("\n"); 
		query.append(", HPC_CRE_FLG = NULL" ).append("\n"); 
		query.append(", LEA_CRE_FLG = NULL" ).append("\n"); 
		query.append(", AP_CXL_DT = NULL" ).append("\n"); 
		query.append(", HPC_CXL_FLG = NULL" ).append("\n"); 
		query.append(", LEA_CXL_FLG = NULL" ).append("\n"); 
		query.append(", AP_PAY_DT = NULL" ).append("\n"); 
		query.append(", HPC_DELT_FLG = NULL" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND INV_NO = @[inv_no]" ).append("\n"); 

	}
}