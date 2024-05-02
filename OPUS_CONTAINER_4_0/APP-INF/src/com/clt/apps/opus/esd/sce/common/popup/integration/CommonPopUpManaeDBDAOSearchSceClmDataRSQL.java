/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpManaeDBDAOSearchSceClmDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.09 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonPopUpManaeDBDAOSearchSceClmDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select data
	  * </pre>
	  */
	public CommonPopUpManaeDBDAOSearchSceClmDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.popup.integration ").append("\n"); 
		query.append("FileName : CommonPopUpManaeDBDAOSearchSceClmDataRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append(",TO_CHAR(DEP_DT,'YYYY/MM/DD HH24:MI:SS') ETA_DT" ).append("\n"); 
		query.append(",CLM_CRR_NM RR" ).append("\n"); 
		query.append(",TO_CHAR(CLM_RCV_DT,'YYYY/MM/DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append(",DECODE(CNMV_YR,'IETA','RR ETA at Interchange','RR ETA at DEST') ETA_TP" ).append("\n"); 
		query.append("FROM  SCE_CLM" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("AND   ROWNUM <= 5" ).append("\n"); 
		query.append("ORDER BY CLM_RCV_DT DESC" ).append("\n"); 

	}
}