/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchGapDatetimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.01.15 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchGapDatetimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGapDatetime
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchGapDatetimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchGapDatetimeRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(TO_NUMBER(TO_CHAR( (TO_DATE(@[aft_act_dt],'YYYY/MM/DD HH24:MI:SS') - NVL(TO_DATE(@[bfr_act_dt],'YYYYMMDDHH24MISS') ,ESTM_DT))" ).append("\n"); 
		query.append("                               ,'0000000000.0000000000')" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("            ) ESTM_GAP" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL DTL" ).append("\n"); 
		query.append("WHERE  DTL.COP_NO        = @[cop_no]" ).append("\n"); 
		query.append("AND    DTL.COP_DTL_SEQ   = @[to_cop_dtl_seq]" ).append("\n"); 

	}
}