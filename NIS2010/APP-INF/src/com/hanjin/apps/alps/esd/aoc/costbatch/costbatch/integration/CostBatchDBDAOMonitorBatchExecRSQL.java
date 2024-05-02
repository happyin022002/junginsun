/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchDBDAOMonitorBatchExecRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostBatchDBDAOMonitorBatchExecRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.11 변종건 Inland Cost Batch Cretion 화면의 Batch Queue 에 Processing 데이터 존재 여부 확인
	  * </pre>
	  */
	public CostBatchDBDAOMonitorBatchExecRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.integration").append("\n"); 
		query.append("FileName : CostBatchDBDAOMonitorBatchExecRSQL").append("\n"); 
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
		query.append("SELECT  'Y' PROG_FLG" ).append("\n"); 
		query.append("FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND     IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND     BAT_PROG_STS_CD IN ('W','P','A','R')" ).append("\n"); 
		query.append("AND     ROWNUM <= 1" ).append("\n"); 

	}
}