/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineDBDAOCheckPriSgBlplHdrYearRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.04 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateGuidelineDBDAOCheckPriSgBlplHdrYearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 년도당 보일러플레이트가 하나인 지 체크
	  * </pre>
	  */
	public SCBoilerPlateGuidelineDBDAOCheckPriSgBlplHdrYearRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blpl_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration").append("\n"); 
		query.append("FileName : SCBoilerPlateGuidelineDBDAOCheckPriSgBlplHdrYearRSQL").append("\n"); 
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
		query.append("COUNT(*) AS CHK" ).append("\n"); 
		query.append("FROM PRI_SG_BLPL_HDR" ).append("\n"); 
		query.append("WHERE	BLPL_REF_YR = @[blpl_ref_yr]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${blpl_hdr_seq} != '')" ).append("\n"); 
		query.append("AND	BLPL_HDR_SEQ <> @[blpl_hdr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}