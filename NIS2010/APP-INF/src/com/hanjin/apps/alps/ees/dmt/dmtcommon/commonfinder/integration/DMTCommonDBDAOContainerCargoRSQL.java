/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOContainerCargoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.25 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOContainerCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR & Cargo Type List
	  * </pre>
	  */
	public DMTCommonDBDAOContainerCargoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code1",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  A.DMDT_CNTR_TP_CD ||':' || A.DMDT_CGO_TP_CD AS CNTR_CGO" ).append("\n"); 
		query.append(",A.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",B.INTG_CD_VAL_DP_DESC AS DMDT_CGO_TP_NM" ).append("\n"); 
		query.append(",A.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",C.INTG_CD_VAL_DP_DESC AS DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append("FROM DMT_CMB_SET A, COM_INTG_CD_DTL B, COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("WHERE A.DMDT_CNTR_TP_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND A.DMDT_CGO_TP_CD = C.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND B.INTG_CD_ID = @[code1]	--DEM/DET CONTAINER CARGO TYPE CODE" ).append("\n"); 
		query.append("AND C.INTG_CD_ID = @[code2]	--DEM/DET CARGO TYPE CODE" ).append("\n"); 
		query.append("ORDER BY B.INTG_CD_VAL_DP_SEQ, C.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOContainerCargoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}