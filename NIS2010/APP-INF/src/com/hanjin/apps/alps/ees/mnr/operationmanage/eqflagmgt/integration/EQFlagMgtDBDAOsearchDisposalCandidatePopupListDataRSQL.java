/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchDisposalCandidatePopupListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.08
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.08 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchDisposalCandidatePopupListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalCandidatePopupListData
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchDisposalCandidatePopupListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchDisposalCandidatePopupListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("   B.EQ_NO" ).append("\n"); 
		query.append(",  B.EQ_TYPE EQ_KND_CD" ).append("\n"); 
		query.append(",  B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",  A.MNR_DMG_FLG" ).append("\n"); 
		query.append(",  B.MST_DMG_FLAG" ).append("\n"); 
		query.append(",  A.MNR_DMG_FLG" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG" ).append("\n"); 
		query.append(",  DECODE(A.MNR_DISP_SEL_FLG,'Y','1','0') AS MNR_DISP_SEL_FLG" ).append("\n"); 
		query.append(",  NVL(A.DISP_RSN_CD,'C') AS DISP_RSN_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_RCK_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",  A.HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append(",  A.MNR_DMG_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG_DT" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG_DT" ).append("\n"); 
		query.append(",  DECODE(A.MNR_DISP_SEL_FLG,'Y',TO_CHAR(A.MNR_DISP_SEL_FLG_DT,'YYYY-MM-DD')) AS MNR_DISP_SEL_FLG_DT" ).append("\n"); 
		query.append(",  B.CRNT_YD_CD MNR_DMG_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_HNGR_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DONA_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_SCRP_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_RPR_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_TTL_LSS_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DISP_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_DISP_SEL_FLG_YD_CD" ).append("\n"); 
		query.append(",  A.MNR_STS_RMK" ).append("\n"); 
		query.append(",  A.CRE_USR_ID" ).append("\n"); 
		query.append(",  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, @[cost_ofc_cd]), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",  A.UPD_USR_ID" ).append("\n"); 
		query.append(",  TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append(",  B.LSTM_CD" ).append("\n"); 
		query.append(",  MNR_COMMON_PKG.MNR_CAL_DV_FNC(B.EQ_TYPE, B.EQ_NO, replace(TO_CHAR(SYSDATE,'YYYY-MM-DD'),'-',''))  DV_VALUE" ).append("\n"); 
		query.append(",  B.MVMT_CD" ).append("\n"); 
		query.append(",  B.MTRL_CD " ).append("\n"); 
		query.append(",  B.MTRL_NM" ).append("\n"); 
		query.append(",  B.MKR_NM AS EQ_MKR_NM" ).append("\n"); 
		query.append(",  B.MDL_NM AS EQ_MDL_NM" ).append("\n"); 
		query.append(",  A.RPR_COST_AMT" ).append("\n"); 
		query.append(",  B.MVMT_DT" ).append("\n"); 
		query.append(",  TRUNC((SYSDATE - TO_DATE(B.MVMT_DT,'yyyy-mm-dd')),0) SDAYS_DT" ).append("\n"); 
		query.append(",  B.BKG_NO" ).append("\n"); 
		query.append(",  B.MANU_DT" ).append("\n"); 
		query.append("FROM MNR_EQ_STS A, MNR_EQ_STS_V B" ).append("\n"); 
		query.append("WHERE	B.EQ_NO = A.EQ_NO(+)" ).append("\n"); 
		query.append("AND     SUBSTR(B.CRNT_YD_CD,0,5) = SUBSTR(@[location_cd],0,5)" ).append("\n"); 
		query.append("AND     A.MNR_DISP_SEL_FLG = 'Y'" ).append("\n"); 
		query.append("AND     B.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND 	NOT EXISTS (" ).append("\n"); 
		query.append("    		SELECT MDD.EQ_NO " ).append("\n"); 
		query.append("    			FROM MNR_DISP_DTL MDD,MNR_DISP_HDR MDH" ).append("\n"); 
		query.append("    		WHERE MDD.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("			AND MDD.DISP_NO = MDH.DISP_NO" ).append("\n"); 
		query.append("			AND MDH.DISP_STS_CD <> 'HD'" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}