/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsCustSvcInstrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchUsCustSvcInstrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inbound C/S_USA SCREEN에서 저장된 Remark를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchUsCustSvcInstrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchUsCustSvcInstrRSQL").append("\n"); 
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
		query.append("SELECT   INSTR.BKG_NO" ).append("\n"); 
		query.append("       , INSTR.INSTR_RMK_SEQ" ).append("\n"); 
		query.append("       , INSTR.INSTR_RMK" ).append("\n"); 
		query.append("       , INSTR.CRE_USR_ID" ).append("\n"); 
		query.append("       , USR.USR_NM" ).append("\n"); 
		query.append("       , to_char(INSTR.UPD_LOCL_DT, 'YYYY/MM/DD HH24:MI')  UPD_LOCL_DT" ).append("\n"); 
		query.append("       , to_char(INSTR.UPD_LOCL_GDT, 'YYYY/MM/DD HH24:MI') UPD_LOCL_GDT" ).append("\n"); 
		query.append("FROM   BKG_USA_CUST_SVC_INSTR INSTR," ).append("\n"); 
		query.append("       COM_USER USR" ).append("\n"); 
		query.append("WHERE  INSTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    INSTR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    INSTR.CRE_USR_ID = USR.USR_ID (+)" ).append("\n"); 
		query.append("ORDER BY INSTR.BKG_NO, INSTR.INSTR_RMK_SEQ asc" ).append("\n"); 

	}
}