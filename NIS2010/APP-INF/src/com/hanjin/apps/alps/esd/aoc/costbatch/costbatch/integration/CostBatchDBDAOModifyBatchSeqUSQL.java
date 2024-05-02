/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostBatchDBDAOModifyBatchSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
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

public class CostBatchDBDAOModifyBatchSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Re-Batch로 인한 HDR Table의 Batch Seq 수정
	  * </pre>
	  */
	public CostBatchDBDAOModifyBatchSeqUSQL(){
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
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CostBatchDBDAOModifyBatchSeqUSQL").append("\n"); 
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
		query.append("#if (${rhq_cd} == 'HAMRU') " ).append("\n"); 
		query.append("UPDATE  AOC_EUR_INLND_TRF_HDR" ).append("\n"); 
		query.append("#elseif (${rhq_cd} == 'NYCRA') " ).append("\n"); 
		query.append("UPDATE  AOC_USA_INLND_TRF_HDR" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE  AOC_CHN_INLND_TRF_HDR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SET     COST_TRF_BAT_SEQ = (" ).append("\n"); 
		query.append("                             SELECT  MAX(COST_TRF_BAT_SEQ)" ).append("\n"); 
		query.append("                             FROM    AOC_TRF_BAT" ).append("\n"); 
		query.append("                             WHERE   1 = 1" ).append("\n"); 
		query.append("                             AND     COST_TRF_BAT_SEQ > @[cost_trf_bat_seq]" ).append("\n"); 
		query.append("                             AND     ( CNT_CD, IO_BND_CD ) IN ( (@[cnt_cd], @[io_bnd_cd]) )" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("      , UPD_OFC_CD = @[usr_ofc_cd]" ).append("\n"); 
		query.append("      , LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("      , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 

	}
}