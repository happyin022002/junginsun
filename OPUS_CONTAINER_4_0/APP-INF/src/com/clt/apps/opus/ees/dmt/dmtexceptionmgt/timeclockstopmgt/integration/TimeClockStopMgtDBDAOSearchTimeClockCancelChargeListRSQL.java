/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TimeClockStopMgtDBDAOSearchTimeClockCancelChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.03.29 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TimeClockStopMgtDBDAOSearchTimeClockCancelChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTimeClockCancelChargeList
	  * </pre>
	  */
	public TimeClockStopMgtDBDAOSearchTimeClockCancelChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clk_stop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : TimeClockStopMgtDBDAOSearchTimeClockCancelChargeListRSQL").append("\n"); 
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
		query.append("SELECT C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.CNTR_CYC_NO" ).append("\n"); 
		query.append(",C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",C.CHG_SEQ" ).append("\n"); 
		query.append(",B.BKG_NO" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append(",B.VSL_CD" ).append("\n"); 
		query.append(",B.SKD_VOY_NO" ).append("\n"); 
		query.append(",B.SKD_DIR_CD" ).append("\n"); 
		query.append(",C.CUST_CNT_CD" ).append("\n"); 
		query.append(",C.CUST_SEQ" ).append("\n"); 
		query.append(",C.ACT_CNT_CD" ).append("\n"); 
		query.append(",C.ACT_CUST_SEQ" ).append("\n"); 
		query.append(",SUBSTR (C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",3" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(") AS IO_BND_CD" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TO_CHAR (C.FM_MVMT_DT, 'YYYYMMDD') AS FM_MVMT_DT" ).append("\n"); 
		query.append(",C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR (C.TO_MVMT_DT, 'YYYYMMDD') AS TO_MVMT_DT" ).append("\n"); 
		query.append(",C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",C.OFC_CD" ).append("\n"); 
		query.append(",C.OFC_RHQ_CD" ).append("\n"); 
		query.append(",NVL(C.OFC_TRNS_FLG,    'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append(",NVL(C.DUL_TP_EXPT_FLG, 'N') AS DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append(",NVL(C.CXL_BKG_CHG_FLG, 'N') AS CXL_BKG_CHG_FLG" ).append("\n"); 
		query.append("FROM DMT_CHG_TM_CLK_STOP S" ).append("\n"); 
		query.append(",DMT_CHG_CALC C" ).append("\n"); 
		query.append(",DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append(",COM_SYS_AREA_GRP_ID CS" ).append("\n"); 
		query.append("WHERE C.SYS_AREA_GRP_ID = S.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND C.CNTR_NO = S.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO = S.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = S.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = S.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND C.CHG_SEQ = S.CHG_SEQ" ).append("\n"); 
		query.append("AND S.CLK_STOP_NO = @[clk_stop_no]" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND C.SYS_AREA_GRP_ID = CS.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND CS.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("AND CS.CNT_CD = (SELECT SUBSTR (LOC_CD" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = C.OFC_CD)" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD NOT IN ('I', 'T')" ).append("\n"); 

	}
}