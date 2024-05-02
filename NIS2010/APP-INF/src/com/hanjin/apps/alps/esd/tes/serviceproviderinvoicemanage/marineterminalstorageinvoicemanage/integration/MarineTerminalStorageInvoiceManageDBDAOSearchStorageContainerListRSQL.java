/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorageContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOSearchStorageContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchStorageContainerList
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOSearchStorageContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codc_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOSearchStorageContainerListRSQL").append("\n"); 
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
		query.append("BB_CGO_FLG          ," ).append("\n"); 
		query.append("WRK_DT              ," ).append("\n"); 
		query.append("CLM_DT              ," ).append("\n"); 
		query.append("RAIL_BIL_DT         ," ).append("\n"); 
		query.append("DSCR_RSN            ," ).append("\n"); 
		query.append("HNDL_RSLT_RMK       ," ).append("\n"); 
		query.append("CNTR_RMK            ," ).append("\n"); 
		query.append("CRE_USR_ID          ," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT  ," ).append("\n"); 
		query.append("UPD_USR_ID          ," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT  ," ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD   ," ).append("\n"); 
		query.append("TML_SO_SEQ          ," ).append("\n"); 
		query.append("TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("VRFY_RSLT_IND_CD    ," ).append("\n"); 
		query.append("MODI_FLG            ," ).append("\n"); 
		query.append("DSCR_IND_CD         ," ).append("\n"); 
		query.append("TML_RVIS_IND_FLG    ," ).append("\n"); 
		query.append("IO_BND_CD           ," ).append("\n"); 
		query.append("IOC_CD              ," ).append("\n"); 
		query.append("LANE_CD             ," ).append("\n"); 
		query.append("ATB_DT              ," ).append("\n"); 
		query.append("CNTR_NO             ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD        ," ).append("\n"); 
		query.append("CNTR_STY_CD         ," ).append("\n"); 
		query.append("LOCL_TS_IND_CD      ," ).append("\n"); 
		query.append("SAM_LOCL_TS_IND_CD  ," ).append("\n"); 
		query.append("RCVDE_TERM_IND_CD   ," ).append("\n"); 
		query.append("PRE_YD_CD           ," ).append("\n"); 
		query.append("TO_CHAR(MVMT_GATE_IN_DT,'YYYY-MM-DD HH24:MI') MVMT_GATE_IN_DT     ," ).append("\n"); 
		query.append("TO_CHAR(INV_GATE_IN_DT,'YYYY-MM-DD HH24:MI') INV_GATE_IN_DT      ," ).append("\n"); 
		query.append("GATE_IN_TD_DYS      ," ).append("\n"); 
		query.append("TO_CHAR(MVMT_GATE_OUT_DT,'YYYY-MM-DD HH24:MI') MVMT_GATE_OUT_DT    ," ).append("\n"); 
		query.append("TO_CHAR(INV_GATE_OUT_DT,'YYYY-MM-DD HH24:MI') INV_GATE_OUT_DT    ," ).append("\n"); 
		query.append("GATE_OUT_TD_DYS     ," ).append("\n"); 
		query.append("MVMT_STAY_DYS       ," ).append("\n"); 
		query.append("INV_STAY_DYS+1 INV_STAY_DYS     ,  -- 2012.07.30 장병용 부장 요청으로 +1 추가함..이유는 Verify시 Stay day 구할때 CMNC_HRMNT를 계산하지 않기 때문임..임시방편 인듯.." ).append("\n"); 
		query.append("STAY_DIFF_DYS       ," ).append("\n"); 
		query.append("AWK_CGO_FLG         ," ).append("\n"); 
		query.append("RC_FLG              ," ).append("\n"); 
		query.append("DCGO_CLSS_CD" ).append("\n"); 
		query.append("FROM TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("WHERE TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND   VRFY_RSLT_IND_CD = @[codc_type]" ).append("\n"); 
		query.append("#if (${codc_type} != '' and ${codc_type} == 'DC')" ).append("\n"); 
		query.append("ORDER BY DSCR_IND_CD ASC, CNTR_TPSZ_CD ASC, CNTR_STY_CD ASC, CNTR_NO ASC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY CNTR_NO ASC, CNTR_TPSZ_CD ASC, CNTR_STY_CD ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}