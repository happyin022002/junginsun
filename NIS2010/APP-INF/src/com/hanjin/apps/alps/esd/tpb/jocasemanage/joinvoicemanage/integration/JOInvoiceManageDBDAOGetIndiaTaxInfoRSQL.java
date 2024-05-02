/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOGetIndiaTaxInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.03.26 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOGetIndiaTaxInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getIndiaTaxInfo
	  * </pre>
	  */
	public JOInvoiceManageDBDAOGetIndiaTaxInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOGetIndiaTaxInfoRSQL").append("\n"); 
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
		query.append("SELECT IDA_TAX_SEQ" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(EFF_DT,( SELECT OFC_CD FROM TPB_IDA_TAX WHERE EFF_DT < SYSDATE AND (DELT_FLG != 'Y' OR DELT_FLG IS NULL ) GROUP BY OFC_CD )),'YYYY-MM-DD HH24:MI') EFF_DT" ).append("\n"); 
		query.append(",EXPN_TAX" ).append("\n"); 
		query.append(",EDU_TAX" ).append("\n"); 
		query.append(",HIGH_EDU_TAX" ).append("\n"); 
		query.append(",TAX_RGST_NO" ).append("\n"); 
		query.append(",SVC_CATE_RMK" ).append("\n"); 
		query.append(",PMNT_ACCT_NO" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(CRE_DT,( SELECT OFC_CD FROM TPB_IDA_TAX WHERE EFF_DT < SYSDATE AND (DELT_FLG != 'Y' OR DELT_FLG IS NULL ) GROUP BY OFC_CD )),'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(UPD_DT,( SELECT OFC_CD FROM TPB_IDA_TAX WHERE EFF_DT < SYSDATE AND (DELT_FLG != 'Y' OR DELT_FLG IS NULL ) GROUP BY OFC_CD )),'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("FROM TPB_IDA_TAX" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND EFF_DT = (  SELECT MAX(EFF_DT) EFF_DT" ).append("\n"); 
		query.append("FROM TPB_IDA_TAX" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND EFF_DT < SYSDATE" ).append("\n"); 
		query.append("AND (DELT_FLG != 'Y' OR DELT_FLG IS NULL )" ).append("\n"); 
		query.append("GROUP BY OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (DELT_FLG != 'Y' OR DELT_FLG IS NULL)" ).append("\n"); 

	}
}