/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAOSearch13RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.09.07 최진오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JIN O CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch13RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search13RailSoManage SELECT
	  * </pre>
	  */
	public RailSoManageDBDAOSearch13RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_prov_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch13RailSoManageRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("A.PROV_VNDR_SEQ  ," ).append("\n"); 
		query.append("A.PROV_USR_ID    ," ).append("\n"); 
		query.append("A.PROV_PHN_NO" ).append("\n"); 
		query.append("FROM  TRS_TRSP_RAIL_BIL_ORD A," ).append("\n"); 
		query.append("MDM_VENDOR            B" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = @[f_trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.TRSP_SO_SEQ        = @[f_trsp_so_seq]" ).append("\n"); 
		query.append("AND   A.PROV_VNDR_SEQ      = @[f_prov_vndr_seq]" ).append("\n"); 
		query.append("AND   A.PROV_VNDR_SEQ      = B.VNDR_SEQ" ).append("\n"); 

	}
}