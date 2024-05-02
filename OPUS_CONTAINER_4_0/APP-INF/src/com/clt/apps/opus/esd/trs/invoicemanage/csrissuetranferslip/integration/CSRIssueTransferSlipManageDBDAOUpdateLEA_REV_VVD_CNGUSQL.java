/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOUpdateLEA_REV_VVD_CNGUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.12.01 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOUpdateLEA_REV_VVD_CNGUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateLEA_REV_VVD_CNG
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOUpdateLEA_REV_VVD_CNGUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEW_CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_SKD_VOY_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_VSL_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_REV_DIR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OLD_SKD_DIR_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOUpdateLEA_REV_VVD_CNGUSQL").append("\n"); 
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
		query.append("UPDATE	LEA_REV_VVD_CNG" ).append("\n"); 
		query.append("SET		MODI_CSR_NO 		= @[NEW_CSR_NO]" ).append("\n"); 
		query.append(",MODI_GL_DT 		= (SELECT GL_DT FROM AP_INV_HDR WHERE CSR_NO = @[NEW_CSR_NO])" ).append("\n"); 
		query.append(",MODI_CSR_CRE_FLG 	= 'Y'" ).append("\n"); 
		query.append(",ERP_IF_FLG 		= 'N'" ).append("\n"); 
		query.append("WHERE	CSR_NO 				= @[CSR_NO]" ).append("\n"); 
		query.append("AND	BKG_NO 			= @[BKG_NO]" ).append("\n"); 
		query.append("AND 	OLD_VSL_CD 		= @[OLD_VSL_CD]" ).append("\n"); 
		query.append("AND 	OLD_SKD_VOY_NO 	= @[OLD_SKD_VOY_NO]" ).append("\n"); 
		query.append("AND 	OLD_SKD_DIR_CD 	= @[OLD_SKD_DIR_CD]" ).append("\n"); 
		query.append("AND 	OLD_REV_DIR_CD 	= @[OLD_REV_DIR_CD]" ).append("\n"); 

	}
}