/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BasicDataDBDAOCopyLaneDirectionChangeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.12
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.08.12 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOCopyLaneDirectionChangeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 최근 이전 분기의 데이터를 복사
	  * </pre>
	  */
	public BasicDataDBDAOCopyLaneDirectionChangeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOCopyLaneDirectionChangeCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_DIR_CONV (" ).append("\n"); 
		query.append("     BSE_TP_CD " ).append("\n"); 
		query.append("	,BSE_YR " ).append("\n"); 
		query.append("	,BSE_QTR_CD " ).append("\n"); 
		query.append("	,TRD_CD " ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,DIR_CD " ).append("\n"); 
		query.append("    ,CONV_DIR_CD " ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("SELECT  @[f_bse_tp_cd] " ).append("\n"); 
		query.append("        ,@[f_bse_yr] " ).append("\n"); 
		query.append("        ,DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd]) " ).append("\n"); 
		query.append("        ,TRD_CD " ).append("\n"); 
		query.append("        ,RLANE_CD " ).append("\n"); 
		query.append("        ,DIR_CD " ).append("\n"); 
		query.append("        ,CONV_DIR_CD " ).append("\n"); 
		query.append("        ,@[usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(SQM_DIR_CONV XPKSQM_DIR_CONV) */" ).append("\n"); 
		query.append("                BSE_YR " ).append("\n"); 
		query.append("               ,BSE_QTR_CD" ).append("\n"); 
		query.append("         FROM SQM_DIR_CONV" ).append("\n"); 
		query.append("        WHERE BSE_YR || BSE_QTR_CD  <  @[f_bse_yr]||DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd]) " ).append("\n"); 
		query.append("          AND BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      ,SQM_DIR_CONV CONV             " ).append("\n"); 
		query.append(" WHERE CONV.BSE_YR = A.BSE_YR " ).append("\n"); 
		query.append("   AND CONV.BSE_QTR_CD = A.BSE_QTR_CD" ).append("\n"); 

	}
}