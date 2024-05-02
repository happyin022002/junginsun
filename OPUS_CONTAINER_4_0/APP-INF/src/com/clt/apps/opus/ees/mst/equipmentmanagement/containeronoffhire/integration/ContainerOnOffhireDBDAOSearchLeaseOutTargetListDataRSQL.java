/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchLeaseOutTargetListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchLeaseOutTargetListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLeaseOutTargetListData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchLeaseOutTargetListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchLeaseOutTargetListDataRSQL").append("\n"); 
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
		query.append("SELECT    " ).append("\n"); 
		query.append("   AA.CNTR_NO," ).append("\n"); 
		query.append("   AA.OFFH_STS_CD," ).append("\n"); 
		query.append("   AA.OFFH_DUE_DT," ).append("\n"); 
		query.append("   AA.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   AA.LSTM_CD," ).append("\n"); 
		query.append("   AA.AGMT_CTY_CD," ).append("\n"); 
		query.append("   AA.AGMT_NO," ).append("\n"); 
		query.append("   AA.REF_NO," ).append("\n"); 
		query.append("   AA.VNDR_SEQ," ).append("\n"); 
		query.append("   AA.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("   AA.CNTR_STS_CD," ).append("\n"); 
		query.append("   AA.CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("   AA.FULL_FLG," ).append("\n"); 
		query.append("   AA.CNMV_STS_CD," ).append("\n"); 
		query.append("   AA.CRNT_YD_CD," ).append("\n"); 
		query.append("   AA.CNMV_DT," ).append("\n"); 
		query.append("   AA.CNTR_DRFF_AMT," ).append("\n"); 
		query.append("   '' CNTR_DRFF_CR_AMT,   " ).append("\n"); 
		query.append("   AA.CNTR_LFT_CHG_AMT," ).append("\n"); 
		query.append("   AA.CNTR_LFT_CHG_CUR,     " ).append("\n"); 
		query.append("   '' RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("   '' CNTR_OLD_VAN_FLG," ).append("\n"); 
		query.append("   '' CNTR_PKUP_CHG_AMT," ).append("\n"); 
		query.append("   '' CNTR_PKUP_CR_CHG_AMT,   " ).append("\n"); 
		query.append("   '' CNTR_RMK " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   B.CNTR_NO," ).append("\n"); 
		query.append("   CASE WHEN A.OFFH_STS_CD = 'C' THEN 'Y'" ).append("\n"); 
		query.append("   ELSE '' END OFFH_STS_CD," ).append("\n"); 
		query.append("   CASE WHEN A.OFFH_STS_CD = 'C' THEN TO_CHAR(TO_DATE(A.OFFH_DUE_DT,'YYYY-MM-DD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   ELSE '' END OFFH_DUE_DT," ).append("\n"); 
		query.append("   B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   B.LSTM_CD," ).append("\n"); 
		query.append("   B.AGMT_CTY_CD," ).append("\n"); 
		query.append("   MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(B.AGMT_CTY_CD,B.AGMT_SEQ)  AS AGMT_NO," ).append("\n"); 
		query.append("   C.REF_NO," ).append("\n"); 
		query.append("   B.VNDR_SEQ," ).append("\n"); 
		query.append("   D.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("   B.CNTR_STS_CD," ).append("\n"); 
		query.append("  (SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */ TO_CHAR(H.CNTR_STS_EVNT_DT,'YYYY-MM-DD') " ).append("\n"); 
		query.append("   FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("   WHERE H.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("   AND   H.CNTR_STS_SEQ = B.LST_STS_SEQ  " ).append("\n"); 
		query.append("   AND   ROWNUM = 1" ).append("\n"); 
		query.append("   ) CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("   (SELECT N1ST_CHG_AMT" ).append("\n"); 
		query.append("     FROM LSE_AGMT_RT" ).append("\n"); 
		query.append("     WHERE AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("     AND   AGMT_SEQ     = B.AGMT_SEQ" ).append("\n"); 
		query.append("     AND   CNTR_RNTL_CHG_TP_CD ='DOCV'" ).append("\n"); 
		query.append("     AND   LOC_CD       = (SELECT  SCC_CD " ).append("\n"); 
		query.append("	                   FROM MDM_LOCATION " ).append("\n"); 
		query.append("	                   WHERE LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5))" ).append("\n"); 
		query.append("     AND   CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   ) CNTR_DRFF_AMT," ).append("\n"); 
		query.append("   (SELECT N2ND_CHG_AMT" ).append("\n"); 
		query.append("     FROM LSE_AGMT_RT" ).append("\n"); 
		query.append("     WHERE AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("     AND   AGMT_SEQ     = B.AGMT_SEQ" ).append("\n"); 
		query.append("     AND   CNTR_RNTL_CHG_TP_CD ='LIFV'" ).append("\n"); 
		query.append("     AND   LOC_CD       = (SELECT  SCC_CD " ).append("\n"); 
		query.append("	                   FROM MDM_LOCATION " ).append("\n"); 
		query.append("	                   WHERE LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5))" ).append("\n"); 
		query.append("     AND   CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   ) CNTR_LFT_CHG_AMT," ).append("\n"); 
		query.append("   (SELECT CURR_CD" ).append("\n"); 
		query.append("     FROM LSE_AGREEMENT" ).append("\n"); 
		query.append("     WHERE AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("     AND   AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("   ) CNTR_LFT_CHG_CUR,   " ).append("\n"); 
		query.append("   DECODE(B.FULL_FLG, 'Y', 'F', 'N', 'M') FULL_FLG," ).append("\n"); 
		query.append("   B.CNMV_STS_CD," ).append("\n"); 
		query.append("   B.CRNT_YD_CD," ).append("\n"); 
		query.append("   TO_CHAR(B.CNMV_DT, 'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("   LSE_AVAL_OFFH A, " ).append("\n"); 
		query.append("   MST_CONTAINER  B, " ).append("\n"); 
		query.append("   LSE_AGREEMENT C," ).append("\n"); 
		query.append("   MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND   A.OFFH_YD_CD   =  (SELECT SCC_CD FROM MDM_LOCATION L WHERE L.LOC_CD = SUBSTR(@[sts_evnt_yd_cd],1,5))" ).append("\n"); 
		query.append("AND   REPLACE(@[hire_date],'-','')   <=  A.OFFH_DUE_DT		" ).append("\n"); 
		query.append("AND   A.OFFH_DUE_DT  >=  TO_CHAR(SYSDATE,'YYYYMMDD')		" ).append("\n"); 
		query.append("AND   A.CNTR_NO      =   B.CNTR_NO		" ).append("\n"); 
		query.append("AND   A.OFFH_STS_CD  =   'C'" ).append("\n"); 
		query.append("AND   B.ACIAC_DIV_CD =   'A'" ).append("\n"); 
		query.append("AND   C.AGMT_CTY_CD  = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND   C.AGMT_SEQ     = A.AGMT_SEQ" ).append("\n"); 
		query.append("AND   D.VNDR_SEQ     = A.VNDR_SEQ" ).append("\n"); 
		query.append("AND   B.CNMV_STS_CD IN ('MT', 'ID', 'TN')" ).append("\n"); 
		query.append("AND   B.CRNT_YD_CD   = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append("AND   A.MTY_RTN_YD_CD = B.CRNT_YD_CD" ).append("\n"); 
		query.append("AND   TRUNC(B.CNMV_DT) <= TO_DATE(REPLACE(@[hire_date],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND   DECODE(A.CNTR_FULL_FLG,'Y','1',B.FULL_FLG)  = DECODE(A.CNTR_FULL_FLG,'Y','1','N')" ).append("\n"); 
		query.append(") AA" ).append("\n"); 

	}
}