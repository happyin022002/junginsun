/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOsearchCHSAtdtStsDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.02 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAttachDetachHistoryDBDAOsearchCHSAtdtStsDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOsearchCHSAtdtStsDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOsearchCHSAtdtStsDataRSQL").append("\n"); 
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
		query.append("SELECT CC.EQ_NO" ).append("\n"); 
		query.append(",CC.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",MAX(DECODE(NUM,1,CC.CNTR_NO)) CNTR_NO1" ).append("\n"); 
		query.append(",MAX(DECODE(NUM,2,CC.CNTR_NO)) CNTR_NO2" ).append("\n"); 
		query.append(",MAX(DECODE(NUM,1,CC.CNTR_NO)) ORG_CNTR_NO1" ).append("\n"); 
		query.append(",MAX(DECODE(NUM,2,CC.CNTR_NO)) ORG_CNTR_NO2" ).append("\n"); 
		query.append(",MAX(CC.ACIAC_DIV_CD) AS  ACIAC_DIV_CD" ).append("\n"); 
		query.append(",MAX(CC.CRNT_LOC_CD) AS CRNT_LOC_CD" ).append("\n"); 
		query.append(",DECODE (MAX( CC.ATCH_DT  ),NULL,MAX( CC.DTCH_DT  ),MAX( CC.ATCH_DT  )) ATCH_DT" ).append("\n"); 
		query.append(", ''                           STATUS" ).append("\n"); 
		query.append(", ''                           AT" ).append("\n"); 
		query.append(", MAX(CC.ONH_YD_CD)            YD_CD" ).append("\n"); 
		query.append(", MAX(DD.CNTR_TPSZ_CD)         CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' ATCH_DT2" ).append("\n"); 
		query.append(",'' EQ_KND_CD" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CHSS_NO" ).append("\n"); 
		query.append(",'' DTCH_DT" ).append("\n"); 
		query.append(",'' ATCH_YD_CD" ).append("\n"); 
		query.append(",'' DTCH_YD_CD" ).append("\n"); 
		query.append(",'' ATCH_INP_TP_CD" ).append("\n"); 
		query.append(",'' DTCH_INP_TP_CD" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT AA.*" ).append("\n"); 
		query.append(",ROWNUM NUM" ).append("\n"); 
		query.append(",BB.CNTR_NO" ).append("\n"); 
		query.append(",TO_CHAR(BB.ATCH_DT,'YYYYMMDD HH24MISS') ATCH_DT" ).append("\n"); 
		query.append(", ( SELECT /*+ INDEX_DESC(CC XPKCGM_EQ_ATCH_DTCH_HIS ) */" ).append("\n"); 
		query.append("DECODE ( DTCH_YD_CD , NULL, TO_CHAR(ATCH_DT,'YYYYMMDD HH24MISS'), TO_CHAR(DTCH_DT,'YYYYMMDD HH24MISS'))" ).append("\n"); 
		query.append("FROM CGM_EQ_ATCH_DTCH_HIS CC" ).append("\n"); 
		query.append("WHERE CC.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND ROWNUM =1) DTCH_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(B XPKCGM_CHSS_MVMT_HIS ) */" ).append("\n"); 
		query.append("A.EQ_NO" ).append("\n"); 
		query.append(", A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", A.ACIAC_DIV_CD" ).append("\n"); 
		query.append(", A.ONH_YD_CD" ).append("\n"); 
		query.append(", A.CRNT_LOC_CD" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append(", CGM_CHSS_MVMT_HIS B" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD='Z'" ).append("\n"); 
		query.append("AND A.EQ_NO = B.CHSS_NO" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(",CGM_EQ_ATCH_DTCH_HIS BB" ).append("\n"); 
		query.append("WHERE  AA.EQ_NO = BB.EQ_NO (+)" ).append("\n"); 
		query.append("AND BB.DTCH_DT (+)= TO_DATE('88881231','YYYYMMDD')" ).append("\n"); 
		query.append(") CC" ).append("\n"); 
		query.append(",MST_CONTAINER DD" ).append("\n"); 
		query.append("WHERE CC.CNTR_NO = DD.CNTR_NO(+)" ).append("\n"); 
		query.append("GROUP BY  CC.EQ_NO ,CC.EQ_TPSZ_CD" ).append("\n"); 

	}
}