/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VendorDBDAOManufacturerVendorDBListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.22 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.vendor.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VendorDBDAOManufacturerVendorDBListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manufacturer Vendor 코드를 리스트업한다.
	  * </pre>
	  */
	public VendorDBDAOManufacturerVendorDBListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT 	B.VNDR_SEQ," ).append("\n"); 
		query.append("NVL(B.VNDR_ABBR_NM, B.VNDR_LGL_ENG_NM) VNDR_ABBR_NM" ).append("\n"); 
		query.append("FROM 	MDM_CNTR_VNDR_CLSS A," ).append("\n"); 
		query.append("MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE 	A.CNTR_VNDR_SVC_CD = 'MFR'" ).append("\n"); 
		query.append("AND 	A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND 	B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY VNDR_ABBR_NM" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.vendor.integration ").append("\n"); 
		query.append("FileName : VendorDBDAOManufacturerVendorDBListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}