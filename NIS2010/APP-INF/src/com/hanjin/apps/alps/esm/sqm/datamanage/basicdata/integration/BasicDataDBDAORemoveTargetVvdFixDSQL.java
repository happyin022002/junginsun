/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BasicDataDBDAORemoveTargetVvdFixDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAORemoveTargetVvdFixDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [2017.05.10] 김동호
	  * TARGET VVD FIX 메뉴를 계속 CREATION 할수 있게 변경 요청으로 인해
	  * SQM_QTA_TGT_VVD 데이터 삭제 쿼리 추가(조지윤 차장님 요청)
	  * </pre>
	  */
	public BasicDataDBDAORemoveTargetVvdFixDSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAORemoveTargetVvdFixDSQL").append("\n"); 
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
		query.append("DELETE FROM SQM_QTA_TGT_VVD " ).append("\n"); 
		query.append("WHERE BSE_TP_CD   = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("  AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 

	}
}