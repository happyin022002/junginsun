/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqDurVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.05 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqDurVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Boiler Plate Inquiry Duration을 조회합니다.
	  * </pre>
	  */
	public SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqDurVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.integration").append("\n"); 
		query.append("FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqDurVORSQL").append("\n"); 
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
		query.append("SELECT BLPL_HDR_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(EFF_DT, 'yyyy-MM-dd') EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(EXP_DT, 'yyyy-MM-dd') EXP_DT" ).append("\n"); 
		query.append(",DECODE(CFM_FLG,'Y','Yes','N','No') CFM_FLG" ).append("\n"); 
		query.append("FROM PRI_SG_BLPL_HDR" ).append("\n"); 
		query.append("WHERE BLPL_REF_YR = @[blpl_ref_yr]" ).append("\n"); 
		query.append("ORDER BY EFF_DT DESC" ).append("\n"); 

	}
}