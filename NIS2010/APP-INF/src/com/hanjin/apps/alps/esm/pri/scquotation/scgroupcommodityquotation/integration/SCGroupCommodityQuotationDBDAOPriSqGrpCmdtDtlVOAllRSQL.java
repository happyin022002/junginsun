/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityQuotationDBDAOPriSqGrpCmdtDtlVOAllRSQL.java
*@FileTitle : S/C Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityQuotationDBDAOPriSqGrpCmdtDtlVOAllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cmdt seq별 삭제
	  * </pre>
	  */
	public SCGroupCommodityQuotationDBDAOPriSqGrpCmdtDtlVOAllRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration ").append("\n"); 
		query.append("FileName : SCGroupCommodityQuotationDBDAOPriSqGrpCmdtDtlVOAllRSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_SQ_GRP_CMDT_DTL" ).append("\n"); 
		query.append("WHERE	QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND	GRP_CMDT_SEQ = @[grp_cmdt_seq]" ).append("\n"); 

	}
}