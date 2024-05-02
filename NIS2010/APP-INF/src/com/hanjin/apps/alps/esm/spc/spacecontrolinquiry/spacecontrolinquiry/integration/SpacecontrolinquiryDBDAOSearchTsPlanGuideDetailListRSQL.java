/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchTsPlanGuideDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchTsPlanGuideDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [T/S Plan & guide detail list]을 [조회]합니다.
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchTsPlanGuideDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_pln_cfm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchTsPlanGuideDetailListRSQL").append("\n"); 
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
		query.append("        PLN_SEQ" ).append("\n"); 
		query.append("      , REP_TRD_CD" ).append("\n"); 
		query.append("      , REP_SUB_TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , VVD_CD" ).append("\n"); 
		query.append("      , IRR_PORT_CD" ).append("\n"); 
		query.append("      , IRR_YD_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , IOC_CD" ).append("\n"); 
		query.append("      , DECODE(CNTR_FULL_FLG, 'Y', 1, 0) CNTR_FULL_FLG" ).append("\n"); 
		query.append("      , DECODE(CNTR_MTY_FLG, 'Y', 1, 0) CNTR_MTY_FLG" ).append("\n"); 
		query.append("      , MLT_CRR_LIST_CTNT" ).append("\n"); 
		query.append("      , MLT_POL_LIST_CTNT" ).append("\n"); 
		query.append("      , TO_CHAR(N1ST_PORT_ETD_DT, 'YYYY-MM-DD') AS N1ST_PORT_ETD_DT" ).append("\n"); 
		query.append("      , N1ST_RLANE_CD" ).append("\n"); 
		query.append("      , N1ST_VVD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N1ST_PORT_ETB_DT, 'YYYY-MM-DD') AS N1ST_PORT_ETB_DT" ).append("\n"); 
		query.append("      , N1ST_POD_CD" ).append("\n"); 
		query.append("      , N1ST_POD_YD_CD" ).append("\n"); 
		query.append("      , N2ND_POL_CD" ).append("\n"); 
		query.append("      , N2ND_POL_YD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N2ND_PORT_ETD_DT, 'YYYY-MM-DD') AS N2ND_PORT_ETD_DT" ).append("\n"); 
		query.append("      , N2ND_RLANE_CD" ).append("\n"); 
		query.append("      , N2ND_VVD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N2ND_PORT_ETB_DT, 'YYYY-MM-DD') AS N2ND_PORT_ETB_DT" ).append("\n"); 
		query.append("      , N2ND_POD_CD" ).append("\n"); 
		query.append("      , N2ND_POD_YD_CD" ).append("\n"); 
		query.append("      , N3RD_POL_CD" ).append("\n"); 
		query.append("      , N3RD_POL_YD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N3RD_PORT_ETD_DT, 'YYYY-MM-DD') AS N3RD_PORT_ETD_DT" ).append("\n"); 
		query.append("      , N3RD_RLANE_CD" ).append("\n"); 
		query.append("      , N3RD_VVD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N3RD_PORT_ETB_DT, 'YYYY-MM-DD') AS N3RD_PORT_ETB_DT" ).append("\n"); 
		query.append("      , N3RD_POD_CD" ).append("\n"); 
		query.append("      , N3RD_POD_YD_CD" ).append("\n"); 
		query.append("      , N4TH_POL_CD" ).append("\n"); 
		query.append("      , N4TH_POL_YD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N4TH_PORT_ETD_DT, 'YYYY-MM-DD') AS N4TH_PORT_ETD_DT" ).append("\n"); 
		query.append("      , N4TH_RLANE_CD" ).append("\n"); 
		query.append("      , N4TH_VVD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N4TH_PORT_ETB_DT, 'YYYY-MM-DD') AS N4TH_PORT_ETB_DT" ).append("\n"); 
		query.append("      , N4TH_POD_CD" ).append("\n"); 
		query.append("      , N4TH_POD_YD_CD" ).append("\n"); 
		query.append("      , N5TH_POL_CD" ).append("\n"); 
		query.append("      , N5TH_POL_YD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N5TH_PORT_ETD_DT, 'YYYY-MM-DD') AS N5TH_PORT_ETD_DT" ).append("\n"); 
		query.append("      , N5TH_RLANE_CD" ).append("\n"); 
		query.append("      , N5TH_VVD_CD" ).append("\n"); 
		query.append("      , TO_CHAR(N5TH_PORT_ETB_DT, 'YYYY-MM-DD') AS N5TH_PORT_ETB_DT" ).append("\n"); 
		query.append("      , MLT_POD_LIST_CTNT" ).append("\n"); 
		query.append("      , TS_PLN_CFM_STS_CD" ).append("\n"); 
		query.append("      , TS_RMK" ).append("\n"); 
		query.append("      , DECODE((SELECT COUNT(*) " ).append("\n"); 
		query.append("         FROM SPC_TS_PLN_GID_FILE_STO STO" ).append("\n"); 
		query.append("        WHERE STO.REP_TRD_CD        = DTL.REP_TRD_CD" ).append("\n"); 
		query.append("          AND STO.REP_SUB_TRD_CD    = DTL.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("          AND STO.RLANE_CD          = DTL.RLANE_CD" ).append("\n"); 
		query.append("          AND STO.VVD_CD            = DTL.VVD_CD" ).append("\n"); 
		query.append("          AND STO.IRR_PORT_CD       = DTL.IRR_PORT_CD" ).append("\n"); 
		query.append("          AND STO.IRR_YD_CD         = DTL.IRR_YD_CD" ).append("\n"); 
		query.append("          AND STO.PLN_SEQ           = DTL.PLN_SEQ" ).append("\n"); 
		query.append("       ),0,'N','Y') AS PLN_ATCH" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MM') AS UPD_DT " ).append("\n"); 
		query.append("FROM  SPC_TS_PLN_GID_DTL DTL" ).append("\n"); 
		query.append("WHERE REP_TRD_CD     = @[rep_trd_cd]" ).append("\n"); 
		query.append("AND   REP_SUB_TRD_CD = @[rep_sub_trd_cd]" ).append("\n"); 
		query.append("AND   RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("AND   VVD_CD         = @[vvd_cd]" ).append("\n"); 
		query.append("AND   IRR_PORT_CD    = @[irr_port_cd]" ).append("\n"); 
		query.append("AND   IRR_YD_CD      = @[irr_yd_cd]" ).append("\n"); 
		query.append("#if (${ts_pln_cfm_sts_cd} != 'All') " ).append("\n"); 
		query.append("AND   TS_PLN_CFM_STS_CD = @[ts_pln_cfm_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}