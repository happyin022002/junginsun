/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCancelCSRAPifInvUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.12.22 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCancelCSRAPifInvUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR cancel시 TRS_TRSP_INV_WRK update(Disapproved 건의 취소)
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCancelCSRAPifInvUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_INV_AUD_STS_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCancelCSRAPifInvUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_INV_WRK WRK" ).append("\n"); 
		query.append("   SET TRSP_INV_AUD_STS_CD = @[TRSP_INV_AUD_STS_CD]" ).append("\n"); 
		query.append("      ,UPD_USR_ID          = @[USR_ID]" ).append("\n"); 
		query.append("      ,UPD_DT              = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(WRK.CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT         = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(WRK.CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,CSR_NO              = ''" ).append("\n"); 
		query.append("      ,INV_RJCT_FLG        = ''" ).append("\n"); 
		query.append("      ,INV_RJCT_DT		   = ''" ).append("\n"); 
		query.append(" WHERE INV_NO = @[INV_NO]" ).append("\n"); 
		query.append("   AND INV_VNDR_SEQ = @[INV_VNDR_SEQ]" ).append("\n"); 

	}
}