/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReplanManageDBDAOSearchPartialCopsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchPartialCopsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container no 를 대상으로 partial 관계로 엮인 COP 들을 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchPartialCopsRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchPartialCopsRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	COP_UPD_RMK, " ).append("\n"); 
		query.append("	COP_NO, " ).append("\n"); 
		query.append("	BKG_NO, " ).append("\n"); 
		query.append("	CNTR_NO, " ).append("\n"); 
		query.append("	CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("	CNMV_YR, " ).append("\n"); 
		query.append("	COP_STS_CD, " ).append("\n"); 
		query.append("	PCTL_NO, " ).append("\n"); 
		query.append("	DECODE(COP_STS_CD, 'X', 'N/A', MST_COP_NO) AS MST_COP_NO," ).append("\n"); 
		query.append("	TO_CHAR(COP_FSH_DT, 'YYYYMMDDHH24MISS') AS COP_FSH_DT, " ).append("\n"); 
		query.append("	TRNK_VSL_CD, " ).append("\n"); 
		query.append("	TRNK_SKD_VOY_NO, " ).append("\n"); 
		query.append("	TRNK_SKD_DIR_CD, " ).append("\n"); 
		query.append("	POR_NOD_CD, " ).append("\n"); 
		query.append("	POL_NOD_CD, " ).append("\n"); 
		query.append("	POD_NOD_CD, " ).append("\n"); 
		query.append("	DEL_NOD_CD, " ).append("\n"); 
		query.append("	COP_RAIL_CHK_CD, " ).append("\n"); 
		query.append("	IB_TRO_FLG, " ).append("\n"); 
		query.append("	OB_TRO_FLG, " ).append("\n"); 
		query.append("	RAIL_RCV_COFF_DT_SRC_TP_CD, " ).append("\n"); 
		query.append("	TO_CHAR(RAIL_RCV_COFF_FM_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_FM_DT, " ).append("\n"); 
		query.append("	CRE_USR_ID, " ).append("\n"); 
		query.append("	TO_CHAR(CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT, " ).append("\n"); 
		query.append("	UPD_USR_ID, " ).append("\n"); 
		query.append("	TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT, " ).append("\n"); 
		query.append("	TO_CHAR(RAIL_RCV_COFF_TO_DT, 'YYYYMMDDHH24MISS') AS RAIL_RCV_COFF_TO_DT, " ).append("\n"); 
		query.append("	COP_SUB_STS_CD, " ).append("\n"); 
		query.append("	UMCH_STS_CD, " ).append("\n"); 
		query.append("	PROV_CNTR_NO, " ).append("\n"); 
		query.append("	PROV_CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("	TO_CHAR(CFM_OB_DOR_ARR_DT, 'YYYYMMDDHH24MISS') AS CFM_OB_DOR_ARR_DT, " ).append("\n"); 
		query.append("	TO_CHAR(CFM_APNT_DT, 'YYYYMMDDHH24MISS') AS CFM_APNT_DT" ).append("\n"); 
		query.append("from 	sce_cop_hdr" ).append("\n"); 
		query.append("where  (cntr_no" ).append("\n"); 
		query.append("	,	trnk_vsl_cd" ).append("\n"); 
		query.append("	,	trnk_skd_voy_no" ).append("\n"); 
		query.append("	,	trnk_skd_dir_cd" ).append("\n"); 
		query.append("	,	POL_NOD_CD" ).append("\n"); 
		query.append("	,	POD_NOD_CD" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("		IN " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("    select cntr_no" ).append("\n"); 
		query.append("	,	trnk_vsl_cd" ).append("\n"); 
		query.append("	,	trnk_skd_voy_no" ).append("\n"); 
		query.append("	,	trnk_skd_dir_cd" ).append("\n"); 
		query.append("	,	POL_NOD_CD" ).append("\n"); 
		query.append("	,	POD_NOD_CD" ).append("\n"); 
		query.append("    from sce_cop_hdr" ).append("\n"); 
		query.append("    where bkg_no = @[bkg_no] and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("#if (${sts_flg} == 'C')  " ).append("\n"); 
		query.append("		and cop_sts_cd in ('C'," ).append("\n"); 
		query.append("          'T') " ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'F')" ).append("\n"); 
		query.append("		and cop_sts_cd = 'F'" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'A')" ).append("\n"); 
		query.append("		and cop_sts_cd in ('C', 'T', 'F')" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'X')" ).append("\n"); 
		query.append("		and cop_sts_cd = 'X'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sts_flg} == 'C' or ${sts_flg} == 'X')  " ).append("\n"); 
		query.append("		and cop_sts_cd in ('C'," ).append("\n"); 
		query.append("          'T') " ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'F')" ).append("\n"); 
		query.append("		and cop_sts_cd = 'F'" ).append("\n"); 
		query.append("#elseif (${sts_flg} == 'A')" ).append("\n"); 
		query.append("		and cop_sts_cd in ('C', 'T', 'F')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}