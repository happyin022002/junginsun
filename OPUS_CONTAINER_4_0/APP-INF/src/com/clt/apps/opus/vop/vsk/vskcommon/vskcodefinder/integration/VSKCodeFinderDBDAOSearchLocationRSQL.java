/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquire a location code list
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchLocationRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("T1.LOC_CD" ).append("\n"); 
		query.append(",T1.SCC_CD" ).append("\n"); 
		query.append(",T1.LOC_NM" ).append("\n"); 
		query.append(",T1.RGN_CD" ).append("\n"); 
		query.append(",T1.CNT_CD" ).append("\n"); 
		query.append(",T1.STE_CD" ).append("\n"); 
		query.append(",T1.CONTI_CD" ).append("\n"); 
		query.append(",T1.PORT_INLND_FLG" ).append("\n"); 
		query.append(",T1.LOC_CHR_CD" ).append("\n"); 
		query.append(",T1.BLK_PORT_FLG" ).append("\n"); 
		query.append(",T1.HUB_LOC_CD" ).append("\n"); 
		query.append(",T1.SLS_OFC_CD" ).append("\n"); 
		query.append(",T1.LOC_GRD_NO" ).append("\n"); 
		query.append(",T1.GMT_HRS" ).append("\n"); 
		query.append(",T1.BKG_BL_PFX_CD" ).append("\n"); 
		query.append(",T1.CALL_PORT_FLG" ).append("\n"); 
		query.append(",T1.LOC_AMS_PORT_CD" ).append("\n"); 
		query.append(",T1.FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append(",T1.EQ_RTN_YD_CD" ).append("\n"); 
		query.append(",T1.UN_LOC_IND_CD" ).append("\n"); 
		query.append(",T1.UN_LOC_CD" ).append("\n"); 
		query.append(",T1.CML_ZN_FLG" ).append("\n"); 
		query.append(",T1.CSTMS_CD" ).append("\n"); 
		query.append(",T1.LOC_TP_CD" ).append("\n"); 
		query.append(",T1.BFR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.BFR_EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.BFR_SLS_OFC_CD" ).append("\n"); 
		query.append(",T1.BFR_OFC_CNG_DT" ).append("\n"); 
		query.append(",T1.REP_ZN_CD" ).append("\n"); 
		query.append(",T1.ZIP_CD" ).append("\n"); 
		query.append(",T1.SCONTI_CD" ).append("\n"); 
		query.append(",T1.EXPT_LGS_OFC_CD" ).append("\n"); 
		query.append(",T1.EXPT_CUST_SVC_OFC_CD" ).append("\n"); 
		query.append(",T1.VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append(",T1.VOP_PORT_MNTR_FLG" ).append("\n"); 
		query.append(",T1.VOP_LOC_URL" ).append("\n"); 
		query.append("FROM MDM_LOCATION T1" ).append("\n"); 
		query.append("WHERE T1.LOC_CD LIKE upper(@[loc_cd]) || '%'" ).append("\n"); 
		query.append("#if (${call_port_flg} != '') " ).append("\n"); 
		query.append("AND T1.CALL_PORT_FLG='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.DELT_FLG = 'N'" ).append("\n"); 

	}
}