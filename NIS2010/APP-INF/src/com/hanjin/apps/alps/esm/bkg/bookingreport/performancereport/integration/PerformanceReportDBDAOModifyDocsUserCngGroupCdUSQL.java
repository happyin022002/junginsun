/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyDocsUserCngGroupCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifyDocsUserCngGroupCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOModifyDocsUserCngGroupCdUSQL.Query
	  * 
	  * 2011.11.17 정선용 [CHM-201114554] DPCS-Correction 기능 보완 요청
	  *                            Minor : YYNN, Input/Rate/I&R에 FAX N으로 Flag 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyDocsUserCngGroupCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("change_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyDocsUserCngGroupCdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_CRNT_RQST " ).append("\n"); 
		query.append("SET  SR_WRK_STS_USR_ID = @[change_usr_id] " ).append("\n"); 
		query.append("   , PIC_CNG_USR_ID = @[change_usr_id] " ).append("\n"); 
		query.append("   , RTN_FM_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#if(${ui_grp_cd} !='' && ${ui_grp_cd} =='A')" ).append("\n"); 
		query.append(", BL_DOC_INP_FLG ='Y',BL_RT_FLG ='Y',BL_AUD_FLG ='N', BL_DRFT_FAX_OUT_FLG='N'" ).append("\n"); 
		query.append("#elseif(${ui_grp_cd} !='' && ${ui_grp_cd} =='I')" ).append("\n"); 
		query.append(", BL_DOC_INP_FLG ='N',BL_RT_FLG ='N',BL_AUD_FLG ='N', BL_DRFT_FAX_OUT_FLG='N'" ).append("\n"); 
		query.append("#elseif(${ui_grp_cd} !='' && ${ui_grp_cd} =='R')" ).append("\n"); 
		query.append(", BL_DOC_INP_FLG ='Y',BL_RT_FLG ='N',BL_AUD_FLG ='N', BL_DRFT_FAX_OUT_FLG='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE SR_KND_CD   = @[src_cd] " ).append("\n"); 
		query.append("AND SR_NO         = @[sr_no]    " ).append("\n"); 
		query.append("AND BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND SR_KND_CD 	  = @[src_cd]" ).append("\n"); 
		query.append("AND SR_AMD_TP_CD  = 'R'" ).append("\n"); 

	}
}