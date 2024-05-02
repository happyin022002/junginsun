/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchKORIssueTargetBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.11.16 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchKORIssueTargetBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L NO 입력하고 TAB 또는 FOCUS 이동 시 Invoice Main 테이블에서 BKG NO, LOCAL VVD, S/A DATE, BOUND, PORT를 SELECT 한다.
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchKORIssueTargetBLRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchKORIssueTargetBLRSQL").append("\n"); 
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
		query.append("SELECT A.BL_SRC_NO," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("A.SAIL_ARR_DT," ).append("\n"); 
		query.append("DECODE(A.IO_BND_CD, 'O', 'O/B', 'I', 'I/B') IO_BND_CD," ).append("\n"); 
		query.append("DECODE(A.IO_BND_CD, 'O', A.POL_CD, 'I', A.POD_CD) PORT," ).append("\n"); 
		query.append("A.POL_CD," ).append("\n"); 
		query.append("A.POD_CD," ).append("\n"); 
		query.append("A.USD_XCH_RT" ).append("\n"); 
		query.append("FROM INV_AR_MN A" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.AR_IF_NO = (" ).append("\n"); 
		query.append("SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y')" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 

	}
}