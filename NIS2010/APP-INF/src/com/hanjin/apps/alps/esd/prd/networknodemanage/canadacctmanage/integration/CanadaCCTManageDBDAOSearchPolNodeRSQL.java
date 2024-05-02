/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CanadaCCTManageDBDAOSearchPolNodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCCTManageDBDAOSearchPolNodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CanadaCCTManageDBDAOSearchPolNodeRSQL
	  * </pre>
	  */
	public CanadaCCTManageDBDAOSearchPolNodeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration").append("\n"); 
		query.append("FileName : CanadaCCTManageDBDAOSearchPolNodeRSQL").append("\n"); 
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
		query.append("select   P.LOC_CD" ).append("\n"); 
		query.append("		,P.SCC_CD" ).append("\n"); 
		query.append("		,P.LOC_NM" ).append("\n"); 
		query.append("		,P.RGN_CD" ).append("\n"); 
		query.append("		,P.CNT_CD" ).append("\n"); 
		query.append("		,P.STE_CD" ).append("\n"); 
		query.append("		,P.CONTI_CD" ).append("\n"); 
		query.append("		,P.PORT_INLND_CD" ).append("\n"); 
		query.append("		,P.LOC_CHR_CD" ).append("\n"); 
		query.append("		,P.BLK_PORT_FLG" ).append("\n"); 
		query.append("		,P.HUB_LOC_CD" ).append("\n"); 
		query.append("		,P.SLS_OFC_CD" ).append("\n"); 
		query.append("		,P.LOC_GRD_NO" ).append("\n"); 
		query.append("		,P.GMT_HRS" ).append("\n"); 
		query.append("		,P.BKG_BL_PFX_CD" ).append("\n"); 
		query.append("		,P.CALL_PORT_FLG" ).append("\n"); 
		query.append("		,P.LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("		,P.FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,P.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,P.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("		,P.SEN_EQ_OFC_CD" ).append("\n"); 
		query.append("		,P.EQ_RTN_YD_CD" ).append("\n"); 
		query.append("		,P.UN_LOC_IND_CD" ).append("\n"); 
		query.append("		,P.UN_LOC_CD" ).append("\n"); 
		query.append("		,P.CML_ZN_FLG" ).append("\n"); 
		query.append("		,P.CSTMS_CD" ).append("\n"); 
		query.append("		,P.LOC_TP_CD" ).append("\n"); 
		query.append("		,P.BFR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,P.BFR_EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,P.BFR_SLS_OFC_CD" ).append("\n"); 
		query.append("		,P.BFR_OFC_CNG_DT" ).append("\n"); 
		query.append("		,P.REP_ZN_CD" ).append("\n"); 
		query.append("		,P.ZIP_CD" ).append("\n"); 
		query.append("		,P.SCONTI_CD" ).append("\n"); 
		query.append("		,P.EXPT_LGS_OFC_CD" ).append("\n"); 
		query.append("		,P.EXPT_CUST_SVC_OFC_CD" ).append("\n"); 
		query.append("		,P.VOP_PORT_RHQ_CD" ).append("\n"); 
		query.append("		,P.VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,P.VOP_PORT_MNTR_FLG" ).append("\n"); 
		query.append("		,P.VOP_LOC_URL" ).append("\n"); 
		query.append("		,P.VOP_PORT_FLG" ).append("\n"); 
		query.append("		,P.VOP_BNK_PORT_FLG" ).append("\n"); 
		query.append("		,P.LOC_LOCL_LANG_NM" ).append("\n"); 
		query.append("		,P.CRE_USR_ID" ).append("\n"); 
		query.append("		,P.CRE_DT" ).append("\n"); 
		query.append("		,P.UPD_USR_ID" ).append("\n"); 
		query.append("		,P.UPD_DT" ).append("\n"); 
		query.append("		,P.DELT_FLG" ).append("\n"); 
		query.append("		,P.EAI_EVNT_DT" ).append("\n"); 
		query.append("		,P.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("		,P.LOC_LAT" ).append("\n"); 
		query.append("		,P.LAT_UT_CD" ).append("\n"); 
		query.append("		,P.LOC_LON" ).append("\n"); 
		query.append("		,P.LON_UT_CD" ).append("\n"); 
		query.append("		,P.EAI_IF_ID" ).append("\n"); 
		query.append("from prd_node n, mdm_location p" ).append("\n"); 
		query.append("where n.nod_cd= @[loc_cd]" ).append("\n"); 
		query.append("and p.loc_cd = substr(n.nod_cd,1,5)" ).append("\n"); 
		query.append("AND P.CNT_CD IN ('CA', 'US')  -- POL 도 US 가능 20130930 --POR 은 US,CA/ POL 은 CA" ).append("\n"); 
		query.append("and nvl(n.delt_flg,'N') = 'N'" ).append("\n"); 
		query.append("and nvl(p.delt_flg,'N') = 'N'" ).append("\n"); 

	}
}