/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustmentDBDAOSearchReeferSpclTpSzMgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOSearchReeferSpclTpSzMgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Reefer/Special Type/Size Master]을 [조회]합니다.
	  * </pre>
	  */
	public AdjustmentDBDAOSearchReeferSpclTpSzMgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dg_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearchReeferSpclTpSzMgmtRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DECODE(SPCL_TGT_CD, 'D', 'Dry', 'S', 'Special', 'R', 'Reefer') AS SPCL_TGT_CD" ).append("\n"); 
		query.append("     , DECODE(SPCL_DG_CGO_FLG,'N', '', 'Y') AS SPCL_DG_CGO_FLG" ).append("\n"); 
		query.append("     , DECODE(RD_FLG,'N', '', 'Y') AS RD_FLG" ).append("\n"); 
		query.append("     , DECODE(SQM_ACT_FLG,'Y', 1, 0) AS SQM_ACT_FLG " ).append("\n"); 
		query.append("FROM SQM_SPCL_CNTR_TP_SZ_MGMT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_spcl_tgt_cd} != '' && ${f_spcl_tgt_cd} != 'All')" ).append("\n"); 
		query.append("AND SPCL_TGT_CD = @[f_spcl_tgt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dg_flg} != '' && ${f_dg_flg} != 'All')" ).append("\n"); 
		query.append("AND SPCL_DG_CGO_FLG = @[f_dg_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rd_flg} != '' && ${f_rd_flg} != 'All')" ).append("\n"); 
		query.append("AND RD_FLG = @[f_rd_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD, SPCL_TGT_CD" ).append("\n"); 

	}
}