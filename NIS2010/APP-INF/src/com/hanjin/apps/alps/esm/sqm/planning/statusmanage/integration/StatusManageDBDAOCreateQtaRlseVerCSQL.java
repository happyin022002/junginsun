/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : StatusManageDBDAOCreateQtaRlseVerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.13
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.08.13 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOCreateQtaRlseVerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Freezing 시 Qta Rlse Ver 생성
	  * </pre>
	  */
	public StatusManageDBDAOCreateQtaRlseVerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOCreateQtaRlseVerCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_QTA_RLSE_VER (" ).append("\n"); 
		query.append("       QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,SQM_VER_STS_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUBSTR(@[f_bse_yr], 3, 2) || DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) || DECODE(CPY_NO, 0, '01', '02') AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,@[f_bse_tp_cd]  AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,@[f_bse_yr]     AS BSE_YR" ).append("\n"); 
		query.append("      ,DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) AS BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(CPY_NO, 0, 'I', 'R') AS SQM_VER_STS_CD" ).append("\n"); 
		query.append("      ,@[f_usr_id]     AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE         AS CRE_DT" ).append("\n"); 
		query.append("      ,@[f_usr_id]     AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE         AS UPD_DT" ).append("\n"); 
		query.append("  FROM COM_CPY_NO" ).append("\n"); 
		query.append(" WHERE CPY_NO < 2" ).append("\n"); 

	}
}