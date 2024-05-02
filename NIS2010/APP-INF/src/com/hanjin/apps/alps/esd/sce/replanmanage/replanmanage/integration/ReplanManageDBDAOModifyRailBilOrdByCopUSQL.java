/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReplanManageDBDAOModifyRailBilOrdByCopUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.06
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.10.06 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOModifyRailBilOrdByCopUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_RAIL_BIL_ORD table 의 COP_NO, COST_ACT_GRP_SEQ, BKG_NO, bkg_no_rvis_flg,  act_grp_cd 등을 수정한다.
	  * </pre>
	  */
	public ReplanManageDBDAOModifyRailBilOrdByCopUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_be_cop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no_rvis_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOModifyRailBilOrdByCopUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("COP_NO = NVL(@[to_be_cop_no], A.COP_NO)," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ = NVL(@[cost_act_grp_seq], A.COST_ACT_GRP_SEQ)," ).append("\n"); 
		query.append("BKG_NO = NVL(@[bkg_no], (SELECT DISTINCT BKG_NO FROM SCE_COP_HDR WHERE COP_NO = @[to_be_cop_no] AND COP_STS_CD != 'X' AND ROWNUM = 1 ))," ).append("\n"); 
		query.append("BL_NO = NVL(@[bl_no], (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = (SELECT DISTINCT BKG_NO FROM SCE_COP_HDR WHERE COP_NO = @[to_be_cop_no] AND COP_STS_CD != 'X' AND ROWNUM = 1 )))," ).append("\n"); 
		query.append("BKG_NO_RVIS_FLG = NVL(@[bkg_no_rvis_flg], A.BKG_NO_RVIS_FLG)" ).append("\n"); 
		query.append("where " ).append("\n"); 
		query.append("cop_no = @[cop_no]" ).append("\n"); 
		query.append("and cost_act_grp_cd not like 'OD%'" ).append("\n"); 

	}
}