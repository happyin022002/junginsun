/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MisUseApprovalDBDAOMisUseReqContainerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MisUseApprovalDBDAOMisUseReqContainerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 CNTR에 대한 기본정보를 조회한다.
	  * LT일때 Per-Diem LCC로 변경
	  * </pre>
	  */
	public MisUseApprovalDBDAOMisUseReqContainerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.integration").append("\n"); 
		query.append("FileName : MisUseApprovalDBDAOMisUseReqContainerInfoRSQL").append("\n"); 
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
		query.append("SELECT  A.CNTR_NO" ).append("\n"); 
		query.append("         , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("         , A.AGMT_SEQ" ).append("\n"); 
		query.append("         , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , A.LSTM_CD " ).append("\n"); 
		query.append("         , TO_CHAR(A.CNMV_DT,'YYYYMMDD') AS CNMV_DT" ).append("\n"); 
		query.append("         , A.CRNT_YD_CD" ).append("\n"); 
		query.append("         , A.CNMV_STS_CD AS MVMT_STS_CD" ).append("\n"); 
		query.append("         , D.POD_CD, D.POL_CD" ).append("\n"); 
		query.append("--        , MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, 'PDM', A.CNTR_TPSZ_CD, A.ONH_YD_CD) AS PDM_AMT" ).append("\n"); 
		query.append("          , DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y',MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, 'PDM', A.CNTR_TPSZ_CD, A.ONH_YD_CD) " ).append("\n"); 
		query.append(" 				,'N','') AS PDM_AMT" ).append("\n"); 
		query.append("         , NVL(B.CNTR_LFT_CHG_AMT,0) AS LON_AMT           " ).append("\n"); 
		query.append("FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("        MST_CNTR_STS_HIS B, " ).append("\n"); 
		query.append("        LSE_AGREEMENT C," ).append("\n"); 
		query.append("		BKG_BOOKING D" ).append("\n"); 
		query.append("WHERE   A.CNTR_NO = B.CNTR_NO " ).append("\n"); 
		query.append("AND     A.LST_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("AND		B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     B.AGMT_SEQ = C.AGMT_SEQ  " ).append("\n"); 
		query.append("AND     A.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("AND     A.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}