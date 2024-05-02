/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetBkgVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.13 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetBkgVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 부킹 컨테이너 등에서 vvd 체크를 위한 자료 얻기
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetBkgVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetBkgVVDRSQL").append("\n"); 
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
		query.append("SELECT CO.CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("       DECODE (CO.CNTR_HNGR_RCK_CD, NULL, 'N', 'Y') CNTR_HNGR_RCK_CD, CO.ACIAC_DIV_CD," ).append("\n"); 
		query.append("       CO.RFUB_FLG, CO.DISP_FLG, CO.IMDT_EXT_FLG, CO.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CO.AGMT_CTY_CD, CO.AGMT_SEQ, CO.DMG_FLG, CM.CNMV_LVL_NO, CM.FCNTR_FLG," ).append("\n"); 
		query.append("       BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("#if (${osca_bkg_flg} == 'Y')" ).append("\n"); 
		query.append("  FROM MST_CONTAINER CO, CTM_MVMT_SEQ CM, CTM_BKG_VVD BV" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM MST_CONTAINER CO, CTM_MVMT_SEQ CM, BKG_VVD BV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE CO.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CM.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("   AND CM.MVMT_STS_CD = @[mvmt_sts_cd]" ).append("\n"); 
		query.append("   AND BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BV.VSL_CD = @[crnt_vsl_cd]" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO = @[crnt_skd_voy_no]" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD = @[crnt_skd_dir_cd]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}