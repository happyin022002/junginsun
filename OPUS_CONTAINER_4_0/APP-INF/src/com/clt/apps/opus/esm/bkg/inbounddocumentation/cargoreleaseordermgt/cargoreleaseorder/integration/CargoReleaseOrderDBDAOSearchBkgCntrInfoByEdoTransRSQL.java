/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchBkgCntrInfoByEdoTransRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchBkgCntrInfoByEdoTransRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Container 정보를 조회한다
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchBkgCntrInfoByEdoTransRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchBkgCntrInfoByEdoTransRSQL").append("\n"); 
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
		query.append("SELECT 'CNTR_NO:'       || CNTR_NO || CHR(10)" ).append("\n"); 
		query.append("|| 'SIZE_TYPE:'   || SIZE_TYPE || CHR(10)" ).append("\n"); 
		query.append("|| 'DMIF_END_DT:' || NVL(DMIF_END_DT,NVL(VPS_ETA_DT,'')) || CHR(10)" ).append("\n"); 
		query.append("|| 'DTIC_END_DT:' || NVL(DTIC_END_DT,' ') || CHR(10)" ).append("\n"); 
		query.append("|| 'DT_FT_DAYS:'  || DT_FT_DAYS || CHR(10)" ).append("\n"); 
		query.append("FROM ( SELECT BCNTR.CNTR_NO                                                                          AS CNTR_NO" ).append("\n"); 
		query.append(", BCNTR.CNTR_TPSZ_CD                                                                     AS SIZE_TYPE" ).append("\n"); 
		query.append(", MAX(DECODE(NVL(INVM1.DMDT_AR_IF_CD, 'N'),'Y', TO_CHAR(CALC1.TO_MVMT_DT, 'YYYYMMDD')," ).append("\n"); 
		query.append("'N', TO_CHAR(CALC1.FT_END_DT), 'YYYYMMDD'))   AS DMIF_END_DT" ).append("\n"); 
		query.append(", MIN(TO_CHAR(CALC2.FT_END_DT, 'YYYYMMDD'))                                              AS DTIC_END_DT" ).append("\n"); 
		query.append(", TO_CHAR(NVL(SUM(CALC2.FX_FT_OVR_DYS), 0))                                              AS DT_FT_DAYS" ).append("\n"); 
		query.append(", MAX(TO_CHAR(VSKD.VPS_ETA_DT+6, 'YYYYMMDD'))                                            AS VPS_ETA_DT" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR BCNTR" ).append("\n"); 
		query.append(", DMT_CHG_CALC     CALC1" ).append("\n"); 
		query.append(", DMT_INV_MN       INVM1" ).append("\n"); 
		query.append(", DMT_CHG_CALC     CALC2" ).append("\n"); 
		query.append(", DMT_INV_MN       INVM2" ).append("\n"); 
		query.append(", BKG_VVD          VVD" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("WHERE BCNTR.BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("AND CALC1.SYS_AREA_GRP_ID(+) = BCNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND CALC1.CNTR_NO(+)         = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("AND CALC1.CNTR_CYC_NO(+)     = BCNTR.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND CALC1.DMDT_TRF_CD(+)     = 'DMIF'" ).append("\n"); 
		query.append("AND CALC1.DMDT_INV_NO        = INVM1.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND CALC2.SYS_AREA_GRP_ID(+) = BCNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND CALC2.CNTR_NO(+)         = BCNTR.CNTR_NO" ).append("\n"); 
		query.append("AND CALC2.CNTR_CYC_NO(+)     = BCNTR.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND CALC2.DMDT_INV_NO        = INVM2.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND NVL(INVM2.DMDT_AR_IF_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND CALC2.DMDT_TRF_CD(+)     = 'DTIC'" ).append("\n"); 
		query.append("AND VVD.BKG_NO               = BCNTR.BKG_NO" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD       IN ('T','U')" ).append("\n"); 
		query.append("AND VVD.VSL_CD               = VSKD.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO           = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD           = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD               = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POD_CLPT_IND_SEQ     = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("GROUP BY BCNTR.CNTR_NO,BCNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}