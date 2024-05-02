/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.14 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOndockRailChargeContainerList
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vrfy_rslt_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerListRSQL").append("\n"); 
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
		query.append("SELECT    TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",TML_SO_SEQ" ).append("\n"); 
		query.append(",TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(",VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append(",MODI_FLG" ).append("\n"); 
		query.append(",DSCR_IND_CD" ).append("\n"); 
		query.append(",DECODE(TES_GET_COMCODENAME_FNC('CD00823',DSCR_IND_CD),NULL,'',TES_GET_COMCODENAME_FNC('CD00823',DSCR_IND_CD))  DSCR_IND_NM" ).append("\n"); 
		query.append(",RVIS_IND_FLG" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",FINC_VSL_CD" ).append("\n"); 
		query.append(",FINC_SKD_VOY_NO" ).append("\n"); 
		query.append(",FINC_SKD_DIR_CD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",IOC_CD" ).append("\n"); 
		query.append(",LANE_CD" ).append("\n"); 
		query.append(",TO_CHAR(ATB_DT,'YYYY-MM-DD')            ATB_DT" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CNTR_STY_CD" ).append("\n"); 
		query.append(",LOCL_TS_IND_CD" ).append("\n"); 
		query.append(",SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append(",SUBSTR(RCVDE_TERM_IND_CD,0,1)||'/'||SUBSTR(RCVDE_TERM_IND_CD,2,1)  RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append(",PRE_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(MVMT_GATE_IN_DT,'YYYY-MM-DD')   MVMT_GATE_IN_DT" ).append("\n"); 
		query.append(",TO_CHAR(INV_GATE_IN_DT,'YYYY-MM-DD')    INV_GATE_IN_DT" ).append("\n"); 
		query.append(",GATE_IN_TD_DYS" ).append("\n"); 
		query.append(",MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append(",INV_GATE_OUT_DT" ).append("\n"); 
		query.append(",GATE_OUT_TD_DYS" ).append("\n"); 
		query.append(",MVMT_STAY_DYS" ).append("\n"); 
		query.append(",INV_STAY_DYS" ).append("\n"); 
		query.append(",STAY_DIFF_DYS" ).append("\n"); 
		query.append(",DCGO_CLSS_CD" ).append("\n"); 
		query.append(",BB_CGO_FLG" ).append("\n"); 
		query.append(",TO_CHAR(WRK_DT,'YYYY-MM-DD')            WRK_DT" ).append("\n"); 
		query.append(",TO_CHAR(CLM_DT,'YYYY-MM-DD')            CLM_DT" ).append("\n"); 
		query.append(",TO_CHAR(RAIL_BIL_DT,'YYYY-MM-DD')       RAIL_BIL_DT" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append("--,BKG_NO_SPLIT" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append("--,BL_NO_TP" ).append("\n"); 
		query.append("--,BL_NO_CHK" ).append("\n"); 
		query.append(",DSCR_RSN" ).append("\n"); 
		query.append(",HNDL_RSLT_RMK" ).append("\n"); 
		query.append(",CNTR_RMK" ).append("\n"); 
		query.append(",VSL_CD||SKD_VOY_NO||SKD_DIR_CD 		VVD_NO" ).append("\n"); 
		query.append(",DSCR_DTL_IND_CD" ).append("\n"); 
		query.append(",AWK_CGO_FLG" ).append("\n"); 
		query.append(",RC_FLG" ).append("\n"); 
		query.append("FROM  TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("WHERE TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND	TML_SO_SEQ			= @[tml_so_seq]" ).append("\n"); 
		query.append("#if (${vrfy_rslt_ind_cd} != '')" ).append("\n"); 
		query.append("AND	VRFY_RSLT_IND_CD  = @[vrfy_rslt_ind_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vrfy_rslt_ind_cd} == 'CO')" ).append("\n"); 
		query.append("ORDER BY  VSL_CD||SKD_VOY_NO||SKD_DIR_CD, IO_BND_CD, CNTR_NO,CNTR_TPSZ_CD,CNTR_STY_CD, DCGO_CLSS_CD, WRK_DT," ).append("\n"); 
		query.append("LANE_CD, LOCL_TS_IND_CD, RCVDE_TERM_IND_CD, VRFY_RSLT_IND_CD,DSCR_IND_CD" ).append("\n"); 
		query.append("#elseif (${vrfy_rslt_ind_cd} == 'DC')" ).append("\n"); 
		query.append("ORDER BY  DSCR_IND_CD, LOCL_TS_IND_CD, CNTR_STY_CD, CNTR_TPSZ_CD, CNTR_NO, DCGO_CLSS_CD, LANE_CD, WRK_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}