/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ExceptionAckRailRoadDBDAOSearchExceptionAckRailRoadVendorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionAckRailRoadDBDAOSearchExceptionAckRailRoadVendorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExceptionAckRailRoadDBDAOSearchExceptionAckRailRoadVendorList
	  * </pre>
	  */
	public ExceptionAckRailRoadDBDAOSearchExceptionAckRailRoadVendorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_railroad",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.integration").append("\n"); 
		query.append("FileName : ExceptionAckRailRoadDBDAOSearchExceptionAckRailRoadVendorListRSQL").append("\n"); 
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
		query.append("SELECT A.EXPT_ACK_RAIL_VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,M.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,DECODE(A.DELT_FLG, 'Y', 'D', 'R') IBFLAG" ).append("\n"); 
		query.append("      ,DECODE(A.DELT_FLG, 'Y', 1, 0) DELT_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("  FROM TRS_EXPT_ACK_RAIL_VNDR A, MDM_VENDOR M" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = M.VNDR_SEQ" ).append("\n"); 
		query.append("   AND DECODE(@[sel_railroad], 'ALL', 'X', A.VNDR_SEQ) = DECODE(@[sel_railroad], 'ALL', 'X', @[sel_railroad])" ).append("\n"); 
		query.append(" ORDER BY A.EXPT_ACK_RAIL_VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}