/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAOSearchPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquire a port infomation.
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOSearchPortListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vop_port_mntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOSearchPortListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
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
		query.append(",T1.GMT_HRS/60 AS ZD" ).append("\n"); 
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
		query.append(",NVL(VSKD_PORT_RHQ_CD," ).append("\n"); 
		query.append("    (SELECT MAX(OFC_CD)" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE OFC_KND_CD='2'" ).append("\n"); 
		query.append("    AND DELT_FLG='N'" ).append("\n"); 
		query.append("    START WITH OFC_CD = T1.SLS_OFC_CD" ).append("\n"); 
		query.append("	CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD)) AS VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append(",T1.VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append(",NVL(T1.VOP_PORT_MNTR_FLG, 'N') AS VOP_PORT_MNTR_FLG" ).append("\n"); 
		query.append(",T1.VOP_LOC_URL" ).append("\n"); 
		query.append(",T1.VOP_PORT_FLG" ).append("\n"); 
		query.append(",T2.CNT_NM" ).append("\n"); 
		query.append(",T2.CURR_CD" ).append("\n"); 
		query.append(",T2.FRGN_VAT_FLG" ).append("\n"); 
		query.append(",T2.ZN_DIV_BSEL_CD" ).append("\n"); 
		query.append(",T2.BKG_ADDR_ORD_CD" ).append("\n"); 
		query.append(",T2.BKG_ADDR_ORD_DESC" ).append("\n"); 
		query.append("FROM MDM_LOCATION T1, MDM_COUNTRY T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.CNT_CD=T2.CNT_CD" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("AND T1.CNT_CD LIKE UPPER(@[cnt_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("AND T1.LOC_CD LIKE UPPER(@[loc_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_nm} != '') " ).append("\n"); 
		query.append("AND T1.LOC_NM LIKE '%' || UPPER(@[loc_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL') " ).append("\n"); 
		query.append("AND T1.VSKD_PORT_RHQ_CD = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vop_port_mntr_flg} != '')" ).append("\n"); 
		query.append("AND T1.VOP_PORT_MNTR_FLG=@[vop_port_mntr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.CALL_PORT_FLG='Y'" ).append("\n"); 
		query.append("AND T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY LOC_CD" ).append("\n"); 

	}
}