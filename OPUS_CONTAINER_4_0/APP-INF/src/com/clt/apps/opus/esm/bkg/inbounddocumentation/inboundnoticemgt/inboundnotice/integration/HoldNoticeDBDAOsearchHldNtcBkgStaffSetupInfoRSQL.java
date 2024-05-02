/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchHldNtcBkgStaffSetupInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : inyoung Lee
*@LastVersion : 1.0
* 2011.01.04 inyoung Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author inyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchHldNtcBkgStaffSetupInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHldNtcBkgStaffSetupInfo
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchHldNtcBkgStaffSetupInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchHldNtcBkgStaffSetupInfoRSQL").append("\n"); 
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
		query.append("SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("      ,BKGM.BL_NO" ).append("\n"); 
		query.append("      ,BKGM.POR_CD" ).append("\n"); 
		query.append("      ,BKGM.POL_CD" ).append("\n"); 
		query.append("      ,BKGM.POD_CD" ).append("\n"); 
		query.append("      ,BKGM.DEL_CD" ).append("\n"); 
		query.append("      ,BKGM.DOC_USR_ID" ).append("\n"); 
		query.append("      ,COM.OFC_CD" ).append("\n"); 
		query.append("      ,COM.USR_NM" ).append("\n"); 
		query.append("      ,COM.USR_EML" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BKGM" ).append("\n"); 
		query.append("     ,COM_USER COM" ).append("\n"); 
		query.append("WHERE BKGM.BL_NO    = @[bl_no]" ).append("\n"); 
		query.append("AND   COM.USR_ID(+) = BKGM.DOC_USR_ID" ).append("\n"); 

	}
}