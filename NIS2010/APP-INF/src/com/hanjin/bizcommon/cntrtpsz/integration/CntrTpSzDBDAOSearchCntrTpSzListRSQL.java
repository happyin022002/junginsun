/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrTpSzDBDAOSearchCntrTpSzListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.cntrtpsz.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrTpSzDBDAOSearchCntrTpSzListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CntrTpSz의 모든 목록을 가져온다.
	  * </pre>
	  */
	public CntrTpSzDBDAOSearchCntrTpSzListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.cntrtpsz.integration").append("\n"); 
		query.append("FileName : CntrTpSzDBDAOSearchCntrTpSzListRSQL").append("\n"); 
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
		query.append("SELECT cntr_tpsz_cd," ).append("\n"); 
		query.append("cntr_tpsz_desc" ).append("\n"); 
		query.append("FROM (	SELECT ROW_NUMBER() OVER (ORDER BY cntr_tpsz_cd ASC) no," ).append("\n"); 
		query.append("cntr_tpsz_cd," ).append("\n"); 
		query.append("cntr_tpsz_desc" ).append("\n"); 
		query.append("FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND cntr_tpsz_cd like @[cntr_tpsz_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_desc} != '')" ).append("\n"); 
		query.append("AND cntr_tpsz_desc like '%' || @[cntr_tpsz_desc] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("WHERE no BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}