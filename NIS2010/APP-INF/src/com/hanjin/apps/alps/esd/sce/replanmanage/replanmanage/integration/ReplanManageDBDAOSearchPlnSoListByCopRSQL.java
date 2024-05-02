/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageDBDAOSearchPlnSoListByCopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.30 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchPlnSoListByCopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP NO 로 SCE_PLN_SO_LIST 를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchPlnSoListByCopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchPlnSoListByCopRSQL").append("\n"); 
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
		query.append("SELECT 	COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("COST_ACT_GRP_CD," ).append("\n"); 
		query.append("CTRL_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(N1ST_NOD_PLN_DT, 'YYYYMMDDHH24MISS') AS N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("N1ST_NOD_CD," ).append("\n"); 
		query.append("N2ND_NOD_CD," ).append("\n"); 
		query.append("N3RD_NOD_CD," ).append("\n"); 
		query.append("N4TH_NOD_CD," ).append("\n"); 
		query.append("PCTL_IO_BND_CD," ).append("\n"); 
		query.append("PCTL_COST_MOD_CD," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD," ).append("\n"); 
		query.append("TRNS_RQST_OFC_CD," ).append("\n"); 
		query.append("TRNS_RQST_USR_ID," ).append("\n"); 
		query.append("TRNS_RQST_RSN," ).append("\n"); 
		query.append("TRSP_MOD_CD," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT," ).append("\n"); 
		query.append("DELT_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(DELT_DT, 'YYYYMMDDHH24MISS') AS DELT_DT," ).append("\n"); 
		query.append("TO_CHAR(DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS DOR_ARR_DT," ).append("\n"); 
		query.append("TO_CHAR(LST_NOD_PLN_DT, 'YYYYMMDDHH24MISS') AS LST_NOD_PLN_DT" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("sce_pln_so_list" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("cop_no = @[cop_no]" ).append("\n"); 

	}
}