/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOsearchMovementHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOsearchMovementHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerMovementFinderDBDAO
	  * 컨테이너의 이동정보 상세 내역을 얻어온다
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOsearchMovementHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOsearchMovementHistoryRSQL").append("\n"); 
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
		query.append("SELECT CTM.CNMV_CYC_NO," ).append("\n"); 
		query.append("       CTM.CNMV_CO_CD," ).append("\n"); 
		query.append("       CTM.MVMT_STS_CD," ).append("\n"); 
		query.append("       CTM.MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("       CTM.ORG_YD_CD," ).append("\n"); 
		query.append("       CTM.DEST_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR (CTM.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') CNMV_EVNT_DT," ).append("\n"); 
		query.append("       CTM.FCNTR_FLG," ).append("\n"); 
		query.append("       CTM.OB_CNTR_FLG," ).append("\n"); 
		query.append("       CTM.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("       CTM.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       CTM.CNTR_DMG_FLG," ).append("\n"); 
		query.append("       CTM.CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("       CTM.CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("       CTM.CNTR_DISP_FLG," ).append("\n"); 
		query.append("       CTM.IMDT_EXT_FLG," ).append("\n"); 
		query.append("       CTM.CNTR_RFUB_FLG," ).append("\n"); 
		query.append("       CTM.CNTR_XCH_CD," ).append("\n"); 
		query.append("       CTM.SPCL_CGO_FLG," ).append("\n"); 
		query.append("       CTM.VNDR_SEQ," ).append("\n"); 
		query.append("       CTM.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("       CTM.CHSS_NO," ).append("\n"); 
		query.append("       CTM.MGST_NO," ).append("\n"); 
		query.append("       CTM.CNTR_SEAL_NO," ).append("\n"); 
		query.append("       CTM.WBL_NO," ).append("\n"); 
		query.append("       CTM.PKUP_NO," ).append("\n"); 
		query.append("       TO_CHAR (CTM.UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI') UPD_LOCL_DT," ).append("\n"); 
		query.append("       TO_CHAR (CTM.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') CRE_LOCL_DT," ).append("\n"); 
		query.append("       CTM.OFC_CD," ).append("\n"); 
		query.append("       CTM.USR_NM," ).append("\n"); 
		query.append("       CTM.CNMV_RMK" ).append("\n"); 
		query.append("       , CTM.USA_EDI_CD" ).append("\n"); 
		query.append("       , MSG.CNTR_STWG_PSN_CTNT" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT CTM," ).append("\n"); 
		query.append("       CTM_MVMT_EDI_MSG MSG" ).append("\n"); 
		query.append(" WHERE CTM.CNTR_NO = @[p_cntrno]||@[check_digit]" ).append("\n"); 
		query.append("   AND CTM.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("   AND CTM.MVMT_EDI_TP_CD = MSG.MVMT_EDI_TP_CD(+)" ).append("\n"); 
		query.append("   AND CTM.MVMT_EDI_MSG_TP_ID = MSG.MVMT_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("   AND CTM.MVMT_EDI_MSG_AREA_CD = MSG.MVMT_EDI_MSG_AREA_CD(+)" ).append("\n"); 
		query.append("   AND CTM.MVMT_EDI_MSG_YRMONDY = MSG.MVMT_EDI_MSG_YRMONDY(+)" ).append("\n"); 
		query.append("   AND CTM.MVMT_EDI_MSG_SEQ = MSG.MVMT_EDI_MSG_SEQ(+)" ).append("\n"); 

	}
}