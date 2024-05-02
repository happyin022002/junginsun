/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PrdCommonManageDBDAOCreatePrdNodeByZoneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOCreatePrdNodeByZoneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CCD Zone Creation시 PRD Node에도 해당 정보를 Insert한다.
	  * </pre>
	  */
	public PrdCommonManageDBDAOCreatePrdNodeByZoneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOCreatePrdNodeByZoneCSQL").append("\n"); 
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
		query.append("INSERT INTO prd_node (                                      					" ).append("\n"); 
		query.append("			 	nod_cd 	       ,nod_nm 	       ,nod_tp_cd      ,loc_cd 	       ,			" ).append("\n"); 
		query.append("			 	onf_hir_yd_flg ,delt_flg       ,cre_usr_id     ,cre_dt 	       ,			" ).append("\n"); 
		query.append("			 	upd_usr_id     ,upd_dt" ).append("\n"); 
		query.append("			  )                                                           					" ).append("\n"); 
		query.append("VALUES  (													 					" ).append("\n"); 
		query.append("			 	@[zn_cd] ,@[zn_nm] ,'Z' ,SUBSTR(@[zn_cd],1,5) ," ).append("\n"); 
		query.append("				'N' ,@[delt_flg] ,@[usr_id] ,sysdate," ).append("\n"); 
		query.append("				@[usr_id] ,sysdate" ).append("\n"); 
		query.append("		 )" ).append("\n"); 

	}
}