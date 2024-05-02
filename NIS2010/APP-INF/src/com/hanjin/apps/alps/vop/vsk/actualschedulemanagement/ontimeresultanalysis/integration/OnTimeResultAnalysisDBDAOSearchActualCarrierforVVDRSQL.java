/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchActualCarrierforVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.08
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.08.08 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchActualCarrierforVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD에 대해서 ACTUAL CARRIER 정보를 조회한다.
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchActualCarrierforVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchActualCarrierforVVDRSQL").append("\n"); 
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
		query.append("SELECT    NVL(VS.ACT_CRR_CD,VC.CRR_CD)      AS ACT_CRR_CD" ).append("\n"); 
		query.append("FROM      MDM_VSL_CNTR     VC" ).append("\n"); 
		query.append("       ,  VSK_VSL_SKD      VS" ).append("\n"); 
		query.append("WHERE     VC.VSL_CD        = VS.VSL_CD " ).append("\n"); 
		query.append("AND       VS.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND       VS.SKD_VOY_NO    = @[voy_no]" ).append("\n"); 
		query.append("AND       VS.SKD_DIR_CD    = @[dir_cd]" ).append("\n"); 

	}
}