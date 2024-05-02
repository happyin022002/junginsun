/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOLoadingQtyVORSQL.java
*@FileTitle : Loading Port Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOLoadingQtyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOLoadingQtyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOLoadingQtyVORSQL").append("\n"); 
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
		query.append("'' VVD" ).append("\n"); 
		query.append(",       '' OFC_CD" ).append("\n"); 
		query.append(",''FORM_ORD" ).append("\n"); 
		query.append(",''POL_CD" ).append("\n"); 
		query.append(",''CLPT_SEQ" ).append("\n"); 
		query.append(",''TYPE" ).append("\n"); 
		query.append(",''SKD_DIR_CD" ).append("\n"); 
		query.append(",''POD1" ).append("\n"); 
		query.append(",''POD1_20_QTY" ).append("\n"); 
		query.append(",''POD1_40_QTY" ).append("\n"); 
		query.append(",''POD1_HC_QTY" ).append("\n"); 
		query.append(",''POD1_45_QTY" ).append("\n"); 
		query.append(",''POD2" ).append("\n"); 
		query.append(",''POD2_20_QTY" ).append("\n"); 
		query.append(",''POD2_40_QTY" ).append("\n"); 
		query.append(",''POD2_HC_QTY" ).append("\n"); 
		query.append(",''POD3" ).append("\n"); 
		query.append(",''POD3_20_QTY" ).append("\n"); 
		query.append(",''POD3_40_QTY" ).append("\n"); 
		query.append(",''POD3_HC_QTY" ).append("\n"); 
		query.append(",''POD4" ).append("\n"); 
		query.append(",''POD4_20_QTY" ).append("\n"); 
		query.append(",''POD4_40_QTY" ).append("\n"); 
		query.append(",''POD4_HC_QTY" ).append("\n"); 
		query.append(",''POD5" ).append("\n"); 
		query.append(",''POD5_20_QTY" ).append("\n"); 
		query.append(",''POD5_40_QTY" ).append("\n"); 
		query.append(",''POD5_HC_QTY" ).append("\n"); 
		query.append(",''POD6" ).append("\n"); 
		query.append(",''POD6_20_QTY" ).append("\n"); 
		query.append(",''POD6_40_QTY" ).append("\n"); 
		query.append(",''POD6_HC_QTY" ).append("\n"); 
		query.append(",''POD7" ).append("\n"); 
		query.append(",''POD7_20_QTY" ).append("\n"); 
		query.append(",''POD7_40_QTY" ).append("\n"); 
		query.append(",''POD7_HC_QTY" ).append("\n"); 
		query.append(",''POD8" ).append("\n"); 
		query.append(",''POD8_20_QTY" ).append("\n"); 
		query.append(",''POD8_40_QTY" ).append("\n"); 
		query.append(",''POD8_HC_QTY" ).append("\n"); 
		query.append(",''POD9" ).append("\n"); 
		query.append(",''POD9_20_QTY" ).append("\n"); 
		query.append(",''POD9_40_QTY" ).append("\n"); 
		query.append(",''POD9_HC_QTY" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}