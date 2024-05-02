/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoAvailableDBDAOSearchSpecialCargoAvailableListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.01.07 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoAvailableDBDAOSearchSpecialCargoAvailableListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special Cargo Available S/P List 조회
	  * </pre>
	  */
	public SpecialCargoAvailableDBDAOSearchSpecialCargoAvailableListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.integration").append("\n"); 
		query.append("FileName : SpecialCargoAvailableDBDAOSearchSpecialCargoAvailableListRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_SPCL_CGO_SP_SEQ" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR  WHERE VNDR_SEQ = A.VNDR_SEQ ) AS VNDR_NM" ).append("\n"); 
		query.append("      ,A.SO_CRE_OFC_CD" ).append("\n"); 
		query.append("      ,A.HZD_MTRL_FLG" ).append("\n"); 
		query.append("      ,A.OVWT_TRI_AXL_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID )AS CRE_USR_NM" ).append("\n"); 
		query.append("      ,A.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CRE_DT,'YYYY-MM-DD') CRE_DT " ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("  FROM TRS_SPCL_CGO_AVAL_SVC_PROV A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${vndr_seq} != '' )" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}