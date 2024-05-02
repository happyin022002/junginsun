/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOMultiExpMapgOfcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.11.10 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOMultiExpMapgOfcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multi exp
	  * </pre>
	  */
	public ExceptionDataDBDAOMultiExpMapgOfcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ibflag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mapg_ofc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_act_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mapg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOMultiExpMapgOfcCSQL").append("\n"); 
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
		query.append("MERGE  INTO   SCE_EXPT_OFC_MAPG_INFO A" ).append("\n"); 
		query.append("USING  ( SELECT  @[f_ofc_cd] AS OFC_CD,  @[f_mapg_ofc_cd] AS MAPG_OFC_CD, @[f_act_flg] AS DELT_FLG" ).append("\n"); 
		query.append(", @[f_ibflag] AS IB_FLG ," ).append("\n"); 
		query.append("(select NVL(MAX(SUBSTR(OFC_CLSS_ID,1,1))+1,1)" ).append("\n"); 
		query.append("FROM SCE_EXPT_OFC_MAPG_INFO" ).append("\n"); 
		query.append("where not exists" ).append("\n"); 
		query.append("(select 'X'" ).append("\n"); 
		query.append("FROM SCE_EXPT_OFC_MAPG_INFO" ).append("\n"); 
		query.append("WHERE OFC_CD = @[f_ofc_cd]" ).append("\n"); 
		query.append("AND   MAPG_OFC_CD = @[f_mapg_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") MAX_OFC_CLSS_ID" ).append("\n"); 
		query.append("FROM    DUAL ) B" ).append("\n"); 
		query.append("ON     (A.OFC_CD = B.OFC_CD  AND A.MAPG_OFC_CD=B.MAPG_OFC_CD)" ).append("\n"); 
		query.append("WHEN   MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET    UPD_USR_ID   = @[f_usr_id]," ).append("\n"); 
		query.append("UPD_DT       = SYSDATE," ).append("\n"); 
		query.append("DELT_FLG      = DECODE(B.IB_FLG,'D','Y', 'N')" ).append("\n"); 
		query.append("WHEN   NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( OFC_CLSS_ID," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("MAPG_OFC_CD," ).append("\n"); 
		query.append("MAPG_OFC_ENG_NM," ).append("\n"); 
		query.append("LOC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("DELT_FLG)" ).append("\n"); 
		query.append("VALUES (B.OFC_CD||B.MAPG_OFC_CD, @[f_ofc_cd], @[f_mapg_ofc_cd], @[f_mapg_ofc_nm], @[f_loc_cd], @[f_usr_id], SYSDATE, @[f_usr_id],'N')" ).append("\n"); 

	}
}