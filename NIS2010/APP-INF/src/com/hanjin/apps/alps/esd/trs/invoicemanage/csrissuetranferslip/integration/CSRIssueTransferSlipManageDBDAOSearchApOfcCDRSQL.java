/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchApOfcCDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.13 김진
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

public class CSRIssueTransferSlipManageDBDAOSearchApOfcCDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Ap Office Cd 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchApOfcCDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchApOfcCDRSQL").append("\n"); 
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
		query.append("SELECT		NVL(AP_OFC_CD	, '') 	AP_OFC_CD" ).append("\n"); 
		query.append(",	NVL(FINC_RGN_CD	, '') 	FINC_RGN_CD" ).append("\n"); 
		query.append(",	NVL(AP_CTR_CD	, '') 	AP_CTR_CD" ).append("\n"); 
		query.append("FROM		MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE		OFC_CD	= @[OFC_CD]" ).append("\n"); 
		query.append("AND		NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 

	}
}