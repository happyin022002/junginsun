/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchCopByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.10.05 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchCopByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking no 로 cancel 되지 않은 cop 를 찾는다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchCopByBkgNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchCopByBkgNoRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("COP_STS_CD," ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("MST_COP_NO," ).append("\n"); 
		query.append("COP_FSH_DT," ).append("\n"); 
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
		query.append("RAIL_RCV_COFF_FM_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("sce_cop_hdr" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${cntr_no} != null)" ).append("\n"); 
		query.append("and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and cop_sts_cd != 'X'" ).append("\n"); 

	}
}