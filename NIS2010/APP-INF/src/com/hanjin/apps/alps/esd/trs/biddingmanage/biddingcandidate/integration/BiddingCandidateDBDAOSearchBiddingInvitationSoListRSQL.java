/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateDBDAOSearchBiddingInvitationSoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.11.03 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BiddingCandidateDBDAOSearchBiddingInvitationSoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bidding Invitation 보내야 할  S/O정보 조회
	  * </pre>
	  */
	public BiddingCandidateDBDAOSearchBiddingInvitationSoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration").append("\n"); 
		query.append("FileName : BiddingCandidateDBDAOSearchBiddingInvitationSoListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM SEQ" ).append("\n"); 
		query.append("      ,A.SPOT_BID_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(A.SPOT_BID_DUE_DT,'YYYY-MM-DD HH24:MI') SPOT_BID_DUE_DT" ).append("\n"); 
		query.append("      ,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.FM_NOD_CD) FM_NOD_NM" ).append("\n"); 
		query.append("      ,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.VIA_NOD_CD) VIA_NOD_NM" ).append("\n"); 
		query.append("      ,(SELECT ZN_NM FROM MDM_ZONE WHERE ZN_CD = A.DOR_NOD_CD ) DOR_NOD_NM" ).append("\n"); 
		query.append("      ,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.TO_NOD_CD ) TO_NOD_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(A.N1ST_NOD_PLN_DT,'YYYYMMDD HH24:MI:SS') FM_DEPT_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.LST_NOD_PLN_DT,'YYYYMMDD HH24:MI:SS') TO_ARVL_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(A.CONTI_CD,'E',A.DOR_ARR_DT,A.DOR_NOD_PLN_DT),'YYYYMMDD HH24:MI:SS') DOR_ARVL_DT" ).append("\n"); 
		query.append("      ,A.EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,(SELECT REPLACE(REPLACE(CNTR_SZ_DESC,'CONTAINER',''),'STANDARD','')FROM MDM_CNTR_SZ WHERE CNTR_SZ_CD= SUBSTR(A.EQ_TPSZ_CD,2,1)) " ).append("\n"); 
		query.append("       ||(SELECT CNTR_TP_DESC FROM MDM_CNTR_TP WHERE CNTR_TP_CD = SUBSTR(A.EQ_TPSZ_CD,1,1))" ).append("\n"); 
		query.append("         AS EQ_TPSZ_NM" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD00748'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT =A.CGO_TP_CD) CGO_TP_NM" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01956'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = A.SPCL_CGO_CNTR_TP_CD) SPCL_CGO_CNTR_TP_NM" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD00794'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = A.TRSP_CRR_MOD_CD ) TRSP_CRR_MOD_NM" ).append("\n"); 
		query.append("      ,A.CNTR_KGS_WGT" ).append("\n"); 
		query.append("      ,A.CNTR_LBS_WGT" ).append("\n"); 
		query.append("      ,B.OVR_FWRD_LEN" ).append("\n"); 
		query.append("      ,B.OVR_BKWD_LEN" ).append("\n"); 
		query.append("      ,B.OVR_HGT" ).append("\n"); 
		query.append("      ,B.OVR_LF_LEN" ).append("\n"); 
		query.append("      ,B.OVR_RT_LEN" ).append("\n"); 
		query.append("      ,A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("      ,A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("      ,BKG_AWK_CGO B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND A.EQ_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND A.SPOT_BID_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if ($arr_so_no.size() > 0)" ).append("\n"); 
		query.append("	AND (A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_so_no}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			(SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	    	,(SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)  " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}