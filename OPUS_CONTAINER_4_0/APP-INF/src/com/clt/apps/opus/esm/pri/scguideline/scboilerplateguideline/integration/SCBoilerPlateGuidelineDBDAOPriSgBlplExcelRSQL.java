/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.04.23 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateGuidelineDBDAOPriSgBlplExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Boiler Plate Excel Download
	  * </pre>
	  */
	public SCBoilerPlateGuidelineDBDAOPriSgBlplExcelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blpl_ref_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration ").append("\n"); 
		query.append("FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplExcelRSQL").append("\n"); 
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
		query.append("SELECT HD.BLPL_REF_YR" ).append("\n"); 
		query.append("     /*, HD.BLPL_HDR_SEQ" ).append("\n"); 
		query.append("     , HD.BLPL_NM" ).append("\n"); 
		query.append("     , HD.EFF_DT" ).append("\n"); 
		query.append("     , HD.EXP_DT" ).append("\n"); 
		query.append("     , BP.BLPL_SEQ*/" ).append("\n"); 
		query.append("     , BP.BLPL_TIT_NM" ).append("\n"); 
		query.append("     /*, BP.DP_SEQ" ).append("\n"); 
		query.append("     , CT.BLPL_CTNT_SEQ" ).append("\n"); 
		query.append("     , CT.DP_SEQ AS CTNT_DP_SEQ*/" ).append("\n"); 
		query.append("     , CT.BLPL_CTNT" ).append("\n"); 
		query.append("FROM PRI_SG_BLPL_HDR HD" ).append("\n"); 
		query.append("   , PRI_SG_BLPL BP" ).append("\n"); 
		query.append("   , PRI_SG_BLPL_CTNT CT" ).append("\n"); 
		query.append("WHERE HD.BLPL_REF_YR = @[blpl_ref_yr]" ).append("\n"); 
		query.append("AND   BP.BLPL_HDR_SEQ = HD.BLPL_HDR_SEQ" ).append("\n"); 
		query.append("AND   CT.BLPL_HDR_SEQ = BP.BLPL_HDR_SEQ" ).append("\n"); 
		query.append("AND   CT.BLPL_SEQ = BP.BLPL_SEQ" ).append("\n"); 
		query.append("ORDER BY BP.DP_SEQ, CT.DP_SEQ" ).append("\n"); 

	}
}