/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDSPBuyerDTLPartDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDSPBuyerDTLPartDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDSPBuyerDTLPartData
	  * ------------------------------------------------------------------------------------------------------------------------------------------
	  *  [CHM-201432978] MNR-Disposal-Disposal Request 및 SPP  EQ Bidding 시에 Bidding Time간의 로직 수정 요청 으로 인한 수정
	  * 쿼리에서 더이상 @[rqst_ofc_cd]를 사용하지 않음
	  *  VNDR_BID_TMS를 가져오는 function : GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELOPB',A.VNDR_BID_TMS,@[rqst_ofc_cd])
	  * 에서 제1param은 From Office, 제3param은 To Office이지만 해당쿼리를 SELOPB에서 검색할 경우엔
	  * 1param과 3param이 모두 SELOPB되어 쿼리의 의도와 맞지않고 시차에 따라 Bidding 허용시간을 오버한 Bidd time으로
	  * 보이는 오류도 발생함.
	  * 이에 3param을 rqst_ofc_cd -> MNR_PARTNER.CTRL_OFC_CD로 변경함
	  * 2015.01.19 Chang Young Kim
	  * ------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDSPBuyerDTLPartDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDSPBuyerDTLPartDataRSQL").append("\n"); 
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
		query.append("         A.DISP_NO" ).append("\n"); 
		query.append("        ,A.DISP_DTL_SEQ" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("		,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,DECODE(C.DISP_UT_TP_CD,'E','1',A.DISP_QTY) DISP_QTY" ).append("\n"); 
		query.append("		,DECODE(C.DISP_UT_TP_CD,'E','1',A.DISP_CFM_QTY) DISP_CFM_QTY" ).append("\n"); 
		query.append("        ,A.PART_UT_AMT" ).append("\n"); 
		query.append("        ,DECODE(NVL(A.MNR_DISP_CFM_STS_CD,'N'),'N','0','1') AS MNR_DISP_CFM_STS_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.MNR_DISP_CFM_DT, 'yyyy-mm-dd') MNR_DISP_CFM_DT" ).append("\n"); 
		query.append("        ,A.MNR_DISP_CFM_USR_ID" ).append("\n"); 
		query.append("        ,A.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("        ,MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.MNR_PRNR_SEQ,A.MNR_PRNR_CNT_CD) AS MNR_PRNR_ID" ).append("\n"); 
		query.append("        ,B.MNR_PRNR_LGL_ENG_NM AS VNDR_LGL_ENG_NM  " ).append("\n"); 
		query.append("		,C.DISP_UT_TP_CD " ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' AND ROWNUM = 1 ), A.VNDR_BID_TMS, B.CTRL_OFC_CD),'YYYY-MM-DD HH24:MI:SS')||' '||TO_CHAR(A.VNDR_BID_TMS, 'FF3') AS VNDR_BID_TMS" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_DTL_PART A,MNR_PARTNER B,MNR_DISP_DTL C" ).append("\n"); 
		query.append("WHERE A.DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("AND B.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("AND A.MNR_PRNR_SEQ  = B.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND A.MNR_PRNR_CNT_CD = B.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND A.DISP_NO = C.DISP_NO" ).append("\n"); 
		query.append("AND A.DISP_DTL_SEQ = C.DISP_DTL_SEQ" ).append("\n"); 
		query.append("ORDER BY A.PART_UT_AMT DESC" ).append("\n"); 

	}
}