/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanadaCCTManageDBDAOSearchMdmLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.15
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.06.15 이준근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCCTManageDBDAOSearchMdmLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CanadaCCTManageDBDAOSearchMdmLocationRSQL
	  * </pre>
	  */
	public CanadaCCTManageDBDAOSearchMdmLocationRSQL(){
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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration").append("\n"); 
		query.append("FileName : CanadaCCTManageDBDAOSearchMdmLocationRSQL").append("\n"); 
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
		query.append("SELECT   LOC_CD" ).append("\n"); 
		query.append("		,SCC_CD" ).append("\n"); 
		query.append("		,LOC_NM" ).append("\n"); 
		query.append("		,RGN_CD" ).append("\n"); 
		query.append("		,CNT_CD" ).append("\n"); 
		query.append("		,STE_CD" ).append("\n"); 
		query.append("		,CONTI_CD" ).append("\n"); 
		query.append("		,PORT_INLND_CD" ).append("\n"); 
		query.append("		,LOC_CHR_CD" ).append("\n"); 
		query.append("		,BLK_PORT_FLG" ).append("\n"); 
		query.append("		,HUB_LOC_CD" ).append("\n"); 
		query.append("		,SLS_OFC_CD" ).append("\n"); 
		query.append("		,LOC_GRD_NO" ).append("\n"); 
		query.append("		,GMT_HRS" ).append("\n"); 
		query.append("		,BKG_BL_PFX_CD" ).append("\n"); 
		query.append("		,CALL_PORT_FLG" ).append("\n"); 
		query.append("		,LOC_AMS_PORT_CD" ).append("\n"); 
		query.append("		,FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("		,SEN_EQ_OFC_CD" ).append("\n"); 
		query.append("		,EQ_RTN_YD_CD" ).append("\n"); 
		query.append("		,UN_LOC_IND_CD" ).append("\n"); 
		query.append("		,UN_LOC_CD" ).append("\n"); 
		query.append("		,CML_ZN_FLG" ).append("\n"); 
		query.append("		,CSTMS_CD" ).append("\n"); 
		query.append("		,LOC_TP_CD" ).append("\n"); 
		query.append("		,BFR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,BFR_EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,BFR_SLS_OFC_CD" ).append("\n"); 
		query.append("		,BFR_OFC_CNG_DT" ).append("\n"); 
		query.append("		,REP_ZN_CD" ).append("\n"); 
		query.append("		,ZIP_CD" ).append("\n"); 
		query.append("		,SCONTI_CD" ).append("\n"); 
		query.append("		,EXPT_LGS_OFC_CD" ).append("\n"); 
		query.append("		,EXPT_CUST_SVC_OFC_CD" ).append("\n"); 
		query.append("		,VOP_PORT_RHQ_CD" ).append("\n"); 
		query.append("		,VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,VOP_PORT_MNTR_FLG" ).append("\n"); 
		query.append("		,VOP_LOC_URL" ).append("\n"); 
		query.append("		,VOP_PORT_FLG" ).append("\n"); 
		query.append("		,VOP_BNK_PORT_FLG" ).append("\n"); 
		query.append("		,LOC_LOCL_LANG_NM" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("		,DELT_FLG" ).append("\n"); 
		query.append("		,EAI_EVNT_DT" ).append("\n"); 
		query.append("		,VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("		,LOC_LAT" ).append("\n"); 
		query.append("		,LAT_UT_CD" ).append("\n"); 
		query.append("		,LOC_LON" ).append("\n"); 
		query.append("		,LON_UT_CD" ).append("\n"); 
		query.append("		,EAI_IF_ID" ).append("\n"); 
		query.append("FROM MDM_LOCATION P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("  AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}