/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrTpSzDBDAOTotalCntrTpSzRSQL.java
*@FileTitle : TEST
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.05.22 정인선
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.cntrtpsz.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung In Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrTpSzDBDAOTotalCntrTpSzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Type Size의 총 카운트를 조회한다.
	  * </pre>
	  */
	public CntrTpSzDBDAOTotalCntrTpSzRSQL(){
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
		params.put("cntr_tpsz_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND cntr_tpsz_cd like @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_desc} != '')" ).append("\n"); 
		query.append("AND cntr_tpsz_desc like @[cntr_tpsz_desc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.cntrtpsz.integration ").append("\n"); 
		query.append("FileName : CntrTpSzDBDAOTotalCntrTpSzRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}