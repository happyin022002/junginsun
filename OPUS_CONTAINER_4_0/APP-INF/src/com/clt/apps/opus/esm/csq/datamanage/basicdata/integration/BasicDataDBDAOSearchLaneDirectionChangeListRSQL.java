/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOSearchLaneDirectionChangeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchLaneDirectionChangeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reverse Sailing 노선들의 Direction을 조회.
	  * 김용습-조회시 같은 노선을 가진 열들의 DIR_CD이 E,W,N,S순으로 정렬되어
	  * 화면에 뿌려지도록 하기 위해서 REORDER컬럼을 생성하여 이에 따라 정렬하도록 함
	  * (그렇지 않으면 알파벳순에 따라 DIR_CD가 E인 열의 아래 DIR_CD가 N이 나오는 등
	  *  E와W, N과S의 짝으로 데이터가 뿌려지지 않음)
	  * </pre>
	  */
	public BasicDataDBDAOSearchLaneDirectionChangeListRSQL(){
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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchLaneDirectionChangeListRSQL").append("\n"); 
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
		query.append("SELECT BSE_TP_CD" ).append("\n"); 
		query.append("       ,BSE_YR" ).append("\n"); 
		query.append("       ,BSE_QTR_CD" ).append("\n"); 
		query.append("       ,TRD_CD" ).append("\n"); 
		query.append("       ,RLANE_CD" ).append("\n"); 
		query.append("       ,DIR_CD" ).append("\n"); 
		query.append("       ,CONV_DIR_CD" ).append("\n"); 
		query.append("	   ,DECODE(DIR_CD,'E',1,'W',2,'N',3,'S',4) REORDER" ).append("\n"); 
		query.append(" FROM CSQ_DIR_CONV" ).append("\n"); 
		query.append("WHERE BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("  AND TRD_CD = DECODE(@[f_trd_cd],'All',TRD_CD,@[f_trd_cd])" ).append("\n"); 
		query.append("  AND RLANE_CD = DECODE(@[f_rlane_cd],'All',RLANE_CD,@[f_rlane_cd])" ).append("\n"); 
		query.append("  AND DIR_CD = DECODE(@[f_dir_cd],'All',DIR_CD,@[f_dir_cd])" ).append("\n"); 
		query.append("ORDER BY TRD_CD,RLANE_CD,REORDER" ).append("\n"); 

	}
}