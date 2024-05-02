/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostBatchDBDAOInsertBatchQueueCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
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

public class CostBatchDBDAOInsertBatchQueueCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * History
	  * 2012.05.11 변종건 Inland Cost Batch Creation화면의 Batch Creation 생성 위한 Queue Insert
	  * 2013.01.14 이혜민 CHM-201322300 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
	  * 2015.02.03 전지예 CHM-201533794 [AOC] 45' Cost 추가
	  * </pre>
	  */
	public CostBatchDBDAOInsertBatchQueueCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_20ft_crte_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_40ft_crte_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_45ft_crte_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.integration").append("\n"); 
		query.append("FileName : CostBatchDBDAOInsertBatchQueueCSQL").append("\n"); 
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
		query.append("INSERT INTO AOC_TRF_BAT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      COST_TRF_BAT_SEQ" ).append("\n"); 
		query.append("    , PGM_NO" ).append("\n"); 
		query.append("    , CNT_CD" ).append("\n"); 
		query.append("    , IO_BND_CD" ).append("\n"); 
		query.append("    , COST_TRF_BAT_ID" ).append("\n"); 
		query.append("    , BAT_PROG_STS_CD" ).append("\n"); 
		query.append("    , BAT_PROG_KNT" ).append("\n"); 
		query.append("    , BAT_PROG_TTL_KNT" ).append("\n"); 
		query.append("    , COST_TRF_BAT_ERR_VAL" ).append("\n"); 
		query.append("    , COST_TRF_BAT_ERR_DESC" ).append("\n"); 
		query.append("    , BAT_ST_DT" ).append("\n"); 
		query.append("    , BAT_END_DT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , CRE_OFC_CD" ).append("\n"); 
		query.append("    , LOCL_CRE_DT" ).append("\n"); 
		query.append("	, CNTR_45FT_CRTE_WGT -- 45' Cost 추가" ).append("\n"); 
		query.append("	, CNTR_40FT_CRTE_WGT" ).append("\n"); 
		query.append("	, CNTR_20FT_CRTE_WGT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("      TRS_COST_TRF_BAT_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("    , (" ).append("\n"); 
		query.append("        SELECT  MAX(PGM_NO)" ).append("\n"); 
		query.append("        FROM    AOC_TRF_BAT_MAPG" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     ( RHQ_CD = @[rhq_cd] AND CNT_CD = @[cnt_cd] )" ).append("\n"); 
		query.append("        OR      ( RHQ_CD = @[rhq_cd] AND CNT_CD IS NULL )" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    , @[cnt_cd]" ).append("\n"); 
		query.append("    , @[io_bnd_cd]" ).append("\n"); 
		query.append("    , NULL" ).append("\n"); 
		query.append("    , @[sts_cd]" ).append("\n"); 
		query.append("    , NULL" ).append("\n"); 
		query.append("    , NULL" ).append("\n"); 
		query.append("    , NULL" ).append("\n"); 
		query.append("    , NULL" ).append("\n"); 
		query.append("    , NULL" ).append("\n"); 
		query.append("    , NULL" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[usr_ofc_cd]" ).append("\n"); 
		query.append("    , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("	, @[cntr_45ft_crte_wgt] -- 45' Cost 추가" ).append("\n"); 
		query.append("	, @[cntr_40ft_crte_wgt]" ).append("\n"); 
		query.append("	, @[cntr_20ft_crte_wgt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}