/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BasicDataDBDAOAddLaneDirectionChangeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.06.05 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOAddLaneDirectionChangeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reverse Sailing 노선들의 변경된 Direction을 추가
	  * </pre>
	  */
	public BasicDataDBDAOAddLaneDirectionChangeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOAddLaneDirectionChangeCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_DIR_CONV (  " ).append("\n"); 
		query.append("             BSE_TP_CD" ).append("\n"); 
		query.append("            ,BSE_YR" ).append("\n"); 
		query.append("            ,BSE_QTR_CD" ).append("\n"); 
		query.append("            ,TRD_CD" ).append("\n"); 
		query.append("            ,RLANE_CD" ).append("\n"); 
		query.append("            ,DIR_CD" ).append("\n"); 
		query.append("            ,CONV_DIR_CD   " ).append("\n"); 
		query.append("            ,CRE_USR_ID          " ).append("\n"); 
		query.append("            ,CRE_DT              " ).append("\n"); 
		query.append("            ,UPD_USR_ID         " ).append("\n"); 
		query.append("            ,UPD_DT           )  " ).append("\n"); 
		query.append(" VALUES (                       " ).append("\n"); 
		query.append("             @[bse_tp_cd]" ).append("\n"); 
		query.append("            ,@[bse_yr]" ).append("\n"); 
		query.append("            ,DECODE(@[bse_tp_cd],'Y','00',@[bse_qtr_cd])" ).append("\n"); 
		query.append("            ,@[trd_cd]" ).append("\n"); 
		query.append("            ,@[rlane_cd]" ).append("\n"); 
		query.append("            ,@[dir_cd]" ).append("\n"); 
		query.append("            ,@[conv_dir_cd]                  " ).append("\n"); 
		query.append("            ,@[cre_usr_id]                   " ).append("\n"); 
		query.append("            ,SYSDATE             " ).append("\n"); 
		query.append("            ,@[cre_usr_id]                 " ).append("\n"); 
		query.append("            ,SYSDATE )" ).append("\n"); 

	}
}