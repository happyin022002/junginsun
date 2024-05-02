/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoApprovalCommonDBDAOSearchAproRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoApprovalCommonDBDAOSearchAproRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Own/Partner Booking 의 Approval Reference Number 생성
	  * </pre>
	  */
	public CargoApprovalCommonDBDAOSearchAproRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.integration").append("\n"); 
		query.append("FileName : CargoApprovalCommonDBDAOSearchAproRefNoRSQL").append("\n"); 
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
		query.append("-- 2016-04-12 SQL 튜닝" ).append("\n"); 
		query.append("SELECT  COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()" ).append("\n"); 
		query.append("||'${pol_cd}'||TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append("||DECODE(NVL(LENGTH(MAX(SUBSTR(APRO_REF_NO,15,17))+1),0)," ).append("\n"); 
		query.append("          0, '001'," ).append("\n"); 
		query.append("          1, '00'||TO_CHAR(MAX(SUBSTR(APRO_REF_NO,15,17))+1)," ).append("\n"); 
		query.append("          2, '0'||TO_CHAR(MAX(SUBSTR(APRO_REF_NO,15,17))+1)," ).append("\n"); 
		query.append("          3, TO_CHAR(MAX(SUBSTR(APRO_REF_NO,15,17))+1) " ).append("\n"); 
		query.append("        )  AS APRO_REF_NO " ).append("\n"); 
		query.append("       -- ,MAX(APRO_REF_NO)" ).append("\n"); 
		query.append("        --,COUNT(*) CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT   " ).append("\n"); 
		query.append("--/*+ INDEX_DESC(PRNR XAK1SCG_PRNR_APRO_RQST_CGO) */" ).append("\n"); 
		query.append("          PRNR.APRO_REF_NO AS APRO_REF_NO  " ).append("\n"); 
		query.append("  FROM    SCG_PRNR_APRO_RQST_CGO PRNR " ).append("\n"); 
		query.append(" WHERE    1=1" ).append("\n"); 
		query.append(" AND      PRNR.APRO_REF_NO LIKE COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()||'${pol_cd}'||TO_CHAR(SYSDATE, 'yymmdd')||'%'" ).append("\n"); 
		query.append(" --AND    ROWNUM <=1 " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT   " ).append("\n"); 
		query.append("--/*+ INDEX_DESC(OWN XAK1SCG_AUTHORIZATION) */" ).append("\n"); 
		query.append("          OWN.APRO_REF_NO  AS APRO_REF_NO" ).append("\n"); 
		query.append(" FROM     SCG_AUTHORIZATION OWN" ).append("\n"); 
		query.append(" WHERE    OWN.APRO_REF_NO LIKE COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()||'${pol_cd}'||TO_CHAR(SYSDATE, 'yymmdd')||'%'" ).append("\n"); 
		query.append(" --AND    ROWNUM <= 1" ).append("\n"); 
		query.append(" ) APRO" ).append("\n"); 

	}
}