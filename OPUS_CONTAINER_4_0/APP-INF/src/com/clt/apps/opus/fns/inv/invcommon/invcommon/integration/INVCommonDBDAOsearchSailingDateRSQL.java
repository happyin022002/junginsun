/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : INVCommonDBDAOsearchSailingDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.01.05 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchSailingDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVCommonDBDAOsearchSailingDateRSQL
	  * </pre>
	  */
	public INVCommonDBDAOsearchSailingDateRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchSailingDateRSQL").append("\n"); 
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
		query.append("SELECT MIN(TO_CHAR(A.VPS_ETD_DT, 'yyyymmdd')) VPS_ETD_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A, BKG_VVD B" ).append("\n"); 
		query.append("WHERE B.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("AND A.VSL_CD(+)       = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO(+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD(+)    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD(+)    = B.POL_CD" ).append("\n"); 
		query.append("AND A.CLPT_IND_SEQ(+)  = '1'" ).append("\n"); 
		query.append("AND A.VPS_ETD_DT IS NOT NULL" ).append("\n"); 

	}
}