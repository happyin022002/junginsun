/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaCgoPoLocSlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaCgoPoLocSlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaCgoPoLocSlanRSQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaCgoPoLocSlanRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaCgoPoLocSlanRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.PO_NO AS PO_NO, " ).append("\n"); 
		query.append("       D.LOC_CD AS LOC_CD," ).append("\n"); 
		query.append("       NVL(VSL_SLAN_NM, '') AS VSL_SLAN_NM" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("       BKG_REF_DTL      B," ).append("\n"); 
		query.append("       MDM_VSL_SVC_LANE C," ).append("\n"); 
		query.append("       /*  (SELECT LOC_CD " ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD =(SELECT OFC_CD" ).append("\n"); 
		query.append("                          FROM COM_USER" ).append("\n"); 
		query.append("                         WHERE USR_ID = '')" ).append("\n"); 
		query.append("       ) D */" ).append("\n"); 
		query.append("       (SELECT LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]) D /* ACCOUNT의 Office Code 또는 타모듈에서의 Parameter 변수 처리 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BL_NO   = @[bl_no] /* 변수 처리 */" ).append("\n"); 
		query.append("   AND A.BKG_NO  = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND ROWNUM    = 1" ).append("\n"); 

	}
}