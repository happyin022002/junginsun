/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MisUseApprovalDBDAOMisUseReqContainerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.16
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2010.12.16 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
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
	  * 2010.12.09 정윤태 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.integration").append("\n"); 
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
		query.append("SELECT  A.CNTR_NO, A.AGMT_CTY_CD, A.AGMT_SEQ, A.CNTR_TPSZ_CD, A.LSTM_CD, " ).append("\n"); 
		query.append("        TO_CHAR(A.CNMV_DT,'YYYYMMDD') AS CNMV_DT, A.CRNT_YD_CD," ).append("\n"); 
		query.append("		A.CNMV_STS_CD AS MVMT_STS_CD, D.POD_CD, D.POL_CD," ).append("\n"); 
		query.append("        NVL((SELECT  NVL(RT.N1ST_CHG_AMT, 0)" ).append("\n"); 
		query.append("        	 FROM    LSE_AGMT_RT RT" ).append("\n"); 
		query.append("        	 WHERE   RT.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("        	 AND     RT.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("        	 AND 	 RT.LOC_CD = DECODE(A.LSTM_CD, 'LT', B.LCC_CD, 'KRSEL')" ).append("\n"); 
		query.append("        	 AND     RT.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        	 AND     RT.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("        	 AND     RT.AGMT_CHG_VAL = 1), 0) AS PDM_AMT," ).append("\n"); 
		query.append("        NVL(B.CNTR_LFT_CHG_AMT,0) AS LON_AMT        " ).append("\n"); 
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