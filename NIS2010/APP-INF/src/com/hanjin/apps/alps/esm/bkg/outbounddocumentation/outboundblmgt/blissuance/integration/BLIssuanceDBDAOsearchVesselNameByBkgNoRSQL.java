/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchVesselNameByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchVesselNameByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVesselNameByBkgNo
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchVesselNameByBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchVesselNameByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT A3.VSL_ENG_NM || ' ' || A1.SKD_VOY_NO || A1.SKD_DIR_CD AS VSL_NM" ).append("\n"); 
		query.append("  FROM BKG_VVD A1" ).append("\n"); 
		query.append("      ,BKG_BOOKING A2" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR A3" ).append("\n"); 
		query.append(" WHERE A2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("   AND A1.POL_CD = A2.POL_CD" ).append("\n"); 
		query.append("   AND A1.VSL_PRE_PST_CD||VSL_SEQ IN ('S1', 'T0')" ).append("\n"); 
		query.append("   AND A1.VSL_CD = A3.VSL_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD IS NOT NULL" ).append("\n"); 
		query.append(" ORDER BY A1.VSL_PRE_PST_CD,A1.VSL_SEQ ASC" ).append("\n"); 

	}
}