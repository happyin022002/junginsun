/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsearchBbCargoCostInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.02 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsearchBbCargoCostInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBbCargoCostInfo
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsearchBbCargoCostInfoRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsearchBbCargoCostInfoRSQL").append("\n"); 
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
		query.append("BC.BB_CGO_TP_SEQ, BC.LGS_COST_CD, BC.BB_CGO_DESC, D.INV_AMT, D.BB_CGO_RMK," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN EXISTS (" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM TES_TML_SO_COST TC, MDM_YARD MY" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TC.MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("AND TC.CFS_FLG      IN (DECODE(MY.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("AND TC.RAIL_RMP_FLG IN (DECODE(MY.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("AND TC.XCLD_TML_FLG IN (DECODE(MY.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("#if(${yd_cd} != '' )" ).append("\n"); 
		query.append("AND	MY.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TC.LGS_COST_CD = BC.LGS_COST_CD )" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_YD_USE_YN," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(BC.DELT_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_DEL_YN" ).append("\n"); 
		query.append("FROM TES_BB_SO_COST BC, (" ).append("\n"); 
		query.append("SELECT BD.*" ).append("\n"); 
		query.append("FROM TES_TML_SO_DTL DD, TES_TML_SO_BB_DTL BD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DD.TML_SO_OFC_CTY_CD = BD.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND DD.TML_SO_SEQ = BD.TML_SO_SEQ" ).append("\n"); 
		query.append("AND DD.TML_SO_DTL_SEQ = BD.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("AND DD.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("#if(${tml_so_ofc_cty_cd} != '' )" ).append("\n"); 
		query.append("AND DD.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND DD.TML_SO_OFC_CTY_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tml_so_seq} != '' )" ).append("\n"); 
		query.append("AND DD.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND DD.TML_SO_SEQ = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bkg_no} != '' )" ).append("\n"); 
		query.append("AND DD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND DD.BKG_NO = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BC.BB_CGO_TP_SEQ = D.BB_CGO_TP_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY BC.BB_CGO_TP_SEQ" ).append("\n"); 

	}
}