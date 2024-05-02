/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CIMCommonDBDAOsearchLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOsearchLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * lane조회
	  * </pre>
	  */
	public CIMCommonDBDAOsearchLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOsearchLaneListRSQL").append("\n"); 
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
		query.append("SELECT 	'   |ALL' lane" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	DISTINCT " ).append("\n"); 
		query.append("        SUBSTR(A.RLANE_CD,1,3)||'|'||A.RLANE_NM lane" ).append("\n"); 
		query.append("FROM	MDM_REV_LANE A, MDM_DTL_REV_LANE B, MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("WHERE	A.RLANE_CD		= B.RLANE_CD " ).append("\n"); 
		query.append("AND		A.VSL_TP_CD		= 'C' " ).append("\n"); 
		query.append("AND		B.DELT_FLG IN ('N', NULL) " ).append("\n"); 
		query.append("AND		B.TRD_CD		<> 'COM' " ).append("\n"); 
		query.append("AND     B.TRD_CD        =   DECODE( @[trade], NULL, B.TRD_CD, @[trade] )	/* Trade Code */" ).append("\n"); 
		query.append("AND		A.VSL_SLAN_CD	= C.VSL_SLAN_CD " ).append("\n"); 
		query.append("AND		DECODE(C.VSL_SVC_TP_CD,'I',C.CO_CD,'1') = DECODE(C.VSL_SVC_TP_CD,'I','O','1') " ).append("\n"); 
		query.append("AND		C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("ORDER BY	lane" ).append("\n"); 

	}
}