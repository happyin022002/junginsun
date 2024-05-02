/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchPartialCopsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.18 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchPartialCopsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container no 를 대상으로 partial 관계로 엮인 COP 들을 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchPartialCopsRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchPartialCopsRSQL").append("\n"); 
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
		query.append("TO_CHAR(COP_FSH_DT,  'YYYYMMDDHH24MISS') AS COP_FSH_DT," ).append("\n"); 
		query.append("TRNK_VSL_CD," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("POR_NOD_CD," ).append("\n"); 
		query.append("POL_NOD_CD," ).append("\n"); 
		query.append("POD_NOD_CD," ).append("\n"); 
		query.append("DEL_NOD_CD," ).append("\n"); 
		query.append("COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("IB_TRO_FLG," ).append("\n"); 
		query.append("OB_TRO_FLG" ).append("\n"); 
		query.append("from sce_cop_hdr" ).append("\n"); 
		query.append("where (cntr_no," ).append("\n"); 
		query.append("trnk_vsl_cd," ).append("\n"); 
		query.append("trnk_skd_voy_no," ).append("\n"); 
		query.append("trnk_skd_dir_cd) in (" ).append("\n"); 
		query.append("select cntr_no," ).append("\n"); 
		query.append("trnk_vsl_cd," ).append("\n"); 
		query.append("trnk_skd_voy_no," ).append("\n"); 
		query.append("trnk_skd_dir_cd" ).append("\n"); 
		query.append("from sce_cop_hdr" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no] and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("#if (${sts_flg} == 'C')" ).append("\n"); 
		query.append("and cop_sts_cd in ('C'," ).append("\n"); 
		query.append("'T')" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'F')" ).append("\n"); 
		query.append("and cop_sts_cd = 'F'" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'A')" ).append("\n"); 
		query.append("and cop_sts_cd in ('C', 'T', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}