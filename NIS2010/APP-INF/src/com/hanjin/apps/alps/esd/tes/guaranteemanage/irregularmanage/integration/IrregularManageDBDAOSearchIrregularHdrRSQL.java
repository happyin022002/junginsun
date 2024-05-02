/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IrregularManageDBDAOSearchIrregularHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IrregularManageDBDAOSearchIrregularHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Irregular Header 정보 조회
	  * </pre>
	  */
	public IrregularManageDBDAOSearchIrregularHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.integration").append("\n"); 
		query.append("FileName : IrregularManageDBDAOSearchIrregularHdrRSQL").append("\n"); 
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
		query.append("		  IH.IRR_NO" ).append("\n"); 
		query.append("		, IH.GNTE_NO" ).append("\n"); 
		query.append("		, IH.OFC_CD" ).append("\n"); 
		query.append("		, IH.GNTE_TP_CD" ).append("\n"); 
		query.append("		, IH.CURR_CD" ).append("\n"); 
		query.append("		, IH.BKG_STS_CD" ).append("\n"); 
		query.append("		, IH.IRR_TP_CD" ).append("\n"); 
		query.append("		, IH.RESPB_PTY_NM" ).append("\n"); 
		query.append("		, IH.IRR_RSN_RMK" ).append("\n"); 
		query.append("		, IH.IRR_PRVT_RMK" ).append("\n"); 
		query.append("		, IH.IRR_TTL_AMT" ).append("\n"); 
		query.append("		, IH.IRR_STF_ERR_FLG" ).append("\n"); 
		query.append("		, IH.IRR_SYS_ERR_FLG" ).append("\n"); 
		query.append("		, IH.IRR_CHSS_SHTG_FLG" ).append("\n"); 
		query.append("		, IH.IRR_OTR_FLG" ).append("\n"); 
		query.append("		, IH.IRR_LATE_DIS_FLG" ).append("\n"); 
		query.append("		, IH.IRR_LACK_OF_FLW_FLG" ).append("\n"); 
		query.append("		, IH.IRR_CXL_WO_FLG" ).append("\n"); 
		query.append("		, IH.IRR_EQ_SHTG_FLG" ).append("\n"); 
		query.append("		, IH.OP_COST_OCP_FLG" ).append("\n"); 
		query.append("		, IH.OP_COST_TNK_ORD_FLG" ).append("\n"); 
		query.append("		, IH.OP_COST_TEAM_TRKG_FLG" ).append("\n"); 
		query.append("		, IH.OP_COST_XTRA_FT_FLG" ).append("\n"); 
		query.append("		, IH.OP_COST_SPTG_ICRZ_FLG" ).append("\n"); 
		query.append("		, IH.OP_COST_OTR_TML_CHSS_FLG" ).append("\n"); 
		query.append("		, IH.OP_COST_MNR_FLG" ).append("\n"); 
		query.append("		, IH.OP_COST_TRI_AXL_FLG" ).append("\n"); 
		query.append("		, IH.DELT_FLG" ).append("\n"); 
		query.append("		, IH.CRE_USR_ID" ).append("\n"); 
		query.append("		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELOPA', IH.CRE_DT, IH.OFC_CD), 'YYYY-MM-DD') CRE_DT -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)" ).append("\n"); 
		query.append("		, IH.UPD_USR_ID" ).append("\n"); 
		query.append("		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELOPA', IH.UPD_DT, IH.OFC_CD), 'YYYY-MM-DD') UPD_DT -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)" ).append("\n"); 
		query.append("		, GH.DEPT_NO" ).append("\n"); 
		query.append("		, GH.DMY_FLG" ).append("\n"); 
		query.append("FROM	TES_IRR_HDR IH" ).append("\n"); 
		query.append("		, TES_GNTE_HDR GH" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND     IH.GNTE_NO  = GH.GNTE_NO" ).append("\n"); 
		query.append("#if (${irr_no} != '') " ).append("\n"); 
		query.append("AND		IH.IRR_NO	= @[irr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gnte_no} != '') " ).append("\n"); 
		query.append("AND		IH.GNTE_NO	= @[gnte_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY IH.GNTE_NO" ).append("\n"); 

	}
}