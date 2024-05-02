/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalInformationPortInfoDAOOptComvoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInformationPortInfoDAOOptComvoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combo Search
	  * </pre>
	  */
	public TerminalInformationPortInfoDAOOptComvoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration").append("\n"); 
		query.append("FileName : TerminalInformationPortInfoDAOOptComvoRSQL").append("\n"); 
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
		query.append("SELECT    	X.LOC_NM 	AS NAME" ).append("\n"); 
		query.append("		,	(" ).append("\n"); 
		query.append("             SELECT    	MAX(DECODE(MO.OFC_TP_CD, 'HQ', MO.OFC_CD))--  AS VAL    " ).append("\n"); 
		query.append("             FROM    	MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("             CONNECT BY NOCYCLE PRIOR MO.PRNT_OFC_CD  	= MO.OFC_CD" ).append("\n"); 
		query.append("             START WITH	MO.OFC_CD             			= X.SLS_OFC_CD" ).append("\n"); 
		query.append("             )			AS VAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--        , CASE WHEN X.CONTI_CD  IN ('F','E') THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001', 'VSK')))" ).append("\n"); 
		query.append("--               WHEN X.CONTI_CD  = 'M'        THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000002', 'VSK')))" ).append("\n"); 
		query.append("--               WHEN X.CONTI_CD  = 'A'        THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000003', 'VSK')))" ).append("\n"); 
		query.append("--               ELSE ''" ).append("\n"); 
		query.append("--          END  AS VAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM      MDM_LOCATION          X" ).append("\n"); 
		query.append("WHERE     X.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("AND       X.CALL_PORT_FLG       = 'Y'" ).append("\n"); 
		query.append("AND       X.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("AND       X.LOC_CD              = @[loc_cd]" ).append("\n"); 

	}
}