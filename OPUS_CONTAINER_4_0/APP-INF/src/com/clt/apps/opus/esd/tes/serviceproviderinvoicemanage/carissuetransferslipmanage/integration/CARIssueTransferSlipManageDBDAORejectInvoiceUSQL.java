/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAORejectInvoiceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAORejectInvoiceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RejectInvoice
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAORejectInvoiceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAORejectInvoiceUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_HDR T" ).append("\n"); 
		query.append(" SET	T.TML_INV_RJCT_STS_CD = 'RJ'," ).append("\n"); 
		query.append(" 	    T.INV_RJCT_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[inv_ofc_cd])," ).append("\n"); 
		query.append("		T.UPD_DT = SYSDATE," ).append("\n"); 
		query.append("		T.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[inv_ofc_cd])" ).append("\n"); 
		query.append(" WHERE	1=1" ).append("\n"); 
		query.append(" AND T.TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND T.TML_SO_SEQ			= @[tml_so_seq]" ).append("\n"); 
		query.append(" AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append(" AND T.TML_INV_STS_CD = 'A'     -- CSR 결재처리 상태('P')는 Disapprove할 수 없게 하기 위해 추가합니다." ).append("\n"); 

	}
}