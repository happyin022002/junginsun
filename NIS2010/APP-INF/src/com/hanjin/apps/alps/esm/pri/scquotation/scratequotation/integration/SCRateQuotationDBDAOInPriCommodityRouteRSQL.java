/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAOInPriCommodityRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.21 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAOInPriCommodityRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면의 파라메터를 받기위한 VO를 만들기 위한 DUMMY QUERY
	  * </pre>
	  */
	public SCRateQuotationDBDAOInPriCommodityRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAOInPriCommodityRouteRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS qttn_no" ).append("\n"); 
		query.append(",'' AS qttn_ver_no" ).append("\n"); 
		query.append(",'' AS gen_spcl_rt_tp_cd" ).append("\n"); 
		query.append(",'' AS rate_adjust" ).append("\n"); 
		query.append(",'' AS cust_cnt_cd" ).append("\n"); 
		query.append(",'' AS cust_seq" ).append("\n"); 
		query.append(",'' AS cmdt_hdr_seq" ).append("\n"); 
		query.append(",'' AS org_dest_tp_cd" ).append("\n"); 
		query.append(",'' AS ORI_LOC_DEF_CD" ).append("\n"); 
		query.append(",'' AS DEST_LOC_DEF_CD" ).append("\n"); 
		query.append(",'' AS ORI_VIA_DEF_CD" ).append("\n"); 
		query.append(",'' AS DEST_VIA_DEF_CD" ).append("\n"); 
		query.append(",'' AS OP_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}