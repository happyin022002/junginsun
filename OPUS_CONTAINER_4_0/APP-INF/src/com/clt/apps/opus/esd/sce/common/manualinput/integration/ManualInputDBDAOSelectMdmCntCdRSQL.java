/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputDBDAOSelectMdmCntCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.05.02 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOSelectMdmCntCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualInputDBDAOSelectMdmCntCd
	  * </pre>
	  */
	public ManualInputDBDAOSelectMdmCntCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration ").append("\n"); 
		query.append("FileName : ManualInputDBDAOSelectMdmCntCdRSQL").append("\n"); 
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
		query.append("SELECT CNT_CD, CNT_NM, SCONTI_CD, CURR_CD, FRGN_VAT_FLG, " ).append("\n"); 
		query.append("       ZN_DIV_BSEL_CD, BKG_ADDR_ORD_CD, BKG_ADDR_ORD_DESC, CNT_ISO_CD, " ).append("\n"); 
		query.append("       EAI_EVNT_DT, EAI_IF_ID, DELT_FLG," ).append("\n"); 
		query.append("       CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(" FROM MDM_COUNTRY" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("#if (${frm_cnt_cd} != '') " ).append("\n"); 
		query.append("  AND CNT_CD = @[frm_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}