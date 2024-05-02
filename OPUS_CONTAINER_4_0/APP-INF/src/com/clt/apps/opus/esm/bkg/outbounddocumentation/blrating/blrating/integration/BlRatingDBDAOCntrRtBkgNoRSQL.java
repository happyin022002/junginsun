/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOCntrRtBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCntrRtBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BlRatingDBDAOCntrRtBkgNoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCntrRtBkgNoRSQL").append("\n"); 
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
		query.append("SELECT a.bkg_no, b.BL_CVRD_TP_CD" ).append("\n"); 
		query.append("FROM   bkg_booking a, bkg_bl_doc b" ).append("\n"); 
		query.append(",      (SELECT NVL (b.mst_cvrd_bl_no, a.bl_no) mst_bl_no" ).append("\n"); 
		query.append("FROM   bkg_booking a, bkg_bl_doc b" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND    a.bkg_no = @[bkg_no]) c" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND    (a.bl_no = c.mst_bl_no OR b.mst_cvrd_bl_no = c.mst_bl_no)" ).append("\n"); 
		query.append("AND    a.bkg_sts_cd NOT IN ('X', 'A')" ).append("\n"); 
		query.append("ORDER BY 2 desc, 1" ).append("\n"); 

	}
}