/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoManageDBDAOmodifyIfDMTOtherUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WebDoManageDBDAOmodifyIfDMTOtherUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMDT_TRF_CD 가 DMIF 외 일 경우 update
	  * </pre>
	  */
	public WebDoManageDBDAOmodifyIfDMTOtherUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("web_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("web_ntfy_pic_telcm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("web_ntfy_pic_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.integration").append("\n"); 
		query.append("FileName : WebDoManageDBDAOmodifyIfDMTOtherUSQL").append("\n"); 
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
		query.append("UPDATE  DMT_CHG_CALC" ).append("\n"); 
		query.append("SET     TO_MVMT_STS_CD = 'DR'," ).append("\n"); 
		query.append("        TO_MVMT_DT = TO_DATE(@[to_mvmt_dt], 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        TO_MVMT_YD_CD = FM_MVMT_YD_CD," ).append("\n"); 
		query.append("        WEB_IND_FLG = 'Y'," ).append("\n"); 
		query.append("        WEB_CRE_USR_ID = @[web_cre_usr_id]," ).append("\n"); 
		query.append("		WEB_CRE_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(OFC_CD)," ).append("\n"); 
		query.append("        WEB_NTFY_PIC_NM = @[web_ntfy_pic_nm]," ).append("\n"); 
		query.append("        WEB_NTFY_PIC_TELCM_NO = @[web_ntfy_pic_telcm_no]" ).append("\n"); 
		query.append("WHERE   CNTR_NO = @[cntr_no] " ).append("\n"); 
		query.append("AND     CNTR_CYC_NO = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     CHG_SEQ = @[chg_seq]" ).append("\n"); 
		query.append("AND     SYS_AREA_GRP_ID = 'USA'" ).append("\n"); 

	}
}