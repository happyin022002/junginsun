/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOBkgContainerInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.02.11 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOBkgContainerInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ChargeCalculationDBDAOBkgContainerInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOBkgContainerInfoVORSQL").append("\n"); 
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
		query.append("SELECT BB.BL_NO 				BL_NO" ).append("\n"); 
		query.append(",BB.POR_CD 				POR_CD" ).append("\n"); 
		query.append(",NVL (RL.CONTI_CD, ' ') 	POR_CONTI_CD" ).append("\n"); 
		query.append(",NVL (RL.CNT_CD, ' ') 	POR_CNT_CD" ).append("\n"); 
		query.append(",NVL (RL.RGN_CD, ' ') 	POR_RGN_CD" ).append("\n"); 
		query.append(",NVL (RL.STE_CD, ' ') 	POR_STE_CD" ).append("\n"); 
		query.append(",BB.POD_CD 				POD_CD" ).append("\n"); 
		query.append(",BB.POL_CD 				POL_CD" ).append("\n"); 
		query.append(",NVL (LL.CONTI_CD, ' ') 	POL_CONTI_CD" ).append("\n"); 
		query.append(",NVL (LL.CNT_CD, ' ') 	POL_CNT_CD" ).append("\n"); 
		query.append(",NVL (LL.RGN_CD, ' ') 	POL_RGN_CD" ).append("\n"); 
		query.append(",NVL (LL.STE_CD, ' ') 	POL_STE_CD" ).append("\n"); 
		query.append(",BB.DEL_CD 				DEL_CD" ).append("\n"); 
		query.append(",NVL (EL.CONTI_CD, ' ') 	DEL_CONTI_CD" ).append("\n"); 
		query.append(",NVL (EL.CNT_CD, ' ') 	DEL_CNT_CD" ).append("\n"); 
		query.append(",NVL (EL.RGN_CD, ' ') 	DEL_RGN_CD" ).append("\n"); 
		query.append(",NVL (EL.STE_CD, ' ') 	DEL_STE_CD" ).append("\n"); 
		query.append(",SUBSTR (CC.FM_MVMT_YD_CD,1,5) YRD_CD" ).append("\n"); 
		query.append(",NVL (ML.CONTI_CD, ' ') 	YRD_CONTI_CD" ).append("\n"); 
		query.append(",NVL (ML.CNT_CD, ' ') 	YRD_CNT_CD" ).append("\n"); 
		query.append(",NVL (ML.RGN_CD, ' ') 	YRD_RGN_CD" ).append("\n"); 
		query.append(",NVL (ML.STE_CD, ' ') 	YRD_STE_CD" ).append("\n"); 
		query.append(",BB.DMDT_CNTR_TP_CD		DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",BB.DMDT_BKG_CGO_TP_CD	DMDT_BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",BB.BKG_CNTR_QTY			BKG_CNTR_QTY" ).append("\n"); 
		query.append(",CC.FM_MVMT_STS_CD		FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(CC.FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append(",CC.FM_MVMT_YD_CD         FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",CC.TO_MVMT_STS_CD        TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(CC.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append(",CC.TO_MVMT_YD_CD         TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",'SZP'					DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'G'						DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",CC.OFC_CD      			OFC_CD" ).append("\n"); 
		query.append(",CC.OFC_RHQ_CD			OFC_RHQ_CD" ).append("\n"); 
		query.append(",CC.CUST_CNT_CD			CUST_CNT_CD" ).append("\n"); 
		query.append(",CC.CUST_SEQ				CUST_SEQ" ).append("\n"); 
		query.append(",CC.ACT_CNT_CD			ACT_CNT_CD" ).append("\n"); 
		query.append(",CC.ACT_CUST_SEQ			ACT_CUST_SEQ" ).append("\n"); 
		query.append(",CC.VNDR_SEQ				VNDR_SEQ" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR	BB" ).append("\n"); 
		query.append(",DMT_CHG_CALC		CC" ).append("\n"); 
		query.append(",MDM_LOCATION RL" ).append("\n"); 
		query.append(",MDM_LOCATION LL" ).append("\n"); 
		query.append(",MDM_LOCATION EL" ).append("\n"); 
		query.append(",MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE BB.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("AND BB.SYS_AREA_GRP_ID	= 'CHN'" ).append("\n"); 
		query.append("AND BB.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND BB.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND BB.POR_CD = RL.LOC_CD" ).append("\n"); 
		query.append("AND BB.POL_CD = LL.LOC_CD" ).append("\n"); 
		query.append("AND BB.DEL_CD = EL.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ML.LOC_CD = SUBSTR (CC.FM_MVMT_YD_CD, 1, 5)" ).append("\n"); 
		query.append("AND CC.SYS_AREA_GRP_ID	= 'CHN'" ).append("\n"); 
		query.append("AND CC.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND CC.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND CC.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND CC.CHG_SEQ = @[chg_seq]" ).append("\n"); 

	}
}