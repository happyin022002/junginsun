/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchIdaDoRlseListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.27
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.11.27 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchIdaDoRlseListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 조회한다.
	  * * History
	  * 2012.05.08 김보배 [CHM-201217621] [BKG] India Cargo Release Performance 기능 보완
	  * 2012.07.23 김보배 [CHM-201219143] [BKG] India Cargo Release Performance 기능 보완 요청
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchIdaDoRlseListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("evnt_dt_ym",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchIdaDoRlseListRSQL").append("\n"); 
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
		query.append("SELECT BKDO.IDA_DO_DMDT_PAY_TP_CD AS DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("     , CDTL.INTG_CD_VAL_DP_DESC AS DMDT_PAY_TP_CD_DESC" ).append("\n"); 
		query.append("     , BKGM.BL_NO" ).append("\n"); 
		query.append("     , BKDO.HBL_NO" ).append("\n"); 
		query.append("     , BKDO.RCVR_CNEE_NM" ).append("\n"); 
		query.append("     , BKDO.RCVR_CO_NM" ).append("\n"); 
		query.append("     , DCNT.CNTR_NO" ).append("\n"); 
		query.append("     , BKGM.POD_CD" ).append("\n"); 
		query.append("     , BKGM.DEL_CD" ).append("\n"); 
		query.append("     , BKDO.DO_NO || DECODE(BKDO.DO_NO_SPLIT, '00', '' , BKDO.DO_NO_SPLIT) AS DO_NO" ).append("\n"); 
		query.append("     , TO_CHAR(DOTL.EVNT_DT, 'YYYY-MM-DD  HH24:MI') EVNT_DT" ).append("\n"); 
		query.append("     , TO_CHAR(BKDO.IDA_DO_VTY_DT,'YYYY-MM-DD') AS DO_VTY_DT" ).append("\n"); 
		query.append("     , DOTL.EVNT_OFC_CD" ).append("\n"); 
		query.append("     , DOTL.EVNT_USR_ID " ).append("\n"); 
		query.append("FROM BKG_DO_DTL DOTL" ).append("\n"); 
		query.append("   , BKG_DO BKDO" ).append("\n"); 
		query.append("   , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("   , BKG_DO_CNTR DCNT" ).append("\n"); 
		query.append("   , (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           , INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE INTG_CD_ID = 'CD02209' ) CDTL -- D/O DEM/DET PAYMENT TYPE CODE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${evnt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND DOTL.EVNT_OFC_CD = @[evnt_ofc_cd] --- RELEASE OFFICE " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rd_flag} == 'F')" ).append("\n"); 
		query.append("AND TRIM(DOTL.EVNT_DT) >= TO_DATE(@[evnt_dt_fm], 'YYYYMMDD')  -- RELEASE DATE" ).append("\n"); 
		query.append("AND TRIM(DOTL.EVNT_DT) < TO_DATE(@[evnt_dt_to], 'YYYYMMDD') + 1 -- RELEASE DATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rd_flag} == 'S')" ).append("\n"); 
		query.append("AND TRIM(DOTL.EVNT_DT) >= TO_DATE(@[evnt_dt_ym], 'YYYYMM')      -- RELEASE DATE YM" ).append("\n"); 
		query.append("AND TRIM(DOTL.EVNT_DT) < ADD_MONTHS(TO_DATE(@[evnt_dt_ym], 'YYYYMM'), 1) -- RELEASE DATE YM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BKDO.BKG_NO = DOTL.BKG_NO" ).append("\n"); 
		query.append("AND BKDO.RLSE_SEQ = DOTL.RLSE_SEQ" ).append("\n"); 
		query.append("AND BKDO.IDA_DO_DMDT_PAY_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${dmdt_pay_tp_cd} != '')" ).append("\n"); 
		query.append("AND BKDO.IDA_DO_DMDT_PAY_TP_CD = @[dmdt_pay_tp_cd]  -- DMDT PAYMENT TYPE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BKGM.BKG_NO = DOTL.BKG_NO" ).append("\n"); 
		query.append("AND SUBSTR(BKGM.POD_CD, 1,2) = 'IN'" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND BKGM.BL_NO = @[bl_no]  -- BL NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DCNT.BKG_NO = DOTL.BKG_NO" ).append("\n"); 
		query.append("AND DCNT.RLSE_SEQ = DOTL.RLSE_SEQ" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND DCNT.CNTR_NO = @[cntr_no] -- CNTR NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CDTL.INTG_CD_VAL_CTNT = BKDO.IDA_DO_DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("ORDER BY DOTL.EVNT_DT" ).append("\n"); 

	}
}