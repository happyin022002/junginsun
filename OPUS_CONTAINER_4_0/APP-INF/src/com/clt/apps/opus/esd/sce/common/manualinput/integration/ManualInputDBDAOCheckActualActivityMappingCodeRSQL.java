/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputDBDAOCheckActualActivityMappingCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOCheckActualActivityMappingCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckActualActivityMappingCode
	  * </pre>
	  */
	public ManualInputDBDAOCheckActualActivityMappingCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration ").append("\n"); 
		query.append("FileName : ManualInputDBDAOCheckActualActivityMappingCodeRSQL").append("\n"); 
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
		query.append("SELECT COUNT(0) AS CHK" ).append("\n"); 
		query.append("FROM SCE_ACT_ACT_MAPG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ACT_CD = @[act_cd]" ).append("\n"); 
		query.append("AND ACT_RCV_TP_CD = @[act_rcv_tp_cd]" ).append("\n"); 
		query.append("AND ACT_STS_MAPG_CD = @[act_sts_mapg_cd]" ).append("\n"); 

	}
}