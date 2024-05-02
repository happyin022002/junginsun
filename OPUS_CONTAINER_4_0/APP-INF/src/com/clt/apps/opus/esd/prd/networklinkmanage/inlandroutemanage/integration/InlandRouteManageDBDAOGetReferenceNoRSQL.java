/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InlandRouteManageDBDAOGetReferenceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOGetReferenceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetReferenceNo
	  * </pre>
	  */
	public InlandRouteManageDBDAOGetReferenceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOGetReferenceNoRSQL").append("\n"); 
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
		query.append("SELECT a.AGMT_REF_NO,av.VNDR_SEQ from TRS_AGMT_HDR a ,TRS_AGMT_APLY_VNDR AV   " ).append("\n"); 
		query.append("        	WHERE a.TRSP_AGMT_OFC_CTY_CD = @[cty_cd]" ).append("\n"); 
		query.append("        	AND   TO_CHAR(a.TRSP_AGMT_SEQ) = @[agmt_seq] " ).append("\n"); 
		query.append("        	AND   a.TRSP_AGMT_OFC_CTY_CD = av.TRSP_AGMT_OFC_CTY_CD " ).append("\n"); 
		query.append("        	AND   a.TRSP_AGMT_SEQ = av.TRSP_AGMT_SEQ " ).append("\n"); 
		query.append("        	--AND   NVL(a.DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}