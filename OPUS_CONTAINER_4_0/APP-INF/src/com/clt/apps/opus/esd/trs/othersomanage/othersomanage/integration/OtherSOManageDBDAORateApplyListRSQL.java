/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageDBDAORateApplyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.09.15 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAORateApplyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * only for create VO
	  * </pre>
	  */
	public OtherSOManageDBDAORateApplyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDBDAORateApplyListRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' as INV_XCH_RT" ).append("\n"); 
		query.append(",'' as PO_TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",'' as PO_TRSP_AGMT_SEQ" ).append("\n"); 
		query.append(",'' as PO_TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append(",'' as PO_WAY_TYPE" ).append("\n"); 
		query.append(",'' as PO_TRSP_AGMT_RT_TP_NM" ).append("\n"); 
		query.append(",'' as PO_SP_TYPE" ).append("\n"); 
		query.append(",'' as PO_CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append(",'' as PO_CUST_CNT_CD" ).append("\n"); 
		query.append(",'' as PO_CUST_SEQ" ).append("\n"); 
		query.append(",'' as PO_CUST_CND_CD_SEQ" ).append("\n"); 
		query.append(",'' as PO_LOCAL_CURR_CD" ).append("\n"); 
		query.append(",'' as PO_BASIC_RT" ).append("\n"); 
		query.append(",'' as PO_FUEL_SCG_RT" ).append("\n"); 
		query.append(",'' as PO_OVER_WGT_SCG_RT" ).append("\n"); 
		query.append(",'' as PO_LOCAL_CURR_TOT_AMT" ).append("\n"); 
		query.append(",'' as PO_USD_CURR_TOT_AMT" ).append("\n"); 
		query.append(",'' as PO_RTN_CD" ).append("\n"); 
		query.append(",'' as PO_RTN_MSG" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}