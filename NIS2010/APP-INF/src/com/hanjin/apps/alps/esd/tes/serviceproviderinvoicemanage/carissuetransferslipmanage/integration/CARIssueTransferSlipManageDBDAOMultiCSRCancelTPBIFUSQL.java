/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOMultiCSRCancelTPBIFUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.12.20 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */
 
public class CARIssueTransferSlipManageDBDAOMultiCSRCancelTPBIFUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiCSRCancelTPBIF
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOMultiCSRCancelTPBIFUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOMultiCSRCancelTPBIFUSQL").append("\n"); 
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
		query.append("UPDATE TES_N3RD_PTY_IF" ).append("\n"); 
		query.append("SET TML_N3PTY_IF_STS_CD = 'N'" ).append("\n"); 
		query.append("WHERE (TML_IF_OFC_CD, TML_IF_SEQ)" ).append("\n"); 
		query.append("IN (" ).append("\n"); 
		query.append("SELECT N.TML_IF_OFC_CD, N.TML_IF_SEQ" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR T, AP_INV_HDR A, TES_N3RD_PTY_IF N" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("AND T.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND T.INV_OFC_CD = @[inv_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(T.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND T.TML_SO_OFC_CTY_CD = N.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND T.TML_SO_SEQ = N.TML_SO_SEQ" ).append("\n"); 
		query.append("AND N.TML_N3PTY_IF_STS_CD ='P'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}