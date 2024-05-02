/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchMoreInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.08.11 박찬민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHAN MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchMoreInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMoreInfoVO
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchMoreInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchMoreInfoVORSQL").append("\n"); 
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
		query.append("SELECT '' NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append("     , '' NVOCC_LIC_NO" ).append("\n"); 
		query.append("     , '' NVOCC_BD_NO" ).append("\n"); 
		query.append("     , '' NVOCC_BD_AMT" ).append("\n"); 
		query.append("     , '' NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append("     , '' NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append("     , '' CR_AMT" ).append("\n"); 
		query.append("     , '' CR_CLT_OFC_CD" ).append("\n"); 
		query.append("     , '' IB_CR_TERM_DYS" ).append("\n"); 
		query.append("     , '' OB_CR_TERM_DYS" ).append("\n"); 
		query.append("     , '' INDUS_TP_N1ST_DESC" ).append("\n"); 
		query.append("     , '' MJR_N1ST_TRD_CD" ).append("\n"); 
		query.append("	 , '' MJR_N2ND_TRD_CD" ).append("\n"); 
		query.append("     , '' INDUS_TP_N2ND_DESC" ).append("\n"); 
		query.append("     , '' PRF_N1ST_REP_CMDT_CD" ).append("\n"); 
		query.append("	 , '' PRF_N1ST_CMDT_GRP_DTL" ).append("\n"); 
		query.append("     , '' CMPT_DESC" ).append("\n"); 
		query.append("     , '' PRF_N2ND_REP_CMDT_CD" ).append("\n"); 
		query.append("     , '' PRF_N2ND_CMDT_GRP_DTL" ).append("\n"); 
		query.append("     , '' SPCL_REQ_DESC" ).append("\n"); 
		query.append("     , '' CUST_RMK" ).append("\n"); 
		query.append("     , '' PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , '' YRY_VOL_QTY" ).append("\n"); 
		query.append("     , '' CUST_SLA_FLG" ).append("\n"); 
		query.append("     , '' BKG_ALT_RSN" ).append("\n"); 
		query.append("     , '' CUST_URL" ).append("\n"); 
		query.append("     , '' BKG_ALT_MSG" ).append("\n"); 
		query.append("     , '' BKG_ALT_FM_DT" ).append("\n"); 
		query.append("     , '' BKG_ALT_TO_DT" ).append("\n"); 
		query.append("	 , '' USER_ID" ).append("\n"); 
		query.append("	 , '' CUST_CD" ).append("\n"); 
		query.append("	 , '' CHK_CMDT_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}