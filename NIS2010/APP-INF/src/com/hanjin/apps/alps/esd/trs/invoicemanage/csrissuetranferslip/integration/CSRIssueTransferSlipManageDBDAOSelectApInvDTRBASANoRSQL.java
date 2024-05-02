/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.17 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApInvDTRBASANo 내역을 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL").append("\n"); 
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
		query.append("SELECT  	A.LINE_SEQ" ).append("\n"); 
		query.append(",	B.LINE_NO" ).append("\n"); 
		query.append(",	C.INV_NO" ).append("\n"); 
		query.append(",	C.ISS_DT" ).append("\n"); 
		query.append(",	C.LOC_CD" ).append("\n"); 
		query.append(",	D.TOTAL_AMT" ).append("\n"); 
		query.append("FROM		(	SELECT 	NVL(MAX(LINE_SEQ),0)+1 LINE_SEQ" ).append("\n"); 
		query.append("FROM 	AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE 	CSR_NO = @[CSR_NO]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(	SELECT 	NVL(MAX(LINE_NO),0)+1 LINE_NO" ).append("\n"); 
		query.append("FROM 	AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE 	CSR_NO = @[CSR_NO]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(	SELECT 		A.ATTR_CTNT1 INV_NO" ).append("\n"); 
		query.append(",	MAX(B.ATTR_CTNT2) ISS_DT" ).append("\n"); 
		query.append(",	SUBSTR(YD_CD,1,5) LOC_CD" ).append("\n"); 
		query.append("FROM 		(	SELECT 	MAX(ATTR_CTNT1) ATTR_CTNT1" ).append("\n"); 
		query.append("FROM 	AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE 	CSR_NO 	= @[CSR_NO]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("AP_INV_DTRB B" ).append("\n"); 
		query.append("WHERE 		B.CSR_NO 		= @[CSR_NO]" ).append("\n"); 
		query.append("AND 		A.ATTR_CTNT1 	= B.ATTR_CTNT1" ).append("\n"); 
		query.append("GROUP BY 	YD_CD" ).append("\n"); 
		query.append(",	A.ATTR_CTNT1" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(	SELECT 		-SUM(INV_AMT) TOTAL_AMT" ).append("\n"); 
		query.append("FROM 		AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE 		CSR_NO 			= @[CSR_NO]" ).append("\n"); 
		query.append(") D" ).append("\n"); 

	}
}