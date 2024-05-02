/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchSegrGrpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchSegrGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유사한 화학적 특성을 갖는 위험물 격리군(Segregation Groups) 조회
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchSegrGrpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchSegrGrpRSQL").append("\n"); 
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
		query.append("SELECT   0 AS IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append(", 'NIL' AS IMDG_SEGR_GRP_NM" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append(", IMDG_SEGR_GRP_NM" ).append("\n"); 
		query.append("FROM     SCG_IMDG_SEGR_GRP" ).append("\n"); 
		query.append("ORDER BY IMDG_SEGR_GRP_NO" ).append("\n"); 

	}
}