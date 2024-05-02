/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalSoldDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.11.16 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalSoldDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Disposal Sold Creation 의 Detail 조회
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalSoldDetailDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selected_disp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalSoldDetailDataRSQL").append("\n"); 
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
		query.append("SELECT A.DISP_TP_CD" ).append("\n"); 
		query.append(", (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00035' AND MNR_CD_ID = A.DISP_TP_CD )  AS DISP_TP_NM" ).append("\n"); 
		query.append(", B.EQ_NO" ).append("\n"); 
		query.append(", B.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", B.PART_AMT" ).append("\n"); 
		query.append(", B.DISP_RLSE_NO" ).append("\n"); 
		query.append(", TO_CHAR(B.DISP_SOLD_DT,'YYYY-MM-DD') DISP_SOLD_DT" ).append("\n"); 
		query.append(", B.DISP_YD_CD" ).append("\n"); 
		query.append(", B.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append(", B.DISP_NO" ).append("\n"); 
		query.append(", B.DISP_QTY" ).append("\n"); 
		query.append(", B.DISP_DTL_SEQ" ).append("\n"); 
		query.append(", B.DISP_UT_TP_CD" ).append("\n"); 
		query.append(", B.DISP_TRKR_NM" ).append("\n"); 
		query.append(", B.DISP_UT_PRC" ).append("\n"); 
		query.append(", B.DISP_RSN_CD" ).append("\n"); 
		query.append(", B.PART_AMT" ).append("\n"); 
		query.append(", B.INV_AMT" ).append("\n"); 
		query.append(", B.FILE_SEQ" ).append("\n"); 
		query.append(", B.INV_NO" ).append("\n"); 
		query.append(", B.RCV_INV_SEQ" ).append("\n"); 
		query.append(", B.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(", B.MNR_PRNR_SEQ" ).append("\n"); 
		query.append(", B.CRE_USR_ID" ).append("\n"); 
		query.append(", B.CRE_DT" ).append("\n"); 
		query.append(", DECODE(B.DISP_SOLD_DT,'','D','E') DISP_SOLD_DT_FLG" ).append("\n"); 
		query.append(", A.EQ_KND_CD" ).append("\n"); 
		query.append(", DECODE(B.EQ_NO,'','N',DECODE(B.DISP_RLSE_NO,'','Y','N')) DISP_RLSE_NO_FLG" ).append("\n"); 
		query.append(", B.EQ_NO  AS OLD_EQ_NO" ).append("\n"); 
		query.append(", B.EQ_TPSZ_CD  AS OLD_EQ_TPSZ_CD" ).append("\n"); 
		query.append(", B.DISP_YD_CD  AS OLD_EQ_DISP_YD_CD" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A" ).append("\n"); 
		query.append(", MNR_DISP_DTL B" ).append("\n"); 
		query.append("WHERE A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("AND A.DISP_NO = @[selected_disp_no]" ).append("\n"); 

	}
}