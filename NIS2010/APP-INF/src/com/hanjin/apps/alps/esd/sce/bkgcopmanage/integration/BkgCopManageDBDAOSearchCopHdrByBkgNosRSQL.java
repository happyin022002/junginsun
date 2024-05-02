/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchCopHdrByBkgNosRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.15
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.15 김인수
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

public class BkgCopManageDBDAOSearchCopHdrByBkgNosRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 복수개의 Booking no 로 cancel 되지 않은 COP 를 찾는다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchCopHdrByBkgNosRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchCopHdrByBkgNosRSQL").append("\n"); 
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
		query.append("SELECT 	COP_UPD_RMK," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("COP_STS_CD," ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("MST_COP_NO," ).append("\n"); 
		query.append("TO_CHAR(COP_FSH_DT, 'YYYYMMDDHH24MISS') AS COP_FSH_DT," ).append("\n"); 
		query.append("TRNK_VSL_CD," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("POR_NOD_CD," ).append("\n"); 
		query.append("POL_NOD_CD," ).append("\n"); 
		query.append("POD_NOD_CD," ).append("\n"); 
		query.append("DEL_NOD_CD," ).append("\n"); 
		query.append("COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("IB_TRO_FLG," ).append("\n"); 
		query.append("OB_TRO_FLG," ).append("\n"); 
		query.append("RAIL_RCV_COFF_DT_SRC_TP_CD," ).append("\n"); 
		query.append("TO_CHAR(RAIL_RCV_COFF_FM_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_FM_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT," ).append("\n"); 
		query.append("TO_CHAR(RAIL_RCV_COFF_TO_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_TO_DT," ).append("\n"); 
		query.append("COP_SUB_STS_CD," ).append("\n"); 
		query.append("UMCH_STS_CD," ).append("\n"); 
		query.append("PROV_CNTR_NO," ).append("\n"); 
		query.append("PROV_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("TO_CHAR(CFM_OB_DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS CFM_OB_DOR_ARR_DT," ).append("\n"); 
		query.append("TO_CHAR(CFM_APNT_DT, 'YYYYMMDDHH24MISS') AS CFM_APNT_DT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${bkg_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("('$ele')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$ele')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND COP_STS_CD != 'X'" ).append("\n"); 

	}
}