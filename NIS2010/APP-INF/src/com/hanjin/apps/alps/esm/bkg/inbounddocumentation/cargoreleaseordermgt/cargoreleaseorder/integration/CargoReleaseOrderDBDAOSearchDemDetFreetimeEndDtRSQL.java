/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchDemDetFreetimeEndDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchDemDetFreetimeEndDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemDet의 Free Time End Date 값을 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDemDetFreetimeEndDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchDemDetFreetimeEndDtRSQL").append("\n"); 
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
		query.append("SELECT   BCNTR.BKG_NO                                       AS BKG_NO" ).append("\n"); 
		query.append("        ,BCNTR.CNTR_NO                                      AS CNTR_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(DMT_CALC.DMIF_END_DT,'YYYY/MM/DD')         AS FT_END_DT" ).append("\n"); 
		query.append("FROM    BKG_CONTAINER    BCNTR," ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("            SELECT   C.CNTR_NO" ).append("\n"); 
		query.append("                    ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                    ,MAX(DECODE(NVL(INVM1.DMDT_AR_IF_CD, 'N'),'Y', TO_MVMT_DT,'N', FT_END_DT))   AS DMIF_END_DT" ).append("\n"); 
		query.append("            FROM    DMT_CHG_CALC    C," ).append("\n"); 
		query.append("                    DMT_INV_MN  INVM1" ).append("\n"); 
		query.append("            WHERE   (SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO) IN" ).append("\n"); 
		query.append("                    ( SELECT SYS_AREA_GRP_ID,CNTR_NO,CNTR_CYC_NO FROM DMT_CHG_BKG_CNTR WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("            AND     C.DMDT_INV_NO        = INVM1.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("            AND     C.SYS_AREA_GRP_ID = 'KOR'" ).append("\n"); 
		query.append("            AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L', 'N', 'U')  " ).append("\n"); 
		query.append("            AND (   ( C.DMDT_TRF_CD = 'DMIF'  AND C.DMDT_CHG_LOC_DIV_CD = 'POD')" ).append("\n"); 
		query.append("                 OR ( C.DMDT_TRF_CD = 'CTIC'  AND C.DMDT_CHG_LOC_DIV_CD = 'DEL')" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("            AND C.DMDT_CHG_LOC_DIV_CD	<> 'SZP'  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            GROUP BY C.CNTR_NO, C.CNTR_CYC_NO" ).append("\n"); 
		query.append("        )   DMT_CALC" ).append("\n"); 
		query.append("WHERE   BCNTR.BKG_NO          = @[bkg_no] " ).append("\n"); 
		query.append("AND     BCNTR.CNTR_NO         = DMT_CALC.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     BCNTR.CNMV_CYC_NO     = DMT_CALC.CNTR_CYC_NO(+)" ).append("\n"); 

	}
}