/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchRailRcvCoffDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.15 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchRailRcvCoffDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CLZ_TM table 에서 Rail receiving cut off date 관련 정보를 조회힌다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchRailRcvCoffDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchRailRcvCoffDtRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO, RAIL_RCV_COFF_FM_DT, RAIL_RCV_COFF_TO_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("select BKG_NO," ).append("\n"); 
		query.append("MAX(decode (clz_tp_cd, 'F', TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYYMMDDHH24MISS'), '')) AS RAIL_RCV_COFF_FM_DT ," ).append("\n"); 
		query.append("MAX(decode (clz_tp_cd, 'O', TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYYMMDDHH24MISS'), '')) AS RAIL_RCV_COFF_TO_DT" ).append("\n"); 
		query.append("from bkg_clz_tm" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and clz_tp_cd in ('F'," ).append("\n"); 
		query.append("'O')" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("RAIL_RCV_COFF_FM_DT IS NOT NULL AND RAIL_RCV_COFF_TO_DT IS NOT NULL" ).append("\n"); 

	}
}