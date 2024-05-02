/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchDBDAOModifyUsaBatchDtlSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.31 
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

public class CostBatchDBDAOModifyUsaBatchDtlSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA 지역의 Re-Batch 추가에 따른 AOC_USA_INLND_BAT_DTL 의 Bat Seq. 수정
	  * </pre>
	  */
	public CostBatchDBDAOModifyUsaBatchDtlSeqUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.integration").append("\n"); 
		query.append("FileName : CostBatchDBDAOModifyUsaBatchDtlSeqUSQL").append("\n"); 
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
		query.append("UPDATE  AOC_USA_INLND_BAT_DTL" ).append("\n"); 
		query.append("SET     COST_TRF_BAT_SEQ = (" ).append("\n"); 
		query.append("                             SELECT  MAX(COST_TRF_BAT_SEQ)" ).append("\n"); 
		query.append("                             FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("                             WHERE   1 = 1" ).append("\n"); 
		query.append("                             AND     COST_TRF_BAT_SEQ > @[cost_trf_bat_seq]" ).append("\n"); 
		query.append("                             AND     ( CNT_CD, IO_BND_CD ) IN ( (@[cnt_cd], @[io_bnd_cd]) )" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("      , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     COST_TRF_BAT_SEQ = @[cost_trf_bat_seq]" ).append("\n"); 

	}
}