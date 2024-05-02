/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOMdmLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.04.15 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOMdmLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOMdmLocationRSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAOMdmLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOMdmLocationRSQL").append("\n"); 
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
		query.append("#if (${cond_type} == 'vvd_cd')" ).append("\n"); 
		query.append("SELECT   CNT_CD" ).append("\n"); 
		query.append(",RGN_CD" ).append("\n"); 
		query.append(",STE_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",'' AS LOC_RHQ_CD" ).append("\n"); 
		query.append(",TO_CHAR(VPS_ETA_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE   LOC_CD			=	@[pod_cd]" ).append("\n"); 
		query.append("AND		VSL_CD          =   SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND     SKD_VOY_NO      =   SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND     SKD_DIR_CD      =   SUBSTR(@[vvd_cd],9)" ).append("\n"); 
		query.append("AND     VPS_PORT_CD     =   @[pod_cd]" ).append("\n"); 
		query.append("AND     NVL(SKD_CNG_STS_CD, ' ')  <>   'S'" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT   LB.CNT_CD" ).append("\n"); 
		query.append(",LB.RGN_CD" ).append("\n"); 
		query.append(",LB.STE_CD" ).append("\n"); 
		query.append(",LB.LOC_CD" ).append("\n"); 
		query.append(",LB.LOC_RHQ_CD" ).append("\n"); 
		query.append(",TO_CHAR(V.VPS_ETA_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append(",(SELECT  L.CNT_CD" ).append("\n"); 
		query.append(",L.RGN_CD" ).append("\n"); 
		query.append(",L.STE_CD" ).append("\n"); 
		query.append(",L.LOC_CD" ).append("\n"); 
		query.append(",B.VSL_CD" ).append("\n"); 
		query.append(",B.SKD_VOY_NO" ).append("\n"); 
		query.append(",B.SKD_DIR_CD" ).append("\n"); 
		query.append(",B.POD_CD" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = (" ).append("\n"); 
		query.append("SELECT DMDT_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_YARD" ).append("\n"); 
		query.append("WHERE LOC_CD = B.POD_CD" ).append("\n"); 
		query.append("AND DMDT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS LOC_RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM 	MDM_LOCATION L" ).append("\n"); 
		query.append(",(SELECT BV.VSL_CD" ).append("\n"); 
		query.append(",BV.SKD_VOY_NO" ).append("\n"); 
		query.append(",BV.SKD_DIR_CD" ).append("\n"); 
		query.append(",BK.POD_CD" ).append("\n"); 
		query.append("FROM	BKG_BOOKING BK" ).append("\n"); 
		query.append(",BKG_VVD	BV" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#elseif (${bl_no} != '')" ).append("\n"); 
		query.append("BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND	BK.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE L.LOC_CD = B.POD_CD" ).append("\n"); 
		query.append(") LB" ).append("\n"); 
		query.append("WHERE   V.VSL_CD    = LB.VSL_CD" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO    = LB.SKD_VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD    = LB.SKD_DIR_CD" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD   = LB.LOC_CD" ).append("\n"); 
		query.append("AND NVL(V.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}