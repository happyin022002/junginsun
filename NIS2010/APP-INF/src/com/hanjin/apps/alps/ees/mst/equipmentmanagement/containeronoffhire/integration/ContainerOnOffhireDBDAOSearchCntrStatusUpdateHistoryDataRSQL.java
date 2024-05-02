/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.12
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.11.12 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrStatusUpdateHistoryData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_dgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("(SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append("FROM MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${noExit} == 'A')" ).append("\n"); 
		query.append("#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("AND  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_dgt} != '')" ).append("\n"); 
		query.append("AND   CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${noExit} == 'E')" ).append("\n"); 
		query.append("#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("AND  CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_dgt} != '')" ).append("\n"); 
		query.append("AND   CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CNMV_DT = (" ).append("\n"); 
		query.append("SELECT MAX(CNMV_DT)" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${noExit} == 'A')" ).append("\n"); 
		query.append("#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("AND  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_dgt} != '')" ).append("\n"); 
		query.append("AND   CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${noExit} == 'E')" ).append("\n"); 
		query.append("#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("AND  CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_dgt} != '')" ).append("\n"); 
		query.append("AND   CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CNTR_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYY-MM-DD') CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append(",A.YD_CD" ).append("\n"); 
		query.append(",A.AGMT_CTY_CD" ).append("\n"); 
		query.append(",A.AGMT_SEQ" ).append("\n"); 
		query.append(",B.LSTM_CD" ).append("\n"); 
		query.append(",B.REF_NO," ).append("\n"); 
		query.append("CASE WHEN A.CNTR_STS_CD IN ('SLD')" ).append("\n"); 
		query.append("THEN DECODE(NVL(A.CUST_CNT_CD,'0'), '0', '', A.CUST_CNT_CD||A.CUST_SEQ)" ).append("\n"); 
		query.append("ELSE TO_CHAR(B.VNDR_SEQ) END VNDR_SEQ," ).append("\n"); 
		query.append("CASE WHEN A.CNTR_STS_CD IN ('SLD')" ).append("\n"); 
		query.append("THEN DECODE(NVL(A.CUST_CNT_CD,'0'), '0', A.CUST_NM, (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.CUST_CNT_CD AND CUST_SEQ = A.CUST_SEQ))" ).append("\n"); 
		query.append("ELSE C.VNDR_LGL_ENG_NM END VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.DIR_ITCHG_VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.DIR_ITCHG_VNDR_SEQ) DIR_VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.OFC_CD" ).append("\n"); 
		query.append(",A.CNTR_OLD_VAN_FLG" ).append("\n"); 
		query.append(",CASE WHEN A.CNTR_PKUP_CHG_AMT > 0 THEN" ).append("\n"); 
		query.append("A.CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append("ELSE  0 END CNTR_PKUP_CHG_AMT" ).append("\n"); 
		query.append(",CASE WHEN A.CNTR_PKUP_CHG_AMT < 0 THEN" ).append("\n"); 
		query.append("A.CNTR_PKUP_CHG_AMT * (-1)" ).append("\n"); 
		query.append("ELSE 0 END CNTR_PKUP_CR_CHG_AMT" ).append("\n"); 
		query.append(",A.CNTR_MIN_ONH_DYS" ).append("\n"); 
		query.append(",A.RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append(",A.CNTR_DIR_ITCHG_FEE_AMT" ).append("\n"); 
		query.append(",CASE WHEN A.CNTR_DRFF_CR_AMT > 0 THEN" ).append("\n"); 
		query.append("A.CNTR_DRFF_CR_AMT" ).append("\n"); 
		query.append("ELSE  0 END CNTR_DRFF_AMT" ).append("\n"); 
		query.append(",CASE WHEN A.CNTR_DRFF_CR_AMT < 0 THEN" ).append("\n"); 
		query.append("A.CNTR_DRFF_CR_AMT * (-1)" ).append("\n"); 
		query.append("ELSE 0 END CNTR_DRFF_CR_AMT" ).append("\n"); 
		query.append(",A.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append(",A.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append(",A.CNTR_STS_RMK" ).append("\n"); 
		query.append(",D.CNMV_STS_CD MVMT_STS_CD" ).append("\n"); 
		query.append(",A.CNTR_STS_SEQ" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR(A.YD_CD, 1, 5)) , 'YYYY-MM-DD') TIME_LOCAL" ).append("\n"); 
		query.append(",CASE WHEN A.CNTR_STS_CD = 'LSI' AND" ).append("\n"); 
		query.append("D.CNMV_STS_CD = 'MT' AND" ).append("\n"); 
		query.append("NVL((SELECT TO_NUMBER(SUBSTR(MAX(TO_CHAR(CRE_DT,'YYYYMMDDHH24MISS')||LTRIM(TO_CHAR(CNMV_CYC_NO,'0000'))), 15))" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO = P.CNTR_NO),88888888) != 9999 THEN 'O'" ).append("\n"); 
		query.append("ELSE 'X' END DEL_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("MDM_VENDOR C," ).append("\n"); 
		query.append("MST_CONTAINER D," ).append("\n"); 
		query.append("PARAM P" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.CNTR_NO     = P.CNTR_NO" ).append("\n"); 
		query.append("AND B.AGMT_CTY_CD(+) = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND B.AGMT_SEQ(+)    = A.AGMT_SEQ" ).append("\n"); 
		query.append("AND C.VNDR_SEQ(+)    = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND D.CNTR_NO     = A.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY A.CNTR_STS_EVNT_DT, A.CNTR_STS_SEQ" ).append("\n"); 

	}
}