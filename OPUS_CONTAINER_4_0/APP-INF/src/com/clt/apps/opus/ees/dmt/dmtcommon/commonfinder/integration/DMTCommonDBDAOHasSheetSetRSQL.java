/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOHasSheetSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOHasSheetSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sheet Set 이 존재하는지를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOHasSheetSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_sh_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOHasSheetSetRSQL").append("\n"); 
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
		query.append("SELECT	COUNT(OFC_CD) AS CNT" ).append("\n"); 
		query.append("FROM	DMT_SH_SET" ).append("\n"); 
		query.append("WHERE	OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND DMDT_SH_TP_CD = @[dmdt_sh_tp_cd]" ).append("\n"); 

	}
}