/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslResidualSpaceManageDBDAOSearchVslRsdlSpaceEccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VslResidualSpaceManageDBDAOSearchVslRsdlSpaceEccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel R.Capa. [ EES_EQR_0060 ]
	  * EQR_SCNR_VSL_RSDL_CAPA 테이블의 특정 ecc의 vsl space 정보 조회
	  * </pre>
	  */
	public VslResidualSpaceManageDBDAOSearchVslRsdlSpaceEccRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.integration").append("\n"); 
		query.append("FileName : VslResidualSpaceManageDBDAOSearchVslRsdlSpaceEccRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT VSL_LOC_CD AS ECC_CD" ).append("\n"); 
		query.append("FROM	EQR_SCNR_VSL_SKD A" ).append("\n"); 
		query.append(",EQR_WK_PRD B" ).append("\n"); 
		query.append("WHERE	SUBSTR(SCNR_ID,5,4) = B.PLN_YR" ).append("\n"); 
		query.append("AND	SUBSTR(SCNR_ID,9,2) = PLN_WK" ).append("\n"); 
		query.append("AND	A.VSL_ETD_DT BETWEEN TO_DATE(B.WK_ST_DT, 'YYYYMMDD') AND TO_DATE(B.WK_END_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND	A.SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND	A.VSL_LOC_CD = @[ecc_cd]" ).append("\n"); 

	}
}