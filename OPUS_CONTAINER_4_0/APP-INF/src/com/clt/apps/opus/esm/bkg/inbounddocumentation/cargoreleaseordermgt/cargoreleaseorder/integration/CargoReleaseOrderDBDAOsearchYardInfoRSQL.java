/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchYardInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchYardInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ....
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchYardInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchYardInfoRSQL").append("\n"); 
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
		query.append("SELECT FULL_RLSE_EDI_CD" ).append("\n"); 
		query.append("FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("BKG_EDI_YD   B," ).append("\n"); 
		query.append("BKG_BOOKING  C" ).append("\n"); 
		query.append("WHERE A.BL_NO   = @[bl_no]" ).append("\n"); 
		query.append("AND A.BL_NO   = C.BL_NO" ).append("\n"); 
		query.append("AND B.PORT_CD = C.POD_CD" ).append("\n"); 
		query.append("AND C.SLAN_CD IN (B.SLAN_CD1,B.SLAN_CD2,B.SLAN_CD3,B.SLAN_CD4,B.SLAN_CD5," ).append("\n"); 
		query.append("B.SLAN_CD6,B.SLAN_CD7,B.SLAN_CD8,B.SLAN_CD9,B.SLAN_CD10)" ).append("\n"); 
		query.append("AND ROWNUM    = 1" ).append("\n"); 

	}
}