/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyACMCommInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyACMCommInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyACMCommInfo
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyACMCommInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOModifyACMCommInfoUSQL").append("\n"); 
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
		query.append("UPDATE ACM_AGN_COMM A" ).append("\n"); 
		query.append("       SET A.AC_STS_CD  = 'IF'," ).append("\n"); 
		query.append("           A.AC_PROC_DESC = 'Interface Success!'," ).append("\n"); 
		query.append("           A.ACCL_FLG          = 'Y'," ).append("\n"); 
		query.append("           A.IF_USR_ID      = 'ACM System'," ).append("\n"); 
		query.append("           A.IF_DT" ).append("\n"); 
		query.append("         =" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD)" ).append("\n"); 
		query.append("                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                WHERE OFC_CD = DECODE(VNDR_CNT_CD,'CN',A.AR_OFC_CD,A.AGN_CD) AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("         )," ).append("\n"); 
		query.append("           A.IF_GDT" ).append("\n"); 
		query.append("         =" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,'GMT')" ).append("\n"); 
		query.append("                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                WHERE OFC_CD = DECODE(VNDR_CNT_CD,'CN',A.AR_OFC_CD,A.AGN_CD) AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("         )," ).append("\n"); 
		query.append("           A.UPD_USR_ID        = 'ACM System'," ).append("\n"); 
		query.append("           A.UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("     WHERE A.CSR_NO            = @[csr_no]" ).append("\n"); 

	}
}